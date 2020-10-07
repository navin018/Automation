package testobjects;

import static org.testng.Assert.assertTrue;
import static utilities.selenium.SeleniumDSL.ExpWaitForCondition;
import static utilities.selenium.SeleniumDSL.ExpWaitForElementToDisappear;
import static utilities.selenium.SeleniumDSL.*;
import static utilities.selenium.SeleniumDSL.clickJS;
import static utilities.selenium.SeleniumDSL.highlight;
import static utilities.selenium.SeleniumDSL.isEnabled;
import static utilities.selenium.SeleniumDSL.selectDropdownByText;
import static utilities.selenium.SeleniumDSL.singleClick;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;

import junit.framework.Assert;
import uiMap.MyWizardUIMap;

public class DataLoader {
	
	public static void PrepareExcelFileAndWriteEntityIDToJSON(String[] entities, String Excelfilepath,String dataload_type){

		try{
			
	String ExcelWithUpdatedEntityIDPath = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "Excel"+  File.separator ;
		FileInputStream fis = new FileInputStream(new File(Excelfilepath));
		XSSFWorkbook workbook = new XSSFWorkbook (fis);
		
		JSONObject jsonObject = new JSONObject();
		String Entities_JSONFile = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "JSON"+ File.separator + "DataLoaderJSON.json";
		
		for(String entity: entities)
		{
			XSSFSheet sheet = workbook.getSheet(entity);
			Random rnd = new Random();
			int randomNumb = 10000000 + rnd.nextInt(90000000);
			sheet.getRow(1).getCell(0).setCellValue(randomNumb);
			String entityWithWorkItemExternalID = "WorkItemExternalId_"+entity;
			 jsonObject.put(entityWithWorkItemExternalID, randomNumb);	
			 if(dataload_type.equalsIgnoreCase("AD") && entity.equalsIgnoreCase("Test"))
				 workbook.getSheet("TestSteps").getRow(1).getCell(7).setCellValue(randomNumb);

		}
	
		if(dataload_type.equalsIgnoreCase("AD"))
			ExcelWithUpdatedEntityIDPath = ExcelWithUpdatedEntityIDPath+"AD.xlsx";
		
		if(dataload_type.equalsIgnoreCase("Devops"))
			ExcelWithUpdatedEntityIDPath = ExcelWithUpdatedEntityIDPath+"Devops.xlsx";
		
		
		
		FileOutputStream fos = new FileOutputStream(new File(ExcelWithUpdatedEntityIDPath));
		workbook.write(fos);
		fis.close();
	    fos.close();
	    FileWriter file = new FileWriter(Entities_JSONFile);
        file.write(jsonObject.toJSONString());
        file.close();	
	
	}
	catch(Exception e)
	{
		Assert.fail("problem with excel file creation to be uploaded");
		e.printStackTrace();
	}
}
		
		public static void SelectEntitiyType(String dataload_type)
		{
			try{
			ExpWaitForCondition(MyWizardUIMap.SelectEntity_Drpdown);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			if(dataload_type.equalsIgnoreCase("AD"))
			selectDropdownByText(MyWizardUIMap.SelectEntity_Drpdown,"AD Entities");
			else if(dataload_type.equalsIgnoreCase("Devops"))
			selectDropdownByText(MyWizardUIMap.SelectEntity_Drpdown,"DevOps Entities");
			}
			catch(Exception e)
			{
				Assert.fail("Could not select dataupload type from the dropdown");
				e.printStackTrace();
			}
		}
		
		public static void UploadFile(String dataload_type)
		{
			try{
			  String ExcelFileLoc = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "Excel"+  File.separator ;

				if(dataload_type.equalsIgnoreCase("AD"))
					ExcelFileLoc = ExcelFileLoc+"AD.xlsx";
				
				if(dataload_type.equalsIgnoreCase("Devops"))
					ExcelFileLoc = ExcelFileLoc+"Devops.xlsx";
				
				
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				singleClick(MyWizardUIMap.Browse_btn);
				Thread.sleep(5000);
				
				String AutoITFileloc = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator +"AutoIT" + File.separator ;
				String autoITExecutable = AutoITFileloc+"UploadFile_DataLoader.exe " +ExcelFileLoc;
				Process process = Runtime.getRuntime().exec(autoITExecutable);
				process.waitFor();
			    Thread.sleep(6000);
			    highlight(MyWizardUIMap.Upload_checkbox);
			    clickJS(MyWizardUIMap.Upload_checkbox);
			    click(MyWizardUIMap.UploadAll_link);
			    Thread.sleep(3000);
			    ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				assertTrue(isEnabled(MyWizardUIMap.UploadComplete_statictxt));
				driver().close();
				driver().quit();
		}
		catch(Exception e)
		{
			Assert.fail("Issue with file upload");
			e.printStackTrace();
		}
}
		
		public static void prepareExcelFilePathtoBeUploaded(String dataload_type)
		{
			try{
			String[] entities_AD = {"Bug","Iteration","Requirement","Test","TestResult"};
			String[] entities_Devops = {"CodeCommit","CodeBranch","Build","Deployment","Environment","TestResult"};
			
			String ExcelToBePrepared = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "Excel"+  File.separator ;
			if(dataload_type.equalsIgnoreCase("AD"))
				ExcelToBePrepared = ExcelToBePrepared+"AD.xlsx";
		
			if(dataload_type.equalsIgnoreCase("Devops"))
				ExcelToBePrepared = ExcelToBePrepared+"Devops.xlsx";
			
			
			
			if(dataload_type.equalsIgnoreCase("AD"))
			DataLoader.PrepareExcelFileAndWriteEntityIDToJSON(entities_AD,ExcelToBePrepared,dataload_type);
			if(dataload_type.equalsIgnoreCase("Devops"))
			DataLoader.PrepareExcelFileAndWriteEntityIDToJSON(entities_Devops,ExcelToBePrepared,dataload_type);		
			}
			catch(Exception e)
			{
				Assert.fail("Problem preparing the excel sheet to be uploaded");
				e.printStackTrace();
			}
			
		}
	}

