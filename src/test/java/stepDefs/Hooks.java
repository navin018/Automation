package stepDefs;

import java.io.IOException;
import java.sql.Timestamp;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.general.Property;
import utilities.reporting.*;
import utilities.selenium.*;
import static utilities.reporting.LogUtil.logger;
//import uk.ndc.csa.utilities.general.Property;
//import uk.ndc.csa.utilities.reporting.ExtentManager;
//import uk.ndc.csa.utilities.reporting.ExtentTestManager;
//import uk.ndc.csa.utilities.selenium.Context;
//import uk.ndc.csa.utilities.selenium.DriverFactory;
//import uk.ndc.csa.utilities.selenium.ZapScanTest;
//import static uk.ndc.csa.utilities.reporting.LogUtil.logger;
//import static uk.ndc.csa.utilities.selenium.SeleniumDSL.driver;


public class Hooks {
	
	String featureName="";
	
	@Before
	public void startUp(Scenario scenario) throws IOException  {
		
		if (Context.getInstance().getBrowserName() == null){
			Context.getInstance().setContext("local","Windows","internet explorer","11","","",Property.getProperty("targetApp"));
		}
		Context.getInstance().setScenario(scenario.getName());
		
//		featureName = (scenario.getSourceTagNames().iterator().next().substring(1,scenario.getSourceTagNames().iterator().next().length()));				
		String featureName=scenario.getId().split(";")[0].replace("-", " ");
//		ExtentTestManager.startTest(featureName+" : " + Context.getInstance().getPlatform()+" : " +Context.getInstance().getBrowserName()+" "+Context.getInstance().getBrowserVersion()); 	//[extent] 
		ExtentTestManager.startTest(featureName); 	//[extent]
//    	ExtentTestManager.getTest().assignCategory(featureName);
    	ExtentTestManager.getTest().assignCategory(scenario.getName());
    	if("1".equals(Property.getProperty("isZapEnabled"))){
    		ZapScanTest.startZap();
    		ZapScanTest.initZapScanner();
    	}
    	
		DriverFactory.getInstance().setWebDriver(Property.getProperty("CheckPerformance"));
		
		logger.info("Scenario "+scenario.getName()+" run is starting now");
		logger.info("Scenario start time: "+new Timestamp(System.currentTimeMillis()));
	}

	
	@After
	public void closeDown(Scenario scenario) throws InterruptedException, IOException {		
		if("1".equals(Property.getProperty("isZapEnabled"))){
			ZapScanTest.spider();
			ZapScanTest.ActiveScan();
			ZapScanTest.stopZAP();
		}
		System.out.println(scenario.isFailed());
		if (scenario.isFailed()){
			ExtentTestManager.getTest().log(LogStatus.FAIL, scenario.getName());	
//			System.out.println(scenario.getName());
			logger.info("Scenario "+featureName+" FAILED during execution. Scenario end time: "+new Timestamp(System.currentTimeMillis()));
		}else{
			ExtentTestManager.getTest().log(LogStatus.PASS, scenario.getName());							 		 				
			logger.info("Scenario "+featureName+" PASSED during execution. Scenario end time: "+new Timestamp(System.currentTimeMillis()));
		}
			
		ExtentManager.getReporter().endTest(ExtentTestManager.getTest());    					     
		ExtentManager.getReporter().flush();													 
//		ExtentManager.getReporter().close();													  
		
		
//		DriverFactory.getInstance().quit();
//		utilities.selenium.SeleniumDSL.driver().close();
//		utilities.selenium.SeleniumDSL.driver().switchTo()
//		utilities.selenium.SeleniumDSL.driver().quit();
		
//		Process p = Runtime.getRuntime().exec("cmd /c killFirefox.bat",null,new File("C:\\"));
		Process p = Runtime.getRuntime().exec("cmd /c taskkill /f /im chrome.exe");
//		if(!(driver().toString().contains("null")))
//		DriverFactory.getInstance().quit();
//		Process p1 = Runtime.getRuntime().exec("cmd /c start D:\\GIT\\killTemp.bat");
	}
	
}
