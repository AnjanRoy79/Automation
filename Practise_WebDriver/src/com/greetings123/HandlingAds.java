package com.greetings123;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HandlingAds {

	public static void main(String[] args)
	{
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\anjan.ray\\Desktop\\AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx")); // Replace with actual path
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://www.123greetings.com");

	}

}
