package com.ammob.communication.vidyo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ammob.communication.vidyo.dao.TenantDao;
import com.ammob.communication.vidyo.model.Tenant;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class TenantManagerImplTest extends BaseManagerMockTestCase {
    private TenantManagerImpl manager = null;
    private TenantDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(TenantDao.class);
        manager = new TenantManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetTenant() {
        log.debug("testing get...");

        final Long id = 7L;
        final Tenant tenant = new Tenant();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(tenant));
        }});

        Tenant result = manager.get(id);
        assertSame(tenant, result);
    }

    @Test
    public void testGetTenants() {
        log.debug("testing getAll...");

        final List<Tenant> tenants = new ArrayList<Tenant>();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(tenants));
        }});

        List<Tenant> result = manager.getAll();
        assertSame(tenants, result);
    }

    @Test
    public void testSaveTenant() {
        log.debug("testing save...");

        final Tenant tenant = new Tenant();
        // enter all required fields
        tenant.setAdminName("admin");
        tenant.setAdminPassword("password");
        tenant.setUrl("v.seekoom.com");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(tenant)));
        }});

        manager.save(tenant);
    }

    @Test
    public void testRemoveTenant() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}