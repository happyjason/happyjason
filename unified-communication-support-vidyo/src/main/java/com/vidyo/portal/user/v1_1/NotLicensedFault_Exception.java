
package com.vidyo.portal.user.v1_1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.0
 * 2013-01-05T17:33:17.607+08:00
 * Generated source version: 2.7.0
 */

@WebFault(name = "NotLicensedFault", targetNamespace = "http://portal.vidyo.com/user/v1_1")
public class NotLicensedFault_Exception extends Exception {
    
    private com.vidyo.portal.user.v1_1.NotLicensedFault notLicensedFault;

    public NotLicensedFault_Exception() {
        super();
    }
    
    public NotLicensedFault_Exception(String message) {
        super(message);
    }
    
    public NotLicensedFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public NotLicensedFault_Exception(String message, com.vidyo.portal.user.v1_1.NotLicensedFault notLicensedFault) {
        super(message);
        this.notLicensedFault = notLicensedFault;
    }

    public NotLicensedFault_Exception(String message, com.vidyo.portal.user.v1_1.NotLicensedFault notLicensedFault, Throwable cause) {
        super(message, cause);
        this.notLicensedFault = notLicensedFault;
    }

    public com.vidyo.portal.user.v1_1.NotLicensedFault getFaultInfo() {
        return this.notLicensedFault;
    }
}
