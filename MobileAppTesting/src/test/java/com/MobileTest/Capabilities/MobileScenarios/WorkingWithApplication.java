package com.MobileTest.Capabilities.MobileScenarios;

import org.testng.annotations.Test;
import java.time.Duration;
import com.MobileTest.Capabilities.Utility.DriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class WorkingWithApplication {
  @Test
  public void testAppManagement() throws InterruptedException 
  {
	  
	  //create driver session
	  AppiumDriver driver=DriverSession.initDriverSession();
	  
	  //get the package name
	  String appPackage=((AndroidDriver)driver).getCurrentPackage();
	  
	  //current status
	  System.out.println("current App status: "+((AndroidDriver)driver).queryAppState(appPackage));
	  
	  //terminate app
	  ((AndroidDriver)driver).terminateApp(appPackage);
	  
	  System.out.println("After terminate current App status: "+((AndroidDriver)driver).queryAppState(appPackage));

	  Thread.sleep(2000);
//activate app
	  
	  ((AndroidDriver)driver).activateApp(appPackage);
	  
	  System.out.println("After activate current App status: "+((AndroidDriver)driver).queryAppState(appPackage));

	  //uninstall app-removeApp
	  
	  ((AndroidDriver)driver).removeApp(appPackage);
	  
	  System.out.println("After uninstall current App status: "+((AndroidDriver)driver).queryAppState(appPackage));

	  Thread.sleep(2000);
	  //install
	  String path=System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";

	  ((AndroidDriver)driver).installApp(path);
	  
	  System.out.println("After install current App status: "+((AndroidDriver)driver).queryAppState(appPackage));

	  Thread.sleep(2000);
	  	//activate app
	  
	  ((AndroidDriver)driver).activateApp(appPackage);
	  System.out.println("After activate current App status: "+((AndroidDriver)driver).queryAppState(appPackage));

	  
	  //background
	  ((AndroidDriver)driver).runAppInBackground(Duration.ofMillis(4000));
	  System.out.println("After Background execution current App status: "+((AndroidDriver)driver).queryAppState(appPackage));
	  
  }
}
