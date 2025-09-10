package com.TestNGDemo;


import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinkAutomation 
{
	/*1.link should have href attribute and it should not be empty or null

	2.send only for valid href request to the server

	3.get the status code and compare is status code is equal and greter than 400

	4.update status as link is broken
	 * 
	 */
  @Test
  public void testBrokenLink() 

  {
	  //create driver session
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  
	  //total links
	  List<WebElement> allLinks=driver.findElements(By.tagName("a"));
	  System.out.println("Total links are: "+allLinks.size());
	  
	  int brokenLinkCount=0;
	  int validLinkCount=0;
	  for(WebElement link:allLinks)
	  {
		  //1.link should have href attribute and it should not be empty or null
		  String hrefValue=link.getDomAttribute("href");
		  System.out.println();
		  
		  if(hrefValue==null || hrefValue.isEmpty())
		  {
			  System.out.println("Empty or Null link we cant automate");
			  System.out.println(hrefValue);
			  continue;//skip
			  			  
		  }
		  
		  //remaining links are valid  & pass to server
		  try {
		  //Send the request to server: URL class from java
		  //URL url=new URI(hrefValue).toURL();
		  
		  URL url=new URI(hrefValue).toURL();
		  
		  //To establish connection to server open server connection
		  HttpURLConnection httpurl=(HttpURLConnection)url.openConnection();
		  
		  //URLConnection httpurl=url.openConnection();
		  //connect to the server
		  httpurl.connect();
		  
		  int statusCode=httpurl.getResponseCode();
		  
		  if(statusCode>=400)
		  {
			  brokenLinkCount++;
			  System.out.println("===========Broken Link=================");
			 
		  }else
		  {
			  validLinkCount++;
			  System.out.println("================Valid Link================");
		  }
		  }catch(Exception e)
		  {
			  
		  }
		  
		  
		  
	  }
	  
	  System.out.println("Total valid links are: "+validLinkCount);
	  System.out.println("Total Broken Links are: "+brokenLinkCount);
	 	  
	  
  }
}

