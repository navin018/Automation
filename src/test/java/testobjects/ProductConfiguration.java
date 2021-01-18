package testobjects;
import uiMap.MyWizardUIMap;
import uiMap.ProductConfigUIMap;
import utilities.general.Property;
import utilities.selenium.DriverFactory;
import utilities.selenium.Excel;
import static org.testng.Assert.assertEquals;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import dataobjects.ClientNativeAPI;
import dataobjects.ClientNativeAPI.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.jcraft.jsch.Logger;

import net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

import org.openqa.selenium.NoSuchElementException;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
public class ProductConfiguration extends Baseclass {
	
	private Baseclass base;
	
	public ProductConfiguration(){
		
	}
	
	public ProductConfiguration(Baseclass base) {
		this.base =base; 
	}
	
	
	public static String Attributes_FileLoc = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator	+ "resources" + File.separator + "testdata" + File.separator + "SEI" + File.separator + "Excel" + File.separator +"DefaultIntegartionPerametersValue.xlsx";
	public static String ClientNative_FileLoc = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator	+ "resources" + File.separator + "testdata" + File.separator + "MyWizard" + File.separator + "ClientNative" + File.separator +"ClientNative.xlsx";
	
	public static XSSFWorkbook workbook;
	public static FileInputStream fis;
	public static XSSFSheet sheet;
	
	
	public static void SelectTheTool(String toolname)
	{
		try{
			
		if(toolname.equalsIgnoreCase("ADT JIRA") || toolname.equalsIgnoreCase("ADOP JIRA"))
		{
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			enterText(ProductConfigUIMap.searchBox_txtbox,toolname.toUpperCase());
			Thread.sleep(3000);
			if(CheckIfElementExists(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ToolSugestions_statictxt, toolname.toUpperCase(), "toolname")))
			{
			
				click(ProductConfigUIMap.plusIcon_btn);
				Thread.sleep(1000);
				click(ProductConfigUIMap.plusIcon_btn);
				Thread.sleep(2000);
				if(CheckIfElementExists(prepareWebElementWithDynamicXpath(ProductConfigUIMap.toolnameInstance_statixtxt, toolname.toUpperCase(), "toolname")))
				{doubleClick(prepareWebElementWithDynamicXpath(ProductConfigUIMap.toolnameInstance_statixtxt, toolname.toUpperCase(), "toolname"));
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					Thread.sleep(2000);
					
					ExpWaitForCondition(ProductConfigUIMap.EditProductInstance_statictxt);
					if(!CheckIfElementExists(ProductConfigUIMap.EditProductInstance_statictxt))
					{
						logger.info("Product instance page for tool "+toolname+" not loaded");
						Assert.fail("Product instance page for tool "+toolname+" not loaded");
					}
				}
			}
		}
		else if(toolname.equalsIgnoreCase("MYWIZARD-TFS"))
		{
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			enterText(ProductConfigUIMap.searchBox_txtbox,toolname.toUpperCase());
			Thread.sleep(2000);
			click(ProductConfigUIMap.plusIcon_btn);
			Thread.sleep(1000);
			click(ProductConfigUIMap.plusIcon_btn);
			Thread.sleep(1000);
			if(CheckIfElementExists(ProductConfigUIMap.myWizard_TFS_statictxt))
			{
				doubleClick(ProductConfigUIMap.myWizard_TFS_statictxt);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				Thread.sleep(2000);
				
				ExpWaitForCondition(ProductConfigUIMap.EditProductInstance_statictxt);
				if(!CheckIfElementExists(ProductConfigUIMap.EditProductInstance_statictxt))
				{
					logger.info("Product instance page for tool "+toolname+" not loaded");
					Assert.fail("Product instance page for tool "+toolname+" not loaded");
				}
			}
			
		}
		
		else if(toolname.equalsIgnoreCase("mywizardMSPS"))
		{
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			enterText(ProductConfigUIMap.searchBox_txtbox,toolname.toUpperCase());
			Thread.sleep(2000);
			click(ProductConfigUIMap.plusIcon_btn);
			Thread.sleep(1000);
			click(ProductConfigUIMap.plusIcon_btn);
			Thread.sleep(1000);
			if(CheckIfElementExists(ProductConfigUIMap.mywizard_MSPS_statictxt))
			{
				doubleClick(ProductConfigUIMap.mywizard_MSPS_statictxt);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				Thread.sleep(2000);
				
				ExpWaitForCondition(ProductConfigUIMap.EditProductInstance_statictxt);
				if(!CheckIfElementExists(ProductConfigUIMap.EditProductInstance_statictxt))
				{
					logger.info("Product instance page for tool "+toolname+" not loaded");
					Assert.fail("Product instance page for tool "+toolname+" not loaded");
				}
			}
			
		}
		
		else if(toolname.equalsIgnoreCase("mywizardinstance"))
		{
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			enterText(ProductConfigUIMap.searchBox_txtbox,toolname.toUpperCase());
			Thread.sleep(2000);
			click(ProductConfigUIMap.plusIcon_btn);
			Thread.sleep(1000);
			click(ProductConfigUIMap.plusIcon_btn);
			Thread.sleep(1000);
			if(CheckIfElementExists(ProductConfigUIMap.mywizardInstance_statictxt))
			{
				doubleClick(ProductConfigUIMap.mywizardInstance_statictxt);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				Thread.sleep(2000);
				
				ExpWaitForCondition(ProductConfigUIMap.EditProductInstance_statictxt);
				if(!CheckIfElementExists(ProductConfigUIMap.EditProductInstance_statictxt))
				{
					logger.info("Product instance page for tool "+toolname+" not loaded");
					Assert.fail("Product instance page for tool "+toolname+" not loaded");
				}
			}
			
		}
			else{
				logger.info("Entered Tool doesnt exists on Product Configuration page");
				Assert.fail("Entered Tool doesnt exists on Product Configuration page");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue loading Prod config page");
			Assert.fail("Issue loading Prod config page");
		}
	}
	
	public static void Navigatetosection(String sectionaname)
	{
		try{
			clickJS(ProductConfigUIMap.IsRealtimeConfigChangesEnabled_btn);
			ExpWaitForCondition(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductConfigPage_Section, sectionaname, "sectionname"));
			ScrollIntoView(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductConfigPage_Section, sectionaname, "sectionname"));
			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductConfigPage_Section, sectionaname, "sectionname"));
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("could not load section "+sectionaname+" in page product config"); 
			Assert.fail("could not load section "+sectionaname+" in page product config"); 
		}
	}
	public static void AddProductInstanceExtensionDetails(String toolname){
		try{
			Thread.sleep(3000);
			int totalNumberofEnteriesInProductInstanceExtension = getDataRowCount(ProductConfigUIMap.ProductInstanceExtension_Table);
			for(int i=1;i<totalNumberofEnteriesInProductInstanceExtension;i++)
			{
//				highlight(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductInstanceExtensionRowToDelete_Img,String.valueOf(i) , "rownumb"));
				singleClick(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductInstanceExtensionRowToDelete_Img,String.valueOf(i) , "rownumb"));
				Thread.sleep(1000);
			}
			
			//if tool be added is JIRA
			if(toolname.equalsIgnoreCase("ADT JIRA") || toolname.equalsIgnoreCase("ADOP JIRA"))
				{
				String ProjExtenstionEntryToBeAdded = Property.getProperty("ProductInstanceTool")+"_"+Property.getProperty("MyWizard_Client").trim()+"_Project";
				String ProjExtenstionEntryBoardID = Property.getProperty("ProductInstanceTool")+"_"+Property.getProperty("MyWizard_Client").trim()+"_BoardId";
				clickJS(ProductConfigUIMap.AddExtension_link);
				enterText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductInstanceExtensionRowCol1AddData_txtbox,String.valueOf(totalNumberofEnteriesInProductInstanceExtension), "rownumb"),ProjExtenstionEntryToBeAdded);
				enterText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductInstanceExtensionRowCol2AddData_txtbox,String.valueOf(totalNumberofEnteriesInProductInstanceExtension), "rownumb"),Property.getProperty("ProductInstanceProject"));
				clickJS(ProductConfigUIMap.AddExtension_link)	;
				enterText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductInstanceExtensionRowCol1AddData_txtbox,String.valueOf(totalNumberofEnteriesInProductInstanceExtension+1), "rownumb"),ProjExtenstionEntryBoardID);
				enterText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductInstanceExtensionRowCol2AddData_txtbox,String.valueOf(totalNumberofEnteriesInProductInstanceExtension+1), "rownumb"),(Property.getProperty("ProductInstanceProject")+":"+Property.getProperty("Board_ID")));
				}
			//if tool be added is TFS
			if(toolname.equalsIgnoreCase("MyWizard-TFS"))
			{
				String ProjExtenstionEntryToBeAdded = Property.getProperty("ProductInstanceTool")+"_"+Property.getProperty("MyWizard_Client")+"_Project";
				clickJS(ProductConfigUIMap.AddExtension_link);
				enterText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductInstanceExtensionRowCol1AddData_txtbox,String.valueOf(totalNumberofEnteriesInProductInstanceExtension), "rownumb"),ProjExtenstionEntryToBeAdded);
				enterText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductInstanceExtensionRowCol2AddData_txtbox,String.valueOf(totalNumberofEnteriesInProductInstanceExtension), "rownumb"),Property.getProperty("ProductInstanceProject"));
			}
			{
				
			}
			
			
		}
		catch(Exception e)
		{
				e.printStackTrace();
				logger.info("Issues adding product instance extension details for the given tool "+toolname);
				Assert.fail("Issues adding product instance extension details for the given tool "+toolname);
		}
	}
	public static void AddDeliveryConstructAssociationDetails(String toolname){
		try{
			Thread.sleep(3000);
			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductConfigPage_Section, "Delivery Construct Association", "sectionname"));
			Thread.sleep(2000);
			//select the client
			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DCClientToSelect_StaticTxt, Property.getProperty("MyWizard_Client"), "clientname"));
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
			//select + icon to expand the client
			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.PlusIconToExpandClientSelected_StaticTxt,Property.getProperty("MyWizard_Client"), "clientname"));
			
		if(toolname.equalsIgnoreCase("ADT JIRA") || toolname.equalsIgnoreCase("ADOP JIRA"))	
		{
			//check if L1 DC is selected/ticked
			WebElement checkbox_L1 = driver().findElement(prepareWebElementWithDynamicXpath(ProductConfigUIMap.checkL1DCcheckbox_checkbox, Property.getProperty("MyWizard_DC_L1"), "DCname"));
			if(checkbox_L1.isSelected())
			{
				String selectedProj= getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"));
				String selectedBoardId= getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedBoardValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1"),  "DCname"));

				if(!(selectedProj.equalsIgnoreCase(Property.getProperty("ProductInstanceProject")) && selectedBoardId.equalsIgnoreCase(Property.getProperty("Board_ID") )))
				{
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"),Property.getProperty("ProductInstanceProject"));
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedBoardValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"),Property.getProperty("Board_ID"));
				}
			}
			else
			{
				click(prepareWebElementWithDynamicXpath(ProductConfigUIMap.checkL1DCcheckbox_checkbox, Property.getProperty("MyWizard_DC_L1"), "DCname"));
				//check if the project and board dropdowns have more than 0 options to select from
//					if((getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"))>0) && (getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedBoardValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"))>0))
				if((getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"))>0))
					{	
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"),Property.getProperty("ProductInstanceProject"));
					Thread.sleep(2000);
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedBoardValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"),Property.getProperty("Board_ID"));
					}
					else
					{
						logger.info("no data in dropdown to select from for L1 DC");
						Assert.fail("no data in dropdown to select from for L1 DC");
					}
	
			}
			//expand DC L2 
			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.PlusIconToExpandDCL1_StaticTxt, Property.getProperty("MyWizard_DC_L1"), "DCname"));
			
			
			//check to see if DC L2 needs to be added or not
			if(!Property.getProperty("MyWizard_DC_L2").equalsIgnoreCase("NA") || Property.getProperty("MyWizard_DC_L2").equalsIgnoreCase(""))
			{
			//check if DC L2 is selected					
			WebElement checkbox_L2 = driver().findElement(prepareWebElementWithDynamicXpath(ProductConfigUIMap.checkL2DCcheckbox_checkbox, Property.getProperty("MyWizard_DC_L2"), "programname"));
				if(checkbox_L2.isSelected())
				{
					String selectedProj= getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L2_DC_drpdown,  Property.getProperty("MyWizard_DC_L2"), "programname"));
					String selectedBoardId= getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedBoardValueFromDropDown_L2_DC_drpdown, Property.getProperty("MyWizard_DC_L2"), "programname"));
					if(!(selectedProj.equalsIgnoreCase(Property.getProperty("ProductInstanceProject")) && selectedBoardId.equalsIgnoreCase(Property.getProperty("Board_ID") )))
					{
						selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L2_DC_drpdown, Property.getProperty("MyWizard_DC_L2") , "programname"),Property.getProperty("ProductInstanceProject"));
						selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedBoardValueFromDropDown_L2_DC_drpdown, Property.getProperty("MyWizard_DC_L2") , "programname"),Property.getProperty("Board_ID"));
					}
				}
				else
				{
					click(prepareWebElementWithDynamicXpath(ProductConfigUIMap.checkL2DCcheckbox_checkbox, Property.getProperty("MyWizard_DC_L2"), "programname"));
					//check if the project and board dropdowns have more than 0 options to select from for L2 DC
					if((getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L2_DC_drpdown, Property.getProperty("MyWizard_DC_L2") , "programname"))>0) )
					{	
						selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L2_DC_drpdown, Property.getProperty("MyWizard_DC_L2") , "programname"),Property.getProperty("ProductInstanceProject"));
