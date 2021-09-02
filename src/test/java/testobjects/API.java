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

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import dataobjects.WorkItemDO;
import dataobjects.WorkItemExternalIDDO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import javassist.bytecode.stackmap.BasicBlock.Catch;
import testobjects.Baseclass;
import uiMap.JiraUIMap;

import utilities.general.DataManager;
import utilities.general.Property;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

	public class API extends Baseclass{
		private Baseclass base;
	
		public API()
		{
			
		}
		
		public API(Baseclass base) {
			this.base =base; 
		}
		
		public static String testDataPath = System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "testdata" + File.separator + "Jira" + File.separator + "JSON" +  File.separator;
		
		 public static String workitem_title;

		public static void VerifyInBoundDetails(String Workitem, String toolname,String QueryType, String ClientUID, String DC,String functionality) {
			
			try{
				String WorkItemTypeUId="";
				String WorkItemExternalId="";
//				String Workitem = "Story_wsjf_Multiply_0";
				String workitem = Workitem.split("_")[0];
				//fetch workitemexternalID and workitemtypeID
				try{
					if(!((workitem.contains("Release") || workitem.contains("Sprint"))))
						{
						WorkItemExternalId = API.getWorkItemExternalIDForGivenFunctionality(Workitem,toolname,functionality);
//						System.out.println("workitem id from json file is "+WorkItemExternalId);
						String getWorkitemType = "WorkItemTypeUId_"+workitem;
						if(!(workitem.contains("Test") || workitem.contains("Requirement") || workitem.contains("Team") || workitem.contains("TestCase") || workitem.contains("Action") || workitem.contains("Decision") || workitem.contains("Test Execution") || workitem.contains("Work Request")))
						 WorkItemTypeUId = Property.getProperty(getWorkitemType);
						
						}
				}catch(Exception e)
					{
						e.printStackTrace();
						logger.info("Could not get WorkItemExternalId for "+workitem+" for the tool "+toolname);
						Assert.fail("Could not get WorkItemExternalId for "+workitem+" for the tool "+toolname);
					}
				
				String WorkItemOrDeliverableOrIterationOrTestOrRequirement=Tools.SetEntityTypeForPostURL(workitem);
				 Response response=PostRequesttoGetIBResponse(Workitem,WorkItemTypeUId,WorkItemExternalId,workitem,QueryType,toolname,ClientUID,DC,functionality);
				 if(functionality.equalsIgnoreCase("WSJF"))
				 {
					 validateWSJFFunctionality(Workitem,response,toolname);
				 }
				 if(functionality.equalsIgnoreCase("RAG"))
				 {
					 validateRAGFunctionality(Workitem,response,toolname);
				 }
				 if(functionality.contains("TeamsCheck"))
				 {
					 String checkIfTeamVerificationIsRequired = Tools.checkIfTeamVerificationRequired(toolname,Workitem);
					 if(!(checkIfTeamVerificationIsRequired.equalsIgnoreCase("NA") || checkIfTeamVerificationIsRequired.equalsIgnoreCase("No")))
					 {
						 //verify team details in workitems API
						 if(functionality.contains("flown") || functionality.contains("Flown"))
						 Tools.VerifyTeamDetailsForEntity(response.jsonPath(),workitem,toolname,"flown",checkIfTeamVerificationIsRequired);
						 else if(functionality.contains("Deleted") || functionality.contains("deleted"))
							 Tools.VerifyTeamDetailsForEntity(response.jsonPath(),workitem,toolname,"deleted",checkIfTeamVerificationIsRequired);
					 }
				 }
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}
			
		private static void validateRAGFunctionality(String workitem, Response response, String toolname) {
			String ExpectedRAGValue = GetWSJF_RAG_Inference_ForWorkitem(toolname,workitem,"RAG");
			String ExpectedInferenceValue = GetWSJF_RAG_Inference_ForWorkitem(toolname,workitem,"Inference");
			List<ArrayList<String>> FieldNames = response.jsonPath().get("WorkItems.WorkItemExtensions.FieldName");
			 for(ArrayList j:FieldNames)
					 {
						 if(j.contains("RagStatus"))
						 {
							 List<ArrayList<String>> FieldValues = response.jsonPath().get("WorkItems.WorkItemExtensions.FieldValue");
							 for(ArrayList<String> ae : FieldValues)
							{
								System.out.println("ragStatus is "+ae.get(j.indexOf("RagStatus")));
								String ragStatusfromAPI = ae.get(j.indexOf("RagStatus"));
								Assert.assertEquals(ragStatusfromAPI,ExpectedRAGValue, "Mismatch in RAG value for workitem "+workitem+ " for tool "+toolname);
								
							}
						 }
						 else
							 Assert.fail("RAG tag missing in the response for workitem "+workitem+ " for tool "+toolname);
						 if(j.contains("RagInference"))
						 {
							 List<ArrayList<String>> FieldValues = response.jsonPath().get("WorkItems.WorkItemExtensions.FieldValue");
							 for(ArrayList<String> ae : FieldValues)
							{
								 System.out.println("RagInference is - "+ae.get(j.indexOf("RagInference")));
									String InferenceStatusfromAPI = ae.get(j.indexOf("RagInference"));
									Assert.assertEquals(InferenceStatusfromAPI, ExpectedInferenceValue,"Mismatch in RagInference value for workitem "+workitem+ " for tool "+toolname);
							}
						 }
						 else
							 Assert.fail("RagInference tag missing in the response for workitem "+workitem+ " for tool "+toolname);
						 
					}
			}
			
		

		public static void validateWSJFFunctionality(String workitem, Response response, String toolname) {
			String ExpectedWSJFValue = GetWSJF_RAG_Inference_ForWorkitem(toolname,workitem,"WSJF");
			String testprocessname = GetTestProcessName(toolname,workitem);
			List<ArrayList<String>> FieldNames = response.jsonPath().get("WorkItems.WorkItemExtensions.FieldName");
			 for(ArrayList j:FieldNames)
					 {
						 if(j.contains(testprocessname))
						 {
							 List<ArrayList<String>> FieldValues = response.jsonPath().get("WorkItems.WorkItemExtensions.FieldValue");
							 for(ArrayList<String> ae : FieldValues)
							{
								System.out.println(ae.get(j.indexOf(testprocessname)));
								float wsjf_API = Float.parseFloat((ae.get(j.indexOf("testprocessname"))));
								Assert.assertEquals(ExpectedWSJFValue, wsjf_API, "Mismatch in wsjf value for workitem "+workitem+ " for tool "+toolname);
							}
						 }
						 else
							 Assert.fail("WSJF tag missing in the response for workitem "+workitem+ " for tool "+toolname);
					}
			}

			
		public static String GetTestProcessName(String toolname, String workitem) {
			try{
				String testDataPath = System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator
						+ "resources" + File.separator + "testdata" + File.separator;
				
				String testDataPath_testprocessfilepath="";
				if((toolname.equalsIgnoreCase("ADT Jira") || toolname.equalsIgnoreCase("ADOP Jira") || toolname.contains("Jira") || toolname.contains("JIRA")))
				
					testDataPath_testprocessfilepath = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "TestProcess_PreComputation_WSJF.json" ;
				else if((toolname.equalsIgnoreCase("TFS Agile") || toolname.equalsIgnoreCase("TFS Scrum") || toolname.contains("TFS")))
					testDataPath_testprocessfilepath = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "TestProcess_PreComputation_WSJF.json" ;
				FileReader reader = new FileReader(testDataPath_testprocessfilepath);

		        JSONParser jsonParser = new JSONParser();
		        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
		        String testprocessname = (String) jsonObject.get("TestProcess_WSJF_"+workitem);
		        String testprocesstoreturn[] = testprocessname.split("_");
				String testprocessnamewithoutSpecialChars = "";
		        for(int i =0;i<testprocesstoreturn.length;i++)
		        {
		        	testprocessnamewithoutSpecialChars = testprocessnamewithoutSpecialChars.concat(testprocesstoreturn[i]);
		        }
		        return testprocessnamewithoutSpecialChars;
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}

		public static String GetWSJF_RAG_Inference_ForWorkitem(String toolname, String workitem,String WSJF_RAG_Inference) {
			try{
				String testDataPath = System.getProperty("user.dir")+File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator;
				
				String testDataPath_WorkItemExternalIDs="";
				if((toolname.equalsIgnoreCase("ADT Jira") || toolname.equalsIgnoreCase("ADOP Jira") || toolname.contains("Jira") || toolname.contains("JIRA")))
				{
						testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItem.json" ;
				}
				
				else if((toolname.equalsIgnoreCase("TFS Agile") || toolname.equalsIgnoreCase("TFS Scrum") || toolname.contains("TFS")))
				{
					testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator; 
				}		
					WorkItemDO wi = DataManager.getData(testDataPath_WorkItemExternalIDs, "WorkItem",WorkItemDO.class).item.get(workitem);
//					System.out.println(wi.WSJF);
					if(WSJF_RAG_Inference.equalsIgnoreCase("WSJF"))
					return wi.WSJF;
					else if(WSJF_RAG_Inference.equalsIgnoreCase("RAG"))
						return wi.RAG;
					else if(WSJF_RAG_Inference.equalsIgnoreCase("Inference"))
						return wi.Inference;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}

		public static String getWorkItemExternalIDForGivenFunctionality(String workitem, String toolname,String functionality) {
			
			try{
					String testDataPath = System.getProperty("user.dir")
							+ File.separator + "src" + File.separator + "test" + File.separator
							+ "resources" + File.separator + "testdata" + File.separator;
					
					String testDataPath_WorkItemExternalIDs="";
					if((toolname.equalsIgnoreCase("ADT Jira") || toolname.equalsIgnoreCase("ADOP Jira") || toolname.contains("Jira") || toolname.contains("JIRA")))
					{
						if(functionality.contains("WSJF"))
							testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_PreComputation_WSJF.json" ;
						else if(functionality.contains("RAG"))
							testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_PreComputation_RAG.json" ;
						else
						testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs.json" ;
					}
					
					else if((toolname.equalsIgnoreCase("TFS Agile") || toolname.equalsIgnoreCase("TFS Scrum") || toolname.contains("TFS")))
					{
						if(functionality.contains("WSJF"))
							testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_PreComputation_WSJF.json" ;
						else if(functionality.contains("RAG"))
							testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_PreComputation_RAG.json" ;
						else
						testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs.json" ;
					}
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(testDataPath_WorkItemExternalIDs));
			JSONObject jsonObject = (JSONObject) obj;
			String WorkItemExternalId="";
			
			if(functionality.contains("WSJF") || functionality.equalsIgnoreCase("RAG"))
			{
				WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_"+workitem);
			}
			else {
					if(!(workitem.contains("Release") || workitem.contains("Sprint") || workitem.equalsIgnoreCase("Test Execution") || workitem.equalsIgnoreCase("Work Request") || workitem.equalsIgnoreCase("ProductBacklog")))
						WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_"+workitem.split("_")[0]);
					else if(workitem.contains("Test Execution"))
						WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_TestExecution");
					else if(workitem.contains("Work Request"))
						WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_WorkRequest");
					else if(workitem.contains("ProductBacklog"))
						WorkItemExternalId=(String) jsonObject.get("WorkItemExternalId_Story");
			}
			
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
			logger.info("issue fetching workitem external ID for workitem "+workitem);
		}
			return null;
		}

		public static Response PostRequesttoGetIBResponse(String Workitem,String WorkItemTypeUId,String WorkItemExternalId,String workitem,String FlatNonFlarURL,String toolname,String ClientUID,String DC,String functionality){
			try{
			RequestSpecification request = RestAssured.given();
		 	
			 request.header("Content-Type", "application/json")
			        .header("Authorization","Bearer "+Property.getToken("Token"))
			        .header("AppServiceUId",Property.getProperty("AppServiceUId"));
			 
			 JSONObject requestParams = new JSONObject();
			 
			 //frame the URL
			 String PostUrl="";
			 String mywizURL = Property.getProperty("MyWizard_URL");
			 String[] mywizURL_Sp = mywizURL.split(".com");
			 mywizURL = mywizURL_Sp[0]+".com/core";
			 mywizURL = mywizURL.replace("mywizard", "mywizardapi");
			 String EntityType="";
			 
			 if(WorkItemExternalId.equalsIgnoreCase(null) || WorkItemExternalId.equalsIgnoreCase(""))
					Assert.fail("WorkItem "+workitem+ " not created for tool "+toolname);
			 
			 
			 //prepare the body of the request
			 requestParams.put("ClientUId", Property.getProperty(ClientUID)); 
			 requestParams.put("DeliveryConstructUId", Property.getProperty(DC));
			 
			 switch(workitem){
			 
			 case("Deliverable"):
				 requestParams.put("DeliverableExternalId",WorkItemExternalId);
			 	 EntityType="Deliverables";	
				 break;
		
			case("Test"):
			case("TestCase"):
				 requestParams.put("TestExternalId",WorkItemExternalId);
			 	 EntityType="Tests";	
				 break;
			 
			case("Requirement"):
				 requestParams.put("RequirementExternalId",WorkItemExternalId);
			 	 EntityType="Requirements";	
				 break;
				 
			case("Team"):
			 	 EntityType="DeliveryConstructsByDeliveryConstructType";	
				 break;
				 
			case("Action"):
				requestParams.put("ActionExternalId",WorkItemExternalId);
			 EntityType="Actions";
				 break;
				 
			case("Decision"):
				 requestParams.put("DecisionExternalId",WorkItemExternalId);
				EntityType="Decisions";
				 break;
				 
			case("Test Execution"):
				 requestParams.put("TestResultExternalId",WorkItemExternalId);
				EntityType="TestResults";
				 break;
				 
			case("Milestone"):
				 requestParams.put("MilestoneExternalId",WorkItemExternalId);
				EntityType="Milestones";
				 break;
				 
			case("Work Request"):
				 requestParams.put("ChangeRequestExternalId",WorkItemExternalId);
			 		EntityType="ChangeRequests";
				 break;
			 
			case("Release"):
				 requestParams.put("IterationExternalID", Baseclass.getInstance().release_IterationExternalID);
			 		EntityType="Iterations";
				 break;
				 
			case("Sprint"):
				 requestParams.put("IterationExternalID", Baseclass.getInstance().sprint_IterationExternalID);
			 	EntityType="Iterations";
				 break;
			 
			default:
				 requestParams.put("WorkItemTypeUId",WorkItemTypeUId);
				 requestParams.put("WorkItemExternalId", WorkItemExternalId);
				 EntityType="WorkItems";
				break;
			 
			 }
			 			 
			 request.body(requestParams.toJSONString());
			 String QueryType="";
			 if(FlatNonFlarURL.equalsIgnoreCase("Flat"))
				 QueryType = "Query/Flat";
			 if(FlatNonFlarURL.equalsIgnoreCase("NonFlat"))
				 QueryType = "Query";
			 if(!workitem.equalsIgnoreCase("Team"))
			 PostUrl = mywizURL+"/v1/"+EntityType+"/"+QueryType+"?clientUId="+Property.getProperty(ClientUID)+"&deliveryConstructUId="+Property.getProperty(DC)+"&includeCompleteHierarchy=false";
//				 PostUrl = mywizURL+"/v1/"+WorkItemOrDeliverableOrIterationOrTestOrRequirement+"/"+"?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L2")+"&includeCompleteHierarchy=false";
			 if(workitem.equalsIgnoreCase("Team"))
				 PostUrl = mywizURL+"/v1/"+EntityType+"?clientUId="+Property.getProperty(ClientUID)+"&deliveryConstructUId=null&deliveryConstructTypeUId=00200020-0000-0000-0000-000000000000";
			
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
//					 Assert.fail("Got "+response.getStatusCode()+" reponse code for "+workitem+" for the given tool "+toolname + " please refresh the token");
					Assert.fail("Got "+response.getStatusCode()+" reponse code for "+workitem+" for the given tool "+toolname);
			 }
			 Assert.assertEquals(response.getStatusCode(), 200);
			 
			 
			 if(!workitem.equalsIgnoreCase("Team"))
			 {
				 int totalrecordcount = response.jsonPath().get("TotalRecordCount");
				 Assert.assertEquals(totalrecordcount, 1,workitem+ " not flown for IB "+toolname);	
			 }			
			 return response;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}		
	



	}