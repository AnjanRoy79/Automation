package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment16_RedBus {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div/div/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("srcDest")).sendKeys("Kolh");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]"
				+ "/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//div[@class='inputWrapper___017bdb']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("srcDest")).sendKeys("pune");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1"
				+ "]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/div[3]/div[1]/div/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[3]/div[2]/div[1]/ul[1]/li[36]/div[1]/div[1]/span[1]")).click();	
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/button")).click();
		String name = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[4]/div/ul/li[1]/div[1]/div"
				+ "[3]/div/div[1]/div[1]")).getText();
		System.out.println(name);

	}

}
