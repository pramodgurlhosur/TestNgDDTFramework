package com.htc.register;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SeleniumAcademyRegister {
	WebDriver driver=null;
	Properties prop=null;
	 FileReader in=null;
	 
@BeforeMethod(alwaysRun=true)
public void setUp() throws Exception {
	System.out.println("Setting up for test");
	 in = new FileReader("src/main/resources/eportal.properties");
	 prop=new Properties();
	 prop.load(in);
	System.setProperty("webdriver.chrome.driver", prop.getProperty("driver_path"));
 driver =new ChromeDriver();
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 driver.manage().window().maximize();
}
  
@AfterMethod(alwaysRun=true)
public void tearDown() throws Exception {
	System.out.println("Closing the session");
	//driver.close();
}

@Test(priority=1,enabled=false)
public void testRegisterAccount_inputUserDetails_shouldShowSusccessfulRegistrationMessage() throws InterruptedException
{
	driver.get(prop.getProperty("website_url"));
	Thread.sleep(3000);
	WebElement clickAccount=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[1]"));
	clickAccount.click();
	WebElement clickRegister=driver.findElement(By.xpath("//a[text()=\"Register\"]"));
	clickRegister.click();
	WebElement firstName=driver.findElement(By.xpath("//input[@id=\"firstname\"]"));
	firstName.sendKeys(prop.getProperty("firstName"));
	WebElement middleName=driver.findElement(By.xpath("//input[@id=\"middlename\"]"));
	middleName.sendKeys(prop.getProperty("middleName"));
	WebElement lastName=driver.findElement(By.xpath("//input[@id=\"lastname\"]"));
	lastName.sendKeys(prop.getProperty("lastName"));
	WebElement email=driver.findElement(By.xpath("//input[@id=\"email_address\"]"));
	email.sendKeys(prop.getProperty("email"));
	WebElement password=driver.findElement(By.xpath("//input[@id=\"password\"]"));
	password.sendKeys(prop.getProperty("password"));
	WebElement confirmPass=driver.findElement(By.xpath("//input[@id=\"confirmation\"]"));
	confirmPass.sendKeys(prop.getProperty("confirm"));
	WebElement clickButton=driver.findElement(By.xpath("//span[text()=\"Register\"]"));
	clickButton.click();
	Thread.sleep(5000);
	WebElement successMessage=driver.findElement(By.xpath("//span[text()=\"Thank you for registering with Madison Island.\"]"));
	Assert.assertEquals(successMessage.getText(),"Thank you for registering with Madison Island.");
	System.out.println("Registration successfull"+successMessage.getText());
}

@Test(priority=2)
public void testLoginAccount_validCredentails_shouldShowSuccessMessage() throws InterruptedException
{
	driver.get(prop.getProperty("website_url"));
	Thread.sleep(3000);
	WebElement clickAccount=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[1]"));
	clickAccount.click();
	WebElement clickLogin=driver.findElement(By.xpath("//a[text()=\"Log In\"]"));
	clickLogin.click();
	WebElement email=driver.findElement(By.xpath("//input[@type=\"email\"][@title=\"Email Address\"]"));
	email.sendKeys(prop.getProperty("email"));
	WebElement password=driver.findElement(By.xpath("//input[@type=\"password\"]"));
	password.sendKeys(prop.getProperty("password"));
	WebElement loginButton=driver.findElement(By.xpath("//button[@type=\"submit\"][@title=\"Login\"]"));
	loginButton.click();
     Assert.assertEquals(driver.getTitle(), "My Account");
     System.out.println("After login the title changed to "+driver.getTitle());
}

@Test(priority=3)
public void testPurchaseProduct_enterDetailsRequired_shouldAllowToCheckout() throws InterruptedException
{ 
  Actions act=new Actions(driver);
	driver.get(prop.getProperty("website_url"));
	Thread.sleep(2000);
	WebElement clickAccount=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[1]"));
	clickAccount.click();
	WebElement clickLogin=driver.findElement(By.xpath("//a[text()=\"Log In\"]"));
	clickLogin.click();
	WebElement email=driver.findElement(By.xpath("//input[@type=\"email\"][@title=\"Email Address\"]"));
	email.sendKeys(prop.getProperty("email"));
	WebElement password=driver.findElement(By.xpath("//input[@type=\"password\"]"));
	password.sendKeys(prop.getProperty("password"));
	WebElement loginButton=driver.findElement(By.xpath("//button[@type=\"submit\"][@title=\"Login\"]"));
	loginButton.click();
	WebElement searchButton=driver.findElement(By.xpath("//input[@id=\"search\"]"));
	searchButton.sendKeys("mens pants");
	Thread.sleep(2000);
	searchButton.submit();
	//scroll down to view the product details
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("window.scroll(0,300)");
	Thread.sleep(2000);
	/*WebElement menOption=driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a"));
	act.moveToElement(menOption).perform();
	Thread.sleep(2000);
	//click on men then on pants and shirt
	WebElement menWearOptions=driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/ul/li[5]/a"));
	menWearOptions.click();
	/*WebElement searchBox=driver.findElement(By.xpath("//input[@id=\"search\"]"));
	searchBox.sendKeys("men");*/ 
	WebElement viewDetails=driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div[3]/ul/li[1]/div/div[2]/a"));
	viewDetails.click();
	//*[@id="top"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div[3]/ul/li[1]/div/div[2]/a
	Thread.sleep(3000);
	WebElement chooseColor=driver.findElement(By.xpath("//*[@id=\"swatch25\"]/span[1]/img"));
	chooseColor.click();
	//*[@id="swatch25"]/span[1]/img
	WebElement selectSize=driver.findElement(By.xpath("//*[@id=\"swatch59\"]/span[1]"));
	selectSize.click();
	//*[@id="swatch59"]/span[1]
	WebElement qty=driver.findElement(By.xpath("//*[@id=\"qty\"]"));
    qty.clear();   //clear the default quantity set 
	qty.sendKeys("3");
	WebElement addToCart=driver.findElement(By.xpath("//*[@id=\"product_addtocart_form\"]/div[3]/div[6]/div[2]/div[2]/button"));
	addToCart.click();
	//*[@id="product_addtocart_form"]/div[3]/div[6]/div[2]/div[2]/button
	WebElement proceedTocheckout=driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div/div[2]/div[1]/ul/li/button/span/span"));
	proceedTocheckout.click();
	//*[@id="product_addtocart_form"]/div[3]/div[6]/div[2]/div[2]/button
	driver.findElement(By.xpath("//*[@id=\"billing:company\"]")).sendKeys("BEL");//*[@id="billing:company"]
	driver.findElement(By.xpath("//*[@id=\"billing:street1\"]")).sendKeys("sadashiv nagar");
	driver.findElement(By.xpath("//*[@id=\"billing:street2\"]")).sendKeys("belgavi");
	driver.findElement(By.xpath("//*[@id=\"billing:city\"]")).sendKeys("Belgaum");
	driver.findElement(By.xpath("//*[@id=\"billing:region_id\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"billing:region_id\"]/option[44]")).click();
	driver.findElement(By.xpath("//*[@id=\"billing:postcode\"]")).sendKeys("591111");
	//*[@id="billing:postcode"]
	driver.findElement(By.xpath("//*[@id=\"billing:telephone\"]")).sendKeys("9177715161");
	driver.findElement(By.xpath("//*[@id=\"billing:fax\"]")).sendKeys("1640632626");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button")).click();
	driver.findElement(By.xpath("//*[@id=\"s_method_freeshipping_freeshipping\"]")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button/span/span")).click();

	driver.findElement(By.xpath("//*[@id=\"payment-buttons-container\"]/button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"review-buttons-container\"]/button")).click();
	Thread.sleep(2000);
	WebElement order=driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div/h2"));
    Assert.assertEquals(order.getText(), "THANK YOU FOR YOUR PURCHASE!");
	System.out.println("order successfull"+order.getText());
	

}
}
