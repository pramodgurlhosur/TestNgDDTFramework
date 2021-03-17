package com.htc.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	private WebDriver driver = null;
	@FindBy(xpath = "//input[@id=\"qty\"]")
	private WebElement quantity;
	@FindBy(xpath = "(//button[@class='button btn-cart'])[2]")
	private WebElement ClickAddToCart;

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
			ClickAddToCart.click();
		} 
		catch (NoSuchElementException nsee) {
			System.out.println(nsee.getStackTrace());
		}
		catch (StaleElementReferenceException  exception) {
			System.out.println(exception.getStackTrace());
		}
		catch (Throwable throwable) {
			System.out.println(throwable.getStackTrace());
		}
	}
}
