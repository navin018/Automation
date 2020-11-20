package testobjects;
import java.io.File;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import static utilities.selenium.SeleniumDSL.*;
import static utilities.general.Property.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
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
						String getWorkitemType = "WorkItemTypeUId_"+workitem;
						if(!(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("Team")))
						 WorkItemTypeUId = Property.getProperty(getWorkitemType);
						
						}
				}catch(Exception e)
					{
						e.printStackTrace();
						Assert.fail("Could not get WorkItemExternalId for "+workitem+" for the tool "+toolname);
					}
				if(workitem.equalsIgnoreCase("ReleaseAndSprint"))
				{
					try{
					WorkItemExternalId = getWorkItemExternalID(workitem,toolname);
					String[] WorkItemExternalId_Sp = WorkItemExternalId.toString().split("&");
					ReleaseName = WorkItemExternalId_Sp[0];
					SprintName = WorkItemExternalId_Sp[1];
					}
					catch(Exception e)
					{
						e.printStackTrace();
						Assert.fail("Could not get ReleaseName or SprintName for "+workitem+" for the tool "+toolname);
					}
				}
				
					VerifyInboundWorkItemReponse(WorkItemTypeUId,WorkItemExternalId,toolname,workitem,ReleaseName,SprintName);
				}
			catch(Exception e)
			{
				e.printStackTrace();
				Assert.fail("Could not verify "+workitem+" for tool "+toolname+". ");
			}
			}

