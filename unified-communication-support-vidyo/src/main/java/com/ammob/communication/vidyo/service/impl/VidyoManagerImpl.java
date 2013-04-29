package com.ammob.communication.vidyo.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

import com.ammob.communication.core.model.User;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.model.Member;
import com.ammob.communication.vidyo.service.VidyoManager;
import com.ammob.communication.vidyo.service.VidyoService;
import com.vidyo.portal.admin.v1_1.AddRoomRequest;
import com.vidyo.portal.admin.v1_1.GetGroupRequest;
import com.vidyo.portal.admin.v1_1.GetMemberRequest;
import com.vidyo.portal.admin.v1_1.GetMemberResponse;
import com.vidyo.portal.admin.v1_1.GetRoomsRequest;
import com.vidyo.portal.admin.v1_1.GetRoomsResponse;
import com.vidyo.portal.admin.v1_1.Room;
import com.vidyo.portal.admin.v1_1.VidyoPortalAdminService;
import com.vidyo.portal.admin.v1_1.VidyoPortalAdminServicePortType;
import com.vidyo.portal.superapi.ListTenantsRequest;
import com.vidyo.portal.superapi.ListTenantsResponse;
import com.vidyo.portal.superapi.SingleTenantDataType;
import com.vidyo.portal.superapi.VidyoPortalSuperService;
import com.vidyo.portal.superapi.VidyoPortalSuperServicePortType;
import com.vidyo.portal.user.v1_1.ConferenceLockedFault_Exception;
import com.vidyo.portal.user.v1_1.ControlMeetingFault_Exception;
import com.vidyo.portal.user.v1_1.Entity;
import com.vidyo.portal.user.v1_1.Filter;
import com.vidyo.portal.user.v1_1.GeneralFault_Exception;
import com.vidyo.portal.user.v1_1.GetParticipantsRequest;
import com.vidyo.portal.user.v1_1.GetParticipantsResponse;
import com.vidyo.portal.user.v1_1.GetRoomProfileRequest;
import com.vidyo.portal.user.v1_1.GetUserNameRequest;
import com.vidyo.portal.user.v1_1.GetWebcastURLRequest;
import com.vidyo.portal.user.v1_1.InvalidArgumentFault_Exception;
import com.vidyo.portal.user.v1_1.InviteToConferenceRequest;
import com.vidyo.portal.user.v1_1.InviteToConferenceResponse;
import com.vidyo.portal.user.v1_1.JoinConferenceRequest;
import com.vidyo.portal.user.v1_1.JoinConferenceResponse;
import com.vidyo.portal.user.v1_1.LogInRequest;
import com.vidyo.portal.user.v1_1.LogInResponse;
import com.vidyo.portal.user.v1_1.NotLicensedFault_Exception;
import com.vidyo.portal.user.v1_1.ObjectFactory;
import com.vidyo.portal.user.v1_1.SearchRequest;
import com.vidyo.portal.user.v1_1.SearchResponse;
import com.vidyo.portal.user.v1_1.SeatLicenseExpiredFault_Exception;
import com.vidyo.portal.user.v1_1.VidyoPortalUserService;
import com.vidyo.portal.user.v1_1.VidyoPortalUserServicePortType;
import com.vidyo.portal.user.v1_1.WrongPINFault_Exception;

@Service("vidyoManager")
@WebService(serviceName = "VidyoService", endpointInterface = "com.ammob.communication.vidyo.service.VidyoManager")
public class VidyoManagerImpl implements VidyoManager, VidyoService {

	ObjectFactory userFactory = new ObjectFactory();
	
