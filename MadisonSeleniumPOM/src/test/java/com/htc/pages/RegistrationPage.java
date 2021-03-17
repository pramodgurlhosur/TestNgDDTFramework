package com.htc.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.htc.utilities.Util;

public class RegistrationPage {
	protected WebDriver driver = null;
	@FindBy(xpath = "(//span[@class='label'])[3]")
	private WebElement account;
	@FindBy(xpath = "//div[@id='header-account']//div//ul//li//a[@title='Register']")
	private WebElement register;
	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstname;
	@FindBy(xpath = "//input[@id='middlename']")
	private WebElement middlename;
	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastname;
	@FindBy(xpath = "//input[@id='email_address']")
	private WebElement emailid;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//input[@id='confirmation']")
	private WebElement confirmPassword;
	@FindBy(xpath = "//button[@class='button']")
	private WebElement clickRegisterButton;
	@FindBy(xpath = "//span[contains(text(),'Thank you for registering with Madison Island.')]")
	private WebElement successMessage;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void performRegistration(String firstname, String middlename, String lastname, String emailid,String password, String confirmpassword) 
	{
		try {
			Util.explicitWait(account, driver);
			account.click();
			register.click();
			this.firstname.sendKeys(firstname);
			this.middlename.sendKeys(middlename);
			this.lastname.sendKeys(lastname);
			this.emailid.sendKeys(emailid);
			this.password.sendKeys(password);
			this.confirmPassword.sendKeys(confirmpassword);
			clickRegisterButton.click();
		   } 
		    catch (NoSuchElementException nsee) {
			System.out.println(nsee.getStackTrace());
		   }
		  catch (StaleElementReferenceException  exception) {
			System.out.println(exception.getStackTrace());
		}
		catch (Throwable throwable) {
			System.out.println(throwable.getStackTrace());
		}
    }

        public String assertSuccessMessage()
        {
		return successMessage.getText();
	    }
}
