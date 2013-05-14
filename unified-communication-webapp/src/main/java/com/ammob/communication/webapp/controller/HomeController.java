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
@RequestMapping("/home*")
public class HomeController extends BaseController {
	
	/**
	 * The home page.
	 * @param Request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showHome(HttpServletRequest request) throws Exception {
		Model model = new ExtendedModelMap();
		saveMessage(request, "testtest");
		return new ModelAndView("home", model.asMap());
	}
}