//						selectDropdownByIndex(((prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L2_DC_drpdown, Property.getProperty("MyWizard_DC_L2") , "programname"))), 1);
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedBoardValueFromDropDown_L2_DC_drpdown, Property.getProperty("MyWizard_DC_L2") , "programname"),Property.getProperty("Board_ID"));
					}
					else
					{
						logger.info("no data in dropdown to select from for L2 DC");
						Assert.fail("no data in dropdown to select from for L2 DC");
					}
				}
			}	
		}
		
		if(toolname.equalsIgnoreCase("Mywizard-TFS"))	
		{
			//check if L1 DC is selected/ticked
			WebElement checkbox_L1 = driver().findElement(prepareWebElementWithDynamicXpath(ProductConfigUIMap.checkL1DCcheckbox_checkbox, Property.getProperty("MyWizard_DC_L1"), "DCname"));
			if(checkbox_L1.isSelected())
			{
				String selectedProj= getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"));
				

				if(!(selectedProj.equalsIgnoreCase(Property.getProperty("ProductInstanceProject"))))
				{
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"),Property.getProperty("ProductInstanceProject"));
					
				}
			}
			else
			{
				click(prepareWebElementWithDynamicXpath(ProductConfigUIMap.checkL1DCcheckbox_checkbox, Property.getProperty("MyWizard_DC_L1"), "DCname"));
				//check if the project and board dropdowns have more than 0 options to select from
//					if((getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"))>0) && (getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedBoardValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"))>0))
				if((getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"))>0))
					{	
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"),Property.getProperty("ProductInstanceProject"));
					
					}
					else{
						logger.info("no data in dropdown to select from for L1 DC");
						Assert.fail("no data in dropdown to select from for L1 DC");
					}
	
			}
			//expand DC L2 
			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.PlusIconToExpandDCL1_StaticTxt, Property.getProperty("MyWizard_DC_L1"), "DCname"));
			
			
			//check to see if DC L2 needs to be added or not
			if(!Property.getProperty("MyWizard_DC_L2").equalsIgnoreCase("NA") || Property.getProperty("MyWizard_DC_L2").equalsIgnoreCase(""))
			{
			//check if DC L2 is selected					
			WebElement checkbox_L2 = driver().findElement(prepareWebElementWithDynamicXpath(ProductConfigUIMap.checkL2DCcheckbox_checkbox, Property.getProperty("MyWizard_DC_L2"), "programname"));
				if(checkbox_L2.isSelected())
				{
					String selectedProj= getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L2_DC_drpdown,  Property.getProperty("MyWizard_DC_L2"), "programname"));
					
					if(!(selectedProj.equalsIgnoreCase(Property.getProperty("ProductInstanceProject"))))
					{
						selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L2_DC_drpdown, Property.getProperty("MyWizard_DC_L2") , "programname"),Property.getProperty("ProductInstanceProject"));
						
					}
				}
				else
				{
					click(prepareWebElementWithDynamicXpath(ProductConfigUIMap.checkL2DCcheckbox_checkbox, Property.getProperty("MyWizard_DC_L2"), "programname"));
					//check if the project and board dropdowns have more than 0 options to select from for L2 DC
					if((getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L2_DC_drpdown, Property.getProperty("MyWizard_DC_L2") , "programname"))>0) )
					{	
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L2_DC_drpdown, Property.getProperty("MyWizard_DC_L2") , "programname"),Property.getProperty("ProductInstanceProject"));
					
					}
					else{
						logger.info("no data in dropdown to select from for L2 DC");
						Assert.fail("no data in dropdown to select from for L2 DC");
					}
				}
			}	
		}
		}
		catch(Exception e)
		{
				e.printStackTrace();
				logger.info("Issue selecting the Delivery cosntruct association");
				Assert.fail("Issue selecting the Delivery cosntruct association");
		}
	}
	public static void AddProductInstanceEntitiesDetails(String toolname){
		try{
			
			if(toolname.equalsIgnoreCase("ADT JIRA"))
			{
				ProductConfiguration.checkAndAddWorkItemsForJira();
				ProductConfiguration.checkAndAddDeliverable();
				ProductConfiguration.checkAndAddIteration();
				ProductConfiguration.checkAndAddRequirement();
				ProductConfiguration.checkAndAddTeamArea();
				ProductConfiguration.checkAndAddMilesStone();
				ProductConfiguration.checkAndAddTestResult();
				ProductConfiguration.checkAndAddAction();
				ProductConfiguration.checkAndAddTest();
			}
			if(toolname.equalsIgnoreCase("ADOP JIRA"))
			{
				ProductConfiguration.checkAndAddWorkItemsForJira();
				ProductConfiguration.checkAndAddIteration();
				
			}
			if(toolname.equalsIgnoreCase("MyWizard-TFS"))
			{
				ProductConfiguration.checkAndAddWorkItemsForTFS();
				ProductConfiguration.checkAndAddIteration();
				ProductConfiguration.checkAndAddTest();
				ProductConfiguration.checkAndAddDeliverable();
				ProductConfiguration.checkAndAddMilesStone();
				ProductConfiguration.checkAndAddTeamArea();
				ProductConfiguration.checkAndAddAction();
				ProductConfiguration.checkAndAddDecision();
			}
			
			
		}
		catch(Exception e)
		{
				e.printStackTrace();
				logger.info("Issue adding product instance entity details");
				Assert.fail("Issue adding product instance entity details");
				
		}
	}
	
	private static void checkAndAddTeamArea() {
	try{
			
			boolean TeamArea = false;
			int totalNoRow = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
			//check if Requirement exists
			if(totalNoRow>1)
			{
								
					for(int i=1;i<totalNoRow;i++)
					{
						 if(getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(i), "int")).equalsIgnoreCase("TeamArea"))
						 {
							 TeamArea = true;
						 	break;
						 }
					}
			}
			
			
			
			//if Iteration entity is missing in UI
			if(!TeamArea)
			{
				int currentrowCount = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
				clickJS(ProductConfigUIMap.AddEntity_link);
				selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(currentrowCount), "int"),"TeamArea");
				selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(currentrowCount), "int"),"Inbound and Outbound");
			}
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue adding TeamArea entity in product instance entities section");
			Assert.fail("Issue adding TeamArea entity in product instance entities section");
		}
		
		
	}
	
	private static void checkAndAddTestResult() {
		try{
				
				boolean TestResult = false;
				int totalNoRow = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
				//check if Requirement exists
				if(totalNoRow>1)
				{
									
						for(int i=1;i<totalNoRow;i++)
						{
							 if(getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(i), "int")).equalsIgnoreCase("TestResult"))
							 {
								 TestResult = true;
							 	break;
							 }
						}
				}
				
				
				
				//if Iteration entity is missing in UI
				if(!TestResult)
				{
					int currentrowCount = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
					clickJS(ProductConfigUIMap.AddEntity_link);
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(currentrowCount), "int"),"TestResult");
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(currentrowCount), "int"),"Inbound");
				}
			
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Issue adding TeamResult entity in product instance entities section");
				Assert.fail("Issue adding TeamResult entity in product instance entities section");
			}
			
			
		}
	
	
	private static void checkAndAddAction() {
		try{
				
				boolean Action = false;
				int totalNoRow = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
				//check if Action exists
				if(totalNoRow>1)
				{
									
						for(int i=1;i<totalNoRow;i++)
						{
							 if(getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(i), "int")).equalsIgnoreCase("Action"))
							 {
								 Action = true;
							 	break;
							 }
						}
				}
				
				
				
				//if MilesStone entity is missing in UI
				if(!Action)
				{
					int currentrowCount = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
					clickJS(ProductConfigUIMap.AddEntity_link);
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(currentrowCount), "int"),"Action");
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(currentrowCount), "int"),"Inbound and Outbound");
				}
			
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Issue adding Action entity in product instance entities section");
				Assert.fail("Issue adding Action entity in product instance entities section");
			}
			
			
		}
	
	private static void checkAndAddMilesStone() {
		try{
				
				boolean MilesStone = false;
				int totalNoRow = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
				//check if MilesStone exists
				if(totalNoRow>1)
				{
									
						for(int i=1;i<totalNoRow;i++)
						{
							 if(getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(i), "int")).equalsIgnoreCase("Milestone"))
							 {
								 MilesStone = true;
							 	break;
							 }
						}
				}
				
				
				
				//if MilesStone entity is missing in UI
				if(!MilesStone)
				{
					int currentrowCount = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
					clickJS(ProductConfigUIMap.AddEntity_link);
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(currentrowCount), "int"),"Milestone");
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(currentrowCount), "int"),"Inbound and Outbound");
				}
			
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Issue adding MilesStone entity in product instance entities section");
				Assert.fail("Issue adding MilesStone entity in product instance entities section");
			}
			
			
		}
	
	private static void checkAndAddDecision() {
		try{
				
				boolean Decision = false;
				int totalNoRow = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
				//check if Decision exists
				if(totalNoRow>1)
				{
									
						for(int i=1;i<totalNoRow;i++)
						{
							 if(getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(i), "int")).equalsIgnoreCase("Decision"))
							 {
								 Decision = true;
							 	break;
							 }
						}
				}
				
				
				
				//if Decision entity is missing in UI
				if(!Decision)
				{
					int currentrowCount = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
					clickJS(ProductConfigUIMap.AddEntity_link);
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(currentrowCount), "int"),"Decision");
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(currentrowCount), "int"),"Inbound and Outbound");
				}
			
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Issue adding Decision entity in product instance entities section");
				Assert.fail("Issue adding Decision entity in product instance entities section");
			}
			
			
		}

	private static void checkAndAddRequirement() {
		
		try{
			
			boolean Requirement = false;
			int totalNoRow = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
			//check if Requirement exists
			if(totalNoRow>1)
			{
								
					for(int i=1;i<totalNoRow;i++)
					{
						 if(getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(i), "int")).equalsIgnoreCase("Requirement"))
						 {
							 Requirement = true;
						 	break;
						 }
					}
			}
			
			
			
			//if Iteration entity is missing in UI
			if(!Requirement)
			{
				int currentrowCount = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
				clickJS(ProductConfigUIMap.AddEntity_link);
				selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(currentrowCount), "int"),"Requirement");
				selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(currentrowCount), "int"),"Inbound and Outbound");
			}
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue adding Requirement entity in product instance entities section");
			Assert.fail("Issue adding Requirement entity in product instance entities section");
		}
		
	}

	public static void checkAndAddWorkItemsForJira()
	{
		try{
		int totalNoRow = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
		ArrayList<String> ADTJiraEntities = new ArrayList<>(Arrays.asList("Epic", "Feature", "UserStory", "Task", "Bug" , "Impediment", "Issue", "Risk"));
		ArrayList<String> ActualWorkItemEntitiesOnUi = new ArrayList<>();
		
		
		//check if all workitems exists
		for(int i=1;i<totalNoRow;i++)
		{
			
//			if(getDropdownValue(By.xpath("//span[text()='Add Entity']//following::table[1]//tbody//tr["+i+"]//td[1]//select[1]")).equalsIgnoreCase("WorkItem"))
			if(getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(i), "int")).equalsIgnoreCase("WorkItem"))
			{
//				ActualWorkItemEntitiesOnUi.add(getDropdownValue(By.xpath("//span[text()='Add Entity']//following::table[1]//tbody//tr["+i+"]//td[2]//select[1]")));
				ActualWorkItemEntitiesOnUi.add(getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column2_WorkItemType_drpdown,String.valueOf(i), "int")));
				
//					//system.out.println(getDropdownValue(By.xpath("//span[text()='Add Entity']//following::table[1]//tbody//tr["+i+"]//td[2]//select[1]")));
				if(!getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(i), "int")).equalsIgnoreCase("Inbound and Outbound"))
				{
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(i), "int"),"Inbound and Outbound");
				}
			}
		}
		
	//after below step, ADTJiraEntities will contain elements that are missing in UI. 
		ADTJiraEntities.removeAll(ActualWorkItemEntitiesOnUi);
		//if size is 0, all elements are already present in UI. if not, add the elements
		int y = totalNoRow-1;
		if(ADTJiraEntities.size()!=0)
		{
			
				for(int j=0; j<ADTJiraEntities.size(); j++)
				{
					clickJS(ProductConfigUIMap.AddEntity_link);
					int x = y+1+j;
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(x), "int"),"WorkItem");
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column2_WorkItemType_drpdown,String.valueOf(x), "int"),ADTJiraEntities.get(j));
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(x), "int"),"Inbound and Outbound");
					
				}
			
		}
	}
		
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue adding Workitem entity in product instance entities section");
			Assert.fail("Issue adding Workitem entity in product instance entities section");
		}
		
	}
	
	public static void checkAndAddIteration(){
		
	try{
		
		boolean Iteration = false;
		int totalNoRow = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
		//check if deliverable and Iteration exists
		if(totalNoRow>1)
		{
							
				for(int i=1;i<totalNoRow;i++)
				{
					 if(getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(i), "int")).equalsIgnoreCase("Iteration"))
					 {
						 Iteration = true;
					 	break;
					 }
				}
		}
		
		
		
		//if Iteration entity is missing in UI
		if(!Iteration)
		{
			int currentrowCount = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
			clickJS(ProductConfigUIMap.AddEntity_link);
			selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(currentrowCount), "int"),"Iteration");
			selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(currentrowCount), "int"),"Inbound and Outbound");
		}
	
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("Issue adding Interation entity in product instance entities section");
		Assert.fail("Issue adding Interation entity in product instance entities section");
	}
	
	}
	
	public static void checkAndAddDeliverable(){
		
		try{
			boolean Deliverable = false;
			
			int totalNoRow = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
			//check if deliverable exists
			if(totalNoRow>1)
			{
					for(int i=1;i<totalNoRow;i++)
					{
					 if(getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(i), "int")).equalsIgnoreCase("Deliverable"))
						 {
						 Deliverable = true;
						 break;
						 }
					}
				
					
			}
			
			//if Deliverable entity is missing in UI
			if(!Deliverable)
			{
				int currentrowCount = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
				clickJS(ProductConfigUIMap.AddEntity_link);
				selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(currentrowCount), "int"),"Deliverable");
				selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(currentrowCount), "int"),"Inbound and Outbound");
			}
			
		
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue adding Deliverable entity in product instance entities section");
			Assert.fail("Issue adding Deliverable entity in product instance entities section");
		}
		
		}
	
