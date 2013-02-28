package com.ammob.communication.vidyo.dao.hibernate;

import java.util.List;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.util.RoutingDataSource;
import com.ammob.communication.vidyo.dao.ConferenceCallDao;
import com.ammob.communication.vidyo.model.ConferenceCall;

import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("conferenceCallDao")
@org.springframework.context.annotation.Scope(org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON)
public class ConferenceCallDaoHibernate extends VidyoDaoHibernate<ConferenceCall, Long> implements ConferenceCallDao {
    
    public ConferenceCallDaoHibernate() {
        super(ConferenceCall.class);
    }
    
    @Override
    public ConferenceCall loadConferenceCallById(String determineType, Long id) {
    	RoutingDataSource.setDetermineType(determineType);
        Session sess =  getSessionFactory().openSession();
		try {
			IdentifierLoadAccess byId = sess.byId(ConferenceCall.class);
			return (ConferenceCall) byId.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RoutingDataSource.setDetermineType(Constants.DEFAULT_DATASOUCE);
		}
        return null;
    }

	@Override
	public void removeConferenceCall(String determineType, Long id) {
		RoutingDataSource.setDetermineType(determineType);
        Session sess =  getSessionFactory().openSession();
        try {
			IdentifierLoadAccess byId = sess.byId(ConferenceCall.class);
			ConferenceCall entity = (ConferenceCall) byId.load(id);
			sess.delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RoutingDataSource.setDetermineType(Constants.DEFAULT_DATASOUCE);
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ConferenceCall> getConferenceCalls(String determineType, String sql) {
		RoutingDataSource.setDetermineType(determineType);
        Session session =  getSessionFactory().openSession();
        Query result = session.createQuery(sql);
        return result.list();
	}
}
