package stepDefs;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import uiMap.GenericUploaderUIMap;
import uiMap.JiraUIMap;
import uiMap.MyWizardUIMap;
import utilities.general.Property;
import testobjects.*;

public class GenericUploaderSteps  {
	@Then("^i select the Product Instance as \"([^\"]*)\"$")
	public void i_select_the_Product_Instance_as(String ProdInstance) throws Throwable {
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		selectByPartOfVisibleText(GenericUploaderUIMap.ProductInstance_drpdown, ProdInstance);
		
	}
	
	@Then("^i select the Data Entity as \"([^\"]*)\" and upload the excel file$")
	public void i_select_the_Data_Entity_as(String dataentity) throws Throwable {
		DataLoader.UploadFileForGenericUploader(dataentity);
		
			}
	
}
