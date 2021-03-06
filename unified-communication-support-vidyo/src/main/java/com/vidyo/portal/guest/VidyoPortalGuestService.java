package com.vidyo.portal.guest;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2013-01-05T16:43:30.824+08:00
 * Generated source version: 2.7.0
 * 
 */
@WebServiceClient(name = "VidyoPortalGuestService", 
                  wsdlLocation = "http://210.14.78.26/services/VidyoPortalGuestService?wsdl",
                  targetNamespace = "http://portal.vidyo.com/guest") 
public class VidyoPortalGuestService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://portal.vidyo.com/guest", "VidyoPortalGuestService");
    public final static QName VidyoPortalGuestServicePort = new QName("http://portal.vidyo.com/guest", "VidyoPortalGuestServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://210.14.78.26/services/VidyoPortalGuestService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(VidyoPortalGuestService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://210.14.78.26/services/VidyoPortalGuestService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public VidyoPortalGuestService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public VidyoPortalGuestService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public VidyoPortalGuestService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public VidyoPortalGuestService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public VidyoPortalGuestService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public VidyoPortalGuestService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns VidyoPortalGuestServicePortType
     */
    @WebEndpoint(name = "VidyoPortalGuestServicePort")
    public VidyoPortalGuestServicePortType getVidyoPortalGuestServicePort() {
        return super.getPort(VidyoPortalGuestServicePort, VidyoPortalGuestServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns VidyoPortalGuestServicePortType
     */
    @WebEndpoint(name = "VidyoPortalGuestServicePort")
    public VidyoPortalGuestServicePortType getVidyoPortalGuestServicePort(WebServiceFeature... features) {
        return super.getPort(VidyoPortalGuestServicePort, VidyoPortalGuestServicePortType.class, features);
    }

}
