package com.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {
	
	@Test
public void getdata() throws IOException {
		
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
				data[i][j]=(row.getCell(j));
				
				
			}
		}
	}

}
