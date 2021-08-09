package stepDefs;

import cucumber.api.java.en.Given;
import testobjects.ProductInstanceEntityRuleConfig;


public class ProductInstanceEntityRuleConfigSteps {

	@Given("^i click on the \"([^\"]*)\" for \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" under \"([^\"]*)\"$")
	public void i_click_on_the_for_and_and_under(String InactivateorAddorCloneorDelete, String toolName, String entityType, String workItemType, String arg5) throws Throwable {
		if(InactivateorAddorCloneorDelete.equalsIgnoreCase("Inactivate Rule"))
		{
			ProductInstanceEntityRuleConfig.InactivateRule();
		}
		else if(InactivateorAddorCloneorDelete.equalsIgnoreCase("Add Rule"))
			{
				ProductInstanceEntityRuleConfig.Addrule(toolName,entityType,workItemType);
			}
			else if(InactivateorAddorCloneorDelete.equalsIgnoreCase("Clone Rule"))
			{
				ProductInstanceEntityRuleConfig.Clonerule();
			}
			else if(InactivateorAddorCloneorDelete.equalsIgnoreCase("Delete Rule"))
			{
				ProductInstanceEntityRuleConfig.Deleterule();
			} 
	 
	}

	
	}


