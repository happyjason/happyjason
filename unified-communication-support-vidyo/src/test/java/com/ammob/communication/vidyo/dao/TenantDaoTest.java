package com.ammob.communication.vidyo.dao;

import java.util.List;

import com.ammob.communication.vidyo.model.Tenant;

import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

public class TenantDaoTest extends BaseDaoTestCase {
	@Autowired
	private TenantDao tenantDao;

	@Test(expected = DataAccessException.class)
	public void testAddAndRemoveTenant() {
		Tenant tenant = new Tenant();

		// enter all required fields
		tenant.setAdminName("admin");
		tenant.setAdminPassword("password");
		tenant.setUrl("v.ammob.com");
		tenant.setName("Ammob");
		tenant.setVersion(1);

		tenant.setCdrPassword("PbPaQoZbNlFwFbIoJfRvNvCq");
		log.debug("adding tenant...");
		tenant = tenantDao.save(tenant);

		tenant = tenantDao.get(tenant.getId());

		assertNotNull(tenant.getId());

		log.debug("removing tenant...");

		tenantDao.remove(tenant.getId());

		// should throw DataAccessException 
		tenantDao.get(tenant.getId());
	}

	@Test
	public void testTenantSearch() throws Exception {
		// reindex all the data
		tenantDao.reindex();

		List<Tenant> found = tenantDao.search("sunpa");
		assertEquals(1, found.size());
		Tenant tenant = found.get(0);
		assertEquals("sunpa", tenant.getName());

		// test mirroring
		tenant = tenantDao.get(2L);
		tenant.setUrl("sunpa.seekoom.com");
		tenantDao.saveTenant(tenant);
		flush();
		flushSearchIndexes();

		// now verify it is reflected in the index
		found = tenantDao.search("sunpa.seekoom.com");
		assertEquals(1, found.size());
		tenant = found.get(0);
		assertEquals("sunpa.seekoom.com", tenant.getUrl());
		
		// test get all
		found = tenantDao.getAll();
		assertEquals(2, found.size());
	}
}