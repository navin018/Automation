package testobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import static utilities.selenium.SeleniumDSL.*;
import static utilities.general.Property.*;
import static utilities.reporting.LogUtil.logger;

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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import dataobjects.WorkItemDO;
import dataobjects.WorkItemExternalIDDO;
//import javassist.bytecode.stackmap.BasicBlock.Catch;
import testobjects.Baseclass;
import uiMap.JiraUIMap;

import utilities.general.DataManager;
import utilities.general.Property;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
import java.io.FileReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

	public class JiraWorkitem extends Baseclass{
		private Baseclass base;
	
		public JiraWorkitem()
		{
			
		}
		
		public JiraWorkitem(Baseclass base) {
			this.base =base; 
		}
		
		public static String testDataPath = System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" +  File.separator;
		
		 public static String workitem_title;
	public	static void CreateWorkitem(String workItem) {
		
			try	{
				 WorkItemDO wi = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(workItem);
				 workitem_title = wi.Summary;
				ExpWaitForCondition(JiraUIMap.Summary_txtBox);
				Thread.sleep(3000);
				 enterTextUsingAction(JiraUIMap.Summary_txtBox,wi.Summary);
				 
				 Thread.sleep(1000);
				
			
				 
				String workItemSplit[] = workItem.split("_");
				switch(workItemSplit[0]){

				case "risk":
				case "Risk":
					if(Property.getProperty("JiraURL").contains("uat.alm.accenture"))
					{
//						
						 switchFrame(JiraUIMap.Description_iFrame);
						enterText(JiraUIMap.Description_txtBox,wi.Description);
						Thread.sleep(1000);
						 driver().switchTo().defaultContent();
						selectDropdownByText(JiraUIMap.Probability_dropdown, wi.Probability);
						selectDropdownByText(JiraUIMap.Impact_dropdown, wi.Probability);
						enterText(JiraUIMap.TargetResolutionDate_txtBox,wi.TargetResolutionDate);
						enterText(JiraUIMap.NextReviewDate_txtBox,wi.NextReviewDate);
					}
					break;
				case "issue":
				case "Issue":
					if(Property.getProperty("JiraURL").contains("uat.alm.accenture"))
					{
						 switchFrame(JiraUIMap.Description_iFrame);
						 enterText(JiraUIMap.Description_txtBox,wi.Description);
						 Thread.sleep(1000);
						 driver().switchTo().defaultContent();
						 selectDropdownByText(JiraUIMap.Impact_dropdown,wi.Impact);
						enterText(JiraUIMap.TargetResolutionDate_txtBox,wi.TargetResolutionDate);
						enterText(JiraUIMap.NextReviewDate_txtBox,wi.NextReviewDate);
					}
					break;
				case "story":
				case "Story":
//					enterText(JiraUIMap.StoryPoints_txtbox, wi.StoryPoints);
					Thread.sleep(1000);
					break;
				case "epic":
				case "Epic":
					if(!Property.getProperty("JiraURL").contains("jira4phoenixmywiz"))
					{
					Thread.sleep(5000);
					clickJS(JiraUIMap.EpicName_txtBox);
					enterTextUsingAction(JiraUIMap.EpicName_txtBox, wi.EpicName);
					Thread.sleep(1000);
					}
					break;
					
				}
				
				click(JiraUIMap.Create_btn);
//				ExpWaitForElementToDisappear(JiraUIMap.Create_btn);
//				grabScreenshotForExtentReport();
//				 Thread.sleep(10000);
//				 ExpWaitForElementToDisappear(JiraUIMap.CreateDisabled_btn);
//				 waitPageToLoad();
				
				}
			catch(Exception e) {
				e.printStackTrace();
				grabScreenshotForExtentReport();
				logger.info("Issue creating workitem "+workItem + " for the given tool");
//				Assert.fail("Issue creating workitem "+workItem + " for the given tool");
				Baseclass.getInstance().workitemcreation_fail = true;
				}
			
		}
	
	
		

		public static void SelectWorkItemtype(String workitem) {
			try {
			String workitem_type[] =workitem.split("_");
				waitPageToLoad();
				doubleClick(JiraUIMap.CreateWokitem_dropdown);
				Thread.sleep(1000);
				sendBackSpace(JiraUIMap.CreateWokitem_dropdown);
				Thread.sleep(2000);
				enterText(JiraUIMap.CreateWokitem_dropdown,workitem_type[0]);
				sendEnter(JiraUIMap.CreateWokitem_dropdown);
				waitPageToLoad();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("issue selecting the "+workitem+" for the given tool");
				Baseclass.getInstance().workitemcreation_fail = true;
//				Assert.fail("issue selecting the "+workitem+" for the given tool");
			}
		
			
		}
		
		public static void SelectProject() {
			try {
				Thread.sleep(2000);
				waitPageToLoad();
				click(JiraUIMap.Project_link);
				click(JiraUIMap.ViewAllProject_link);
			
//				
				ExpWaitForCondition(JiraUIMap.SearchBoxAllPorjects_txtbox);
				doubleClick(JiraUIMap.SearchBoxAllPorjects_txtbox);
				Thread.sleep(2000);
//				enterText(JiraUIMap.SearchBoxAllPorjects_txtbox, Property.getProperty("JiraProject"));
				enterTextUsingAction(JiraUIMap.SearchBoxAllPorjects_txtbox, Property.getProperty("JiraProject"));
				Thread.sleep(5000);
				Assert.assertEquals(getText(JiraUIMap.ProjectKey_Statictxt), Property.getProperty("JiraProject"),"Entered project "+Property.getProperty("JiraProject")+ " not found");
					click(JiraUIMap.ProjectToSelect_Statictxt);

				waitPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("Issue selecting the project for the given tool");
				Assert.fail("Issue selecting the project for the given tool");
			}
			}
			
			
			public static void CaptureWorkitemID(String workitem) {
			try {
				
				String workitem_type[] =workitem.split("_");
				if(workitem_type[0].contains("Feature") && Property.getProperty("JiraURL").contains("uat.alm.accenture"))
					enterText(JiraUIMap.SearchBoxHomePage_txtbox,"Feature");
				else if(workitem_type[0].equalsIgnoreCase("TestForTestExec"))
					enterText(JiraUIMap.SearchBoxHomePage_txtbox,"Test");
				else
					enterText(JiraUIMap.SearchBoxHomePage_txtbox,workitem_type[0]);
				Thread.sleep(5000);
				//if finding the workitems fails, try this part
				//--------------------------------------------
				Thread.sleep(5000);
				if(!CheckIfElementExists(JiraUIMap.WorkItemExternalID_txt)){
					doubleClick(JiraUIMap.SearchBoxHomePage_txtbox);
					Thread.sleep(1000);
					sendBackSpace(JiraUIMap.SearchBoxHomePage_txtbox);
					doubleClick(JiraUIMap.SearchBoxHomePage_txtbox);
					sendBackSpace(JiraUIMap.SearchBoxHomePage_txtbox);
					if(workitem_type[0].contains("Feature") && Property.getProperty("JiraURL").contains("uat.alm.accenture"))
						enterText(JiraUIMap.SearchBoxHomePage_txtbox,"Feature");
					else if(workitem_type[0].equalsIgnoreCase("TestForTestExec"))
						enterText(JiraUIMap.SearchBoxHomePage_txtbox,"Test");
					else
						enterText(JiraUIMap.SearchBoxHomePage_txtbox,workitem_type[0]);
					Thread.sleep(5000);
				}
				//---------------------------------------------
				ExpWaitForCondition(JiraUIMap.WorkItemExternalID_txt);
				String toGetID = getAttribute(JiraUIMap.WorkItemExternalID_txt,"href");
				
				String toGetID1[] = toGetID.split("browse/");
				
//				ExpWaitForCondition((By.xpath("//a[@class='js-issue-link']"))); 
//				String toGetID = getText(By.xpath("//a[@class='js-issue-link']"));
				

//				ExpWaitForCondition((By.xpath("//a[@class='issue-created-key issue-link' || @class='js-issue-link']"))); 
//				String splittogetID = getText(By.xpath("//a[@class='issue-created-key issue-link' ||  @class='js-issue-link']"));
//				String[] splittogetID1 = splittogetID.split(" ");
//				String toGetID = splittogetID1[1];
				switch(workitem_type[0]){
				
				case "task":
				case "Task":
				Baseclass.getInstance().WorkItemExternalId_Task = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "story":
				case "Story":
				Baseclass.getInstance().WorkItemExternalId_Story = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "risk":
				case "Risk":
				Baseclass.getInstance().WorkItemExternalId_Risk = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "issue":
				case "Issue":
				Baseclass.getInstance().WorkItemExternalId_Issue = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "bug":
				case "Bug":
				Baseclass.getInstance().WorkItemExternalId_Bug = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "feature":
				case "Feature":
				Baseclass.getInstance().WorkItemExternalId_Feature = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				case "new feature":
				case "New Feature":
				Baseclass.getInstance().WorkItemExternalId_Feature = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "impediment":
				case "Impediment":
				Baseclass.getInstance().WorkItemExternalId_Impediment = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "deliverable":
				case "Deliverable":
				Baseclass.getInstance().WorkItemExternalId_Deliverable = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "requirement":
				case "Requirement":
				Baseclass.getInstance().WorkItemExternalId_Requirement = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "test":
				case "Test":
				Baseclass.getInstance().WorkItemExternalId_Test = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "TestForTestExec":
				case "testForTestExec":
				Baseclass.getInstance().WorkItemExternalId_TestExecution = Baseclass.getInstance().WorkItemExternalId_TestExecution+"_"+toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				
				break;
				case "epic":
				case "Epic":
				Baseclass.getInstance().WorkItemExternalId_Epic = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "subtask":
				case "SubTask":
				Baseclass.getInstance().WorkItemExternalId_SubTask = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "Milestone":
				case "milestone":
				Baseclass.getInstance().WorkItemExternalId_Milestone = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "Action":
				case "action":
				Baseclass.getInstance().WorkItemExternalId_Action = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				break;
				case "test execution":
				case "Test Execution":
				Baseclass.getInstance().WorkItemExternalId_TestExecution = toGetID1[1];
				System.out.println("Created "+workitem_type[0]+" ID is "+toGetID1[1]);
				sendBackSpace(JiraUIMap.SearchBoxHomePage_txtbox);
				doubleClick(JiraUIMap.SearchBoxHomePage_txtbox);
				sendBackSpace(JiraUIMap.SearchBoxHomePage_txtbox);
				break;
				default:
			        throw new IllegalArgumentException("Invalid workitem: " + workitem_type[0]);	
				}
				doubleClick(JiraUIMap.SearchBoxHomePage_txtbox);
				Thread.sleep(1000);
				sendBackSpace(JiraUIMap.SearchBoxHomePage_txtbox);
				doubleClick(JiraUIMap.SearchBoxHomePage_txtbox);
				sendBackSpace(JiraUIMap.SearchBoxHomePage_txtbox);
				Thread.sleep(3000);
				
			} catch (Exception e) {
		
				e.printStackTrace();
				logger.info("Issue capturing workitem details for "+workitem+ " for the given tool");
//				Assert.fail("Issue capturing workitem details for "+workitem+ " for the given tool");
				Baseclass.getInstance().workitemcreation_fail = true;
			}
		}
			
			
			public static void CaptureWorkitemIDForCloudJira(String workitem) {
				try {
					
					String workitem_type[] =workitem.split("_");
//					if(workitem_type[0].contains("Feature") && Property.getProperty("JiraURL").contains("uat.alm.accenture"))
//						enterText(JiraUIMap.SearchBoxHomePage_txtbox,"Feature");
					ExpWaitForCondition(JiraUIMap.CloudJiraGetIssueID_statictxt);
					String workitemID = getText(JiraUIMap.CloudJiraGetIssueID_statictxt);
					
					
					switch(workitem_type[0]){
					
					case "task":
					case "Task":
					Baseclass.getInstance().WorkItemExternalId_Task = workitemID;
					System.out.println("Created "+workitem+" ID is "+workitemID);
					break;
					case "story":
					case "Story":
					Baseclass.getInstance().WorkItemExternalId_Story = workitemID;
					System.out.println("Created "+workitem+" ID is "+workitemID);
					break;
					
					case "bug":
					case "Bug":
					Baseclass.getInstance().WorkItemExternalId_Bug = workitemID;
					System.out.println("Created "+workitem+" ID is "+workitemID);
					break;
					
					case "epic":
					case "Epic":
					Baseclass.getInstance().WorkItemExternalId_Epic = workitemID;
					System.out.println("Created "+workitem+" ID is "+workitemID);
					break;
					
				
					default:
				        throw new IllegalArgumentException("Invalid workitem: " + workitem_type[0]);	
					}
					
				} catch (Exception e) {
			
					e.printStackTrace();
					logger.info("Issue capturing workitem details for "+workitem+ " for the given tool");
//					Assert.fail("Issue capturing workitem details for "+workitem+ " for the given tool");
					Baseclass.getInstance().workitemcreation_fail = true;
				}
			}
			
			public static void CreateRelease(String ReleaseOrSprint) {
				try {
					Random rnd = new Random();
					WorkItemDO wii = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(ReleaseOrSprint);
					
					//generate random dates(sprint start date and end date) and release name
					int randomNumbForRelease = 1000 + rnd.nextInt(9000);
					String newReleasewithAppendedNumb = wii.ReleaseName+randomNumbForRelease;
					int randomNumbForSrpint = 100 + rnd.nextInt(900);
					
//					release
						if(ReleaseOrSprint.contains("Release"))
						{
							waitPageToLoad();
							clickJS(JiraUIMap.Releases_Link);
							ExpWaitForCondition(JiraUIMap.ReleaseVersionName_txtBox);
							waitPageToLoad();
							Thread.sleep(3000);
							if(CheckIfElementExists(JiraUIMap.ReleaseVersionName_txtBox))
							{
							enterText(JiraUIMap.ReleaseVersionName_txtBox,newReleasewithAppendedNumb);
							enterText(JiraUIMap.ReleaseStartDate_txtBox,wii.ReleaseStartDate);
							enterText(JiraUIMap.ReleaseEndDate_txtBox,wii.ReleaseEndDate);
							clickJS(JiraUIMap.AddRelease_btn);
							waitPageToLoad();
							Baseclass.getInstance().Jira_ReleaseName =newReleasewithAppendedNumb;
							Baseclass.getInstance().Jira_ReleaseStartDate= wii.ReleaseStartDate;
							Baseclass.getInstance().Jira_ReleaseEndDate = wii.ReleaseEndDate;
							}
							else 
								System.out.println("Provision to add new release not present for project "+Property.getProperty("JiraProject"));
						}
						else if(ReleaseOrSprint.contains("Sprint"))
						{
							clickJS(JiraUIMap.BacklogIcon_Img);
							Thread.sleep(10000);
							ExpWaitForCondition(JiraUIMap.ActiveSprint_Img);
//							String SprintName = getAttribute(JiraUIMap.SprintName_Statictxt, "data-fieldvalue");]
							clickJS(JiraUIMap.EditSprintDots_button);
							clickJS(JiraUIMap.EditSprint_link);
							ExpWaitForCondition(JiraUIMap.SprintName_txt);
							
//							clickJS(By.xpath("//a[@class='aui-button js-sprint-actions-trigger'][1]/span[1]"));
//							clickJS(JiraUIMap.SprintName_Statictxt);
//							Thread.sleep(2000);
							ClearTextAndEnterData("Sprint"+randomNumbForSrpint);
							Thread.sleep(4000);
//							clickJS(JiraUIMap.SaveSprint_btn);
//							click(JiraUIMap.BacklogIcon_Img);
							Baseclass.getInstance().Jira_SprintName = "Sprint"+randomNumbForSrpint;
						}
	
				} 
				
				catch (Exception e) {
					e.printStackTrace();
					logger.info("Issues in creating release or sprint");
					Assert.fail("Issues in creating release or sprint");
				}
				}
			
		public static void ValidateOB(String appname) {
		try {
			String WorkItemEx_FileLoc="";
			String Wk_OB;
			
			WorkItemEx_FileLoc = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" +  File.separator  + "WorkItemExternalIDs.json";
			Wk_OB = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" +  File.separator  + "OB_Validation.json";
			
			JSONParser jsonParser = new JSONParser();
			
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(WorkItemEx_FileLoc));
			JSONObject jsonObject1 = (JSONObject) jsonParser.parse(new FileReader(Wk_OB));
			
			SoftAssert sa = new SoftAssert();
			String[] ADTJIRA_ItemsToVerify = {"Task", "Epic", "Feature", "Story", "Bug", "Impediment", "Issue", "Risk", "Test", "Deliverable", "Requirement", "Milestone","Action"};
			String[] ADOPJira_ItemsToVerify = {"Task", "Epic", "Feature", "Story", "Bug", "Impediment", "Issue", "Risk"};
		
			if(appname.equalsIgnoreCase("ADT Jira"))
				
			{
					
					for(String entity:ADTJIRA_ItemsToVerify )
					{
						if((String) jsonObject.get("WorkItemExternalId_"+entity)!=null)
						{
							String value = (String) jsonObject.get("WorkItemExternalId_"+entity);
							enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
							Thread.sleep(2000);
		//					assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Task_Title"));
							sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get(entity+"_Title"));
							clear(JiraUIMap.SearchBoxHomePage_txtbox);
						}
						else 
						{
							throw new NullPointerException(entity+" value is null for app "+appname);
						}
					}
			
			}
			
			if(appname.equalsIgnoreCase("ADOP Jira"))
							
						{
								
								for(String entity:ADOPJira_ItemsToVerify )
								{
									if((String) jsonObject.get("WorkItemExternalId_"+entity)!=null)
									{
										String value = (String) jsonObject.get("WorkItemExternalId_"+entity);
										enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
										Thread.sleep(2000);
					//					assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Task_Title"));
										sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get(entity+"_Title"));
										clear(JiraUIMap.SearchBoxHomePage_txtbox);
									}
									else 
									{
										throw new NullPointerException(entity+" value is null for app "+appname);
									}
								}
						
						}
			
			
