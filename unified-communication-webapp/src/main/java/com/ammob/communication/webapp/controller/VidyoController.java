package com.ammob.communication.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ammob.communication.vidyo.service.VidyoManager;

/**
 * Simple class to retrieve a list of tenants from the database.
 */
@Controller
@RequestMapping("/vidyo*")
public class VidyoController {
	
	private VidyoManager vidyoManager;
	
	@Autowired
	public void setVidyoManager(VidyoManager vidyoManager) {
		this.vidyoManager = vidyoManager;
	}
	
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login*", method = RequestMethod.GET)
	public ModelAndView showLogin() throws Exception {
		return new ModelAndView("guest/vidyoLogin");
	}
	
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login*", method = RequestMethod.POST)
	public ModelAndView handleLogin(@RequestParam(required = false, value = "q") String query) throws Exception {
		Model model = new ExtendedModelMap();

		return new ModelAndView("guest/vidyo", model.asMap());
	}
}
