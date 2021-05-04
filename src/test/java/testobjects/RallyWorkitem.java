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
import uiMap.RallyUIMap;
import uiMap.TFSUIMap;
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

	public class RallyWorkitem extends Baseclass{
		private Baseclass base;
	
		public RallyWorkitem()
		{
			
		}
		
		public RallyWorkitem(Baseclass base) {
			this.base =base; 
		}
		
		public static String testDataPath = System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "testdata" + File.separator + "Rally" + File.separator + "JSON" +  File.separator;
		
		 public static String workitem_title;

		public static void SelectProjectForrally(String projectname) {

		try{
			clickJS(RallyUIMap.SelectProject_dropdown);
			Thread.sleep(2000);
			System.out.println(Property.getProperty("Project"));
			clickJS(prepareWebElementWithDynamicXpath(RallyUIMap.SelectAProjectFromDrpdown_drpdown,Property.getProperty("Project"),"projname"));
			ExpWaitForCondition(prepareWebElementWithDynamicXpath(RallyUIMap.SelectedProjSeen_Statictxt,Property.getProperty("Project"),"projname"));
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Assert.fail("issue selecting project for Rally");
			}
			
		}

		public static void createworkitem(String workItem) {
			try{
				WorkItemDO wi = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(workItem);
			
			 workitem_title = wi.Summary;
			
			clickJS(RallyUIMap.AddNew_btn);
			ExpWaitForCondition(RallyUIMap.NameClick_txtBox);
			singleClick(RallyUIMap.NameClick_txtBox);
//			click(RallyUIMap.Name_txtBox);
			enterText(RallyUIMap.Name_txtBox, workitem_title);
			Thread.sleep(2000);
			clickJS(RallyUIMap.Create_btn);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		public static void CaptureWorkitemID(String workitem) throws InterruptedException {
		ExpWaitForCondition(RallyUIMap.CofirmWorkitemAdded_Msg);
		String workitemID = getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0];
//			System.out.println(workitem + "id is "+workitemID);
			Thread.sleep(3000);
			try {
				String workitem_sp[] = workitem.split("_");
				switch(workitem_sp[0].toLowerCase()){
				
				case "bug":
				
						Baseclass.getInstance().WorkItemExternalId_Bug = getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0];
						System.out.println(workitem+" id is "+getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0]);
//						click(TFSUIMap.close_btn);
						break;
				case "epic":
				
						Baseclass.getInstance().WorkItemExternalId_Epic =  getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0];
						System.out.println(workitem+" id is "+getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0]);
//						click(TFSUIMap.close_btn);
						break;
				case "risk":
					
					Baseclass.getInstance().WorkItemExternalId_Risk =  getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0];
					System.out.println(workitem+" id is "+getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0]);
//					click(TFSUIMap.close_btn);
					break;
				case "feature":
				
						Baseclass.getInstance().WorkItemExternalId_Feature =getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0];
						System.out.println(workitem+" id is "+getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0]);
//						click(TFSUIMap.close_btn);
						break;
			
				case "task":
				
						Baseclass.getInstance().WorkItemExternalId_Task =getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0];
						System.out.println(workitem+" id is "+getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0]);
//						click(TFSUIMap.close_btn);
						break;
				case "story":
				case "user story":
				
						Baseclass.getInstance().WorkItemExternalId_Story =getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0];
						System.out.println(workitem+" id is "+getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0]);
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

		public static void CreateRelease() {
			try{
				WorkItemDO wi = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get("Release_01");
				
				 workitem_title = wi.Summary;
				
			clickJS(RallyUIMap.plan_link);
			clickJS(RallyUIMap.Timeboxes_link);
			clickJS(RallyUIMap.Timesboxes_drpdown);
//			clickJS(RallyUIMap.TimesboxesDrpdownSelectRelease_drpdown);
			clickJS(RallyUIMap.SelectReleaseFromDrpdown);
			Thread.sleep(5000);
//			ExpWaitForCondition(RallyUIMap.AddNew_btn);
			clickJS(RallyUIMap.AddNew_btn);
			Thread.sleep(5000);
//			ExpWaitForCondition(RallyUIMap.Name_txtBox);
			doubleClick(RallyUIMap.Name_txtBox);
			enterText(RallyUIMap.Name_txtBox, wi.ReleaseName);
			singleClick(RallyUIMap.ReleaseStartDate_DatePicker);
			singleClick(RallyUIMap.NextMonth_DatePicker);
			singleClick(RallyUIMap.PickDayOneofMonth_DatePicker);
			singleClick(RallyUIMap.ReleaseEndDate_DatePicker);
			singleClick(RallyUIMap.NextMonthForReleaseEndDate_DatePicker);
			singleClick(RallyUIMap.PickDayTwoofMonth_DatePicker);
			System.out.println(getAttribute(RallyUIMap.getReleaseEndDate_txt, "value"));
			System.out.println(getAttribute(RallyUIMap.getReleaseStartDate_txt, "value"));
			singleClick(RallyUIMap.State_DrpDown);
			singleClick(RallyUIMap.Planning_link);
			singleClick(RallyUIMap.Create_btn);
			ExpWaitForCondition(RallyUIMap.CofirmWorkitemAdded_Msg);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		public static void openworkitem(String workitem) {
			try{
			ExpWaitForCondition(RallyUIMap.plan_link);
			clickJS(RallyUIMap.plan_link);
			clickJS(RallyUIMap.userStories_link);
			Thread.sleep(5000);
			ExpWaitForCondition(RallyUIMap.SearchWorkitem_txtbox);
			String WorkItemExternalId = Tools.getWorkItemExternalID(workitem.split("_")[0],"Rally");
			enterText(RallyUIMap.SearchWorkitem_txtbox, WorkItemExternalId);
			ExpWaitForCondition(prepareWebElementWithDynamicXpath(RallyUIMap.SearchResultforWorkitem_txt, WorkItemExternalId, "workitemid"));
			clickJS(prepareWebElementWithDynamicXpath(RallyUIMap.SearchResultforWorkitem_txt, WorkItemExternalId, "workitemid"));
			ExpWaitForCondition(RallyUIMap.WorkitemopenedSuccess_txt);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Assert.fail("issue opening workitem in rally");
				logger.info("issue opening workitem in rally");
			}
		}

		public static void changeStatus(String status) {
			clickJS(RallyUIMap.changeStatusToNext_icon);
			clickJS(RallyUIMap.SaveWorkitem_btn);
			
			
		}
	

	

	}