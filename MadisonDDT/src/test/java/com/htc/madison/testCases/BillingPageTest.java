package com.htc.madison.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.htc.madison.pages.Billing;
import com.htc.madison.pages.OrderConfirmation;
import com.htc.madsion.base.TestBase;

public class BillingPageTest extends TestBase{

	   TestBase testBase;
	   Billing billing;
	   OrderConfirmation order;
	   
	  public BillingPageTest() 
	  {
		super();
	  }   
	  
	  @BeforeClass
	  public void loadPage()
	  {
		  testBase=new TestBase();
		  billing=new Billing(driver);
		  order=new OrderConfirmation(driver);
	  }

	   @Test
	  public void testBillingPaAndOrderPage_enterValidBillingDetails_shouldAllowToCheckout() throws InterruptedException, IOException
	  { 
		  billing.setcompanyBy(properties.getProperty("company"));
		  billing.setstreetBy(properties.getProperty("street1"));
			billing.setstreet(properties.getProperty("street2"));
			billing.setcityBy(properties.getProperty("city"));
			billing.setregionBy(properties.getProperty("region"));
			billing.setpincodeBy(properties.getProperty("pincode"));
			billing.setCountryBy(properties.getProperty("country"));
			billing.setmobilenumberBy(properties.getProperty("mobileNum"));
			billing.click_billingcontinueBy();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			billing.setshippingmethodBy();
			billing.click_shippingcontinueBy();
			billing.click_paymentcontinueBy();
			billing.click_chechoutBy();
			System.out.println("billing details filled  SUCCESSFULLY");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		    Thread.sleep(5000);
			testBase.captureScreenshot(driver,"orderConfirmation");
			order=new OrderConfirmation(driver);
			System.out.println("ORDER PLACED SUCCESSFULLY");
			Assert.assertEquals(order.checkOutTitle(),"YOUR ORDER HAS BEEN RECEIVED.");
			
	}
}
