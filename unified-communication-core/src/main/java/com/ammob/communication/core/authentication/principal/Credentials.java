package com.ammob.communication.core.authentication.principal;

public class Credentials {

    private String username;
    private String password;
	private String url;
	private boolean internal;
	private boolean rememberMe;
	
	public Credentials() {
		
	}
	
	public Credentials(String username, String password) {
		setUsername(username);
		setPassword(password);
	}
	
	public Credentials(String username, String password, String url) {
		setUsername(username);
		setPassword(password);
		setUrl(url);
	}
	
	public Credentials(String username, String password, boolean rememberMe) {
		setUsername(username);
		setPassword(password);
		setRememberMe(rememberMe);
	}

	 /**
     * @return Returns the password.
     */
    public final String getPassword() {
        return this.password;
    }

    /**
     * @param password The password to set.
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return Returns the userName.
     */
    public final String getUsername() {
        return this.username;
    }

    /**
     * @param userName The userName to set.
     */
    public final void setUsername(final String userName) {
        this.username = userName;
    }

    /**
     * 
     */
    public String toString() {
        return "[username: " + this.username + "]";
    }
    
    /**
     * @return
     */
	public final boolean isRememberMe() {
		return this.rememberMe;
	}
	
	/**
	 * @param rememberMe
	 */
	public final void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	/**
	 * @return
	 */
	public boolean isInternal() {
		return internal;
	}

	/**
	 * @param internal
	 */
	public void setInternal(boolean internal) {
		this.internal = internal;
	}

	/**
	 * @return vidyo super manage url
	 */
	 public String getUrl() {
		return url;
	}

	 /**
	  * @param serverUrl
	  */
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Credentials other = (Credentials) obj;
        if (password != null ? !password.equals(other.password) : other.password != null) 
        	return false;
        if (username != null ? !username.equals(other.username) : other.username != null) 
        	return false;
        if (url != null ? !url.equals(other.url) : other.url != null) 
        	return false;
		if (this.rememberMe != other.rememberMe)
			return false;
		if (this.internal != other.internal)
			return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = this.username != null ? this.username.hashCode() : 0;
		result = prime * result + (this.password != null ? this.password.hashCode() : 0);
		result = prime * result + (this.url != null ? this.url.hashCode() : 0);
		result = prime * result + (this.rememberMe ? 1231 : 1237);
		result = prime * result + (this.internal ? 1231 : 1237);
		return result;
	}
}