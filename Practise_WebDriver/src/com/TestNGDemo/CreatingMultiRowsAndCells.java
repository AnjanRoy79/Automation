package com.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class CreatingMultiRowsAndCells {
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	@Test
	public void createFriendsData() {
		sheet.createRow(0).createCell(0).setCellValue("Anjan");
		sheet.getRow(0).createCell(1).setCellValue("Roy");
		sheet.getRow(0).createCell(2).setCellValue("Father");

		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue("Amrapali");
		
		cell = row.createCell(1);
		cell.setCellValue("Roy");
		
		// Another way of writing the above codes in just one line
		
		sheet.createRow(2).createCell(0).setCellValue("Anjali");
		sheet.getRow(2).createCell(1).setCellValue("Roy"); // getRow used to get the current row 
		
		sheet.createRow(3).createCell(0).setCellValue("Agnishwar");
		sheet.getRow(3).createCell(1).setCellValue("Roy");
	}

	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		file = new File("ExcelFiles\\Family.xlsx");
		fos = new FileOutputStream(file);
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("Family Data");
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fos.close();
	}

}
