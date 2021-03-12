package com.htc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.htc.seleniumUtility.TestUtil;

public class LoginPage {
	protected WebDriver driver;
	private By selectList=By.xpath("//*[@id=\"nav\"]/ol/li[4]/a");	
	private By selectOption=By.xpath("//*[@id=\"nav\"]/ol/li[4]/ul/li[2]/a");//By.xpath("//*[@id=\"nav\"]/ol/li[4]/child::ul/child::li/child::a[text()=\"Books & Music\"]");
	private By dashboard=By.xpath("//h1[.=\"My Dashboard\"]");	
	TestUtil util=new TestUtil();
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	public void clickandSelectList() {
		WebElement list1=driver.findElement(selectList);
		Actions ac=new Actions(driver);
		ac.moveToElement(list1).perform();
	}
	public void clickBooksOption() {
		driver.findElement(selectOption).click();
	}
	public void loginActions() {
		this.clickandSelectList();
		this.clickBooksOption();
	}
	public boolean isDashbordDisplayed() {
		System.out.println("is dashboard start : "+dashboard);
		boolean isDisplayed=false;
		System.out.println("is dashboard : "+isDisplayed);
		WebElement dash=driver.findElement(dashboard);
		try {
			
			util.waitForVisibilityOfElements(driver, dashboard);
		}
		catch(ElementNotVisibleException e){
			e.printStackTrace();
		}
		isDisplayed=dash.isDisplayed();
		System.out.println("is dashboard : "+isDisplayed);
		return isDisplayed;
	}

}
