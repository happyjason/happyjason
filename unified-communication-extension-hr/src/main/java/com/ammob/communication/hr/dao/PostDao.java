package com.ammob.communication.hr.dao;

import com.ammob.communication.core.dao.GenericDao;

import com.ammob.communication.hr.model.Post;

/**
 * An interface that provides a data management interface to the Post table.
 */
public interface PostDao extends GenericDao<Post, Long> {

    /**
     * Saves a post's information.
     * @param post the object to be saved
     * @return the persisted Post object
     */
    Post savePost(Post post);
}