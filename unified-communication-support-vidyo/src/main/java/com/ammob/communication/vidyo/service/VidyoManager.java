package com.ammob.communication.vidyo.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Path;

import com.ammob.communication.core.authentication.principal.Credentials;
import com.ammob.communication.vidyo.exception.VidyoWrapException;
import com.ammob.communication.vidyo.model.Member;

/**
 * Web Service interface so hierarchy of Generic Manager isn't carried through.
 */
@WebService
@Path("/vidyo")
public interface VidyoManager {

	/**
	 * Get Member List
	 * @param user
	 * @param area
	 * @param index
	 * @param limit
	 * @return
	 * @throws VidyoWrapException
	 */
	List<Member> getMemberList(Credentials credentials, String ModeratorPIN, String area, int index, int limit)
			throws VidyoWrapException;
}
