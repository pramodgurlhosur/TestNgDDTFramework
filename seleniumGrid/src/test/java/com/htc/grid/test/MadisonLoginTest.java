package com.htc.grid.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.htc.grid.pages.LoginPage;
import com.htc.grid.utility.Browser;
import com.htc.grid.utility.RemoteDriverFactory;

public class MadisonLoginTest {
	private WebDriver driver;
	private String baseUrl,nodeURL;
	Properties prop=null;
    LoginPage login=null;

	@BeforeTest
	public void setup()
	{
		baseUrl="http://demo-store.seleniumacademy.com/";	
		prop=new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\PramodVG\\Desktop\\25493_PRAMODVGURLHOSUR_SEED40\\SeleniumGrid - Copy\\src\\test\\resources\\Application.properties");
			prop.load(fis);
			nodeURL=prop.getProperty("testNG.grid.nodeURL");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Parameters({"browser"})
public void testLoginPage_validCredentails_shouldShowSuccessMessage(String browser) throws MalformedURLException
	{
		driver = RemoteDriverFactory.getDriver(Browser.valueOf(browser), nodeURL);
		driver.get(baseUrl);
		login=new LoginPage(driver);
		login.accountBy();
		login.loginBy();
		login.enterEmail(prop.getProperty("emailId"));
		login.enterPassword(prop.getProperty("password"));
		login.clicklogin();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(login.loginDashboard());
		Assert.assertEquals(login.loginDashboard(), "MY DASHBOARD");
	}
	
	@Test
	@Parameters({"engine"})
public void testLoginPage_enterValidCredentails_shouldShowSuccessMessage(String browser) throws MalformedURLException
	{
		driver = RemoteDriverFactory.getDriver(Browser.valueOf(browser), nodeURL);
		driver.get(baseUrl);
		login=new LoginPage(driver);
		login.accountBy();
		login.loginBy();
		login.enterEmail(prop.getProperty("emailId"));
		login.enterPassword(prop.getProperty("password"));
		login.clicklogin();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(login.loginDashboard());
		Assert.assertEquals(login.loginDashboard(), "MY DASHBOARD");
	}
	
}
