package testobjects;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import static utilities.selenium.SeleniumDSL.*;
import static utilities.general.Property.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import dataobjects.WorkItemDO;
import dataobjects.WorkItemExternalIDDO;
import testobjects.Baseclass;
import uiMap.JiraUIMap;
import uiMap.TFSUIMap;
import utilities.general.DataManager;
import utilities.general.Property;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

	public class TFSWorkitem extends Baseclass{
		private Baseclass base;
	
		public TFSWorkitem()
		{
			
		}
		
		public TFSWorkitem(Baseclass base) {
			this.base =base; 
		}
		
		public static String Workitem_Img_path = System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "Workitem_Img" + File.separator;
		
		public static String testDataPath = System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON" + File.separator ;
		
	public	static void CreateWorkitem(String workItem) {
		
	try	{
		 WorkItemDO wi = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(workItem);
		 
		 String workItem_sp []  = workItem.split("_");
		String workitemPath = Workitem_Img_path+workItem_sp[0].toLowerCase()+".jpg";
		click(TFSUIMap.plusIcon_btn);
		Thread.sleep(2000);
		Screen s = new Screen();
		Pattern workitemImg = new Pattern(workitemPath);
		s.click(workitemImg);
		System.out.println(wi.Summary);
		enterText(TFSUIMap.title_txtbox,wi.Summary);
		Thread.sleep(1000);
		click(TFSUIMap.save_drpdown);
		Thread.sleep(2000);
		click(TFSUIMap.save_btn);
		CaptureWorkitemID(workItem);
		}
			catch(Exception e) {
				e.printStackTrace();	
				
				}
			
		}
	
	
		

		
		
		public static void SelectProject() {
			try {
				
				waitPageToLoad();
				enterText(TFSUIMap.searchProject_txtbox,Property.getProperty("TFSProject"));
				waitPageToLoad();
				Thread.sleep(5000);
				
				prepareWebElementWithDynamicXpathAndClickJS(TFSUIMap.clickProject_statictxt,Property.getProperty("TFSProject"),"projectname");
				waitPageToLoad();
				Thread.sleep(2000);
//				assertTrue(driver().findElements(prepareWebElementWithDynamicXpath(TFSUIMap.VerifyProjectload_statictxt,Property.getProperty("TFSProject"),"projectname")).size()!=0);			
				
			} catch (Exception e) {
				System.out.println("Problems with TFS project load");
				e.printStackTrace();
			}
			}
			
			
			public static void CaptureWorkitemID(String workitem) {
			try {
				String workitem_sp[] = workitem.split("_");
				switch(workitem_sp[0].toLowerCase()){
				
				case "bug":
				
						Baseclass.getInstance().WorkItemExternalId_Bug = getText(TFSUIMap.captureWorkItemID_statictxt);
						click(TFSUIMap.close_btn);
						break;
				case "epic":
				
						Baseclass.getInstance().WorkItemExternalId_Epic =  getText(TFSUIMap.captureWorkItemID_statictxt);
						click(TFSUIMap.close_btn);
						break;
				case "feature":
				
						Baseclass.getInstance().WorkItemExternalId_Feature =getText(TFSUIMap.captureWorkItemID_statictxt);
						click(TFSUIMap.close_btn);
						break;
				case "issue":
				
						Baseclass.getInstance().WorkItemExternalId_Issue =getText(TFSUIMap.captureWorkItemID_statictxt);
						click(TFSUIMap.close_btn);
						break;
				case "task":
				
						Baseclass.getInstance().WorkItemExternalId_Task =getText(TFSUIMap.captureWorkItemID_statictxt);
						click(TFSUIMap.close_btn);
						break;
				case "story":
				
						Baseclass.getInstance().WorkItemExternalId_Story =getText(TFSUIMap.captureWorkItemID_statictxt);
						click(TFSUIMap.close_btn);
						break;
				case "testcase":
				
						Baseclass.getInstance().WorkItemExternalId_TestCase =getText(TFSUIMap.captureWorkItemID_statictxt);
						click(TFSUIMap.close_btn);
						break;
				case "impediment":
				
						Baseclass.getInstance().WorkItemExternalId_Impediment =getText(TFSUIMap.captureWorkItemID_statictxt);
						click(TFSUIMap.close_btn);
						break;
				case "productbacklog":
				
						Baseclass.getInstance().WorkItemExternalId_ProductBacklog =getText(TFSUIMap.captureWorkItemID_statictxt);
						click(TFSUIMap.close_btn);
						break;
				default:
			        throw new IllegalArgumentException("Invalid workitem: " + workitem);	
				}
				
				
			} catch (Exception e) {
				System.out.println("Issue with capturing workitem ID");
				e.printStackTrace();
			}
		}
			
			
			
		public static void ValidateOB() {
		try {
			
			String WorkItemEx_FileLoc = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON" +  File.separator  + "WorkItemExternalIDs.json";
			String Wk_OB = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON" +  File.separator  + "OB_Validation.json";
			
			JSONParser jsonParser = new JSONParser();
			
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(WorkItemEx_FileLoc));
			JSONObject jsonObject1 = (JSONObject) jsonParser.parse(new FileReader(Wk_OB));
			
			if((String.valueOf(jsonObject.get("WorkItemExternalId_Task")))!=null)
			{
				String value = (String.valueOf(jsonObject.get("WorkItemExternalId_Task")));
				enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
				Thread.sleep(2000);
				waitPageToLoad();			
				ExpWaitForCondition(TFSUIMap.WorkItemtxt_static);
				assertEquals(getText(TFSUIMap.WorkitemTitleSearch_statictxt),(String) jsonObject1.get("Task_Title"));
				clear(TFSUIMap.SearchBoxHomePage_txtbox);
			}
			else 
			{
				throw new NullPointerException("Task value is null");
			}
			if((String.valueOf(jsonObject.get("WorkItemExternalId_Bug")))!=null)
			{
				String value = (String.valueOf(jsonObject.get("WorkItemExternalId_Bug")));
				enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
				Thread.sleep(2000);
				waitPageToLoad();			
				ExpWaitForCondition(TFSUIMap.WorkItemtxt_static);
				assertEquals(getText(TFSUIMap.WorkitemTitleSearch_statictxt),(String) jsonObject1.get("Bug_Title"));
				clear(TFSUIMap.SearchBoxHomePage_txtbox);
			}
			else 
			{
				throw new NullPointerException("Bug value is null");
			}
			if((String.valueOf(jsonObject.get("WorkItemExternalId_Epic")))!=null)
			{
				String value = (String.valueOf(jsonObject.get("WorkItemExternalId_Epic")));
				enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
				Thread.sleep(2000);
				waitPageToLoad();			
				ExpWaitForCondition(TFSUIMap.WorkItemtxt_static);
				assertEquals(getText(TFSUIMap.WorkitemTitleSearch_statictxt),(String) jsonObject1.get("Epic_Title"));
				clear(TFSUIMap.SearchBoxHomePage_txtbox);
			}
			else 
			{
				throw new NullPointerException("Epic value is null");
			}
			if((String.valueOf(jsonObject.get("WorkItemExternalId_Feature")))!=null)
			{
				String value = (String.valueOf(jsonObject.get("WorkItemExternalId_Feature")));
				enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
				Thread.sleep(2000);
				waitPageToLoad();			
				ExpWaitForCondition(TFSUIMap.WorkItemtxt_static);
				assertEquals(getText(TFSUIMap.WorkitemTitleSearch_statictxt),(String) jsonObject1.get("Feature_Title"));
				clear(TFSUIMap.SearchBoxHomePage_txtbox);
			}
			else 
			{
				throw new NullPointerException("Feature value is null");
			}
			if((String.valueOf(jsonObject.get("WorkItemExternalId_Issue")))!=null)
			{
				String value = (String.valueOf(jsonObject.get("WorkItemExternalId_Issue")));
				enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
				Thread.sleep(2000);
				waitPageToLoad();			
				ExpWaitForCondition(TFSUIMap.WorkItemtxt_static);
				assertEquals(getText(TFSUIMap.WorkitemTitleSearch_statictxt),(String) jsonObject1.get("Issue_Title"));
				clear(TFSUIMap.SearchBoxHomePage_txtbox);
			}
			else 
			{
				throw new NullPointerException("Issue value is null");
			}
			if((String.valueOf(jsonObject.get("WorkItemExternalId_TestCase")))!=null)
			{
				String value = (String.valueOf(jsonObject.get("WorkItemExternalId_TestCase")));
				enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
				Thread.sleep(2000);
				waitPageToLoad();			
				ExpWaitForCondition(TFSUIMap.WorkItemtxt_static);
				assertEquals(getText(TFSUIMap.WorkitemTitleSearch_statictxt),(String) jsonObject1.get("TestCase_Title"));
				clear(TFSUIMap.SearchBoxHomePage_txtbox);
			}
			else 
			{
				throw new NullPointerException("TestCase value is null");
			}
			if((String.valueOf(jsonObject.get("WorkItemExternalId_Story")))!=null)
			{
				String value = (String.valueOf(jsonObject.get("WorkItemExternalId_Story")));
				enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
				Thread.sleep(2000);
				waitPageToLoad();			
				ExpWaitForCondition(TFSUIMap.WorkItemtxt_static);
				assertEquals(getText(TFSUIMap.WorkitemTitleSearch_statictxt),(String) jsonObject1.get("Story_Title"));
				clear(TFSUIMap.SearchBoxHomePage_txtbox);
			}
			else 
			{
				throw new NullPointerException("Story value is null");
			}
			if((String.valueOf(jsonObject.get("WorkItemExternalId_Impediment")))!=null)
			{
				String value = (String.valueOf(jsonObject.get("WorkItemExternalId_Impediment")));
				enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
				Thread.sleep(2000);
				waitPageToLoad();			
				ExpWaitForCondition(TFSUIMap.WorkItemtxt_static);
				assertEquals(getText(TFSUIMap.WorkitemTitleSearch_statictxt),(String) jsonObject1.get("Impediment_Title"));
				clear(TFSUIMap.SearchBoxHomePage_txtbox);
			}
			else 
			{
				throw new NullPointerException("Impediment value is null");
			}
			if((String.valueOf(jsonObject.get("WorkItemExternalId_ProductBacklog")))!=null)
			{
				String value = (String.valueOf(jsonObject.get("WorkItemExternalId_ProductBacklog")));
				enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
				Thread.sleep(2000);
				waitPageToLoad();			
				ExpWaitForCondition(TFSUIMap.WorkItemtxt_static);
				assertEquals(getText(TFSUIMap.WorkitemTitleSearch_statictxt),(String) jsonObject1.get("ProductBacklog_Title"));
				clear(TFSUIMap.SearchBoxHomePage_txtbox);
			}
			else 
			{
				throw new NullPointerException("ProductBacklog value is null");
			}
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		}
		
		public static void CreateReleaseAndSprint(String Release,String Sprint){
			try {
			
			click(TFSUIMap.settingsIcon_Img);
			click(TFSUIMap.ProjectConfiguration_link);
			Thread.sleep(4000);
			ExpWaitForCondition(TFSUIMap.NewChild_link);
			click(TFSUIMap.NewChild_link);
	 
				WorkItemDO wi_release = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(Release);
				WorkItemDO wi_sprint = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(Sprint);
			
				Random rnd = new Random();
				int randomNumbForRelease = 1000 + rnd.nextInt(9000);	
			//enter release data
			String newReleasewithAppendedNumb = wi_release.IterationName+randomNumbForRelease;
			clear(TFSUIMap.IterationName_txtbox);
			enterText(TFSUIMap.IterationName_txtbox,newReleasewithAppendedNumb);
			enterText(TFSUIMap.StartDate_txtbox,wi_release.StartDate);
			enterText(TFSUIMap.EndDate_txtbox,wi_release.EndDate);
			click(TFSUIMap.saveAndClose_btn);
			
			//enter sprint data
			Thread.sleep(3000);
			move(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseRow_statictxt,newReleasewithAppendedNumb,"releasename"));
			click(prepareWebElementWithDynamicXpath(TFSUIMap.newSprint_statictxt,newReleasewithAppendedNumb,"releasename"));
			click(TFSUIMap.NewChild_link);
			clear(TFSUIMap.IterationName_txtbox);
			int randomNumbForSprint = 1000 + rnd.nextInt(9000);	
			String newSprintwithAppendedNumb = wi_sprint.IterationName+randomNumbForSprint;
			enterText(TFSUIMap.IterationName_txtbox,newSprintwithAppendedNumb);
			enterText(TFSUIMap.StartDate_txtbox,wi_sprint.StartDate);
			enterText(TFSUIMap.EndDate_txtbox,wi_sprint.EndDate);
			click(TFSUIMap.saveAndClose_btn);
			
			Baseclass.getInstance().TFS_ReleaseName = newReleasewithAppendedNumb;
			Baseclass.getInstance().TFS_ReleaseStartDate= wi_release.StartDate;
			Baseclass.getInstance().TFS_ReleaseEndDate = wi_release.EndDate;
			Baseclass.getInstance().TFS_SprintName = newSprintwithAppendedNumb;
			Baseclass.getInstance().TFS_SprintStartDate = wi_sprint.StartDate;
			Baseclass.getInstance().TFS_SprintEndDate = wi_sprint.EndDate;
											
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		
		public static void DeleteTestAutomationData(String queryname){
			try{
			clickJS(TFSUIMap.Boards_link);
			clickJS(TFSUIMap.Queries_link);
			Thread.sleep(2000);
			if(isVisible(prepareWebElementWithDynamicXpath(TFSUIMap.DeletionQuery_link, queryname, "queryname")))
			{
				click(prepareWebElementWithDynamicXpath(TFSUIMap.DeletionQuery_link, queryname, "queryname"));
				ExpWaitForCondition(TFSUIMap.QueryExecutionComplete);
				ControlPlusAllAndDelete();
				Thread.sleep(3000);
				click(TFSUIMap.DeleteAutomationData_Btn);
				Thread.sleep(2000);
				ExpWaitForCondition(TFSUIMap.QueryExecuted_txt);
			
			}
			else
				Assert.fail("The query to be deleted doesnt exist");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Assert.fail("issues with deleting test automation data");
			}
	}
		public static void updateWorkItemExternalIDFile(String proj){
			try{
				String ProjName = Property.getProperty("TFSProject");
				String workitemfilepath_input = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON" +  File.separator + ProjName+"_"+"WorkItemExternalIDs.json";
				String workitemfilepath_output = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs.json";	
					FileInputStream instream = new FileInputStream(new File(workitemfilepath_input));
					FileOutputStream outstream = new FileOutputStream(new File(workitemfilepath_output));
					byte[] buffer = new byte[1024];
		    	    int length;
		    	    while ((length = instream.read(buffer)) > 0){
		    	    	outstream.write(buffer, 0, length);
		    	    }
		    	    instream.close();
		    	    outstream.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					Assert.fail("issues with copying data of existing workitems or file not found");
				}
			}
		
		public static void VerifyReleaseAndSprintFromRMP(String appname)
		{
			try{
				String RMP_Data = System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator
						+ "resources" + File.separator + "testdata" + File.separator + "RMP" + File.separator + "JSON" +  File.separator + "ReleaseAndSprintDetails.json";
				
				JSONParser parser = new JSONParser();
				 Object obj = parser.parse(new FileReader(RMP_Data));
				 JSONObject jsonObject = (JSONObject)obj;
				 String ReleaseName = (String) jsonObject.get("ReleaseName");
				 
				click(TFSUIMap.settingsIcon_Img);
				click(TFSUIMap.ProjectConfiguration_link);
				Thread.sleep(4000);
				ExpWaitForCondition(TFSUIMap.NewChild_link);
				
				//release flown validation
				if(CheckIfElementExists(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseORSprintNamefromRMP_statictxt, ReleaseName, "releasenameORsprintname")))
				 {
					
					assertEquals(getText(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseORSprintNamefromRMP_statictxt, ReleaseName, "releasenameORsprintname")), ReleaseName);
					
					SimpleDateFormat dFormat = new SimpleDateFormat("M/d/yyyy");
					SimpleDateFormat dFormatRequired = new SimpleDateFormat("MM/dd/YYYY");
					
					String ReleaseStartDatefromJSON = (String) jsonObject.get("ReleaseStartDate");
					 String ReleaseEndDatefromJSON = (String) jsonObject.get("ReleaseEndDate");
					String releaseStartDatefromUI = getText(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseORSprintStartDatefromRMP_statictxt,ReleaseName,"releasenameORsprintname"));
					String releaseEndDatefromUI = getText(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseORSprintEndDatefromRMP_statictxt,ReleaseName,"releasenameORsprintname"));
					
					String ReleaseStartDateInRequiredFormat= dFormatRequired.format(dFormat.parse(releaseStartDatefromUI));
					assertEquals(ReleaseStartDateInRequiredFormat, ReleaseStartDatefromJSON);
					String ReleaseEndDateInRequiredFormat= dFormatRequired.format(dFormat.parse(releaseEndDatefromUI));
					assertEquals(ReleaseEndDateInRequiredFormat, ReleaseEndDatefromJSON);
					
					
					
				 }
				else
					Assert.fail("Release not flown from RMP to TFS");
				 
				//release flown validation
				if(CheckIfElementExists(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseORSprintNamefromRMP_statictxt, ReleaseName, "releasenameORsprintname")))
				 {
					
					assertEquals(getText(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseORSprintNamefromRMP_statictxt, ReleaseName, "releasenameORsprintname")), ReleaseName);
					
					SimpleDateFormat dFormat = new SimpleDateFormat("M/d/yyyy");
					SimpleDateFormat dFormatRequired = new SimpleDateFormat("MM/dd/YYYY");
					
					String ReleaseStartDatefromJSON = (String) jsonObject.get("ReleaseStartDate");
					 String ReleaseEndDatefromJSON = (String) jsonObject.get("ReleaseEndDate");
					String releaseStartDatefromUI = getText(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseORSprintStartDatefromRMP_statictxt,ReleaseName,"releasenameORsprintname"));
					String releaseEndDatefromUI = getText(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseORSprintEndDatefromRMP_statictxt,ReleaseName,"releasenameORsprintname"));
					
					String ReleaseStartDateInRequiredFormat= dFormatRequired.format(dFormat.parse(releaseStartDatefromUI));
					assertEquals(ReleaseStartDateInRequiredFormat, ReleaseStartDatefromJSON);
					String ReleaseEndDateInRequiredFormat= dFormatRequired.format(dFormat.parse(releaseEndDatefromUI));
					assertEquals(ReleaseEndDateInRequiredFormat, ReleaseEndDatefromJSON);
					
					
					
				 }
				else
					Assert.fail("Release not flown from RMP to TFS");
				
				//Sprint validation
				String SprintName = (String) jsonObject.get("SprintName");
				if(CheckIfElementExists(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseORSprintNamefromRMP_statictxt, SprintName, "releasenameORsprintname")))
				 {
					
					assertEquals(getText(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseORSprintNamefromRMP_statictxt, SprintName, "releasenameORsprintname")), SprintName);
					
					SimpleDateFormat dFormat = new SimpleDateFormat("M/d/yyyy");
					SimpleDateFormat dFormatRequired = new SimpleDateFormat("MM/dd/YYYY");
					
					String SprintStartDatefromJSON = (String) jsonObject.get("SprintStartDate");
					 String SprintEndDatefromJSON = (String) jsonObject.get("SprintEndDate");
					String SprintStartDatefromUI = getText(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseORSprintStartDatefromRMP_statictxt,SprintName,"releasenameORsprintname"));
					String SprintEndDatefromUI = getText(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseORSprintEndDatefromRMP_statictxt,SprintName,"releasenameORsprintname"));
					
					String SprintStartDateInRequiredFormat= dFormatRequired.format(dFormat.parse(SprintStartDatefromUI));
					assertEquals(SprintStartDateInRequiredFormat, SprintStartDatefromJSON);
					String SprintEndDateInRequiredFormat= dFormatRequired.format(dFormat.parse(SprintEndDatefromUI));
					assertEquals(SprintEndDateInRequiredFormat, SprintEndDatefromJSON);
					driver().close();
					driver().quit();
					
					
				 }
				else
					Assert.fail("Sprint not flown from RMP to TFS");
			
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Assert.fail("Issue verifying release and sprint for TFS");
			}
			
		}
	}

	