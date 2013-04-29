package com.ammob.communication.vidyo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_ext_vidyo_portal")
public class Portal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8972114765574816332L;

	private Long id;
	
	private String portalUrl;
	
	private String portalName;
	
	private String portalPassword;

	private String status;
	
	private Set<Tenant> tenants = new HashSet<Tenant>();
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="portalurl",nullable = false)
	public String getPortalUrl() {
		return portalUrl;
	}

	public void setPortalUrl(String portalUrl) {
		this.portalUrl = portalUrl;
	}
	@Column(name="portalname",nullable = false)
	public String getPortalName() {
		return portalName;
	}

	public void setPortalName(String portalName) {
		this.portalName = portalName;
	}
	@Column(name="portalpassword",nullable = false)
	public String getPortalPassword() {
		return portalPassword;
	}

	public void setPortalPassword(String portalPassword) {
		this.portalPassword = portalPassword;
	}

	  @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	    @JoinTable(
	            name = "t_ext_portal_tenant",
	            joinColumns = { @JoinColumn(name = "portal_id") },
	            inverseJoinColumns = @JoinColumn(name = "tenant_id")
	    )
	   
	public Set<Tenant> getTenants() {
		return tenants;
	}

	public void setTenants(Set<Tenant> tenants) {
		this.tenants = tenants;
	}

	public String getStatus() {
		return status;
	}

	@Column
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
