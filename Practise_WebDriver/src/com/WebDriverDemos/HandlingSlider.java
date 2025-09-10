package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingSlider {

	
		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://jqueryui.com/");
			
			Actions act = new Actions(driver);
			
			driver.findElement(By.linkText("Slider")).click();
			driver.switchTo().frame(0); // used as the webelement is in iframe
			WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
			
			//int x = slider.getLocation().x;
			//int y = slider.getLocation().y;
			//act.dragAndDropBy(slider, x+100, y).perform(); //+ 100 is the mark value to move to the point of the slider.
			
			// Below is the simplified code of the above three lines.
			act.dragAndDropBy(slider, slider.getLocation().x + 100, slider.getLocation().y).perform();
			
			// getLocation method is used to set the cordinated of x and y axis
			// act.dragAndDropBy method is used to move slider from place to another
			// this is horizontal slider example
		}

}
