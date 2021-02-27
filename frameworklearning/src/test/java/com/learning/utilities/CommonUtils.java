package com.learning.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CommonUtils {

	// Screenshots, alerts, frames, multiple windows, sync issues,
	// javascriptexecutor, customdateformat

	public static String captureScreenshot(WebDriver driver) {

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/FacebookTest_"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(screenshot, new File(screenshotPath));
//			System.out.println("Screenshot Captured successfully");

		} catch (Exception e) {
			System.out.println("unable to capture screenshot" + e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return dateFormat.format(date);
		
	}

}