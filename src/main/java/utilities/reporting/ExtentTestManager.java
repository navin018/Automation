package utilities.reporting;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.selenium.Context;

/** 
 * Provides set of methods for starting, logging to, and closing an Extent reporting thread.
 * Logging methods accepts an optional message string and then either include the
 * test scenario + message or test scenario + calling method in the report log entry. 
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class ExtentTestManager {  
   
	public static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.getReporter();

    /** get extent report instance for current execution thread */
    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    /** starts extent report instance for current execution thread */
    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }
    
    /** starts extent report instance for current execution thread */
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
    
    /** ends extent report instance for current execution thread */
    public static synchronized void endTest() {
        extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    /** logs an INFO message to the report based on either 'scenario + optional message' 
     * or 'scenario + calling method 
     * */
    
       
	public static synchronized void logInfo(String... msg){
		try{
	        throw new Exception();
	    }catch(Exception e){
	    	ExtentTestManager.getTest().log(
	    			LogStatus.INFO, msg.length>0 
	    			? Context.getInstance().getScenario() + " : " + msg[0] 
	    			: Context.getInstance().getScenario() + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());	 
	    }
	}
	
	/** logs an PASS message to the report based on either 'scenario + optional message' 
     * or 'scenario + calling method 
     * */
	public static synchronized void logPass(String... msg){
		try{ 
	        throw new Exception();
	    }catch(Exception e){
	    	ExtentTestManager.getTest().log(
	    			LogStatus.PASS, msg.length>0 
	    			? Context.getInstance().getScenario() + " : " + msg[0] 
	    			: Context.getInstance().getScenario() + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());	 
	    }																		
	}
	
	/** logs a FAIL message to the report based on either 'scenario + optional message' 
     * or 'scenario + calling method 
     * */
	public static synchronized void logFail(String... msg){
		try{
	        throw new Exception();
	    }catch(Exception e){
	    	ExtentTestManager.getTest().log(
	    			LogStatus.FAIL, msg.length>0 
	    			? Context.getInstance().getScenario() + " : " + msg[0] 
	    			: Context.getInstance().getScenario() + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());	 
	    }																		
	}
	
	/** logs an SKIP message to the report based on either 'scenario + optional message' 
     * or 'scenario + calling method 
     * */
	public static synchronized void logSkip(String... msg){
		try{
	        throw new Exception();
	    }catch(Exception e){
	    	ExtentTestManager.getTest().log(
	    			LogStatus.SKIP, msg.length>0 
	    			? Context.getInstance().getScenario() + " : " + msg[0] 
	    			: Context.getInstance().getScenario() + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());	 
	    }																		
	}
	
	public static synchronized void log(Boolean result, String... msg){
		
		if (result)
			logPass(msg[0]);
		else
			logFail(msg[0]);
	}
}