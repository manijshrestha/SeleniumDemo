package com.manijshrestha.seleniumdemo.remotewebdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author mshrestha
 * 
 */
public class RemoteSimpleWebDriverTest {

	WebDriver webDriver;

	/**
	 * Things to setup before Running tests in this class
	 * 
	 * @throws MalformedURLException
	 */
	@BeforeClass
	public void setupBeforeClass() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		this.webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
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
