package com.ammob.communication.vidyo.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.ammob.communication.core.authentication.principal.Credentials;
import com.ammob.communication.vidyo.model.Member;

@WebService
@Path("/vidyo")
@Consumes({"application/json", "application/xml"})
public interface VidyoService {
	
	@GET
    @Path("/user")
	@Produces({"application/json"})
	Member getMemberForWs(@QueryParam("")Credentials credentials, @QueryParam("area") String area);
	
	@GET
    @Path("/user/endpoint")
	@Produces({"text/plain"})
	String getEndpointForWs(@QueryParam("")Credentials credentials, @QueryParam("area") String area);
	
	@GET
    @Path("/user/link")
	@Produces({"text/plain"})
	String getLinkUrlForWs(@QueryParam("")Credentials credentials, @QueryParam("area") String area);
	
	@GET
    @Path("/user/favorite")
	@Produces({"application/json", "text/plain"})
	List<Member> getMyContactsForWs(@QueryParam("")Credentials credentials);
	
	@PUT
    @Path("/user/favorite/{MemberId}")
	@Produces({"text/plain", "application/json", "application/xml"})
	Response addMyContactsForWs(@QueryParam("")Credentials credentials, @PathParam("MemberId")int entityId);
	
	@DELETE
    @Path("/user/favorite/{MemberId}")
	@Produces({"application/json", "text/plain"})
	Response delMyContactsForWs(@QueryParam("")Credentials credentials, @PathParam("MemberId")int entityId);
	
	@GET
    @Path("/user/join/{RoomId}")
	@Produces({"text/plain"})
	Response joinRoomForWs(@QueryParam("")Credentials credentials, @QueryParam("pin") String ModeratorPIN, 
			@PathParam("RoomId") int conferenceId);
	
	@GET
    @Path("/user/leave/{RoomId}/{MemberId}")
	@Produces({"text/plain"})
	Response leaveRoomForWs(@QueryParam("")Credentials credentials, @QueryParam("pin") String ModeratorPIN, 
			@PathParam("RoomId") int conferenceId, @PathParam("MemberId")int entityId);
	
	@GET
    @Path("/user/invit/{RoomId}/{MemberId}")
	@Produces({"text/plain"})
	Response invitMemberForWs(@QueryParam("")Credentials credentials, @QueryParam("pin") String ModeratorPIN, 
			@PathParam("RoomId")int conferenceId, @PathParam("MemberId")int entityId);
	
	@GET
    @Path("/user/list/{Area}")
	@Produces({"application/json", "text/plain"})
	List<Member> getMemberListForWs(@QueryParam("")Credentials credentials, @QueryParam("pin") String ModeratorPIN, 
			@PathParam("Area") String area, @QueryParam("index") int index, @QueryParam("limit")int limit);
}
