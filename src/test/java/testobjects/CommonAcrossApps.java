package testobjects;

import static org.testng.Assert.assertTrue;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;

import uiMap.JiraUIMap;
import uiMap.MyWizardUIMap;
import uiMap.TFSUIMap;
import utilities.general.Property;

public class CommonAcrossApps {
	
	public static void loginToJira(){
		try{
			Thread.sleep(3000);
			sendEsc();
			driver().get(Property.getProperty("JiraURL"));
			waitPageToLoad();
		
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
			
			//code change after browser remembering the login details
			
			if(CheckIfElementExists(JiraUIMap.login_btn))
				clickJS(JiraUIMap.login_btn);
			driver().manage().window().maximize();
			 waitPageToLoad();
			 
			 
			
			 waitPageToLoad();
			 ExpWaitForCondition(JiraUIMap.Create_link);
			 
			 
			 
			 
			 assertTrue(CheckIfElementExists(JiraUIMap.Create_link));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Problem logging in to JIRA");
		}
	}
	
	public static void LoginToMyWizard(){
		try{
			driver().get(Property.getProperty("MyWizard_URL"));
			waitPageToLoad();
			driver().manage().window().maximize();
			
			//check if the creds need to be entered
			if(CheckIfElementExists(MyWizardUIMap.signIn_txtbox))
			{
				enterText(MyWizardUIMap.signIn_txtbox,Property.getProperty("MyWizard_Username"));
				 click(MyWizardUIMap.Next_btn);
				 waitPageToLoad();
				 enterText(MyWizardUIMap.Pwd_txtbox,Property.getProperty("MyWizard_Password"));
				 click(MyWizardUIMap.signIn_btn);
				 waitPageToLoad();
				 Thread.sleep(5000);
//				 ExpWaitForCondition(MyWizardUIMap.Yes_btn);
				 if(CheckIfElementExists(MyWizardUIMap.Yes_btn))
				 click(MyWizardUIMap.Yes_btn);
				 Thread.sleep(15000);
				 waitPageToLoad();
				 Thread.sleep(5000);
			}
	
			
			
			//if creds are forgotten
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccount_link, Property.getProperty("MyWizard_Username"), "username")))
			{ 
				click(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccount_link, Property.getProperty("MyWizard_Username"), "username"));
			 click(MyWizardUIMap.signIn_btn);
			 ExpWaitForCondition(MyWizardUIMap.Yes_btn);
			 click(MyWizardUIMap.Yes_btn);
			 Thread.sleep(4000);
			}
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 
			//code for AI fusion page
//			 ExpWaitForCondition(MyWizardUIMap.SettingIcon_Image);
//				
//				if(CheckIfElementExists(MyWizardUIMap.SettingIcon_Image))
//					ExpWaitForCondition(MyWizardUIMap.SettingIcon_Image);
//				else
//					Thread.sleep(20000);
//				if(!CheckIfElementExists(MyWizardUIMap.SettingIcon_Image))
//					Assert.fail("My Wizard page is either slow or app is down");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("MyWizard page could not be loaded");
		}
	
	
}
public static void LoginToTFS()
{
	try{
		driver().get(Property.getProperty("TFS_URL"));
		waitPageToLoad();
		driver().manage().window().maximize();
		enterText(TFSUIMap.signIn_txtbox,Property.getProperty("TFSUsername"));
		 click(TFSUIMap.Next_btn);
		 waitPageToLoad();
		 enterText(TFSUIMap.Pwd_txtbox,Property.getProperty("TFSPassword"));
		 click(TFSUIMap.signIn_btn);
		 waitPageToLoad();
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
			
			if(appname.equalsIgnoreCase("jira")){
			  String WorkItemEx_FileLoc = System.getProperty("user.dir")
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
		    
		    jsonObject.put("WorkItemExternalId_ReleaseName", Baseclass.getInstance().Jira_ReleaseName);
		    jsonObject.put("WorkItemExternalId_ReleaseStartDate", Baseclass.getInstance().Jira_ReleaseStartDate);
		    jsonObject.put("WorkItemExternalId_ReleaseEndDate", Baseclass.getInstance().Jira_ReleaseEndDate);
		    jsonObject.put("WorkItemExternalId_SprintName", Baseclass.getInstance().Jira_SprintName);
		    jsonObject.put("WorkItemExternalId_Team", Baseclass.getInstance().Jira_ComponentName);
		    
		  
		    FileWriter file = new FileWriter(WorkItemEx_FileLoc);
	         file.write(jsonObject.toJSONString());
	         file.close();
	         driver().close();
	         driver().quit();
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
	    jsonObject.put("WorkItemExternalId_Task", CommonFunctions.SpiltWorkitem(Baseclass.getInstance().WorkItemExternalId_Task));
	    jsonObject.put("WorkItemExternalId_Story", CommonFunctions.SpiltWorkitem(Baseclass.getInstance().WorkItemExternalId_Story));
	    jsonObject.put("WorkItemExternalId_TestCase", CommonFunctions.SpiltWorkitem(Baseclass.getInstance().WorkItemExternalId_TestCase));
	    jsonObject.put("WorkItemExternalId_Issue", CommonFunctions.SpiltWorkitem(Baseclass.getInstance().WorkItemExternalId_Issue));
	    jsonObject.put("WorkItemExternalId_Impediment", CommonFunctions.SpiltWorkitem(Baseclass.getInstance().WorkItemExternalId_Impediment));
	    jsonObject.put("WorkItemExternalId_Feature", CommonFunctions.SpiltWorkitem(Baseclass.getInstance().WorkItemExternalId_Feature));
	    jsonObject.put("WorkItemExternalId_Epic", CommonFunctions.SpiltWorkitem(Baseclass.getInstance().WorkItemExternalId_Epic));
	    jsonObject.put("WorkItemExternalId_ProductBacklog", CommonFunctions.SpiltWorkitem(Baseclass.getInstance().WorkItemExternalId_ProductBacklog));
	    jsonObject.put("WorkItemExternalId_Bug", CommonFunctions.SpiltWorkitem(Baseclass.getInstance().WorkItemExternalId_Bug));

	    jsonObject.put("TFS_ReleaseName",Baseclass.getInstance().TFS_ReleaseName);
		jsonObject.put("TFS_ReleaseStartDate",Baseclass.getInstance().TFS_ReleaseStartDate);
		jsonObject.put("TFS_ReleaseEndDate",Baseclass.getInstance().TFS_ReleaseEndDate);
		jsonObject.put("TFS_SprintName",Baseclass.getInstance().TFS_SprintName);
		jsonObject.put("TFS_SprintStartDate",Baseclass.getInstance().TFS_SprintStartDate);
		jsonObject.put("TFS_SprintEndDate",Baseclass.getInstance().TFS_SprintEndDate);
		
		
		
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
}
