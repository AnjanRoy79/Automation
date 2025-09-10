package com.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class WritingXLWithDataProvider {
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int i = 0;//variable i of integer type declared to automatically handle cells and row according to data
	
	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File("ExcelFiles\\LoginData.xlsx");
		fos = new FileOutputStream(file);
		wb = new XSSFWorkbook();
		//wb = new XSSFWorkbook(fis/fos);
		sheet = wb.createSheet("LoginData");
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fos.close();
	}
	
	@Test(dataProvider = "getLoginData")
	public void createLoginFile(String un, String ps, String rs, String ms) {
		sheet.createRow(i).createCell(0).setCellValue(un);
		sheet.getRow(i).createCell(1).setCellValue(ps);
		sheet.getRow(i).createCell(2).setCellValue(rs);
		sheet.getRow(i).createCell(3).setCellValue(ms);
		
		//row is created once using the variable i and later used that i variable to increase
		// number of cells will determine the numbers of lines of code written, here 4 cells used
		i++; 
	}

	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] {
			new Object[] { "User Name", "Password", "Result", "Test Case"},
			new Object[] { "admin", "admin123","Not Run", "Pass"},
			new Object[] { "anjan", "anjan123","Not Run", "Pass"},
			new Object[] { "amit", "amit123", "Not Run" , "Pass"},
			new Object[] { "admin", "admin123","Not Run", "Pass"},
		};
	}


}
