package com.ammob.communication.vidyo.service.impl;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.enumeration.Month;
import com.ammob.communication.core.service.impl.GenericManagerImpl;
import com.ammob.communication.core.util.DateUtil;
import com.ammob.communication.core.util.StringUtil;
import com.ammob.communication.vidyo.dao.TenantDao;
import com.ammob.communication.vidyo.exception.CdrQueryException;
import com.ammob.communication.vidyo.model.Tenant;
import com.ammob.communication.vidyo.service.TenantManager;
import com.ammob.communication.vidyo.service.TenantService;
import com.ammob.communication.vidyo.util.ChinaUnitedSIUtil;
import com.ammob.communication.vidyo.util.FtpUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.util.Date;
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
	public List<Map<String, Object>> getCallDetailRecordList(Tenant tenant) throws CdrQueryException {
		return getCallDetailRecordList(tenant, "WHERE 1=1 LIMIT 10000");
	}
	
    /**
     * {@inheritDoc}
     * @throws CdrQueryException 
     */
	public List<Map<String, Object>> getCallDetailRecordList(Tenant tenant, Date startDate, Date endDate) throws CdrQueryException {
		String startDateStr = DateUtil.getDate("yyyy-MM-dd HH:mm:ss", startDate);
		String endDateStr = DateUtil.getDate("yyyy-MM-dd HH:mm:ss", endDate);
		return getCallDetailRecordList(tenant, "WHERE JoinTime>'" + startDateStr + "' AND JoinTime<'" + endDateStr + "'");
	}
	
    /**
     * {@inheritDoc}
     * @throws CdrQueryException 
     */
	public List<Map<String, Object>> getCallDetailRecordList(Tenant tenant, String searchTerm) throws CdrQueryException {
		if(!checkCdrState(tenant))
			throw new CdrQueryException("Cdr State Check Fail !!! tenant:" + tenant);
		try {
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
	 * Check Tenant Cdr State
	 * @param tenant
	 * @return
	 */
	private boolean checkCdrState(Tenant tenant){
		if(tenant.isAllowedOfCdr() && StringUtil.hasText(tenant.getCdrPassword()) && StringUtil.hasText(tenant.getUrl()))
			return true;
		return false;
	}
	
	/**
     * {@inheritDoc}
	 * @throws Exception 
     */
	public boolean handleCallDetailRecordUpload(Tenant tenant) throws CdrQueryException {
		Date date = tenant.getCdrSynchroTime();
		if((date == null) || (DateUtil.getYear(date) < 2012))
			date = new Date(System.currentTimeMillis() - 2592000000L); // 3600*24*30, a month ago
		List<Map<String, Object>> result = null;
		Date processDate = new Date(System.currentTimeMillis());
		if(DateUtil.getMonth(date) == DateUtil.getMonth(processDate))
			throw new CdrQueryException("This date hasn't arrived, please wait next month !", 1);
		try {
			Date nextDate = DateUtil.getNextCycleMonth(date);
			result = getCallDetailRecordList(tenant, date, nextDate);
			String paymentDayId = String.valueOf(tenant.getPaymentDays());
			if(tenant.getPaymentDays() < 1 || tenant.getPaymentDays() > 9999) { // 边界检查
				paymentDayId = "0001";
				tenant.setPaymentDays(1);
			}
			while(paymentDayId.length() < 4){ // 补位
				paymentDayId = "0".concat(paymentDayId);
			}
			String fileName = ChinaUnitedSIUtil.getBillFileName(Month.valueOf(DateUtil.getMonth(date))
					, "", paymentDayId, processDate);
			log.info("upload file name is " + fileName);
			boolean flag = FtpUtil.uploadFile("123.157.223.235", 21, "bill_test", "bill_test",
				"/home/bill_home/test/voice/request", fileName, new ByteArrayInputStream(
						ChinaUnitedSIUtil.getBillFileContent(paymentDayId, date, nextDate, result, processDate
							).getBytes()));
			if(flag) { // 打完收工
				tenant.setPaymentDays(tenant.getPaymentDays() + 1);
				tenant.setCdrSynchroTime(processDate);
				tenant.setCdrSchedulerTime(DateUtil.getNextCycleMonth(processDate));
				save(tenant);
				return true;
			}
		} catch (Exception e) {
			throw new CdrQueryException(e.getMessage());
		}
		return false;
	}

}