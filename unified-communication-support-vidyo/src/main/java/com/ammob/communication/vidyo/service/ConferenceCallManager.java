package com.ammob.communication.vidyo.service;

import java.util.List;

import javax.jws.WebService;

import com.ammob.communication.vidyo.model.ConferenceCall;


@WebService
public interface ConferenceCallManager/* extends GenericManager<ConferenceCall, Long> */{
	
	ConferenceCall get(String determineType, Long id);
	
	void remove(String determineType, Long id);
	
	List<ConferenceCall> getConferenceCalls(String determineType, String searchTerm);
}