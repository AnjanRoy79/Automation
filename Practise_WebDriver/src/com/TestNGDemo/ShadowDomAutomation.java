package com.TestNGDemo;



import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowDomAutomation {
  @Test
  public void testShadowDoM()
  {
	  //create driver session
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	    
	  //document-->host-->root-->shadow element
	  //shadow host
	  WebElement host1=driver.findElement(By.cssSelector("#shadow_host"));
	  //shadow root
	  SearchContext root1=host1.getShadowRoot();
	  //shadow element
	  String text1=root1.findElement(By.cssSelector("#shadow_content")).getText();
	  
	  System.out.println("Text 1 is: "+text1);
	  
	  
	  
	  //nested element
	  /*
	   * root1--->root2
	   * 
	   * root1-->host2--->root2-->shadow element
	   */
	  WebElement host2=root1.findElement(By.cssSelector("#nested_shadow_host"));
	  
	  //get the root
	 SearchContext root2=host2.getShadowRoot();
	 
	 //root-->element
	 String text2=root2.findElement(By.cssSelector("#nested_shadow_content")).getText();
	  System.out.println("Nested dom element text is: "+text2);
	  
	  //input box: host1 and root1
	  
	  root1.findElement(By.cssSelector("input[type='text']")).sendKeys("Shadow inputbox tested");
	  
	  
  }
}

