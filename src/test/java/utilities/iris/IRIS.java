package utilities.iris;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.testng.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class IRIS {

	APICaller api;
	private int executionID = -1;
	private ArrayList<Configuration> configurations;

	public IRIS(String host, int executionID) throws Exception {
		
		// Marking execution as running
		this.executionID = executionID;
		api = new APICaller(host);
		api.setExecutionStatus(executionID, "RUNNING");
		
		// Getting configurations
		JSONArray configs = api.getExecutionCapabilities(executionID).getJSONArray("data");
		
		configurations = new ArrayList<Configuration>();
		for (int i = 0; i < configs.length(); i++) {
			
			HashMap<String, String> capabilities = new HashMap<String, String>();
			
			JSONObject configCapabilities = configs.getJSONObject(i);
			capabilities.put("platform_name", configCapabilities.getString("platform_name"));
			capabilities.put("platform_id", configCapabilities.getString("platform_id"));
			capabilities.put("browser_api_name", configCapabilities.getString("browser_api_name"));
			capabilities.put("browser_version", configCapabilities.getString("browser_version"));
			capabilities.put("browser_id", configCapabilities.getString("browser_id"));
//			capabilities.put("provider_name", configCapabilities.getString("provider_name"));
			configurations.add(new Configuration(capabilities));

		}

	}

	
	public ArrayList<Configuration> getConfigurations() throws Exception {
		return configurations;
	}


	public void takeScreenshot(WebDriver driver, Configuration currentConfiguration, int stepNumber, String stepDescription) throws Exception {

		String currentURL = driver.getCurrentUrl();
		String pageTitle = driver.getTitle();
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		System.out.println(api.uploadScreenshot(executionID, currentConfiguration.getPlatformID(), currentConfiguration.getBrowserID(), stepNumber, stepDescription, currentURL, pageTitle, screenshot));
	}


	public void markExecutionError() throws Exception {
		api.setExecutionStatus(executionID, "ERROR");
	}
	
	public void markExecutionComplete() throws Exception {
		api.setExecutionStatus(executionID, "DONE");
	}
}