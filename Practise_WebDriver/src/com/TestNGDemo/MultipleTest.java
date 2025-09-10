package com.TestNGDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleTest {
	
  @Test 
   public void RedBus() { // if priority same for two or more test case, then it will follow the alphabetical order.
	    
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		System.out.println("Title" + "" +driver.getTitle());
		driver.close();
  }
  
  @Test // if priority not set, test will run alphabetical order
  public void Amazon() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		System.out.println("Title" + "" +  driver.getTitle());
		driver.close();
	  
  }
  
  @Test(priority = 1) // setting priority to which test will execute first
  public void Greetings() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.123greetings.com/");
		System.out.println("Title" + "" + driver.getTitle());
		driver.close();
	  
  }
  
}
