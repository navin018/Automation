package testobjects;

import static org.testng.Assert.assertTrue;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.jcraft.jsch.Logger;

import uiMap.JiraUIMap;
import uiMap.MyWizardUIMap;
import uiMap.RallyUIMap;
import uiMap.TFSUIMap;
import utilities.general.Property;
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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fasterxml.uuid.Generators;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import dataobjects.WorkItemDO;
import dataobjects.WorkItemExternalIDDO;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testobjects.Baseclass;
import uiMap.JiraUIMap;

import utilities.general.DataManager;
import utilities.general.Property;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
public class CommonAcrossApps {
	
	public static void loginToJira(){
		try{
			Thread.sleep(3000);
			driver().get(Property.getProperty("JiraURL"));
			waitPageToLoad();
			
//			grabScreenshotForExtentReport();
			//code change after browser remembering the login details
			String parent=driver().getWindowHandle();
			driver().switchTo().window(parent);
			if(CheckIfElementExists(JiraUIMap.login_btn)){
				clickJS(JiraUIMap.login_btn);
				ExpWaitForCondition(MyWizardUIMap.signIn_txtbox);
				enterText(MyWizardUIMap.signIn_txtbox,Property.getProperty("Username"));
				clickJS(MyWizardUIMap.Next_btn);
				ExpWaitForCondition(MyWizardUIMap.Pwd_txtbox1);
				Thread.sleep(3000);
				 enterText(MyWizardUIMap.Pwd_txtbox1,CommonFunctions.decrypt(Property.getProperty("Password")));
				 click(MyWizardUIMap.signIn_btn1);
				ExpWaitForCondition(MyWizardUIMap.Yes_btn);
						clickJS(MyWizardUIMap.Yes_btn);
			}
			
			if(CheckIfElementExists(MyWizardUIMap.signIn_txtbox)){
				enterText(MyWizardUIMap.signIn_txtbox,Property.getProperty("Username"));
				clickJS(MyWizardUIMap.Next_btn);
				ExpWaitForCondition(MyWizardUIMap.Pwd_txtbox1);
				Thread.sleep(3000);
				 enterText(MyWizardUIMap.Pwd_txtbox1,CommonFunctions.decrypt(Property.getProperty("Password")));
				 click(MyWizardUIMap.signIn_btn1);
				ExpWaitForCondition(MyWizardUIMap.Yes_btn);
						clickJS(MyWizardUIMap.Yes_btn);
			}
			
			
			
			
			
			
			
			
			
			if(CheckIfElementExists(JiraUIMap.login_btn)){
				clickJS(JiraUIMap.login_btn);
				Thread.sleep(10000);
				//if pick an account screen shows up
				if(CheckIfElementExists(prepareWebElementWithDynamicXpath(JiraUIMap.pickAnExistingAccount_statictxt, Property.getProperty("Username"), "username")))
				{
					clickJS(prepareWebElementWithDynamicXpath(JiraUIMap.pickAnExistingAccount_statictxt, Property.getProperty("Username"), "username"));
					ExpWaitForCondition(MyWizardUIMap.Pwd_txtbox1);
					 enterText(MyWizardUIMap.Pwd_txtbox1,CommonFunctions.decrypt(Property.getProperty("Password")));
					 click(MyWizardUIMap.signIn_btn1);
					 Thread.sleep(10000);
					 	if(CheckIfElementExists(JiraUIMap.ConfirmYourIndentity_txt))
					 	{
					 		Assert.fail("login issues to JIRA. need to enter symantec pin");
					 	}
					 	if(CheckIfElementExists(MyWizardUIMap.Yes_btn))	
						{
							clickJS(MyWizardUIMap.Yes_btn);
						}
					 	
				}
			}
				
			
			
			 waitPageToLoad();
//			 grabScreenshotForExtentReport();
			 ExpWaitForCondition(JiraUIMap.Create_link);
			 
			 
			 
			 
			 assertTrue(CheckIfElementExists(JiraUIMap.Create_link));
			 System.out.println("login to jira successful");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			grabScreenshotForExtentReport();
			Assert.fail("Problem logging in to JIRA");
		}
	}
	
