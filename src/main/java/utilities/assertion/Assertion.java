package utilities.assertion;

import static utilities.selenium.SeleniumDSL.grabScreenshotForExtentReport;
import static utilities.selenium.SeleniumDSL.saveScreenshot;

import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.reporting.ExtentTestManager;
import utilities.selenium.Context;
import utilities.testng.*;

/** 
 * Base class providing set of common selenium methods 
 */

public class Assertion {
	
	/** Write assertion failure to output report and optionally fail test+grab screenshot */
	public static void reportAssertResult(String exceptionReason, Boolean fail, String msg, Boolean...screenshot) { 
		ExtentTest extentTest = ExtentTestManager.getTest();
		extentTest.log(LogStatus.FAIL, Context.getInstance().getScenario() +" : " + msg + exceptionReason);
		if (fail){
			if (screenshot.length > 0){
				if(screenshot[0]){
					grabScreenshotForExtentReport();	
				}
			}else if(Context.getInstance().getBrowserName() != null){
				grabScreenshotForExtentReport();
			}
			Assert.fail(exceptionReason);
		}else{
			grabScreenshotForExtentReport();
		}
	}
	
	/** Asserts that two objects are equal otherwise write to output report and optionally stop test+grab screenshot */
	public static void assertEquals(Object act, Object exp, Boolean stopTest, String... msg) {
		try{
			Assert.assertEquals(act, exp);	
    	}catch(AssertionError e) {
    		reportAssertResult(e.getMessage(), stopTest, (msg.length > 0 ? msg[0] : Thread.currentThread().getStackTrace()[2].getMethodName()),true);
		}
	}
	
	/** Asserts that two objects are not equal otherwise write to output report and optionally stop test+grab screenshot */
	public static void assertNotEquals(Object act, Object exp, Boolean stopTest, String... msg) {
		try{
			Assert.assertNotEquals(act, exp);	
    	}catch(AssertionError e) {
    		reportAssertResult(e.getMessage(), stopTest, (msg.length > 0 ? msg[0] : Thread.currentThread().getStackTrace()[2].getMethodName()));
		}
	}
	
	/** Asserts condition is true otherwise write to output report and optionally stop test+grab screenshot */
	public static void assertTrue(Boolean expression, Boolean stopTest, String... msg) {
		try{
			Assert.assertTrue(expression);	
    	}catch(AssertionError e) {
    		reportAssertResult(e.getMessage(), stopTest, (msg.length > 0 ? msg[0] : Thread.currentThread().getStackTrace()[2].getMethodName()));
		}
	}
	
	/** Asserts condition is false otherwise write to output report and optionally stop test+grab screenshot */
	public static void assertFalse(Boolean expression, Boolean stopTest, String... msg) {
		try{
			Assert.assertFalse(expression);	
    	}catch(AssertionError e) {
    		reportAssertResult(e.getMessage(), stopTest, (msg.length > 0 ? msg[0] : Thread.currentThread().getStackTrace()[2].getMethodName()));
		}
	}
	
	/** Asserts object is  null otherwise write to output report and optionally stop test+grab screenshot */
	public static void assertNull(Object obj, Boolean stopTest, String... msg) {
		try{
			Assert.assertNull(obj);	
    	}catch(AssertionError e) {
    		reportAssertResult(e.getMessage(), stopTest, (msg.length > 0 ? msg[0] : Thread.currentThread().getStackTrace()[2].getMethodName()));
		}
	}
	
	/** Asserts object is not null otherwise write to output report and optionally stop test+grab screenshot */
	public static void assertNotNull(Object obj, Boolean stopTest, String... msg) {
		try{
			Assert.assertNotNull(obj);	
    	}catch(AssertionError e) {
    		reportAssertResult(e.getMessage(), stopTest, (msg.length > 0 ? msg[0] : Thread.currentThread().getStackTrace()[2].getMethodName()));
		}
	}
	
	/** Asserts 2 objects refer to same object null otherwise write to output report and optionally stop test+grab screenshot */
	public static void assertSame(Object act, Object exp, Boolean stopTest, String... msg) {
		try{
			Assert.assertSame(act, exp);	
    	}catch(AssertionError e) {
    		reportAssertResult(e.getMessage(), stopTest, (msg.length > 0 ? msg[0] : Thread.currentThread().getStackTrace()[2].getMethodName()));
		}
	}
	
	/** Asserts 2 objects do not refer to same object null otherwise write to output report and optionally stop test+grab screenshot */
	public static void assertNotSame(Object act, Object exp, Boolean stopTest, String... msg) {
		try{
			Assert.assertNotSame(act, exp);	
    	}catch(AssertionError e) {
    		reportAssertResult(e.getMessage(), stopTest, (msg.length > 0 ? msg[0] : Thread.currentThread().getStackTrace()[2].getMethodName()));
		}
	}
	
	
}
