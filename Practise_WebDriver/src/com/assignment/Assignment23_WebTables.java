package com.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment23_WebTables {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/webtables");
		int i;
		
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)", "");
		
		// Display all header columns
		
		List<WebElement>menus = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[1]/div"));
		System.out.println("Total menus: " + menus.size());
		
		for(WebElement m : menus)
			System.out.println(m.getText());
		
		// click on add button, filling details and clicking in submit
		
		driver.findElement(By.id("addNewRecordButton")).click();
		driver.findElement(By.id("firstName")).sendKeys("Anjan");
		driver.findElement(By.id("lastName")).sendKeys("Roy");
		driver.findElement(By.id("userEmail")).sendKeys("anjan@gmail.com");
		driver.findElement(By.id("age")).sendKeys("46");
		driver.findElement(By.id("salary")).sendKeys("100000");
		driver.findElement(By.id("department")).sendKeys("QA");
		driver.findElement(By.id("submit")).click();
		
		Thread.sleep(2000);
		
		//Search for the added user name in the first row and deleting the same.
		List<WebElement>firstName = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div/div/div[1]"));
		
		for(i = 0; i < firstName.size(); i++)
		{
			if(firstName.get(i).getText().equals("Anjan"))
				break;
		}
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div["+ (i+1) + "]/div/div[7]/div/span[2]")).click();
		
		Thread.sleep(5000);
		//driver.close();
		
	}
}

