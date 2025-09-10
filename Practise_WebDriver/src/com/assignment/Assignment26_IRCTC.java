package com.assignment;

import java.time.Duration;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment26_IRCTC {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications"); // disables the notification
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/nget/profile/user-registration");
		//Alert alt;
		
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)", "");
       Thread.sleep(1000);
     //  alt = driver.switchTo().alert();
     //  alt.accept();
       driver.findElement(By.id("userName")).sendKeys("Anjan123");
       driver.findElement(By.id("fullName")).sendKeys("Anjan Roy");
       driver.findElement(By.id("usrPwd")).sendKeys("ZXcv@786b#1");
       driver.findElement(By.id("cnfUsrPwd")).sendKeys("ZXcv@786b#1");
       driver.findElement(By.id("email")).sendKeys("anjantest@gmail.com");
       driver.findElement(By.id("mobile")).sendKeys("9830721933");
       Thread.sleep(10000);
       driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-user-signup/div/div/form/div/div[2]/div/div[2]/div[12]/div/button")).click();

	}

}
