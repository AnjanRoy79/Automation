package com.TestNGDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NestedFrame {
  @Test
  public void testFrame() 
  {
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/nested_frames");
	  
	  //top=0
//	  driver.switchTo().frame(0);
//	  driver.switchTo().frame("frame-left");
	  driver.switchTo().frame(0).switchTo().frame("frame-left");
	  System.out.println(driver.getPageSource());
	  
	  //left to middle
	  driver.switchTo().parentFrame().switchTo().frame("frame-middle");
	  System.out.println(driver.getPageSource());
	  
	  //middle to right
	  driver.switchTo().parentFrame().switchTo().frame("frame-right");
	  System.out.println(driver.getPageSource());
	  
	  //bottom
	  driver.switchTo().defaultContent().switchTo().frame(1);
	  System.out.println(driver.getPageSource());
	   
	  
  }
}

