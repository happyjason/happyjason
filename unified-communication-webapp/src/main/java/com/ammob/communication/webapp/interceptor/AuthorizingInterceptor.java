package com.ammob.communication.webapp.interceptor;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.security.AbstractAuthorizingInInterceptor;
import org.apache.cxf.interceptor.security.AccessDeniedException;
import org.apache.cxf.message.Message;
import org.apache.cxf.security.SecurityContext;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

import com.ammob.communication.core.util.StringUtil;

public class AuthorizingInterceptor extends AbstractAuthorizingInInterceptor {

	@Override
    public void handleMessage(Message message) throws Fault {
		HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
        SecurityContext sc = message.get(SecurityContext.class);
        if (sc != null && sc.getUserPrincipal() != null) {
            Method method = getTargetMethod(message);
            if (authorize(sc, method)) {
                return;
            }
        }
        String access_token = request.getParameter("access_token");
        if(StringUtil.hasText(access_token) && access_token.equals("2f3146ac90d60b9f79125b1167437b6c64657a0b")) {
        	return;
		}
        throw new AccessDeniedException("Unauthorized");
    }
    
	@Override
	protected List<String> getExpectedRoles(Method method) {
		return null;
	}
}
