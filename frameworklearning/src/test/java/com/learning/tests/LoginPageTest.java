package com.learning.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.learning.pages.BaseClass;
import com.learning.pages.LoginPage;
import com.learning.utilities.CommonUtils;
import com.learning.utilities.ExcelDataProvider;

public class LoginPageTest extends BaseClass {

	@Test
	public void verifyLogin() {
//		System.out.println("Thread name:"+ Thread.currentThread().getId());

		logger = reports.createTest("Login to FB");

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");

		String username = ExcelDataProvider.getStringData("usercreds", 1, 0);
		String password = ExcelDataProvider.getStringData("usercreds", 1, 1);

		loginpage.loginApp(username, password);
		logger.pass("Login successful");
		Reporter.log("LOGIN PASSED", true);

		CommonUtils.captureScreenshot(driver);
	}
	
	@Test(enabled = true)
	public void verifyPageTitleAfterLogin() {

		logger = reports.createTest("Verify page title on login to FB");

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");

		String username = ExcelDataProvider.getStringData("usercreds", 1, 0);
		String password = ExcelDataProvider.getStringData("usercreds", 1, 1);

		loginpage.loginApp(username, password);
		logger.pass("Login successful");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Kiran Dvn')]")));
		logger.pass("User name displayed after login is successful");
		String pageTitle = driver.getTitle();
		System.out.println("Page title on login is: "+pageTitle);
		logger.pass("Page title is captured after login is successful");

		CommonUtils.captureScreenshot(driver);
	}

	@Test(dependsOnMethods = { "verifyLogin" }, enabled = false)
	public void dummyTest() {

		System.out.println("Thread name:" + Thread.currentThread().getId());
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

		String username = ExcelDataProvider.getStringData("usercreds", 1, 0);
		String password = ExcelDataProvider.getStringData("usercreds", 1, 1);

		loginpage.loginApp(username, password);

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(driver.getTitle());
	}

}