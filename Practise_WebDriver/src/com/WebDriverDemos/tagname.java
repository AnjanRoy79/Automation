package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tagname {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		List<WebElement> links = driver.findElements(By.tagName("a")); //collection used ( List )
		System.out.println(links.size());
		//System.out.println(links.get(0).getText()); --> index wise printing
		for(int i = 0; i < links.size(); i++) // for loop printing
			System.out.println(links.get(i).getText());
		//for (WebElement L : links )//advance for each loop.
		//System.out.println(L.getText());
		driver.findElement(By.linkText("Business")).click();//finding a particular link
		//links.get(4).click();

	}

}
