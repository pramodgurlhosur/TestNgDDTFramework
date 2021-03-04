package com.htc.madison.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.htc.madison.pages.Cart;
import com.htc.madison.pages.ProductPage;
import com.htc.madison.util.TestUtil;
import com.htc.madsion.base.TestBase;

public class ProductPageTest extends TestBase{
	   TestBase testBase;
	   ProductPage product;
	   TestUtil util;
	   Cart cart;
	 
	  public ProductPageTest() 
	  {
		super();
	  }
	   
	  @BeforeClass
	  public void loadPage()
	  {
		  testBase=new TestBase();
		  cart =new Cart(driver);
		  product=new ProductPage(driver);
		  util=new TestUtil();
	  }
	 
	  @Test
	  public void testProductPage_clickOnTheProduct_shouldShowTheProductetails() throws InterruptedException
	  { 
		  product.scrollPage();
		  cart=product.selectproduct();
		  System.out.println("product page loaded succesfully");
		  Assert.assertEquals(product.assertProductName(), "FLAT FRONT TROUSER");
	}
}
