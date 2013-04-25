package com.ammob.communication.vidyo.dao.hibernate;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.ammob.communication.core.Constants;
import com.ammob.communication.core.util.RoutingDataSource;
import com.ammob.communication.vidyo.dao.PortalDao;
import com.ammob.communication.vidyo.model.Portal;

@Repository("portalDao")
public class PortalDaoHibernate extends VidyoDaoHibernate<Portal, Long> implements PortalDao {

	  public PortalDaoHibernate() {
	        super(Portal.class);
	        RoutingDataSource.setDetermineType(Constants.DEFAULT_DATASOUCE);
	    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Portal> findAllPortal() {
		
		return this.getSession().createQuery("from Portal").list();
	}

	@Override
	public Portal getPortalById(Long portalId) {
		return (Portal) this.getSession().get(Portal.class,portalId );
	}

	@Override
	public void update(Portal portal) {
		this.getSession().merge(portal);
	}
	    

	

}
