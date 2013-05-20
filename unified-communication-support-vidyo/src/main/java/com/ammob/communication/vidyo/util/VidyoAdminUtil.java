package com.ammob.communication.vidyo.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import com.ammob.communication.core.authentication.principal.Credentials;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.exception.VidyoWrapException;
import com.ammob.communication.vidyo.model.Member;
import com.ammob.communication.vidyo.model.SearchFilter;
import com.ammob.communication.vidyo.model.SearchFilter.Dir;

import com.vidyo.portal.admin.v1_1.Filter;
import com.vidyo.portal.admin.v1_1.GeneralFault_Exception;
import com.vidyo.portal.admin.v1_1.GetMembersRequest;
import com.vidyo.portal.admin.v1_1.GetMembersResponse;
import com.vidyo.portal.admin.v1_1.InvalidArgumentFault_Exception;
import com.vidyo.portal.admin.v1_1.NotLicensedFault_Exception;
import com.vidyo.portal.admin.v1_1.ObjectFactory;
import com.vidyo.portal.admin.v1_1.SortDir;
import com.vidyo.portal.admin.v1_1.VidyoPortalAdminService;
import com.vidyo.portal.admin.v1_1.VidyoPortalAdminServicePortType;

public class VidyoAdminUtil {
	
	private static ObjectFactory adminFactory = new ObjectFactory();
	
	/**
	 * get member list
	 * @param credentials
	 * @param filter
	 * @return
	 * @throws VidyoWrapException
	 */
	public static List<Member> getMemberList(Credentials credentials, SearchFilter filter)
			throws VidyoWrapException{
		GetMembersRequest request = adminFactory.createGetMembersRequest();
		request.setFilter(convertFilter(filter));
		try {
			GetMembersResponse response  = getClient(credentials.getUrl(), credentials.getUsername(), 
					credentials.getPassword()).getMembers(request);
			return convertMemberList(response.getMember());
		} catch (MalformedURLException e) {
			throw new VidyoWrapException(e);
		} catch (GeneralFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (NotLicensedFault_Exception e) {
			throw new VidyoWrapException(e);
		} catch (InvalidArgumentFault_Exception e) {
			throw new VidyoWrapException(e);
		}
	}
	
	/**
	 * convert com.vidyo.portal.admin.v1_1.Member to com.ammob.communication.vidyo.model.Member
	 * @param com.vidyo.portal.admin.v1_1.Member
	 * @return
	 */
	private static com.ammob.communication.vidyo.model.Member convertMember(com.vidyo.portal.admin.v1_1.Member entity){
		com.ammob.communication.vidyo.model.Member member = new com.ammob.communication.vidyo.model.Member();
		if(entity != null) {
			member.setDescription(entity.getDescription());
			member.setDisplayName(entity.getDisplayName());
			member.setEmailAddress(entity.getEmailAddress());
			member.setExtension(entity.getExtension());
			member.setGroupName(entity.getGroupName());
			member.setLanguage(entity.getLanguage());
			member.setLocationTag(entity.getLocationTag());
			member.setMemberID(entity.getMemberID());
			member.setName(entity.getName());
			member.setProxyName(entity.getProxyName());
			member.setRoleName(entity.getRoleName());
			if(entity.getPassword() != null)
				member.setPassword(entity.getPassword().getValue());
		}
		return member;
	}
	
	/**
	 * convert com.vidyo.portal.admin.v1_1.Member list to com.ammob.communication.vidyo.model.Member list
	 * @param com.vidyo.portal.admin.v1_1.Member
	 * @return
	 */
	private static List<com.ammob.communication.vidyo.model.Member> convertMemberList(
			List<com.vidyo.portal.admin.v1_1.Member> entitys){
		List<com.ammob.communication.vidyo.model.Member> result = 
				new ArrayList<com.ammob.communication.vidyo.model.Member>();
		if(entitys != null && !entitys.isEmpty()) {
			for(com.vidyo.portal.admin.v1_1.Member entity : entitys) {
				result.add(convertMember(entity));
			}
		}
		return result;
	}
	
	/**
	 * convert Filter to Vidyo Filter
	 * @param filter
	 * @return
	 */
	private static Filter convertFilter(SearchFilter filter){
		if(filter != null) {
			Filter vidyoFilter = adminFactory.createFilter();
			if(StringUtil.hasText(filter.getDir())){
				if(filter.getDir().equals(Dir.ASC.toString())) {
					vidyoFilter.setDir(adminFactory.createFilterDir(SortDir.ASC));
				} else if(filter.getDir().equals(Dir.DESC.toString())) {
					vidyoFilter.setDir(adminFactory.createFilterDir(SortDir.DESC));
				}
			}
			vidyoFilter.setLimit(adminFactory.createFilterLimit(filter.getLimit()));
			vidyoFilter.setQuery(adminFactory.createFilterQuery(filter.getQuery()));
			vidyoFilter.setSortBy(adminFactory.createFilterSortBy(filter.getSortBy()));
			vidyoFilter.setStart(adminFactory.createFilterStart(filter.getStart()));
			return vidyoFilter;
		} else {
			return null;
		}
	}
	
	/**
	 * vidyo portal admin service, webservice method
	 * 
	 * @param protalUrl
	 * @param username
	 * @param password
	 * @return
	 * @throws MalformedURLException
	 */
	private static VidyoPortalAdminServicePortType getClient(String protalUrl, String username, String password) throws MalformedURLException {
		VidyoPortalAdminService service = new VidyoPortalAdminService(new URL(protalUrl + "/services/v1_1/VidyoPortalAdminService?wsdl"));
		VidyoPortalAdminServicePortType client = service.getVidyoPortalAdminServicePort();
		BindingProvider bp = (BindingProvider)client;
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
		return client;
	}
}
