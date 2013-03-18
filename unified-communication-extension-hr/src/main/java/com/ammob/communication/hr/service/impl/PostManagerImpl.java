package com.ammob.communication.hr.service.impl;

import com.ammob.communication.hr.dao.PostDao;
import com.ammob.communication.hr.exception.PostExistsException;
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

    /**
     * {@inheritDoc}
     */
	public Post savePost(Post post) throws PostExistsException {
        if (post.getVersion() == null) {
        	post.setVersion(0);
        }
        post.setVersion(post.getVersion() + 1);
        try {
            return postDao.savePost(post);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new PostExistsException("Post '" + post.getName() + "' already exists!");
        }
	}
}