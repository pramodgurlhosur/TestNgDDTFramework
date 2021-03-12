package com.htc.javaUtility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DataProviderConfig {

	protected Properties properties;
	
	public DataProviderConfig() {
		File source=new File("D:\\ECLIPSE WORKSPACE\\MadisonSeleniumDDT\\src\\test\\resources\\madisonData.properties");
		try {
			FileInputStream fileInputStream=new FileInputStream(source);
			properties=new Properties();
			properties.load(fileInputStream);
		} catch (Exception e) {
			System.out.println("Not able to load config file "+e.getMessage());
		}
	}
	
	
	public String getBrowser() {
		return properties.getProperty("browser");
	}
	
	public String getStagingURL() {
		return properties.getProperty("url");
	}
	
	public String getDriverLocatioin() {
		return properties.getProperty("driverLocation");
	}
	
	
}
