package stepDefs;

import static utilities.selenium.SeleniumDSL.ExpWaitForCondition;

import cucumber.api.java.en.Given;
import testobjects.CommonFunctions;
import testobjects.SecurityTests;
import uiMap.SecurityTestsUIMap;


public class SecurityTestSteps {
	
	@Given("^the user check for the duplicate security headers and missing security headers for \"([^\"]*)\"$")
    public void the_user_check_for_the_security_headers(String TilePageName) throws Throwable {
	
		SecurityTests.the_user_check_for_the_security_headers(TilePageName);
    }
	
//	@Given("^i clear the existing security headers data$")
//    public void clearexceldata() throws Throwable {
//	
//		SecurityTests.clearExcelFileToLoadNewData();
//    }
	@Given("^i \"([^\"]*)\" the vulnerabilites details into excel$")
  public void writevulerabilitesdetailsintoexcel(String WriteOrUpdate) throws Throwable {
	if(WriteOrUpdate.equalsIgnoreCase("write"))
		SecurityTests.writetoexcel();
	if(WriteOrUpdate.equalsIgnoreCase("update"))
		SecurityTests.updateexcel();
  }
	
	@Given("^i verify the overall securitytest results$")
    public void verify_SecurityTestResults() throws Throwable {
	
		SecurityTests.verify_securitytest_results();
    }
	@Given("^i click on link \"([^\"]*)\" under \"([^\"]*)\"$")
	public void i_click_on_link_under(String sublink, String tilename) throws Throwable {
		SecurityTests.clickSublink(sublink,tilename);
	 
	}
	
	@Given("^i click on \"([^\"]*)\" button$")
	public void i_click_backbutton(String btn) throws Throwable {
		SecurityTests.clickbutton(btn);
	 
	}
	@Given("^i navigate to HomePage$")
	public void i_navigate_homepage() throws Throwable {
		SecurityTests.gotohomepage();
	 
	}
	
	@Given("^i add a DC$")
	public void addDC() throws Throwable {
		SecurityTests.AddDC();
	 
	}
	@Given("^i enter all the mandatory details for \"([^\"]*)\"$")
    public void i_enter_all_the_mandatory_details_for(String TileName) throws Throwable {
        switch(TileName) {
        
        case "my Queries page":
        SecurityTests.CreateQuery();
        break;

        case "Organization (Delivery) Structure Page":
            SecurityTests.ActivateDeliveryStructureType();
            break;
        case "Team Configuration":
            SecurityTests.CreateTeam();
            break;
        case "Account Management":
          SecurityTests.ActivateAccount();
          break;    
        case "Product Instance Entity Rule Config":
        	SecurityTests.InactivateRules();
        	break;
        case "Data Upload":
            SecurityTests.SelectEntityType();
            SecurityTests.UploadFile();
            break;
        case "Organization (Delivery) Structure Config":
            SecurityTests.ActivateDC();
            break;         
        case "Client Configuration":
        SecurityTests.ChangeDescriptionOfExistingClient();
        break;
        case "Product Configuration":
        	SecurityTests.AddProductConfig();
        	break;
        case "Lifecycle Template Configuration/Add Stage Template":
            SecurityTests.Add_StageTemplate();
            break;
            
        }

    }


    @Given("^i delete the data for \"([^\"]*)\"$")
    public void i_delete_data_for_a_given_tile(String TileName) throws Throwable {
       switch(TileName) {
       case  "my Queries page":
       SecurityTests.DeleteQuery();
       break;
       case "Organization (Delivery) Structure Page":
            SecurityTests.InActivateDeliveryStructureType();
       break;
      case "Team":
     SecurityTests.DeleteTeam();
     break;
    case "Account Management":
    	SecurityTests.InactivateAccount();
    	break;
    case "Product Instance Entity Rule Config":
        SecurityTests.ActivateRules();
        break;   
    case "Organization (Delivery) Structure Config":
        SecurityTests.InActivateDC();
        break;  
    case "Product Configuration":
    	SecurityTests.DeleteProductConfig();
    	break;
    case "Lifecycle Template Configuration/Add Stage Template":
        SecurityTests.Delete_StageTemplate();
        break;
    	
           }

    }
    

}
