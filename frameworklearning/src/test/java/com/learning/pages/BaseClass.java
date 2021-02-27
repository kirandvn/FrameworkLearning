package com.learning.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learning.utilities.AppProperties;
import com.learning.utilities.BrowserFactory;
import com.learning.utilities.CommonUtils;
import com.learning.utilities.ExcelDataProvider;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excelDataProvider;
	public AppProperties appProperties;
	public ExtentReports reports;
	public ExtentHtmlReporter reporter;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("setting up reports and test started", true);
		excelDataProvider = new ExcelDataProvider();
		appProperties = new AppProperties();
		reports = new ExtentReports();
		reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/facebook_"+CommonUtils.getCurrentDateTime()+".html"));
		reports.attachReporter(reporter);
	}

	@Parameters({"urlname","bname"})
	@BeforeMethod(alwaysRun = true)
		public void setUp(String urlname, String bname) {
//		driver = BrowserFactory.openBrowser(driver, appProperties.getBrowserFromProp());
		driver = BrowserFactory.openBrowser(driver, bname);

		Reporter.log("browser opened", true);

//		driver.get(appProperties.getAppURLFromProp());
		driver.get(urlname);

		System.out.println(driver.getTitle());
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
//			CommonUtils.captureScreenshot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(CommonUtils.captureScreenshot(driver)).build());
		}
		
		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(CommonUtils.captureScreenshot(driver)).build());
		}

		BrowserFactory.quitBrowser(driver);
		reports.flush();
		
		Reporter.log("test ended", true);

	}

}
