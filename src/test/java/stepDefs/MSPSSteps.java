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

public class MSPSSteps {
	@Then("^i \"([^\"]*)\" a \"([^\"]*)\" in \"([^\"]*)\"$")
	public void i_a_in(String Create, String Project, String Applicationname) throws Throwable {
	    MSPS.CreateProject();
	}

	@Then("^i enable the ACNP Project details$")
	public void i_enable_the_ACNP_Project_details() throws Throwable {
	    MSPS.Enable();
	}

	@Then("^i create \"([^\"]*)\" in \"([^\"]*)\"$")
	public void i_create_in(String Entity, String AppName) throws Throwable {
	   MSPS.CreateEntities(Entity);
	    
	}
	@Then("^i save, publish,close and check-in the changes$")
	public void i_save_publish_close_and_check_in_the_changes() throws Throwable {
	    MSPS.PublishandClose();
	}
}