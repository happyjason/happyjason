package com.ammob.communication.webapp.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.springframework.security.cas.authentication.CasAuthenticationToken;

import com.ammob.communication.vidyo.model.Member;

public class DwrUtil {
	
	public List<Member> getUserList(){
		WebContext webContext = WebContextFactory.get(); 
		HttpSession session = webContext.getSession();
		HttpServletRequest request=webContext.getHttpServletRequest();
		HttpServletResponse response=webContext.getHttpServletResponse();

		try {
			//AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
			CasAuthenticationToken token = (CasAuthenticationToken) request.getUserPrincipal();
			String loginName = token.getName();//获取用户名
			String prin = token.getPrincipal().toString();//获取用户名
			System.out.print(loginName);
			System.out.print(prin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
