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

//		"classpath:features/SEI/SEI_ADTJira.feature",
//		"classpath:features/SEI/SEI_MSPS.feature"
		"classpath:features/MappingRules/Rules_ADOPJira.feature"

},


glue = { "stepDefs" })




public class Rules_ADOPJira_TestRunner {
	@BeforeClass
	public static void setContext() throws IOException{
		Context.getInstance().setContext("local","Windows","chrome","43","","",Property.getProperty("targetApp"));
	}
//	@AfterClass
//	public static void markForClosure(){
//		RunnerMain.checkForBatches.add(new Boolean("TRUE"));
//	}
}





