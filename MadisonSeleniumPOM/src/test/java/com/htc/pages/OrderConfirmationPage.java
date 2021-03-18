package com.htc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	
	private WebDriver driver=null;
	@FindBy(xpath="//h1[text()=\"Your order has been received.\"]")
	private WebElement checkOutTitle;
	
	public OrderConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String assertCheckOutTitle() 
	{
		return checkOutTitle.getText();
	}
}
