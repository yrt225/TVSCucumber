package com.tvsmotors.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
	static Properties properties;
	static String env ; // Default to "stage" if not provided
	static String browser ;
	
	public static void loadProperties()
	{
		
		try
		{
			properties = new Properties();
			
			  env = System.getProperty("env", "stage"); // Default to "stage" if not
			   browser = System.getProperty("browser", "Chrome");
			 
	FileInputStream fileInputStream = new FileInputStream("src/main/resources/configs/" + env + ".properties");
		//FileInputStream fileInputStream = new FileInputStream("src/main/resources/configs/stage.properties");
		
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getProperty(String key)
	{
	loadProperties();
	return	properties.getProperty(key);
		
	}
	
	 public static String getBrowser() {
		 loadProperties();
	        return browser;
	    }

	    public static String getEnv() {
	  
	    	loadProperties();
	        return env;
	    }
	
	

}
