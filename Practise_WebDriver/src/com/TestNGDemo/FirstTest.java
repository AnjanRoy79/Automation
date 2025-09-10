package com.TestNGDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {
  @Test // @test denotes each test
  public void RedBus() { // any thing can be given as the method name
	  
	  // normal Selenium code to be written here
	  
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		System.out.println("Title" + driver.getTitle());
		driver.close();
  }
}
