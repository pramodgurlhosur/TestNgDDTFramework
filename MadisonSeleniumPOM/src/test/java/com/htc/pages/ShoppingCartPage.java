package com.htc.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htc.utilities.Util;

public class ShoppingCartPage {
	private WebDriver driver = null;
	 
	@FindBy(xpath = "(//button[@class='button btn-proceed-checkout btn-checkout'])[2]")
	private WebElement checkOutButton;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void performSettingAddress(String country, String region, String city, String pin) {
		try {
			checkOutButton.click();
		} catch (NoSuchElementException nsee) {
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
