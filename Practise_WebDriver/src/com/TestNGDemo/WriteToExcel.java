package com.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class WriteToExcel {
	File file; // for file object
	FileOutputStream fos; // either output stream or input or both object
	XSSFWorkbook wb; // workbook object
	//XSSF - XML Spreadsheet Format - .xlsx files
	//HSSF - Horrible spreadsheet format - .xls files
	XSSFSheet sheet; // sheet object
	XSSFRow row; // row object
	XSSFCell cell; // cell object
	
	// Above lines are sequence which should be follow. Sequence Mandatory for configuring
	
	
	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File("MyFirstExcelFile.xlsx");  // file name of the file to be created can be kept in any folder.
		fos = new FileOutputStream(file);
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("My Sheet"); // sheet name with createsheet method
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos); //Write the data physically to the file using method write
		wb.close();
		fos.close();
	}
	
	@Test
	public void createrow() {
		row = sheet.createRow(0);		//Create 1st row
		cell = row.createCell(0);		//Create 1st cell inside 1st row
		cell.setCellValue("Anjan"); // sets value to the cell
	}

}