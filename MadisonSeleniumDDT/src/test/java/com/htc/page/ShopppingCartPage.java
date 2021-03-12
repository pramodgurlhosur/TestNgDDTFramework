package com.htc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopppingCartPage {
	protected WebDriver driver;

	private By selectQty=By.cssSelector("[title='Qty']");
	private By selectCheckBox=By.xpath("//*[@id=\"links_21\"]");//By.cssSelector("[id='links_21']");
	private By selectAddCardButton=By.xpath("//*[@id=\"product_addtocart_form\"]/div[3]/div[6]/div[2]/div[2]/button");


	public ShopppingCartPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void selectQuantity() {
		WebElement qty=driver.findElement(selectQty);
		qty.clear();
		qty.sendKeys("3");
	}
	public void selectCheckBox() {
		driver.findElement(selectCheckBox).click();
	}
	public void clickAddtoCartButton() {
		driver.findElement(selectAddCardButton).click();
	}
	public void addCart() {
		this.selectQuantity();
		this.selectCheckBox();
		this.clickAddtoCartButton();
	}
}


