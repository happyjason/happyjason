package com.ammob.communication.vidyo.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.solr.request.JSONResponseWriter;

import com.ammob.communication.core.authentication.principal.Credentials;
import com.ammob.communication.vidyo.model.Member;
import com.ammob.communication.vidyo.model.SearchFilter;
import com.ammob.communication.vidyo.model.Tenant;

@WebService
@Path("/vidyo")
@Consumes({"application/x-www-form-urlencoded"})
@Produces({"application/json", "application/xml", "text/plain"})
public interface VidyoService {
	
	/*****************************************************************************
	 *                           For Super Web Service
	 *****************************************************************************/
	
	@PUT
    @Path("/tenant")
	String addTenantForWs(@QueryParam("")Credentials credentials, @FormParam("")Tenant tenant);

	@DELETE
    @Path("/tenant/{tenantId}")
	String delTenantForWs(@QueryParam("")Credentials credentials, @PathParam("tenantId")Integer tenantId);
	
	@POST
    @Path("/tenant/{tenantId}")
	String setTenantForWs(@QueryParam("")Credentials credentials, @PathParam("tenantId")Integer tenantId, @FormParam("")Tenant tenant);
	
	@GET
    @Path("/tenant/{tenantId}")
	Tenant getTenantForWs(@QueryParam("")Credentials credentials, @PathParam("tenantId")Integer tenantId);
	
	@GET
    @Path("/tenant")
	List<Tenant> getTenantListForWs(@QueryParam("")Credentials credentials, @QueryParam("")SearchFilter filter,
			@QueryParam("tenantName")String tenantName, @QueryParam("tenantUrl")String tenantURL);
	/*****************************************************************************
	 *                           For Admin Web Service
	 *****************************************************************************/
	
	/*****************************************************************************
	 *                           For User Web Service
	 *****************************************************************************/
	
	@GET
    @Path("/user")
	Member getMemberForWs(@QueryParam("")Credentials credentials, @QueryParam("area") String area);
	
	@GET
    @Path("/user/endpoint")
	String getEndpointForWs(@QueryParam("")Credentials credentials, @QueryParam("area") String area);
	
	@GET
    @Path("/user/link")
	String getLinkUrlForWs(@QueryParam("")Credentials credentials, @QueryParam("area") String area);
	
	@GET
    @Path("/user/favorite")
	List<Member> getMyContactsForWs(@QueryParam("")Credentials credentials);
	
	@PUT
    @Path("/user/favorite/{MemberId}")
	Response addMyContactsForWs(@QueryParam("")Credentials credentials, @PathParam("MemberId")int entityId);
	
	@DELETE
    @Path("/user/favorite/{MemberId}")
	Response delMyContactsForWs(@QueryParam("")Credentials credentials, @PathParam("MemberId")int entityId);
	
	@GET
    @Path("/user/join/{RoomId}")
	Response joinRoomForWs(@QueryParam("")Credentials credentials, @QueryParam("pin") String ModeratorPIN, 
			@PathParam("RoomId") int conferenceId);
	
	@GET
    @Path("/user/leave/{RoomId}/{MemberId}")
	Response leaveRoomForWs(@QueryParam("")Credentials credentials, @QueryParam("pin") String ModeratorPIN, 
			@PathParam("RoomId") int conferenceId, @PathParam("MemberId")int entityId);
	
	@GET
    @Path("/user/invit/{RoomId}/{MemberId}")
	Response invitMemberForWs(@QueryParam("")Credentials credentials, @QueryParam("pin") String ModeratorPIN, 
			@PathParam("RoomId")int conferenceId, @PathParam("MemberId")int entityId);
	
	@GET
    @Path("/user/list/{Area}")
	List<Member> getMemberListForWs(@QueryParam("")Credentials credentials, @QueryParam("pin") String ModeratorPIN, 
			@PathParam("Area") String area, @QueryParam("index") int index, @QueryParam("limit")int limit);
	
	
	
	@GET
	@Path("/user/list")
	List<Member>getMemberLists(@QueryParam("")Credentials credentials,@QueryParam("")SearchFilter filter);
	
}
