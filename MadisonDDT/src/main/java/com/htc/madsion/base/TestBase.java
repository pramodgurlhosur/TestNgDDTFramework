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
			fis = new FileInputStream("src\\main\\resources\\madison.properties");
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
    	
    	String browser=properties.getProperty("browser");
    	if(browser.equals("chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver",properties.getProperty("driver_path"));
    		driver = new ChromeDriver();
    	}
    	else if (browser.equals("firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", properties.getProperty("firefox_path"));
    		driver = new FirefoxDriver();
    	}
    	driver.manage().window().maximize();
    	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.get(properties.getProperty("url"));
    }
    
      public  void captureScreenshot(WebDriver driver,String fileName) throws IOException 
	{
		Date d=new Date();
        fileName =fileName+"_"+ d.toString().replace(":", "_").replace(" ", "_") + ".png";
           //colon and space is not supported in file naming format. 
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File("src\\main\\java\\com\\htc\\madision\\screenshots\\" + fileName));
	}
   }
