package com.ammob.communication.webapp.controller;

import org.apache.commons.lang.StringUtils;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.service.UserManager;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.service.TenantManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Implementation of <strong>SimpleFormController</strong> that interacts with
 * the {@link UserManager} to retrieve/persist values to the database.
 */
@Controller
@RequestMapping("/tenant/profile*")
public class TenantFormController extends BaseFormController {
    private TenantManager tenantManager;
    
    @Autowired
    public void setTenantManager(TenantManager tenantManager) {
        this.tenantManager = tenantManager;
    }
    
    public TenantFormController() {
        setCancelView("redirect:/home");
        setSuccessView("redirect:/tenant");
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Tenant tenant, BindingResult errors, HttpServletRequest request,
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
            validator.validate(tenant, errors);
            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "vidyo/profile";
            }
        }

        log.debug("entering 'onSubmit' method...");

        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	tenantManager.remove(tenant);
            saveMessage(request, getText("tenantForm.deleted", tenant.getName(), locale));

            return getSuccessView();
        } else {
            try {
            	tenantManager.save(tenant);
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
    protected Tenant showForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // If not an administrator, make sure user is not trying to add or edit another tenant
        if (!request.isUserInRole(Constants.ADMIN_ROLE) && !isFormSubmission(request)) {
            if (isAdd(request) || request.getParameter("id") != null) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                log.warn("User '" + request.getRemoteUser() + "' is trying to edit tenant with id '" +
                        request.getParameter("id") + "'");
                throw new AccessDeniedException("You do not have permission to modify other users.");
            }
        }
        String tenantId = request.getParameter("id");
        
        // if user logged in with remember me, display a warning that they can't change passwords
        log.debug("checking for remember me login...");

        AuthenticationTrustResolver resolver = new AuthenticationTrustResolverImpl();
        SecurityContext ctx = SecurityContextHolder.getContext();

        if (ctx.getAuthentication() != null) {
            Authentication auth = ctx.getAuthentication();

            if (resolver.isRememberMe(auth)) {
                request.getSession().setAttribute("cookieLogin", "true");

                // add warning message
                saveMessage(request, getText("userProfile.cookieLogin", request.getLocale()));
            }
        }
        return tenantManager.getTenant(tenantId);
    }

    private boolean isFormSubmission(HttpServletRequest request) {
        return request.getMethod().equalsIgnoreCase("post");
    }

    protected boolean isAdd(HttpServletRequest request) {
        String method = request.getParameter("method");
        return (method != null && method.equalsIgnoreCase("add"));
    }
}
