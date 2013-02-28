package com.ammob.communication.vidyo.service.impl;

import com.ammob.communication.core.service.impl.GenericManagerImpl;
import com.ammob.communication.vidyo.dao.TenantDao;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.service.TenantManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("tenantManager")
@WebService(serviceName = "TenantService", endpointInterface = "com.ammob.communication.vidyo.service.TenantManager")
public class TenantManagerImpl extends GenericManagerImpl<Tenant, Long> implements TenantManager {
    TenantDao tenantDao;

    @Autowired
    public TenantManagerImpl(TenantDao tenantDao) {
        super(tenantDao);
        this.tenantDao = tenantDao;
    }

    /**
     * {@inheritDoc}
     */
	public Tenant creatTenants(Tenant tenant) {
		return tenantDao.save(tenant);
	}
	
    /**
     * {@inheritDoc}
     */
	public Tenant getTenant(String tenantId) {
		Long _tenantId = 0L;
		try {
			_tenantId = Long.valueOf(tenantId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
		return tenantDao.get(_tenantId);
	}
	
    /**
     * {@inheritDoc}
     */
	public List<Tenant> getTenants() {
		return tenantDao.getAllDistinct();
	}

    /**
     * {@inheritDoc}
     */
	public List<Tenant> search(String searchTerm) {
		 return super.search(searchTerm, Tenant.class);
	}
}