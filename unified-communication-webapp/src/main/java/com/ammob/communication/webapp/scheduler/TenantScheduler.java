package com.ammob.communication.webapp.scheduler;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ammob.communication.vidyo.service.TenantManager;
import com.ammob.communication.webapp.util.FtpUtil;

public class TenantScheduler {
	
	@Autowired
	private TenantManager tenantManager;
	
	private static long executeId;
	/**
	 * 
	 */
	public void execute(){
		executeId++;
		//System.out.println(executeId);
	}
	
	private void uploadFtp() {
	    try {
	        InputStream input = new ByteArrayInputStream("0003	02	20120830105810	902	104	20120830105810	20120830105810	00001	0002											0						55555555555T	057156077177			2012-08-30 09:54:25	2012-08-30 09:55:13	48	0	0	0	0	0	".getBytes("utf-8"));  
	        boolean flag = FtpUtil.uploadFile("123.157.223.235", 21, "bill_test", "bill_test", "/home/bill_home/test/voice/request", "20T08201208301058100004.req", input);  
	        System.out.println(flag);
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	}

	public TenantManager getTenantManager() {
		return tenantManager;
	}

	public void setTenantManager(TenantManager tenantManager) {
		this.tenantManager = tenantManager;
	}
}
