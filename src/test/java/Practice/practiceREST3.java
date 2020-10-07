package Practice;

import static io.restassured.RestAssured.*;

import java.io.IOException;
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
import org.codehaus.groovy.*;
import groovy.json.JsonSlurper;
public class practiceREST3 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		String multivaluedfields = "[StateUId,PriorityUId,TypeUId]";
		  String[] sp = String.valueOf(multivaluedfields).split("\\[");
		    String[] sp1 = sp[1].split("\\]");
		    String[] sp2 = sp1[0].split(",");
		    for(int i=0;i<sp2.length;i++)
		    {
		    	System.out.print(sp2[i]);
		    }
		    
		
		
		 RequestSpecification request = RestAssured.given();
		 	
		 request.header("Content-Type", "application/json")
		        .header("Authorization","Bearer "+Property.getProperty("Token"))
		        .header("AppServiceUId",Property.getProperty("AppServiceUId"));
		 
		 JSONObject requestParams = new JSONObject();
		 
		 
		 requestParams.put("ClientUId", Property.getProperty("ClientUId")); 
		 requestParams.put("DeliveryConstructUId", Property.getProperty("DeliveryConstructUId"));
		 requestParams.put("EntityUId", "00020040-0200-0000-0000-000000000000");
		 requestParams.put("WorkItemTypeUId", "00020040-0200-0010-0040-000000000000");
		 requestParams.put("ProductInstanceUId", Property.getProperty("ProductInstanceUId"));
		 
		 request.body(requestParams.toJSONString());
//		 String url = Property.getProperty("MyWizard_URL")+"/v1/ProductEntityClientPropertyValues?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId")+"\")";
		 Response response = request.post("https://mywizardapi-devtest-lx.aiam-dh.com/core/v1/ProductEntityClientPropertyValues?clientUId=00100000-0000-0000-0000-000000000000&deliveryConstructUId=9b733b7c-2591-4116-b9fd-85b500400643");
		 									
//		 Response response = request.post(url);
		 System.out.println(response.getStatusCode());
		 System.out.println(response.body().toString());
		 JsonPath js = response.jsonPath();
		
		 
		 
		 int size = js.getInt("EntityPropertyValues.size()");
		
		 Map<String, List<Object>> alldata = new HashMap<>();
		 
		 for(int p=0; p<sp2.length;p++)
		 {
		 
		 for (int i = 0; i < size; i++) {
		        String MultivaluedFeild = js.getString("EntityPropertyValues[" + i + "].Name");
		        if (MultivaluedFeild.equalsIgnoreCase(sp2[p].trim())) {
		            List<Object> EntityPropertyValue = js
		                    .getList("EntityPropertyValues[" + i + "].Values.EntityPropertyValue");
		            List<Object> ProductPropertyValueUId = js
		                    .getList("EntityPropertyValues[" + i + "].Values.ProductPropertyValueUId");
		            List<Object> ProductPropertyValueDisplayName = js
		                    .getList("EntityPropertyValues[" + i + "].Values.ProductPropertyValueDisplayName");
		            System.out.println("Values for EntityPropertyValue : " + sp2[p]+  EntityPropertyValue);
		            System.out.println("Values for ProductPropertyValueUId : " +sp2[p] + ProductPropertyValueUId);
//		            System.out.println("Values for ProductPropertyValueDisplayName : " +sp2[p] + ProductPropertyValueDisplayName);
		          
		          alldata.put(sp2[p]+"_Property", EntityPropertyValue);
		          alldata.put(sp2[p]+"_GUId", ProductPropertyValueDisplayName);
//		          alldata.put("ProductPropertyValueUId", ProductPropertyValueUId);
		          
//		          List<Object> a = EntityPropertyValue;
//		          for(int m=0;m<EntityPropertyValue.size();m++)
//		          {
//		        	  System.out.println(EntityPropertyValue.get(m));
//		          }
		           
		            break;
		        }
		    }
		 }
	List<Object> epv = alldata.get("EntityPropertyValue");
	List<Object> displayname = alldata.get("ProductPropertyValueDisplayName");
	List<Object> guid = alldata.get("ProductPropertyValueUId");
	for(int j=0;j<epv.size();j++)
	{
		System.out.println(epv.get(j) +":"+displayname.get(j) + ":" + guid.get(j) );
		
	}
		 
//		if(alldata.containsKey("StateUId_Property"))
//			System.out.println("okkkkkk" + alldata.get("StateUId_Property"));
//		 
//		 
//		 
		 
		 
		 
		 
		 
	 
		
	}

}
