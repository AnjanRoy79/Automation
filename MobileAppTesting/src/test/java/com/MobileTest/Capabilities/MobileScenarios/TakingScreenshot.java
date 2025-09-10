package com.MobileTest.Capabilities.MobileScenarios;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import com.MobileTest.Capabilities.Utility.DriverSession;
import io.appium.java_client.AppiumDriver;

public class TakingScreenshot {
  @Test
  public void testScreenshot() throws IOException
  {
	  
	  //create appium driver session
	  AppiumDriver driver=DriverSession.initDriverSession();	
	  
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  
	  File temp=ts.getScreenshotAs(OutputType.FILE);
	  File dest=new File(System.getProperty("user.dir")+"//Screenshots//APIDemos"+System.currentTimeMillis()+".png");
	  FileHandler.copy(temp,dest);
  
  }
}
