package com.TestNGDemo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AssertionDemo {
	WebDriver driver;
	
	// Puting the expected result in variable and declaring another for actual 
	String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", actUrl;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() {
		driver.quit(); 
	}

	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] {
			{ "admin", "admin123" },
			{ "anjan", "anjan123" },
			{ "admin", "admin123" },
			{ "sarth", "sarth123" },
		};
	}

	@Test(dataProvider = "getLoginData")
	public void loginToOHRM(String un, String ps) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
				
		// Below code checks if actual and expected url are same using assert.assertEquals function
		
		actUrl = driver.getCurrentUrl(); // fetch the current URL
		Assert.assertEquals(actUrl, expUrl, "Invalid Credentials"); // passing the actual and expected variable with message.
		
		
		//Assert.assertTrue(actUrl.contains("dashboard")); // Another way of writing assertion code
	}

	@AfterMethod
	public void logout() {
		if (driver.getCurrentUrl().contains("dashboard")) {
			driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
			driver.findElement(By.partialLinkText("Log")).click();
			System.out.println("Test case pass");
		} else {
			System.out.println("Invalid user name / password");
		}
	}
}
