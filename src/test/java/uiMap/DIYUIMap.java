package uiMap;

import org.openqa.selenium.By;



public class DIYUIMap {
	

public static By ConfigureContractExplore_btn=By.xpath("//div[text()=' Configure Contract ']//following::button[1]");
public static By AddDC_link=By.xpath("//span[text()='Add Delivery Structure']");
public static By DCType_drpdown=By.xpath("//select[@name='deliveryStructureType']");
public static By AddDC_btn=By.xpath("//button[text()=' Add ']");
public static By PortfolionName_txtbox=By.xpath("//input[@placeholder='Please enter the Portfolio name']");
public static By PlusIconToAddPortfolio_btn=By.xpath("//table[@class='ui-treetable-table']//tbody//tr[1]//td[3]//a[@aria-label='Add']");
public static By ContractOpportunityDetails_btn=By.xpath("//table[@class='ui-treetable-table']//tbody//tr[1]//td[3]//a[@title='Contract/Opportunity Details']");
public static By ContractOpportunityDetails_window=By.xpath("//h5[text()=' Contract/Opportunity Details - ']");

public static By Market_drpdown=By.xpath("//label[text()='Market ']//following::input[@role='combobox'][1]//following::span[@class='ng-arrow-wrapper'][1]");
public static By Market_drpdownValue=By.xpath("//span[text()='Europe']");
public static By MarketUnit_drpdown=By.xpath("//label[text()='Market Unit ']//following::input[@role='combobox'][1]//following::span[@class='ng-arrow-wrapper'][1]");
public static By MarketUnit_drpdownValue=By.xpath("//span[text()='Nordic']");
public static By IndustrySegement_drpdown=By.xpath("//label[text()='Industry Segment ']//following::input[@role='combobox'][1]//following::span[@class='ng-arrow-wrapper'][1]");
public static By IndustrySegement_drpdownValue=By.xpath("//span[text()='Energy']");
public static By ClientServiceGroup_drpdown=By.xpath("//label[text()='Client Service Group ']//following::input[@role='combobox'][1]//following::span[@class='ng-arrow-wrapper'][1]");
public static By ResponsibleBusinessEntity_drpdown=By.xpath("//label[text()='Responsible Business Entity ']//following::input[@role='combobox'][1]//following::span[@class='ng-arrow-wrapper'][1]");
public static By ResponsibleBusinessEntity_drpdownValue=By.xpath("//span[text()='Security']");
public static By DeliveryLead_txtbox=By.xpath("//label[text()='Delivery Lead ']//following::input[@type='text'][1]");
public static By DeliveryFunction_drpdown=By.xpath("//label[text()='Delivery Function ']//following::span[@class='dropdown-btn'][1]");
public static By DeliveryFunction_drpdownValue=By.xpath("//div[text()='Analytics']");
public static By DeployRegion_drpdown=By.xpath("//label[text()='Deploy Region ']//following::input[@role='combobox'][1]//following::span[@class='ng-arrow-wrapper'][1]");
public static By DeployRegion_drpdownValue=By.xpath("//span[text()='APAC']");
public static By EndToEndType_drpdown=By.xpath("//label[text()='End To End Type ']//following::input[@role='combobox'][1]//following::span[@class='ng-arrow-wrapper'][1]");
public static By EndToEndType_drpdownValue=By.xpath("//span[text()='Contract']");
public static By ContractOpportunityId_txtbox=By.xpath("//label[text()='Contract/Opportunity Id ']//following::input[@type='text'][1]");
public static By ContractOpportunityStartDate_drpdown=By.xpath("//label[text()='Contract/Opportunity Start Date ']//following::input[@type='text'][1]");
public static By ContractOpportunityEndDate_drpdown=By.xpath("//label[text()='Contract/Opportunity End Date ']//following::input[@type='text'][1]");
public static By Platform_drpdown=By.xpath("//label[text()='Platform ']//following::input[@role='combobox'][1]//following::span[@class='ng-arrow-wrapper'][1]");
public static By Platform_drpdownValue=By.xpath("//span[text()='ACI']");
public static By DeliveryType_drpdown=By.xpath("//label[text()='Delivery Type ']//following::span[@class='dropdown-btn'][1]");
public static By DeliveryType_drpdownValue=By.xpath("//div[text()='Application Development - Agile']");
public static By Save_btn=By.xpath("//button[text()='Save' and @title='Save' and @class='btn btn-primary-mod ml-4']");
public static By SaveAndClose_btn=By.xpath("//button[text()='Save & Close']");

public static By DCSavedSuccess_Msg=By.xpath("//div[contains(text(),'Delivery Construct saved successfully')]");

public static By SelfEnableAutomationExplore_btn=By.xpath("//div[text()=' Self Enable Automation ']//following::button[1]");
public static By SearchDC_txtbox=By.xpath("//input[@placeholder='Search...']");
public static String DCName_statictxt="//span[text()='{DCName}']";

public static By SelectFunctions_btn=By.xpath("//span[@class='phx-cob-overall-arrow-2']");
public static By selectedToolADTJira_checkbox=By.xpath("//input[contains(@id,'ADT JIRA')]");
public static By selectedToolADOPJira_checkbox=By.xpath("//input[contains(@id,'ADOP JIRA')]");
//public static By selectedToolTFS_checkbox=By.xpath("//input[contains(@id,'myWizard-TFS')]");
public static By TFS_checkbox=By.xpath("//input[contains(@id,'Azure DevOps (VSTS)-Agile-Air New Zealand')]");
public static By selectedToolMyWizardTFS_checkbox=By.xpath("//input[contains(@id,'myWizard-TFS')]");
public static By Next_btn=By.xpath("//button[text()='Next']");
public static By SaveAndNext_btn=By.xpath("//button[text()='Save & Next']");
public static By SaveAndNextFinalScreen_btn=By.xpath("//*[@id='ApplicationData']/div[2]/button[2]");
public static By ProjectArea_txtbox=By.xpath("//input[@placeholder='Please enter the Project Key' or @placeholder='Please enter the Project Name']");
public static By BoardID_txtbox=By.xpath("//input[@placeholder='Please enter the Board ID']");
public static By methodology_drpdown=By.xpath("//select[@name='methodology']");
public static By SaveSuccess_Msg=By.xpath("//div[contains(text(),'Saved successfully') or contains(text(),'saved successfully')]");
public static By entity_drpdown=By.xpath("//select[@name='entity']");
public static By RuleDoesntExists_Msg=By.xpath("//*[contains(text(),'No Standard Rule created, please add a rule ')]");
public static By Project_drpdown=By.xpath("//table[@class='ui-treetable-table']//tbody//tr[1]//td[1]//select[1]");
public static By Operator_drpdown=By.xpath("//table[@class='ui-treetable-table']//tbody//tr[1]//td[2]//select[1]");
public static By Value_txtbox=By.xpath("//table[@class='ui-treetable-table']//tbody//tr[1]//td[3]//input[1]");
public static String AppBundle_Icon="//label[text()='{appbundle}']//following::*[text()='All'][1]";
public static By SelfEnablementSuccessful_Msg=By.xpath("//div[text()='You are now enabled with AD automation usecases']");
public static By GetStarted_Btn=By.xpath("//button[text()=' Click here to get started']");
public static By clientAdminNumber_statictxt=By.xpath("//div[text()='Client Admin']//following::span[1]");
public static By AddAccount_link=By.xpath("//span[text()='Add Account']");
public static By Email_txtbox=By.xpath("//input[@type='email']");
public static By FirstName_txtbox=By.xpath("//input[@name='FirstName']");
public static By SelectRole_checkbox=By.xpath("//*[@name='selectroles']//following::input[@role='combobox'][1]");
public static By ClientAdminRole_checkbox=By.xpath("//span[text()='Client Admin']");
public static By Update_btn=By.xpath("//button[text()='Update']");
public static By DataMapping_link=By.xpath("//a[@title='Data Mapping']");
public static By Verifyconnectivity_btn=By.xpath("//button[text()='Click here to verify connectivity']");
public static By ConnectivitySuccess_Msg=By.xpath("//div[contains(text(),'Connectivity successful')]");
public static By DeleteDC_btn=By.xpath("//table[@class='ui-treetable-table']//following::a[@title='Delete Portfolio'][1]");
public static By ConfirmDeleteDC_btn=By.xpath("//button[@title='Delete Delivery Construct'][text()='Yes']");
public static By ConfirmChangingTool_btn=By.xpath("//span[contains(text(),'Do you want to change ')]//following::button[text()='Yes']");
public static By Yes_btn=By.xpath("//button[text()='Yes']");
public static By SelectuseCases_txt=By.xpath("//div[text()='SELECT USE CASES']");
public static By ProjHierarchy_txtbox=By.xpath("//label[text()='Project Hierarchy']//following::input[1]");
public static By ResponsibleDeliveryEntity =By.xpath("//label[text()='Responsible Delivery Entity ']//following::input[@role='combobox'][1]//following::span[@class='ng-arrow-wrapper'][1]");

}
