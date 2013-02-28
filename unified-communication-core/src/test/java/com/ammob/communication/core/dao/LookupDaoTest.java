package com.ammob.communication.core.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ammob.communication.core.model.Role;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * This class tests the current LookupDao implementation class
 * @author mraible
 */
public class LookupDaoTest extends BaseDaoTestCase {
    @Autowired
    LookupDao lookupDao;

    @Test
    public void testGetRoles() {
        List<Role> roles = lookupDao.getRoles();
        log.debug(roles);
        assertTrue(roles.size() > 0);
    }
}
