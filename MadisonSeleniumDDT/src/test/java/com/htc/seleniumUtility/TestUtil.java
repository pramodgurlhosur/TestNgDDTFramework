package com.htc.seleniumUtility;



import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.htc.base.TestBase;

public class TestUtil extends TestBase{
	public static String screenshotPath;
	public static String screenshotName;
public static int explicitWaitTime=10;
WebDriverWait wait =null;

	public static  String captureScreenShot(WebDriver driver,ITestResult result) {
		String screenshotPath=null;
		if(result.getStatus()==ITestResult.FAILURE)
		{
		screenshotPath=System.getProperty("user.dir")+"./Screenshots/failed/MadisonFailed_"+getCurrentDateTime()+".png";
		}
		else {
			screenshotPath=System.getProperty("user.dir")+"./Screenshots/passed/MadisonPassed_"+getCurrentDateTime()+".png";

		}
		try {
			TakesScreenshot screenShot=(TakesScreenshot)driver;
			File source=screenShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(screenshotPath));
			System.out.println("screenShot is captured");
		} catch (Exception e) {
			System.out.println("Exception while taking Screenshot"+e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
	}

	public void waitForVisibilityOfElements(WebDriver driver, By locators) {
		wait = new WebDriverWait(driver, explicitWaitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locators));
	}

	public void waitForElementToBeClicked(WebDriver driver, By locators) {
		wait = new WebDriverWait(driver, explicitWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(locators));
	}

	public void waitForElementToBeSelected(By locators) {
		wait = new WebDriverWait(driver, explicitWaitTime);
		wait.until(ExpectedConditions.elementToBeSelected(locators));
    }
}
