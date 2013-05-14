package com.ammob.communication.webapp.controller;

import org.apache.commons.lang.StringUtils;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.service.UserManager;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.model.Portal;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.service.PortalService;
import com.ammob.communication.vidyo.service.TenantManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Implementation of <strong>SimpleFormController</strong> that interacts with
 * the {@link UserManager} to retrieve/persist values to the database.
 */
@Controller
@RequestMapping("/tenant/profile*")
public class TenantFormController extends BaseFormController {
    private TenantManager tenantManager;
    private PortalService portalService;
    @Autowired
    public void setTenantManager(TenantManager tenantManager) {
        this.tenantManager = tenantManager;
    }
    @Autowired
    public void setPortalService(PortalService portalService) {
		this.portalService = portalService;
	}

	public TenantFormController() {
        setCancelView("redirect:/home");
        setSuccessView("redirect:/tenant");
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Tenant tenant, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
            throws Exception {
    	Portal portal = null;
    	String portal_id = null;
    	if(request.getParameter("portal_id") != null && request.getParameter("portal_id") != ""){
    		portal_id = request.getParameter("portal_id");
    		portal = this.portalService.getPortalById(Long.valueOf(portal_id));
    		
    	}
        if (request.getParameter("cancel") != null) {
            if (!StringUtils.equals(request.getParameter("from"), "list")) {
                return getCancelView();
            } else {
                return getSuccessView();
            }
        }

        if (validator != null) { // validator is null during testing
            validator.validate(tenant, errors);
            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "vidyo/profile";
            }
        }

        log.debug("entering 'onSubmit' method...");

        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	System.out.println("TenantFormController.onSubmit()"+portal);
        	Tenant t =tenantManager.get(tenant.getId());
        //	portal.getTenants().remove(tenant);
        	tenantManager.remove(t);
        	 
            saveMessage(request, getText("tenantForm.deleted", tenant.getName(), locale));

            return getSuccessView();
        } else {
            try {
           
            	
            	Long tenant_id = tenant.getId();
            	if(tenant_id == null){
            		//insert
            		portal.getTenants().add(tenant);
            		 portalService.save(portal);
            	}else{
            		System.out.println("TenantFormController.onSubmit()f");
            		//update
//            		Set<Tenant> tenants = portal.getTenants();
//              
//                	 tenants.add(tenant);
//                	 portal.setTenants(tenants);
                	 tenantManager.save(tenant);
                //	 portalService.save(portal);
            	}
          
            	
            
            } catch (AccessDeniedException ade) {
                // thrown by UserSecurityAdvice configured in aop:advisor userManagerSecurity
                log.warn(ade.getMessage());
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                return null;
            } catch (Exception e) {
            	//throw e;
                return "vidyo/profile";
            }
            return getSuccessView();
        }
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Tenant showForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	System.out.println("TenantFormController.showForm()1");
        // If not an administrator, make sure user is not trying to add or edit another tenant
    	//Portal portal ;
    	String portal_id = request.getParameter("portal_id");
    	
//    	if(portal_id != "" && portal_id != null){
//    		portal = portalService.getPortalById(Long.valueOf(portal_id));
//    	}
    	
        if (!request.isUserInRole(Constants.ROLE_ADMIN) && !isFormSubmission(request)) {
            if (isAdd(request) || request.getParameter("id") != null) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                log.warn("User '" + request.getRemoteUser() + "' is trying to edit tenant with id '" +
                        request.getParameter("id") + "'");
                throw new AccessDeniedException("You do not have permission to modify other users.");
            }
        }
        request.setAttribute("portal_id", portal_id);
        String tenantId = request.getParameter("id");
        if(StringUtil.hasText(tenantId)){
        	System.out.println("TenantFormController.showForm()2");
        	return tenantManager.getTenant(tenantId);
        }
     
    	System.out.println("TenantFormController.showForm()3"+portal_id);
        return new Tenant();
    }

    private boolean isFormSubmission(HttpServletRequest request) {
        return request.getMethod().equalsIgnoreCase("post");
    }

    protected boolean isAdd(HttpServletRequest request) {
        String method = request.getParameter("method");
        return (method != null && method.equalsIgnoreCase("add"));
    }
}
