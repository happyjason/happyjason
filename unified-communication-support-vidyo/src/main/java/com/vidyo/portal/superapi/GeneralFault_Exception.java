
package com.vidyo.portal.superapi;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.0
 * 2013-04-21T14:11:43.340+08:00
 * Generated source version: 2.7.0
 */

@WebFault(name = "GeneralFault", targetNamespace = "http://portal.vidyo.com/superapi/")
public class GeneralFault_Exception extends Exception {
    
    private com.vidyo.portal.superapi.GeneralFault generalFault;

    public GeneralFault_Exception() {
        super();
    }
    
    public GeneralFault_Exception(String message) {
        super(message);
    }
    
    public GeneralFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneralFault_Exception(String message, com.vidyo.portal.superapi.GeneralFault generalFault) {
        super(message);
        this.generalFault = generalFault;
    }

    public GeneralFault_Exception(String message, com.vidyo.portal.superapi.GeneralFault generalFault, Throwable cause) {
        super(message, cause);
        this.generalFault = generalFault;
    }

    public com.vidyo.portal.superapi.GeneralFault getFaultInfo() {
        return this.generalFault;
    }
}
