package Practice;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.testng.asserts.SoftAssert;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import utilities.general.Property;

public class softassert {

	public static void main(String[] args) throws IOException {
		
		 String mywizURL = Property.getProperty("MyWizard_URL");
		 mywizURL = mywizURL.replace("mywizard", "mywizardapi");
		 
		 
		 JSONObject json = new JSONObject("{\"data\":[{\"city\":\"New York\",\"name\":\"John\",\"age\":31},{\"city\":\"Paris\",\"name\":\"Jack\",\"age\":12}]}");
		 DocumentContext doc = JsonPath.parse(json.toString())
		                 .set("$..name","newName");
		 System.out.println("doc.jsonString() = " + doc.jsonString());

		
	}

}
