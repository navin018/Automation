package testobjects;
import static org.testng.Assert.assertEquals;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import dataobjects.WorkItemDO;
import uiMap.TFSUIMap;
import utilities.general.DataManager;
import utilities.general.Property;

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
		
	public	static void CreateWorkitem(String workItem) throws IOException, InterruptedException, Exception {
		 WorkItemDO wi = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(workItem);
		 String workItem_sp []  = workItem.split("_");
			String workitemPath = Workitem_Img_path+workItem_sp[0].toLowerCase()+".png";
	try	{
		
		 Thread.sleep(3000);
		click(TFSUIMap.plusIcon_btn);
		Thread.sleep(2000);
		driver().manage().window().maximize();
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
				
//				e.printStackTrace();	
				try{
				Screen s = new Screen();
				Pattern newworkitem = new Pattern(Workitem_Img_path+"newworkitem.png");
				s.hover(newworkitem);
				Thread.sleep(2000);
				Pattern workitemImg = new Pattern(workitemPath);
				s.click(workitemImg);
				Thread.sleep(5000);
				System.out.println(wi.Summary);
				enterText(TFSUIMap.title_txtbox,wi.Summary);
				Thread.sleep(1000);
				click(TFSUIMap.save_drpdown);
				Thread.sleep(2000);
				click(TFSUIMap.save_btn);
				CaptureWorkitemID(workItem);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					logger.info("Issue creating workitem "+workItem);
				}
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
				logger.info("Problems with TFS project load");
				e.printStackTrace();
			}
			}
			
			
			public static void CaptureWorkitemID(String workitem) {
			try {
				String workitem_sp[] = workitem.split("_");
				switch(workitem_sp[0].toLowerCase()){
				
				case "bug":
				
						Baseclass.getInstance().WorkItemExternalId_Bug = getText(TFSUIMap.captureWorkItemID1_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "epic":
				
						Baseclass.getInstance().WorkItemExternalId_Epic =  getText(TFSUIMap.captureWorkItemID1_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "risk":
					
					Baseclass.getInstance().WorkItemExternalId_Risk =  getText(TFSUIMap.captureWorkItemID1_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//					click(TFSUIMap.close_btn);
					break;
				case "feature":
				
						Baseclass.getInstance().WorkItemExternalId_Feature =getText(TFSUIMap.captureWorkItemID1_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "issue":
				
						Baseclass.getInstance().WorkItemExternalId_Issue =getText(TFSUIMap.captureWorkItemID1_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "task":
				
						Baseclass.getInstance().WorkItemExternalId_Task =getText(TFSUIMap.captureWorkItemID1_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "story":
				case "user story":
				
						Baseclass.getInstance().WorkItemExternalId_Story =getText(TFSUIMap.captureWorkItemID1_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "testcase":
				
						Baseclass.getInstance().WorkItemExternalId_TestCase =getText(TFSUIMap.captureWorkItemID1_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "impediment":
				
						Baseclass.getInstance().WorkItemExternalId_Impediment =getText(TFSUIMap.captureWorkItemID1_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "productbacklog":
				
						Baseclass.getInstance().WorkItemExternalId_Story =getText(TFSUIMap.captureWorkItemID1_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "action":
					
					Baseclass.getInstance().WorkItemExternalId_Action =getText(TFSUIMap.captureWorkItemID1_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//					click(TFSUIMap.close_btn);
					break;
				case "decision":
					
					Baseclass.getInstance().WorkItemExternalId_Decision =getText(TFSUIMap.captureWorkItemID1_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//					click(TFSUIMap.close_btn);
					break;
				case "milestone":
					
					Baseclass.getInstance().WorkItemExternalId_Milestone =getText(TFSUIMap.captureWorkItemID1_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//					click(TFSUIMap.close_btn);
					break;
				case "requirement":
					
					Baseclass.getInstance().WorkItemExternalId_Requirement =getText(TFSUIMap.captureWorkItemID1_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//					click(TFSUIMap.close_btn);
					break;
				case "deliverable":
					
					Baseclass.getInstance().WorkItemExternalId_Deliverable =getText(TFSUIMap.captureWorkItemID1_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//					click(TFSUIMap.close_btn);
					break;
					
				case "changerequest":
					Baseclass.getInstance().WorkItemExternalId_WorkRequest =getText(TFSUIMap.captureWorkItemID1_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID1_statictxt));
//					click(TFSUIMap.close_btn);
					break;
				default:
			        throw new IllegalArgumentException("Invalid workitem: " + workitem);	
				}
				
				
			} catch (Exception e) {
				System.out.println("Issue with capturing workitem ID");
				e.printStackTrace();
			}
		}
			
			
			
		public static void ValidateOB(String appname) {
		try {
		
			String WorkItemEx_FileLoc = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON" +  File.separator  + "WorkItemExternalIDs.json";
			String Wk_OB = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON" +  File.separator  + "OB_Validation.json";
			
			JSONParser jsonParser = new JSONParser();
			
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(WorkItemEx_FileLoc));
			JSONObject jsonObject1 = (JSONObject) jsonParser.parse(new FileReader(Wk_OB));
			
			
			String[] TFSAgile_ItemsToVerify = {"Task", "Epic", "Feature", "Story", "Bug", "Issue", "Risk", "Deliverable", "Requirement", "Milestone","Action","Decision","TestCase","WorkRequest"};
			String[] TFSScrum_ItemsToVerify = {"Task", "Epic", "Feature", "Story", "Bug", "Issue", "Risk", "Impediment","Deliverable","Requirement","Milestone","Action","Decision","TestCase","WorkRequest"};
			
			SoftAssert sa = new SoftAssert();
			
			if(appname.equalsIgnoreCase("TFS Agile"))
				
			{
					
					for(String entity:TFSAgile_ItemsToVerify )
					{
						if((String) jsonObject.get("WorkItemExternalId_"+entity)!=null)
						{
							Thread.sleep(5000);
							String value = (String) jsonObject.get("WorkItemExternalId_"+entity);
							singleClick(TFSUIMap.SearchBoxHomePage_txtbox);
							ExpWaitForCondition(By.xpath("//div[text()='Recent work items']"));
							enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
							Thread.sleep(5000);
							ExpWaitForCondition(By.xpath("//div[text()='Work items']"));
//							if(CheckIfElementExists(By.xpath("//div[contains(text(),'No work item results found')]")))
//								enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
		//					assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Task_Title"));
							sa.assertEquals(getText(TFSUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get(entity+"_Title"));
							Thread.sleep(4000);
							doubleClick(TFSUIMap.SearchBoxHomePage_txtbox);
							sendBackSpace(TFSUIMap.SearchBoxHomePage_txtbox);
//							clear(JiraUIMap.SearchBoxHomePage_txtbox);
						}
						else 
						{
							throw new NullPointerException(entity+" value is null for app "+appname);
						}
					}
			
			}
			
	if(appname.equalsIgnoreCase("TFS Scrum"))
				
			{
					
					for(String entity:TFSScrum_ItemsToVerify )
					{
						if((String) jsonObject.get("WorkItemExternalId_"+entity)!=null)
						{
							
							Thread.sleep(5000);
							String value = (String) jsonObject.get("WorkItemExternalId_"+entity);
							singleClick(TFSUIMap.SearchBoxHomePage_txtbox);
							ExpWaitForCondition(By.xpath("//div[text()='Recent work items']"));
							enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
//							Thread.sleep(2000);
							ExpWaitForCondition(By.xpath("//div[text()='Work items']"));
//							if(CheckIfElementExists(By.xpath("//div[contains(text(),'No work item results found')]")))
//								enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
		//					assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Task_Title"));
							sa.assertEquals(getText(TFSUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get(entity+"_Title"));
							Thread.sleep(4000);
							doubleClick(TFSUIMap.SearchBoxHomePage_txtbox);
							sendBackSpace(TFSUIMap.SearchBoxHomePage_txtbox);
//							clear(JiraUIMap.SearchBoxHomePage_txtbox);
//							String value = (String) jsonObject.get("WorkItemExternalId_"+entity);
//							enterText(TFSUIMap.SearchBoxHomePage_txtbox,value);
//							Thread.sleep(2000);
//		//					assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Task_Title"));
//							sa.assertEquals(getText(TFSUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get(entity+"_Title"));
//							Thread.sleep(4000);
//							doubleClick(TFSUIMap.SearchBoxHomePage_txtbox);
//							sendBackSpace(TFSUIMap.SearchBoxHomePage_txtbox);
////							clear(JiraUIMap.SearchBoxHomePage_txtbox);
						}
						else 
						{
							throw new NullPointerException(entity+" value is null for app "+appname);
						}
					}
			
			}
			

				sa.assertAll();
				
		} catch (Exception e) {
			logger.info("Issue with OB validation for app "+appname);
			System.out.println("Issue with OB validation for app"+appname);
			e.printStackTrace();
		}
	finally{
		driver().close();
	}
			
		}
		
		public static void CreateReleaseAndSprint(String Release,String Sprint){
			try {
			Thread.sleep(4000);
			click(TFSUIMap.settingsIcon_Img);
			Thread.sleep(4000);
			if(!CheckIfElementExists(TFSUIMap.ProjectConfiguration_link))
			{	
			click(TFSUIMap.settingsIcon_Img);
			Thread.sleep(10000);
			}
			ExpWaitForCondition(TFSUIMap.ProjectConfiguration_link);
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
			enterText(TFSUIMap.StartDate_txtbox,wi_release.ReleaseStartDate);
			enterText(TFSUIMap.EndDate_txtbox,wi_release.ReleaseEndDate);
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
			Baseclass.getInstance().TFS_ReleaseStartDate= wi_release.ReleaseStartDate;
			Baseclass.getInstance().TFS_ReleaseEndDate = wi_release.ReleaseEndDate;
			Baseclass.getInstance().TFS_SprintName = newSprintwithAppendedNumb;
			Baseclass.getInstance().TFS_SprintStartDate = wi_sprint.StartDate;
			Baseclass.getInstance().TFS_SprintEndDate = wi_sprint.EndDate;
											
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("Issue creating release/sprint");
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

		public static void CreateWorkitem1(String workitem) {
			try{
				 WorkItemDO wi = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(workitem);
//			String currentproject_sp[] = driver().getCurrentUrl().split(Property.getProperty("TFS_URL")+"/");
//			String currentproject = currentproject_sp[1];
				 String workitemURL;
				if(workitem.contains("TestCase")) 
			 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"Test Case";
				else if(workitem.contains("Story"))
			 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"User Story";
				else if(workitem.contains("ChangeRequest"))
					 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"Change Request";
				else if(workitem.contains("ProductBacklog"))
					 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"Product Backlog Item";
				else
				workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+workitem.split("_")[0];
			driver().get(workitemURL);
			Thread.sleep(5000);
			//putting this piece of code as workitem url wasnt loading
			if(CheckIfElementExists(TFSUIMap.title_txtbox))
			{
				Thread.sleep(5000);
				ExpWaitForCondition(TFSUIMap.title_txtbox);
				enterText(TFSUIMap.title_txtbox,wi.Summary);
				Thread.sleep(2000);
				singleClick(TFSUIMap.save_btn);
				Thread.sleep(5000);
				CaptureWorkitemID(workitem);
			}
			else if(CheckIfElementExists(TFSUIMap.title_txtbox))
			{
				Thread.sleep(5000);
				ExpWaitForCondition(TFSUIMap.title_txtbox);
				enterText(TFSUIMap.title_txtbox,wi.Summary);
				Thread.sleep(2000);
				singleClick(TFSUIMap.save_btn);
				Thread.sleep(5000);
				CaptureWorkitemID(workitem);
			}
			else
				{
				driver().get(workitemURL);
				Thread.sleep(5000);
				}
			if(!CheckIfElementExists(TFSUIMap.title_txtbox))
			{
				logger.info("page not loading for workitem "+workitem);
			}
			waitPageToLoad();
			
			
//			Thread.sleep(4000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		public static void CreateTestResult(String workitem) {
			try{
				
				clickJS(TFSUIMap.TestPlan_link);
				ExpWaitForCondition(TFSUIMap.ALlTestPlan_link);
				clickJS(TFSUIMap.ALlTestPlan_link);
				ExpWaitForCondition(TFSUIMap.NewTestPlan_link);
				clickJS(TFSUIMap.NewTestPlan_link);
				Thread.sleep(5000);
				int randomNumbForTestPlan = 1000 + new Random().nextInt(9000);
				Baseclass.getInstance().WorkItemExternalId_TestPlan= "TestPlan"+randomNumbForTestPlan;
				enterText(TFSUIMap.TestPlanName_txtbox,"TestPlan"+randomNumbForTestPlan);
				Thread.sleep(5000);
				clickJS(TFSUIMap.CreateTestPlan_btn);
				Thread.sleep(5000);
				clickJS(TFSUIMap.NewTestCase_btn);
				Thread.sleep(5000);
				Baseclass.getInstance().WorkItemExternalId_TestCase_TE = "TestCase"+randomNumbForTestPlan;
				
				enterText(TFSUIMap.TestCaseTitle_txtbox,"TestCase"+randomNumbForTestPlan);
				Thread.sleep(5000);
				clickJS(TFSUIMap.SaveAndClose_btn);
				Thread.sleep(5000);
				clickJS(TFSUIMap.ExecuteTestCase_link);
				clickJS(TFSUIMap.SelectTestCase_chkbox);
				
				
				Thread.sleep(3000);
				click(prepareWebElementWithDynamicXpath(TFSUIMap.createdTest_txt, "TestCase"+randomNumbForTestPlan , "TCName"));
				clickJS(TFSUIMap.More_link);
				Thread.sleep(3000);
				
				clickJS(TFSUIMap.MarkOutcome_link);
				Thread.sleep(5000);
				singleClick(TFSUIMap.Passtest_link);

				click(prepareWebElementWithDynamicXpath(TFSUIMap.createdTest_txt, "TestCase"+randomNumbForTestPlan , "TCName"));
				clickJS(TFSUIMap.More_link);
				Thread.sleep(3000);
				clickJS(TFSUIMap.ViewTestResult_link);
				Thread.sleep(5000);
//				String winHandleBefore = driver().getWindowHandle();
				for(String winHandle : driver().getWindowHandles()){
				    driver().switchTo().window(winHandle);
				}
				String urltogetTestResult = driver().getCurrentUrl();
				String testid = urltogetTestResult.split("resultId=")[1];
				String runid = urltogetTestResult.split("resultSummary&runId=")[1].split("&")[0];
				Baseclass.getInstance().RunID = runid;
				Baseclass.getInstance().WorkItemExternalId_TestExecution=testid+"-"+runid;
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Issue creating Test Result in TFS");
			}
		}

		public static void CreateWorkitemforWSJFfunctionality(String workitem) {
			try{
			 WorkItemDO wi = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(workitem);
			 String workitemURL;
			 //navigate to the create WI url
			 if(workitem.contains("TestCase")) 
				 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"Test Case";
					else if(workitem.contains("Story"))
				 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"User Story";
					else if(workitem.contains("ProductBacklog"))
						 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"Product Backlog Item";
					else
					workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+workitem.split("_")[0];
			 
			 driver().get(workitemURL);
				Thread.sleep(5000);
				
				//enter title
				//putting this piece of code as workitem url wasnt loading
				if(CheckIfElementExists(TFSUIMap.title_txtbox))
				{
					Thread.sleep(5000);
					ExpWaitForCondition(TFSUIMap.title_txtbox);
					enterText(TFSUIMap.title_txtbox,wi.Summary);
					Thread.sleep(2000);
				}
				
				if(workitem.contains("ProductBacklog")){
					doubleClick(TFSUIMap.Priority_drpdown);
					clear(TFSUIMap.Priority_drpdown);
					enterText(TFSUIMap.Priority_drpdown,wi.Priority);
					enterText(TFSUIMap.BusinessValue_txtbox, wi.BusinessValue);
					enterText(TFSUIMap.RiskReduction_txtbox, wi.RiskReduction);
					enterText(TFSUIMap.StoryPoints_txtbox, wi.StoryPoints);
				}
				
				//save WI and capture details
				singleClick(TFSUIMap.save_btn);
				Thread.sleep(5000);
				CaptureWorkitemID(workitem);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue creating "+workitem+" in TFS");
			}
		}

		public static void openworkitem(String workitem) {
			try{
				ExpWaitForCondition(TFSUIMap.SearchBoxHomePage_txtbox);
			 String WorkItemExternalId = Tools.getWorkItemExternalID(workitem.split("_")[0],"TFS");
			 Thread.sleep(3000);
			 clearEnterText(TFSUIMap.SearchBoxHomePage_txtbox, WorkItemExternalId);
//			 enterText(TFSUIMap.SearchBoxHomePage_txtbox, WorkItemExternalId);
			 ExpWaitForCondition(prepareWebElementWithDynamicXpath(TFSUIMap.workitemIDInSearch_txt, WorkItemExternalId, "workitemid"));
			 clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.workitemIDInSearch_txt, WorkItemExternalId, "workitemid"));
			 ExpWaitForCondition(TFSUIMap.captureWorkItemID1_statictxt);
		}
			catch(Exception e)
			{
				e.printStackTrace();
				Assert.fail("issue opening workitem in TFS");
				}
			}

		public static void changeStatus(String status) throws InterruptedException {
		clearEnterText(TFSUIMap.State_drpdown, status);
//			sendEsc();
//			clickJS(TFSUIMap.title_txtbox);
			Thread.sleep(3000);
			singleClick(TFSUIMap.saveandclose_btn);
		}

		public static void deleteworkitem() {
		ExpWaitForCondition(TFSUIMap.ActionWorkitem_btn);
			clickJS(TFSUIMap.ActionWorkitem_btn);
			clickJS(TFSUIMap.DeleteWorkitem_btn);
			ExpWaitForCondition(TFSUIMap.ConfirmDeleteWorkitem_PopUp);
			clickJS(TFSUIMap.DeleteWorkitem_btn);
		}

		public static void DeleteReleaseSprint() {
			try{
			click(TFSUIMap.settingsIcon_Img);
			Thread.sleep(4000);
			if(!CheckIfElementExists(TFSUIMap.ProjectConfiguration_link))
			{	
			click(TFSUIMap.settingsIcon_Img);
			Thread.sleep(10000);
			}
			ExpWaitForCondition(TFSUIMap.ProjectConfiguration_link);
			click(TFSUIMap.ProjectConfiguration_link);
			Thread.sleep(4000);
			ExpWaitForCondition(TFSUIMap.NewChild_link);
			HashMap<String,String> ReleaseSrpintDetails = Tools.getReleaseAndSprintDetails("TFS");
			String ReleaseName = ReleaseSrpintDetails.get("ReleaseName");
			String SprintName = ReleaseSrpintDetails.get("SprintName");
//			HoverUsingAction(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseOrSprintAction_btn, ReleaseName, "ReleaseOrSprintName"));
			clickJS(By.xpath("//div[text()='TFS Agile1_ Client-Native']//preceding::span[@class='grid-context-menu-icon bowtie-icon bowtie-ellipsis'][1]"));
//			sendCtrlPlusPageDown();
//			ScrollToEndOfPage();
			driver().findElement(By.xpath("//div[text()='Iterations']//following::div[text()='TFS Agile1_ Client-Native'][1]")).sendKeys(Keys.chord(Keys.CONTROL, Keys.PAGE_DOWN));
//			Scroll1();
//			ScrollIntoView(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseOrSprintAction_btn, ReleaseName, "ReleaseOrSprintName"));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		  public static void scrollToElement(int x, int y) {

		        JavascriptExecutor javScriptExecutor = (JavascriptExecutor) driver();

		        javScriptExecutor.executeScript("window.scrollBy(" + x + ", " + y + ");");

		    }

		public static void changeProjectOrIssueTypeofWorkitem(String ProjectOrEntityType, String workitemFrom, String toolname, String workitemTo) {
			try{
				if(ProjectOrEntityType.equalsIgnoreCase("entitytype")){
				clickJS(TFSUIMap.ActionWorkitem_btn);
				clickJS(TFSUIMap.ChangeEntityType_link);
				enterText(TFSUIMap.EntityTypeTo_txtbox,workitemTo);
				sendEnter(TFSUIMap.EntityTypeTo_txtbox);
				Thread.sleep(2000);
				clickJS(TFSUIMap.Ok_btn);
				Thread.sleep(2000);
				clickJS(TFSUIMap.save_drpdown);
				clickJS(TFSUIMap.save_btn);
				CaptureWorkitemID(workitemTo);
				}
				if(ProjectOrEntityType.equalsIgnoreCase("project")){
					clickJS(TFSUIMap.ActionWorkitem_btn);
					clickJS(TFSUIMap.ChangeProject_link);
					enterText(TFSUIMap.ChangeProjectTo_txtbox, Property.getProperty("TFSProject_ChangeProject"));
					Thread.sleep(2000);
					clickJS(TFSUIMap.Ok_btn);
					Thread.sleep(2000);
					clickJS(TFSUIMap.save_drpdown);
					clickJS(TFSUIMap.save_btn);
					CaptureWorkitemID(workitemFrom);
					}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}

		public static void CreateWorkitemAndAssociateReleaseSprint(String workitem) {
			try{
				 WorkItemDO wi = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(workitem);
//			String currentproject_sp[] = driver().getCurrentUrl().split(Property.getProperty("TFS_URL")+"/");
//			String currentproject = currentproject_sp[1];
				 String workitemURL;
				if(workitem.contains("TestCase")) 
			 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"Test Case";
				else if(workitem.contains("Story"))
			 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"User Story";
				else if(workitem.contains("ProductBacklog"))
					 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"Product Backlog Item";
				else
				workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+workitem.split("_")[0];
			driver().get(workitemURL);
			Thread.sleep(5000);
			//putting this piece of code as workitem url wasnt loading
			if(CheckIfElementExists(TFSUIMap.title_txtbox))
			{
				Thread.sleep(5000);
				ExpWaitForCondition(TFSUIMap.title_txtbox);
				enterText(TFSUIMap.title_txtbox,wi.Summary);
				Thread.sleep(2000);
				AssociateReleaseAndSprint(workitem);
				singleClick(TFSUIMap.save_btn);
				Thread.sleep(5000);
				CaptureWorkitemID(workitem);
			}
			else if(CheckIfElementExists(TFSUIMap.title_txtbox))
			{
				Thread.sleep(5000);
				ExpWaitForCondition(TFSUIMap.title_txtbox);
				enterText(TFSUIMap.title_txtbox,wi.Summary);
				Thread.sleep(2000);
				singleClick(TFSUIMap.save_btn);
				Thread.sleep(5000);
				CaptureWorkitemID(workitem);
			}
			else
				{
				driver().get(workitemURL);
				Thread.sleep(5000);
				}
			if(!CheckIfElementExists(TFSUIMap.title_txtbox))
			{
				logger.info("page not loading for workitem "+workitem);
			}
			waitPageToLoad();
			
			
//			Thread.sleep(4000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}

		private static void AssociateReleaseAndSprint(String workitem) {
			try{
			HashMap<String,String> sprintandreleasedetails = Tools.getReleaseAndSprintDetails("TFS");
			String releasename = sprintandreleasedetails.get("ReleaseName");
			String sprintname = sprintandreleasedetails.get("SprintName");
			Thread.sleep(5000);
			click(TFSUIMap.Iteration_label);
			Thread.sleep(2000);
			sendBackSpace(TFSUIMap.Iteration_drpdown);
			Thread.sleep(2000);
			enterText(TFSUIMap.Iteration_drpdown, Property.getProperty("TFSProject")+"\\"+ releasename +"\\"+ sprintname);
			sendEnter(TFSUIMap.Iteration_drpdown);
			Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	
		
	}

	