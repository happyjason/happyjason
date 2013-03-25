package com.ammob.communication.hr.exception;

/**
 * An exception that is thrown by classes wanting to trap unique 
 * constraint violations.  This is used to wrap Spring's 
 * DataIntegrityViolationException so it's checked in the web layer.
 */
public class PostExistsException extends Exception {
    private static final long serialVersionUID = 4050482305178810162L;

    /**
     * Constructor for PostExistsException.
     *
     * @param message exception message
     */
    public PostExistsException(final String message) {
        super(message);
    }
}
