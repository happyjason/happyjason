package com.ammob.communication.hr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ammob.communication.hr.dao.PostDao;
import com.ammob.communication.hr.model.Post;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class PostManagerImplTest extends BaseManagerMockTestCase {
    private PostManagerImpl manager = null;
    private PostDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(PostDao.class);
        manager = new PostManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetPost() {
        log.debug("testing get...");

        final Long id = 7L;
        final Post post = new Post();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(post));
        }});

        Post result = manager.get(id);
        assertSame(post, result);
    }

    @Test
    public void testGetPosts() {
        log.debug("testing getAll...");

        final List<Post> posts = new ArrayList<Post>();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(posts));
        }});

        List<Post> result = manager.getAll();
        assertSame(posts, result);
    }

    @Test
    public void testSavePost() {
        log.debug("testing save...");

        final Post post = new Post();
        // enter all required fields
        post.setName("AkDgVkEhOwTbXyNnFfOhYwRvVaFcNkUxXhRsCmYkTiRcWyOfNsCkCxOfKqTa");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(post)));
        }});

        manager.save(post);
    }

    @Test
    public void testRemovePost() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}