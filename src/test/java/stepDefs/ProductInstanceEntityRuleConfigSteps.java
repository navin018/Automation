package stepDefs;

import cucumber.api.java.en.Given;
import testobjects.ProductInstanceEntityRuleConfig;


public class ProductInstanceEntityRuleConfigSteps {

	@Given("^i click on the \"([^\"]*)\" for \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" under \"([^\"]*)\"$")
	public void i_click_on_the_for_and_and_under(String InactivateorAddorCloneorDeleteOrDuplicateOrCheck, String toolName, String entityType, String workItemType, String arg5) throws Throwable {
		if( InactivateorAddorCloneorDeleteOrDuplicateOrCheck.equalsIgnoreCase("Inactivate Rule"))
		{
			ProductInstanceEntityRuleConfig.InactivateRule(toolName,entityType,workItemType);
		}
		else if( InactivateorAddorCloneorDeleteOrDuplicateOrCheck.equalsIgnoreCase("Add Rule"))
			{
				ProductInstanceEntityRuleConfig.Addrule(toolName,entityType,workItemType);
			}
			else if( InactivateorAddorCloneorDeleteOrDuplicateOrCheck.equalsIgnoreCase("Clone Rule"))
			{
				ProductInstanceEntityRuleConfig.Clonerule(toolName,entityType,workItemType);
			}
			else if( InactivateorAddorCloneorDeleteOrDuplicateOrCheck.equalsIgnoreCase("Delete Rule"))
			{
				ProductInstanceEntityRuleConfig.Deleterule(toolName,entityType,workItemType);
			} 
			else if( InactivateorAddorCloneorDeleteOrDuplicateOrCheck.equalsIgnoreCase("Duplicate Rule"))
			{
				ProductInstanceEntityRuleConfig.Duplicaterule(toolName,entityType,workItemType);
			} 
			else if( InactivateorAddorCloneorDeleteOrDuplicateOrCheck.equalsIgnoreCase("Check Rule"))
			{
				ProductInstanceEntityRuleConfig.Checkrule(toolName,entityType,workItemType);
			} 
			else if(InactivateorAddorCloneorDeleteOrDuplicateOrCheck.equalsIgnoreCase("Edit Rule"))
			{
			ProductInstanceEntityRuleConfig.Editrule(toolName,entityType,workItemType);
			}
	}

	
	}


