package com.TestNGDemo;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SVGElementAutomation {
  @Test
  public void testSVGElement()
  {
	  //create driver session
	  WebDriver driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
	  
	  //automate links with svg
	  List<WebElement> allSVGLinks=driver.findElements(By.xpath("//*[name()='svg']"));
	  
	  System.out.println("Total SVG links are: "+allSVGLinks.size());
	  
	  int count=0;
	  for(WebElement i:allSVGLinks)
	  {
		  count++;
		  
		  if(count==4)//youtube
		  {
			  i.click();
			  break;
		  }
		  
	  }
	 
  }
}

