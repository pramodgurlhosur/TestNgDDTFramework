package com.htc.seleniumUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import com.htc.javaUtility.ExcelFileReader;


public class MadisonDataProvider {
	public Properties data;

	public MadisonDataProvider()
	{
		data=new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:\\ECLIPSE WORKSPACE\\MadisonSeleniumDDT\\src\\test\\resources\\madisonData.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			data.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DataProvider(name = "ecom_register")
	public Object[][] ecomStoreRegisterValidData()
	{

		ExcelFileReader ref= new ExcelFileReader(data.getProperty("madision.datas"));

		Object[][] loginDataSet=ref.getDataUsingMap(data.getProperty("madision.sheetname.register"));

		System.out.println(loginDataSet.length);
		return loginDataSet;
    }
	
	@DataProvider(name = "ecomLogin_address")
	public Object[][] ecomStoreAddressData()
	{
        ExcelFileReader ref= new ExcelFileReader(data.getProperty("madision.datas"));
        Object[][] loginDataSet=ref.getDataUsingMap(data.getProperty("madision.sheetname.address"));
        System.out.println("test"+loginDataSet.length);
		return loginDataSet;
		}
	
			@DataProvider(name = "data")
			public Object[][] ecomStoreSigninInValidData()
			{
	            ExcelFileReader ref= new ExcelFileReader(data.getProperty("madision.datas"));
	            Object[][] loginDataSet=ref.getDataUsingMap(data.getProperty("madision.sheetname.loginData"));
	            System.out.println(loginDataSet.length);
				return loginDataSet;
	       }

}