package com.ammob.communication.vidyo.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import com.ammob.communication.core.model.User;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.model.SearchFilter;
import com.ammob.communication.vidyo.model.SearchFilter.SortBy;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.model.SearchFilter.Dir;
import com.vidyo.portal.superapi.GeneralFault_Exception;
import com.vidyo.portal.superapi.ListTenantsRequest;
import com.vidyo.portal.superapi.ListTenantsResponse;
import com.vidyo.portal.superapi.ObjectFactory;
import com.vidyo.portal.superapi.SingleTenantDataType;
import com.vidyo.portal.superapi.SortingDirection;
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
	 */
	public static List<Tenant> getTenantList(User user, SearchFilter filter, String tenantName, String tenantURL){
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
			ListTenantsResponse  response  = getClient(user.getWebsite(), user.getUsername(), 
					user.getPassword()).getListOfTenants(request);
			return convertTenantList(response.getTenant());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (GeneralFault_Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * convert SingleTenantDataType to Tenant
	 * @param SingleTenantDataType
	 * @return
	 */
	private static Tenant convertTenant(SingleTenantDataType entity){
		if(entity != null) {
			Tenant tenant = new Tenant();
			tenant.setRemotId(entity.getTenantId());
			tenant.setName(entity.getTenantName());
			tenant.setUrl(entity.getTenantURL());
			tenant.setDescription(entity.getDescription());
			tenant.setMobileAllowed(entity.getVidyoMobileAllowed());
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
			return tenant;
		} else {
			return null;
		}
	}
	
	/**
	 * convert SingleTenantDataType list to Tenant list
	 * @param SingleTenantDataType
	 * @return
	 */
	private static List<Tenant> convertTenantList(List<SingleTenantDataType> entitys){
		List<Tenant> result = new ArrayList<Tenant>();
		if(entitys != null) {
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
