package utilities.testng;

/** 
 * Used by the TestNG dataprovider class (BrowserComboDP) to store the target server and
 * platform/browser combination details
 */
public class BrowserCombo {
	
	private String seleniumServer;
	private String browserName;
	private String browserVersion;
	private String platform;
	
	public String getSeleniumServer(){
		return this.seleniumServer;
	}
	
	public String getBrowserName(){
		return this.browserName;
	}
	
	public String getBrowserVersion(){
		return this.browserVersion;
	}
	
	public String getPlatform(){
		return this.platform;
	}
	
}
