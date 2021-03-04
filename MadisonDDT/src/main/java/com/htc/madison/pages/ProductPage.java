package com.htc.madison.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htc.madsion.base.TestBase;

public class ProductPage extends TestBase{
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="(//a[@href=\"http://demo-store.seleniumacademy.com/flat-front-trouser-542.html\"])[3]")
	private WebElement product;
	@FindBy (xpath="//*[@id=\"product_addtocart_form\"]/div[3]/div[1]/span")
	private WebElement productName;
	
	public void scrollPage() throws InterruptedException
	{
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("window.scroll(0,300)");
     driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public Cart selectproduct() throws InterruptedException
	{
		
		this.product.click();
		return new Cart(driver);
	}
	
	public String assertProductName() throws InterruptedException
	{
		
		return this.productName.getText();
	}
}
