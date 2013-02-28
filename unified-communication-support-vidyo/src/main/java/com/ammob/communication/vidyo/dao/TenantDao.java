package com.ammob.communication.vidyo.dao;

import com.ammob.communication.core.dao.GenericDao;
import com.ammob.communication.vidyo.model.Tenant;


/**
 * An interface that provides a data management interface to the Tenant table.
 */
public interface TenantDao extends GenericDao<Tenant, Long> {
	
    /**
     * Saves a tenant's information.
     * @param tenant the object to be saved
     * @return the persisted Tenant object
     */
	Tenant saveTenant(Tenant tenant);

}