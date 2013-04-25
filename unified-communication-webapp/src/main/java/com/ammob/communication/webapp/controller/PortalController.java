package com.ammob.communication.webapp.controller;

import java.util.List;
import java.util.Set;

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
import com.ammob.communication.vidyo.model.Portal;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.service.PortalService;
import com.ammob.communication.vidyo.service.VidyoManager;



@Controller
@RequestMapping("/portal*")
public class PortalController {

	
	VidyoManager vidyoManager;
	PortalService portalService;
	

	@Autowired
	public void setVidyoManager(VidyoManager vidyoManager) {
		this.vidyoManager = vidyoManager;
	}
	
	@Autowired
	public void setPortalService(PortalService portalService) {
		this.portalService = portalService;
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
			List<Portal> found = portalService.findAllPortal();
			model.addAttribute(Constants.PORTAL_LIST, found);
		} catch (SearchException se) {
			model.addAttribute("searchError", se.getMessage());
//			List<Tenant> found = tenantManager.getAll();
//			model.addAttribute(found);
		}
//		return new ModelAndView("tenant/list", model.asMap());
		
		return new ModelAndView("portal/list", model.asMap());
	}
	
	
	
}
