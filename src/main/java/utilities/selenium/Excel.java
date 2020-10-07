package utilities.selenium;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static XSSFRow Row;
	
	public static void setExcelLocAndSheet(String FileLoc, String SheetName)
	{
		
		try{
			
			 fis = new FileInputStream(new File(FileLoc));
			 workbook = new XSSFWorkbook (fis);
			 sheet = workbook.getSheet(SheetName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	 public static String getCellData(int RowNum, int ColNum) {
		 
	       try{
	           cell = sheet.getRow(RowNum).getCell(ColNum);
	           return cell.getStringCellValue();
	           }
	       catch (Exception e){
	        	   return"";
	 
	           }
	 
	     }

}
