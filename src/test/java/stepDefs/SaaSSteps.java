package stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import testobjects.Saas;

public class SaaSSteps {


@And("^i add the role \"([^\"]*)\" for user \"([^\"]*)\"$")
public void i_add_the_role_for_user(String role, String userID) throws Throwable {
	Saas.AddRole(role,userID);
    
}
@And("^i add bundle \"([^\"]*)\" to the cart in SAAS screen$")
public void i_add_bundle_to_the_cart_in_SAAS_screen(String AppBundle) throws Throwable {
    Saas.AddBundle(AppBundle);
    
}

@And("^i go to final cart and enter all the mandatory details \"([^\"]*)\"$")
public void i_go_to_final_cart_and_enter_all_the_mandatory_details(String AppBundle) throws Throwable {
    Saas.EnterDetails(AppBundle);
   
}
@And("^i confirm order confirmation for bundle \"([^\"]*)\" in SAAS screen$")
public void i_confirm_order_confirmation_for_bundle_in_SAAS_screen(String AppBundle) throws Throwable {
    Saas.ConfirmOrder(AppBundle);
  
}
@And("^i verify if i am able to view all the apps under the bundle \"([^\"]*)\"$")
public void i_verify_if_i_am_able_to_view_all_the_apps_under_the_bundle(String AppBundle) throws Throwable {
    Saas.VerifyBundle(AppBundle);
} 
@And("^i add Contract Demographics details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
public void i_add_Contract_Demographics_details_with_and_and(String Chargecode, String NoofUsers, String ContractDuration) throws Throwable {
	Saas.AddDetails(Chargecode,NoofUsers,ContractDuration);
    
}

@And("^i enter data for \"([^\"]*)\" section for the bundle \"([^\"]*)\" in DIY screen$")
public void i_enter_data_for_section_for_the_bundle_in_DIY_screen(String Section, String AppBundle) throws Throwable {
	Saas.EnterDataforSelectTool(Section,AppBundle);

}

@And("^i get started to order services for bundle \"([^\"]*)\" in DIY screen$")
public void i_get_started_to_order_services_for_bundle_in_DIY_screen(String AppBundle) throws Throwable {
	Saas.GetStartedtooderservices(AppBundle);
    
}




}