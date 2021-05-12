package uiMap;

import org.openqa.selenium.By;



public class TFSUIMap {
	

public static By signIn_txtbox=By.xpath("//input[@type='email' and @name='loginfmt']");
public static By Next_btn=By.xpath("//input[@type='submit']");

public static By Pwd_txtbox=By.xpath("//input[@type='password' and @name='passwd']");
public static By signIn_btn=By.xpath("//input[@type='submit']");

public static By searchProject_txtbox = By.xpath("//input[@aria-label='Filter projects']");
public static String clickProject_statictxt= "//div[@class='project-name font-size-l font-weight-semibold text-ellipsis'][text()='{projectname}']";
public static String VerifyProjectload_statictxt= "//H1[@class='project-name-container text-ellipsis title-l'][text()='{projectname}']";
public static String ChangedProj_statictxt= "//div[text()='{newproj}']";
public static By title_txtbox = By.xpath("//input[@aria-label='Title Field']");

public static By Priority_drpdown = By.xpath("//input[@aria-label='Priority']");
public static By StoryPoints_txtbox = By.xpath("//input[@aria-label='Story Point']");
public static By RiskReduction_txtbox = By.xpath("//input[@aria-label='Risk Reduction']");
public static By BusinessValue_txtbox = By.xpath("//input[@aria-label='Business Value']");


public static By save_drpdown = By.xpath("//li[@aria-label='More save options']//following::div[@class='drop'][1]");
//
public static By save_btn = By.xpath("//span[@class='text'][text()='Save']");
public static By saveandclose_btn = By.xpath("//span[text()='Save & Close']");
public static By captureWorkItemID_statictxt = By.xpath("//a[@class='caption']");
public static By captureWorkItemID1_statictxt = By.xpath("//span[@aria-label='ID Field'][1]");
public static By captureWorkItemID2_statictxt = By.xpath("//*[@id='witc_75_txt']/preceding::span[@aria-label='ID Field'][1]");
public static By close_btn = By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']");

public static By plusIcon_btn = By.xpath("//span[contains(@class,'Add medium')]");

public static By SearchBoxHomePage_txtbox = By.xpath("//input[@id='l1-search-input']");
//public static By WorkItemExternalIDTitle_txt = By.xpath("//span[@class='search-suggestion-title text-ellipsis']");
public static By WorkItemExternalIDTitle_txt = By.xpath("//table[@id='__bolt-instant-search-menu']/tbody//tr[4]//td[2]//following::span[@class='search-suggestion-title text-ellipsis']");


public static By WorkitemTitleSearch_statictxt = By.xpath("//span[@class='search-suggestion-icon flex-row flex-noshrink']//following::span[1]");

public static By WorkItemtxt_static = By.xpath("//div[@class='bolt-menuitem-cell-content bolt-menuitem-cell-text'][text()='Work items']");
public static By settingsIcon_Img = By.xpath("//span[contains(@class,'navigation-icon flex-row flex-center justify-center flex-noshrink fabric-icon ms-Icon--Settings medium')]");
public static By ProjectConfiguration_link = By.xpath("//span[text()='Project configuration']");
public static By NewChild_link = By.xpath("//span[text()='New child']");
public static By IterationName_txtbox = By.xpath("//input[@id='fieldName']");
public static By StartDate_txtbox = By.xpath("//input[@id='fieldStartDate']");
public static By EndDate_txtbox = By.xpath("//input[@id='fieldEndDate']");
public static By saveAndClose_btn = By.xpath("//span[text()='Save and close']");

public static String ReleaseRow_statictxt = "//div[text()='{releasename}']";
public static String newSprint_statictxt = "//div[@class='grid-cell-contents-container'][text()='{releasename}']//preceding::div[@aria-label='Row actions'][1]";

public static By Boards_link = By.xpath("//span[text()='Boards']");
public static By Queries_link = By.xpath("//span[text()='Queries']");
public static String DeletionQuery_link = "//div[@class='ms-TooltipHost host_2c77c47c'][text()='{queryname}']";
public static By QueryExecutionComplete = By.xpath("//span[@class='vss-HubTextTile--primaryText']");
public static By DeleteAutomationData_Btn = By.xpath("//span[text()='Delete']");
public static By DeletePath_btn = By.xpath("//span[text()='Delete path']");
public static By QueryExecuted_txt = By.xpath("//span[text()='Query returned no results.']");

public static String ReleaseORSprintNamefromRMP_statictxt = "//div[@class='grid-cell-contents-container' and text()='{releasenameORsprintname}']";
public static String ReleaseORSprintStartDatefromRMP_statictxt = "//div[@class='grid-cell-contents-container' and text()='{releasenameORsprintname}']//following::div[@class='grid-cell'][1]";
public static String ReleaseORSprintEndDatefromRMP_statictxt = "//div[@class='grid-cell-contents-container' and text()='{releasenameORsprintname}']//following::div[@class='grid-cell'][2]";

public static By TestPlan_link = By.xpath("//span[text()='Test Plans']");
public static By ALlTestPlan_link = By.xpath("//a[@aria-label='All test plans']");
public static By NewTestPlan_link = By.xpath("//span[text()='New Test Plan']");
public static By TestPlanName_txtbox = By.xpath("//input[@aria-label='Enter a plan name']");
public static By CreateTestPlan_btn = By.xpath("//button[text()='Create']");
public static By NewTestCase_btn = By.xpath("//span[text()='New Test Case']");
public static By TestCaseTitle_txtbox = By.xpath("//input[@aria-label='Title Field']");
public static By SaveAndClose_btn = By.xpath("//span[text()='Save & Close']");
public static By ExecuteTestCase_link = By.xpath("//span[text()='Execute']");
public static By SelectTestCase_chkbox = By.xpath("//table[@class='testplans-hub-execute-tab-testpoints-table bolt-table bolt-table-show-lines bolt-list body-m relative scroll-hidden']//tbody/tr[3]/td[2]//following::span[1]");
public static By RunForWebApplication_link = By.xpath("//span[text()='Run for web application']");
public static By More_link = By.xpath("//table[@class='testplans-hub-execute-tab-testpoints-table bolt-table bolt-table-show-lines bolt-list body-m relative scroll-hidden']//tbody/tr[3]/td[3]/following::button[@aria-label='More...']");
public static By MarkOutcome_link = By.xpath("//*[contains(text(),'Mark Outcome')]");
public static By Passtest_link = By.xpath("//*[contains(text(),'Mark Outcome')]//following::*[contains(text(),'Pass Test')]");
public static By MarkTestCaseResult_btn = By.xpath("//li[@aria-label='Mark test case result']");
public static By ViewTestResult_link = By.xpath("//*[contains(text(),'View test result')]");
public static String createdTest_txt = "//*[contains(text(),'{TCName}')]";
public static String workitemIDInSearch_txt = "//span[contains(text(),'{workitemid}')]";

public static By State_drpdown = By.xpath("//label[@for='witc_77_txt']");
public static By ActionWorkitem_btn = By.xpath("//span[@aria-label='Actions']");

public static By DeleteWorkitem_btn = By.xpath("//span[text()='Delete']");
public static By PermanentDeleteWorkitem_btn = By.xpath("//span[text()='Permanently delete']");
public static By ConfirmDeleteWorkitem_PopUp = By.xpath("//span[text()='Delete work item(s)']");
public static By ConfirmDeleteWorkitem_btn = By.xpath("//button[@id='ok']");
public static By DeleteReleaseSprint_btn = By.xpath("//span[text()='Delete']");
public static By DeleteReleaseSprintConfirm_window = By.xpath("//span[text()='Delete iteration']");
public static By ConfirmReleaseSprintDelete_btn = By.xpath("//span[text()='Delete path']");
public static String ReleaseOrSprintAction_btn = "//div[text()='{ReleaseOrSprintName}']//preceding::span[@class='grid-context-menu-icon bowtie-icon bowtie-ellipsis'][1]";
public static String ReleaseOrSprint_Row = "//div[text()='{ReleaseOrSprintName}']";
public static By ChangeEntityType_link = By.xpath("//span[text()='Change type...']");
public static By ChangeProject_link = By.xpath("//span[text()='Move to team project']");
public static By ChangeProjectTo_txtbox = By.xpath("//input[@id='destinationProject']");

public static By EntityTypeTo_txtbox = By.xpath("//input[@id='availableTypes']");

public static By Ok_btn = By.xpath("//button[@id='ok']");
public static By Iteration_drpdown = By.xpath("//input[@aria-label='Iteration Path']");
public static By Iteration_label = By.xpath("//label[text()='Ite']");
public static By deleteTestCase_txtbox = By.xpath("//input[@class='test-workitem-delete-inputbox']");



}
