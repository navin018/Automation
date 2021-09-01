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
		if(!(workitem.contains("TestResult") || workitem.equalsIgnoreCase("Team")))
			TFSWorkitem.CreateWorkitem1(workitem);

		if(workitem.equalsIgnoreCase("TestResult"))
		TFSWorkitem.CreateTestResult(workitem);
		
		if(workitem.equalsIgnoreCase("Team"))
			TFSWorkitem.CreateTeam();
	}
	
//	And i create a "Team" in TFS with member "gopala.veeramani@accenture.com"
	@Then("^i create a \"([^\"]*)\" in TFS with member \"([^\"]*)\"$")
	public void i_create_a_team(String teammember) throws Throwable {
		TFSWorkitem.CreateTeamWithSpecificMember(teammember);
	}
	
	
	  @Then("^i delete the \"([^\"]*)\" in \"([^\"]*)\" for \"([^\"]*)\" functionality$")
	    public void i_delete_the_in_for_functionality(String workitem, String toolname,String functionality) throws Throwable {
	        TFSWorkitem.DeleteTeam( workitem, toolname,functionality);
	    }

//	And i "create" a "Story_wsjf_Decimal_AssociatedWith_Task" associated to "Task_wsjf_Deminal_Output" with linking as "Related" in TFS for "PreComputation_WSJF"
	@Then("^i \"([^\"]*)\" a \"([^\"]*)\" associated to \"([^\"]*)\" with linking as \"([^\"]*)\" in TFS for \"([^\"]*)\"$")
	public void i_create_workitems_with_associations(String CreateOrUpdate, String workitem,String workitem1, String linkingtype, String functionality) throws Throwable {
		TFSWorkitem.CreateWorkitemForPrecomputationEngine(workitem,functionality);
		TFSWorkitem.CreateWorkitemForPrecomputationEngine(workitem1,functionality);
		CommonAcrossApps.UpdateWorkItemExternalIDsForAppsForSpecificFunctionality("TFS",functionality);
		TFSWorkitem.LinkWorkitems(workitem,workitem1,linkingtype, functionality);
	}
	
	@Then("^i \"([^\"]*)\" a \"([^\"]*)\" in TFS for \"([^\"]*)\"$")
	public void i_create_a_in_TFS_nonsanity(String CreateOrUpdate, String workitem,String functionality) throws Throwable {
		
				if(functionality.equalsIgnoreCase("autorecon") || functionality.equalsIgnoreCase("manualrecon"))
					 TFSWorkitem.CreateWorkitemAndAssociateReleaseSprint(workitem);
				if(functionality.equalsIgnoreCase("PreComputation_WSJF") || functionality.equalsIgnoreCase("PreComputation_RAG"))
					{
					if(CreateOrUpdate.equalsIgnoreCase("create"))
					
					TFSWorkitem.CreateWorkitemForPrecomputationEngine(workitem,functionality);
					else if(CreateOrUpdate.equalsIgnoreCase("update"))
							TFSWorkitem.UpdateWorkItemForPreComputation(workitem,functionality);
					}



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
	
//	And i create a "Release" with start date as "-60" days from today and end date as "1" days from today in TFS 
	@Then("^i create a \"([^\"]*)\" with start date as \"([^\"]*)\" days from today and end date as \"([^\"]*)\" days from today in TFS$")
	public void i_createiteration(String releaseOrSprint, int startdate, int enddate) throws Throwable {
		
		TFSWorkitem.CreateIterationForSpecificDuration(releaseOrSprint, startdate,enddate);
		
		
}
	
//	And i associate "WorkItemExternalId_Story_RAG_AssociatedSprintTiming_Rule7" to "WorkItemExternalId_Story_RAG_AssociatedToStory_Rule7" with releationship "Parent" in TFS
	@Then("^i associate \"([^\"]*)\" to \"([^\"]*)\" with relationship \"([^\"]*)\" for functionality \"([^\"]*)\" in TFS$")
	public void associateworkitems(String workitem1,String workitem2, String relationship,String functionality) throws Throwable {
		TFSWorkitem.LinkWorkitems(workitem1,workitem2,relationship, functionality);
		
		
		
}
}
