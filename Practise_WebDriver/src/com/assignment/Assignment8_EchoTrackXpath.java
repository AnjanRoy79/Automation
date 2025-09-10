package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8_EchoTrackXpath {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]"
				+ "/div/div/div/form/fieldset/div[2]/fieldset/input[1]")).sendKeys("anjan");
		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div/div/div/form"
				+ "/fieldset/div[3]/div[1]/input")).click();
		

	}

}
