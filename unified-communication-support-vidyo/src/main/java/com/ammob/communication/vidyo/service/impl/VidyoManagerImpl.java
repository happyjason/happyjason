package com.ammob.communication.vidyo.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.WebService;
import javax.xml.ws.BindingProvider;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

import com.ammob.communication.vidyo.service.VidyoManager;
import com.vidyo.portal.admin.v1_1.GetRoomsRequest;
import com.vidyo.portal.admin.v1_1.GetRoomsResponse;
import com.vidyo.portal.admin.v1_1.InviteToConferenceRequest;
import com.vidyo.portal.admin.v1_1.InviteToConferenceResponse;
import com.vidyo.portal.admin.v1_1.VidyoPortalAdminService;
import com.vidyo.portal.admin.v1_1.VidyoPortalAdminServicePortType;
import com.vidyo.portal.user.v1_1.GeneralFault_Exception;
import com.vidyo.portal.user.v1_1.InvalidArgumentFault_Exception;
import com.vidyo.portal.user.v1_1.LogInRequest;
import com.vidyo.portal.user.v1_1.LogInResponse;
import com.vidyo.portal.user.v1_1.NotLicensedFault_Exception;
import com.vidyo.portal.user.v1_1.SeatLicenseExpiredFault_Exception;
import com.vidyo.portal.user.v1_1.VidyoPortalUserService;
import com.vidyo.portal.user.v1_1.VidyoPortalUserServicePortType;

@Service("vidyoManager")
@WebService(serviceName = "VidyoService", endpointInterface = "com.ammob.communication.vidyo.service.VidyoManager")
public class VidyoManagerImpl implements VidyoManager {
	
    /**
     * {@inheritDoc}
     */
	public void synchroVidyoDeskTopClientLogin(String protalUrl, LogInResponse logInResponse,
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
				} catch (IOException ex) {
					throw ex;
				} catch (RuntimeException ex) {
					httpget.abort();
					throw ex;
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
	}
	
    /**
     * {@inheritDoc}
     */
	public VidyoPortalUserServicePortType getUserClient(String protalUrl, String username, String password) throws MalformedURLException {
		VidyoPortalUserService service = new VidyoPortalUserService(new URL(protalUrl + "/services/v1_1/VidyoPortalUserService?wsdl"));
		VidyoPortalUserServicePortType client = service.getVidyoPortalUserServicePort();
		BindingProvider bp = (BindingProvider)client;
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
		return client;
	}

    /**
     * {@inheritDoc}
     */
	public VidyoPortalAdminServicePortType getAdminClient(String protalUrl, String username, String password) throws MalformedURLException {
		VidyoPortalAdminService service = new VidyoPortalAdminService(new URL(protalUrl + "/services/v1_1/VidyoPortalAdminService?wsdl"));
		VidyoPortalAdminServicePortType client = service.getVidyoPortalAdminServicePort();
		BindingProvider bp = (BindingProvider)client;
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
		return client;
	}
	
	public LogInResponse login(String protalUrl, String username,
			String password) throws MalformedURLException, SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception {
		return getUserClient(protalUrl, username, password).logIn(new LogInRequest());
	}
	
	public GetRoomsResponse getRooms(String protalUrl, String username,
			String password) throws MalformedURLException, com.vidyo.portal.admin.v1_1.GeneralFault_Exception, com.vidyo.portal.admin.v1_1.NotLicensedFault_Exception, com.vidyo.portal.admin.v1_1.InvalidArgumentFault_Exception {
		return getAdminClient(protalUrl, username, password).getRooms(new GetRoomsRequest());
	}
	
	public InviteToConferenceResponse invite(String protalUrl, String username,
			String password) throws MalformedURLException, com.vidyo.portal.admin.v1_1.GeneralFault_Exception, com.vidyo.portal.admin.v1_1.NotLicensedFault_Exception, com.vidyo.portal.admin.v1_1.InvalidArgumentFault_Exception {
		InviteToConferenceRequest inviteRequest = new InviteToConferenceRequest();
		inviteRequest.setConferenceID(32);// room id
		inviteRequest.setEntityID(5);// member id
		return getAdminClient(protalUrl, username, password).inviteToConference(inviteRequest);
	}
	
	public static void main(String[] args) {
		VidyoManager vidyo = new VidyoManagerImpl();
		try {
			vidyo.invite("http://v.seekoom.com", "hotmob", "121212");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (com.vidyo.portal.admin.v1_1.GeneralFault_Exception e) {
			e.printStackTrace();
		} catch (com.vidyo.portal.admin.v1_1.NotLicensedFault_Exception e) {
			e.printStackTrace();
		} catch (com.vidyo.portal.admin.v1_1.InvalidArgumentFault_Exception e) {
			e.printStackTrace();
		}
	}
}