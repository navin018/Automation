package testobjects;

import static org.testng.Assert.assertTrue;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.io.FileWriter;

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

public class CommonAcrossApps {
	
	public static void loginToJira(){
		try{
			Thread.sleep(3000);
			driver().get(Property.getProperty("JiraURL"));
			waitPageToLoad();
//			Thread.sleep(10000);
			ExpWaitForCondition(JiraUIMap.login_btn);
//			grabScreenshotForExtentReport();
//			if(Property.getProperty("JiraURL").contains("adt"))
//			 click(JiraUIMap.login_btn);
//			 waitPageToLoad();
//			 enterText(JiraUIMap.signIn_txtbox,Property.getProperty("Username"));
//			 click(JiraUIMap.Next_btn);
//			 waitPageToLoad();
//			 enterText(JiraUIMap.signInPwd_txtbox,Property.getProperty("Password"));
////			
//			 click(JiraUIMap.signIn_btn);
//			 Thread.sleep(3000);
//			 ExpWaitForCondition(JiraUIMap.skip_btn);
//			 click(JiraUIMap.skip_btn);
//			 ExpWaitForCondition(JiraUIMap.Yes_btn);
//			 click(JiraUIMap.Yes_btn);
//			
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
				 enterText(MyWizardUIMap.Pwd_txtbox1,Property.getProperty("Password"));
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
					 enterText(MyWizardUIMap.Pwd_txtbox1,Property.getProperty("Password"));
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
				
				
				
				
				
//				if(CheckIfElementExists(MyWizardUIMap.UserAnotherAccount_link))
//					{
//						//if user another account shows up
//						enterText(MyWizardUIMap.signIn_txtbox,Property.getProperty("Username")+"@ds.dev.accenture.com");
//						clickJS(MyWizardUIMap.Next_btn);
//						ExpWaitForCondition(MyWizardUIMap.Pwd_txtbox1);
//						 enterText(MyWizardUIMap.Pwd_txtbox1,Property.getProperty("MyWizard_Password"));
//						 click(MyWizardUIMap.signIn_btn1);
//						 Thread.sleep(10000);
//						
//					}
//				 enterText(JiraUIMap.UserName_txtbox,Property.getProperty("Username"));
//				 enterText(JiraUIMap.Pwd_txtbox,Property.getProperty("Password"));
//				 Thread.sleep(3000);
//				 clickJS(JiraUIMap.login_btn1);	
//			}
////			driver().manage().window().maximize();
//			 waitPageToLoad();
//			 
			 
			
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
				 enterText(MyWizardUIMap.Pwd_txtbox1,Property.getProperty("MyWizard_Password"));
				 click(MyWizardUIMap.signIn_btn1);
				 Thread.sleep(10000);
			}
			
			//if sign in with email id page shows up
			if(CheckIfElementExists(MyWizardUIMap.signIn_txtbox)){
				enterText(MyWizardUIMap.signIn_txtbox, Property.getProperty("MyWizard_Username"));
				clickJS(MyWizardUIMap.Next_btn);
				ExpWaitForCondition(MyWizardUIMap.Pwd_txtbox1);
				 enterText(MyWizardUIMap.Pwd_txtbox1,Property.getProperty("MyWizard_Password"));
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
			 enterText(MyWizardUIMap.Pwd_txtbox1,Property.getProperty("MyWizard_Password"));
			 click(MyWizardUIMap.signIn_btn1);
			 Thread.sleep(10000);
			}
			
			
			
			//if stay signed in page shows up
			if(CheckIfElementExists(MyWizardUIMap.Yes_btn))	
			{
				clickJS(MyWizardUIMap.Yes_btn);
			}
			
//-------------------------------removing this part as we have got a dedicated user id			
////			//check if the creds need to be entered
//			if(CheckIfElementExists(MyWizardUIMap.signIn_txtbox))
//			{
//				enterText(MyWizardUIMap.signIn_txtbox,Property.getProperty("MyWizard_Username"));
//				 click(MyWizardUIMap.Next_btn);
//				 waitPageToLoad();
//				 enterText(MyWizardUIMap.Pwd_txtbox1,Property.getProperty("MyWizard_Password"));
//				 click(MyWizardUIMap.signIn_btn1);
//				 waitPageToLoad();
//				 Thread.sleep(5000);
////				 ExpWaitForCondition(MyWizardUIMap.Yes_btn);
//				 if(CheckIfElementExists(MyWizardUIMap.Yes_btn))
//				 click(MyWizardUIMap.Yes_btn);
//				 Thread.sleep(15000);
//				 waitPageToLoad();
//				 Thread.sleep(5000);
//			}
////	
////			
////			
////			//if creds are forgotten
//			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccount_link, Property.getProperty("MyWizard_Username"), "username")))
//			{ 
//				click(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccount_link, Property.getProperty("MyWizard_Username"), "username"));
//				Thread.sleep(2000);
//				if(CheckIfElementExists(MyWizardUIMap.Pwd_txtbox1))
//					 enterText(MyWizardUIMap.Pwd_txtbox1,Property.getProperty("MyWizard_Password"));
//			 click(MyWizardUIMap.signIn_btn1);
//			 ExpWaitForCondition(MyWizardUIMap.Yes_btn);
//			 click(MyWizardUIMap.Yes_btn);
//			 Thread.sleep(4000);
//			}
//			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			 
//			 //if creds are remembered but needs to be selected
//			 Thread.sleep(10000);
////			 String username = Property.getProperty("MyWizard_Username");
////			 String[] username_sp = username.split("@");
//			 if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccountnew_link, Property.getProperty("MyWizard_Username"), "username")))
//			 {
//				 click(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccountnew_link, Property.getProperty("MyWizard_Username"), "username"));
//					Thread.sleep(5000);
//					if(CheckIfElementExists(MyWizardUIMap.Pwd_txtbox1))
//						 {
//						enterText(MyWizardUIMap.Pwd_txtbox1,Property.getProperty("MyWizard_Password"));
//						 click(MyWizardUIMap.signIn_btn1);
////						 ExpWaitForCondition(MyWizardUIMap.Yes_btn);
////						 click(MyWizardUIMap.Yes_btn);
//						 }
//				 
//				 Thread.sleep(4000);
//			 }
//			 
//			 //if username is already present and password needs to be entered
//			 if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardUIMap.enteredUsername_txtbox, Property.getProperty("MyWizard_Username"), "username")))
//			 {
//				 enterText(MyWizardUIMap.Pwd_txtbox1,Property.getProperty("MyWizard_Password"));
//				 click(MyWizardUIMap.signIn_btn1);
//			 }
			
//-------------------------------removing this part as we have got a dedicated user id	
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
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
	//OG Login with old UI(without @ds.dev.accenture login
//	public static void LoginToMyWizard(){
//		try{
//			
//			driver().get(Property.getProperty("MyWizard_URL"));
//			waitPageToLoad();
//			driver().manage().window().maximize();
			
			//check if the creds need to be entered
//			if(CheckIfElementExists(MyWizardUIMap.signIn_txtbox))
//			{
//				enterText(MyWizardUIMap.signIn_txtbox,Property.getProperty("MyWizard_Username"));
//				 click(MyWizardUIMap.Next_btn);
//				 waitPageToLoad();
//				 enterText(MyWizardUIMap.Pwd_txtbox,Property.getProperty("MyWizard_Password"));
//				 click(MyWizardUIMap.signIn_btn);
//				 waitPageToLoad();
//				 Thread.sleep(5000);
////				 ExpWaitForCondition(MyWizardUIMap.Yes_btn);
//				 if(CheckIfElementExists(MyWizardUIMap.Yes_btn))
//				 click(MyWizardUIMap.Yes_btn);
//				 Thread.sleep(15000);
//				 waitPageToLoad();
//				 Thread.sleep(5000);
//			}
//	
//			
//			
//			//if creds are forgotten
//			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccount_link, Property.getProperty("MyWizard_Username"), "username")))
//			{ 
//				click(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccount_link, Property.getProperty("MyWizard_Username"), "username"));
//				Thread.sleep(2000);
//				if(CheckIfElementExists(MyWizardUIMap.Pwd_txtbox))
//					 enterText(MyWizardUIMap.Pwd_txtbox,Property.getProperty("MyWizard_Password"));
//			 click(MyWizardUIMap.signIn_btn);
//			 ExpWaitForCondition(MyWizardUIMap.Yes_btn);
//			 click(MyWizardUIMap.Yes_btn);
//			 Thread.sleep(4000);
//			}
//			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			 
//			 //if creds are remembered but needs to be selected
//			 Thread.sleep(10000);
//			 String username = Property.getProperty("MyWizard_Username");
//			 String[] username_sp = username.split("@");
//			 if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccount1_link, username_sp[0], "username")))
//			 {
//			 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccount1_link, username_sp[0], "username"));
//			 }
//			 
//			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			 ExpWaitForCondition(MyWizardUIMap.SettingIcon_Image);
//			 
//			//code for AI fusion page
////			 ExpWaitForCondition(MyWizardUIMap.SettingIcon_Image);
////				
////				if(CheckIfElementExists(MyWizardUIMap.SettingIcon_Image))
////					ExpWaitForCondition(MyWizardUIMap.SettingIcon_Image);
////				else
////					Thread.sleep(20000);
////				if(!CheckIfElementExists(MyWizardUIMap.SettingIcon_Image))
////					Assert.fail("My Wizard page is either slow or app is down");
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			Assert.fail("MyWizard page could not be loaded");
//		}
//	
//	
//}
public static void LoginToTFS()
{
	try{
		driver().get(Property.getProperty("TFS_URL"));
		waitPageToLoad();
//		driver().manage().window().maximize();
		Thread.sleep(4000);
		String parent=driver().getWindowHandle();
		driver().switchTo().window(parent);
		ExpWaitForCondition(TFSUIMap.signIn_txtbox);
		enterText(TFSUIMap.signIn_txtbox,Property.getProperty("TFSUsername"));
		 click(TFSUIMap.Next_btn);
		 waitPageToLoad();
		 ExpWaitForCondition(TFSUIMap.Pwd_txtbox);
		 enterText(TFSUIMap.Pwd_txtbox,Property.getProperty("TFSPassword"));
		 click(TFSUIMap.signIn_btn);
		 waitPageToLoad();
		Thread.sleep(10000);
		grabScreenshotForExtentReport();
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
			if(appname.contains("jira") || appname.contains("Jira") || appname.contains("JIRA")){
			  WorkItemEx_FileLoc = System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator
						+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON"+  File.separator + "WorkItemExternalIDs.json";
			
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
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail("could not write workitem IDs for "+appname );
		}
		
		if(appname.equalsIgnoreCase("TFS"))
		{
			try{String WorkItemEx_FileLoc = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON"+ File.separator + "WorkItemExternalIDs.json";
		  
		  
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
	    
//	    jsonObject.put("TFS_ReleaseName",Baseclass.getInstance().TFS_ReleaseName);
//		jsonObject.put("TFS_ReleaseStartDate",Baseclass.getInstance().TFS_ReleaseStartDate);
//		jsonObject.put("TFS_ReleaseEndDate",Baseclass.getInstance().TFS_ReleaseEndDate);
//		jsonObject.put("TFS_SprintName",Baseclass.getInstance().TFS_SprintName);
//		jsonObject.put("TFS_SprintStartDate",Baseclass.getInstance().TFS_SprintStartDate);
//		jsonObject.put("TFS_SprintEndDate",Baseclass.getInstance().TFS_SprintEndDate);
	    
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
		
		if(appname.equalsIgnoreCase("RMP"))
		{
			try{String FileLoc = System.getProperty("user.dir")
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
		 enterText(JiraUIMap.CloudJiraPwd_txtbox,Property.getProperty("Password"));
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
		 enterText(RallyUIMap.password_txtbox,Property.getProperty("Password"));
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
}
