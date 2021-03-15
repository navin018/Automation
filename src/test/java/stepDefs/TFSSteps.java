package stepDefs;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;
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

	@Then("^i create a \"([^\"]*)\" in TFS for non-sanity$")
	public void i_create_a_in_TFS_nonsanity(String workitem) throws Throwable {

	   TFSWorkitem.CreateWorkitemfornonsanity(workitem);


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
}
