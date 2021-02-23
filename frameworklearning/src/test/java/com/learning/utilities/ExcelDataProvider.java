package com.learning.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelDataProvider() {
		
		File src = new File("./TestData/testdata.xlsx");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Issue while loading excel"+e.getMessage());
		}
		
	}
	
	public static String getStringData(String sheetName, int row, int col) {
		sheet = workbook.getSheet(sheetName);
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}
	
	public static double getNumericData(String sheetName, int row, int col) {
		sheet = workbook.getSheet(sheetName);
		return sheet.getRow(row).getCell(col).getNumericCellValue();
	}
	
	public static Object getData(String sheetName, int row, int col) {
		sheet = workbook.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		Object data  = formatter.formatCellValue(sheet.getRow(row).getCell(col)) ;
		return data;
	}
}
