package testobjects;

import static org.testng.Assert.assertTrue;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Instant;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import uiMap.GenericUploaderUIMap;
import uiMap.MyWizardUIMap;
import utilities.general.Property;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
public class DataLoader {
	
	public static void PrepareExcelFileForGenericUploaderAndWriteEntityIDToJSON(String entity,String toolname){

		try{
			
			String Entities_JSONFile = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" + File.separator + "WorkItemExternalIDs.json";
		String Excelfilepath="";
		if(toolname.equalsIgnoreCase("ADT Jira") ||  toolname.equalsIgnoreCase("myWizardInstance"))	
		Excelfilepath = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "GenericUploader"+ File.separator +"ADTJira" + File.separator +"Excel"+  File.separator + entity+".xlsx" ;
		else if(toolname.equalsIgnoreCase("NoToolInstance"))
			Excelfilepath = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "GenericUploader"+ File.separator +"NoTool" + File.separator +"Excel"+  File.separator + entity+".xlsx" ;	
		FileInputStream fis = new FileInputStream(new File(Excelfilepath));
		XSSFWorkbook workbook = new XSSFWorkbook (fis);
		
		 
		
		
		String workitemID="";
		String EntityIDForJSON="";
		XSSFSheet sheet = workbook.getSheet(entity);
		Random rnd = new Random();
		int randomNumb = 10000 + rnd.nextInt(90000);
//		 workitemID = Property.getProperty("JiraProject")+"-"+randomNumb;
		
		String title = entity+"_AutomationData_GenericUploader";
		String Project = Property.getProperty("JiraProject");
	String time = Instant.now().toString().substring(0, 19)+"Z";
		if(!(entity.equalsIgnoreCase("Action") || entity.equalsIgnoreCase("Iteration") || entity.equalsIgnoreCase("Decision") || entity.equalsIgnoreCase("IterationForMyWizardInstance")))
			{
			if(toolname.equalsIgnoreCase("ADT Jira"))
			{
				workitemID = Tools.getWorkItemExternalID(entity, "ADT Jira");
				sheet.getRow(1).getCell(0).setCellValue(workitemID);
				sheet.getRow(1).getCell(2).setCellValue(title);
				sheet.getRow(1).getCell(4).setCellValue(Project);
				sheet.getRow(1).getCell(12).setCellValue(time);
			}
			else if(toolname.equalsIgnoreCase("NoToolInstance"))
			{
				Random rndnumb = new Random();
				int randomNumber = 10000 + rndnumb.nextInt(90000);
				sheet.getRow(1).getCell(0).setCellValue(String.valueOf(randomNumber));
				sheet.getRow(1).getCell(2).setCellValue(title);
				
				FileReader reader = new FileReader(Entities_JSONFile);
				JSONParser jsonParser = new JSONParser();
			    JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			    jsonObject.put("WorkItemExternalId_"+entity, String.valueOf(randomNumber));        
			    FileOutputStream outputStream = new FileOutputStream(Entities_JSONFile);
				byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
			}
			}
		else if(entity.equalsIgnoreCase("Action"))
		{
			if(toolname.equalsIgnoreCase("ADT Jira"))
			{
			workitemID = Tools.getWorkItemExternalID(entity, "ADT Jira");
			sheet.getRow(1).getCell(0).setCellValue(workitemID);
			sheet.getRow(1).getCell(2).setCellValue(title);
			sheet.getRow(1).getCell(11).setCellValue(time);
			}
			else if(toolname.equalsIgnoreCase("NoToolInstance"))
			{
				Random rndnumb = new Random();
				int randomNumber = 10000 + rndnumb.nextInt(90000);
				sheet.getRow(1).getCell(0).setCellValue(String.valueOf(randomNumber));
				sheet.getRow(1).getCell(2).setCellValue(title);
				
				FileReader reader = new FileReader(Entities_JSONFile);
				JSONParser jsonParser = new JSONParser();
			    JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			    jsonObject.put("WorkItemExternalId_"+entity, String.valueOf(randomNumber));      
			    FileOutputStream outputStream = new FileOutputStream(Entities_JSONFile);
				byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
			}
		}
		else if(entity.equalsIgnoreCase("Decision"))
		{
			if(toolname.equalsIgnoreCase("myWizardInstance"))
			{
			String workitemIDForDecision = "GNRIC-"+randomNumb;
			sheet.getRow(1).getCell(0).setCellValue(workitemIDForDecision);
			sheet.getRow(1).getCell(2).setCellValue(title);
			sheet.getRow(1).getCell(10).setCellValue(time);
				

				FileReader reader = new FileReader(Entities_JSONFile);
				JSONParser jsonParser = new JSONParser();
			        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			        jsonObject.put("WorkItemExternalId_Decision", workitemIDForDecision);        
			        FileOutputStream outputStream = new FileOutputStream(Entities_JSONFile);
					byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
			}
			else if(toolname.equalsIgnoreCase("NoToolInstance"))
			{
				
				Random rndnumb = new Random();
				int randomNumber = 10000 + rndnumb.nextInt(90000);
				sheet.getRow(1).getCell(0).setCellValue(String.valueOf(randomNumber));
				sheet.getRow(1).getCell(2).setCellValue(title);
				
				FileReader reader = new FileReader(Entities_JSONFile);
				JSONParser jsonParser = new JSONParser();
			    JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			    jsonObject.put("WorkItemExternalId_"+entity, String.valueOf(randomNumber));      
			    FileOutputStream outputStream = new FileOutputStream(Entities_JSONFile);
				byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
			}
			
									
		}
		else if(entity.equalsIgnoreCase("Iteration"))
		{
			if(toolname.equalsIgnoreCase("ADT Jira"))
			{
			sheet.getRow(1).getCell(0).setCellValue(Baseclass.getInstance().release_IterationExternalID);
			sheet.getRow(1).getCell(2).setCellValue("Release_AutomationData_GenericUploader");
			sheet.getRow(1).getCell(4).setCellValue(Project);
			sheet.getRow(1).getCell(9).setCellValue(time);
			sheet.getRow(1).getCell(13).setCellValue("Release");
			
			sheet.getRow(2).getCell(0).setCellValue(Baseclass.getInstance().sprint_IterationExternalID);
			sheet.getRow(2).getCell(2).setCellValue("Sprint_AutomationData_GenericUploader");
			sheet.getRow(2).getCell(4).setCellValue(Project);
			sheet.getRow(2).getCell(9).setCellValue(time);
			sheet.getRow(2).getCell(13).setCellValue("Sprint-DevelopmentSprint");
			}
			else if(toolname.equalsIgnoreCase("NoToolInstance"))
			{
				Random rndnumb = new Random();
				int randomNumber = 10000 + rndnumb.nextInt(90000);
				sheet.getRow(1).getCell(0).setCellType(Cell.CELL_TYPE_NUMERIC);
				sheet.getRow(1).getCell(0).setCellValue(String.valueOf(randomNumber));
				Baseclass.getInstance().release_IterationExternalID=String.valueOf(randomNumber);
				sheet.getRow(1).getCell(2).setCellValue("Release_AutomationData_GenericUploader");
				sheet.getRow(1).getCell(9).setCellValue(time);
				sheet.getRow(1).getCell(13).setCellValue("Release");
				sheet.getRow(1).getCell(14).setCellValue("Agile");
				sheet.getRow(1).getCell(15).setCellValue("Scrum");
				
				sheet.getRow(2).getCell(0).setCellValue(String.valueOf(randomNumber+1));
				sheet.getRow(1).getCell(0).setCellType(Cell.CELL_TYPE_NUMERIC);
				Baseclass.getInstance().sprint_IterationExternalID=String.valueOf(randomNumber+1);
				sheet.getRow(2).getCell(2).setCellValue("Sprint_AutomationData_GenericUploader");
				sheet.getRow(2).getCell(9).setCellValue(time);
				sheet.getRow(2).getCell(13).setCellValue("Sprint-DevelopmentSprint");
				sheet.getRow(2).getCell(14).setCellValue("Agile");
				sheet.getRow(2).getCell(15).setCellValue("Scrum");
				
				CommonFunctions.writeIterationExternalIDs(Baseclass.getInstance().release_IterationExternalID,Baseclass.getInstance().sprint_IterationExternalID,"ADT Jira");
			}
		}
		else if(entity.equalsIgnoreCase("IterationForMyWizardInstance"))
		{
			sheet = workbook.getSheet("Iteration");
			sheet.getRow(1).getCell(0).setCellValue(String.valueOf(randomNumb));
			Baseclass.getInstance().release_IterationExternalID= String.valueOf(randomNumb);
			sheet.getRow(1).getCell(2).setCellValue("Release_AutomationData_GenericUploader");
			sheet.getRow(1).getCell(8).setCellValue(time);
			sheet.getRow(1).getCell(13).setCellValue("Release");
			sheet.getRow(1).getCell(14).setCellValue("Agile");
			sheet.getRow(1).getCell(15).setCellValue("Scrum");
			
			sheet.getRow(2).getCell(0).setCellValue(String.valueOf(randomNumb+1));
			Baseclass.getInstance().sprint_IterationExternalID= String.valueOf(randomNumb+1);
			sheet.getRow(2).getCell(2).setCellValue("Sprint_AutomationData_GenericUploader");
			sheet.getRow(1).getCell(8).setCellValue(time);
			sheet.getRow(1).getCell(13).setCellValue("Sprint-DevelopmentSprint");
			sheet.getRow(1).getCell(14).setCellValue("Agile");
			sheet.getRow(1).getCell(15).setCellValue("Scrum");
			
			CommonFunctions.writeIterationExternalIDs(Baseclass.getInstance().release_IterationExternalID,Baseclass.getInstance().sprint_IterationExternalID,"ADT Jira");
			
		}
		
		FileOutputStream fos = new FileOutputStream(new File(Excelfilepath));
		workbook.write(fos);
		fis.close();
	    fos.close();
//	    FileWriter file = new FileWriter(Entities_JSONFile1);
     
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		Assert.fail("problem with excel file creation to be uploaded");

	}
	}
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
		
