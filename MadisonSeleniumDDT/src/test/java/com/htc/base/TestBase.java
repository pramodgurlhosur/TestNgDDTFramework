package com.htc.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.htc.javaUtility.BrowserFactory;
import com.htc.javaUtility.DataProviderConfig;
import com.htc.page.BooksPage;
import com.htc.page.CartPage;
import com.htc.page.CheckOutPage;
import com.htc.page.HomePage;
import com.htc.page.LoginPage;
import com.htc.page.OrderConfirmationPage;
import com.htc.page.RegistrationPage;
import com.htc.page.ShopppingCartPage;
import com.htc.seleniumUtility.TestUtil;

public class TestBase {

	public static WebDriver driver = null;
    protected RegistrationPage register = null;
	protected HomePage home = null;
	protected DataProviderConfig config=null;
	protected LoginPage login = null;
	protected BooksPage books=null;
	protected CartPage cart=null;
	protected ShopppingCartPage addToCart=null;
	protected CheckOutPage checkOut=null;
	protected OrderConfirmationPage order=null;
	protected ExtentReports report;
	protected ExtentTest logger;
	public Properties data=null;

	@BeforeSuite
	public void loadProptiesFile()
	{
		Reporter.log("Setting up reports and Test is getting ready", true);
		data=new Properties();
		try {
			FileInputStream fis=new FileInputStream("D:\\ECLIPSE WORKSPACE\\MadisonSeleniumDDT\\src\\test\\resources\\madisonData.properties");
			data.load(fis);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(new File("./Reports/MadisonIsland_"+TestUtil.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		config=new DataProviderConfig();
		Reporter.log("Setting up reports", true);
	}

	@BeforeClass
	public void setup() {
		
		driver=BrowserFactory.startBrowser(driver,config.getBrowser(),config.getStagingURL(),config.getDriverLocatioin());
		Reporter.log("Trying to start Browser and Getting Application ready", true);
		Reporter.log("Browser and Application up and running", true);
		books=new BooksPage(driver);
		addToCart=new ShopppingCartPage(driver);
		cart=new CartPage(driver);
		checkOut=new CheckOutPage(driver);
		register = new RegistrationPage(driver);
		order=new OrderConfirmationPage(driver);
		home=new HomePage(driver);
		login=new LoginPage(driver);
	}
	
	@AfterMethod
	public void screenshot(ITestResult result) throws IOException {
		Reporter.log("Test is about to end", true);

		if(result.getStatus()==ITestResult.FAILURE) 
		{
			//TestUtil.captureScreenShot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenShot(driver,result)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenShot(driver,result)).build());
		}
		report.flush();
       Reporter.log("Test is Completed and Reports Generated", true);
	}

}