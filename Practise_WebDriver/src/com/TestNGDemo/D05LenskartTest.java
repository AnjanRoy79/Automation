package com.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class D05LenskartTest {
	
	WebDriver driver;
	WebDriver driver1;
	  @BeforeTest(alwaysRun = true)
		public void launchBrowser() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver1 = new FirefoxDriver();
			driver1.manage().window().maximize();
			driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			

		}

	  @AfterTest(alwaysRun = true) // always run parameter executed the codes for xml
		public void closeBrowser() {
			driver.close();
			driver1.close();
		}

  @BeforeMethod(alwaysRun = true)
  public void beforeMethod() {
	  
	  driver.get("https://www.lenskart.com/");
	  System.out.println("Title :" + driver.getTitle());
	  
	  driver1.get("https://www.lenskart.com/");
	  System.out.println("Title :" + driver1.getTitle());
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod() {
	  System.out.println("Title :" + driver.getTitle());
	  System.out.println("Title :" + driver1.getTitle());
	 	    
  }
  
  @Test (priority = 1, groups = "group1")
  public void EYEGLASSES() {
	  
	  driver.findElement(By.xpath("//*[@id=\"lrd1\"]")).click();
	  driver1.findElement(By.xpath("//*[@id=\"lrd1\"]")).click();
	  }
  
  @Test (priority = 2, groups = "group2")
  public void SCREENGLASSES() {
	 
	  driver.findElement(By.xpath("//*[@id=\"lrd2\"]")).click();
	  driver1.findElement(By.xpath("//*[@id=\"lrd2\"]")).click();
	  }
  
  @Test (priority = 3, groups = "group1")
  public void KIDSGLASSES() {
	 
	  driver.findElement(By.xpath("//*[@id=\"lrd11\"]")).click();
	  driver1.findElement(By.xpath("//*[@id=\"lrd11\"]")).click();
	  }
  @Test (priority = 4, groups = "group2")
  public void SUNGLASSES() {
	  
	  driver.findElement(By.xpath("//*[@id=\"lrd5\"]")).click();
	  driver1.findElement(By.xpath("//*[@id=\"lrd5\"]")).click();
	  }

}
