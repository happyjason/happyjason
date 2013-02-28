package com.ammob.communication.webapp.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.service.UserManager;

import static org.junit.Assert.*;

public class UserControllerTest extends BaseControllerTestCase {
    @Autowired
    private UserController c;

    @Test
    public void testHandleRequest() throws Exception {
        ModelAndView mav = c.handleRequest(null);
        Map<String, Object> m = mav.getModel();
        assertNotNull(m.get(Constants.USER_LIST));
        assertEquals("admin/userList", mav.getViewName());
    }

    @Test
    public void testSearch() throws Exception {
        // reindex before searching
        UserManager userManager = (UserManager) applicationContext.getBean("userManager");
        userManager.reindex();

        ModelAndView mav = c.handleRequest("admin");
        Map<String, Object> m = mav.getModel();
        List<?> results = (List<?>) m.get(Constants.USER_LIST);
        assertNotNull(results);
        assertTrue(results.size() >= 1);
        assertEquals("admin/userList", mav.getViewName());
    }
}
