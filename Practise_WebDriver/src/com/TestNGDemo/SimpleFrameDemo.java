package com.TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SimpleFrameDemo {
  @Test
  public void testFrame() 
  {
	  //create driver session
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://www.lambdatest.com/selenium-playground/iframe-demo/");
	  //switch to frame with indexing
	  //  driver.switchTo().frame(0);
	  
	  
	  //switch to frame with name/ id
	  //driver.switchTo().frame("iFrame1");
	  
	  //switch to frame with WebElement
	  WebElement frameElement=driver.findElement(By.id("iFrame1"));
	  driver.switchTo().frame(frameElement);
	  
	
	  WebElement ele=driver.findElement(By.xpath("//div[@class='rsw-ce']"));
	  
	  ele.clear();
	  ele.sendKeys("Hello All!");
	  
	  driver.close();
	  
	  
  }
}
