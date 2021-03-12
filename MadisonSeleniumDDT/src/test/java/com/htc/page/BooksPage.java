package com.htc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksPage {
	protected WebDriver driver;
	private By selectBook=By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[3]/ul/li[2]/div/h2/a");	
	
		
	public BooksPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void selectBookFromList() {
		driver.findElement(selectBook).click();
	}
}
