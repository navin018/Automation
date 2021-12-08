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
import org.xbill.DNS.utils.base16;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import dataobjects.WorkItemDO;
import dataobjects.WorkItemExternalIDDO;
//import javassist.bytecode.stackmap.BasicBlock.Catch;
import testobjects.Baseclass;
import uiMap.JiraUIMap;
import uiMap.MyWizardUIMap;
import uiMap.PreComputationEngineUIMAP;
import uiMap.SaaSUIMap;
import utilities.general.DataManager;
import utilities.general.Property;
import utilities.selenium.SeleniumDSL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;

public class PreComputationEngine extends Baseclass{
		private Baseclass base;
	
		public PreComputationEngine()
		{
			
		}
		
		public PreComputationEngine(Baseclass base) {
			this.base =base; 
		}
		
		public static String testDataPath = System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" +  File.separator;

		public static void CreateTestProcess(String alertOrCompute, String entity, String subEntity) {
			try{
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				singleClick(PreComputationEngineUIMAP.AddProcess_link);// Selects the add process icon
				ExpWaitForCondition(PreComputationEngineUIMAP.Name_txtbox);
				int RandomNumber = RandomNumberGenerator();
				String TestProcessName = "TestProcess_WSJF_"+subEntity+RandomNumber;
				enterText(PreComputationEngineUIMAP.Name_txtbox,TestProcessName);
//				String entityName = "TestProcess_WSJF_"+subEntity+"#"+RandomNumber;
				System.out.println(TestProcessName);
				//save entity name in baseclass
//					if(subEntity.contains("Story"))
//					{
						Baseclass.getInstance().TestProcessName=TestProcessName;    
//					}
					
				enterText(PreComputationEngineUIMAP.Description_txtbox,TestProcessName);
				Thread.sleep(2000);
				selectDropdownByText(PreComputationEngineUIMAP.ProcessType_drpdown,alertOrCompute); // TYPE
				Thread.sleep(2000);
				selectByPartOfVisibleText(PreComputationEngineUIMAP.TriggerBasedOn_drpdown,"Data change");	// TRIGGER_BASED_ON
//				selectDropdownByValue(PreComputationEngineUIMAP.TriggerBasedOn_drpdown,"00907020-0020-0000-0000-000000000000");  
				Thread.sleep(2000);
//				selectByPartOfVisibleText(PreComputationEngineUIMAP.Entitytype_drpdown,entity);// ENTITY_TYPE
				singleClick(PreComputationEngineUIMAP.Entitytype_drpdown);
				enterText(PreComputationEngineUIMAP.Entitytype_drpdown1, entity);
				sendEntr();
//				selectDropdownByValue(PreComputationEngineUIMAP.Entitytype_drpdown,"00020040-0200-0000-0000-000000000000");  
				Thread.sleep(2000);
				if(subEntity.contains("Story"))
				selectByPartOfVisibleText(PreComputationEngineUIMAP.workitem_drpdown,"UserStory"); // WORKITEM_TYPE
				else 
					selectByPartOfVisibleText(PreComputationEngineUIMAP.workitem_drpdown,"UserStory"); // WORKITEM_TYPE
//				selectDropdownByValue(PreComputationEngineUIMAP.workitem_drpdown,"00020040-0200-0010-0040-000000000000");
				Thread.sleep(2000);
				selectDropdownByText(PreComputationEngineUIMAP.Entityevent_drpdown,"Merged");  //ENTITY_EVENT
				Thread.sleep(2000);
				singleClick(PreComputationEngineUIMAP.Application_dropdown);
				enterText(PreComputationEngineUIMAP.Search,"Story Readiness Assistant");  //APPLICATION_DROPDOWN
				singleClick(PreComputationEngineUIMAP.Story_Readiness_txt);
				Thread.sleep(2000);
				clickJS(PreComputationEngineUIMAP.empty_space);
				singleClick(PreComputationEngineUIMAP.Save_btn);  //save
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				
			}
				catch(Exception e)
				{
					e.printStackTrace();
					logger.info("Adding of new process failed for entity "+entity+" and subentity "+subEntity);
					Assert.fail("Adding of new process failed for entity "+entity+" and subentity "+subEntity);
				}		
			
		}

