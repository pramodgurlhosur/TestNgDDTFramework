package com.htc.test;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.htc.base.TestBase;
import com.htc.utilities.MadsionDataProvider;

public class LoginTest extends TestBase{
	@Test(dataProviderClass = MadsionDataProvider.class, dataProvider = "MadisonRegisterAndLogin")
	@Parameters("SheetName")
	public void testLoginPage_validInvalidMessage_enterValidAndInvalidDetails(Map<String, String> mapData) throws IOException, InterruptedException {
		login.performLogin(mapData.get("emailid"), mapData.get("password"));
		Assert.assertEquals(home.assertLogin(), "Hello, anonymous unknown ghost!");
        home.goToHomePage(properties.getProperty("searchproduct"));
        product.selectProduct();
        cart.selectProduct(properties.getProperty("quantity"));
        shop.performSettingAddress(properties.getProperty("country"), properties.getProperty("region"), properties.getProperty("city"),properties.getProperty("pincode"));
        billing.performBilling(mapData.get("emailid"), properties.getProperty("company"), properties.getProperty("street"),
        		properties.getProperty("city"), properties.getProperty("quantity"), properties.getProperty("pincode"),properties.getProperty("mobilenumber"));
		System.out.println("ORDER PLACED SUCCESSFULLY");
		Assert.assertEquals(order.assertCheckOutTitle(), "CHECKOUT");
		
	}
}
