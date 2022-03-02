package utilities.testng;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.DataProvider;
import utilities.general.Property;
import utilities.iris.IRIS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/** 
 * The main data provider class that reads in the target selenium server and platform/browser 
 * combination and enables TestNG to start a separate thread for each combination.
 * 
 * If the execution has been triggered from the IRIS front end application then a call will
 * be made using the IRIS API to obtain the platform/browser set.  The target selenium server 
 * (e.g. grid or saucelabs will be read from the project properties file)
 * 
 * If the execution has been triggered directly either from Jenkins, Eclipse or CLI
 * then the specified "browser combo" JSON file will be used.
 */
public class BrowserComboDP {
	
	@DataProvider(name = "browserComboDP", parallel=true)
	public static Object[][] getParams() throws Exception{

		Boolean iristrigger = Boolean.valueOf(System.getProperty("iristrigger"));
		String browsercombo = System.getProperty("browsercombo");
		
		if(!iristrigger){
			BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"testng"+File.separator+browsercombo+".json"));
			Gson gson = new GsonBuilder().create();
			BrowserCombo[] stacks = gson.fromJson(reader, BrowserCombo[].class);
		
			Object[][] obj = new Object[stacks.length][7];		
			
			for(int i = 0; i < stacks.length; i++) {
				obj[i][0] = Property.getProperty("targetApp");
				obj[i][1] = stacks[i].getSeleniumServer();
				obj[i][2] = stacks[i].getBrowserName();
				obj[i][3] = stacks[i].getBrowserVersion();
				obj[i][4] = stacks[i].getPlatform();
				obj[i][5] = "";
				obj[i][6] = "";}
			
			return obj;
			
			}else{
			
			int execID = -1;
			IRIS logger = null;
				
			execID = Integer.parseInt(System.getProperty("browsercombo"));
			final String irisURL = Property.getProperty("irisURL");	
			logger = new IRIS(irisURL, execID);
			
			ArrayList<Configuration> configurations = logger.getConfigurations();

			Object[][] obj = new Object[configurations.size()][7];		
			for(int i = 0; i < configurations.size(); i++) {
					obj[i][0] = Property.getProperty("targetApp");
					obj[i][1] = Property.getProperty("irisSeleniumServer");
					obj[i][2] = configurations.get(i).getBrowser();
					obj[i][3] = configurations.get(i).getBrowserVersion();
					obj[i][4] = configurations.get(i).getPlatform();
					obj[i][5] = String.valueOf(configurations.get(i).getBrowserID());
					obj[i][6] = String.valueOf(configurations.get(i).getPlatformID());
			    }
				
			return obj;
		}
	}	
}
