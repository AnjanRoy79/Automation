package com.TestNGDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAndAfterMethod {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	@BeforeMethod 
	// before method will execute all the methods mentioned in each test case once
	public void beforeMethod()
	{
		
	}
	
	@AfterMethod 
	// after method will execute all the methods mentioned in each test case once
	// Basically used to get results/output after the method is used.
	public void printTitle()
	{
		System.out.println("Title: " + driver.getTitle());
		
	}

	@Test(priority = 3)
	public void launchMyntra() {
		driver.get("https://www.myntra.com/");
		System.out.println("myntra opened successfully 3");
	}

	@Test(priority = 4)
	public void launchFlipkart() {
		driver.get("https://www.flipkart.com/");
		System.out.println("Flipkartt opened successfully 4");
	}

	@Test(priority = 1)
	public void launchLenskart() {
		driver.get("https://www.lenskart.com/");
		System.out.println("Lenskart opened successfully 1");
	}

	@Test(priority = 2)
	public void launchAmazon() {
		driver.get("https://www.amazon.in/");
		System.out.println("Amazon opened successfully 2 ");
	}

	
}
