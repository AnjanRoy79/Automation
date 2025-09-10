package com.TestNGDemo;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeywordDrivenFramework {
	WebDriver driver;
	File file; // file object is declared as we are storing the properties in a file
	FileInputStream fis; // FileInputStream is used here to read the data from properties file
	Properties prop; // this file stores all locators which we are going to use in the entire code
					// Will be used as reference file for all test. Can be used for multiple methods in the test.
	
	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File("D:\\Anjan-SeleniumDemos\\Practise_WebDriver\\src\\com\\TestNGDemo\\keyword.properties");//actual location of the file which is created
		fis = new FileInputStream(file);// reading the file from the location
		prop = new Properties();
		prop.load(fis);	//Load all the properties from .properties file and executes the test accordingly	
				
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url")); 
		}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
	

	@Test
	public void login() 
	{
		driver.findElement(By.name(prop.getProperty("nameUNTextBox"))).sendKeys("anjan");
		driver.findElement(By.id(prop.getProperty("idPsTxtBox"))).sendKeys("anjan123");
		driver.findElement(By.xpath(prop.getProperty("xpathLoginBtn"))).click();
		// .getProperty fetches the mentioned locators from the properties file
		// These above mentioned locators are declared in properties file
		System.out.println(driver.findElement(By.cssSelector(prop.getProperty("cssError"))).getText());
	}




}

