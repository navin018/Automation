package stepDefs;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import uiMap.DIYUIMap;
import uiMap.JiraUIMap;
import uiMap.MyWizardUIMap;
import uiMap.SecurityTestsUIMap;
import testobjects.*;
public class DIYSteps {
	

	@Then("^i \"([^\"]*)\" a DC for DIY for \"([^\"]*)\"$")
	public void i_create_DC(String CreateOrDelete, String toolname) throws Throwable {
		if(CreateOrDelete.equalsIgnoreCase("Create"))
				DIY.AddDC(toolname);
		if(CreateOrDelete.equalsIgnoreCase("Delete"))
				DIY.DeleteDC(toolname);
		if(CreateOrDelete.equalsIgnoreCase("Upload"))
			DIY.UploadDC(toolname);
			}
	
	@Then("^i deactivate the rules for \"([^\"]*)\"$")
	public void i_deactivate(String toolname) throws Throwable {
		DIY.DeactivateRules(toolname);
		clickJS(MyWizardUIMap.BackToDashboard_link);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
	}
	
	@Then("^i select client and DC for DIY for \"([^\"]*)\"$")
	public void i_select_client_and_DC(String toolname) throws Throwable {
		
    		DIY.SelectClientAndDC(toolname);
    		Thread.sleep(3000);
    		refresh();
    		Thread.sleep(10000);
    		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		
	}
	
	@Then("^i test the connectivity for \"([^\"]*)\"$")
	public void i_test_connectivity(String toolname) throws Throwable {
		DIY.TestConnectivity(toolname);
		clickJS(MyWizardUIMap.BacktoOverallSetup_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		clickJS(MyWizardUIMap.BacktoDIYADAutomation_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		clickJS(MyWizardUIMap.BackToDashboard_link);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);

	}
	
	@Then("^i enter self enabled automation details for \"([^\"]*)\" for \"([^\"]*)\" functionality$")
	public void i_enter_selfenabledautomationdetails(String toolname,String functionality) throws Throwable {
		DIY.AddSelfEnabledAutomationDetails(toolname,functionality);
	}
	
	@Then("^i remove the role \"([^\"]*)\" for user \"([^\"]*)\"$")
	public void i_remove_the_role_for_user(String role, String userID) throws Throwable {
	    DIY.RemoveRole(role,userID);
	}
	
	@Then("^i make a note of the DC created for \"([^\"]*)\"$")
	public void notedownDC(String toolname) throws Throwable {
		DIY.NoteDownDCNameAndDCUID(toolname);
		
	}
}



	