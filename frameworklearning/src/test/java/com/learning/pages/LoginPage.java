package com.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}

@FindBy(name="email")
WebElement uname;

@FindBy(name="pass")
WebElement password;

@FindBy(xpath="//button[@type='submit']")
WebElement LogIn;

public void loginApp(String usernameApp, String passwordApp) {
	
	uname.sendKeys(usernameApp);
	password.sendKeys(passwordApp);
	LogIn.click();
	
}


}
