package com.MobileTest.Capabilities.MobileScenarios;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import com.MobileTest.Capabilities.Utility.DriverSession;
import com.MobileTest.Capabilities.Utility.MobileElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class KeyboardEvent {
  @Test
  public void testKeyEvents() 
  {
	  //create appium driver session
	  AppiumDriver driver=DriverSession.initDriverSession();
	  
	  //views
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  
	  //page area
	  WebElement pageArea=driver.findElement(AppiumBy.id("android:id/content"));
	  
	  //scroll down 3 time
	  MobileElement.scrollAsPerUserChoice(driver,pageArea,3,"down");
	  
	  //textfields
	  
	  driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
	  
	  //input field
	 // driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).sendKeys("Hello All");	  
	  /*
	   * Appium support Android/IOS/Window application test
	   * Few methods/commands are platform specific and if you wanted to access it then do type casting
	   * here AppiumDriver instance (driver) we are converting into AndroidDriver instance.
	   */
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.H));	  
	  
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.E));
	  
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.L));
	  
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.L));
	  
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.O));
	  
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.SPACE));
	  
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.A));
	  
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.L));
	  
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.L));
	  
	  
	  
  }
}
