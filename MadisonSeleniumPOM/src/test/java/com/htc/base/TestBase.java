package com.htc.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.htc.constants.GlobalVariables;
import com.htc.pages.BillingPage;
import com.htc.pages.CartPage;
import com.htc.pages.Homepage;
import com.htc.pages.LoginPage;
import com.htc.pages.OrderConfirmationPage;
import com.htc.pages.ProductsPage;
import com.htc.pages.RegistrationPage;
import com.htc.pages.ShoppingCartPage;
import com.htc.utilities.Screenshot;

public class TestBase {
	protected WebDriver driver=null;
	protected RegistrationPage register = null;
	protected LoginPage login = null;
	protected Homepage home = null;
	protected ProductsPage product = null;
	protected CartPage cart = null;
	protected ShoppingCartPage shop = null;
	protected BillingPage billing = null;
	protected OrderConfirmationPage order = null;
    protected Screenshot screenshot = null;
    public Properties properties = null;

	public TestBase() 
	{
		properties = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("src//test//resources//madison.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeSuite
	@Parameters("platform")
	public void start(String browser) {

		this.driver = BrowserFactory.selectWebDriver(browser);
		this.driver.get(GlobalVariables.URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_IN_SECONDS, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void createPageObjects() {
		register=new RegistrationPage(driver);
		login = new LoginPage(driver);
		home = new Homepage(driver);
		product = new ProductsPage(driver);
		cart = new CartPage(driver);
		shop = new ShoppingCartPage(driver);
		billing = new BillingPage(driver);
		order = new OrderConfirmationPage(driver);
	}

	  @BeforeTest 
	  public WebDriver getDriver() 
	  { 
		  return this.driver; 
	  }
	 
    @AfterMethod
	public void performlogOutOperaton()
	{
		login.Logout();
    }
}
