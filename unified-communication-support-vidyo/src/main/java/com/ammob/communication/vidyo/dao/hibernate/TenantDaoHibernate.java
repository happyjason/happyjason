package com.ammob.communication.vidyo.dao.hibernate;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.util.RoutingDataSource;
import com.ammob.communication.vidyo.dao.TenantDao;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.dao.hibernate.VidyoDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("tenantDao")
public class TenantDaoHibernate extends VidyoDaoHibernate<Tenant, Long> implements TenantDao {

    public TenantDaoHibernate() {
        super(Tenant.class);
        RoutingDataSource.setDetermineType(Constants.DEFAULT_DATASOUCE);
    }
    
    /**
     * {@inheritDoc}
     */
    public Tenant saveTenant(Tenant tenant) {
        if (log.isDebugEnabled()) {
            log.debug("tenant's id: " + tenant.getId());
        }
        getSession().saveOrUpdate(tenant);
        // necessary to throw a DataIntegrityViolation and catch it in TenantManager
        getSession().flush();
        return tenant;
    }
}
