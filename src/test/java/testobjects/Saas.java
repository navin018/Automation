package testobjects;

import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import uiMap.DIYUIMap;
import uiMap.JiraUIMap;
import uiMap.MyWizardUIMap;
import uiMap.ProductConfigUIMap;
import uiMap.SaaSUIMap;
import uiMap.SecurityTestsUIMap;
import uiMap.myQueriesUIMap;
import utilities.general.Property;
import utilities.selenium.SeleniumDSL;

public class Saas extends Baseclass{
private Baseclass base;
public Saas()
{
}
public Saas(Baseclass base) {
this.base =base;
}

	public static void AddRole(String role, String userID) {
		try{
			clickJS(SaaSUIMap.Page_size);
			clickJS(SaaSUIMap.Page_num);
			clickJS(MyWizardUIMap.Search_txtbox);
			enterText(MyWizardUIMap.Search_txtbox, userID);
			ExpWaitForCondition(prepareWebElementWithDynamicXpath(MyWizardUIMap.SearchResultAccountManagement_statictxt, userID, "userID"));
			doubleClick(prepareWebElementWithDynamicXpath(MyWizardUIMap.SearchResultAccountManagement_statictxt, userID, "userID"));
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clickJS(SaaSUIMap.Clear_btn);
			Thread.sleep(3000);
			ScrollIntoView(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductConfigPage_Section, "Client/Delivery Construct Role(s)", "sectionname"));
		   clickJS(SaaSUIMap.Client_checkbox);
			Thread.sleep(2000);
		 clickJS(prepareWebElementWithDynamicXpath(SaaSUIMap.DC_Checkbox, Property.getProperty("SaaS_DC_L1"), "SaaS_DC_L1"));
			selectDropdownByText(SaaSUIMap.DC_Statictext,"Delivery Lead");
			clickJS(SaaSUIMap.Client_checkbox);
			Thread.sleep(2000);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clickJS(MyWizardUIMap.Save_btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clickJS(MyWizardUIMap.BackToDashboard_link);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			logger.info("Adding role in Account Management was successful");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				grabScreenshotForExtentReport();
				logger.info("Issue Adding the role");
				Assert.fail("Issue Adding the role");
			}
		
	}

	public static void AddBundle(String AppBundle) throws InterruptedException {
		try {
		singleClick(SaaSUIMap.Search_icon);
		enterText(SaaSUIMap.Search_txtbox, AppBundle);
		Thread.sleep(3000);
		clickJS(SaaSUIMap.AddCart_btn);
		waitPageToLoad();
		singleClick(SaaSUIMap.Cart_icon);
		waitPageToLoad();
		logger.info("Successfully added "+AppBundle+" to cart");
		
		}
		catch(Exception e){
			e.printStackTrace();
			grabScreenshotForExtentReport();
			logger.info("Issue Adding "+AppBundle+" to cart");
			Assert.fail("Issue Adding "+AppBundle+" to cart");
		}
		
		
	
}

