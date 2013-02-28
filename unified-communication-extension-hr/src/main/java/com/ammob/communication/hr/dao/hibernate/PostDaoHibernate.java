package com.ammob.communication.hr.dao.hibernate;

import com.ammob.communication.hr.model.Post;
import com.ammob.communication.hr.dao.PostDao;
import com.ammob.communication.core.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("postDao")
public class PostDaoHibernate extends GenericDaoHibernate<Post, Long> implements PostDao {

    public PostDaoHibernate() {
        super(Post.class);
    }
}
