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


public class APTSteps  {
	
	@Then("^i select the client as \"([^\"]*)\" and DC_L1 as \"([^\"]*)\" and DC_L2 as \"([^\"]*)\" and DC_L3 as \"([^\"]*)\"$")
	public void i_select_specificClientandDC(String client,String DC_L1,String DC_L2,String DC_L3) throws Throwable {
		APT.selectClientAndDC(client,DC_L1,DC_L2,DC_L3);
		
	}
	
	@Then("^i \"([^\"]*)\" records for entity \"([^\"]*)\" in the excel file for client \"([^\"]*)\" and DC_L1 \"([^\"]*)\" and DC_L2 \"([^\"]*)\" and DC_L3 \"([^\"]*)\"$")
	public void i_prepareexceldata(String createOrUpdate,String entity, String client, String DC_L1,String DC_L2,String DC_l3) throws Throwable {
		APT.prepareexceldata(createOrUpdate,20,entity,client,DC_L1,DC_L2, DC_l3);
		
	}

	@Then("^i select the Data Entity as \"([^\"]*)\" for client \"([^\"]*)\" and DC_L1 \"([^\"]*)\" and DC_L2 \"([^\"]*)\" and DC_L3 \"([^\"]*)\" and upload the excel file$")
	public void i_select_the_Data_Entity_as(String entity, String client, String DC_L1,String DC_L2,String DC_L3) throws Throwable {
		APT.UploadFileForGenericUploader(entity,client,DC_L1,DC_L2,DC_L3);
		
			}
	
//	@Then("^i select the Product Instance as \"([^\"]*)\"$")
//	public void i_select_the_Product_Instance_as(String ProdInstance) throws Throwable {
//		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//		selectByPartOfVisibleText(GenericUploaderUIMap.ProductInstance_drpdown, ProdInstance);
//		
//	}
//	
//	@Then("^i select the Data Entity as \"([^\"]*)\" for \"([^\"]*)\" and upload the excel file$")
//	public void i_select_the_Data_Entity_as(String dataentity,String toolname) throws Throwable {
//		DataLoader.UploadFileForGenericUploader(dataentity,toolname);
//		
//			}
	
}
