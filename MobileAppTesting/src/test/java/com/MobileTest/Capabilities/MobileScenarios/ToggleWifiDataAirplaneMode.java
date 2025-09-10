package com.MobileTest.Capabilities.MobileScenarios;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import com.MobileTest.Capabilities.Utility.DriverSession;
import com.MobileTest.Capabilities.Utility.MobileElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ToggleWifiDataAirplaneMode {
  @Test
  public void testDeviceFeature() throws InterruptedException 
  {
	  AppiumDriver driver=DriverSession.initDriverSession();
	  
	  
	  /*
	   * wifi-toggleWifi()
	   * mobileData- toggleData()
	   * airplaneMode- toggleAirplaneMode()
	   */
	  
	  System.out.println("Initial status for Wifi is ON");
	  ((AndroidDriver)driver).toggleWifi();
	  System.out.println("After command status for Wifi is OFF");
	  
	  //mobileData-swipe left
	  //page area
	  WebElement pageArea=driver.findElement(AppiumBy.id("com.android.systemui:id/tile_page"));
	  MobileElement.swipeLeft(driver,pageArea,1);
	  
	  System.out.println("Initial status for Mobile Data is ON");
	  //ON to OFF
	  ((AndroidDriver)driver).toggleData();
	  
	  System.out.println("After Command status for Mobile Data is OFF");
	  //off to On
	Thread.sleep(2000);
	
	  ((AndroidDriver)driver).toggleData();
	  
	  //airplaneMode
	  
	  System.out.println("Initial status for AirplaneMode is OFF");
	  //off to on
	  
	  ((AndroidDriver)driver).toggleAirplaneMode();
	  
	  System.out.println("After Command status for AirplaneMode is ON");
 	  
  }
}
