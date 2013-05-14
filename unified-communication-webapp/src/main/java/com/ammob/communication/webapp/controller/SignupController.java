package com.ammob.communication.webapp.controller;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.exception.UserExistsException;
import com.ammob.communication.core.service.RoleManager;
import com.ammob.communication.webapp.form.UserForm;
import com.ammob.communication.webapp.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
 * Controller to signup new users.
 */
@Controller
@RequestMapping("/signup*")
public class SignupController extends BaseFormController {
    private RoleManager roleManager;

    @Autowired
    public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    public SignupController() {
        setCancelView("redirect:login");
        setSuccessView("redirect:home");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    public UserForm showForm() {
        return new UserForm();  
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(UserForm userForm, BindingResult errors, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(userForm, errors);

            if (errors.hasErrors()) {
                return "signup";
            }
        }

        Locale locale = request.getLocale();
        
        userForm.setEnabled(true);

        // Set the default user role on this new user
        userForm.addRole(roleManager.getRole(Constants.ROLE_USER));

        try {
            this.getUserManager().saveUser(UserForm.fromConsumerUserForm(userForm));
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
            return "signup";
        }

        saveMessage(request, getText("user.registered", userForm.getUsername(), locale));
        request.getSession().setAttribute(Constants.REGISTERED, Boolean.TRUE);

        // log user in automatically
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                userForm.getUsername(), userForm.getConfirmPassword(), userForm.getAuthorities());
        auth.setDetails(userForm);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Send user an e-mail
        if (log.isDebugEnabled()) {
            log.debug("Sending user '" + userForm.getUsername() + "' an account information e-mail");
        }

        // Send an account information e-mail
        message.setSubject(getText("signup.email.subject", locale));

        try {
            sendUserMessage(userForm, getText("signup.email.message", locale), RequestUtil.getAppURL(request));
        } catch (MailException me) {
            saveError(request, me.getMostSpecificCause().getMessage());
        }
        return getSuccessView();
    }
}
