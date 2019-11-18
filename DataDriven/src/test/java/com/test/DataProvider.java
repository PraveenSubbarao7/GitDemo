package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class DataProvider {
	DataFormatter formatter = new DataFormatter();
	
	@Test(dataProvider = "data")
	public void testcasedata(String greeting, String communication,String id) {
		
		System.out.println("The Greeting is   " + greeting + " Communication is  " + communication + " The Id is  " + id);
		
		
	}
	
	
	
	@org.testng.annotations.DataProvider(name="data")
	public Object[][] getdata() throws IOException {
		
//		Object[][] data= {{"hello","test","1"},{"bye","message","143"},{"solo","call","444"}};
//		return data;
		
		FileInputStream fis= new FileInputStream("C:\\Users\\praveen.subbarao\\Desktop\\exceldriven.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowcount=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int colcount=row.getLastCellNum();
		Object data[][]=new Object[rowcount-1][colcount];
		
		for(int i=0;i<rowcount-1;i++) {
			row=sheet.getRow(i+1);
			for (int j=0;j<colcount;j++) {
				
				XSSFCell cell=row.getCell(j);
				
				data[i][j]=formatter.formatCellValue(cell);
				
				
			}
		}
		return data;
	}

}
