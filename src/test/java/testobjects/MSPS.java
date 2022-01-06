package testobjects;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.JavascriptExecutor;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Instant;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import uiMap.GenericUploaderUIMap;
import uiMap.MSPSUIMap;
import uiMap.MyWizardUIMap;
import utilities.general.Property;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.jcraft.jsch.Logger;

import groovyjarjarantlr4.v4.codegen.model.ExceptionClause;
public class MSPS {

		public static void CreateProject() {
			try {
				ExpWaitForCondition(MSPSUIMap.Search_Icon);
				
				clickJS(MSPSUIMap.Project_ribbon);
				ExpWaitForElementToDisappear(MSPSUIMap.Workingonit_text);
				ExpWaitForCondition(MSPSUIMap.NewProject_icon);
				clickJS(MSPSUIMap.NewProject_icon);
				clickJS(MSPSUIMap.EnterpriseProject_option);
				ExpWaitForElementToDisappear(MSPSUIMap.Workingonit_text);
				
	//Project Details are in Iframe so switching to Iframe			
				switchFrame(MSPSUIMap.Iframe);
				ExpWaitForCondition(MSPSUIMap.ProjectName_txtbox);
				String DeliveryPlanName=Tools.getWorkItemExternalID("DeliveryPlan", "MSPS");
				System.out.println(DeliveryPlanName);
				Baseclass.getInstance().WorkItemExternalId_DeliveryPlan=DeliveryPlanName;
				enterText(MSPSUIMap.ProjectName_txtbox,DeliveryPlanName);
				enterText(MSPSUIMap.Description_txtbox,DeliveryPlanName);
	//switching back to Default content
				switchDefault();
				clickJS(MSPSUIMap.Finish_btn);
				ExpWaitForElementToDisappear(MSPSUIMap.HoldOncreating_msg);
				ExpWaitForCondition(MSPSUIMap.Addtasks_text);
				
				Baseclass.getInstance().WorkItemExternalId_DeliveryPlan
				=DeliveryPlanName;
				
				logger.info("Project Created Sucessfully in MSPS");				
				
			}catch(Exception e) {
				e.printStackTrace();
				logger.info("Issue creating Project in MSPS");
				Assert.fail("Issue Creating Project in MSPS");
			}
			
		}

		public static void Enable() {
			try {
		//Enabling is neccessary for the Data created to flow
			ExpWaitForCondition(MSPSUIMap.ProjectDetails_option);
			clickJS(MSPSUIMap.ProjectDetails_option);
			ExpWaitForCondition(MSPSUIMap.BasicInfo_text);
			selectByPartOfVisibleText(MSPSUIMap.ACNPSelect_dropdown, "Yes");
			
			if(CheckIfElementExists(MSPSUIMap.Save_btn)) {
				clickJS(MSPSUIMap.Save_btn);
			}
			else {
				clickJS(MSPSUIMap.Project_ribbon);
				ExpWaitForElementToDisappear(MSPSUIMap.Workingonit_text);				
				singleClick(MSPSUIMap.Save_btn);
			}
			
			ExpWaitForCondition(MSPSUIMap.Savecomplete_toastermsg);
			logger.info("Enabling ACNP is Mywizard Project is a success");
			}
			catch(Exception e) {
				e.printStackTrace();
				logger.info("Enabling ACNP is Mywizard Project failed");
				Assert.fail("Enabling ACNP is Mywizard Project failed");
			}
			
		}

