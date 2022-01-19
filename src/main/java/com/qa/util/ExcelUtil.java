package com.qa.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtil {

	public  Object[][] getData(String sheetName) throws IOException{
		XSSFWorkbook workBook = new XSSFWorkbook(this.getClass().getClassLoader().getResourceAsStream("FreeCrm.xlsx"));
		XSSFSheet sheet = 	workBook.getSheet(sheetName);
		int rowCnt = sheet.getLastRowNum();
		int colCnt = sheet.getRow(0).getLastCellNum();
		
		Object [][] obj = new Object[rowCnt][colCnt];
		for(int i=0;i<rowCnt;i++) {
			for(int j=0;j<colCnt;j++) {
				String data = sheet.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(data);
				obj[i][j] = data;
			}
		}
		return obj;
	}

}