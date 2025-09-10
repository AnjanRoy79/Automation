package com.TestNGDemo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPresent {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("Ankush");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/form/button")).click();

		Alert alt;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// alertIsPresent() condition applied
		if (wait.until(ExpectedConditions.alertIsPresent()) == null)
		{
			System.out.println("Alert not exists");
		}
		else
		{
			System.out.println("Alert exists");
			alt = driver.switchTo().alert();
			System.out.println(alt.getText());
			alt.accept();
		}
		
		driver.close();
	}

}

