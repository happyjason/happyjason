package com.ammob.communication.vidyo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.stereotype.Service;

import com.ammob.communication.core.model.User;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.exception.VidyoWrapException;
import com.ammob.communication.vidyo.model.Member;
import com.ammob.communication.vidyo.model.SearchFilter;
import com.ammob.communication.vidyo.model.SearchFilter.EntityType;
import com.ammob.communication.vidyo.service.VidyoManager;
import com.ammob.communication.vidyo.service.VidyoService;
import com.ammob.communication.vidyo.util.VidyoUserUtil;

@Service("vidyoManager")
@WebService(serviceName = "VidyoService", endpointInterface = "com.ammob.communication.vidyo.service.VidyoManager")
public class VidyoManagerImpl implements VidyoManager, VidyoService {

    /**
     * {@inheritDoc}
     */
	public List<Member> getMemberList(User user, String pin, String area, int index, int limit) 
			throws VidyoWrapException {
		List<Member> result = new ArrayList<Member>();
		if(StringUtil.hasText(area) && area.equals("participants")) {
			result.addAll(VidyoUserUtil.getRoomMember(user, null, pin, index));
		} else {
			SearchFilter filter = new SearchFilter(EntityType.Member, index, limit);
			result.addAll(VidyoUserUtil.search(user, filter));
		}
		Collections.sort(result);
		return result;
	}
	
    /**
     * {@inheritDoc}
     */
	public Response joinRoomForWs(User user, String pin, int conferenceID){
		ResponseBuilder builder = null;
		try {
			builder = Response.ok(VidyoUserUtil.joinRoom(user, pin, conferenceID));
		} catch (VidyoWrapException e) {
			builder = Response.ok(e.getMessage() + " E :" + e.getWrap().toString());
		}
		return builder.build();
	}
	
    /**
     * {@inheritDoc}
     */
	public Response leaveRoomForWs(User user, String pin, int conferenceID, int entityID){
		ResponseBuilder builder = null;
		try {
			builder = Response.ok(VidyoUserUtil.leaveRoom(user, pin, conferenceID, entityID));
		} catch (VidyoWrapException e) {
			builder = Response.ok(e.getMessage());
		}
		return builder.build();
	}
	
    /**
     * {@inheritDoc}
     */
	public Response invitMemberForWs(User user, String pin, int conferenceID, int entityID){
		ResponseBuilder builder = null;
		try {
			builder = Response.ok(VidyoUserUtil.invitMember(user, pin,
					conferenceID, String.valueOf(entityID)));
		} catch (VidyoWrapException e) {
			builder = Response.ok(e.getMessage());
		}
		return builder.build();
	}
	
    /**
     * {@inheritDoc}
     */
	public List<Member> getMemberListForWs(User user, String pin, String area, int index, int limit) {
		try {
			return getMemberList(user, pin, area, index, limit);
		} catch (VidyoWrapException e) {
			return new ArrayList<Member>();
		}
	}

    /**
     * {@inheritDoc}
     */
	public Member getMemberForWs(User user, String area) {
		if(StringUtil.hasText(area) && area.equals("participants")) {
			return null;
		} else {
			try {
				return VidyoUserUtil.getMyAccount(user);
			} catch (VidyoWrapException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getEndpointForWs(User user, String area) {
		if(StringUtil.hasText(area) && area.equals("participants")) {
			return null;
		} else {
			try {
				return VidyoUserUtil.getEndpointStatus(user);
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
	public String getLinkUrlForWs(User user, String area) {
		if(StringUtil.hasText(area) && area.equals("participants")) {
			return null;
		} else {
			return VidyoUserUtil.synchroLoginUrlForDeskTopClient(user);
		}
	}
	
	/**
     * {@inheritDoc}
     */
	public List<Member> getMyContactsForWs(User user) {
		SearchFilter filter = null;//new SearchFilter(EntityType.Member);
		try {
			return VidyoUserUtil.getMyContacts(user, filter);
		} catch (VidyoWrapException e) {
			return new ArrayList<Member>();
		}
	}
	
	/**
     * {@inheritDoc}
     */
	public Response addMyContactsForWs(User user, int entityId) {
		ResponseBuilder builder = null;
		try {
			builder = Response.ok(VidyoUserUtil.addToMyContacts(user, entityId));
		} catch (VidyoWrapException e) {
			builder = Response.ok(e.getMessage());
		}
		return builder.build();
	}

	/**
     * {@inheritDoc}
     */
	public Response delMyContactsForWs(User user, int entityId) {
		ResponseBuilder builder = null;
		try {
			builder = Response.ok(VidyoUserUtil.removeFromMyContacts(user, entityId));
		} catch (VidyoWrapException e) {
			builder = Response.ok(e.getMessage());
		}
		return builder.build();
	}
}
