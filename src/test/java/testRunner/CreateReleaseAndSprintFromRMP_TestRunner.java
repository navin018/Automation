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

		"classpath:features/RMP/CreateReleaseAndSprintViaRMP.feature"

//		"classpath:features/RMP/VerifyReleaseAndSprint_TFS.feature"

},


glue = { "stepDefs" })




public class CreateReleaseAndSprintFromRMP_TestRunner {
	@BeforeClass
	public static void setContext() throws IOException{
		Context.getInstance().setContext("local","Windows","chrome","43","","",Property.getProperty("targetApp"));
	}
//	@AfterClass
//	public static void markForClosure(){
//		RunnerMain.checkForBatches.add(new Boolean("TRUE"));
//	}
}





