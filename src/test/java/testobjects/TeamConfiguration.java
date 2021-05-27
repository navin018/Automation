package testobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import static utilities.selenium.SeleniumDSL.*;
import static utilities.general.Property.*;
import static utilities.reporting.LogUtil.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import dataobjects.WorkItemDO;
import dataobjects.WorkItemExternalIDDO;
//import javassist.bytecode.stackmap.BasicBlock.Catch;
import testobjects.Baseclass;
import uiMap.JiraUIMap;
import uiMap.MyWizardUIMap;
import uiMap.ProductConfigUIMap;
import uiMap.TeamConfigUIMap;
import utilities.general.DataManager;
import utilities.general.Property;
import utilities.selenium.SeleniumDSL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TeamConfiguration extends Baseclass {
	private Baseclass base;
	
	public TeamConfiguration() {

	}

	public TeamConfiguration(Baseclass base) {
		this.base = base;
	}

	public static String testDataPath = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "test" + File.separator + "resources" + File.separator + "testdata" + File.separator + "Jira"
			+ File.separator + "JSON" + File.separator;

	public static void Navigatetosection(String sectionaname) {
		try {
			// clickJS(ProductConfigUIMap.IsRealtimeConfigChangesEnabled_btn);
			ExpWaitForCondition(prepareWebElementWithDynamicXpath(TeamConfigUIMap.TeamConfigPage_Section, sectionaname,
					"sectionname"));
			ScrollIntoView(prepareWebElementWithDynamicXpath(TeamConfigUIMap.TeamConfigPage_Section, sectionaname,
					"sectionname"));
			clickJS(prepareWebElementWithDynamicXpath(TeamConfigUIMap.TeamConfigPage_Section, sectionaname,
					"sectionname"));

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("could not load section " + sectionaname + " in page team config");
			Assert.fail("could not load section " + sectionaname + " in page team config");
		}
	}

	public static void AddDeliveryConstructAssociationDetails(String toolname) {
		try {
			Thread.sleep(3000);
			clickJS(prepareWebElementWithDynamicXpath(TeamConfigUIMap.TeamConfigPage_Section,
					"Delivery Construct Association", "sectionname"));
			Thread.sleep(2000);
			// select the client
			clickJS(prepareWebElementWithDynamicXpath(TeamConfigUIMap.DCClientToSelect_StaticTxt,
					Property.getProperty("MyWizard_Client"), "clientname"));
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);

			// select + icon to expand the client
			clickJS(prepareWebElementWithDynamicXpath(TeamConfigUIMap.PlusIconToExpandClientSelected_StaticTxt,
					Property.getProperty("MyWizard_Client"), "clientname"));

			if (toolname.equalsIgnoreCase("ADT JIRA") || toolname.equalsIgnoreCase("ADOP JIRA")) {
				// check if L1 DC is selected/ticked
				WebElement checkbox_L1 = driver()
						.findElement(prepareWebElementWithDynamicXpath(TeamConfigUIMap.checkL1DCcheckbox_checkbox,
								Property.getProperty("MyWizard_DC_L1"), "DCname"));
				
				// expand DC L2
				clickJS(prepareWebElementWithDynamicXpath(TeamConfigUIMap.PlusIconToExpandDCL1_StaticTxt,
						Property.getProperty("MyWizard_DC_L1"), "DCname"));

				// check to see if DC L2 needs to be added or not
				if (!Property.getProperty("MyWizard_DC_L2").equalsIgnoreCase("NA")
						|| Property.getProperty("MyWizard_DC_L2").equalsIgnoreCase("")) {
					// check if DC L2 is selected
					WebElement checkbox_L2 = driver().findElement(
							prepareWebElementWithDynamicXpath(TeamConfigUIMap.checkL2DCcheckbox_checkbox,
									Property.getProperty("MyWizard_DC_L2"), "programname"));
					if (checkbox_L2.isSelected()) {
					System.out.println("L2 DC is selected already");
						}
					else{
						clickJS(checkbox_L2);
						}
					}
			}
		}
			catch (Exception e) {
				e.printStackTrace();
				logger.info("Issue selecting the Delivery construct association");
				Assert.fail("Issue selecting the Delivery construct association");
			}
			}

	public static void createTeam(String toolName) throws InterruptedException, IOException {
		try{
		singleClick(TeamConfigUIMap.addTeam_button);
		Baseclass.getInstance().teamName = "Team_" + RandomNumberGenerator();
		System.out.println(Baseclass.getInstance().teamName);
		ExpWaitForCondition(TeamConfigUIMap.teamName_txtBox);
		enterText(TeamConfigUIMap.teamName_txtBox,Baseclass.getInstance().teamName); 
		
		Navigatetosection("Client/Delivery Construct Association(s)");
		AddDeliveryConstructAssociationDetails(toolName);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		Navigatetosection("Resource Association");
		enterText(TeamConfigUIMap.resourceSearch_txtBox,Property.getProperty("MyWizard_Username"));
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		selectDropdownByText(TeamConfigUIMap.selectResource_dropdown,Property.getProperty("MyWizard_Username"));
		clickJS(TeamConfigUIMap.addResource_button);
		click(TeamConfigUIMap.save_button);
		ExpWaitForCondition(TeamConfigUIMap.saveSuccessful_staticTxt);
		
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.info("Creation of team failed");
			Assert.fail("Creation of team failed");
		}
	}

	public static void editTeam() throws InterruptedException {
		try{
		ExpWaitForCondition(TeamConfigUIMap.addTeam_button);
		enterText(TeamConfigUIMap.searchBox_txtBox, Baseclass.getInstance().teamName);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		clickJS(prepareWebElementWithDynamicXpath(TeamConfigUIMap.selectTeam_staticTxt,
				Baseclass.getInstance().teamName, "teamname"));
		clickJS(TeamConfigUIMap.edit_link);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		enterText(TeamConfigUIMap.description_txtBox,"Updating the team");
		click(TeamConfigUIMap.save_button);
		ExpWaitForCondition(TeamConfigUIMap.saveSuccessful_staticTxt);
		System.out.println("Team edit successful");
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.info("Updation of team failed");
			Assert.fail("Updation of team failed");
		}

	}

	public static void deleteTeam() throws InterruptedException {
		try{
		enterText(TeamConfigUIMap.searchBox_txtBox, Baseclass.getInstance().teamName);
		click(TeamConfigUIMap.delete_button);
		ExpWaitForCondition(TeamConfigUIMap.confirmDelete_button);
//		ArrayList<String> wHandles = new ArrayList<String>(driver().getWindowHandles());       
//        driver().switchTo().window(wHandles.get(1));
		singleClick(TeamConfigUIMap.confirmDelete_button);
		ExpWaitForCondition(TeamConfigUIMap.deleteTeamSuccess_staticTxt);
		System.out.println("Team deletion successful");
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.info("Deletion of team failed");
			Assert.fail("Deletion of team failed");
		}
	}

}