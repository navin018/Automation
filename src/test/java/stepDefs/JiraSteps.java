package stepDefs;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import uiMap.JiraUIMap;
import testobjects.*;

public class JiraSteps  {
	
	@Then("^i create a \"([^\"]*)\" in Jira$")
	public void iCreateAInJira(String workitem) throws Throwable {
		
		String workitem_sp[] = workitem.split("_");
		
		if(!workitem_sp[0].equalsIgnoreCase("SubTask"))
		{
		Thread.sleep(3000);
		ExpWaitForCondition(JiraUIMap.Create_link);
		click(JiraUIMap.Create_link);
		ExpWaitForCondition(JiraUIMap.CreateIssue_Statictxt);
		waitPageToLoad();
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
		JiraWorkitem.associateTestExecution(workitem);
		}
		
	}

	

	@Then("^i create an \"([^\"]*)\" in Jira$")
	public void iCreateAnInJira(String ReleaseOrTeam) throws Throwable {
		if(ReleaseOrTeam.contains("Release") || ReleaseOrTeam.contains("release") || ReleaseOrTeam.contains("Sprint") || ReleaseOrTeam.contains("sprint"))
		JiraWorkitem.CreateRelease(ReleaseOrTeam);
		if(ReleaseOrTeam.contains("Team") || ReleaseOrTeam.contains("team"))
			JiraWorkitem.CreateTeam(ReleaseOrTeam);	
	}
	
	
//
//	@Then("^i validate the outbound flow for \"([^\"]*)\" $")
//	public void iValidateTheOutboundFlow(String appname) throws Throwable {
//		JiraWorkitem.ValidateOB(appname);
//	}

	@Then("^i delete the test automation data$")
	public void i_delete_the_test_automation_data() throws Throwable {
	   JiraWorkitem.DeleteTestAutomationData();
	   }
	
	@Then("^i copy existing workitem details for \"([^\"]*)\" into WorkItemExternalIDsFile$")
	public void i_copy_existing_workitem_details_for_into_WorkItemExternalIDsFile(String project) throws Throwable {
		JiraWorkitem.updateWorkItemExternalIDFile(project);
	}
	

}
;