package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver iDriver) {
		
		//Initializing driver in a constructor , my first commit Somanko
		this.driver = iDriver;
	}
	
   @FindBy(xpath = "//input[@ng-model='FirstName']") WebElement uName;
   @FindBy(xpath = "//input[@ng-model='LastName']") WebElement lName;
   @FindBy(id = "submitbtn") WebElement loginButton;
   
   public void getLogin(String userApplication, String lastName){
	   
	   try {
		Thread.sleep(3000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   uName.sendKeys(userApplication);
	   lName.sendKeys(lastName);
	   loginButton.click();
	   try {
		Thread.sleep(5000);
	} catch (Exception ex) {
		// TODO Auto-generated catch block
		ex.printStackTrace();
	}
	   
   }
   
}
