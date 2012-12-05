package com.manijshrestha.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test to assert that search is working
 * 
 * @author mshrestha
 * 
 */
public class SearchItemTest {

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
