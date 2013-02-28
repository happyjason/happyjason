package com.ammob.communication.core.dao.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ammob.communication.core.dao.LookupDao;
import com.ammob.communication.core.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Session;

/**
 * Hibernate implementation of LookupDao.
 */
@Repository
public class LookupDaoHibernate implements LookupDao {
    private Log log = LogFactory.getLog(LookupDaoHibernate.class);
    private final SessionFactory sessionFactory;

    /**
     * Initialize LookupDaoHibernate with Hibernate SessionFactory.
     * @param sessionFactory
     */
    @Autowired
    public LookupDaoHibernate(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Role> getRoles() {
        log.debug("Retrieving all role names...");
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Role.class).list();
    }
}
