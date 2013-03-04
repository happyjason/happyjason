package com.ammob.communication.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.service.TenantManager;

/**
 * Simple class to retrieve a list of users from the database.
 */
@Controller
@RequestMapping("/tenant*")
public class TenantController {
	private TenantManager tenantManager;
	
	@Autowired
	public void setTenantManager(TenantManager tenantManager) {
		this.tenantManager = tenantManager;
	}
	
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
		if(tenantManager.checkCdrState(tenantId)){
			String searchTerm = "where JoinTime > '" + stime + "' AND JoinTime < '" + endtime + "'";
			try {
				List<Map<String, Object>> found = tenantManager.getCallDetailRecordList(tenantId);
				model.addAttribute(Constants.CDR_LIST, found);
				return new ModelAndView("tenant/cdr", model.asMap());
			} catch(Exception e) {
				model.addAttribute("error", e.getMessage());
				System.out.println(e.getMessage());
			}
		} else {
			model.addAttribute("error", "tenant Id is error : id = " + tenantId);
		}
		return new ModelAndView("tenant/cdr", model.asMap());
	}
}
