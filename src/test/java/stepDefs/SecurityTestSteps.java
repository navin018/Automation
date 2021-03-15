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
	

}
