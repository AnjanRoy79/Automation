package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuSelectionWithActionClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://istqb.in/");
		
		Actions act = new Actions(driver);
		//Actions class is used to handle any mouse actions
		
		// Getting all menus and printing then in console
		
		List<WebElement> menus = driver.findElements(By.xpath("//*[@id=\"sp-menu\"]/div/nav/ul/li"));
		System.out.println("Total Number of menus :" + menus.size());
		for(WebElement m : menus)
			System.out.println(m.getText());
		
		// Selecting sub menus of a particular menu using action class and it's method
		
		WebElement spMenu = driver.findElement(By.linkText("SPECIALIST"));
		//WebElement spMenu = driver.findElement(By.linkText("AGILE"));
		
		act.moveToElement(spMenu).perform(); // act.moveToElement is a method of action class and .perform required to perform the action.
		
		// Putting into list to print the same on console
		
		List<WebElement>subMenus = driver.findElements(By.xpath("//*[@id=\"sp-menu\"]/div/nav/ul/li[6]/div/div/ul/li/a"));
		//List<WebElement>subMenus = driver.findElements(By.xpath("//*[@id=\"sp-menu\"]/div/nav/ul/li[5]")); //Agile
		System.out.println("\nTotal Sub Menus :" + subMenus.size());
		System.out.println("\nSub menus are");
		for(WebElement sm : subMenus)
			System.out.println(sm.getText());
		
		Thread.sleep(1000);
		//driver.close();
	}

}
