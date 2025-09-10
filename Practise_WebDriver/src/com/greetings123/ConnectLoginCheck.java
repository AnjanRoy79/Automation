package com.greetings123;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ConnectLoginCheck {
	WebDriver driver;
	Actions act;
	String expUrl = "https://www.123greetings.com/connect/my_page", actUrl;
	
	@BeforeTest
	public void beforeTest() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.123greetings.com/connect/");
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
	
	@AfterMethod
	public void logout()
	{
		if(driver.getCurrentUrl().contains("my_page"))
		{
			act.moveToElement(driver.findElement(By.xpath("//div[@class='pro-photo']//a[normalize-space()='Anjan']"))).perform();
			//driver.findElement(By.xpath("//*[@id=\"fconnectnavblk\"]/div/div/div/a")).click();
			driver.findElement(By.partialLinkText("Log")).click();
			System.out.println("Test case passed");
		}
		else
		{
			System.out.println("Invalid user name / password");
		}
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		return new Object[][] 
							
				{
			new Object[] { "anjanroycal@gmail.com", "12345678" },
			new Object[] { "itltest09@gmail.com", "A123456" },
			new Object[] { "anjanroycal@yahoo.com", "123456789" },
			new Object[] { "anjanroy786@gmail.com", "love12345" },
		};
	}
	
	@Test(dataProvider = "getLoginData") 
	public void loginToConnect(String un, String ps) throws InterruptedException 
	{
		driver.findElement(By.id("login_email")).clear();
		driver.findElement(By.id("login_email")).sendKeys(un);
		driver.findElement(By.id("login_pwd")).sendKeys(ps);
		driver.findElement(By.xpath("//*[@id=\"login_frm\"]/ul/li[5]/button")).click();
		Thread.sleep(1000);
		
		actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, expUrl, "Invalid Credentials");
	}

}