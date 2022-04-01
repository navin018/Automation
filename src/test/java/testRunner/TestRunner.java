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
//"classpath:features/SecurityTests/SecurityTest.feature",
		"classpath:features"

},

	
//tags = {"@6IBValidation_TFSScrum,@6IBValidation_CloudJira"},
	//	@5WorkItemCreation_ADOPJira
//tags= {"@6IBValidation_CloudJira"},
//		tags= {"@IBvalidation12"},
//		/tags = {"@5WorkItemCreation_TFSAgile"},
				//tags = {"@6IBValidation_TFSAgile"},


		//dryRun = true,


	

glue = { "stepDefs" })




public class TestRunner {
	@BeforeClass
	public static void setContext() throws IOException{
		Context.getInstance().setContext("local","windows","chrome","","","",Property.getProperty("targetApp"));
	}
//	@AfterClass
//	public static void markForClosure(){
//		RunnerMain.checkForBatches.add(new Boolean("TRUE"));
//	}
}