    /**
     * {@inheritDoc}
     */
	public boolean getVidyoAuthenticationState(String protalUrl, String username, String password) {
		try {
			LogInResponse logInResponse = getUserClient(protalUrl, username, password).logIn(new LogInRequest());
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
     * {@inheritDoc}
     */
	public boolean vidyoSynchroDeskTopClientLogin(String protalUrl, LogInResponse logInResponse,
			String username) {
		String url = "http://stunusa.vidyo.com/ws/user/SetEid.php";
		String _dummyUrl = "http://127.0.0.1:63457/dummy?url=" + url + 
			"&vm=" + logInResponse.getVmaddress().getValue() + 
			"&un=" + username + "&pak=" + logInResponse.getPak() + 
			"&portal=" + protalUrl + "/services&proxy=" + logInResponse.getProxyaddress() +
			"&showdialpad=yes&showstartmeeting=yes";
		System.out.println(_dummyUrl);
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(_dummyUrl);
		try {
			HttpResponse response = httpclient.execute(httpget);
			System.out.println(response.getStatusLine());
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
					System.out.println(reader.readLine());
					return true;
				} catch (IOException ex) {
					return false;
				} catch (RuntimeException ex) {
					httpget.abort();
					return false;
				} finally {
					instream.close();
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return true;
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
	private VidyoPortalUserServicePortType getUserClient(String protalUrl, String username, String password) throws MalformedURLException {
		VidyoPortalUserService service = new VidyoPortalUserService(new URL(protalUrl + "/services/v1_1/VidyoPortalUserService?wsdl"));
		VidyoPortalUserServicePortType client = service.getVidyoPortalUserServicePort();
		BindingProvider bp = (BindingProvider)client;
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
		return client;
	}
	
	/**
	 * vidyo portal admin service, webservice method
	 * 
	 * @param protalUrl
	 * @param username
	 * @param password
	 * @return
	 * @throws MalformedURLException
	 */
	private VidyoPortalAdminServicePortType getAdminClient(String protalUrl, String username, String password) throws MalformedURLException {
		VidyoPortalAdminService service = new VidyoPortalAdminService(new URL(protalUrl + "/services/v1_1/VidyoPortalAdminService?wsdl"));
		VidyoPortalAdminServicePortType client = service.getVidyoPortalAdminServicePort();
		BindingProvider bp = (BindingProvider)client;
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
		return client;
	}
	
	/**
	 * vidyo portal super service, webservice method
	 * 
	 * @param protalUrl
	 * @param username
	 * @param password
	 * @return
	 * @throws MalformedURLException
	 */
	private VidyoPortalSuperServicePortType getSuperClient(String protalUrl,
			String username, String password) throws MalformedURLException {
		VidyoPortalSuperService service = new VidyoPortalSuperService(new URL(protalUrl + "/services/VidyoPortalSuperService?wsdl"));
		VidyoPortalSuperServicePortType client = service.getVidyoPortalSuperServicePort();
		BindingProvider bp = (BindingProvider)client;
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
		return client;
	}
	
	private List<Entity> search(String protalUrl, String username, String password, int type, int index, int limit) {
		SearchRequest query = userFactory.createSearchRequest();
		Filter filter = userFactory.createFilter();
		filter.setStart(userFactory.createFilterStart(index));
		filter.setStart(userFactory.createFilterLimit(limit));
		switch(type){
		case 0:
			filter.setEntityType("Member");
			break;
		default:
			filter.setEntityType("Room");
			break;
		}
		query.setFilter(filter);
		try {
			return getUserClient(protalUrl, username, password).search(query).getEntity();
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
		}
		return new ArrayList<Entity>();
	}
	
	public LogInResponse login(String protalUrl, String username,
			String password) throws MalformedURLException, SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception {
		return getUserClient(protalUrl, username, password).logIn(new LogInRequest());
	}
	
	public GetRoomsResponse getRooms(String protalUrl, String username,
			String password) throws MalformedURLException, com.vidyo.portal.admin.v1_1.GeneralFault_Exception, com.vidyo.portal.admin.v1_1.NotLicensedFault_Exception, com.vidyo.portal.admin.v1_1.InvalidArgumentFault_Exception {
		return getAdminClient(protalUrl, username, password).getRooms(new GetRoomsRequest());
	}

    /**
     * {@inheritDoc}
     */
	public List<Member> getVidyoMemberList(User user, String area, int index, int limit) {
		List<Entity> result = null;
		if(area.equals("participants")) {
			GetParticipantsRequest request = userFactory.createGetParticipantsRequest();
			try {
				result = getUserClient(user.getWebsite(), user.getUsername(), 
						user.getPassword()).getParticipants(request).getEntity();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (SeatLicenseExpiredFault_Exception e) {
				e.printStackTrace();
			} catch (ControlMeetingFault_Exception e) {
				e.printStackTrace();
			} catch (NotLicensedFault_Exception e) {
				e.printStackTrace();
			} catch (InvalidArgumentFault_Exception e) {
				e.printStackTrace();
			} catch (GeneralFault_Exception e) {
				e.printStackTrace();
			}
		} else {
			result = search(user.getWebsite(), user.getUsername(), 
					user.getPassword(), 0, index, limit);
		}
		List<Member> response = new ArrayList<Member>();
		for(Entity entity : result) {
			Member member = new Member();
			member.setEntityID(entity.getEntityID());
			member.setDisplayName(entity.getDisplayName());
			member.setEmailAddress(entity.getEmailAddress().getValue());
			member.setMemberStatus(entity.getMemberStatus());
			member.setRoomStatus(entity.getRoomStatus());
			member.setIsInMyContacts(entity.isIsInMyContacts());
			response.add(member);
		}
		Collections.sort(response);
		return response;
	}
	
    /**
     * {@inheritDoc}
     */
	public boolean joinVidyoRoom(User user, int conferenceID){
		JoinConferenceRequest request = userFactory.createJoinConferenceRequest();
		request.setConferenceID(String.valueOf(conferenceID));
		try {
			JoinConferenceResponse response = getUserClient(user.getWebsite(), user.getUsername(), 
					user.getPassword()).joinConference(request);
			if(StringUtil.hasText(response.getOK()))
				return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SeatLicenseExpiredFault_Exception e) {
			e.printStackTrace();
		} catch (NotLicensedFault_Exception e) {
			e.printStackTrace();
		} catch (InvalidArgumentFault_Exception e) {
			e.printStackTrace();
		} catch (ConferenceLockedFault_Exception e) {
			e.printStackTrace();
		} catch (GeneralFault_Exception e) {
			e.printStackTrace();
		} catch (WrongPINFault_Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
    /**
     * {@inheritDoc}
     */
	public boolean invitVidyoMember(User user, int conferenceID, int entityID){
		InviteToConferenceRequest request = userFactory.createInviteToConferenceRequest();
		request.setConferenceID(String.valueOf(conferenceID));
		try {
			InviteToConferenceResponse response = getUserClient(user.getWebsite(), user.getUsername(), 
					user.getPassword()).inviteToConference(request);
			if(StringUtil.hasText(response.getOK()))
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
		} catch (ControlMeetingFault_Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		User user = new User("hotmob");
		user.setPassword("121212");
		user.setWebsite("http://v.seekoom.com");
		VidyoManager vidyo = new VidyoManagerImpl();

		//vidyo.invite("http://v.seekoom.com", "hotmob", "121212");
//		ListTenantsResponse  dd = vidyo.getSuperClient("http://bj.vidyo.com", "super", "WdyyVidyo").getListOfTenants(new ListTenantsRequest());
//		List<SingleTenantDataType> singleTenantDataTypes = dd.getTenant();
//		for(SingleTenantDataType s:singleTenantDataTypes){
//			System.out.println("VidyoManagerImpl.main()"+s.getTenantURL());
//			System.out.println("VidyoManagerImpl.main()"+s.getTenantName());
//		}
		
//		VidyoPortalUserServicePortType  dd = vidyo.getUserClient("http://v.seekoom.com", "hotmob", "121212");
		
//		GetUserNameRequest g = new GetUserNameRequest();
//	
//		System.out.println("VidyoManagerImpl.main()"+dd.getUserName(g).getRealUserName());
//		
//		
//		System.out.println("VidyoManagerImpl.main()"+dd.getUserName(new GetUserNameRequest()).getRealUserName());
//		
		
//		VidyoPortalAdminServicePortType  dd = vidyo.getAdminClient("http://v.seekoom.com", "hotmob", "121212");
//	
//		System.out.println("VidyoManagerImpl.main()"+dd.addRoom(new AddRoomRequest().setRoom(new Room)));
//		
		
	}
}