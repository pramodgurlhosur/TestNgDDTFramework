package com.htc.madison.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.htc.madsion.base.TestBase;

public class Billing extends TestBase{
	
	public Billing(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//button[@class='button btn-checkout']")
	private WebElement checkout;
	@FindBy (xpath="//input[@id='billing:company']")
	private WebElement company;
	@FindBy (xpath="//*[@id=\"billing:street1\"]")
	private WebElement street1;
	@FindBy (xpath="//*[@id=\"billing:street2\"]")
	private WebElement street2;
	@FindBy (xpath="//*[@id=\"billing:city\"]")
	private WebElement city;
	@FindBy (xpath="//*[@id=\"billing:region_id\"]")
    private WebElement regionBy;
	@FindBy (xpath="//*[@id=\"billing:region_id\"]/option[13]")
    private WebElement optionRegion;
	
	@FindBy (xpath="//*[@id=\"billing:postcode\"]")
	private WebElement pincode;
	@FindBy (xpath="//*[@id=\"billing:country_id\"]")
	private WebElement selectCountry;
	@FindBy (xpath="//*[@id=\"billing:country_id\"]/option[6]")
	private WebElement optionCountry;
	@FindBy (xpath="//*[@id=\"billing:telephone\"]")
	private WebElement mobileNumber;
	@FindBy (xpath="(//button[@class='button'])[1]")
    private WebElement billingContinue;
	@FindBy (xpath="//*[@id=\"s_method_freeshipping_freeshipping\"]")
    private WebElement shippingmethod;
	
	@FindBy (xpath="//*[@id=\"shipping-method-buttons-container\"]/button/span/span")
	private WebElement shippingcontinue;
	@FindBy (xpath="//*[@id=\"payment-buttons-container\"]/button/span/span")
    private WebElement paymentcontinue;
	@FindBy (xpath="//*[@id=\"review-buttons-container\"]/button/span/span")
    private WebElement placeOrder;
	
	public void setcompanyBy(String company) {
		this.company.sendKeys(company);
	}
	public void setstreetBy(String street) {
		this.street1.sendKeys(street);;
	}
	public void setstreet(String street) {
		this.street2.sendKeys(street);;
	}
	public void setcityBy(String city) {
		this.city.sendKeys(city);;
	}
	public void setregionBy(String region) {
		Select drop= new Select(this.regionBy); 
		
		  drop.selectByVisibleText(region);
	}
	public void setpincodeBy(String pincode) {
		this.pincode.sendKeys(pincode);
	}
	public void setCountryBy(String country) {
		Select drop= new Select(this.selectCountry); 
		
		  drop.selectByVisibleText(country);
	}
	public void setmobilenumberBy(String mobilenumber) {
		this.mobileNumber.sendKeys(mobilenumber);
	}
	public void click_billingcontinueBy() {
		this.billingContinue.click();
	}
	public void setshippingmethodBy() {
		this.shippingmethod.click();
	}
	public void click_shippingcontinueBy() {
		this.shippingcontinue.click();
	}
	public void click_paymentcontinueBy() {
	   this.paymentcontinue.click();
	}
	public void click_chechoutBy() {
		this.checkout.click();
	}
	public void clickPlaceOrder() {
	this.placeOrder.click();
	}

	
}

