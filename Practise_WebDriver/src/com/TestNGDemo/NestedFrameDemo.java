package com.TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NestedFrameDemo {
  @Test
  public void testNestedFrame() 
  {
	  //create driver session
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://ui.vision/demo/webtest/frames/");
	  
	  //frame1
	  //driver.switchTo().frame(0);
	  WebElement fele=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
	  driver.switchTo().frame(fele);
	  driver.findElement(By.name("mytext1")).sendKeys("Frame1 test");
	  
	  //Selects either the first frame on the page, or the main document when a page contains iframes. 
	  driver.switchTo().defaultContent();
	  
	  //frame2
	  driver.switchTo().frame(1);
	  driver.findElement(By.name("mytext2")).sendKeys("Frame2 test");
	  
	  //outside
	  driver.switchTo().defaultContent();
	  
	  //Nested frame concept
	  //frame3
	  driver.switchTo().frame(2);
	  WebElement input3=driver.findElement(By.name("mytext3"));
	  input3.sendKeys("Frame3 test");
	  
	  //parent --->child(iframe)
	  WebElement ele=driver.findElement(By.tagName("iframe"));
	  driver.switchTo().frame(ele);
	  
	  driver.findElement(By.id("i9")).click();
	  
	  
	  //child ---->parent -->clear text-->add next text
	  //parentFrame():Change focus to the parent context. 
	  driver.switchTo().parentFrame();
	  input3.clear();
	  input3.sendKeys("Bye Everyone!");
	   
	  
  }
}