		public static void EditNewTestProcess(String SubEntity,String toolname) {
			try{
					String testprocessname ="";
					//edit the process

//					if(SubEntity.contains("Story"))
//					{
						testprocessname = Baseclass.getInstance().TestProcessName;    
//					}
//					clickJS(PreComputationEngineUIMAP.viewmore_text);
//					clickJS(prepareWebElementWithDynamicXpath(PreComputationEngineUIMAP.TestProcess_MoreOptions_Drpdown, testprocessname, "testprocessname"));
//					ExpWaitForCondition(prepareWebElementWithDynamicXpath(PreComputationEngineUIMAP.TestProcess_Edit_Link,testprocessname, "testprocessname"));
//					clickJS(prepareWebElementWithDynamicXpath(PreComputationEngineUIMAP.TestProcess_Edit_Link,testprocessname, "testprocessname"));
//					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//		
//					//drag and drop node
//				
//					WebElement source = find(PreComputationEngineUIMAP.compute_node);
//		            WebElement destination = find(PreComputationEngineUIMAP.empty_area);
//		            DragAndDropUsingJS(source, destination);
//		            
//		            //enter node details
//		            enterText(PreComputationEngineUIMAP.definition_txtbox,"TestNode");
//					enterText(PreComputationEngineUIMAP.Result_storedin_txtbox,testprocessname);
					System.out.println(getAttribute(PreComputationEngineUIMAP.Result_storedin_txtbox,"value"));
		     		singleClick(PreComputationEngineUIMAP.configurecalculation_link);
		//			singleClick(PreComUIMAP.Editcalculation_btn);
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					ExpWaitForCondition(PreComputationEngineUIMAP.back_btn);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Editing process failed for subentity "+SubEntity);
				Assert.fail("Adding of new process failed for subentity "+SubEntity);
			}		
		}

