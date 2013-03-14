package com.ammob.communication.core.util;

import org.apache.commons.configuration.CompositeConfiguration;
import org.springframework.beans.factory.annotation.Required;

public class PropertyUtil {
	
	private static CompositeConfiguration compositeConfiguration;

	public static String getString(String key) {
		if(compositeConfiguration == null)
			throw new NullPointerException("Configuration Fail, compositeConfiguration is null !!");
		return compositeConfiguration.getString(key);
	}
	
	public static String getString(String key, String defaultValue) {
		if(compositeConfiguration == null)
			throw new NullPointerException("Configuration Fail, compositeConfiguration is null !!");
		return compositeConfiguration.getString(key, defaultValue);
	}
	
	@Required
	public void setCompositeConfiguration(
			CompositeConfiguration compositeConfiguration) {
		PropertyUtil.compositeConfiguration = compositeConfiguration;
	}
}
