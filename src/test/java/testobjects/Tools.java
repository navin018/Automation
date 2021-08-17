package testobjects;
import java.io.File;
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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fasterxml.uuid.Generators;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import dataobjects.WorkItemDO;
import dataobjects.WorkItemExternalIDDO;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testobjects.Baseclass;
import uiMap.JiraUIMap;

import utilities.general.DataManager;
import utilities.general.Property;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;


	public class Tools extends Baseclass{
		private Baseclass base;
	
		public Tools()
		{
			
		}
		
		public Tools(Baseclass base) {
			this.base =base; 
		}
		
		public static String testDataPath = System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "testdata" + File.separator;

		
		
		public static void VerifyInBoundWorkitemDetails(String workitem, String toolname) {
			
			try{
				String WorkItemTypeUId="";
				String ReleaseName ="";
				String SprintName="";
				String WorkItemExternalId="";
				try{
					if(!(workitem.equalsIgnoreCase("ReleaseAndSprint") ))
						{
						WorkItemExternalId = getWorkItemExternalID(workitem,toolname);
//						System.out.println("workitem id from json file is "+WorkItemExternalId);
						String getWorkitemType = "WorkItemTypeUId_"+workitem;
						if(!(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("Team") || workitem.equalsIgnoreCase("TestCase") || workitem.equalsIgnoreCase("Action") || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request") ))
						 WorkItemTypeUId = Property.getProperty(getWorkitemType);
						
						}
				}catch(Exception e)
					{
						e.printStackTrace();
						logger.info("Could not get WorkItemExternalId for "+workitem+" for the tool "+toolname);
						Assert.fail("Could not get WorkItemExternalId for "+workitem+" for the tool "+toolname);
					}
				if(workitem.equalsIgnoreCase("ReleaseAndSprint"))
				{
					try{
//						String ReleaseDetails = getWorkItemExternalID("Release",toolname);
//						String SprintDetails =  getWorkItemExternalID("Sprint",toolname);
//					
//					String[] releasedetails = ReleaseDetails.toString().split("&");
//					String[] sprintdetails = SprintDetails.toString().split("&");
//					ReleaseName = releasedetails[0];
//					SprintName = sprintdetails[0];
//					WorkItemExternalId = ReleaseName+"&"+SprintName;
						WorkItemExternalId = "ReleaseAndSprint";
					}
					catch(Exception e)
					{
						e.printStackTrace();
						logger.info("Could not get ReleaseName or SprintName for "+workitem+" for the tool "+toolname);
						Assert.fail("Could not get ReleaseName or SprintName for "+workitem+" for the tool "+toolname);
					}
				}
				
					VerifyInboundWorkItemReponse(WorkItemTypeUId,WorkItemExternalId,toolname,workitem);
				}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Could not verify "+workitem+" for tool "+toolname+". ");
				Assert.fail("Could not verify "+workitem+" for tool "+toolname+". ");
			}
			}

public static String getWorkItemExternalID_custom(String workitem, String toolname,String functionality){
	
	try{
		String testDataPath_WorkItemExternalIDs="";
		if((toolname.equalsIgnoreCase("ADT Jira") || toolname.equalsIgnoreCase("ADOP Jira") || toolname.contains("Jira") || toolname.contains("JIRA")))
		{
			if(functionality.equalsIgnoreCase("ChangeProjectFromOne") || functionality.contains("Recon") || functionality.contains("DFT") || functionality.equalsIgnoreCase("DIY") || functionality.equalsIgnoreCase("normal") || functionality.contains("GenericUploader"))
				testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs.json" ;
			else if(functionality.equalsIgnoreCase("ChangeProjectToAnother"))
			testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDsForMoveProjOrIssue.json" ;
		}
		else if((toolname.equalsIgnoreCase("TFS Agile") || toolname.equalsIgnoreCase("TFS Scrum")))
		{
			if(functionality.equalsIgnoreCase("ChangeProjectFromOne") || functionality.contains("Recon") || functionality.equalsIgnoreCase("DIY") || functionality.equalsIgnoreCase("normal"))
				testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs.json" ;
			else if(functionality.equalsIgnoreCase("ChangeProjectToAnother"))
			testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDsForMoveProjOrIssue.json" ;
		}
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(testDataPath_WorkItemExternalIDs));
		JSONObject jsonObject = (JSONObject) obj;
		String WorkItemExternalId="";
		
		if(!(workitem.contains("Release") || workitem.contains("Sprint") || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request") ))
			WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_"+workitem);
		else if(workitem.equalsIgnoreCase("Test Execution"))
			WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_TestExecution");
		else if(workitem.equalsIgnoreCase("Work Request"))
			WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_WorkRequest");
		
		
		if(workitem.contains("Release") || workitem.contains("Sprint"))
		{
			WorkItemExternalId = (String) jsonObject.get("WorkItemExternalId_"+"ReleaseName");
			WorkItemExternalId = WorkItemExternalId + "&" + (String) jsonObject.get("WorkItemExternalId_"+"SprintName");
		}
		if(!workitem.equalsIgnoreCase("Team")) 
		{
			if(!(WorkItemExternalId.equalsIgnoreCase(null) || WorkItemExternalId.equals("")))
			 return WorkItemExternalId;
		 else{
				logger.info("Workitem "+workitem+" was not created for tool "+toolname);
			 Assert.fail("Workitem "+workitem+" was not created for tool "+toolname);
		 }
			if(workitem.equalsIgnoreCase("Team"))
				return (String) jsonObject.get("Team_Name"); 
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return "";
}	

public static String getWorkItemExternalID(String workitem, String toolname){
	
	try{
		String testDataPath = System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "testdata" + File.separator;
		
		String testDataPath_WorkItemExternalIDs="";
		if((toolname.equalsIgnoreCase("ADT Jira") || toolname.equalsIgnoreCase("ADOP Jira") || toolname.contains("Jira") || toolname.contains("JIRA")))
		{
			testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs.json" ;
		}
		if((toolname.equalsIgnoreCase("Rally")))
		{
			testDataPath_WorkItemExternalIDs = testDataPath + "Rally" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs.json" ;
		}
		else if((toolname.equalsIgnoreCase("TFS Agile") || toolname.equalsIgnoreCase("TFS Scrum") || toolname.contains("TFS")))
		{
			testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs.json" ;
		}
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(testDataPath_WorkItemExternalIDs));
		JSONObject jsonObject = (JSONObject) obj;
		String WorkItemExternalId="";
		
		if(!(workitem.equalsIgnoreCase("ReleaseAndSprint") || workitem.contains("Release") || workitem.contains("Sprint") || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request") || workitem.equalsIgnoreCase("ProductBacklog")))
			WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_"+workitem);
		else if(workitem.equalsIgnoreCase("Test Execution"))
			WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_TestExecution");
		else if(workitem.equalsIgnoreCase("Work Request"))
			WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_WorkRequest");
		else if(workitem.equalsIgnoreCase("ProductBacklog"))
			WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_Story");
	
		
		if(workitem.contains("Release") || workitem.contains("Sprint"))
		{
			WorkItemExternalId = (String) jsonObject.get("WorkItemExternalId_"+"ReleaseName");
			WorkItemExternalId = WorkItemExternalId + "&" + (String) jsonObject.get("WorkItemExternalId_"+"SprintName");
		}
		 if(!(WorkItemExternalId.equalsIgnoreCase(null) || WorkItemExternalId.equals("")))
			 return WorkItemExternalId;
		 else{
				logger.info("Workitem "+workitem+" was not created for tool "+toolname);
			 Assert.fail("Workitem "+workitem+" was not created for tool "+toolname);
		 }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return "";
}		
		
public static void VerifyOutBoundWorkitemDetails(String workitem, String toolname) {
			
			try{
				String WorkItemTypeUId=null;
				String WorkItemExternalId =getWorkItemExternalID(workitem,toolname);
				if(!(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("TestCase") || workitem.equalsIgnoreCase("Action") || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Milestone")  || workitem.equalsIgnoreCase("TestExecution") || workitem.equalsIgnoreCase("Work Request")))
				{
				String getWorkitemType = "WorkItemTypeUId_"+workitem;
				WorkItemTypeUId = Property.getProperty(getWorkitemType);
				}

					VerifyOutboundWorkItemReponse(WorkItemTypeUId,WorkItemExternalId,toolname,workitem);
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}
		
		public static void VerifyInboundWorkItemReponse(String WorkItemTypeUId, String WorkItemExternalId,String toolname,String workitem){
			
			try{
				
				 
				 String WorkItemOrDeliverableOrIterationOrTestOrRequirement="";
				 if(!(workitem.equalsIgnoreCase("Deliverable") || workitem.equalsIgnoreCase("ReleaseAndSprint")  || workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("Team") || workitem.equalsIgnoreCase("TestCase") || workitem.equalsIgnoreCase("Action") || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Milestone") || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request")))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="WorkItems"; 
				 if(workitem.equalsIgnoreCase("Deliverable"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Deliverables";
				 if(workitem.equalsIgnoreCase("ReleaseAndSprint"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Iterations";	
				 if(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("TestCase"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Tests";	
				 if(workitem.equalsIgnoreCase("Requirement"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Requirements";
				 if(workitem.equalsIgnoreCase("Team"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="DeliveryConstructsByDeliveryConstructType";
				 if(workitem.equalsIgnoreCase("Action"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Actions";		 
				 if(workitem.equalsIgnoreCase("Decision"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Decisions";	
				 if(workitem.equalsIgnoreCase("Milestone"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Milestones";
				 if(workitem.equalsIgnoreCase("Test Execution"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="TestResults";	
				 if(workitem.equalsIgnoreCase("Work Request"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="ChangeRequests";	
				 
				 Response response=null;
				 if(!workitem.equalsIgnoreCase("Work Request"))
				 response = PostRequesttoGetIBResponse(WorkItemTypeUId, WorkItemExternalId, workitem, "Flat", toolname);
				 else if(workitem.equalsIgnoreCase("Work Request"))
					 response = PostRequesttoGetIBResponse(WorkItemTypeUId, WorkItemExternalId, workitem, "NonFlat", toolname);
				 
				 JsonPath js = response.jsonPath();
				 
				 String responsebody = response.getBody().asString();
//				 System.out.println(responsebody);
				 
				 
				 String workitem_title="";
				 String ReleaseName="";
				 String ReleaseStartDate="";
				 String ReleaseEndDate="";
				 String SprintName="";
				 String SprintStartDate="";
				 String SprintEndDate="";
				 
				 
				 if(!(workitem.equalsIgnoreCase("ReleaseAndSprint") || workitem.equalsIgnoreCase("Team")))
				 workitem_title = getTitle(toolname, workitem);
				 if(workitem.equalsIgnoreCase("ReleaseAndSprint"))
				 {
//					 String[] ReleaseDates_sp = ReleaseDates.split("&");
//					 ReleaseStartDate = ReleaseDates_sp[0];
//					 ReleaseEndDate = ReleaseDates_sp[1];
//					 String ReleaseDates = getTitle(toolname,workitem);
					 HashMap<String,String>ReleaseAndSprintDetails= getReleaseAndSprintDetails(toolname);
					 ReleaseName = ReleaseAndSprintDetails.get("ReleaseName");
					 ReleaseStartDate = ReleaseAndSprintDetails.get("ReleaseStartDate");
					 ReleaseEndDate = ReleaseAndSprintDetails.get("ReleaseEndDate");
					 SprintName = ReleaseAndSprintDetails.get("SprintName");
					 SprintStartDate = ReleaseAndSprintDetails.get("SprintStartDate");
					 SprintEndDate = ReleaseAndSprintDetails.get("SprintEndDate");
				 }
				 
				 //cos field totalrecordcountdoesnt exists in Team
				 int totalrecordcount=0;
				 if(!workitem.equalsIgnoreCase("Team"))
					 totalrecordcount = js.get("TotalRecordCount");

				 
				 //Title validation for WorkItems
				 if(!(workitem.equalsIgnoreCase("ReleaseAndSprint") || workitem.equalsIgnoreCase("Team")))
				 {
				 String TitleFromAPI = js.getString(WorkItemOrDeliverableOrIterationOrTestOrRequirement+"[0].Title");
//				 System.out.println(TitleFromAPI);
//				 System.out.println(workitem_title);
				 if(!TitleFromAPI.equals(workitem_title))
					 logger.info("title mismatch for workitem "+workitem +" for the given tool "+toolname);
				 Assert.assertEquals(TitleFromAPI, workitem_title,"title mismatch for workitem "+workitem +" for the given tool "+toolname);
				
				 }
				 
				 
				 //DeliveryConstructUId for WorkItems 
				 List<Object> DCUid=null;
				 if(!(workitem.equalsIgnoreCase("Deliverable") || workitem.equalsIgnoreCase("ReleaseAndSprint") || workitem.equalsIgnoreCase("TestCase") || workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("Team") || workitem.equalsIgnoreCase("Action") || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Milestone") || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request")))
					 {
						 
					 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
					 DCUid = js.getList("WorkItems.WorkItemDeliveryConstructs.DeliveryConstructUId");
					 }
				 
				//DeliveryConstructUId for Deliverable 
				 if(workitem.equalsIgnoreCase("Deliverable"))
					 {
					 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
					 DCUid = js.getList("Deliverables.DeliverableDeliveryConstructs.DeliveryConstructUId");	
					 }
				 
				//DeliveryConstructUId for Test 
				 if(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("TestCase"))
				 {
					 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				 DCUid = js.getList("Tests.TestDeliveryConstructs.DeliveryConstructUId");	
				 }
				 //DCUid for Action
				 if(workitem.equalsIgnoreCase("Action"))
				 {
					 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				 DCUid = js.getList("Actions.ActionDeliveryConstructs.DeliveryConstructUId");	
				 }
				 if(workitem.equalsIgnoreCase("Decision"))
				 {
					 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				 DCUid = js.getList("Decisions.DecisionDeliveryConstructs.DeliveryConstructUId");	
				 }
				 if(workitem.equalsIgnoreCase("Milestone"))
				 {
					 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				 DCUid = js.getList("Milestones.MilestoneDeliveryConstructs.DeliveryConstructUId");	
				 }
				 if(workitem.equalsIgnoreCase("Test Execution"))
				 {
					 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				 DCUid = js.getList("TestResults.TestResultDeliveryConstructs.DeliveryConstructUId");	
				 }
				 if(workitem.equalsIgnoreCase("Work Request"))
				 {
					 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				 DCUid = js.getList("ChangeRequests.ChangeRequestDeliveryConstructs.DeliveryConstructUId");	
				 }
					//DeliveryConstructUId for Requirement 
				 if(workitem.equalsIgnoreCase("Requirement"))
				 {
					 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				 DCUid = js.getList("Requirements.RequirementDeliveryConstructs.DeliveryConstructUId");	
				 }
				 
					//DeliveryConstructUId for all workitems 
				 if(!(workitem.equalsIgnoreCase("ReleaseAndSprint") || workitem.equalsIgnoreCase("Team")))
				 Assert.assertTrue(DCUid.toString().contains(Property.getProperty("DeliveryConstructUId_L2")),workitem+" is not associated to the required DCUId for tool "+toolname);
				 
				 if(workitem.equalsIgnoreCase("Team"))
				 {
					 
				String teamnames = js.getList("DeliveryConstructs.DeliveryStructures.Name").toString();
				 Assert.assertTrue(teamnames.contains(WorkItemExternalId),workitem+" is not flown tool "+toolname);
//				System.out.println(teamnames);
				 }
			
				 //ReleaseName, ReleaseStartDate and ReleaseEndDate Validation
				 try{
					 if(workitem.equalsIgnoreCase("ReleaseAndSprint"))
						 {
							 int size = response.jsonPath().getInt("Iterations.size()");
//							 System.out.println(size);
							 
							 boolean releasefound = false;
							 boolean sprintfound = false;
							 for(int p=0; p<size;p++)
							 {
								 
								 String name = response.jsonPath().getString("Iterations[" + p + "].Name");
								 if(name.equalsIgnoreCase(ReleaseName))
								 
								 {
									 releasefound=true;
//									 captureIterationExternalID_ReleaseAndSprint("Release",response.jsonPath(),p,toolname);
									 String ReleaseStartDateFromAPI = response.jsonPath().getString("Iterations[" + p + "].StartOn");
									 String ReleaseEndDateFromAPI = response.jsonPath().getString("Iterations[" + p + "].EndOn");
									 CompareReleaseSprintDate(ReleaseStartDateFromAPI,ReleaseStartDate,toolname);
									 CompareReleaseSprintDate(ReleaseEndDateFromAPI,ReleaseEndDate,toolname);
									 break;
								 }
						
							 }
							 
							 for(int p=0; p<size;p++)
							 {
								 
								 String name = response.jsonPath().getString("Iterations[" + p + "].Name");
								 if(name.equalsIgnoreCase(SprintName))
								 
								 {
									 sprintfound=true;
									 String SprintStartDateFromAPI = response.jsonPath().getString("Iterations[" + p + "].StartOn");
									 String SprintEndDateFromAPI = response.jsonPath().getString("Iterations[" + p + "].EndOn");
									 CompareReleaseSprintDate(SprintStartDateFromAPI,SprintStartDate,toolname);
									 CompareReleaseSprintDate(SprintEndDateFromAPI,SprintEndDate,toolname);
									 break;
								 }
						
							 }

							 SoftAssert sa = new SoftAssert();
							 if(!releasefound){
								 sa.assertEquals(releasefound, true,"Release not flown for "+toolname);
								 }
							
							 if(!sprintfound){
								 sa.assertEquals(sprintfound, true,"Sprint not flown for "+toolname);
							 }
						
							 sa.assertAll();
									 
						 }
				 }
					 catch(Exception e)
					 {
						e.printStackTrace();
						logger.info("Issue verfying release/sprint for tool "+toolname);
						Assert.fail("Issue verfying release/sprint for tool "+toolname);
					 
					 }
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Issue verfying IB response for "+workitem+ " for toolname "+toolname);
				Assert.fail("Issue verfying IB response for "+workitem+ " for toolname "+toolname);
			}
		}
		
		
//private static void captureIterationExternalID_ReleaseAndSprint(String ReleaseOrSprint, JsonPath jsonPath, int p,String toolname) {
		private static void captureIterationExternalID_ReleaseAndSprint(String ReleaseOrSprint, String IterationExternalID,String toolname) {
	try{
	String testDataPath_WorkItemExternalIDs="";
//	System.out.println(jsonPath.getString("Iterations[" + p + "].IterationProductInstances.IterationExternalId[1]").toString());
//	String IterationExternalID = null;
//	if(ReleaseOrSprint.equalsIgnoreCase("Release"))
//	IterationExternalID = jsonPath.getString("Iterations[" + p + "].IterationProductInstances.IterationExternalId[1]").toString();
//	if(ReleaseOrSprint.equalsIgnoreCase("Sprint"))
//	IterationExternalID = jsonPath.getString("Iterations[" + p + "].IterationProductInstances.IterationExternalId").toString();
//	IterationExternalID = IterationExternalID.substring(1, IterationExternalID.length() - 1);
//    IterationExternalID ="\""+IterationExternalID+"\"";
			if(toolname.contains("Jira") || toolname.contains("JIRA")){
				testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
			}
			else if(toolname.contains("TFS") || toolname.contains("Tfs")){
				testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
			}
			FileReader reader = new FileReader(testDataPath_WorkItemExternalIDs);

	        JSONParser jsonParser = new JSONParser();
	        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
	        if(ReleaseOrSprint.equalsIgnoreCase("Release"))
	        jsonObject.put("IterationExternalID_Release",IterationExternalID);
	        else if(ReleaseOrSprint.equalsIgnoreCase("Sprint"))
	        jsonObject.put("IterationExternalID_Sprint",IterationExternalID);
	        FileOutputStream outputStream = new FileOutputStream(testDataPath_WorkItemExternalIDs);
			 byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
	        
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.info("issue capturing IterationExternalID for tool "+toolname);
	}
	
		}

public static HashMap<String, String> getReleaseAndSprintDetails(String toolname) {
	try{
		String testDataPath_WorkItemExternalIDs="";
		if(toolname.contains("Jira") || toolname.contains("JIRA")){
			testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
		}
		else if(toolname.contains("TFS") || toolname.contains("Tfs")){
			testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
		}
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(testDataPath_WorkItemExternalIDs));
		JSONObject jsonObject = (JSONObject) obj;
		
			String ReleaseName = (String) jsonObject.get("WorkItemExternalId_"+"ReleaseName");
			String ReleaseStartDate = (String) jsonObject.get("WorkItemExternalId_"+"ReleaseStartDate");
			String ReleaseEndDate = (String) jsonObject.get("WorkItemExternalId_"+"ReleaseEndDate");
			String SprintName = (String) jsonObject.get("WorkItemExternalId_"+"SprintName");
			String SprintStartDate = ((String) jsonObject.get("WorkItemExternalId_"+"SprintStartDate"));
			String SprintEndDate = (String) jsonObject.get("WorkItemExternalId_"+"SprintEndDate");
			String ReleaseNameFromRMP = (String) jsonObject.get("ReleaseName_FromRMP");
			String SprintNameFromRMP = (String) jsonObject.get("SprintName_FromRMP");
		HashMap<String,String> ReleaseAndSprintDetails = new HashMap<>();
		ReleaseAndSprintDetails.put("ReleaseName", ReleaseName);
		ReleaseAndSprintDetails.put("ReleaseStartDate", ReleaseStartDate);
		ReleaseAndSprintDetails.put("ReleaseEndDate", ReleaseEndDate);
		ReleaseAndSprintDetails.put("SprintName", SprintName);
		ReleaseAndSprintDetails.put("ReleaseNameFromRMP", ReleaseNameFromRMP);
		ReleaseAndSprintDetails.put("SprintNameFromRMP", SprintNameFromRMP);
		if(toolname.contains("Jira") || toolname.contains("JIRA")){
			if(!toolname.equalsIgnoreCase("ADOP Jira")){
		ReleaseAndSprintDetails.put("SprintStartDate", SprintStartDate.split(" ")[0]);
		ReleaseAndSprintDetails.put("SprintEndDate", SprintEndDate.split(" ")[0]);
			}
		}
		else if(toolname.contains("TFS")){
			ReleaseAndSprintDetails.put("SprintStartDate", SprintStartDate);
			ReleaseAndSprintDetails.put("SprintEndDate", SprintEndDate);
			
		}
		return ReleaseAndSprintDetails;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;

			
		}



public static Response PostRequesttoGetIBResponse(String WorkItemTypeUId,String WorkItemExternalId,String workitem,String FlatNonFlarURL,String toolname){
	try{
	RequestSpecification request = RestAssured.given();
 	
	 request.header("Content-Type", "application/json")
	        .header("Authorization","Bearer "+Property.getToken("Token"))
	        .header("AppServiceUId",Property.getProperty("AppServiceUId"));
	 
	 JSONObject requestParams = new JSONObject();
	 
	 String PostUrl="";
	 String mywizURL = Property.getProperty("MyWizard_URL");
	 String[] mywizURL_Sp = mywizURL.split(".com");
	 mywizURL = mywizURL_Sp[0]+".com/core";
	 mywizURL = mywizURL.replace("mywizard", "mywizardapi");
	 String WorkItemOrDeliverableOrIterationOrTestOrRequirement="";
	 
	 if(WorkItemExternalId.equalsIgnoreCase(null) || WorkItemExternalId.equalsIgnoreCase(""))
			Assert.fail("WorkItem "+workitem+ " not created for tool "+toolname);
	 
	 if(!(workitem.equalsIgnoreCase("Deliverable") || workitem.equalsIgnoreCase("ReleaseAndSprint")  || workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement")  || workitem.equalsIgnoreCase("Team") || workitem.equalsIgnoreCase("TestCase") || workitem.equalsIgnoreCase("Action") || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Milestone") || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request")))
	 {
	 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
	 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
	 requestParams.put("WorkItemTypeUId",WorkItemTypeUId);
	//if WorkItemExternalId is equals to null, assert fail
	 requestParams.put("WorkItemExternalId", WorkItemExternalId);
	
	 WorkItemOrDeliverableOrIterationOrTestOrRequirement="WorkItems";
					 
	
//	String NonFlat_url = mywizURL+"/v1/WorkItems/Query?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L1")+"&includeCompleteHierarchy=false";
//	String url1 = "https://mywizardapi-devtest-lx.aiam-dh.com/core/v1/WorkItems/Query/flat?clientUId=00100000-0000-0000-0000-000000000000&deliveryConstructUId=9b733b7c-2591-4116-b9fd-85b500400643&includeCompleteHierarchy=false";
	
	 }
	 if(workitem.equalsIgnoreCase("Deliverable") )
	 {
		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
		 requestParams.put("DeliverableExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Deliverables";				 
	 }
	 if(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("TestCase")  )
	 {
		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
		 requestParams.put("TestExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Tests";				 
	 }
//	 if(workitem.equalsIgnoreCase("TestCase")  )
//	 {
//		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
//		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
//		 requestParams.put("TestExternalId",WorkItemExternalId);
//		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Test1";				 
//	 }
	 if(workitem.equalsIgnoreCase("Requirement") )
	 {
		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
		 requestParams.put("RequirementExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Requirements";				 
	 }
	 if(workitem.equalsIgnoreCase("ReleaseAndSprint"))
	 {
		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Iterations";	
	 }
	 if(workitem.equalsIgnoreCase("Team"))
	 {
		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="DeliveryConstructsByDeliveryConstructType";	
	 }
	 if(workitem.equalsIgnoreCase("Action"))
	 {
		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
		 requestParams.put("ActionExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Actions";
	 }
	 
	 if(workitem.equalsIgnoreCase("Decision"))
	 {
		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
		 requestParams.put("DecisionExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Decisions";
	 }
	 if(workitem.equalsIgnoreCase("Milestone"))
	 {
		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
		 requestParams.put("MilestoneExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Milestones";
	 }
	 
	 if(workitem.equalsIgnoreCase("Test Execution"))
	 {
		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
		 requestParams.put("TestResultExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="TestResults";
	 }
	
	 if(workitem.equalsIgnoreCase("Work Request"))
	 {
		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
		 requestParams.put("ChangeRequestExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="ChangeRequests";
		 													  
	 }
	 
	 request.body(requestParams.toJSONString());
	 String QueryType="";
	 if(FlatNonFlarURL.equalsIgnoreCase("Flat"))
		 QueryType = "Query/Flat";
	 if(FlatNonFlarURL.equalsIgnoreCase("NonFlat"))
		 QueryType = "Query";
	 if(!workitem.equalsIgnoreCase("Team"))
	 PostUrl = mywizURL+"/v1/"+WorkItemOrDeliverableOrIterationOrTestOrRequirement+"/"+QueryType+"?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
//		 PostUrl = mywizURL+"/v1/"+WorkItemOrDeliverableOrIterationOrTestOrRequirement+"/"+"?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
	 if(workitem.equalsIgnoreCase("Team"))
		 PostUrl = mywizURL+"/v1/"+WorkItemOrDeliverableOrIterationOrTestOrRequirement+"?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId=null&deliveryConstructTypeUId=00200020-0000-0000-0000-000000000000";
	
	 Response response=null;
	 if(!workitem.equalsIgnoreCase("Team"))	
	 response = request.post(PostUrl);
	 else if(workitem.equalsIgnoreCase("Team"))
		 response = request.get(PostUrl); 
	 System.out.println(response.getBody().asString());
	 if(response.getStatusCode()!=200)
	 {
		 if(response.getStatusCode()==401)
			 logger.info("Got "+response.getStatusCode()+" reponse code for "+workitem+" for the given tool "+toolname);
//			 Assert.fail("Got "+response.getStatusCode()+" reponse code for "+workitem+" for the given tool "+toolname + " please refresh the token");
			Assert.fail("Got "+response.getStatusCode()+" reponse code for "+workitem+" for the given tool "+toolname);
	 }
	 Assert.assertEquals(response.getStatusCode(), 200);
	 
	 
	 if(!(workitem.equalsIgnoreCase("ReleaseAndSprint") || workitem.equalsIgnoreCase("Team") ))
	 {
		 int totalrecordcount = response.jsonPath().get("TotalRecordCount");
		 Assert.assertEquals(totalrecordcount, 1,workitem+ " not flown for IB "+toolname);	
	 }
	

	 
//	 JsonPath js = response.jsonPath();
	 
//	 String responsebody = response.getBody().asString();
//	 System.out.println(responsebody);
	 
	
	 return response;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}		


public static Response PostRequesttoGetIBResponse_custom(String WorkItemTypeUId,String WorkItemExternalId,String workitem,String FlatNonFlarURL,String toolname,String functionality){
	try{
	RequestSpecification request = RestAssured.given();
 	
	 request.header("Content-Type", "application/json")
	        .header("Authorization","Bearer "+Property.getToken("Token"))
	        .header("AppServiceUId",Property.getProperty("AppServiceUId"));
	 
	 JSONObject requestParams = new JSONObject();
	 
	 String PostUrl="";
	 String mywizURL = Property.getProperty("MyWizard_URL");
	 String[] mywizURL_Sp = mywizURL.split(".com");
	 mywizURL = mywizURL_Sp[0]+".com/core";
	 mywizURL = mywizURL.replace("mywizard", "mywizardapi");
	 String WorkItemOrDeliverableOrIterationOrTestOrRequirement="";
	 
	if(!workitem.contains("Team"))
	 if(WorkItemExternalId.equalsIgnoreCase(null) || WorkItemExternalId.equalsIgnoreCase(""))
			Assert.fail("WorkItem "+workitem+ " not created for tool "+toolname);
	 
	 String DCUid="";
	 if(functionality.equalsIgnoreCase("ChangeProjectFromOne") || functionality.contains("Recon") || functionality.equalsIgnoreCase("DFT") || functionality.equalsIgnoreCase("DIY")  || functionality.equalsIgnoreCase("normal") || functionality.equalsIgnoreCase("GenericUploader") || functionality.equalsIgnoreCase("GenericUploader_MyWizardInstance"))
	 {
		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
		 if(functionality.equalsIgnoreCase("DIY"))
		 {
			 DCUid = getDCUid(toolname,functionality);
			 requestParams.put("DeliveryConstructUId", DCUid);
			 if(WorkItemExternalId.contains("Release"))
				 requestParams.put("IterationExternalID", Baseclass.getInstance().release_IterationExternalID);
			 if(WorkItemExternalId.contains("Sprint"))
				 requestParams.put("IterationExternalID", Baseclass.getInstance().sprint_IterationExternalID);
//			 if(workitem.equalsIgnoreCase("Release") || workitem.equalsIgnoreCase("Sprint"))
//			 {
//				 requestParams.put("DeliveryConstructUId", DCUid);
//			 }
		 }
		 else{
			 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
			 if(WorkItemExternalId.contains("Release"))
				 requestParams.put("IterationExternalID", Baseclass.getInstance().release_IterationExternalID);
			 if(WorkItemExternalId.contains("Sprint"))
				 requestParams.put("IterationExternalID", Baseclass.getInstance().sprint_IterationExternalID);
		 }
	 }
	 else if(functionality.equalsIgnoreCase("GenericUploader_NoTool"))
	 {
		 requestParams.put("ClientUId", Property.getProperty("NoToolInstance_ClientUId"));  
		 requestParams.put("DeliveryConstructUId", Property.getProperty("NoToolInstance_DeliveryConstructUId_L2"));  
	 }
	 
	 
	  else if(functionality.equalsIgnoreCase("ChangeProjectToAnother"))
	 {
		 requestParams.put("ClientUId", Property.getProperty("ClientUId_DeleteFunctionality")); 
		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_DeleteFunctionality"));
	 }
	 if(!(workitem.equalsIgnoreCase("Deliverable") || workitem.contains("Release") ||  workitem.contains("Sprint") || workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement")  || workitem.equalsIgnoreCase("Team") || workitem.equalsIgnoreCase("TestCase") || workitem.equalsIgnoreCase("Action") || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Milestone") || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request")))
	 {
	 requestParams.put("WorkItemTypeUId",WorkItemTypeUId);
	//if WorkItemExternalId is equals to null, assert fail
	 requestParams.put("WorkItemExternalId", WorkItemExternalId);
	
	 WorkItemOrDeliverableOrIterationOrTestOrRequirement="WorkItems";
					 
	
	
	 }
	 if(workitem.equalsIgnoreCase("Deliverable") )
	 {
		 requestParams.put("DeliverableExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Deliverables";				 
	 }
	 if(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("TestCase")  )
	 {
		 requestParams.put("TestExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Tests";				 
	 }

	 if(workitem.equalsIgnoreCase("Requirement") )
	 {
		 requestParams.put("RequirementExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Requirements";				 
	 }
	 if((workitem.contains("Release") || workitem.contains("Sprint")))
	 {
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Iterations";	
	 }
	 if(workitem.equalsIgnoreCase("Team"))
	 {
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="DeliveryConstructsByDeliveryConstructType";	
	 }
	 if(workitem.equalsIgnoreCase("Action"))
	 {
		 requestParams.put("ActionExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Actions";
	 }
	 
	 if(workitem.equalsIgnoreCase("Decision"))
	 {
		 requestParams.put("DecisionExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Decisions";
	 }
	 if(workitem.equalsIgnoreCase("Milestone"))
	 {
		 requestParams.put("MilestoneExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Milestones";
	 }
	 
	 if(workitem.equalsIgnoreCase("Test Execution"))
	 {
		 requestParams.put("TestResultExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="TestResults";
	 }
	 
	 if(workitem.equalsIgnoreCase("Work Request"))
	 {
		 requestParams.put("ChangeRequestExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="ChangeRequests";
	 }
	
	 
	 request.body(requestParams.toJSONString());
	 String QueryType="";
	 if(FlatNonFlarURL.equalsIgnoreCase("Flat"))
		 QueryType = "Query/Flat";
	 if(FlatNonFlarURL.equalsIgnoreCase("NonFlat"))
		 QueryType = "Query";
	 String ClientUId="";
	 String deliveryConstructUId="";
	 if(functionality.equalsIgnoreCase("ChangeProjectToAnother"))
	 {
		 ClientUId=Property.getProperty("ClientUId_DeleteFunctionality");
		deliveryConstructUId=Property.getProperty("DeliveryConstructUId_DeleteFunctionality");
	 }
	 else if(functionality.equalsIgnoreCase("ChangeProjectFromOne") || functionality.contains("Recon") || functionality.equalsIgnoreCase("DFT")  || functionality.equalsIgnoreCase("normal") || functionality.equalsIgnoreCase("GenericUploader") || functionality.equalsIgnoreCase("GenericUploader_MyWizardInstance"))
	 {
		 ClientUId=Property.getProperty("ClientUId");
			deliveryConstructUId=Property.getProperty("DeliveryConstructUId_L2");
	 }
	 else if(functionality.equalsIgnoreCase("DIY"))
	 {
		 ClientUId=Property.getProperty("ClientUId");
		 deliveryConstructUId=DCUid;
	 }
	 else if(functionality.equalsIgnoreCase("GenericUploader_NoTool"))
	 {
		 ClientUId=Property.getProperty("NoToolInstance_ClientUId");
		 deliveryConstructUId=Property.getProperty("NoToolInstance_DeliveryConstructUId_L2");;
	 }
	 if(!workitem.equalsIgnoreCase("Team"))
		 PostUrl = mywizURL+"/v1/"+WorkItemOrDeliverableOrIterationOrTestOrRequirement+"/"+QueryType+"?clientUId="+ClientUId+"&deliveryConstructUId="+deliveryConstructUId+"&includeCompleteHierarchy=true";
//		 PostUrl = mywizURL+"/v1/"+WorkItemOrDeliverableOrIterationOrTestOrRequirement+"/"+"?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
	 if(workitem.equalsIgnoreCase("Team"))
		 PostUrl = mywizURL+"/v1/"+WorkItemOrDeliverableOrIterationOrTestOrRequirement+"?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId=null&deliveryConstructTypeUId=00200020-0000-0000-0000-000000000000";
	
	 Response response=null;
	 if(!workitem.equalsIgnoreCase("Team"))	
	 response = request.post(PostUrl);
	 else if(workitem.equalsIgnoreCase("Team"))
		 response = request.get(PostUrl); 
	 System.out.println(response.getBody().asString());
	 if(response.getStatusCode()!=200)
	 {
		 if(response.getStatusCode()==401)
			 logger.info("Got "+response.getStatusCode()+" reponse code for "+workitem+" for the given tool "+toolname);
//			 Assert.fail("Got "+response.getStatusCode()+" reponse code for "+workitem+" for the given tool "+toolname + " please refresh the token");
			Assert.fail("Got "+response.getStatusCode()+" reponse code for "+workitem+" for the given tool "+toolname);
	 }
	 Assert.assertEquals(response.getStatusCode(), 200);
	 
	 
	 if(!(workitem.contains("Release") ||workitem.contains("Sprint") || workitem.equalsIgnoreCase("Team") ))
	 {
		 int totalrecordcount = response.jsonPath().get("TotalRecordCount");
//		 Assert.assertEquals(totalrecordcount, 1,workitem+ " not flown for IB "+toolname);	
	 }
	 return response;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}		

public static String getDCUid(String toolname, String functionality) {
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
				return ((String) jsonObject.get("DCUid"));
			}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
	
}

public static void 	putOutBoundBodyInTempFile(String responsebody){
	
	try{
		 String temprepsonsefile= System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator	+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" +  File.separator + "ResponseFile_Temp.json";
		 FileWriter filetowrite = new FileWriter(temprepsonsefile);
		 filetowrite.write(responsebody);
		 filetowrite.flush();
		 filetowrite.close();
    
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
}	

public static String getTitle(String toolname,String workitem){
	
	try{
		
		String testDataPath_WorkItem="";
		WorkItemDO  wi ;
			if(toolname.equalsIgnoreCase("ADT JIRA") || toolname.equalsIgnoreCase("ADOP JIRA"))
			{
				testDataPath_WorkItem = testDataPath + "Jira" + File.separator + "JSON" +  File.separator  ;
			}
			if(toolname.equalsIgnoreCase("TFS Agile") || toolname.equalsIgnoreCase("TFS Scrum"))
			{
				testDataPath_WorkItem = testDataPath + "TFS" + File.separator + "JSON" +  File.separator  ;
			}
			if(!(workitem.equalsIgnoreCase("ReleaseAndSprint") || workitem.equalsIgnoreCase("WorkRequest")))
			{
			 wi = DataManager.getData(testDataPath_WorkItem, "WorkItem",WorkItemDO.class).item.get(workitem+"_01");
			return wi.Summary;
			}
			else if(workitem.equalsIgnoreCase("WorkRequest"))
			{
				wi = DataManager.getData(testDataPath_WorkItem, "WorkItem",WorkItemDO.class).item.get("Work Request"+"_01");
			}
			else if(workitem.equalsIgnoreCase("Test Execution") && toolname.contains("TFS"))
			{
				String testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs.json" ;
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader(testDataPath_WorkItemExternalIDs));
				JSONObject jsonObject = (JSONObject) obj;
				return "Run "+(String) jsonObject.get("RunID")+ " - "+(String) jsonObject.get("WorkItemExternalId_TestPlan")+" (Manual) / "+(String) jsonObject.get("WorkItemExternalId_TestCase_TE");
			}
			else if(workitem.equalsIgnoreCase("ReleaseAndSprint"))
			{
			 wi = DataManager.getData(testDataPath_WorkItem, "WorkItem",WorkItemDO.class).item.get("Release_01");
			String ReleaseStartDate=wi.ReleaseStartDate;
			 String ReleaseEndDate=wi.ReleaseEndDate;
			 String releaseDates = ReleaseStartDate+"&"+ReleaseEndDate;
			 return releaseDates;
			}

		}
	catch(Exception e)
		{
			e.printStackTrace();
		}
	return "";
}

public static String checkIfTeamVerificationRequired(String toolname,String workitem){
	
	try{
		
		String testDataPath_WorkItem="";
		WorkItemDO  wi ;
			if(toolname.equalsIgnoreCase("ADT JIRA") || toolname.equalsIgnoreCase("ADOP JIRA"))
			{
				testDataPath_WorkItem = testDataPath + "Jira" + File.separator + "JSON" +  File.separator  ;
			}
			if(toolname.equalsIgnoreCase("TFS Agile") || toolname.equalsIgnoreCase("TFS Scrum"))
			{
				testDataPath_WorkItem = testDataPath + "TFS" + File.separator + "JSON" +  File.separator  ;
			}
			
			 wi = DataManager.getData(testDataPath_WorkItem, "WorkItem",WorkItemDO.class).item.get(workitem.split("_")[0]+"_TeamVerify");
			if(!(wi==null))
				return wi.TeamVerify;
			else{
				logger.info("Ignore Team verification for workitem "+workitem);
				return "NA";
			}
			}
	catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue getting team verification details required from JSON file");
		}
	return "NA";

}
public static String PrepareOutBoundBodyWithRequiredDataAndGetCorrelationID(String toolname,String workitem)
{
	try{
		String temprepsonsefile= System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator	+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" +  File.separator + "ResponseFile_Temp.json";
		Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
				   .mappingProvider(new JacksonMappingProvider()).build();
		   
         File filetoread = new File(temprepsonsefile);
         
		   DocumentContext json = com.jayway.jsonpath.JsonPath.using(configuration).parse(filetoread);
		  File file = new File(temprepsonsefile);
		  	
		  
		  	DocumentContext finaljson=null;
		  	UUID GUid = Generators.timeBasedGenerator().generate();
		  	if(!(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("Deliverable") || workitem.equalsIgnoreCase("TestCase") || workitem.equalsIgnoreCase("Action") || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Milestone")  || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request") ))
		  			{
		   finaljson = json.set("WorkItems[0].CorrelationUId", GUid.toString());
		   finaljson = json.set("WorkItems[0].ItemState", 1);
//		   finaljson = json.set("WorkItems[0].CreatedByApp", "myWizard.IssueManagement");
//		   finaljson = json.set("WorkItems[0].ModifiedByApp", "myWizard.IssueManagement");
		   finaljson = json.set("WorkItems[0].CreatedByApp", "myWizard.RequirementsManagement");
		   finaljson = json.set("WorkItems[0].ModifiedByApp", "myWizard.RequirementsManagement");
		   finaljson = json.set("WorkItems[0].WorkItemAttributes[0].Value", getTitle(toolname,workitem)+"_OB");
		   finaljson = json.set("WorkItems[0].ModifiedAtSourceOn", (new Random().nextInt(2)+2024+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(12)+1)))+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(28)+1)))+"T18:48:07.6972433"));
		  			}
		  	if((workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("TestCase")))
		  			{
		   finaljson = json.set("Tests[0].CorrelationUId", GUid.toString());
		   finaljson = json.set("Tests[0].ItemState", 1);
//		   finaljson = json.set("Tests[0].CreatedByApp", "myWizard.IssueManagement");
//		   finaljson = json.set("Tests[0].ModifiedByApp", "myWizard.IssueManagement");
		   finaljson = json.set("Tests[0].CreatedByApp", "myWizard.RequirementsManagement");
		   finaljson = json.set("Tests[0].ModifiedByApp", "myWizard.RequirementsManagement");
		   finaljson = json.set("Tests[0].Title", getTitle(toolname,workitem)+"_OB");
		   finaljson = json.set("Tests[0].ModifiedAtSourceOn", (new Random().nextInt(2)+2024+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(12)+1)))+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(28)+1)))+"T18:48:07.6972433"));
		  			}
		  	
			if((workitem.equalsIgnoreCase("Action")))
  			{
		   finaljson = json.set("Actions[0].CorrelationUId", GUid.toString());
		   finaljson = json.set("Actions[0].ItemState", 1);
//		   finaljson = json.set("Actions[0].CreatedByApp", "myWizard.IssueManagement");
//		   finaljson = json.set("Actions[0].ModifiedByApp", "myWizard.IssueManagement");
		   finaljson = json.set("Actions[0].CreatedByApp", "myWizard.RequirementsManagement");
		   finaljson = json.set("Actions[0].ModifiedByApp", "myWizard.RequirementsManagement");
		   finaljson = json.set("Actions[0].Title", getTitle(toolname,workitem)+"_OB");
		   finaljson = json.set("Actions[0].ModifiedAtSourceOn", (new Random().nextInt(2)+2024+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(12)+1)))+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(28)+1)))+"T18:48:07.6972433"));
  			}
			
			if((workitem.equalsIgnoreCase("Decision")))
  			{
		   finaljson = json.set("Decisions[0].CorrelationUId", GUid.toString());
		   finaljson = json.set("Decisions[0].ItemState", 1);
//		   finaljson = json.set("Decisions[0].CreatedByApp", "myWizard.IssueManagement");
//		   finaljson = json.set("Decisions[0].ModifiedByApp", "myWizard.IssueManagement");
		   finaljson = json.set("Decisions[0].CreatedByApp", "myWizard.RequirementsManagement");
		   finaljson = json.set("Decisions[0].ModifiedByApp", "myWizard.RequirementsManagement");
		   finaljson = json.set("Decisions[0].Title", getTitle(toolname,workitem)+"_OB");
		   finaljson = json.set("Decisions[0].ModifiedAtSourceOn", (new Random().nextInt(2)+2024+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(12)+1)))+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(28)+1)))+"T18:48:07.6972433"));
  			}
			
			if((workitem.equalsIgnoreCase("Milestone")))
  			{
		   finaljson = json.set("Milestones[0].CorrelationUId", GUid.toString());
		   finaljson = json.set("Milestones[0].ItemState", 1);
//		   finaljson = json.set("Milestones[0].CreatedByApp", "myWizard.IssueManagement");
//		   finaljson = json.set("Milestones[0].ModifiedByApp", "myWizard.IssueManagement");
		   finaljson = json.set("Milestones[0].CreatedByApp", "myWizard.RequirementsManagement");
		   finaljson = json.set("Milestones[0].ModifiedByApp", "myWizard.RequirementsManagement");
		   finaljson = json.set("Milestones[0].Title", getTitle(toolname,workitem)+"_OB");
		   finaljson = json.set("Milestones[0].ModifiedAtSourceOn", (new Random().nextInt(2)+2024+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(12)+1)))+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(28)+1)))+"T18:48:07.6972433"));
  			}
			
			if((workitem.equalsIgnoreCase("Test Execution")))
  			{
		   finaljson = json.set("TestResults[0].CorrelationUId", GUid.toString());
		   finaljson = json.set("TestResults[0].ItemState", 1);
//		   finaljson = json.set("TestResults[0].CreatedByApp", "myWizard.IssueManagement");
//		   finaljson = json.set("TestResults[0].ModifiedByApp", "myWizard.IssueManagement");
		   finaljson = json.set("TestResults[0].CreatedByApp", "myWizard.RequirementsManagement");
		   finaljson = json.set("TestResults[0].ModifiedByApp", "myWizard.RequirementsManagement");
		   finaljson = json.set("TestResults[0].Title", getTitle(toolname,workitem)+"_OB");
		   finaljson = json.set("TestResults[0].ModifiedAtSourceOn", (new Random().nextInt(2)+2024+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(12)+1)))+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(28)+1)))+"T18:48:07.6972433"));
  			}
			
			
			if((workitem.equalsIgnoreCase("Requirement")))
  			{
	   finaljson = json.set("Requirements[0].CorrelationUId", GUid.toString());
	   finaljson = json.set("Requirements[0].ItemState", 1);
//	   finaljson = json.set("Requirements[0].CreatedByApp", "myWizard.IssueManagement");
//	   finaljson = json.set("Requirements[0].ModifiedByApp", "myWizard.IssueManagement");
	   finaljson = json.set("Requirements[0].CreatedByApp", "myWizard.RequirementsManagement");
	   finaljson = json.set("Requirements[0].ModifiedByApp", "myWizard.RequirementsManagement");
	   finaljson = json.set("Requirements[0].Title", getTitle(toolname,workitem)+"_OB");
	   finaljson = json.set("Requirements[0].ModifiedAtSourceOn", (new Random().nextInt(2)+2024+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(12)+1)))+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(28)+1)))+"T18:48:07.6972433"));
  			}
			
			if((workitem.equalsIgnoreCase("Deliverable")))
  			{
	   finaljson = json.set("Deliverables[0].CorrelationUId", GUid.toString());
	   finaljson = json.set("Deliverables[0].ItemState", 1);
//	   finaljson = json.set("Deliverables[0].CreatedByApp", "myWizard.IssueManagement");
//	   finaljson = json.set("Deliverables[0].ModifiedByApp", "myWizard.IssueManagement");
	   finaljson = json.set("Deliverables[0].CreatedByApp", "myWizard.RequirementsManagement");
	   finaljson = json.set("Deliverables[0].ModifiedByApp", "myWizard.RequirementsManagement");
	   finaljson = json.set("Deliverables[0].Title", getTitle(toolname,workitem)+"_OB");
	   finaljson = json.set("Deliverables[0].ModifiedAtSourceOn", (new Random().nextInt(2)+2024+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(12)+1)))+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(28)+1)))+"T18:48:07.6972433"));
  			}
			
			if((workitem.equalsIgnoreCase("Work Request")))
  			{
	   finaljson = json.set("ChangeRequests[0].CorrelationUId", GUid.toString());
	   finaljson = json.set("ChangeRequests[0].ItemState", 1);
//	   finaljson = json.set("Deliverables[0].CreatedByApp", "myWizard.IssueManagement");
//	   finaljson = json.set("Deliverables[0].ModifiedByApp", "myWizard.IssueManagement");
	   finaljson = json.set("ChangeRequests[0].CreatedByApp", "myWizard.RequirementsManagement");
	   finaljson = json.set("ChangeRequests[0].ModifiedByApp", "myWizard.RequirementsManagement");
	   finaljson = json.set("ChangeRequests[0].Title", getTitle(toolname,workitem)+"_OB");
	   finaljson = json.set("ChangeRequests[0].ModifiedAtSourceOn", (new Random().nextInt(2)+2024+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(12)+1)))+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(28)+1)))+"T18:48:07.6972433"));
  			}
		  	
		   JSONParser parser = new JSONParser();
		   JSONObject jsonObject = (JSONObject) parser.parse(finaljson.jsonString());
		   
		   String requiredNode_WorkItemNodeOnly=null;
			if(!(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("Deliverable") || workitem.equalsIgnoreCase("TestCase")  || workitem.equalsIgnoreCase("Action") || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Milestone") || workitem.equalsIgnoreCase("Test Execution")  || workitem.equalsIgnoreCase("Work Request")  ))
				requiredNode_WorkItemNodeOnly = (String) jsonObject.get("WorkItems").toString();
			if(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("TestCase"))
			requiredNode_WorkItemNodeOnly = (String) jsonObject.get("Tests").toString();
			if((workitem.equalsIgnoreCase("Requirement")))
				requiredNode_WorkItemNodeOnly = (String) jsonObject.get("Requirements").toString();
			if((workitem.equalsIgnoreCase("Action")))
				requiredNode_WorkItemNodeOnly = (String) jsonObject.get("Actions").toString();
			if((workitem.equalsIgnoreCase("Decision")))
				requiredNode_WorkItemNodeOnly = (String) jsonObject.get("Decisions").toString();
			if((workitem.equalsIgnoreCase("Milestone")))
				requiredNode_WorkItemNodeOnly = (String) jsonObject.get("Milestones").toString();
			if((workitem.equalsIgnoreCase("Test Execution")))
				requiredNode_WorkItemNodeOnly = (String) jsonObject.get("TestResults").toString();
			if((workitem.equalsIgnoreCase("Deliverable")))
				requiredNode_WorkItemNodeOnly = (String) jsonObject.get("Deliverables").toString();
			if((workitem.equalsIgnoreCase("Work Request")))
				requiredNode_WorkItemNodeOnly = (String) jsonObject.get("ChangeRequests").toString();

			//		   System.out.println(requiredNode_WorkItemNodeOnly.substring(1, requiredNode_WorkItemNodeOnly.length() - 1));
		   requiredNode_WorkItemNodeOnly = requiredNode_WorkItemNodeOnly.substring(1, requiredNode_WorkItemNodeOnly.length() - 1);
			 FileWriter filetowrite = new FileWriter(temprepsonsefile);
			 filetowrite.write(requiredNode_WorkItemNodeOnly);
			 filetowrite.flush();
			 filetowrite.close();
			 return GUid.toString();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return "";
	
}
public static void VerifyOutboundWorkItemReponse(String WorkItemTypeUId, String WorkItemExternalId,String toolname,String workitem){
			
			try{
				String FlatNonFlarURL = "NonFlat";
				Response responsebodyFromIB = PostRequesttoGetIBResponse(WorkItemTypeUId,WorkItemExternalId,workitem,FlatNonFlarURL,toolname);
				 putOutBoundBodyInTempFile(responsebodyFromIB.getBody().asString());
				 String CorrelationUID = PrepareOutBoundBodyWithRequiredDataAndGetCorrelationID(toolname,workitem);
		
				 RequestSpecification request = RestAssured.given();
								 	
				request.header("Content-Type", "application/json")
						.header("Authorization","Bearer "+Property.getToken("Token"))
						.header("AppServiceUId",Property.getProperty("AppServiceUId_OB"))
						.header("CorrelationUId",CorrelationUID);
									 
				 String mywizURL = Property.getProperty("MyWizard_URL");
				 String[] mywizURL_Sp = mywizURL.split(".com");
				 mywizURL = mywizURL_Sp[0]+".com/core";
				 mywizURL = mywizURL.replace("mywizard", "mywizardapi");
				String temprepsonsefile= System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator	+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" +  File.separator + "ResponseFile_Temp.json";
				request.body(new File(temprepsonsefile));
				
				
				String posturlmerge="";
				if(!(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("Deliverable") || workitem.equalsIgnoreCase("TestCase") || workitem.equalsIgnoreCase("Action")  || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Milestone")  || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request")))
				posturlmerge = mywizURL+"/v1/MergeWorkItem?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("TestCase"))
					posturlmerge = mywizURL+"/v1/Test1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Requirement"))
					posturlmerge = mywizURL+"/v1/Requirement1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Action"))
					posturlmerge = mywizURL+"/v1/Action1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Decision"))
					posturlmerge = mywizURL+"/v1/Decision1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Milestone"))
					posturlmerge = mywizURL+"/v1/Milestone1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Test Execution"))
					posturlmerge = mywizURL+"/v1/TestResult?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Deliverable"))
					posturlmerge = mywizURL+"/v1/Deliverable1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Work Request"))
					posturlmerge = mywizURL+"/v1/ChangeRequest1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";

				
				
				
				Response response = request.post(posturlmerge);
