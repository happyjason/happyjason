package com.ammob.communication.webapp.controller;

import org.apache.commons.lang.StringUtils;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.service.UserManager;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.model.Portal;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.service.PortalService;
import com.ammob.communication.vidyo.service.TenantManager;
import com.ammob.communication.vidyo.service.VidyoManager;
import com.vidyo.portal.superapi.SingleTenantDataType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Locale;
import java.util.Set;

/**
 * Implementation of <strong>SimpleFormController</strong> that interacts with
 * the {@link UserManager} to retrieve/persist values to the database.
 */
@Controller
@RequestMapping("/portal/profile*")
public class PortalFormController extends BaseFormController {

	PortalService portalService;
	VidyoManager vidyoManager;
	TenantManager tenantManager;
	
    public TenantManager getTenantManager() {
		return tenantManager;
	}
    @Autowired
	public void setTenantManager(TenantManager tenantManager) {
		this.tenantManager = tenantManager;
	}
	public VidyoManager getVidyoManager() {
		return vidyoManager;
	}
    @Autowired
	public void setVidyoManager(VidyoManager vidyoManager) {
		this.vidyoManager = vidyoManager;
	}
	public PortalService getPortalService() {
		return portalService;
	}
    @Autowired
	public void setPortalService(PortalService portalService) {
		this.portalService = portalService;
	}

	public PortalFormController() {
        setCancelView("redirect:/home");
        setSuccessView("redirect:/portal");
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Portal portal, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
            throws Exception {
        if (request.getParameter("cancel") != null) {
            if (!StringUtils.equals(request.getParameter("from"), "list")) {
                return getCancelView();
            } else {
                return getSuccessView();
            }
        }

        if (validator != null) { // validator is null during testing
            validator.validate(portal, errors);
            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "vidyo/profile";
            }
        }

        log.debug("entering 'onSubmit' method...");

        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	portalService.remove(portal);
            saveMessage(request, getText("tenantForm.deleted", portal.getPortalName(), locale));

            return getSuccessView();
        } else {
            try {
            	Portal p = null;
           // 	Tenant tenant = null;
            	Long portal_id = portal.getId();
            	if(portal_id == null){
            		//insert
            	//	Set<Tenant> tenants = new HashSet<Tenant>();
              
                //	ListTenantsResponse  dd = vidyoManager.getSuperClient(portal.getPortalUrl(), portal.getPortalName(), portal.getPortalPassword()).getListOfTenants(new ListTenantsRequest());
                //	List<SingleTenantDataType> singleTenantDataTypes = dd.getTenant();
//            		for(SingleTenantDataType s:singleTenantDataTypes){
//            			tenant = this.copyTenantProperties(s);
//            			tenants.add(tenant);
//            			this.tenantManager.save(tenant);	
//            		}
         //   		portal.setTenants(tenants);
            		portalService.save(portal);
            	}else{
            		//update
            		p = portalService.getPortalById(portal_id);
            		portal.setTenants(p.getTenants());
            		portalService.save(portal);
            	}
            	
            
            	
            
            	
            } catch (AccessDeniedException ade) {
                // thrown by UserSecurityAdvice configured in aop:advisor userManagerSecurity
                log.warn(ade.getMessage());
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                return null;
            } catch (Exception e) {
                return "vidyo/profile";
            }
            return getSuccessView();
        }
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Portal showForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	System.out.println("PortalFormController.showForm()~~~~~~~~~~~~~~~~~~~~~~~~");
        // If not an administrator, make sure user is not trying to add or edit another tenant
        if (!request.isUserInRole(Constants.ROLE_ADMIN) && !isFormSubmission(request)) {
            if (isAdd(request) || request.getParameter("id") != null) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                log.warn("User '" + request.getRemoteUser() + "' is trying to edit tenant with id '" +
                        request.getParameter("id") + "'");
                throw new AccessDeniedException("You do not have permission to modify other users.");
            }
        }
        String portalId = request.getParameter("id");
        System.out.println("PortalFormController.showForm()"+portalId);
        if(StringUtil.hasText(portalId)){
        	return portalService.getPortalById(Long.valueOf(portalId));
        }
        return new Portal();
    }

    private boolean isFormSubmission(HttpServletRequest request) {
        return request.getMethod().equalsIgnoreCase("post");
    }

    protected boolean isAdd(HttpServletRequest request) {
        String method = request.getParameter("method");
        return (method != null && method.equalsIgnoreCase("add"));
    }
    
    
    @RequestMapping(params = "method=listTenant")
	public ModelAndView listTental(@RequestParam(required = false, value = "portal_id") String query) throws Exception {
		Model model = new ExtendedModelMap();
		Portal portal = portalService.getPortalById(Long.valueOf(query));
		Set<Tenant> tenants = portal.getTenants();
		model.addAttribute(Constants.TENANT_LIST, tenants);
		model.addAttribute("portal_id", query);
		return new ModelAndView("tenant/list", model.asMap());
	}
    
    
    public Tenant copyTenantProperties(SingleTenantDataType singleTenantDataType){
    	Tenant tenant = new Tenant();
    	tenant.setDescription(singleTenantDataType.getDescription());
    	tenant.setId(Integer.valueOf(singleTenantDataType.getTenantId()).longValue());
    	tenant.setUrl(singleTenantDataType.getTenantURL());
    	tenant.setAdminName("adminadmin");
    	tenant.setAdminPassword("adminadmin");
    	tenant.setEnabled(true);
    	tenant.setName(singleTenantDataType.getTenantName());
    	tenant.setPaymentDays(2);
    	//......
    	
    	return tenant;
    }
	
}
