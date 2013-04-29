package com.ammob.communication.cas.authentication.principal;

import org.jasig.cas.authentication.principal.RememberMeUsernamePasswordCredentials;

public class VidyoCredentials extends RememberMeUsernamePasswordCredentials {

	private static final long serialVersionUID = 1L;

	private String serverUrl;
	private boolean internal = false;

	public VidyoCredentials() {
		super();
	}

	public VidyoCredentials(String username, String password) {
		this();
		setUsername(username);
		setPassword(password);
	}

	public VidyoCredentials(String username, String password, boolean rememberMe) {
		this();
		setUsername(username);
		setPassword(password);
		setRememberMe(rememberMe);
	}

	public boolean isInternal() {
		return internal;
	}

	public void setInternal(boolean internal) {
		this.internal = internal;
	}
	
	/**
	 * 租客服务器地址
	 * @return
	 */
	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
}