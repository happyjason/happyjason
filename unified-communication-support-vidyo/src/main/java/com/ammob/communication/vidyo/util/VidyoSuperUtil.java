package com.ammob.communication.vidyo.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import com.ammob.communication.core.authentication.principal.Credentials;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.exception.VidyoWrapException;
import com.ammob.communication.vidyo.model.SearchFilter;
import com.ammob.communication.vidyo.model.SearchFilter.SortBy;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.model.SearchFilter.Dir;
import com.vidyo.portal.superapi.CreateTenantRequest;
import com.vidyo.portal.superapi.CreateTenantResponse;
import com.vidyo.portal.superapi.ExistingTenantFault_Exception;
import com.vidyo.portal.superapi.GeneralFault_Exception;
import com.vidyo.portal.superapi.InvalidArgumentFault_Exception;
import com.vidyo.portal.superapi.ListTenantsRequest;
import com.vidyo.portal.superapi.ListTenantsResponse;
import com.vidyo.portal.superapi.NotLicensedFault_Exception;
import com.vidyo.portal.superapi.ObjectFactory;
import com.vidyo.portal.superapi.SingleTenantDataType;
import com.vidyo.portal.superapi.SortingDirection;
import com.vidyo.portal.superapi.TenantDataType;
import com.vidyo.portal.superapi.TenantSortingField;
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
	 * convert SingleTenantDataType to Tenant
	 * @param SingleTenantDataType
	 * @return
	 */
	private static TenantDataType convertTenantDataType(Tenant tenant){
		TenantDataType entity = superFactory.createTenantDataType();
		if(tenant != null) {
			entity.setDescription(superFactory.createTenantDataTypeDescription(tenant.getDescription()));
			entity.setDialinNumber(superFactory.createTenantDataTypeDialinNumber(String.valueOf(tenant.getDialIn())));
			entity.setEnableGuestLogin(superFactory.createTenantDataTypeEnableGuestLogin(tenant.isAllowedOfGuestLogin()));
			entity.setExtensionPrefix(String.valueOf(tenant.getExtensionPrefix()));
			entity.setIpcAllowInbound(superFactory.createTenantDataTypeIpcAllowInbound(tenant.isAllowedOfIpcInbound()));
			entity.setIpcAllowOutbound(superFactory.createTenantDataTypeIpcAllowOutbound(tenant.isAllowedOfIpcOutbound()));
			entity.setNumOfExecutives(tenant.getNumOfExecutives());
			entity.setNumOfInstalls(tenant.getNumOfExecutives());
			entity.setNumOfLines(tenant.getNumOfLines());
			entity.setNumOfPanoramas(tenant.getNumOfPanoramas());
			entity.setNumOfSeats(tenant.getNumOfSeats());
			entity.setTenantName(tenant.getName());
			entity.setTenantUrl(tenant.getUrl());
			entity.setVidyoManager(tenant.getVidyoManager());
			entity.setVidyoMobileAllowed(superFactory.createTenantDataTypeVidyoMobileAllowed(tenant.isAllowedOfMobile()));
			entity.setVidyoReplayUrl(superFactory.createTenantDataTypeVidyoReplayUrl(tenant.getVidyoReplayUrl()));
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
			try {
				tenant.setDialIn(Integer.parseInt(entity.getDialinNumber()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				tenant.setExtensionPrefix(Integer.parseInt(entity.getExtensionPrefix()));
			} catch (Exception e) {
				e.printStackTrace();
			}
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
