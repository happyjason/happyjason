package com.ammob.communication.unicom.xmlUtil;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root")
public class AcceptResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3237626637785229189L;
	
	
	private String StreamingNo;
	private String TimeStamp;
	private String ResultCode;
	private String ResultMsg;
	public String getStreamingNo() {
		return StreamingNo;
	}
	public void setStreamingNo(String streamingNo) {
		StreamingNo = streamingNo;
	}
	public String getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		TimeStamp = timeStamp;
	}
	public String getResultCode() {
		return ResultCode;
	}
	public void setResultCode(String resultCode) {
		ResultCode = resultCode;
	}
	public String getResultMsg() {
		return ResultMsg;
	}
	public void setResultMsg(String resultMsg) {
		ResultMsg = resultMsg;
	}
	
	
	
	
	
}
