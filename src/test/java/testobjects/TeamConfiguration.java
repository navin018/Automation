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
import net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable;
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

	public static String testDataPath = System.getProperty("user.dir")
			+ File.separator + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator + "testdata" + File.separator;

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
		Baseclass.getInstance().TeamUId = getAttribute(TeamConfigUIMap.TeamUID_statictxt, "value");
		System.out.println(Baseclass.getInstance().TeamUId);
		enterText(TeamConfigUIMap.teamName_txtBox,Baseclass.getInstance().teamName); 
		
		Navigatetosection("Client/Delivery Construct Association(s)");
		AddDeliveryConstructAssociationDetails(toolName);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		Navigatetosection("Resource Association");
		enterText(TeamConfigUIMap.resourceSearch_txtBox,Property.getProperty("UserName_ForTeamConfig"));
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		selectDropdownByText(TeamConfigUIMap.selectResource_dropdown,Property.getProperty("UserName_ForTeamConfig"));
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
		ExpWaitForCondition(prepareWebElementWithDynamicXpath(TeamConfigUIMap.Teamname_statictxt, Baseclass.getInstance().teamName, "teamname"));
		doubleClick(prepareWebElementWithDynamicXpath(TeamConfigUIMap.Teamname_statictxt, Baseclass.getInstance().teamName, "teamname"));
//		clickJS(TeamConfigUIMap.edit_link);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		enterText(TeamConfigUIMap.description_txtBox,"Updating the team");
		ScrollIntoView(TeamConfigUIMap.save_button);
		clickJS(TeamConfigUIMap.save_button);
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

	public static void UpdateteamDetails(String toolname) {
		try{
			String testDataPath_WorkItemExternalIDs="";
			if(toolname.contains("Jira") || toolname.contains("JIRA")){
				testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs.json" ;
			}
			else if(toolname.contains("TFS") || toolname.contains("Tfs")){
				testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs.json" ;
			}
			FileReader reader = new FileReader(testDataPath_WorkItemExternalIDs);

	        JSONParser jsonParser = new JSONParser();
	        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
	        jsonObject.put("Team_Name",Baseclass.getInstance().teamName);
	        jsonObject.put("WorkItemExternalId_TeamUId",Baseclass.getInstance().TeamUId);
	        FileOutputStream outputStream = new FileOutputStream(testDataPath_WorkItemExternalIDs);
			 byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue updating teamname or teamuid for "+toolname);
			}
		}

	public static void CaptureteamDetails(String toolname) throws InterruptedException {
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		String teamname = Tools.getWorkItemExternalID_custom("Team", toolname, "normal");
		enterText(MyWizardUIMap.Search_txtbox, teamname);
		Thread.sleep(4000);
		try{
			ExpWaitForCondition(prepareWebElementWithDynamicXpath(TeamConfigUIMap.Teamname_statictxt, teamname, "teamname"));
			doubleClick(prepareWebElementWithDynamicXpath(TeamConfigUIMap.Teamname_statictxt, teamname, "teamname"));
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			Baseclass.getInstance().TeamUId = getAttribute(TeamConfigUIMap.TeamUID_statictxt, "value");
			Baseclass.getInstance().teamName = teamname;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("team "+teamname+" has not flown yet. the mentioned team not shown in team config tile");
			Assert.fail("team "+teamname+" has not flown yet. the mentioned team not shown in team config tile");
		}
		
		
		
	}

	public static void removeResource(String toolname) throws InterruptedException {
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		String teamname = Tools.getWorkItemExternalID_custom("Team", toolname, "normal");
		enterText(MyWizardUIMap.Search_txtbox, teamname);
		Thread.sleep(4000);
		try{
			ExpWaitForCondition(prepareWebElementWithDynamicXpath(TeamConfigUIMap.Teamname_statictxt, teamname, "teamname"));
			doubleClick(prepareWebElementWithDynamicXpath(TeamConfigUIMap.Teamname_statictxt, teamname, "teamname"));
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			if(CheckIfElementExists(prepareWebElementWithDynamicXpath(TeamConfigUIMap.AssociatedResourceList_statictxt, Property.getProperty("UserName_ForTeamConfig"), "resourceID"))){
				singleClick(prepareWebElementWithDynamicXpath(TeamConfigUIMap.AssociatedResourceList_statictxt, Property.getProperty("UserName_ForTeamConfig"), "resourceID"));
				singleClick(TeamConfigUIMap.RemoveResource_button);
				Thread.sleep(2000);
				if(!CheckIfElementExists(prepareWebElementWithDynamicXpath(TeamConfigUIMap.ResourceList_statictxt, Property.getProperty("UserName_ForTeamConfig"), "resourceID")))
					Assert.fail("failed to remove resource from the given team "+teamname);
						click(TeamConfigUIMap.save_button);
						ExpWaitForCondition(TeamConfigUIMap.saveSuccessful_staticTxt);
						System.out.println("Team edit successful");
			}
			else
				Assert.fail("Resource "+ Property.getProperty("UserName_ForTeamConfig")+ " that needs to be removed doesnt exists in the given team "+teamname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("team "+teamname+" not shown in team config tile");
			Assert.fail("team "+teamname+" not shown in team config tile");
		}
		
		
		
	}

	public static void CaptureteamDetailsForSpecificFunctionality(String team, String toolname,String functionality) throws InterruptedException {
		
		String teamname = API.getWorkItemExternalIDForGivenFunctionality(team,toolname,functionality);
		  clickJS(TeamConfigUIMap.PageCount_txtBox);
	        clickJS(TeamConfigUIMap.Page_number);
		enterText(MyWizardUIMap.Search_txtbox, teamname);
		Thread.sleep(4000);
		try{
			ExpWaitForCondition(prepareWebElementWithDynamicXpath(TeamConfigUIMap.Teamname_statictxt, teamname, "teamname"));
			singleClick(prepareWebElementWithDynamicXpath(TeamConfigUIMap.Teamname_statictxt, teamname, "teamname"));
			Thread.sleep(2000);
//			Baseclass.getInstance().TeamUId = getAttribute(TeamConfigUIMap.TeamUID_statictxt, "value");
//			Baseclass.getInstance().TeamExternalID = teamname;
			Baseclass.getInstance().TeamUId = getAttribute(TeamConfigUIMap.TeamUID_statictxt1, "value");
			Baseclass.getInstance().TeamExternalID = getAttribute(TeamConfigUIMap.TeamExternalID_statictxt, "value");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("team "+teamname+" has not flown yet. the mentioned team not shown in team config tile");
			Assert.fail("team "+teamname+" has not flown yet. the mentioned team not shown in team config tile");
		}
		
	}

	public static void duplicateteam(String toolname) {
		try {
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		singleClick(TeamConfigUIMap.addTeam_button);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		String teamName = Tools.getWorkItemExternalID_custom("Team", toolname, "normal");
		enterText(TeamConfigUIMap.teamName_txtBox,Baseclass.getInstance().teamName);
		Thread.sleep(1000);
		click(TeamConfigUIMap.save_button);
		ExpWaitForCondition(TeamConfigUIMap.Duplication_staticTxt);
		logger.info("Duplication of team scenario tested successful");
		}
		catch(Exception e)
		{
		e.printStackTrace();
		logger.info("Duplication of team is successful which is not expected");
		Assert.fail("Duplication of team is successful which is not expected");
		}
		}
		
	}
	
	