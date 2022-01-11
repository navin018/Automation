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
import java.util.Calendar;
import java.util.Date;
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
		
		public static void SelectSpecificProjectInTFS(String projectname,String toolname) {
			try {
				
				waitPageToLoad();
			
				enterText(TFSUIMap.searchProject_txtbox,Property.getProperty(projectname));
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
				
						Baseclass.getInstance().WorkItemExternalId_Bug = getText(TFSUIMap.captureWorkItemID2_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "epic":
				
						Baseclass.getInstance().WorkItemExternalId_Epic =  getText(TFSUIMap.captureWorkItemID2_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "risk":
					
					Baseclass.getInstance().WorkItemExternalId_Risk =  getText(TFSUIMap.captureWorkItemID2_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//					click(TFSUIMap.close_btn);
					break;
				case "feature":
				
						Baseclass.getInstance().WorkItemExternalId_Feature =getText(TFSUIMap.captureWorkItemID2_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "issue":
				
						Baseclass.getInstance().WorkItemExternalId_Issue =getText(TFSUIMap.captureWorkItemID2_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "task":
				
						Baseclass.getInstance().WorkItemExternalId_Task =getText(TFSUIMap.captureWorkItemID2_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "story":
				case "user story":
				
						Baseclass.getInstance().WorkItemExternalId_Story =getText(TFSUIMap.captureWorkItemID2_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "testcase":
				
						Baseclass.getInstance().WorkItemExternalId_TestCase =getText(TFSUIMap.captureWorkItemID2_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "Deliverable":
				
						Baseclass.getInstance().WorkItemExternalId_Deliverable =getText(TFSUIMap.captureWorkItemID2_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "productbacklog":
				
						Baseclass.getInstance().WorkItemExternalId_Story =getText(TFSUIMap.captureWorkItemID2_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//						click(TFSUIMap.close_btn);
						break;
				case "action":
					
					Baseclass.getInstance().WorkItemExternalId_Action =getText(TFSUIMap.captureWorkItemID2_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//					click(TFSUIMap.close_btn);
					break;
				case "decision":
					
					Baseclass.getInstance().WorkItemExternalId_Decision =getText(TFSUIMap.captureWorkItemID2_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//					click(TFSUIMap.close_btn);
					break;
				case "milestone":
					
					Baseclass.getInstance().WorkItemExternalId_Milestone =getText(TFSUIMap.captureWorkItemID2_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//					click(TFSUIMap.close_btn);
					break;
				case "requirement":
					
					Baseclass.getInstance().WorkItemExternalId_Requirement =getText(TFSUIMap.captureWorkItemID2_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//					click(TFSUIMap.close_btn);
					break;
				case "deliverable":
					
					Baseclass.getInstance().WorkItemExternalId_Deliverable =getText(TFSUIMap.captureWorkItemID2_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//					click(TFSUIMap.close_btn);
					break;
				case "impediment":
                    Baseclass.getInstance().WorkItemExternalId_Impediment =getText(TFSUIMap.captureWorkItemID2_statictxt);
                    System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
//                    click(TFSUIMap.close_btn);
                    break;
				case "changerequest":
				case "workrequest":
				case "work request":
					Baseclass.getInstance().WorkItemExternalId_WorkRequest =getText(TFSUIMap.captureWorkItemID2_statictxt);
					System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
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
			
			public static void CaptureWorkitemID1(String workitem) {
				try {
					String workitem_sp[] = workitem.split("_");
					switch(workitem_sp[0].toLowerCase()){
					
					case "bug":
					
							Baseclass.getInstance().WorkItemExternalId_Bug = getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
							System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//							click(TFSUIMap.close_btn);
							break;
					case "epic":
					
							Baseclass.getInstance().WorkItemExternalId_Epic =  getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
							System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//							click(TFSUIMap.close_btn);
							break;
					case "risk":
						
						Baseclass.getInstance().WorkItemExternalId_Risk =  getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//						click(TFSUIMap.close_btn);
						break;
					case "feature":
					
							Baseclass.getInstance().WorkItemExternalId_Feature =getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
							System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//							click(TFSUIMap.close_btn);
							break;
					case "issue":
					
							Baseclass.getInstance().WorkItemExternalId_Issue =getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
							System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//							click(TFSUIMap.close_btn);
							break;
					case "task":
					
							Baseclass.getInstance().WorkItemExternalId_Task =getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
							System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//							click(TFSUIMap.close_btn);
							break;
					case "story":
					case "user story":
					
							Baseclass.getInstance().WorkItemExternalId_Story =getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
							System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//							click(TFSUIMap.close_btn);
							break;
					case "testcase":
					
							Baseclass.getInstance().WorkItemExternalId_TestCase =getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
							System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//							click(TFSUIMap.close_btn);
							break;
					case "Deliverable":
					
							Baseclass.getInstance().WorkItemExternalId_Deliverable =getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
							System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//							click(TFSUIMap.close_btn);
							break;
					case "productbacklog":
					
							Baseclass.getInstance().WorkItemExternalId_Story =getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
							System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//							click(TFSUIMap.close_btn);
							break;
					case "action":
						
						Baseclass.getInstance().WorkItemExternalId_Action =getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//						click(TFSUIMap.close_btn);
						break;
					case "decision":
						
						Baseclass.getInstance().WorkItemExternalId_Decision =getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//						click(TFSUIMap.close_btn);
						break;
					case "milestone":
						
						Baseclass.getInstance().WorkItemExternalId_Milestone =getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//						click(TFSUIMap.close_btn);
						break;
					case "requirement":
						
						Baseclass.getInstance().WorkItemExternalId_Requirement =getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//						click(TFSUIMap.close_btn);
						break;
					case "deliverable":
						
						Baseclass.getInstance().WorkItemExternalId_Deliverable =getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//						click(TFSUIMap.close_btn);
						break;
						
					case "changerequest":
					case "workrequest":
					case "work request":
						Baseclass.getInstance().WorkItemExternalId_WorkRequest =getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt);
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID_DeleteFn_statictxt));
//						click(TFSUIMap.close_btn);
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
			String[] TFSScrum_ItemsToVerify = {"Task", "Epic", "Feature", "Story", "Bug", "Issue", "Risk", "Deliverable","Deliverable","Requirement","Milestone","Action","Decision","TestCase","WorkRequest"};
			
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
			Thread.sleep(5000);
			ExpWaitForCondition(TFSUIMap.saveAndClose_btn);
			click(TFSUIMap.saveAndClose_btn);
			Thread.sleep(4000);
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
				Assert.fail("Issue creating release/sprint");
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
				 String workitemURL = GoToWorkitemURL(workitem);
				 EnterWorkItemDetails(workitem, workitemURL, wi);
				 CaptureWorkitemID(workitem);
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		public static void EnterWorkItemDetails(String workitem, String workitemURL, WorkItemDO wi)
		{
			try{
					//putting this piece of code as workitem url wasnt loading
					if(CheckIfElementExists(TFSUIMap.title_txtbox))
					{
//						Thread.sleep(5000);
						ExpWaitForCondition(TFSUIMap.title_txtbox);
						enterText(TFSUIMap.title_txtbox,wi.Summary);
						Thread.sleep(2000);
					}
					else if(CheckIfElementExists(TFSUIMap.title_txtbox))
					{
						Thread.sleep(5000);
						ExpWaitForCondition(TFSUIMap.title_txtbox);
						enterText(TFSUIMap.title_txtbox,wi.Summary);
						Thread.sleep(2000);
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
					
					
					//assignee
					if(!wi.Assignee.equalsIgnoreCase("NA"))
					{
                      sendBlankTab();
                      Thread.sleep(2000);
                      enterText(TFSUIMap.SearchUsers_txtbox,wi.Assignee);
                      sendEntr();
					}
					
					
//					//Team or Assignee field
//					if(!wi.TeamVerify.equalsIgnoreCase("NA"))
//                    {
//                        if(wi.TeamVerify.equalsIgnoreCase("TeamAreaVerification")) {
////                            ExpWaitForCondition(TFSUIMap.SearchUsers_txtbox);
//                            sendBlankTab();
//                            Thread.sleep(2000);
//                            enterText(TFSUIMap.SearchUsers_txtbox,Property.getProperty("UserName_ForToolTeam"));
//                            sendEntr();
//                          
//                        }
//                        if ( wi.TeamVerify.equalsIgnoreCase("TeamDCVerification")) {
//                            ExpWaitForCondition(TFSUIMap.SearchUsers_txtbox);
//                            sendBlankTab();
//                            Thread.sleep(2000);
//                            enterText(TFSUIMap.Unassigned_txtbox,Property.getProperty("UserName_ForTeamConfig"));
//                            sendEntr();
//                        }
//                       
//                        
//                    }
					
					
					//priority
					if(!wi.Priority.equalsIgnoreCase("NA"))
					{
						
						EnterDataInTheField(wi.Priority,TFSUIMap.Priority_drpdown);
					}
					
					
					
					//severity
					if(!wi.Severity.equalsIgnoreCase("NA"))
					{
						
						EnterDataInTheField(wi.Severity,TFSUIMap.Severity_drpdown);
					}
					
					//effort
					if(!wi.Effort.equalsIgnoreCase("NA"))
					{
						
						EnterDataInTheField(wi.Effort,TFSUIMap.Effort_txtbox);
					}
					
					//ActualEffort
					if(!wi.ActualEffort.equalsIgnoreCase("NA"))
					{
						
						EnterDataInTheField(wi.ActualEffort,TFSUIMap.ActualEffort_txtbox);
					}
					
					//remaining work
					if(!wi.RemainingWork.equalsIgnoreCase("NA"))
					{
						
						EnterDataInTheField(wi.RemainingWork,TFSUIMap.RemainingWork_txtbox);
					}
					
					
					
					//BusinessValue
					if(!wi.BusinessValue.equalsIgnoreCase("NA"))
					{
						
						EnterDataInTheField(wi.BusinessValue,TFSUIMap.BusinessValue_txtbox);
					}
					
					//Rank
					if(!wi.Rank.equalsIgnoreCase("NA"))
					{
						
						EnterDataInTheField(wi.Rank,TFSUIMap.Rank_txtbox);
					}
					
					//Stack Rank
					if(!wi.StackRank.equalsIgnoreCase("NA"))
					{
						
						EnterDataInTheField(wi.StackRank,TFSUIMap.StackRank_txtbox);
					}
					
					//Risk Reduction
					if(!wi.RiskReduction.equalsIgnoreCase("NA"))
					{
						
						EnterDataInTheField(wi.RiskReduction,TFSUIMap.RiskReduction_txtbox);
					}
					
				
					//Completed
					if(!wi.Completed.equalsIgnoreCase("NA"))
					{
						EnterDataInTheField(wi.Completed,TFSUIMap.Completed_txtbox);
					}
		
					//Completed work
					if(!wi.CompletedWork.equalsIgnoreCase("NA"))
					{
						EnterDataInTheField(wi.CompletedWork,TFSUIMap.CompletedWork_txtbox);
					}
					
					//OriginalEstimate
					if(!wi.OriginalEstimate.equalsIgnoreCase("NA"))
					{
						EnterDataInTheField(wi.OriginalEstimate,TFSUIMap.OriginalEstimate_txtbox);
					}
					
					//StoryPoints
					if(!wi.StoryPoints.equalsIgnoreCase("NA"))
					{
						EnterDataInTheField(wi.StoryPoints,TFSUIMap.StoryPoints_txtbox);
					}
					
					
					//TimeCriticality
					if(!wi.TimeCriticality.equalsIgnoreCase("NA"))
					{
						EnterDataInTheField(wi.TimeCriticality,TFSUIMap.TimeCriticality_txtbox);
					}
					
					//Criticality
					if(!wi.Criticality.equalsIgnoreCase("NA"))
					{
						EnterDataInTheField(wi.Criticality,TFSUIMap.Criticality_txtbox);
					}
					
					//Complexity
					if(!wi.Complexity.equalsIgnoreCase("NA"))
					{
						EnterDataInTheField(wi.Complexity,TFSUIMap.Complexity_txtbox);
					}
					
					//CostEstimate
					if(!wi.CostEstimate.equalsIgnoreCase("NA"))
					{
						EnterDataInTheField(wi.CostEstimate,TFSUIMap.CostEstimate_txtbox);
					}
					
					//CostApproved
					if(!wi.CostApproved.equalsIgnoreCase("NA"))
					{
						EnterDataInTheField(wi.CostApproved,TFSUIMap.CostApproved_txtbox);
					}
					
					//Risk
					if(!wi.Risk.equalsIgnoreCase("NA"))
					{
						EnterDataInTheField(wi.Risk,TFSUIMap.Risk_txtbox);
					}
					
					
					
					
					//Release and sprint
					try{
					switch(wi.Release){
					case("NA"):
						//do nothing
						break;
					case("None"):
						clickJS(TFSUIMap.Iteration_label);
						Thread.sleep(4000);
						enterText(TFSUIMap.IterationName1_txtbox,Property.getProperty("TFSProject"));
//						clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.IterationValue_drpdown, Property.getProperty("TFSProject"), "projectname"));
						break;
					case("PickFromBaseclass"):
						clickJS(TFSUIMap.Iteration_label);
						Thread.sleep(2000);
						String ReleasePlusSprintName = Property.getProperty("TFSProject")+"\\"+Baseclass.getInstance().TFS_ReleaseName+"\\"+Baseclass.getInstance().TFS_SprintName;
						enterText(TFSUIMap.IterationName1_txtbox,ReleasePlusSprintName);
						sendEntr();
						break;
					default:
						clickJS(TFSUIMap.Iteration_label);
						String IterationDetails = Property.getProperty("TFS Scrum_Client-Native")+"\\"+wi.Release+"\\"+wi.Sprint;
						enterText(TFSUIMap.IterationName1_txtbox, IterationDetails);
						sendEntr();
						break;
					}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						logger.info("issue tagging release/sprint for the workitem");
					}
//					if(!(wi.Release.equalsIgnoreCase("NA") && wi.Sprint.equalsIgnoreCase("NA")))
//					{
//						if(!wi.Release.equalsIgnoreCase("None") && !wi.Sprint.equalsIgnoreCase("None")){
//						clickJS(TFSUIMap.Iteration_label);
//						String IterationDetails = Property.getProperty("TFS Scrum_Client-Native")+"/"+wi.Release+"/"+wi.Sprint;
//						enterText(TFSUIMap.Iteration_label, IterationDetails);
//						sendEntr();
//						}
//					}
//					if((wi.Release.equalsIgnoreCase("None") && wi.Sprint.equalsIgnoreCase("None")))
//					{
//						clickJS(TFSUIMap.Iteration_label);
//						Thread.sleep(2000);
//						clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.IterationValue_drpdown, Property.getProperty("TFSProject"), "projectname"));
////						clickJS(TFSUIMap.Iteration_label);
////						String IterationDetails = Property.getProperty("TFSProject");
////						EnterTextUsingJS(By.xpath("//label[text()='Ite']//following::div[2]"), IterationDetails);
//						System.out.println("hi");
////						sendEntr();
//					}
					
				
						
			//save and capture workitem ID details
			singleClick(TFSUIMap.save_btn);
			Thread.sleep(5000);
			
					if(!wi.State.equalsIgnoreCase("New"))
					{
						clickJS(TFSUIMap.State_drpdown1);
						clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.StateValues_drpdown, wi.State, "state"));
						Thread.sleep(2000);
						singleClick(TFSUIMap.save_btn);
						Thread.sleep(5000);
					}	
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue entering workitem details for workitem "+workitem);
			}
		}
		private static void EnterDataInTheField(String datatobeentered, By field) {
			try{
				
				if(CheckIfElementExists(field)){
					clickJS(field);
					clear(field);
					enterText(field,datatobeentered);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue entering data in the field "+field);
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

		
		public static String GoToWorkitemURL(String workitem){
			try{
			 String workitemURL;
						if(workitem.contains("TestCase")) 
							 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"Test Case";
						else if (workitem.contains("Work Request")) {
							workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"change request";
							}
								else if(workitem.split("_")[0].contains("Story")){
							 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"User Story";
							 driver().get(workitemURL);
							 Thread.sleep(5000);
							 if(CheckIfElementExists(TFSUIMap.ServerError_txt))
								 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"Product Backlog Item";
								}
								else if(workitem.split("_")[0].contains("ProductBacklog"))
									 workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+"Product Backlog Item";
								else
								workitemURL = Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject+"/_workitems/create/"+workitem.split("_")[0];
			 
			 driver().get(workitemURL);
				Thread.sleep(5000);
				return workitemURL;
			}
			catch(Exception e)
			{e.printStackTrace();}
			return "";
		}
		public static void CreateWorkitemForPrecomputationEngine(String workitem,String functionality) {
			try{
			 WorkItemDO wi = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(workitem);
			
			 //navigate to the create WI url
			 String workitemURL = GoToWorkitemURL(workitem);
			 EnterWorkItemDetailsForSpecificFUnctionality(workitem, workitemURL, wi,functionality);
				CaptureWorkitemIDForPreComputationEngine(workitem);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue creating "+workitem+" in TFS");
			}
		}
		
		
		

		public static void CaptureWorkitemIDForPreComputationEngine(String workitem) {
			try {
				String workitem_sp[] = workitem.split("_");
				switch(workitem_sp[0].toLowerCase()){
				
					
				case "story":
				case "user story":
						switch(workitem){
						case("Story_wsjf_Multiply_0"):
						Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Multiply_0 = getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;
						case("Story_wsjf_Deno_0"):
							Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Deno_0 = getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;
						case("Story_wsjf_Nume_0"):
							Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Nume_0 = getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;
						case("Story_wsjf_Negative_Int"):
							Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Negative_Int = getText(TFSUIMap.captureWorkItemID2_statictxt);
							break;
						case("Story_wsjf_Decimal_Tool"):
							Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Decimal_Tool = getText(TFSUIMap.captureWorkItemID2_statictxt);
							break;
						case("Story_wsjf_Zero_Tool"):
							Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Zero_Tool = getText(TFSUIMap.captureWorkItemID2_statictxt);
							break;
						case("Story_wsjf_Decimal_Output"):
							Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Decimal_Output = getText(TFSUIMap.captureWorkItemID2_statictxt);
							break;
						case("Story_wsjf_Negative_Int_UpdateWorkitem"):
							Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Negative_Int_UpdateWorkitem= getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;
						case("Story_wsjf_Multiply_0_UpdateFormula"):
							Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Multiply_0_UpdateFormula= getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;	
						case("Story_RAG_StatusDone_Rule1"):
							Baseclass.getInstance().WorkItemExternalId_Story_RAG_StatusDone_Rule1= getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;
						case("Story_RAG_StatusInactivate_Rule2"):
							Baseclass.getInstance().WorkItemExternalId_Story_RAG_StatusInactivate_Rule2= getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;
						case("Story_RAG_NoAssociation_Rule3"):
							Baseclass.getInstance().WorkItemExternalId_Story_RAG_NoAssociation_Rule3= getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;
						case("Story_RAG_IterationTiming_Rule4"):
							Baseclass.getInstance().WorkItemExternalId_Story_RAG_IterationTiming_Rule4= getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;
						case("Story_RAG_IterationTiming_Rule5"):
							Baseclass.getInstance().WorkItemExternalId_Story_RAG_IterationTiming_Rule5= getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;
						case("Story_RAG_AssociatedIterationTiming_Rule7"):
							Baseclass.getInstance().WorkItemExternalId_Story_RAG_AssociatedIterationTiming_Rule7= getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;
						case("Story_RAG_AssociatedToStory_Rule7"):
							Baseclass.getInstance().WorkItemExternalId_Story_RAG_AssociatedToStory_Rule7= getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;
						case("Story_RAG_PastIteration_Rule10"):
							Baseclass.getInstance().WorkItemExternalId_Story_RAG_PastIteration_Rule10= getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;
						case("Story_RAG_IterationTiming_Rule11"):
							Baseclass.getInstance().WorkItemExternalId_Story_RAG_IterationTiming_Rule11= getText(TFSUIMap.captureWorkItemID2_statictxt);
						break;
						
						}
						System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
				case "Deliverable":
				case "deliverable":
							switch(workitem){
							case("Deliverable_wsjf_Multiply_0"):
							Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Multiply_0 = getText(TFSUIMap.captureWorkItemID2_statictxt);
							break;
							case("Deliverable_wsjf_Deno_0"):
								Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Deno_0 = getText(TFSUIMap.captureWorkItemID2_statictxt);
							break;
							case("Deliverable_wsjf_Nume_0"):
								Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Nume_0 = getText(TFSUIMap.captureWorkItemID2_statictxt);
							break;
							case("Deliverable_wsjf_Negative_Int"):
								Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Negative_Int = getText(TFSUIMap.captureWorkItemID2_statictxt);
								break;
							case("Deliverable_wsjf_Decimal_Tool"):
								Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Decimal_Tool = getText(TFSUIMap.captureWorkItemID2_statictxt);
								break;
							case("Deliverable_wsjf_Zero_Tool"):
								Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Zero_Tool = getText(TFSUIMap.captureWorkItemID2_statictxt);
								break;
							case("Deliverable_wsjf_Decimal_Output"):
								Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Decimal_Output = getText(TFSUIMap.captureWorkItemID2_statictxt);
								break;
							}
							System.out.println(workitem+" id is "+getText(TFSUIMap.captureWorkItemID2_statictxt));
							break;
				case "risk":
				case "Risk":
					switch(workitem){
					case("Risk_RAG_ToBeAssociatedToStory_Rule10"):
					Baseclass.getInstance().WorkItemExternalId_Risk_RAG_ToBeAssociatedToStory_Rule10 = getText(TFSUIMap.captureWorkItemID2_statictxt);
					break;
					case("Risk_RAG_ToBeAssociatedToStory_Rule11"):
						Baseclass.getInstance().WorkItemExternalId_Risk_RAG_ToBeAssociatedToStory_Rule10 = getText(TFSUIMap.captureWorkItemID2_statictxt);
					break;
							
				default:
			        throw new IllegalArgumentException("Invalid workitem: " + workitem);	
				}
				}
				
			} catch (Exception e) {
				System.out.println("Issue with capturing workitem ID");
				e.printStackTrace();
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
			 Thread.sleep(5000);
		}
			catch(Exception e)
			{
				e.printStackTrace();
				Assert.fail("issue opening workitem in TFS");
				}
			}
		public static void openWorkitemUsingWorkitemID(String workitemID) {
			try{
				ExpWaitForCondition(TFSUIMap.SearchBoxHomePage_txtbox);
			 clearEnterText(TFSUIMap.SearchBoxHomePage_txtbox, workitemID);
//			 enterText(TFSUIMap.SearchBoxHomePage_txtbox, WorkItemExternalId);
			 ExpWaitForCondition(prepareWebElementWithDynamicXpath(TFSUIMap.workitemIDInSearch_txt, workitemID, "workitemid"));
			 clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.workitemIDInSearch_txt, workitemID, "workitemid"));
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

		public static void deleteworkitem(String workitem) {
			try{
		ExpWaitForCondition(TFSUIMap.ActionWorkitem_btn);
			clickJS(TFSUIMap.ActionWorkitem_btn);
			
			
			if(workitem.contains("TestCase") || workitem.contains("Testcase"))
				{
				clickJS(TFSUIMap.PermanentDeleteWorkitem_btn);
					ExpWaitForCondition(TFSUIMap.deleteTestCase_txtbox);
					clickJS(TFSUIMap.deleteTestCase_txtbox);
					String WorkItemExternalId = Tools.getWorkItemExternalID(workitem.split("_")[0],"TFS");
					enterText(TFSUIMap.deleteTestCase_txtbox,WorkItemExternalId);
					ExpWaitForCondition(TFSUIMap.ConfirmDeleteWorkitem_btn);
					clickJS(TFSUIMap.ConfirmDeleteWorkitem_btn);
				}
				else{
			ExpWaitForCondition(TFSUIMap.DeleteWorkitem_btn);
			clickJS(TFSUIMap.DeleteWorkitem_btn);
			ExpWaitForCondition(TFSUIMap.ConfirmDeleteWorkitem_PopUp);
			clickJS(TFSUIMap.ConfirmDeleteWorkitem_btn);
			Thread.sleep(3000);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue deleting workitem in TFS");
			}
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
			
			
			
				singleClick(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseOrSprint_Row, ReleaseName, "ReleaseOrSprintName"));
				Thread.sleep(2000);
//			HoverUsingAction(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseOrSprintAction_btn, ReleaseName, "ReleaseOrSprintName"));
			clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseOrSprintAction_btn, ReleaseName, "ReleaseOrSprintName"));
			Thread.sleep(2000);
			clickJS(TFSUIMap.DeleteAutomationData_Btn);
			ExpWaitForCondition(TFSUIMap.DeletePath_btn);
			clickJS(TFSUIMap.DeletePath_btn);
			
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
				ExpWaitForCondition(TFSUIMap.ChangeEntityType_link);
				clickJS(TFSUIMap.ChangeEntityType_link);
				
				ExpWaitForCondition(TFSUIMap.EntityTypeTo_txtbox);
				clickJS(TFSUIMap.EntityTypeTo_txtbox);
				clear(TFSUIMap.EntityTypeTo_txtbox);
				enterText(TFSUIMap.EntityTypeTo_txtbox,workitemTo.split("_")[0]);
				sendEnter(TFSUIMap.EntityTypeTo_txtbox);
				Thread.sleep(2000);
				clickJS(TFSUIMap.Ok_btn);
				Thread.sleep(2000);
				singleClick(TFSUIMap.State_drpdown);
				Thread.sleep(2000);
				sendPageDown();
				sendPageDown();
				sendEntr();
				Thread.sleep(2000);
				ExpWaitForCondition(TFSUIMap.save_drpdown);
				singleClick(TFSUIMap.save_drpdown);
				ExpWaitForCondition(TFSUIMap.save_btn);
				singleClick(TFSUIMap.save_btn);
//				clickJS(TFSUIMap.save_drpdown);
//				clickJS(TFSUIMap.save_btn);
				Thread.sleep(3000);
				CaptureWorkitemID1(workitemTo);
				clickJS(TFSUIMap.close_btn);
				Thread.sleep(3000);
				if(CheckIfElementExists(TFSUIMap.Confirm_window))
				{
					clickJS(TFSUIMap.ConfirmSave_btn);
				}
				}
				
				if(ProjectOrEntityType.equalsIgnoreCase("project")){
					clickJS(TFSUIMap.ActionWorkitem_btn);
					ExpWaitForCondition(TFSUIMap.ChangeProject_link);
					clickJS(TFSUIMap.ChangeProject_link);
					ExpWaitForCondition(TFSUIMap.SelectProject_Drpdown);
					clickJS(TFSUIMap.SelectProject_Drpdown);
					Thread.sleep(1000);
					clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.NewProjToBeSelected_drpdown, Property.getProperty("TFSProject_ChangeProject"), "projname"));
					Thread.sleep(1000);
//					}
					clickJS(TFSUIMap.Ok_btn);
					Thread.sleep(4000);
					ExpWaitForCondition(TFSUIMap.IterationName1_txtbox);
					if(CheckIfElementExists(TFSUIMap.IterationPathNotFound_txt))
						{
						
							clickJS(TFSUIMap.Iteration_label1);
							Thread.sleep(2000);
							clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.Iteration_drodownvalues, Property.getProperty("TFSProject_ChangeProject"), "projname"));
							Thread.sleep(2000);
						}
					ExpWaitForCondition(TFSUIMap.save_drpdown);
					singleClick(TFSUIMap.save_drpdown);
					ExpWaitForCondition(TFSUIMap.save_btn);
					singleClick(TFSUIMap.save_btn);
					CaptureWorkitemID1(workitemFrom);
					clickJS(TFSUIMap.close_btn);
					Thread.sleep(3000);
					if(CheckIfElementExists(TFSUIMap.Confirm_window))
					{
						clickJS(TFSUIMap.ConfirmSave_btn);
					}
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

		public static void UpdateWorkItemForPreComputation(String workitem, String functionality) {
			try{
			String workitemID = API.getWorkItemExternalIDForGivenFunctionality(workitem.split("_Update")[0],"TFS",functionality);
			ExpWaitForCondition(TFSUIMap.SearchBoxHomePage_txtbox);
			clearEnterText(TFSUIMap.SearchBoxHomePage_txtbox, workitemID);
			 ExpWaitForCondition(prepareWebElementWithDynamicXpath(TFSUIMap.workitemIDInSearch_txt, workitemID, "workitemid"));
			 clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.workitemIDInSearch_txt, workitemID, "workitemid"));
			 ExpWaitForCondition(TFSUIMap.captureWorkItemID1_statictxt);
			 
			 WorkItemDO wi = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(workitem);
				
			 //navigate to the create WI url
			 EnterWorkItemDetailsForSpecificFUnctionality(workitem, "NA", wi,functionality);
				CaptureWorkitemIDForPreComputationEngine(workitem);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		public static void LinkWorkitems(String workitem, String workitem1,String linkingtype, String functionality) {
			try{
			String workitemID = API.getWorkItemExternalIDForGivenFunctionality(workitem,"TFS",functionality);
			String workitemID1 = API.getWorkItemExternalIDForGivenFunctionality(workitem1,"TFS",functionality);
		
		
			if(CheckIfElementExists(TFSUIMap.Close_btn))
				clickJS(TFSUIMap.Close_btn);
			
			openWorkitemUsingWorkitemID(workitemID);
			clickJS(TFSUIMap.Links_link);
			clickJS(TFSUIMap.AddLink_link);
			clickJS(TFSUIMap.Existingitem_link);
			Thread.sleep(5000);
			clickJS(TFSUIMap.linkage_drpdown);
			Thread.sleep(2000);
			ScrollIntoView(prepareWebElementWithDynamicXpath(TFSUIMap.linkage_relationship, linkingtype, "relationship"));
			Thread.sleep(2000);
			clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.linkage_relationship, linkingtype, "relationship"));
			Thread.sleep(2000);
//			clickJS(TFSUIMap.LinkType_drpdown);
//			clear(TFSUIMap.LinkType_drpdown);
//			Thread.sleep(2000);
//			clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.linkingType_txt, linkingtype, "linkingtype"));
//			sendBackSpace();
//			Thread.sleep(3000);
//			enterText(TFSUIMap.LinkType_drpdown,linkingtype);
//			sendEntr();
			enterText(TFSUIMap.workitemlinking_txtbox,workitemID1);
			Thread.sleep(2000);
			ExpWaitForCondition(TFSUIMap.searchedWorkitem_drpdown);
			if(CheckIfElementExists(TFSUIMap.searchedWorkitem_drpdown)){
//				clickJS(TFSUIMap.SearchBoxHomePage_txtbox);
				sendEntr();
				Thread.sleep(2000);
			}
			else
				logger.info(workitemID1+ " i.e. "+workitem1+" doesnt show up in search in TFS");
			ExpWaitForCondition(TFSUIMap.Ok_btn);
			clickJS(TFSUIMap.Ok_btn);
			ExpWaitForCondition(TFSUIMap.saveandclose_btn);
			singleClick(TFSUIMap.saveandclose_btn);
			Thread.sleep(5000);
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Issue linking workitems");
				Assert.fail("Issue linking workitems");
			}
		}

		public static void CreateIterationForSpecificDuration(String releaseorSprint, int startdatefromtoday, int enddatefromtoday) {
		try{
			
			if(releaseorSprint.equalsIgnoreCase("Release")){
				int randomnumb = RandomNumberGenerator();
				String releasename = "Release_AutomationData_"+randomnumb;
				String sprintname = "Sprint_AutomationData_"+randomnumb;
				Baseclass.getInstance().TFS_ReleaseName= releasename;
				Baseclass.getInstance().TFS_SprintName= sprintname;
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
					Random rnd = new Random();
					int randomNumbForRelease = 1000 + rnd.nextInt(9000);	
				//enter release data
			
				clear(TFSUIMap.IterationName_txtbox);
				
				enterText(TFSUIMap.IterationName_txtbox,releasename);
				enterText(TFSUIMap.StartDate_txtbox,getCalculatedDate(startdatefromtoday));
				enterText(TFSUIMap.EndDate_txtbox,getCalculatedDate(enddatefromtoday));
				click(TFSUIMap.saveAndClose_btn);
				
			}
			else if(releaseorSprint.equalsIgnoreCase("Sprint"))
					{
				Thread.sleep(3000);
				move(prepareWebElementWithDynamicXpath(TFSUIMap.ReleaseRow_statictxt,Baseclass.getInstance().TFS_ReleaseName,"releasename"));
				click(prepareWebElementWithDynamicXpath(TFSUIMap.newSprint_statictxt,Baseclass.getInstance().TFS_ReleaseName,"releasename"));
				click(TFSUIMap.NewChild_link);
				clear(TFSUIMap.IterationName_txtbox);
				
				enterText(TFSUIMap.IterationName_txtbox,Baseclass.getInstance().TFS_SprintName);
				enterText(TFSUIMap.StartDate_txtbox,getCalculatedDate(startdatefromtoday));
				enterText(TFSUIMap.EndDate_txtbox,getCalculatedDate(enddatefromtoday));
				click(TFSUIMap.saveAndClose_btn);
				Thread.sleep(5000);
					}
//				Baseclass.getInstance().TFS_ReleaseName=releasename;
//				Baseclass.getInstance().TFS_SprintName=sprintname;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue creating iteration for a specific duration");
			Assert.fail("Issue creating iteration for a specific duration");
		}
			
		}

		public static String getCalculatedDate(int duration) {
			 SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
			    Calendar c = Calendar.getInstance();
			    c.setTime(new Date()); // Using today's date
			    c.add(Calendar.DATE, duration); // Adding 5 days
			    String output = sdf.format(c.getTime());
//			    System.out.println(output);
			    return output;
		}
		public static void DeleteTeam(String workitem, String toolname,String functionality) {
            try {
                if(CheckIfElementExists(TFSUIMap.projectsetting_text)) {
                    clickJS(TFSUIMap.projectsetting_text);
                }
                clickJS(TFSUIMap.Teams_text);    

                //read team from JSON file
                String Team=Tools.getWorkItemExternalID_custom(workitem,toolname,"normal");
                System.out.println(Team);
                enterText(TFSUIMap.filterteam_textbox,Team);
                
                clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.SelectTeam_text, Team,"Teamname"));
                
                clickJS(TFSUIMap.Settings_text);
                ExpWaitForCondition(TFSUIMap.DeleteTeam_text);
                clickJS(TFSUIMap.DeleteTeam_text);
                ExpWaitForCondition(TFSUIMap.Delete_btn);
                clickJS(TFSUIMap.Delete_btn);
                waitPageToLoad();
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
                Assert.fail("Issue Deleting Team in Tool");
            }

 

            
        }
		public static void CreateTeam() {
            try {
	            if(CheckIfElementExists(TFSUIMap.projectsetting_text)) {
	                clickJS(TFSUIMap.projectsetting_text);
	            }
            clickJS(TFSUIMap.Teams_text);
            Thread.sleep(3000);
            refresh();
            Thread.sleep(4000);
            ExpWaitForCondition(TFSUIMap.NewTeam_btn);
            clickJS(TFSUIMap.NewTeam_btn);
            ExpWaitForCondition(TFSUIMap.Teamname_txtbox);           
            Baseclass.getInstance().teamName="AutomationTeam_"+RandomNumberGenerator();
            System.out.println(Baseclass.getInstance().teamName);           
            enterText(TFSUIMap.Teamname_txtbox,Baseclass.getInstance().teamName);
            enterTextUsingAction(TFSUIMap.Addmember_txtbox,"sonal.harish.nagda@accenture.com");
            Thread.sleep(5000);
            sendPageDownKey();
            Thread.sleep(2000);
            sendEntr();
            clickJS(TFSUIMap.Createteam_txt);
            waitPageToLoad();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                logger.info("Issue Creating Team in Tool");
                Assert.fail("Issue Creating Team in Tool");
            }
        }

		public static void CreateTeamWithSpecificMember(String teammember) {
			try {
			if (CheckIfElementExists(TFSUIMap.projectsetting_text)) {
			clickJS(TFSUIMap.projectsetting_text);
			}
			clickJS(TFSUIMap.Teams_text);
			Thread.sleep(3000);
			refresh();
			Thread.sleep(4000);
			ExpWaitForCondition(TFSUIMap.NewTeam_btn);
			clickJS(TFSUIMap.NewTeam_btn);
			ExpWaitForCondition(TFSUIMap.Teamname_txtbox);





			Baseclass.getInstance().teamName = "AutomationTeam_" + RandomNumberGenerator();
			String Team = Baseclass.getInstance().teamName;
			System.out.println(Baseclass.getInstance().teamName);
			enterText(TFSUIMap.Teamname_txtbox, Baseclass.getInstance().teamName);
			clickJS(TFSUIMap.Createteam_txt);
			waitPageToLoad();
			enterText(TFSUIMap.filterteam_textbox, Baseclass.getInstance().teamName);
			ExpWaitForCondition(prepareWebElementWithDynamicXpath(TFSUIMap.SelectTeam_text, Team,
			"Teamname"));
			clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.SelectTeam_text, Team,"Teamname"));
			clickJS(TFSUIMap.Addmembers_btn);

			if (teammember.contains("&")) {
			String[] teammemberSplit = teammember.split("&");

			//if more than 1 resource to be added
			if(teammemberSplit.length>1)
			{
			for(int i = 0; i<teammemberSplit.length;i++)
			{
			teammember=teammemberSplit[i];
			enterText(TFSUIMap.SearchUsers_txtbox1, teammember);
			Thread.sleep(3000);
			sendEntr();
			}
			}
			}
			else {
			enterText(TFSUIMap.SearchUsers_txtbox1, teammember);
			Thread.sleep(3000);
			sendEntr();
			}
			Thread.sleep(4000);
			clickJS(TFSUIMap.SaveUser_btn);
			Thread.sleep(6000);
			//if save btn is not clicked, reclick it
			if(CheckIfElementExists(prepareWebElementWithDynamicXpath(TFSUIMap.Member_txt,teammember,"ResourceName")))
			System.out.println("Resource added sucessfully");
			else
			Assert.fail("Resource Not Added Or Added Resource is missing");



			waitPageToLoad();
			waitPageToLoad();
			driver().get(Property.getProperty("TFS_URL")+"/"+Baseclass.getInstance().TFSProject);




			} catch (Exception e) {
			e.printStackTrace();
			logger.info("Issue Creating Team in Tool");
			Assert.fail("Issue Creating Team in Tool");
			}
			}

		public static void updateEntity(String fieldtoupdate, String workitem) {
			try{
			openworkitem(workitem);
			switch(fieldtoupdate)
			{
				case("Description"):
					enterText(TFSUIMap.Description_txt,"updated descrption");
					break;
			}
			if(CheckIfElementExists(TFSUIMap.save_btn)) {
				clickJS(TFSUIMap.save_btn);
				Thread.sleep(5000);
				}else if(CheckIfElementExists(TFSUIMap.saveAndClose_btn)){
				clickJS(TFSUIMap.saveandclose_button);
				Thread.sleep(5000);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue opening or updating workitem "+workitem);
			}
		}

		public static void CreateWorkitemForTeamArchitecture(String workitem, String functionality) {
			try{
				 WorkItemDO wi = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(workitem);
				
				 //navigate to the create WI url
				 String workitemURL = GoToWorkitemURL(workitem);
				 EnterWorkItemDetailsForSpecificFUnctionality(workitem, workitemURL, wi,functionality);
					CaptureWorkitemIDForTeamArchitecture(workitem);
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					logger.info("issue creating "+workitem+" in TFS");
				}
			}

		public static void EnterWorkItemDetailsForSpecificFUnctionality(String workitem, String workitemURL,WorkItemDO wi, String functionality) {
			{
				try{
						//putting this piece of code as workitem url wasnt loading
						if(CheckIfElementExists(TFSUIMap.title_txtbox))
						{
//							Thread.sleep(5000);
							ExpWaitForCondition(TFSUIMap.title_txtbox);
							enterText(TFSUIMap.title_txtbox,wi.Summary);
							Thread.sleep(2000);
						}
						else if(CheckIfElementExists(TFSUIMap.title_txtbox))
						{
							Thread.sleep(5000);
							ExpWaitForCondition(TFSUIMap.title_txtbox);
							enterText(TFSUIMap.title_txtbox,wi.Summary);
							Thread.sleep(2000);
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
						
						
						//assignee
						if(!wi.Assignee.equalsIgnoreCase("NA"))
						{
	                      sendBlankTab();
	                      Thread.sleep(2000);
	                      enterText(TFSUIMap.SearchUsers_txtbox,wi.Assignee);
	                      sendEntr();
						}
						
						 if(!wi.TeamArea.equalsIgnoreCase("NA")){
							 singleClick(TFSUIMap.TeamArea_label);
						     Thread.sleep(2000);
						     String Teamarea=API.getWorkItemExternalIDForGivenFunctionality(wi.TeamArea,"TFS",functionality);
						     String Teamarea1 = Property.getProperty("TFSProject")+"\\"+Teamarea;
						     enterText(TFSUIMap.TeamArea_label1,Teamarea1);
						     sendEntr();
						 }
						 
						//priority
						if(!wi.Priority.equalsIgnoreCase("NA"))
						{
							
							EnterDataInTheField(wi.Priority,TFSUIMap.Priority_drpdown);
						}
						
						
						
						//severity
						if(!wi.Severity.equalsIgnoreCase("NA"))
						{
							
							EnterDataInTheField(wi.Severity,TFSUIMap.Severity_drpdown);
						}
						
						//effort
						if(!wi.Effort.equalsIgnoreCase("NA"))
						{
							
							EnterDataInTheField(wi.Effort,TFSUIMap.Effort_txtbox);
						}
						
						//ActualEffort
						if(!wi.ActualEffort.equalsIgnoreCase("NA"))
						{
							
							EnterDataInTheField(wi.ActualEffort,TFSUIMap.ActualEffort_txtbox);
						}
						
						//remaining work
						if(!wi.RemainingWork.equalsIgnoreCase("NA"))
						{
							
							EnterDataInTheField(wi.RemainingWork,TFSUIMap.RemainingWork_txtbox);
						}
						
						
						
						//BusinessValue
						if(!wi.BusinessValue.equalsIgnoreCase("NA"))
						{
							
							EnterDataInTheField(wi.BusinessValue,TFSUIMap.BusinessValue_txtbox);
						}
						
						//Rank
						if(!wi.Rank.equalsIgnoreCase("NA"))
						{
							
							EnterDataInTheField(wi.Rank,TFSUIMap.Rank_txtbox);
						}
						
						//Stack Rank
						if(!wi.StackRank.equalsIgnoreCase("NA"))
						{
							
							EnterDataInTheField(wi.StackRank,TFSUIMap.StackRank_txtbox);
						}
						
						//Risk Reduction
						if(!wi.RiskReduction.equalsIgnoreCase("NA"))
						{
							
							EnterDataInTheField(wi.RiskReduction,TFSUIMap.RiskReduction_txtbox);
						}
						
					
						//Completed
						if(!wi.Completed.equalsIgnoreCase("NA"))
						{
							EnterDataInTheField(wi.Completed,TFSUIMap.Completed_txtbox);
						}
			
						//Completed work
						if(!wi.CompletedWork.equalsIgnoreCase("NA"))
						{
							EnterDataInTheField(wi.CompletedWork,TFSUIMap.CompletedWork_txtbox);
						}
						
						//OriginalEstimate
						if(!wi.OriginalEstimate.equalsIgnoreCase("NA"))
						{
							EnterDataInTheField(wi.OriginalEstimate,TFSUIMap.OriginalEstimate_txtbox);
						}
						
						//StoryPoints
						if(!wi.StoryPoints.equalsIgnoreCase("NA"))
						{
							EnterDataInTheField(wi.StoryPoints,TFSUIMap.StoryPoints_txtbox);
						}
						
						
						//TimeCriticality
						if(!wi.TimeCriticality.equalsIgnoreCase("NA"))
						{
							EnterDataInTheField(wi.TimeCriticality,TFSUIMap.TimeCriticality_txtbox);
						}
						
						//Criticality
						if(!wi.Criticality.equalsIgnoreCase("NA"))
						{
							EnterDataInTheField(wi.Criticality,TFSUIMap.Criticality_txtbox);
						}
						
						//Complexity
						if(!wi.Complexity.equalsIgnoreCase("NA"))
						{
							EnterDataInTheField(wi.Complexity,TFSUIMap.Complexity_txtbox);
						}
						
						//CostEstimate
						if(!wi.CostEstimate.equalsIgnoreCase("NA"))
						{
							EnterDataInTheField(wi.CostEstimate,TFSUIMap.CostEstimate_txtbox);
						}
						
						//CostApproved
						if(!wi.CostApproved.equalsIgnoreCase("NA"))
						{
							EnterDataInTheField(wi.CostApproved,TFSUIMap.CostApproved_txtbox);
						}
						
						//Risk
						if(!wi.Risk.equalsIgnoreCase("NA"))
						{
							EnterDataInTheField(wi.Risk,TFSUIMap.Risk_txtbox);
						}
						
						
						
						
						//Release and sprint
						try{
						switch(wi.Release){
						case("NA"):
							//do nothing
							break;
						case("None"):
							clickJS(TFSUIMap.Iteration_label);
							Thread.sleep(4000);
							enterText(TFSUIMap.IterationName1_txtbox,Property.getProperty("TFSProject"));
//							clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.IterationValue_drpdown, Property.getProperty("TFSProject"), "projectname"));
							break;
						case("PickFromBaseclass"):
							clickJS(TFSUIMap.Iteration_label);
							Thread.sleep(2000);
							String ReleasePlusSprintName = Property.getProperty("TFSProject")+"\\"+Baseclass.getInstance().TFS_ReleaseName+"\\"+Baseclass.getInstance().TFS_SprintName;
							enterText(TFSUIMap.IterationName1_txtbox,ReleasePlusSprintName);
							sendEntr();
							break;
						default:
							clickJS(TFSUIMap.Iteration_label);
							String IterationDetails = Property.getProperty("TFS Scrum_Client-Native")+"\\"+wi.Release+"\\"+wi.Sprint;
							enterText(TFSUIMap.IterationName1_txtbox, IterationDetails);
							sendEntr();
							break;
						}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							logger.info("issue tagging release/sprint for the workitem");
						}

					
							
				//save and capture workitem ID details
				singleClick(TFSUIMap.save_btn);
				Thread.sleep(5000);
				
						if(!wi.State.equalsIgnoreCase("New"))
						{
							clickJS(TFSUIMap.State_drpdown1);
							clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.StateValues_drpdown, wi.State, "state"));
							Thread.sleep(2000);
							singleClick(TFSUIMap.save_btn);
							Thread.sleep(5000);
						}	
				}
				catch(Exception e)
				{
					e.printStackTrace();
					logger.info("issue entering workitem details for workitem "+workitem);
				}
			}
			
			
		}

		public static void CaptureWorkitemIDForTeamArchitecture(String workitem) {
				
			switch(workitem){
			case("Bug_TeamArchitecture_Scenario1"):
                Baseclass.getInstance().WorkItemExternalId_Bug_TeamArchitecture_Scenario1 = getText(TFSUIMap.captureWorkItemID2_statictxt);
                break;
            case("Action_TeamArchitecture_Scenario1"):
                Baseclass.getInstance().WorkItemExternalId_Action_TeamArchitecture_Scenario1 = getText(TFSUIMap.captureWorkItemID2_statictxt);
                break;
            case("Bug_TeamArchitecture_Scenario2"):
                Baseclass.getInstance().WorkItemExternalId_Bug_TeamArchitecture_Scenario2 = getText(TFSUIMap.captureWorkItemID2_statictxt);
                break;
            case("Action_TeamArchitecture_Scenario2"):
                Baseclass.getInstance().WorkItemExternalId_Action_TeamArchitecture_Scenario2 = getText(TFSUIMap.captureWorkItemID2_statictxt);
                break;
            case("Bug_TeamArchitecture_Scenario3"):
                Baseclass.getInstance().WorkItemExternalId_Bug_TeamArchitecture_Scenario3 = getText(TFSUIMap.captureWorkItemID2_statictxt);
                break;
            case("Action_TeamArchitecture_Scenario3"):
                Baseclass.getInstance().WorkItemExternalId_Action_TeamArchitecture_Scenario3 = getText(TFSUIMap.captureWorkItemID2_statictxt);
                break;
          }
			
		}
			
		}

		
//		public static void AssociateWorkitems(String workitem1, String workitem2, String relationship) {
//			try{
//				String workitemID = Baseclass.getInstance().workitem1;
//				String workitemID1 = API.getWorkItemExternalIDForGivenFunctionality(workitem1,"TFS",functionality);
//			
//				
//				if(CheckIfElementExists(TFSUIMap.Close_btn))
//					clickJS(TFSUIMap.Close_btn);
//				
//				openWorkitemUsingWorkitemID(workitemID);
//				clickJS(TFSUIMap.Links_link);
//				clickJS(TFSUIMap.AddLink_link);
//				clickJS(TFSUIMap.Existingitem_link);
//				clickJS(TFSUIMap.LinkType_drpdown);
////				clickJS(prepareWebElementWithDynamicXpath(TFSUIMap.linkingType_txt, linkingtype, "linkingtype"));
//				enterText(TFSUIMap.LinkType_drpdown,linkingtype);
//				sendEntr();
//				enterText(TFSUIMap.workitemlinking_txtbox,workitemID1);
//				Thread.sleep(5000);
//				if(CheckIfElementExists(TFSUIMap.searchedWorkitem_drpdown)){
////					clickJS(TFSUIMap.SearchBoxHomePage_txtbox);
//					sendEntr();
//				}
//				else
//					logger.info(workitemID1+ " i.e. "+workitem1+" doesnt show up in search in TFS");
//				clickJS(TFSUIMap.Ok_btn);
//				singleClick(TFSUIMap.saveandclose_btn);
//				Thread.sleep(5000);
//				}
//				
//				catch(Exception e)
//				{
//					e.printStackTrace();
//				}
//			}
			
//		}

	
		


	