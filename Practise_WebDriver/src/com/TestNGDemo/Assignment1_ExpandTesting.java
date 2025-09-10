package com.TestNGDemo;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Assignment1_ExpandTesting {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/login");
		
	}
	@AfterTest
	public void closeBrowser() 
	{
			driver.close();
	}

	 @AfterMethod
	  public void afterMethod() 
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)", "");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"core\"]/div/div/a/i")));
		 logoutBtn.click();
		}
	 
  @Test
  public void Login()
  {
	  driver.findElement(By.id("username")).sendKeys("practice");
	  driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	  driver.findElement(By.xpath("//*[@id=\"login\"]/button")).submit();
  }
}
