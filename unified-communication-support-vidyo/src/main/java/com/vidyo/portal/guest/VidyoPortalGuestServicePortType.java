package com.vidyo.portal.guest;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2013-01-05T16:43:30.819+08:00
 * Generated source version: 2.7.0
 * 
 */
@WebService(targetNamespace = "http://portal.vidyo.com/guest", name = "VidyoPortalGuestServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface VidyoPortalGuestServicePortType {

    @WebResult(name = "GuestJoinConferenceResponse", targetNamespace = "http://portal.vidyo.com/guest", partName = "parameter")
    @WebMethod(action = "guestJoinConference")
    public GuestJoinConferenceResponse guestJoinConference(
        @WebParam(partName = "parameter", name = "GuestJoinConferenceRequest", targetNamespace = "http://portal.vidyo.com/guest")
        GuestJoinConferenceRequest parameter
    ) throws RoomIsFullFault_Exception, GeneralFault_Exception, InvalidArgumentFault_Exception, AllLinesInUseFault_Exception, ConferenceLockedFault_Exception, ResourceNotAvailableFault_Exception, WrongPinFault_Exception;

    @WebResult(name = "LinkEndpointToGuestResponse", targetNamespace = "http://portal.vidyo.com/guest", partName = "parameter")
    @WebMethod(action = "linkEndpointToGuest")
    public LinkEndpointToGuestResponse linkEndpointToGuest(
        @WebParam(partName = "parameter", name = "LinkEndpointToGuestRequest", targetNamespace = "http://portal.vidyo.com/guest")
        LinkEndpointToGuestRequest parameter
    ) throws GeneralFault_Exception, InvalidArgumentFault_Exception, AccessRestrictedFault_Exception;

    @WebResult(name = "LogInAsGuestResponse", targetNamespace = "http://portal.vidyo.com/guest", partName = "parameter")
    @WebMethod(action = "logInAsGuest")
    public LogInAsGuestResponse logInAsGuest(
        @WebParam(partName = "parameter", name = "LogInAsGuestRequest", targetNamespace = "http://portal.vidyo.com/guest")
        LogInAsGuestRequest parameter
    ) throws RoomIsFullFault_Exception, GeneralFault_Exception, InvalidArgumentFault_Exception, ResourceNotAvailableFault_Exception;
}
