package com.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class RediffRegistrationClient {
	WebDriver driver;
	RediffRegistrationUtility r1;
	@Test
	public void testRegistration() throws InterruptedException {
		r1.setFullName("Anjan Roy"); 
		r1.chooseRedifId("anjan123");
		r1.checkAvaiablity();
		r1.setPassword("anjan@123");
		r1.confirmPassword("anjan@123");
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		r1 = new RediffRegistrationUtility(driver); // creating object of rediff registration passing driver as object
		// this driver object will pass the class via constructor created in utility class
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
