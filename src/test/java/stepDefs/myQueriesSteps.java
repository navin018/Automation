package stepDefs;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.io.IOException;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import uiMap.JiraUIMap;
import utilities.general.Property;
import testobjects.*;

public class myQueriesSteps  {
	
	@Then("^i \"([^\"]*)\" the query for \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_the_query_for_and_and(String createOrEditOrRun, String toolName, String entityType, String workItemType)  throws Throwable {
	if(createOrEditOrRun.equalsIgnoreCase("create"))
	{
		myQueries.createQuery(toolName,entityType,workItemType);
	}
	else if(createOrEditOrRun.equalsIgnoreCase("edit"))
	{
		myQueries.editQuery();
	}
	else if(createOrEditOrRun.equalsIgnoreCase("delete"))
	{
		myQueries.deleteQuery();
	}
	}


}
;