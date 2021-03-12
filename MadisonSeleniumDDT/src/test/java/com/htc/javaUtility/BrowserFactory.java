package com.htc.javaUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class BrowserFactory {

	public static WebDriver startBrowser(WebDriver driver,String browser,String url,String driverLocation) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",driverLocation);
			driver=new ChromeDriver();
			Reporter.log("ChromeDriver  is loaded", true);

		}else  if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",driverLocation);
			driver=new FirefoxDriver();
			Reporter.log("FirefoxDriver  is loaded", true);
		}else {
			Assert.assertTrue(false,"No browser is launched  send a proper browser  name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		Reporter.log("Navigate to browser:"+browser+"URL:"+url, true);
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		driver.close();
	}
	
}
