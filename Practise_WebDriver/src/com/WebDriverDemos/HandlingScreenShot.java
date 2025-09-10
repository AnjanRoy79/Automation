package com.WebDriverDemos;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.io.FileHandler;

public class HandlingScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.123greetings.com/");
		
		// Below lines of code is the method and function use to take screenshot and store in a file.
		
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(ss, new File("Screenshots\\MyScreenshot.jpeg"));
		FileHandler.copy(ss, new File("C:\\Users\\anjan.ray\\Desktop\\New folder\\ss.jpeg")); // any format supported
		
		System.out.println("Screen shot taken!!!");
		
		driver.close();
	}

}