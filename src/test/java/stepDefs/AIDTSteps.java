package stepDefs;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import uiMap.JiraUIMap;
import testobjects.*;
public class AIDTSteps {

@And("^i create a \"([^\"]*)\" in \"([^\"]*)\"$")
public void i_create_a_in(String workitem, String toolname) throws Throwable {
    
	if(!(workitem.contains("Team")))
		AIDTWorkitem.CreateWorkitem(workitem, toolname);
		// need to work on this
	if(workitem.equalsIgnoreCase("Team"))
		TFSWorkitem.CreateTeam();
}
	
@And("^i create \"([^\"]*)\" and \"([^\"]*)\" in \"([^\"]*)\"$")
public void i_create_and_in(String Release, String Sprint, String toolname ) throws Throwable {
	AIDTWorkitem.CreateReleaseAndSprint(Release,Sprint);
}

}