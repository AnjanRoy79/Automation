package com.MobileTest.Capabilities.MobileScenarios;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.MobileTest.Capabilities.Utility.DriverSession;
import com.MobileTest.Capabilities.Utility.MobileElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class SwipeGesture {
  @Test
  public void testSwipe()
  {
	  
	  //create appium driver session
	  
	  AppiumDriver driver=DriverSession.initDriverSession();
	  
	  // Click on views
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  
	  //Click on gallery
	  driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
	  
	  
	  //Click on photos
	  driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
	  
	  
	  //click on area
	  WebElement pageArea=driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));
	  
	  	  
	  
	  //gesture
	  
	  MobileElement.swipeLeft(driver,pageArea,1);
	  
//	  driver.executeScript("mobile:swipeGesture",ImmutableMap.of(
//			  
//			  "elementId",((RemoteWebElement)pageArea).getId(),
//			  "direction","left",
//			  "percent",1.0
//			  ));
  
  }
}
