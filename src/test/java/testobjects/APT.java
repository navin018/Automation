package testobjects;

import static org.testng.Assert.assertTrue;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Instant;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import uiMap.GenericUploaderUIMap;
import uiMap.MyWizardUIMap;
import utilities.general.Property;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import groovyjarjarantlr4.v4.codegen.model.ExceptionClause;
public class APT {
	
	
	public static void selectClientAndDC(String client, String dC_L1, String dC_L2,String dC_L3) {
		try{
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			boolean clientalreadyselected=false;
			boolean DC_L1_Selected=false;
			boolean DC_L2_Selected=false;
			boolean DC_L3_Selected=false;
			if(getAttribute(MyWizardUIMap.scopeSelector_drpdown, "title").contains(client))
			{
				clientalreadyselected=true;
				if(getAttribute(MyWizardUIMap.scopeSelector_drpdown, "title").contains(dC_L1))
					DC_L1_Selected=true;
				if(getAttribute(MyWizardUIMap.scopeSelector_drpdown, "title").contains(dC_L1))
					DC_L2_Selected=true;
				if(getAttribute(MyWizardUIMap.scopeSelector_drpdown, "title").contains(dC_L3))
					DC_L3_Selected=true;
			}
			
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 clickJS(MyWizardUIMap.scopeSelector_drpdown);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 enterText(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox,client);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 Thread.sleep(2000);
			 if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt,client,"clientname")))
			 { 
				 if(!clientalreadyselected)
				 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt,client,"clientname"));
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//				 clear(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox);
			 }
			 else
			 Assert.fail("Mentioned client "+client+"doesnt exists");
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			waitPageToLoad();
//			if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt,DC,"dcname")))
			if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt,dC_L1,"dcname")))
			{
				if(!DC_L2_Selected)
				clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt,dC_L1,"dcname"));
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			}
			else
				 Assert.fail("Mentioned client "+dC_L1+"doesnt exists");
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 if(!dC_L2.equalsIgnoreCase("NA"))
			 {
				 if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectProgram_statictxt,dC_L2,"programname")))
					 if(!DC_L2_Selected)
				 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectProgram_statictxt,dC_L2,"programname"));
//				clickJS(prepareWebElementWithDynamicXpath2(MyWizardUIMap.SelectProgram_statictxt,DC,Program,"dcname","programname"));
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 }
			 
			 if(!dC_L3.equalsIgnoreCase("NA"))
			 {
				 if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectProject_statictxt,dC_L2,"project")))
					 if(!DC_L3_Selected)
				 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectProject_statictxt,dC_L2,"project"));
