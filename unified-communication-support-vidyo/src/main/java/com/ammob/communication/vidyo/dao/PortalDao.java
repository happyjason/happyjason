package com.ammob.communication.vidyo.dao;

import java.util.List;

import com.ammob.communication.core.dao.GenericDao;
import com.ammob.communication.vidyo.model.Portal;


public interface PortalDao extends GenericDao<Portal, Long> {

	

	public List<Portal>findAllPortal();

	public Portal getPortalById(Long portalId);
	
	public void update(Portal portal);
	
}
