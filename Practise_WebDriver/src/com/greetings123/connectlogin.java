package com.greetings123;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class connectlogin {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver ();
		WebDriver driver1 = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver1.manage().window().maximize();
		
		driver.get("https://123greetings.com/connect");
		driver1.get("https://123greetings.com/connect");
		
		driver.findElement(By.name("email")).sendKeys("anjanroycal@gmail.com");
		driver1.findElement(By.name("email")).sendKeys("anjanroycal@gmail.com");
		
		driver.findElement(By.name("password")).sendKeys("123456789",Keys.ENTER);
		driver1.findElement(By.name("password")).sendKeys("123456789",Keys.ENTER);
		
		

	}

}
