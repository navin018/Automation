package stepDefs;

import cucumber.api.java.en.Then;
import testobjects.DLM;
public class DLMSteps {
	
	@Then("^i add a new template for DLM with data \"([^\"]*)\"$")
	public void i_add_a_new_template_for_DLM(String template) throws Throwable {
		DLM.addTemplate(template);
	}

}
