package com.org.ishir.util;

import java.util.Properties;

import com.org.ishir.util.ResourceLoader;

public class DataReadWrite {
	 public static String getProperty(String Property) {
	        try {
	            Properties prop = ResourceLoader.loadProperties("./Config.properties");
	            return prop.getProperty(Property);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }
	    
}
