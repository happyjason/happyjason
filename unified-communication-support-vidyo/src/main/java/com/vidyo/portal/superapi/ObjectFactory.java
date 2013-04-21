
package com.vidyo.portal.superapi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.vidyo.portal.superapi package. 
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

    private final static QName _ErrorMessage_QNAME = new QName("http://portal.vidyo.com/superapi/", "ErrorMessage");
    private final static QName _OK_QNAME = new QName("http://portal.vidyo.com/superapi/", "OK");
    private final static QName _ListTenantsRequestStart_QNAME = new QName("http://portal.vidyo.com/superapi/", "start");
    private final static QName _ListTenantsRequestLimit_QNAME = new QName("http://portal.vidyo.com/superapi/", "limit");
    private final static QName _TenantDataTypeDescription_QNAME = new QName("http://portal.vidyo.com/superapi/", "description");
    private final static QName _TenantDataTypeEnableGuestLogin_QNAME = new QName("http://portal.vidyo.com/superapi/", "enableGuestLogin");
    private final static QName _TenantDataTypeDialinNumber_QNAME = new QName("http://portal.vidyo.com/superapi/", "dialinNumber");
    private final static QName _TenantDataTypeIpcAllowInbound_QNAME = new QName("http://portal.vidyo.com/superapi/", "ipcAllowInbound");
    private final static QName _TenantDataTypeIpcAllowOutbound_QNAME = new QName("http://portal.vidyo.com/superapi/", "ipcAllowOutbound");
    private final static QName _TenantDataTypeVidyoReplayUrl_QNAME = new QName("http://portal.vidyo.com/superapi/", "vidyoReplayUrl");
    private final static QName _TenantDataTypeVidyoMobileAllowed_QNAME = new QName("http://portal.vidyo.com/superapi/", "vidyoMobileAllowed");
    private final static QName _IpcAccessControlAccessMode_QNAME = new QName("http://portal.vidyo.com/superapi/", "accessMode");
    private final static QName _IpcAccessControlRouterID_QNAME = new QName("http://portal.vidyo.com/superapi/", "routerID");
    private final static QName _GetServiceComponentsDataRequestServiceComponentType_QNAME = new QName("http://portal.vidyo.com/superapi/", "serviceComponentType");
    private final static QName _GetLicenseDataRequestTenantId_QNAME = new QName("http://portal.vidyo.com/superapi/", "tenantId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.vidyo.portal.superapi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListTenantsResponse }
     * 
     */
    public ListTenantsResponse createListTenantsResponse() {
        return new ListTenantsResponse();
    }

    /**
     * Create an instance of {@link SingleTenantDataType }
     * 
     */
    public SingleTenantDataType createSingleTenantDataType() {
        return new SingleTenantDataType();
    }

    /**
     * Create an instance of {@link MissingArgumentFault }
     * 
     */
    public MissingArgumentFault createMissingArgumentFault() {
        return new MissingArgumentFault();
    }

    /**
     * Create an instance of {@link SaveDBRequest }
     * 
     */
    public SaveDBRequest createSaveDBRequest() {
        return new SaveDBRequest();
    }

    /**
     * Create an instance of {@link CreateTenantResponse }
     * 
     */
    public CreateTenantResponse createCreateTenantResponse() {
        return new CreateTenantResponse();
    }

    /**
     * Create an instance of {@link GetLicenseDataResponse }
     * 
     */
    public GetLicenseDataResponse createGetLicenseDataResponse() {
        return new GetLicenseDataResponse();
    }

    /**
     * Create an instance of {@link LicenseFeatureData }
     * 
     */
    public LicenseFeatureData createLicenseFeatureData() {
        return new LicenseFeatureData();
    }

    /**
     * Create an instance of {@link NotAuthorizedFault }
     * 
     */
    public NotAuthorizedFault createNotAuthorizedFault() {
        return new NotAuthorizedFault();
    }

    /**
     * Create an instance of {@link GetIpcDomainListRequest }
     * 
     */
    public GetIpcDomainListRequest createGetIpcDomainListRequest() {
        return new GetIpcDomainListRequest();
    }

    /**
     * Create an instance of {@link DeleteDBRequest }
     * 
     */
    public DeleteDBRequest createDeleteDBRequest() {
        return new DeleteDBRequest();
    }

    /**
     * Create an instance of {@link GetServiceComponentsDataResponse }
     * 
     */
    public GetServiceComponentsDataResponse createGetServiceComponentsDataResponse() {
        return new GetServiceComponentsDataResponse();
    }

    /**
     * Create an instance of {@link ComponentData }
     * 
     */
    public ComponentData createComponentData() {
        return new ComponentData();
    }

    /**
     * Create an instance of {@link DeleteDBResponse }
     * 
     */
    public DeleteDBResponse createDeleteDBResponse() {
        return new DeleteDBResponse();
    }

    /**
     * Create an instance of {@link GetRouterPoolListRequest }
     * 
     */
    public GetRouterPoolListRequest createGetRouterPoolListRequest() {
        return new GetRouterPoolListRequest();
    }

    /**
     * Create an instance of {@link GetTenantDetailsRequest }
     * 
     */
    public GetTenantDetailsRequest createGetTenantDetailsRequest() {
        return new GetTenantDetailsRequest();
    }

    /**
     * Create an instance of {@link ListTenantsRequest }
     * 
     */
    public ListTenantsRequest createListTenantsRequest() {
        return new ListTenantsRequest();
    }

    /**
     * Create an instance of {@link GetLicenseDataRequest }
     * 
     */
    public GetLicenseDataRequest createGetLicenseDataRequest() {
        return new GetLicenseDataRequest();
    }

    /**
     * Create an instance of {@link DeleteTenantResponse }
     * 
     */
    public DeleteTenantResponse createDeleteTenantResponse() {
        return new DeleteTenantResponse();
    }

    /**
     * Create an instance of {@link SetIpcAccessControlResponse }
     * 
     */
    public SetIpcAccessControlResponse createSetIpcAccessControlResponse() {
        return new SetIpcAccessControlResponse();
    }

    /**
     * Create an instance of {@link IncorrectIpcAccessLevelFault }
     * 
     */
    public IncorrectIpcAccessLevelFault createIncorrectIpcAccessLevelFault() {
        return new IncorrectIpcAccessLevelFault();
    }

    /**
     * Create an instance of {@link GetIpcAccessControlResponse }
     * 
     */
    public GetIpcAccessControlResponse createGetIpcAccessControlResponse() {
        return new GetIpcAccessControlResponse();
    }

    /**
     * Create an instance of {@link IpcAccessControl }
     * 
     */
    public IpcAccessControl createIpcAccessControl() {
        return new IpcAccessControl();
    }

    /**
     * Create an instance of {@link GetTenantDetailsResponse }
     * 
     */
    public GetTenantDetailsResponse createGetTenantDetailsResponse() {
        return new GetTenantDetailsResponse();
    }

    /**
     * Create an instance of {@link TenantDataExtType }
     * 
     */
    public TenantDataExtType createTenantDataExtType() {
        return new TenantDataExtType();
    }

    /**
     * Create an instance of {@link InvalidTenantFault }
     * 
     */
    public InvalidTenantFault createInvalidTenantFault() {
        return new InvalidTenantFault();
    }

    /**
     * Create an instance of {@link GetRouterPoolListResponse }
     * 
     */
    public GetRouterPoolListResponse createGetRouterPoolListResponse() {
        return new GetRouterPoolListResponse();
    }

    /**
     * Create an instance of {@link RouterPool }
     * 
     */
    public RouterPool createRouterPool() {
        return new RouterPool();
    }

    /**
     * Create an instance of {@link GetIpcAccessControlRequest }
     * 
     */
    public GetIpcAccessControlRequest createGetIpcAccessControlRequest() {
        return new GetIpcAccessControlRequest();
    }

    /**
     * Create an instance of {@link NotLicensedFault }
     * 
     */
    public NotLicensedFault createNotLicensedFault() {
        return new NotLicensedFault();
    }

    /**
     * Create an instance of {@link SetIpcDomainsResponse }
     * 
     */
    public SetIpcDomainsResponse createSetIpcDomainsResponse() {
        return new SetIpcDomainsResponse();
    }

    /**
     * Create an instance of {@link UpdateTenantRequest }
     * 
     */
    public UpdateTenantRequest createUpdateTenantRequest() {
        return new UpdateTenantRequest();
    }

    /**
     * Create an instance of {@link SetIpcAccessControlRequest }
     * 
     */
    public SetIpcAccessControlRequest createSetIpcAccessControlRequest() {
        return new SetIpcAccessControlRequest();
    }

    /**
     * Create an instance of {@link CreateTenantRequest }
     * 
     */
    public CreateTenantRequest createCreateTenantRequest() {
        return new CreateTenantRequest();
    }

    /**
     * Create an instance of {@link TenantDataType }
     * 
     */
    public TenantDataType createTenantDataType() {
        return new TenantDataType();
    }

    /**
     * Create an instance of {@link SetIpcDomainsRequest }
     * 
     */
    public SetIpcDomainsRequest createSetIpcDomainsRequest() {
        return new SetIpcDomainsRequest();
    }

    /**
     * Create an instance of {@link ListNetworkComponentsRequest }
     * 
     */
    public ListNetworkComponentsRequest createListNetworkComponentsRequest() {
        return new ListNetworkComponentsRequest();
    }

    /**
     * Create an instance of {@link InvalidArgumentFault }
     * 
     */
    public InvalidArgumentFault createInvalidArgumentFault() {
        return new InvalidArgumentFault();
    }

    /**
     * Create an instance of {@link ExistingTenantFault }
     * 
     */
    public ExistingTenantFault createExistingTenantFault() {
        return new ExistingTenantFault();
    }

    /**
     * Create an instance of {@link GeneralFault }
     * 
     */
    public GeneralFault createGeneralFault() {
        return new GeneralFault();
    }

    /**
     * Create an instance of {@link UpdateTenantResponse }
     * 
     */
    public UpdateTenantResponse createUpdateTenantResponse() {
        return new UpdateTenantResponse();
    }

    /**
     * Create an instance of {@link GetLocationTagsRequest }
     * 
     */
    public GetLocationTagsRequest createGetLocationTagsRequest() {
        return new GetLocationTagsRequest();
    }

    /**
     * Create an instance of {@link GetServiceComponentsDataRequest }
     * 
     */
    public GetServiceComponentsDataRequest createGetServiceComponentsDataRequest() {
        return new GetServiceComponentsDataRequest();
    }

    /**
     * Create an instance of {@link SaveDBResponse }
     * 
     */
    public SaveDBResponse createSaveDBResponse() {
        return new SaveDBResponse();
    }

    /**
     * Create an instance of {@link GetIpcDomainListResponse }
     * 
     */
    public GetIpcDomainListResponse createGetIpcDomainListResponse() {
        return new GetIpcDomainListResponse();
    }

    /**
     * Create an instance of {@link ListNetworkComponentsResponse }
     * 
     */
    public ListNetworkComponentsResponse createListNetworkComponentsResponse() {
        return new ListNetworkComponentsResponse();
    }

    /**
     * Create an instance of {@link SingleComponentDataType }
     * 
     */
    public SingleComponentDataType createSingleComponentDataType() {
        return new SingleComponentDataType();
    }

    /**
     * Create an instance of {@link GetLocationTagsResponse }
     * 
     */
    public GetLocationTagsResponse createGetLocationTagsResponse() {
        return new GetLocationTagsResponse();
    }

    /**
     * Create an instance of {@link LocationTag }
     * 
     */
    public LocationTag createLocationTag() {
        return new LocationTag();
    }

    /**
     * Create an instance of {@link DeleteTenantRequest }
     * 
     */
    public DeleteTenantRequest createDeleteTenantRequest() {
        return new DeleteTenantRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "ErrorMessage")
    public JAXBElement<String> createErrorMessage(String value) {
        return new JAXBElement<String>(_ErrorMessage_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "OK")
    public JAXBElement<String> createOK(String value) {
        return new JAXBElement<String>(_OK_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "start", scope = ListTenantsRequest.class)
    public JAXBElement<Integer> createListTenantsRequestStart(Integer value) {
        return new JAXBElement<Integer>(_ListTenantsRequestStart_QNAME, Integer.class, ListTenantsRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "limit", scope = ListTenantsRequest.class)
    public JAXBElement<Integer> createListTenantsRequestLimit(Integer value) {
        return new JAXBElement<Integer>(_ListTenantsRequestLimit_QNAME, Integer.class, ListTenantsRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "description", scope = TenantDataType.class)
    public JAXBElement<String> createTenantDataTypeDescription(String value) {
        return new JAXBElement<String>(_TenantDataTypeDescription_QNAME, String.class, TenantDataType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "enableGuestLogin", scope = TenantDataType.class, defaultValue = "1")
    public JAXBElement<Boolean> createTenantDataTypeEnableGuestLogin(Boolean value) {
        return new JAXBElement<Boolean>(_TenantDataTypeEnableGuestLogin_QNAME, Boolean.class, TenantDataType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "dialinNumber", scope = TenantDataType.class)
    public JAXBElement<String> createTenantDataTypeDialinNumber(String value) {
        return new JAXBElement<String>(_TenantDataTypeDialinNumber_QNAME, String.class, TenantDataType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "ipcAllowInbound", scope = TenantDataType.class, defaultValue = "1")
    public JAXBElement<Boolean> createTenantDataTypeIpcAllowInbound(Boolean value) {
        return new JAXBElement<Boolean>(_TenantDataTypeIpcAllowInbound_QNAME, Boolean.class, TenantDataType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "ipcAllowOutbound", scope = TenantDataType.class, defaultValue = "1")
    public JAXBElement<Boolean> createTenantDataTypeIpcAllowOutbound(Boolean value) {
        return new JAXBElement<Boolean>(_TenantDataTypeIpcAllowOutbound_QNAME, Boolean.class, TenantDataType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "vidyoReplayUrl", scope = TenantDataType.class)
    public JAXBElement<String> createTenantDataTypeVidyoReplayUrl(String value) {
        return new JAXBElement<String>(_TenantDataTypeVidyoReplayUrl_QNAME, String.class, TenantDataType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "vidyoMobileAllowed", scope = TenantDataType.class, defaultValue = "1")
    public JAXBElement<Boolean> createTenantDataTypeVidyoMobileAllowed(Boolean value) {
        return new JAXBElement<Boolean>(_TenantDataTypeVidyoMobileAllowed_QNAME, Boolean.class, TenantDataType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IpcAccessControlAccessMode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "accessMode", scope = IpcAccessControl.class)
    public JAXBElement<IpcAccessControlAccessMode> createIpcAccessControlAccessMode(IpcAccessControlAccessMode value) {
        return new JAXBElement<IpcAccessControlAccessMode>(_IpcAccessControlAccessMode_QNAME, IpcAccessControlAccessMode.class, IpcAccessControl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "routerID", scope = IpcAccessControl.class)
    public JAXBElement<String> createIpcAccessControlRouterID(String value) {
        return new JAXBElement<String>(_IpcAccessControlRouterID_QNAME, String.class, IpcAccessControl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceComponentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "serviceComponentType", scope = GetServiceComponentsDataRequest.class)
    public JAXBElement<ServiceComponentType> createGetServiceComponentsDataRequestServiceComponentType(ServiceComponentType value) {
        return new JAXBElement<ServiceComponentType>(_GetServiceComponentsDataRequestServiceComponentType_QNAME, ServiceComponentType.class, GetServiceComponentsDataRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portal.vidyo.com/superapi/", name = "tenantId", scope = GetLicenseDataRequest.class)
    public JAXBElement<Integer> createGetLicenseDataRequestTenantId(Integer value) {
        return new JAXBElement<Integer>(_GetLicenseDataRequestTenantId_QNAME, Integer.class, GetLicenseDataRequest.class, value);
    }

}
