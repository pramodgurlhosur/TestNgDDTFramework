package com.htc.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.htc.constants.GlobalVariables;

public class BrowserFactory {
	
	public static WebDriver selectWebDriver(String browser) 
	{
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(GlobalVariables.CHROME_NAME, GlobalVariables.CHROME_PATH);
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(GlobalVariables.FIREFOX_NAME, GlobalVariables.FIREFOX_PATH);
			driver = new FirefoxDriver();
		}
		else
			System.out.println("BROWSER NAME INVALID. ENTER VALID BROSWER");
		return driver;
     }
}
