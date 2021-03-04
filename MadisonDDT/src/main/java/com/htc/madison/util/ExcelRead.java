package com.htc.madison.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	Workbook madisonWorkBook;
	Sheet loginData;
	
	public ExcelRead(String excelfilePath) {
		try {
		File s = new File(excelfilePath);
		FileInputStream fis = new FileInputStream(s);
		madisonWorkBook = new XSSFWorkbook(fis);
		System.out.println("excelFilepath"+excelfilePath);
		System.out.println("madison workbook sheets are "+madisonWorkBook.getNumberOfSheets());
		}
		catch(Exception e) {
		System.out.println(e.getMessage());
		}
		}

	      public Object[][] getRecords(String sheetName)
		{
			loginData =madisonWorkBook.getSheet(sheetName);
			System.out.println(loginData.toString());
			//if sheet as heading start row =1 for the data 
			//row 0 consist of heading
			int totalNoofRows=loginData.getLastRowNum();
			Object[][] records=new Object[totalNoofRows][loginData.getRow(1).getLastCellNum()];
			for(int row=0;row<loginData.getLastRowNum();row++)
			{
			   System.out.println("testing no of rows" +loginData.getLastRowNum());
				for(int col=0;col<loginData.getRow(row+1).getLastCellNum();col++)
				{
					records[row][col]=loginData.getRow(row+1).getCell(col).getStringCellValue();
				}
			}
			return records;
		}
}
