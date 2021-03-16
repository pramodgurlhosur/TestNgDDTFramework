package com.htc.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htc.utilities.Util;

public class LoginPage {
	protected WebDriver driver = null;

	@FindBy(xpath = "(//span[@class='label'])[3]")
	private WebElement account;
	@FindBy(xpath = "//div[@class='links']//ul//li[@class=' last']//a")
	private WebElement login;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailid;
	@FindBy(xpath = "//input[@id='pass']")
	private WebElement password;
	@FindBy(xpath = "//button[@id='send2']")
	private WebElement loginbutton;
	@FindBy(xpath = "//a[@title='Log Out']")
	private WebElement logoutbutton;
	@FindBy(xpath = "//div[@class='welcome-msg']//p[@class='hello']//strong")
	private WebElement assertsuccessMsg;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void performLogin(String email, String password) {
		try {
			Util.explicitWait(account, driver);
			account.click();
			login.click();
			this.emailid.sendKeys(email);
			this.password.sendKeys(password);
			this.loginbutton.click();
		} catch (NoSuchElementException nsee) {
			System.out.println(nsee.getStackTrace());
		}
		catch (Exception exception) {
			System.out.println(exception.getStackTrace());
		}
		catch (Throwable throwable) {
			System.out.println(throwable.getStackTrace());
		}

	}

	public WebDriver returndriver() {
		return driver;
	}

	public String assertLogin() {
		return assertsuccessMsg.getText();
	}

	public void Logout() {
		account.click();
		logoutbutton.click();
	}
}
