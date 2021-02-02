package stepDefs;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;



import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import uiMap.RallyUIMap;
import utilities.general.Property;
import testobjects.*;

public class RallySteps  {
	
	@Then("^i create a \"([^\"]*)\" in Rally$")
	public void iCreateAInRally(String workitem) throws Throwable {
		
		String workitem_sp[] = workitem.split("_");
		
		
		if(workitem_sp[0].equalsIgnoreCase("Story"))
		{
		clickJS(RallyUIMap.plan_link);
		ExpWaitForCondition(RallyUIMap.userStories_link);
		clickJS(RallyUIMap.userStories_link);
		ExpWaitForCondition(RallyUIMap.AddNew_btn);
		}
		if(workitem_sp[0].equalsIgnoreCase("Task"))
		{
			singleClick(RallyUIMap.clickOneUserStory_StaticTxt);
			ExpWaitForCondition(RallyUIMap.Tasks_link);
				clickJS(RallyUIMap.Tasks_link);
			
		}
		
		if(workitem_sp[0].equalsIgnoreCase("Risk"))
		{
			clickJS(RallyUIMap.Risks_link);
		}
		
		if(workitem_sp[0].equalsIgnoreCase("Bug"))
		{
			clickJS(RallyUIMap.Defects_link);
		
		}
		if(workitem_sp[0].equalsIgnoreCase("Feature"))
		{
		clickJS(RallyUIMap.Portfolio_link);
		clickJS(RallyUIMap.PortfolioItems_link);
		ExpWaitForCondition(RallyUIMap.AddNew_btn);
		clickJS(RallyUIMap.Portfolio_drpdown);
		clickJS(RallyUIMap.PortfolioDrpdownSelectFeature_drpdown);
		
		}
		if(workitem_sp[0].equalsIgnoreCase("Epic"))
		{
		clickJS(RallyUIMap.Portfolio_drpdown);
		clickJS(RallyUIMap.PortfolioDrpdownSelectInitiative_drpdown);
		
		}
		RallyWorkitem.createworkitem(workitem);
		RallyWorkitem.CaptureWorkitemID(workitem);
		
		if(workitem_sp[0].equalsIgnoreCase("Release"))
		{
			RallyWorkitem.CreateRelease();
		}
	}
	
	




	
//
//	@Then("^i create an \"([^\"]*)\" in Jira$")
//	public void iCreateAnInJira(String ReleaseOrTeam) throws Throwable {
//		if(ReleaseOrTeam.contains("Release") || ReleaseOrTeam.contains("release") || ReleaseOrTeam.contains("Sprint") || ReleaseOrTeam.contains("sprint"))
//			{
//			if(!Property.getProperty("JiraURL").contains("jira4phoenixmywiz"))
//			JiraWorkitem.CreateRelease(ReleaseOrTeam);
//			if(Property.getProperty("JiraURL").contains("jira4phoenixmywiz"))
//				JiraWorkitem.CreateReleaseForCloudJira(ReleaseOrTeam);
//			}
//		if(ReleaseOrTeam.contains("Team") || ReleaseOrTeam.contains("team"))
//			JiraWorkitem.CreateTeam(ReleaseOrTeam);	
//	}
//	
//	
////
////	@Then("^i validate the outbound flow for \"([^\"]*)\" $")
////	public void iValidateTheOutboundFlow(String appname) throws Throwable {
////		JiraWorkitem.ValidateOB(appname);
////	}
//
//	@Then("^i delete the test automation data$")
//	public void i_delete_the_test_automation_data() throws Throwable {
//	   JiraWorkitem.DeleteTestAutomationData();
//	   }
//	
//	@Then("^i copy existing workitem details for \"([^\"]*)\" into WorkItemExternalIDsFile$")
//	public void i_copy_existing_workitem_details_for_into_WorkItemExternalIDsFile(String project) throws Throwable {
//		JiraWorkitem.updateWorkItemExternalIDFile(project);
//	}
	

}
;