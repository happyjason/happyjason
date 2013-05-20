package com.ammob.communication.vidyo.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import com.ammob.communication.core.authentication.principal.Credentials;
import com.ammob.communication.core.util.NumberUtil;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.exception.VidyoWrapException;
import com.ammob.communication.vidyo.model.SearchFilter;
import com.ammob.communication.vidyo.model.SearchFilter.SortBy;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.model.SearchFilter.Dir;
import com.vidyo.portal.superapi.CreateTenantRequest;
import com.vidyo.portal.superapi.CreateTenantResponse;
import com.vidyo.portal.superapi.DeleteTenantRequest;
import com.vidyo.portal.superapi.DeleteTenantResponse;
import com.vidyo.portal.superapi.ExistingTenantFault_Exception;
import com.vidyo.portal.superapi.GeneralFault_Exception;
import com.vidyo.portal.superapi.GetTenantDetailsRequest;
import com.vidyo.portal.superapi.GetTenantDetailsResponse;
import com.vidyo.portal.superapi.InvalidArgumentFault_Exception;
import com.vidyo.portal.superapi.InvalidTenantFault_Exception;
import com.vidyo.portal.superapi.ListTenantsRequest;
import com.vidyo.portal.superapi.ListTenantsResponse;
import com.vidyo.portal.superapi.NotLicensedFault_Exception;
import com.vidyo.portal.superapi.ObjectFactory;
import com.vidyo.portal.superapi.SingleTenantDataType;
import com.vidyo.portal.superapi.SortingDirection;
import com.vidyo.portal.superapi.TenantDataExtType;
import com.vidyo.portal.superapi.TenantDataType;
import com.vidyo.portal.superapi.TenantSortingField;
import com.vidyo.portal.superapi.UpdateTenantRequest;
import com.vidyo.portal.superapi.UpdateTenantResponse;
import com.vidyo.portal.superapi.VidyoPortalSuperService;
import com.vidyo.portal.superapi.VidyoPortalSuperServicePortType;

public class VidyoSuperUtil {
	
	private static ObjectFactory superFactory = new ObjectFactory();
	
	/**
	 * Get Tenant List
	 * @param user
	 * @param filter
	 * @param tenantName
	 * @param tenantURL
	 * @return
	 * @throws VidyoWrapException 
	 */
	public static List<Tenant> getTenantList(Credentials credentials, SearchFilter filter, String tenantName, String tenantURL)
			throws VidyoWrapException{
		ListTenantsRequest request = superFactory.createListTenantsRequest();
		request.setLimit(superFactory.createListTenantsRequestLimit(filter.getLimit()));
		if(StringUtil.hasText(filter.getDir())){
			if(filter.getDir().equals(Dir.ASC.toString())) {
				request.setDir(SortingDirection.ASC);
			} else if(filter.getDir().equals(Dir.DESC.toString())) {
				request.setDir(SortingDirection.DESC);
			}
		}
		if(StringUtil.hasText(filter.getSortBy())){
			if(filter.getSortBy().equals(SortBy.Name.toString())) {
				request.setSortBy(TenantSortingField.TENANT_NAME);
			} else if(filter.getSortBy().equals(SortBy.Url.toString())) {
				request.setSortBy(TenantSortingField.TENANT_URL);
			} else if(filter.getSortBy().equals(SortBy.Extension.toString())) {
				request.setSortBy(TenantSortingField.EXTENSION_PREFIX);
			}
		}
		request.setStart(superFactory.createListTenantsRequestStart(filter.getStart()));
		request.setTenantName(tenantName);
		request.setTenantURL(tenantURL);
		try {
			ListTenantsResponse  response  = getClient(credentials.getUrl(), credentials.getUsername(), 
					credentials.getPassword()).getListOfTenants(request);
			return convertTenantList(response.getTenant());
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		}
	}
	
