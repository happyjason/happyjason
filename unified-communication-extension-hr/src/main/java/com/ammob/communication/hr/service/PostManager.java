package com.ammob.communication.hr.service;

import java.util.List;

import com.ammob.communication.core.service.GenericManager;
import com.ammob.communication.hr.model.Post;

import javax.jws.WebService;

@WebService
public interface PostManager extends GenericManager<Post, Long> {
	
    /**
     * Search a user for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Post> search(String searchTerm);
}