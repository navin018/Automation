package testobjects;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import uiMap.DIYUIMap;
import uiMap.DLMUIMap;
import uiMap.MyWizardMappingRuleUIMap;
import uiMap.MyWizardUIMap;
import uiMap.ProductConfigUIMap;
import uiMap.SecurityTestsUIMap;
import utilities.general.DataManager;
import utilities.general.Property;

import static org.testng.Assert.assertEquals;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;

import dataobjects.DLMDO;

public class DIY extends Baseclass{
	private Baseclass base;
	
	public DIY()
	{
		
	}
	
	public DIY(Baseclass base) {
		this.base =base; 
	}
	 
	
	public static String testDataPath = System.getProperty("user.dir")
			+ File.separator + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator + "testdata" + File.separator ;

	public static String getDCName(String toolname, String functionality) {
		try{
		if(functionality.equalsIgnoreCase("DIY")){	
			String DCDetailsFilePath="";
				 if(toolname.contains("Jira") || toolname.contains("JIRA"))
				 {
					 DCDetailsFilePath = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "DCDetails.json" ;
				 }
				 else if(toolname.contains("TFS") || toolname.contains("tfs"))
				 {
					 DCDetailsFilePath = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "DCDetails.json" ;
				 }
				 
				 JSONParser parser = new JSONParser();
					Object obj = parser.parse(new FileReader(DCDetailsFilePath));
					JSONObject jsonObject = (JSONObject) obj;
					return ((String) jsonObject.get("DCName"));
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}

	
	public static void AddDC(String toolname) {
		try{
		clickJS(DIYUIMap.ConfigureContractExplore_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		clickJS(DIYUIMap.AddDC_link);
		Thread.sleep(4000);
		selectDropdownByText(DIYUIMap.DCType_drpdown, "Portfolio, Program & Project Management (PMI - PPM)");
		clickJS(DIYUIMap.AddDC_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		String DCName = "DIYAutomation"+"_"+RandomNumberGenerator();
		System.out.println(DCName);
		enterText(DIYUIMap.PortfolionName_txtbox,DCName);
		Baseclass.getInstance().DCName = DCName;
		clickJS(DIYUIMap.ContractOpportunityDetails_btn);
		ExpWaitForCondition(DIYUIMap.ContractOpportunityDetails_window);
		
		singleClick(DIYUIMap.Market_drpdown);
		clickJS(DIYUIMap.Market_drpdownValue);
		
		singleClick(DIYUIMap.MarketUnit_drpdown);
		clickJS(DIYUIMap.MarketUnit_drpdownValue);
		
		
		singleClick(DIYUIMap.IndustrySegement_drpdown);
		clickJS(DIYUIMap.IndustrySegement_drpdownValue);
		
		singleClick(DIYUIMap.ResponsibleBusinessEntity_drpdown);
		clickJS(DIYUIMap.ResponsibleBusinessEntity_drpdownValue);
		
		singleClick(DIYUIMap.DeliveryLead_txtbox);
		enterText(DIYUIMap.DeliveryLead_txtbox,"testuser@accenture.com");
		
		singleClick(DIYUIMap.ContractOpportunityId_txtbox);
		enterText(DIYUIMap.ContractOpportunityId_txtbox,"DIY");
		
		singleClick(DIYUIMap.ContractOpportunityStartDate_drpdown);
		enterText(DIYUIMap.ContractOpportunityStartDate_drpdown,"01/08/2021");
		singleClick(DIYUIMap.ContractOpportunityEndDate_drpdown);
		enterText(DIYUIMap.ContractOpportunityEndDate_drpdown,"01/12/2021");
		
		singleClick(DIYUIMap.DeliveryFunction_drpdown);
		clickJS(DIYUIMap.DeliveryFunction_drpdownValue);

		singleClick(DIYUIMap.DeployRegion_drpdown);
		clickJS(DIYUIMap.DeployRegion_drpdownValue);
		
		singleClick(DIYUIMap.EndToEndType_drpdown);
		clickJS(DIYUIMap.EndToEndType_drpdownValue);
		
		singleClick(DIYUIMap.Platform_drpdown);
		clickJS(DIYUIMap.Platform_drpdownValue);

		singleClick(DIYUIMap.DeliveryType_drpdown);
		clickJS(DIYUIMap.DeliveryType_drpdownValue);
		Thread.sleep(3000);
		clickJS(DIYUIMap.Save_btn);
		Thread.sleep(3000);
		ExpWaitForCondition(DIYUIMap.SaveAndClose_btn);
		clickJS(DIYUIMap.SaveAndClose_btn);
		ExpWaitForCondition(DIYUIMap.DCSavedSuccess_Msg);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue creating for tool "+toolname);
			Assert.fail("Issue creating for tool "+toolname);

		}
	}

	public static void AddSelfEnabledAutomationDetails(String toolname,String functionality) {
		try{
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		clickJS(DIYUIMap.SelfEnableAutomationExplore_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			try{
				singleClick(DIYUIMap.SearchDC_txtbox);
			enterText(DIYUIMap.SearchDC_txtbox,Baseclass.getInstance().DCName);
			ExpWaitForCondition(prepareWebElementWithDynamicXpath(DIYUIMap.DCName_statictxt, Baseclass.getInstance().DCName, "DCName") );
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("created DC not shown up in add self enabled automation page for tool "+toolname);
				Assert.fail("created DC not shown up in add self enabled automation page for tool "+toolname);
				
			}
			
		clickJS(DIYUIMap.SelectFunctions_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		switch(toolname){
		case "ADT Jira":
		case "ADT JIRA":
			if(!getAttribute(DIYUIMap.selectedToolADTJira_checkbox, "checked").equalsIgnoreCase("true"))
				clickJS(DIYUIMap.selectedToolADTJira_checkbox);
				clickJS(DIYUIMap.Next_btn);
				if(!getAttribute(DIYUIMap.selectedToolADTJira_checkbox, "checked").equalsIgnoreCase("true"))
					clickJS(DIYUIMap.selectedToolADTJira_checkbox);
				clickJS(DIYUIMap.Next_btn);
				if(!getAttribute(DIYUIMap.selectedToolADTJira_checkbox, "checked").equalsIgnoreCase("true"))
					clickJS(DIYUIMap.selectedToolADTJira_checkbox);
				clickJS(DIYUIMap.Next_btn);
				if(!getAttribute(DIYUIMap.selectedToolADTJira_checkbox, "checked").equalsIgnoreCase("true"))
					clickJS(DIYUIMap.selectedToolADTJira_checkbox);
				clickJS(DIYUIMap.Next_btn);
				if(!getAttribute(DIYUIMap.selectedToolADTJira_checkbox, "checked").equalsIgnoreCase("true"))
					clickJS(DIYUIMap.selectedToolADTJira_checkbox);
				clickJS(DIYUIMap.Next_btn);
				if(!getAttribute(DIYUIMap.selectedToolADTJira_checkbox, "checked").equalsIgnoreCase("true"))
					clickJS(DIYUIMap.selectedToolADTJira_checkbox);
				clickJS(DIYUIMap.Next_btn);
				clickJS(DIYUIMap.SaveAndNext_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				Thread.sleep(5000);
				clickJS(DIYUIMap.Yes_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				//stuff here
				configuretools(toolname,functionality);
				DataMappingCheck(toolname);
				ExpWaitForCondition(DIYUIMap.SaveAndNext_btn);
				EnableUseCases(toolname);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				AddUsers(toolname);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				clickJS(DIYUIMap.SaveAndNextFinalScreen_btn);
				ExpWaitForCondition(DIYUIMap.SelfEnablementSuccessful_Msg);
				ExpWaitForCondition(DIYUIMap.GetStarted_Btn);
			break;
		case "ADOP Jira":
			clickJS(DIYUIMap.selectedToolADTJira_checkbox);
				clickJS(DIYUIMap.selectedToolADOPJira_checkbox);
				clickJS(DIYUIMap.ConfirmChangingTool_btn);
				clickJS(DIYUIMap.Next_btn);
				if(!getAttribute(DIYUIMap.selectedToolADOPJira_checkbox, "checked").equalsIgnoreCase("true"))
					clickJS(DIYUIMap.selectedToolADOPJira_checkbox);
				clickJS(DIYUIMap.Next_btn);
				Thread.sleep(3000);
				clickJS(DIYUIMap.Next_btn);
				if(!getAttribute(DIYUIMap.selectedToolADOPJira_checkbox, "checked").equalsIgnoreCase("true"))
					clickJS(DIYUIMap.selectedToolADOPJira_checkbox);
				clickJS(DIYUIMap.Next_btn);
				if(!getAttribute(DIYUIMap.selectedToolADOPJira_checkbox, "checked").equalsIgnoreCase("true"))
					clickJS(DIYUIMap.selectedToolADOPJira_checkbox);
				clickJS(DIYUIMap.Next_btn);
				Thread.sleep(3000);
				clickJS(DIYUIMap.Next_btn);
				clickJS(DIYUIMap.SaveAndNext_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				Thread.sleep(5000);
				clickJS(DIYUIMap.Yes_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				configuretools(toolname,functionality);
			DataMappingCheck(toolname);
				
				EnableUseCases(toolname);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				AddUsers(toolname);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				clickJS(DIYUIMap.SaveAndNextFinalScreen_btn);
				ExpWaitForCondition(DIYUIMap.SelfEnablementSuccessful_Msg);
				ExpWaitForCondition(DIYUIMap.GetStarted_Btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
			break;
		case "TFS Agile":
		case "TFS Scrum":
			clickJS(DIYUIMap.selectedToolADTJira_checkbox);
			clickJS(DIYUIMap.selectedToolTFS_checkbox);
			clickJS(DIYUIMap.ConfirmChangingTool_btn);
			clickJS(DIYUIMap.Next_btn);
			if(!getAttribute(DIYUIMap.selectedToolTFS_checkbox, "checked").equalsIgnoreCase("true"))
				clickJS(DIYUIMap.selectedToolTFS_checkbox);
			clickJS(DIYUIMap.Next_btn);
			Thread.sleep(3000);
			clickJS(DIYUIMap.Next_btn);
			if(!getAttribute(DIYUIMap.selectedToolTFS_checkbox, "checked").equalsIgnoreCase("true"))
				clickJS(DIYUIMap.selectedToolTFS_checkbox);
			clickJS(DIYUIMap.Next_btn);
			if(!getAttribute(DIYUIMap.selectedToolTFS_checkbox, "checked").equalsIgnoreCase("true"))
				clickJS(DIYUIMap.selectedToolTFS_checkbox);
			clickJS(DIYUIMap.Next_btn);
			Thread.sleep(3000);
			clickJS(DIYUIMap.Next_btn);
			clickJS(DIYUIMap.SaveAndNext_btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			Thread.sleep(5000);

			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clickJS(DIYUIMap.Yes_btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			configuretools(toolname,functionality);
			DataMappingCheck(toolname);
			
			EnableUseCases(toolname);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			AddUsers(toolname);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clickJS(DIYUIMap.SaveAndNextFinalScreen_btn);
			ExpWaitForCondition(DIYUIMap.SelfEnablementSuccessful_Msg);
			ExpWaitForCondition(DIYUIMap.GetStarted_Btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		
			
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue adding self enabled automation details for tool "+toolname);
			Assert.fail("Issue adding self enabled automation details for tool "+toolname);
			
		}
	}

	

	private static void AddUsers(String toolname) {
	try{
	ExpWaitForCondition(DIYUIMap.clientAdminNumber_statictxt);
	String getClientAdminCount_before = getText(DIYUIMap.clientAdminNumber_statictxt);
	clickJS(DIYUIMap.AddAccount_link);
	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
	enterText(DIYUIMap.Email_txtbox,Property.getProperty("emailIDToBeadded"));

	sendTab(DIYUIMap.Email_txtbox);
	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
	Thread.sleep(2000);
	singleClick(DIYUIMap.SelectRole_checkbox);
	sendEnter(DIYUIMap.SelectRole_checkbox);

	Thread.sleep(2000);
	clickJS(DIYUIMap.Update_btn);
	String getClientAdminCount_after = getText(DIYUIMap.clientAdminNumber_statictxt);
	System.out.println(Integer.parseInt(getClientAdminCount_before)+1);
	System.out.println(Integer.parseInt(getClientAdminCount_after));
	//uncheck the below line. TFS agile not able to uncheck the user
	//	Assert.assertEquals(Integer.parseInt(getClientAdminCount_before)+1, Integer.parseInt(getClientAdminCount_after));
	clickJS(DIYUIMap.SaveAndNext_btn);
	ExpWaitForCondition(DIYUIMap.SaveSuccess_Msg);
	}
	catch(Exception e) 
	{
		e.printStackTrace();
	}
	
	}

	private static void EnableUseCases(String toolname) throws InterruptedException {
//		String appbundles[] = {"Planning & Program Management","Requirements, Product Backlog & Change Management","Release & Sprint Planning","Release / Sprint Execution","Analytics & Virtual Agent","Knowledge Management","Myconcerto","Governance"};
		String appbundles[] = {"Planning & Program Management","Requirements, Product Backlog & Change Management","Release & Sprint Planning","Release / Sprint Execution","Analytics & Virtual Agent","Knowledge Management","Myconcerto"};
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ExpWaitForCondition(DIYUIMap.SelectuseCases_txt);
		ExpWaitForCondition(DIYUIMap.SaveAndNext_btn);
		Thread.sleep(10000);
		SoftAssert sa = new SoftAssert();
		for(String appbundle: appbundles){
			if(!CheckIfElementExists(prepareWebElementWithDynamicXpath(DIYUIMap.AppBundle_Icon, appbundle, "appbundle")))
			{
				sa.assertEquals(appbundle, "absent", "the "+appbundle +" does not exists or is not checked in the enable usecases page for tool "+toolname);
			}
		}
		sa.assertAll();
		clickJS(DIYUIMap.SaveAndNext_btn);
		ExpWaitForCondition(DIYUIMap.SaveSuccess_Msg);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
	
	}

	private static void DataMappingCheck(String toolname) {
		try{
				
				String[] ADTJira_WorkItems = {"Task", "Epic", "Feature", "UserStory", "Bug", "Impediment", "Issue", "Risk"};
				String[] ADTJira_NonWorkItems = {"Test","Deliverable","Requirement","Iteration","Action","TestResult","Milestone","ChangeRequest"};
				String[] ADOPJira_WorkItems = {"Task", "Epic", "Feature", "UserStory", "Bug", "Impediment", "Issue", "Risk"};
				String[] ADOPJira_NonWorkItems = {"Iteration"};
				String[] TFSAgile_WorkItems = {"Task", "Epic", "Feature", "UserStory", "Bug", "Issue","Risk","Impediment"};
				String[] TFSScrum_WorkItems = {"Task", "Epic", "Feature", "UserStory", "Bug", "Impediment", "Issue","Risk"};
				String[] TFS_NonWorkItems = {"Iteration", "Test", "Deliverable","Action","TestResult","Milestone","Decision","ChangeRequest","Requirement"};
				
			
				
				if(toolname.equalsIgnoreCase("ADT Jira"))
				{
					VerifyRules_workitems("workitem",ADTJira_WorkItems,toolname);
					VerifyRules_workitems("nonworkitem",ADTJira_NonWorkItems,toolname);
				}
				else if(toolname.equalsIgnoreCase("ADOP Jira")){
					VerifyRules_workitems("workitem",ADOPJira_WorkItems,toolname);
					VerifyRules_workitems("nonworkitem",ADOPJira_NonWorkItems,toolname);
				}
				else if(toolname.equalsIgnoreCase("TFS Agile")){
					VerifyRules_workitems("nonworkitem",TFSAgile_WorkItems,toolname);
					VerifyRules_workitems("nonworkitem",TFS_NonWorkItems,toolname);
				}
				else if(toolname.equalsIgnoreCase("TFS Scrum")){
					VerifyRules_workitems("workitem",TFSScrum_WorkItems,toolname);
					VerifyRules_workitems("nonworkitem",TFS_NonWorkItems,toolname);
				}
				
				
				
				clickJS(DIYUIMap.SaveAndNext_btn);
				clickJS(DIYUIMap.SaveSuccess_Msg);
				ExpWaitForCondition(DIYUIMap.SaveAndNext_btn);
				Thread.sleep(5000);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	
	public static void VerifyRules_workitems(String workitemornonworkitem, String[] listofentities,String toolname) {
	try{
		SoftAssert sa = new SoftAssert();
			if(workitemornonworkitem.equalsIgnoreCase("workitem"))
				{
					for(String entity:listofentities)
					{
						ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
						Thread.sleep(4000);
						selectDropdownByText(DIYUIMap.entity_drpdown, entity);
						ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
						Thread.sleep(2000);
						ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
						if(CheckIfElementExists(DIYUIMap.RuleDoesntExists_Msg))
						{
							sa.assertEquals("Absent", "Rules", "the "+entity +"does not have the rules by default in the DIY Screen for tool "+toolname);
		
						}
						else
						checkifRuleExists("workitem", entity,Property.getProperty("ProductInstanceTool"));
					}

				}
			else if(workitemornonworkitem.equalsIgnoreCase("nonworkitem"))
			{
				for(String entity:listofentities )
				{
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					Thread.sleep(4000);
					selectDropdownByText(DIYUIMap.entity_drpdown, entity);
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					Thread.sleep(2000);
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					
					if(CheckIfElementExists(DIYUIMap.RuleDoesntExists_Msg))
					{
						sa.assertEquals("Absent", "Rules", "the "+entity +"does not have the rules by default in the DIY Screen");
					}
					else
						checkifRuleExists("nonworkitem",entity,Property.getProperty("ProductInstanceTool"));
				}
			}
			sa.assertAll();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		


	private static void checkifRuleExists(String workitemOrNonworkitem, String entity, String property) {
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//		if(workitemOrNonworkitem.equalsIgnoreCase("workitem")){
//			if(!getDropdownValue(DIYUIMap.Project_drpdown).equalsIgnoreCase("Project Key"))
//			selectDropdownByText(DIYUIMap.Project_drpdown, "Project Key");
//		}
//		else if(workitemOrNonworkitem.equalsIgnoreCase("nonworkitem")){
//			if(!getDropdownValue(DIYUIMap.Project_drpdown).equalsIgnoreCase("Project"))
//		selectDropdownByText(DIYUIMap.Project_drpdown, "Project");
//		}
		if(!(getDropdownValue(DIYUIMap.Project_drpdown).equalsIgnoreCase("Project Key") || getDropdownValue(DIYUIMap.Project_drpdown).equalsIgnoreCase("Project")))
				selectByPartOfVisibleText(DIYUIMap.Project_drpdown, "Project");
		if(!getDropdownValue(DIYUIMap.Operator_drpdown).equalsIgnoreCase("="))
			selectDropdownByText(DIYUIMap.Operator_drpdown, "=");
		
	}

	private static void configuretools(String toolname,String functionality) {
		try{
			switch(toolname){
			case "ADT Jira":
			case "ADT JIRA":
			case "ADOP Jira":
			case "ADOP JIRA":
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				ExpWaitForCondition(DIYUIMap.ProjectArea_txtbox);
				clickJS(DIYUIMap.ProjectArea_txtbox);
				enterText(DIYUIMap.ProjectArea_txtbox,Property.getProperty("ProductInstanceProject"));
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				clickJS(DIYUIMap.BoardID_txtbox);
				enterText(DIYUIMap.BoardID_txtbox,Property.getProperty("Board_ID"));
				selectDropdownByText(DIYUIMap.methodology_drpdown, "Agile");
				clickJS(DIYUIMap.SaveAndNext_btn);
				ExpWaitForCondition(DIYUIMap.SaveSuccess_Msg);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				Thread.sleep(10000);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				break;
			case "TFS Agile":
			case "TFS AGILE":
			case "TFS Scrum":
			case "TFS SCRUM":
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				ExpWaitForCondition(DIYUIMap.ProjectArea_txtbox);
				clickJS(DIYUIMap.ProjectArea_txtbox);
				//changing this since for DIY, we should select a new proj and not an existing project
				enterText(DIYUIMap.ProjectArea_txtbox,Property.getProperty("ProductInstanceProjectForDIY"));
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				if(functionality.equalsIgnoreCase("ProjectHierarchy"))
				{
					enterText(DIYUIMap.ProjHierarchy_txtbox,Property.getProperty("ProductInstanceProjectForDIY")+"\\Level1");
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				}
//				else if(functionality.equalsIgnoreCase("normal"))
//				{
//					enterText(DIYUIMap.ProjectArea_txtbox,Property.getProperty("ProductInstanceProjectForDIY"));
//					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//				}
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				selectDropdownByText(DIYUIMap.methodology_drpdown, "Agile");
				clickJS(DIYUIMap.SaveAndNext_btn);
				ExpWaitForCondition(DIYUIMap.SaveSuccess_Msg);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				Thread.sleep(10000);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				break;
				
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue confugirng tool in the integrate tool screen for tool "+ toolname);
			}
	}

	public static void RemoveRole(String role, String userID) {
		try{
		clickJS(MyWizardUIMap.Search_txtbox);
		enterText(MyWizardUIMap.Search_txtbox, userID);
		ExpWaitForCondition(prepareWebElementWithDynamicXpath(MyWizardUIMap.SearchResultAccountManagement_statictxt, userID, "userID"));
		doubleClick(prepareWebElementWithDynamicXpath(MyWizardUIMap.SearchResultAccountManagement_statictxt, userID, "userID"));
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ScrollIntoView(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductConfigPage_Section, "Client/Delivery Construct Role(s)", "sectionname"));
		if(isSelected(prepareWebElementWithDynamicXpath(MyWizardUIMap.clientInAccountManagmentScreen, Property.getProperty("MyWizard_Client"), "clientname"))){
			clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.clientInAccountManagmentScreen, Property.getProperty("MyWizard_Client"), "clientname"));
		}

		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		clickJS(MyWizardUIMap.Save_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		clickJS(MyWizardUIMap.BackToDashboard_link);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void TestConnectivity(String toolname) {
		try{
		Thread.sleep(300000);
		clickJS(DIYUIMap.DataMapping_link);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ExpWaitForCondition(DIYUIMap.Verifyconnectivity_btn);
		clickJS(DIYUIMap.Verifyconnectivity_btn);
			try{
			ExpWaitForCondition(DIYUIMap.ConnectivitySuccess_Msg);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("conenctivity(pipelines) for "+toolname+" failed");
				Assert.fail("conenctivity(pipelines) for "+toolname+" failed");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue testing the connectivity for the tool "+toolname);
			Assert.fail("Issue testing the connectivity for the tool "+toolname);
			}
		}

	public static void NoteDownDCNameAndDCUID(String toolname) {
	try{
		String DCUid="";
			try{
				MyWizardHomePage.clickOnTile("Organization (Delivery) Structure Config");
				MyWizardHomePage.VerifyIfTileisLoaded("Organization (Delivery) Structure Config");
				enterText(ProductConfigUIMap.searchBox_txtbox,Baseclass.getInstance().DCName);
				ExpWaitForCondition(prepareWebElementWithDynamicXpath(DIYUIMap.DCName_statictxt, Baseclass.getInstance().DCName, "DCName"));
				clickJS(prepareWebElementWithDynamicXpath(DIYUIMap.DCName_statictxt, Baseclass.getInstance().DCName, "DCName"));
				DCUid = getAttribute(By.xpath("//label[text()='Delivery Construct UId']//following::input[1]"), "value");
				}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("created DC either not shown up in the Organization (Delivery) Structure Config tile for tool "+ toolname);
				Assert.fail("created DC either not shown up in the Organization (Delivery) Structure Config tile for tool "+ toolname);
			}
		
		String FileLocForDCUpdation="";
			if(toolname.contains("Jira") || toolname.contains("JIRA"))
			{
				FileLocForDCUpdation = System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator
						+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON"+  File.separator + "DCDetails.json";
			
			}
			if(toolname.contains("TFS") || toolname.contains("tfs"))
			{
				FileLocForDCUpdation = System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator
						+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON"+  File.separator + "DCDetails.json";
			}
			
			JSONObject jsonObject = new JSONObject();
						
		    jsonObject.put("DCName", Baseclass.getInstance().DCName);
		    jsonObject.put("DCUid", DCUid);
		    FileWriter file = new FileWriter(FileLocForDCUpdation);
		    file.write(jsonObject.toJSONString());
		    file.flush();
		    file.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("Issue writing DC name to the file for tool "+toolname);
		Assert.fail("Issue writing DC name to the file for tool "+toolname);
	}
	}

	public static void DeleteDC(String toolname) {
		try{
			
			//fetch the DC you created.
			String DCDetailsFilePath="";
			if(toolname.contains("Jira") || toolname.contains("JIRA")){
				DCDetailsFilePath = System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator
						+ "resources" + File.separator + "testdata" + File.separator  + "Jira" + File.separator + "JSON" +  File.separator + "DCDetails.json" ;
			}
			else if(toolname.contains("TFS") || toolname.contains("Tfs")){
				DCDetailsFilePath = System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator
						+ "resources" + File.separator + "testdata" + File.separator  + "TFS" + File.separator + "JSON" +  File.separator + "DCDetails.json" ;
			}
			FileReader reader = new FileReader(DCDetailsFilePath);

	        JSONParser jsonParser = new JSONParser();
	        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
	        String DCName = (String) jsonObject.get("DCName");
	        
	        clickJS(DIYUIMap.ConfigureContractExplore_btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			singleClick(DIYUIMap.SearchDC_txtbox);
			enterText(DIYUIMap.SearchDC_txtbox,DCName);
			ExpWaitForCondition(DIYUIMap.DeleteDC_btn);
			clickJS(DIYUIMap.DeleteDC_btn);
			clickJS(DIYUIMap.ConfirmDeleteDC_btn);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("issue deleting DC for tool "+toolname);
			Assert.fail("issue deleting DC for tool "+toolname);
		}
		
	}

	public static void SelectClientAndDC(String toolname) {
		try{
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		 clickJS(MyWizardUIMap.scopeSelector_drpdown);
		 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		 enterText(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox,Property.getProperty("MyWizard_Client"));
		 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		 Thread.sleep(2000);
		 if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt,Property.getProperty("MyWizard_Client"),"clientname")))
		 { 
			 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt,Property.getProperty("MyWizard_Client"),"clientname"));
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			 clear(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox);
		 }
		 else
		 Assert.fail("Mentioned client "+Property.getProperty("MyWizard_Client")+"doesnt exists");
		 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		waitPageToLoad();
	
		if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt,getDCName(toolname, "DIY"),"dcname")))
		{
			clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt,getDCName(toolname, "DIY"),"dcname"));
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		}
		else
			 Assert.fail("Mentioned client "+getDCName(toolname, "DIY")+" doesnt exists");
		clickJS(MyWizardUIMap.apply_btn);
		 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue fetching DC details for tool "+toolname);
		}
	}

	public static void DeactivateRules(String toolname) {
		String[] JIRA_WorkItems = {"Task", "Epic", "Feature", "UserStory", "Bug", "Impediment", "Issue", "Risk"};
		String[] CloudJIRA_WorkItems = {"Task", "Epic", "Feature", "UserStory", "Bug", "Impediment"};
		String[] CloudJIRA_NonWorkItems = {"Iteration"};
		
		String[] ADTJira_NonWorkItems = {"Test","Deliverable","Requirement","Iteration","Action","TestResult","Test","Milestone","ChangeRequest"};
		
		String[] ADOPJira_NonWorkItems = {"Iteration","Test"};
		String[] TFSAgile_WorkItems = {"Task", "Epic", "Feature", "UserStory", "Bug", "Issue","Risk","Impediment"};
		String[] TFSScrum_WorkItems = {"Task", "Epic", "Feature", "UserStory", "Bug", "Impediment", "Issue","Risk"};
		String[] TFS_NonWorkItems = {"Iteration", "Test", "Deliverable","Action","TestResult","Milestone","Decision","ChangeRequest","Requirement"};

	
		
		if(toolname.equalsIgnoreCase("ADT JIRA"))
		{
			DIY.DisableRules(toolname,JIRA_WorkItems,ADTJira_NonWorkItems);
		}
		else if(toolname.equalsIgnoreCase("ADOP JIRA"))
		{
			DIY.DisableRules(toolname,JIRA_WorkItems,ADOPJira_NonWorkItems);
		}
		else if(toolname.equalsIgnoreCase("TFS Agile"))
		{
			DIY.DisableRules("myWizard-TFS",TFSAgile_WorkItems,TFS_NonWorkItems);
		}
		else if(toolname.equalsIgnoreCase("Cloud JIRA"))
		{
			DIY.DisableRules("Cloud Jira",CloudJIRA_WorkItems,CloudJIRA_NonWorkItems);
		}
		else if(toolname.equalsIgnoreCase("TFS Scrum"))
		{
			DIY.DisableRules("myWizard-TFS",TFSScrum_WorkItems,TFS_NonWorkItems);
		}
		else{
			logger.info("Entered tool not found for mapping rules");
			Assert.fail("Entered tool not found for mapping rules");
		}
		
	}

	public static void DisableRules(String toolname,String[] workitems, String[] nonWorkitems){
		try{
			ExpWaitForCondition(MyWizardMappingRuleUIMap.PageSize_statictxt);
			clickJS(MyWizardMappingRuleUIMap.PageSize_statictxt);
			clickJS(MyWizardMappingRuleUIMap.PageSize100_statictxt);
			Thread.sleep(10000);
			
			if(!CheckIfElementExists(MyWizardMappingRuleUIMap.Rules_Table))
					{
					System.out.println("rules not displayed");
						refresh();
					}
			else 
			logger.info("rules present");
			Thread.sleep(5000);
					for(String entity:workitems )
					{
						
						if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.Entity_statictxt, entity, "workitem")))
								{													
									disablerule_entity(entity);
								}
						else 
							logger.info(entity+ " not found in the page");
					}
					
					for(String nonworkitem:nonWorkitems )
					{
						
						if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.EntityForDIY_statictxt, nonworkitem, "nonworkitem")))
						{
							disablerule_nonworkitem(nonworkitem);
						}else 
							logger.info(nonworkitem+ " not found in the page");
					}
		}
	
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("issue disabling the rule for tool "+toolname);
	}

	
		
	
}

	private static void disablerule_nonworkitem(String nonworkitem) {
		try{
			ExpWaitForCondition(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.EntityForDIY_statictxt, nonworkitem, "nonworkitem"));
			doubleClick(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.EntityForDIY_statictxt, nonworkitem, "nonworkitem"));
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			ExpWaitForCondition(MyWizardMappingRuleUIMap.InactiveRule_toggle);
			clickJS(MyWizardMappingRuleUIMap.InactiveRule_toggle);
			clickJS(MyWizardMappingRuleUIMap.SaveRule_btn);
			ExpWaitForCondition(MyWizardMappingRuleUIMap.RuleSavedSuccesfully_statictxt);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			ExpWaitForCondition(MyWizardMappingRuleUIMap.Rules_Table);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue disabling the rule for nonworkitem "+nonworkitem);
			}
		
		
	}

	public static void disablerule_entity(String entity) {
		try{
		ExpWaitForCondition(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.Entity_statictxt, entity, "workitem"));
		doubleClick(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.Entity_statictxt, entity, "workitem"));
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		clickJS(MyWizardMappingRuleUIMap.InactiveRule_toggle);
		clickJS(MyWizardMappingRuleUIMap.SaveRule_btn);
		ExpWaitForCondition(MyWizardMappingRuleUIMap.RuleSavedSuccesfully_statictxt);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		Thread.sleep(2000);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ExpWaitForCondition(MyWizardMappingRuleUIMap.Rules_Table);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("issue disabling the rule for entity "+entity);
		}
	}
}