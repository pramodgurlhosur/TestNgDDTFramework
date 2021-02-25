package com.htc.madison.extentReport;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {
public ExtentHtmlReporter htmlReporter;
public ExtentReports extent;
public ExtentTest test;

@BeforeSuite
public void setUp()
{
	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/MyExtentReport.html");
	extent =new ExtentReports();
	extent.attachReporter(htmlReporter);
	
}

@AfterMethod
public void getResult(ITestResult result)
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		test.fail(MarkupHelper.createLabel(result.getName()+"Test case failed", ExtentColor.RED));
		test.fail(result.getThrowable());
	}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.pass(MarkupHelper.createLabel(result.getName()+"Test case passed", ExtentColor.GREEN));
		
	}
	else
		test.skip(MarkupHelper.createLabel(result.getName()+"Test case skipped", ExtentColor.YELLOW));
}  

@AfterSuite
public void teaarDown()
{
	extent.flush();
}
}
