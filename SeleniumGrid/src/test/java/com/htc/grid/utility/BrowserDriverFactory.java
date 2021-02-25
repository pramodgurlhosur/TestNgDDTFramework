package com.htc.grid.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {
	public static WebDriver getDriver(Browser browser) //in the program they lowercase or randomaccess Chrome ChRome
	{
		WebDriver browserDriver = null;
		
		switch(browser)
		{
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriverSetup\\chromedriver.exe");
			browserDriver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "D:\\FireFoxDriverGECKOSETUP\\geckodriver.exe");
			browserDriver = new FirefoxDriver();
			break;

		default:
			break
			;
		}
		
		return browserDriver;
		
	}
}
