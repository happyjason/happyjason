package com.ammob.communication.vidyo.service.impl;

import java.util.List;

import com.ammob.communication.core.service.impl.GenericManagerImpl;
import com.ammob.communication.vidyo.dao.ConferenceCallDao;
import com.ammob.communication.vidyo.model.ConferenceCall;
import com.ammob.communication.vidyo.service.ConferenceCallManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("conferenceCallManager")
@WebService(serviceName = "ConferenceCallService", endpointInterface = "com.ammob.communication.core.service.ConferenceCallManager")
public class ConferenceCallManagerImpl extends GenericManagerImpl<ConferenceCall, Long> implements ConferenceCallManager {
    ConferenceCallDao conferenceCallDao;

    @Autowired
    public ConferenceCallManagerImpl(ConferenceCallDao conferenceCallDao) {
        super(conferenceCallDao);
        this.conferenceCallDao = conferenceCallDao;
    }

	@Override
	public ConferenceCall get(String determineType, Long id) {
		return conferenceCallDao.loadConferenceCallById(determineType, id);
	}

	@Override
	public void remove(String determineType, Long id) {
		conferenceCallDao.removeConferenceCall(determineType, id);
	}

	@Override
	public List<ConferenceCall> getConferenceCalls(String determineType, String searchTerm) {
		return conferenceCallDao.getConferenceCalls(determineType, searchTerm);
	}
}