	public static void LoginToMyWizard(){
		try{
						
			driver().get(Property.getProperty("MyWizard_URL"));
			waitPageToLoad();
			Thread.sleep(10000);
//			driver().manage().window().maximize();
			
			
			if(CheckIfElementExists(MyWizardUIMap.signInWithUserNameSaved_txtbox)){
				clear(MyWizardUIMap.signInWithUserNameSaved_txtbox);
				enterText(MyWizardUIMap.signInWithUserNameSaved_txtbox, Property.getProperty("MyWizard_Username"));
				 enterText(MyWizardUIMap.Pwd_txtbox1,CommonFunctions.decrypt(Property.getProperty("MyWizard_Password")));
				 click(MyWizardUIMap.signIn_btn1);
				 Thread.sleep(10000);
			}
			
			//if sign in with email id page shows up
			if(CheckIfElementExists(MyWizardUIMap.signIn_txtbox)){
				enterText(MyWizardUIMap.signIn_txtbox, Property.getProperty("MyWizard_Username"));
				clickJS(MyWizardUIMap.Next_btn);
				ExpWaitForCondition(MyWizardUIMap.Pwd_txtbox1);
				 enterText(MyWizardUIMap.Pwd_txtbox1,CommonFunctions.decrypt(Property.getProperty("MyWizard_Password")));
				 click(MyWizardUIMap.signIn_btn1);
				 Thread.sleep(10000);
			}
			
			//if pick an account page shows up
			if(CheckIfElementExists(MyWizardUIMap.PickAnAccount_staticTxt)){
			clickJS(MyWizardUIMap.UserAnotherAccount_link);
			Thread.sleep(5000);
			ExpWaitForCondition(MyWizardUIMap.signIn_txtbox);
			enterText(MyWizardUIMap.signIn_txtbox, Property.getProperty("MyWizard_Username"));
			clickJS(MyWizardUIMap.Next_btn);
			ExpWaitForCondition(MyWizardUIMap.Pwd_txtbox1);
			Thread.sleep(5000);
			 enterText(MyWizardUIMap.Pwd_txtbox1,CommonFunctions.decrypt(Property.getProperty("MyWizard_Password")));
			 click(MyWizardUIMap.signIn_btn1);
//			 Thread.sleep(10000);
			}
			
			
			
			//if stay signed in page shows up
			ExpWaitForCondition(MyWizardUIMap.Yes_btn);	
				clickJS(MyWizardUIMap.Yes_btn);
			

			
//-------------------------------removing this part as we have got a dedicated user id	
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 
			 //notification icon mywizard works best in google chrome
//			 if(CheckIfElementExists(MyWizardUIMap.MywizChromeNotification_btn))
//			 {
//				 clickJS(MyWizardUIMap.MywizChromeNotification_btn);
//			 }
			
		     ExpWaitForCondition(MyWizardUIMap.Dashboard_Checkbox);
		                clickJS(MyWizardUIMap.Dashboard_Checkbox);
		                 clickJS(MyWizardUIMap.Dashboard_Confirm_btn);

			 ExpWaitForCondition(MyWizardUIMap.SettingIcon_Image);
//			 
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("MyWizard page could not be loaded");
			Assert.fail("MyWizard page could not be loaded");
		}
	}
	
public static void LoginToTFS()
{
	try{
		driver().get(Property.getProperty("TFS_URL"));
	
//		driver().manage().window().maximize();
//		Thread.sleep(10000);
		String parent=driver().getWindowHandle();
		driver().switchTo().window(parent);
		if(CheckIfElementExists(MyWizardUIMap.UserAnotherAccount_link))
			clickJS(MyWizardUIMap.UserAnotherAccount_link);
		ExpWaitForCondition(TFSUIMap.signIn_txtbox);
		enterText(TFSUIMap.signIn_txtbox,Property.getProperty("TFSUsername"));
		 click(TFSUIMap.Next_btn);
		 waitPageToLoad();
		 ExpWaitForCondition(TFSUIMap.Pwd_txtbox);
//		 enterText(TFSUIMap.Pwd_txtbox,Property.getProperty("TFSPassword"));
		 enterText(TFSUIMap.Pwd_txtbox,CommonFunctions.decrypt(Property.getProperty("TFSPassword")));
		 click(TFSUIMap.signIn_btn);
		 waitPageToLoad();
//		Thread.sleep(10000);
		 ExpWaitForCondition(TFSUIMap.Yes_btn);       
		 clickJS(TFSUIMap.Yes_btn);
//		grabScreenshotForExtentReport();
		ExpWaitForCondition(TFSUIMap.searchProject_txtbox);
		System.out.println("login to TFS successful");
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		Assert.fail("Could not login to TFS");
	}
}

public static void UpdateWorkItemExternalIDsForApps(String appname)
{

try{
			System.out.println("updating workitemexternalIDs");
			 String WorkItemEx_FileLoc="";
			 String WorkItemEx_FileLoc_ReleaseSprint="";
			if(appname.contains("jira") || appname.contains("Jira") || appname.contains("JIRA")){
			  WorkItemEx_FileLoc = System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator
						+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON"+  File.separator + "WorkItemExternalIDs.json";
			
			  WorkItemEx_FileLoc_ReleaseSprint = System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator
						+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON"+  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json";
			  
			JSONObject jsonObject = new JSONObject();
			JSONObject jsonObject_releaseandsprintdetails = new JSONObject();
			
			
		    jsonObject.put("WorkItemExternalId_Task", Baseclass.getInstance().WorkItemExternalId_Task);
		    jsonObject.put("WorkItemExternalId_Story", Baseclass.getInstance().WorkItemExternalId_Story);
		    jsonObject.put("WorkItemExternalId_Risk", Baseclass.getInstance().WorkItemExternalId_Risk);
		    jsonObject.put("WorkItemExternalId_Issue", Baseclass.getInstance().WorkItemExternalId_Issue);
		    jsonObject.put("WorkItemExternalId_Impediment", Baseclass.getInstance().WorkItemExternalId_Impediment);
		    jsonObject.put("WorkItemExternalId_Feature", Baseclass.getInstance().WorkItemExternalId_Feature);
		    jsonObject.put("WorkItemExternalId_Epic", Baseclass.getInstance().WorkItemExternalId_Epic);
		    jsonObject.put("WorkItemExternalId_Deliverable", Baseclass.getInstance().WorkItemExternalId_Deliverable);
		    jsonObject.put("WorkItemExternalId_Decision", Baseclass.getInstance().WorkItemExternalId_Decision);
		    jsonObject.put("WorkItemExternalId_Bug", Baseclass.getInstance().WorkItemExternalId_Bug);
		    jsonObject.put("WorkItemExternalId_Requirement", Baseclass.getInstance().WorkItemExternalId_Requirement);
		    jsonObject.put("WorkItemExternalId_Test", Baseclass.getInstance().WorkItemExternalId_Test);
		    jsonObject.put("WorkItemExternalId_SubTask", Baseclass.getInstance().WorkItemExternalId_SubTask);
		    jsonObject.put("WorkItemExternalId_Milestone", Baseclass.getInstance().WorkItemExternalId_Milestone);
		    jsonObject.put("WorkItemExternalId_Action", Baseclass.getInstance().WorkItemExternalId_Action);
		    jsonObject.put("WorkItemExternalId_TestExecution", Baseclass.getInstance().WorkItemExternalId_TestExecution);
		    jsonObject.put("WorkItemExternalId_TestCase", Baseclass.getInstance().WorkItemExternalId_TestCase);
		 
		    jsonObject.put("WorkItemExternalId_ReleaseName", Baseclass.getInstance().Jira_ReleaseName);
		    jsonObject.put("WorkItemExternalId_ReleaseStartDate", Baseclass.getInstance().Jira_ReleaseStartDate);
		    jsonObject.put("WorkItemExternalId_ReleaseEndDate", Baseclass.getInstance().Jira_ReleaseEndDate);
		    jsonObject.put("WorkItemExternalId_SprintName", Baseclass.getInstance().Jira_SprintName);
		    jsonObject.put("WorkItemExternalId_SprintStartDate", Baseclass.getInstance().Jira_SprintStartDate);
		    jsonObject.put("WorkItemExternalId_SprintEndDate", Baseclass.getInstance().Jira_SprintEndDate);
		    
		    jsonObject.put("WorkItemExternalId_Team", Baseclass.getInstance().Jira_ComponentName);
		    
		    jsonObject.put("WorkItemExternalId_WorkRequest", Baseclass.getInstance().WorkItemExternalId_WorkRequest);
		    
		    
		     FileWriter file = new FileWriter(WorkItemEx_FileLoc);
	         file.write(jsonObject.toJSONString());
	         file.flush();
	         file.close();
	         
//	         if(!(Baseclass.getInstance().Jira_ReleaseName.isEmpty() || Baseclass.getInstance().Jira_ReleaseName==null || Baseclass.getInstance().Jira_SprintName.isEmpty())) {
	        	 {
	 		    jsonObject_releaseandsprintdetails.put("WorkItemExternalId_ReleaseName", Baseclass.getInstance().Jira_ReleaseName);
	 		    jsonObject_releaseandsprintdetails.put("WorkItemExternalId_ReleaseStartDate", Baseclass.getInstance().Jira_ReleaseStartDate);
	 		    jsonObject_releaseandsprintdetails.put("WorkItemExternalId_ReleaseEndDate", Baseclass.getInstance().Jira_ReleaseEndDate);
	 		    jsonObject_releaseandsprintdetails.put("WorkItemExternalId_SprintName", Baseclass.getInstance().Jira_SprintName);
	 		    jsonObject_releaseandsprintdetails.put("WorkItemExternalId_SprintStartDate", Baseclass.getInstance().Jira_SprintStartDate);
	 		    jsonObject_releaseandsprintdetails.put("WorkItemExternalId_SprintEndDate", Baseclass.getInstance().Jira_SprintEndDate);
	 		    FileWriter file1 = new FileWriter(WorkItemEx_FileLoc_ReleaseSprint);
	 	         file1.write(jsonObject_releaseandsprintdetails.toJSONString());
	 	         file1.flush();
	 	         file1.close();
	 		    }
	       
//	         driver().close();
//	         driver().quit();
		}
		
}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail("could not write workitem IDs for "+appname );
		}
		
