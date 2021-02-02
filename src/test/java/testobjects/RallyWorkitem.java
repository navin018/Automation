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
			click(RallyUIMap.Create_btn);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		public static void CaptureWorkitemID(String workitem) {
		ExpWaitForCondition(RallyUIMap.CofirmWorkitemAdded_Msg);
		String workitemID = getText(RallyUIMap.GetWorkitemID_StaticTxt).split(":")[0];
			System.out.println(workitem + "id is "+workitemID);
		}

		public static void CreateRelease() {
			clickJS(RallyUIMap.plan_link);
			clickJS(RallyUIMap.Timeboxes_link);
			clickJS(RallyUIMap.Timesboxes_drpdown);
//			clickJS(RallyUIMap.iter);
			
		}
	

	

	}