public static void checkAndAddTest(){
		
		try{
			boolean Test = false;
			
			int totalNoRow = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
			//check if deliverable exists
			if(totalNoRow>1)
			{
					for(int i=1;i<totalNoRow;i++)
					{
					 if(getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(i), "int")).equalsIgnoreCase("Test"))
						 {
						 Test = true;
						 break;
						 }
					}
				
					
			}
			
			//if Test entity is missing in UI
			if(!Test)
			{
				int currentrowCount = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
				clickJS(ProductConfigUIMap.AddEntity_link);
				selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(currentrowCount), "int"),"Test");
				selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(currentrowCount), "int"),"Inbound and Outbound");
			}
			
		
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue adding Test entity in product instance entities section");
			Assert.fail("Issue adding Test entity in product instance entities section");
		}
		
		}
	public static void checkAndAddWorkItemsForTFS()
	{
		try{
		int totalNoRow = getDataRowCount(ProductConfigUIMap.ProdInstanceEntityTable_table);
		ArrayList<String> TFSEntities = new ArrayList<>(Arrays.asList("Epic", "Feature", "UserStory", "Task", "Bug" , "Impediment", "Issue"));
		ArrayList<String> ActualWorkItemEntitiesOnUi = new ArrayList<>();
		
		
		//check if all workitems exists
		for(int i=1;i<totalNoRow;i++)
		{
			
//			if(getDropdownValue(By.xpath("//span[text()='Add Entity']//following::table[1]//tbody//tr["+i+"]//td[1]//select[1]")).equalsIgnoreCase("WorkItem"))
			if(getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(i), "int")).equalsIgnoreCase("WorkItem"))
			{
//				ActualWorkItemEntitiesOnUi.add(getDropdownValue(By.xpath("//span[text()='Add Entity']//following::table[1]//tbody//tr["+i+"]//td[2]//select[1]")));
				ActualWorkItemEntitiesOnUi.add(getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column2_WorkItemType_drpdown,String.valueOf(i), "int")));
				
//					//system.out.println(getDropdownValue(By.xpath("//span[text()='Add Entity']//following::table[1]//tbody//tr["+i+"]//td[2]//select[1]")));
				if(!getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(i), "int")).equalsIgnoreCase("Inbound and Outbound"))
				{
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(i), "int"),"Inbound and Outbound");
				}
			}
		}
		
	//after below step, ADTJiraEntities will contain elements that are missing in UI. 
		TFSEntities.removeAll(ActualWorkItemEntitiesOnUi);
		//if size is 0, all elements are already present in UI. if not, add the elements
		int y = totalNoRow-1;
		if(TFSEntities.size()!=0)
		{
			
				for(int j=0; j<TFSEntities.size(); j++)
				{
					clickJS(ProductConfigUIMap.AddEntity_link);
					int x = y+1+j;
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_WorkItem_Deliverable_drpdown,String.valueOf(x), "int"),"WorkItem");
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column2_WorkItemType_drpdown,String.valueOf(x), "int"),TFSEntities.get(j));
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_InboundOutbound_drpdown,String.valueOf(x), "int"),"Inbound and Outbound");
					
				}
			
		}
	}
		
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue adding Workitem entity in product instance entities section");
			Assert.fail("Issue adding Workitem entity in product instance entities section");
		}
		
	}
	
	public static void hitSaveButton(){
		
		try{
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			ScrollIntoView(ProductConfigUIMap.Save_btn);
			singleClick(ProductConfigUIMap.Save_btn);
//			Thread.sleep(5000);
			ExpWaitForCondition(ProductConfigUIMap.SuccessfulSaveProdInstance);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
		}
		catch(Exception e)
		{
				e.printStackTrace();
				grabScreenshot();
				logger.info("Problem saving Product Instance");
				Assert.fail("Problem saving Product Instance");
		}
		
	}
	
	public static boolean verifyProjectNameProjectKey(String toolname){
		try{
			boolean deploy=false;
		//match the project name
				if(!CheckIfElementExists(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProjectName_AttributeName_statictxt, Property.getProperty("JiraProjectKey"), "projectname")))
					//update project name
				{
					deploy=true;
					clickJS(ProductConfigUIMap.ProjectNameAttribute_link);
					clear(ProductConfigUIMap.ParameterValue_txtbox);
					enterText(ProductConfigUIMap.ParameterValue_txtbox,Property.getProperty("JiraProjectKey") );
					clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
				}
				if(!CheckIfElementExists(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProjectKey_AttributeName_statictxt, Property.getProperty("JiraProjectKey"), "projectname")))
					//update project key
				{
					deploy=true;
					clickJS(ProductConfigUIMap.ProjectKeyAttribute_link);
					clear(ProductConfigUIMap.ParameterValue_txtbox);
					enterText(ProductConfigUIMap.ParameterValue_txtbox,Property.getProperty("JiraProjectKey") );
					clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
				}
				
				return deploy;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	return true;
	}
	
	
	public static void verifyIfPipelinesExists1(String[] pipelines,String toolname,String IBorOB){
		int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
		boolean pipelinenotfound = false;
		boolean pipelinefound = true;
		List<String> list_pipeline = Arrays.asList(pipelines);

			for(int i=1;i<totalNoRow;i++){
				String currentpipeline = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_pipelineName_statictxt, String.valueOf(i), "int"));
				boolean stringExists = substringExistsInArray(currentpipeline, pipelines);
			if(!stringExists)
				pipelinenotfound=true;
				}

		
		if(pipelinenotfound)
		{
			logger.info("Pipeline/Pipelines missing or not in Success state for the tool "+toolname);
			Assert.fail("Pipeline/Pipelines missing or not in Success state for the tool "+toolname);
		}
		
	}
	
		
	public static boolean substringExistsInArray(String inputStr, String[] items) {
        return Arrays.stream(items).parallel().anyMatch(inputStr::contains);
     }

     public static Optional getFirstMatchingSubstring(String inputStr, String[] items) {
       return Arrays.stream(items).parallel().filter(inputStr::contains).findAny();
     }
	
	public static void verifyIfPipelinesExists(String[] pipelines,String toolname,String IBorOB){
		
		try{
				int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
				boolean datamismatch = false;
				boolean finaldeploy = false;
				for(int i=1;i<totalNoRow;i++){
					//if pipeline exists
					if(getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_pipelineName_statictxt, String.valueOf(i), "int")).contains(pipelines[i-1]))
					{
						//get the status of the pipeline. success or not
						if(getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column3_pipelineName_statictxt,  String.valueOf(i), "int")).contains("Success"))
						{
							//as per suseela, we need not touch the pipeline if the status of the pipeline is success
		//							if(IBorOB.equalsIgnoreCase("IB"))
		//							{
		//								clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_ManageIntegrationParamters_statictxt,  String.valueOf(i), "int"));
		//								datamismatch = verifyProjectNameProjectKey(toolname);
		//								if(datamismatch)
		//									finaldeploy=true;
		//								clickJS(ProductConfigUIMap.CloseAttributesWidow_btn);
		//							}
		//							if(IBorOB.equalsIgnoreCase("OB"))
		//							{
		//								//do nothing. as project name and project key attributes are missing
		//							}
						}
						else
							finaldeploy=true;
						
					}
					else{
						logger.info("Pipeline "+pipelines[i]+" missing for tool "+toolname);
						Assert.fail("Pipeline "+pipelines[i]+" missing for tool "+toolname);
					}
				}
				
			if(finaldeploy)
//				Baseclass.getInstance().DeployPipeline=true;
			{
				logger.info("Pipeline/Pipelines missing or not in Success state for the tool "+toolname);
				Assert.fail("Pipeline/Pipelines missing or not in Success state for the tool "+toolname);
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue verfying pipelines for tool "+toolname);
			Assert.fail("Issue verfying pipelines for tool "+toolname);
		}
	}
	public static void verifyPipelines1(String IBorOB,String toolname){
		try{
			int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
				if(toolname.contains("JIRA"))
				{
					if(IBorOB.equalsIgnoreCase("IB"))
					{
						if(totalNoRow>=1)
						{
							
							if(toolname.equalsIgnoreCase("ADT JIRA"))
							{
							String[] pipelines = {"JIRA-ITR-US-Inbound","JIRA-TEAMS-US-Inbound","JIRA-US-Inbound"};
							verifyIfPipelinesExists1(pipelines,toolname,IBorOB);
							}
							if(toolname.equalsIgnoreCase("ADOP JIRA"))
							{
							String[] pipelines = {"JIRA-US-Inbound","JIRA-ITR-US-Inbound", "JIRA-Team-US-Inbound"};
							verifyIfPipelinesExists1(pipelines,toolname,IBorOB);
							}
							if(toolname.equalsIgnoreCase("TFS Agile"))
							{
							String[] pipelines = {"TFS-Agile-US-Inbound","TFS-Agile-ITR-US-Inbound", "TFS-Agile-Team-US-Inbound"};
							verifyIfPipelinesExists1(pipelines,toolname,IBorOB);
							}
							if(toolname.equalsIgnoreCase("TFS Scrum"))
							{
							String[] pipelines = {"TFS-Scrum-US-Inbound","TFS-Scrum-ITR-US-Inbound", "TFS-Scrum-Team-US-Inbound"};
							verifyIfPipelinesExists1(pipelines,toolname,IBorOB);
							}
						}
						else{
							logger.info("pipelines not present for the tool "+toolname);
							Assert.fail("pipelines not present for the tool "+toolname);
						}
						
					}
					if(IBorOB.equalsIgnoreCase("OB"))
					{
						if(totalNoRow>=1)
						{
							if(toolname.contains("JIRA"))
							{
							String[] pipelines = {"JIRA-US-Outbound"};
							verifyIfPipelinesExists1(pipelines,toolname,IBorOB);
							}
							if(toolname.contains("TFS Agile"))
							{
							String[] pipelines = {"TFS-Agile-US-Outbound"};
							verifyIfPipelinesExists1(pipelines,toolname,IBorOB);
							}
							if(toolname.contains("TFS Scrum"))
							{
							String[] pipelines = {"TFS-Scrum-US-Outbound"};
							verifyIfPipelinesExists1(pipelines,toolname,IBorOB);
							}
						}
						else
							Assert.fail("pipelines not present for the tool "+toolname);
						
					}
				}
				if(toolname.contains("TFS"))
				{
					if(totalNoRow>=1)
					{
						;
						if(IBorOB.equalsIgnoreCase("IB"))
						{
							
							if(toolname.equalsIgnoreCase("TFS Scrum"))
							{
							
								String[] pipelines = {"TFS-Scrum-US-Inbound","TFS-Scrum-ITR-US-Inbound","TFS-Scrum-Team-US-Inbound"};
								verifyIfPipelinesExists(pipelines,toolname,IBorOB);
							}
							if(toolname.equalsIgnoreCase("TFS Agile"))
							{
							
								String[] pipelines = {"TFS-Agile-US-Inbound","TFS-Agile-ITR-US-Inbound","TFS-Agile-Team-US-Inbound"};
								verifyIfPipelinesExists(pipelines,toolname,IBorOB);
							}
						
						}
						if(IBorOB.equalsIgnoreCase("OB"))
						{
							if(toolname.equalsIgnoreCase("TFS Scrum"))
							{
								String[] pipelines = {"TFS-Scrum-US-Outbound"};
								verifyIfPipelinesExists(pipelines,toolname,IBorOB);
					
							}
							if(toolname.equalsIgnoreCase("TFS Agile"))
							{
								String[] pipelines = {"TFS-Agile-US-Outbound"};
								verifyIfPipelinesExists(pipelines,toolname,IBorOB);
						
							}
							
							
						}
					}
					else{
						logger.info("pipelines not present for the tool "+toolname);
						Assert.fail("pipelines not present for the tool "+toolname);
					}
					
				}
				if(toolname.contains("MSPS"))
				{
					if(IBorOB.equalsIgnoreCase("IB"))
					{
						
					}
					if(IBorOB.equalsIgnoreCase("OB"))
					{
						
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue verfiying the pipelines for the tool "+toolname);
			Assert.fail("Issue verfiying the pipelines for the tool "+toolname);
		}
		
	
	
	}
public static void verifyPipelines(String IBorOB,String toolname){
		
		try{
			int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
			
		if((toolname.contains("MSPS") || toolname.contains("TFS") || (toolname.contains("JIRA"))))	
		{
			if(!(toolname.contains("MSPS") || toolname.contains("msps")))
			{
				if(IBorOB.equalsIgnoreCase("IB"))
				{
					if(totalNoRow>1)
					{
						ProductConfiguration.checkWorkItemsPipeline(IBorOB,toolname);
						ProductConfiguration.checkIterationsPipeline(toolname);
						ProductConfiguration.checkTeamsPipeline(toolname);
					}
					else
					{
						ProductConfiguration.addWorkItemPipeline(IBorOB,toolname);
						ProductConfiguration.addIterationsPipeline(toolname);
						ProductConfiguration.addTeamPipeline(toolname);
					}
			}
			if(IBorOB.equalsIgnoreCase("OB"))
			{
				if(totalNoRow>1)
				{
					ProductConfiguration.checkWorkItemsPipeline(IBorOB,toolname);
					
//				
				}
				else
					ProductConfiguration.addWorkItemPipeline(IBorOB,toolname);
			}
			
			
			}
			
			if((toolname.contains("MSPS") || toolname.contains("msps")))
			{
//				if(IBorOB.equalsIgnoreCase("IB"))
//				{
					if(totalNoRow>1)
					{
						ProductConfiguration.checkWorkItemsPipeline(IBorOB,toolname);
					}
					else
					{
						ProductConfiguration.addWorkItemPipeline(IBorOB,toolname);
				    }
//				}
			
			}
			
		}
	
		else{
			logger.info("Entered tool doesnt exist in Product Config page");
			Assert.fail("Entered tool doesnt exist in Product Config page");
		}
		}
		catch(Exception e)
		{
				e.printStackTrace();
				logger.info("Problem verifying pipeline "+IBorOB+" for tool "+toolname);
				Assert.fail("Problem verifying pipeline "+IBorOB+" for tool "+toolname);
		}
		
	}
	
public static void checkWorkItemsPipeline(String IBorOB,String toolname){
	
	try{
		boolean pipeline = false;
		int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
		
		if(IBorOB.equalsIgnoreCase("IB"))
		{
			
			for(int i=1;i<totalNoRow;i++)
			{
				String pipelinename = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_pipelineName_statictxt, String.valueOf(i), "int"));
				if(pipelinename.contains("JIRA-US-Inbound") || pipelinename.contains("Scrum-US-Inbound") || pipelinename.contains("Agile-US-Inbound") || pipelinename.contains("MSPS-US-Inbound"))
						{
							
							clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_editPipeline_statictxt, String.valueOf(i), "int"));
							Thread.sleep(1000);
	//						ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
							ExpWaitForCondition(ProductConfigUIMap.EditProcessPipeline_window);
							clickJS(ProductConfigUIMap.isEnabled_Yes_statictxt);
							clear(ProductConfigUIMap.ExecutionFrequency_txtbox);
							enterText(ProductConfigUIMap.ExecutionFrequency_txtbox,"1");
							selectDropdownByValue(ProductConfigUIMap.ServiceName_drpdown, "Accenture.MyWizard.GatewayManager.Engine-10");
//							assertEquals(getDropdownValue(ProductConfigUIMap.ServiceName_drpdown), "Accenture.MyWizard.GatewayManager.Engine-10");
							clickJS(ProductConfigUIMap.ContinueBtnInPipelineWindow_btn);
							ProductConfiguration.verifyWorkItemAttributes(IBorOB,toolname);
	//						ProductConfiguration.verifyPassword(toolname);
							clickJS(ProductConfigUIMap.CloseAttributesWidow_btn);
							pipeline = true;
							break;
						}
			}
					if(!pipeline)
					ProductConfiguration.addWorkItemPipeline(IBorOB,toolname);
			
		}
		

		if(IBorOB.equalsIgnoreCase("OB"))
		{
			for(int i=1;i<totalNoRow;i++)
			{
				String pipelinename = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_pipelineName_statictxt, String.valueOf(i), "int"));
				if(pipelinename.contains("JIRA-US-Outbound")  || pipelinename.contains("Scrum-US-Outbound") || pipelinename.contains("Agile-US-Outbound") || pipelinename.contains("MSPS-US-Outbound"))
						{
							
							clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_editPipeline_statictxt, String.valueOf(i), "int"));
							ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
							Thread.sleep(1000);
							ExpWaitForCondition(ProductConfigUIMap.EditProcessPipeline_window);
							clickJS(ProductConfigUIMap.isEnabled_Yes_statictxt);
							clear(ProductConfigUIMap.ExecutionFrequency_txtbox);
							enterText(ProductConfigUIMap.ExecutionFrequency_txtbox,"1");
							assertEquals(getDropdownValue(ProductConfigUIMap.ServiceName_drpdown), "Accenture.MyWizard.GatewayManager.Engine-20");
							clickJS(ProductConfigUIMap.ContinueBtnInPipelineWindow_btn);
							ProductConfiguration.verifyWorkItemAttributes(IBorOB,toolname);
	//						ProductConfiguration.verifyPassword(toolname);
							clickJS(ProductConfigUIMap.CloseAttributesWidow_btn);
							pipeline = true;
							break;
						}
			}
					if(!pipeline)
					ProductConfiguration.addWorkItemPipeline(IBorOB,toolname);
		}
	}
	catch(Exception e)
	{
			e.printStackTrace();
			logger.info("Issue checking/loading the "+IBorOB+" workitem pipeline for tool "+toolname);
			Assert.fail("Issue checking/loading the "+IBorOB+" workitem pipeline for tool "+toolname);
	}
	
}


