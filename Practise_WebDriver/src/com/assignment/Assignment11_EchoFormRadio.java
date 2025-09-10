package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment11_EchoFormRadio {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://echoecho.com/htmlforms10.htm");
	
		WebElement radiob = driver.findElement(By.cssSelector("input[name=\"group1\"]"));
		System.out.println("Before");
		System.out.println("Status before selection = "+ radiob.isSelected() );
		if(radiob.isSelected()==false)
		radiob.click();
		System.out.println("Afer");
		System.out.println("Status after selection = "+ radiob.isSelected() );
		WebElement radiob1 = driver.findElement(By.cssSelector("input[value=\"Butter\"]"));
		System.out.println("Before");
		System.out.println("Status before selection = "+ radiob1.isSelected() );
		if(radiob1.isSelected()==false)
			radiob1.click();
		System.out.println("Afer");
		System.out.println("Status after selection = "+ radiob1.isSelected() );
		WebElement radiob2 = driver.findElement(By.cssSelector("input[value=\"Cheese\"]"));
		System.out.println("Before");
		System.out.println("Status before selection = "+ radiob2.isSelected() );
		if(radiob2.isSelected()==false)
			radiob2.click();
		System.out.println("Afer");
		System.out.println("Status after selection = "+ radiob2.isSelected() );
	}

}
