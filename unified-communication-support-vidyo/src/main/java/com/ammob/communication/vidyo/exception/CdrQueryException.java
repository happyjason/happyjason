package com.ammob.communication.vidyo.exception;

/**
 * An exception that is thrown by classes wanting to trap unique 
 * constraint violations.  This is used to wrap Spring's 
 * DataIntegrityViolationException so it's checked in the web layer.
 */
public class CdrQueryException extends Exception {
	private static final long serialVersionUID = 6296333974735455431L;
	private int type = 0;
	/**
     * Constructor for UserExistsException.
     *
     * @param message exception message
     */
    public CdrQueryException(final String message) {
        super(message);
    }
    
	/**
     * Constructor for UserExistsException.
     *
     * @param message exception message
     * @param type exception type
     */
    public CdrQueryException(final String message, int type) {
        super(message);
        this.type = type;
    }
    
    /**
     * Get Type;
     * 0 : Normal, 1 : Date Before maturity
     * @return
     */
    public int getType(){
    	return this.type;
    }
}
