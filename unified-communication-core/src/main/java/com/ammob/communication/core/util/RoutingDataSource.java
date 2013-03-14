package com.ammob.communication.core.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;  

public class RoutingDataSource extends AbstractRoutingDataSource{  
  
	private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<String>();
	
    @Override  
    protected String determineCurrentLookupKey() {
        return getDetermineType();
    }

	public static void setDetermineType(String customerType) {
		RoutingDataSource.CONTEXT_HOLDER.set(customerType);
	}

	public static String getDetermineType() {
		return RoutingDataSource.CONTEXT_HOLDER.get();
	}

	public static void clearDetermineType() {
		RoutingDataSource.CONTEXT_HOLDER.remove();
	}
}