public static void checkIterationsPipeline(String toolname){
	
	try{
		boolean pipeline = false;
		int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
		for(int i=1;i<totalNoRow;i++)
		{
			String pipelinename = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_pipelineName_statictxt, String.valueOf(i), "int"));
			if(pipelinename.contains("ITR-US-Inbound"))
					{
						clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_editPipeline_statictxt, String.valueOf(i), "int"));
						Thread.sleep(1000);
						ExpWaitForCondition(ProductConfigUIMap.EditProcessPipeline_window);
						clickJS(ProductConfigUIMap.isEnabled_Yes_statictxt);
						clear(ProductConfigUIMap.ExecutionFrequency_txtbox);
						enterText(ProductConfigUIMap.ExecutionFrequency_txtbox,"6");
						assertEquals(getDropdownValue(ProductConfigUIMap.ServiceName_drpdown), "Accenture.MyWizard.GatewayManager.Engine-10");
						clickJS(ProductConfigUIMap.ContinueBtnInPipelineWindow_btn);
						ProductConfiguration.verifyIterationAttributes(toolname);
						clickJS(ProductConfigUIMap.CloseAttributesWidow_btn);
						pipeline = true;
						break;
					}
		}
		
		if(!pipeline)
			ProductConfiguration.addIterationsPipeline(toolname);
		
		}
	catch(Exception e)
	{
			e.printStackTrace();
			logger.info("Issue checking/loading the Iteration pipeline for tool "+toolname);
			Assert.fail("Issue checking/loading the Iteration pipeline for tool "+toolname);
	}
	
}

public static void checkTeamsPipeline(String toolname){
	
	try{
		boolean pipeline = false;
		int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
		for(int i=1;i<totalNoRow;i++)
		{
			String pipelinename = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_pipelineName_statictxt, String.valueOf(i), "int"));
			if(pipelinename.contains("TEAMS-US-Inbound") || pipelinename.contains("Team-US-Inbound"))
					{
						clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_editPipeline_statictxt, String.valueOf(i), "int"));
						Thread.sleep(1000);
						ExpWaitForCondition(ProductConfigUIMap.EditProcessPipeline_window);
						clickJS(ProductConfigUIMap.isEnabled_Yes_statictxt);
						clear(ProductConfigUIMap.ExecutionFrequency_txtbox);
						enterText(ProductConfigUIMap.ExecutionFrequency_txtbox,"60");
						assertEquals(getDropdownValue(ProductConfigUIMap.ServiceName_drpdown), "Accenture.MyWizard.GatewayManager.Engine-10");
						clickJS(ProductConfigUIMap.ContinueBtnInPipelineWindow_btn);
						ProductConfiguration.verifyTeamAttributes(toolname);
						clickJS(ProductConfigUIMap.CloseAttributesWidow_btn);
						pipeline = true;
						break;
					}
				
		}
		if(!pipeline)
			ProductConfiguration.addTeamPipeline(toolname);
		
	}
	catch(Exception e)
	{
			e.printStackTrace();
			logger.info("Issue checking/loading the Teams pipeline for "+toolname);
			Assert.fail("Issue checking/loading the Teams pipeline for "+toolname);
	}
	
	
}
public static void addWorkItemPipeline(String IBorOB,String toolname){
	
	try{
		clickJS(ProductConfigUIMap.AddProcessPipeline_link);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//		ExpWaitForCondition(ProductConfigUIMap.ProductVersionProcessPipeline_link);
		if(toolname.equalsIgnoreCase("ADT JIRA") && IBorOB.equalsIgnoreCase("IB"))
		selectDropdownByText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "ADTJIRA-US-Inbound");
		if(toolname.equalsIgnoreCase("ADOP JIRA") && IBorOB.equalsIgnoreCase("IB"))
		selectDropdownByText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "ADOPJIRA-US-Inbound");	
		if(toolname.equalsIgnoreCase("ADT JIRA") && IBorOB.equalsIgnoreCase("OB"))
		selectDropdownByText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "ADTJIRA-US-Outbound");
		if(toolname.equalsIgnoreCase("ADOP JIRA") && IBorOB.equalsIgnoreCase("OB"))
		selectDropdownByText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "ADOPJIRA-US-Outbound");	
		if(toolname.equalsIgnoreCase("TFS Agile") && IBorOB.equalsIgnoreCase("IB"))
		selectByPartOfVisibleText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "Agile-US-Inbound");
		if(toolname.equalsIgnoreCase("TFS Scrum") && IBorOB.equalsIgnoreCase("IB"))
		selectByPartOfVisibleText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "Scrum-US-Inbound");
		if(toolname.equalsIgnoreCase("TFS Agile") && IBorOB.equalsIgnoreCase("OB"))
		selectByPartOfVisibleText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "Agile-US-Outbound");
		if(toolname.equalsIgnoreCase("TFS Scrum") && IBorOB.equalsIgnoreCase("OB"))
		selectDropdownByText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "Scrum-US-Outbound");
		if(toolname.equalsIgnoreCase("mywizardMSPS") && IBorOB.equalsIgnoreCase("IB"))
		selectDropdownByText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "MSPS-US-Inbound");
		if(toolname.equalsIgnoreCase("mywizardMSPS") && IBorOB.equalsIgnoreCase("OB"))
		selectDropdownByText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "MSPS-US-Outbound");
		
		clickJS(ProductConfigUIMap.isEnabled_Yes_statictxt);
		clear(ProductConfigUIMap.ExecutionFrequency_txtbox);
		enterText(ProductConfigUIMap.ExecutionFrequency_txtbox,"1");
		if(IBorOB.equalsIgnoreCase("IB"))
		selectDropdownByText(ProductConfigUIMap.ServiceName_drpdown, "Accenture.MyWizard.GatewayManager.Engine-10");
		if(IBorOB.equalsIgnoreCase("OB"))
		selectDropdownByText(ProductConfigUIMap.ServiceName_drpdown, "Accenture.MyWizard.GatewayManager.Engine-20");
		clickJS(ProductConfigUIMap.ContinueBtnInPipelineWindow_btn);
		ProductConfiguration.addWorkItemAttributes(IBorOB,toolname);
	}
	catch(Exception e)
	{
			e.printStackTrace();
			logger.info("Problem adding "+IBorOB+" workitem pieline for tool "+toolname);
			Assert.fail("Problem adding "+IBorOB+" workitem pieline for tool "+toolname);
	}
}
	public static void addIterationsPipeline(String toolname){
		
		try{
			clickJS(ProductConfigUIMap.AddProcessPipeline_link);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			ExpWaitForCondition(ProductConfigUIMap.EditProcessPipeline_window);
			if(toolname.contains("ADT") || toolname.contains("adt"))
			selectDropdownByText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "ADTJIRAITR-US-Inbound");
			if(toolname.contains("ADOP") || toolname.contains("adop"))
			selectDropdownByText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "ADOPJIRA-US-ITR-Inbound");
			if(toolname.contains("TFS") || toolname.contains("tfs"))
			selectByPartOfVisibleText(ProductConfigUIMap.ProductVersionProcessPipeline_link,"ITR-US-Inbound");
			clickJS(ProductConfigUIMap.isEnabled_Yes_statictxt);
			clear(ProductConfigUIMap.ExecutionFrequency_txtbox);
			enterText(ProductConfigUIMap.ExecutionFrequency_txtbox,"6");
			selectDropdownByText(ProductConfigUIMap.ServiceName_drpdown, "Accenture.MyWizard.GatewayManager.Engine-10");
			clickJS(ProductConfigUIMap.ContinueBtnInPipelineWindow_btn);
			ProductConfiguration.addIterationAttributes(toolname);
		}
		catch(Exception e)
		{
				e.printStackTrace();
				logger.info("Problem adding Iterations pipeline for tool "+toolname);
				Assert.fail("Problem adding Iterations pipeline for tool "+toolname);
		}
		
}
	public static void addTeamPipeline(String toolname){
		
		try{
			clickJS(ProductConfigUIMap.AddProcessPipeline_link);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			ExpWaitForCondition(ProductConfigUIMap.EditProcessPipeline_window);
			if(toolname.contains("ADT") || toolname.contains("adt"))
			selectDropdownByText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "ADTJIRATeam-US-Inbound");
			if(toolname.contains("ADOP") || toolname.contains("adop"))
			selectDropdownByText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "ADOPJIRA-US-Team-Inbound");
			if(toolname.contains("TFS") || toolname.contains("tfs"))
			selectByPartOfVisibleText(ProductConfigUIMap.ProductVersionProcessPipeline_link, "Teams-US-Inbound");
			clickJS(ProductConfigUIMap.isEnabled_Yes_statictxt);
			enterText(ProductConfigUIMap.ExecutionFrequency_txtbox,"60");
			selectDropdownByText(ProductConfigUIMap.ServiceName_drpdown, "Accenture.MyWizard.GatewayManager.Engine-10");
			clickJS(ProductConfigUIMap.ContinueBtnInPipelineWindow_btn);
			ProductConfiguration.addTeamAttributes(toolname);
		}
		catch(Exception e)
		{
				e.printStackTrace();
				logger.info("Problem adding Team pipeline for "+toolname);
				Assert.fail("Problem adding Team pipeline for "+toolname);
		}
		
}
	
