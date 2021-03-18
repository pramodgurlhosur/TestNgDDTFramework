package com.htc.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	Workbook madisonWorkbook;
	Sheet loginData;

	public ExcelReader(String excelfilePath) {
		try {
			File file = new File(excelfilePath);
			FileInputStream stream = new FileInputStream(file);
			madisonWorkbook = new XSSFWorkbook(stream);
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
	}

	public Object[][] getDataUsingMap(String sheetName) 
	{
    	loginData = madisonWorkbook.getSheet(sheetName);
		int rowCount = loginData.getLastRowNum();
		int columnCount = loginData.getRow(0).getLastCellNum();

		Object[][] object = new Object[rowCount][1];

		for (int row = 0; row < rowCount; row++) {
			Map<Object, Object> dataMap = new HashMap<Object, Object>();
			for (int col = 0; col < columnCount; col++) {
				dataMap.put(loginData.getRow(0).getCell(col).toString(),loginData.getRow(row + 1).getCell(col).toString());
        }
			object[row][0] = dataMap;
		}
         return object;
     }
}
