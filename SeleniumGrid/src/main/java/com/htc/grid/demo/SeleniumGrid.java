package com.htc.grid.demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumGrid {
	private WebDriver driver;
	private String websiteURL,nodeURL;
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		websiteURL="http://technicalfreak.unaux.com";
		nodeURL="http://192.168.56.1:4444/wd/hub";
		DesiredCapabilities desired=DesiredCapabilities.chrome();
		driver=new RemoteWebDriver(new URL(nodeURL),desired);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGrid_validURL_shouldDisplayWebpage() throws MalformedURLException
	{
		driver.get(websiteURL);
		System.out.println("the title of webpage is "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Explore India - Discover places in Incredible india");
	}
	
	/*@Test(priority=2)
	public void testSkipMethod_throwSkipException_testShouldSkip()
	{
		throw new SkipException("the test is skipped");
	}
	
	@Test(priority=3)
	public void testFailMethod()
	{
		Assert.assertTrue(false);
	}*/
	/*
	 * @Test public void test() throws MalformedURLException { DesiredCapabilities
	 * desired=new DesiredCapabilities(); desired.setBrowserName("chrome"); String
	 * url="http://192.168.56.1:4444/wd/hub"; WebDriver driver=new
	 * RemoteWebDriver(new URL(url),desired);
	 * driver.get("http://technicalfreak.unaux.com");
	 * System.out.println("the title of webpage is "+driver.getTitle()); }
	 */
	
}
