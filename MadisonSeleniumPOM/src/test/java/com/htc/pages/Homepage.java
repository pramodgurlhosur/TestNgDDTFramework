package com.htc.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htc.utilities.Util;

public class Homepage {
	private WebDriver driver = null;
	@FindBy(xpath = "//div[@class='block-content']//ul//li[@class='current']//a//strong")
	private WebElement dashboard;
	@FindBy(xpath = "//div[@class='welcome-msg']//p[@class='hello']//strong")
	private WebElement assertElement;
	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchProducts;
	@FindBy(xpath = "//button[@class='button search-button']")
	private WebElement clickSearch;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToHomePage(String search) {
		try {
			Util.explicitWait(dashboard, driver);
			dashboard.click();
			searchProducts.click();
			searchProducts.sendKeys(search);
			clickSearch.click();
		} 
		catch (NoSuchElementException nsee) {
			System.out.println(nsee.getStackTrace());
		}
		catch (StaleElementReferenceException  exception) {
			System.out.println(exception.getStackTrace());
		}
		catch (RuntimeException runtime) {
			System.out.println(runtime.getStackTrace());
		}
		catch (Throwable throwable) {
			System.out.println(throwable.getStackTrace());
		}
	}

	public WebDriver driver() {
		return driver;
	}

	public String assertLogin() {
		return assertElement.getText();

	}
}
