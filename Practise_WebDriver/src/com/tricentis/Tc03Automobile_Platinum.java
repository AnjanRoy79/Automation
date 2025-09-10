package com.tricentis;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tc03Automobile_Platinum {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://sampleapp.tricentis.com/101/index.php");
		driver.findElement(By.id("nav_automobile")).click();
		
		//Enter Vehicle Data
		
		new Select(driver.findElement(By.id("make"))).selectByVisibleText("BMW");
		driver.findElement(By.id("engineperformance")).sendKeys("1000");
		driver.findElement(By.id("dateofmanufacture")).sendKeys("03/06/2020");
		new Select(driver.findElement(By.id("numberofseats"))).selectByVisibleText("4");
		new Select(driver.findElement(By.id("fuel"))).selectByVisibleText("Petrol");
		driver.findElement(By.id("listprice")).sendKeys("1000");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("wb-02-1979");
		driver.findElement(By.id("annualmileage")).sendKeys("5000");
		driver.findElement(By.id("nextenterinsurantdata")).click();
		
		//Enter Insurant Data
		
		driver.findElement(By.id("firstname")).sendKeys("Anjan");
		driver.findElement(By.id("lastname")).sendKeys("Roy");
		driver.findElement(By.id("birthdate")).sendKeys("05/16/1979");
		WebElement radiob = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[1]/span"));
		if(radiob.isSelected()==false)
			radiob.click();
		driver.findElement(By.id("streetaddress")).sendKeys("188/ Picnic Garden Road");
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");
		driver.findElement(By.id("zipcode")).sendKeys("700039");
		driver.findElement(By.id("city")).sendKeys("Kolkata");
		new Select(driver.findElement(By.id("occupation"))).selectByVisibleText("Employee");
		WebElement hobbies = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[5]/span"));
		if(hobbies.isSelected()==false)
			hobbies.click();
		driver.findElement(By.id("website")).sendKeys("https://sampleapp.tricentis.com/101/app.php");
		driver.findElement(By.id("nextenterproductdata")).click();
		
		//Enter Product Data
		
		driver.findElement(By.id("startdate")).sendKeys("08/03/2025");
		new Select(driver.findElement(By.id("insurancesum"))).selectByVisibleText("5.000.000,00");
		new Select(driver.findElement(By.id("meritrating"))).selectByVisibleText("Bonus 5");
		new Select(driver.findElement(By.id("damageinsurance"))).selectByVisibleText("Full Coverage");	
		WebElement opt = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[1]/span"));
		if(opt.isSelected()==false)
			opt.click();
		new Select(driver.findElement(By.id("courtesycar"))).selectByVisibleText("Yes");
		driver.findElement(By.id("nextselectpriceoption")).click();
		
		//Select Price Option and Checking for expected and actual price with test result
		
		String expPrice="1,413.00", expclaim ="Submit", expClaimDis ="5", expCover = "Limited", actPrice, actClaim, actClaimDis, actCover;
		actPrice = driver.findElement(By.id("selectplatinum_price")).getText();
		actClaim = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[4]")).getText();
		actClaimDis = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[4]")).getText();
		actCover = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[4]")).getText();
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
		
		driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[3]/span")).click();
		driver.findElement(By.id("nextsendquote")).click();
		
		//Send Quote
		
		driver.findElement(By.id("email")).sendKeys("anjanroy@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("9830721932");
		driver.findElement(By.id("username")).sendKeys("AnjanR");
		driver.findElement(By.id("password")).sendKeys("Zxcv@786b");
		driver.findElement(By.id("confirmpassword")).sendKeys("Zxcv@786b");
		driver.findElement(By.id("Comments")).sendKeys("Test Comment");
		driver.findElement(By.id("sendemail")).click();
		String success = driver.findElement(By.xpath("/html/body/div[4]/h2")).getText();
		System.out.println(success);
		driver.findElement(By.xpath("/html/body/div[4]/div[7]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"backmain\"]/span/i")).click();
		driver.close();
	}
	

}