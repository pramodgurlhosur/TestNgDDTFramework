package com.htc.grid.utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverFactory {
	public static WebDriver getDriver(Browser browser, String nodeURL) throws MalformedURLException {

		WebDriver browserDriver = null;
		DesiredCapabilities browserCapability = null;

		switch (browser) {
		case CHROME:
			browserCapability = DesiredCapabilities.chrome();
				browserDriver = new RemoteWebDriver(new URL(nodeURL), browserCapability);
				// TODO Auto-generated catch block
			break;
			
		case FIREFOX:
			browserCapability = DesiredCapabilities.firefox();
		
				browserDriver = new RemoteWebDriver(new URL(nodeURL), browserCapability);
			
		
			break;
		}

		return browserDriver;

	}
}
