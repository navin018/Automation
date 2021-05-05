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
public static By AddAttribute_statictxt = By.xpath("//h5[text()='Add Attribute']");
public static By AddTile_statictxt = By.xpath("//h5[text()='Add Tile']");
public static By AddTeam_statictxt = By.xpath("//span[text()='Team']");
public static By AddProduct_statictxt = By.xpath("//a[text()='Add Product']");
public static By AddStageTemplate_statictxt = By.xpath("//a[text()='Add Lifecycle Template ']");
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

}
