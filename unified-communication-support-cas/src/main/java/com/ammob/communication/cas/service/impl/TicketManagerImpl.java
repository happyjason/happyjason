package com.ammob.communication.cas.service.impl;

import java.net.URI;

import javax.jws.WebService;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jasig.cas.CentralAuthenticationService;
import org.jasig.cas.authentication.principal.SimpleWebApplicationServiceImpl;
import org.jasig.cas.ticket.InvalidTicketException;
import org.jasig.cas.ticket.TicketException;
import org.jasig.cas.util.HttpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ammob.communication.cas.authentication.principal.VidyoCredentials;
import com.ammob.communication.cas.service.TicketService;
import com.ammob.communication.core.util.StringUtil;

@Service("authTicketManager")
@WebService(serviceName = "TicketService", 
	endpointInterface = "com.ammob.communication.cas.service.TicketService")
@Transactional("coreTransactionManager")
public class TicketManagerImpl implements TicketService {
	
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());
    
    @Autowired
    @NotNull
    private CentralAuthenticationService centralAuthenticationService;
    
    @Autowired
    @NotNull
    private HttpClient httpClient;
    
	public String createTicketGrantingTicket(VidyoCredentials vidyoCredentials) {
		try {
			return centralAuthenticationService.createTicketGrantingTicket(vidyoCredentials);
		} catch (TicketException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public Response createTicketGrantingTicketForWs(VidyoCredentials vidyoCredentials, UriInfo uriInfo){
        String tgt = createTicketGrantingTicket(vidyoCredentials);
        if(!StringUtil.hasText(tgt))
        	return Response.status(Response.Status.NOT_FOUND).build();
        URI newItemURI = uriInfo.getRequestUriBuilder().path(tgt).build();
        ResponseBuilder builder = Response.ok("<!DOCTYPE HTML PUBLIC \"-//IETF//DTD HTML 2.0//EN\"><html><head><title>" + Response.Status.CREATED.getStatusCode() + " " + Response.Status.CREATED.getReasonPhrase() + "</title></head><body><h1>TGT Created</h1><form action=\"" + newItemURI.toString() + "\" method=\"POST\">Service:<input type=\"text\" name=\"service\" value=\"\"><br><input type=\"submit\" value=\"Submit\"></form></body></html>");  
        builder.location(newItemURI);
        builder.status(Response.Status.CREATED);
        return builder.build();
	}
	
	@Override
	public Response getServerTicket(String tgt, String serviceUrl) {
		try {
			org.jasig.cas.authentication.principal.Service _service = new SimpleWebApplicationServiceImpl(serviceUrl, this.httpClient);
			String serviceTicketId = this.centralAuthenticationService.grantServiceTicket(tgt, _service);
			return Response.ok(serviceTicketId, MediaType.TEXT_PLAIN).build();
		} catch (InvalidTicketException e) {
			log.warn("ServiceUrl = " + serviceUrl + ", tgt = " + tgt + ", e : " + e);
			return Response.status(Response.Status.BAD_REQUEST).build();
		} catch (DataAccessResourceFailureException e) {
			log.warn("ServiceUrl = " + serviceUrl + ", tgt = " + tgt + ", e : " + e);
			return Response.status(Response.Status.BAD_REQUEST).build();
		} catch (Exception e) {
			log.warn("ServiceUrl = " + serviceUrl + ", tgt = " + tgt + ", e : " + e);
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@Override
	public Response removeServerTicket(String tgt) {
		this.centralAuthenticationService.destroyTicketGrantingTicket(tgt);
		return Response.status(Response.Status.OK).build();
	}
}
