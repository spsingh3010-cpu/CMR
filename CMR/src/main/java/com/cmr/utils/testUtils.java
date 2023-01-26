package com.cmr.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
//import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.cmr.Base.baseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class testUtils extends baseTest{
	
	public static long PAGE_LOAD_TIMEOUT=300;
	public static long IMPLICIT_WAIT_TIMEOUT=300;
	
//	public void Switchtoframe()
//	{
//		driver.switchTo().frame("mainpanel");
//	} 
	//use this function in case the the locator is located in frame so switch it to frame then locate
	
	public static String SHEET_LOCATION="C:\\Users\\Supriya\\eclipse-workspace\\CMR\\src\\main\\java\\com\\cmr\\testData\\FreeCRMData (1).xlsx";
	
	static Sheet sheet;
	static Workbook book;
	
	public static Object[][] getTestData(String sheetName)
	{
	  FileInputStream file=null;	
	  try
	  {
		  file= new FileInputStream(SHEET_LOCATION);
	  }
	  catch(FileNotFoundException e)
	  {
		e.printStackTrace();  
	  }
	  try
	  {
		  book=WorkbookFactory.create(file);
	  }
	  catch(InvalidFormatException e)
	  {
			e.printStackTrace();  

	  }  catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  sheet= book.getSheet(sheetName);
	  
	  Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	  for(int i=0;i<sheet.getLastRowNum();i++)
	  {
		  for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
		  {
			  data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			  
		  }
	  }
	  return data;
	}
	public static void getScreenshot() throws IOException {

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDir=System.getProperty("user dir");
        FileUtils.copyFile(scrFile, new File(currentDir+".//screenshot"+System.currentTimeMillis()+".png"));

	}

}
