package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class radiobutton {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		WebElement radiob = driver.findElement(By.cssSelector("input[value=\"f\"]"));
		//radiob.isSelected(); //if not selected it will select the inspected radio button
		System.out.println("Before");
		System.out.println("Selected" + radiob.isSelected());
		if(radiob.isSelected()==false) // checks if the radio button inspected is selected or not and returns boolean value.
		radiob.click(); // acts according to the value.
		System.out.println("After");
		System.out.println("Selected"+radiob.isSelected()); 
		
	}

}
