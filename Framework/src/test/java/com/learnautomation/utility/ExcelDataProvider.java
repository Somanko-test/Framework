package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	public XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File src = new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}
		 catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			System.out.println("Unable to read excel file");
		}
	}
	
	public String getStringData(String sheetName, int row, int cell) {
		
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}
	
	//method overloading
    public String getStringData(int sheetIndex, int row, int cell) {
		
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();
	}
	
    public double getNumericData(String sheetName, int row, int cell) {
		
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
	}

}
