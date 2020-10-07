package Practice;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.codehaus.groovy.*;
import groovy.json.JsonSlurper;
public class practiceREST2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
	
		RestAssured.baseURI ="https://mywizardapi-devtest-lx.aiam-dh.com/core/v1/ProductEntityClientPropertyValues?clientUId=7313a7b5-37a5-e811-a6ad-8cdcd453ddff&deliveryConstructUId=1645d687-61ef-41e2-b83b-a1930a921483";
		 RequestSpecification request = RestAssured.given();
		 
		
		 request.header("Content-Type", "application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6ImppYk5ia0ZTU2JteFBZck45Q0ZxUms0SzRndyIsImtpZCI6ImppYk5ia0ZTU2JteFBZck45Q0ZxUms0SzRndyJ9.eyJhdWQiOiIyNDQ2N2JjOC1iMzc0LTRiY2UtYjkzOS00MzQwNGExZDkyZjkiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC8zODEyYWU1ZS1jZDRhLTQ1ZTQtOGVmYy1lNjE3YjhlN2M1ZGIvIiwiaWF0IjoxNTk5MzI3OTI4LCJuYmYiOjE1OTkzMjc5MjgsImV4cCI6MTU5OTMzMTgyOCwiYWNyIjoiMSIsImFpbyI6IkUyQmdZRER3WERMcDBSdVRPcS9QK3ZYT3BWK3NWc3pZMmR0a2R5QStPOHRnNWpPVnBlMEEiLCJhbXIiOlsicHdkIl0sImFwcGlkIjoiMDM1N2E1YWItYzY1Ni00YTUzLWFmNzktZmFhMWIzOTAwNjFmIiwiYXBwaWRhY3IiOiIwIiwiaXBhZGRyIjoiNDUuMjUwLjQ2LjEwMSIsIm5hbWUiOiJyYWNoYWtvbmRhLnN1c2VlbGEiLCJvaWQiOiI3NmMxZTYzMy02MGFlLTQ1ODgtYTNlMS1lM2FmMTNlZWZjMzMiLCJwd2RfZXhwIjoiNzQwOTU5IiwicHdkX3VybCI6Imh0dHBzOi8vcG9ydGFsLm1pY3Jvc29mdG9ubGluZS5jb20vQ2hhbmdlUGFzc3dvcmQuYXNweCIsInJoIjoiMC5BQUFBWHE0U09Fck41RVdPX09ZWHVPZkYyNnVsVndOV3hsTktyM242b2JPUUJoOHNBQTQuIiwic2NwIjoiV2ViQXBpTG9naW4iLCJzdWIiOiJKSGk4RzM1c1dSR2pVSERRcWZleDdkT1FCWWpESmhLUlpTeFBURG5idXpVIiwidGlkIjoiMzgxMmFlNWUtY2Q0YS00NWU0LThlZmMtZTYxN2I4ZTdjNWRiIiwidW5pcXVlX25hbWUiOiJyYWNoYWtvbmRhLnN1c2VlbGFAbXdwaG9lbml4Lm9ubWljcm9zb2Z0LmNvbSIsInVwbiI6InJhY2hha29uZGEuc3VzZWVsYUBtd3Bob2VuaXgub25taWNyb3NvZnQuY29tIiwidXRpIjoiZHNqcDhiOUxVMDYyS3ViNUJCeFZBQSIsInZlciI6IjEuMCJ9.EueB_GSiKL4yxvgvVpXYpHQlg1f20fJ6mO3sr3bNrGnSEbY_Pq00Pe98FaDhjvIz2AhYfOt68n2-hLV4hlV5LMiT06D6SMaapIY7jEFxvVJlhwdx6CBMdsREHsntqNwLOn7NLY0mkNUXNWgXI4LXNt78lcn5Qk1taPSIXXFTYgaJe6kERoCZ2ADQs6EEtErFI0N0FbHccfHwxm83SQCdGeXpFuChUMbORT9TJhuTD40roHFIdeXIcA9xH2Guo2ctp4mBPZpJCBIuPhJo60-JjhtrW98gzaBpO7Cz-1E7059Ut-c32xQAbtnNvOWt7u7_AxiU2hFITwo_ibgoRk0N1g").header("AppServiceUId","00000001-0000-0000-0000-000000000000");
		
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("ClientUId", "7313a7b5-37a5-e811-a6ad-8cdcd453ddff"); 
		 requestParams.put("DeliveryConstructUId", "1645d687-61ef-41e2-b83b-a1930a921483");
		 requestParams.put("EntityUId", "00020040-0200-0000-0000-000000000000");
		 requestParams.put("WorkItemTypeUId", "00020040-0200-0010-0040-000000000000");
		 requestParams.put("ProductInstanceUId", "00000019-0000-0000-0000-000000000000");
		 
