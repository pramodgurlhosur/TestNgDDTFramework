package com.htc.madison.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;


public class DataProviders {
	public Properties properties;
     
	public DataProviders()
    {
    	properties=new Properties();
    	FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:\\ECLIPSE WORKSPACE\\MadisonDDT\\src\\main\\resources\\madison.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}
	    @DataProvider(name = "madison_register")
		public Object[][] madisonRegisterData()
	   {
			ExcelRead ref= new ExcelRead(properties.getProperty("datarepository.madison.signin"));
		    Object[][] loginDataSet=ref.getRecords(properties.getProperty("datarepository.madison.signin.sheetname.register"));
			System.out.println(loginDataSet.length);
			return loginDataSet;
		}
	    
	    @DataProvider(name = "madisonSignin_valid")
	  		public Object[][] madisonValidData()
	  		{
	  			ExcelRead ref= new ExcelRead(properties.getProperty("datarepository.madison.signin"));
	  			Object[][] loginDataSet=ref.getRecords(properties.getProperty("datarepository.madison.signin.sheetname.valid"));
	  			System.out.println(loginDataSet.length);
	  			return loginDataSet;
	  		}
	  		
	  		@DataProvider(name = "madisonSignin_invalid")
	  		public Object[][] madisonInValidData()
	  		{
	  			ExcelRead ref= new ExcelRead(properties.getProperty("datarepository.madison.signin"));
	  			Object[][] loginDataSet=ref.getRecords(properties.getProperty("datarepository.madison.signin.sheetname.invalid"));
	  			System.out.println(loginDataSet.length);
	  			return loginDataSet;
	  		}
}
