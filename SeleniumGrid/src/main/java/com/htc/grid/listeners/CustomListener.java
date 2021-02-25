package com.htc.grid.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.htc.grid.demo.Base;
import com.htc.grid.demo.ScreenShotTest;

public class CustomListener extends Base implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Madison log in Test Started");
       Reporter.log("test started ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Madison log in Test finished");
	       Reporter.log("test finished ");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("test failed "+ Thread.currentThread().getName());
		takeScreenShot(result.getMethod().getMethodName());  //calling the method from Base class
	    //store the screenshot with Test method name everytime any test method fails  
		Reporter.log("test failed ");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("test skipped "+ Thread.currentThread().getName());
	    Reporter.log("test skipped "+ Thread.currentThread().getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("test passed based on percentage "+ Thread.currentThread().getName());
	       Reporter.log("test passed based on percentage "+ Thread.currentThread().getName());
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("method "+ Thread.currentThread().getName()+" has started");
	       Reporter.log("method "+ Thread.currentThread().getName()+" has started");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("method "+ Thread.currentThread().getName()+" is over");
	       Reporter.log("method "+ Thread.currentThread().getName()+" is over");
	}

}
