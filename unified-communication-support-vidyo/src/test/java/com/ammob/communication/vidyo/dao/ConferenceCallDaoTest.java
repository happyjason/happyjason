package com.ammob.communication.vidyo.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.util.PropertyUtil;
import com.ammob.communication.core.util.RoutingDataSource;
import com.ammob.communication.vidyo.model.ConferenceCall;

import static org.junit.Assert.*;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.Transactional;
@Transactional("vidyoTransactionManager")
public class ConferenceCallDaoTest extends BaseDaoTestCase {

	private final static String TEST_CDR_SOURCE_NAME = "cdrDataSource";
	
    @Autowired
    private ConferenceCallDao conferenceCallDao;
    
    @Autowired
    @Qualifier("vidyoDynamicDataSource")
    private RoutingDataSource dynamicDataSource;
    
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

	/**
	 * @throws Exception
	 */
    @PostConstruct
	public void before() {
		log.info("before run junit test class, setting....! ");
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		targetDataSources.put(Constants.DEFAULT_DATASOUCE, dataSource);
		DataSource cdrDataSource;
		try {
			cdrDataSource = new SimpleDriverDataSource(new com.mysql.jdbc.Driver(),
					PropertyUtil.getString("cdr.url"),
					PropertyUtil.getString("cdr.username"),
					PropertyUtil.getString("cdr.password"));
			targetDataSources.put(TEST_CDR_SOURCE_NAME, cdrDataSource);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dynamicDataSource.setTargetDataSources(targetDataSources);
		dynamicDataSource.afterPropertiesSet();
	}

    @Test
    public void testGetConferenceCall() {
    	ConferenceCall cc_1 = conferenceCallDao.loadConferenceCallById(Constants.DEFAULT_DATASOUCE, 1L);
    	log.info("ConferenceCall for " + Constants.DEFAULT_DATASOUCE + " : " + cc_1);
    	ConferenceCall cc_2 = conferenceCallDao.loadConferenceCallById(TEST_CDR_SOURCE_NAME, 1L);
    	ConferenceCall cc_3 = conferenceCallDao.loadConferenceCallById(TEST_CDR_SOURCE_NAME + "dkghp", 131L);
    	if(cc_1 != null)
    		assertNotSame(cc_1, cc_2);
    	else
    		assertNotNull(cc_2);
    	assertNull(cc_3);
    }
    
    @Test
    public void testQueryConferenceCall() {
    	//String sql = "from ConferenceCall c where CallID=1";
    	String sql = "from ConferenceCall c where JoinTime > '2013-01-01' AND JoinTime < '2013-01-05'";
    	List<ConferenceCall> result = conferenceCallDao.getConferenceCalls(TEST_CDR_SOURCE_NAME, sql);
    	log.info("result size : " + result.size());
    	for(ConferenceCall cc : result){
    		log.info(cc.toString());
    	}
    }
}