package com.htc.testCases;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.base.TestBase;
import com.htc.utilities.MadsionDataProvider;

public class LoginPurchaseTest extends TestBase
{
	@Test(dataProviderClass = MadsionDataProvider.class, dataProvider = "MadisonRegisterLoginAndPurchase")
	public void testLoginAndCheckOutPage_shouldDisplayValidInvalidMessage_enterValidAndInvalidDetails(Map<String, String> excelMapData) 
	{
		login.performLogin(excelMapData.get("emailid"), excelMapData.get("password"));
		Assert.assertEquals(home.assertLogin(), "Hello, anonymous unknown ghost!");
		
        home.goToHomePage(properties.getProperty("productSearch"));
        
        product.selectProduct();
        
        cart.selectProduct(properties.getProperty("quantity"));
        
        shop.proceedToBillingPage();
        
        billing.performBilling(excelMapData.get("emailid"), properties.getProperty("company"), properties.getProperty("street"),
        		properties.getProperty("city"), properties.getProperty("quantity"), properties.getProperty("pincode"),properties.getProperty("mobilenumber"));
		System.out.println("ORDER PLACED SUCCESSFULLY");
		Assert.assertEquals(order.assertCheckOutTitle(), "YOUR ORDER HAS BEEN RECEIVED.");
	}
}
