package com.WebDriverDemos;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/alerts");
		
		JavascriptExecutor js = (JavascriptExecutor) driver; // is JavascriptExecutor which is an interface in Java. Type casting used.
		js.executeScript("window.scrollBy(0,700)", "");
		
		Alert alt; // creating an alt reference variable using Alert interface to handle any alert.
		
		WebElement btn1 = driver.findElement(By.id("alertButton"));
		js.executeScript("arguments[0].click()", btn1); // -- js.executeScript("arguments[0] this is predefined statement of js executor. 
		//js.executeScript("arguments[0].click()", driver.findElement(By.id("alertButton")));  --> alternate code
		// arguments[0] here is btn1
		
		/// THere is no relationship between alert and JS executor, here used only to handle page scroll.
		
		alt = driver.switchTo().alert();	// switchTo().alert() is used to Jump to alert
		System.out.println(alt.getText()); // optional ( to display the alert using .getText method of alert interface
		alt.accept();		//Accept any click button using .accept method of alert interface
		
		
		
		js.executeScript("arguments[0].click()", driver.findElement(By.id("timerAlertButton"))); 
		// Above code the usage of js executor to avoid the interception
		Thread.sleep(5000); // used to wait as the code required for this website
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		
		js.executeScript("window.scrollBy(0, 300)", "");
		
		driver.findElement(By.id("confirmButton")).click();
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		//alt.dismiss();		//Dismiss any cancel button using .dismiss method of alert interface
		alt.accept();
		System.out.println(driver.findElement(By.id("confirmResult")).getText());
		
		driver.findElement(By.id("promtButton")).click();
		alt = driver.switchTo().alert();
		alt.sendKeys("Anjan"); //Send any test button using .sendKeys method of alert interface
		alt.accept();
		System.out.println(driver.findElement(By.id("promptResult")).getText());
		
		Thread.sleep(5000);
		//driver.close();
	}

}