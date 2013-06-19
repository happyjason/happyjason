package com.ammob.communication.vidyo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.ammob.communication.core.authentication.principal.Credentials;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.exception.VidyoWrapException;
import com.ammob.communication.vidyo.model.Member;
import com.ammob.communication.vidyo.model.SearchFilter;
import com.ammob.communication.vidyo.model.SearchFilter.EntityType;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.service.VidyoManager;
import com.ammob.communication.vidyo.service.VidyoService;
import com.ammob.communication.vidyo.util.VidyoSuperUtil;
import com.ammob.communication.vidyo.util.VidyoUserUtil;

@Service("vidyoManager")
@WebService(serviceName = "VidyoService", endpointInterface = "com.ammob.communication.vidyo.service.VidyoManager")
public class VidyoManagerImpl implements VidyoManager, VidyoService {
	
	private static final Log log = LogFactory.getLog(VidyoManagerImpl.class);
	
    /**
     * {@inheritDoc}
     */
	public boolean addTenant(Credentials credentials, Tenant tenant) throws VidyoWrapException {
		return VidyoSuperUtil.addTenant(credentials, tenant);
	}
	
    /**
     * {@inheritDoc}
     */
	public boolean delTenant(Credentials credentials, Integer tenantId) throws VidyoWrapException {
		return VidyoSuperUtil.delTenant(credentials, tenantId);
	}
	
    /**
     * {@inheritDoc}
     */
	public boolean setTenant(Credentials credentials, Tenant tenant) throws VidyoWrapException {
		return VidyoSuperUtil.setTenant(credentials, tenant);
	}
	
    /**
     * {@inheritDoc}
     */
	public Tenant getTenant(Credentials credentials, Integer tenantId) throws VidyoWrapException {
		return VidyoSuperUtil.getTenant(credentials, tenantId);
	}
	
    /**
     * {@inheritDoc}
     */
	public List<Tenant> getTenantList(Credentials credentials, SearchFilter filter, String tenantName, String tenantURL)
			throws VidyoWrapException {
		return VidyoSuperUtil.getTenantList(credentials, filter, tenantName, tenantURL);
	}
	
    /**
     * {@inheritDoc}
     */
	public List<Member> getMemberList(Credentials credentials, String pin, String area, int index, int limit) 
			throws VidyoWrapException {
		List<Member> result = new ArrayList<Member>();
		if(StringUtil.hasText(area) && area.equals("participants")) {
			result.addAll(VidyoUserUtil.getRoomMember(credentials, null, pin, index));
		} else {
			SearchFilter filter = new SearchFilter(EntityType.Member, index, limit);
			result.addAll(VidyoUserUtil.search(credentials, filter));
		}
		Collections.sort(result);
		return result;
	}
	
	/*****************************************************************************
	 *                           For Super Web Service
	 *****************************************************************************/
		
    /**
     * {@inheritDoc}
     */
	public String addTenantForWs(Credentials credentials, Tenant tenant) {
		try {
			return String.valueOf(addTenant(credentials, tenant));
		} catch (VidyoWrapException e) {
			log.warn(e.getMessage());
			return e.getMessage();
		}
	}
	
    /**
     * {@inheritDoc}
     */
	public String delTenantForWs(Credentials credentials, Integer tenantId) {
		if(tenantId == null)
			return "tenantId is null !";
		try {
			return String.valueOf(delTenant(credentials, tenantId));
		} catch (VidyoWrapException e) {
			log.warn(e.getMessage());
			return e.getMessage();
		}
	}
	
    /**
     * {@inheritDoc}
     */
	public String setTenantForWs(Credentials credentials, Integer tenantId, Tenant tenant) {
		try {
			tenant.setRemotId(tenantId);
			return String.valueOf(setTenant(credentials, tenant));
		} catch (VidyoWrapException e) {
			log.warn(e.getMessage());
			return e.getMessage();
		} catch (Exception e) {
			log.warn(e.getMessage());
			return e.getMessage();
		}
	}
	
    /**
     * {@inheritDoc}
     */
	public Tenant getTenantForWs(Credentials credentials, Integer tenantId) {
		try {
			return getTenant(credentials, tenantId);
		} catch (VidyoWrapException e) {
			log.warn(e.getMessage());
		}
		return null;
	}
	
	/**
     * {@inheritDoc}
     */
	public List<Tenant> getTenantListForWs(Credentials credentials, SearchFilter filter, String tenantName, String tenantURL) {
		try {
			return getTenantList(credentials, filter, tenantName, tenantURL);
		} catch (VidyoWrapException e) {
			log.warn(e.getWrap().toString() + e.getMessage());
			return new ArrayList<Tenant>();
		}
	}
	
