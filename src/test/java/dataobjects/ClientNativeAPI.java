package dataobjects;
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
import utilities.general.Property;

import org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.codehaus.groovy.*;
import groovy.json.JsonSlurper;
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
public class ClientNativeAPI {
	
	public static Map<String, List<Object>> getClientNativeAPI(String ClientIUd,String DeliveryConstructUId,String EntityUID,String WorkItemTypeUId,String ProductInstanceUId,Object MultiValuedFields){
		try{
			
//			convert object MultiValuedFields to string
			String AllMultiValuedFields1 = String.valueOf(MultiValuedFields);
			String[] AllMultiValuedFields_removeBrace1 = String.valueOf(AllMultiValuedFields1).split("\\[");
		    String[] AllMultiValuedFields_removeBrace2 = AllMultiValuedFields_removeBrace1[1].split("\\]");
		    String[] AllMultiValuedFields = AllMultiValuedFields_removeBrace2[0].split(",");
					
			 RequestSpecification request = RestAssured.given();
			 	
			 request.header("Content-Type", "application/json")
			        .header("Authorization","Bearer "+Property.getProperty("Token"))
			        .header("AppServiceUId",Property.getProperty("AppServiceUId"));
			 
			 JSONObject requestParams = new JSONObject();
			 
			 
			 requestParams.put("ClientUId", ClientIUd); 
			 requestParams.put("DeliveryConstructUId", DeliveryConstructUId);
			 requestParams.put("EntityUId", EntityUID);
			 if(!WorkItemTypeUId.equalsIgnoreCase("NA"))
			 requestParams.put("WorkItemTypeUId", WorkItemTypeUId);
			 requestParams.put("ProductInstanceUId", ProductInstanceUId);
			 
			 request.body(requestParams.toJSONString());
			 
			 
			 String mywizURL = Property.getProperty("MyWizard_URL");
			 String[] mywizURL_Sp = mywizURL.split(".com");
			 mywizURL = mywizURL_Sp[0]+".com/core";
			 mywizURL = mywizURL.replace("mywizard", "mywizardapi");
			 
			 	 
			 String url = mywizURL+"/v1/ProductEntityClientPropertyValues?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId")+"\")";

			 Response response = request.post(url);
			 Assert.assertEquals(response.getStatusCode(), 200);
//			 System.out.println(response.getStatusCode());
			 
			 
			 if((int) response.getStatusCode()==200)
					 {
					 JsonPath js = response.jsonPath();
					 
					 
					 int size = js.getInt("EntityPropertyValues.size()");
					
					 Map<String, List<Object>> alldata = new HashMap<>();
					 
								 for(int p=0; p<AllMultiValuedFields.length;p++)
								 {
								 
									 for (int i = 0; i < size; i++) {
									        String MultivaluedFeild = js.getString("EntityPropertyValues[" + i + "].Name");
									        if (MultivaluedFeild.equalsIgnoreCase(AllMultiValuedFields[p].trim())) {
									            List<Object> EntityPropertyValue = js
									                    .getList("EntityPropertyValues[" + i + "].Values.EntityPropertyValue");
									            List<Object> ProductPropertyValueUId = js
									                    .getList("EntityPropertyValues[" + i + "].Values.ProductPropertyValueUId");
									            List<Object> ProductPropertyValueDisplayName = js
									                    .getList("EntityPropertyValues[" + i + "].Values.ProductPropertyValueDisplayName");
					//				            System.out.println("Values for EntityPropertyValue : " + AllMultiValuedFields[p]+  EntityPropertyValue);
					//				            System.out.println("Values for ProductPropertyValueUId : " +AllMultiValuedFields[p] + ProductPropertyValueUId);
						//			            System.out.println("Values for ProductPropertyValueDisplayName : " +sp2[p] + ProductPropertyValueDisplayName);
									          
									          alldata.put(AllMultiValuedFields[p]+"_Property", EntityPropertyValue);
					//				          alldata.put(AllMultiValuedFields[p]", ProductPropertyValueDisplayName);
									          alldata.put(AllMultiValuedFields[p]+"_GUId", ProductPropertyValueUId);
									           
									            break;
									        }
									    }
								 }
					 //comment out the below part
//					 for(Map.Entry<String, List<Object>> entry : alldata.entrySet())
//					 {
//						 System.out.println(entry.getKey() + " = " + entry.getValue());
//					 }
//					 System.out.println("_________________________________");
					 
					 return alldata;
					
				}
		
		else
				Assert.fail("API response is "+response.getStatusCode());
			
			}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Problem fetching repsonse from client native api");
		}
		return null;
	}
	
	
}
