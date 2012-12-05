package com.manijshrestha.seleniumdemo.remotewebdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author mshrestha
 * 
 */
public class RemoteSearchItemTest {

	WebDriver webDriver;

	/**
	 * Things to setup before Running tests in this class
	 * 
	 * @throws MalformedURLException
	 */
	@BeforeClass
	public void setupBeforeClass() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		this.webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	}

	@AfterClass
	public void tearDownClass() {
		this.webDriver.close();
	}

	@Test
	public void Surface_Search() {
		this.webDriver.get("http://www.microsoftstore.com");

		WebElement searchBox = this.webDriver.findElement(By.id("dr_search_text"));
		searchBox.sendKeys("surface");
		searchBox.submit();

		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		WebElement breadCrumb = wait.until(ExpectedConditions.elementToBeClickable(By.id("dr_breadcrumb")));

		assert breadCrumb.getText().equals("HOME > SEARCH RESULTS");
		assert this.webDriver.getTitle().contains("Search results");
	}
}
