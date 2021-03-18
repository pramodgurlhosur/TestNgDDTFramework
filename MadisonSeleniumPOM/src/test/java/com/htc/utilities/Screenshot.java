package com.htc.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public static String captureScreenShot(WebDriver driver, String path,String methodname) throws IOException, InterruptedException
	{
        String screenshotPath = path +"\\"+methodname+ Util.getCurrentTime() +".jpg";
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(screenshotPath);
		FileHandler.copy(source,destination);
		Thread.sleep(3000);
		return screenshotPath;
	}
}