//		 requestParams.put("ClientUId", "00100000-0000-0000-0000-000000000000"); 
//		 requestParams.put("DeliveryConstructUId", "9b733b7c-2591-4116-b9fd-85b500400643");
//		 requestParams.put("EntityUId", "00020040-0200-0000-0000-000000000000");
//		 requestParams.put("WorkItemTypeUId", "00020040-0200-0010-0040-000000000000");
//		 requestParams.put("ProductInstanceUId", "00000090-0030-0010-0010-000000000000");
		 
		 request.body(requestParams.toJSONString());
		
		
		 Response response = request.post("https://mywizardapi-devtest-lx.aiam-dh.com/core/v1/ProductEntityClientPropertyValues?clientUId=7313a7b5-37a5-e811-a6ad-8cdcd453ddff&deliveryConstructUId=1645d687-61ef-41e2-b83b-a1930a921483");
//		 Response response = request.post("https://mywizardapi-devtest-lx.aiam-dh.com/core/v1/ProductEntityClientPropertyValues?clientUId=00100000-0000-0000-0000-000000000000&deliveryConstructUId=9b733b7c-2591-4116-b9fd-85b500400643");
		 System.out.println(response.getStatusCode());
		 System.out.println(response.body().toString());
		 JsonPath js = response.jsonPath();
		 
		 
		 int size = js.getInt("EntityPropertyValues.size()");
		
		 Map<String, List<Object>> alldata = new HashMap<>();
		 
		 for (int i = 0; i < size; i++) {
		        String MultivaluedFeild = js.getString("EntityPropertyValues[" + i + "].Name");
		        if (MultivaluedFeild.equalsIgnoreCase("StateUId")) {
		            List<Object> EntityPropertyValue = js
		                    .getList("EntityPropertyValues[" + i + "].Values.EntityPropertyValue");
		            List<Object> ProductPropertyValueUId = js
		                    .getList("EntityPropertyValues[" + i + "].Values.ProductPropertyValueUId");
		            List<Object> ProductPropertyValueDisplayName = js
		                    .getList("EntityPropertyValues[" + i + "].Values.ProductPropertyValueDisplayName");
		            System.out.println("Values for EntityPropertyValue : " + EntityPropertyValue);
		            System.out.println("Values for ProductPropertyValueUId : " + ProductPropertyValueUId);
		            System.out.println("Values for ProductPropertyValueDisplayName : " + ProductPropertyValueDisplayName);
		          
		          alldata.put("EntityPropertyValue", EntityPropertyValue);
		          alldata.put("ProductPropertyValueDisplayName", ProductPropertyValueDisplayName);
		          alldata.put("ProductPropertyValueUId", ProductPropertyValueUId);
		           
		            break;
		        }
		    }
		 
	List<Object> epv = alldata.get("EntityPropertyValue");
	List<Object> displayname = alldata.get("ProductPropertyValueDisplayName");
	List<Object> guid = alldata.get("ProductPropertyValueUId");
	for(int j=0;j<epv.size();j++)
	{
		System.out.println(epv.get(j) +":"+displayname.get(j) + ":" + guid.get(j) );
		
	}
		 
		 
		 
		 
		 
		 
		 
		 
//		 System.out.println("Response body: " + response.body().asString());
//		 List<Map<String, String>> epv = response.jsonPath().getList("EntityPropertyValues");
//		 
//		 
//		for(int i=0;i<epv.size();i++)
//		{
//			if(epv.get(i).containsValue("PriorityUId"))
//			{
//				System.out.println("yes");
//				System.out.println(epv.get(i));
////				if(companies.get(i).containsKey("EntityPropertyIdValue"))
////					System.out.println(companies.get(i).values());
//				break;
//			}
//		}
//		 System.out.println(companies.get(0));
		
	
		
		 
		
	}

}