		public static void prepareExcelFilePathtoBeUploaded(String toolname, String dataload_type)
		{
			try{
			String ExcelToBePrepared="";
//			String[] entities_AD = {"Bug","Iteration","Requirement","Test","TestResult"};
//			String[] entities_Devops = {"CodeCommit","CodeBranch","Build","Deployment","Environment","TestResult"};
			String[] entities_ADTJira_GenericUploader = {"Epic","Feature","Task","Bug","Issue","Impediment","Risk","Action","Iteration"};
//			String[] entities_ADTJira_GenericUploader = {"Iteration"};
			String[] entities_MyWizardInstanceGenericUploader = {"Decision","IterationForMyWizardInstance"};
			String[] entities_NoToolInstance_GenericUploader = {"Epic","Feature","Task","Bug","Issue","Impediment","Risk","Action","Decision","Iteration"};
//			String[] entities_NoToolInstance_GenericUploader = {"Decision"};
			ExcelToBePrepared = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "Excel"+  File.separator ;
			if(toolname.equalsIgnoreCase("ADT Jira"))
					{
				for(String entity:entities_ADTJira_GenericUploader)
						{
							PrepareExcelFileForGenericUploaderAndWriteEntityIDToJSON(entity,toolname);
						}
					}
			else if(toolname.equalsIgnoreCase("myWizardInstance"))
				{
					for(String entity:entities_MyWizardInstanceGenericUploader)
					{
						PrepareExcelFileForGenericUploaderAndWriteEntityIDToJSON(entity,toolname);
					}
				}
			else if(toolname.equalsIgnoreCase("NoToolInstance"))
			{
				for(String entity:entities_NoToolInstance_GenericUploader)
				{
					PrepareExcelFileForGenericUploaderAndWriteEntityIDToJSON(entity,toolname);
				}
			}
			
//			ExcelToBePrepared = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "Excel"+  File.separator ;
//			if(dataload_type.equalsIgnoreCase("AD"))
//				ExcelToBePrepared = ExcelToBePrepared+"AD.xlsx";
//		
//			if(dataload_type.equalsIgnoreCase("Devops"))
//				ExcelToBePrepared = ExcelToBePrepared+"Devops.xlsx";
//			
//			
//			
//			if(dataload_type.equalsIgnoreCase("AD"))
//			DataLoader.PrepareExcelFileAndWriteEntityIDToJSON(entities_AD,ExcelToBePrepared,dataload_type);
//			if(dataload_type.equalsIgnoreCase("Devops"))
//			DataLoader.PrepareExcelFileAndWriteEntityIDToJSON(entities_Devops,ExcelToBePrepared,dataload_type);		
			}
			catch(Exception e)
			{
				Assert.fail("Problem preparing the excel sheet to be uploaded");
				e.printStackTrace();
			}
			
		}
		public static void UploadFileForGenericUploader(String dataentity,String toolname) {
			try{
			if(!dataentity.equalsIgnoreCase("IterationForMyWizardInstance"))	
			selectByPartOfVisibleText(GenericUploaderUIMap.DataEntity_drpdown, dataentity);
			else if(dataentity.equalsIgnoreCase("IterationForMyWizardInstance"))
				selectByPartOfVisibleText(GenericUploaderUIMap.DataEntity_drpdown, "Iteration");	
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			singleClick(GenericUploaderUIMap.DataMappingTemplate_drpdown);
			Thread.sleep(2000);
			clickJS(GenericUploaderUIMap.DataMappingTemplateOption_drpdown);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			singleClick(GenericUploaderUIMap.Upload_Img);
			ExpWaitForCondition(GenericUploaderUIMap.Upload_btn);
			singleClick(GenericUploaderUIMap.SelectFile_btn);
			String ExcelFileLoc="";
			if(toolname.equalsIgnoreCase("ADT Jira"))
			 ExcelFileLoc = System.getProperty("user.dir")+File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator +"DataLoader" + File.separator +"GenericUploader" + File.separator + "ADTJira"+ File.separator +"Excel"+ File.separator + dataentity+".xlsx";
			else if(toolname.equalsIgnoreCase("noToolInstance"))
				ExcelFileLoc = System.getProperty("user.dir")+File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator +"DataLoader" + File.separator +"GenericUploader" +File.separator+ "NoTool"+ File.separator +"Excel"+ File.separator + dataentity+".xlsx";
			String AutoITFileloc = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator +"AutoIT" + File.separator ;
			
			String autoITExecutable = AutoITFileloc+"UploadFile_DataLoader.exe " +ExcelFileLoc;
			Process process = Runtime.getRuntime().exec(autoITExecutable);
			process.waitFor();
			Thread.sleep(5000);
			clickJS(GenericUploaderUIMap.Upload_btn);
		    Thread.sleep(120000);
			clickJS(GenericUploaderUIMap.Refresh_btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
		    if(!getText(GenericUploaderUIMap.StatusOfRecordUploaded_statictxt).equalsIgnoreCase("Complete"))
		    {
		    	clickJS(GenericUploaderUIMap.Refresh_btn);
		    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		    	Thread.sleep(60000);
		    	if(!getText(GenericUploaderUIMap.StatusOfRecordUploaded_statictxt).equalsIgnoreCase("Complete"))
		    		{
		    		clickJS(GenericUploaderUIMap.Refresh_btn);
		    		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		    		Thread.sleep(60000);
		    		}
		    	if(!getText(GenericUploaderUIMap.StatusOfRecordUploaded_statictxt).equalsIgnoreCase("Complete"))
		    			Assert.fail("The record for entity "+dataentity+" could not be uplaoded in generic uploader. waited for max(4mins). current status of upload is "+getText(GenericUploaderUIMap.StatusOfRecordUploaded_statictxt));
		    }

			}
			catch(Exception e)
			{
				e.printStackTrace();
				 Assert.fail("Issue uploading entity "+dataentity+ " in generic uploader");
			}
		}
	}

