package com.ammob.communication.vidyo.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import com.ammob.communication.core.authentication.principal.Credentials;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.exception.VidyoWrapException;
import com.ammob.communication.vidyo.model.Member;
import com.ammob.communication.vidyo.model.SearchFilter;
import com.ammob.communication.vidyo.model.SearchFilter.Dir;
import com.vidyo.portal.user.v1_1.AddToMyContactsRequest;
import com.vidyo.portal.user.v1_1.AddToMyContactsResponse;
import com.vidyo.portal.user.v1_1.ConferenceLockedFault_Exception;
import com.vidyo.portal.user.v1_1.ControlMeetingFault_Exception;
import com.vidyo.portal.user.v1_1.Entity;
import com.vidyo.portal.user.v1_1.Filter;
import com.vidyo.portal.user.v1_1.GeneralFault_Exception;
import com.vidyo.portal.user.v1_1.GetParticipantsRequest;
import com.vidyo.portal.user.v1_1.GetParticipantsResponse;
import com.vidyo.portal.user.v1_1.InvalidArgumentFault_Exception;
import com.vidyo.portal.user.v1_1.InviteToConferenceRequest;
import com.vidyo.portal.user.v1_1.InviteToConferenceResponse;
import com.vidyo.portal.user.v1_1.JoinConferenceRequest;
import com.vidyo.portal.user.v1_1.JoinConferenceResponse;
import com.vidyo.portal.user.v1_1.LeaveConferenceRequest;
import com.vidyo.portal.user.v1_1.LeaveConferenceResponse;
import com.vidyo.portal.user.v1_1.LinkEndpointRequest;
import com.vidyo.portal.user.v1_1.LinkEndpointResponse;
import com.vidyo.portal.user.v1_1.LogInRequest;
import com.vidyo.portal.user.v1_1.LogInResponse;
import com.vidyo.portal.user.v1_1.MyAccountRequest;
import com.vidyo.portal.user.v1_1.MyAccountResponse;
import com.vidyo.portal.user.v1_1.MyEndpointStatusRequest;
import com.vidyo.portal.user.v1_1.MyEndpointStatusResponse;
import com.vidyo.portal.user.v1_1.NotLicensedFault_Exception;
import com.vidyo.portal.user.v1_1.ObjectFactory;
import com.vidyo.portal.user.v1_1.RemoveFromMyContactsRequest;
import com.vidyo.portal.user.v1_1.RemoveFromMyContactsResponse;
import com.vidyo.portal.user.v1_1.SearchMyContactsRequest;
import com.vidyo.portal.user.v1_1.SearchMyContactsResponse;
import com.vidyo.portal.user.v1_1.SearchRequest;
import com.vidyo.portal.user.v1_1.SearchResponse;
import com.vidyo.portal.user.v1_1.SeatLicenseExpiredFault_Exception;
import com.vidyo.portal.user.v1_1.SortDir;
import com.vidyo.portal.user.v1_1.VidyoPortalUserService;
import com.vidyo.portal.user.v1_1.VidyoPortalUserServicePortType;
import com.vidyo.portal.user.v1_1.WrongPINFault_Exception;

public class VidyoUserUtil {
	
	private static ObjectFactory userFactory = new ObjectFactory();
	
