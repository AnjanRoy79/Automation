package com.WebDriverDemos;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Handling_DragAndDrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/");
		
		Actions act = new Actions(driver);  // as mouse action drag and drop is used action interface will be used,

		driver.findElement(By.linkText("Droppable")).click();
		
		//driver.switchTo().frame(0); // As frame is used here we need to switch to that frame.
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
		
		//below is the simplified code same as the above two lines
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		// Two web element created one for source and another for destination of the drop.
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		act.dragAndDrop(source, target).perform(); // both the source referance value used by act.dragAndDrop method to perform the action
	}

}
