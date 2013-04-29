package com.ammob.communication.vidyo.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.ammob.communication.core.model.User;
import com.ammob.communication.vidyo.model.Member;

@WebService
@Path("/vidyo")
@Produces({"application/json"})
public interface VidyoService {
	
	@GET
    @Path("/user/invit/{conferenceID}/{entityID}")
	boolean invitVidyoMember(@QueryParam("")User user, 
			@PathParam("conferenceID")int conferenceID, @PathParam("entityID")int entityID);
	
	@GET
    @Path("/user/join/{conferenceID}")
	boolean joinVidyoRoom(@QueryParam("")User user, 
			@PathParam("conferenceID") int conferenceID);
	
	@GET
    @Path("/user/list/{area}/{index}/{limit}")
	List<Member> getVidyoMemberList(@QueryParam("")User user, 
			@PathParam("area") String area, @PathParam("index") int index, @PathParam("limit")int limit);
    
}
