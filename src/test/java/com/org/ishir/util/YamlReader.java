package com.org.ishir.util;

import static com.org.ishir.util.DataReadWrite.getProperty;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

import org.testng.Reporter;
import org.yaml.snakeyaml.Yaml;

public class YamlReader {
	public static String yamlFilePath = null;

	 public static String getValue1(String token) throws FileNotFoundException {
	        Reader doc = new FileReader("D:"+File.separator+"assignment"+File.separator+"assignment"+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"testData"+File.separator+"database.yaml");//filepath
	        Yaml yaml = new Yaml();
	        Map<String, Object> object=(Map<String, Object>) yaml.load(doc);
	        return getMapValue(object, token);
	    }

	    public static String getMapValue(Map<String, Object> object, String token) {
	        String st[]=new String[10];
	    	return object.get(token).toString();
	    }
	    
	    public static String setYamlFilePath() {
	    	//getProperty("Config.properties").trim();
	    	yamlFilePath ="testData/ishir.yml";	
	    	return yamlFilePath;
	    }

	    public static String getYamlValue(String token) {
	        try {
	            return getValue(token);
	        } catch (FileNotFoundException ex) {
	            System.out.println(ex.getMessage());
	            return null;
	        }
	    }
	    
	    private static String getValue(String token) throws FileNotFoundException {
			Reader doc = null;
			try {
				doc = new FileReader(yamlFilePath);
			} catch (FileNotFoundException e) {
				Reporter.log("Value doesn't exist'", true);
				return null;
			}
	        Yaml yaml = new Yaml();
	        Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
	        return getMapValue(object, token);
	    }
}
