package com.htc.madison.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htc.madsion.base.TestBase;

public class OrderConfirmation extends TestBase{
	
	public OrderConfirmation(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//div[@class='page-title']")
	private WebElement checkout;
	
	public String checkOutTitle() {
	  return checkout.getText();
	}
}
