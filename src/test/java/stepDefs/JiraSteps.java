package stepDefs;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;



import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import uiMap.JiraUIMap;
import utilities.general.Property;
import testobjects.*;

public class JiraSteps  {
	
	@Then("^i change the \"([^\"]*)\" of \"([^\"]*)\" in \"([^\"]*)\"$")
	public void i_change_the_project_of_in(String ProjectOrEntityType, String workitem,String toolname) throws Throwable {
		JiraWorkitem.openworkiteminjira(workitem,toolname);
		JiraWorkitem.changeProjectOrIssueTypeofWorkitem(ProjectOrEntityType,workitem,toolname,"");
	}
	
//	i change the entitytype of "<story>" to "<milestone>" in "<applicationname>" 
	@Then("^i change the \"([^\"]*)\" of \"([^\"]*)\" to \"([^\"]*)\" in \"([^\"]*)\"$")
	public void i_change_the_entitytype(String ProjectOrEntityType, String workitemFrom,String workitemTo, String toolname) throws Throwable {
		JiraWorkitem.openworkiteminjira(workitemFrom,toolname);
		JiraWorkitem.changeProjectOrIssueTypeofWorkitem(ProjectOrEntityType, workitemFrom,toolname,workitemTo);
	}
	
	
	@Then("^i create a \"([^\"]*)\" in Jira for \"([^\"]*)\"$")
	public void i_create_a_in_Jira_nonsanity(String workitem,String functionality) throws Throwable {
		if(functionality.equalsIgnoreCase("WSJF functionality"))
	   JiraWorkitem.CreateWorkitemforWSJFfunctionality(workitem);
		if(functionality.equalsIgnoreCase("autorecon") || functionality.equalsIgnoreCase("manualrecon"))
			 JiraWorkitem.CreateWorkitemForRecon(workitem);


	}

	@Then("^i create a \"([^\"]*)\" in Jira$")
	public void iCreateAInJira(String workitem) throws Throwable {
		try{
		String workitem_sp[] = workitem.split("_");
		
		if(!workitem_sp[0].equalsIgnoreCase("SubTask"))
		{
		Thread.sleep(3000);
		ExpWaitForCondition(JiraUIMap.Create_link);
		clickJS(JiraUIMap.Create_link);
		Thread.sleep(5000);
//		ExpWaitForCondition(JiraUIMap.CreateIssue_Statictxt);
		waitPageToLoad();
		if(Property.getProperty("JiraURL").contains("adtjira001eu")){
		JiraWorkitem.SelectProjectInCreateWorkitemScreen();
		}
		JiraWorkitem.SelectWorkItemtype(workitem);
		JiraWorkitem.CreateWorkitem(workitem);
		JiraWorkitem.CaptureWorkitemID(workitem);
		}
		else
		{
			waitPageToLoad();
			Thread.sleep(5000);
			click(JiraUIMap.WorkItemExternalID_txt);
			Thread.sleep(5000);
			click(JiraUIMap.CreateSubTask_btn);
			JiraWorkitem.CreateWorkitem(workitem);
			JiraWorkitem.CaptureWorkitemID(workitem);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			grabScreenshotForExtentReport();
		}
	}
	
	@Then("^i create a \"([^\"]*)\" in CloudJira$")
	public void iCreateAInCloudJira(String workitem) throws Throwable {
		
		String workitem_sp[] = workitem.split("_");
		ExpWaitForCondition(JiraUIMap.CloudJiraCreate_link);
		click(JiraUIMap.CloudJiraCreate_link);
		ExpWaitForCondition(JiraUIMap.CloudJiraCreateIssue_Statictxt);
		waitPageToLoad();
		JiraWorkitem.SelectWorkItemtype(workitem);
		JiraWorkitem.CreateWorkitem(workitem);
		JiraWorkitem.CaptureWorkitemIDForCloudJira(workitem);
		
	
	}

	@Then("^i create entity \"([^\"]*)\" in Jira$")
	public void iCreateEntityInJira(String workitem) throws Throwable {
		
		String workitem_sp[] = workitem.split("_");
		
		if(workitem_sp[0].equalsIgnoreCase("TestForTestExec"))
		{
		Thread.sleep(3000);
		ExpWaitForCondition(JiraUIMap.Create_link);
		click(JiraUIMap.Create_link);
		ExpWaitForCondition(JiraUIMap.CreateIssue_Statictxt);
		waitPageToLoad();
	
		JiraWorkitem.SelectWorkItemtype("Test");
		JiraWorkitem.CreateWorkitem(workitem);
		JiraWorkitem.CaptureWorkitemID(workitem);
		   if(Property.getProperty("JiraURL").contains("uat"))
			   JiraWorkitem.Createtestcycle(workitem);
		   else
		JiraWorkitem.associateTestExecution(workitem);
		}
		
	}

	

	@Then("^i create an \"([^\"]*)\" in Jira$")
	public void iCreateAnInJira(String ReleaseOrTeam) throws Throwable {
		if(ReleaseOrTeam.contains("Release") || ReleaseOrTeam.contains("release") || ReleaseOrTeam.contains("Sprint") || ReleaseOrTeam.contains("sprint"))
			{
			if(!Property.getProperty("JiraURL").contains("jira4phoenixmywiz"))
			JiraWorkitem.CreateRelease(ReleaseOrTeam);
			if(Property.getProperty("JiraURL").contains("jira4phoenixmywiz"))
				JiraWorkitem.CreateReleaseForCloudJira(ReleaseOrTeam);
			}
		if(ReleaseOrTeam.contains("Team") || ReleaseOrTeam.contains("team"))
			JiraWorkitem.CreateTeam(ReleaseOrTeam);	
	}
	
	
//
//	@Then("^i validate the outbound flow for \"([^\"]*)\" $")
//	public void iValidateTheOutboundFlow(String appname) throws Throwable {
//		JiraWorkitem.ValidateOB(appname);
//	}

	@Then("^i delete the test automation data for \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_delete_the_test_automation_data(String releaseOrWorkitems,String toolname) throws Throwable {
	   JiraWorkitem.DeleteTestAutomationData(releaseOrWorkitems,toolname);
	   }
	
	@Then("^i copy existing workitem details for \"([^\"]*)\" into WorkItemExternalIDsFile$")
	public void i_copy_existing_workitem_details_for_into_WorkItemExternalIDsFile(String project) throws Throwable {
		JiraWorkitem.updateWorkItemExternalIDFile(project);
	}
	
	
    @Then("^i \"([^\"]*)\" a \"([^\"]*)\" in Jira for \"([^\"]*)\"$")
    public void i_a_in_Jira_for(String CreateorUpdate, String workitem, String functionality) throws Throwable {​​​​​​​
        if(CreateorUpdate.equalsIgnoreCase("Create"))
        {​​​​​​​
            JiraWorkitem.CreateWorkitemForSpecificFunctionality(workitem, functionality);
        }​​​​​​​
        else if(CreateorUpdate.equalsIgnoreCase("Update"))
        {
        	​​​​​​​
            JiraWorkitem.UpdateWorkitemForTeamArchitecture(workitem, functionality);
        }​​​​​​​
    }​​​​​​​

	

}
