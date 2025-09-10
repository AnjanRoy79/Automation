package com.assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment24_HandlingAlerts {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://omayo.blogspot.com/");
		Alert alt;
		driver.findElement(By.id("alert1")).click();
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		
		driver.findElement(By.id("prompt")).click();
		alt = driver.switchTo().alert();
		alt.sendKeys("Anjan");
		alt.accept();
		
		driver.findElement(By.id("confirm")).click();
		alt = driver.switchTo().alert();
		alt.dismiss();
		
		
		
		
		
		
		
		

	}

}