//				System.out.println(response.getStatusCode());
				 Assert.assertEquals(response.getStatusCode(), 200);
				String responsebody = response.getBody().asString();
//				System.out.println(responsebody);
//				response.jsonPath().get
				int updatecount = response.jsonPath().get("MergeResult.UpdateCount");
//				System.out.println("updatecount: "+updatecount);
				if(!(updatecount==1))
					logger.info("update count for workitem "+workitem+ " is 0. OB issue for the given tool "+toolname);
				 Assert.assertEquals(updatecount, 1); 

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}


		public static void CompareReleaseSprintDate(String ReleaseDateFromAPI,String ReleaseDateFromJSON,String toolname)
		{
			try{
				
				if(toolname.contains("Jira") || toolname.contains("JIRA")){
			String[] ReleaseDateFromAPI_sp	= ReleaseDateFromAPI.split("T");
			
			Date date = new SimpleDateFormat("d/MMM/yy").parse(ReleaseDateFromJSON);
			SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd");
//			System.out.println(sdfDestination.format(date).toString());
//			System.out.println(ReleaseDateFromAPI_sp[0]);
			Assert.assertEquals(ReleaseDateFromAPI_sp[0],sdfDestination.format(date).toString(),"Release/Sprint dates mistmatch for tool "+toolname);
				}
				else if(toolname.contains("TFS") || toolname.contains("tfs"))
				{
					String[] ReleaseDateFromAPI_sp	= ReleaseDateFromAPI.split("T");
					
					Date date = new SimpleDateFormat("MM/d/yyyy").parse(ReleaseDateFromJSON);
					SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd");
//					System.out.println(sdfDestination.format(date).toString());
//					System.out.println(ReleaseDateFromAPI_sp[0]);
					Assert.assertEquals(ReleaseDateFromAPI_sp[0],sdfDestination.format(date).toString(),"Release/Sprint dates mistmatch for tool "+toolname);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Data mismatch for release/sprint date for the tool "+toolname);
				Assert.fail("Data mismatch for release/sprint date for the tool "+toolname);
			}
		}

		public static void VerifyInBoundWorkitemDetails_DCCheck(String workitem, String toolname) {
			
			try{
				String WorkItemExternalId = getWorkItemExternalID(workitem,toolname);
				String getWorkitemType = "WorkItemTypeUId_"+workitem;
				String WorkItemTypeUId = Property.getProperty(getWorkitemType);
				Response response = PostRequesttoGetIBResponse(WorkItemTypeUId, WorkItemExternalId, workitem, "Flat", toolname);
				JsonPath js = response.jsonPath();
//				String responsebody = response.getBody().asString();
				String workitem_title = getTitle(toolname, workitem);
				int  totalrecordcount = js.get("TotalRecordCount");
				String TitleFromAPI = js.getString("WorkItems"+"[0].Title");
				if(!TitleFromAPI.equals(workitem_title))
					logger.info("title mismatch for workitem "+workitem +" for the given tool "+toolname);
				Assert.assertEquals(TitleFromAPI, workitem_title,"title mismatch for workitem "+workitem +" for the given tool "+toolname);
				Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				List<Object>  DCUid = js.getList("WorkItems.WorkItemDeliveryConstructs.DeliveryConstructUId");
				if(!DCUid.toString().contains(Property.getProperty("DeliveryConstructUId_L2")))
					logger.info(workitem+" is not associated to the required DCUId for tool "+toolname);
				  Assert.assertTrue(!DCUid.toString().contains(Property.getProperty("DeliveryConstructUId_L2")),workitem+" is not associated to the required DCUId for tool "+toolname);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Problem verifying the Dc Removal scenario for toolname "+toolname);
				Assert.fail("Problem verifying the Dc Removal scenario for toolname "+toolname);
			}
		}
		
		
		public static String SetEntityTypeForPostURL(String workitem){
			
			String WorkItemOrDeliverableOrIterationOrTestOrRequirement="";
			 if(!(workitem.equalsIgnoreCase("Deliverable") || workitem.contains("Release") || workitem.contains("Sprint") || workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("Team") || workitem.equalsIgnoreCase("TestCase") || workitem.equalsIgnoreCase("Action") || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Milestone") || workitem.equalsIgnoreCase("Test Execution")))
				 WorkItemOrDeliverableOrIterationOrTestOrRequirement="WorkItems"; 
			 if(workitem.equalsIgnoreCase("Deliverable"))
				 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Deliverables";
			 if(workitem.contains("Release") || workitem.contains("Sprint"))
				 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Iterations";	
			 if(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("TestCase"))
				 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Tests";	
			 if(workitem.equalsIgnoreCase("Requirement"))
				 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Requirements";
			 if(workitem.equalsIgnoreCase("Team"))
				 WorkItemOrDeliverableOrIterationOrTestOrRequirement="DeliveryConstructsByDeliveryConstructType";
			 if(workitem.equalsIgnoreCase("Action"))
				 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Actions";		 
			 if(workitem.equalsIgnoreCase("Decision"))
				 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Decisions";	
			 if(workitem.equalsIgnoreCase("Milestone"))
				 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Milestones";
			 if(workitem.equalsIgnoreCase("Test Execution"))
				 WorkItemOrDeliverableOrIterationOrTestOrRequirement="TestResults";	
			 
			 return WorkItemOrDeliverableOrIterationOrTestOrRequirement;
		}
		
		public static void Verifyifworkitemisflown(String workitem, String flownOrDeleted, String toolname,String functionality) {
			try{
				String WorkItemTypeUId="";
//				String ReleaseName ="";
//				String SprintName="";
				String WorkItemExternalId="";
				try{
					if(!((workitem.contains("Release") || workitem.contains("Sprint") )))
						{
						WorkItemExternalId = getWorkItemExternalID_custom(workitem,toolname,functionality);
//						System.out.println("workitem id from json file is "+WorkItemExternalId);
						String getWorkitemType = "WorkItemTypeUId_"+workitem;
						if(!(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("Team") || workitem.equalsIgnoreCase("TestCase") || workitem.equalsIgnoreCase("Action") || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request")))
						 WorkItemTypeUId = Property.getProperty(getWorkitemType);
						
						}
				}catch(Exception e)
					{
						e.printStackTrace();
						logger.info("Could not get WorkItemExternalId for "+workitem+" for the tool "+toolname);
						Assert.fail("Could not get WorkItemExternalId for "+workitem+" for the tool "+toolname);
					}
				if((workitem.contains("Release") || workitem.contains("Sprint")))
				{
					try{
						if(workitem.contains("Release") )	
						WorkItemExternalId="Release";
						if(workitem.contains("Sprint") )	
							WorkItemExternalId="Sprint";
					}
					catch(Exception e)
					{
						e.printStackTrace();
						logger.info("Could not get ReleaseName or SprintName for "+workitem+" for the tool "+toolname);
						Assert.fail("Could not get ReleaseName or SprintName for "+workitem+" for the tool "+toolname);
					}
				}
				
				
				String WorkItemOrDeliverableOrIterationOrTestOrRequirement=SetEntityTypeForPostURL(workitem);
				 Response response=null;
				if(functionality.equalsIgnoreCase("Recon") || functionality.equalsIgnoreCase("normal"))
				{
					//plz check this with swetha. 
				  response = PostRequesttoGetIBResponse_custom(WorkItemTypeUId, WorkItemExternalId, workitem, "Flat", toolname,functionality);
				}
				else if(functionality.equalsIgnoreCase("BeforeRecon") || functionality.equalsIgnoreCase("AfterRecon") || functionality.equalsIgnoreCase("AfterRecon&Delete") || functionality.equalsIgnoreCase("DFT") || workitem.equalsIgnoreCase("Work Request")){
					 response = PostRequesttoGetIBResponse_custom(WorkItemTypeUId, WorkItemExternalId, workitem, "NonFlat", toolname,functionality);
				}
				else
					  response = PostRequesttoGetIBResponse_custom(WorkItemTypeUId, WorkItemExternalId, workitem, "Flat", toolname,functionality);
				 JsonPath js = response.jsonPath();
				 
				 String responsebody = response.getBody().asString();
				 int totalrecordcount=0;
				
				 if(!((workitem.contains("Release") || workitem.contains("Sprint") || workitem.contains("Team"))))
				 {
					 totalrecordcount = js.get("TotalRecordCount");
					 if(flownOrDeleted.equalsIgnoreCase("flown"))
					 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
					 else if(flownOrDeleted.equalsIgnoreCase("deleted"))
						 Assert.assertEquals(totalrecordcount, 0,workitem +" not deleted for tool "+toolname);
					 
					 //this code is for team attached to the entity
					 String checkIfTeamVerificationIsRequired = checkIfTeamVerificationRequired(toolname,workitem);
					 if(!checkIfTeamVerificationIsRequired.equalsIgnoreCase("NA"))
					 {
						 //verify team details in workitems API
						 VerifyTeamDetailsForEntity(response.jsonPath(),workitem,toolname,flownOrDeleted);
					 }
				 }
				 if((workitem.contains("Release") || workitem.contains("Sprint")) && !functionality.equalsIgnoreCase("GenericUploader_MyWizardInstance"))
				 {	 
						 HashMap<String,String>ReleaseAndSprintDetails= getReleaseAndSprintDetails(toolname);
						 String ReleaseName = ReleaseAndSprintDetails.get("ReleaseName");
						 String ReleaseStartDate = ReleaseAndSprintDetails.get("ReleaseStartDate");
						 String ReleaseEndDate = ReleaseAndSprintDetails.get("ReleaseEndDate");
						 String SprintName = ReleaseAndSprintDetails.get("SprintName");
						 String SprintStartDate = ReleaseAndSprintDetails.get("SprintStartDate");
						 String SprintEndDate = ReleaseAndSprintDetails.get("SprintEndDate");
						 String ReleaseNameFromRMP = ReleaseAndSprintDetails.get("ReleaseNameFromRMP");
						 String SprintNameFromRMP = ReleaseAndSprintDetails.get("SprintNameFromRMP");
					 
					 int size = response.jsonPath().getInt("Iterations.size()");
//					 System.out.println(size);
					 
					 boolean releasefound = false;
					 boolean sprintfound = false;
					 
						SoftAssert sa = new SoftAssert();
					 
					 if(workitem.contains("Release")){
							 for(int p=0; p<size;p++)
							 {
								 
								 String name = response.jsonPath().getString("Iterations[" + p + "].Name");
								 if(name.equalsIgnoreCase(ReleaseName) || name.equalsIgnoreCase(ReleaseNameFromRMP))
								 
								 {
									 releasefound=true;
									 String ReleaseStartDateFromAPI = response.jsonPath().getString("Iterations[" + p + "].StartOn");
									 String ReleaseEndDateFromAPI = response.jsonPath().getString("Iterations[" + p + "].EndOn");
									 CompareReleaseSprintDate(ReleaseStartDateFromAPI,ReleaseStartDate,toolname);
									 CompareReleaseSprintDate(ReleaseEndDateFromAPI,ReleaseEndDate,toolname);
									 if(workitem.contains("ReleaseFromTool"))
									 {
//										 captureIterationExternalID_ReleaseAndSprint("Release", response.jsonPath(), p, toolname);
										 captureIterationExternalID_ReleaseAndSprint("Release", Baseclass.getInstance().release_IterationExternalID, toolname);
									 }
									 if(workitem.equalsIgnoreCase("ReleaseFromRMP"))
									 {
										 verifyIterationExternalID_ReleaseAndSprint("Release", Baseclass.getInstance().release_IterationExternalID, toolname);
									 }
									 if(functionality.equalsIgnoreCase("GenericUploader"))
									 {
										 verifyReleaseAndSprintDetailsForGenericUploader(workitem,response.jsonPath());
									 }
									 if(functionality.equalsIgnoreCase("ReleaseForTeamVerification"))
									 {
										 verifyReleaseAndSprintDetailsForTeam(workitem,response.jsonPath(),toolname);
									 }
									 break;

								}
							}
							 if(!releasefound && flownOrDeleted.equalsIgnoreCase("flown")){
								 sa.assertEquals(releasefound, true,"Release not flown for "+toolname);

								 }
							 else if(releasefound && flownOrDeleted.equalsIgnoreCase("deleted")){
								 sa.assertEquals(releasefound, false,"Release flown for "+toolname +" after deletion from the tool");

							 }
					 }
					 if(workitem.contains("Sprint")){
							 for(int p=0; p<size;p++)
							 {
								 
								 String name = response.jsonPath().getString("Iterations[" + p + "].Name");
								 if(name.equalsIgnoreCase(SprintName) || name.equalsIgnoreCase(SprintNameFromRMP))
								 
								 {
									 sprintfound=true;
									 if(!toolname.equalsIgnoreCase("ADOP Jira")){
									 String SprintStartDateFromAPI = response.jsonPath().getString("Iterations[" + p + "].StartOn");
									 String SprintEndDateFromAPI = response.jsonPath().getString("Iterations[" + p + "].EndOn");
									 CompareReleaseSprintDate(SprintStartDateFromAPI,SprintStartDate,toolname);
									 CompareReleaseSprintDate(SprintEndDateFromAPI,SprintEndDate,toolname);
									 }
									 if(workitem.contains("SprintFromTool"))
									 {
//										 captureIterationExternalID_ReleaseAndSprint("Sprint", response.jsonPath(), p, toolname);
										 captureIterationExternalID_ReleaseAndSprint("Sprint", Baseclass.getInstance().sprint_IterationExternalID, toolname);
									 }
									 if(workitem.equalsIgnoreCase("SprintFromRMP"))
									 {
										 verifyIterationExternalID_ReleaseAndSprint("Sprint", Baseclass.getInstance().sprint_IterationExternalID, toolname);
									 }
									 break;

								 }
						
							 }
							 if(!sprintfound && flownOrDeleted.equalsIgnoreCase("flown")){
								 sa.assertEquals(sprintfound, true,"Sprint not flown for "+toolname);

							 }
							 else if(sprintfound && flownOrDeleted.equalsIgnoreCase("deleted")){
								 sa.assertEquals(sprintfound, false,"Sprint flown for "+toolname +" after deletion from the tool");

							 }

					 }
			
					
					 sa.assertAll();
							 
				}
				 
				 //recon functionality
				 
				 if(functionality.equalsIgnoreCase("BeforeRecon"))
				 {
					 String IterationUID_Release="";
					 String IterationUID_Sprint ="";
					 String IterationExternalID_Release="";
					 String IterationExternalID_Sprint="";
					 
					 String jsonpathforName="";
					 String jsonpathforValue="";
					 String jsonpathorExternalValue="";
					 
					 
						 
					 ArrayList<String> IterationDetails = getIterationUIDAndExternalIDForReleaseAndSprintAndVerifyTheSame(response.jsonPath(),workitem,toolname);
					 System.out.println(IterationDetails);
//						 UpdateIterationUIDAndIterationExternalIDOfWorkitemAndCompareIterationExternalID(IterationUID_Release,IterationExternalID_Release,IterationUID_Sprint,IterationExternalID_Sprint,toolname);
					 UpdateIterationUIDAndIterationExternalIDOfWorkitemAndCompareIterationExternalID(IterationDetails.get(0),IterationDetails.get(1),IterationDetails.get(2),IterationDetails.get(3),toolname);	
				
					 
			
					 
//					 UpdateIterationUIDAndIterationExternalIDOfWorkitemAndCompareIterationExternalID(IterationUID_Release,IterationExternalID_Release,IterationUID_Sprint,IterationExternalID_Sprint,toolname);
				 }
				 
				 
//					 String IterationUID="";
//					 String IterationExternalIDOfWorkitemAfterRecon_Release="";
//					 String IterationExternalIDOfWorkitemAfterRecon_Sprint="";
//					 String jsonpathforName="";
//					 String jsonpathforValue="";
//					 String jsonpathorExternalValue="";
//					 List<ArrayList<String>> DisplayNames=null;
					 
					if(functionality.equalsIgnoreCase("AfterRecon")){ 

						ArrayList<String> IterationDetails = getIterationUIDAndExternalIDForReleaseAndSprintAndVerifyTheSame(response.jsonPath(),workitem,toolname);	
//					 VerifyIterationExternalIDAfterReconForWorkitem(IterationExternalIDOfWorkitemAfterRecon_Release,IterationExternalIDOfWorkitemAfterRecon_Sprint,toolname);
						VerifyIterationExternalIDAfterReconForWorkitem(IterationDetails.get(0),IterationDetails.get(2),toolname);
					}
					
					if(functionality.equalsIgnoreCase("AfterRecon&Delete"))
					{
						if(workitem.contains("Action")){
							 List<ArrayList<String>> DisplayNamesa= response.jsonPath().get("Actions.ActionAssociations");
							 for(ArrayList j:DisplayNamesa)
							 {
							Assert.assertEquals(j.isEmpty(), true, "ActionAssociations section present. Action is associated with release");
							 }
						}
						else {
							String jsonpathforName = "WorkItems.WorkItemAttributes.Name";
							String jsonpathforValue = "WorkItems.WorkItemAttributes.Value";
							String 	jsonpathorExternalValue = "WorkItems.WorkItemAttributes.ExternalValue";
							 List<ArrayList<String>> DisplayNames=null;
						
									DisplayNames= response.jsonPath().get(jsonpathforName);
									System.out.println(DisplayNames.size());
								 for(ArrayList j:DisplayNames)
								 {
									 
									 if(j.contains("ReleaseUId"))
									 {
										 List<ArrayList<String>> IdValue = response.jsonPath().get(jsonpathforValue);
										 List<ArrayList<String>> IdExternalValue = response.jsonPath().get(jsonpathorExternalValue);
										 for(ArrayList<String> k : IdValue)
										{
											 
											 Assert.assertEquals(k.get(j.indexOf("ReleaseUId")).isEmpty(), true, "Release value is not null. release is still associated to the worktitem");
//											System.out.println(IterationUID_Release);
											
										}
										 for(ArrayList<String> l : IdExternalValue)
											{
												 
											 Assert.assertEquals(l.get(j.indexOf("ReleaseUId")).isEmpty(), true, "Release ExternalValue is not null. release is still associated to the worktitem");
//											 System.out.println(IterationExternalID_Release);
											}
									 }
									 
									 if(j.contains("IterationUId"))
									 {
										 List<ArrayList<String>> IdValue = response.jsonPath().get(jsonpathforValue);
										 List<ArrayList<String>> IdExternalValue = response.jsonPath().get(jsonpathorExternalValue);
										 for(ArrayList<String> k : IdValue)
										{
											 
											 Assert.assertEquals(k.get(j.indexOf("IterationUId")).isEmpty(), true, "Sprint value is not null. release is still associated to the worktitem");
//											System.out.println(k.get(j.indexOf("IterationUId")).isEmpty());
											
										}
										 for(ArrayList<String> l : IdExternalValue)
											{
												 
											 Assert.assertEquals(l.get(j.indexOf("IterationUId")).isEmpty(), true, "Sprint ExternalValue is not null. release is still associated to the worktitem");
//											 System.out.println(l.get(j.indexOf("IterationUId")).isEmpty());
											}
									 }
								 }
				 }
					}
				 
				 
				 if(functionality.equalsIgnoreCase("DFT"))
				 {
					 String correlationUID = response.jsonPath().get("WorkItems[0].WorkItemDeliveryConstructs[0].CorrelationUId");
					 System.out.println(correlationUID);
					 Baseclass.getInstance().CorrelationUID = response.jsonPath().get("WorkItems[0].WorkItemDeliveryConstructs[0].CorrelationUId");
					 
				 }
				 if(functionality.equalsIgnoreCase("DIY"))
				 {
					 
					 VerifyDCAssociation(workitem,response.jsonPath(),totalrecordcount,toolname);
					
				 }
				 if(functionality.equalsIgnoreCase("GenericUploader") && !workitem.equalsIgnoreCase("Release") && !workitem.equalsIgnoreCase("Sprint"))
				 {
					 VerifyWorkItemDetailsForGenericUploader(workitem,response.jsonPath(),totalrecordcount,toolname);
				 }
				 if(functionality.equalsIgnoreCase("GenericUploader_MyWizardInstance") && (workitem.equalsIgnoreCase("Release") || workitem.equalsIgnoreCase("Sprint")))
				 {
					 String ReleaseOrSprintName = response.jsonPath().getString("Iterations[0].Name");
					 int recordcount =response.jsonPath().get("TotalRecordCount"); 
					 if(recordcount==1)
					 {
						 if(workitem.equalsIgnoreCase("Release"))
						 {
							
							if(!ReleaseOrSprintName.equalsIgnoreCase("Release_AutomationData_GenericUploader"))
							Assert.fail("Title mismatch for generic uploader for "+workitem);
						 }
						 else if(workitem.equalsIgnoreCase("Sprint"))
						 {
							 if(!ReleaseOrSprintName.equalsIgnoreCase("Sprint_AutomationData_GenericUploader"))
								 Assert.fail("Title mismatch for generic uploader for "+workitem);
						 }
					 }
					 else
						 Assert.fail(workitem+" not flown for generic uploader test");
								
					 }
				 
				 
				 //Team verification
				 if(workitem.contains("Team"))
				 {
					 try{
					 boolean Teamfound=false;
                     SoftAssert sa = new SoftAssert();
                     //to be changed by sanggetha to workitemjson file
                     String teamNameFromTool=Tools.getWorkItemExternalID_custom(workitem,toolname,"normal");
                     String TeamFromAPI=response.jsonPath().getString("DeliveryConstructs.Name");
                     if(TeamFromAPI.contains(teamNameFromTool)) {
                         Teamfound=true;
                     }
                         
                    if(!Teamfound && flownOrDeleted.equalsIgnoreCase("flown")){
                         sa.assertEquals(Teamfound, true,"Team not flown for "+toolname);
                         System.out.println("Team not flown for "+toolname);
                         }
                     else if (Teamfound && flownOrDeleted.equalsIgnoreCase("deleted")) {
                         sa.assertEquals(Teamfound, false,"Team flown for "+toolname +" after deletion from the tool");
                         System.out.println("Team flown for "+toolname +"after deletion from the tool");
                     }
					 }
					 catch(Exception e)
					 {
						 e.printStackTrace();
						 logger.info("Issue verifying team details in API");
						 Assert.fail("Issue verifying team details in API");
					 }
                 }
				 
				 
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Could not verify "+workitem+" for tool "+toolname+". ");
				Assert.fail("Could not verify "+workitem+" for tool "+toolname+". ");
			}
			
			
		
		}

		 

public static void verifyReleaseAndSprintDetailsForTeam(String workitem, JsonPath jsonPath,String toolname) {
	 try{
		 if(workitem.contains("Release")){
			 String DCUidOfTeam = getWorkItemExternalID_custom("TeamUId", toolname, "normal");
			 String DCUIdForTeam = jsonPath.getString("Iterations.IterationDeliveryConstructs.DeliveryConstructUId");
			 Assert.assertTrue(DCUIdForTeam.contains(DCUidOfTeam),"Team DC missing in DC Details of the given Iteration for tool "+toolname);
		 }
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
			
		}

public static void VerifyTeamDetailsForEntity(JsonPath jsonPath, String workitem, String toolname,String flownOrDeleted) {
             String checkIfTeamVerificationIsRequired="";
            String teamName=getWorkItemExternalID_custom( workitem, toolname, "normal");
             SoftAssert sa = new SoftAssert();
             boolean flown=false;         
           
             
             if(checkIfTeamVerificationIsRequired.equalsIgnoreCase("TeamCreatedInTool"))
             {
                 String TeamFromAPI="";//verify team details in workitems API
                 if (workitem.equalsIgnoreCase("Epic")||(workitem.equalsIgnoreCase("Story"))) {
                    
                     TeamFromAPI=jsonPath.getString("WorkItems[0].TeamAreaName");
                    
                }
                else if(workitem.equalsIgnoreCase("Action")) {
                    TeamFromAPI=jsonPath.getString("Actions[0].TeamAreaName");
                }
                 
                 if(TeamFromAPI.equalsIgnoreCase(teamName)) {
                    flown=true;
                    
                 }
                    if(!flown && flownOrDeleted.equalsIgnoreCase("flown")){
                         sa.assertEquals(flown, true,"Team not flown for "+ workitem +"in "+toolname);
                         System.out.println("Team  flown not for "+ workitem +"in "+toolname);

 

                         }
                    else if(flown && flownOrDeleted.equalsIgnoreCase("deleted")){
                         sa.assertEquals(flown, false,"Team flown for "+toolname +" after deletion from the tool");
                         System.out.println("Team flown for "+toolname +" after deletion from the tool");
                }    
                 
             }
             else if(checkIfTeamVerificationIsRequired.equalsIgnoreCase("TeamCreatedInUI")) 
             {
                 String DCFromAPI="";
                 boolean DCflown=false;
                 //code to be added
                 //Implemented for Only workitems
                     DCFromAPI=jsonPath.getString("WorkItems.WorkItemDeliveryConstructs.DeliveryConstructUId");
                     System.out.println(DCFromAPI);
                    //to be added by swetha
		                     if(DCFromAPI.contains("")) {
		                            DCflown=true;
		                            
		                         }
	                            if(!DCflown && flownOrDeleted.equalsIgnoreCase("flown")){
	                                 sa.assertEquals(DCflown, true,"Team DC not flown for "+ workitem +"in "+toolname);
	                                 System.out.println("Team DC not flown for "+ workitem +" in "+toolname);
	                            }								
                            else if(DCflown && flownOrDeleted.equalsIgnoreCase("deleted")){
                                 sa.assertEquals(DCflown, false,"Team DC flown for "+toolname +" after deletion from the tool");
                                 System.out.println("Team DC flown for "+toolname +" after deletion from the tool");
                            	}    
                         
                     
             }
           
}
			

		private static ArrayList<String> getIterationUIDAndExternalIDForReleaseAndSprintAndVerifyTheSame(JsonPath jsonPath, String workitem,String toolname) {
				 String IterationUID_Release="";
				 String IterationUID_Sprint ="";
				 String IterationExternalID_Release="";
				 String IterationExternalID_Sprint="";
				 
				 if(!workitem.contains("Action")){
					 String jsonpathforName = "WorkItems.WorkItemAttributes.Name";
					 String jsonpathforValue = "WorkItems.WorkItemAttributes.IdValue";
					 String jsonpathorExternalValue = "WorkItems.WorkItemAttributes.IdExternalValue";
					 List<ArrayList<String>> DisplayNames= jsonPath.get(jsonpathforName);
						System.out.println(DisplayNames.size());
						 for(ArrayList j:DisplayNames)
						 {
							 
							 if(j.contains("ReleaseUId"))
							 {
								 List<ArrayList<String>> IdValue = jsonPath.get(jsonpathforValue);
								 List<ArrayList<String>> IdExternalValue = jsonPath.get(jsonpathorExternalValue);
								 for(ArrayList<String> k : IdValue)
								{
									 
									 IterationUID_Release= k.get(j.indexOf("ReleaseUId"));
									System.out.println(IterationUID_Release);
									
								}
								 for(ArrayList<String> l : IdExternalValue)
									{
										 
									 IterationExternalID_Release= l.get(j.indexOf("ReleaseUId"));
									 System.out.println(IterationExternalID_Release);
									}
							 }
							 
							 if(j.contains("IterationUId"))
							 {
								 List<ArrayList<String>> IdValue = jsonPath.get(jsonpathforValue);
								 List<ArrayList<String>> IdExternalValue = jsonPath.get(jsonpathorExternalValue);
								 for(ArrayList<String> k : IdValue)
								{
									 
									 IterationUID_Sprint= k.get(j.indexOf("IterationUId"));
									System.out.println(IterationUID_Sprint);
									
								}
								 for(ArrayList<String> l : IdExternalValue)
									{
										 
									 IterationExternalID_Sprint= l.get(j.indexOf("IterationUId"));
									 System.out.println(IterationExternalID_Sprint);
									}
							 }
						 }
				 }
				 else if(workitem.contains("Action"))
				 {
					 String jsonpathforIterationTypeUId="Actions.ActionAssociations.IterationTypeUId";
					 List<ArrayList<String>> IterationTypeUId= jsonPath.get(jsonpathforIterationTypeUId);
					 for(ArrayList j:IterationTypeUId)
					 {
						 
						 if(j.contains("00200390-0010-0000-0000-000000000000"))
						 {
							 List<ArrayList<String>> ExternalID = jsonPath.get("Actions.ActionAssociations.ItemExternalId");
							 List<ArrayList<String>> AssociatedUId = jsonPath.get("Actions.ActionAssociations.ItemAssociatedUId");
							 for(ArrayList<String> k : AssociatedUId)
							{
								 
								 IterationUID_Release= k.get(j.indexOf("00200390-0010-0000-0000-000000000000"));
								System.out.println(IterationUID_Release);
								
							}
							 for(ArrayList<String> l : ExternalID)
								{
									 
								 IterationExternalID_Release= l.get(j.indexOf("00200390-0010-0000-0000-000000000000"));
								 System.out.println(IterationExternalID_Release);
								}
						 }
						 
						 if(j.contains("00200390-0020-0000-0000-000000000000"))
						 {
							 List<ArrayList<String>> ExternalID = jsonPath.get("Actions.ActionAssociations.ItemExternalId");
							 List<ArrayList<String>> AssociatedUId = jsonPath.get("Actions.ActionAssociations.ItemAssociatedUId");
							 for(ArrayList<String> k : AssociatedUId)
							{
								 
								 IterationUID_Sprint= k.get(j.indexOf("00200390-0020-0000-0000-000000000000"));
								System.out.println(IterationUID_Sprint);
								
							}
							 for(ArrayList<String> l : ExternalID)
								{
									 
								 IterationExternalID_Sprint= l.get(j.indexOf("00200390-0020-0000-0000-000000000000"));
								 System.out.println(IterationExternalID_Sprint);
								}
						 }
					 }
				 }
				 ArrayList<String> IterationDetails = new ArrayList<>();
				 IterationDetails.add(IterationUID_Release);
				 IterationDetails.add(IterationExternalID_Release);
				 IterationDetails.add(IterationUID_Sprint);
				 IterationDetails.add(IterationExternalID_Sprint);
				 return IterationDetails;
				 
				 
		}

		public static void verifyReleaseAndSprintDetailsForGenericUploader(String workitem, JsonPath jsonPath) {
		
			 if(workitem.equalsIgnoreCase("Release"))
			 {
				 System.out.println(jsonPath.getString("Iterations[0].Name"));
				 Assert.assertEquals(jsonPath.getString("Iterations[0].Name"), "Release_AutomationData_GenericUploader","Mimatch in release name for generic uploader functionality");
			 }
			 else if(workitem.equalsIgnoreCase("Sprint"))
			 {
				 System.out.println(jsonPath.getString("Iterations[0].Name"));
				 Assert.assertEquals(jsonPath.getString("Iterations[0].Name"), "Sprint_AutomationData_GenericUploader","Mimatch in sprint name for generic uploader functionality");
			 }
			
		}

		public static void VerifyWorkItemDetailsForGenericUploader(String workitem, JsonPath jsonPath,int totalrecordcount, String toolname) throws IOException {
			 
			if(!(workitem.equalsIgnoreCase("Decision") ||  workitem.equalsIgnoreCase("Action")))
			{
				 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				 String TitleFromAPI = jsonPath.getString("WorkItems"+"[0].Title");
//				 System.out.println(TitleFromAPI);
//				 System.out.println(workitem_title);
				 if(!TitleFromAPI.equals(workitem+"_AutomationData_GenericUploader"))
				 logger.info("title mismatch for workitem "+workitem +" for the given tool "+toolname+ " for generic uploader functionality");
				 Assert.assertEquals(TitleFromAPI, workitem+"_AutomationData_GenericUploader","title mismatch for workitem "+workitem +" for the given tool "+toolname+ " for generic uploader functionality");
				 
				 //verify phase and workstream
				 if(workitem.equalsIgnoreCase("Risk")|| workitem.equalsIgnoreCase("Issue")|| workitem.equalsIgnoreCase("Bug")) {
		                
	                 String WorkstreamFromAPI=jsonPath.getString("WorkItems"+"[0].Workstream");
	                 String PhaseFromAPI="PhaseUId";
	                
	                 /*WorkStream validation*/
	                 System.out.println(WorkstreamFromAPI);   
	                 SoftAssert sa = new SoftAssert();
	                 if(!WorkstreamFromAPI.equals("Security_AutomationData"))
	                 logger.info("WorkStream mismatch for workitem "+workitem +" for the given tool "+toolname+ " for generic uploader functionality");
	                 sa.assertEquals(WorkstreamFromAPI, "Security_AutomationData", "Value mismatch for workitem "+workitem +" for the given tool "+toolname+ " for generic uploader functionality");
	                
	                 /*Phase validation*/
	                 List<ArrayList<String>> workattributes =jsonPath.get("WorkItems.WorkItemAttributes.Name");
	                 for(ArrayList j:workattributes)
	                         {
	                             if(j.contains(PhaseFromAPI))
	                             {
	                                 List<ArrayList<String>> Names =jsonPath.get("WorkItems.WorkItemAttributes.ExternalValue");
	                                 for(ArrayList<String> ae : Names)
	                                {
	                                    System.out.println(ae.get(j.indexOf(PhaseFromAPI)));
	                                    sa.assertEquals(ae.get(j.indexOf(PhaseFromAPI)), "Plan","Phase mismatch in the response for workitem "+workitem+ " for the given tool "+toolname+" for generic uploader functionality");
	                                   
	                                }
	                             }
	                             else
	                                 Assert.fail("Phase tag missing in the workitem response for toolname "+toolname+" for generic uploader functionality");
	                             
	                        }
	                 
	                 /*Owner-team verification validation via GU*/
	                 List<ArrayList<String>> FieldNames =jsonPath.get("WorkItems.WorkItemExtensions.FieldName");
	                 for(ArrayList j:FieldNames)
	                         {
	                             if(j.contains("ResourceEmailAddress"))
	                             {
	                                 List<ArrayList<String>> Names =jsonPath.get("WorkItems.WorkItemExtensions.FieldValue");
	                                 for(ArrayList<String> ae : Names)
	                                {
	                                    String resourcenameinAPI = ae.get(j.indexOf("ResourceEmailAddress"));
	                                    sa.assertTrue(resourcenameinAPI.contains(Property.getProperty("Owner_TeamResouce")), "mismatch in Owner attached to the worktem via GU");                                   
	                                }
	                             }
	                             else
	                                 Assert.fail("ResourceEmailAddress field not found in the response of workitem for GU upload for workitem "+workitem);
	                             
	                        }
	                 //Team Name verification
	                 String GetAllTeamNames = jsonPath.getString("WorkItems.WorkItemDeliveryConstructs.Name");
	                 sa.assertTrue(GetAllTeamNames.contains(Property.getProperty("TeamName")));
	                 sa.assertAll();
	            
	                }
	                
	            
			}
			else if(workitem.equalsIgnoreCase("Decision"))
			{
				 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				 String TitleFromAPI = jsonPath.getString("Decisions"+"[0].Title");
//				 System.out.println(TitleFromAPI);
//				 System.out.println(workitem_title);
				 if(!TitleFromAPI.equals(workitem+"_AutomationData_GenericUploader"))
					 logger.info("title mismatch for workitem "+workitem +" for the given tool "+toolname+ " for generic uploader functionality");
				 Assert.assertEquals(TitleFromAPI, workitem+"_AutomationData_GenericUploader","title mismatch for workitem "+workitem +" for the given tool "+toolname+ " for generic uploader functionality");
			}
			else if(workitem.equalsIgnoreCase("Action"))
			{
				SoftAssert sa = new SoftAssert();
				 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				 String TitleFromAPI = jsonPath.getString("Actions"+"[0].Title");
				 
				 //verify workstream and phase
                 String WorkstreamFromAPI=jsonPath.getString("Actions"+"[0].Workstream");
                 String PhaseFromAPI="PhaseUId";

               
                 /*Title validation*/
                 if(!TitleFromAPI.equals(workitem+"_AutomationData_GenericUploader"))
                     logger.info("title mismatch for workitem "+workitem +" for the given tool "+toolname+ " for generic uploader functionality");
                 sa.assertEquals(TitleFromAPI, workitem+"_AutomationData_GenericUploader","title mismatch for workitem "+workitem +" for the given tool "+toolname+ " for generic uploader functionality");
                
                 /*WorkStream validation*/
                 System.out.println(WorkstreamFromAPI);                
                 if(!WorkstreamFromAPI.equals("Security_AutomationData"))
                 logger.info("Workstream mismatch for workitem "+workitem +" for the given tool "+toolname+ " for generic uploader functionality");
                 sa.assertEquals(WorkstreamFromAPI, "Security_AutomationData","Workstream mismatch for workitem "+workitem +" for the given tool "+toolname+ " for generic uploader functionality");
               
                 /*Phase validation*/
                 List<ArrayList<String>> workattributes =jsonPath.get("Actions.ActionAttributes.Name");
                 for(ArrayList j:workattributes)
                         {
                             if(j.contains(PhaseFromAPI))
                             {
                                 List<ArrayList<String>> Names =jsonPath.get("Actions.ActionAttributes.ExternalValue");
                                 for(ArrayList<String> ae : Names)
                                {
                                    sa.assertEquals(ae.get(j.indexOf(PhaseFromAPI)),"Plan","Phase mismatch in the response for workitem "+workitem+ " for the given tool "+toolname+" for generic uploader functionality");
                                   
                                }
                             }
                             else
                                 Assert.fail("Phase tag missing in the workitem response for "+workitem+ " for the given tool "+toolname+" for generic uploader functionality");
                        }
                 sa.assertAll();
                }
			
			
		}

		//DeliveryConstructUId for WorkItems
		public static void VerifyDCAssociation(String workitem, JsonPath js, int totalrecordcount,String toolname) {
		 try{
			 List<Object> DCUid=null;
			 if(!(workitem.equalsIgnoreCase("Deliverable") || workitem.equalsIgnoreCase("Release") || workitem.equalsIgnoreCase("Sprint") || workitem.equalsIgnoreCase("TestCase") || workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("Team") || workitem.equalsIgnoreCase("Action") || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Milestone") || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request")))
				 {
					 
				 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				 DCUid = js.getList("WorkItems.WorkItemDeliveryConstructs.DeliveryConstructUId");
				 }
			 
			//DeliveryConstructUId for Deliverable 
			 if(workitem.equalsIgnoreCase("Deliverable"))
				 {
				 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				 DCUid = js.getList("Deliverables.DeliverableDeliveryConstructs.DeliveryConstructUId");	
				 }
			 
			//DeliveryConstructUId for Test 
			 if(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("TestCase"))
			 {
				 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
			 DCUid = js.getList("Tests.TestDeliveryConstructs.DeliveryConstructUId");	
			 }
			 //DCUid for Action
			 if(workitem.equalsIgnoreCase("Action"))
			 {
				 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
			 DCUid = js.getList("Actions.ActionDeliveryConstructs.DeliveryConstructUId");	
			 }
			 if(workitem.equalsIgnoreCase("Decision"))
			 {
				 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
			 DCUid = js.getList("Decisions.DecisionDeliveryConstructs.DeliveryConstructUId");	
			 }
			 if(workitem.equalsIgnoreCase("Milestone"))
			 {
				 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
			 DCUid = js.getList("Milestones.MilestoneDeliveryConstructs.DeliveryConstructUId");	
			 }
			 if(workitem.equalsIgnoreCase("Test Execution"))
			 {
				 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
			 DCUid = js.getList("TestResults.TestResultDeliveryConstructs.DeliveryConstructUId");	
			 }
			 if(workitem.equalsIgnoreCase("Work Request"))
			 {
				 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
			 DCUid = js.getList("ChangeRequests.ChangeRequestDeliveryConstructs.DeliveryConstructUId");	
			 }
				//DeliveryConstructUId for Requirement 
			 if(workitem.equalsIgnoreCase("Requirement"))
			 {
				 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
			 DCUid = js.getList("Requirements.RequirementDeliveryConstructs.DeliveryConstructUId");	
			 }
			 
				//DeliveryConstructUId for all workitems 
			 if(!(workitem.equalsIgnoreCase("Release") || workitem.equalsIgnoreCase("Sprint") || workitem.equalsIgnoreCase("Team")))
			 Assert.assertTrue(DCUid.toString().contains(getDCUid(toolname,"DIY")),workitem+" is not associated to the required DCUId for tool "+toolname);
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 }
		 }
			
		

		private static void VerifyIterationExternalIDAfterReconForWorkitem(String IterationExternalIDOfWorkitemAfterRecon_Release, String IterationExternalIDOfWorkitemAfterRecon_Sprint, String toolname) {
			try{
			String testDataPath_WorkItemExternalIDs="";
			if(toolname.contains("Jira") || toolname.contains("JIRA")){
				testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
			}
			else if(toolname.contains("TFS") || toolname.contains("Tfs")){
				testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
			}
			FileReader reader = new FileReader(testDataPath_WorkItemExternalIDs);

	        JSONParser jsonParser = new JSONParser();
	        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
	        String IterationExternalIDFromRMP_Release = (String) jsonObject.get("IterationExternalIDFromRMP_Release");
	        String IterationExternalIDFromRMP_Sprint = (String) jsonObject.get("IterationExternalIDFromRMP_Sprint");
	        Assert.assertEquals(IterationExternalIDFromRMP_Release, IterationExternalIDOfWorkitemAfterRecon_Release, "mimatch in IterationExternalID after reconiliation for the workitem for tool "+toolname);
	        Assert.assertEquals(IterationExternalIDFromRMP_Sprint, IterationExternalIDOfWorkitemAfterRecon_Sprint, "mimatch in IterationExternalID after reconiliation for the workitem for tool "+toolname);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		private static void verifyIterationExternalID_ReleaseAndSprint(String ReleaseOrSprint, String IterationExternalIDFromRMP, String toolname) {
			try{
			String testDataPath_WorkItemExternalIDs="";
//			System.out.println(jsonPath.getString("Iterations[" + p + "].IterationProductInstances.IterationExternalId").toString());
//			String IterationExternalIDFromRMP = jsonPath.getString("Iterations[" + p + "].IterationProductInstances.IterationExternalId").toString();
//			IterationExternalIDFromRMP = IterationExternalIDFromRMP.substring(1, IterationExternalIDFromRMP.length() - 1);
			if(toolname.contains("Jira") || toolname.contains("JIRA")){
				testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
			}
			else if(toolname.contains("TFS") || toolname.contains("Tfs")){
				testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
			}
			FileReader reader = new FileReader(testDataPath_WorkItemExternalIDs);

	        JSONParser jsonParser = new JSONParser();
	        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
	        if(ReleaseOrSprint.equalsIgnoreCase("Release")){
	        String IterationExternalIDFromTool_Release = (String) jsonObject.get("IterationExternalID_Release");
	        Assert.assertNotEquals(IterationExternalIDFromRMP, IterationExternalIDFromTool_Release, "IterationExternalID not changed after reconiliation for tool "+toolname);
	        jsonObject.put("IterationExternalIDFromRMP_Release",IterationExternalIDFromRMP);
	        }
	        if(ReleaseOrSprint.equalsIgnoreCase("Sprint")){
		        String IterationExternalIDFromTool_Sprint= (String) jsonObject.get("IterationExternalID_Sprint");
		        Assert.assertNotEquals(IterationExternalIDFromRMP, IterationExternalIDFromTool_Sprint, "IterationExternalID not changed after reconiliation for tool "+toolname);
		        jsonObject.put("IterationExternalIDFromRMP_Sprint",IterationExternalIDFromRMP);
		        }
	        
	        
	        FileOutputStream outputStream = new FileOutputStream(testDataPath_WorkItemExternalIDs);
			 byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}

		private static void UpdateIterationUIDAndIterationExternalIDOfWorkitemAndCompareIterationExternalID(String IterationUID_Release, String IterationExternalID_Release,String IterationUID_Sprint, String IterationExternalID_Sprint, String toolname) {
			try{
			String testDataPath_WorkItemExternalIDs="";
			if(toolname.contains("Jira") || toolname.contains("JIRA")){
				testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
			}
			else if(toolname.contains("TFS") || toolname.contains("Tfs")){
				testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
			}
			FileReader reader = new FileReader(testDataPath_WorkItemExternalIDs);

	        JSONParser jsonParser = new JSONParser();
	        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
	        
	        String IterationExternalIDFromTool_Release = (String) jsonObject.get("IterationExternalID_Release");
	        String IterationExternalIDFromTool_Sprint = (String) jsonObject.get("IterationExternalID_Sprint");
	        Assert.assertEquals(IterationExternalIDFromTool_Release, IterationExternalID_Release,"mismatch in IterationExternalID(Release) between tool and the ID in workitem for toolname "+toolname);
	        Assert.assertEquals(IterationExternalIDFromTool_Sprint, IterationExternalID_Sprint,"mismatch in IterationExternalID(Sprint) between tool and the ID in workitem for toolname "+toolname);
//	        jsonObject.put("IterationUID_Release_WorkItem",IterationUID_Release);
//	        jsonObject.put("IterationExternalID_Release_WorkItem",IterationExternalID_Release);
//	        jsonObject.put("IterationUID_Sprint_WorkItem",IterationUID_Sprint);
//	        jsonObject.put("IterationExternalID_Sprint_WorkItem",IterationExternalID_Sprint);
	        FileOutputStream outputStream = new FileOutputStream(testDataPath_WorkItemExternalIDs);
			 byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue updating IterationUID or IterationExternalID for tool "+toolname);
			}
		}

		public static void VerifyWSJFFuncionality(String workitem, String toolname) {
			try{
			 String WorkItemTypeUId = Property.getProperty("WorkItemTypeUId_"+workitem); //this is only for workitems
			 String WorkItemExternalId = getWorkItemExternalID(workitem,toolname);
			 
			 String WorkItemOrDeliverableOrIterationOrTestOrRequirement=SetEntityTypeForPostURL(workitem);
			 Response response = PostRequesttoGetIBResponse(WorkItemTypeUId, WorkItemExternalId, workitem, "NonFlat", toolname);
			 String testDataPath="";
			 if(toolname.contains("TFS"))
			 {
			  testDataPath = System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator
						+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON" +  File.separator;
			 }
			 else if(toolname.contains("Jira") | toolname.contains("JIRA"))
			 {
				 testDataPath = System.getProperty("user.dir")
							+ File.separator + "src" + File.separator + "test" + File.separator
							+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" +  File.separator;
				
				 }
			 if(workitem.equalsIgnoreCase("Story") && toolname.contains("TFS"))
				 workitem="ProductBacklog";
			 String workitemToGetDetailsFor = workitem+"_wsjf";
			 WorkItemDO wi = DataManager.getData(testDataPath, "WorkItem",WorkItemDO.class).item.get(workitemToGetDetailsFor);
			 System.out.println(wi.Priority);
			int Priority = getPriorityWeightage(wi.Priority, toolname);
			 
			 Integer numerator = Integer.parseInt(wi.BusinessValue)+Priority+Integer.parseInt(wi.RiskReduction);
			 Integer denom =  Integer.parseInt(wi.StoryPoints);
			 float expectedWSJFValue = numerator/denom;
			 System.out.println(expectedWSJFValue);
			 List<ArrayList<String>> FieldNames = response.jsonPath().get("WorkItems.WorkItemExtensions.FieldName");
			 for(ArrayList j:FieldNames)
					 {
						 if(j.contains("WSJF"))
						 {
							 List<ArrayList<String>> FieldValues = response.jsonPath().get("WorkItems.WorkItemExtensions.FieldValue");
							 for(ArrayList<String> ae : FieldValues)
							{
								System.out.println(ae.get(j.indexOf("WSJF")));
								float wsjf_API = Float.parseFloat((ae.get(j.indexOf("WSJF"))));
								Assert.assertEquals(wsjf_API, expectedWSJFValue, "Mismatch in wsjf value for workitem "+workitem+ " for tool "+toolname);
							}
						 }
						 else
							 Assert.fail("WSJF tag missing in the response for workitem "+workitem+ " for tool "+toolname);
					}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public static int getPriorityWeightage(String Priority, String toolname){
			int PriorityWeightage = 0;
			if(toolname.contains("TFS")){
				switch(Priority){
					case "1":
						PriorityWeightage = 20;
						break;
					case "2":
						PriorityWeightage = 30;
						break;
					case "3":
						PriorityWeightage = 40;
						break;
					case "4":
						PriorityWeightage = 50;
						break;
				}
			}
			else if(toolname.contains("Jira") || toolname.contains("JIRA")){
				switch(Priority){
				case "Low":
					PriorityWeightage = 20;
					break;
				case "Medium":
					PriorityWeightage = 30;
					break;
				case "High":
					PriorityWeightage = 40;
					break;
				case "Highest":
					PriorityWeightage = 50;
					break;
				}
			}
			return PriorityWeightage;
		}

		public static void VerifyScrumBanFuncionality(String workitem, String toolname,String flownordeletedwithactivateddate) {
			try{
			 String WorkItemTypeUId = Property.getProperty("WorkItemTypeUId_"+workitem); //this is only for workitems
			 String WorkItemExternalId="";
			if(toolname.contains("TFS") || (toolname.equalsIgnoreCase("Rally")) )
			 WorkItemExternalId = getWorkItemExternalID(workitem,toolname);
			if((toolname.contains("ADT Jira") || toolname.contains("ADOP Jira")  || toolname.equalsIgnoreCase("Cloud Jira")) && flownordeletedwithactivateddate.equalsIgnoreCase("flown with activated date same as ModifiedAtSourceOn"))
				 WorkItemExternalId = getWorkItemExternalID(workitem,toolname);
			if((toolname.contains("ADT Jira") || toolname.contains("ADOP Jira") || toolname.equalsIgnoreCase("Cloud Jira")) && flownordeletedwithactivateddate.equalsIgnoreCase("flown without activated date") )
				 {
							//syntax - getWorkItemExternalIDForOldWorkItems(workitem,toolname,nameofthefunctionality);
					WorkItemExternalId = getWorkItemExternalIDForOldWorkItems(workitem,toolname,"ScrumBan");
				 }
			
			 String WorkItemOrDeliverableOrIterationOrTestOrRequirement=SetEntityTypeForPostURL(workitem);
			 Response response = PostRequesttoGetIBResponse(WorkItemTypeUId, WorkItemExternalId, workitem, "NonFlat", toolname);
			

					 if(toolname.contains("TFS")){
							 List<ArrayList<String>> NameField = response.jsonPath().get("WorkItems.WorkItemAttributes.Name");
							 for(ArrayList j:NameField)
							 {
								 if(j.contains("ActivatedDate")){
		//									
									 List<ArrayList<String>> jsonResponse1 = response.jsonPath().get("WorkItems.WorkItemAttributes.Value");
											for(ArrayList<String> value : jsonResponse1)
											{
												if(flownordeletedwithactivateddate.equalsIgnoreCase("flown without activated date"))
													Assert.assertEquals(value.get(j.indexOf("ActivatedDate")), "","date present in value field");
													if(flownordeletedwithactivateddate.equalsIgnoreCase("flown with activated date"))
													{
														 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
														 LocalDateTime now = LocalDateTime.now();  
														   Assert.assertTrue(value.get(j.indexOf("ActivatedDate")).contains(dtf.format(now)), "mismtach in activated date");
													}
																						
											}
								 }
								 else
								 {
									 Assert.fail("response doesnt contain activated date field");
								 }
							 }
					 }
					 if(toolname.contains("Jira") || toolname.contains("JIRA") || toolname.equalsIgnoreCase("Rally")){
						 List<ArrayList<String>> NameField = response.jsonPath().get("WorkItems.WorkItemAttributes.Name");
						 for(ArrayList j:NameField)
						 {
							 if(j.contains("ActivatedDate")){
	//									
								 List<ArrayList<String>> jsonResponse1 = response.jsonPath().get("WorkItems.WorkItemAttributes.Value");
										for(ArrayList<String> value : jsonResponse1)
										{
											if(flownordeletedwithactivateddate.equalsIgnoreCase("flown with activated date same as ModifiedAtSourceOn")){
												String ModifiedAtSourceOn = response.jsonPath().get("WorkItems.ModifiedAtSourceOn");
												Assert.assertEquals(value.get(j.indexOf("ActivatedDate")), ModifiedAtSourceOn ,"date mismatch");
											}
												if(flownordeletedwithactivateddate.equalsIgnoreCase("flown without activated date"))
												{
													 Assert.assertEquals(value.get(j.indexOf("ActivatedDate")),"", "mismtach in activated date");
												}
																					
										}
							 }
							 else
							 {
								 Assert.fail("response doesnt contain activated date field");
							 }
						 }
					 }
			}
					 catch(Exception e)
					 {
						 e.printStackTrace();
						 }
					 }

		private static String getWorkItemExternalIDForOldWorkItems(String workitem, String toolname,String functionality) {
			try{
				String testDataPath_WorkItemExternalIDs="";
				if(toolname.equalsIgnoreCase("ADT Jira") && functionality.equalsIgnoreCase("ScrumBan")){
					testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ADTJiraScrumBan.json" ;
				}
				if(toolname.equalsIgnoreCase("Cloud Jira") && functionality.equalsIgnoreCase("ScrumBan")){
					testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_CloudJiraScrumBan.json" ;
				}
				if(toolname.equalsIgnoreCase("ADOP Jira") && functionality.equalsIgnoreCase("ScrumBan")){
					testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ADOPJiraScrumBan.json" ;
				}
				
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader(testDataPath_WorkItemExternalIDs));
				JSONObject jsonObject = (JSONObject) obj;
				String WorkItemExternalId="";
				if(!(workitem.equalsIgnoreCase("ReleaseAndSprint") || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request") ))
					WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_"+workitem);
				else if(workitem.equalsIgnoreCase("Test Execution"))
					WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_TestExecution");
				else if(workitem.equalsIgnoreCase("Work Request"))
					WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_WorkRequest");
				if(workitem.equalsIgnoreCase("ReleaseAndSprint"))
				{
					WorkItemExternalId = (String) jsonObject.get("WorkItemExternalId_"+"ReleaseName");
					WorkItemExternalId = WorkItemExternalId + "&" + (String) jsonObject.get("WorkItemExternalId_"+"SprintName");
				}
				 if(!(WorkItemExternalId.equalsIgnoreCase(null) || WorkItemExternalId.equals("")))
					 return WorkItemExternalId;
				 else{
						logger.info("Workitem "+workitem+" was not created for tool "+toolname);
					 Assert.fail("Workitem "+workitem+" was not created for tool "+toolname);
				 }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "";
		}

		public static void VerifyOutboundForSpecificFunctionality(String workitem, String toolname, String functionality) {
			try{
				String WorkItemTypeUId=null;
				String WorkItemExternalId =getWorkItemExternalID(workitem,toolname);
				if(!(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("TestCase") || workitem.equalsIgnoreCase("Action") || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Milestone")  || workitem.equalsIgnoreCase("TestExecution") || workitem.equalsIgnoreCase("Work Request")))
				{
				String getWorkitemType = "WorkItemTypeUId_"+workitem;
				WorkItemTypeUId = Property.getProperty(getWorkitemType);
				}

					VerifyOutboundWorkItemReponseForSpecificFunctionality(WorkItemTypeUId,WorkItemExternalId,toolname,workitem,functionality);
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}

		private static void VerifyOutboundWorkItemReponseForSpecificFunctionality(String workItemTypeUId,String workItemExternalId, String toolname, String workitem,String functionality) {
			try{
				String FlatNonFlarURL = "NonFlat";
				
				Response responsebodyFromIB = PostRequesttoGetIBResponse_custom(workItemTypeUId,workItemExternalId,workitem,FlatNonFlarURL,toolname,functionality);
				 putOutBoundBodyInTempFile(responsebodyFromIB.getBody().asString());
				 String CorrelationUID = PrepareOutBoundBodyWithRequiredDataAndGetCorrelationID(toolname,workitem);
				 if(functionality.equalsIgnoreCase("DFT"))
				 {
					 Baseclass.getInstance().CorrelationUID_OB = CorrelationUID;
					 System.out.println(CorrelationUID);
				 }
				 RequestSpecification request = RestAssured.given();
								 	
				request.header("Content-Type", "application/json")
						.header("Authorization","Bearer "+Property.getToken("Token"))
						.header("AppServiceUId",Property.getProperty("AppServiceUId_OB"))
						.header("CorrelationUId",CorrelationUID);
									 
				 String mywizURL = Property.getProperty("MyWizard_URL");
				 String[] mywizURL_Sp = mywizURL.split(".com");
				 mywizURL = mywizURL_Sp[0]+".com/core";
				 mywizURL = mywizURL.replace("mywizard", "mywizardapi");
				String temprepsonsefile= System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator	+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" +  File.separator + "ResponseFile_Temp.json";
				request.body(new File(temprepsonsefile));
				
				
				String posturlmerge="";
				if(!(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("Deliverable") || workitem.equalsIgnoreCase("TestCase") || workitem.equalsIgnoreCase("Action")  || workitem.equalsIgnoreCase("Decision") || workitem.equalsIgnoreCase("Milestone")  || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request")))
				posturlmerge = mywizURL+"/v1/MergeWorkItem?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("TestCase"))
					posturlmerge = mywizURL+"/v1/Test1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Requirement"))
					posturlmerge = mywizURL+"/v1/Requirement1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Action"))
					posturlmerge = mywizURL+"/v1/Action1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Decision"))
					posturlmerge = mywizURL+"/v1/Decision1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Milestone"))
					posturlmerge = mywizURL+"/v1/Milestone1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Test Execution"))
					posturlmerge = mywizURL+"/v1/TestResult?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Deliverable"))
					posturlmerge = mywizURL+"/v1/Deliverable1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Work Request"))
					posturlmerge = mywizURL+"/v1/ChangeRequest1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
//				posturlmerge = mywizURL+"/v1/ChangeRequest1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				
				
				Response response = request.post(posturlmerge);
//				System.out.println(response.getStatusCode());
				 Assert.assertEquals(response.getStatusCode(), 200);
				String responsebody = response.getBody().asString();
				System.out.println(responsebody);
//				response.jsonPath().get
				int updatecount = response.jsonPath().get("MergeResult.UpdateCount");
//				System.out.println("updatecount: "+updatecount);
				if(!(updatecount==1))
					logger.info("update count for workitem "+workitem+ " is 0. OB issue for the given tool "+toolname);
				 Assert.assertEquals(updatecount, 1); 

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		public static void VerifyNorthStarEntities(String workitem, String flownOrDeleted, String toolname) {

			String WorkItemExternalId="";
			String NorthStarEntityName="";
			String Entities_JSONFile = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" + File.separator + "NorthStarWorkItemIDs.json";
			try{
				switch(workitem.toLowerCase())
					{
					case "northstar":
						WorkItemExternalId =Integer.toString(getWorkItemExternalID_NorthStarEntity(workitem));
						NorthStarEntityName="NorthStars";
						UpdateNorthStarEntityID(workitem,WorkItemExternalId);
						break;
					case "businessunit":
						WorkItemExternalId =Integer.toString(getWorkItemExternalID_NorthStarEntity(workitem));
						NorthStarEntityName="BusinessUnits";
						UpdateNorthStarEntityID(workitem,WorkItemExternalId);
						break;
						
					case "serviceline":
						WorkItemExternalId =Integer.toString(getWorkItemExternalID_NorthStarEntity(workitem));
						NorthStarEntityName="ServiceLines";
						UpdateNorthStarEntityID(workitem,WorkItemExternalId);
						break;
					case "businessprocess":
						WorkItemExternalId =Integer.toString(getWorkItemExternalID_NorthStarEntity(workitem));
						NorthStarEntityName="BPHNodes";
						UpdateNorthStarEntityID(workitem,WorkItemExternalId);
						break;
					case "itkpi":
						WorkItemExternalId =Integer.toString(getWorkItemExternalID_NorthStarEntity(workitem));
						UpdateNorthStarEntityID(workitem,WorkItemExternalId);
						NorthStarEntityName="KPIs";
						break;
					case "businesskpi":
						WorkItemExternalId =Integer.toString(getWorkItemExternalID_NorthStarEntity(workitem));
						NorthStarEntityName="KPIs";
						UpdateNorthStarEntityID(workitem,WorkItemExternalId);
						break;
					}
				RequestSpecification request = RestAssured.given();
			 	
				 request.header("Content-Type", "application/json")
				        .header("Authorization","Bearer "+Property.getToken("Token"))
				        .header("AppServiceUId",Property.getProperty("AppServiceUId"));
				 
				 JSONObject requestParams = new JSONObject();
				 
				 String PostUrl="";
				 String mywizURL = Property.getProperty("MyWizard_URL");
				 String[] mywizURL_Sp = mywizURL.split(".com");
				 mywizURL = mywizURL_Sp[0]+".com/core";
				 mywizURL = mywizURL.replace("mywizard", "mywizardapi");
				

				 requestParams.put("ClientUId", Property.getProperty("NoToolInstance_ClientUId")); 
				 requestParams.put("DeliveryConstructUId", Property.getProperty("NoToolInstance_DeliveryConstructUId_L2"));
				
				 switch(workitem.toLowerCase())
					{
					case "northstar":
						 requestParams.put("NorthStarExternalId",WorkItemExternalId);
						break;
					case "businessunit":
						requestParams.put("BusinessUnitExternalId",WorkItemExternalId);
						break;
						
					case "serviceline":
						requestParams.put("ServiceLineExternalId",WorkItemExternalId);
						break;
					case "businessprocess":
						requestParams.put("BPHNodeExternalID",WorkItemExternalId);
						break;
					case "itkpi":
						requestParams.put("KPIExternalId",WorkItemExternalId);
						break;
					case "businesskpi":
						requestParams.put("KPIExternalId",WorkItemExternalId);
						break;
					}
				 request.body(requestParams.toJSONString());
				 PostUrl = mywizURL+"/v1/"+NorthStarEntityName+"/"+"Query"+"?clientUId="+Property.getProperty("NoToolInstance_ClientUId")+"&deliveryConstructUId="+Property.getProperty("NoToolInstance_DeliveryConstructUId_L2");
				 Response response = request.post(PostUrl);
				 JsonPath js = response.jsonPath();
				 
				 String responsebody = response.getBody().asString();
				 System.out.println(response.getStatusCode());
				 System.out.println(responsebody);
				 switch(workitem.toLowerCase())
					{
					case "northstar":
						 System.out.println(response.jsonPath().getString("NorthStars[0].Title"));
						break;
					case "businessunit":
						 System.out.println(response.jsonPath().getString("BusinessUnits[0].Title"));
						 VerifyassociationforNorthStarEntity(response.jsonPath(),"BusinessUnits.BusinessUnitAssociations.AssociationTypeUId","BusinessUnits.BusinessUnitAssociations.ItemExternalId",workitem,"NorthStar");
						break;
						
					case "serviceline":
						 System.out.println(response.jsonPath().getString("ServiceLines[0].Title"));
						 VerifyassociationforNorthStarEntity(response.jsonPath(),"ServiceLines.ServiceLineAssociations.AssociationTypeUId","ServiceLines.ServiceLineAssociations.ItemExternalId",workitem,"BusinessUnit");
						break;
					case "businessprocess":
						System.out.println(response.jsonPath().getString("BPHNodes[0].Title"));
						 VerifyassociationforNorthStarEntity(response.jsonPath(),"BPHNodes.BPHNodeAssociations.AssociationTypeUId","BPHNodes.BPHNodeAssociations.ItemExternalId",workitem,"ServiceLine");
						break;
					case "businesskpi":
						System.out.println(response.jsonPath().getString("KPIs[0].Title"));
						 VerifyassociationforNorthStarEntity(response.jsonPath(),"KPIs.KPIAssociations.AssociationTypeUId","KPIs.KPIAssociations.ItemExternalId",workitem,"BusinessProcess");
						break;
					
					case "itkpi":
						System.out.println(response.jsonPath().getString("KPIs[0].Title"));
						 VerifyassociationforNorthStarEntity(response.jsonPath(),"KPIs.KPIAssociations.AssociationTypeUId","KPIs.KPIAssociations.ItemExternalId",workitem,"BusinessKPI");
						break;
					}
				
			}catch(Exception e)
				{
					e.printStackTrace();
					logger.info("Could not get WorkItemExternalId for "+workitem+" for the tool "+toolname);
					Assert.fail("Could not get WorkItemExternalId for "+workitem+" for the tool "+toolname);
				}
			
		}

		public static void VerifyassociationforNorthStarEntity(JsonPath jsonPath, String AssociationTypeUId, String ItemExternalId,  String workitem,String parent) {
			List<ArrayList<String>> AssociationtypeUid = jsonPath.get(AssociationTypeUId);
			 for(ArrayList j:AssociationtypeUid)
					 {
						 if(j.contains("00200400-0010-0000-0000-000000000000"))
						 {
							 List<ArrayList<String>> itemexternalIDs =jsonPath.get(ItemExternalId);
							 for(ArrayList<String> item : itemexternalIDs)
							{
								System.out.println(item.get(j.indexOf("00200400-0010-0000-0000-000000000000")));
								Assert.assertEquals(item.get(j.indexOf("00200400-0010-0000-0000-000000000000")), ReadNorthStarWorkItemIDs(parent));
//								
							}
						 }
						 else
							 Assert.fail("parent association missing for workitem "+workitem);
					}
			
		}

		public static String ReadNorthStarWorkItemIDs(String workitem) {
			try{
			String Entities_JSONFile = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" + File.separator + "NorthStarWorkItemIDs.json";
			FileReader reader = new FileReader(Entities_JSONFile);

	        JSONParser jsonParser = new JSONParser();
	        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
	        return (String) jsonObject.get(workitem);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "";
	        
		}

		public static void UpdateNorthStarEntityID(String workitem, String workItemExternalId) {
			try{
			String Entities_JSONFile = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" + File.separator + "NorthStarWorkItemIDs.json";
			
			FileReader reader = new FileReader(Entities_JSONFile);
			JSONParser jsonParser = new JSONParser();
		        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
		        jsonObject.put(workitem, workItemExternalId);        
		        FileOutputStream outputStream = new FileOutputStream(Entities_JSONFile);
				byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);

			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue writing northstar workitem IDs into the json file");
			}
			
		}
		public static void updateworkitemJSONfile(String toolname,String workitem){
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
	            String entityID = "WorkItemExternalId_"+workitem;
	            switch(workitem){
	            	case "Story":
	            		jsonObject.put(entityID,Baseclass.getInstance().WorkItemExternalId_Story);
	            		break;
	            	case "Action":
	            		jsonObject.put(entityID,Baseclass.getInstance().WorkItemExternalId_Action);
	            		break;
	            }
	            
	            FileOutputStream outputStream = new FileOutputStream(testDataPath_WorkItemExternalIDs);
	             byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue updating workitem JSON file for tool "+toolname);
			}
		}
		
		public static int getWorkItemExternalID_NorthStarEntity(String workitem) {
			try{
			String Excelfilepath = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "GenericUploader"+ File.separator +"NoTool" + File.separator +"Excel"+  File.separator + "NorthStar_ClientRepository"+".xlsx" ;	
			FileInputStream fis = new FileInputStream(new File(Excelfilepath));
			XSSFWorkbook workbook = new XSSFWorkbook (fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int rownum = 0;
			switch(workitem.toLowerCase())
			{
			case "northstar":
			rownum= 1;
				break;
			case "businessunit":
				rownum= 2;
				break;
				
			case "serviceline":
				rownum= 3;
				break;
			case "businessprocess":
				rownum= 4;
				break;
			case "businesskpi":
				rownum= 5;
				break;
			case "itkpi":
				rownum= 6;
				break;
			
			}
			System.out.println((int) sheet.getRow(rownum).getCell(14).getNumericCellValue());
			return (int) sheet.getRow(rownum).getCell(14).getNumericCellValue();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return 0;
			
		}
	
	}