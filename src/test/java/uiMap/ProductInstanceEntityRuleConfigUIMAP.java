package uiMap;

import org.openqa.selenium.By;

public class ProductInstanceEntityRuleConfigUIMAP {
	//ProductInstanceEntityRuleConfig 
	public static By text_epic=By.xpath("//div[text()='Epic_TFS scrum']");
	public static By Save_rule=By.xpath("//button[@class='btn btn-primary'][text()='Save']");
	public static By Inactive_rule=By.xpath("//span[text()='InActive']");
	public static By Active_rule=By.xpath("//span[text()='Active']");
	public static By rule_name=By.xpath("//input[@name='ruleNames']");
	public static By Backto_ManageRule=By.xpath("//span[text()='Back To Manage Rule']")
			;
	// adding basics
	public static By Standard_btn=By.xpath("//span[@class='btn phx-label'][text()='Standard']");
	public static By Advanced_btn=By.xpath("//span[@class='btn phx-label'][text()='Advanced']");
	public static By attribute_txtbox=By.xpath("//div[@class='ag-header-cell ag-header-cell-sortable ag-header-cell-left'][@col-id='attribute']");
	public static By attribute_drpdwn=By.xpath("//select[@class='ag-cell-edit-input']");
	public static By Field_drpdwn=By.xpath("//select[@class='ag-cell-edit-input']");
	public static By Field_txtbox=By.xpath("//div[@class='ag-cell ag-cell-with-height ag-cell-value ag-cell-no-focus ag-cell-not-inline-editing'][@col-id='field']");
	public static By Value_txtbox=By.xpath("//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-no-focus ag-cell-value'][@col-id='Value']");
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
	public static By SavedRule_txt=By.xpath("//div[text()='Saved Successfully']");
}
