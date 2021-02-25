package com.htc.grid.test;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.htc.grid.utility.Browser;
import com.htc.grid.utility.RemoteDriverFactory;

public class GridBrowserTest {
	private WebDriver driver;
	private String baseUrl,nodeURL;


	@BeforeTest
	public void setup()
	{
		baseUrl="https://www.google.com";	
		Properties prop=new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\ECLIPSE WORKSPACE\\SeleniumGrid\\src\\test\\resources\\Application.properties");
			prop.load(fis);
			nodeURL=prop.getProperty("testNG.grid.nodeURL");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Test
	@Parameters({"browser"})
	public void browserTest(String browser) {
		try {
			driver = RemoteDriverFactory.getDriver(Browser.valueOf(browser), nodeURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(baseUrl);
		assertEquals(driver.getTitle(), "Google");
	}
}
