package com.htc.grid.demo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {
  WebDriver driver;
 public void initialization()
 {
	 System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriverSetup\\chromedriver.exe");
	 driver =new ChromeDriver();
	 driver.get("https://www.google.com");
 }
 
 public void takeScreenShot(String methodName)
 {
		Date d=new Date();
	    methodName =methodName+"_"+ d.toString().replace(":", "_").replace(" ", "_") + ".png";
	           //colon and space is not supported in file naming format. 
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 
			try {
				FileHandler.copy(screenshot, new File("D:\\ECLIPSE WORKSPACE\\SeleniumGrid\\src\\main\\java\\com\\htc\\screenshots\\"
			+ methodName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 }
}
