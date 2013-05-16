package com.ammob.communication.cas.authentication.principal;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.apache.commons.beanutils.PropertyUtils;
import org.jasig.cas.authentication.principal.Credentials;
import org.jasig.cas.authentication.principal.CredentialsToPrincipalResolver;
import org.jasig.cas.authentication.principal.Principal;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.jasig.services.persondir.IPersonAttributeDao;
import org.jasig.services.persondir.IPersonAttributes;
import org.jasig.services.persondir.support.StubPersonAttributeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.model.Member;
import com.ammob.communication.vidyo.util.VidyoUserUtil;

public class VidyoCredentialsToPrincipalResolver implements CredentialsToPrincipalResolver {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    /** Repository of principal attributes to be retrieved */
    @NotNull
    private IPersonAttributeDao attributeRepository = new StubPersonAttributeDao(new HashMap<String, List<Object>>());
    
    /**
     * Return Principal.
     */
    @SuppressWarnings("unchecked")
	@Override
    public final Principal resolvePrincipal(final Credentials credentials) {
        if (log.isDebugEnabled()) {
            log.debug("Attempting to resolve a principal...");
        } 

        final String principalId = extractPrincipalId(credentials);
        
        if (principalId == null) {
            return null;
        }
        
        if (log.isDebugEnabled()) {
            log.debug("Creating SimplePrincipal for [" + principalId + "]");
        }

        final IPersonAttributes personAttributes = this.attributeRepository.getPerson(principalId);
        final Map<String, List<Object>> attributes = new HashMap<String, List<Object>>();

        if (personAttributes != null) {
            attributes.putAll(personAttributes.getAttributes());
        }
        
        List<Object> members = new ArrayList<Object>();
		List<Object> authoritiesList = new ArrayList<Object>();
		Map<String, Object> memberMap = new HashMap<String, Object>();
    	try {
			VidyoCredentials vidyoCredentials = (VidyoCredentials) credentials;
			try {
				if(StringUtil.hasText(vidyoCredentials.getUrl())) {
					Member member = VidyoUserUtil.getMyAccount(
						new com.ammob.communication.core.authentication.principal.Credentials(
							vidyoCredentials.getUsername(), vidyoCredentials.getPassword(),
								vidyoCredentials.getUrl()));
					memberMap.putAll(PropertyUtils.describe(member));
				}
			} catch (Exception e) {
				log.warn(e.getMessage());
			}
			if(vidyoCredentials.getUsername().equals("hotmob")) {
				 authoritiesList.add(Constants.ROLE_ADMIN);
			}
			memberMap.put("username", vidyoCredentials.getUsername());
			memberMap.put("password", vidyoCredentials.getPassword());
			memberMap.put("portal", vidyoCredentials.getUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
        members.add(memberMap);
        authoritiesList.add(Constants.ROLE_VIDYO);
        attributes.put("vidyo", members);
		attributes.put("authorities", authoritiesList);

        final Map<String, Object> convertedAttributes = new HashMap<String, Object>();
        
        for (final Map.Entry<String, List<Object>> entry : attributes.entrySet()) {
            final String key = entry.getKey();
            final Object value = entry.getValue().size() == 1 ? entry.getValue().get(0) : entry.getValue();
            convertedAttributes.put(key, value);
        }
        return new SimplePrincipal(principalId, convertedAttributes);
    }
    
    /**
     * Return true if Credentials are VidyoCredentials, false otherwise.
     */
    @Override
    public boolean supports(final Credentials credentials) {
        return credentials != null && (VidyoCredentials.class.isAssignableFrom(credentials.getClass()));
    }

    /**
     * Extracts the id of the user from the provided credentials.
     * 
     * @param credentials the credentials provided by the user.
     * @return the username, or null if it could not be resolved.
     */
    public String extractPrincipalId(Credentials credentials) {
        final VidyoCredentials vidyoCredentials = (VidyoCredentials) credentials;
        final String principalId = vidyoCredentials.getUsername();
        log.debug("principalId : {}", principalId);
        return principalId;
	}
	
    public final void setAttributeRepository(final IPersonAttributeDao attributeRepository) {
        this.attributeRepository = attributeRepository;
    }
}
