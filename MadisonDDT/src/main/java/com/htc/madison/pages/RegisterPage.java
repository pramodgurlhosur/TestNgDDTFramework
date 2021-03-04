package com.htc.madison.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htc.madsion.base.TestBase;

public class RegisterPage extends TestBase{

	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="(//span[@class=\"icon\"])[3]")
	private WebElement clickAccount;
	@FindBy (xpath="//a[@title=\"Register\"]")
	private WebElement clickRegister;
	@FindBy (xpath="//input[@id=\"firstname\"]")
	private WebElement firstName;
	@FindBy (xpath="//input[@id=\"middlename\"]")
	private WebElement middleName;
	@FindBy (xpath="//input[@id=\"lastname\"]")
	private WebElement lastName;
	@FindBy (xpath="//input[@id=\"email_address\"]")
	private WebElement email;
	@FindBy (xpath="//input[@id=\"password\"]")
	private WebElement password;
	@FindBy (xpath="//input[@id=\"confirmation\"]")
	private WebElement confirmPass;
	@FindBy (xpath="//*[@id=\"form-validate\"]/div[2]/button/span/span")
	private WebElement clickOnRegisterButton;

	@FindBy (xpath="//p[@class=\"welcome-msg\"]")
	private WebElement assertRegisterMsg;
	
	public void clickAccount()
	{
		this.clickAccount.click();
	}
	public void clickRegister()
	{
		this.clickRegister.click();
	}
	
	public void clickOnRegisterButton(String firstName,String mn,String lastName,String email,String password,String confirm) 
	{
		this.firstName.sendKeys(firstName);
		this.middleName.sendKeys(mn);
		this.lastName.sendKeys(lastName);
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		this.confirmPass.sendKeys(confirm);
		clickOnRegisterButton.click();
	}
	public String assertSuccessMsg()
	{
		return this.assertRegisterMsg.getText();
	}
}
