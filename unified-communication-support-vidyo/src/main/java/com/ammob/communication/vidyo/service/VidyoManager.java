package com.ammob.communication.vidyo.service;

import java.net.MalformedURLException;

import javax.jws.WebService;
import javax.ws.rs.Path;

import com.vidyo.portal.admin.v1_1.InviteToConferenceResponse;
import com.vidyo.portal.admin.v1_1.VidyoPortalAdminServicePortType;
import com.vidyo.portal.superapi.VidyoPortalSuperServicePortType;
import com.vidyo.portal.user.v1_1.LogInResponse;
import com.vidyo.portal.user.v1_1.VidyoPortalUserServicePortType;

/**
 * Web Service interface so hierarchy of Generic Manager isn't carried through.
 */
@WebService
@Path("/vidyo")
public interface VidyoManager {
	
	/**
	 * vidyo portal super service, webservice method
	 * 
	 * @param protalUrl
	 * @param username
	 * @param password
	 * @return
	 * @throws MalformedURLException
	 */
	VidyoPortalSuperServicePortType getSuperClient(String protalUrl, String username, String password)
			throws MalformedURLException;
	
	
	/**
	 * vidyo portal admin service, webservice method
	 * 
	 * @param protalUrl
	 * @param username
	 * @param password
	 * @return
	 * @throws MalformedURLException
	 */
	VidyoPortalAdminServicePortType getAdminClient(String protalUrl, String username, String password)
			throws MalformedURLException;
	
	/**
	 * vidyo portal user service, packaging webservice method
	 * 
	 * @param protalUrl
	 * @param username
	 * @param password
	 * @return
	 * @throws MalformedURLException
	 */
	VidyoPortalUserServicePortType getUserClient(String protalUrl, String username, String password) 
			throws MalformedURLException;
	
	/**
	 * custom client synchro vidyo desktop client login
	 * @deprecated
	 * @param protalUrl
	 * @param logInResponse
	 * @param username
	 */
	void synchroVidyoDeskTopClientLogin(String protalUrl, LogInResponse logInResponse, String username);
	
	/**
	 * 
	 * @param protalUrl
	 * @param username
	 * @param password
	 * @return
	 * @throws MalformedURLException
	 * @throws com.vidyo.portal.admin.v1_1.GeneralFault_Exception
	 * @throws com.vidyo.portal.admin.v1_1.NotLicensedFault_Exception
	 * @throws com.vidyo.portal.admin.v1_1.InvalidArgumentFault_Exception
	 */
	InviteToConferenceResponse invite(String protalUrl, String username, String password) 
			throws MalformedURLException, 
					com.vidyo.portal.admin.v1_1.GeneralFault_Exception, 
					com.vidyo.portal.admin.v1_1.NotLicensedFault_Exception, 
					com.vidyo.portal.admin.v1_1.InvalidArgumentFault_Exception;
}
