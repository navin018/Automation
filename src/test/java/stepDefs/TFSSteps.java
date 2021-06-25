package stepDefs;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import uiMap.JiraUIMap;
import testobjects.*;
public class TFSSteps {
	
	@Then("^i create a \"([^\"]*)\" in TFS$")
	public void i_create_a_in_TFS(String workitem) throws Throwable {
//	   TFSWorkitem.CreateWorkitem(workitem);
		if(!(workitem.contains("TestResult")))
	   TFSWorkitem.CreateWorkitem1(workitem);

		if(workitem.equalsIgnoreCase("TestResult"))
		TFSWorkitem.CreateTestResult(workitem);
	}


	@Then("^i create a \"([^\"]*)\" in TFS for \"([^\"]*)\"$")
	public void i_create_a_in_TFS_nonsanity(String workitem,String functionality) throws Throwable {
		if(functionality.equalsIgnoreCase("WSJF functionality")){
			//this is done only for story workitem
			TFSWorkitem.CreateWorkitemforWSJFfunctionality(workitem);
		}
				if(functionality.equalsIgnoreCase("autorecon") || functionality.equalsIgnoreCase("manualrecon"))
					 TFSWorkitem.CreateWorkitemAndAssociateReleaseSprint(workitem);
				if(functionality.equalsIgnoreCase("PreComputation_WSJF"))
					TFSWorkitem.CreateWorkitemForPrecomputationEngine(workitem,functionality);




	}
	@Then("^i update the status of \"([^\"]*)\" to \"([^\"]*)\" in TFS$")
	public void i_update_status_of_story(String workitem, String status) throws Throwable {
		TFSWorkitem.openworkitem(workitem);
		TFSWorkitem.changeStatus(status);
	}
	
	@Then("^i change the \"([^\"]*)\" of \"([^\"]*)\" in TFS$")
	public void i_change_the_project_of_in(String ProjectOrEntityType, String workitem) throws Throwable {
		TFSWorkitem.openworkitem(workitem);
		TFSWorkitem.changeProjectOrIssueTypeofWorkitem(ProjectOrEntityType,workitem,"TFS","");
		
	}
	
	@Then("^i change the \"([^\"]*)\" of \"([^\"]*)\" to \"([^\"]*)\" in TFS$")
	public void i_change_the_entitytype_in_TFS(String ProjectOrEntityType, String workitemFrom,String workitemTo) throws Throwable {
		TFSWorkitem.openworkitem(workitemFrom);
		TFSWorkitem.changeProjectOrIssueTypeofWorkitem(ProjectOrEntityType, workitemFrom,"TFS",workitemTo);
	}

	@Then("^i delete \"([^\"]*)\" in TFS$")
	public void i_delete_workitem(String workitem) throws Throwable {
		if(workitem.contains("ReleaseAndSprint"))
		{
			TFSWorkitem.DeleteReleaseSprint();
		}
		else{
			TFSWorkitem.openworkitem(workitem);
			TFSWorkitem.deleteworkitem(workitem);
		}
	}
	

	
	@Then("^i create \"([^\"]*)\" and \"([^\"]*)\" in TFS$")
	public void i_create_and_in_TFS(String Release, String Sprint) throws Throwable {
		TFSWorkitem.CreateReleaseAndSprint(Release,Sprint);
	}
	
	@Then("^i delete the test automation data for query \"([^\"]*)\"$")
	public void i_delete_the_test_automation_data_for_query(String QueryName) throws Throwable {
		TFSWorkitem.DeleteTestAutomationData(QueryName);
}
	@Then("^i copy the existing workitem details for \"([^\"]*)\" into WorkItemExternalIDsFile$")
	public void i_copy_existing_workitem_details_for_into_WorkItemExternalIDsFile(String project) throws Throwable {
		TFSWorkitem.updateWorkItemExternalIDFile(project);
	}
	
//	@Then("^i delete the test automation data for \"([^\"]*)\" for TFS$")
//	public void i_delete_the_test_automation_data(String releaseOrWorkitems,String toolname) throws Throwable {
//	   TFSWorkitem.DeleteTestAutomationData(releaseOrWorkitems,toolname);
//	   }
}
