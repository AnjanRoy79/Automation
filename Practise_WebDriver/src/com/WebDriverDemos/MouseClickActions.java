package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseClickActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		Actions act = new Actions(driver); // Action class used to perform mouse action
		
		// Below code click on the button using right click function using [act.contextClick(rightClickBtn)] method
		
		WebElement rightClickBtn = driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
		act.contextClick(rightClickBtn).perform();
		
		//List all the elements in the box clicks on specified box and prints them on console and handling alert
		
		List<WebElement>menus = driver.findElements(By.xpath("//*[@id=\"authentication\"]/ul/li/span"));
		for(WebElement m : menus)
		System.out.println(m.getText());
		driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[3]/span")).click();
		System.out.println(driver.switchTo().alert().getText()); // to handle alert on the page
		driver.switchTo().alert().accept();
		
	// // Below code click on the button using double click function using [act.doubleClick(dblClickBtn)] method
	//	driver.findElement(By.id("authentication")).click();
	WebElement dblClickBtn = driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
	act.doubleClick(dblClickBtn).perform();
		
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().accept();
		
		//driver.close();
	}

}