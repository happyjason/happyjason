package com.ammob.communication.cas.authentication.handler;

import javax.validation.constraints.NotNull;

import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.handler.UnsupportedCredentialsException;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Autowired;

import com.ammob.communication.cas.authentication.principal.VidyoCredentials;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.service.VidyoManager;

public class VidyoAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {
	
	@Autowired
	@NotNull
	private VidyoManager vidyoManager;

	public void setVidyoManager(VidyoManager vidyoManager) {
		this.vidyoManager = vidyoManager;
	}

	@Override
	protected boolean authenticateUsernamePasswordInternal(UsernamePasswordCredentials credentials)
				throws AuthenticationException {
		if(!(credentials instanceof VidyoCredentials))
			throw new UnsupportedCredentialsException();
		try {
			final String username = getPrincipalNameTransformer().transform(credentials.getUsername());
	        final String password = credentials.getPassword();
	        String serverUrl = ((VidyoCredentials)credentials).getServerUrl();
	        try {
				serverUrl = StringUtil.getUrlDomain(serverUrl);
			} catch (Exception e) {
				log.debug("server url format is error !! url = " + serverUrl);
	        	return false;
			}
	        if(vidyoManager == null){
	        	log.debug("vidyoManager is null !!");
	        	return false;
	        }
	        if(!StringUtil.hasText(username) || !StringUtil.hasText(password) || !StringUtil.hasText(serverUrl)) {
	        	log.debug("username is null !!");
	        	return false;
	        }
			if(vidyoManager.getVidyoAuthenticationState(serverUrl, username, password)) {
				return true;
			}
		} catch (Exception e) {
			log.warn("ServerUrl : " + ((VidyoCredentials)credentials).getServerUrl() + 
					"User : " + credentials.getUsername() + ", login is fail ! e : " + e.getMessage());
		}
		return false;
	}

}
