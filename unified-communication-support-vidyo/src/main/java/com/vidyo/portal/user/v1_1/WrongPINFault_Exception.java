
package com.vidyo.portal.user.v1_1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.0
 * 2013-01-05T17:33:17.627+08:00
 * Generated source version: 2.7.0
 */

@WebFault(name = "WrongPINFault", targetNamespace = "http://portal.vidyo.com/user/v1_1")
public class WrongPINFault_Exception extends Exception {
    
    private com.vidyo.portal.user.v1_1.WrongPINFault wrongPINFault;

    public WrongPINFault_Exception() {
        super();
    }
    
    public WrongPINFault_Exception(String message) {
        super(message);
    }
    
    public WrongPINFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongPINFault_Exception(String message, com.vidyo.portal.user.v1_1.WrongPINFault wrongPINFault) {
        super(message);
        this.wrongPINFault = wrongPINFault;
    }

    public WrongPINFault_Exception(String message, com.vidyo.portal.user.v1_1.WrongPINFault wrongPINFault, Throwable cause) {
        super(message, cause);
        this.wrongPINFault = wrongPINFault;
    }

    public com.vidyo.portal.user.v1_1.WrongPINFault getFaultInfo() {
        return this.wrongPINFault;
    }
}
