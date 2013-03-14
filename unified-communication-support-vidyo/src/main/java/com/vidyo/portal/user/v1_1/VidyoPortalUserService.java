package com.vidyo.portal.user.v1_1;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2013-01-05T17:33:17.642+08:00
 * Generated source version: 2.7.0
 * 
 */
@WebServiceClient(name = "VidyoPortalUserService", 
                  wsdlLocation = "http://v.seekoom.com/services/v1_1/VidyoPortalUserService?wsdl",
                  targetNamespace = "http://portal.vidyo.com/user/v1_1") 
public class VidyoPortalUserService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://portal.vidyo.com/user/v1_1", "VidyoPortalUserService");
    public final static QName VidyoPortalUserServicePort = new QName("http://portal.vidyo.com/user/v1_1", "VidyoPortalUserServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://v.seekoom.com/services/v1_1/VidyoPortalUserService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(VidyoPortalUserService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://v.seekoom.com/services/v1_1/VidyoPortalUserService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public VidyoPortalUserService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public VidyoPortalUserService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public VidyoPortalUserService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public VidyoPortalUserService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public VidyoPortalUserService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public VidyoPortalUserService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns VidyoPortalUserServicePortType
     */
    @WebEndpoint(name = "VidyoPortalUserServicePort")
    public VidyoPortalUserServicePortType getVidyoPortalUserServicePort() {
        return super.getPort(VidyoPortalUserServicePort, VidyoPortalUserServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns VidyoPortalUserServicePortType
     */
    @WebEndpoint(name = "VidyoPortalUserServicePort")
    public VidyoPortalUserServicePortType getVidyoPortalUserServicePort(WebServiceFeature... features) {
        return super.getPort(VidyoPortalUserServicePort, VidyoPortalUserServicePortType.class, features);
    }

}