public static void verifyWorkItemAttributes(String IBorOB,String toolname){
		
		try{
			
			if(IBorOB.equalsIgnoreCase("IB"))
				{
					int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
					for(int i=1;i<=totalNoRow;i++)
					{
						String p = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_pipelineName_statictxt, String.valueOf(i), "int"));
						if(p.contains("JIRA-US-Inbound") || p.contains("Agile-US-Inbound") || p.contains("Scrum-US-Inbound") || p.contains("MSPS-US-Inbound"))
								{
									clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_ManageIntegrationParamters_statictxt, String.valueOf(i), "int"));
									ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
									if(toolname.contains("ADT"))
									ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "ADT-Inbound", toolname);
									if(toolname.contains("ADOP"))
									ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "ADOP-Inbound", toolname);
									if(toolname.contains("Agile"))
									ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "TFS-Inbound-Agile", toolname);
									if(toolname.contains("Scrum") )
									ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "TFS-Inbound-Scrum", toolname);
									if(toolname.contains("MSPS") || toolname.contains("msps") )
									ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "MSPS-Inbound", toolname);
								
								}
					}
				}
			else if (IBorOB.equalsIgnoreCase("OB"))
			{
				int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
				for(int i=1;i<=totalNoRow;i++)
				{
					String p = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_pipelineName_statictxt, String.valueOf(i), "int"));
					if(p.contains("US-Outbound"))
							{
								clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_ManageIntegrationParamters_statictxt, String.valueOf(i), "int"));
								ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
								if(toolname.contains("ADT") || toolname.contains("adt")) 
								ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "ADT-Outbound", toolname); 
								if(toolname.contains("ADOP"))
								ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "ADOP-Outbound", toolname);
								if(toolname.contains("TFS") || toolname.contains("tfs"))
								ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "TFS-Outbound", toolname);
								if(toolname.contains("MSPS") || toolname.contains("msps"))
								ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "MSPS-Outbound", toolname);
								
							}
				}
			
			
			}
		}
		catch(Exception e)
		{
				e.printStackTrace();
				logger.info("Problem verifying attributes for "+IBorOB+" pipeline for "+toolname);
				Assert.fail("Problem verifying attributes for "+IBorOB+" pipeline for "+toolname);
		}
		
}

public static void verifyIterationAttributes(String toolname){
	
	try{
		int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
		for(int i=1;i<=totalNoRow;i++)
		{
			String p = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_pipelineName_statictxt, String.valueOf(i), "int"));
			if(p.contains("JIRA-ITR-US-Inbound") || p.contains("Agile-ITR-US-Inbound") || p.contains("Scrum-ITR-US-Inbound"))
					{
						clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_ManageIntegrationParamters_statictxt, String.valueOf(i), "int"));
						ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
						if(toolname.contains("ADT"))
						ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "ADT-ITR", toolname);
						if(toolname.contains("ADOP"))
						ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "ADOP-ITR", toolname);
						if(toolname.contains("TFS Agile"))
						ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "TFS-ITR-Agile", toolname);
						if(toolname.contains("TFS Scrum"))
						ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "TFS-ITR-Scrum", toolname);
					}
		}
		
		
	}
	catch(Exception e)
	{
			e.printStackTrace();
			logger.info("Problem verifying Iteration attributes for "+toolname);
			Assert.fail("Problem verifying Iteration attributes for "+toolname);
	}
	
}

public static void verifyTeamAttributes(String toolname){
	
	try{
		int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
		for(int i=1;i<=totalNoRow;i++)
		{
			String p = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_pipelineName_statictxt, String.valueOf(i), "int"));
			if(p.contains("TEAMS-US-Inbound") || p.contains("Team-US-Inbound") )
					{
						clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_ManageIntegrationParamters_statictxt, String.valueOf(i), "int"));
						ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
						if(toolname.contains("ADT"))
						ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "ADT-Team", toolname); 
						if(toolname.contains("ADOP"))
						ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "ADOP-Team", toolname);
						if(toolname.contains("TFS Agile"))
						ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "TFS-Team-Agile", toolname);
						if(toolname.contains("TFS Scrum"))
						ProductConfiguration.verifyAttributesFromExcel(Attributes_FileLoc, "TFS-Team-Scrum", toolname);
					}
		}
		
		
	}
	catch(Exception e)
	{
			e.printStackTrace();
			logger.info("Problem verifying Teams attributes for "+toolname);
			Assert.fail("Problem verifying Teams attributes for "+toolname);
	}
	
}
public static void verifyAttributesFromExcel(String fileloc,String sheetname, String toolname){
	try{
		
		int getTotalRowsOnUI = getDataRowCount(ProductConfigUIMap.Attributes_table);
		 HashMap<String, String> hmap = new HashMap<>();
		 
		 for(int j=1;j<getTotalRowsOnUI;j++)
		 {
			hmap.put(getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column2_AttributeName_statictxt, String.valueOf(j), "int")), getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_AttributeValue_statictxt, String.valueOf(j), "int")));
		 }
		 
		FileInputStream	 fis = new FileInputStream(new File(fileloc));
		XSSFWorkbook workbook = new XSSFWorkbook (fis);
		 XSSFSheet sheet = workbook.getSheet(sheetname);
		 
		 int noofRows = sheet.getPhysicalNumberOfRows();
		 //pwd for jira
		 String password_toBe_Verified = "";
		
		 //token for TFS
		 String token_toBe_Verified = "";
		if(toolname.contains("jira") || toolname.contains("JIRA"))
		{
			 for(int i=1; i<noofRows;i++)
			 {
					 String attributename = sheet.getRow(i).getCell(0).getStringCellValue();
					 DataFormatter formatter = new DataFormatter();
					 String attributevalue =  formatter.formatCellValue(sheet.getRow(i).getCell(1));
						 if(attributename.equalsIgnoreCase("EffectiveFrom") || attributename.equalsIgnoreCase("EffectiveTo") || attributename.equalsIgnoreCase("Password") )
						 {
							 if(attributename.equalsIgnoreCase("Password")) 
							 password_toBe_Verified = attributevalue;
							
						 }
						 if(attributename.equalsIgnoreCase("ProjectExtension")) {
							 clickJS(ProductConfigUIMap.ProjectExtensionAttribute_link);
							 String ProjExt = Property.getProperty("ProductInstanceTool")+"_"+Property.getProperty("MyWizard_Client")+"_Project";
							 clear(ProductConfigUIMap.ParameterValue_txtbox);
							 enterText(ProductConfigUIMap.ParameterValue_txtbox,ProjExt);
							 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
						 }
						 if(attributename.equalsIgnoreCase("BoardExtension")) {
							 clickJS(ProductConfigUIMap.BoardExtensionAttribute_link);
							 String BoardExt = Property.getProperty("ProductInstanceTool")+"_"+Property.getProperty("MyWizard_Client")+"_BoardId";
							 clear(ProductConfigUIMap.ParameterValue_txtbox);
							 enterText(ProductConfigUIMap.ParameterValue_txtbox,BoardExt);
							 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
						 }
						 if(attributename.equalsIgnoreCase("ProjectKey")) {
							 clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DynamicAttribute_link, attributename, "attributename"));
				  			 clear(ProductConfigUIMap.ParameterValue_txtbox);
				  			 enterText(ProductConfigUIMap.ParameterValue_txtbox,Property.getProperty("JiraProjectKey") );
							 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
						 }
						 if(attributename.equalsIgnoreCase("ProjectName")) {
							 clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DynamicAttribute_link, attributename, "attributename"));
				  			 clear(ProductConfigUIMap.ParameterValue_txtbox);
				  			 enterText(ProductConfigUIMap.ParameterValue_txtbox,Property.getProperty("JiraProjectKey") );
							 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
						 }
						 if(attributename.equalsIgnoreCase("UserName")) {
							 clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DynamicAttribute_link, attributename, "attributename"));
				  			 clear(ProductConfigUIMap.ParameterValue_txtbox);
				  			 enterText(ProductConfigUIMap.ParameterValue_txtbox,Property.getProperty("JiraUserName") );
							 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
						 }
						 
					  		if(!(attributename.equalsIgnoreCase("EffectiveFrom") || attributename.equalsIgnoreCase("EffectiveTo") || attributename.equalsIgnoreCase("Password") || attributename.equalsIgnoreCase("ProjectExtension") || attributename.equalsIgnoreCase("BoardExtension") || attributename.equalsIgnoreCase("ProjectKey") || attributename.equalsIgnoreCase("ProjectName") || attributename.equalsIgnoreCase("UserName"))){
					  			if(hmap.containsKey(attributename))
								 {
						  			if(!hmap.get(attributename).contentEquals(attributevalue))
						  			{
						  			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DynamicAttribute_link, attributename, "attributename"));
						  			 clear(ProductConfigUIMap.ParameterValue_txtbox);
						  			 enterText(ProductConfigUIMap.ParameterValue_txtbox,attributevalue );
									 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
						  			}
						  			//assertEquals(hmap.get(attributename), attributevalue);
									 //system.out.println(hmap.get(attributename));
									 //system.out.println(attributevalue);
								 }
						  		else
						  		{
						  			//system.out.println("missing key " +attributename);
						  			//missing key
						  		}	
					  	
					  		
					  		
						 }
							
						
					 
				
				 }
			 clickJS(ProductConfigUIMap.PasswordAttribute_link);
			 clear(ProductConfigUIMap.ParameterValue_txtbox);
			 enterText(ProductConfigUIMap.ParameterValue_txtbox,password_toBe_Verified );
			clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
			 //find the row which has password as attributename. click edit attribute and verify with password_toBe_Verified
	 
	
		}
		
		if(toolname.contains("TFS") || toolname.contains("tfs"))
		{
			 for(int i=1; i<noofRows;i++)
			 {
					 String attributename = sheet.getRow(i).getCell(0).getStringCellValue();
					 DataFormatter formatter = new DataFormatter();
					 
					 String attributevalue = formatter.formatCellValue(sheet.getRow(i).getCell(1));
//					 sheet.getRow(i).getCell(1).getStringCellValue()
					 if(attributename.equalsIgnoreCase("EffectiveFrom") || attributename.equalsIgnoreCase("EffectiveTo") || attributename.equalsIgnoreCase("Token"))
					 {
						 if(attributename.equalsIgnoreCase("Token")) 
							 token_toBe_Verified = attributevalue;
					 }
					 if(attributename.equalsIgnoreCase("ProjectName"))
					 {
							clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DynamicAttribute_link, attributename, "attributename"));
				  			 clear(ProductConfigUIMap.ParameterValue_txtbox);
				  			 enterText(ProductConfigUIMap.ParameterValue_txtbox,Property.getProperty("TFSProjectName")+"_ Client-Native" );
							 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
					 }
					 if(attributename.equalsIgnoreCase("ProjectExtension"))
					 {
						 clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DynamicAttribute_link, attributename, "attributename"));
			  			 clear(ProductConfigUIMap.ParameterValue_txtbox);
			  			 enterText(ProductConfigUIMap.ParameterValue_txtbox,"myWizard-TFS_"+Property.getProperty("MyWizard_Client")+"_Project" );
						 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
					 }
					 if(!(attributename.equalsIgnoreCase("EffectiveFrom") || attributename.equalsIgnoreCase("EffectiveTo") || attributename.equalsIgnoreCase("Token") || attributename.equalsIgnoreCase("ProjectName") || attributename.equalsIgnoreCase("ProjectExtension"))){
						 if(hmap.containsKey(attributename))
						 {
				  			if(!hmap.get(attributename).contentEquals(attributevalue))
				  			{
				  			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DynamicAttribute_link, attributename, "attributename"));
				  			 clear(ProductConfigUIMap.ParameterValue_txtbox);
				  			 enterText(ProductConfigUIMap.ParameterValue_txtbox,attributevalue );
							 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
				  			}
				  			//assertEquals(hmap.get(attributename), attributevalue);
							 //system.out.println(hmap.get(attributename));
							 //system.out.println(attributevalue);
						 }
				  		else
				  		{
				  			//system.out.println("missing key " +attributename);
				  			//missing key
				  		}	
						
			 }
			 
		}
			 clickJS(ProductConfigUIMap.TokenAttribute_link);
			 clear(ProductConfigUIMap.ParameterValue_txtbox);
			 enterText(ProductConfigUIMap.ParameterValue_txtbox,token_toBe_Verified );
			clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
	}
		
		if(toolname.contains("MSPS") || toolname.contains("msps"))
		{
			 for(int i=1; i<noofRows;i++)
			 {
					 String attributename = sheet.getRow(i).getCell(0).getStringCellValue();
					 DataFormatter formatter = new DataFormatter();
					 
					 String attributevalue = formatter.formatCellValue(sheet.getRow(i).getCell(1));

//					 if(attributename.equalsIgnoreCase("myWizardGMBinFolderPath"))
//					 {
//					 clickJS(ProductConfigUIMap.myWizardGMBinFolderPathAttribute_link);
//					 clear(ProductConfigUIMap.ParameterValue_txtbox);
//					 String paramValue = Property.getProperty("myWizardGMBinFolderPath");
//					 enterText(ProductConfigUIMap.ParameterValue_txtbox,paramValue );
//					 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
//					 }
					
					 if(attributename.equalsIgnoreCase("AxureBlobContainerName"))
					 {
						 clickJS(ProductConfigUIMap.AxureBlobContainerNameAttribute_link);
						 clear(ProductConfigUIMap.ParameterValue_txtbox);
						 String paramValue = Property.getProperty("MSPSProjectKeyName");
						 enterText(ProductConfigUIMap.ParameterValue_txtbox,paramValue );
						clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
					 }
					 if(attributename.equalsIgnoreCase("SharedAccessKeyName"))
					 {
						 clickJS(ProductConfigUIMap.SharedAccessKeyNameAttribute_link);
						 clear(ProductConfigUIMap.ParameterValue_txtbox);
						 String paramValue = Property.getProperty("MSPSProjectKeyName");
						 enterText(ProductConfigUIMap.ParameterValue_txtbox,paramValue );
						 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
					 }
					 if(attributename.equalsIgnoreCase("SASKey"))
					 {
						 clickJS(ProductConfigUIMap.SASKeyAttribute_link);
						 clear(ProductConfigUIMap.ParameterValue_txtbox);
						 String paramValue = Property.getProperty("MSPSProjectKeyName");
						 enterText(ProductConfigUIMap.ParameterValue_txtbox,paramValue );
						 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
					 }
					 
					 if(attributename.equalsIgnoreCase("IntermediateAPIUrl"))
					 {
						 clickJS(ProductConfigUIMap.IntermediateAPIUrlAttribute_link);
						 clear(ProductConfigUIMap.ParameterValue_txtbox);
						 String paramValue = Property.getProperty("MyWizard_URL");
						 String[] url = paramValue.split("core");
						 enterText(ProductConfigUIMap.ParameterValue_txtbox,url[0]+"mspsalmintegration");
						 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
					 }
					 if(attributename.equalsIgnoreCase("AzureStorageContainerName"))
					 {
						 clickJS(ProductConfigUIMap.AzureStorageContainerNameAttribute_link);
						 clear(ProductConfigUIMap.ParameterValue_txtbox);
						 String paramValue = Property.getProperty("MSPSProjectKeyName");
						 enterText(ProductConfigUIMap.ParameterValue_txtbox,paramValue );
						 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
					 }
					 if(attributename.equalsIgnoreCase("PropertyInjectorFile"))
					 {
						 //code not required. this field is populated automatically as per swetha
//						 clickJS(ProductConfigUIMap.AzureStorageContainerNameAttribute_link);
//						 clear(ProductConfigUIMap.ParameterValue_txtbox);
//						 String paramValue = Property.getProperty("MSPSProjectKeyName");
//						 enterText(ProductConfigUIMap.ParameterValue_txtbox,paramValue );
//						 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
					 }
					 
					 if(attributename.equalsIgnoreCase("AuthUrl"))
					 {
						 clickJS(ProductConfigUIMap.AuthUrlAttribute_link);
						 clear(ProductConfigUIMap.ParameterValue_txtbox);
						 enterText(ProductConfigUIMap.ParameterValue_txtbox,attributevalue );
						 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
					 }
					 
					 if(attributename.equalsIgnoreCase("SASUri"))
					 {
						 clickJS(ProductConfigUIMap.SASUriAttribute_link);
						 clear(ProductConfigUIMap.ParameterValue_txtbox);
						 enterText(ProductConfigUIMap.ParameterValue_txtbox,attributevalue );
						 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
					 }
					 if(attributename.equalsIgnoreCase("TokenGrantType"))
					 {
						 clickJS(ProductConfigUIMap.TokenGrantTypeAttribute_link);
						 clear(ProductConfigUIMap.ParameterValue_txtbox);
						 enterText(ProductConfigUIMap.ParameterValue_txtbox,attributevalue );
						 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
						 
					 }
					 if(attributename.equalsIgnoreCase("TokenClientId"))
					 {
						 clickJS(ProductConfigUIMap.TokenClientIdAttribute_link);
						 clear(ProductConfigUIMap.ParameterValue_txtbox);
						 enterText(ProductConfigUIMap.ParameterValue_txtbox,attributevalue );
						 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
					 }
					 if(attributename.equalsIgnoreCase("TokenClientSecret"))
					 {
						 clickJS(ProductConfigUIMap.TokenClientSecretAttribute_link);
						 clear(ProductConfigUIMap.ParameterValue_txtbox);
						 enterText(ProductConfigUIMap.ParameterValue_txtbox,attributevalue );
						 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
					 }
					 
					 

					 if(!(attributename.equalsIgnoreCase("AzureStorageContainerName") || attributename.equalsIgnoreCase("IntermediateAPIUrl") || attributename.equalsIgnoreCase("SASKey") || attributename.equalsIgnoreCase("SharedAccessKeyName") || attributename.equalsIgnoreCase("AxureBlobContainerName") || attributename.equalsIgnoreCase("TokenClientSecret") || attributename.equalsIgnoreCase("TokenClientId") || attributename.equalsIgnoreCase("TokenGrantType") || attributename.equalsIgnoreCase("SASUri") || attributename.equalsIgnoreCase("AuthUrl") || attributename.equalsIgnoreCase("PropertyInjectorFile"))){
					  		if(hmap.containsKey(attributename))
							 {
					  			if(!hmap.get(attributename).contentEquals(attributevalue))
					  			{
					  			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DynamicAttribute_link, attributename, "attributename"));
					  			 clear(ProductConfigUIMap.ParameterValue_txtbox);
					  			 enterText(ProductConfigUIMap.ParameterValue_txtbox,attributevalue );
								 clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
					  			}
					  			//assertEquals(hmap.get(attributename), attributevalue);
//								 //system.out.println(hmap.get(attributename));
//								 //system.out.println(attributevalue);
							 }
					  		else
					  		{
//					  			//system.out.println("missing key " +attributename);
					  			Assert.fail("missing key "+attributename+ "in the excel file");
					  			
					  		}
			 }
			 
		}
			 
	}
}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Problem verifying attributes from excel for tool "+toolname);
			Assert.fail("Problem verifying attributes from excel for tool "+toolname);
		}
	
	
	}


