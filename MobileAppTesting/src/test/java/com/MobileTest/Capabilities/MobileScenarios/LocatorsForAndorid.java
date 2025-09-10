package com.MobileTest.Capabilities.MobileScenarios;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.MobileTest.Capabilities.Utility.DriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LocatorsForAndorid {

  @Test
  public void testMobileElements() throws InterruptedException 
  {
	  //create driver session by calling the utility class with it's object
	  
	 AppiumDriver driver= DriverSession.initDriverSession();
	 
	 //Locator1: AccessibilityId(primary)
	 
	 WebElement ele1=driver.findElement(AppiumBy.accessibilityId("Access'ibility"));
	  System.out.println("Text of Element1 is: "+ele1.getText());
	  ele1.click();
	  
	  //static wait
	  Thread.sleep(1500);
	  driver.navigate().back();
	  
	  //Locator2: xpath
	  
	  WebElement ele2=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Animation\"]"));
	  System.out.println("Text of Element2 is: "+ele2.getText());
	  ele2.click();
	  
	  
	  //static wait
	  Thread.sleep(1500);
	  driver.navigate().back();
	  
	  
	  //Locator3: android uiautomator
	  
	  WebElement ele3=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"App\")"));
	  System.out.println("Text of Element3 is: "+ele3.getText());
	  ele3.click();
	  
	  //static wait
	  Thread.sleep(1500);
	  driver.navigate().back();
	  
	  //Locator4:ClassName
	  
	  WebElement ele4=driver.findElements(AppiumBy.className("android.widget.TextView")).get(5);
	  System.out.println("Text of Element4 is: "+ele4.getText());
	  ele4.click();
	  
	  //static wait
	  Thread.sleep(1500);
	  driver.navigate().back();
	  
	  //Locator5:Resource-id or id
	  
	  //WebElement ele5=driver.findElements(AppiumBy.id("android:id/text1")).get(11);
	 //System.out.println("Text of Element5 is: "+ele5.getText());
	  //ele5.click();
	  
	 driver.findElements(AppiumBy.id("android:id/text1")).get(11).click(); 
	  
	  //static wait
	  Thread.sleep(1500);
	  driver.navigate().back();
	  
  }
}
