package utilities.testng;

import java.util.HashMap;

/** 
 * Holds the platform/browser combination data read from IRIS and used to drive TestNG
 * 
 */
public class Configuration {

	HashMap<String, String> data;
	
	public Configuration(HashMap<String, String> newData) {
		data = newData;
	}
	
	public String getPlatform() {
		return data.get("platform_name");
	}
	
	public String getBrowser() {
		return data.get("browser_api_name");
	}
	
	public String getBrowserVersion() {
		return data.get("browser_version");
	}
	
	public int getPlatformID() {
		return Integer.parseInt(data.get("platform_id"));
	}
	
	public int getBrowserID() {
		return Integer.parseInt(data.get("browser_id"));
	}

}