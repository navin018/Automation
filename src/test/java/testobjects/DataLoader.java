package testobjects;

import static org.testng.Assert.assertTrue;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
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
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.jcraft.jsch.Logger;
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
	String Phase="Plan";
    String WorkStream="Security_AutomationData";
    
	if(!entity.equalsIgnoreCase("Iteration") || entity.equalsIgnoreCase("Decision") || entity.equalsIgnoreCase("IterationForMyWizardInstance"))
    {
    if(toolname.equalsIgnoreCase("ADT Jira"))
    {
        workitemID = Tools.getWorkItemExternalID(entity, "ADT Jira");
        sheet.getRow(1).getCell(0).setCellValue(workitemID);
        sheet.getRow(1).getCell(2).setCellValue(title);
        sheet.getRow(1).getCell(4).setCellValue(Project);
        sheet.getRow(1).getCell(12).setCellValue(time);
        if(entity.equalsIgnoreCase("Bug")) {
            sheet.getRow(1).getCell(39).setCellValue(Phase);
            sheet.getRow(1).getCell(40).setCellValue(WorkStream);
            //below line to verify owner field(Team verification) for workitem
            sheet.getRow(1).getCell(6).setCellValue(Property.getProperty("Owner_TeamResouce"));
                           
        }
        else if(entity.equalsIgnoreCase("Action")) {
            sheet.getRow(1).getCell(29).setCellValue(Phase);
            sheet.getRow(1).getCell(30).setCellValue(WorkStream);
            
        }
        else if(entity.equalsIgnoreCase("Risk")) {
            sheet.getRow(1).getCell(38).setCellValue(Phase);
            sheet.getRow(1).getCell(39).setCellValue(WorkStream);
            sheet.getRow(1).getCell(6).setCellValue(Property.getProperty("Owner_TeamResouce"));
        }
        else if(entity.equals("Issue")) {
            sheet.getRow(1).getCell(30).setCellValue(Phase);
            sheet.getRow(1).getCell(31).setCellValue(WorkStream);
            sheet.getRow(1).getCell(6).setCellValue(Property.getProperty("Owner_TeamResouce"));
        }
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
				randomNumb=randomNumb+1;
				sheet.getRow(2).getCell(0).setCellValue(String.valueOf(randomNumb+1));
				Baseclass.getInstance().sprint_IterationExternalID= String.valueOf(randomNumb);
				sheet.getRow(2).getCell(2).setCellValue("Sprint_AutomationData_GenericUploader");
				sheet.getRow(1).getCell(8).setCellValue(time);
				sheet.getRow(1).getCell(13).setCellValue("Sprint-DevelopmentSprint");
				sheet.getRow(1).getCell(14).setCellValue("Agile");
				sheet.getRow(1).getCell(15).setCellValue("Scrum");
				
				CommonFunctions.writeIterationExternalIDs(Baseclass.getInstance().release_IterationExternalID,Baseclass.getInstance().sprint_IterationExternalID,"ADT Jira");
				
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
		public static void PrepareExcelFileAndWriteEntityIDToJSON(String[] entities,String dataload_type){

			try{
				
		String ExcelWithUpdatedEntityIDPath = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "Excel"+  File.separator ;
		
		String Excelfilepath = "";
		
		if(dataload_type.equalsIgnoreCase("ADDataLoader"))
			Excelfilepath= ExcelWithUpdatedEntityIDPath+"AD.xlsx";
		else if(dataload_type.equalsIgnoreCase("DevopsDataLoader"))
			Excelfilepath= ExcelWithUpdatedEntityIDPath+"DevOps.xlsx";
			FileInputStream fis = new FileInputStream(new File(Excelfilepath));
			XSSFWorkbook workbook = new XSSFWorkbook (fis);
			
//			JSONObject jsonObject = new JSONObject();
			String Entities_JSONFile = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "JSON"+ File.separator + "DataLoaderJSON.json";
			FileReader reader = new FileReader(Entities_JSONFile);
			JSONParser jsonParser = new JSONParser();
		        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			
			for(String entity: entities)
			{
				XSSFSheet sheet = workbook.getSheet(entity);
				Random rnd = new Random();
				int randomNumb = 10000000 + rnd.nextInt(90000000);
				sheet.getRow(1).getCell(0).setCellValue(randomNumb);
				
				String entityWithWorkItemExternalID="";
				String entityWithWorkItemExternalID_sprint="";
				if(!entity.equalsIgnoreCase("Iteration"))
				entityWithWorkItemExternalID = "WorkItemExternalId_"+entity;
				else if(entity.equalsIgnoreCase("Iteration")){
					sheet.getRow(2).getCell(0).setCellValue(randomNumb+1);
					entityWithWorkItemExternalID="WorkItemExternalId_"+"Release";
					entityWithWorkItemExternalID_sprint="WorkItemExternalId_"+"Sprint";
					jsonObject.put(entityWithWorkItemExternalID_sprint, randomNumb);	
				}
				 jsonObject.put(entityWithWorkItemExternalID, randomNumb);	
				  FileOutputStream outputStream = new FileOutputStream(Entities_JSONFile);
					byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
//				 if(dataload_type.equalsIgnoreCase("AD") && entity.equalsIgnoreCase("Test"))
//					 workbook.getSheet("TestSteps").getRow(1).getCell(7).setCellValue(randomNumb);

			}
		
			if(dataload_type.equalsIgnoreCase("AD"))
				ExcelWithUpdatedEntityIDPath = ExcelWithUpdatedEntityIDPath+"AD.xlsx";
			
			if(dataload_type.equalsIgnoreCase("Devops"))
				ExcelWithUpdatedEntityIDPath = ExcelWithUpdatedEntityIDPath+"Devops.xlsx";
			
			
			FileOutputStream fos = new FileOutputStream(new File(Excelfilepath));
			workbook.write(fos);
			fis.close();
		    fos.close();
			

		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("problem with excel file creation to be uploaded");
			
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
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
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
//				String autoITExecutable = AutoITFileloc+"UploadFile.exe " +ExcelFileLoc;
				Process process = Runtime.getRuntime().exec(autoITExecutable);
				process.waitFor();
			    Thread.sleep(6000);
			    highlight(MyWizardUIMap.Upload_checkbox);
			    clickJS(MyWizardUIMap.Upload_checkbox);
			    click(MyWizardUIMap.UploadAll_link);
			    Thread.sleep(3000);
			    ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				assertTrue(isEnabled(MyWizardUIMap.UploadComplete_statictxt));
				Thread.sleep(5000);
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			grabScreenshotForExtentReport();
			Assert.fail("Issue with file upload for "+dataload_type);
		
		}
}
		
		public static void prepareExcelFilePathtoBeUploaded(String toolname, String dataload_type)
		{
			try{
			String ExcelToBePrepared="";
			String[] entities_AD = {"Bug","Iteration","Requirement","Test","TestResult"};
			String[] entities_Devops = {"CodeCommit","CodeBranch","Build","Deployment","Environment","TestResult"};
			String[] entities_ADTJira_GenericUploader = {"Epic","Feature","Task","Bug","Issue","Impediment","Risk","Action","Iteration"};
//			String[] entities_ADTJira_GenericUploader = {"Iteration"};
			String[] entities_MyWizardInstanceGenericUploader = {"Decision","IterationForMyWizardInstance"};
			String[] entities_NoToolInstance_GenericUploader = {"Epic","Feature","Task","Bug","Issue","Impediment","Risk","Action","Decision","Iteration"};
//			String[] entities_NoToolInstance_GenericUploader = {"Decision"};
			ExcelToBePrepared = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "Excel"+  File.separator ;
			if(toolname.equalsIgnoreCase("ADT Jira") && !dataload_type.equalsIgnoreCase("ADDataLoader"))
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
			if(dataload_type.equalsIgnoreCase("ADDataLoader"))
			{
			
					PrepareExcelFileAndWriteEntityIDToJSON(entities_AD,dataload_type);
			
			}
			if(dataload_type.equalsIgnoreCase("DevopsDataLoader"))
			{
			
					PrepareExcelFileAndWriteEntityIDToJSON(entities_Devops,dataload_type);
			
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
		
		public static void verifyentityprioritization(String entity,String toolname) {
		try{
			
		     //verify entity present in mywizardinstance
			selectByPartOfVisibleText(GenericUploaderUIMap.ProductInstance_drpdown, "myWizardInstance");
			List<WebElement> alldropdownvalues = getDropdownOptionsElements(GenericUploaderUIMap.DataEntity_drpdown);
			boolean entitypresentInInstance=false;
			for (int j = 0; j < alldropdownvalues.size(); j++) {
		        if(alldropdownvalues.get(j).getText().equalsIgnoreCase(entity)){
		        	entitypresentInInstance=true;
		        	break;
		        }
			}
		     if(!entitypresentInInstance){
		    		logger.info("Entity "+entity+ "not present in mywizardinstance in generic uploader tile");
		     		Assert.fail("Entity "+entity+ "not present in mywizardinstance in generic uploader tile");
		    }
		     
		     //verify entity not present in adt jira
		     boolean entitynotpresentIntool=false;
		     selectByPartOfVisibleText(GenericUploaderUIMap.ProductInstance_drpdown, toolname);
		     alldropdownvalues = getDropdownOptionsElements(GenericUploaderUIMap.DataEntity_drpdown);
		     for (int j = 0; j < alldropdownvalues.size(); j++) {
			        if(alldropdownvalues.get(j).getText().equalsIgnoreCase(entity)){
			        	entitynotpresentIntool=true;
			        	break;
			        }
				}
			     if(entitynotpresentIntool){
			    		logger.info("Entity "+entity+ "present in tool "+toolname+" in generic uploader tile");
			     		Assert.fail("Entity "+entity+ "present in tool "+toolname+" in generic uploader tile");
			    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Problem verifying entity in generic uploader tile");
		
		}	
		}
		
		public static void UploadFileForGenericUploader(String dataentity,String toolname) {
			try{
				SoftAssert sa = new SoftAssert();
				String UploadanotherFile;
				String Dataentity;
				
				//doing this split so that the right entity gets selected in the Entity dropdown
				if(dataentity.contains("_")){
				Dataentity = dataentity.split("_")[0];
				UploadanotherFile = dataentity.split("_")[1];
				}
				else
					Dataentity = dataentity;
				
			//for scenario Epic_WrongData, then deliberatly select wrong entity, i.e. feature
				if(dataentity.contains("WrongData"))
					selectByPartOfVisibleText(GenericUploaderUIMap.DataEntity_drpdown, "Feature");
				else if(!dataentity.equalsIgnoreCase("IterationForMyWizardInstance"))	
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
			
			//This part of code is to validate the entity(no special case-only regression), uploading normal entity and check if flown or not. 
			if(!dataentity.contains("_") || dataentity.contains("CustomTemplate")){
			    if(!getText(GenericUploaderUIMap.StatusOfRecordUploaded_statictxt).contains("Complete"))
			    {
			    	clickJS(GenericUploaderUIMap.Refresh_btn);
			    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			    	Thread.sleep(60000);
			    	if(!getText(GenericUploaderUIMap.StatusOfRecordUploaded_statictxt).contains("Complete"))
			    		{
			    		clickJS(GenericUploaderUIMap.Refresh_btn);
			    		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			    		Thread.sleep(60000);
			    		}
			    	if(!getText(GenericUploaderUIMap.StatusOfRecordUploaded_statictxt).contains("Complete"))
			    			Assert.fail("The record for entity "+dataentity+" could not be uplaoded in generic uploader. waited for max(4mins). current status of upload is "+getText(GenericUploaderUIMap.StatusOfRecordUploaded_statictxt));
			    }
			}
			//special case - to upload excel with partial completing upload
			else{
				//validation for partially complete
		    	if(getText(GenericUploaderUIMap.StatusOfRecordUploaded_statictxt).contains("Partially Complete"))
		    	{
		    		logger.info("The data provided for entity "+dataentity+" is Partially Completed");
		    		sa.assertTrue(true,"The data provided for entity "+dataentity+" is Partially Completed");
		    	}
		    
		    	// //special case - to upload wrong excel. selecting wrong entity
			    	if(getText(GenericUploaderUIMap.StatusOfRecordUploaded_statictxt).contains("Failed"))
			    	{
			    		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			    		doubleClick(GenericUploaderUIMap.Failed_txt);
			    		Thread.sleep(2000);
			    		clickJS(GenericUploaderUIMap.FailedTemplate_download);
			    		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			    		ReadLogFile_GenericUploader(dataentity);
			    		 
			    				
			    		
			    		logger.info("invalid/blank data for entity "+dataentity+" is provided for the given columns the template upload process is failed and the entity is not created");
			    		sa.assertTrue(true,"invalid/blank data for entity "+dataentity+" is provided for the given columns the template upload process is failed and the entity is not created");
			    	}
			}

			}
			catch(Exception e)
			{
				e.printStackTrace();
				 Assert.fail("Issue uploading entity "+dataentity+ " in generic uploader");
			}
		}
		
		//gets the last modified file. mention the LocalUserName in ADTJira property file
		 public static File GetlastmodifiedFileFromASpecificLocation() 
		 {
		     File directory;
			try {
				directory = new File("C:\\Users\\"+ Property.getProperty("LocalUserName")+"\\Downloads");
			 
			
		     File[] files = directory.listFiles(File::isFile);
		     long lastModifiedTime = Long.MIN_VALUE;
		     File chosenFile = null;

		     if (files != null)
		     {
		         for (File file : files)
		         {
		             if (file.lastModified() > lastModifiedTime)
		             {
		                 chosenFile = file;
		                 lastModifiedTime = file.lastModified();
		             }
		         }
		     }

		     return chosenFile;
		 }

		 catch(Exception e)
			{
				grabScreenshotForExtentReport();
				e.printStackTrace();
				logger.info("Issue geting the latest modified file");
				 Assert.fail("Issue geting the latest modified file");
			}
			return null;
}
		
		public static  File ReadLogFile_GenericUploader(String dataentity) throws IOException  {
			String chosenfile = GetlastmodifiedFileFromASpecificLocation().toString();
				File file = new File(chosenfile);
				
				FileReader fr = new FileReader(file);
				 BufferedReader reader = new BufferedReader(fr);
				 String str = reader.readLine();

				 System.out.println("Data is:" + str);
				 String Actual = str;
		    		if(dataentity.contains("Epic_InvalidTemplate"))
		    			Assert.assertEquals(Actual,"Missing mandatory values identified: Column 'Title', Row #2." , "Error log for Invalidtemplate is Different from Expected");
		    		else if(dataentity.contains("Epic_BlankTemplate"))
		    			Assert.assertEquals(Actual,"One or more errors occurred. (Error occurred during processing - Fault - <Fault Id=\"-1\" Title=\"Exception has occurred\" Message=\"Exception has been thrown by the target of an invocation.\" CustomMessage=\"Error occurred\" Severity=\"Critical\" ApplicationTier=\"BusinessDomain\" EntityName=\"\" Operation=\"\" Type=\"\" StackTrace=\"System.Exception: ReferenceDataLookup:ApplyReferenceDataLookup : Sequence contains no elements&#xA;   at Accenture.MyWizard.GatewayManager.CustomLibrary.ReferenceDataLookup.ApplyReferenceDataLookup(Object parameters, XDocument messageDoc, Guid correlationUId)\" />\r\n"
		    					+ ")" , "Error log for BlankTemplate is Different from Expected");
		    		else if(dataentity.contains("Epic_WrongData"))
		    			Assert.assertEquals(Actual,"'Feature' Sheet is missing or Uploaded Excel has no Data.. " , "Error log is Different from Expected");
				
		    		reader.close();
				return file;
				
				
			}
		public static void EditCustomTemplate( String dataentity, String toolname) {
			try {
			String Dataentity = dataentity.split("_")[0];
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			selectByPartOfVisibleText(GenericUploaderUIMap.DataEntity_drpdown, Dataentity);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			Thread.sleep(2000);
			singleClick(GenericUploaderUIMap.DataMappingTemplate_drpdown);
			Thread.sleep(2000);
			clickJS(GenericUploaderUIMap.DataMappingTemplateOption_drpdown);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clickJS(GenericUploaderUIMap.Edit_icon);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clickJS(GenericUploaderUIMap.Clone_btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);

			//adding template details
			clear(GenericUploaderUIMap.TemplateName_txt);
			enterText(GenericUploaderUIMap.TemplateName_txt, dataentity+"_Automation_CustomTemplate");
			Thread.sleep(5000);
			enterText(GenericUploaderUIMap.Search_txtbox,"External Id");
			Thread.sleep(2000);
			clear(GenericUploaderUIMap.NewFeild_txtbox);
			enterText(GenericUploaderUIMap.NewFeild_txtbox,"WorkitemExternal Id");

			clear(GenericUploaderUIMap.Search_txtbox);
			enterText(GenericUploaderUIMap.Search_txtbox,"State");
			Thread.sleep(2000);
			clear(GenericUploaderUIMap.NewFeild_txtbox);
			enterText(GenericUploaderUIMap.NewFeild_txtbox,"Workitem State");

			clear(GenericUploaderUIMap.Search_txtbox);
			enterText(GenericUploaderUIMap.Search_txtbox,"Title");
			Thread.sleep(2000);
			clear(GenericUploaderUIMap.NewFeild_txtbox);
			enterText(GenericUploaderUIMap.NewFeild_txtbox,"Workitem Title");

			clear(GenericUploaderUIMap.Search_txtbox);
			enterText(GenericUploaderUIMap.Search_txtbox,"Project");
			Thread.sleep(2000);

			clear(GenericUploaderUIMap.NewFeild_txtbox);
			enterText(GenericUploaderUIMap.NewFeild_txtbox,"Workitem Project");

			singleClick(GenericUploaderUIMap.SaveAS_btn);
			ExpWaitForCondition(GenericUploaderUIMap.SavedSuccessfully_msg);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);

			}

			catch(Exception e)
			{
			grabScreenshotForExtentReport();
			e.printStackTrace();
			logger.info("Issue Editing the Template for entity "+dataentity+ " in generic uploader");
			Assert.fail("Issue Editing the Template for entity "+dataentity+ " in generic uploader");
			}
			}




			public static void UploadCustomTemplate(String dataentity, String toolname) {
			try {
			SoftAssert sa = new SoftAssert();
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clickJS(GenericUploaderUIMap.GoBack_btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);


			singleClick(GenericUploaderUIMap.Upload_Img);
			ExpWaitForCondition(GenericUploaderUIMap.Upload_btn);
			singleClick(GenericUploaderUIMap.SelectFile_btn);
			String ExcelFileLoc="";
			ExcelFileLoc = System.getProperty("user.dir")+File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator +"DataLoader" + File.separator +"GenericUploader" + File.separator + "ADTJira"+ File.separator +"Excel"+ File.separator + dataentity+".xlsx";
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
			}
			if(getText(GenericUploaderUIMap.StatusOfRecordUploaded_statictxt).contains("Complete"))
			{
			logger.info("The data provided for entity "+dataentity+" is Successfully Uploaded");
			sa.assertTrue(true,"The data provided for entity "+dataentity+" is Successfully Uploaded");

			}

			sa.assertAll();

			}
			catch(Exception e)
			{
			grabScreenshotForExtentReport();
			e.printStackTrace();
			logger.info("Issue Uploading the CustomTemplate for entity "+dataentity+ " in generic uploader");
			Assert.fail("Issue Uploading the CustomTemplate for entity "+dataentity+ " in generic uploader");
			}

			}
			
			public static void prepareExcelFilePathtoBeUploadedwithAssociations(String toolname, String dataload_type) {
				try {
				String ExcelToBePreparedwithAssociations="";
				String[] entities_NoToolInstance_GenericUploaderwithAssociations = {"Epic","Feature","Task","Bug","Issue","Impediment","Risk","Action","Decision","Iteration"};
				ExcelToBePreparedwithAssociations = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "Excel"+ File.separator ;
				if(toolname.equalsIgnoreCase("NoToolInstance"))
				{
				for(String entity:entities_NoToolInstance_GenericUploaderwithAssociations)
				{
				PrepareExcelFileForGenericUploaderwithAssociationsAndWriteEntityIDToJSON(entity,toolname);
				}
				}


				}
				catch(Exception e)
				{
				e.printStackTrace();
				grabScreenshotForExtentReport();
				logger.info("Issue uploading entity in generic uploader");
				Assert.fail("Issue uploading entity in generic uploader");
				}
				}
			
			//excel file with associations
			private static void PrepareExcelFileForGenericUploaderwithAssociationsAndWriteEntityIDToJSON(String entity,String toolname) {
			try{

			String Entities_JSONFile = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" + File.separator + "WorkItemExternalIDs.json";
			String Excelfilepath="";
			if(toolname.equalsIgnoreCase("ADT Jira") || toolname.equalsIgnoreCase("myWizardInstance"))
			Excelfilepath = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "GenericUploader"+ File.separator +"ADTJira" + File.separator +"Excel"+ File.separator + entity+".xlsx" ;
			else if(toolname.equalsIgnoreCase("NoToolInstance"))
			Excelfilepath = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "GenericUploader"+ File.separator +"NoTool" + File.separator +"Excel"+ File.separator + entity+".xlsx" ;
			FileInputStream fis = new FileInputStream(new File(Excelfilepath));
			XSSFWorkbook workbook = new XSSFWorkbook (fis);


			String workitemID="";
			String EntityIDForJSON="";
			XSSFSheet sheet = workbook.getSheet(entity);
			Random rnd = new Random();
			int randomNumb = 10000 + rnd.nextInt(90000);

			String title = entity+"_AutomationData_GenericUploader";
			String TeamArea_Id = entity+"Team";
			String TeamArea_Name = "Team_testing";
			String Iteration_ID = "Iteration_AutomationData";
			String Iteration_Name = "Iteration_AutomationData";
			String Release_ID = "Release_AutomationData";
			String Release_Name = "Release_AutomationData";
			String Linked_ID = "Epic_Testing";
			String LinkedID_Relationship = "Parent";

			if(toolname.equalsIgnoreCase("NoToolInstance"))
			{
			if(entity.equalsIgnoreCase("Epic") || entity.equalsIgnoreCase("Issue") || entity.equalsIgnoreCase("Feature") || entity.equalsIgnoreCase("Task"))
			{
			sheet.getRow(1).getCell(0).setCellValue(String.valueOf(randomNumb));
			sheet.getRow(1).getCell(2).setCellValue(title);
			sheet.getRow(1).getCell(30).setCellValue(TeamArea_Id);
			sheet.getRow(1).getCell(31).setCellValue(TeamArea_Name);
			sheet.getRow(1).getCell(32).setCellValue(Iteration_ID);
			sheet.getRow(1).getCell(33).setCellValue(Iteration_Name);
			sheet.getRow(1).getCell(34).setCellValue(Release_ID);
			sheet.getRow(1).getCell(35).setCellValue(Release_Name);
			sheet.getRow(1).getCell(36).setCellValue(Linked_ID);
			sheet.getRow(1).getCell(37).setCellValue(LinkedID_Relationship);
			}
			else if(entity.equalsIgnoreCase("Action")) {
			sheet.getRow(1).getCell(0).setCellValue(String.valueOf(randomNumb));
			sheet.getRow(1).getCell(2).setCellValue(title);
			sheet.getRow(1).getCell(28).setCellValue(TeamArea_Id);
			sheet.getRow(1).getCell(29).setCellValue(TeamArea_Name);
			sheet.getRow(1).getCell(32).setCellValue(Linked_ID);
			sheet.getRow(1).getCell(33).setCellValue(LinkedID_Relationship);
			}
			else if(entity.equalsIgnoreCase("Bug")) {
			sheet.getRow(1).getCell(0).setCellValue(String.valueOf(randomNumb));
			sheet.getRow(1).getCell(2).setCellValue(title);
			sheet.getRow(1).getCell(33).setCellValue(TeamArea_Id);
			sheet.getRow(1).getCell(34).setCellValue(TeamArea_Name);
			sheet.getRow(1).getCell(35).setCellValue(Iteration_ID);
			sheet.getRow(1).getCell(36).setCellValue(Iteration_Name);
			sheet.getRow(1).getCell(37).setCellValue(Release_ID);
			sheet.getRow(1).getCell(38).setCellValue(Release_Name);
			sheet.getRow(1).getCell(41).setCellValue(Linked_ID);
			sheet.getRow(1).getCell(42).setCellValue(LinkedID_Relationship);
			}

			else if(entity.equals("UserStory")) {
			sheet.getRow(1).getCell(0).setCellValue(String.valueOf(randomNumb));
			sheet.getRow(1).getCell(2).setCellValue(title);
			sheet.getRow(1).getCell(29).setCellValue(TeamArea_Id);
			sheet.getRow(1).getCell(30).setCellValue(TeamArea_Name);
			sheet.getRow(1).getCell(31).setCellValue(Iteration_ID);
			sheet.getRow(1).getCell(32).setCellValue(Iteration_Name);
			sheet.getRow(1).getCell(33).setCellValue(Release_ID);
			sheet.getRow(1).getCell(34).setCellValue(Release_Name);
			sheet.getRow(1).getCell(43).setCellValue(Linked_ID);
			sheet.getRow(1).getCell(44).setCellValue(LinkedID_Relationship);

			}
			else if(entity.equals("Impediment")) {
			sheet.getRow(1).getCell(0).setCellValue(String.valueOf(randomNumb));
			sheet.getRow(1).getCell(2).setCellValue(title);
			sheet.getRow(1).getCell(21).setCellValue(TeamArea_Id);
			sheet.getRow(1).getCell(22).setCellValue(TeamArea_Name);
			sheet.getRow(1).getCell(23).setCellValue(Iteration_ID);
			sheet.getRow(1).getCell(24).setCellValue(Iteration_Name);
			sheet.getRow(1).getCell(25).setCellValue(Release_ID);
			sheet.getRow(1).getCell(26).setCellValue(Release_Name);
			sheet.getRow(1).getCell(27).setCellValue(Linked_ID);
			sheet.getRow(1).getCell(28).setCellValue(LinkedID_Relationship);

			}

			}

			FileOutputStream fos = new FileOutputStream(new File(Excelfilepath));
			workbook.write(fos);
			fis.close();
			fos.close();


			}
			catch(Exception e)
			{
			grabScreenshotForExtentReport();
			e.printStackTrace();
			logger.info("Issue uploading entity in generic uploader");
			Assert.fail("Issue uploading entity in generic uploader");
			}
			}
	}

