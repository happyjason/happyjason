package com.ammob.communication.vidyo.service;

import java.net.MalformedURLException;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Path;

import com.ammob.communication.core.model.User;
import com.ammob.communication.vidyo.model.Member;
import com.vidyo.portal.admin.v1_1.InviteToConferenceResponse;
import com.vidyo.portal.user.v1_1.LogInResponse;

/**
 * Web Service interface so hierarchy of Generic Manager isn't carried through.
 */
@WebService
@Path("/vidyo")
public interface VidyoManager {

	/**
	 * custom client synchro vidyo desktop client login
	 * @deprecated
	 * @param protalUrl
	 * @param logInResponse
	 * @param username
	 */
	boolean vidyoSynchroDeskTopClientLogin(String protalUrl, LogInResponse logInResponse, String username);
	
	/**
	 * custom client vidyo desktop client login
	 * @param protalUrl
	 * @param logInResponse
	 * @param username
	 */
	boolean getVidyoAuthenticationState(String protalUrl, String username, String password);
	
	boolean joinVidyoRoom(User user, int conferenceID);

	boolean invitVidyoMember(User user, int conferenceID, int entityID);
	
	List<Member> getVidyoMemberList(User user, String area, int index, int limit);
}
