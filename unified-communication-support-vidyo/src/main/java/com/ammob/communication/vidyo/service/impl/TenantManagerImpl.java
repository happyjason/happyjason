package com.ammob.communication.vidyo.service.impl;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.service.impl.GenericManagerImpl;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.dao.TenantDao;
import com.ammob.communication.vidyo.exception.CdrQueryException;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.service.TenantManager;
import com.ammob.communication.vidyo.service.TenantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@Service("tenantManager")
@WebService(serviceName = "TenantService", endpointInterface = "com.ammob.communication.vidyo.service.TenantService")
public class TenantManagerImpl extends GenericManagerImpl<Tenant, Long> implements TenantManager, TenantService {
	
    TenantDao tenantDao;
    
	@Autowired
    public TenantManagerImpl(TenantDao tenantDao) {
        super(tenantDao);
        this.tenantDao = tenantDao;
    }
	
    /**
     * {@inheritDoc}
     * @throws CdrQueryException 
     */
	public List<Map<String, Object>> getCallDetailRecordList(String tenantId) throws CdrQueryException {
		return getCallDetailRecordList(tenantId, "WHERE 1=1 LIMIT 10000");
	}
	
    /**
     * {@inheritDoc}
     * @throws CdrQueryException 
     */
	public List<Map<String, Object>> getCallDetailRecordList(String tenantId, String searchTerm) throws CdrQueryException {
		try {
			if(!checkCdrState(tenantId))
				throw new CdrQueryException("Cdr State Check Fail !!!");
			Tenant tenant = get(Long.valueOf(tenantId));
			JdbcTemplate jdbcTemplate = new JdbcTemplate(new SimpleDriverDataSource(new com.mysql.jdbc.Driver(),
				"jdbc:mysql://" + tenant.getUrl() + "/portal2?useUnicode=true&amp;amp;characterEncoding=utf-8", 
					Constants.CDR_USERNAME, tenant.getCdrPassword()));
			List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from ConferenceCall2 ".concat(searchTerm));
			return result;
		} catch (SQLException e) {
			throw new CdrQueryException(e.getMessage());
		} catch (DataAccessException e) {
			throw new CdrQueryException(e.getMessage());
		} catch (Exception e) {
			throw new CdrQueryException(e.getMessage());
		}
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
	
	/**
     * {@inheritDoc}
     */
	public boolean checkCdrState(String tenantId){
		Long _id = null;
		try {
			_id = Long.valueOf(tenantId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		Tenant tenant = get(_id);
		if(tenant.isCdr() && StringUtil.hasText(tenant.getCdrPassword()) && StringUtil.hasText(tenant.getUrl()))
			return true;
		return false;
	}
}