package com.ammob.communication.vidyo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ammob.communication.vidyo.model.Tenant;

public class TenantManagerTest extends BaseManagerTestCase {
    private Log log = LogFactory.getLog(TenantManagerTest.class);
    @Autowired
    private TenantManager mgr;
    
	@Test
	public void testSearch() {
		List<Tenant> found = mgr.search(null);
		log.info(found);
		assertEquals(2, found.size());
	}

}