		if(appname.equalsIgnoreCase("TFS") || appname.contains("TFS"))
		{
			try{
				String WorkItemEx_FileLoc = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON"+ File.separator + "WorkItemExternalIDs.json";
				 String WorkItemEx_FileLoc_ReleaseSprint = System.getProperty("user.dir")
							+ File.separator + "src" + File.separator + "test" + File.separator
							+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON"+  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json";
		  
		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObject_releaseandsprintdetails = new JSONObject();

	    jsonObject.put("WorkItemExternalId_Task", Baseclass.getInstance().WorkItemExternalId_Task);
	    jsonObject.put("WorkItemExternalId_Story", Baseclass.getInstance().WorkItemExternalId_Story);
	    jsonObject.put("WorkItemExternalId_TestCase", Baseclass.getInstance().WorkItemExternalId_TestCase);
	    jsonObject.put("WorkItemExternalId_TestCase_TE", Baseclass.getInstance().WorkItemExternalId_TestCase_TE);
	    jsonObject.put("WorkItemExternalId_Issue", Baseclass.getInstance().WorkItemExternalId_Issue);
	    jsonObject.put("WorkItemExternalId_Impediment", Baseclass.getInstance().WorkItemExternalId_Impediment);
	    jsonObject.put("WorkItemExternalId_Feature", Baseclass.getInstance().WorkItemExternalId_Feature);
	    jsonObject.put("WorkItemExternalId_Epic",Baseclass.getInstance().WorkItemExternalId_Epic);
	    jsonObject.put("WorkItemExternalId_Story",Baseclass.getInstance().WorkItemExternalId_Story);
	    jsonObject.put("WorkItemExternalId_Bug", Baseclass.getInstance().WorkItemExternalId_Bug);
	    jsonObject.put("WorkItemExternalId_Action", Baseclass.getInstance().WorkItemExternalId_Action);
	    jsonObject.put("WorkItemExternalId_Decision",Baseclass.getInstance().WorkItemExternalId_Decision);
	    jsonObject.put("WorkItemExternalId_Risk", Baseclass.getInstance().WorkItemExternalId_Risk);
	    jsonObject.put("WorkItemExternalId_Deliverable", Baseclass.getInstance().WorkItemExternalId_Deliverable);
	    jsonObject.put("WorkItemExternalId_Milestone", Baseclass.getInstance().WorkItemExternalId_Milestone);
	    jsonObject.put("WorkItemExternalId_Requirement", Baseclass.getInstance().WorkItemExternalId_Requirement);
	    jsonObject.put("WorkItemExternalId_WorkRequest", Baseclass.getInstance().WorkItemExternalId_WorkRequest);
	    
	    
	    
		jsonObject.put("WorkItemExternalId_TestPlan", Baseclass.getInstance().WorkItemExternalId_TestPlan);
		jsonObject.put("WorkItemExternalId_TestCase", Baseclass.getInstance().WorkItemExternalId_TestCase);
		jsonObject.put("RunID", Baseclass.getInstance().RunID);
		jsonObject.put("WorkItemExternalId_TestExecution", Baseclass.getInstance().WorkItemExternalId_TestExecution);
	    
		jsonObject.put("WorkItemExternalId_ReleaseName",Baseclass.getInstance().TFS_ReleaseName);
		jsonObject.put("WorkItemExternalId_ReleaseStartDate",Baseclass.getInstance().TFS_ReleaseStartDate);
		jsonObject.put("WorkItemExternalId_ReleaseEndDate",Baseclass.getInstance().TFS_ReleaseEndDate);
		jsonObject.put("WorkItemExternalId_SprintName",Baseclass.getInstance().TFS_SprintName);
		jsonObject.put("WorkItemExternalId_SprintStartDate",Baseclass.getInstance().TFS_SprintStartDate);
		jsonObject.put("WorkItemExternalId_SprintEndDate",Baseclass.getInstance().TFS_SprintEndDate);
		
		jsonObject.put("Team_Name",Baseclass.getInstance().teamName);
		jsonObject.put("WorkItemExternalId_TeamUId",Baseclass.getInstance().TeamUId);
		
		 FileWriter file = new FileWriter(WorkItemEx_FileLoc);
         file.write(jsonObject.toJSONString());
         file.close();
         

		    
		    if(!(Baseclass.getInstance().TFS_ReleaseName==null || (Baseclass.getInstance().TFS_SprintName==null))){
		    jsonObject_releaseandsprintdetails.put("WorkItemExternalId_ReleaseName",Baseclass.getInstance().TFS_ReleaseName);
		    jsonObject_releaseandsprintdetails.put("WorkItemExternalId_ReleaseStartDate",Baseclass.getInstance().TFS_ReleaseStartDate);
		    jsonObject_releaseandsprintdetails.put("WorkItemExternalId_ReleaseEndDate",Baseclass.getInstance().TFS_ReleaseEndDate);
		    jsonObject_releaseandsprintdetails.put("WorkItemExternalId_SprintName",Baseclass.getInstance().TFS_SprintName);
		    jsonObject_releaseandsprintdetails.put("WorkItemExternalId_SprintStartDate",Baseclass.getInstance().TFS_SprintStartDate);
		    jsonObject_releaseandsprintdetails.put("WorkItemExternalId_SprintEndDate",Baseclass.getInstance().TFS_SprintEndDate);
		
       
	         FileWriter file1 = new FileWriter(WorkItemEx_FileLoc_ReleaseSprint);
	         file1.write(jsonObject_releaseandsprintdetails.toJSONString());
	         file1.flush();
	         file1.close();
	}
			}
			catch (Exception e) {
				e.printStackTrace();
				Assert.fail("could not write workitem IDs for "+appname );
			}
	
	
}	
		
		if(appname.equalsIgnoreCase("RMP"))
		{
			try{
				String FileLoc = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator + "RMP" + File.separator + "JSON"+ File.separator + "ReleaseAndSprintDetails.json";
		  
		  
				JSONObject jsonObject = new JSONObject();
		
			jsonObject.put("ReleaseName",Baseclass.getInstance().RMP_ReleaseName);
			jsonObject.put("ReleaseStartDate",Baseclass.getInstance().RMP_ReleaseStartDate);
			jsonObject.put("ReleaseEndDate",Baseclass.getInstance().RMP_ReleaseEndDate);
			jsonObject.put("SprintName",Baseclass.getInstance().RMP_SprintName);
			jsonObject.put("SprintStartDate",Baseclass.getInstance().RMP_SprintStartDate);
			jsonObject.put("SprintEndDate",Baseclass.getInstance().RMP_SprintEndDate);
			
		
		
	    FileWriter file = new FileWriter(FileLoc);
         file.write(jsonObject.toJSONString());
         file.close();
         driver().close();
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Assert.fail("could not write release and sprint details for "+appname );
	}
		}
		
