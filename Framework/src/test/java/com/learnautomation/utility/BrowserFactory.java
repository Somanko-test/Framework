package com.learnautomation.utility;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver iDriver,String browserName,String appURL) {
		
		if(browserName.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			iDriver = new ChromeDriver();
			
			
		}
		else if(browserName.equals("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			iDriver = new FirefoxDriver();
			//iDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		else if(browserName.equals("IE")) {
			
			System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
			iDriver = new InternetExplorerDriver();
			//iDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);			
		}
		else {
		
			System.out.println("Please specify Browser to launch");
		 	
		}
		
		iDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		iDriver.manage().window().maximize();
		iDriver.navigate().to(appURL);
		return iDriver;
	}
	
	public static void closeApplication(WebDriver iDriver) {
		
		iDriver.quit();
		
	}

}
