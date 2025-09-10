package com.MobileTest.Capabilities.MobileScenarios;

import org.testng.annotations.Test;
import java.util.List;
import com.MobileTest.Capabilities.Utility.DriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class GetPerformanceParameters {
  @Test
  public void testPerformanceAnalysis()
  {
	  
	  //create driver session
	  
	  AppiumDriver driver=DriverSession.initDriverSession();
	  
	  //get the performance data type
	 List<String> datatypes=((AndroidDriver)driver).getSupportedPerformanceDataTypes();
	 System.out.println(datatypes);
	  //[cpuinfo, memoryinfo, batteryinfo, networkinfo]
	 
	 //get the current application package name
	 String appPackage=((AndroidDriver)driver).getCurrentPackage();
	 
	 
	  List<List<Object>> batterydata=((AndroidDriver)driver).getPerformanceData(appPackage,"batteryinfo",5);
	  System.out.println(batterydata);
	  
	 
	  List<List<Object>> memorydata=((AndroidDriver)driver).getPerformanceData(appPackage,"memoryinfo",5);
	  System.out.println(memorydata);

	  List<List<Object>> networkdata=((AndroidDriver)driver).getPerformanceData(appPackage,"networkinfo",5);
	  System.out.println(networkdata);
  }
}
