package uiMap;

import org.openqa.selenium.By;



public class SecurityTestsUIMap {
	

public static By AddAccount_AccountManagementPage_link=By.xpath("//span[text()='Add Account']");
public static By VirtualAgents_statictxt=By.xpath("//a[text()='Virtual Agents']");
public static By GenericDataUploaderSelectEntity_drpdown=By.xpath("//select[@name='entity']");
public static By SelectDataEntity_drpdown=By.xpath("//span[@name='entity']");
public static By SelectdrpdownforTemplate_drpdown=By.xpath("//span[@class='dropdown-down']");
public static By SelectdrpTemplate_drpdown=By.xpath("//div[contains(text(),'Standard Template')]");

public static By BasicDetails_AddAccountPage_statictxt=By.xpath("//span[text()='Basic Details']");
public static By BasicDetails_AccessRolePage_statictxt=By.xpath("//span[text()='Basic Details ']");
public static By Cancel_AddAttributePage_btn = By.xpath("//button[@title='Close the popup and navigate to Delivery Construct Type']");
public static String subpage_link = "//span[text()='{subpagelink}']";
public static By BackToDashboard_link = By.xpath("//div[text()='Back to Dashboard' or @title='Go Back']");
public static By Close_btn = By.xpath("//button[text()='Close']");
public static By AssociateClients_btn = By.xpath("//button[text()='Associate Clients']");
public static By CloseAssociateClients_btn = By.xpath("//button[@class='close']");
public static By ViewEditMapping_btn = By.xpath("//img[@title='View/Edit']");

public static By GoBack_btn = By.xpath("//div[@title='Go Back']");
public static By VABack_btn = By.xpath("//a[@title='Virtual Agents']//following::a[@class='pva-btn-icon pva-back'][2]");
public static By AttentionArea_btn = By.xpath("//a[@title='Attention Areas']");
public static By VASettings_btn = By.xpath("//img[@src='/core/images/Settings_icon.png']");
public static By Query_btn = By.xpath("//a[@aria-label='Query']");
public static By Recommendation_btn	 = By.xpath("//a[@aria-label='Recommendation']");
public static By Entity_btn = By.xpath("//a[@aria-label='Entity']");
public static By ruleBuilder_btn = By.xpath("//a[@aria-label='ruleBuilder']");
public static By CloseAddDC_btn = By.xpath("//button[@class='close']");


public static By BackToManageRecon_btn = By.xpath("//span[text()='Back To Manage Reconciliation']");
public static By Notifications_btn = By.xpath("//span[@class='pva-topnav-count']");



public static By MetricsDashboardSetting_btn = By.xpath("//img[@src='/core/images/pva-MetricsConfiguration.png']");
public static By ProcessBuilder_btn = By.xpath("//img[@src='/core/images/pva-process.svg']");


public static By waitSign_Img = By.xpath("//div[@class='pva-metrics-loader']");


public static By Search_txtbox = By.xpath("//input[@placeholder='Search...']");
public static By Search500_txtbox = By.xpath("//input[@placeholder='Enter text to search the first 500 records']");
public static By AddAttribute_statictxt = By.xpath("//h5[text()='Add Attribute']");
public static By AddTile_statictxt = By.xpath("//h5[text()='Add Tile']");
public static By AddTeam_statictxt = By.xpath("//span[text()='Team']");
public static By AddProduct_statictxt = By.xpath("//a[text()='Add Product']");
public static By AddStageTemplate_statictxt = By.xpath("//span[text()='Add Stage Template']");
public static By AddAccessRole_statictxt = By.xpath("//a[text()='Add Access Role']");
public static By AddEditIterationRecon_statictxt = By.xpath("//a[text()='Add/Edit Iteration Reconciliation']");
public static By MyQueries_statictxt = By.xpath("//a[text()='My Queries']");
public static By NewQueryEditor_statictxt = By.xpath("//span[text()='Editor']");
public static By AddDC_statictxt = By.xpath("//h5[text()='Add Delivery Construct']");

public static By AddClient_statictxt = By.xpath("//a[text()='Add Client']");
public static By DataUpload_statictxt = By.xpath("//a[text()='Data Upload']");
public static By GenericUploader_statictxt = By.xpath("//a[text()='Generic Uploader']");
public static By MetricsEngine_statictxt = By.xpath("//a[text()='Metrics Engine']");




public static By ConfigContractExplore_btn = By.xpath("//div[@class='card-header configure']//following::button[1]");
public static By SelfEnabledAutomationExplore_btn = By.xpath("//div[@class='card-header self-enable']//following::button[1]");
public static By OnbaordClientToolExplore_btn = By.xpath("//div[@class='card-header onboard']//following::button[1]");
public static By BacktoDIYADAutomation_btn = By.xpath("//div[text()='Back to DIY AD Automation']");

public static By SelectFunctions_btn = By.xpath("//li[@class='parentDC phx-cob-sdc-hide ng-star-inserted' or @class='parentDC phx-cob-sdc-hide'][1]/following::a[@class='active' or @class='inactive'][1]");
public static By IntegrateTools_btn = By.xpath("//li[@class='parentDC phx-cob-sdc-hide ng-star-inserted' or @class='parentDC phx-cob-sdc-hide'][1]/following::a[@class='active' or @class='inactive'][2]");
public static By DataMapping_btn = By.xpath("//li[@class='parentDC phx-cob-sdc-hide ng-star-inserted' or @class='parentDC phx-cob-sdc-hide'][1]/following::a[@class='active' or @class='inactive'][3]");
public static By EnableUsecases_btn = By.xpath("//li[@class='parentDC phx-cob-sdc-hide ng-star-inserted' or @class='parentDC phx-cob-sdc-hide'][1]/following::a[@class='active' or @class='inactive'][4]");
public static By AddUsers_btn = By.xpath("//li[@class='parentDC phx-cob-sdc-hide ng-star-inserted' or @class='parentDC phx-cob-sdc-hide'][1]/following::a[@class='active' or @class='inactive'][5]");
public static By GetStarted_btn = By.xpath("//li[@class='parentDC phx-cob-sdc-hide' or @class='parentDC phx-cob-sdc-hide'][1]/following::a[@class='active' or @class='inactive'][6]");
public static By BacktoOverallSetup_btn = By.xpath("//div[text()='Back to Overall Setup Progress']");
public static By PPM_RadioBtn = By.xpath("//label[text()='Portfolio, Program & Project Management (PMI - PPM)']");
public static By AddDC_btn = By.xpath("//button[@title='Add Delivery Construct']");
public static By enterDCName_txtbox = By.xpath("//input[@name='Portfolio']");
public static By saveandClose_btn = By.xpath("//button[@title='Save & Close']");
public static By deletePortfolio_btn = By.xpath("//a[@title='Delete Portfolio']");

public static String TestProcessName = "//h6[text()='{testprocessname}']";
public static String TestProcess_MoreOptions_Drpdown = "//h6[text()='{testprocessname}']//following::a[@class='myw-action'][1]";
public static String TestProcess_Edit_Link = "//h6[text()='{testprocessname}']//following::a[text()='Edit'][1]";

//xpath by likhitha
public static By Search_text = By.xpath("//input[@placeholder='Search...']");
public static By Active_btn = By.xpath("//input[@name='status']//following::span[text()='Active']");
public static By Inactive_btn= By.xpath("//input[@name='status']//following::span[text()='InActive']");
public static By Save_btn = By.xpath("//button[@title='Save Delivery Construct Type']");
public static By Cancel_btn = By.xpath("//button[@title='Cancel the changes and navigate to Manage Organization Structure']");
public static By title_text = By.xpath("//span[@title='Automation_DoNotEdit']");
public static By querySaved_txt=By.xpath("//div[contains(text(),'Delivery Structure Type saved successfully')]");
public static By Back_option = By.xpath("//div[@title='Back to Manage Delivery Structure Type']");
public static String Delete_icon= "//div[@id='collapseMyQueries']//table[@class='phx-myqueries-table']//tbody//tr[1]//td//a[@title='Delete Query']";
public static By Epic_StaticTxt=By.xpath("//div[text()='Epic_TFS scrum']");
public static By Saverule_btn=By.xpath("//button[@class='btn btn-primary'][text()='Save']");
public static By Inactiverule_btn=By.xpath("//span[text()='InActive']");
public static By Activerule_btn=By.xpath("//span[text()='Active']");
//ClientConfig
public static By Search_Textbox1=By.xpath("//input[@placeholder='Enter text to search the first 500 records']");
public static By title_statictxt=By.xpath("//div[text()='Unknown@']");
public static By Descprition_txtarea=By.xpath("//textarea[@name='Description']");
public static By Savedescription_btn=By.xpath("//button[@class='btn btn-primary'][text()='Save']");
//ProductConfig
public static By Add_Product=By.xpath("//a[@title='Add Product']");
public static By Productname_txtbox =By.xpath("//input[@name='name']");
public static By Vendor_drpdwn=By.xpath("//select[@name='vendor']");
public static By Productcode_txtbox=By.xpath("//input[@name='code']");
public static By Shortdescription_txtbox=By.xpath("//textarea[@name='shortDescription']");
public static By description_txtbox=By.xpath("//textarea[@name='description']");
public static By productCategory_drpdwn =By.xpath("//select[@name='productCategory']");
public static By productSubcategory_drpdwn=By.xpath("//select[@name='productSubcategory']");
public static By productSubmissioncategor_drpdwn=By.xpath("//select[@name='productSubmissioncategory']");
public static By productType_drpdwn=By.xpath("//select[@name='productType']");
public static By status_drpdwn=By.xpath("//select[@name='status']");
public static By saveproduct_btn=By.xpath("//button[@class='btn btn-primary'][text()='Save']");
public static By backtoproductconfig_btn=By.xpath("//div[@title='Back to Manage Product Configuration']");
public static By searchproductconfig_txt1=By.xpath("//input[@placeholder='Search...']");
public static By application_btn=By.xpath("//span[text()='Applications']");
public static By deleteproduct_btn=By.xpath("//a[@title='Delete Product']");
public static By deletionconfirmation_btn=By.xpath("//button[@title='Click Yes to delete the Product']");
public static By backtodashboard_btn=By.xpath("//div[@title='Back to Dashboard']");
public static By ProductConfigName_txt=By.xpath("//span[@title='ProdConfigData_Automation_DonotEdit']");
//Lifecycle Template Configuration/Add Stage Template
public static By AddStageTemplate_txt = By.xpath("//span[text()='Add Stage Template']");
public static By name_txtbox =By.xpath("//input[@name='name']");
public static By entityuid_drpdwn=By.xpath("//select[@id='entityUId']");
public static By type_drpdwn1=By.xpath("//span[@class='dropdown-btn']");
public static By type_checkbox=By.xpath("//div[text()='Architecture & component design']");
public static By description_txtbox1=By.xpath("//input[@id='D_1']");
public static By savetemplate_btn=By.xpath("//button[@class='btn btn-primary ng-star-inserted'][text()=' Save ']");
public static By stagename_txtbox=By.xpath("//input[@id='S_1']");
public static By completion_txtbox=By.xpath("//input[@id='P_1']");
public static By delete_symbol=By.xpath("//div[@title='Delete']");
public static By yes_btn=By.xpath("//button[text()='Yes']");
public static By name_textbox=By.xpath("//table[@class='ui-treetable-scrollable-header-table']/thead/tr[2]/th[1]/input[1]");





//xpath by sangeetha


//Team configuration
public static By Team_Searchbox=By.xpath("//input[@placeholder='Enter text to search the first 500 records']");
public static By delete_button=By.xpath("//table[@class='ui-treetable-table']//tbody//tr[1]//td[6]//a[@title='Delete Team']");
public static By confirmDelete_button=By.xpath("//div[@class='modal-footer']//button[text()='Yes']");
public static By TeamSave_button=By.xpath("//button[text()='Save' ][@class='btn btn-primary']");
//Data upload
public static By SelectEntity_Drpdown=By.xpath("//*[@name='AppServiceGroup']");
public static By Browse_btn = By.xpath("//input[@id='uploadFile']");
public static By Upload_checkbox = By.xpath("//table//tbody//tr[1]//td[1]//input[@name='access-role']//following::span[1]");
public static By UploadAll_link = By.xpath("//span[text()='Upload All']");
public static By UploadComplete_statictxt = By.xpath("//td[text()=' Completed ']");
public static By waitSign_Img1 = By.xpath("//div[@class='sk-ball-spin-clockwise']");
public static By BacktoManage_text=By.xpath("//div[@title='Back to Manage Organization (Delivery) Structure']");
//organisation delivery structure

public static By DC_Searchbox = By.xpath("//input[@placeholder='Search...']");
public static By Dc_data= By.xpath("//span[@title='Automationdata_donotedit']");
public static By  DcActivate_button= By.xpath("//span[text()='Active'][@class='btn phx-label']");
public static By  DcInactivate_button= By.xpath("//span[text()='InActive'][@class='btn phx-label']");
public static By  DcSave_button= By.xpath("//button[@title='Save Delivery Construct']");
public static By Popup_Yes=By.xpath("//button[@title='Click Yes to leave the form']");



//Account management
public static By SearchAccount_txtbox=By.xpath("//input[@placeholder='Enter text to search the first 500 records']");
public static By Activate_btn=By.xpath("//span[text()='Active'][@class='btn phx-label']");
public static By InActivate_btn=By.xpath("//span[text()='Inactive'][@class='btn phx-label']");
public static By AccountManagementSave_btn=By.xpath("//button[@class='btn btn-primary'][text()='Save']");
public static By Select_account=By.xpath("//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-value ag-column-hover ag-cell-focus'][text()='AutomationAccount_DoNotEdit']");
public static By Select_account1=By.xpath("//div[text()='AutomationAccount_DoNotEdit']");







}