		public static void CreateEntities(String Entity) {
			try {
				clickJS(MSPSUIMap.Schedule_option);
				ExpWaitForCondition(MSPSUIMap.Addtasks_text);
				
		//Moving the Scroll to Right	
				WebElement DragandDrop=driver().findElement(MSPSUIMap.DragandDrop_line);				
		        Actions act=new Actions(driver());
		        act.dragAndDropBy(DragandDrop,75, 100).build().perform();	
		        act.dragAndDropBy(DragandDrop,75, 100).build().perform();
		        act.dragAndDropBy(DragandDrop,75, 100).build().perform();
		        act.dragAndDropBy(DragandDrop,75, 100).build().perform();
		        act.dragAndDropBy(DragandDrop,75, 100).build().perform();
			
			
			
		//Entities covered for MSPS
			String[] MSPS_Entities= {"Initiative","Release","Functional Area","Milestone","Deliverable"};			
			int Random_Number=RandomNumberGenerator();
			
		//loop for Entering Entity Details
			for (int i=0;i<MSPS_Entities.length;i++) {
				doubleClick(prepareWebElementWithDynamicXpath(MSPSUIMap.TaskName_textbox, Integer.toString(i+1), "row"));
				Thread.sleep(2000);
				String EntityName=MSPS_Entities[i]+Random_Number;
				EnterTextUsingJS(MSPSUIMap.TaskNameinput_textbox,EntityName);
				Thread.sleep(3000);
				singleClick(prepareWebElementWithDynamicXpath(MSPSUIMap.WorkType_Selection, Integer.toString(i+1), "row"));
				ExpWaitForCondition(MSPSUIMap.Worktypeselection_img);
				singleClick(MSPSUIMap.Worktypeselection_img);
				ExpWaitForCondition(MSPSUIMap.Srh_WorkType);
				enterText(MSPSUIMap.Srh_WorkType,MSPS_Entities[i]);	
				Thread.sleep(5000);
				
		//Selection of Work type	
				switch(MSPS_Entities[i]){
				case "Milestone":
					ExpWaitForCondition(MSPSUIMap.Criticalopt_formilestone);
					clickJS(MSPSUIMap.Criticalopt_formilestone);
					break;
				default:
					ExpWaitForCondition(prepareWebElementWithDynamicXpath(MSPSUIMap.Search_result, MSPS_Entities[i], "MSPS_Entities"));
					clickJS(prepareWebElementWithDynamicXpath(MSPSUIMap.Search_result, MSPS_Entities[i], "MSPS_Entities"));
				}
					
					

		//double single click is used since the double click is not working on UI for First row
					singleClick(prepareWebElementWithDynamicXpath(MSPSUIMap.ACNTYes_dropdown,  Integer.toString(i+1), "row"));
					singleClick(prepareWebElementWithDynamicXpath(MSPSUIMap.ACNTYes_dropdown,  Integer.toString(i+1), "row"));				
					Thread.sleep(3000);
					enterText(MSPSUIMap.YesOrNo_txtbox,"Yes");
					sendEntr();
					if(MSPS_Entities[i].equalsIgnoreCase("Initiative")){
						singleClick(prepareWebElementWithDynamicXpath(MSPSUIMap.ACNTYes_dropdown,  Integer.toString(i+1), "row"));
						singleClick(prepareWebElementWithDynamicXpath(MSPSUIMap.ACNTYes_dropdown,  Integer.toString(i+1), "row"));				
						Thread.sleep(3000);
						enterText(MSPSUIMap.YesOrNo_txtbox,"Yes");
						sendEntr();
					}
					
					
					
		//selection of Hierarchy	
					if(i!=0) {
						
						singleClick(prepareWebElementWithDynamicXpath(MSPSUIMap.TaskName_textbox, Integer.toString(i+1), "row"));
						Thread.sleep(4000);
						
						if((MSPS_Entities[i].equalsIgnoreCase("Deliverable"))){
							break;
						}							
						
						else {
						for(int j=1;j<=i;j++) {								
								clickJS(MSPSUIMap.SmallIndent_Img);
						}
						
					}
					}
					Thread.sleep(4000);
				//Workitem Name Updation in Baseclass
					switch(MSPS_Entities[i]){
						case "Initiative":
							Baseclass.getInstance().WorkItemExternalId_Initiative=EntityName;
							break;
						case "Release":
							Baseclass.getInstance().WorkItemExternalId_ReleaseName=EntityName;
							break;
						case "Functional Area":
							Baseclass.getInstance().WorkItemExternalId_FunctionalArea=EntityName;
							break;						
						case "Milestone":
							Baseclass.getInstance().WorkItemExternalId_Milestone=EntityName;
							break;
						
						case "Deliverable":
							Baseclass.getInstance().WorkItemExternalId_Deliverable=EntityName;
							break;
							
						
					}
					
					
				}	
			
			
			logger.info(Entity+" Created Successfully in in MSPS");
		}
				
			catch(Exception e) {
				e.printStackTrace();
				logger.info("Issue in Creating "+Entity+" in MSPS");
				Assert.fail("Issue in Creating "+Entity+" in MSPS");
			}
			
		}

		public static void PublishandClose() {
			try {
		//Order is Save, Baseline , publish and Close 
				
		//Save
				ExpWaitForCondition(MSPSUIMap.Save_btn);
				singleClick(MSPSUIMap.Save_btn);
				ExpWaitForElementToDisappear(MSPSUIMap.Processing_toastermsg);
				ExpWaitForCondition(MSPSUIMap.Savecomplete_toastermsg);
				Thread.sleep(4000);
		//Baseline
				singleClick(MSPSUIMap.SetBaseline_img);
				singleClick(MSPSUIMap.setbaseline_option);
				singleClick(MSPSUIMap.Baseline_option);
				ExpWaitForCondition(MSPSUIMap.SuccessBaseline_toastermsg);
				ExpWaitForCondition(MSPSUIMap.SuccessBaseline_toastermsg);
		//Publish
				singleClick(MSPSUIMap.Publish_img);
				ExpWaitForCondition(MSPSUIMap.PublishCompleted_toastermsg);
				ExpWaitForElementToDisappear(MSPSUIMap.PublishCompleted_toastermsg);
		
		//Close
				singleClick(MSPSUIMap.Close_img);
				Thread.sleep(2000);
				sendEntr(); 
				ExpWaitForElementToDisappear(MSPSUIMap.Processing_toastermsg);
				ExpWaitForElementToDisappear(MSPSUIMap.Checkin_toastermsg);
				
		//back to login Page
				ExpWaitForCondition(MSPSUIMap.Search_Icon);
				logger.info("Save,Baseline, Publish and Check In of Project completed successfully in MSPS");
				
				
			}catch(Exception e) {
				e.printStackTrace();
				logger.info("Issue in Save/Baseline/Publish/check-in in MSPS");
				Assert.fail("Issue in Save/Baseline/Publish/check-in in MSPS");
			}
			
		}	
}
