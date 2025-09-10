package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemo {

	public static void main(String[] args) {
		
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://bstackdemo.com/signin");
		  
		  //select username
		 // driver.findElement(By.id("username")).click();
		  driver.findElement(By.xpath("(//*[name()='svg'])[2]")).click();
		  //select demouser
		  driver.findElement(By.xpath("//div[text()='demouser']")).click();
		  
		  
		  
		  //select password
		  driver.findElement(By.xpath("(//*[name()='svg'])[3]")).click();
		  driver.findElement(By.xpath("//div[text()='testingisfun99']")).click();

	

	}

}
