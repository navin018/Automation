package stepDefs;

import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import net.lightbody.bmp.proxy.CaptureType;
import testobjects.Baseclass;
import testobjects.MappingRules;
import testobjects.MyWizardHomePage;
import uiMap.MyWizardUIMap;
import uiMap.SecurityTestsUIMap;
import utilities.selenium.DriverFactory;

public class MyWizardSteps {
	
	@Then("^i select client and DC for \"([^\"]*)\"$")
	public void i_select_client_and_DC(String appname) throws Throwable {
		
    		MyWizardHomePage.SelectClientAndDC();
	
	
		
	}
//	And i select client "PreComputationEngine_Client" with DC_L1 as "PreComputationEngine_DC_L1" and DC_L2 as "PreComputationEngine_DC_L2" 
	@Then("^i select client \"([^\"]*)\" with DC_L1 as \"([^\"]*)\" and DC_L2 as \"([^\"]*)\"$")
	public void i_select_client_and_DC_ForSpecificFunctionality(String client,String DC_L1,String DC_L2) throws Throwable {
		
    		MyWizardHomePage.SelectClientAndDCForSpecificFunctionality(client,DC_L1,DC_L2);
	
	
		
	}
	
	
//	Then i select client and DC for for No Tool Instance
	@Then("^i select client and DC for No Tool Instance$")
	public void i_select_client_and_DCForNoToolInstance() throws Throwable {
		
    		MyWizardHomePage.SelectClientAndDCForNoToolInstance();
	
	
		
	}
	
	@Then("^i select client and DC for \"([^\"]*)\" for RMP$")
	public void i_select_client_and_DC_RMP(String appname) throws Throwable {
		
		MyWizardHomePage.SelectClientAndDCForRMP();
	
	
		
	}
	
	@Then("^i select client and DC for \"([^\"]*)\" for pipelines$")
	public void i_select_client_and_DC_for_pipelines(String appname) throws Throwable {
		
		MyWizardHomePage.SelectClientAndDCForPipelines();
	
	
		
	}
	
	@Then("^i select only the client for \"([^\"]*)\"$")
	public void i_select_only_the_client_for(String arg1) throws Throwable {
	
		MyWizardHomePage.SelectOnlyClient();
		
	}
	
	
	@Then("^i select client \"([^\"]*)\" for \"([^\"]*)\"$")
	public void select_specific_client(String clienttobeselected,String appname) throws Throwable {
		
		MyWizardHomePage.SelectSpecificClient(clienttobeselected);
		
	}
	
	@Then("^i click on tile \"([^\"]*)\"$")
	public void i_click_on_tile(String Tilename) throws Throwable {
		
		MyWizardHomePage.clickOnTile(Tilename);
		MyWizardHomePage.VerifyIfTileisLoaded(Tilename);

	}
	
	@Then("^i navigate to the homepage of \"([^\"]*)\" from \"([^\"]*)\"$")
	public void i_navigate_to_the_homepage_of_from(String arg1, String arg2) throws Throwable {
		MyWizardHomePage.NavigateToHomePage();
	
	}
	
	@Then("^i verify and add the rules if missing for the \"([^\"]*)\"$")
	public void i_verify_rules(String toolname) throws Throwable {

		String[] JIRA_WorkItems = {"Task", "Epic", "Feature", "UserStory", "Bug", "Impediment", "Issue", "Risk"};
		String[] CloudJIRA_WorkItems = {"Task", "Epic", "Feature", "UserStory", "Bug", "Impediment"};
		String[] CloudJIRA_NonWorkItems = {"Iteration"};
//		String[] JIRA_WorkItems = {"Task", "Epic"};
		
		String[] ADTJira_NonWorkItems = {"Test","Deliverable","Requirement","Iteration","Action","TestResult","Test","Milestone"};
		
		String[] ADOPJira_NonWorkItems = {"Iteration"};
		String[] TFSAgile_WorkItems = {"Task", "Epic", "Feature", "UserStory", "Bug", "Issue","Risk"};
		String[] TFSScrum_WorkItems = {"Task", "Epic", "Feature", "UserStory", "Bug", "Impediment", "Issue","Risk"};
		String[] TFS_NonWorkItems = {"Iteration", "Test", "Deliverable","Action","TestResult","Milestone","Decision","ChangeRequest"};
	
		
		if(toolname.equalsIgnoreCase("ADT JIRA"))
		{
			MappingRules.VerifyAndAddRulesIfMissing(toolname,JIRA_WorkItems,ADTJira_NonWorkItems);
		}
		else if(toolname.equalsIgnoreCase("ADOP JIRA"))
		{
			MappingRules.VerifyAndAddRulesIfMissing(toolname,JIRA_WorkItems,ADOPJira_NonWorkItems);
		}
		else if(toolname.equalsIgnoreCase("TFS Agile"))
		{
			MappingRules.VerifyAndAddRulesIfMissing("myWizard-TFS",TFSAgile_WorkItems,TFS_NonWorkItems);
		}
		else if(toolname.equalsIgnoreCase("Cloud JIRA"))
		{
			MappingRules.VerifyAndAddRulesIfMissing("Cloud Jira",CloudJIRA_WorkItems,CloudJIRA_NonWorkItems);
		}
		else if(toolname.equalsIgnoreCase("TFS Scrum"))
		{
			MappingRules.VerifyAndAddRulesIfMissing("myWizard-TFS",TFSScrum_WorkItems,TFS_NonWorkItems);
		}
		else{
			logger.info("Entered tool not found for mapping rules");
			Assert.fail("Entered tool not found for mapping rules");
		}
	
	}

}
