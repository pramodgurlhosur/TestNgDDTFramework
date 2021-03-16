package com.htc.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	private WebDriver driver = null;
	@FindBy(xpath = "//input[@id=\"qty\"]")
	private WebElement quantity;
	@FindBy(xpath = "(//button[@class='button btn-cart'])[2]")
	private WebElement ClickAddtocart;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectProduct(String value) 
	{
		try {
			quantity.click();
			quantity.clear();
			quantity.sendKeys(value);
			ClickAddtocart.click();
		} catch (NoSuchElementException nsee) {
			System.out.println(nsee.getStackTrace());
		}
	}
}
