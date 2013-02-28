package com.ammob.communication.hr.service;

import com.ammob.communication.core.service.GenericManager;
import com.ammob.communication.hr.model.Post;

import javax.jws.WebService;

@WebService
public interface PostManager extends GenericManager<Post, Long> {
    
}