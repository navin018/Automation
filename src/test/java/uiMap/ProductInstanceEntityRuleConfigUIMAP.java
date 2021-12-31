package uiMap;

import org.openqa.selenium.By;

public class ProductInstanceEntityRuleConfigUIMAP {
	//ProductInstanceEntityRuleConfig 
	public static By Search_text = By.xpath("//input[@placeholder='Search...']");
	public static By Entity_Txtbox=By.xpath("//div[text()='Epic'][1]");
	public static By Save_rule=By.xpath("//button[@class='btn btn-primary'][text()='Save']");
	public static By Inactive_rule=By.xpath("//span[text()='InActive']");
	public static By Active_rule=By.xpath("//span[text()='Active']");
	public static By rule_name=By.xpath("//input[@name='ruleNames']");
	public static By Backto_ManageRule=By.xpath("//span[text()='Back To Manage Rule']")
			;
	// adding basics
	public static By Standard_btn=By.xpath("//span[@class='btn phx-label'][text()='Standard']");
	public static By Advanced_btn=By.xpath("//span[@class='btn phx-label'][text()='Advanced']");
	public static By attribute_drpdwn=By.xpath("//select[@class='ag-cell-edit-input']");
	public static By Field_drpdwn=By.xpath("//select[@class='ag-cell-edit-input']");
	public static By Value_drpdwn=By.xpath("//select[@class='ag-cell-edit-input']");
	public static By Condition_drpdwn=By.xpath("//select[@class='ag-cell-edit-input'][text()='OR']");
	public static By Text_area=By.xpath("//textarea[@placeholder='Enter XPath Rule']");
//	public static By Save_btn1=By.xpath("//button[@class='btn btn-primary'][text()='Save']");
	public static By Cancel_btn1=By.xpath("//button[@class='btn btn-outline-primary'][text()='Cancel']");
	public static By AddRule_btn=By.xpath("//span[text()='Add Rule']");
	public static By Condition_txt=By.xpath("//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-no-focus ag-cell-value'][text()='AND']");
	public static By AddClause_txt=By.xpath("//span[@class='phx-btn-text'][text()='Add New Clause']");
	public static By Advance_checkbox=By.xpath("//span[text()='Use Advanced Rule? ']");
	
	public static By ManageDeliveryConstructType_txt=By.xpath("//span[text()='Manage Delivery Construct Type']");
	public static By AddOrganizationStructureType_txt=By.xpath("//span[text()='Add Organization Structure Type']");
	public static By BacktoManageOrganization_txt=By.xpath("//div[@title='Back to Manage Organization (Delivery) Structure']");
	public static By name_txt=By.xpath("//input[@name='ruleNames']");
	public static By productinstance_drpdwn=By.xpath("//select[@name='ProductInstanceUId']");
	public static By dataentity_drpdwn=By.xpath("//select[@name='entitylistcontrol']");
	public static By workitemtype_drpdwn=By.xpath("//select[@name='workitemtype']");
	public static By Search_txtbox=By.xpath("//input[@placeholder='Search...']");
	public static By Name_txt=By.xpath("//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-no-focus ag-cell-value'][text()='Automation_Regression']");
	public static By Clone_icon=By.xpath("//div[text()='Automation_Regression']//following::*[@class='phx-icon-svg phx-icon-svg-sm'][1]");
	public static By SelectRule_Statictxt=By.xpath("//span[text()='Name']//following::div[@col-id='Name' and @role='gridcell'][1]");
	public static By SavedRule_txt=By.xpath("//div[contains(text(),'Saved successfully')]");
	
	
	// new add on
	public static By RuleNotSaved_msg=By.xpath("//div[@id='toast-container']");
	public static By Status_btn=By.xpath("//div[@class='phx-toggle-switch mr-3 phx-disabled']");
	public static By AddRow_btn=By.xpath("//div[@id='divTitle']");
	public static By ProjectValue_txt=By.xpath("//div[text()='TFS Agile1_ Client-Native']");
	public static By Equal_Operator=By.xpath("//div[contains(text(),'=')] ");
	public static By Attribute_txt=By.xpath("//span[contains(text(),'Attribute')]//following::div[@col-id='attribute'][1]");
	public static By Fieled_txt=By.xpath("//span[contains(text(),'Field')]//following::div[@col-id='field'][1]");
	public static By Value_txt=By.xpath("//span[contains(text(),'Value')]//following::div[@col-id='Value'][1]");
	public static By Delete_img=By.xpath("//span[contains(text(),'Select')]//following::div[@col-id='delete'][1]");
	public static By DuplicationError_msg=By.xpath("//div[@id='toast-container']");
	public static By BackToManageRule=By.xpath("//span[contains(text(),'Back To Manage Rule')]");
	
	
	//public static By =By.xpath("");
}
