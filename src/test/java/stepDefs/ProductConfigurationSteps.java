package stepDefs;
import testobjects.Baseclass;
import testobjects.ProductConfiguration;
import cucumber.api.java.en.Then;

public class ProductConfigurationSteps {
	
	@Then("^i select the \"([^\"]*)\" in Manage Product Configuration page$")
	public void i_select_the_in_Manage_Product_Configuration_page(String toolname) throws Throwable {
	   ProductConfiguration.SelectTheTool(toolname);
	}
	@Then("^i check if the field \"([^\"]*)\" is \"([^\"]*)\"$")
	public void i_check_the_field_RealTimeConfigChanges_is_(String fieldname,String enabledOrdisabled) throws Throwable {
	   ProductConfiguration.SetfieldStatusinProdConfigPage(fieldname,enabledOrdisabled);
	}
	
	
		@Then("^i navigate to \"([^\"]*)\" section$")
	public void i_navigate_to_section(String sectionname) throws Throwable {
		ProductConfiguration.Navigatetosection(sectionname);
	}

	@Then("^i add Product Instance Extension\\(s\\) details in the page for \"([^\"]*)\"$")
	public void i_add_Product_Instance_Extension_s_details_in_the_page_for(String toolname) throws Throwable {
	    
		ProductConfiguration.AddProductInstanceExtensionDetails(toolname);
	}
	
	@Then("^i add Delivery construct association details in the page for \"([^\"]*)\"$")
	public void i_add_Delivery_construct_association_details_in_the_page_for(String toolname) throws Throwable {
		ProductConfiguration.AddDeliveryConstructAssociationDetails(toolname);
	}
	@Then("^i remove Delivery construct association details in the page for \"([^\"]*)\"$")
	public void i_remove_Delivery_construct_association_details_in_the_page_for(String toolname) throws Throwable {
		ProductConfiguration.RemoveDeliveryConstructAssociationDetails(toolname);
	}
	
		@Then("^i add Product Instance Entities details in the page for \"([^\"]*)\"$")
	public void i_add_Product_Instance_Entities_details_in_the_page_for(String toolname) throws Throwable {
		ProductConfiguration.AddProductInstanceEntitiesDetails(toolname);
	}
		@Then("^i hit the save button in Product Config page$")
		public void i_hit_the_save_button() throws Throwable {
			ProductConfiguration.hitSaveButton();
		}
		
		@Then("^i verify the existing \"([^\"]*)\" pipelines if present and add them if missing for \"([^\"]*)\"$")
		public void i_verify_the_existing_pipelines_if_present_and_add_them_if_missing(String IBorOB,String toolname) throws Throwable {
			ProductConfiguration.verifyPipelines1(IBorOB,toolname);
			
		}
		@Then("^i deploy the pipelines and verify if successful for \"([^\"]*)\"$")
		public void i_deploy_the_pipelines(String toolname) throws Throwable {
			if(Baseclass.getInstance().DeployPipeline)
			ProductConfiguration.deploypipelines(toolname);
		}
		
		@Then("^i verify the ClientNative details for \"([^\"]*)\"$")
		public void i_verify_the_ClientNative_details(String toolname) throws Throwable {
			ProductConfiguration.verifyClientNativeDetails(toolname);
		}

}
