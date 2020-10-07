package testRunner;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilities.general.Property;
import utilities.selenium.Context;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features={
//"classpath:features/Tools/ADTJira/ADTJira_IB_APIValidation.feature",
		"classpath:features/Jira/ADTJiraOB.feature"
//		"classpath:features/ADTJiraE2E/6ADTJira_IB_APIValidation.feature",
//		"classpath:features/ADTJiraE2E/7ADTJira_OB_APIValidation.feature"
	
},


glue = { "stepDefs" })




public class ADTJira_OB_InTool {
	@BeforeClass
	public static void setContext() throws IOException{
		Context.getInstance().setContext("local","windows","chrome","","","",Property.getProperty("targetApp"));
	}
//	@AfterClass
//	public static void markForClosure(){
//		RunnerMain.checkForBatches.add(new Boolean("TRUE"));
//	}
}