	public static void EnterDetails(String AppBundle) {
		try {
			switch(AppBundle) {
			case "Requirements Analysis":
			case "Agile":
			case "Test optimization":
			case "Process and Workflow Management":
			case "Modern Engineering Analytics":
			case "Program & Project Management":
			clickJS(SaaSUIMap.Note_checkbox);
			Thread.sleep(1000);
			break;
			
			case "Knowledge Assistance":	
				clickJS(SaaSUIMap.Yes_btn);
				clickJS(SaaSUIMap.Note_checkbox);
				Thread.sleep(1000);
				break;
						
			}
			
			clickJS(SaaSUIMap.Confirm_btn);
			ExpWaitForCondition(SaaSUIMap.OrderConfiramtion_txt);
			grabScreenshotForExtentReport();
			//capture id for order
			
            getText(SaaSUIMap.OrderNum_txt);
            System.out.println(getText(SaaSUIMap.OrderNum_txt));
           
            String toGetID = getText(SaaSUIMap.OrderNum_txt);
            System.out.println(toGetID);
        String toGetID1[] = toGetID.split("id ");
        System.out.println(toGetID1);
        //assertion that order ID starts with something
            
			clickJS(SaaSUIMap.Ok_btn);

			waitPageToLoad();
			logger.info("Details were entered successfully for "+AppBundle+"");
			}
		catch(Exception e){
			grabScreenshotForExtentReport();
			e.printStackTrace();
			logger.info("Issue entering the details and confirming the order for "+AppBundle+"");
			Assert.fail("Issue entering the details and confirming the order for "+AppBundle+"");
		}
		
	}

	
	public static void ConfirmOrder(String AppBundle) {
		try {
//			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			int NoOfTabs =0;
//			 Baseclass.getInstance().NoOfTabs =NoOfTabs+1;
//			 SeleniumDSL.MoveToNexttab(); 
//			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
			selectDropdownByText(SaaSUIMap.Username_txt, "My Orders");
			 Thread.sleep(1000);

			CheckIfElementExists(prepareWebElementWithDynamicXpath(SaaSUIMap.Bundle_txt,AppBundle,"AppBundle"));
			Thread.sleep(1000);
			ExpWaitForCondition(SaaSUIMap.Order_id);
			singleClick(SaaSUIMap.Order_id);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			Thread.sleep(3000);
			singleClick(SaaSUIMap.ConfirmConfig_btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			logger.info("Confirming the Order for "+AppBundle+" was successfully");
	}
		catch(Exception e){
			e.printStackTrace();
			grabScreenshotForExtentReport();
			logger.info("Issue Confirming configuration");
			Assert.fail("Issue Confirming configuration");
		}
	}

	public static void VerifyBundle(String AppBundle) {
		
		try {
			int NoOfTabs =0;
			 Baseclass.getInstance().NoOfTabs =NoOfTabs+1;
			MoveToNexttab(); 
			 waitPageToLoad();
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			//this needs to used to test all the testcases //likhitha
			SoftAssert sa=new SoftAssert();
			waitPageToLoad();
			
			
	switch(AppBundle){
	
	case "Requirements Analysis":
		String[] Expected_Requirementbundle = {"Requirements Management","Digital Design Thinking","Change Manager Assistant","IngrAIn","Cygnus"};
		for(int i=0;i>Expected_Requirementbundle.length;i++)
		{
		CheckIfElementExists(prepareWebElementWithDynamicXpath(SaaSUIMap.Actual_Result,"i","tilename"));
		}
	case "Knowledge Assistance":
		String[] Expected_KnowledgeAssistancebundle = {"Quasar"};
		for(int i=0;i>Expected_KnowledgeAssistancebundle.length;i++)
		{
		CheckIfElementExists(prepareWebElementWithDynamicXpath(SaaSUIMap.Actual_Result,"i","tilename"));
		}
	case "Agile":
		String[] Expected_Agilebundle = {"Story Points Predictor","Report Automation","Retrospective Assistant","Sprint Planner Assistant","Traceability Assistant","Daily Standup Assistant","IngrAIn","Story Slicing (SHEQC)"};
		for(int i=0;i>Expected_Agilebundle.length;i++)
		{
		CheckIfElementExists(prepareWebElementWithDynamicXpath(SaaSUIMap.Actual_Result,"i","tilename"));
		}
	case "Test optimization":
		String[] Expected_Testbundle = {"Test Pattern Mining","Instant Test Automation"};
		for(int i=0;i>Expected_Testbundle.length;i++)
		{
		CheckIfElementExists(prepareWebElementWithDynamicXpath(SaaSUIMap.Actual_Result,"i","tilename"));
		}
	case "Process and Workflow Management":
		String[] Expected_ProcessandWorkflowManagementbundle = {"Process Builder"};
		for(int i=0;i>Expected_ProcessandWorkflowManagementbundle.length;i++)
		{
		CheckIfElementExists(prepareWebElementWithDynamicXpath(SaaSUIMap.Actual_Result,"i","tilename"));
		}
		
	case "Planning and Program Management":
		String[] Expected_PlanningandProgramManagementbundle = {"Resource Manager","Roadmap Assistant","Milestones and Deliverables Assistant","RAID"};		
		for(int i=0;i>Expected_PlanningandProgramManagementbundle.length;i++)
		{
		CheckIfElementExists(prepareWebElementWithDynamicXpath(SaaSUIMap.Actual_Result,"i","tilename"));
		}
		
		
	case "Modern Engineering Analytics":
		String[] Expected_ModernEngineeringAnalyticsbundle = {"Virtual Data Scientist","Agile Analytics","DevOps Analytics","Earned Value Analytics","Self-service Analytics","Self-Service Reporting","IngrAIn"};	
		for(int i=0;i>Expected_ModernEngineeringAnalyticsbundle.length;i++)
			{
			CheckIfElementExists(prepareWebElementWithDynamicXpath(SaaSUIMap.Actual_Result,"i","tilename"));
			}
		sa.assertAll();
			logger.info("Able to view all the apps under the bundle  "+AppBundle+" in SaaS successfully");
			driver().close();	
	}
		}
		catch(Exception e){
			e.printStackTrace();
			grabScreenshotForExtentReport();
			logger.info("Issue verifying the bundle "+AppBundle+" in SaaS");
			Assert.fail("Issue verifying the bundle "+AppBundle+" in SaaS");
		}
		
}
	public static void AddDetails(String chargecode, String noofUsers, String contractDuration) {
		try {
		waitPageToLoad();
		//Important Notice Popup
		if(CheckIfElementExists(SaaSUIMap.Importantnotice_text)) {
		clickJS(SaaSUIMap.Iagree_text);
		ExpWaitForCondition(SaaSUIMap.Submit_btn_popup);
		clickJS(SaaSUIMap.Submit_btn_popup);
		}
		//Details
		ExpWaitForCondition(SaaSUIMap.Demographics_text);
		clear(SaaSUIMap.ChargeCode_txtbox);
		enterText(SaaSUIMap.ChargeCode_txtbox,chargecode);
		selectByPartOfVisibleText(SaaSUIMap.NoofUsers_Dropdown, noofUsers);
		selectByPartOfVisibleText(SaaSUIMap.ContractDuration_Dropdown, contractDuration);
		//Verify charge code
		singleClick(SaaSUIMap.Verify_text);
		ExpWaitForCondition(SaaSUIMap.Success_txt);
		clickJS(SaaSUIMap.DC_Submit_btn);
		ExpWaitForCondition(SaaSUIMap.SuccessToaster_Msg);
		logger.info("Details in Contract Demographics page added successfully");
		}
		catch(Exception e) {
		e.printStackTrace();
		grabScreenshotForExtentReport();
		logger.info("Issue in Adding details in Contract Demographics page in SaaS");
		Assert.fail("Issue in Adding details in Contract Demographics page in SaaS");
		}
		}

		 public static void EnterDataforSelectTool(String Section, String AppBundle) {
		try {
		switch(Section) {
		case "select tools":
		Saas.selecttools();
		break;
		case "integrate tools":
		Saas.integratetools();
		break;
		case "data mapping":
		Saas.DataMappingforSaaS();
		break;
		case "enable usecases":
		Saas.EnableUsecaseforSaaS();
		break;
		case "add users":
		Saas.AddUsers(AppBundle);
		break;
		}
		logger.info("Data in "+Section+" in SaaS added successfully");
		}
		catch(Exception e) {
		e.printStackTrace();
		grabScreenshotForExtentReport();
		logger.info("Issue in Entering Data in "+Section+" in SaaS");
		Assert.fail("Issue in Entering Data in "+Section+" in SaaS");
		}
		}

		public static void selecttools() {
			 try {
//			 ExpWaitForCondition(SaaSUIMap.DIYSI_text);
			 singleClick(SaaSUIMap.SetUp_btn);
			 waitPageToLoad();
			 
			 //switch to other tab
//			 TabHandling();
			int NoOfTabs =0;
			 Baseclass.getInstance().NoOfTabs =NoOfTabs+1;
			 SeleniumDSL.MoveToNexttab(); 
			 waitPageToLoad();
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
			 
			 if(CheckIfElementExists(SaaSUIMap.Confidentiality_text)) {
			 clickJS(SaaSUIMap.Iunderstand_popup);
			 clickJS(SaaSUIMap.Confirm_popup);
			 }
			//application lifecycle management
			 clickJS(DIYUIMap.selectedToolADTJira_checkbox);
			 clickJS(SaaSUIMap.TFS_checkbox);
			 // clickJS(DIYUIMap.ConfirmChangingTool_btn);
			 clickJS(DIYUIMap.Next_btn);
			 //planning
//			 if(!getAttribute(SaaSUIMap.TFS_checkbox, "checked").equalsIgnoreCase("true"))
			 clickJS(DIYUIMap.selectedToolADTJira_checkbox);
			 clickJS(SaaSUIMap.TFS_checkbox);
			 clickJS(DIYUIMap.Next_btn);
			 Thread.sleep(3000);
			 //Deliverables
//			 if(!getAttribute(SaaSUIMap.TFS_checkbox, "checked").equalsIgnoreCase("true"))
			 clickJS(DIYUIMap.selectedToolADTJira_checkbox);
			 clickJS(SaaSUIMap.TFS_checkbox);
			 clickJS(DIYUIMap.Next_btn);
			 //Requirements
//			 if(!getAttribute(SaaSUIMap.TFS_checkbox, "checked").equalsIgnoreCase("true"))
			 clickJS(DIYUIMap.selectedToolADTJira_checkbox);
			 clickJS(SaaSUIMap.TFS_checkbox);
			 clickJS(DIYUIMap.Next_btn);
			 //release management
//			 if(!getAttribute(SaaSUIMap.TFS_checkbox, "checked").equalsIgnoreCase("true"))
			 clickJS(DIYUIMap.selectedToolADTJira_checkbox);
			 clickJS(SaaSUIMap.TFS_checkbox);
			 clickJS(DIYUIMap.Next_btn);
			 Thread.sleep(3000);
			 //testing
//			 if(!getAttribute(SaaSUIMap.TFS_checkbox, "checked").equalsIgnoreCase("true"))
			 clickJS(DIYUIMap.selectedToolADTJira_checkbox);
			 clickJS(SaaSUIMap.TFS_checkbox);
//			 clickJS(DIYUIMap.Next_btn);
			 //devops nothing to do
			 clickJS(DIYUIMap.SaveAndNext_btn);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			 Thread.sleep(5000); ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			 clickJS(DIYUIMap.Yes_btn);
//			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			 logger.info("Data added successfully for Integrate Tools in SaaS");
			 }catch(Exception e) {
			 e.printStackTrace();
			 grabScreenshotForExtentReport();
			 logger.info("Issue in Entering Data in Integrate Tools page in SaaS");
			 Assert.fail("Issue in Entering Data in Integrate Tools page in SaaS");
			 }
			 
			 }
		public static void integratetools() {
			try {
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			ExpWaitForCondition(DIYUIMap.ProjectArea_txtbox);
			clickJS(DIYUIMap.ProjectArea_txtbox);
			//changing this since for DIY, we should select a new proj and not an existing project
			enterText(DIYUIMap.ProjectArea_txtbox,Property.getProperty("ProductInstanceProjectForDIY"));
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			selectDropdownByText(DIYUIMap.methodology_drpdown, "Agile");
			clickJS(DIYUIMap.SaveAndNext_btn);
			ExpWaitForCondition(DIYUIMap.SaveSuccess_Msg);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			Thread.sleep(10000);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			logger.info("Data added successfully for Integrate tool page in SaaS");
			}
			catch(Exception e) {
			e.printStackTrace();
			grabScreenshotForExtentReport();
			logger.info("Issue in Entering Data in Integrate tool page in SaaS");
			Assert.fail("Issue in Entering Data in Integrate tool page in SaaS");
			}
			}
		 public static void DataMappingforSaaS() {
			 try {
				 String toolname = "TFS Agile";
				 String[] TFSAgile_WorkItems = {"Task", "Epic", "Feature", "UserStory", "Bug", "Issue","Risk","Impediment"};
				 String[] TFS_NonWorkItems = {"Iteration", "Test", "Deliverable","Action","TestResult","Milestone","Decision","ChangeRequest","Requirement"};
				DIY.VerifyRules_workitems("workitem",TFSAgile_WorkItems,toolname);
				DIY.VerifyRules_workitems("nonworkitem",TFS_NonWorkItems,toolname);

			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 logger.info("Data added successfully for Data Mapping page in SaaS");
			 }
			 catch(Exception e) {
			 e.printStackTrace();
			 grabScreenshotForExtentReport();
			 logger.info("Issue in Entering Data in Data Mapping page in SaaS");
			 Assert.fail("Issue in Entering Data in Data Mapping page in SaaS");
			 }
			 }

		public static void GetStartedtooderservices(String AppBundle) {
		try {
		singleClick(SaaSUIMap.GetStarted_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		logger.info("Data added successfully for Get Started page in SaaS");
		}
		catch(Exception e) {
		e.printStackTrace();
		grabScreenshotForExtentReport();
		logger.info("Issue in Entering Data in Get Started page in SaaS");
		Assert.fail("Issue in Entering Data in Get Started page in SaaS");
		}
		}

		 private static void AddUsers(String AppBundle) {
		try {
		ExpWaitForCondition(SaaSUIMap.Userinenableuser_text);
		clickJS(SaaSUIMap.saveandnxt_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ExpWaitForCondition(SaaSUIMap.Greentick_img);
//		clickJS(SaaSUIMap.Arrow_img);
		clickJS(SaaSUIMap.OrderService_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		int NoOfTabs =0;
		 Baseclass.getInstance().NoOfTabs =NoOfTabs+1;
		 SeleniumDSL.MoveToNexttab(); 
		 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);

		
		
		logger.info("Data added successfully for Add Users page in SaaS");
		
		
		 }
		
		 catch(Exception e) {
		e.printStackTrace();
		grabScreenshotForExtentReport();
		logger.info("Issue in Entering Data in Add Users page in SaaS");
		Assert.fail("Issue in Entering Data in Add Users page in SaaS");
		}
} 

		 private static void EnableUsecaseforSaaS() {
		try {
			int NoOfTabs =0;
			 Baseclass.getInstance().NoOfTabs =NoOfTabs+1;
			 SeleniumDSL.MoveToNexttab(); 
			 waitPageToLoad();
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
		
		if(getAttribute(SaaSUIMap.selectedRRA_checkbox, "aria-selected").equalsIgnoreCase("true"))
		clickJS(SaaSUIMap.selectedRRA_checkbox);
		if(getAttribute(SaaSUIMap.selectedRC_checkbox, "aria-selected").equalsIgnoreCase("true"))
		clickJS(SaaSUIMap.selectedRC_checkbox);
		if(getAttribute(SaaSUIMap.selectedRM_checkbox, "aria-selected").equalsIgnoreCase("true"))
		clickJS(SaaSUIMap.selectedRM_checkbox);
		if(getAttribute(SaaSUIMap.selectedDDT_checkbox, "aria-selected").equalsIgnoreCase("true"))
		clickJS(SaaSUIMap.selectedDDT_checkbox);
		if(getAttribute(SaaSUIMap.selectedCMA_checkbox, "aria-selected").equalsIgnoreCase("true"))
		clickJS(SaaSUIMap.selectedCMA_checkbox);
		if(getAttribute(SaaSUIMap.selectedIAI_checkbox, "aria-selected").equalsIgnoreCase("truee"))
		clickJS(SaaSUIMap.selectedIAI_checkbox);
		if(getAttribute(SaaSUIMap.selectedRDB_checkbox, "aria-selected").equalsIgnoreCase("true"))
		clickJS(SaaSUIMap.selectedRDB_checkbox);
		if(getAttribute(SaaSUIMap.selectedRBP_checkbox, "aria-selected").equalsIgnoreCase("true"))
		clickJS(SaaSUIMap.selectedRBP_checkbox);
		if(getAttribute(SaaSUIMap.selectedCygnus_checkbox, "aria-selected").equalsIgnoreCase("true"))
		clickJS(SaaSUIMap.selectedCygnus_checkbox);
		if(getAttribute(SaaSUIMap.selectedIA_checkbox, "aria-selected").equalsIgnoreCase("true"))
		clickJS(SaaSUIMap.selectedIA_checkbox);
		clickJS(SaaSUIMap.saveandnxt_btn);

		logger.info("Data added successfully for Enable Usecase page in SaaS");
		}catch(Exception e) {
		e.printStackTrace();
		grabScreenshotForExtentReport();
		logger.info("Issue in Entering Data in Enable Usecase page in SaaS");
		Assert.fail("Issue in Entering Data in Enable Usecase page in SaaS");
		}
		}
		 public static void TabHandling()
		 {
		 ArrayList<String> Nooftabs = new ArrayList<String> (driver().getWindowHandles());
		 int Imtermediate=Nooftabs.lastIndexOf(Nooftabs);
		 int LastTab=Imtermediate-1;
		 driver().switchTo().window(Nooftabs.get(LastTab));
		 }
}