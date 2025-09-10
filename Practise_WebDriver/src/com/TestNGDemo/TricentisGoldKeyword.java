package com.TestNGDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TricentisGoldKeyword {
	WebDriver driver;
	File file;
	FileInputStream fis;
	Properties prop; 
					
	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File("D:\\Anjan-SeleniumDemos\\Practise_WebDriver\\src\\com\\TestNGDemo\\TricentisGoldKeyword");
		fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
				
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id(prop.getProperty("Auto"))).click();
		}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
  @Test
  public void AutomobileInsurance()throws InterruptedException 
    {
	//Vehicle Data
	  
	  new Select(driver.findElement(By.id(prop.getProperty("makeID")))).selectByVisibleText("BMW");
	  driver.findElement(By.id(prop.getProperty("EngPrf"))).sendKeys("1000");
	  driver.findElement(By.id(prop.getProperty("DOM"))).sendKeys("03/06/2020");
	  new Select(driver.findElement(By.id(prop.getProperty("NOS")))).selectByVisibleText("4");
	  new Select(driver.findElement(By.id(prop.getProperty("Ful")))).selectByVisibleText("Petrol");
	  driver.findElement(By.id(prop.getProperty("LP"))).sendKeys("1000");
	  driver.findElement(By.id(prop.getProperty("Licp"))).sendKeys("wb-02-1979");
	  driver.findElement(By.id(prop.getProperty("AM"))).sendKeys("5000");
	  driver.findElement(By.id(prop.getProperty("ND"))).click();
	  
	//Enter Insurant Data
	  	
	  driver.findElement(By.id(prop.getProperty("FN"))).sendKeys("Anjan");
	  driver.findElement(By.id(prop.getProperty("LN"))).sendKeys("Roy");
	  driver.findElement(By.id(prop.getProperty("DOB"))).sendKeys("05/16/1979");
	  WebElement radiob = driver.findElement(By.xpath(prop.getProperty("Gen")));
		if(radiob.isSelected()==false)
			radiob.click();
	  driver.findElement(By.id(prop.getProperty("StAdr"))).sendKeys("188/ Picnic Garden Road");
	  new Select(driver.findElement(By.id(prop.getProperty("Cou")))).selectByVisibleText("India");
	  driver.findElement(By.id(prop.getProperty("zip"))).sendKeys("700039");
	  driver.findElement(By.id(prop.getProperty("city"))).sendKeys("Kolkata");
	  new Select(driver.findElement(By.id(prop.getProperty("occu")))).selectByVisibleText("Employee");
      WebElement hobbies = driver.findElement(By.xpath(prop.getProperty("hobb")));
		if(hobbies.isSelected()==false)
			hobbies.click();
	  driver.findElement(By.id(prop.getProperty("web"))).sendKeys("https://sampleapp.tricentis.com/101/app.php");
	  driver.findElement(By.id(prop.getProperty("PD"))).click();
	  
	//Enter Product Data
	  
	  driver.findElement(By.id(prop.getProperty("SD"))).sendKeys("08/03/2025");
	  new Select(driver.findElement(By.id(prop.getProperty("Insum")))).selectByVisibleText("5.000.000,00");
	  new Select(driver.findElement(By.id(prop.getProperty("Merit")))).selectByVisibleText("Bonus 5");
	  new Select(driver.findElement(By.id(prop.getProperty("DamIn")))).selectByVisibleText("Full Coverage");
	  WebElement opt = driver.findElement(By.xpath(prop.getProperty("opt")));
		if(opt.isSelected()==false)
			opt.click();
	  new Select(driver.findElement(By.id(prop.getProperty("CC")))).selectByVisibleText("Yes");
	  driver.findElement(By.id(prop.getProperty("PC"))).click();
	  
	//Select Price Option and Checking for expected and actual price with test result
	  
	  String expPrice="720.00", expclaim ="Submit", expClaimDis ="2", expCover = "Limited", actPrice, actClaim, actClaimDis, actCover;
		actPrice = driver.findElement(By.id(prop.getProperty("GP"))).getText();
		actClaim = driver.findElement(By.xpath(prop.getProperty("AC"))).getText();
		actClaimDis = driver.findElement(By.xpath(prop.getProperty("ACD"))).getText();
		actCover = driver.findElement(By.xpath(prop.getProperty("AC1"))).getText();
		if(actPrice.equals(expPrice))
			System.out.println("Price Match : Case Passed");
		else
			System.out.println("Price Not Matching");
		if(actClaim.equals(expclaim))
			System.out.println("Actual Claim Match : Case Passed");
		else
			System.out.println("Actual Claim Not Matching");
		if(actClaimDis.equals(expClaimDis))
			System.out.println("Actual Discount Match :  Case Passed");
		else
			System.out.println("Actual Discount Not Matching");
		if(actCover.equals(expCover))
			System.out.println("Actual Cover Match : Case Passed");
		else
			System.out.println("Actual Cover Not Matching");
		
		driver.findElement(By.xpath(prop.getProperty("PT"))).click();
		driver.findElement(By.id(prop.getProperty("NQ"))).click();
		
		//Send Quote
		
		 driver.findElement(By.id(prop.getProperty("Em"))).sendKeys("anjanroy@gmail.com");
		 driver.findElement(By.id(prop.getProperty("ph"))).sendKeys("9830721932");
		 driver.findElement(By.id(prop.getProperty("UN"))).sendKeys("AnjanR");
		 driver.findElement(By.id(prop.getProperty("Ps"))).sendKeys("Zxcv@786b");
		 driver.findElement(By.id(prop.getProperty("Cps"))).sendKeys("Zxcv@786b");
		 driver.findElement(By.id(prop.getProperty("Co"))).sendKeys("Test Comment");
		 driver.findElement(By.id(prop.getProperty("SEN"))).click();
		
		 String success = driver.findElement(By.xpath(prop.getProperty("Succ"))).getText();
		 System.out.println(success);
		 driver.findElement(By.xpath(prop.getProperty("but"))).click();
		 driver.findElement(By.xpath(prop.getProperty("bk"))).click();
		 
  }
}
