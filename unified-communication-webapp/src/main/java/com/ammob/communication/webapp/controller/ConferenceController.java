package com.ammob.communication.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ammob.communication.core.service.UserManager;

/**
 * Implementation of <strong>SimpleFormController</strong> that interacts with
 * the {@link UserManager} to retrieve/persist values to the database.
 */
@Controller
@RequestMapping("/conference*")
public class ConferenceController extends BaseController {
	
	/**
	 * The conference page.
	 * @param Request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showConference(HttpServletRequest request) throws Exception {
		Model model = new ExtendedModelMap();
		saveMessage(request, "testtest");
//		try {
//			//AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
//			CasAuthenticationToken token = (CasAuthenticationToken) request.getUserPrincipal();
//			String loginName = token.getName();//获取用户名
//			String prin = token.getPrincipal().toString();//获取用户名
//			System.out.print(loginName);
//			System.out.print(prin);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return new ModelAndView("conference/home", model.asMap());
	}
}
