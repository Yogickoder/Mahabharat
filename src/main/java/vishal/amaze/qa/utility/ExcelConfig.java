package vishal.amaze.qa.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import vishal.amaze.qa.base.TestBase;


public class ExcelConfig extends TestBase{
	
	public static XSSFWorkbook wb; // XSSFWorkbook is a class.
	public static XSSFSheet sheet;// XSSFSheet is also a class.
	public static XSSFRow row;
	
	
	public String getData(String sheetname,int row,int column)
	{
		 sheet = wb.getSheet(sheetname);
		 String celldata = sheet.getRow(row).getCell(column).getStringCellValue();
		 return celldata;
	}
	
	public int getrowcount(String sheetname)
	{
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		//rowcount= rowcount+1;
		return rowcount;
	}
	
	public int getcolumncount(String sheetname)
	{
		row = wb.getSheet(sheetname).getRow(0);
		int colcount = row.getLastCellNum();
		return colcount;
	}
	
    
	public static Object[][] getTestdata(String sheetname, String excelpath)
	{
		  
		try {
			File src = new File(excelpath);
			
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
				
         } catch(Exception e) {
		
			System.out.println(e.getMessage());
		} 
		
		
		  System.out.println("Reading data contents from excel using apache.poi jar files");
		  ExcelConfig config =new ExcelConfig();
		  int rows = config.getrowcount(sheetname);
		  int cols = config.getcolumncount(sheetname);
		  System.out.println("Total no of rows= "+rows);
		  System.out.println("Total no of columns= "+cols);
		  
		   Object[][]  data = new Object[rows][cols];
		   for(int i=0;i<rows;i++)
		    {for (int k =0;k<cols;k++)
		      {
		    	data[i][k] = config.getData(sheetname,i+1,k);
		    	System.out.println("Cell data at "+"["+i+"]"+"["+k+"]"+" is = "+data[i][k]);
		      }
			}
		   
		return data;   
    }
	
	
}
