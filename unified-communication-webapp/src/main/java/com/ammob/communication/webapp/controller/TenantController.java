package com.ammob.communication.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.dao.SearchException;
import com.ammob.communication.vidyo.exception.CdrQueryException;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.service.TenantManager;

/**
 * Simple class to retrieve a list of tenants from the database.
 */
@Controller
@RequestMapping("/tenant*")
public class TenantController {
	private TenantManager tenantManager;
	
	@Autowired
	public void setTenantManager(TenantManager tenantManager) {
		this.tenantManager = tenantManager;
	}
	
	/**
	 * The Tenants List
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query) throws Exception {
		Model model = new ExtendedModelMap();
		try {
			List<Tenant> found = tenantManager.search(query);
			model.addAttribute(Constants.TENANT_LIST, found);
		} catch (SearchException se) {
			model.addAttribute("searchError", se.getMessage());
			List<Tenant> found = tenantManager.getAll();
			model.addAttribute(found);
		}
		return new ModelAndView("tenant/list", model.asMap());
	}
	
	@RequestMapping(value = "/manage*", method = RequestMethod.GET)
	public ModelAndView handleRpc(@RequestParam(required = false, value = "q") String query) throws Exception {
		Model model = new ExtendedModelMap();
		try {
			List<Tenant> found = tenantManager.search(query);
			model.addAttribute(Constants.TENANT_LIST, found);
		} catch (SearchException se) {
			model.addAttribute("searchError", se.getMessage());
			List<Tenant> found = tenantManager.getAll();
			model.addAttribute(found);
		}
		return new ModelAndView("tenant/manage", model.asMap());
	}
	
	@RequestMapping(value = "/cdr*", method = RequestMethod.GET)
	public ModelAndView handleCdr(@RequestParam(required = false, value = "startime") String stime, 
			@RequestParam(required = false, value = "endtime") String endtime,
			@RequestParam(required = false, value = "id") String tenantId) throws Exception {
		Model model = new ExtendedModelMap();
		try {
			Tenant tenant = tenantManager.get(Long.valueOf(tenantId));
			List<Map<String, Object>> found = tenantManager.getCallDetailRecordList(tenant);
			model.addAttribute(Constants.CDR_LIST, found);
			return new ModelAndView("tenant/cdr", model.asMap());
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
		}
		return new ModelAndView("tenant/cdr", model.asMap());
	}
	
	/**
	 * 
	 * @param request
	 * @param stime
	 * @param endtime
	 * @param tenantId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/upload*", method = RequestMethod.GET)
	public ModelAndView handleCdrUpload(HttpServletRequest request, 
			@RequestParam(required = false, value = "startime") String stime, 
			@RequestParam(required = false, value = "endtime") String endtime,
			@RequestParam(required = true, value = "id") String tenantId) throws Exception {
		String message = "同步完成";
		Tenant tenant = tenantManager.get(Long.valueOf(tenantId));
		try {
			tenantManager.handleCallDetailRecordUpload(tenant);
		} catch (CdrQueryException e) {
			if(e.getType() == 1){
				message = "本账期已经同步完成，请下个账期内再操作";
			} else {
				message = e.getMessage();
				e.printStackTrace();
			}
		}
		addMessage(request, message);
		return new ModelAndView("tenant/cdr");
	}
	
	/**
	 * 
	 * @param request
	 * @param message
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void addMessage(HttpServletRequest request, String message){
		List<String> messages = (List) request.getSession().getAttribute(BaseFormController.MESSAGES_KEY);
	    if (messages == null) {
	        messages = new ArrayList();
	    }
	    messages.add(message);
	    request.getSession().setAttribute(BaseFormController.MESSAGES_KEY, messages);
	}
}
