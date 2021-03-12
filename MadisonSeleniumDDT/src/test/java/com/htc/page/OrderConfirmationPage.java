package com.htc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
	protected WebDriver driver;
	private By message=By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div/h2");	

		
	public OrderConfirmationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String SuccessMsg() {
		String text=driver.findElement(message).getText();
		return text;
	}
}
