package com.htc.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.htc.base.TestBase;
import com.htc.seleniumUtility.MadisonDataProvider;

public class RegistrationTest extends TestBase {

    @Test(dataProviderClass=MadisonDataProvider.class,dataProvider ="ecom_register")
	public void testCreateAccount_fillDetails_ShouldCreateNewAccountsuccessfully(Map<String,String> mapData) {
		System.out.println("Test Started");
		logger=report.createTest("Madison Registration");
		home = register.createNewAccount(mapData.get("firstName"),mapData.get("middleName"),mapData.get("lastName"), mapData.get("emailId"), mapData.get("password"), mapData.get("confirm"));
		Assert.assertEquals(home.isWelcomeTextDisplayed(), mapData.get("expected"));
        home.clickAccountButton();
		home.clickLogoutButton();
	}
}
