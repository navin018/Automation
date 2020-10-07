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
//"classpath:features/MyWizardUI/PreRequisites_ADTJira.feature",
//"classpath:features/ClientNative/ClientNative_ADTJIRA.feature",
//"classpath:features/SEI/SEI_ADTJira.feature",
//"classpath:features/MappingRules/Rules_ADTJira.feature",
//		"classpath:features/ADTJiraE2E",
		"classpath:features/Tools/ADTJira/ADTJira_IB_APIValidation.feature",

},


glue = { "stepDefs" })




public class ADT_E2E_TestRunner_Test_DO {
	@BeforeClass
	public static void setContext() throws IOException{
		Context.getInstance().setContext("local","windows","chrome","","","",Property.getProperty("targetApp"));
	}
//	@AfterClass
//	public static void markForClosure(){
//		RunnerMain.checkForBatches.add(new Boolean("TRUE"));
//	}
}





