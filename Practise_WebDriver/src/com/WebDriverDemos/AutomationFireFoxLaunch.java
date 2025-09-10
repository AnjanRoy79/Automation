package com.WebDriverDemos;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class AutomationFireFoxLaunch {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.123greetings.com");
		
		driver.close();
		

	}

}
