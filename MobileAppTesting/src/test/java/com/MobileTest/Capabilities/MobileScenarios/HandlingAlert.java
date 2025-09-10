package com.MobileTest.Capabilities.MobileScenarios;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import com.MobileTest.Capabilities.Utility.DriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class HandlingAlert {
  @Test
  public void testAlert() throws InterruptedException
  {
	  //create driver session
	  AppiumDriver driver=DriverSession.initDriverSession();
	  
	  // Click on app link 
	  driver.findElement(AppiumBy.accessibilityId("App")).click();
	  Thread.sleep(1000);
	  
	  
	  // Click on respective alert link
	  driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
	  
	  
	  //open alert1
	  driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
	  Thread.sleep(1000);
	  //alert will open
	  
	  Alert alt1=driver.switchTo().alert();
	  System.out.println("Alert1 text is: "+alt1.getText());
	  // Click on OK
	  alt1.accept();
	  
	  driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
	  Thread.sleep(1000);
	  //alert will open
	  
	  Alert alt2=driver.switchTo().alert();
	  System.out.println("Alert2 text is: "+alt2.getText());
	  // Click on OK
	  alt2.accept();
 	  
  }
}
