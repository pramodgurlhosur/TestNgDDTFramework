package com.htc.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	protected static WebDriver driver;

	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

	public static void selectDropDownValue(WebElement path,String value) {
		Select select = new Select(path);
		select.selectByValue(value);
	}

	public static void explicitWait(WebElement element, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			if (!element.isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(element));
			}
		} 
		catch (NoSuchElementException no) 
		{
			no.printStackTrace();
		}
		catch (StaleElementReferenceException  exception)
		{
				System.out.println(exception.getStackTrace());
		}
			catch (Throwable throwable) 
		{
				System.out.println(throwable.getStackTrace());
	    }
	    }
	}

