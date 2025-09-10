package com.MobileTest.Capabilities.MobileScenarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.MobileTest.Capabilities.Utility.DriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver; 


public class DragAndDrop{

	@Test
 public void DragGesture ()
  {
	  //create appium driver session
	  AppiumDriver driver=DriverSession.initDriverSession();
	  
	  //click on views link
	    
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  
	  // Click on drag and drop link
	  driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	  
	  // Click any one circle-dot1
	  WebElement ele=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
	  
	  // perform drag gesture and assert the value of outcome
	  driver.executeScript("mobile:dragGesture",ImmutableMap.of(
			  "elementId", ((RemoteWebElement)ele).getId(),
			  "endX",408,
			  "endY",1657
			   ));
	  
	  String actText=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
	  String expText="Dropped!";
	  Assert.assertEquals(actText,expText);
	  System.out.println("Drag Gesture is completed with text: "+actText);
  
  }
}
