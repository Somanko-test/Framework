package com.learnautomation.utility;

import java.io.File;
//import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;

public class Helper {
	
	//To Handle Screenshots, Frames and Multiple Windows, alerts , Sync issues , JScript Executor
	
	public static String captureScreenshot(WebDriver iDriver) {
		
		File src = ((TakesScreenshot)iDriver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "./Screenshots/FreeCRM_" + getCurrentDateTime() + ".png";
		try {
			FileHandler.copy(src, new File (screenshotPath));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println("Error while copying screenshot due to "+ ex.getMessage());
		}
		return screenshotPath;
		
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat newDateTime = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();	
		return newDateTime.format(currentDate);
	}

}
