
package com.vidyo.portal.user.v1_1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.0
 * 2013-01-05T17:33:17.612+08:00
 * Generated source version: 2.7.0
 */

@WebFault(name = "GeneralFault", targetNamespace = "http://portal.vidyo.com/user/v1_1")
public class GeneralFault_Exception extends Exception {
    
    private com.vidyo.portal.user.v1_1.GeneralFault generalFault;

    public GeneralFault_Exception() {
        super();
    }
    
    public GeneralFault_Exception(String message) {
        super(message);
    }
    
    public GeneralFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneralFault_Exception(String message, com.vidyo.portal.user.v1_1.GeneralFault generalFault) {
        super(message);
        this.generalFault = generalFault;
    }

    public GeneralFault_Exception(String message, com.vidyo.portal.user.v1_1.GeneralFault generalFault, Throwable cause) {
        super(message, cause);
        this.generalFault = generalFault;
    }

    public com.vidyo.portal.user.v1_1.GeneralFault getFaultInfo() {
        return this.generalFault;
    }
}
