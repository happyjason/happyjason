package com.ammob.communication.vidyo.service;

import com.ammob.communication.core.service.GenericManager;
import com.ammob.communication.vidyo.exception.CdrQueryException;
import com.ammob.communication.vidyo.model.Tenant;

import java.util.Date;
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
     * Search a tenant for search terms.
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
     * Get Call Detail Records Limit 10000 Num.
     * @param tenant
     * @return ConferenceCall List
     */
    List<Map<String, Object>> getCallDetailRecordList(Tenant tenant) 
    		throws CdrQueryException;
    
    /**
     * Get Call Detail Records for startDate and endDate.
     * @param tenant
     * @return ConferenceCall List
     */
    List<Map<String, Object>> getCallDetailRecordList(Tenant tenant, Date startDate, Date endDate) 
    		throws CdrQueryException;
    
    /**
     * Get Call Detail Records
     * @param tenant
     * @param searchTerm
     * @return ConferenceCall List
     */
    List<Map<String, Object>> getCallDetailRecordList(Tenant tenant, String searchTerm) 
    		throws CdrQueryException;
    
    /**
     * Handle Call Detail Record Upload
     * @param tenant
     * @return Handle Number
     */
    boolean handleCallDetailRecordUpload(Tenant tenant) throws CdrQueryException;
    
}