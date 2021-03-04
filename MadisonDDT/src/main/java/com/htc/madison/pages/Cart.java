package com.htc.madison.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htc.madsion.base.TestBase;

public class Cart extends TestBase{
	public Cart(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//*[@id=\\\"swatch15\\\"]/span[1]/img")
	private WebElement colour;
	@FindBy (xpath="(//span[@class=\"swatch-label\"])[4]")
	private WebElement size;
	@FindBy (xpath="//input[@id='qty']")
	private WebElement quantity;
	@FindBy (xpath="(//button[@class='button btn-cart'])[2]")
    private WebElement addtocart;
	
	public void setcolourBy() {
		this.colour.click();
	}
	public void setsizeBy() {
		this.size.click();
	}
	public void setquantityBy(String value) {
		WebElement we=this.quantity;
		we.click();
		we.clear();
		we.sendKeys(value);
	}
	public void addtocartBy() {
		this.addtocart.click();
	}
}