public static void addWorkItemAttributes(String IBorOB,String toolname){
	try{
		int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
		for(int i=1;i<totalNoRow;i++)
		{
			String p = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_pipelineName_statictxt, String.valueOf(i), "int"));
			if(IBorOB.contains("IB"))
			{
			if(p.contains("JIRA-US-Inbound") || p.contains("Agile-US-Inbound") || p.contains("Scrum-US-Inbound") || p.contains("MSPS-US-Inbound"))
					{
						clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_ManageIntegrationParamters_statictxt, String.valueOf(i), "int"));
						ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					
						break;
					}
			}
			if(IBorOB.contains("OB"))
			{
				if(p.contains("JIRA-US-Outbound") || p.contains("Agile-US-Outbound") || p.contains("Scrum-US-Outbound")  || p.contains("MSPS-US-Outbound"))
				{
					clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_ManageIntegrationParamters_statictxt, String.valueOf(i), "int"));
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				
					break;
				}
			
			}
			
		}
		if(toolname.contains("ADT") && IBorOB.equalsIgnoreCase("IB"))
		ProductConfiguration.AddAttributesFromExcel("ADT-Inbound",toolname);
		if(toolname.contains("ADOP") && IBorOB.equalsIgnoreCase("IB"))
		ProductConfiguration.AddAttributesFromExcel("ADOP-Inbound",toolname);
		if(toolname.contains("ADT") && IBorOB.equalsIgnoreCase("OB"))
		ProductConfiguration.AddAttributesFromExcel("ADT-Outbound",toolname);
		if(toolname.contains("ADOP") && IBorOB.equalsIgnoreCase("OB"))
		ProductConfiguration.AddAttributesFromExcel("ADOP-Outbound",toolname);
		if(toolname.contains("TFS Agile") && IBorOB.equalsIgnoreCase("IB"))
		ProductConfiguration.AddAttributesFromExcel("TFS-Inbound-Agile",toolname);
		if(toolname.contains("TFS Scrum") && IBorOB.equalsIgnoreCase("IB"))
		ProductConfiguration.AddAttributesFromExcel("TFS-Inbound-Scrum",toolname);
		if(toolname.contains("TFS Agile") && IBorOB.equalsIgnoreCase("OB"))
		ProductConfiguration.AddAttributesFromExcel("TFS-Outbound",toolname);
		if(toolname.contains("TFS Scrum") && IBorOB.equalsIgnoreCase("OB"))
		ProductConfiguration.AddAttributesFromExcel("TFS-Outbound",toolname);
		if(toolname.contains("MSPS") && IBorOB.equalsIgnoreCase("IB"))
		ProductConfiguration.AddAttributesFromExcel("MSPS-Inbound",toolname);
		if(toolname.contains("MSPS") && IBorOB.equalsIgnoreCase("OB"))
		ProductConfiguration.AddAttributesFromExcel("MSPS-Outbound",toolname);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("issue adding workitem attributes for "+IBorOB+" pipeline for tool "+toolname);
		Assert.fail("issue adding workitem attributes for "+IBorOB+" pipeline for tool "+toolname);
	}

}

public static void addIterationAttributes(String toolname){
	try{
		int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
		for(int i=1;i<totalNoRow;i++)
		{
			String p = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_pipelineName_statictxt, String.valueOf(i), "int"));
			if(p.contains("ITR-US-Inbound")) 
					{
						clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_ManageIntegrationParamters_statictxt, String.valueOf(i), "int"));
						ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					
						break;
					}
		}
		if(toolname.contains("ADT") || toolname.contains("adt"))
		ProductConfiguration.AddAttributesFromExcel("ADT-ITR",toolname);
		if(toolname.contains("ADOP") || toolname.contains("adop"))
		ProductConfiguration.AddAttributesFromExcel("ADOP-ITR",toolname);
		if(toolname.contains("TFS Agile") || toolname.contains("tfs agile"))
		ProductConfiguration.AddAttributesFromExcel("TFS-ITR-Agile",toolname);
		if(toolname.contains("TFS Scrum") || toolname.contains("tfs scrum"))
		ProductConfiguration.AddAttributesFromExcel("TFS-ITR-Scrum",toolname);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("issue adding Iteration pipeline attributes for tool "+toolname);
		Assert.fail("issue adding Iteration pipeline attributes for tool "+toolname);
	}

}

public static void addTeamAttributes(String toolname){
	try{
		int totalNoRow = getDataRowCount(ProductConfigUIMap.SEI_table);
		for(int i=1;i<totalNoRow;i++)
		{
			String p = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column1_pipelineName_statictxt, String.valueOf(i), "int"));
			if(p.contains("TEAMS-US-Inbound") || p.contains("Team-US-Inbound")) 
					{
						clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column5_ManageIntegrationParamters_statictxt, String.valueOf(i), "int"));
						ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					
						break;
					}
		}
		if(toolname.contains("ADT") || toolname.contains("adt"))
		ProductConfiguration.AddAttributesFromExcel("ADT-Team",toolname);
		if(toolname.contains("ADOP") || toolname.contains("adop"))
		ProductConfiguration.AddAttributesFromExcel("ADOP-Team",toolname);
		if(toolname.contains("TFS Agile") || toolname.contains("tfs agile"))
		ProductConfiguration.AddAttributesFromExcel("TFS-Team-Agile",toolname);
		if(toolname.contains("TFS Scrum") || toolname.contains("tfs scrum"))
		ProductConfiguration.AddAttributesFromExcel("TFS-Team-Scrum",toolname);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("issue adding Teams pipeline attributes for tool "+toolname);
		Assert.fail("issue adding Teams pipeline attributes for tool "+toolname);
	}

}

public static void AddAttributesFromExcel(String sheetname,String toolname){
	try{
	
	 
	 int totalNoAttributes = getDataRowCount(ProductConfigUIMap.Attributes_table);
		
	 if(toolname.contains("JIRA") || toolname.contains("jira"))
	 {
		for(int j=3; j<totalNoAttributes;j++)
		{
			String attributename = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column2_AttributeName_statictxt, String.valueOf(j), "int"));
			String attributevalue = ProductConfiguration.getAttributeValueFromExcel(attributename,sheetname);
			if(attributename.equalsIgnoreCase("EffectiveFrom") || attributename.equalsIgnoreCase("EffectiveTo") )
			{
				//system.out.println("ok dont enter EffectiveFrom and EffectiveTo");
			}
			else if(attributename.equalsIgnoreCase("ProjectName") || attributename.equalsIgnoreCase("ProjectKey") )
			{
				attributevalue = Property.getProperty("JiraProjectKey");
				clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column7_ManageIntegrationParams_Img, String.valueOf(j-1), "int"));
				enterText(ProductConfigUIMap.ParameterValue_txtbox, attributevalue);
				clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
			}
			else if(attributename.equalsIgnoreCase("UserName") )
			{
				attributevalue = Property.getProperty("JiraUserName");
				clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column7_ManageIntegrationParams_Img, String.valueOf(j-1), "int"));
				enterText(ProductConfigUIMap.ParameterValue_txtbox, attributevalue);
				clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
			}
			else if(attributename.equalsIgnoreCase("Password") )
			{
				attributevalue = Property.getProperty("JiraPaswsword");
				clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column7_ManageIntegrationParams_Img, String.valueOf(j-1), "int"));
				enterText(ProductConfigUIMap.ParameterValue_txtbox, attributevalue);
				clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
			}
			else if(attributename.equalsIgnoreCase("ProjectExtension") )
			{
				attributevalue = toolname.toUpperCase()+"_"+Property.getProperty("MyWizard_Client")+"_Project";
				clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column7_ManageIntegrationParams_Img, String.valueOf(j-1), "int"));
				enterText(ProductConfigUIMap.ParameterValue_txtbox, attributevalue);
				clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
			}
			else if(attributename.equalsIgnoreCase("BoardExtension") )
			{
				attributevalue = toolname.toUpperCase()+"_"+Property.getProperty("MyWizard_Client")+"_BoardId";
				clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column7_ManageIntegrationParams_Img, String.valueOf(j-1), "int"));
				enterText(ProductConfigUIMap.ParameterValue_txtbox, attributevalue);
				clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
			}
			else
			{
			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column7_ManageIntegrationParams_Img, String.valueOf(j-1), "int"));
			enterText(ProductConfigUIMap.ParameterValue_txtbox, attributevalue);
			clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
			}
		}
		Thread.sleep(2000);
		clickJS(ProductConfigUIMap.CloseAttributesWidow_btn);
	 }
	 
	 if(toolname.contains("TFS") || toolname.contains("tfs"))
	 {
		for(int j=3; j<totalNoAttributes;j++)
		{
			String attributename = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column2_AttributeName_statictxt, String.valueOf(j), "int"));
			String attributevalue = ProductConfiguration.getAttributeValueFromExcel(attributename,sheetname);
			if(attributename.equalsIgnoreCase("EffectiveFrom") || attributename.equalsIgnoreCase("EffectiveTo") )
			{
				//system.out.println("ok dont enter");
			}
			else if(attributename.equalsIgnoreCase("ProjectName"))
			{
				//check this. it should be "_ Client-Native" added at the end
				attributevalue = Property.getProperty("TFSProjectName")+"_ Client-Native";
				clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column7_ManageIntegrationParams_Img, String.valueOf(j-1), "int"));
				enterText(ProductConfigUIMap.ParameterValue_txtbox, attributevalue);
				clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
			}
			else if(attributename.equalsIgnoreCase("ProjectExtension"))
			{
				attributevalue = "myWizard-TFS_"+Property.getProperty("MyWizard_Client")+"_Project";
				clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column7_ManageIntegrationParams_Img, String.valueOf(j-1), "int"));
				enterText(ProductConfigUIMap.ParameterValue_txtbox, attributevalue);
				clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
			}
			
			else
			{
			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column7_ManageIntegrationParams_Img, String.valueOf(j-1), "int"));
