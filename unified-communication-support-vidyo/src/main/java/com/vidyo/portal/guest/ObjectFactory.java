
package com.vidyo.portal.guest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.vidyo.portal.guest.LogInAsGuestRequest;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.vidyo.portal.guest package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ErrorMessage_QNAME = new QName("http://portal.vidyo.com/guest", "ErrorMessage");
    private final static QName _OK_QNAME = new QName("http://portal.vidyo.com/guest", "OK");
    private final static QName _LogInAsGuestResponseProxyaddress_QNAME = new QName("http://portal.vidyo.com/guest", "proxyaddress");
    private final static QName _LogInAsGuestResponseLoctag_QNAME = new QName("http://portal.vidyo.com/guest", "loctag");
    private final static QName _LogInAsGuestResponseVmaddress_QNAME = new QName("http://portal.vidyo.com/guest", "vmaddress");
    private final static QName _GuestJoinConferenceRequestPin_QNAME = new QName("http://portal.vidyo.com/guest", "pin");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.vidyo.portal.guest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ResourceNotAvailableFault }
     * 
     */
    public ResourceNotAvailableFault createResourceNotAvailableFault() {
        return new ResourceNotAvailableFault();
    }

    /**
     * Create an instance of {@link LogInAsGuestRequest }
     * 
     */
    public LogInAsGuestRequest createLogInAsGuestRequest() {
        return new LogInAsGuestRequest();
    }

    /**
     * Create an instance of {@link ConferenceLockedFault }
     * 
     */
    public ConferenceLockedFault createConferenceLockedFault() {
        return new ConferenceLockedFault();
    }

    /**
     * Create an instance of {@link LinkEndpointToGuestResponse }
     * 
     */
    public LinkEndpointToGuestResponse createLinkEndpointToGuestResponse() {
        return new LinkEndpointToGuestResponse();
    }

    /**
     * Create an instance of {@link WrongPinFault }
     * 
     */
    public WrongPinFault createWrongPinFault() {
        return new WrongPinFault();
    }

    /**
     * Create an instance of {@link LogInAsGuestResponse }
     * 
     */
    public LogInAsGuestResponse createLogInAsGuestResponse() {
        return new LogInAsGuestResponse();
    }

    /**
     * Create an instance of {@link GuestJoinConferenceRequest }
     * 
     */
    public GuestJoinConferenceRequest createGuestJoinConferenceRequest() {
        return new GuestJoinConferenceRequest();
    }

    /**
     * Create an instance of {@link AccessRestrictedFault }
     * 
     */
    public AccessRestrictedFault createAccessRestrictedFault() {
        return new AccessRestrictedFault();
    }

    /**
     * Create an instance of {@link InvalidArgumentFault }
     * 
     */
    public InvalidArgumentFault createInvalidArgumentFault() {
        return new InvalidArgumentFault();
    }

    /**
     * Create an instance of {@link LinkEndpointToGuestRequest }
     * 
     */
    public LinkEndpointToGuestRequest createLinkEndpointToGuestRequest() {
        return new LinkEndpointToGuestRequest();
    }

    /**
     * Create an instance of {@link GeneralFault }
     * 
     */
    public GeneralFault createGeneralFault() {
        return new GeneralFault();
    }

    /**
     * Create an instance of {@link RoomIsFullFault }
     * 
     */
    public RoomIsFullFault createRoomIsFullFault() {
        return new RoomIsFullFault();
    }

    /**
     * Create an instance of {@link GuestJoinConferenceResponse }
     * 
     */
    public GuestJoinConferenceResponse createGuestJoinConferenceResponse() {
        return new GuestJoinConferenceResponse();
    }

    /**
     * Create an instance of {@link AllLinesInUseFault }
     * 
     */
    public AllLinesInUseFault createAllLinesInUseFault() {
        return new AllLinesInUseFault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/guest", name = "ErrorMessage")
    public JAXBElement<String> createErrorMessage(String value) {
        return new JAXBElement<String>(_ErrorMessage_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/guest", name = "OK")
    public JAXBElement<String> createOK(String value) {
        return new JAXBElement<String>(_OK_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/guest", name = "proxyaddress", scope = LogInAsGuestResponse.class)
    public JAXBElement<String> createLogInAsGuestResponseProxyaddress(String value) {
        return new JAXBElement<String>(_LogInAsGuestResponseProxyaddress_QNAME, String.class, LogInAsGuestResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/guest", name = "loctag", scope = LogInAsGuestResponse.class)
    public JAXBElement<String> createLogInAsGuestResponseLoctag(String value) {
        return new JAXBElement<String>(_LogInAsGuestResponseLoctag_QNAME, String.class, LogInAsGuestResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/guest", name = "vmaddress", scope = LogInAsGuestResponse.class)
    public JAXBElement<String> createLogInAsGuestResponseVmaddress(String value) {
        return new JAXBElement<String>(_LogInAsGuestResponseVmaddress_QNAME, String.class, LogInAsGuestResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/guest", name = "pin", scope = GuestJoinConferenceRequest.class)
    public JAXBElement<String> createGuestJoinConferenceRequestPin(String value) {
        return new JAXBElement<String>(_GuestJoinConferenceRequestPin_QNAME, String.class, GuestJoinConferenceRequest.class, value);
    }

}
