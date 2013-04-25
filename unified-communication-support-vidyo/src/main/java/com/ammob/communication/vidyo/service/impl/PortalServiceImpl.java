package com.ammob.communication.vidyo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ammob.communication.vidyo.dao.PortalDao;
import com.ammob.communication.vidyo.model.Portal;
import com.ammob.communication.vidyo.service.PortalService;

@Service("protalService")
public class PortalServiceImpl implements PortalService {

	@Autowired
    PortalDao portalDao;

	public PortalDao getPortalDao() {
		return portalDao;
	}

	public void setPortalDao(PortalDao portalDao) {
		this.portalDao = portalDao;
	}

	@Override
	public List<Portal> findAllPortal() {
		return portalDao.findAllPortal();
	}

	@Override
	public Portal getPortalById(Long portalId) {
		// TODO Auto-generated method stub
		return portalDao.getPortalById(portalId);
	}

	@Override
	public void remove(Portal portal) {
		// TODO Auto-generated method stub
		portalDao.remove( portal);
	}

	@Override
	public void save(Portal portal) {
		// TODO Auto-generated method stub
		portalDao.save( portal);
	}

	@Override
	public void update(Portal portal) {
		portalDao.update( portal);
	}
	
	
    
	
}
