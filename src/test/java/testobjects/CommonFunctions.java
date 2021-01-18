package testobjects;
import java.io.*; 
import java.util.*; 
import static utilities.reporting.LogUtil.logger;
import static utilities.reporting.Reporting.create_logs_and_report;

import static utilities.selenium.SeleniumDSL.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.general.Property;

public class CommonFunctions {
	
	public static String SpiltWorkitem(String fullworkitemID)
	{
		
			if(fullworkitemID!=null)
			{
			String fullworkitem_sp [] = fullworkitemID.split(" ");
			System.out.println(fullworkitem_sp.length);
			int s = fullworkitem_sp.length;
			return fullworkitem_sp[fullworkitem_sp.length-1];
			}
		else
			return null;
}

	public static void copyFileContentFromOneFileToAnother(File A, File B) throws IOException { 
        FileInputStream in = new FileInputStream(A); 
        FileOutputStream out = new FileOutputStream(B); 
  
        try { 
  
            int n; 
  
            // read() function to read the 
            // byte of data 
            while ((n = in.read()) != -1) { 
                // write() function to write 
                // the byte of data 
                out.write(n); 
            } 
        } 
        finally { 
            if (in != null) { 
  
                // close() function to close the 
                // stream 
                in.close(); 
            } 
            // close() function to close 
            // the stream 
            if (out != null) { 
                out.close(); 
            } 
        } 
        System.out.println("Property File loaded"); 
        logger.info("Property File loaded"); 
    } 
	public static void generateToken(String env) throws IOException {
		try{
		switch(env){
		case "DevTest":
		case "devtest":
			String PostUrl="https://login.microsoftonline.com/f3211d0e-125b-42c3-86db-322b19a65a22/oauth2/token";
			 Response response = RestAssured
					    .given()
					    .header("Content-Type", "application/x-www-form-urlencoded")
					    .formParam("grant_type", "client_credentials")
					    .formParam("client_id", "af3d00bb-72bd-4ad9-8ea6-b5dd5c650aed")
					    .formParam("resource","af3d00bb-72bd-4ad9-8ea6-b5dd5c650aed")
					    .formParam("client_secret", "Y1N2T2VzIyV3dFJ4JUJnNA==")
					    .request()
					    .post(PostUrl);
			 Thread.sleep(10000);
			 if(response.getStatusCode()!=200)
				 {
					logger.info("Got "+response.getStatusCode()+" reponse code for "+env+" for the Token Generation ");
						 Assert.fail("Got "+response.getStatusCode()+" reponse code for "+env+" for the Token Generation ");
						
				 }
				 Assert.assertEquals(response.getStatusCode(), 200);
				 logger.info("token gen comlpete");
				 JsonPath js = response.jsonPath();
					String token = js.get("access_token");
					Property.setProperty("Token", token);
			break;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Issue generating the token for "+env+" environment");
		}
	}

	public static void checkoverallstatusofworkitemcreation(String env) {
		if(Baseclass.getInstance().workitemcreation_fail)
			Assert.fail("Issue with workitem creation for "+env);
		
	}

	
	
	
	
		
	}
