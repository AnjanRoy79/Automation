package com.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment19_omoyoBlog {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://omayo.blogspot.com/");
		WebElement chkbox = driver.findElement(By.xpath("//*[@id=\"dte\"]"));
		System.out.println("Status for Mr Option check box is  = "+ chkbox.isEnabled());
		if(chkbox.isEnabled()==false)
			System.out.println("check box Deselected and Disabled");
		
		chkbox.findElement(By.xpath("//*[@id=\"HTML47\"]/div[1]/button")).click();
			
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dte\"]"))).click();
	if(chkbox.isEnabled()==true)
		System.out.println("Status for Mr Option check box is  = " + chkbox.isEnabled());
		System.out.println("check box Selected and Enabled");
	
	
				
		

	}

}
