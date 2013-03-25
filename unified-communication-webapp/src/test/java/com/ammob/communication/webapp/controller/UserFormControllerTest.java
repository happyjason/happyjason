package com.ammob.communication.webapp.controller;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.model.User;
import com.ammob.communication.core.service.UserManager;
import com.ammob.communication.webapp.form.UserForm;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import static org.junit.Assert.*;

public class UserFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private UserFormController c = null;
    private MockHttpServletRequest request;
    private User user;

    @Test
    public void testAdd() throws Exception {
        log.debug("testing add new user...");
        request = newGet("/userform.html");
        request.addParameter("method", "Add");
        request.addUserRole(Constants.ADMIN_ROLE);

        user = c.showForm(request, new MockHttpServletResponse());
        assertNull(user.getUsername());
    }

    @Test
    public void testAddWithoutPermission() throws Exception {
        log.debug("testing add new user...");
        request = newGet("/userform.html");
        request.addParameter("method", "Add");

        try {
            c.showForm(request, new MockHttpServletResponse());
            fail("AccessDeniedException not thrown...");
        } catch (AccessDeniedException ade) {
            assertNotNull(ade.getMessage());
        }     
    }

    @Test
    public void testCancel() throws Exception {
        log.debug("testing cancel...");
        request = newPost("/userform.html");
        request.addParameter("cancel", "");
        UserForm userForm = UserForm.fromProviderUser(user);
        BindingResult errors = new DataBinder(userForm).getBindingResult();
        String view = c.onSubmit(userForm, errors, request, new MockHttpServletResponse());

        assertEquals("redirect:/home", view);
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/userform.html");
        request.addParameter("id", "1"); // regular user
        request.addUserRole(Constants.ADMIN_ROLE);

        User user = c.showForm(request, new MockHttpServletResponse());
        assertEquals("Mob", user.getNickname());
    }

    @Test
    public void testEditWithoutPermission() throws Exception {
        log.debug("testing edit...");
        request = newGet("/userform.html");
        request.addParameter("id", "1"); // regular user

        try {
            c.showForm(request, new MockHttpServletResponse());
            fail("AccessDeniedException not thrown...");
        } catch (AccessDeniedException ade) {
            assertNotNull(ade.getMessage());
        }
    }

    @Test
    public void testEditProfile() throws Exception {
        log.debug("testing edit profile...");
        request = newGet("/userform.html");
        request.setRemoteUser("mupeng");

        user = c.showForm(request, new MockHttpServletResponse());
        assertEquals("Vastar", user.getNickname());
    }

    @Test
    public void testSave() throws Exception {
        request = newPost("/userform.html");
        // set updated properties first since adding them later will
        // result in multiple parameters with the same name getting sent
        User user = ((UserManager) applicationContext.getBean("userManager")).getUser("1");
        UserForm userForm = UserForm.fromProviderUser(user);
        userForm.setConfirmPassword(user.getPassword());
        userForm.setLastName("Updated Last Name");

        request.setRemoteUser(user.getUsername());

        BindingResult errors = new DataBinder(user).getBindingResult();
        c.onSubmit(userForm, errors, request, new MockHttpServletResponse());

        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testAddWithMissingFields() throws Exception {
        request = newPost("/userform.html");
        user = new User();
        user.setNickname("Jack");
        request.setRemoteUser("mupeng");

        BindingResult errors = new DataBinder(user).getBindingResult();
        c.onSubmit(UserForm.fromProviderUser(user), errors, request, new MockHttpServletResponse());
        
        assertTrue(errors.getAllErrors().size() > 0);
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/userform.html");
        request.addParameter("delete", "");
        user = new User();
        user.setId(2L);

        BindingResult errors = new DataBinder(user).getBindingResult();
        c.onSubmit(UserForm.fromProviderUser(user), errors, request, new MockHttpServletResponse());
        
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
