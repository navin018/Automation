package stepDefs;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import uiMap.DIYUIMap;
import uiMap.JiraUIMap;
import testobjects.*;
public class DFTSteps {
	
	
	@Then("^i check the DFT details for \"([^\"]*)\" details for \"([^\"]*)\"$")
	public void i_create_DC(String InboundOrOutbound, String toolname) throws Throwable {
		DFT.CheckIBOBDetails(InboundOrOutbound,toolname);

	}
	
	
	
}



	