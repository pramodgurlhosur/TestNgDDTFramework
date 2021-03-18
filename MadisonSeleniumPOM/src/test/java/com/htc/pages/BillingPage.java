package com.htc.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htc.base.TestBase;
import com.htc.constants.GlobalVariables;
import com.htc.utilities.Screenshot;
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
	@FindBy(xpath = "//button[@class='button btn-checkout']")          // (//button[@type=\"submit\"])[2]
	private WebElement placeOrderButton;

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
			clickPaymentcontinue.click();                                                                                                                               
			this.placeOrderButton.click();
			                                                                                                                                         Thread.sleep(4000);
			
		} catch (NoSuchElementException nsee) {
			System.out.println(nsee.getStackTrace());
		}
		catch (StaleElementReferenceException  exception) {
			System.out.println(exception.getStackTrace());
		}
		catch (RuntimeException runtime) {
			System.out.println(runtime.getStackTrace());
		}

		catch (Throwable throwable) {
			System.out.println(throwable.getStackTrace());
		}

	}

}
