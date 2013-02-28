package com.ammob.communication.vidyo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ammob.communication.vidyo.dao.ConferenceCallDao;
import com.ammob.communication.vidyo.model.ConferenceCall;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConferenceCallManagerImplTest extends BaseManagerMockTestCase {
    private ConferenceCallManagerImpl manager = null;
    private ConferenceCallDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(ConferenceCallDao.class);
        manager = new ConferenceCallManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetConferenceCall() {
        log.debug("testing get...");

        final Long callId = 7L;
        final ConferenceCall conferenceCall = new ConferenceCall();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(callId)));
            will(returnValue(conferenceCall));
        }});

        ConferenceCall result = manager.get(callId);
        assertSame(conferenceCall, result);
    }

    @Test
    public void testGetConferenceCalls() {
        log.debug("testing getAll...");

        final List<ConferenceCall> conferenceCalls = new ArrayList<ConferenceCall>();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(conferenceCalls));
        }});

        List<ConferenceCall> result = manager.getAll();
        assertSame(conferenceCalls, result);
    }

    @Test
    public void testRemoveConferenceCall() {
        log.debug("testing remove...");

        final Long callId = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(callId)));
        }});

        manager.remove(callId);
    }
}