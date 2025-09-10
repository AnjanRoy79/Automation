package com.TestNGDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadFromExcel {
	String fPath = "ExcelFiles\\LoginData.xlsx"; // path where the excel is kept with excel
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File(fPath); // the declared string variable is passed
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		//As we are just reading the data from already present workbook, you need to pass the fis object
		sheet = wb.getSheet("LoginData");
		// read from the sheet using getSheet method and the (sheet name)
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.close();
		fis.close();
	}
	
	@Test(enabled = false)
	public void readFewData() {
		row = sheet.getRow(0);
		cell = row.getCell(0);
		System.out.println(cell.getStringCellValue());// getStringCellValue method reads the cell value
		System.out.println(sheet.getRow(0).getCell(1).getStringCellValue());
		System.out.println(sheet.getRow(0).getCell(2).getStringCellValue());
	}
	
	// above code is used by hard coding every line where below is done using nested for loop
	
	@Test
	public void readAllData()
	{
		int rows = sheet.getPhysicalNumberOfRows();
		// method getPhysicalNumberOfRows counts the numbers of rows from the sheet
		int cells = sheet.getRow(0).getPhysicalNumberOfCells(); //not required
		// method getPhysicalNumberOfCells counts the numbers of cells from the sheet
		
		for(int i = 0; i < rows; i++)		//for rows out loop
		{
			row = sheet.getRow(i);
			
			for(int j = 0; j < cells; j++)	//for cells inner loop
			{
				cell = row.getCell(j);
				
				System.out.println(cell.getStringCellValue());
			}
		}
	}



}
