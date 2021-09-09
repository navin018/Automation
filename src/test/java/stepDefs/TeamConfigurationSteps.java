package stepDefs;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.io.IOException;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import uiMap.JiraUIMap;
import utilities.general.Property;
import testobjects.*;

public class TeamConfigurationSteps  {
	
	@Then("^i want to \"([^\"]*)\" a team for \"([^\"]*)\"$")
	public void i_want_to_a_team(String createOrEditOrDelete,String toolname) throws InterruptedException, IOException{
	    if(createOrEditOrDelete.equalsIgnoreCase("create"))
	    {
	    	TeamConfiguration.createTeam(toolname);
//	    	TeamConfiguration.UpdateteamDetails(toolname);
	    }
	    else if(createOrEditOrDelete.equalsIgnoreCase("edit"))
	    {
	    	TeamConfiguration.editTeam();
	    }
	    else if(createOrEditOrDelete.equalsIgnoreCase("delete"))
	    {
	    	TeamConfiguration.deleteTeam();
	    }
	    else if(createOrEditOrDelete.equalsIgnoreCase("EditteamAndRemoveResource"))
	    {
	    	TeamConfiguration.removeResource(toolname);
	    }
	}

	@Then("^i want to capture team details for a team for \"([^\"]*)\"$")
	public void captureteamdetails(String toolname) throws InterruptedException
	{
		TeamConfiguration.CaptureteamDetails(toolname);
		TeamConfiguration.UpdateteamDetails(toolname);
	}
	
//	Then i want to capture team details for of "Team01" for "<toolname>" for functionality "TeamArchitecture"
	@Then("^i want to capture team details for \"([^\"]*)\" for \"([^\"]*)\" for functionality \"([^\"]*)\"$")
	public void captureteamdetailsforspecificfunctionality(String teamname,String toolname,String functionality) throws InterruptedException
	{
		TeamConfiguration.CaptureteamDetailsForSpecificFunctionality(teamname,toolname,functionality);
		
	}
	
}
;