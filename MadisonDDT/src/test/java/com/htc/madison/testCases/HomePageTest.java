package com.htc.madison.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.htc.madison.pages.HomePage;
import com.htc.madison.pages.LoginPage;
import com.htc.madison.pages.ProductPage;
import com.htc.madison.util.DataProviders;
import com.htc.madison.util.TestUtil;
import com.htc.madsion.base.TestBase;

public class HomePageTest extends TestBase{
	   TestBase testBase;
	   HomePage homePage;
	  ProductPage product;
	  TestUtil util;
	  LoginPage login;
	  
	  public HomePageTest() 
	  {
		super();
	  }
	   
	  @BeforeClass
	  public void loadPage()
	  {
		  login=new LoginPage(driver);
		  testBase=new TestBase();
		  homePage=new HomePage(driver);
		  util=new TestUtil();
	  }
	  
	  @Test(dataProvider ="madisonSignin_valid",dataProviderClass = DataProviders.class)
	  public void testHomePage_searchProduct_shouldShowTheProduct(String ... parameters)
	  {
		  driver.manage().timeouts().implicitlyWait(util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			String email=parameters[0];
			String password=parameters[1];
			if(email!=null && password!=null)
			login.doLogin(email, password);
		 homePage.searchproducts(properties.getProperty("searchProduct"));
		 product=homePage.clicksearch();
		 driver.manage().timeouts().implicitlyWait(util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("home page loaded succesfully");
		Assert.assertEquals(homePage.assertSearchProduct(),"Search results for: 'mens pant'");
	}
}
