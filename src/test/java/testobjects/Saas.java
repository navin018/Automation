package testobjects;

import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Pattern;

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
		clickJS(SaaSUIMap.Search);
		enterText(SaaSUIMap.SearchCatagolue, AppBundle);
		Thread.sleep(3000);
		clickJS(SaaSUIMap.AddCart_btn);
		ExpWaitForCondition(SaaSUIMap.AddCartSucess_taoastermsg);
		clickJS(SaaSUIMap.NewCart_img);
		ExpWaitForCondition(SaaSUIMap.CartPage);
		Thread.sleep(5000);
		logger.info("Successfully added "+AppBundle+" to cart");
		
		}
		catch(Exception e){
			e.printStackTrace();
			logger.info("Issue Adding "+AppBundle+" to cart");
			Assert.fail("Issue Adding "+AppBundle+" to cart");
		}
		
		
	
}

	public static void EnterDetails(String AppBundle) {
		try {
			driver().navigate().refresh();
			ExpWaitForCondition(SaaSUIMap.SelectedServices_txt);
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
			String Order_ID=getText(SaaSUIMap.OrderNum_txt).split(" ")[5];
			System.out.println(Order_ID);
			Assert.assertTrue(Pattern.compile("^ORDR").matcher(Order_ID).find());
        
            
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
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 
			ExpWaitForCondition(SaaSUIMap.Username_txt);
			Thread.sleep(5000);
			clickJS(SaaSUIMap.Username_txt);
			ExpWaitForCondition(SaaSUIMap.MyOrders_txt);
			clickJS(SaaSUIMap.MyOrders_txt);
			 Thread.sleep(1000);

			CheckIfElementExists(prepareWebElementWithDynamicXpath(SaaSUIMap.Bundle_txt,AppBundle,"AppBundle"));
			Thread.sleep(1000);
			ExpWaitForCondition(SaaSUIMap.Order_id);
			singleClick(SaaSUIMap.Order_id);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			String currentHandle= driver().getWindowHandle();
		
			ExpWaitForCondition(SaaSUIMap.ConfirmConfig_btn);
			singleClick(SaaSUIMap.ConfirmConfig_btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			//switch to last tab
			 NavigatetoLastActiveTab(currentHandle);
			logger.info("Confirming the Order for "+AppBundle+" was successfully");
	}
		catch(Exception e){
			e.printStackTrace();
			logger.info("Issue Confirming Order");
			Assert.fail("Issue Confirming Order");
		}
	}

	
	public static void AddDetails(String chargecode, String noofUsers, String contractDuration) {
		try {
		waitPageToLoad();
		ExpWaitForCondition(SaaSUIMap.Welcome_text);
		clickJS(SaaSUIMap.Console_text);
		
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
//		ExpWaitForCondition(SaaSUIMap.SuccessToaster_Msg);//might be the Issue for failure
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
		Saas.EnableUsecaseforSaaS(AppBundle);
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
			 ExpWaitForCondition(SaaSUIMap.DIYSI_text);
			 String currentHandle= driver().getWindowHandle();
			 System.out.println(currentHandle);
			 
			 if(CheckIfElementExists(SaaSUIMap.SetUp_btn)) {
				 singleClick(SaaSUIMap.SetUp_btn);
			 }
			 else if(CheckIfElementExists(SaaSUIMap.EditSetup_btn)){
				 clickJS(SaaSUIMap.EditSetup_btn);
			 }
			 
			 NavigatetoLastActiveTab(currentHandle);
			 
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 Thread.sleep(5000);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
			 Thread.sleep(9000);
			 if(CheckIfElementExists(SaaSUIMap.Confidentiality_text)) {
				 clickJS(SaaSUIMap.Iunderstand_popup);
				 clickJS(SaaSUIMap.Confirm_popup);
			 }
			 ExpWaitForCondition(DIYUIMap.selectedToolADTJira_checkbox);
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
			 Thread.sleep(5000);			 
//			 clickJS(DIYUIMap.Yes_btn);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 logger.info("Data added successfully for Integrate Tools in SaaS");
			
			 }catch(Exception e) {
			 e.printStackTrace();
			 logger.info("Issue in Entering Data in Integrate Tools page in SaaS");
			 Assert.fail("Issue in Entering Data in Integrate Tools page in SaaS");
			 }
			 
			 }
		public static void integratetools() {
			try {
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			ExpWaitForCondition(DIYUIMap.ProjectArea_txtbox);
			clear(DIYUIMap.ProjectArea_txtbox);
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
				clickJS(DIYUIMap.SaveAndNext_btn);
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
			String currentHandle= driver().getWindowHandle();
			singleClick(SaaSUIMap.GetStarted_btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 NavigatetoLastActiveTab(currentHandle);
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
		singleClick(SaaSUIMap.FirstSave_btn);
		Thread.sleep(9000);
		singleClick(SaaSUIMap.SecondSave_btn);
		
		String currentHandle= driver().getWindowHandle();
		
		ExpWaitForCondition(SaaSUIMap.OrderService_btn);

		clickJS(SaaSUIMap.OrderService_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
	
		
		 NavigatetoLastActiveTab(currentHandle);
		 Thread.sleep(5000);
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

		 private static void EnableUsecaseforSaaS(String AppBundle) {
		try {
						 
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 Thread.sleep(8000);
			 if(CheckIfElementExists(MyWizardUIMap.Dashboard_Checkbox)){
				 click(MyWizardUIMap.Dashboard_Checkbox);			
				 ExpWaitForCondition(MyWizardUIMap.Dashboard_Confirm_btn);
				 click(MyWizardUIMap.Dashboard_Confirm_btn);
			 }
			 ExpWaitForCondition(SaaSUIMap.EnableUsecase_txt);
			 
			 
			 
			 switch(AppBundle) {
			 case "Requirements Analysis":			 
				//for removing selected
					if(getAttribute(SaaSUIMap.selectedCMA_checkbox, "aria-selected").equalsIgnoreCase("true"))
						clickJS(SaaSUIMap.selectedCMA_checkbox);
					break;
			 case "Agile":
				 if(getAttribute(SaaSUIMap.StorySlicing_checkbox, "aria-selected").equalsIgnoreCase("true"))
						clickJS(SaaSUIMap.StorySlicing_checkbox);
				 break;
				 
			 case "Knowledge Assistance":
			 case "Test optimization":
			 case "Process and Workflow Management":
			 case "Planning and Program Management":
			 case "Modern Engineering Analytics":
				  	break;
				 
			 }
		 
			 			
		
//		if(!getAttribute(SaaSUIMap.selectedRRA_checkbox, "aria-selected").equalsIgnoreCase("true"))
//			clickJS(SaaSUIMap.selectedRRA_checkbox);
//		if(!getAttribute(SaaSUIMap.selectedRC_checkbox, "aria-selected").equalsIgnoreCase("true"))
//			clickJS(SaaSUIMap.selectedRC_checkbox);
//		if(!getAttribute(SaaSUIMap.selectedRM_checkbox, "aria-selected").equalsIgnoreCase("true"))
//			clickJS(SaaSUIMap.selectedRM_checkbox);
//		if(!getAttribute(SaaSUIMap.selectedDDT_checkbox, "aria-selected").equalsIgnoreCase("true"))
//			clickJS(SaaSUIMap.selectedDDT_checkbox);
//		
//		if(!getAttribute(SaaSUIMap.selectedIAI_checkbox, "aria-selected").equalsIgnoreCase("true"))
//			clickJS(SaaSUIMap.selectedIAI_checkbox);
//		if(!getAttribute(SaaSUIMap.selectedRDB_checkbox, "aria-selected").equalsIgnoreCase("true"))
//			clickJS(SaaSUIMap.selectedRDB_checkbox);
//		if(!getAttribute(SaaSUIMap.selectedRBP_checkbox, "aria-selected").equalsIgnoreCase("true"))
//			clickJS(SaaSUIMap.selectedRBP_checkbox);
//		if(!getAttribute(SaaSUIMap.selectedCygnus_checkbox, "aria-selected").equalsIgnoreCase("true"))
//			clickJS(SaaSUIMap.selectedCygnus_checkbox);
//		if(!getAttribute(SaaSUIMap.selectedIA_checkbox, "aria-selected").equalsIgnoreCase("true"))
//			clickJS(SaaSUIMap.selectedIA_checkbox);
			
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
		 
		 
		 
		 public static void VerifyBundle(String AppBundle) {

			 try {
			 
			 waitPageToLoad();
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 Thread.sleep(5000);
			 
			 //I understand Popup		 
			if(CheckIfElementExists(MyWizardUIMap.Dashboard_Checkbox)) {
	         click(MyWizardUIMap.Dashboard_Checkbox);	         
	         click(MyWizardUIMap.Dashboard_Confirm_btn);
			}
//			 //this needs to used to test all the testcases //likhitha
			 SoftAssert sa=new SoftAssert();
			 waitPageToLoad();
			 

			 switch(AppBundle){
			 
			 case "Requirements Analysis":
				 String[] Expected_RequirementsBundle = {"Requirements Management","Digital Design Thinking","Change Manager Assistant","IngrAIn","Cygnus"};
				 TileChecking(Expected_RequirementsBundle, AppBundle);
				 clickJS(SaaSUIMap.ChangeManagerAssistant_Tile);
				 ExpWaitForCondition(SaaSUIMap.Toaster_msg);
				 break;

			 case "Knowledge Assistance":
				 String[] Expected_KnowledgeAssistancebundle = {"Quasar"};
				 TileChecking(Expected_KnowledgeAssistancebundle, AppBundle);			
				 break;
				 
			 case "Agile":
				 String[] Expected_Agilebundle = {"Story Points Predictor","Report Automation","Retrospective Assistant","Sprint Planner Assistant","Traceability Assistant","Daily Standup Assistant","IngrAIn","Story Slicing (SHEQC)"};
				 TileChecking(Expected_Agilebundle , AppBundle);		
				 clickJS(SaaSUIMap.StorySlicing_Tile);
				 ExpWaitForCondition(SaaSUIMap.Toaster_msg);
			 break;
			 
			 case "Test optimization":
				 String[] Expected_Testbundle = {"Test Pattern Mining","Instant Test Automation"};
				 TileChecking(Expected_Testbundle, AppBundle);			 
				 break;
				 
			 case "Process and Workflow Management":
				 String[] Expected_ProcessandWorkflowManagementbundle = {"Process Builder"};
				 TileChecking(Expected_ProcessandWorkflowManagementbundle, AppBundle);			 
				 break;

			 case "Planning and Program Management":
				 String[] Expected_PlanningandProgramManagementbundle = {"Resource Manager","Roadmap Assistant","Milestones and Deliverables Assistant","RAID"};
				 TileChecking(Expected_PlanningandProgramManagementbundle, AppBundle);		 
				 break;

			 case "Modern Engineering Analytics":
				 String[] Expected_ModernEngineeringAnalyticsbundle = {"Virtual Data Scientist","Agile Analytics","DevOps Analytics","Earned Value Analytics","Self-service Analytics","Self-Service Reporting","IngrAIn"};
				 TileChecking(Expected_ModernEngineeringAnalyticsbundle, AppBundle);		
				 break;
			 }
			 sa.assertAll();			 
			 logger.info("Able to view all the apps under the bundle "+AppBundle+" in SaaS successfully");
//			 driver().close();


			 }
			 catch(Exception e){
				 e.printStackTrace();
				 logger.info("Issue verifying the bundle "+AppBundle+" in SaaS");
			 	 Assert.fail("Issue verifying the bundle "+AppBundle+" in SaaS");
			 }

			 }
		 
		 public static void TileChecking(String[] Expected_Bundle,String AppBundle) {
			 try {
				 for(int i=0;i<Expected_Bundle.length;i++)
					 CheckIfElementExists(prepareWebElementWithDynamicXpath(SaaSUIMap.Actual_Result,Expected_Bundle[i],"tilename"));
			 }
			 catch (Exception e) {
				 e.printStackTrace();
				 logger.info("Issue verifying the tile "+AppBundle+" in SaaS");
			 	 Assert.fail("Issue verifying the tile "+AppBundle+" in SaaS");
			 }
		 }
}