		if(appname.contains("Rally")){
			try{
			String  WorkItemEx_FileLoc = System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator
						+ "resources" + File.separator + "testdata" + File.separator + "Rally" + File.separator + "JSON"+  File.separator + "WorkItemExternalIDs.json";
			
			JSONObject jsonObject = new JSONObject();
			
			
		    jsonObject.put("WorkItemExternalId_Task", Baseclass.getInstance().WorkItemExternalId_Task);
		    jsonObject.put("WorkItemExternalId_Story", Baseclass.getInstance().WorkItemExternalId_Story);
		    jsonObject.put("WorkItemExternalId_Risk", Baseclass.getInstance().WorkItemExternalId_Risk);
		    jsonObject.put("WorkItemExternalId_Issue", Baseclass.getInstance().WorkItemExternalId_Issue);
		   
		    jsonObject.put("WorkItemExternalId_Feature", Baseclass.getInstance().WorkItemExternalId_Feature);
		    jsonObject.put("WorkItemExternalId_Epic", Baseclass.getInstance().WorkItemExternalId_Epic);
		   
		    jsonObject.put("WorkItemExternalId_Bug", Baseclass.getInstance().WorkItemExternalId_Bug);
		   
		 
		    jsonObject.put("WorkItemExternalId_ReleaseName", Baseclass.getInstance().Jira_ReleaseName);
		    jsonObject.put("WorkItemExternalId_ReleaseStartDate", Baseclass.getInstance().Jira_ReleaseStartDate);
		    jsonObject.put("WorkItemExternalId_ReleaseEndDate", Baseclass.getInstance().Jira_ReleaseEndDate);
		    jsonObject.put("WorkItemExternalId_SprintName", Baseclass.getInstance().Jira_SprintName);
		    jsonObject.put("WorkItemExternalId_Team", Baseclass.getInstance().Jira_ComponentName);
		    
		  
		    
		    FileWriter file = new FileWriter(WorkItemEx_FileLoc);
	         file.write(jsonObject.toJSONString());
	         file.flush();
	         file.close();
//	         driver().close();
//	         driver().quit();
		}
			catch (Exception e) {
				e.printStackTrace();
				Assert.fail("could not write workitem IDs for "+appname );
			}
}
	}

public static void loginToCloudJira() {
try{
	Thread.sleep(3000);
	driver().get("chrome://settings/clearBrowserData");
	driver().get(Property.getProperty("JiraURL"));
	waitPageToLoad();
	ExpWaitForCondition(JiraUIMap.CloudJiraEmailID_txtbox);
		enterText(JiraUIMap.CloudJiraEmailID_txtbox,Property.getProperty("Username"));
		clickJS(JiraUIMap.CloudJiraCtn_btn);
		ExpWaitForCondition(JiraUIMap.CloudJiraPwd_txtbox);
		 enterText(JiraUIMap.CloudJiraPwd_txtbox,CommonFunctions.decrypt(Property.getProperty("Password")));
		 click(JiraUIMap.CloudJiraLogIn_btn);
		 Thread.sleep(10000);
		 ExpWaitForCondition(JiraUIMap.CloudJiraCreate_btn);
}
catch(Exception e)
{
	e.printStackTrace();
	Assert.fail("Issue loading/logging into Cloud Jira");

}
}

public static void LoginToRally() {
	try{
	Thread.sleep(3000);
	driver().get(Property.getProperty("RallyURL"));
	waitPageToLoad();
	ExpWaitForCondition(RallyUIMap.username_txtbox);
		enterText(RallyUIMap.username_txtbox,Property.getProperty("Username"));
		 enterText(RallyUIMap.password_txtbox,CommonFunctions.decrypt(Property.getProperty("Password")));
		 click(RallyUIMap.signin_btn);
		 Thread.sleep(10000);
		 ExpWaitForCondition(RallyUIMap.plan_link);
}
	catch(Exception e)
	{
		e.printStackTrace();
		Assert.fail("issue logging into Rally");
	}
	}

public static void UpdateWorkItemExternalIDsForAppsForMoveProjectOrIssue(String appname) {
	try{
		System.out.println("updating workitemexternalIDs");
		 String WorkItemEx_FileLoc="";
		if(appname.contains("jira") || appname.contains("Jira") || appname.contains("JIRA")){
		  WorkItemEx_FileLoc = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON"+  File.separator + "WorkItemExternalIDsForMoveProjOrIssue.json";
		
		JSONObject jsonObject = new JSONObject();
		
		
	    jsonObject.put("WorkItemExternalId_Task", Baseclass.getInstance().WorkItemExternalId_Task);
	    jsonObject.put("WorkItemExternalId_Story", Baseclass.getInstance().WorkItemExternalId_Story);
	    jsonObject.put("WorkItemExternalId_Risk", Baseclass.getInstance().WorkItemExternalId_Risk);
	    jsonObject.put("WorkItemExternalId_Issue", Baseclass.getInstance().WorkItemExternalId_Issue);
	    jsonObject.put("WorkItemExternalId_Impediment", Baseclass.getInstance().WorkItemExternalId_Impediment);
	    jsonObject.put("WorkItemExternalId_Feature", Baseclass.getInstance().WorkItemExternalId_Feature);
	    jsonObject.put("WorkItemExternalId_Epic", Baseclass.getInstance().WorkItemExternalId_Epic);
	    jsonObject.put("WorkItemExternalId_Deliverable", Baseclass.getInstance().WorkItemExternalId_Deliverable);
	    jsonObject.put("WorkItemExternalId_Bug", Baseclass.getInstance().WorkItemExternalId_Bug);
	    jsonObject.put("WorkItemExternalId_Requirement", Baseclass.getInstance().WorkItemExternalId_Requirement);
	    jsonObject.put("WorkItemExternalId_Test", Baseclass.getInstance().WorkItemExternalId_Test);
	    jsonObject.put("WorkItemExternalId_SubTask", Baseclass.getInstance().WorkItemExternalId_SubTask);
	    jsonObject.put("WorkItemExternalId_Milestone", Baseclass.getInstance().WorkItemExternalId_Milestone);
	    jsonObject.put("WorkItemExternalId_Action", Baseclass.getInstance().WorkItemExternalId_Action);
	    jsonObject.put("WorkItemExternalId_TestExecution", Baseclass.getInstance().WorkItemExternalId_TestExecution);
	  
	    jsonObject.put("WorkItemExternalId_TestCase", Baseclass.getInstance().WorkItemExternalId_TestCase);
	    jsonObject.put("WorkItemExternalId_WorkRequest", Baseclass.getInstance().WorkItemExternalId_WorkRequest);
	 
	    jsonObject.put("WorkItemExternalId_ReleaseName", Baseclass.getInstance().Jira_ReleaseName);
	    jsonObject.put("WorkItemExternalId_ReleaseStartDate", Baseclass.getInstance().Jira_ReleaseStartDate);
	    jsonObject.put("WorkItemExternalId_ReleaseEndDate", Baseclass.getInstance().Jira_ReleaseEndDate);
	    jsonObject.put("WorkItemExternalId_SprintName", Baseclass.getInstance().Jira_SprintName);
	    jsonObject.put("WorkItemExternalId_Team", Baseclass.getInstance().Jira_ComponentName);
	    
	
	    
	    FileWriter file = new FileWriter(WorkItemEx_FileLoc);
         file.write(jsonObject.toJSONString());
         file.flush();
         file.close();
//         driver().close();
//         driver().quit();
	}
	}
	catch (Exception e) {
		e.printStackTrace();
		Assert.fail("could not write workitem IDs for "+appname );
	}
	
	if(appname.equalsIgnoreCase("TFS") || appname.contains("TFS"))
	{
		try{String WorkItemEx_FileLoc = System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON"+ File.separator + "WorkItemExternalIDsForMoveProjOrIssue.json";
	  
	  
	JSONObject jsonObject = new JSONObject();
	

//System.out.println(CommonFunctions.SpiltWorkitem(Baseclass.getInstance().WorkItemExternalId_Bug));
    jsonObject.put("WorkItemExternalId_Task", Baseclass.getInstance().WorkItemExternalId_Task);
    jsonObject.put("WorkItemExternalId_Story", Baseclass.getInstance().WorkItemExternalId_Story);
    jsonObject.put("WorkItemExternalId_TestCase", Baseclass.getInstance().WorkItemExternalId_TestCase);
    jsonObject.put("WorkItemExternalId_TestCase_TE", Baseclass.getInstance().WorkItemExternalId_TestCase_TE);
    jsonObject.put("WorkItemExternalId_Issue", Baseclass.getInstance().WorkItemExternalId_Issue);
    jsonObject.put("WorkItemExternalId_Impediment", Baseclass.getInstance().WorkItemExternalId_Impediment);
    jsonObject.put("WorkItemExternalId_Feature", Baseclass.getInstance().WorkItemExternalId_Feature);
    jsonObject.put("WorkItemExternalId_Epic",Baseclass.getInstance().WorkItemExternalId_Epic);
    jsonObject.put("WorkItemExternalId_Story",Baseclass.getInstance().WorkItemExternalId_Story);
    jsonObject.put("WorkItemExternalId_Bug", Baseclass.getInstance().WorkItemExternalId_Bug);
    jsonObject.put("WorkItemExternalId_Action", Baseclass.getInstance().WorkItemExternalId_Action);
    jsonObject.put("WorkItemExternalId_Decision",Baseclass.getInstance().WorkItemExternalId_Decision);
    jsonObject.put("WorkItemExternalId_Risk", Baseclass.getInstance().WorkItemExternalId_Risk);
    jsonObject.put("WorkItemExternalId_Deliverable", Baseclass.getInstance().WorkItemExternalId_Deliverable);
    jsonObject.put("WorkItemExternalId_Milestone", Baseclass.getInstance().WorkItemExternalId_Milestone);
    jsonObject.put("WorkItemExternalId_Requirement", Baseclass.getInstance().WorkItemExternalId_Requirement);
    jsonObject.put("WorkItemExternalId_WorkRequest", Baseclass.getInstance().WorkItemExternalId_WorkRequest);

    
	jsonObject.put("WorkItemExternalId_ReleaseName",Baseclass.getInstance().TFS_ReleaseName);
	jsonObject.put("WorkItemExternalId_ReleaseStartDate",Baseclass.getInstance().TFS_ReleaseStartDate);
	jsonObject.put("WorkItemExternalId_ReleaseEndDate",Baseclass.getInstance().TFS_ReleaseEndDate);
	jsonObject.put("WorkItemExternalId_SprintName",Baseclass.getInstance().TFS_SprintName);
	jsonObject.put("TFS_SprintStartDate",Baseclass.getInstance().TFS_SprintStartDate);
	jsonObject.put("TFS_SprintEndDate",Baseclass.getInstance().TFS_SprintEndDate);
	
	
	 jsonObject.put("WorkItemExternalId_TestPlan", Baseclass.getInstance().WorkItemExternalId_TestPlan);
	    jsonObject.put("WorkItemExternalId_TestCase", Baseclass.getInstance().WorkItemExternalId_TestCase);
	    jsonObject.put("RunID", Baseclass.getInstance().RunID);
	    jsonObject.put("WorkItemExternalId_TestExecution", Baseclass.getInstance().WorkItemExternalId_TestExecution);
	
    FileWriter file = new FileWriter(WorkItemEx_FileLoc);
     file.write(jsonObject.toJSONString());
     file.close();
     driver().close();
}

catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	Assert.fail("could not write workitem IDs for "+appname );
}
	}
}

