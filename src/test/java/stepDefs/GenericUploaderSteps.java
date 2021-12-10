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
	

	@Then("^i verify the entity prioritization for entity \"([^\"]*)\" in generic uploader tile for tool \"([^\"]*)\"$")
	public void verifyentityPrioritization(String entity,String tool) throws Throwable {
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		DataLoader.verifyentityprioritization(entity,tool);		
	}
	
	@Then("^i prepare the excel data for tool \"([^\"]*)\" with Associations in \"([^\"]*)\" DataLoader$")
	public void i_prepare_the_excel_data_for_tool_with_Associations_in_DataLoader(String toolname,String dataload_type) throws Throwable {
		DataLoader.prepareExcelFilePathtoBeUploadedwithAssociations(toolname, dataload_type);
	}


	@Then("^i select the Data Entity as \"([^\"]*)\" for \"([^\"]*)\" and upload the excel file$")
	public void i_select_the_Data_Entity_as(String dataentity,String toolname) throws Throwable {
		DataLoader.UploadFileForGenericUploader(dataentity,toolname);
		
			}
	
	
	

	@Then("^i \"([^\"]*)\" the Custom Template for \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_the_Custom_Template_for_for(String EditorUpload, String dataentity, String toolname) throws Throwable {
		if(EditorUpload.equalsIgnoreCase("Edit"))
		{
			DataLoader.EditCustomTemplate(dataentity,toolname);
			clickJS(GenericUploaderUIMap.GoBack_btn);
		}
		
	}
	
}
