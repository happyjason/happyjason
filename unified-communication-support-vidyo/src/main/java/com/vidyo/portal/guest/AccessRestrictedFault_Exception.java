
package com.vidyo.portal.guest;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.0
 * 2013-01-05T16:43:30.819+08:00
 * Generated source version: 2.7.0
 */

@WebFault(name = "AccessRestrictedFault", targetNamespace = "http://portal.vidyo.com/guest")
public class AccessRestrictedFault_Exception extends Exception {
    
    private com.vidyo.portal.guest.AccessRestrictedFault accessRestrictedFault;

    public AccessRestrictedFault_Exception() {
        super();
    }
    
    public AccessRestrictedFault_Exception(String message) {
        super(message);
    }
    
    public AccessRestrictedFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessRestrictedFault_Exception(String message, com.vidyo.portal.guest.AccessRestrictedFault accessRestrictedFault) {
        super(message);
        this.accessRestrictedFault = accessRestrictedFault;
    }

    public AccessRestrictedFault_Exception(String message, com.vidyo.portal.guest.AccessRestrictedFault accessRestrictedFault, Throwable cause) {
        super(message, cause);
        this.accessRestrictedFault = accessRestrictedFault;
    }

    public com.vidyo.portal.guest.AccessRestrictedFault getFaultInfo() {
        return this.accessRestrictedFault;
    }
}