		public static void EnterFormula(String formula) {
			try{
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			String[] formula_split= formula.split(" ");
				for(int i=0;i<formula_split.length;i++)
				{
					switch(formula_split[i])
					{
					
						case("BusinessValue"):
							clickJS(PreComputationEngineUIMAP.SelectFieldForEntity_dropdown);
							clickJS(PreComputationEngineUIMAP.BusinessValue_checkbox);
							singleClick(PreComputationEngineUIMAP.SelectFieldForEntity_txt);
							clickJS(PreComputationEngineUIMAP.BusinessValue_label);
							break;
						case("StoryPoints"):
							singleClick(PreComputationEngineUIMAP.SelectFieldForEntity_dropdown);
							clickJS(PreComputationEngineUIMAP.StoryPointEstimated_checkbox);
							singleClick(PreComputationEngineUIMAP.SelectFieldForEntity_txt);
							clickJS(PreComputationEngineUIMAP.StoryPointEstimated_label);
							break;
						case("+"):
							clickJS(PreComputationEngineUIMAP.add_icon);
							break;
						case("-"):
							clickJS(PreComputationEngineUIMAP.subtract_icon);
							break;
						case("*"):
							clickJS(PreComputationEngineUIMAP.multiply_icon);
							break;
						case("/"):
							clickJS(PreComputationEngineUIMAP.div_icon);
							break;
						case("("):
							clickJS(PreComputationEngineUIMAP.leftbracket_icon);
							break;
						case(")"):
							clickJS(PreComputationEngineUIMAP.rightbracket_icon);
							break;
						case("="):
							clickJS(PreComputationEngineUIMAP.equal_icon);
							break;
						case("!="):
							clickJS(PreComputationEngineUIMAP.notequals_icon);
							break;
						case("Priority"):
							System.out.println("add code for priority");
							break;
						case("Severity"):
							System.out.println("add code for Severity");
							break;
						case("RiskReduction"):
							clickJS(PreComputationEngineUIMAP.RiskReduction_checkbox);
							clickJS(PreComputationEngineUIMAP.RiskReduction_label);
							break;
						case("BusinessValue_Task"):
							selectDropdownByText(PreComputationEngineUIMAP.Level1AssociationToTask_drpdown, "WorkItem-Task");
							ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
							clickJS(PreComputationEngineUIMAP.SelectFieldForEntity_dropdown);
							clickJS(PreComputationEngineUIMAP.BusinessValue_checkbox);
							clickJS(PreComputationEngineUIMAP.BusinessValue_label);
						}
				}
				clickJS(PreComputationEngineUIMAP.SaveFormula_btn);
				ExpWaitForCondition(PreComputationEngineUIMAP.SaveSuccess_Msg);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		public static void MakeNoteOfTestProcessName(String SubEntity, String toolname) {
			try{
				String testDataPath = System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator
						+ "resources" + File.separator + "testdata" + File.separator;
				
				String testDataPath_WorkItemExternalIDs="";
				if((toolname.equalsIgnoreCase("ADT Jira") || toolname.equalsIgnoreCase("ADOP Jira") || toolname.contains("Jira") || toolname.contains("JIRA")))
				
						testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "TestProcess_PreComputation_WSJF.json" ;
				else if((toolname.equalsIgnoreCase("TFS Agile") || toolname.equalsIgnoreCase("TFS Scrum") || toolname.contains("TFS")))
						testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "TestProcess_PreComputation_WSJF.json" ;
				
			FileReader reader = new FileReader(testDataPath_WorkItemExternalIDs);
			JSONParser jsonParser = new JSONParser();
		        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
		        jsonObject.put("TestProcess_WSJF_"+SubEntity, Baseclass.getInstance().TestProcessName);        
		        FileOutputStream outputStream = new FileOutputStream(testDataPath_WorkItemExternalIDs);
				byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}

		public static void GetTestProcess(String subEntity, String toolname) {
		try{
			String testDataPath = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator;
			
			String testDataPath_TestProcessID="";
			if((toolname.equalsIgnoreCase("ADT Jira") || toolname.equalsIgnoreCase("ADOP Jira") || toolname.contains("Jira") || toolname.contains("JIRA")))
			
				testDataPath_TestProcessID = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "TestProcess_PreComputation_WSJF.json" ;
			else if((toolname.equalsIgnoreCase("TFS Agile") || toolname.equalsIgnoreCase("TFS Scrum") || toolname.contains("TFS")))
				testDataPath_TestProcessID = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "TestProcess_PreComputation_WSJF.json" ;
			
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(testDataPath_TestProcessID));
		JSONObject jsonObject = (JSONObject) obj;
		String testprocessname=(String) jsonObject.get("TestProcess_WSJF_"+subEntity);
		Baseclass.getInstance().TestProcessName = testprocessname;
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("issue getting testprocess name for the entity "+subEntity);
		}
			
		}

		public static void EditExistingTestProcess(String subEntity, String toolname) {
			
			String testprocessname = Baseclass.getInstance().TestProcessName;
			clickJS(PreComputationEngineUIMAP.viewmore_text);
			clickJS(prepareWebElementWithDynamicXpath(PreComputationEngineUIMAP.TestProcess_MoreOptions_Drpdown, testprocessname, "testprocessname"));
			ExpWaitForCondition(prepareWebElementWithDynamicXpath(PreComputationEngineUIMAP.TestProcess_Edit_Link,testprocessname, "testprocessname"));
			clickJS(prepareWebElementWithDynamicXpath(PreComputationEngineUIMAP.TestProcess_Edit_Link,testprocessname, "testprocessname"));
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clickJS(PreComputationEngineUIMAP.Editcalculation_btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clickJS(PreComputationEngineUIMAP.clear_btn);
		}


		public static void checkProperty(String Entity, String Functionality) {
			try {		
								
		//Checking Property
				switch (Entity) {
				case "Userstory":
					ViewOrEdit("Edit","WSJF Userstory");
					ExpWaitForCondition(PreComputationEngineUIMAP.Userstoryfield_txt);
					String[] Property_userstory= {"StoryPointCompleted","StoryPointEstimated"};
					singleClick(PreComputationEngineUIMAP.SelectFieldForEntity_dropdown);		
					for(int i=0;i<Property_userstory.length;i++) {
						if(CheckIfElementExists(prepareWebElementWithDynamicXpath(PreComputationEngineUIMAP.Property_checkbox, Property_userstory[i],"PropertyName")))
							logger.info("Property "+Property_userstory[i]+"is Present for "+Entity);
						else
							Assert.fail("Property "+Property_userstory[i]+"is not present");
					}
					break;
				case "Requirement":
					ViewOrEdit("Edit","Requirement WSJF");
					ExpWaitForCondition(PreComputationEngineUIMAP.Requirementfield_txt);
					String[] Property_requirement= {"RequirementTypeUId","SScore","Ascore","TScore"};
					singleClick(PreComputationEngineUIMAP.SelectFieldForEntity_dropdown);
					for(int i=0;i<Property_requirement.length;i++)	{					
						if(CheckIfElementExists(prepareWebElementWithDynamicXpath(PreComputationEngineUIMAP.Property_checkbox, Property_requirement[i],"PropertyName")))
							logger.info("Property "+Property_requirement[i]+"is present");
						else
							Assert.fail("Property "+Property_requirement[i]+"is not present");
					}
					break;
				}
			
					
		//go to main page	
				clickJS(PreComputationEngineUIMAP.Back_button);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				clickJS(PreComputationEngineUIMAP.Back_button);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);	
				
			}
			catch(Exception e) {
				e.printStackTrace();
				logger.info("Issue Checking Property for "+ Entity);
				Assert.fail("Issue Checking Property for "+ Entity);
			}
			
		}



		public static void AddNewProperty(String Property, String Entity) {
			try {
				singleClick(PreComputationEngineUIMAP.Weighatge_img);
				
				ExpWaitForCondition(PreComputationEngineUIMAP.SelectEntity_dropdown);
				selectByPartOfVisibleText(PreComputationEngineUIMAP.SelectEntity_dropdown, Entity);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);	
				clickJS(PreComputationEngineUIMAP.AddRow_icon);
				ExpWaitForCondition(PreComputationEngineUIMAP.Selectinfirstrow);
				selectByPartOfVisibleText(PreComputationEngineUIMAP.Selectinfirstrow, Property);
				selectByPartOfVisibleText(PreComputationEngineUIMAP.Group_select, "WSJF-Weightage");
				selectByPartOfVisibleText(PreComputationEngineUIMAP.Name_select, "New");
				enterText(PreComputationEngineUIMAP.Value_txtbox,"10");
				clickJS(PreComputationEngineUIMAP.Saveweightage_btn);
				ExpWaitForCondition(PreComputationEngineUIMAP.Sucesstoaster_msg);
				logger.info("New Property "+Property+" for "+Entity+" added successfully in UI");
				
			}
			catch(Exception e) {
				e.printStackTrace();
				logger.info("Unable to add New Property in UI");
				Assert.fail("Unable to add New Property in UI");
			}
		}

		public static void DeleteAddedProperty(String Property, String Entity) {
			try {
				
//				ExpWaitForCondition(PreComputationEngineUIMAP.SelectEntity_dropdown);
				selectByPartOfVisibleText(PreComputationEngineUIMAP.SelectEntity_dropdown, Entity);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				for(int i=1;i<=4;i++) {				
					if(getDropdownValue(prepareWebElementWithDynamicXpath(PreComputationEngineUIMAP.Property_dropdown, Integer.toString(i), "R")).equalsIgnoreCase("StateUId"))
						singleClick(prepareWebElementWithDynamicXpath(PreComputationEngineUIMAP.DeleteProperty_option,Integer.toString(i), "R"));
				}
				clickJS(PreComputationEngineUIMAP.Nextpage_option);	
				for(int i=1;i<=4;i++) {				
							if(getDropdownValue(prepareWebElementWithDynamicXpath(PreComputationEngineUIMAP.Property_dropdown, Integer.toString(i), "R")).equalsIgnoreCase("StateUId")) {
								singleClick(prepareWebElementWithDynamicXpath(PreComputationEngineUIMAP.DeleteProperty_option,Integer.toString(i), "R"));
								break;
						}
				}
									
				  
						
//				getDropdownValue
				
//				ExpWaitForCondition(PreComputationEngineUIMAP.DeleteProperty_option);
				
				ExpWaitForCondition(PreComputationEngineUIMAP.YesAfterDelete_btn);
				clickJS(PreComputationEngineUIMAP.YesAfterDelete_btn);				
				clickJS(PreComputationEngineUIMAP.Saveweightage_btn);
				ExpWaitForCondition(PreComputationEngineUIMAP.Sucesstoaster_msg);
				logger.info("Added Property "+Property+" for "+Entity+" deleted successfully in UI");
				
			}
			catch(Exception e) {
				e.printStackTrace();
				logger.info("Unable to Delete Added Property for Precomputation in UI");
				Assert.fail("Unable to Delete Added  Property for Precomputation in UI");
			}
			
		}

		public static void ValidateFilter(String processName) {
			try {
			
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);	
				clickJS(PreComputationEngineUIMAP.Filter_img);
		//Values Entered for Global UserStory RAG Process in ADT Jira	
				selectByPartOfVisibleText(PreComputationEngineUIMAP.Triggerbasedon_drpdown, "Scheduler");
				selectByPartOfVisibleText(PreComputationEngineUIMAP.Status_dropdown, "Publish");
				selectByPartOfVisibleText(PreComputationEngineUIMAP.Type_dropdown, "Validation");
				selectByPartOfVisibleText(PreComputationEngineUIMAP.Entity_dropdown, "WorkItem");
				selectByPartOfVisibleText(PreComputationEngineUIMAP.Workitem_drpdown, "UserStory");
				selectByPartOfVisibleText(PreComputationEngineUIMAP.Entityevent_dropdown, "Merged");
				CheckIfElementExists(PreComputationEngineUIMAP.Active_txt);
				clickJS(PreComputationEngineUIMAP.Apply_btn);
				if(CheckElementsSize(PreComputationEngineUIMAP.Elementtobefiltered)==1)					
					logger.info("Filter for "+processName +" is validated");
				else
					Assert.fail("Filter for "+processName +" is not working as expected");
				
			}
			catch(Exception e) {
				e.printStackTrace();
				logger.info("Filter for "+processName +" is not working as expected");
				Assert.fail("Filter for "+processName +" is not working as expected");
			}
			
			
		}

