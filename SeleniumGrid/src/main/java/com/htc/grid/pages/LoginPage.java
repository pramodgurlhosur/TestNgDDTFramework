package com.htc.grid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//span[text()="Invalid login or password."]
	@FindBy (xpath="(//span[@class='label'])[3]")
	private WebElement clickAccount;
	@FindBy (xpath=" //a[@title=\"Log In\"]")
	private WebElement clickLogin;
	@FindBy (xpath="//input[@type=\"email\"][@title=\"Email Address\"]")
	private WebElement email;
	@FindBy (xpath="//input[@type=\"password\"]")
	private WebElement password;
	@FindBy (xpath="//button[@type=\"submit\"][@title=\"Login\"]")
	private WebElement login;
	@FindBy (xpath="//h1[text()=\"My Dashboard\"]")
	private WebElement loginDashboard;

	public void accountBy()
	{
		this.clickAccount.click();
	}
	
	public void loginBy() {
		this.clickLogin.click();
	}
		 public void enterEmail(String mail) {
		   this.email.sendKeys(mail);
		 }
		//Method to enter password
			 public void enterPassword(String pass) {
				 this.password.sendKeys(pass);
			 }
		
			 public void clicklogin() {
			   this.login.click();
			 }
			 public String loginDashboard()
			 {
				 return this.loginDashboard.getText();
			 }
		
}
