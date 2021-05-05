package stepDefs;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import uiMap.JiraUIMap;
import utilities.general.Property;
import testobjects.*;

public class APISteps {
	
	@Then("^i verify the \"([^\"]*)\" \"([^\"]*)\" details for \"([^\"]*)\"$")
	public void iVerifyWorkitemDetail(String InBoundOrOutBound, String workitem, String toolname) throws FileNotFoundException, IOException, ParseException {
		if(InBoundOrOutBound.equalsIgnoreCase("Inbound"))
		Tools.VerifyInBoundWorkitemDetails(workitem,toolname);
		else if(InBoundOrOutBound.equalsIgnoreCase("Outbound"))
		Tools.VerifyOutBoundWorkitemDetails(workitem,toolname);
		else Assert.fail("mention inbound or outbound only for workitem verification");
	}
	
//	And i verify the "Outbound" flow for "Story" details for "ADT JIRA" for "DFT" functionality
	@Then("^i verify the Outbound flow for \"([^\"]*)\" details for \"([^\"]*)\" for \"([^\"]*)\" functionality$")
	public void iVerifyOutBoundFlowForSpecificFunctionality(String workitem,String toolname,String functionality) throws FileNotFoundException, IOException, ParseException {
		Tools.VerifyOutboundForSpecificFunctionality(workitem,toolname,functionality);
	
	}
	@Then("^i verify if \"([^\"]*)\" has \"([^\"]*)\" which was \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\" functionality$")
	public void iVerifyWorkitemDetailfordeletefunctionality(String workitem,String flownOrDeleted,String oldworkitemtype, String toolname,String functionality) throws FileNotFoundException, IOException, ParseException {
		
		if((functionality.equalsIgnoreCase("ChangeProjectFromOne") || functionality.equalsIgnoreCase("delete")) && oldworkitemtype.equalsIgnoreCase("NA"))
		Tools.Verifyifworkitemisflown(workitem,flownOrDeleted,toolname,"ChangeProjectFromOne");
		if(functionality.equalsIgnoreCase("ChangeProjectFromOne") && !oldworkitemtype.equalsIgnoreCase("NA"))
			Tools.Verifyifworkitemisflown(workitem,flownOrDeleted,toolname,functionality);
		if(functionality.equalsIgnoreCase("WSJF"))
			Tools.VerifyWSJFFuncionality(workitem,toolname);
		if(functionality.equalsIgnoreCase("ScrumBan"))
			Tools.VerifyScrumBanFuncionality(workitem,toolname,flownOrDeleted);
		if(functionality.equalsIgnoreCase("ChangeProjectToAnother"))
			Tools.Verifyifworkitemisflown(workitem,flownOrDeleted,toolname,functionality);
		if(functionality.contains("Recon") || functionality.equalsIgnoreCase("DFT") || functionality.equalsIgnoreCase("DIY") || functionality.equalsIgnoreCase("Normal"))
			Tools.Verifyifworkitemisflown(workitem,flownOrDeleted,toolname,functionality);
	}
	
	@Then("^i verify the \"([^\"]*)\" \"([^\"]*)\" details for \"([^\"]*)\" after removing DC$")
	public void iVerifyWorkitemDetailafterremovingDC(String InBoundOrOutBound, String workitem, String toolname) throws FileNotFoundException, IOException, ParseException {
		if(InBoundOrOutBound.equalsIgnoreCase("Inbound"))
		Tools.VerifyInBoundWorkitemDetails_DCCheck(workitem,toolname);
		else if(InBoundOrOutBound.equalsIgnoreCase("Outbound"))
		Tools.VerifyOutBoundWorkitemDetails(workitem,toolname);
		else Assert.fail("mention inbound or outbound only for workitem verification");
	}
	
	
	

}
;