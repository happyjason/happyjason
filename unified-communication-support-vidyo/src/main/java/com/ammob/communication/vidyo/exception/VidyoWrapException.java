package com.ammob.communication.vidyo.exception;

public class VidyoWrapException extends Exception {
	private static final long serialVersionUID = 3008032480432012734L;
	private Exception wrap;
	
    public VidyoWrapException(Exception e) {
        super(e.getMessage(), e.getCause());
        wrap = e;
    }
    
    public Exception getWrap(){
    	return wrap;
    }
}
