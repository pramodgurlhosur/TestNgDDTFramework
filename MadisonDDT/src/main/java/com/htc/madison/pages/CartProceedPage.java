package com.htc.madison.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htc.madsion.base.TestBase;


public class CartProceedPage extends TestBase {
	
	public CartProceedPage(WebDriver driver) 
	{
       PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="(//button[@class='button btn-proceed-checkout btn-checkout'])[2]")
    private WebElement checkoutbutton;
	@FindBy (xpath="//h1[text()=\"Checkout\"]")
    private WebElement assertCheckOut;

	public Billing clickCheckoutbuttonBy() {
		this.checkoutbutton.click();
		return new Billing(driver);
	}


	public String assertProceedToBilling() {
		// TODO Auto-generated method stub
		return this.assertCheckOut.getText();
	}
}
