package com.ammob.communication.vidyo.service;

import com.ammob.communication.core.service.GenericManager;
import com.ammob.communication.vidyo.exception.CdrQueryException;
import com.ammob.communication.vidyo.model.Tenant;

import java.util.List;
import java.util.Map;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 */
public interface TenantManager extends GenericManager<Tenant, Long> {
	
    /**
     * Retrieves a list of all tenants.
     *
     * @return List
     */
    List<Tenant> getTenants();
    
    /**
     * Search a user for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Tenant> search(String searchTerm);
    
    /**
     * Retrieves a tenant by tenantId.  An exception is thrown if tenant not found
     *
     * @param tenantId the identifier for the tenant
     * @return Tenant
     */
    Tenant getTenant(String tenantId);
    
    /**
     * Check cdr availability
     * @param tenantId
     * @return
     */
    boolean checkCdrState(String tenantId);
    
    /**
     * Get Call Detail Records Limit 100 Num.
     * @param tenantId
     * @return ConferenceCall List
     */
    List<Map<String, Object>> getCallDetailRecordList(String tenantId) throws CdrQueryException;
    
    /**
     * Get Call Detail Records
     * @param tenantId
     * @param searchTerm
     * @return ConferenceCall List
     */
    List<Map<String, Object>> getCallDetailRecordList(String tenantId, String searchTerm) throws CdrQueryException;
    
}