package com.ammob.communication.vidyo.service;

import com.ammob.communication.core.service.GenericManager;
import com.ammob.communication.vidyo.model.Tenant;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Web Service interface so hierarchy of Generic Manager isn't carried through.
 */
@WebService
@Path("/tenants")
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
    @GET
    @Path("{id}")
    Tenant getTenant(@PathParam("id") String tenantId);
    
}