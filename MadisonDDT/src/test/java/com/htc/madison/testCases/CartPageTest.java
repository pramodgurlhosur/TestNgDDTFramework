package com.htc.madison.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.htc.madison.pages.Billing;
import com.htc.madison.pages.Cart;
import com.htc.madison.pages.CartProceedPage;

import com.htc.madison.pages.ProductPage;
import com.htc.madison.util.TestUtil;
import com.htc.madsion.base.TestBase;

public class CartPageTest extends TestBase{

	   TestBase testBase;
	   Cart cart;
	   CartProceedPage cartProceed;
	   Billing billing;
	   TestUtil util;
	   
	  
	  public CartPageTest() 
	  {
		super();
	  }
	   
	  @BeforeClass
	  public void loadPage()
	  {
		  testBase=new TestBase();
		  cart =new Cart(driver);
		  cartProceed=new CartProceedPage(driver);
		  billing=new Billing(driver);
		  util=new TestUtil();
	  }
	  
	  @Test
	  public void testCartPage_chooseDesired_shouldAllowToSelect() throws InterruptedException
	  { 
		  cart.setcolourBy();
		  cart.setsizeBy();
		  cart.setquantityBy(properties.getProperty("quantity"));
		  cart.addtocartBy();
		 billing= cartProceed.clickCheckoutbuttonBy();
		 System.out.println("cart page loaded succesfully");
			Assert.assertEquals(cartProceed.assertProceedToBilling(), "CHECKOUT");
	}
}
