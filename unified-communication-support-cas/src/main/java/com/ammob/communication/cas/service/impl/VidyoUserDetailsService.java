package com.ammob.communication.cas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.dao.UserDao;
import com.ammob.communication.core.model.Role;
import com.ammob.communication.core.model.User;

@Service("vidyoUserDetailsService")
public class VidyoUserDetailsService implements AuthenticationUserDetailsService<CasAssertionAuthenticationToken> {
	
	private UserDao userDao;
	
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
	@Override
	public UserDetails loadUserDetails(CasAssertionAuthenticationToken token)
			throws UsernameNotFoundException {
		try {
			return userDao.loadUserByUsername(token.getName());
		} catch (Exception e) {
			User user = new User();
			user.addRole(new Role(Constants.USER_ROLE));
			return user;
		}
	}
}
