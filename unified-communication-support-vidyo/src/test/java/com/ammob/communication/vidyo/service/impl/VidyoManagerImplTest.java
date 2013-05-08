package com.ammob.communication.vidyo.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ammob.communication.core.model.User;
import com.ammob.communication.vidyo.model.Member;
import com.vidyo.portal.user.v1_1.LogInResponse;

public class VidyoManagerImplTest {
	
    private VidyoManagerImpl manager = null;
    private User user = null;
    
    private String url = "http://v.seekoom.com";
    private String username = "hotmob";
    private String password = "121212";
    
    @Before
    public void setUp() {
        manager = new VidyoManagerImpl();
        user = new User(username);
        user.setPassword(password);
        user.setWebsite(url);
    }

    @After
    public void tearDown() {
        manager = null;
    }
    
    @Test
	public void testGetMemberListWs() {
		ObjectMapper mapper = new ObjectMapper();
		List<Member> dd = manager.getMemberListForWs(user, null, "participants", 5, 20);
		for(Member member : dd){
			System.out.println(member.getDisplayName() + " : " + member.getMemberStatus());
		}
		try {
			System.out.println(mapper.writeValueAsString(dd)); //返回字符串
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    @Ignore
	public void testJoinRoomWs() {
		ObjectMapper mapper = new ObjectMapper();
		Response dd = manager.joinRoomForWs(user, null, 474);
		try {
			System.out.println(mapper.writeValueAsString(dd)); //返回字符串
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    @Ignore
    public void testGetMyContactsForWs() {
    	ObjectMapper mapper = new ObjectMapper();
    	List<Member> dd = manager.getMyContactsForWs(user);
    	for(Member member : dd){
			System.out.println(member.getDisplayName() + " : " + member.getMemberStatus());
		}
		try {
			System.out.println(mapper.writeValueAsString(dd)); //返回字符串
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	public boolean synchroLoginForDeskTopClient(String protalUrl, LogInResponse logInResponse,
			String username) {
		String url = "http://m.seekoom.com/services/api/vidyo/user/client";
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
}
