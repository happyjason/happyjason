package com.ammob.communication.core.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserManagerTest extends BaseManagerTestCase {
    private Log log = LogFactory.getLog(UserManagerTest.class);
    @Autowired
    private UserManager mgr;
    @Autowired
    private RoleManager roleManager;
    private User user;

    @Test
    public void testGetUser() throws Exception {
        user = mgr.getUserByUsername("mupeng");
        assertNotNull(user);
        
        log.debug(user);
        assertEquals(1, user.getRoles().size());
    }

    @Test
    public void testSaveUser() throws Exception {
        user = mgr.getUserByUsername("hotmob");
        user.setPhoneNumber("303-555-1212");
        log.debug("saving user with updated phone number: " + user);

        user = mgr.saveUser(user);
        assertEquals("303-555-1212", user.getPhoneNumber());
        assertEquals(1, user.getRoles().size());
    }

    @Test
    public void testAddAndRemoveUser() throws Exception {
        user = new User();

        // call populate method in super class to populate test data
        // from a properties file matching this class name
        user = (User) populate(user);

        user.addRole(roleManager.getRole(Constants.USER_ROLE));

        user = mgr.saveUser(user);
        assertEquals("lee", user.getUsername());
        assertEquals(1, user.getRoles().size());

        log.debug("removing user...");

        mgr.removeUser(user.getId().toString());

        try {
            user = mgr.getUserByUsername("lee");
            fail("Expected 'Exception' not thrown");
        } catch (Exception e) {
            log.debug(e);
            assertNotNull(e);
        }
    }
}