public static void UpdateWorkItemExternalIDsForAppsForSpecificFunctionality(String appname, String functionality) {
	try{
		System.out.println("updating workitemexternalIDs");
		 String WorkItemEx_FileLoc="";
		 String WorkItemEx_FileLoc_ReleaseSprint="";
		 String filename = "";
		 if(functionality.equalsIgnoreCase("PreComputation_WSJF"))
			 filename = "WorkItemExternalIDs_PreComputation_WSJF.json";
		 else if(functionality.equalsIgnoreCase("PreComputation_RAG"))
			 filename = "WorkItemExternalIDs_PreComputation_RAG.json";
		 else if(functionality.equalsIgnoreCase("TeamArchitecture"))
			 filename = "WorkItemExternalIDs_TeamArchitecture.json";
		if(appname.contains("jira") || appname.contains("Jira") || appname.contains("JIRA")){
		  WorkItemEx_FileLoc = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON"+  File.separator + filename;
		
//		  WorkItemEx_FileLoc_ReleaseSprint = System.getProperty("user.dir")
//					+ File.separator + "src" + File.separator + "test" + File.separator
//					+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON"+  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json";
		  
		
//		JSONObject jsonObject_releaseandsprintdetails = new JSONObject();
		
		if(functionality.equalsIgnoreCase("PreComputation_WSJF")){
			JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("WorkItemExternalId_Story_wsjf_Multiply_0", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Multiply_0);
		jsonObject.put("WorkItemExternalId_Story_wsjf_Deno_0", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Deno_0);
		jsonObject.put("WorkItemExternalId_Story_wsjf_Nume_0", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Nume_0);
		jsonObject.put("WorkItemExternalId_Story_wsjf_Negative_Int", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Negative_Int);
		jsonObject.put("WorkItemExternalId_Story_wsjf_Decimal_Tool", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Decimal_Tool);
		jsonObject.put("WorkItemExternalId_Story_wsjf_Zero_Tool", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Zero_Tool);
		jsonObject.put("WorkItemExternalId_Story_wsjf_Decimal_Output", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Decimal_Output);
		jsonObject.put("WorkItemExternalId_Story_wsjf_Negative_Int_UpdateWorkitem", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Negative_Int_UpdateWorkitem);
		
		
		
		jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Multiply_0", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Multiply_0);
		jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Deno_0", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Deno_0);
		jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Nume_0", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Nume_0);
		jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Negative_Int", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Negative_Int);
		jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Decimal_Tool", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Decimal_Tool);
		jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Zero_Tool", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Zero_Tool);
		jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Decimal_Output", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Decimal_Output);
		
		
		  FileWriter file = new FileWriter(WorkItemEx_FileLoc);
	         file.write(jsonObject.toJSONString());
	         file.flush();
	         file.close();
		}
		else if(functionality.equalsIgnoreCase("PreComputation_RAG")){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("WorkItemExternalId_Story_RAG_StatusDone_Rule1", Baseclass.getInstance().WorkItemExternalId_Story_RAG_StatusDone_Rule1);
			jsonObject.put("WorkItemExternalId_Story_RAG_StatusInactivate_Rule2", Baseclass.getInstance().WorkItemExternalId_Story_RAG_StatusInactivate_Rule2);
			jsonObject.put("WorkItemExternalId_Story_RAG_NoAssociation_Rule3", Baseclass.getInstance().WorkItemExternalId_Story_RAG_NoAssociation_Rule3);
			jsonObject.put("WorkItemExternalId_Story_RAG_IterationTiming_Rule4", Baseclass.getInstance().WorkItemExternalId_Story_RAG_IterationTiming_Rule4);
			jsonObject.put("WorkItemExternalId_Story_RAG_IterationTiming_Rule5", Baseclass.getInstance().WorkItemExternalId_Story_RAG_IterationTiming_Rule5);
			jsonObject.put("WorkItemExternalId_Story_RAG_AssociatedIterationTiming_Rule7", Baseclass.getInstance().WorkItemExternalId_Story_RAG_AssociatedIterationTiming_Rule7);
			jsonObject.put("WorkItemExternalId_Story_RAG_AssociatedToStory_Rule7", Baseclass.getInstance().WorkItemExternalId_Story_RAG_AssociatedToStory_Rule7);
			jsonObject.put("WorkItemExternalId_Risk_RAG_ToBeAssociatedToStory_Rule10", Baseclass.getInstance().WorkItemExternalId_Risk_RAG_ToBeAssociatedToStory_Rule10);
			jsonObject.put("WorkItemExternalId_Story_RAG_PastIteration_Rule10", Baseclass.getInstance().WorkItemExternalId_Story_RAG_PastIteration_Rule10);
			jsonObject.put("WorkItemExternalId_Risk_RAG_ToBeAssociatedToStory_Rule11", Baseclass.getInstance().WorkItemExternalId_Risk_RAG_ToBeAssociatedToStory_Rule11);
			jsonObject.put("WorkItemExternalId_Story_RAG_IterationTiming_Rule11", Baseclass.getInstance().WorkItemExternalId_Story_RAG_IterationTiming_Rule11);
			
			  FileWriter file = new FileWriter(WorkItemEx_FileLoc);
		         file.write(jsonObject.toJSONString());
		         file.flush();
		         file.close();
		}
		else if(functionality.equalsIgnoreCase("TeamArchitecture")){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("WorkItemExternalId_Bug_TeamArchitecture_Scenario1", Baseclass.getInstance().WorkItemExternalId_Bug_TeamArchitecture_Scenario1);
			jsonObject.put("WorkItemExternalId_Action_TeamArchitecture_Scenario1", Baseclass.getInstance().WorkItemExternalId_Action_TeamArchitecture_Scenario1);
		
		}
	}
	
}
	catch (Exception e) {
		e.printStackTrace();
		Assert.fail("could not write workitem IDs for "+appname );
	}
	
	if(appname.equalsIgnoreCase("TFS") || appname.contains("TFS"))
	{
		try{
			String filename = "";
			 if(functionality.equalsIgnoreCase("PreComputation_WSJF"))
				 filename = "WorkItemExternalIDs_PreComputation_WSJF.json";
			 else if(functionality.equalsIgnoreCase("PreComputation_RAG"))
				 filename = "WorkItemExternalIDs_PreComputation_RAG.json";
			String WorkItemEx_FileLoc = System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON"+ File.separator + filename;
//			 String WorkItemEx_FileLoc_ReleaseSprint = System.getProperty("user.dir")
//						+ File.separator + "src" + File.separator + "test" + File.separator
//						+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON"+  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json";
	  
//	JSONObject jsonObject = new JSONObject();
//	JSONObject jsonObject_releaseandsprintdetails = new JSONObject();

	if(functionality.equalsIgnoreCase("PreComputation_WSJF")){
		JSONObject jsonObject = new JSONObject();
	
	jsonObject.put("WorkItemExternalId_Story_wsjf_Multiply_0", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Multiply_0);
	jsonObject.put("WorkItemExternalId_Story_wsjf_Deno_0", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Deno_0);
	jsonObject.put("WorkItemExternalId_Story_wsjf_Nume_0", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Nume_0);
	jsonObject.put("WorkItemExternalId_Story_wsjf_Negative_Int", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Negative_Int);
	jsonObject.put("WorkItemExternalId_Story_wsjf_Decimal_Tool", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Decimal_Tool);
	jsonObject.put("WorkItemExternalId_Story_wsjf_Zero_Tool", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Zero_Tool);
	jsonObject.put("WorkItemExternalId_Story_wsjf_Decimal_Output", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Decimal_Output);
	jsonObject.put("WorkItemExternalId_Story_wsjf_Negative_Int_UpdateWorkitem", Baseclass.getInstance().WorkItemExternalId_Story_wsjf_Negative_Int_UpdateWorkitem);
	
	
	
	jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Multiply_0", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Multiply_0);
	jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Deno_0", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Deno_0);
	jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Nume_0", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Nume_0);
	jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Negative_Int", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Negative_Int);
	jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Decimal_Tool", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Decimal_Tool);
	jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Zero_Tool", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Zero_Tool);
	jsonObject.put("WorkItemExternalId_Deliverable_wsjf_Decimal_Output", Baseclass.getInstance().WorkItemExternalId_Deliverable_wsjf_Decimal_Output);
	
	
	 FileWriter file = new FileWriter(WorkItemEx_FileLoc);
     file.write(jsonObject.toJSONString());
     file.close();
	}
	
	else if(functionality.equalsIgnoreCase("PreComputation_RAG")){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("WorkItemExternalId_Story_RAG_StatusDone_Rule1", Baseclass.getInstance().WorkItemExternalId_Story_RAG_StatusDone_Rule1);
		jsonObject.put("WorkItemExternalId_Story_RAG_StatusInactivate_Rule2", Baseclass.getInstance().WorkItemExternalId_Story_RAG_StatusInactivate_Rule2);
		jsonObject.put("WorkItemExternalId_Story_RAG_NoAssociation_Rule3", Baseclass.getInstance().WorkItemExternalId_Story_RAG_NoAssociation_Rule3);
		jsonObject.put("WorkItemExternalId_Story_RAG_IterationTiming_Rule4", Baseclass.getInstance().WorkItemExternalId_Story_RAG_IterationTiming_Rule4);
		jsonObject.put("WorkItemExternalId_Story_RAG_IterationTiming_Rule5", Baseclass.getInstance().WorkItemExternalId_Story_RAG_IterationTiming_Rule5);
		
		jsonObject.put("WorkItemExternalId_Story_RAG_AssociatedIterationTiming_Rule7", Baseclass.getInstance().WorkItemExternalId_Story_RAG_AssociatedIterationTiming_Rule7);
		jsonObject.put("WorkItemExternalId_Story_RAG_AssociatedToStory_Rule7", Baseclass.getInstance().WorkItemExternalId_Story_RAG_AssociatedToStory_Rule7);
		jsonObject.put("WorkItemExternalId_Risk_RAG_ToBeAssociatedToStory_Rule10", Baseclass.getInstance().WorkItemExternalId_Risk_RAG_ToBeAssociatedToStory_Rule10);
		jsonObject.put("WorkItemExternalId_Story_RAG_PastIteration_Rule10", Baseclass.getInstance().WorkItemExternalId_Story_RAG_PastIteration_Rule10);
		jsonObject.put("WorkItemExternalId_Risk_RAG_ToBeAssociatedToStory_Rule11", Baseclass.getInstance().WorkItemExternalId_Risk_RAG_ToBeAssociatedToStory_Rule11);
		jsonObject.put("WorkItemExternalId_Story_RAG_IterationTiming_Rule11", Baseclass.getInstance().WorkItemExternalId_Story_RAG_IterationTiming_Rule11);
		
		
		
		
		  FileWriter file = new FileWriter(WorkItemEx_FileLoc);
	         file.write(jsonObject.toJSONString());
	         file.flush();
	         file.close();
	}
	else if(functionality.equalsIgnoreCase("TeamArchitecture")){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("WorkItemExternalId_Bug_TeamArchitecture_Scenario1", Baseclass.getInstance().WorkItemExternalId_Bug_TeamArchitecture_Scenario1);
		jsonObject.put("WorkItemExternalId_Action_TeamArchitecture_Scenario1", Baseclass.getInstance().WorkItemExternalId_Action_TeamArchitecture_Scenario1);
	
	}
	}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail("could not write workitem IDs for "+appname );
		}
	
}

}

