package com.TestNGDemo;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SVGElementAutomationDemo2 {
  @Test
  public void testSVG() throws InterruptedException
  {
	  //create driver session
	  WebDriver driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://bstackdemo.com/");
	  //driver.manage().window().maximize();
	  
	  //sign in link
	  driver.findElement(By.xpath("//span[@id='signin']")).click();
	  
	  Thread.sleep(2000);
	  
	  //login page
	  //driver.findElement(By.xpath("//div[@id='username']")).sendKeys("demouser");
	  //driver.findElement(By.xpath("//div[text()='Select Username']")).sendKeys("demouser");
	  
	  //user name
	  driver.findElement(By.xpath("(//*[name()='svg'])[2]")).click();
	  
	  driver.findElement(By.xpath("//div[text()='demouser']")).click();
	  
	  //password
	  driver.findElement(By.xpath("(//*[name()='svg'])[3]")).click();
	  driver.findElement(By.xpath("//div[text()='testingisfun99']")).click();
	  
	  //click on login button
	  driver.findElement(By.id("login-btn")).click();
	  
	  
	  
	  
  }
}

