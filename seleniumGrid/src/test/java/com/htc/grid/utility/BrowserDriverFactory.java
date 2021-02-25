package com.htc.grid.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BrowserDriverFactory {
	public static WebDriver browserDriver = null;
	public static WebDriver getDriver(Browser browser) //in the program they lowercase or randomaccess Chrome ChRome
	{
		
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
	
	public void takeScreenShot(String methodName)
	 {
			Date d=new Date();
		    methodName =methodName+"_"+ d.toString().replace(":", "_").replace(" ", "_") + ".png";
		           //colon and space is not supported in file naming format. 
				File screenshot = ((TakesScreenshot)browserDriver).getScreenshotAs(OutputType.FILE);
		 
				try {
					FileHandler.copy(screenshot, new File("D:\\ECLIPSE WORKSPACE\\SeleniumGrid\\src\\main\\java\\com\\htc\\screenshots\\"
				+ methodName));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 }
}
