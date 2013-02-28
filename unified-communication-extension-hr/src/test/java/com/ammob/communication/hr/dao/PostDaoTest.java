package com.ammob.communication.hr.dao;

import com.ammob.communication.hr.model.Post;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

public class PostDaoTest extends BaseDaoTestCase {
    @Autowired
    private PostDao postDao;

    @Test(expected = DataAccessException.class)
    public void testAddAndRemovePost() {
        Post post = new Post();

        // enter all required fields
        post.setName("YaKgUqIkDtPiUoAoGeLaSxQtAhEoFsFpEpEfUlSiAoQzEuYvEkBgPfBiSjXx");

        log.debug("adding post...");
        post = postDao.save(post);

        post = postDao.get(post.getId());

        assertNotNull(post.getId());

        log.debug("removing post...");

        postDao.remove(post.getId());

        // should throw DataAccessException 
        postDao.get(post.getId());
    }
}