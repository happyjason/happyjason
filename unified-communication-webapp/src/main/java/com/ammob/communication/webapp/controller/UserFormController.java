package com.ammob.communication.webapp.controller;

import org.apache.commons.lang.StringUtils;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.exception.UserExistsException;
import com.ammob.communication.core.model.Role;
import com.ammob.communication.core.model.User;
import com.ammob.communication.core.service.RoleManager;
import com.ammob.communication.core.service.UserManager;
import com.ammob.communication.webapp.form.UserForm;
import com.ammob.communication.webapp.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
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
 *
 * <p><a href="UserFormController.java.html"><i>View Source</i></a>
 */
@Controller
@RequestMapping("/user/profile*")
public class UserFormController extends BaseFormController {
    private RoleManager roleManager;

    @Autowired
    public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    public UserFormController() {
        setCancelView("redirect:/home");
        setSuccessView("redirect:/admin/users");
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(UserForm userForm, BindingResult errors, HttpServletRequest request,
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
            validator.validate(userForm, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "user/profile";
            }
        }

        log.debug("entering 'onSubmit' method...");

        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            getUserManager().removeUser(userForm.getId().toString());
            saveMessage(request, getText("user.deleted", userForm.getNickname(), locale));

            return getSuccessView();
        } else {

            // only attempt to change roles if user is admin for other users,
            // showForm() method will handle populating
            if (request.isUserInRole(Constants.ROLE_ADMIN)) {
                String[] userRoles = request.getParameterValues("userRoles");

                if (userRoles != null) {
                    userForm.getRoles().clear();
                    for (String roleName : userRoles) {
                        userForm.addRole(roleManager.getRole(roleName));
                    }
                }
            } else {
                // if user is not an admin then load roles from the database
                // (or any other user properties that should not be editable 
                // by users without admin role) 
                User cleanUser = getUserManager().getUserByUsername(
                        request.getRemoteUser());
                userForm.setRoles(cleanUser.getRoles());
            }

            Integer originalVersion = userForm.getVersion();

            try {
                getUserManager().saveUser(UserForm.fromConsumerUserForm(userForm));
            } catch (AccessDeniedException ade) {
                // thrown by UserSecurityAdvice configured in aop:advisor userManagerSecurity
                log.warn(ade.getMessage());
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                return null;
            } catch (UserExistsException e) {
                errors.rejectValue("username", "errors.existing.user",
                        new Object[]{userForm.getUsername(), userForm.getEmail()}, "duplicate user");

                // redisplay the unencrypted passwords
                userForm.setPassword(userForm.getConfirmPassword());
                // reset the version # to what was passed in
                userForm.setVersion(originalVersion);

                return "user/profile";
            } catch (Exception e) {
                errors.rejectValue("username", "errors.token", new Object[]{}, "errors : " + e.getMessage());

                // redisplay the unencrypted passwords
                userForm.setPassword(userForm.getConfirmPassword());
                // reset the version # to what was passed in
                userForm.setVersion(originalVersion);

                return "user/profile";
            }

            if (!StringUtils.equals(request.getParameter("from"), "list")) {
                saveMessage(request, getText("user.saved", userForm.getNickname(), locale));

                // return to main Menu
                return getCancelView();
            } else {
                if (StringUtils.isBlank(request.getParameter("version"))) {
                    saveMessage(request, getText("user.added", userForm.getNickname(), locale));

                    // Send an account information e-mail
                    message.setSubject(getText("signup.email.subject", locale));

                    try {
                        sendUserMessage(userForm, getText("newuser.email.message", userForm.getNickname(), locale),
                                RequestUtil.getAppURL(request));
                    } catch (MailException me) {
                        saveError(request, me.getCause().getLocalizedMessage());
                    }

                    return getSuccessView();
                } else {
                    saveMessage(request, getText("user.updated.byAdmin", userForm.getNickname(), locale));
                }
            }
        }

        return "user/profile";
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected UserForm showForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // If not an administrator, make sure user is not trying to add or edit another user
        if (!request.isUserInRole(Constants.ROLE_ADMIN) && !isFormSubmission(request)) {
            if (isAdd(request) || request.getParameter("id") != null) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                log.warn("User '" + request.getRemoteUser() + "' is trying to edit user with id '" +
                        request.getParameter("id") + "'");

                throw new AccessDeniedException("You do not have permission to modify other users.");
            }
        }

        if (!isFormSubmission(request)) {
            String userId = request.getParameter("id");

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

            UserForm user;
            if (userId == null && !isAdd(request)) {
                user = UserForm.fromProviderUser(getUserManager().getUserByUsername(request.getRemoteUser()));
            } else if (!StringUtils.isBlank(userId) && !"".equals(request.getParameter("version"))) {
                user = UserForm.fromProviderUser(getUserManager().getUser(userId));
            } else {
                user = new UserForm();
                user.addRole(new Role(Constants.ROLE_USER));
            }

            user.setConfirmPassword(user.getPassword());

            return user;
        } else {
            // populate user object from database, so all fields don't need to be hidden fields in form
            return UserForm.fromProviderUser(getUserManager().getUser(request.getParameter("id")));
        }
    }

    private boolean isFormSubmission(HttpServletRequest request) {
        return request.getMethod().equalsIgnoreCase("post");
    }

    protected boolean isAdd(HttpServletRequest request) {
        String method = request.getParameter("method");
        return (method != null && method.equalsIgnoreCase("add"));
    }
}
