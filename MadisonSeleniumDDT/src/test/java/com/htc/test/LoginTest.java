package com.htc.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.htc.base.TestBase;
import com.htc.seleniumUtility.MadisonDataProvider;

public class LoginTest extends TestBase{

	@Test(dataProviderClass=MadisonDataProvider.class,dataProvider ="data" )
	public void test(Map<String,String> mapData)
	{
		System.out.println("Test Started");
		logger=report.createTest("Login to Madison with invalid");

		home.loginWithCredantials(mapData.get("email"), mapData.get("password"));
		if(mapData.get("Expected").equals("My Account")) {
			Assert.assertTrue(login.isDashbordDisplayed());
			home.performLogOut();
		}

		if(mapData.get("Expected").equals("Invalid login or password.")) {
			Assert.assertTrue(home.isErrorDisplayed());
		}

		System.out.println("Test Ends");
	}

}