		public static void ViewOrEdit(String EditOrView, String Processname) {
			try {
				
		//search validation
				ExpWaitForCondition(PreComputationEngineUIMAP.Search_Imgintile);
				singleClick(PreComputationEngineUIMAP.Search_Imgintile);				
				enterText(PreComputationEngineUIMAP.Search_Imgintile,Processname);
				
		//Edit Validation	
				if(EditOrView.equalsIgnoreCase("Edit")){
					clickJS(PreComputationEngineUIMAP.More_options);
					ExpWaitForCondition(PreComputationEngineUIMAP.EditNode_txt);
					clickJS(PreComputationEngineUIMAP.EditNode_txt);
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					ExpWaitForCondition(PreComputationEngineUIMAP.Editcalculation_btn);
					clickJS(PreComputationEngineUIMAP.Editcalculation_btn);
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					Thread.sleep(5000);
		//View Validation			
				}else if(EditOrView.equalsIgnoreCase("View")) {
					clickJS(PreComputationEngineUIMAP.More_options);
					ExpWaitForCondition(PreComputationEngineUIMAP.ViewNode_txt);
					clickJS(PreComputationEngineUIMAP.ViewNode_txt);
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					clickJS(PreComputationEngineUIMAP.Editcalculation_btn);
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					String[] Disabled_Items= {"Pre Defined Formula","Reset","Save"};
					for(int i =0;i<Disabled_Items.length;i++) {
						if(CheckIfElementExists(prepareWebElementWithDynamicXpath(PreComputationEngineUIMAP.Disabled_items, Disabled_Items[i], "disabled")))
							logger.info("No Editing is possible in  View Mode in precomp Page");
						else
							Assert.fail("Editing is possible in View Mode");
										
				}
			}
			}
			catch(Exception e) {
				e.printStackTrace();
				logger.info("Issue in Viewing/Editing Node in precomp Page");
				Assert.fail("Issue in Viewing/Editing Node in precomp Page");
			}
			
		}

