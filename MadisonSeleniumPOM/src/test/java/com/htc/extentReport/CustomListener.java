package com.htc.extentReport;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.htc.base.TestBase;
import com.htc.constants.GlobalVariables;
import com.htc.utilities.Screenshot;

public class CustomListener extends TestBase implements ITestListener{
	ExtentTestManager etm=new ExtentTestManager();
	public void onStart(ITestContext context) {
		System.out.println(" Test Suite " + context.getName() + " started ");
	}

	public void onFinish(ITestContext context) {
		System.out.println((" Test Suite " + context.getName() + " ending "));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println((" Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(" Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		 Object testClass = result.getInstance();
		    WebDriver driver = ((TestBase) testClass).getDriver();
		    try {
				Screenshot.captureScreenShot(driver, GlobalVariables.PASSED_SCREENSHOTS,result.getMethod().getMethodName());
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(" Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		Object testClass = result.getInstance();
	    WebDriver driver = ((TestBase) testClass).getDriver();
	    try {
			Screenshot.captureScreenShot(driver, GlobalVariables.FAILED_SCREENSHOTS,result.getMethod().getMethodName());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(" Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(" Test failed but within percentage % " + result.getMethod().getMethodName());
	} 

}
