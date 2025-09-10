package com.MobileTest.Capabilities.MobileScenarios;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppPackageActivityLaunch {
  @Test
  public void launchClockApp() throws MalformedURLException, URISyntaxException
  {
	  
	  //set the capability
	  UiAutomator2Options options=new UiAutomator2Options();
	  options.setCapability("appium:appPackage","com.google.android.deskclock");
	  options.setCapability("appium:appActivity","com.android.deskclock.DeskClock");
	  
	  //server address
	  URL url=new URI("http://0.0.0.0:4723").toURL();
	  
	  //create driver session
	  AppiumDriver driver=new AndroidDriver(url,options);
	  System.out.println("Session id is: "+driver.getSessionId());
  
  }
}