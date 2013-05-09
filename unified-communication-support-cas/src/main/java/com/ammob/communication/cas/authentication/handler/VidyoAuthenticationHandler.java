package com.ammob.communication.cas.authentication.handler;

import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.handler.UnsupportedCredentialsException;
import org.jasig.cas.authentication.handler.support.AbstractPreAndPostProcessingAuthenticationHandler;
import org.jasig.cas.authentication.principal.Credentials;

import com.ammob.communication.cas.authentication.principal.VidyoCredentials;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.util.VidyoUserUtil;

public class VidyoAuthenticationHandler extends AbstractPreAndPostProcessingAuthenticationHandler {

	/**
	 * @return true if the credentials are not null and the credentials class is
	 * equal to the class defined in classToSupport.
	 */
	@Override
	public final boolean supports(final Credentials credentials) {
		return credentials != null && (
				VidyoCredentials.class.isAssignableFrom(credentials.getClass()));
	}

	@Override
	protected boolean doAuthentication(Credentials credentials)
			throws AuthenticationException {
		if(!(credentials instanceof VidyoCredentials))
			throw new UnsupportedCredentialsException();
		VidyoCredentials vidyoCredentials = (VidyoCredentials)credentials;
		String username = vidyoCredentials.getUsername();
		String password = vidyoCredentials.getPassword();
		String serverUrl = vidyoCredentials.getUrl();
		try {
			try {
				serverUrl = StringUtil.getUrlDomain(serverUrl);
			} catch (Exception e) {
				log.warn("server url format is error !! url = " + serverUrl);
				return false;
			}
			if(!StringUtil.hasText(username) || !StringUtil.hasText(password) 
					|| !StringUtil.hasText(serverUrl)) {
				log.warn("username is null !!");
				return false;
			}
			if(VidyoUserUtil.getAuthenticationState(serverUrl, username, password)) {
				return true;
			}
		} catch (Exception e) {
			log.warn("ServerUrl : " + vidyoCredentials.getUrl() + 
					 ", User : " + vidyoCredentials.getUsername() + 
					 ", login is fail ! e : " + e.getMessage());
		}
		return false;
	}
}
