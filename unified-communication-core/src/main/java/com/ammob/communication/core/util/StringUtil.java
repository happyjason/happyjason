package com.ammob.communication.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {

	/**
	 * 判断字符串是否是数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		return Pattern.compile("^[-+]?[0-9]*$").matcher(str.trim()).matches();
	}

	/**
	 * 判断字符串是否是字母数字组合,正负号匹配
	 * @param str
	 * @return
	 */
	public static boolean isCharacterAndNumeric(String str){
		return Pattern.compile("^[-+]?[a-zA-Z0-9]*$").matcher(str.trim()).matches();
	}
	
	/**
	 * 获取带有http前缀的完整URL域名
	 * @param originalUrl
	 * @return
	 */
	public static String getUrlDomain(String originalUrl)throws IllegalStateException {
		Pattern p = Pattern.compile("http://.*?.(com|cn|net|org|biz|info|cc|tv)",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(originalUrl);
		matcher.find();
		return matcher.group();
	}
}