//			Thread.sleep(2000);
//			ExpWaitForElementToDisappear(ProductConfigUIMap.ToasterMsg_HighlightedFeilds_Msg);
			clear(ProductConfigUIMap.ParameterValue_txtbox);
			enterText(ProductConfigUIMap.ParameterValue_txtbox, attributevalue);
			clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
			}
		}
		Thread.sleep(2000);
		clickJS(ProductConfigUIMap.CloseAttributesWidow_btn);
	 }
	 
	 if(toolname.contains("MSPS") || toolname.contains("msps"))
	 {
		for(int j=1; j<totalNoAttributes;j++)
		{
			String attributename = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.Column2_AttributeName_statictxt, String.valueOf(j), "int"));
			String attributevalue = ProductConfiguration.getAttributeValueFromExcel(attributename,sheetname);
			if(attributename.equalsIgnoreCase("AxureBlobContainerName") || attributename.equalsIgnoreCase("SharedAccessKeyName") || attributename.equalsIgnoreCase("SASKey") || attributename.equalsIgnoreCase("AzureStorageContainerName") )
			{
				attributevalue = Property.getProperty("MSPSProjectKeyName");
				clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DynamicAttribute_link, attributename, "attributename"));
				enterText(ProductConfigUIMap.ParameterValue_txtbox, attributevalue);
				clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
			}
			else if(attributename.equalsIgnoreCase("IntermediateAPIUrl"))
			{
				
				attributevalue = Property.getProperty("MyWizard_URL");
				String[] url = attributevalue.split("core");
				clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DynamicAttribute_link, attributename, "attributename"));
				enterText(ProductConfigUIMap.ParameterValue_txtbox,url[0]+"mspsalmintegration");
				clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
			}
			
			
			else
			{
			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DynamicAttribute_link, attributename, "attributename"));
			clear(ProductConfigUIMap.ParameterValue_txtbox);
			enterText(ProductConfigUIMap.ParameterValue_txtbox, attributevalue);
			clickJS(ProductConfigUIMap.ContinueToSaveParamter_btn);
			}
		}
		Thread.sleep(2000);
		clickJS(ProductConfigUIMap.CloseAttributesWidow_btn);
	 }
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("issue adding Attributes from excel sheet "+ sheetname+" for tool "+toolname);
		Assert.fail("issue adding Attributes from excel sheet "+ sheetname+" for tool "+toolname);
	}
}

public static String getAttributeValueFromExcel(String attributename,String sheetname){
	try
	{
		FileInputStream	 fis = new FileInputStream(new File(Attributes_FileLoc));
		XSSFWorkbook workbook = new XSSFWorkbook (fis);
		 XSSFSheet sheet = workbook.getSheet(sheetname);
		 String attributevalue = "";
		 int noofRows = sheet.getPhysicalNumberOfRows();
		 for(int i=0;i<noofRows;i++)
		 {
			 if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(attributename))
				 {
				 DataFormatter formatter = new DataFormatter();
				 attributevalue = formatter.formatCellValue(sheet.getRow(i).getCell(1));
//				attributevalue  = sheet.getRow(i).getCell(1).getStringCellValue();
				 break;
				 }
		 }
		 
		 return attributevalue;
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("issue fetching Attribute "+attributename+ " from excel sheet "+ sheetname);
		Assert.fail("issue fetching Attribute "+attributename+ " from excel sheet "+ sheetname);
		return "";
	}
	
	
}

public static void deploypipelines(String toolname){
	try{
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		clickJS(ProductConfigUIMap.DeployPipeline_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ExpWaitForCondition(ProductConfigUIMap.DeployPipelineTable_table);
		int rowcount_deploymentTable = getDataRowCount(ProductConfigUIMap.DeployPipelineTable_table);
		for(int i=1;i<rowcount_deploymentTable;i++)
		{
			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.SelectRows_DeployPipeline_Table, String.valueOf(i), "int"));
		}
		clickJS(ProductConfigUIMap.Deploy_btn);
		Thread.sleep(180000);
		refresh();
		Thread.sleep(6000);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ScrollIntoView(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductConfigPage_Section, "GatewayManager/ToolGateway Integration Parameters", "sectionname"));
		clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductConfigPage_Section, "GatewayManager/ToolGateway Integration Parameters", "sectionname"));
		int rowcount_statusOfDeployment = getDataRowCount(ProductConfigUIMap.SEI_table);
		boolean overallDeploymentStatus = true;
		for(int i = 1; i<rowcount_statusOfDeployment;i++)
		{
			String currentDeploymentStatus = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DeploymentStatus_txt, String.valueOf(i), "int"));
			if(!currentDeploymentStatus.equalsIgnoreCase("success"))
			{
				overallDeploymentStatus = false;
				break;
			}
		}
		if(!overallDeploymentStatus)
		{
			overallDeploymentStatus = true;
			Thread.sleep(120000);
			refresh();
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			for(int i = 1; i<rowcount_statusOfDeployment;i++)
			{
				String currentDeploymentStatus = getText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DeploymentStatus_txt, String.valueOf(i), "int"));
				if(!currentDeploymentStatus.equalsIgnoreCase("success"))
				{
					overallDeploymentStatus = false;
					break;
				}
				else
				{
					logger.info("pipeline deployed successfully for "+toolname);
					
				}
			}
		}
		if(!overallDeploymentStatus){
			logger.info("pipeline Deployment failed for "+toolname);
			Assert.fail("pipeline Deployment failed for "+toolname);
		}
	}
	catch(Exception e){
		e.printStackTrace();
		logger.info("Deploying pipelines failed");
		Assert.fail("Deploying pipelines failed");
	}
	
}

