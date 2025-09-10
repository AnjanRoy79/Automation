package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationChromeLaunch {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		WebElement username = driver.findElement(By.name("txtCustomerID"));
		username.sendKeys("Deepak");
		WebElement password = driver.findElement(By.name("txtPassword"));
		password.sendKeys("deepek123");
		WebElement login = driver.findElement(By.name("Butsub"));
		login.click();
		
	
	}

}
