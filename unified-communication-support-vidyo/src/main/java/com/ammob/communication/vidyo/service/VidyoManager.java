package com.ammob.communication.vidyo.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Path;

import com.ammob.communication.core.authentication.principal.Credentials;
import com.ammob.communication.vidyo.exception.VidyoWrapException;
import com.ammob.communication.vidyo.model.Member;
import com.ammob.communication.vidyo.model.SearchFilter;
import com.ammob.communication.vidyo.model.Tenant;

/**
 * Web Service interface so hierarchy of Generic Manager isn't carried through.
 */
@WebService
@Path("/vidyo")
public interface VidyoManager {

	/**
	 * add vidyo tenant for credentials portal
	 * @param credentials
	 * @param tenant url\name\extensionPrefix is required
	 * @return
	 * @throws VidyoWrapException
	 */
	boolean addTenant(Credentials credentials, Tenant tenant) throws VidyoWrapException;
	
	/**
	 * del vidyo tenant for credentials portal
	 * @param credentials
	 * @param tenantId
	 * @return
	 * @throws VidyoWrapException
	 */
	boolean delTenant(Credentials credentials, Integer tenantId) throws VidyoWrapException;
	
	/**
	 * set vidyo tenant for credentials portal
	 * @param credentials
	 * @param tenant url\name\extensionPrefix is required
	 * @return
	 * @throws VidyoWrapException
	 */
	boolean setTenant(Credentials credentials, Tenant tenant) throws VidyoWrapException;
	
	/**
	 * get vidyo tenant for credentials portal
	 * @param credentials
	 * @param tenantId
	 * @return
	 * @throws VidyoWrapException
	 */
	Tenant getTenant(Credentials credentials, Integer tenantId) throws VidyoWrapException;
	
	/**
	 * get tenant list
	 * @param credentials
	 * @return
	 * @throws VidyoWrapException
	 */
	List<Tenant> getTenantList(Credentials credentials, SearchFilter filter, String tenantName, String tenantURL)
			throws VidyoWrapException;
	
	/**
	 * get member list
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
