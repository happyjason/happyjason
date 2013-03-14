package com.ammob.communication.hr.dao.hibernate;

import com.ammob.communication.hr.model.Post;
import com.ammob.communication.hr.dao.PostDao;
import org.springframework.stereotype.Repository;

@Repository("postDao")
public class PostDaoHibernate extends HrDaoHibernate<Post, Long> implements PostDao {

    public PostDaoHibernate() {
        super(Post.class);
    }
}
