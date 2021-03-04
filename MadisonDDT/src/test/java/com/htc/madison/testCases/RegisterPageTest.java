package com.htc.madison.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.htc.madison.pages.AccountMenu;
import com.htc.madison.pages.LoginPage;
import com.htc.madison.pages.RegisterPage;
import com.htc.madison.util.DataProviders;
import com.htc.madison.util.TestUtil;
import com.htc.madsion.base.TestBase;

public class RegisterPageTest extends TestBase {
   RegisterPage register;
   LoginPage login;
   AccountMenu account;
   TestUtil util;
   
  public RegisterPageTest() 
  {
	super();
  }
   
  @BeforeClass
  public void loadPage()
  {
	  register=new RegisterPage(driver);
	  account=new AccountMenu(driver);
	  util=new TestUtil();
  }

	   @Test(dataProviderClass = DataProviders.class ,dataProvider ="madison_register")
	   public void testRegistration_entervalidDetails_shouldShowRegistrationMessage(String ... parameters)
	   {
	    register.clickAccount();
		register.clickRegister();
		String fName=parameters[0];
		String mName=parameters[1];
		String lName=parameters[2];
		String emailId=parameters[3];
		String passwd=parameters[4];
		String confirmPasswd=parameters[5];
		register.clickOnRegisterButton(fName,mName,lName,emailId,passwd,confirmPasswd);
		System.out.println("Registration has Done Succesfully");
		driver.manage().timeouts().implicitlyWait(util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		try {
			captureScreenshot(driver,"registration");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account.clickAccountToLogout();
		account.clickLogout();
		
		Assert.assertEquals(register.assertSuccessMsg(), "WELCOME");
	}
 }
