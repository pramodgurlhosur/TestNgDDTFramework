package com.htc.grid.demo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.htc.grid.listeners.CustomListener.class)
public class ScreenShotTest extends Base {
@BeforeMethod
public void setup()
{
	initialization();
}

@AfterMethod
public void tearDown()
{
	driver.close();
}


@Test
public void testScreenshotForFailedTest()
{
	Assert.assertEquals(false, true);
}

@Test
public void testScreenshotForFailed()
{
	Assert.assertEquals(false, true);    //failing as to take sceenshot onTestFailure
}
@Test
public void testScreenshotForFailedTest1()
{
	Assert.assertEquals(false, true);    //failing as to take sceenshot onTestFailure
}
}
