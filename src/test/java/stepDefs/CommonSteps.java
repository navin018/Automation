package stepDefs;
import static utilities.reporting.LogUtil.logger;

import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.io.FileWriter;

import utilities.general.Property;
import utilities.selenium.Context;
import org.json.simple.JSONObject;

import org.testng.Assert;




import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.AssertionFailedError;
import testobjects.*;
import uiMap.JiraUIMap;
import uiMap.TFSUIMap;
import uiMap.MyWizardUIMap;

public class CommonSteps {
	
	@Given("^i close the browser session")
	public void iClosetheBrowser()  {
		driver().quit();
	}

	
	@Given("^i login to application \"([^\"]*)\"$")
	public void iLoginToApplicationWith(String AppName) throws Throwable {
		
		try{
		switch(AppName)
		{
			case "Jira":
			{
				CommonAcrossApps.loginToJira();
				
			}
			break;
			case "MyWizard":
			case "mywizard":
			{
				CommonAcrossApps.LoginToMyWizard();
			}
			break;
			
			case "TFS":
			case "tfs":
			{
				CommonAcrossApps.LoginToTFS();
				
			}
			break;
			
		
			default:
	        throw new IllegalArgumentException("Invalid Applicationname: " + AppName);	
		}}
	catch(Exception e)
	{
		e.printStackTrace();
		Assert.fail();
		
	}}

	@SuppressWarnings("unchecked")
	@And("^i update the WorkItemExternalIDs into a JSON file for \"([^\"]*)\"$")
	public void iUpdateTheWorkItemExternalIDsIntoAJSONFile(String appname) throws Throwable {
		
		CommonAcrossApps.UpdateWorkItemExternalIDsForApps(appname);
		
		
		}	
		
	
	@Then("^i select a Project for \"([^\"]*)\"$")
	public void iSelectAProject(String AppName) throws Throwable {
		if(AppName.equalsIgnoreCase("jira"))
		{
		JiraWorkitem.SelectProject();
		Baseclass.getInstance().workitemcreation_fail = false;
		}
		if(AppName.equalsIgnoreCase("TFS"))
			TFSWorkitem.SelectProject();
	}
	
	@Then("^i verify the Release and Sprint for \"([^\"]*)\"$")
	public void i_verify_the_Release_and_Sprint_for(String AppName) throws Throwable {
		if(AppName.equalsIgnoreCase("jira"))
			JiraWorkitem.VerifyReleaseAndSprintFromRMP(AppName);
		if(AppName.equalsIgnoreCase("TFS"))
			TFSWorkitem.VerifyReleaseAndSprintFromRMP(AppName);
	}
	
	@Then("^i put a explicit wait of \"([^\"]*)\"$")
	public void i_put_explicit_wait(int waitInSec) throws Throwable {
		try{
			Thread.sleep(waitInSec);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Then("^i generate a token for \"([^\"]*)\" environment$")
	public void generateToken(String Env) throws Throwable {
		try{
			CommonFunctions.generateToken(Env);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Then("^i check the overall status of workitem creation for \"([^\"]*)\"$")
	public void checkoverallstatusofworkitemcreation(String Env) throws Throwable {
		try{
			CommonFunctions.checkoverallstatusofworkitemcreation(Env);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	


	




	

}

	
