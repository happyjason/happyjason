package com.ammob.communication.vidyo.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.ConversionException;

import com.ammob.communication.core.enumeration.Month;
import com.ammob.communication.core.util.DateUtil;
import com.ammob.communication.core.util.PropertyUtil;
import com.ammob.communication.core.util.StringUtil;

public class ChinaUnitedSIUtil {
	
	/**
	 * Get Bill File Name
	 * 
	 * e.g ： 20T082011101116250001.req 
	 * 			TTFMMYYYYMMDDHHMISIDXXXX.SUF
	 * 文件类型（2位）+ 文件标志（1位）+ 帐务周期月份（2位）+ 文件产生的时间（精确到年月日时分）+ 
	 * SSID（3位）+ 序列号（4位）＋.后缀
	 * 
	 * @param month
	 * @param SSID
	 * @param serialId
	 * @return 话单文件名命名
	 */
	public static String getBillFileName(Month month, String SSID, String serialId, Date processDate) throws NumberFormatException, ConversionException {
		if(!checkSSID(serialId))
			throw new NumberFormatException(serialId + "format fail !");
		return "20" + PropertyUtil.getString("current.platform.mode", "T") + month.getPlaceholderValue() + 
				DateUtil.getDate("YYYYMMddHHmmss", processDate) + SSID + serialId + ".req";
	}
	
	/**
	 * Get Bill File Head
	 * 
	 * e.g : 0001022011090323595990210420110914130913201108312359590000000001
	 * 
	 * @param serialId
	 * @param starTime
	 * @param endTime
	 * @param recordId
	 * @return
	 */
	public static String getBillFileHead(String serialId, Date starTime, Date endTime, String recordLine, Date processDate) 
			throws NumberFormatException, ConversionException {
		if(!checkSSID(serialId) || !checkRecordId(recordLine))
			throw new NumberFormatException("format fail ! serialId : " + serialId + ", recordLine : " + recordLine);
		return serialId + "02" + DateUtil.getDate("YYYYMMddHHmmss", processDate) + "902" + "104" + 
			DateUtil.getDate("YYYYMMddHHmmss", starTime) + DateUtil.getDate("YYYYMMddHHmmss", endTime) + 
				recordLine + "\n";
	}
	
	/**
	 * Get Bill File Body
	 * @param serialId
	 * @param startCallTime
	 * @param endCallTime
	 * @return
	 */
	public static String getBillFileBody(String serialId, Date startCallTime, Date endCallTime, Date processDate){
		if(!checkSSID(serialId))
			throw new NumberFormatException(serialId + "format fail !");
		return DateUtil.getDate("YYYYMMddHHmmss", processDate) + serialId + "\t" + 
			DateUtil.getDate("YYYYMMddHHmmss", processDate) + "\t\t" + // MessageID
			PropertyUtil.getString("current.platform.spid", "62189") + "\t" +
			PropertyUtil.getString("current.platform.sid", "17360018") + "\t\t\t" +  // CPID ContentID
			PropertyUtil.getString("current.platform.accessNo", "10655057890") + "\t" + 
			PropertyUtil.getString("current.platform.serviceType", "42") + "\t\t\t\t" + // SourceDevice_Type SourceDevice_ID CDRType
			PropertyUtil.getString("current.platform.pid", "42") + "\t" +
			PropertyUtil.getString("current.platform.spc.pid", "42") + "\t" +
			PropertyUtil.getString("current.platform.sp.pid", "42") + "\t\t\t\t\t" + // OrderMethod PushId OAMDN DAMDN
			PropertyUtil.getString("current.platform.sp.famdn", "42") + "\t" + "1" + "\t" +
			DateUtil.getDate("YYYYMMddHHmmss", startCallTime) + "\t" +
			DateUtil.getDate("YYYYMMddHHmmss", endCallTime) + "\t" +
				Math.round((endCallTime.getTime() - startCallTime.getTime()) / 1000) + // InputOctets OutputOctets FeePoint
					"\t\t\t\t" + "3" + "\t" + "0" + "\t\t\t\n";
	}

	/**
	 * Get Bill File Content
	 * @param serialId
	 * @param starTime
	 * @param endTime
	 * @param billList
	 * @return
	 */
	public static String getBillFileContent(String serialId, Date starTime, Date endTime, 
			List<Map<String, Object>> billList, Date processDate) {
		StringBuffer result = new StringBuffer();
		int _count = 1, record = 0;
		for(Map<String, Object> bill : billList){
			System.out.println(bill.get("JoinTime"));
				if(bill.get("JoinTime") != null && bill.get("LeaveTime") != null) {
				String _serialId = String.valueOf(_count);
				while(_serialId.length() < 4){
					_serialId = "0".concat(_serialId);
				}
				result.append(getBillFileBody(_serialId, (Date)bill.get("JoinTime"), 
						(Date)bill.get("LeaveTime"), processDate));
				_count++;
				record++;
				if(_count > 9999)
					_count = 1;
			}
		}
		String recordLine = String.valueOf(record--);
		while(recordLine.length() < 10){ // 补位
			recordLine = "0".concat(recordLine);
		}
		return getBillFileHead(serialId, starTime, endTime, recordLine, processDate).concat(result.toString());
	}
	
	/**
	 * Check SSID
	 * 
	 * @param serialId
	 * @return
	 */
	private static boolean checkSSID(String serialId) {
		if(StringUtil.hasText(serialId) && serialId.length() == 4)
			return true;
		return false;
	}
	
	/**
	 * Check RecordId
	 * 
	 * @param recordId
	 * @return
	 */
	private static boolean checkRecordId(String recordId) {
		if(StringUtil.hasText(recordId) && recordId.length() == 10)
			return true;
		return false;
	}
}