public static String Entity ;
public static void verifyClientNativeDetails(String toolname){
	
	try{
		
		HashMap<String,ArrayList<String>> ListofMultivaluedFields = getMultiValuedFieldsFromExcel(toolname);

		String ClientIUd = Property.getProperty("ClientIUd");
		String DeliveryConstructUId = Property.getProperty("DeliveryConstructUId_L1");
		String DeliveryConstructUId_L2 = Property.getProperty("DeliveryConstructUId_L2");
		String ProductInstanceUId = Property.getProperty("ProductInstanceUId");
		for (Entry<String, ArrayList<String>> entry : ListofMultivaluedFields.entrySet()) {
			
		    Entity = entry.getKey();
		    Object MultiValuedFields = entry.getValue();
//		    //system.out.println(Entity+" :"+ MultiValuedFields);
		   
		    String EntityUID = getEntityUID(Entity);
		    String WorkItemTypeUId = getWorkItemTypeUId(Entity);
		    
		    Map<String, List<Object>> clientNativeDetails; 
		    
		    if(!Entity.equalsIgnoreCase("Iteration"))
		   {
		    	clientNativeDetails = ClientNativeAPI.getClientNativeAPI(ClientIUd, DeliveryConstructUId, EntityUID, WorkItemTypeUId, ProductInstanceUId, MultiValuedFields);
		    }
		    else
		    {
		    	clientNativeDetails = ClientNativeAPI.getClientNativeAPI(ClientIUd, DeliveryConstructUId_L2, EntityUID, WorkItemTypeUId, ProductInstanceUId, MultiValuedFields);
		    }
		   
		  //convert MultiValuedFields to string, select each multivalued field, and verify the details
		   String MultiValuedFields_Str = String.valueOf(MultiValuedFields);
		    
		    //code to navigate to the required workitem and verify the details on the UI
		    
		  clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ManageEntity_link, Entity, "workitem"));
		  ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		  
		  if(MultiValuedFields_Str.contains("State"))
		  {
			  if(clientNativeDetails.containsKey("StateUId_Property"))
				  {
				  
				  		navigateToEntityPropertyTable("State");
					
					  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
					  List<Object> currentProperty = clientNativeDetails.get("StateUId_Property");
					  List<Object> currentPropertyGUId = clientNativeDetails.get("StateUId_GUId");
//					  //system.out.println(currentProperty.size());
//					  assertEquals(totalrowcount-1, currentProperty.size());
					  
					  verifyEntityPropertyToggleButton(totalrowcount);	
					  verifyEntityProperty("State", totalrowcount,currentProperty);
					  verifyEntityPropertyGUId("State", totalrowcount,currentPropertyGUId);
					 	
					  
					  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
					  Thread.sleep(5000);

				  }
				 
		  }
		  
		  if(MultiValuedFields_Str.contains("Category"))
		  {
			  if(clientNativeDetails.containsKey(" CategoryUId_Property"))
				  {
				  
				  		navigateToEntityPropertyTable("Category");
					
					  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
					  List<Object> currentProperty = clientNativeDetails.get(" CategoryUId_Property");
					  List<Object> currentPropertyGUId = clientNativeDetails.get(" CategoryUId_GUId");
//					  //system.out.println(currentProperty.size());
//					  assertEquals(totalrowcount-1, currentProperty.size());
					 
					  verifyEntityPropertyToggleButton(totalrowcount);
					  verifyEntityPropertyForCategory("Category",totalrowcount,currentProperty);
					  verifyEntityPropertyGUIdForCategory("Category",totalrowcount,currentPropertyGUId);
					 	
					  
					  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
					  Thread.sleep(5000);
				  }
				 
		  }
		
		
		  if(MultiValuedFields_Str.contains("Priority"))
		  {
			  if(clientNativeDetails.containsKey(" PriorityUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("Priority");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" PriorityUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" PriorityUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);	
				  verifyEntityProperty("Priority",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("Priority",totalrowcount,currentPropertyGUId);
					
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  if(MultiValuedFields_Str.contains("Type"))
		  {
			  if(clientNativeDetails.containsKey(" TypeUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("Type");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" TypeUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" TypeUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);	
				  verifyEntityProperty("Type",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("Type",totalrowcount,currentPropertyGUId);
					
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  if(MultiValuedFields_Str.contains("Type"))
		  {
			  if(clientNativeDetails.containsKey(" IterationTypeUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("Type");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" IterationTypeUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" IterationTypeUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);	
				  verifyEntityProperty("Type",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("Type",totalrowcount,currentPropertyGUId);
					
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  if(MultiValuedFields_Str.contains("Exposure"))
		  {
			  if(clientNativeDetails.containsKey(" ExposureUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("Exposure");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" ExposureUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" ExposureUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("Exposure",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("Exposure",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  
		  
		  if(MultiValuedFields_Str.contains("RiskExposure"))
		  {
			  if(clientNativeDetails.containsKey(" RiskExposureUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("Exposure");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" RiskExposureUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" RiskExposureUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("Exposure",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("Exposure",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  
		  if(MultiValuedFields_Str.contains("Exposure"))
		  {
			  if(clientNativeDetails.containsKey(" ExposureUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("Exposure");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" ExposureUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" ExposureUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("Exposure",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("Exposure",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  if(MultiValuedFields_Str.contains("Severity"))
		  {
			  if(clientNativeDetails.containsKey(" SeverityUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("Severity");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" SeverityUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" SeverityUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("Severity",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("Severity",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  if(MultiValuedFields_Str.contains("ExposureThreshold"))
		  {
			  if(clientNativeDetails.containsKey(" ExposureThresholdUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("ExposureThreshold");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" ExposureThresholdUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" ExposureThresholdUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("ExposureThreshold",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("ExposureThreshold",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  
		  if(MultiValuedFields_Str.contains("Proximity"))
		  {
			  if(clientNativeDetails.containsKey(" ProximityUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("Proximity");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" ProximityUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" ProximityUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("Proximity",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("Proximity",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  if(MultiValuedFields_Str.contains("Proximity"))
		  {
			  if(clientNativeDetails.containsKey(" RiskProximityUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("Proximity");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" RiskProximityUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" RiskProximityUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("Proximity",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("Proximity",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  
		  if(MultiValuedFields_Str.contains("Probability"))
		  {
			  if(clientNativeDetails.containsKey(" ProbabilityUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("Probability");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" ProbabilityUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" ProbabilityUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("Probability",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("Probability",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  if(MultiValuedFields_Str.contains("RequiresAttention"))
		  {
			  if(clientNativeDetails.containsKey(" RequiresAttentionUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("EscalationLevel");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" RequiresAttentionUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" RequiresAttentionUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("EscalationLevel",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("EscalationLevel",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  if(MultiValuedFields_Str.contains("EscalationLevel"))
		  {
			  if(clientNativeDetails.containsKey(" EscalationLevelUID_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("EscalationLevel");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" EscalationLevelUID_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" EscalationLevelUID_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("EscalationLevel",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("EscalationLevel",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  if(MultiValuedFields_Str.contains("Methodology"))
		  {
			  if(clientNativeDetails.containsKey(" IterationMethodology_Property"))
			  {
			  
			  	if(!Entity.equalsIgnoreCase("Iteration"))
				  navigateToEntityPropertyTable("Methodology");
			  	else
			  		navigateToEntityPropertyTable("MethodologyUId");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" IterationMethodology_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" IterationMethodology_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("Methodology",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("Methodology",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  if(MultiValuedFields_Str.contains("IterationPhase"))
		  {
			  if(clientNativeDetails.containsKey(" IterationPhase_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("IterationPhase");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" IterationPhase_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" IterationPhase_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("IterationPhase",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("IterationPhase",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  if(MultiValuedFields_Str.contains("Complexity"))
		  {
			  if(clientNativeDetails.containsKey(" IterationComplexityUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("Complexity");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" IterationComplexityUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" IterationComplexityUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("Complexity",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("Complexity",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  if(MultiValuedFields_Str.contains("Type"))
		  {
			  if(clientNativeDetails.containsKey(" DeliverableTypeUId_Property"))
			  {
			  
			  		navigateToEntityPropertyTable("Type");
				
				  int totalrowcount = getDataRowCount(ProductConfigUIMap.EntityPropertyValue_table) ;
				  List<Object> currentProperty = clientNativeDetails.get(" DeliverableTypeUId_Property");
				  List<Object> currentPropertyGUId = clientNativeDetails.get(" DeliverableTypeUId_GUId");
//				  //system.out.println(currentProperty.size());
//				  assertEquals(totalrowcount-1, currentProperty.size());
				  
				  verifyEntityPropertyToggleButton(totalrowcount);		
				  verifyEntityProperty("Type",totalrowcount,currentProperty);
				  verifyEntityPropertyGUId("Type",totalrowcount,currentPropertyGUId);
				  
				  
				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_PropertyValuePage_btn);
				  Thread.sleep(5000);
//				  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
			  }
		  }
		  
		  clickJS(ProductConfigUIMap.ContinueToSaveAttribute_EntityPropertyPage_btn);
		  Thread.sleep(5000);
		  
		}
		
		if(Baseclass.ClientNativeMatch.size()!=0)
		{
			 for(Map.Entry<String, List<Object>> entry : ClientNativeMatch.entrySet())
			 {
				 logger.info(entry.getKey() + " = " + entry.getValue());
			 }
			logger.info("Client native data mismatch");
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("Issue verfying the client native details for tool "+toolname);
		Assert.fail("Issue verfying the client native details for tool "+toolname);
	}
 

}

public static void verifyEntityProperty(String property, int totalrowcount,List<Object> currentProperty){
	
	try{
		boolean EntityPropertyMismatch = false;
		String currentCDMValfromUI ;
		for(int p=1;p<totalrowcount;p++)
		  {
					try
					{
					 currentCDMValfromUI = getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.CDMValue_Dropdwn, String.valueOf(p), "int"));
					 
					}
					catch(NoSuchElementException e)
					{
						continue;
					}
					 //system.out.println(currentCDMValfromUI);
					 String currentCDMCalfromAPI = (String) currentProperty.get(p-1);
					 //system.out.println(currentCDMCalfromAPI);
		//			 assertEquals(currentCDMVal, currentCDMCalfromAPI);
					 if(!currentCDMValfromUI.contentEquals(currentCDMCalfromAPI))
					 {
						 EntityPropertyMismatch = true;
					 }
			
		  }
		 if(EntityPropertyMismatch) {
			Baseclass.getInstance();
			Baseclass.ClientNativeMatch.put(Entity+"_"+property, currentProperty);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("issue verifying entity property "+currentProperty + "for entity "+Entity);
		Assert.fail("issue verifying entity property "+currentProperty + "for entity "+Entity);
	}
	
}



public static void verifyEntityPropertyForCategory(String property,int totalrowcount,List<Object> currentProperty){
	
	try{
		boolean EntityPropertyMismatch = false;
		for(int p=2;p<totalrowcount;p++)
		  {
			 String currentCDMValfromUI = getDropdownValue(prepareWebElementWithDynamicXpath(ProductConfigUIMap.CDMValue_Dropdwn, String.valueOf(p), "int"));
//			 //system.out.println(currentCDMValfromUI);
			 String currentCDMCalfromAPI = (String) currentProperty.get(p-2);
//			 //system.out.println(currentCDMCalfromAPI);
			 if(!currentCDMValfromUI.contentEquals(currentCDMCalfromAPI))
			 {
				 EntityPropertyMismatch = true;
			 }
		  }
		if(EntityPropertyMismatch) {
			Baseclass.getInstance();
			Baseclass.ClientNativeMatch.put(Entity+"_"+property, currentProperty);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("issue verifying entity property "+currentProperty + "for entity "+Entity);
		Assert.fail("issue verifying entity property "+currentProperty + "for entity "+Entity);
	}
	
}

public static void verifyDefaultPropertySelected(String property, int totalrowcount,List<Object> currentPropertyGUId){
	
	try{
		boolean DefaultPropertySelected = false;
		 for(int p=1;p<totalrowcount;p++)
		  {
			  if(isSelected(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DefaultProperty_chkbox, String.valueOf(p), "int")))
					  {
					  DefaultPropertySelected=true;
					  break;
					  }
			 
		  }
		 if(!DefaultPropertySelected) {
				clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DefaultProperty_chkbox,"1","int"));
			}
		 
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("issue selecting default property for entity "+Entity);
//		Assert.fail("issue verifying entity property GUID "+currentPropertyGUId + "for entity "+Entity);
	}
	
}

public static void verifyEntityPropertyGUId(String property, int totalrowcount,List<Object> currentPropertyGUId){
	
	try{
		boolean EntityPropertyMismatchGUId = false;
		 for(int p=1;p<totalrowcount;p++)
		  {
			  String currentPropertyGUIDFromUIToBeSplit = getAttribute(prepareWebElementWithDynamicXpath(ProductConfigUIMap.EntityPropertyGUId_HoverKey, String.valueOf(p), "int"),"title");
			  String[] currentPropertyGUIDFromUI= currentPropertyGUIDFromUIToBeSplit.split(":");
//			  //system.out.println(currentPropertyGUIDFromUI[1].trim());
			  String currentPropertyValueFromAPI = (String)currentPropertyGUId.get(p-1);
//			  //system.out.println(currentPropertyValueFromAPI);
//			  assertEquals(currentPropertyGUIDFromUI[1].trim(),currentPropertyValueFromAPI);
			  if(!currentPropertyGUIDFromUI[1].trim().contentEquals(currentPropertyValueFromAPI))
				 {
				  EntityPropertyMismatchGUId = true;
				 }
			 
		  }
		 if(EntityPropertyMismatchGUId) {
				Baseclass.getInstance();
				Baseclass.ClientNativeMatch.put(Entity+"_"+property, currentPropertyGUId);
			}
		 
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("issue verifying entity property GUID "+currentPropertyGUId + "for entity "+Entity);
		Assert.fail("issue verifying entity property GUID "+currentPropertyGUId + "for entity "+Entity);
	}
	
}



public static void verifyEntityPropertyGUIdForCategory(String property,int totalrowcount,List<Object> currentPropertyGUId){
	
	try{
		boolean EntityPropertyMismatchGUId = false;
		 for(int p=2;p<totalrowcount;p++)
		  {
			  String currentPropertyGUIDFromUIToBeSplit = getAttribute(prepareWebElementWithDynamicXpath(ProductConfigUIMap.EntityPropertyGUId_HoverKey, String.valueOf(p), "int"),"title");
			  String[] currentPropertyGUIDFromUI= currentPropertyGUIDFromUIToBeSplit.split(":");
//			  //system.out.println(currentPropertyGUIDFromUI[1].trim());
			  String currentPropertyValueFromAPI = (String)currentPropertyGUId.get(p-2);
//			  //system.out.println(currentPropertyValueFromAPI);
//			  assertEquals(currentPropertyGUIDFromUI[1].trim(),currentPropertyValueFromAPI);
			  if(!currentPropertyGUIDFromUI[1].trim().contentEquals(currentPropertyValueFromAPI))
				 {
				  EntityPropertyMismatchGUId = true;
				 }
			 
		  }
		 if(EntityPropertyMismatchGUId) {
				Baseclass.getInstance();
				Baseclass.ClientNativeMatch.put(Entity+"_"+property, currentPropertyGUId);
			}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("issue verifying entity property GUID "+currentPropertyGUId + "for entity "+Entity);
		Assert.fail("issue verifying entity property GUID "+currentPropertyGUId + "for entity "+Entity);
	}
	
}

public static void verifyEntityPropertyToggleButton(int totalrowcount){
	
	try{
		  for(int p=1;p<totalrowcount;p++)
		  {
			  String togglevalue = getAttribute(prepareWebElementWithDynamicXpath(ProductConfigUIMap.EntityPropertyToggle_btn, String.valueOf(p), "int"),"aria-pressed");
			  if(!togglevalue.equalsIgnoreCase("true"))
				  clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.EntityPropertyToggle_btn, String.valueOf(p), "int"));
			 
		  }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
	
public static void navigateToEntityPropertyTable(String EntityProperty){
	
	try{
		  if(!isSelected(prepareWebElementWithDynamicXpath(ProductConfigUIMap.MultiValuedField_checkbox, EntityProperty, "multivaluedField")))
			  clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.MultiValuedField_checkbox, EntityProperty, "multivaluedField"));
			  clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.EntityPropertyValues_checkbox, EntityProperty, "property"));
			  ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("issue navigating to "+EntityProperty+"for entity "+Entity);
		Assert.fail("issue navigating to "+EntityProperty+"for entity "+Entity);
	}
}

public static String getEntityUID(String Entity)
{
	try{
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		String EntityUid = "";
		 for(int i= 0; i<noOfColumns;i++)
		    {
		    	if(sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(Entity))
		    	{
		    		EntityUid=sheet.getRow(1).getCell(i).getStringCellValue();
		    		break;
		    	}
		    }
		 return EntityUid;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("Issue getting entityUID details from the excel");
		Assert.fail("Issue getting entityUID details from the excel");
	}
	return null;

}

public static String getWorkItemTypeUId(String Entity)
{
	try{
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		String WorkItemTypeUId = "";
		 for(int i= 0; i<noOfColumns;i++)
		    {
		    	if(sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(Entity))
		    	{
		    		WorkItemTypeUId=sheet.getRow(2).getCell(i).getStringCellValue();
		    		break;
		    	}
		    }
		 return WorkItemTypeUId;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("Issue getting workitemUID details from the excel");
		Assert.fail("Issue getting workitemUID details from the excel");
	}
	return null;

}
//gets all the multivalued fields for all the workitems for the given tool
	public static HashMap<String,ArrayList<String>> getMultiValuedFieldsFromExcel(String toolname)
	{
		try{
			 fis = new FileInputStream(new File(ClientNative_FileLoc));
				workbook = new XSSFWorkbook (fis);
				sheet = workbook.getSheet(toolname);
				int noOfColumns = sheet.getRow(0).getLastCellNum();
				int noofRows = sheet.getLastRowNum();
				HashMap<String,ArrayList<String>> listofEntities = new HashMap<String,ArrayList<String>>();
				for(int i= 1; i<noOfColumns;i++)
				{
					String entityname = sheet.getRow(0).getCell(i).getStringCellValue();
					ArrayList<String> listofentities = new ArrayList<>();
					for(int j=3;j<=noofRows;j++)
					{
						if(sheet.getRow(j).getCell(i).getStringCellValue().equalsIgnoreCase("Yes"))
							listofentities.add(sheet.getRow(j).getCell(0).getStringCellValue());
					}
					listofEntities.put(entityname,listofentities );
//					//system.out.println(entityname+" :"+ listofentities);
				}
		return listofEntities;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue fetching data from excel for the tool "+toolname);
			Assert.fail("Issue fetching data from excel for the tool "+toolname);
		}
		return null;

	}

	public static void SetfieldStatusinProdConfigPage(String fieldname, String enabledOrdisabled) {
		ScrollIntoView(ProductConfigUIMap.RealtimeConfig_input);
		clickJS(ProductConfigUIMap.RealtimeConfig_input);
		
	}

	public static void RemoveDeliveryConstructAssociationDetails(String toolname) {
		try{
			Thread.sleep(3000);
			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.ProductConfigPage_Section, "Delivery Construct Association", "sectionname"));
			Thread.sleep(2000);
			//select the client
			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.DCClientToSelect_StaticTxt, Property.getProperty("MyWizard_Client"), "clientname"));
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
			//select + icon to expand the client
			clickJS(prepareWebElementWithDynamicXpath(ProductConfigUIMap.PlusIconToExpandClientSelected_StaticTxt,Property.getProperty("MyWizard_Client"), "clientname"));
			
		if(toolname.equalsIgnoreCase("ADT JIRA") || toolname.equalsIgnoreCase("ADOP JIRA"))	
		{
			//check if L1 DC is selected/ticked
			WebElement checkbox_L1 = driver().findElement(prepareWebElementWithDynamicXpath(ProductConfigUIMap.checkL1DCcheckbox_checkbox, Property.getProperty("MyWizard_DC_L1"), "DCname"));
			if(checkbox_L1.isSelected())
			{
				//uncheck the selected DC
				clickJS(checkbox_L1);
			}
			else
			{
				click(prepareWebElementWithDynamicXpath(ProductConfigUIMap.checkL1DCcheckbox_checkbox, Property.getProperty("MyWizard_DC_L1"), "DCname"));
				//check if the project and board dropdowns have more than 0 options to select from
//					if((getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"))>0) && (getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedBoardValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"))>0))
				if((getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"))>0))
					{	
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"),Property.getProperty("ProductInstanceProject"));
					Thread.sleep(2000);
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedBoardValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"),Property.getProperty("Board_ID"));
					}
					else{
						logger.info("no data in dropdown to select from for L1 DC");
						Assert.fail("no data in dropdown to select from for L1 DC");
					}
	
			}
			
				
		}
		
		if(toolname.equalsIgnoreCase("Mywizard-TFS"))	
		{
			//check if L1 DC is selected/ticked
			WebElement checkbox_L1 = driver().findElement(prepareWebElementWithDynamicXpath(ProductConfigUIMap.checkL1DCcheckbox_checkbox, Property.getProperty("MyWizard_DC_L1"), "DCname"));
			if(checkbox_L1.isSelected())
			{
				clickJS(checkbox_L1);
				
			}
			else
			{
				click(prepareWebElementWithDynamicXpath(ProductConfigUIMap.checkL1DCcheckbox_checkbox, Property.getProperty("MyWizard_DC_L1"), "DCname"));
				//check if the project and board dropdowns have more than 0 options to select from
//					if((getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"))>0) && (getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedBoardValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"))>0))
				if((getDropdownCount(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"))>0))
					{	
					selectDropdownByText(prepareWebElementWithDynamicXpath(ProductConfigUIMap.getSelectedProjectValueFromDropDown_L1_DC_drpdown, Property.getProperty("MyWizard_DC_L1") , "DCname"),Property.getProperty("ProductInstanceProject"));
					
					}
					else{
						logger.info("no data in dropdown to select from for L1 DC");
						Assert.fail("no data in dropdown to select from for L1 DC");
					}
	
			}
		
		}
		}
		catch(Exception e)
		{
				e.printStackTrace();
				logger.info("Issue selecting the Delivery cosntruct association");
				Assert.fail("Issue selecting the Delivery cosntruct association");
		}
	
		
	}

	
}
