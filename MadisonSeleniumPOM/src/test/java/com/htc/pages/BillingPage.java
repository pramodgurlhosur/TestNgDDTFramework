package com.htc.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.htc.utilities.Util;

public class BillingPage {
	private WebDriver driver = null;
	@FindBy(xpath = "//input[@id='newsletter']")
	private WebElement newsletter;
	@FindBy(xpath = "//span[text()=\"Subscribe\"]")
	private WebElement subscribeButton;
	@FindBy(xpath = "//input[@id='billing:company']")
	private WebElement company;
	@FindBy(xpath = "//input[@id='billing:street1']")
	private WebElement street;
	@FindBy(xpath = "//input[@id='billing:city']")
	private WebElement city;
	@FindBy(xpath = "//select[@id='billing:region_id']")
	private WebElement region;
	@FindBy(xpath = "//input[@id='billing:postcode']")
	private WebElement pincode;
	@FindBy(xpath = "//input[@id='billing:telephone']")
	private WebElement mobilenumber;
	@FindBy(xpath = "(//button[@type=\"button\"])[2]")
	private WebElement clickBillingcontinue;
	@FindBy(xpath = "(//button[@type=\"button\"])[3]")          
	private WebElement clickPaymentcontinue;
	@FindBy(xpath = "(//button[@type=\"submit\"])[2]")         
	private WebElement checkOut;

	public BillingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void performBilling(String email, String company, String street, String city, String region, String pincode,String mobilenumber)
	{
		try {
			this.newsletter.sendKeys(email);
			this.subscribeButton.click();
			this.company.sendKeys(company);
			this.street.sendKeys(street);
			this.city.sendKeys(city);
			Util.selectDropDownValue(this.region, region);
			this.pincode.sendKeys(pincode);
			this.mobilenumber.sendKeys(mobilenumber);
			clickBillingcontinue.click();
			Util.explicitWait(clickPaymentcontinue, driver);
			clickPaymentcontinue.click();
			Util.explicitWait(checkOut, driver);
			checkOut.click();
			
		} catch (NoSuchElementException nsee) {
			System.out.println(nsee.getStackTrace());
		}
		catch (StaleElementReferenceException  exception) {
			System.out.println(exception.getStackTrace());
		}
		catch (Throwable throwable) {
			System.out.println(throwable.getStackTrace());
		}

	}

}
