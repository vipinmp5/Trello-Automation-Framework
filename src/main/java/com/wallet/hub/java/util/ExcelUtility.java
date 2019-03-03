package com.wallet.hub.java.util;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;


public class ExcelUtility {

	 

	    public FileInputStream fis = null;
	    public XSSFWorkbook workbook = null;
	    public XSSFSheet sheet = null;
	    public XSSFRow row = null;
	    public XSSFCell cell = null;
	 
	    public ExcelUtility(String xlFilePath) throws Exception
	    {
	        fis = new FileInputStream(xlFilePath);
	        workbook = new XSSFWorkbook(fis);
	        fis.close();
	    }
	 
	    public String getCellData(String sheetName, String colName, int rowNum)
	    {
	    	 int col_Num = -1;
	        try
	        {
	           
	            sheet = workbook.getSheet(sheetName);
	            row = sheet.getRow(0);
	            for(int i = 0; i < row.getLastCellNum(); i++)
	            {
	                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
	                    col_Num = i;
	            }
	 
	            row = sheet.getRow(rowNum - 1);
	            cell = row.getCell(col_Num);
	 
	           
	                return cell.getStringCellValue();
	          
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            return "row "+rowNum+" or column "+col_Num +" does not exist  in Excel";
	        }
	    }
	}

