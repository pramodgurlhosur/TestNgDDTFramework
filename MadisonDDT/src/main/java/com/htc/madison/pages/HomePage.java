package com.htc.madison.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htc.madsion.base.TestBase;

public class HomePage extends TestBase{

	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	 
	
	@FindBy (xpath="//input[@id='search']")
	private WebElement searchBox;
	@FindBy (xpath="//*[@id=\"search_mini_form\"]/div[1]/button")
    private WebElement clickButton;
	@FindBy (xpath="//strong[text()=\"Search results for: 'mens pant'\"]")
    private WebElement assertSearch;
	
	

	public String getPageTitle()
	{
		return driver.getTitle();
	}
	public void searchproducts(String search) {
		Actions act=new Actions(driver);
		act.moveToElement(searchBox).click().build().perform();
		
		this.searchBox.sendKeys(search);
	}
	//Method for search
	public ProductPage clicksearch() {
		 clickButton.click();
		return new ProductPage(driver);
		   //driver.sendKeys("men pants");
		 }
	public String assertSearchProduct()
	{
		return assertSearch.getText();
	}
}
