package com.TestNGDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAndAfterTestMethod {
	
	WebDriver driver; // A WebDriver variable driver is declared at the class level to be used across all test methods
	
	@BeforeTest // @before test method will execute the below code for each test at the beginning . Written once for all
				// In this case it is launching the browser
	
	public void launchBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest // @after test method will execute the below code after each test case. Written once for all
			  // in this case it is closing the browser for each test case.
	public void closeBrowser()
	{
		driver.close();
	}
	
	// Actual test cases below
	
	@Test (priority = 3)
	public void launchMyntra() {
		driver.get("https://www.myntra.com/");
		System.out.println("Title: " + driver.getTitle());
	}
	@Test (priority = 4)
	public void launchFlipkart() {
		driver.get("https://www.flipkart.com/");
		System.out.println("Title: " + driver.getTitle());
	}
	@Test (priority = 1)
	public void launchLenskart() {
		driver.get("https://www.lenskart.com/");
		System.out.println("Title: " + driver.getTitle());
	}
	@Test(priority = 2)
	public void launchAmazon() {
		driver.get("https://www.amazon.in/");
		System.out.println("Title: " + driver.getTitle());
	}

}
