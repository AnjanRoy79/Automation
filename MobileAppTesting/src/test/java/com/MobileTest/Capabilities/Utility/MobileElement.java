package com.MobileTest.Capabilities.Utility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;

public class MobileElement
{
	
	// For taking Screenshot
	
	public static void getScreenshot(AppiumDriver driver,String filename)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		  
		  File temp=ts.getScreenshotAs(OutputType.FILE);
		  File dest=new File(System.getProperty("user.dir")+"//Screenshots//"+filename+System.currentTimeMillis()+".png");
		  try {
			FileHandler.copy(temp,dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//For scroll as per user choice
	
	public static void scrollAsPerUserChoice(AppiumDriver driver,WebElement pageArea,int count,String direction)
	{
		for(int i=1;i<=count;i++)
		{
		  driver.executeScript("mobile:scrollGesture",ImmutableMap.of(
				  
				  "elementId",((RemoteWebElement)pageArea).getId(),
				  "direction",direction,
				  "percent",1.0
				  
				  ));
		  System.out.println("Iteration counter is: "+i);
		}
	}

	
	//For swipe left only
	
	public static void swipeLeft(AppiumDriver driver,WebElement pageArea,int count)
	{
		for(int i=1;i<=count;i++)
		{
		 driver.executeScript("mobile:swipeGesture",ImmutableMap.of(
				  
				  "elementId",((RemoteWebElement)pageArea).getId(),
				  "direction","left",
				  "percent",1.0
				  ));
		 System.out.println("Iteration count is: "+i);
		}
	}
	
	//For swipe Right only
	
	public static void swipeRight(AppiumDriver driver,WebElement pageArea,int count)
	{
		for(int i=1;i<=count;i++)
		{
		 driver.executeScript("mobile:swipeGesture",ImmutableMap.of(
				  
				  "elementId",((RemoteWebElement)pageArea).getId(),
				  "direction","right",
				  "percent",1.0
				  ));
		 System.out.println("Iteration count is: "+i);
		}
	}
	
	//For swipe as per user choice
	
	public static void swipeAsPerUserChoice(AppiumDriver driver,WebElement pageArea,int count,String direction)
	{
		
			for(int i=1;i<=count;i++)
			{
			 driver.executeScript("mobile:swipeGesture",ImmutableMap.of(
					  
					  "elementId",((RemoteWebElement)pageArea).getId(),
					  "direction",direction,
					  "percent",1.0
					  ));
			 System.out.println("Iteration count is: "+i);
			}
		}
	
}
