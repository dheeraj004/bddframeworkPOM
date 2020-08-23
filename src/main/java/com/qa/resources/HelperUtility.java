package com.qa.resources;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.qa.testbase.TestBase;

public class HelperUtility extends TestBase {
	
	public static long pageloadtimeout=20;
	public static long implicitlyWaittimeout=20;
	public static String filename="E:\\Selenium_Practice\\bddframework\\src\\main\\java\\com\\qa\\testdata\\FreeCrmTestData.xlsx";
	public static File file;
	public static FileInputStream fi;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	public void switchtoFrame()
	{
		driver.switchTo().frame("mainpanel");
	}

	
	
	public static Object[][] getData(String sheetName)
	{
		try
		{
		file=new File(filename);
		fi=new FileInputStream(file);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		Object[][] data=new Object[(sheet.getLastRowNum())][(sheet.getRow(0).getLastCellNum())];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}
	

}
