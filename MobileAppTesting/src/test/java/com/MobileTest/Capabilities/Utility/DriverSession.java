package com.MobileTest.Capabilities.Utility;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverSession
{
	public static AppiumDriver driver;
	
	public static AppiumDriver initDriverSession()
	{
		  //set the capabilities
		
		  UiAutomator2Options options=new UiAutomator2Options();
		  String path=System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
		  options.setCapability("appium:app",path);
		  
		  
		  //set the server address
		  URL url;
		try {
			url = new URI("http://0.0.0.0:4723").toURL();
			
		 //create driver session
			
			 driver=new AndroidDriver(url,options);
			  System.out.println("Session id is: "+driver.getSessionId());
			  
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 return driver; 	  
		 
	}

}