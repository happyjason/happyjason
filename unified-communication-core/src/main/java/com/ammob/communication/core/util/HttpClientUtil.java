package com.ammob.communication.core.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	private static final Log log = LogFactory.getLog(HttpClientUtil.class);
	
	private static HttpClient customerHttpClient;
	private static final String CHARSET = "UTF-8";
	private static final String USER_AGENT_MOZILLA = "Mozilla/5.0(Linux;U;Android 2.2.1;en-us;Nexus One Build.FRG83) "
        	+ "AppleWebKit/553.1(KHTML,like Gecko) Version/4.0 Mobile Safari/533.1";
	
	/**
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String Get(String url) throws Exception {
		try {
	        HttpGet request =new HttpGet(url);
	        HttpResponse response = getHttpClient().execute(request);
            if(response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new RuntimeException("Server Error, response : " + response.getStatusLine());
            }
	        return new BasicResponseHandler().handleResponse(response);
        } catch (UnsupportedEncodingException e) {
        	log.warn(e.getMessage());
            return null;
        } catch (ClientProtocolException e) {
        	log.warn(e.getMessage());
            return null;
        } catch (IOException e) {
            throw new RuntimeException("连接失败", e);
        }
    }
	
	/**
	 * 
	 * @param url
	 * @param formparams
	 * @return
	 * @throws Exception
	 */
	public static String Post(String url, List<NameValuePair> formparams) throws Exception {
        try {
            UrlEncodedFormEntity entity =new UrlEncodedFormEntity(formparams, CHARSET);// 编码参数
            
            HttpPost request =new HttpPost(url);// 创建POST请求
            request.setEntity(entity);// 发送请求
            
            HttpResponse response = getHttpClient().execute(request);
            if(response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            	throw new RuntimeException("Server Error, response : " + response.getStatusLine());
            }
            HttpEntity resEntity =  response.getEntity();
            return (resEntity ==null) ? null : EntityUtils.toString(resEntity, CHARSET);
        } catch (UnsupportedEncodingException e) {
        	log.warn(e.getMessage());
            return null;
        } catch (ClientProtocolException e) {
        	log.warn(e.getMessage());
            return null;
        } catch (IOException e) {
            throw new RuntimeException("连接失败", e);
        }
    }
	
	/**
	 * 
	 * @param url
	 * @param formparams
	 * @return
	 * @throws Exception
	 */
	public static String Put(String url, List<NameValuePair> formparams) throws Exception {
        try {
            UrlEncodedFormEntity entity =new UrlEncodedFormEntity(formparams, CHARSET);// 编码参数
            
            HttpPut request =new HttpPut(url);// 创建POST请求
            request.setEntity(entity);// 发送请求
            
            HttpClient client = getHttpClient();
            HttpResponse response = client.execute(request);
            if(response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            	throw new RuntimeException("Server Error, response : " + response.getStatusLine());
            }
            HttpEntity resEntity =  response.getEntity();
            return (resEntity ==null) ?null : EntityUtils.toString(resEntity, CHARSET);
        } catch (UnsupportedEncodingException e) {
        	log.warn(e.getMessage());
            return null;
        } catch (ClientProtocolException e) {
        	log.warn(e.getMessage());
            return null;
        } catch (IOException e) {
            throw new RuntimeException("连接失败", e);
        }
	}
	
	/**
	 * 
	 * @param url
	 * @throws Exception
	 */
	public static String Delete(String url) throws Exception {
		try {
	        HttpDelete request =new HttpDelete(url);
	        HttpResponse response = getHttpClient().execute(request);
            if(response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new RuntimeException("Server Error, response : " + response.getStatusLine());
            }
	        return new BasicResponseHandler().handleResponse(response);
        } catch (UnsupportedEncodingException e) {
        	log.warn(e.getMessage());
            return null;
        } catch (ClientProtocolException e) {
        	log.warn(e.getMessage());
            return null;
        } catch (IOException e) {
            throw new RuntimeException("连接失败", e);
        }
	}
	
	public static synchronized HttpClient getHttpClient() {
        if (null == customerHttpClient) {
            HttpParams params =new BasicHttpParams();
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, CHARSET);
            HttpProtocolParams.setUseExpectContinue(params, true);
            HttpProtocolParams.setUserAgent(params, USER_AGENT_MOZILLA);
            HttpConnectionParams.setConnectionTimeout(params, 5000);							// 连接超时
            HttpConnectionParams.setSoTimeout(params, 150000); 									// 请求超时
            SchemeRegistry schReg = new SchemeRegistry(); 										// 设置我HttpClient支持HTTP和HTTPS两种模式
            schReg.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
            schReg.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
            ClientConnectionManager connectionManager = new PoolingClientConnectionManager(schReg);	// 使用线程安全的连接管理来创建HttpClient, 可设置连接池超时
            customerHttpClient = new DefaultHttpClient(connectionManager, params);
        }
        return customerHttpClient;
    }
}