public static String getWorkItemExternalID(String workitem, String toolname){
	
	try{
		String testDataPath_WorkItemExternalIDs="";
		if((toolname.equalsIgnoreCase("ADT Jira") || toolname.equalsIgnoreCase("ADOP Jira")))
		{
			testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs.json" ;
		}
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(testDataPath_WorkItemExternalIDs));
		JSONObject jsonObject = (JSONObject) obj;
		String WorkItemExternalId="";
		if(!workitem.equalsIgnoreCase("ReleaseAndSprint"))
			WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_"+workitem);
		if(workitem.equalsIgnoreCase("ReleaseAndSprint"))
		{
			WorkItemExternalId = (String) jsonObject.get("WorkItemExternalId_"+"ReleaseName");
			WorkItemExternalId = WorkItemExternalId + "&" + (String) jsonObject.get("WorkItemExternalId_"+"SprintName");
		}
		 if(!WorkItemExternalId.equalsIgnoreCase(null))
			 return WorkItemExternalId;
		 else
			 Assert.fail("Workitem "+workitem+" was not created for tool "+toolname);
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
				if(!(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement")))
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
		
		public static void VerifyInboundWorkItemReponse(String WorkItemTypeUId, String WorkItemExternalId,String toolname,String workitem,String ReleaseName,String SprintName ){
			
			try{
				
				 
				 String WorkItemOrDeliverableOrIterationOrTestOrRequirement="";
				 if(!(workitem.equalsIgnoreCase("Deliverable") || workitem.equalsIgnoreCase("ReleaseAndSprint")  || workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("Team")))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="WorkItems"; 
				 if(workitem.equalsIgnoreCase("Deliverable"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Deliverables";
				 if(workitem.equalsIgnoreCase("ReleaseAndSprint"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Iterations";	
				 if(workitem.equalsIgnoreCase("Test"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Tests";	
				 if(workitem.equalsIgnoreCase("Requirement"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Requirements";
				 if(workitem.equalsIgnoreCase("Team"))
					 WorkItemOrDeliverableOrIterationOrTestOrRequirement="DeliveryConstructsByDeliveryConstructType";
								 
				 Response response = PostRequesttoGetIBResponse(WorkItemTypeUId, WorkItemExternalId, workitem, "Flat", toolname);
			 
				 JsonPath js = response.jsonPath();
				 
				 String responsebody = response.getBody().asString();
//				 System.out.println(responsebody);
				 
				 
				 String workitem_title="";
				 String ReleaseStartDate="";
				 String ReleaseEndDate="";
				 
				 if(!(workitem.equalsIgnoreCase("ReleaseAndSprint") || workitem.equalsIgnoreCase("Team")))
				 workitem_title = getTitle(toolname, workitem);
				 if(workitem.equalsIgnoreCase("ReleaseAndSprint"))
				 {
					 String ReleaseDates = getTitle(toolname,workitem);
					 String[] ReleaseDates_sp = ReleaseDates.split("&");
					 ReleaseStartDate = ReleaseDates_sp[0];
					 ReleaseEndDate = ReleaseDates_sp[1];
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
				 Assert.assertEquals(TitleFromAPI, workitem_title,"title mismatch for workitem "+workitem +" for the given tool "+toolname);
				
				 }
				 
				 
				 //DeliveryConstructUId for WorkItems 
				 List<Object> DCUid=null;
				 if(!(workitem.equalsIgnoreCase("Deliverable") || workitem.equalsIgnoreCase("ReleaseAndSprint") || workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement") || workitem.equalsIgnoreCase("Team")))
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
				 if(workitem.equalsIgnoreCase("Test"))
				 {
					 Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				 DCUid = js.getList("Tests.TestDeliveryConstructs.DeliveryConstructUId");	
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
									 String ReleaseStartDateFromAPI = response.jsonPath().getString("Iterations[" + p + "].StartOn");
									 String ReleaseEndDateFromAPI = response.jsonPath().getString("Iterations[" + p + "].EndOn");
									 CompareReleaseDate(ReleaseStartDateFromAPI,ReleaseStartDate,toolname);
									 CompareReleaseDate(ReleaseEndDateFromAPI,ReleaseEndDate,toolname);
									 break;
								 }
						
							 }
							 
							 for(int p=0; p<size;p++)
							 {
								 
								 String name = response.jsonPath().getString("Iterations[" + p + "].Name");
								 if(name.equalsIgnoreCase(SprintName))
								 
								 {
									 sprintfound=true;
									 break;
								 }
						
							 }
							 if(!releasefound)
								 Assert.fail("Release not flown for "+toolname);
							 if(!sprintfound)
								 Assert.fail("Sprint not flown for "+toolname);
						
						 }
				 }
					 catch(Exception e)
					 {
						e.printStackTrace();
						Assert.fail("Issue verfying release/sprint for tool "+toolname);
					 
					 }
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Assert.fail("Issue verfying IB response for "+workitem+ " for toolname "+toolname);
			}
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
	 
	 if(!(workitem.equalsIgnoreCase("Deliverable") || workitem.equalsIgnoreCase("ReleaseAndSprint")  || workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement")  || workitem.equalsIgnoreCase("Team")))
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
	 if(workitem.equalsIgnoreCase("Test") )
	 {
		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId_L2"));
		 requestParams.put("TestExternalId",WorkItemExternalId);
		 WorkItemOrDeliverableOrIterationOrTestOrRequirement="Tests";				 
	 }
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
	
	 
	 request.body(requestParams.toJSONString());
	 String QueryType="";
	 if(FlatNonFlarURL.equalsIgnoreCase("Flat"))
		 QueryType = "Query/Flat";
	 if(FlatNonFlarURL.equalsIgnoreCase("NonFlat"))
		 QueryType = "Query";
	 if(!workitem.equalsIgnoreCase("Team"))
	 PostUrl = mywizURL+"/v1/"+WorkItemOrDeliverableOrIterationOrTestOrRequirement+"/"+QueryType+"?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
	 if(workitem.equalsIgnoreCase("Team"))
		 PostUrl = mywizURL+"/v1/"+WorkItemOrDeliverableOrIterationOrTestOrRequirement+"?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId=null&deliveryConstructTypeUId=00200020-0000-0000-0000-000000000000";
	
	 Response response=null;
	 if(!workitem.equalsIgnoreCase("Team"))
	 response = request.post(PostUrl);
	 else if(workitem.equalsIgnoreCase("Team"))
		 response = request.get(PostUrl); 
//	 System.out.println(response.getBody().asString());
	 if(response.getStatusCode()!=200)
	 {
		 if(response.getStatusCode()==401)
			 Assert.fail("Got "+response.getStatusCode()+" reponse code for "+workitem+" for the given tool "+toolname + " please refresh the token");
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
			if(!workitem.equalsIgnoreCase("ReleaseAndSprint"))
			{
			 wi = DataManager.getData(testDataPath_WorkItem, "WorkItem",WorkItemDO.class).item.get(workitem+"_01");
			return wi.Summary;
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
		  	if(!(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement")))
		  			{
		   finaljson = json.set("WorkItems[0].CorrelationUId", GUid.toString());
		   finaljson = json.set("WorkItems[0].ItemState", 1);
		   finaljson = json.set("WorkItems[0].CreatedByApp", "myWizard.IssueManagement");
		   finaljson = json.set("WorkItems[0].ModifiedByApp", "myWizard.IssueManagement");
		   finaljson = json.set("WorkItems[0].WorkItemAttributes[0].Value", getTitle(toolname,workitem)+"_OB");
		   finaljson = json.set("WorkItems[0].ModifiedAtSourceOn", (new Random().nextInt(2)+2024+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(12)+1)))+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(28)+1)))+"T18:48:07.6972433"));
		  			}
		  	if((workitem.equalsIgnoreCase("Test")))
		  			{
		   finaljson = json.set("Tests[0].CorrelationUId", GUid.toString());
		   finaljson = json.set("Tests[0].ItemState", 1);
		   finaljson = json.set("Tests[0].CreatedByApp", "myWizard.IssueManagement");
		   finaljson = json.set("Tests[0].ModifiedByApp", "myWizard.IssueManagement");
		   finaljson = json.set("Tests[0].Title", getTitle(toolname,workitem)+"_OB");
		   finaljson = json.set("Tests[0].ModifiedAtSourceOn", (new Random().nextInt(2)+2024+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(12)+1)))+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(28)+1)))+"T18:48:07.6972433"));
		  			}
			if((workitem.equalsIgnoreCase("Requirement")))
  			{
	   finaljson = json.set("Requirements[0].CorrelationUId", GUid.toString());
	   finaljson = json.set("Requirements[0].ItemState", 1);
	   finaljson = json.set("Requirements[0].CreatedByApp", "myWizard.IssueManagement");
	   finaljson = json.set("Requirements[0].ModifiedByApp", "myWizard.IssueManagement");
	   finaljson = json.set("Requirements[0].Title", getTitle(toolname,workitem)+"_OB");
	   finaljson = json.set("Requirements[0].ModifiedAtSourceOn", (new Random().nextInt(2)+2024+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(12)+1)))+"-"+String.format("%02d", Integer.valueOf(String.valueOf(new Random().nextInt(28)+1)))+"T18:48:07.6972433"));
  			}
		  	
		   JSONParser parser = new JSONParser();
		   JSONObject jsonObject = (JSONObject) parser.parse(finaljson.jsonString());
		   
		   String requiredNode_WorkItemNodeOnly=null;
			if(!(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement")))
				requiredNode_WorkItemNodeOnly = (String) jsonObject.get("WorkItems").toString();
			if(workitem.equalsIgnoreCase("Test"))
			requiredNode_WorkItemNodeOnly = (String) jsonObject.get("Tests").toString();
			if((workitem.equalsIgnoreCase("Requirement")))
				requiredNode_WorkItemNodeOnly = (String) jsonObject.get("Requirements").toString();
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
				if(!(workitem.equalsIgnoreCase("Test") || workitem.equalsIgnoreCase("Requirement")))
				posturlmerge = mywizURL+"/v1/MergeWorkItem?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Test"))
					posturlmerge = mywizURL+"/v1/Test1?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				else if(workitem.equalsIgnoreCase("Requirement"))
					posturlmerge = mywizURL+"/v1/Requirement?"+"clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
				
				
				
				Response response = request.post(posturlmerge);
//				System.out.println(response.getStatusCode());
				 Assert.assertEquals(response.getStatusCode(), 200);
				String responsebody = response.getBody().asString();
//				System.out.println(responsebody);
//				response.jsonPath().get
				int updatecount = response.jsonPath().get("MergeResult.UpdateCount");
//				System.out.println("updatecount: "+updatecount);
//				 Assert.assertEquals(updatecount, 1); 

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}


		public static void CompareReleaseDate(String ReleaseDateFromAPI,String ReleaseDateFromJSON,String toolname)
		{
			try{
				
			String[] ReleaseDateFromAPI_sp	= ReleaseDateFromAPI.split("T");
			
			Date date = new SimpleDateFormat("d/MMM/yy").parse(ReleaseDateFromJSON);
			SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd");
//			System.out.println(sdfDestination.format(date).toString());
//			System.out.println(ReleaseDateFromAPI_sp[0]);
			Assert.assertEquals(ReleaseDateFromAPI_sp[0],sdfDestination.format(date).toString(),"Release dates mistmatch for tool "+toolname);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Assert.fail("Data mismatch for release date for the tool "+toolname);
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
				Assert.assertEquals(TitleFromAPI, workitem_title,"title mismatch for workitem "+workitem +" for the given tool "+toolname);
				Assert.assertEquals(totalrecordcount, 1,workitem +" not flown for tool "+toolname);
				List<Object>  DCUid = js.getList("WorkItems.WorkItemDeliveryConstructs.DeliveryConstructUId");
				  Assert.assertTrue(!DCUid.toString().contains(Property.getProperty("DeliveryConstructUId_L2")),workitem+" is not associated to the required DCUId for tool "+toolname);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Assert.fail("Problem verifying the Dc Removal scenario for toolname "+toolname);
			}
		}
		
	
	}