package com.ammob.communication.vidyo.dao;

import java.util.List;

import com.ammob.communication.core.dao.GenericDao;
import com.ammob.communication.vidyo.model.ConferenceCall;

/**
 * An interface that provides a data management interface to the ConferenceCall table.
 */
public interface ConferenceCallDao extends GenericDao<ConferenceCall, Long>{
	
    /**
     * Gets users information based on login name.
     * @param username the user's username
     * @return userDetails populated userDetails object
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException thrown when user not
     * found in database
     */
    ConferenceCall loadConferenceCallById(String determineType, Long id);
	
    /**
     * Gets a list of ConferenceCall.
     *
     * @return List populated list of ConferenceCall
     */
    List<ConferenceCall> getConferenceCalls(String determineType, String searchTerm);
    
    /**
     * Remove ConferenceCall.
     */
	void removeConferenceCall(String determineType, Long id);
}