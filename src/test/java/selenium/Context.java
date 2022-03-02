package selenium;

import utilities.general.Property;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** 
 * Used to hold the execution context including scenario and platform/browser combo 
 * for each execution thread
 */
public class Context {
	
	private static List<Context> contexts = new ArrayList<Context>();
	
	private String		scenario;
	private String 		seleniumServer;
	private String 		serverAddress;
	private String 		platform;
	private String 		browserName;
	private String 		browserVersion;
	private String 		browserID;
	private String 		platformID;
	private String 		targetApp;
	private long 		threadToEnvID;
	
	
	private Context(){
		//blank constructor to prevent instantiation
	}
	
	private Context(long threadID){
		this.threadToEnvID = threadID;
	}
	
	public static synchronized Context getInstance(){
		long currentRunningThreadID = Thread.currentThread().getId();
		for(Context context : contexts){
			if (context.threadToEnvID == currentRunningThreadID){
				return context;
			}
		}
		Context temp = new Context(currentRunningThreadID);
		contexts.add(temp);
		return temp;
	}
	
	public void setContext(String seleniumServer, String platform, String browserName, String browserVersion, String browserID, String platformID, String targetApp) throws IOException{
		
		setPlatform(platform);
		setBrowserName(browserName);
		setBrowserVersion(browserVersion);
		setBrowserID(browserID);
		setPlatformID(platformID);
		setTargetApp(targetApp);
		setSeleniumServer(seleniumServer);
		setServerAddress();
	}
	
	public String getScenario(){
		return this.scenario;
	}
	
	public String getPlatform(){
		return this.platform;
	}
	
	public String getBrowserName(){
		return this.browserName;
	}
	
	public String getBrowserVersion(){
		return this.browserVersion;
	}
	
	public String getBrowserID(){
		return this.browserID;
	}
	
	public String getPlatformID(){
		return this.platformID;
	}
	
	public String getTargetApp(){
		return this.targetApp;
	}
	
	public String getSeleniumServer(){
		return this.seleniumServer;
	}
	
	public String getServerAddress(){
		return this.serverAddress;
	}
	
	public void setScenario(String val){
		this.scenario=val;
	}
	
	public void setPlatform(String val){
			this.platform = val;
	}
	
	public void setBrowserName(String val){
		this.browserName=val;
	}
	
	public void setBrowserID(String val){
		this.browserID=val;
	}
	
	public void setPlatformID(String val){
		this.platformID=val;
	}
	
	public void setBrowserVersion(String val){
		this.browserVersion=val;
	}
	
	public void setTargetApp(String val){
		this.targetApp=val;
	}
	
	public void setSeleniumServer(String val) throws IOException{
		this.seleniumServer=val;
	}
	
	public void setServerAddress() throws IOException{
		if(this.seleniumServer.equalsIgnoreCase("grid")){
			this.serverAddress = Property.getProperty("grid");
		}else{
			String sauceUserName = Property.getProperty("sauceUserName");
			String sauceAccessKey = Property.getProperty("sauceAccessKey"); //System.getenv("SAUCE_ACCESS_KEY");
			String sauceEndPoint = Property.getProperty("sauceEndPoint");
			this.serverAddress = "http://"+sauceUserName + ":" + sauceAccessKey + sauceEndPoint;
		}
	}	
	
	
}
