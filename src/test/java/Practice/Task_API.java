package Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.general.Property;

public class Task_API {

	public static void main(String[] args) {
		
		try{
			RequestSpecification request = RestAssured.given();
		 	
			 request.header("Content-Type", "application/json")
			        .header("Authorization","Bearer "+Property.getProperty("Token"))
			        .header("AppServiceUId",Property.getProperty("AppServiceUId"));
			 
			 JSONObject requestParams = new JSONObject();
			 
			 
			 requestParams.put("ClientUId", "00100000-0000-0000-0000-000000000000"); 
			 requestParams.put("DeliveryConstructUId", "9b733b7c-2591-4116-b9fd-85b500400643");
			 requestParams.put("WorkItemTypeUId", "00020040-0200-0010-0050-000000000000");
			 requestParams.put("WorkItemExternalId", "BOM-3296");
		
			 
			 request.body(requestParams.toJSONString());
			 
			String url = "https://mywizardapi-devtest-lx.aiam-dh.com/core/v1/WorkItems/Query/flat?clientUId=00100000-0000-0000-0000-000000000000&deliveryConstructUId=9b733b7c-2591-4116-b9fd-85b500400643&includeCompleteHierarchy=false";
			 
//			 String url = mywizURL+"/v1/ProductEntityClientPropertyValues?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId")+"\")";

			 Response response = request.post(url);
			 //add validation to check if response is 200
			 System.out.println(response.getStatusCode());
//			 System.out.println(response.getBody().asString());
			 List<String> jsonResponse = response.jsonPath().getList("WorkItems");
			 JsonPath js = response.jsonPath();
			ArrayList<String> wi = js.get("WorkItems");
			System.out.println(wi);
			System.out.println(wi.size());
			List<Object> a = js.getList("WorkItems.WorkItemDeliveryConstructs.DeliveryConstructUId");
			System.out.println(a.toString());
			
			if(a.toString().contains("0af1f80f-5ca7-4bea-966d-eb3aee0ed6b1"))
				System.out.println("yes");
//			String[] sp = a.toString().split("[");
//			String[] sp2 = sp[1].split("[");
//			String[] sp3 = sp2[1].split("]");
//			String [] sp4 = sp3[0].split(",");
//			System.out.println(sp4);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();}
		}
}
