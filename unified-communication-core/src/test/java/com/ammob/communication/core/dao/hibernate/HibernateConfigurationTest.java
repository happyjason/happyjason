package com.ammob.communication.core.dao.hibernate;

import com.ammob.communication.core.dao.BaseDaoTestCase;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.EntityPersister;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

public class HibernateConfigurationTest extends BaseDaoTestCase {
    @Autowired
    @Qualifier("coreSessionFactory")
    SessionFactory sessionFactory;

    @Test
    public void testColumnMapping() throws Exception {
        Session session = sessionFactory.openSession();
        try {
            Map<?, ?> metadata = sessionFactory.getAllClassMetadata();
            for (Object o : metadata.values()) {
                EntityPersister persister = (EntityPersister) o;
                String className = persister.getEntityName();
                log.debug("Trying select * from: " + className);
                Query q = session.createQuery("from " + className + " c");
                q.iterate();
                log.debug("ok: " + className);
            }
        } finally {
            session.close();
        }
    }
}