public static void LogOutFromMyWizard() throws IOException, InterruptedException {
	 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
	 ExpWaitForCondition(MyWizardUIMap.UserID_link);
	 clickJS(MyWizardUIMap.UserID_link);
	 ExpWaitForCondition(MyWizardUIMap.SignOut_btn);
	 clickJS(MyWizardUIMap.SignOut_btn);
	 Thread.sleep(10000);
	 if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardUIMap.LogOutfromUser_txt, Property.getProperty("MyWizard_Username"), "username")))
	 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.LogOutfromUser_txt, Property.getProperty("MyWizard_Username"), "username"));
	ExpWaitForCondition(MyWizardUIMap.SignOutSuccessful_msg);
}

public static void UpdateSpecificEntityID(String entity, String appname) {
	try{
	 String WorkItemEx_FileLoc="";
	 String WorkItemEx_FileLoc_ReleaseSprint="";
	 String tool="";
	if(appname.contains("jira") || appname.contains("Jira") || appname.contains("JIRA"))
		tool="Jira";
	else if(appname.equalsIgnoreCase("TFS") || appname.contains("TFS"))
		tool="TFS";
		  WorkItemEx_FileLoc = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator + tool + File.separator + "JSON"+  File.separator + "WorkItemExternalIDs.json";
		
		  WorkItemEx_FileLoc_ReleaseSprint = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator + tool + File.separator + "JSON"+  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json";
		  
			FileReader reader = new FileReader(WorkItemEx_FileLoc);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        
        
	switch(entity){
	case("Task"):
		  jsonObject.put("WorkItemExternalId_Task", Baseclass.getInstance().WorkItemExternalId_Task);    
		break;
	
	case("Story"):
		 jsonObject.put("WorkItemExternalId_Story", Baseclass.getInstance().WorkItemExternalId_Story);
		break;

	case("TestCase"):
		jsonObject.put("WorkItemExternalId_TestCase", Baseclass.getInstance().WorkItemExternalId_TestCase);
	break;
	
	case("Issue"):
		jsonObject.put("WorkItemExternalId_Issue", Baseclass.getInstance().WorkItemExternalId_Issue);
		break;
	
	case("Impediment"):
		jsonObject.put("WorkItemExternalId_Impediment", Baseclass.getInstance().WorkItemExternalId_Impediment);
		break;
	
	case("Feature"):
		   jsonObject.put("WorkItemExternalId_Feature", Baseclass.getInstance().WorkItemExternalId_Feature);
		break;
	
	case("Epic"):
		  jsonObject.put("WorkItemExternalId_Epic",Baseclass.getInstance().WorkItemExternalId_Epic);
		break;
	
	case("Bug"):
			jsonObject.put("WorkItemExternalId_Bug", Baseclass.getInstance().WorkItemExternalId_Bug);
		break;
	
	case("Action"):
		jsonObject.put("WorkItemExternalId_Action", Baseclass.getInstance().WorkItemExternalId_Action);
		break;
	
	case("Decision"):
		jsonObject.put("WorkItemExternalId_Decision",Baseclass.getInstance().WorkItemExternalId_Decision);
		break;
	
	case("Risk"):
		jsonObject.put("WorkItemExternalId_Risk", Baseclass.getInstance().WorkItemExternalId_Risk);
			break;
	
	case("Deliverable"):
		jsonObject.put("WorkItemExternalId_Deliverable", Baseclass.getInstance().WorkItemExternalId_Deliverable);
		break;
	
	case("Milestone"):
		jsonObject.put("WorkItemExternalId_Milestone", Baseclass.getInstance().WorkItemExternalId_Milestone);
		break;
	
	case("Requirement"):
		jsonObject.put("WorkItemExternalId_Requirement", Baseclass.getInstance().WorkItemExternalId_Requirement);
			break;
	
	case("WorkRequest"):
	case ("Work Request"):
		jsonObject.put("WorkItemExternalId_WorkRequest", Baseclass.getInstance().WorkItemExternalId_WorkRequest);
		break;
	
	case("Release"):
		{
		FileReader reader1 = new FileReader(WorkItemEx_FileLoc_ReleaseSprint);
		JSONParser jsonParser1 = new JSONParser();
		JSONObject jsonObject1 = (JSONObject) jsonParser1.parse(reader1);
		
			if(tool.contains("TFS") || tool.contains("tfs"))
			{
			jsonObject.put("WorkItemExternalId_ReleaseName",Baseclass.getInstance().TFS_ReleaseName);
			jsonObject.put("WorkItemExternalId_ReleaseStartDate",Baseclass.getInstance().TFS_ReleaseStartDate);
			jsonObject.put("WorkItemExternalId_ReleaseEndDate",Baseclass.getInstance().TFS_ReleaseEndDate);
			}else if(tool.contains("Jira") || tool.contains("JIRA")){
				jsonObject.put("WorkItemExternalId_ReleaseName",Baseclass.getInstance().Jira_ReleaseName);
				jsonObject.put("WorkItemExternalId_ReleaseStartDate",Baseclass.getInstance().Jira_ReleaseStartDate);
				jsonObject.put("WorkItemExternalId_ReleaseEndDate",Baseclass.getInstance().Jira_ReleaseEndDate);
			}
			 FileOutputStream outputStream = new FileOutputStream(WorkItemEx_FileLoc_ReleaseSprint);
				byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
		}
		break;
	
	case("Sprint"):{
		
		FileReader reader1 = new FileReader(WorkItemEx_FileLoc_ReleaseSprint);
		JSONParser jsonParser1 = new JSONParser();
		JSONObject jsonObject1 = (JSONObject) jsonParser1.parse(reader1);
		
		if(tool.contains("TFS") || tool.contains("tfs")){
			jsonObject.put("WorkItemExternalId_SprintName",Baseclass.getInstance().TFS_SprintName);
			jsonObject.put("WorkItemExternalId_SprintStartDate",Baseclass.getInstance().TFS_SprintStartDate);
			jsonObject.put("WorkItemExternalId_SprintEndDate",Baseclass.getInstance().TFS_SprintEndDate);
			}else if(tool.contains("Jira") || tool.contains("JIRA")){
				jsonObject.put("WorkItemExternalId_SprintName",Baseclass.getInstance().Jira_SprintName);
				jsonObject.put("WorkItemExternalId_SprintStartDate",Baseclass.getInstance().Jira_SprintStartDate);
				jsonObject.put("WorkItemExternalId_SprintEndDate",Baseclass.getInstance().Jira_SprintEndDate);
			}
				FileOutputStream outputStream = new FileOutputStream(WorkItemEx_FileLoc_ReleaseSprint);
					byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
			}
		break;
	case("Team"):{
		jsonObject.put("Team_Name",Baseclass.getInstance().teamName);
		jsonObject.put("WorkItemExternalId_TeamUId",Baseclass.getInstance().TeamUId);
		}
		break;
		
		}
	
	 FileOutputStream outputStream = new FileOutputStream(WorkItemEx_FileLoc);
		byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
		   	

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public static void UpdateSpecificEntityIDForSpecificFunctionality(String entity, String appname,String functionality) {
	
	try{
	String WorkItemEx_FileLoc="";
	 String WorkItemEx_FileLoc_ReleaseSprint="";
	 String tool="";
	 String filetoupdate =""; 
	
	 //check the tool and update the file
	 if(appname.contains("jira") || appname.contains("Jira") || appname.contains("JIRA"))
		tool="Jira";
	else if(appname.equalsIgnoreCase("TFS") || appname.contains("TFS"))
		tool="TFS";
	
	//check functionality and update file
	if(functionality.equalsIgnoreCase("TeamArchitecture"))
		filetoupdate="WorkItemExternalIDs_TeamArchitecture.json";
	
	
		  WorkItemEx_FileLoc = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator + tool + File.separator + "JSON"+  File.separator + filetoupdate;
		
		  //ignore
		  WorkItemEx_FileLoc_ReleaseSprint = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator + tool + File.separator + "JSON"+  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json";
		  
			FileReader reader = new FileReader(WorkItemEx_FileLoc);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
       
       
	switch(entity){
	case("Task"):
		  jsonObject.put("WorkItemExternalId_Task", Baseclass.getInstance().WorkItemExternalId_Task);    
		break;
	
	case("Story"):
		 jsonObject.put("WorkItemExternalId_Story", Baseclass.getInstance().WorkItemExternalId_Story);
		break;

	case("TestCase"):
		jsonObject.put("WorkItemExternalId_TestCase", Baseclass.getInstance().WorkItemExternalId_TestCase);
	break;
	
	case("Issue"):
		jsonObject.put("WorkItemExternalId_Issue", Baseclass.getInstance().WorkItemExternalId_Issue);
		break;
	
	case("Impediment"):
		jsonObject.put("WorkItemExternalId_Impediment", Baseclass.getInstance().WorkItemExternalId_Impediment);
		break;
	
	case("Feature"):
		   jsonObject.put("WorkItemExternalId_Feature", Baseclass.getInstance().WorkItemExternalId_Feature);
		break;
	
	case("Epic"):
		  jsonObject.put("WorkItemExternalId_Epic",Baseclass.getInstance().WorkItemExternalId_Epic);
		break;
	
	case("Bug"):
			jsonObject.put("WorkItemExternalId_Bug", Baseclass.getInstance().WorkItemExternalId_Bug);
		break;
	
	case("Action"):
		jsonObject.put("WorkItemExternalId_Action", Baseclass.getInstance().WorkItemExternalId_Action);
		break;
	
	case("Decision"):
		jsonObject.put("WorkItemExternalId_Decision",Baseclass.getInstance().WorkItemExternalId_Decision);
		break;
	
	case("Risk"):
		jsonObject.put("WorkItemExternalId_Risk", Baseclass.getInstance().WorkItemExternalId_Risk);
			break;
	
	case("Deliverable"):
		jsonObject.put("WorkItemExternalId_Deliverable", Baseclass.getInstance().WorkItemExternalId_Deliverable);
		break;
	
	case("Milestone"):
		jsonObject.put("WorkItemExternalId_Milestone", Baseclass.getInstance().WorkItemExternalId_Milestone);
		break;
	
	case("Requirement"):
		jsonObject.put("WorkItemExternalId_Requirement", Baseclass.getInstance().WorkItemExternalId_Requirement);
			break;
	
	case("WorkRequest"):
	case ("Work Request"):
		jsonObject.put("WorkItemExternalId_WorkRequest", Baseclass.getInstance().WorkItemExternalId_WorkRequest);
		break;
	
	case("Release"):
		{
		FileReader reader1 = new FileReader(WorkItemEx_FileLoc_ReleaseSprint);
		JSONParser jsonParser1 = new JSONParser();
		JSONObject jsonObject1 = (JSONObject) jsonParser1.parse(reader1);
		
			if(tool.contains("TFS") || tool.contains("tfs"))
			{
			jsonObject.put("WorkItemExternalId_ReleaseName",Baseclass.getInstance().TFS_ReleaseName);
			jsonObject.put("WorkItemExternalId_ReleaseStartDate",Baseclass.getInstance().TFS_ReleaseStartDate);
			jsonObject.put("WorkItemExternalId_ReleaseEndDate",Baseclass.getInstance().TFS_ReleaseEndDate);
			}else if(tool.contains("Jira") || tool.contains("JIRA")){
				jsonObject.put("WorkItemExternalId_ReleaseName",Baseclass.getInstance().Jira_ReleaseName);
				jsonObject.put("WorkItemExternalId_ReleaseStartDate",Baseclass.getInstance().Jira_ReleaseStartDate);
				jsonObject.put("WorkItemExternalId_ReleaseEndDate",Baseclass.getInstance().Jira_ReleaseEndDate);
			}
			 FileOutputStream outputStream = new FileOutputStream(WorkItemEx_FileLoc_ReleaseSprint);
				byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
		}
		break;
	
	case("Sprint"):{
		
		FileReader reader1 = new FileReader(WorkItemEx_FileLoc_ReleaseSprint);
		JSONParser jsonParser1 = new JSONParser();
		JSONObject jsonObject1 = (JSONObject) jsonParser1.parse(reader1);
		
		if(tool.contains("TFS") || tool.contains("tfs")){
			jsonObject.put("WorkItemExternalId_SprintName",Baseclass.getInstance().TFS_SprintName);
			jsonObject.put("WorkItemExternalId_SprintStartDate",Baseclass.getInstance().TFS_SprintStartDate);
			jsonObject.put("WorkItemExternalId_SprintEndDate",Baseclass.getInstance().TFS_SprintEndDate);
			}else if(tool.contains("Jira") || tool.contains("JIRA")){
				jsonObject.put("WorkItemExternalId_SprintName",Baseclass.getInstance().Jira_SprintName);
				jsonObject.put("WorkItemExternalId_SprintStartDate",Baseclass.getInstance().Jira_SprintStartDate);
				jsonObject.put("WorkItemExternalId_SprintEndDate",Baseclass.getInstance().Jira_SprintEndDate);
			}
				FileOutputStream outputStream = new FileOutputStream(WorkItemEx_FileLoc_ReleaseSprint);
					byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
			}
		break;
	case("Team"):{
		jsonObject.put("Team_Name",Baseclass.getInstance().teamName);
		jsonObject.put("WorkItemExternalId_TeamUId",Baseclass.getInstance().TeamUId);
		}
		break;
	
	case("Team01"):{
		jsonObject.put("WorkItemExternalId_Teame01",Baseclass.getInstance().teamName);
		
		}
		break;
	case("TeamUId01"):{
		
		jsonObject.put("WorkItemExternalId_TeamUId01",Baseclass.getInstance().TeamUId);
		}
		break;
	case("TeamExternalId01"):{
		
		jsonObject.put("WorkItemExternalId_TeamExternalId01",Baseclass.getInstance().TeamExternalID);
		}
		break;
	
	case("Team02"):{
		jsonObject.put("WorkItemExternalId_Teame02",Baseclass.getInstance().teamName);
		
		}
		break;
	case("TeamUId02"):{
		
		jsonObject.put("WorkItemExternalId_TeamUId02",Baseclass.getInstance().TeamUId);
		}
		break;
	case("TeamExternalId02"):{
		
		jsonObject.put("WorkItemExternalId_TeamExternalId02",Baseclass.getInstance().TeamExternalID);
		}
		break;
		
		}
	

	
	
	 FileOutputStream outputStream = new FileOutputStream(WorkItemEx_FileLoc);
		byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
		   	

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
}
