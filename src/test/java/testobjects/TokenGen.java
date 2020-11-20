package testobjects;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.general.Property;

public class TokenGen {
	
	public static void GenerateToken(String env){
	try{
	RequestSpecification request = RestAssured.given();
 	
	 request.header("Content-Type", "application/json")
	        .header("Authorization","Bearer "+Property.getProperty("Token"))
	        .header("AppServiceUId",Property.getProperty("AppServiceUId"));
	 
	 JSONObject requestParams = new JSONObject();
	 
	 String PostUrl="https://login.microsoftonline.com/f3211d0e-125b-42c3-86db-322b19a65a22/oauth2/token";
	 requestParams.put("grant_type", "client_credentials"); 
	 requestParams.put("client_id", "af3d00bb-72bd-4ad9-8ea6-b5dd5c650aed");
	 requestParams.put("resource","af3d00bb-72bd-4ad9-8ea6-b5dd5c650aed");
	 requestParams.put("client_secret", "Y1N2T2VzIyV3dFJ4JUJnNA==");
	 
	 request.body(requestParams.toJSONString());
	 
	 Response response = request.post(PostUrl);
	 
	 if(response.getStatusCode()!=200)
	 {
			 Assert.fail("Got "+response.getStatusCode()+" reponse code for "+env+" for the Token Generation ");
			
	 }
	 Assert.assertEquals(response.getStatusCode(), 200);
	 
	 JsonPath js = response.jsonPath();
		String token = js.get("access_token");
		System.out.println(token);
	 
	 
	 
	 
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
