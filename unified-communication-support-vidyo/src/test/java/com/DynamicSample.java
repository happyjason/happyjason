package com;


import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingMessageInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ammob.communication.vidyo.service.BaseManagerTestCase;

public class DynamicSample extends BaseManagerTestCase {
	
	private Log log = LogFactory.getLog(DynamicSample.class);
	private static final String API_URL_PRIFIX = "http://180.166.8.94";
	private static final String API_SERVICE_ADMIN = "/services/VidyoPortalAdminService?wsdl";
    private static final QName SERVICE_NAME = new QName("http://portal.vidyo.com/admin", "VidyoPortalAdminServiceBinding");
    private static final QName OP_NAME = new QName("http://portal.vidyo.com/admin", "getMember");
    
	@Autowired
	private JaxWsDynamicClientFactory clientFactory;
	
	@Test
    public void testGetMember() throws Exception {
		Client client = clientFactory.createClient(API_URL_PRIFIX + API_SERVICE_ADMIN);
		
    	HTTPConduit httpConduit = (HTTPConduit)client.getConduit();
    	
    	httpConduit.getAuthorization().setUserName("hotmob");
    	httpConduit.getAuthorization().setPassword("121212");
    	HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
    	httpClientPolicy.setConnectionTimeout(36000);
    	httpClientPolicy.setAllowChunking(false);
    	httpClientPolicy.setReceiveTimeout(32000);
    	httpConduit.setClient(httpClientPolicy);
    	
    	Map<String, String> dd = new HashMap<String, String>();
    	dd.put("memberID", "1");
    	log.info("invoke !!");
		Object[] result = null;
		try {
	    	Object order = Thread.currentThread().getContextClassLoader().loadClass("com.ammob.billing.vidyo.Member").newInstance();
	    	Method m1 = order.getClass().getMethod("setMemberID", String.class);
	    	m1.invoke(order, "1");
	    		
//	    	Member order = new Member("1");
			result = client.invoke("getMember", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	System.out.println(result[0]);
	}

    public static void main(String[] args) throws Exception {
    	JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
    	Client client = clientFactory.createClient(API_URL_PRIFIX + API_SERVICE_ADMIN);
    	
    	HTTPConduit httpConduit = (HTTPConduit)client.getConduit();
    	httpConduit.getAuthorization().setUserName("hotmob");
    	httpConduit.getAuthorization().setPassword("121212");
    	HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
    	httpClientPolicy.setConnectionTimeout(36000);
    	httpClientPolicy.setAllowChunking(false);
    	httpClientPolicy.setReceiveTimeout(32000);
    	httpConduit.setClient(httpClientPolicy);
    	
    	Endpoint endpoint = client.getEndpoint();
    	ServiceInfo serviceInfo = endpoint.getService().getServiceInfos().get(0);
    	BindingInfo binding = serviceInfo.getBinding(SERVICE_NAME);
    	BindingOperationInfo boi = binding.getOperation(OP_NAME);
    	BindingMessageInfo inputMessageInfo = boi.getInput();
    	// !?!
    	List<MessagePartInfo> parts = inputMessageInfo.getMessageParts();
    	MessagePartInfo partInfo = parts.get(0); // Input class is Order
        Class<?> partClass = partInfo.getTypeClass();
        System.out.println(partClass.getCanonicalName()); // GetAgentDetails
        Object inputObject = partClass.newInstance();
        
        PropertyDescriptor custProperty = new PropertyDescriptor("memberID", partClass);
        custProperty.getWriteMethod().invoke(inputObject, Integer.valueOf(1));
        
        Object[] result = client.invoke(OP_NAME, inputObject);
        System.out.println("The order ID is " + result[0]);
	}
}
