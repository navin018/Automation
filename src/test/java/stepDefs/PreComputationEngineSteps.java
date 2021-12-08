package stepDefs;
import static utilities.reporting.LogUtil.logger;

import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

import utilities.general.Property;
import utilities.selenium.Context;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;




import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.AssertionFailedError;
import testobjects.*;
import uiMap.JiraUIMap;
import uiMap.TFSUIMap;
import uiMap.TeamConfigUIMap;
import uiMap.myQueriesUIMap;
import uiMap.MyWizardUIMap;
import uiMap.PreComputationEngineUIMAP;
import uiMap.SecurityTestsUIMap;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
public class PreComputationEngineSteps {
	
@Given("^i \"([^\"]*)\" a Process in Precom Tile$")
public void i_a_Process_in_Precom_Tile(String arg1) throws Throwable {
	try{
		
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Adding of new process failed");
			Assert.fail("Adding of new process failed");
		}		


    
}


//Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "ProductBacklog" and add the formula "StoryPoints / ( Priority * Rank )"
@Given("^i \"([^\"]*)\" a process of type \"([^\"]*)\" for entity \"([^\"]*)\" and subentity \"([^\"]*)\" and add the formula \"([^\"]*)\" for tool \"([^\"]*)\"$")
public void i_add_process_withformula(String addOrEditOrDelete,String AlertOrCompute,String entity,String SubEntity,String formula,String toolname) throws Throwable {
	try{
		if(addOrEditOrDelete.equalsIgnoreCase("add")){
				PreComputationEngine.CreateTestProcess(AlertOrCompute,entity,SubEntity);
				PreComputationEngine.EditNewTestProcess(SubEntity,toolname);
				PreComputationEngine.EnterFormula(formula);
				PreComputationEngine.MakeNoteOfTestProcessName(SubEntity,toolname);
		}
		if(addOrEditOrDelete.equalsIgnoreCase("edit")){
			PreComputationEngine.GetTestProcess(SubEntity,toolname);
			PreComputationEngine.EditExistingTestProcess(SubEntity,toolname);
			PreComputationEngine.EnterFormula(formula);
			PreComputationEngine.MakeNoteOfTestProcessName(SubEntity,toolname);
	}
	
	}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Adding of new process failed");
			Assert.fail("Adding of new process failed");
		}		

}

@Then("^i Verify the Property for \"([^\"]*)\" Entity for \"([^\"]*)\" Functionality$")
public void i_Verify_the_Property_for_Entity_for_Functionality(String Entity, String Functionality) throws Throwable {
	PreComputationEngine.checkProperty(Entity,Functionality);
}

@Given("^i \"([^\"]*)\" weightage for \"([^\"]*)\" for \"([^\"]*)\" in UI$")
	public void i_weightage_for_for_in_UI(String AddEditOrDelete, String Property, String Entity) throws Throwable {
   switch(AddEditOrDelete) {
   case "Add":
	   PreComputationEngine.AddNewProperty(Property, Entity);
	   break;
      case "Delete":
	   PreComputationEngine.DeleteAddedProperty(Property, Entity);
	   break;
   }
}
@Then("^i verify the filter option for \"([^\"]*)\"$")
public void i_verify_the_filter_option_for(String ProcessName) throws Throwable {
	PreComputationEngine.ValidateFilter(ProcessName);
}	

@Given("^i \"([^\"]*)\" a process of name \"([^\"]*)\"$")
public void i_a_process_of_name(String EditOrView, String Processname) throws Throwable {
	PreComputationEngine.ViewOrEdit(EditOrView,Processname);
}

@Then("^i verify user guide for \"([^\"]*)\"$")
public void i_verify_user_guide_for(String tilename) throws Throwable {
	PreComputationEngine.CheckUserGuide(tilename);
}
@Given("^i add filter criteria in formula page$")
public void i_add_filter_criteria_in_formula_page() throws Throwable {
   PreComputationEngine.Addfiltercriteria();
}
}	
	