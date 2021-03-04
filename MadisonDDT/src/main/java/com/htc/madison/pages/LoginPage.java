package com.htc.madison.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htc.madsion.base.TestBase;

public class LoginPage extends TestBase {
	public WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="(//span[@class='label'])[3]")
	private WebElement clickAccount;
	@FindBy (xpath="//a[@title=\"Log In\"]")
	private WebElement clickLogin;
	@FindBy (xpath="//input[@id='email']")
	private WebElement emailId;
	
	@FindBy (xpath="//input[@id='pass']")
	private WebElement password;
	@FindBy (xpath="//button[@id='send2']")
	private WebElement loginButton;
	@FindBy (xpath="//h1[text()=\"My Dashboard\"]")
	private WebElement assertDashboardMsg;
	@FindBy (xpath="//span[text()=\"Invalid login or password.\"]")
	private WebElement assertInvalid;
	public void clickAccount()
	{
		this.clickAccount.click();
	}
	public void clickLogin() {
		this.clickLogin.click();
	}
	public void setEmailId(String email) {
		this.emailId.sendKeys(email);
	}
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	public void clickloginButton() {
		this.loginButton.click();
	}

	public HomePage doLogin(String emailId,String password)
	{
		clickAccount();
		clickLogin();
		setEmailId(emailId);
		setPassword(password);
		clickloginButton();
		return new HomePage(driver);
	}
	public String assertDashboard() {
		return driver.getTitle();
	}
	
	public String assertInvalidMsg() {
		return this.assertInvalid.getText();
	}
}
