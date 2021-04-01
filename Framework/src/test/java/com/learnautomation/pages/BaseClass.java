package com.learnautomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	
	public WebDriver iDriver;
	public ExcelDataProvider fetchData;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() {
		
		Reporter.log("Setting up the reports and test getting ready", true);
		fetchData = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/TestReport_"+ Helper.getCurrentDateTime() +".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting done and test can be started", true);
		
	}
	
	@BeforeClass
	public void setup() {
		
		Reporter.log("Getting Browser Ready", true);
		iDriver = BrowserFactory.startApplication(iDriver, config.getBrowser() , config.getURL());
		Reporter.log("Browser Launched", true);
	}
	
	@AfterClass
	public void teardown() {
		
		 BrowserFactory.closeApplication(iDriver);
	}
	
	@AfterMethod
	public void teardownmethod(ITestResult result) {
		
		Reporter.log("Test about to end and Reports being generated", true);
		
		 if(result.getStatus()==ITestResult.FAILURE) {
			 
			  //Helper.captureScreenshot(iDriver);
			  //Very Important
			  logger.fail("Login Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(iDriver)).build());
		 }
		 else if(result.getStatus()==ITestResult.SUCCESS) {
			 
			  //Helper.captureScreenshot(iDriver);
			  //Very Important
			  logger.pass("Test Case Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(iDriver)).build());
		 }
		 
		 report.flush();
		 Reporter.log("Test Completed and Reports generated", true);
		
	}
	

}
