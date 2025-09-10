package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment10_EchoFormCheckBox {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://echoecho.com/htmlforms09.htm");
		WebElement chkbox1 = driver.findElement(By.name("option1"));
		System.out.println("Before");
		System.out.println("Status for check box 1 = "+ chkbox1.isSelected());
		if(chkbox1.isSelected()==false)
			chkbox1.click();
		System.out.println("After");
		System.out.println("Status for check box 1 = "+chkbox1.isSelected());
		WebElement chkbox2 = driver.findElement(By.name("option2"));
		System.out.println("Before");
		System.out.println("Status for check box 2 = "+ chkbox2.isSelected());
		if(chkbox2.isSelected()==true);
		System.out.println("After");
		System.out.println("Status for check box 2 = "+ chkbox2.isSelected());
		WebElement chkbox3 = driver.findElement(By.name("option3"));
		System.out.println("Before");
		System.out.println("Status for check box 3 = "+ chkbox3.isSelected());
		if(chkbox3.isSelected()==false)
			chkbox3.click();
		System.out.println("After");
		System.out.println("Status for check box 3 = "+ chkbox3.isSelected());
	
	}

}