	/**
	 * Add To My Contacts
	 * @param user
	 * @param entityId
	 * @return
	 * @throws VidyoWrapException
	 */
	public static boolean addToMyContacts(Credentials credentials, int entityId) 
			throws VidyoWrapException {
		AddToMyContactsRequest request = userFactory.createAddToMyContactsRequest();
		request.setEntityID(String.valueOf(entityId));
		try {
			AddToMyContactsResponse response = getClient(credentials.getUrl(), 
					credentials.getUsername(), credentials.getPassword()).addToMyContacts(request);
			if(StringUtil.hasText(response.getOK()))
				return true;
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (SeatLicenseExpiredFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		}
		return false;
	}
	
	/**
	 * Remove From My Contacts
	 * @param user
	 * @param entityId
	 * @return
	 * @throws VidyoWrapException
	 */
	public static boolean removeFromMyContacts(Credentials credentials, int entityId) 
			throws VidyoWrapException {
		RemoveFromMyContactsRequest request = userFactory.createRemoveFromMyContactsRequest();
		request.setEntityID(String.valueOf(entityId));
		try {
			RemoveFromMyContactsResponse response = getClient(credentials.getUrl(), 
					credentials.getUsername(), credentials.getPassword()).removeFromMyContacts(
							request);
			if(StringUtil.hasText(response.getOK()))
				return true;
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (SeatLicenseExpiredFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		}
		return false;
	}
	
	/**
	 * Get My Contacts
	 * @param user
	 * @param filter
	 * @return
	 * @throws VidyoWrapException
	 */
	public static List<Member> getMyContacts(Credentials credentials, SearchFilter filter)
			throws VidyoWrapException {
		SearchMyContactsRequest request = userFactory.createSearchMyContactsRequest();
		request.setFilter(convertFilter(filter));
		try {
			SearchMyContactsResponse response = getClient(credentials.getUrl(), 
					credentials.getUsername(), credentials.getPassword()).searchMyContacts(request);
			return convertMemberList(response.getEntity());
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (SeatLicenseExpiredFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		}
	}
	
	/**
	 * Get My Account
	 * @param user
	 * @return
	 * @throws VidyoWrapException
	 */
	public static Member getMyAccount(Credentials credentials)
			throws VidyoWrapException {
		MyAccountRequest request = userFactory.createMyAccountRequest();
		try {
			MyAccountResponse response = getClient(credentials.getUrl(), 
					credentials.getUsername(), credentials.getPassword()).myAccount(request);
			return convertMember(response.getEntity());
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (SeatLicenseExpiredFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		}
	}
	
	/**
	 * Get User Endpoint Status
	 * @param user
	 * @return
	 * @throws VidyoWrapException
	 */
	public static String getEndpointStatus(Credentials credentials) throws VidyoWrapException {
		MyEndpointStatusRequest request = userFactory.createMyEndpointStatusRequest();
		try {
			MyEndpointStatusResponse response = getClient(credentials.getUrl(), 
					credentials.getUsername(), credentials.getPassword()).myEndpointStatus(request);
			return response.getMemberStatus();
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (SeatLicenseExpiredFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		}
	}
	
	/**
	 * Join Room
	 * @param user
	 * @param conferenceID
	 * @return
	 * @throws VidyoWrapException 
	 * @throws MalformedURLException
	 * @throws SeatLicenseExpiredFault_Exception
	 * @throws NotLicensedFault_Exception
	 * @throws InvalidArgumentFault_Exception
	 * @throws ConferenceLockedFault_Exception
	 * @throws GeneralFault_Exception
	 * @throws WrongPINFault_Exception
	 */
	public static boolean joinRoom(Credentials credentials, String PIN, int conferenceID) throws VidyoWrapException {
		JoinConferenceRequest request = userFactory.createJoinConferenceRequest();
		request.setConferenceID(String.valueOf(conferenceID));
		request.setPIN(userFactory.createJoinConferenceRequestPIN(PIN));
		try {
			JoinConferenceResponse response = getClient(credentials.getUrl(), 
					credentials.getUsername(), credentials.getPassword()).joinConference(request);
			if(StringUtil.hasText(response.getOK()))
				return true;
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (SeatLicenseExpiredFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (ConferenceLockedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (WrongPINFault_Exception e) {
			throw new VidyoWrapException(e);
		}
		return false;
	}
	
	/**
	 * Leave Room
	 * @param user
	 * @param ModeratorPIN
	 * @param conferenceID
	 * @param entityID
	 * @return
	 * @throws VidyoWrapException 
	 * @throws MalformedURLException
	 * @throws SeatLicenseExpiredFault_Exception
	 * @throws ControlMeetingFault_Exception
	 * @throws NotLicensedFault_Exception
	 * @throws InvalidArgumentFault_Exception
	 * @throws GeneralFault_Exception
	 */
	public static boolean leaveRoom(Credentials credentials, String ModeratorPIN, int conferenceID, int entityID) 
			throws VidyoWrapException {
		LeaveConferenceRequest request = userFactory.createLeaveConferenceRequest();
		request.setConferenceID(String.valueOf(conferenceID));
		request.setModeratorPIN(userFactory.createLeaveConferenceRequestModeratorPIN(ModeratorPIN));
		request.setParticipantID(String.valueOf(entityID));
		try {
			LeaveConferenceResponse response = getClient(credentials.getUrl(), 
					credentials.getUsername(), credentials.getPassword()).leaveConference(request);
			if(StringUtil.hasText(response.getOK()))
				return true;
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (SeatLicenseExpiredFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (ControlMeetingFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		}
		return false;
	}
	
	/**
	 * Get Room Member List
	 * @param user
	 * @param filter
	 * @param ModeratorPIN
	 * @param conferenceID
	 * @return Member List
	 * @throws VidyoWrapException
	 */
	public static List<Member> getRoomMember(Credentials credentials, SearchFilter filter, String ModeratorPIN, int conferenceID)
			throws VidyoWrapException {
		GetParticipantsRequest request = userFactory.createGetParticipantsRequest();
		request.setModeratorPIN(userFactory.createGetParticipantsRequestModeratorPIN(ModeratorPIN));
		request.setFilter(convertFilter(filter));
		request.setConferenceID(String.valueOf(conferenceID));
		try {
			GetParticipantsResponse response = getClient(credentials.getUrl(), 
					credentials.getUsername(), credentials.getPassword()).getParticipants(request);
			return convertMemberList(response.getEntity());
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (SeatLicenseExpiredFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (ControlMeetingFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		}
	}
	
	/**
	 * Invit Member
	 * @param user
	 * @param conferenceID
	 * @param invitObject, String to Url : Num to entityID.
	 * @return
	 * @throws VidyoWrapException 
	 * @throws MalformedURLException
	 * @throws SeatLicenseExpiredFault_Exception
	 * @throws ControlMeetingFault_Exception
	 * @throws NotLicensedFault_Exception
	 * @throws InvalidArgumentFault_Exception
	 * @throws GeneralFault_Exception
	 */
	public static boolean invitMember(Credentials credentials, String ModeratorPIN, int conferenceID, String invitObject) 
			throws VidyoWrapException {
		InviteToConferenceRequest request = userFactory.createInviteToConferenceRequest();
		request.setConferenceID(String.valueOf(conferenceID));
		request.setModeratorPIN(userFactory.createInviteToConferenceRequestModeratorPIN(ModeratorPIN));
		if(StringUtil.isNumeric(invitObject)) {
			request.setEntityID(invitObject); // entityID
		} else {
			request.setInvite(invitObject); // Invit URL
		}
		try {
			InviteToConferenceResponse response = getClient(credentials.getUrl(), 
					credentials.getUsername(), credentials.getPassword()).inviteToConference(request);
			if(StringUtil.hasText(response.getOK()))
				return true;
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (SeatLicenseExpiredFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (ControlMeetingFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		}
		return false;
	}
	
	/**
	 * search
	 * @param user
	 * @param filter
	 * @return
	 * @throws VidyoWrapException
	 */
	public static List<Member> search(Credentials credentials, SearchFilter filter) throws VidyoWrapException {
		SearchRequest request = userFactory.createSearchRequest();
		request.setFilter(convertFilter(filter));
		try {
			SearchResponse response = getClient(credentials.getUrl(), 
					credentials.getUsername(), credentials.getPassword()).search(request);
			return convertMemberList(response.getEntity());
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (SeatLicenseExpiredFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		}
	}
	
	/**
	 * link user endpoint
	 * @param user
	 * @param endpointId
	 * @param vrIp
	 * @param clientType
	 * @return
	 * @throws VidyoWrapException
	 */
	public static Member linkEndpoint(Credentials credentials, String endpointId, String vrIp, String clientType) 
			throws VidyoWrapException {
		LinkEndpointRequest request = userFactory.createLinkEndpointRequest();
		request.setEID(endpointId);
		request.setVrIP(vrIp);
		request.setClientType(clientType);
		try {
			LinkEndpointResponse response = getClient(credentials.getUrl(), 
					credentials.getUsername(), credentials.getPassword()).linkEndpoint(request);
			return convertMember(response.getEntity());
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (SeatLicenseExpiredFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (Exception e) {
			throw new VidyoWrapException(e);
		}
	}
	
	/**
	 * custom client vidyo desktop client login
	 * @param protalUrl
	 * @param logInResponse
	 * @param username
	 */
	public static boolean getAuthenticationState(String protalUrl, String username, String password) {
		try {
			LogInResponse logInResponse = getClient(protalUrl, username, 
					password).logIn(new LogInRequest());
			if(logInResponse != null && StringUtil.hasText(logInResponse.getPak()))
				return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SeatLicenseExpiredFault_Exception e) {
			e.printStackTrace();
		} catch (NotLicensedFault_Exception e) {
			e.printStackTrace();
		} catch (InvalidArgumentFault_Exception e) {
			e.printStackTrace();
		} catch (GeneralFault_Exception e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * custom client synchro vidyo desktop client login url
	 * @deprecated
	 * @param protalUrl
	 * @param logInResponse
	 * @param username
	 */
	public static String synchroLoginUrlForDeskTopClient(Credentials credentials) {
		try {
			LogInResponse logInResponse = getClient(credentials.getUrl(), 
					credentials.getUsername(), credentials.getPassword()).logIn(new LogInRequest());
			String url = "http://m.seekoom.com/services/api/vidyo/client";
			return "http://127.0.0.1:63457/dummy?url=" + url + 
				"&vm=" + logInResponse.getVmaddress().getValue() + 
				"&un=" +  credentials.getUsername() + "&pak=" + logInResponse.getPak() + 
				"&portal=" + credentials.getUrl() + "/services&proxy=" + 
				logInResponse.getProxyaddress() + "&showdialpad=yes&showstartmeeting=yes";
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SeatLicenseExpiredFault_Exception e) {
			e.printStackTrace();
		} catch (NotLicensedFault_Exception e) {
			e.printStackTrace();
		} catch (InvalidArgumentFault_Exception e) {
			e.printStackTrace();
		} catch (GeneralFault_Exception e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * convert Filter to Vidyo Filter
	 * @param filter
	 * @return
	 */
	private static Filter convertFilter(SearchFilter filter){
		if(filter != null) {
			Filter vidyoFilter = userFactory.createFilter();
			if(StringUtil.hasText(filter.getDir())){
				if(filter.getDir().equals(Dir.ASC.toString())) {
					vidyoFilter.setDir(userFactory.createFilterDir(SortDir.ASC));
				} else if(filter.getDir().equals(Dir.DESC.toString())) {
					vidyoFilter.setDir(userFactory.createFilterDir(SortDir.DESC));
				}
			}
			vidyoFilter.setEntityType(filter.getEntityType());
			vidyoFilter.setLimit(userFactory.createFilterLimit(filter.getLimit()));
			vidyoFilter.setQuery(userFactory.createFilterQuery(filter.getQuery()));
			vidyoFilter.setSortBy(userFactory.createFilterSortBy(filter.getSortBy()));
			vidyoFilter.setStart(userFactory.createFilterStart(filter.getStart()));
			return vidyoFilter;
		} else {
			return null;
		}
	}
	
	/**
	 * convert entity to Member
	 * @param entity
	 * @return
	 */
	private static Member convertMember(Entity entity){
		Member member = new Member();
		if(entity != null) {
			member.setEntityID(entity.getEntityID());
			member.setDisplayName(entity.getDisplayName());
			member.setEmailAddress(entity.getEmailAddress().getValue());
			member.setMemberStatus(entity.getMemberStatus());
			member.setRoomStatus(entity.getRoomStatus());
			member.setIsInMyContacts(entity.isIsInMyContacts());
		}
		return member;
	}
	
	/**
	 * convert entity list to Member list
	 * @param entitys
	 * @return
	 */
	private static List<Member> convertMemberList(List<Entity> entitys){
		List<Member> result = new ArrayList<Member>();
		if(entitys != null) {
			for(Entity entity : entitys) {
				result.add(convertMember(entity));
			}
		}
		return result;
	}
	
	/**
	 * vidyo portal user service, packaging webservice method
	 * 
	 * @param protalUrl
	 * @param username
	 * @param password
	 * @return
	 * @throws MalformedURLException
	 */
	private static VidyoPortalUserServicePortType getClient(String protalUrl, String username,
			String password) throws MalformedURLException {
		VidyoPortalUserService service = new VidyoPortalUserService(new URL(protalUrl + 
				"/services/v1_1/VidyoPortalUserService?wsdl"));
		VidyoPortalUserServicePortType client = service.getVidyoPortalUserServicePort();
		BindingProvider bp = (BindingProvider)client;
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
		return client;
	}
}
