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
		RallyWorkitem.createworkitem(workitem);
		RallyWorkitem.CaptureWorkitemID(workitem);
		
		}
		if(workitem_sp[0].equalsIgnoreCase("Task"))
		{
			Thread.sleep(5000);
			singleClick(RallyUIMap.clickOneUserStory_StaticTxt);
			ExpWaitForCondition(RallyUIMap.Tasks_link);
				clickJS(RallyUIMap.Tasks_link);
				Thread.sleep(5000);
				RallyWorkitem.createworkitem(workitem);
				RallyWorkitem.CaptureWorkitemID(workitem);
			
		}
		
		if(workitem_sp[0].equalsIgnoreCase("Risk"))
		{
			clickJS(RallyUIMap.Risks_link);
			Thread.sleep(5000);
			RallyWorkitem.createworkitem(workitem);
			RallyWorkitem.CaptureWorkitemID(workitem);
		}
		
		if(workitem_sp[0].equalsIgnoreCase("Bug"))
		{
			clickJS(RallyUIMap.Defects_link);
			Thread.sleep(5000);
			RallyWorkitem.createworkitem(workitem);
			RallyWorkitem.CaptureWorkitemID(workitem);
		
		}
		if(workitem_sp[0].equalsIgnoreCase("Feature"))
		{
		clickJS(RallyUIMap.Portfolio_link);
		clickJS(RallyUIMap.PortfolioItems_link);
		ExpWaitForCondition(RallyUIMap.AddNew_btn);
		clickJS(RallyUIMap.Portfolio_drpdown);
		clickJS(RallyUIMap.PortfolioDrpdownSelectFeature_drpdown);
		RallyWorkitem.createworkitem(workitem);
		RallyWorkitem.CaptureWorkitemID(workitem);
		
		}
		if(workitem_sp[0].equalsIgnoreCase("Epic"))
		{
		clickJS(RallyUIMap.Portfolio_drpdown);
		clickJS(RallyUIMap.PortfolioDrpdownSelectInitiative_drpdown);
		Thread.sleep(5000);
		clickJS(RallyUIMap.AddNew_btn);
		RallyWorkitem.createworkitem(workitem);
		RallyWorkitem.CaptureWorkitemID(workitem);
		
		}
//		RallyWorkitem.createworkitem(workitem);
//		RallyWorkitem.CaptureWorkitemID(workitem);
		
		if(workitem_sp[0].equalsIgnoreCase("Release"))
		{
			RallyWorkitem.CreateRelease();
		}
	}
	
	
	@Then("^i update the status of \"([^\"]*)\" to \"([^\"]*)\" in Rally$")
	public void i_update_status_of_story(String workitem, String status) throws Throwable {
		RallyWorkitem.openworkitem(workitem);
		RallyWorkitem.changeStatus(status);
	}



	

//	}
	

}
;