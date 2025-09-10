package com.TestNGDemo;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginToOHRM_XLS {
	String fPath = "ExcelFiles\\LoginData.xlsx"; // location of the XL file
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	WebDriver driver;
	int index = 1; // this int type (index ) will always start with 1
	
	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File(fPath);
		fis = new FileInputStream(file);  
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0); // if sheet name is not known, pass the index and use getSheetAt method
		fos = new FileOutputStream(file);
		
		// both fis and fos is used as we are reading the data and writing back
		// FOS should always be written after sheet or file gets corrupted
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos); // this is actualy writing the data to excel
		wb.close();
		fis.close();
		driver.close();
	}
	
	@Test(dataProvider = "getLoginData")
	public void loginToOHRM(String un, String ps) throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
	}
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		row = sheet.getRow(index); // reading the data for row
		cell = row.getCell(2); // / reading the data for cell, 2 in this example
		
		// this will be used to input the data below from the test
		
		if(driver.getCurrentUrl().contains("dashboard")) {
			driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
			driver.findElement(By.partialLinkText("Log")).click();
			Thread.sleep(500);
			cell.setCellValue("Login Success"); 
			// writing back to excel if success login with the data using the method setCellValue
		}
		else
		{
			cell.setCellValue(driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText());
			// writing back to excel if invalid details provide getting the actual text from element
		}
		
		index++; // index will always increase by one
	}


	@DataProvider
	public Object[][] getLoginData() {
		
		int rows = sheet.getPhysicalNumberOfRows(); 
		
		String[][]loginData = new String[rows-1][2]; // using two columns in this data file
		//As we are ignoring 0th row as the first row contains header
		
		for(int i = 1; i < rows; i++) // as it is reading from the 1st row and 0 row is ignored
		{
			row = sheet.getRow(i);
			
			for(int j = 0; j < 2; j++)
			{
				cell = row.getCell(j);
				
		loginData[i-1][j] = cell.getStringCellValue(); // stores all the values from the mentioned cells
													// and rows virtually in memory
					// i-1 is here as were are going to store the data in the first row/column 0,0 index
								
			}
		}
		return loginData; //returning the login data as the file executes
	}


}
