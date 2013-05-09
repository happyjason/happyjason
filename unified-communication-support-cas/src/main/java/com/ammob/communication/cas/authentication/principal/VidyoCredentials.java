package com.ammob.communication.cas.authentication.principal;

import org.jasig.cas.authentication.principal.RememberMeCredentials;

import com.ammob.communication.core.authentication.principal.Credentials;

public class VidyoCredentials extends Credentials implements RememberMeCredentials {

	private static final long serialVersionUID = 1L;

	public VidyoCredentials(String username, String password) {
		super(username, password);
	}

	public VidyoCredentials(String username, String password, boolean rememberMe) {
		super(username, password, rememberMe);
	}

}