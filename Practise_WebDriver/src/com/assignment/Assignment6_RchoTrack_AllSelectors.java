package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6_RchoTrack_AllSelectors {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		WebElement username = driver.findElement(By.cssSelector("input[placeholder=\"Username\"]"));
		username.sendKeys("deepak");
		WebElement password = driver.findElement(By.cssSelector("input[placeholder=\"Password\"][type=\"password\"]"));
		password.sendKeys("deepak123");
		WebElement login = driver.findElement(By.cssSelector("input[title^=\"Log\"] "));
		login.click();
		WebElement errmssg = driver.findElement(By.cssSelector("span[class=\"error\"]"));
		String msg = errmssg.getText();
		System.out.println(msg);
		if(msg.contains("Invalid"))
		System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		driver.findElement(By.linkText("Forgot your password?")).click();
		//link.click();
	

	}

}
