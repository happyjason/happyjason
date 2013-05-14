package com.ammob.communication.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
	
	/**
	 * 
	 * @param request
	 * @param error
	 */
    @SuppressWarnings("unchecked")
    public static void saveError(HttpServletRequest request, String error) {
        List<String> errors = (List<String>) request.getSession().getAttribute("errors");
        if (errors == null) {
            errors = new ArrayList<String>();
        }
        errors.add(error);
        request.getSession().setAttribute("errors", errors);
    }
    
	/**
	 * 
	 * @param request
	 * @param message
	 */
	@SuppressWarnings({"unchecked" })
	protected void saveMessage(HttpServletRequest request, String message){
		List<String> messages = (List<String>) request.getSession().getAttribute(BaseFormController.MESSAGES_KEY);
	    if (messages == null) {
	        messages = new ArrayList<String>();
	    }
	    messages.add(message);
	    request.getSession().setAttribute(BaseFormController.MESSAGES_KEY, messages);
	}
}
