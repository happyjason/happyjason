package com.ammob.communication.unicom.xmlUtil;

import com.sun.xml.txw2.annotation.XmlElement;


public class AcceptRequest {

	
	private AcceptHeader acceptHeader;
	private AcceptBody acceptBody;
	public AcceptHeader getAcceptHeader() {
		return acceptHeader;
	}
	public void setAcceptHeader(AcceptHeader acceptHeader) {
		this.acceptHeader = acceptHeader;
	}
	public AcceptBody getAcceptBody() {
		return acceptBody;
	}
	public void setAcceptBody(AcceptBody acceptBody) {
		this.acceptBody = acceptBody;
	}
	
	
	
	
}