		public static void Addfiltercriteria() {
			try {
		//Filter criteria in formula Page		
				ExpWaitForCondition(PreComputationEngineUIMAP.AddFilter_optn);
				clickJS(PreComputationEngineUIMAP.AddFilter_optn);
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					if(CheckIfElementExists(PreComputationEngineUIMAP.StateUid_label)) {
						singleClick(PreComputationEngineUIMAP.StateUid_label);
					}
					else {
						singleClick(PreComputationEngineUIMAP.SelectFieldForEntity_dropdown);
						clickJS(PreComputationEngineUIMAP.StateUId_select);
						singleClick(PreComputationEngineUIMAP.Filter_txtarea);
						singleClick(PreComputationEngineUIMAP.StateUid_label);
					}
					
					singleClick(PreComputationEngineUIMAP.equal_icon);
					singleClick(PreComputationEngineUIMAP.Filter_txtarea);
					enterText(PreComputationEngineUIMAP.Filter_txtarea,"New");
					singleClick(PreComputationEngineUIMAP.SaveFormula_btn);
					ExpWaitForElementToDisappear(PreComputationEngineUIMAP. SaveSuccess_Msg);
					logger.info("Filter Criteria in Formula Page is successfully added for Precomputation");
				
			}
			catch(Exception e) {
				e.printStackTrace();
				logger.info("Unable to add filter criteria for Precomputation");
				Assert.fail("Unable to add filter criteria for Precomputation");
			}
				
			
		}
		public static void CheckUserGuide(String tilename) {
			try {
				ExpWaitForCondition(PreComputationEngineUIMAP.Userguide_icon);
				 String currentHandle= driver().getWindowHandle();
				clickJS(PreComputationEngineUIMAP.Userguide_icon);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);	
				SeleniumDSL.NavigatetoLastActiveTab(currentHandle);
				SeleniumDSL.MovetoNext();
		//Pdf Validation to be done
				String Title=getTitle();
				System.out.println(Title);
//				if(getTitle().equals(tilename))
				Assert.assertEquals(Title,tilename);
					logger.info("User Guide Avilable for "+tilename);
								
			}
			catch(Exception e) {
				e.printStackTrace();
				logger.info("User Guide is not available for "+tilename);
				Assert.fail("User Guide is not available for "+tilename);
			}
			
		}
	}