package com.htc.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	private WebDriver driver = null;
	@FindBy(xpath = "(//a[@title=\"5-Year Warranty\"])[2]")
	private WebElement product;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectProduct() {
		try {
			product.click();
		} catch (NoSuchElementException nsee) {
			System.out.println(nsee.getStackTrace());
		}
		catch (Exception exception) {
			System.out.println(exception.getStackTrace());
		}
		catch (Throwable throwable) {
			System.out.println(throwable.getStackTrace());
		}
	}
}

