package utilities.reporting;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import utilities.general.Property;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static utilities.reporting.LogUtil.logger;



public class Reporting {
	
	public static void create_logs_and_report(String logs, String flag) {
        if (flag.equals("pass")) {
            ExtentTestManager.logInfo(logs);
            logger.info(logs);
        } else if (flag.equals("fail")) {
            ExtentTestManager.logFail(logs);
            logger.info(logs);
            try {
//            	 grabScreenshotForExtentReport();
			} catch (Exception e) {
				// TODO: handle exception
			}
           
        }
    }

	public static void main(String[] args) throws Exception { 
		
		String datesuffix = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		String project = Property.getProperty("appName");
		String inputPathJSON = Property.getProperty("reportPathJSON");
		String outputPathHTML = Property.getProperty("reportPathHTML")+"\\"+project+"\\"+datesuffix+"\\";

		Path outputPath = Paths.get(outputPathHTML);
		        
		if (!Files.exists(outputPath)) {
		   try {
		        Files.createDirectories(outputPath);
		   } catch (IOException e) {
		                //fail to create directory
			   e.printStackTrace();
		       }
		}
		
		File reportInputDirectory = new File(inputPathJSON);
		File reportOutputDirectory = new File(outputPathHTML);
		
		List<String> jsonFiles = new ArrayList<String>();
		
		for (File file : reportInputDirectory.listFiles()){
			jsonFiles.add(file.getAbsolutePath());
		}

		String projectName = "cucumber-jvm";
//		String jenkinsBasePath = "";
//		String buildNumber = "1";
//		boolean skippedFails = true;
//		boolean pendingFails = false;
//		boolean undefinedFails = true;
//		boolean missingFails = true;
//		boolean runWithJenkins = false;
//		boolean parallelTesting = false;

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optionally only if you need
//		configuration.setStatusFlags(skippedFails, pendingFails, undefinedFails, missingFails);
//		configuration.setParallelTesting(parallelTesting);
//		configuration.setJenkinsBasePath(jenkinsBasePath);
//		configuration.setRunWithJenkins(runWithJenkins);
//		configuration.setBuildNumber(buildNumber);

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
		

		for (File file : reportInputDirectory.listFiles()) {
			file.delete();
		}
//		Path cleanup = Paths.get(outputPathHTML+"velocity.log");
//		Files.deleteIfExists(cleanup);
		
	}
	
}