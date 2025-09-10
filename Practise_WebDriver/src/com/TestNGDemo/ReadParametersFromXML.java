package com.TestNGDemo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ReadParametersFromXML
{
	WebDriver driver;
	JavascriptExecutor js;
	
	//For reading the values of respective parameters from xml file
	//Any numbers of parameters passed with any name as variable already declared in XML
	@Parameters({"userName", "password"})
	
	@Test
	public void login(String un, String ps) // Assigning two variable to be used as send keys parameter
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ps);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
	}

	@AfterMethod
	public void afterMethod() {
		//driver.findElement(By.linkText("Logout")).click();
		js.executeScript("arguments[0].click()", driver.findElement(By.linkText("Logout")));
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/login");
		js = (JavascriptExecutor) driver;
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}