package com.ammob.communication.cas.service;

import java.io.IOException;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import com.ammob.communication.cas.service.impl.TicketManagerImpl;

public class AuthorizationServiceTest {
	private final JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
	private final String username = "低";
	private final String password = "121212";
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
        factoryBean.getInInterceptors().add(new LoggingInInterceptor());
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
        factoryBean.setResourceClasses(TicketManagerImpl.class);
        factoryBean.setAddress("http://localhost:9000");
        factoryBean.create();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * {@link com.ammob.communication.cas.service.TicketService#getGrantTicket(java.lang.String, java.lang.String)} 的测试方法。
	 */
	@Ignore
	public void testGetGrantTicket() throws Exception {
		HttpMethod method = Post("http://localhost:9000/authorization/tickets/", 
				new NameValuePair[] {new NameValuePair("username", username), 
				new NameValuePair("password", password)});
		try {
			System.out.println(method.getStatusCode());
			//getUserInfo("http://localhost:8080");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	protected static void getUserInfo(String username, String password, String urlPrefix) throws Exception {
		String response = "", st = "";
		HttpMethod method = Post(urlPrefix + "/services/api/authorization/tickets/", new NameValuePair[] {
				new NameValuePair("username", username), 
				new NameValuePair("password", password), 
				new NameValuePair("url", "http://v.seekoom.com")});
//		if(method != null && method.getStatusCode() != 404){
//			String responseStr = getResponseHeader(method);
//			if(responseStr.contains("/") && !responseStr.endsWith("/") && !responseStr.startsWith("/")) {
//				String [] result = getResponseHeader(method).split("/");
//				String tgt = result != null && result.length > 1 ? result[result.length-1] : "";
//				System.out.println("tgt value : " + tgt);
//				st = getResponseBody(Post(urlPrefix + "/services/api/authorization/tickets/" + tgt, new NameValuePair[] {new NameValuePair("service", urlPrefix)}));
//				System.out.println(st);
//				response = getResponseBody(Post(urlPrefix + "/serviceValidate", new NameValuePair[] {new NameValuePair("service", urlPrefix), new NameValuePair("ticket", st)}));
//				System.out.println(response.trim());
//			} else {
//				System.out.println("responseStr is : " + responseStr);
//			}
//		} else {
//			System.out.println("method is null or 404");
//		}
	}
	
	private static void Get(String url) throws Exception {  
        HttpClient client = new HttpClient();  
        GetMethod method = new GetMethod(url);
        int statusCode = client.executeMethod(method);  
        if (statusCode != HttpStatus.SC_OK) {  
            System.err.println("Method failed: " + method.getStatusLine());  
        }  
        byte[] responseBody = method.getResponseBody();  
        System.out.println(new String(responseBody));  
    }
	
	private static HttpMethod Post(String url, NameValuePair[] nvp) throws Exception {  
        HttpClient client = new HttpClient();  
        PostMethod method = new PostMethod(url);
        method.setRequestBody(nvp);
        int statusCode = client.executeMethod(method);
        if (statusCode != HttpStatus.SC_OK && statusCode != HttpStatus.SC_CREATED) {
            System.err.println("Method failed: " + method.getStatusLine());
        }
        Cookie[] cookies = client.getState().getCookies();
        for (Cookie cookie : cookies)
        	System.out.println("Cookie Name = " + cookie.getName() + ", Value = " + cookie.getValue() + ", Domain = " + cookie.getDomain() + ", Path = " + cookie.getPath() + ", ExpiryDate = " + cookie.getExpiryDate());
        return method;
    }
	
	protected static HttpMethod Put(String url, NameValuePair[] nvp) throws Exception {
		HttpClient client = new HttpClient();  
        PutMethod method = new PutMethod(url);
        method.setQueryString(nvp);
        int statusCode = client.executeMethod(method);
        if (statusCode != HttpStatus.SC_OK && statusCode != HttpStatus.SC_CREATED) {
            System.err.println("Method failed: " + method.getStatusLine());
        }
        Cookie[] cookies = client.getState().getCookies();
        for (Cookie cookie : cookies)
        	System.out.println("Cookie Name = " + cookie.getName() + ", Value = " + cookie.getValue() + ", Domain = " + cookie.getDomain() + ", Path = " + cookie.getPath() + ", ExpiryDate = " + cookie.getExpiryDate());
        return method;
	}
	
	protected static void Delete(String url) throws Exception {
        HttpClient client = new HttpClient();  
        DeleteMethod method = new DeleteMethod(url);
        int statusCode = client.executeMethod(method);  
        if (statusCode != HttpStatus.SC_OK) {  
            System.err.println("Method failed: " + method.getStatusLine());  
        }  
        byte[] responseBody = method.getResponseBody();  
        System.out.println(new String(responseBody));  
	}
	
	private static String getResponseHeader(HttpMethod method) {
		return method.getResponseHeader("Location").getValue();
	}
	
	private static String getResponseBody(HttpMethod method) throws IOException {
		 byte[] responseBody = method.getResponseBody();
		 return new String(responseBody);
	}

	public static void main(String[] args) {
		try {
			AuthorizationServiceTest.getUserInfo("test3", "111111", "http://localhost:8080");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		// 测试注销
		//AuthorizationServiceTest.Delete("http://localhost:8080/services/api/authorization/tickets/TGT-272567-Lf3py4597ZnkX6m04naexlwdNgxrmdEIAehkCJBbbOHbVPGtXM-authentication");
	}
}
