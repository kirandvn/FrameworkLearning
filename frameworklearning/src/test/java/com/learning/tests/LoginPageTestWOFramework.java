package com.learning.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTestWOFramework {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		driver.findElement(By.name("email")).sendKeys("kirandvn@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("eRock#123");
		driver.findElement(By.xpath("//button[@type='submit']"));

		driver.quit();

	}

}
