package stepDefs;
import org.openqa.selenium.Point;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Pattern;


import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import uiMap.JiraUIMap;
import uiMap.MyWizardUIMap;
import uiMap.RMPUIMap;
import testobjects.*;
public class RMPSteps {
	
		
	@Then("^i navigate to RMP page$")
	public void i_navigate_to_RMP_page() throws Throwable {
		RMP.NavigateToRMPPage();
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		Thread.sleep(3000);
		ExpWaitForCondition(MyWizardUIMap.Dashboard_Checkbox);
        click(MyWizardUIMap.Dashboard_Checkbox);
        ExpWaitForCondition(MyWizardUIMap.Dashboard_Confirm_btn);
        click(MyWizardUIMap.Dashboard_Confirm_btn);
       	 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
	}
	
	@Then("^i and create Release and Sprint in RMP page for \"([^\"]*)\" for the tool \"([^\"]*)\"$")
	public void i_and_create_Release_and_Sprint_in_RMP_page(String typeofrecon,String toolname) throws Throwable {
//		  RMP.AddReleaseAndSprint(typeofrecon,toolname);
		  RMP.AddReleaseAndSprint1(typeofrecon,toolname);
		  RMP.BaselineRoadMap();
		  RMP.CaptureReleaseAndSprintDetails(toolname);
	}
	
	
	@Then("^i perform Manual Recon for \"([^\"]*)\" for tool \"([^\"]*)\"$")
	public void i_perform_manualrecon(String ReleaseorSprint, String toolname) throws Throwable {
		RMP.PerformManualRecon(ReleaseorSprint,toolname);
	}

	
}
