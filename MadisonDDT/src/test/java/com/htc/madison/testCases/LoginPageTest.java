package com.htc.madison.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.htc.madison.pages.AccountMenu;
import com.htc.madison.pages.HomePage;
import com.htc.madison.pages.LoginPage;
import com.htc.madison.utilities.DataProviders;
import com.htc.madison.utilities.TestUtil;
import com.htc.madsion.base.TestBase;

public class LoginPageTest extends TestBase{
	 LoginPage login;
	   HomePage homePage;
	  AccountMenu account;
	  TestUtil util;
	  
	  public LoginPageTest() 
	  {
		super();
	  }
	   
	  @BeforeClass
	  public void loadPage()
	  {
		  login=new LoginPage(driver);
		  account=new AccountMenu(driver);
		  util=new TestUtil();
	  }

	    @Test(dataProvider ="madisonSignin_valid",dataProviderClass = DataProviders.class)
		public void testMadisonSignin_ValidloginCredential_ShouldDisplayDashboard(String ... parameters) throws InterruptedException 
		{
	    	String email=parameters[0];
			String password=parameters[1];
			if(email!=null && password!=null)
			homePage=login.doLogin(email, password);
			System.out.println("login valid data passed Succesfully");
			driver.manage().timeouts().implicitlyWait(util.IMPLICIT_WAIT, TimeUnit.SECONDS);
			try {
				captureScreenshot(driver,"validLogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			account.clickAccountToLogout();
			account.clickLogout();
			//Assert.assertEquals(login.assertDashboard(), parameters[2]); //method returns title
	   }
		
		@Test(dataProvider ="madisonSignin_invalid",dataProviderClass = DataProviders.class)
		public void testMadisonSignin_InValidloginCredential_ShouldDisplayErrorInSigninPage(String ... parameters)		{
			String email=parameters[0];
			String password=parameters[1];
			if(email!=null && password!=null)
				homePage=login.doLogin(email, password);
			driver.manage().timeouts().implicitlyWait(util.IMPLICIT_WAIT, TimeUnit.SECONDS);
			try {
				captureScreenshot(driver,"invalidLogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("login invalid data passed Succesfully");
			Assert.assertEquals(login.assertInvalidMsg(), parameters[2]); //method returns title
	    }
	}