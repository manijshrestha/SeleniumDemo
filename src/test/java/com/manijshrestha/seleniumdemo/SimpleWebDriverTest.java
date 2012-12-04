package com.manijshrestha.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * This will demonstrate simple web driver test
 * @author mshrestha
 *
 */
public class SimpleWebDriverTest {

	WebDriver webDriver;
	
	/**
	 * Things to setup before Running tests in this class
	 */
	@BeforeClass
	public void setupBeforeClass() {
		this.webDriver = new FirefoxDriver();
	}
	
	@AfterClass
	public void tearDownClass() {
		this.webDriver.close();
	}
	
	@Test
	public void MicrosoftStore_Accessible() {
		this.webDriver.get("http://www.microsoftstore.com");
		
		WebElement signInLink = this.webDriver.findElement(By.id("dr_accountLinkSignIn"));
		
		assert signInLink.getText().contains("Sign in");
	}
}
