package com.MobileTest.Capabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AppiumDesiredCapabilities {

  @Test
  public void CreateDriverSession() throws MalformedURLException, URISyntaxException 
  {
	  
	  //step1: add required capabilities
	  
	  DesiredCapabilities cap=new DesiredCapabilities();
	  cap.setCapability("platformName","Android");
	  cap.setCapability("appium:automationName","uiautomator2");
	  cap.setCapability("appium:deviceName","pixel_4");
	  cap.setCapability("appium:udid","emulator-5554");
	  //application path(src/test/resources)
	  String path=System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
	  cap.setCapability("appium:app",path);
	  
	  //step2: set server address
	  
	 // URL url=new URL("http://0.0.0.0:4723"); if you see line over URL class follow solution
	  
	  URL url=new URI("http://0.0.0.0:4723").toURL();
	  
	  //step3: create driver session
	  
	  AppiumDriver driver=new AndroidDriver(url,cap);
	  //after session created server send session id to client
	  System.out.println("Session id is: "+driver.getSessionId());
   
  }
}
