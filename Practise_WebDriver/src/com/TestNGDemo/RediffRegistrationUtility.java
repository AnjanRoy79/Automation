package com.TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RediffRegistrationUtility {
	WebDriver driver;
	
	//@FindBy (xpath = "//input[@placeholder='Enter your full name']") WebElement fullName;
	// find by annotation is used in page factory declaring in a variable for that element
	//@FindBy (css = "input[name^=\"login\"]") WebElement rediffId;
	
	public RediffRegistrationUtility(WebDriver d) // A constructor is created passing the webdrive object with variable d
	// the object driver from the client class will be passed to this constructor and stored in variable
	{
		driver = d;  // the above driver object is holding the address of client driver
		//PageFactory.initElements(driver, this); // page factory is subset of POM
		// the statement above 
	}
	
	public void setFullName(String fn)
	{
		driver.findElement(By.xpath("//input[@placeholder='Enter your full name']")).sendKeys(fn);
		//fullName.sendKeys(fn); // this page factory declared variable is used here to pass the value
	}
	public void chooseRedifId(String rid)
	{
		driver.findElement(By.xpath("//*[@placeholder=\"Enter Rediffmail ID\"]")).sendKeys(rid);
		//rediffId.sendKeys("anjanroy"); // directly passing the value without using the variable
	}
	public void checkAvaiablity() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@value=\"Check availability\"]")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"check_availability\"]/div/span")).getText());
	}
	public void setPassword(String ps)
	{
		driver.findElement(By.xpath("//input[@id='newpasswd']")).sendKeys(ps);
	}
	public void confirmPassword(String ps)
	{
		driver.findElement(By.xpath("//input[@id='newpasswd1']")).sendKeys(ps);
	}
}
