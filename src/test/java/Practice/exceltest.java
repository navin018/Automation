package Practice;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;

import testobjects.Baseclass;
public class exceltest {

	public static void main(String[] args) throws IOException {
		String[] entities = {"Bug","Iteration","Requirement","Test","TestResult"};
		
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\sonal.harish.nagda\\Downloads\\AD_Entities.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook (fis);
		
		JSONObject jsonObject = new JSONObject();
		String Entities_JSONFile = "C:\\Users\\sonal.harish.nagda\\Documents\\almPT_old\\src\\test\\resources\\testdata\\DataLoader\\JSON\\AD_DataLoaderJSON.json";
		
	   
		
		for(String entity: entities)
		{
			XSSFSheet sheet = workbook.getSheet(entity);
			Random rnd = new Random();
			int randomNumb = 10000000 + rnd.nextInt(90000000);
			sheet.getRow(1).getCell(0).setCellValue(randomNumb);
			String entityWithWorkItemExternalID = "WorkItemExternalId_"+entity;
			 jsonObject.put(entityWithWorkItemExternalID, randomNumb);
			
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\sonal.harish.nagda\\Downloads\\AD_Entities1.xlsx"));
		workbook.write(fos);
	    fos.close();
	    FileWriter file = new FileWriter(Entities_JSONFile);
        file.write(jsonObject.toJSONString());
        file.close();
		System.out.println("Done");
		
		
	}

}