	/*****************************************************************************
	 *                           For User Web Service
	 *****************************************************************************/
	
    /**
     * {@inheritDoc}
     */
	public Response joinRoomForWs(Credentials credentials, String pin, int conferenceID){
		ResponseBuilder builder = null;
		try {
			builder = Response.ok(VidyoUserUtil.joinRoom(credentials, pin, conferenceID));
		} catch (VidyoWrapException e) {
			builder = Response.ok(e.getMessage() + " E :" + e.getWrap().toString());
		}
		return builder.build();
	}
	
    /**
     * {@inheritDoc}
     */
	public Response leaveRoomForWs(Credentials credentials, String pin, int conferenceID, int entityID){
		ResponseBuilder builder = null;
		try {
			builder = Response.ok(VidyoUserUtil.leaveRoom(credentials, pin, conferenceID, entityID));
		} catch (VidyoWrapException e) {
			builder = Response.ok(e.getMessage());
		}
		return builder.build();
	}
	
    /**
     * {@inheritDoc}
     */
	public Response invitMemberForWs(Credentials credentials, String pin, int conferenceID, int entityID){
		ResponseBuilder builder = null;
		try {
			builder = Response.ok(VidyoUserUtil.invitMember(credentials, pin,
					conferenceID, String.valueOf(entityID)));
		} catch (VidyoWrapException e) {
			builder = Response.ok(e.getMessage());
		}
		return builder.build();
	}
	
    /**
     * {@inheritDoc}
     */
	public List<Member> getMemberListForWs(Credentials credentials, String pin, String area, int index, int limit) {
		try {
			return getMemberList(credentials, pin, area, index, limit);
		} catch (VidyoWrapException e) {
			return new ArrayList<Member>();
		}
	}

    /**
     * {@inheritDoc}
     */
	public Member getMemberForWs(Credentials credentials, String area) {
		if(StringUtil.hasText(area) && area.equals("participants")) {
			return null;
		} else {
			try {
				return VidyoUserUtil.getMyAccount(credentials);
			} catch (VidyoWrapException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getEndpointForWs(Credentials credentials, String area) {
		if(StringUtil.hasText(area) && area.equals("participants")) {
			return null;
		} else {
			try {
				return VidyoUserUtil.getEndpointStatus(credentials);
			} catch (VidyoWrapException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("deprecation")
	public String getLinkUrlForWs(Credentials credentials, String area) {
		if(StringUtil.hasText(area) && area.equals("participants")) {
			return null;
		} else {
			return VidyoUserUtil.synchroLoginUrlForDeskTopClient(credentials);
		}
	}
	
	/**
     * {@inheritDoc}
     */
	public List<Member> getMyContactsForWs(Credentials credentials) {
		SearchFilter filter = null;//new SearchFilter(EntityType.Member);
		try {
			return VidyoUserUtil.getMyContacts(credentials, filter);
		} catch (VidyoWrapException e) {
			return new ArrayList<Member>();
		}
	}
	
	/**
     * {@inheritDoc}
     */
	public Response addMyContactsForWs(Credentials credentials, int entityId) {
		ResponseBuilder builder = null;
		try {
			builder = Response.ok(VidyoUserUtil.addToMyContacts(credentials, entityId));
		} catch (VidyoWrapException e) {
			builder = Response.ok(e.getMessage());
		}
		return builder.build();
	}

	/**
     * {@inheritDoc}
     */
	public Response delMyContactsForWs(Credentials credentials, int entityId) {
		ResponseBuilder builder = null;
		try {
			builder = Response.ok(VidyoUserUtil.removeFromMyContacts(credentials, entityId));
		} catch (VidyoWrapException e) {
			builder = Response.ok(e.getMessage());
		}
		return builder.build();
	}

	@Override
	@GET
	@Path("/user/list")
	public List<Member> getMemberLists(@QueryParam("") Credentials credentials,
			@QueryParam("") SearchFilter filter) {
		List<Member> result = new ArrayList<Member>();
	
			try {
				result.addAll(VidyoUserUtil.search(credentials, new SearchFilter()));
			} catch (VidyoWrapException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		Collections.sort(result);
		return result;
	}

//	@Override
//	@GET
//	@Path("/user/list/all")
//	public List<Member> getMemberLists(@QueryParam("") Credentials credentials) {
//		// TODO Auto-generated method stub
//		try {
//			return VidyoUserUtil.getMyContacts(credentials, null);
//		} catch (VidyoWrapException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
}
