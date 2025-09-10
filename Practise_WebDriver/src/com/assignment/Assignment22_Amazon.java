package com.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment22_Amazon {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.amazon.in/");
		
		List<WebElement>menus = driver.findElements(By.xpath("//*[@id=\"nav-xshop\"]/ul/li"));
		System.out.println("Total Menus" + menus.size());
		
		int visibleCount = 0;
		for (WebElement m : menus) {
		    if (m.isDisplayed()) {
		        visibleCount++;
		        System.out.println(m.getText());
		    }
		}
		System.out.println("Visible Menus: " + visibleCount);
		    }
		

	}
	

