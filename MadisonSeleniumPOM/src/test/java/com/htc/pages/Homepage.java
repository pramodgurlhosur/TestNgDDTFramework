package com.htc.pages;

import org.openqa.selenium.NoSuchElementException;
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
	private WebElement searchproducts;
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
			searchproducts.click();
			searchproducts.sendKeys(search);
			clickSearch.click();
		} catch (NoSuchElementException nsee) {
			System.out.println(nsee.getStackTrace());
		}
	}

	public WebDriver driver() {
		return driver;
	}

	public String assertLogin() {
		return assertElement.getText();

	}
}
