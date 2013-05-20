package com.ammob.communication.core.util;

import org.springframework.util.NumberUtils;


public class NumberUtil extends NumberUtils {

	/**
	 * don't throw an exception
	 * @param integer
	 * @param defaultValue
	 * @return
	 */
	public static int getInteger(Integer integer, int defaultValue){
		if(integer == null)
			return defaultValue;
		return integer.intValue();
	}
	
	/**
	 * don't throw an exception
	 * @param string
	 * @param defaultValue
	 * @return
	 */
	public static int getInteger(String string, int defaultValue){
		if(!StringUtil.hasText(string) || !StringUtil.isNumeric(string))
			return defaultValue;
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}
}
