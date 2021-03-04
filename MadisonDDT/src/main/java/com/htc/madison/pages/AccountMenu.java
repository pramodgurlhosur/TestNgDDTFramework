package com.htc.madison.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htc.madsion.base.TestBase;

public class AccountMenu extends TestBase{

	public AccountMenu(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="(//span[text()=\"Account\"])[1]")
	private WebElement clickAccountToLogout;
	@FindBy (xpath="//a[text()=\"Log Out\"]")
	private WebElement logoutButton;
	
	public void clickAccountToLogout()
	{
		this.clickAccountToLogout.click();
	}
	public void clickLogout()
	{
		this.logoutButton.click();
	}
}