//			if((String) jsonObject.get("WorkItemExternalId_Task")!=null)
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_Task");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(2000);
////				assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Task_Title"));
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Task_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
//			else 
//			{
//				throw new NullPointerException("Task value is null");
//			}
//			
//			if((String) jsonObject.get("WorkItemExternalId_Impediment")!=null)
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_Impediment");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(1000);
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Impediment_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
//			else 
//			{
//				throw new NullPointerException("Impediment value is null");
//			}
//			if((String) jsonObject.get("WorkItemExternalId_Story")!=null)
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_Story");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(1000);
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Story_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
//			else 
//			{
//				throw new NullPointerException("Story value is null");
//			}
//			if((String) jsonObject.get("WorkItemExternalId_Epic")!=null)
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_Epic");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(1000);
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Epic_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
//			else 
//			{
//				throw new NullPointerException("Epic value is null");
//			}
//			
//			if((String) jsonObject.get("WorkItemExternalId_Risk")!=null)
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_Risk");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(1000);
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Risk_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
//			else 
//			{
//				throw new NullPointerException("Risk value is null");
//			}
//			
//			if((String) jsonObject.get("WorkItemExternalId_Bug")!=null)
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_Bug");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(1000);
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Bug_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
//			else 
//			{
//				throw new NullPointerException("Bug value is null");
//			}
//			if((String) jsonObject.get("WorkItemExternalId_Issue")!=null)
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_Issue");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(1000);
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Issue_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
//			else 
//			{
//				throw new NullPointerException("Issue value is null");
//			}
//			if((String) jsonObject.get("WorkItemExternalId_Feature")!=null)
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_Feature");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(1000);
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Feature_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
//			else 
//			{
//				throw new NullPointerException("Feature value is null");
//			}	
//			if((String) jsonObject.get("WorkItemExternalId_Requirement")!=null)
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_Requirement");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(1000);
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Requirement_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
//			else 
//			{
//				throw new NullPointerException("Requirement value is null");
//			}	
//			
//			if((String) jsonObject.get("WorkItemExternalId_Action")!=null)
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_Action");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(1000);
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Action_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
//			else 
//			{
//				throw new NullPointerException("Action value is null");
//			}	
//			if((String) jsonObject.get("WorkItemExternalId_Milestone")!=null)
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_Milestone");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(1000);
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Milestone_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
//			else 
//			{
//				throw new NullPointerException("Milestone value is null");
//			}	
//			
//			if((String) jsonObject.get("WorkItemExternalId_Test")!=null)
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_Test");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(1000);
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Test_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
//			else 
//			{
//				throw new NullPointerException("Test value is null");
//			}	
//			if((String) jsonObject.get("WorkItemExternalId_Deliverable")!=null && !Property.getProperty("JiraURL").contains("adt"))
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_Deliverable");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(1000);
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("Deliverable_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
//			
//			if((String) jsonObject.get("WorkItemExternalId_SubTask")!=null && !Property.getProperty("JiraURL").contains("adt"))
//			{
//				String value = (String) jsonObject.get("WorkItemExternalId_SubTask");
//				enterText(JiraUIMap.SearchBoxHomePage_txtbox,value);
//				Thread.sleep(1000);
//				sa.assertEquals(getText(JiraUIMap.WorkItemExternalIDTitle_txt), (String) jsonObject1.get("SubTask_Title"));
//				clear(JiraUIMap.SearchBoxHomePage_txtbox);
//			}
			
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

		public static void DeleteTestAutomationData(){
			try{
				
				Thread.sleep(4000);
//				click(JiraUIMap.Issues_link);
				click(JiraUIMap.ViewALlIssuesAndFilters_link);
				clear(JiraUIMap.advancedSearch_txtbox);
				String createQuery = "project = "+Property.getProperty("JiraProject")+" AND summary ~ \"_AutomationData\" AND summary !~ \"AutomationData_Donot_Edit\"";
				enterText(JiraUIMap.advancedSearch_txtbox, createQuery);
				click(JiraUIMap.Search_btn);
				ExpWaitForCondition(JiraUIMap.SaveAsEnabaledPostSearchResult_btn);
				click(JiraUIMap.Tools_drpdown);
				click(JiraUIMap.allIssues_drpdown);
				ExpWaitForCondition(JiraUIMap.ChooseIssues_Statictxt);
				click(JiraUIMap.BulkEdit_checkbox);
				click(JiraUIMap.NextBtnDeleteData_btn);
				ExpWaitForCondition(JiraUIMap.ChooseOperations_Statictxt);
				click(JiraUIMap.DeleteIssues_btn);
				click(JiraUIMap.NextBtnChooseOpsScreen_btn);
				ExpWaitForCondition(JiraUIMap.Operationsdetails_Statictxt);
				click(JiraUIMap.UncheckSendEmail_chkbox);
				click(JiraUIMap.NextBtnChooseOpsScreen_btn);
				ExpWaitForCondition(JiraUIMap.ConfirmationScreen_Statictxt);
				click(JiraUIMap.ConfirmDelete_btn);
				ExpWaitForCondition(JiraUIMap.DataDeletedConfirmationMsg_statictxt);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Issues deleting test automation data ");
				Assert.fail("Issues deleting test automation data ");
			}
			
			
		}
		
		public static void updateWorkItemExternalIDFile(String appname){
		try{
			String ProjName = Property.getProperty("JiraProject");
			String workitemfilepath_input = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + appname + File.separator + "JSON" +  File.separator + ProjName+"_"+"WorkItemExternalIDs.json";
			String workitemfilepath_output = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + appname + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs.json";	
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
			}
		}
		
	
	public static void VerifyReleaseAndSprintFromRMP(String AppName)
	{
		try{
			String RMP_Data = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator + "RMP" + File.separator + "JSON" +  File.separator + "ReleaseAndSprintDetails.json";
			JSONParser parser = new JSONParser();
			 Object obj = parser.parse(new FileReader(RMP_Data));
			 JSONObject jsonObject = (JSONObject)obj;
			 String ReleaseName = (String) jsonObject.get("ReleaseName");
			 click(JiraUIMap.Releases_Link);
			 ExpWaitForCondition(JiraUIMap.SearchReleases_txtbox);
			 waitPageToLoad();
			 enterText(JiraUIMap.SearchReleases_txtbox,ReleaseName);
			 
				SimpleDateFormat dFormat = new SimpleDateFormat("dd/MMM/yy");
				SimpleDateFormat dFormatRequired = new SimpleDateFormat("MM/dd/YYYY");
				
				
				 //release start date and end date check
			 if(getText(JiraUIMap.SearchedReleaseName_txt) == ReleaseName)
			 {
			
				Date Sdate = dFormat.parse(getText(JiraUIMap.SearchedReleaseStartDate_txt));
				String ReleaseStartdateInRequiredFormat = dFormatRequired.format(Sdate);
				assertEquals(ReleaseStartdateInRequiredFormat,(String) jsonObject.get("ReleaseStartDate"));
		
				Date Edate = dFormat.parse(getText(JiraUIMap.SearchedReleaseEndDate_txt));
				String ReleaseEnddateInRequiredFormat = dFormatRequired.format(Edate);
				assertEquals(ReleaseEnddateInRequiredFormat,(String) jsonObject.get("ReleaseEndDate"));
			 }
			 else
				 Assert.fail("Release not flown from RMP to Jira");
				 
				//Sprint validation
				click(JiraUIMap.BacklogIcon_Img);
				Thread.sleep(10000);
				ExpWaitForCondition(JiraUIMap.ActiveSprint_Img);
			
				if(CheckIfElementExists(prepareWebElementWithDynamicXpath(JiraUIMap.SprintNameFromRMP_statictxt,(String) jsonObject.get("SprintName"),"sprintname")))
					{
					
					String SprintStartDate = getAttribute(prepareWebElementWithDynamicXpath(JiraUIMap.SprintStartDateFromRMP_statictxt, (String) jsonObject.get("SprintName"),"sprintname"),"data-fieldvalue");
					String SprintEndDate = getAttribute(prepareWebElementWithDynamicXpath(JiraUIMap.SprintEndDateFromRMP_statictxt, (String) jsonObject.get("SprintName"),"sprintname"),"data-fieldvalue");
					String SD[] = SprintStartDate.split(" ");
					String ED[] = SprintEndDate.split(" ");
					
					Date SprintStartdate = dFormat.parse(SD[0]);
					String SprintStartdateInRequiredFormat = dFormatRequired.format(SprintStartdate);
					assertEquals(SprintStartdateInRequiredFormat, (String) jsonObject.get("SprintStartDate"));
					
					Date SprintEnddate = dFormat.parse(ED[0]);
					String SprintEnddateInRequiredFormat = dFormatRequired.format(SprintEnddate);
					assertEquals(SprintEnddateInRequiredFormat, (String) jsonObject.get("SprintEndDate"));
						}
				else
					Assert.fail("Sprint not flown from RMP");
				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Could not verify release/sprint for "+AppName);
			Assert.fail("Could not verify release/sprint for "+AppName);
			
			
		}
	}

public static void CreateTeam(String Team) {
		
		try{
		Random rnd = new Random();
		String[] Team_sp = Team.split("_");
		WorkItemDO wii = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(Team);
		
		//generate random dates(sprint start date and end date) and release name
		int randomNumbForTeam = 1000 + rnd.nextInt(9000);
		String newTeeamwithAppendedNumb = wii.TeamName+randomNumbForTeam;
	
				ExpWaitForCondition(JiraUIMap.Components_Link);
				waitPageToLoad();
				clickJS(JiraUIMap.Components_Link);
				waitPageToLoad();
				Thread.sleep(3000);
				if(CheckIfElementExists(JiraUIMap.ComponentName_txtbox))
					{
					enterText(JiraUIMap.ComponentName_txtbox,newTeeamwithAppendedNumb);
					enterText(JiraUIMap.ComponentAssignee_txtbox,"Unassigned");
					Thread.sleep(1000);
					sendTab(JiraUIMap.ComponentAssignee_txtbox);
					click(JiraUIMap.AddRelease_btn);
					Thread.sleep(5000);
					waitPageToLoad();
					if(!CheckIfElementExists(prepareWebElementWithDynamicXpath(JiraUIMap.checkIfTeamCreated_link, newTeeamwithAppendedNumb, "teamname")))
						Assert.fail("could not create team for ADTJira");
					Baseclass.getInstance().Jira_ComponentName =newTeeamwithAppendedNumb;
			
					}
				else 
					System.out.println("Provision to add new release not present for project "+Property.getProperty("JiraProject"));
			
	}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue adding Team in the tool JIRA");
			Assert.fail("Issue adding Team in the tool JIRA");
		}

		
	}

