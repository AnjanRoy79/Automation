	package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrangeHrm {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	      /// use of WebDriverWait class to create a object which will wait for the web element to load for mentioned duration
	      ///wait.until will handle the ExpectionConditions exception until the visibilityOfElementLocated 
	      ///method find the WebElement by locator.
		// input name and password then click login
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		// find logout button
		//driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
		//driver.findElement(By.linkText("Logout")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[contains(@class,'bi-caret-down-fill')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout"))).click();
        
        driver.close();

	}

}
