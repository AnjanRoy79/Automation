package com.MobileTest.Capabilities.MobileScenarios;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.MobileTest.Capabilities.Utility.DriverSession;
import com.MobileTest.Capabilities.Utility.MobileElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ScrollGesture {
  @Test
  public void testScroll() throws InterruptedException
  {
	  //create appium driver session
	  AppiumDriver driver=DriverSession.initDriverSession();
	  
	  
	  // Click on views
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  
	  //get the page address/area
	  WebElement pageArea=driver.findElement(AppiumBy.id("android:id/content"));
	  
	  //perform gesture
	  
	  
	  MobileElement.scrollAsPerUserChoice(driver,pageArea,3,"down");
	  MobileElement.getScreenshot(driver,"ScrollDown");
	  
	  Thread.sleep(2000);
	  
	  MobileElement.scrollAsPerUserChoice(driver,pageArea,2,"up");
	  MobileElement.getScreenshot(driver,"ScrollUp");
	  
//	  driver.executeScript("mobile:scrollGesture",ImmutableMap.of(
//			  
//			  "elementId",((RemoteWebElement)pageArea).getId(),
//			  "direction","down",
//			  "percent",1.0
//			  
//			  ));
   
	  
  }
}
