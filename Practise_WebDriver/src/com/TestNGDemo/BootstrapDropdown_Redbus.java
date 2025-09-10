package com.TestNGDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BootstrapDropdown_Redbus {
  @Test
  public void testDropdown() 
  {
	  //create driver session
	  WebDriver driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  driver.get("https://www.redbus.in/");
	  
	  
	  //from dropdown
	  driver.findElement(By.xpath("//div[text()='From']")).click();
	  
	  //enter input
	  driver.findElement(By.id("srcDest")).sendKeys("kol");
	  
	  //suggestion
	  List<WebElement> allOptions=driver.findElements(By.xpath("(//div[contains(@class,'searchCategory')])[1]//div[contains(@class,'listHeader')]"));
	  System.out.println("Total options are: "+allOptions.size());
	  
	  for(WebElement i:allOptions)
	  {
		  System.out.println(i.getText());
		  if(i.getText().contains("Esplande"))
		  {
			  i.click();
			  break;
		  }
	  }
	   
	  
  }
}

