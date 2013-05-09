package com.ammob.communication.vidyo.util;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.BindingProvider;

import com.vidyo.portal.admin.v1_1.VidyoPortalAdminService;
import com.vidyo.portal.admin.v1_1.VidyoPortalAdminServicePortType;

public class VidyoAdminUtil {

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
