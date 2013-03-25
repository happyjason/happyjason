package com.vidyo.portal.user.v1_1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2013-01-05T17:33:17.632+08:00
 * Generated source version: 2.7.0
 * 
 */
@WebService(targetNamespace = "http://portal.vidyo.com/user/v1_1", name = "VidyoPortalUserServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface VidyoPortalUserServicePortType {

    @WebResult(name = "GetInviteContentResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "getInviteContent")
    public GetInviteContentResponse getInviteContent(
        @WebParam(partName = "parameter", name = "GetInviteContentRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        GetInviteContentRequest parameter
    ) throws NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "ResumeRecordingResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "resumeRecording")
    public ResumeRecordingResponse resumeRecording(
        @WebParam(partName = "parameter", name = "ResumeRecordingRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        ResumeRecordingRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "AddToMyContactsResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "addToMyContacts")
    public AddToMyContactsResponse addToMyContacts(
        @WebParam(partName = "parameter", name = "AddToMyContactsRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        AddToMyContactsRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "GetPortalVersionResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "getPortalVersion")
    public GetPortalVersionResponse getPortalVersion(
        @WebParam(partName = "parameter", name = "GetPortalVersionRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        GetPortalVersionRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "LeaveConferenceResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "leaveConference")
    public LeaveConferenceResponse leaveConference(
        @WebParam(partName = "parameter", name = "LeaveConferenceRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        LeaveConferenceRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "StartRecordingResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "startRecording")
    public StartRecordingResponse startRecording(
        @WebParam(partName = "parameter", name = "StartRecordingRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        StartRecordingRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, ControlMeetingFault_Exception, ResourceNotAvailableFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "SearchByEmailResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "searchByEmail")
    public SearchByEmailResponse searchByEmail(
        @WebParam(partName = "parameter", name = "SearchByEmailRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        SearchByEmailRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "LinkEndpointResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "linkEndpoint")
    public LinkEndpointResponse linkEndpoint(
        @WebParam(partName = "parameter", name = "LinkEndpointRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        LinkEndpointRequest parameter
    ) throws AccessRestrictedFault_Exception, SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "RemoveRoomURLResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "removeRoomURL")
    public RemoveRoomURLResponse removeRoomURL(
        @WebParam(partName = "parameter", name = "RemoveRoomURLRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        RemoveRoomURLRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "GetEntityByEntityIDResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "getEntityByEntityID")
    public GetEntityByEntityIDResponse getEntityByEntityID(
        @WebParam(partName = "parameter", name = "GetEntityByEntityIDRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        GetEntityByEntityIDRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "JoinIPCConferenceResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "joinIPCConference")
    public JoinIPCConferenceResponse joinIPCConference(
        @WebParam(partName = "parameter", name = "JoinIPCConferenceRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        JoinIPCConferenceRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, ConferenceLockedFault_Exception, GeneralFault_Exception, WrongPINFault_Exception;

    @WebResult(name = "PauseRecordingResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "pauseRecording")
    public PauseRecordingResponse pauseRecording(
        @WebParam(partName = "parameter", name = "PauseRecordingRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        PauseRecordingRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "InviteToConferenceResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "inviteToConference")
    public InviteToConferenceResponse inviteToConference(
        @WebParam(partName = "parameter", name = "InviteToConferenceRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        InviteToConferenceRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "GetRoomProfileResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "getRoomProfile")
    public GetRoomProfileResponse getRoomProfile(
        @WebParam(partName = "parameter", name = "GetRoomProfileRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        GetRoomProfileRequest parameter
    ) throws NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "LogOutResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "logOut")
    public LogOutResponse logOut(
        @WebParam(partName = "parameter", name = "LogOutRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        LogOutRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "MyEndpointStatusResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "myEndpointStatus")
    public MyEndpointStatusResponse myEndpointStatus(
        @WebParam(partName = "parameter", name = "MyEndpointStatusRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        MyEndpointStatusRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "SearchMyContactsResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "searchMyContacts")
    public SearchMyContactsResponse searchMyContacts(
        @WebParam(partName = "parameter", name = "SearchMyContactsRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        SearchMyContactsRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "GetWebcastURLResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "getWebcastURL")
    public GetWebcastURLResponse getWebcastURL(
        @WebParam(partName = "parameter", name = "GetWebcastURLRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        GetWebcastURLRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "RemoveWebcastPINResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "removeWebcastPIN")
    public RemoveWebcastPINResponse removeWebcastPIN(
        @WebParam(partName = "parameter", name = "RemoveWebcastPINRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        RemoveWebcastPINRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "CreateWebcastPINResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "createWebcastPIN")
    public CreateWebcastPINResponse createWebcastPIN(
        @WebParam(partName = "parameter", name = "CreateWebcastPINRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        CreateWebcastPINRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "StartVideoResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "startVideo")
    public StartVideoResponse startVideo(
        @WebParam(partName = "parameter", name = "StartVideoRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        StartVideoRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "DeleteRoomResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "deleteRoom")
    public DeleteRoomResponse deleteRoom(
        @WebParam(partName = "parameter", name = "DeleteRoomRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        DeleteRoomRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "GetEntityByRoomKeyResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "getEntityByRoomKey")
    public GetEntityByRoomKeyResponse getEntityByRoomKey(
        @WebParam(partName = "parameter", name = "GetEntityByRoomKeyRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        GetEntityByRoomKeyRequest parameter
    ) throws NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "RemoveWebcastURLResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "removeWebcastURL")
    public RemoveWebcastURLResponse removeWebcastURL(
        @WebParam(partName = "parameter", name = "RemoveWebcastURLRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        RemoveWebcastURLRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "StopRecordingResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "stopRecording")
    public StopRecordingResponse stopRecording(
        @WebParam(partName = "parameter", name = "StopRecordingRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        StopRecordingRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "JoinConferenceResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "joinConference")
    public JoinConferenceResponse joinConference(
        @WebParam(partName = "parameter", name = "JoinConferenceRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        JoinConferenceRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, ConferenceLockedFault_Exception, GeneralFault_Exception, WrongPINFault_Exception;

    @WebResult(name = "DirectCallResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "directCall")
    public DirectCallResponse directCall(
        @WebParam(partName = "parameter", name = "DirectCallRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        DirectCallRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "RemoveRoomPINResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "removeRoomPIN")
    public RemoveRoomPINResponse removeRoomPIN(
        @WebParam(partName = "parameter", name = "RemoveRoomPINRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        RemoveRoomPINRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "CreateWebcastURLResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "createWebcastURL")
    public CreateWebcastURLResponse createWebcastURL(
        @WebParam(partName = "parameter", name = "CreateWebcastURLRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        CreateWebcastURLRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "LogInResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "logIn")
    public LogInResponse logIn(
        @WebParam(partName = "parameter", name = "LogInRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        LogInRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "RemoveModeratorPINResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "removeRoomModeratorPIN")
    public RemoveModeratorPINResponse removeModeratorPIN(
        @WebParam(partName = "parameter", name = "RemoveModeratorPINRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        RemoveModeratorPINRequest parameter
    ) throws ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "CreateRoomURLResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "createRoomURL")
    public CreateRoomURLResponse createRoomURL(
        @WebParam(partName = "parameter", name = "CreateRoomURLRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        CreateRoomURLRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "UpdatePasswordResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "updatePassword")
    public UpdatePasswordResponse updatePassword(
        @WebParam(partName = "parameter", name = "UpdatePasswordRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        UpdatePasswordRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "UpdateLanguageResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "updateLanguage")
    public UpdateLanguageResponse updateLanguage(
        @WebParam(partName = "parameter", name = "UpdateLanguageRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        UpdateLanguageRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "MuteAudioResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "muteAudio")
    public MuteAudioResponse muteAudio(
        @WebParam(partName = "parameter", name = "MuteAudioRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        MuteAudioRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "CreateRoomResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "createRoom")
    public CreateRoomResponse createRoom(
        @WebParam(partName = "parameter", name = "CreateRoomRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        CreateRoomRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "GetUserNameResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "getUserName")
    public GetUserNameResponse getUserName(
        @WebParam(partName = "parameter", name = "GetUserNameRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        GetUserNameRequest parameter
    ) throws NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "SetMemberModeResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "setMemberMode")
    public SetMemberModeResponse setMemberMode(
        @WebParam(partName = "parameter", name = "SetMemberModeRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        SetMemberModeRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "GetRecordingProfilesResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "getRecordingProfiles")
    public GetRecordingProfilesResponse getRecordingProfiles(
        @WebParam(partName = "parameter", name = "GetRecordingProfilesRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        GetRecordingProfilesRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "SetRoomProfileResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "setRoomProfile")
    public SetRoomProfileResponse setRoomProfile(
        @WebParam(partName = "parameter", name = "SetRoomProfileRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        SetRoomProfileRequest parameter
    ) throws NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "MyAccountResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "myAccount")
    public MyAccountResponse myAccount(
        @WebParam(partName = "parameter", name = "MyAccountRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        MyAccountRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "GetParticipantsResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "getParticipants")
    public GetParticipantsResponse getParticipants(
        @WebParam(partName = "parameter", name = "GetParticipantsRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        GetParticipantsRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "RemoveRoomProfileResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "removeRoomProfile")
    public RemoveRoomProfileResponse removeRoomProfile(
        @WebParam(partName = "parameter", name = "RemoveRoomProfileRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        RemoveRoomProfileRequest parameter
    ) throws NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "GetRoomProfilesResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "getRoomProfiles")
    public GetRoomProfilesResponse getRoomProfiles(
        @WebParam(partName = "parameter", name = "GetRoomProfilesRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        java.lang.Object parameter
    ) throws NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "UnmuteAudioResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "unmuteAudio")
    public UnmuteAudioResponse unmuteAudio(
        @WebParam(partName = "parameter", name = "UnmuteAudioRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        UnmuteAudioRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "UnlockRoomResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "unlockRoom")
    public UnlockRoomResponse unlockRoom(
        @WebParam(partName = "parameter", name = "UnlockRoomRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        UnlockRoomRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "StopVideoResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "stopVideo")
    public StopVideoResponse stopVideo(
        @WebParam(partName = "parameter", name = "StopVideoRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        StopVideoRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "LockRoomResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "lockRoom")
    public LockRoomResponse lockRoom(
        @WebParam(partName = "parameter", name = "LockRoomRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        LockRoomRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "CreateModeratorPINResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "createRoomModeratorPIN")
    public CreateModeratorPINResponse createModeratorPIN(
        @WebParam(partName = "parameter", name = "CreateModeratorPINRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        CreateModeratorPINRequest parameter
    ) throws ControlMeetingFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception, InvalidModeratorPINFormatFault_Exception;

    @WebResult(name = "SearchByEntityIDResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "searchByEntityID")
    public SearchByEntityIDResponse searchByEntityID(
        @WebParam(partName = "parameter", name = "SearchByEntityIDRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        SearchByEntityIDRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "RemoveFromMyContactsResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "removeFromMyContacts")
    public RemoveFromMyContactsResponse removeFromMyContacts(
        @WebParam(partName = "parameter", name = "RemoveFromMyContactsRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        RemoveFromMyContactsRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "SearchResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "search")
    public SearchResponse search(
        @WebParam(partName = "parameter", name = "SearchRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        SearchRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;

    @WebResult(name = "CreateRoomPINResponse", targetNamespace = "http://portal.vidyo.com/user/v1_1", partName = "parameter")
    @WebMethod(action = "createRoomPIN")
    public CreateRoomPINResponse createRoomPIN(
        @WebParam(partName = "parameter", name = "CreateRoomPINRequest", targetNamespace = "http://portal.vidyo.com/user/v1_1")
        CreateRoomPINRequest parameter
    ) throws SeatLicenseExpiredFault_Exception, NotLicensedFault_Exception, InvalidArgumentFault_Exception, GeneralFault_Exception;
}