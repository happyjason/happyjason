package com.ammob.communication.vidyo.service.impl;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ammob.communication.core.authentication.principal.Credentials;
import com.ammob.communication.core.util.HttpClientUtil;
import com.ammob.communication.vidyo.exception.VidyoWrapException;
import com.ammob.communication.vidyo.model.Member;
import com.ammob.communication.vidyo.model.SearchFilter;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.service.VidyoManager;
import com.ammob.communication.vidyo.service.VidyoService;
import com.vidyo.portal.user.v1_1.LogInResponse;

public class VidyoManagerImplTest {
	
	private static final Log log = LogFactory.getLog(VidyoManagerImplTest.class);
	
    private VidyoManager manager = null;
    private VidyoService service = null;
    private Tenant tenant = null;
    private Credentials userCredentials = null;
    private Credentials superCredentials = null;
    private final JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
    
    @Before
    public void setUp() {
        manager = new VidyoManagerImpl();
        service = new VidyoManagerImpl();
        
        tenant = new Tenant("WDYY-API-TEST");
        tenant.setUrl("test.seekoom.com");
        tenant.setExtensionPrefix("021");
        tenant.setVidyoManager(1);
        
        userCredentials = new Credentials("hotmob", "121212", "http://v.seekoom.com");
        superCredentials = new Credentials("super", "WdyyVidyo", "http://bj.vidyo.com");
        //superCredentials = new Credentials("super", "seek00m", "http://zj.seekoom.com");
        factoryBean.getInInterceptors().add(new LoggingInInterceptor());
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
        factoryBean.setResourceClasses(VidyoManagerImpl.class);
        factoryBean.setAddress("http://localhost:9000");
        factoryBean.create();
    }

    @After
    public void tearDown() {
        manager = null;
        service = null;
    }
    
    @Ignore
    public void testAddTenant(){
    	try {
    		assertTrue(manager.addTenant(superCredentials, tenant));
		} catch (VidyoWrapException e) {
			log.info(e.getMessage());
			assertNull(e);
		}
    }
    
    @Ignore
    public void testDelTenant(){
    	try {
    		List<Tenant> result = manager.getTenantList(superCredentials, new SearchFilter(), tenant.getName(), "");
    		assertTrue(manager.delTenant(superCredentials, result.get(0).getRemotId()));
		} catch (VidyoWrapException e) {
			log.info(e.getMessage());
			assertNull(e);
		}
    }
    
    @Ignore
    public void testGetTenant(){
    	try {
    		List<Tenant> result = manager.getTenantList(superCredentials, new SearchFilter(), tenant.getName(), "");
    		assertNotNull(manager.getTenant(superCredentials, result.get(0).getRemotId()));
		} catch (VidyoWrapException e) {
			log.info(e.getMessage());
			assertNull(e);
		}
    }
    
    @Ignore
	public void testGetTenantList() {
    	try {
    		List<Tenant> result = manager.getTenantList(superCredentials, new SearchFilter(), "", "");
    		for(Tenant tenant : result){
    			log.info(tenant.getName());
    		}
		} catch (VidyoWrapException e) {
			log.info(e.getMessage());
			assertNull(e);
		}
    }
    
    @Ignore
    public void testAddTenantForWs(){
    	try {
    		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
    		formparams.add(new BasicNameValuePair("name", tenant.getName()));
    		formparams.add(new BasicNameValuePair("url", tenant.getUrl()));
    		formparams.add(new BasicNameValuePair("extensionPrefix", String.valueOf(tenant.getExtensionPrefix())));
    		formparams.add(new BasicNameValuePair("vidyoManager", String.valueOf(tenant.getVidyoManager())));
			String result = HttpClientUtil.Put("http://localhost:9000/vidyo/tenant?username=super&password=WdyyVidyo&url=http://bj.vidyo.com", formparams);
			log.info(result);
		} catch (Exception e) {
			log.info(e.getMessage());
			assertNull(e);
		}
    }
    
    @Test
	public void testSetTenantForWs() {
    	try {
    		List<Tenant> tenants = manager.getTenantList(superCredentials, new SearchFilter(), tenant.getName(), "");
    		Tenant _tenant = tenants.get(0);
    		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
    		//formparams.add(new BasicNameValuePair("remotId", String.valueOf(tenant.getRemotId())));
    		formparams.add(new BasicNameValuePair("name", tenant.getName()));
    		formparams.add(new BasicNameValuePair("url", tenant.getUrl()));
    		formparams.add(new BasicNameValuePair("extensionPrefix", "120"));
    		formparams.add(new BasicNameValuePair("vidyoManager", String.valueOf(tenant.getVidyoManager())));
			String result = HttpClientUtil.Post("http://localhost:9000/vidyo/tenant/" + _tenant.getRemotId() + "?username=super&password=WdyyVidyo&url=http://bj.vidyo.com", formparams);
			log.info(result);
		} catch (Exception e) {
			log.info(e.getMessage());
			assertNull(e);
		}
    }
    
    @Ignore
	public void testDelTenantForWs() {
    	try {
    		List<Tenant> tenants = manager.getTenantList(superCredentials, new SearchFilter(), tenant.getName(), "");
    		Tenant _tenant = tenants.get(0);
			String result = HttpClientUtil.Delete("http://localhost:9000/vidyo/tenant/" + _tenant.getRemotId() + "?username=super&password=WdyyVidyo&url=http://bj.vidyo.com");
			log.info(result);
		} catch (Exception e) {
			log.info(e.getMessage());
			assertNull(e);
		}
    }
    
    @Test
	public void testGetTenantForWs() {
    	try {
    		List<Tenant> tenants = manager.getTenantList(superCredentials, new SearchFilter(), tenant.getName(), "");
    		Tenant _tenant = tenants.get(0);
			String result = HttpClientUtil.Get("http://localhost:9000/vidyo/tenant/" + _tenant.getRemotId() + "?username=super&password=WdyyVidyo&url=http://bj.vidyo.com");
			log.info(result);
		} catch (Exception e) {
			log.info(e.getMessage());
			assertNull(e);
		}
    }
    
    @Ignore
	public void testGetTenantListForWs() {
    	try {
			String result = HttpClientUtil.Get("http://localhost:9000/vidyo/tenant?username=super&password=WdyyVidyo&url=http://bj.vidyo.com&tenantName=bjvidyocom");
			log.info(result);
		} catch (Exception e) {
			log.info(e.getMessage());
			assertNull(e);
		}
    }
    
    @Ignore
    public void testGetMyContactsForWs() {
    	ObjectMapper mapper = new ObjectMapper();
    	List<Member> dd = service.getMyContactsForWs(userCredentials);
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