	/**
	 * Add Tenant
	 * @param user
	 * @param filter
	 * @param tenantName
	 * @param tenantURL
	 * @return
	 * @throws VidyoWrapException 
	 */
	public static boolean addTenant(Credentials credentials, Tenant tenant)
			throws VidyoWrapException{
		CreateTenantRequest request = superFactory.createCreateTenantRequest();
		request.setTenantData(convertTenantDataType(tenant));
		try {
			CreateTenantResponse  response  = getClient(credentials.getUrl(), credentials.getUsername(), 
					credentials.getPassword()).createTenant(request);
			if(StringUtil.hasText(response.getOK()))
				return true;
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (ExistingTenantFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		}
		return false;
	}
	
	/**
	 * Del Tenant
	 * @param user
	 * @param filter
	 * @param tenantName
	 * @param tenantURL
	 * @return
	 * @throws VidyoWrapException 
	 */
	public static boolean delTenant(Credentials credentials, Integer tenantId)
			throws VidyoWrapException {
		DeleteTenantRequest request = superFactory.createDeleteTenantRequest();
		request.setTenantId(tenantId);
		try {
			DeleteTenantResponse  response  = getClient(credentials.getUrl(), credentials.getUsername(), 
					credentials.getPassword()).deleteTenant(request);
			if(StringUtil.hasText(response.getOK()))
				return true;
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidTenantFault_Exception e) {
			throw new VidyoWrapException(e);
		}
		return false;
	}

	/**
	 * Update Tenant
	 * @param credentials
	 * @param tenant
	 * @return
	 * @throws VidyoWrapException
	 */
	public static boolean setTenant(Credentials credentials, Tenant tenant)
			throws VidyoWrapException {
		UpdateTenantRequest request = superFactory.createUpdateTenantRequest();
		request.setTenantData(convertTenantDataExtType(tenant));
		try {
			UpdateTenantResponse  response  = getClient(credentials.getUrl(), credentials.getUsername(), 
					credentials.getPassword()).updateTenant(request);
			if(StringUtil.hasText(response.getOK()))
				return true;
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (InvalidTenantFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (ExistingTenantFault_Exception e) {
			throw new VidyoWrapException(e);
		}
		return false;
	}
	
	/**
	 * Get Tenant
	 * @param credentials
	 * @param tenant
	 * @return
	 * @throws VidyoWrapException
	 */
	public static Tenant getTenant(Credentials credentials, Integer tenantId)
			throws VidyoWrapException {
		GetTenantDetailsRequest request = superFactory.createGetTenantDetailsRequest();
		request.setTenantId(tenantId);
		try {
			GetTenantDetailsResponse  response  = getClient(credentials.getUrl(), credentials.getUsername(), 
					credentials.getPassword()).getTenantDetails(request);
			return convertTenant(response.getTenantDetail());
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (InvalidTenantFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		}
	}
	
	/**
	 * convert tenant to TenantDataExtType
	 * @param SingleTenantDataType
	 * @return
	 */
	private static TenantDataExtType convertTenantDataExtType(Tenant tenant){
		TenantDataExtType entity = superFactory.createTenantDataExtType();
		if(tenant != null) {
			if(tenant.getDescription() != null)
				entity.setDescription(superFactory.createTenantDataTypeDescription(tenant.getDescription()));
			if(tenant.getDialIn() != null)
				entity.setDialinNumber(superFactory.createTenantDataTypeDialinNumber(tenant.getDialIn()));
			if(tenant.getExtensionPrefix() != null)
				entity.setExtensionPrefix(tenant.getExtensionPrefix());
			if(tenant.getVidyoManager() != null)
				entity.setVidyoManager(tenant.getVidyoManager());
			if(tenant.getVidyoReplayUrl() != null)
				entity.setVidyoReplayUrl(superFactory.createTenantDataTypeVidyoReplayUrl(tenant.getVidyoReplayUrl()));
			
			entity.setTenantID(NumberUtil.getInteger(tenant.getRemotId(), 0));   // TenantDataExtType value
			
			entity.setNumOfExecutives(NumberUtil.getInteger(tenant.getNumOfExecutives(), 0));
			entity.setNumOfInstalls(NumberUtil.getInteger(tenant.getNumOfInstalls(), 0));
			entity.setNumOfLines(NumberUtil.getInteger(tenant.getNumOfLines(), 0));
			entity.setNumOfPanoramas(NumberUtil.getInteger(tenant.getNumOfPanoramas(), 0));
			entity.setNumOfSeats(NumberUtil.getInteger(tenant.getNumOfSeats(), 0));
			
			entity.getAllowedLocationTagList().add(1); // FIXME this is what?
			entity.setTenantName(tenant.getName());
			entity.setTenantUrl(tenant.getUrl());
			entity.setVidyoMobileAllowed(superFactory.createTenantDataTypeVidyoMobileAllowed(tenant.isAllowedOfMobile()));
			entity.setIpcAllowInbound(superFactory.createTenantDataTypeIpcAllowInbound(tenant.isAllowedOfIpcInbound()));
			entity.setIpcAllowOutbound(superFactory.createTenantDataTypeIpcAllowOutbound(tenant.isAllowedOfIpcOutbound()));
			entity.setEnableGuestLogin(superFactory.createTenantDataTypeEnableGuestLogin(tenant.isAllowedOfGuestLogin()));
		}
		return entity;
	}
	
	/**
	 * convert tenant to TenantDataType
	 * @param SingleTenantDataType
	 * @return
	 */
	private static TenantDataType convertTenantDataType(Tenant tenant){
		TenantDataType entity = superFactory.createTenantDataType();
		if(tenant != null) {
			if(tenant.getDescription() != null)
				entity.setDescription(superFactory.createTenantDataTypeDescription(tenant.getDescription()));
			if(tenant.getDialIn() != null)
				entity.setDialinNumber(superFactory.createTenantDataTypeDialinNumber(tenant.getDialIn()));
			if(tenant.getExtensionPrefix() != null)
				entity.setExtensionPrefix(tenant.getExtensionPrefix());
			if(tenant.getVidyoManager() != null)
				entity.setVidyoManager(tenant.getVidyoManager());
			if(tenant.getVidyoReplayUrl() != null)
				entity.setVidyoReplayUrl(superFactory.createTenantDataTypeVidyoReplayUrl(tenant.getVidyoReplayUrl()));
			
			entity.setNumOfExecutives(NumberUtil.getInteger(tenant.getNumOfExecutives(), 0));
			entity.setNumOfInstalls(NumberUtil.getInteger(tenant.getNumOfInstalls(), 0));
			entity.setNumOfLines(NumberUtil.getInteger(tenant.getNumOfLines(), 0));
			entity.setNumOfPanoramas(NumberUtil.getInteger(tenant.getNumOfPanoramas(), 0));
			entity.setNumOfSeats(NumberUtil.getInteger(tenant.getNumOfSeats(), 0));
			
			entity.getAllowedLocationTagList().add(1); // FIXME this is what?
			entity.setTenantName(tenant.getName());
			entity.setTenantUrl(tenant.getUrl());
			entity.setVidyoMobileAllowed(superFactory.createTenantDataTypeVidyoMobileAllowed(tenant.isAllowedOfMobile()));
			entity.setIpcAllowInbound(superFactory.createTenantDataTypeIpcAllowInbound(tenant.isAllowedOfIpcInbound()));
			entity.setIpcAllowOutbound(superFactory.createTenantDataTypeIpcAllowOutbound(tenant.isAllowedOfIpcOutbound()));
			entity.setEnableGuestLogin(superFactory.createTenantDataTypeEnableGuestLogin(tenant.isAllowedOfGuestLogin()));
		}
		return entity;
	}
	
	/**
	 * convert SingleTenantDataType to Tenant
	 * @param SingleTenantDataType
	 * @return
	 */
	private static Tenant convertTenant(SingleTenantDataType entity){
		Tenant tenant = new Tenant();
		if(entity != null) {
			tenant.setRemotId(entity.getTenantId());
			tenant.setName(entity.getTenantName());
			tenant.setUrl(entity.getTenantURL());
			tenant.setDescription(entity.getDescription());
			tenant.setAllowedOfMobile(entity.getVidyoMobileAllowed() > 0 ? true : false );
			tenant.setVidyoReplayUrl(entity.getVidyoReplayUrl());
			tenant.setExtensionPrefix(entity.getExtensionPrefix());
			tenant.setDialIn(entity.getDialinNumber());
		}
		return tenant;
	}
	
	/**
	 * convert TenantDataExtType to Tenant
	 * @param SingleTenantDataType
	 * @return
	 */
	private static Tenant convertTenant(TenantDataExtType entity){
		Tenant tenant = new Tenant();
		if(entity != null) {
			tenant.setRemotId(entity.getTenantID());
			tenant.setName(entity.getTenantName());
			tenant.setUrl(entity.getTenantUrl());
			tenant.setExtensionPrefix(entity.getExtensionPrefix());
			if(entity.getDialinNumber() != null)
				tenant.setDialIn(entity.getDialinNumber().getValue());
			if(entity.getDescription() != null)
				tenant.setDescription(entity.getDescription().getValue());
			if(entity.getVidyoReplayUrl() != null)
				tenant.setVidyoReplayUrl(entity.getVidyoReplayUrl().getValue());
			tenant.setVidyoManager(entity.getVidyoManager());
			
			if(entity.getVidyoMobileAllowed() != null)
				tenant.setAllowedOfMobile(entity.getVidyoMobileAllowed().getValue() );
			if(entity.getEnableGuestLogin() != null)
				tenant.setAllowedOfGuestLogin(entity.getEnableGuestLogin().getValue());
			if(entity.getIpcAllowInbound() != null)
				tenant.setAllowedOfIpcInbound(entity.getIpcAllowInbound().getValue());
			if(entity.getIpcAllowOutbound() != null)
				tenant.setAllowedOfIpcOutbound(entity.getIpcAllowOutbound().getValue());
			
			tenant.setNumOfExecutives(entity.getNumOfExecutives());
			tenant.setNumOfInstalls(entity.getNumOfInstalls());
			tenant.setNumOfLines(entity.getNumOfLines());
			tenant.setNumOfPanoramas(entity.getNumOfPanoramas());
			tenant.setNumOfSeats(entity.getNumOfSeats());
			
			tenant.setAllowedTenantList(entity.getAllowedTenantList());
			tenant.setAllowedVidyoGatewayList(entity.getAllowedVidyoGatewayList());
			tenant.setAllowedLocationTagList(entity.getAllowedLocationTagList());
			tenant.setAllowedVidyoProxyList(entity.getVidyoProxyList());
			tenant.setAllowedVidyoRepalyList(entity.getAllowedVidyoRepalyList());
			tenant.setAllowedVidyoReplayRecorderList(entity.getAllowedVidyoReplayRecorderList());
		}
		return tenant;
	}
	
	/**
	 * convert SingleTenantDataType list to Tenant list
	 * @param SingleTenantDataType
	 * @return
	 */
	private static List<Tenant> convertTenantList(List<SingleTenantDataType> entitys){
		List<Tenant> result = new ArrayList<Tenant>();
		if(entitys != null && !entitys.isEmpty()) {
			for(SingleTenantDataType entity : entitys) {
				result.add(convertTenant(entity));
			}
		}
		return result;
	}
	
	/**
	 * vidyo portal super service, webservice method
	 * @param protalUrl
	 * @param username
	 * @param password
	 * @return
	 * @throws MalformedURLException
	 */
	private static VidyoPortalSuperServicePortType getClient(String protalUrl,
			String username, String password) throws MalformedURLException {
		VidyoPortalSuperService service = new VidyoPortalSuperService(new URL(protalUrl + "/services/VidyoPortalSuperService?wsdl"));
		VidyoPortalSuperServicePortType client = service.getVidyoPortalSuperServicePort();
		BindingProvider bp = (BindingProvider)client;
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
		return client;
	}
}
