package com.ammob.communication.vidyo.service;

import java.util.List;

import com.ammob.communication.vidyo.model.Portal;

public interface PortalService {
	
	public List<Portal> findAllPortal();
	
	public Portal getPortalById(Long portalId);

	public void remove(Portal portal);

	public void save(Portal portal);
	
	public void update(Portal portal);

}
