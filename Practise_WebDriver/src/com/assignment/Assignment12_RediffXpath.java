package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment12_RediffXpath {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/input")).sendKeys("Anjan Roy");
		driver.findElement(By.xpath("//*[contains(@id, 'login')]")).sendKeys("anjanroy786");
		driver.findElement(By.xpath("//*[@id=\"newpasswd\"]")).sendKeys("anjanroy786");
		driver.findElement(By.xpath("//*[@id=\"newpasswd1\"]")).sendKeys("anjanroy786");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[15]/div/input")).click();

	}

}
