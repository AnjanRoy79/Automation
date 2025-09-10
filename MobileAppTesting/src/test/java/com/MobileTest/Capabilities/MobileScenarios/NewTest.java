package com.MobileTest.Capabilities.MobileScenarios;

import org.testng.annotations.Test;
import java.time.Duration;
import com.MobileTest.Capabilities.Utility.DriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class NewTest {
  @Test
  public void testAppManagement() throws InterruptedException 
  {
	  
	  //create driver session
	  AppiumDriver driver=DriverSession.initDriverSession();
	  
	  //get the package name
	  String appPackage=((AndroidDriver)driver).getCurrentPackage();
	  
	  //Current status of the APP
	  System.out.println("current App status: "+((AndroidDriver)driver).queryAppState(appPackage));
	  
	  //Sending to background and current status

	((AndroidDriver)driver).runAppInBackground(Duration.ofMillis(5000));
	  System.out.println("After Background execution current App status: "+((AndroidDriver)driver).queryAppState(appPackage));
		
	  //Uninstall and current status of the app

	  ((AndroidDriver)driver).removeApp(appPackage);
	  
	  System.out.println("After uninstall current App status: "+((AndroidDriver)driver).queryAppState(appPackage));
}
}