public static void associateTestExecution(String workitem) {
	
	try{
		
		clickJS(JiraUIMap.SearchBoxHomePage_txtbox);
		Thread.sleep(4000);
		enterText(JiraUIMap.SearchBoxHomePage_txtbox,"Test");
		clickJS(JiraUIMap.WorkItemExternalID_txt);
		Thread.sleep(4000);
		clickJS(JiraUIMap.ExecuteIn_statictxt);
		clickJS(JiraUIMap.ExistingTestExecution_statictxt);
		Thread.sleep(2000);
		ExpWaitForCondition(JiraUIMap.TestExecution_txtbox);
		Thread.sleep(4000);
//		enterText(JiraUIMap.TestExecution_txtbox,Baseclass.getInstance().WorkItemExternalId_TestExecution.split("_")[0]);
		enterTextUsingAction(JiraUIMap.TestExecution_txtbox,Baseclass.getInstance().WorkItemExternalId_TestExecution.split("_")[0]);
		Thread.sleep(3000);
		sendEnter(JiraUIMap.TestExecution_txtbox);
		sendEnter(JiraUIMap.TestExecution_txtbox);
		Thread.sleep(3000);
//		clickJS(JiraUIMap.AddTestExecution_btn);
		Thread.sleep(3000);
		ExpWaitForCondition(JiraUIMap.AssociatedSuccess_txt);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public static void SelectProjectForCloudJira() {
	try {
		Thread.sleep(2000);
		waitPageToLoad();
		click(JiraUIMap.CloudJiraProjects_link);
		click(JiraUIMap.CloudJiraViewALlProjects_link);
		Thread.sleep(10000);
//		
		ExpWaitForCondition(JiraUIMap.CloudJiraSearchProject_txtbox);
		doubleClick(JiraUIMap.CloudJiraSearchProject_txtbox);
		Thread.sleep(2000);
//		enterText(JiraUIMap.SearchBoxAllPorjects_txtbox, Property.getProperty("JiraProject"));
		enterTextUsingAction(JiraUIMap.CloudJiraSearchProject_txtbox, Property.getProperty("JiraProject"));
		Thread.sleep(5000);
		Assert.assertEquals(getText(JiraUIMap.CloudJiraProjectKey_Statictxt), Property.getProperty("JiraProject"),"Entered project "+Property.getProperty("JiraProject")+ " not found");
			click(JiraUIMap.CloudJiraProjectKey_Statictxt);

		waitPageToLoad();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		logger.info("Issue selecting the project for the given tool");
		Assert.fail("Issue selecting the project for the given tool");
	}
	
}

public static void CreateReleaseForCloudJira(String ReleaseOrSprint) {
	try {
		Random rnd = new Random();
		WorkItemDO wii = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(ReleaseOrSprint);
		
		//generate random dates(sprint start date and end date) and release name
		int randomNumbForRelease = 1000 + rnd.nextInt(9000);
		String newReleasewithAppendedNumb = wii.ReleaseName+randomNumbForRelease;
		int randomNumbForSrpint = 100 + rnd.nextInt(900);
		
//		release
			if(ReleaseOrSprint.contains("Release"))
			{
				waitPageToLoad();
				Thread.sleep(5000);
				click(JiraUIMap.CloudJiraReleases_Link);
				waitPageToLoad();
				Thread.sleep(3000);
				clickJS(JiraUIMap.CloudJiraReleaseCreateVersion_Link);
//				Thread.sleep(3000);
//				singleClick(JiraUIMap.CloudJiraReleaseName_txtBox);
				Thread.sleep(5000);
				enterTextUsingAction(JiraUIMap.CloudJiraReleaseName_txtBox,newReleasewithAppendedNumb);
				
				
				Thread.sleep(2000);
				clickJS(JiraUIMap.CloudJiraStartDateIcon);

				Thread.sleep(2000);
				clickJS(JiraUIMap.CloudJiraNextMonthIcon);

				Thread.sleep(2000);
				clickJS(JiraUIMap.CloudJiraSelectReleaseStartDate);

				String releasestartdate = getText(JiraUIMap.CloudJiraGetReleaseStartDate);

				Thread.sleep(3000);
				
				clickJS(JiraUIMap.CloudJiraStartDateIcon);

				Thread.sleep(2000);
				clickJS(JiraUIMap.CloudJiraNextMonthIcon);

				Thread.sleep(2000);
				clickJS(JiraUIMap.CloudJiraSelectReleaseEndDate);

				String releaseenddate =getText(JiraUIMap.CloudJiraGetReleaseEndDate);

				System.out.println(releaseenddate);
				System.out.println(releasestartdate);
				 String startDateString = releasestartdate;
				    SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
				    SimpleDateFormat sdf2 = new SimpleDateFormat("d/MMM/YY");
				    System.out.println(sdf2.format(sdf.parse(releasestartdate)));
				    System.out.println(sdf2.format(sdf.parse(releaseenddate)));

				clickJS(JiraUIMap.CloudJiraSaveRelease_btn);
				waitPageToLoad();
				Baseclass.getInstance().Jira_ReleaseName =newReleasewithAppendedNumb;
				Baseclass.getInstance().Jira_ReleaseStartDate= sdf2.format(sdf.parse(releasestartdate));
				Baseclass.getInstance().Jira_ReleaseEndDate = sdf2.format(sdf.parse(releaseenddate));
				
			}
			else if(ReleaseOrSprint.contains("Sprint"))
			{
				clickJS(JiraUIMap.BacklogIcon_Img);
//				Thread.sleep(10000);
				ExpWaitForCondition(JiraUIMap.CloudJiraEditSprintDots_Img);
				clickJS(JiraUIMap.CloudJiraEditSprintDots_Img);
				clickJS(JiraUIMap.CloudJiraEditSprint_Img);
				ExpWaitForCondition(JiraUIMap.CloudJiraSprintName_txt);
				String currentsprintname = getValue(JiraUIMap.CloudJiraSprintName_txt);
//				clickJS(By.xpath("//a[@class='aui-button js-sprint-actions-trigger'][1]/span[1]"));
//				clickJS(JiraUIMap.SprintName_Statictxt);
//				Thread.sleep(2000);
				ClearTextAndEnterData(currentsprintname+"_"+randomNumbForSrpint);
				Thread.sleep(4000);
//				clickJS(JiraUIMap.SaveSprint_btn);
//				click(JiraUIMap.BacklogIcon_Img);
				Baseclass.getInstance().Jira_SprintName = currentsprintname+"_"+randomNumbForSrpint;
			}

	} 
	
	catch (Exception e) {
		e.printStackTrace();
		logger.info("Issues in creating release or sprint");
		Assert.fail("Issues in creating release or sprint");
	}

	
}
	}