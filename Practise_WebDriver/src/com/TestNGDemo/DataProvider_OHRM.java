package com.TestNGDemo;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DataProvider_OHRM {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() 
	{
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
	
	@AfterMethod
	public void logout() // checking if the login happened using the get current URL.contains method
	{
		if(driver.getCurrentUrl().contains("dashboard"))
		{
			driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
			driver.findElement(By.partialLinkText("Log")).click();
			System.out.println("Test case passed");
		}
		else
		{
			System.out.println("Invalid user name / password");
		}
	}
	
	@DataProvider
	public Object[][] getLoginData() // data provider is stored in 2 dimensional array. Data type can be anything
	{
		return new Object[][] // it returns a new object which will pass the data to below method 1 row at a time.
							 // any number of new object can be created
				{
			new Object[] { "admin", "admin123" },
			new Object[] { "anjan", "anjan123" },
			new Object[] { "admin", "admin123" },
			new Object[] { "sarth", "sarth123" },
		};
	}
	
	@Test(dataProvider = "getLoginData") // the below method holds value of the array in two variable which is passed 
										// from the above array and performs the method defined below.
	public void loginToOHRM(String un, String ps) 
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);// passing the variable as data
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}