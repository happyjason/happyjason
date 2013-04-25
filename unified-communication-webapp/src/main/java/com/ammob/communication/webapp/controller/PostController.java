package com.ammob.communication.webapp.controller;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.dao.SearchException;
import com.ammob.communication.core.service.MailEngine;
import com.ammob.communication.core.service.UserManager;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.hr.model.Post;
import com.ammob.communication.hr.service.PostManager;
import com.ammob.communication.vidyo.util.FtpUtil;
import com.ammob.communication.webapp.form.PostForm;

/**
 * Simple class to retrieve a list of posts from the database.
 */
@Controller
@RequestMapping("/post*")
public class PostController {
	private MailEngine mailEngine;
	private PostManager postManager;
	private UserManager userManager;
	private MessageSource messageSource = null;
	
    @Autowired
    public void setMailEngine(MailEngine mailEngine) {
        this.mailEngine = mailEngine;
    }
    
	@Autowired
	public void setPostManager(PostManager postManager) {
		this.postManager = postManager;
	}
	
    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
	/**
	 * The Posts List
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query) throws Exception {
		Model model = new ExtendedModelMap();
		try {
			List<Post> found = postManager.search(query);
			model.addAttribute(Constants.POST_LIST, found);
		} catch (SearchException se) {
			model.addAttribute("searchError", se.getMessage());
			List<Post> found = postManager.getAll();
			model.addAttribute(found);
		}
		return new ModelAndView("post/list", model.asMap());
	}
	
	/**
	 * 
	 * @param postId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/profile*", method = RequestMethod.GET)
	public ModelAndView handleProfileGet(@RequestParam(required = false, value = "id") String postId,
			@RequestParam(required = false, value = "method") String method, HttpServletRequest request) 
			throws Exception {
		Model model = new ExtendedModelMap();
		if(StringUtil.hasText(method)) {
			MessageSourceAccessor text = new MessageSourceAccessor(messageSource, request.getLocale());
			if(method.equals("Add")) {
				model.addAttribute("post", new PostForm());
				BaseFormController.saveMessage(request, text.getMessage("success.operate"));
			} else if(method.equals("Del") && StringUtil.hasText(postId)) {
				try {
					Long _id = Long.parseLong(postId);
					System.out.println(_id);
					postManager.remove(_id);
					BaseFormController.saveMessage(request, text.getMessage("success.operate"));
				} catch (Exception e) {
					BaseFormController.saveError(request, text.getMessage("errors.token") + " code : " + e.getMessage());
				}
				return new ModelAndView("redirect:/post");
			} else {
				BaseFormController.saveError(request, text.getMessage("errors.token"));
			}
		} else {
			if(StringUtil.hasText(postId)){
				try {
					PostForm _post = PostForm.fromProviderPost(postManager.get(Long.valueOf(postId)));
					model.addAttribute("post", _post);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				return new ModelAndView("redirect:/post");
			}
		}
		return new ModelAndView("post/profile", model.asMap());
	}
	
	/**
	 * 
	 * @param postId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/profile*", method = RequestMethod.POST)
	public ModelAndView handleProfilePost(PostForm post, HttpServletRequest request) 
			throws Exception {
        if (request.getParameter("cancel") != null) {
            return new ModelAndView("redirect:/post");
        }
        MessageSourceAccessor text = new MessageSourceAccessor(messageSource, request.getLocale());
        try {
        	Post _p = PostForm.fromConsumerPostForm(post);
			postManager.save(_p);
			BaseFormController.saveMessage(request, text.getMessage("success.operate"));
		} catch (Exception e) {
			BaseFormController.saveError(request, text.getMessage("errors.token") + " code : " + e.getMessage());
		}
		Model model = new ExtendedModelMap();
		model.addAttribute("post", post);
		return new ModelAndView("post/profile", model.asMap());
	}
	
	/**
	 * 
	 * @param postId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/notification*", method = RequestMethod.GET)
	public ModelAndView handleNotificationGet(@RequestParam(required = true, value = "id") String postId) 
			throws Exception {
		Model model = new ExtendedModelMap();
		if(!StringUtil.hasText(postId)){
			return new ModelAndView("redirect:/post", model.asMap());
		}
		PostForm post = null;
		try {
			post = PostForm.fromProviderPost(postManager.get(Long.valueOf(postId)));
		} catch (Exception e) {
			return new ModelAndView("redirect:/post", model.asMap());
		}
		model.addAttribute("post", post);
		return new ModelAndView("post/notification", model.asMap());
	}
	
	/**
	 * 
	 * @param post
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/notification*", method = RequestMethod.POST)
	public ModelAndView handleNotificationPost(PostForm post, HttpServletRequest request) 
			throws Exception {
        if (request.getParameter("cancel") != null) {
            return new ModelAndView("redirect:/post");
        }
		Model model = new ExtendedModelMap();
		model.addAttribute("post", post);
		MessageSourceAccessor text = new MessageSourceAccessor(messageSource, request.getLocale());
		if(StringUtil.hasText(post.getRecipients()) && StringUtil.hasText(post.getRecipientsEmail())) {
			Map<String, Serializable> mapper = new HashMap<String, Serializable>();
			String uuid = UUID.randomUUID().toString(); 
			mapper.put("post", post);
			mapper.put("uuid", uuid);
			try {
				mapper.put("user", userManager.getUserByUsername(request.getRemoteUser()));
				String result = mailEngine.sendMessage(new String[]{"yufeng@seekoom.com","vanton@seekoom.com","mob@seekoom.com", post.getRecipientsEmail()}, 
						"面试邀请", "velocity/Interview.vm", mapper);
				BaseFormController.saveMessage(request, text.getMessage("success.operate"));
				FtpUtil.uploadFile("www.vccloud.com.cn", 21, "mob", "121212",
						"/offer", uuid + ".html", new ByteArrayInputStream(result.getBytes()));
				return new ModelAndView("redirect:/post", model.asMap());
			} catch (Exception e) {
				BaseFormController.saveError(request, e.getMessage());
			}
		}
		BaseFormController.saveError(request, text.getMessage("errors.token"));
		return new ModelAndView("redirect:/post", model.asMap());
	}
}
