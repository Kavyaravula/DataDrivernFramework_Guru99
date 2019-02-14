package com.qa.guru99.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.qa.guru99.TestBase.TestBase;

public class TestUtility extends TestBase {

	public String getScreenshot(String screenshotName) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String userDir = System.getProperty("user.dir");
		Date dt = new Date();
		String dateTime = new SimpleDateFormat("ddMMMYYYYHHmmss").format(dt);
		String destination = userDir + "\\Screenshots\\" + screenshotName + dateTime + ".png";
		File destinationFile = new File(destination);
		try {
			FileHandler.copy(src, destinationFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return destination;
	}
	
	
	public Object[][] getExcelData(String pathOfTheSheet){
		
		FileInputStream fis = null;
		XSSFWorkbook book = null;
		
		try {
			fis = new FileInputStream(pathOfTheSheet);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		XSSFSheet sh =book.getSheetAt(0);
		int rowCount = sh.getLastRowNum();
		int colCount = sh.getRow(1).getLastCellNum();
		
		Object[][] data = new Object[rowCount][colCount];
		
		for (int i=0; i< rowCount; i++){
			for (int j=0; j< colCount; j++){
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
