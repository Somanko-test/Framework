package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;


public class LoginTestCRM extends BaseClass {
	
	//WebDriver iDriver;
	//OOPS Abstraction
	@Test
	public void loginApp() {
		
	     //iDriver = BrowserFactory.startApplication(iDriver, "Chrome", "https://www.google.com");
	     //System.out.println(iDriver.getTitle());
		 logger = report.createTest("Login to Register Automation");
	     LoginPage loginpage = PageFactory.initElements(iDriver, LoginPage.class);
	     logger.info("Starting the application");
	     loginpage.getLogin(fetchData.getStringData("Login", 0, 0),fetchData.getStringData("Login", 0, 1));
	     logger.pass("Test Successful");
	    // BrowserFactory.closeApplication(iDriver);
	     //Helper.captureScreenshot(iDriver);
	}

}
