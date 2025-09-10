package com.assignment;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4_Facebook {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement emailaddress = driver.findElement(By.className("inputtext"));
		emailaddress.sendKeys("anjanroycal@gmail.com");
		WebElement password = driver.findElement(By.className("inputtext"));
		password.sendKeys("123456789");
		WebElement login = driver.findElement(By.className("_42ft"));
		login.click();

	}

}

