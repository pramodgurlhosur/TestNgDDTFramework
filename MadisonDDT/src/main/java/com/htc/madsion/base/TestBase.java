package com.htc.madsion.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.htc.madison.pages.LoginPage;
import com.htc.madison.pages.RegisterPage;
import com.htc.madison.util.TestUtil;


public class TestBase {
    protected WebDriver driver;
    protected Properties properties;
    RegisterPage register;
    LoginPage login;
  
   public TestBase()
    {
    	properties=new Properties();
    	FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:\\ECLIPSE WORKSPACE\\MadisonDDT\\src\\main\\resources\\madison.properties");
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
	  public void setUp()
	  {
		  this.initialization();
	  }
	  
	  @AfterSuite
	  public void tearDown()
	  {
		  //driver.close();
	  }
	  
    public void initialization()
    {
    	TestUtil util=new TestUtil();
    	String browser=properties.getProperty("browser");
    	if(browser.equals("chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver",properties.getProperty("driver_path"));
    		driver = new ChromeDriver();
    	}
    	else if (browser.equals("firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", "D:\\FireFoxDriverGECKOSETUP\\geckodriver.exe");
    		driver = new FirefoxDriver();
    	}
    	driver.manage().window().maximize();
    	driver.manage().timeouts().pageLoadTimeout(util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(util.IMPLICIT_WAIT, TimeUnit.SECONDS);
    	driver.get(properties.getProperty("url"));
    }
    
      public  void captureScreenshot(WebDriver driver,String fileName) throws IOException 
	{
		Date d=new Date();
        fileName =fileName+"_"+ d.toString().replace(":", "_").replace(" ", "_") + ".png";
           //colon and space is not supported in file naming format. 
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File("D:\\ECLIPSE WORKSPACE\\MadisonDDT\\src\\main\\java\\com\\htc\\madision\\screenshots\\" + fileName));
	}
   }