//				clickJS(prepareWebElementWithDynamicXpath2(MyWizardUIMap.SelectProgram_statictxt,DC,Program,"dcname","programname"));
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 }
		
			waitPageToLoad();
			click(MyWizardUIMap.apply_btn);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue selecting client or DC");
			Assert.fail("Issue selecting client or DC");
		}
		
	}
	
	
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


		public static void prepareexceldata(String createOrUpdate, int numberofrecords, String entity, String client,
				String dC_L1, String dC_L2, String dC_L3) {
			if(createOrUpdate.equalsIgnoreCase("Create"))
			{
				clonesheetforentity(entity,client,dC_L1,dC_L2,dC_L3);
				prepareexcelsheetfortheentity(entity,numberofrecords,client,dC_L1,dC_L2,dC_L3);
			
			}
			else if(createOrUpdate.equalsIgnoreCase("update"))
			{
				updateexcelsheetforentitiy(entity,numberofrecords,client,dC_L1,dC_L2,dC_L3);
			}
			
		}


		private static void updateexcelsheetforentitiy(String entity, int numberofrecords, String client, String dC_L1,
				String dC_L2,String dC_L3) {
			try{
					String filenameofclonedcopy = entity+"&"+client+"&"+dC_L1+"&"+dC_L2+"&"+dC_L3;
					String Excelfilepath = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "GenericUploader"+ File.separator +"APT" + File.separator + filenameofclonedcopy+".xlsx" ;
					FileInputStream fis = new FileInputStream(new File(Excelfilepath));
					XSSFWorkbook workbook = new XSSFWorkbook (fis);
					XSSFSheet sheet = workbook.getSheetAt(2);
					String description = "APT_GenericUploaderTest_Description";
					switch(entity){			
					case("Task"):
						for(int i=1;i<(numberofrecords/2)+1;i++)
						{
							sheet.getRow(i).getCell(3).setCellValue(String.valueOf(description));	
						}
						for(int j=(numberofrecords/2)+1;j<numberofrecords+1;j++)
						{
							sheet.getRow(j).getCell(13).setCellValue("Active");
						}
						break;
					case("Action"):
						for(int i=1;i<(numberofrecords/2)+1;i++)
						{
							sheet.getRow(i).getCell(3).setCellValue(String.valueOf(description));
						}
					for(int j=(numberofrecords/2)+1;j<numberofrecords+1;j++)
					{
						sheet.getRow(j).getCell(18).setCellValue("Active");
					}
						break;
					case("Decision"):
						for(int i=1;i<(numberofrecords/2)+1;i++)
						{
							sheet.getRow(i).getCell(3).setCellValue(String.valueOf(description));
						}
						for(int j=(numberofrecords/2)+1;j<numberofrecords+1;j++)
						{
							sheet.getRow(j).getCell(18).setCellValue("Active");
						}
						break;
					case("Bug"):
						for(int i=1;i<(numberofrecords/2)+1;i++)
						{
							sheet.getRow(i).getCell(3).setCellValue(String.valueOf(description));	
						}
						for(int j=(numberofrecords/2)+1;j<numberofrecords+1;j++)
						{
							sheet.getRow(j).getCell(13).setCellValue("Active");
						}
						break;
					case("UserStory"):
						for(int i=1;i<(numberofrecords/2)+1;i++)
						{
							sheet.getRow(i).getCell(3).setCellValue(String.valueOf(description));	
						}
						for(int j=(numberofrecords/2)+1;j<numberofrecords+1;j++)
						{
							sheet.getRow(j).getCell(13).setCellValue("Active");
						}
						break;
					}
					FileOutputStream fos1 = new FileOutputStream(new File(Excelfilepath));
					workbook.write(fos1);
					fis.close();
				    fos1.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}


		private static void prepareexcelsheetfortheentity(String entity, int numberofrecords, String client, String dC_L1, String dC_L2, String dC_L3) {
			try{
					String filenameofclonedcopy = entity+"&"+client+"&"+dC_L1+"&"+dC_L2+"&"+dC_L3;
					String Excelfilepath = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "GenericUploader"+ File.separator +"APT" + File.separator + filenameofclonedcopy+".xlsx" ;
					FileInputStream fis = new FileInputStream(new File(Excelfilepath));
					XSSFWorkbook workbook = new XSSFWorkbook (fis);
					XSSFSheet sheet = workbook.getSheetAt(2);
					String title = "APT_GenericUploaderTest";
//					XSSFCellStyle cellstyle= sheet.getRow(1).getRowStyle();
					
					
					for(int i=1;i<numberofrecords+1;i++)
					{
						Random rnd = new Random();
						int randomNumb = 10000 + rnd.nextInt(90000);
					
						sheet.getRow(i).getCell(0).setCellValue(String.valueOf(randomNumb));
						sheet.getRow(i).getCell(2).setCellValue(title);
					}
					FileOutputStream fos1 = new FileOutputStream(new File(Excelfilepath));
					workbook.write(fos1);
					fis.close();
				    fos1.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}


		public static void clonesheetforentity(String entity, String client, String dC_L1, String dC_L2,String dC_L3) {
			try{
				String Excelfilepathwhosecopytobecreated=System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "GenericUploader"+ File.separator +"APT" + File.separator + entity+".xlsx" ;
				String filenameofclonedcopy = entity+"&"+client+"&"+dC_L1+"&"+dC_L2+"&"+dC_L3;
				String ClonedCopyExcelFilePath=System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "GenericUploader"+ File.separator +"APT" + File.separator + filenameofclonedcopy+".xlsx" ;
			FileInputStream excelFile = new FileInputStream(new File(Excelfilepathwhosecopytobecreated));
		    Workbook workbook = new XSSFWorkbook(excelFile);
		    FileOutputStream outputStream = new FileOutputStream(ClonedCopyExcelFilePath);
		    workbook.write(outputStream);
		    excelFile.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}


		public static void UploadFileForGenericUploader(String entity, String client, String dC_L1, String dC_L2,String dC_L3) {
			try{
				
				selectByPartOfVisibleText(GenericUploaderUIMap.DataEntity_drpdown, entity);
				
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				singleClick(GenericUploaderUIMap.DataMappingTemplate_drpdown);
				Thread.sleep(2000);
				clickJS(GenericUploaderUIMap.DataMappingTemplateOption_drpdown);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				singleClick(GenericUploaderUIMap.Upload_Img);
				ExpWaitForCondition(GenericUploaderUIMap.Upload_btn);
				singleClick(GenericUploaderUIMap.SelectFile_btn);
				String filetobeuploaded = entity+"&"+client+"&"+dC_L1+"&"+dC_L2+"&"+dC_L3;
				String ExcelFileLoc = System.getProperty("user.dir")+File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator +"DataLoader" + File.separator +"GenericUploader" +File.separator+ "APT"+ File.separator + filetobeuploaded+".xlsx";
				String AutoITFileloc = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator +"AutoIT" + File.separator ;
				
				String autoITExecutable = AutoITFileloc+"UploadFile_DataLoader.exe " +ExcelFileLoc;
				Process process = Runtime.getRuntime().exec(autoITExecutable);
				process.waitFor();
				Thread.sleep(5000);
				clickJS(GenericUploaderUIMap.Upload_btn);
			   //wait for a minute
				Thread.sleep(60000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					 Assert.fail("Issue uploading entity "+entity+ " in generic uploader");
				}
	}
}
