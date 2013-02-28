package com.ammob.communication.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.dao.SearchException;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.model.ConferenceCall;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.service.ConferenceCallManager;
import com.ammob.communication.vidyo.service.TenantManager;

/**
 * Simple class to retrieve a list of users from the database.
 */
@Controller
@RequestMapping("/tenant*")
public class TenantController {
	private TenantManager tenantManager;
	private ConferenceCallManager conferenceCallManager;
	
	@Autowired
	public void setTenantManager(TenantManager tenantManager) {
		this.tenantManager = tenantManager;
	}
	
	@Autowired
	public void setConferenceCallManager(ConferenceCallManager conferenceCallManager) {
		this.conferenceCallManager = conferenceCallManager;
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
			@PathVariable("id") String id) throws Exception {
		Model model = new ExtendedModelMap();
		try {
			Long _id = Long.valueOf(id);
			Tenant tenant = tenantManager.get(_id);
			String sql = "from ConferenceCall c";
			if(StringUtil.hasText(stime)) {
				sql = sql.concat("where JoinTime > '" + stime + "' AND JoinTime < '" + endtime + "'");
			}
			List<ConferenceCall> found = conferenceCallManager.getConferenceCalls(Constants.DEFAULT_DATASOUCE, sql);
			model.addAttribute(Constants.CDR_LIST, found);
			return new ModelAndView("tenant/cdr", model.asMap());
		} catch(Exception e) {
			model.addAttribute("error", e.getMessage());
			return new ModelAndView("tenant/manage", model.asMap());
		}
	}
}
