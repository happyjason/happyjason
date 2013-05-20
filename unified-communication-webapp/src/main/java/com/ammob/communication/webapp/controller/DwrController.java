package com.ammob.communication.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ammob.communication.core.authentication.principal.Credentials;
import com.ammob.communication.vidyo.exception.VidyoWrapException;
import com.ammob.communication.vidyo.model.Member;
import com.ammob.communication.vidyo.service.VidyoManager;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

@Controller("dwrController")
public class DwrController {
	
	@Autowired
	private VidyoManager vidyoManager;
	
	public List<Member> getMemberList(Integer index, Integer limit){
		try {
			return vidyoManager.getMemberList(new Credentials("hotmob", "121212", "http://v.seekoom.com"), "", "", index, limit);
		} catch (VidyoWrapException e) {
		}
		return new ArrayList<Member>();
	}
	
	public String getUser(){
		WebContext webContext = WebContextFactory.get(); 
		HttpSession session = webContext.getSession();
		HttpServletRequest request=webContext.getHttpServletRequest();
		HttpServletResponse response=webContext.getHttpServletResponse(); 
		return "helloworld";
	}

	/**
	 * @return vidyoManager
	 */
	public VidyoManager getVidyoManager() {
		return vidyoManager;
	}

	/**
	 * @param vidyoManager 要设置的 vidyoManager
	 */
	public void setVidyoManager(VidyoManager vidyoManager) {
		this.vidyoManager = vidyoManager;
	}
}
