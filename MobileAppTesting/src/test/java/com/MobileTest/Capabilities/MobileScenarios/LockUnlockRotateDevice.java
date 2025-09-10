package com.MobileTest.Capabilities.MobileScenarios;

import org.testng.annotations.Test;
import org.openqa.selenium.ScreenOrientation;
import com.MobileTest.Capabilities.Utility.DriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class LockUnlockRotateDevice {
  @Test
  public void testDeviceFeatures() throws InterruptedException 
  {
	  //create driver session
	  AppiumDriver driver=DriverSession.initDriverSession();
	  
	  //lock device
	  ((AndroidDriver)driver).lockDevice();
	  
	  Thread.sleep(2000);
	  
	  //unlock device
	  
	  ((AndroidDriver)driver).unlockDevice();
	  
	  //rotate
	  
	  ((AndroidDriver)driver).rotate(ScreenOrientation.LANDSCAPE);
	  Thread.sleep(2000);
	  
	  ((AndroidDriver)driver).rotate(ScreenOrientation.PORTRAIT);
	  
	  
  }
}
