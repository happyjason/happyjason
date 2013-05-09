package com.ammob.communication.cas.service;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Web Service interface so hierarchy of Generic Manager isn't carried through.
 */
@WebService
@Path("/authorization")
@Produces({"text/html", "text/plain"})
public interface AuthorizationService {

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
    @POST
    @Path("/tickets")
    Response getGrantTicket(@FormParam("username") String username, @FormParam("password") String password, @FormParam("rememberMe") boolean rememberMe, @Context UriInfo uriInfo);
    
    /**
     * 
     * @param tgt ticket granting ticketId.
     * @param serviceUrl service url
     * @return
     */
    @POST
    @Path("/tickets/{id}")
    Response getServerTicket(@PathParam("id") String tgt, @FormParam("service") String serviceUrl);
    
    /**
     * 
     * @param tgt
     * @return
     */
    @DELETE
    @Path("/tickets/{id}")
    Response removeServerTicket(@PathParam("id") String tgt);
}