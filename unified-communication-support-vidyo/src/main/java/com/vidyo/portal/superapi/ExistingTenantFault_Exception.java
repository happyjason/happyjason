
package com.vidyo.portal.superapi;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.0
 * 2013-04-21T14:11:44.958+08:00
 * Generated source version: 2.7.0
 */

@WebFault(name = "ExistingTenantFault", targetNamespace = "http://portal.vidyo.com/superapi/")
public class ExistingTenantFault_Exception extends Exception {
    
    private com.vidyo.portal.superapi.ExistingTenantFault existingTenantFault;

    public ExistingTenantFault_Exception() {
        super();
    }
    
    public ExistingTenantFault_Exception(String message) {
        super(message);
    }
    
    public ExistingTenantFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingTenantFault_Exception(String message, com.vidyo.portal.superapi.ExistingTenantFault existingTenantFault) {
        super(message);
        this.existingTenantFault = existingTenantFault;
    }

    public ExistingTenantFault_Exception(String message, com.vidyo.portal.superapi.ExistingTenantFault existingTenantFault, Throwable cause) {
        super(message, cause);
        this.existingTenantFault = existingTenantFault;
    }

    public com.vidyo.portal.superapi.ExistingTenantFault getFaultInfo() {
        return this.existingTenantFault;
    }
}
