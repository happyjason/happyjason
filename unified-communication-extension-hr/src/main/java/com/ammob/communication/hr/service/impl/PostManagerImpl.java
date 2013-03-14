package com.ammob.communication.hr.service.impl;

import com.ammob.communication.hr.dao.PostDao;
import com.ammob.communication.hr.model.Post;
import com.ammob.communication.hr.service.PostManager;
import com.ammob.communication.core.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("postManager")
@WebService(serviceName = "PostService", endpointInterface = "com.ammob.communication.core.service.PostManager")
public class PostManagerImpl extends GenericManagerImpl<Post, Long> implements PostManager {
    PostDao postDao;

    @Autowired
    public PostManagerImpl(PostDao postDao) {
        super(postDao);
        this.postDao = postDao;
    }
    
    /**
     * {@inheritDoc}
     */
	public List<Post> search(String searchTerm) {
		 return super.search(searchTerm, Post.class);
	}
}