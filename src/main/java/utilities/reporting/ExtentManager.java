package utilities.reporting;

import java.io.File;
import java.io.IOException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

/** 
 * Manages the extent reporting across multiple threads allowing each thread
 * to write back to the same report
 * 
 */
@SuppressWarnings ({"static-access"})
public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentManager extentManager;
    final static String filePath = System.getProperty("user.dir")+File.separator+"ExtentReports"+File.separator+"ExtentRunReport.html";
    
    public synchronized static ExtentReports getReporter() {
        if (extentManager.extent == null) {
        	extent = new ExtentReports(filePath, true, NetworkMode.OFFLINE);
        } 
        return extent;
    }
    
    public static ExtentReports getExtentManager() throws IOException {
    	if (null == extentManager) {
    		extentManager = new ExtentManager();
    		extent = extentManager.getReporter();
    	}
    	return extent;
    }
}

