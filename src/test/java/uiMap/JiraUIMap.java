package uiMap;

import org.openqa.selenium.By;



public class JiraUIMap {
	
public static By login_btn=By.xpath("//a[text()='Log In']");
public static By signIn_txtbox=By.xpath("//input[@type='email' and @name='loginfmt']");

public static By Next_btn=By.xpath("//input[@type='submit']");
public static By NextMoveIssue_btn=By.xpath("//input[@id='next_submit']");
public static By MoveSubmit_btn=By.xpath("//input[@id='move_submit']");
public static By skip_btn=By.xpath("//input[@type='button'][@value='Skip']");
public static By Yes_btn=By.xpath("//input[@type='submit'][@value='Yes']");

public static String pickAnExistingAccount_statictxt = "//div[text()='{username}']";

public static By signInPwd_txtbox=By.xpath("//input[@id='passwordInput' and @name='Password']");
public static By signIn_btn=By.xpath("//span[@id='submitButton']");

public static By Create_link=By.xpath("//a[@id='create_link']");
public static By cancel_btn=By.xpath("//a[text()='Cancel']");

public static By CreateIssue_Statictxt=By.xpath("//h2[@title='Create Issue']");
public static By CreateWokitem_dropdown=By.xpath("//input[@id='issuetype-field']");
public static By SelectProject_dropdown=By.xpath("//input[@id='project-field']");
public static By ConfirmYourIndentity_txt = By.xpath("//span[text()='Confirm Your Identity']");

public static By Summary_txtBox=By.xpath("//input[@name='summary' and @id='summary']");

public static By CollapsedSideBar_icon=By.xpath("//input[@name='summary']");

//public static By Description_txtBox=By.xpath("//textarea[@id='description']");//label[text()='Description']//following::div[1]
//public static By Description_txtBox=By.xpath("//label[text()='Description']//following::div[1]");

//public static By Description_txtBox=By.xpath("//div[@id='mceu_31']");
public static By Description_txtBox=By.xpath("//body[@id='tinymce'][@class='mce-content-body ']");
public static By Description_iFrame=By.xpath("//div[@id='description-wiki-edit']//following::iframe[1]");
//
public static By de = By.xpath("//*[@id='mce_0_ifr']");
public static By EpicName_txtBox=By.xpath("//label[text()='Epic Name']//following::input[1]");
public static By Create_btn=By.xpath("//input[@type='submit' and @value='Create']");
public static By CreateSubTask_btn=By.xpath("//span[text()='Create sub-task']");
public static By firstElementInSearchBox_staticTxt = By.xpath("//span[@class='quick-search-item-title'][@xpath='1']");


public static By Project_link=By.xpath("//*[@title='View recent projects and browse a list of projects' or text()='Projects']");
public static String SelectProject_Link = "//a[contains(@href,'{ProjectName}')][@class='aui-icon-container'][contains(@id,'proj_lnk')]";
public static String checkIfTeamCreated_link = "//a[text()='{teamname}']";
public static By WorkItemExternalID_txt=By.xpath("//div[@class='quick-search-section-heading']//following::a[1]");
public static By WorkItemExternalIDTitle_txt=By.xpath("//img[@class='quick-search-item-image']//following::span[1]");

public static By SearchBoxHomePage_txtbox=By.xpath("//input[@id='quickSearchInput']");
public static By ExecuteIn_statictxt=By.xpath("//span[text()='Execute In']");
public static By TestExecution_txtbox=By.xpath("//textarea[@id='raven-field-issuepicker-textarea']");
public static By AddTestExecution_btn=By.xpath("//input[@value='Add' and @id='issue-selector-form-submit']");
public static By AssociatedSuccess_txt=By.xpath("//div[@class='aui-message closeable aui-message-success']");

public static By ExistingTestExecution_statictxt=By.xpath("//a[@title='Existing Test Execution']");
public static By ViewAllProject_link = By.xpath("//*[@id='project_view_all_link_lnk' or text()='View all projects']");
public static By SearchBoxAllPorjects_txtbox=By.xpath("//input[@id='project-filter-text' or @aria-label='Search projects']");
public static By ProjectKey_Statictxt = By.xpath("//table[@class='aui']//tbody//tr[1]//td[2]");
public static String ProjectKeyCloudJira_Statictxt = "//span[text()='{projectname}']";
public static By ProjectToSelect_Statictxt = By.xpath("//td[@class='cell-type-name']//a[1]");

public static By DynamicWorkItemID_txt = By.xpath("//a[@class='issue-created-key issue-link'][contains(text(),'has been successfully created.')]");

public static By StoryPoints_txtbox = By.xpath("//label[text()='Story Points']//following::input[1]");
public static By SprintName_drpdown = By.xpath("//input[@id='customfield_10100-field']");
public static By ReleaseName_drpdown = By.xpath("//textarea[@id='fixVersions-textarea']");
public static String SprintOrReleaseNamePresent_drpdown = "//*[text()='{sprintreleasename}']";
//public static By Releases_Link = By.xpath("//a[@class='aui-nav-item '][contains(@href,'release-page')]");
public static By Releases_Link = By.xpath("//span[text()='Releases']");
public static By SearchReleases_txtbox = By.xpath("//input[@id='version-filter-text']");
public static By SearchedReleaseName_txt = By.xpath("//table[@id='versions-table']//tbody//tr[1]//td[2]//a[1]");
public static By SearchedReleaseStartDate_txt = By.xpath("//table[@id='versions-table']//tbody//tr[1]/td[5]/div[1]/time[@class='date']");
public static By SearchedReleaseEndDate_txt = By.xpath("//table[@id='versions-table']//tbody//tr[1]/td[6]/div[1]/time[@class='date']");

public static By Components_Link = By.xpath("//span[text()='Components']");
public static By ComponentName_txtbox = By.xpath("//input[@aria-label='Component name']");
public static By ComponentAssignee_txtbox = By.xpath("//input[@id='assigneeType-field']");


public static By ReleaseVersionName_txtBox = By.xpath("//input[@aria-label='Version name']");
public static By ReleaseStartDate_txtBox = By.xpath("//input[@name='startDate']");
public static By ReleaseEndDate_txtBox = By.xpath("//input[@name='releaseDate']");
public static By AddRelease_btn = By.xpath("//button[text()='Add']");
public static By Filterwithreleasename_txtbox = By.xpath("//input[@id='version-filter-text']");
public static By ActionRelease_btn = By.xpath("//span[@class='aui-icon aui-icon-small aui-iconfont-more'][text()='Operations']");
public static By ActionReleaseCloudJira_btn = By.xpath("//span[@class='sc-htpNat dcTkON' and @aria-label='More']");
public static By DeleteRelease_link = By.xpath("//a[text()='Delete'][@class='project-config-operations-delete']");
public static By DeleteReleaseCloudJira_link = By.xpath("//span[text()='Delete']");
public static By DeleteReleaseConfirmationBox = By.xpath("//div[contains(text(),'Are you sure you want to delete')]");
public static By DeleteReleaseConfirmationBox_CloudJira = By.xpath("//span[contains(text(),'deleted')]");

public static By DeleteReleaseConfirm_btn = By.xpath("//input[@id='submit' and @value='Yes']");
public static By ReleaseDeletedConfirmationMSg = By.xpath("//h4[text()='No versions were found that match your search']");


public static By Probability_dropdown = By.xpath("//*[@name='customfield_11300']");
public static By Impact_dropdown = By.xpath("//*[@name='customfield_11205']");
public static By TargetResolutionDate_txtBox = By.xpath("//input[@name='customfield_10505']");
public static By NextReviewDate_txtBox = By.xpath("//input[@name='customfield_10506']");

public static By ActiveSprint_Img = By.xpath("//span[@class='active-sprint-lozenge aui-lozenge aui-lozenge-success']");

public static By CreateSprint_btn = By.xpath("//button[text()='Create sprint' or text()='Create Sprint']");
public static By NewSprintName_txt = By.xpath("//input[@id='ghx-sprint-name']");
public static By SprintStartDate_txt = By.xpath("//input[@id='ghx-sprint-start-date']");
public static By SprintEndDate_txt = By.xpath("//input[@id='ghx-sprint-end-date']");
public static By CreateNewSprint_btn = By.xpath("//button[@title='Press Ctrl+Alt+s to submit this form.']");


public static By BacklogIcon_Img = By.xpath("//span[@title='Backlog' or text()='Backlog']");
public static By SprintName_Statictxt = By.xpath("//div[@id='ghx-classification-menu-column']//following::span[@class='field-value ghx-editable js-editable-field js-edit-sprintName-trigger'][1]");
public static By SprintStartDate_Statictxt = By.xpath("//div[@id='ghx-classification-menu-column']//following::span[@class='field-value ghx-editable js-editable-field js-edit-startDate-trigger'][1]");
public static By SprintEndDate_Statictxt = By.xpath("//div[@id='ghx-classification-menu-column']//following::span[@class='field-value ghx-editable js-editable-field js-edit-endDate-trigger'][1]");

public static By Issues_link =  By.xpath("//a[@title='Search for issues and view recent issues']");
public static By ViewALlIssuesAndFilters_link = By.xpath("//a[text()='Search for issues']");
public static By advancedSearch_txtbox = By.xpath("//textarea[@id='advanced-search']");

public static By SwitchToAdvancedSearch_btn = By.xpath("//a[@original-title='Switch to advanced search using JQL']");
public static By Search_btn = By.xpath("//button[@class='aui-button aui-button-primary search-button']");
public static By SaveAsEnabaledPostSearchResult_btn = By.xpath("//button[@class='aui-button save-as-new-filter' and @aria-disabled='false']");
public static By Tools_drpdown = By.xpath("//button[@class='aui-button aui-button-subtle header-tools header-operations jira-aui-dropdown2-trigger']");
public static By allIssues_drpdown = By.xpath("//a[@class='aui-list-item-link' and @id='bulkedit_all']");
public static By ChooseIssues_Statictxt = By.xpath("//h2[text()='Step 1 of 4: Choose Issues']");
public static By BulkEdit_checkbox= By.xpath("//table//tr[1]//th[1]//input[@id='bulkedit-select-all']");
public static By NextBtnDeleteData_btn = By.xpath("//div[@class='end-of-stable-message']//following::input[@type='submit']");
public static By ChooseOperations_Statictxt = By.xpath("//h2[text()='Step 2 of 4: Choose Operation']");
public static By DeleteIssues_btn = By.xpath("//table//tbody//tr[4]//input[@id='bulk.delete.operation.name_id']");
public static By NextBtnChooseOpsScreen_btn = By.xpath("//input[@name='Next']");
public static By Operationsdetails_Statictxt = By.xpath("//h2[text()='Step 3 of 4: Operation Details']");
public static By UncheckSendEmail_chkbox = By.xpath("//label[@for='sendBulkNotificationCB']");
public static By ConfirmationScreen_Statictxt = By.xpath("//h2[text()='Step 4 of 4: Confirmation']");
public static By ConfirmDelete_btn = By.xpath("//input[@name='Confirm']");
public static By DataDeletedConfirmationMsg_statictxt = By.xpath("//span[contains(text(),'Finished')]");
public static By waitSpin_img = By.xpath("//div[@class='aui-spinner spinner']");
public static By CreateDisabled_btn = By.xpath("//input[@name='Edit' and @value='Create' and @disabled='disabled']");


public static String SprintNameFromRMP_statictxt = "//span[@data-fieldname='sprintName' and @data-fieldvalue='{sprintname}']";
public static String SprintStartDateFromRMP_statictxt ="//span[@data-fieldname='sprintName' and @data-fieldvalue='{sprintname}']//following::span[@data-fieldname='startDate'][1]";
public static String SprintEndDateFromRMP_statictxt ="//span[@data-fieldname='sprintName' and @data-fieldvalue='{sprintname}']//following::span[@data-fieldname='endDate'][1]";
public static By UserName_txtbox = By.xpath("//input[@name='os_username']");
public static By Pwd_txtbox = By.xpath("//input[@name='os_password']");
public static By login_btn1 = By.xpath("//input[@name='login' and @value='Log In']");

public static By EditSprintDots_button = By.xpath("//a[@class='aui-button js-sprint-actions-trigger' or @class='aui-button aui-button-compact js-sprint-actions-trigger'][1]/span[1]");
public static By EditSprint_link = By.xpath("//a[text()='Edit sprint']");
public static By SprintName_txt = By.xpath("//label[@for='ghx-sprint-name']//following::input[1]");
public static By SaveSprint_btn = By.xpath("//button[@type='submit' and text()='Save']");
public static By UpdateSprint_btn = By.xpath("//button[text()='Update']");
//cloud jira
public static By CloudJiraEmailID_txtbox=By.xpath("//input[@type='email' and @class='Input__InputElement-sc-1o6bj35-0 bfCuIo']");
public static By CloudJiraCtn_btn=By.xpath("//span[text()='Continue']");
public static By CloudJiraPwd_txtbox=By.xpath("//input[@id='password' and @class='Input__InputElement-sc-1o6bj35-0 bfCuIo']");
public static By CloudJiraLogIn_btn=By.xpath("//span[text()='Log in']");
public static By CloudJiraCreate_btn=By.xpath("//span[text()='Create']");
public static By CloudJiraProjects_link=By.xpath("//span[text()='Projects']");
public static By CloudJiraViewALlProjects_link=By.xpath("//span[text()='View all projects']");
public static By CloudJiraSearchProject_txtbox=By.xpath("//input[@name='search']");
public static By CloudJiraProjectKey_Statictxt = By.xpath("//table[@class='sc-iuJeZd bqkAwE']//tbody//tr[1]//td[2]//a//div//span");
public static By CloudJiraCreate_link=By.xpath("//span[text()='Create']");
public static By CloudJiraCreateIssue_Statictxt=By.xpath("//h2[@title='Import issuesCreate issue']");
public static By CloudJiraSearchBoxHomePage_txtbox=By.xpath("//input[@data-test-id='search-dialog-input']");
public static By CloudJiraGetIssueID_statictxt=By.xpath("//a[@class='js-issue-link']");
public static By CloudJiraReleases_Link = By.xpath("//span[text()='Releases']");
public static By CloudJiraReleaseCreateVersion_Link = By.xpath("//span[text()='Create version']");
public static By CloudJiraReleaseName_txtBox = By.xpath("//label[text()='Start Date']//preceding::input[1]");
public static By CloudJiraReleaseStartDate_txtBox = By.xpath("//span[text()='Start date']/following::div[@class=' css-ypi1dq-placeholder'][1]");
public static By CloudJiraReleaseEndDate_txtBox = By.xpath("//span[text()='Start date']/following::div[@class=' css-ypi1dq-placeholder'][2]");
public static By CloudJiraSaveRelease_btn = By.xpath("//span[text()='Save']");
public static By CloudJiraBacklogIcon_Img = By.xpath("//span[text()='Backlog']");
public static By CloudJiraEditSprintDots_Img = By.xpath("//span[@class='aui-icon ghx-iconfont aui-icon-small aui-iconfont-more']");

public static By CloudJiraDeleteSprint_link = By.xpath("//a[text()='Delete sprint']");
public static By CloudJiraConfirmSprintDelete_btn = By.xpath("//button[text()='Confirm']");
public static By CloudJiraSearchWorkItem_txtbox = By.xpath("//input[@data-test-id='search-dialog-input']");

public static String CloudJiraclickWorkitemFromSearch_link = "//span[text()='{id}']";
public static By ActiontheWorkItem_link = By.xpath("//button[@aria-label='Actions' and @data-testid='issue-meatball-menu.ui.dropdown-trigger.button']");


public static By CloudJiraEditSprint_Img = By.xpath("//a[text()='Edit sprint']");
public static By CurrentSprintToBeEdited_txt = By.xpath("//span[@class='field-value ghx-editable js-editable-field js-edit-sprintName-trigger']");

public static By CloudJiraSprintName_txt = By.xpath("//input[@id='ghx-sprint-name']");
public static By CloudJiraSaveSprint_btn = By.xpath("//button[text()='Update']");

public static By CloudJiraStartDateIcon = By.xpath("//span[text()='Start date']/following::span[@class='sc-htpNat dcTkON' and @role='presentation'][1]");
public static By CloudJiraNextMonthIcon = By.xpath("//span[@aria-label='Next month']");
public static By CloudJiraSelectReleaseStartDate = By.xpath("//div[@aria-label='calendar']//following::table[1]//tbody/tr[1]/td[1]/div[1]");
public static By CloudJiraGetReleaseStartDate = By.xpath("//div[@class=' css-lrg2au-singleValue']");

public static By CloudJiraSelectReleaseEndDate = By.xpath("//div[@aria-label='calendar']//following::table[1]//tbody/tr[2]/td[1]/div[1]");
public static By CloudJiraGetReleaseEndDate = By.xpath("//div[@class=' css-lrg2au-singleValue']");

public static By more_link = By.xpath("//span[text()='More']");
public static By move_link = By.xpath("//span[text()='Move']");
public static By delete_link = By.xpath("//span[text()='Delete']");
public static By moveIssue_txt = By.xpath("//h1[text()='Move Issue']");
public static By newproject_drpdown = By.xpath("//input[@id='project-field']");
public static By newentitytype_drpdown = By.xpath("//input[@id='issuetype-field']");
public static By updatefields_statictxt = By.xpath("//h3[contains(text(),'Update')]");

public static By MoveIssueConfirm_statictxt = By.xpath("//h3[contains(text(),'Confirm')]");
public static By confirmProjectChange_statictxt = By.xpath("//a[@class='issue-link']");
public static By CloudJiraconfirmProjectChange_statictxt = By.xpath("//div[@class='Droplist-sc-1z05y4v-0 cLrmQm']//following::span[1]");


public static By Priority_drpdown = By.xpath("//input[@id='priority-field']");
public static By RiskReduction_drpdown = By.xpath("//label[text()='Risk Reduction/OE']//following::*[@class='select cf-select'][1]");
public static By BusinessValue_drpdown = By.xpath("//label[text()='Business Value']//following::*[@class='select cf-select'][1]");

public static By searchRelease_txtBox = By.xpath("//input[@data-test-id='searchfield']");

public static String SprintToBedeleted_txt = "//span[text()='{SprintName}']";
public static String ActionSpecificSprint_btn = "//span[text()='{SprintName}']//following::span[@class='aui-icon ghx-iconfont aui-icon-small aui-iconfont-more'][1]";
public static By ConfirmDeleteSprint_btn = By.xpath("//button[text()='Delete' or text()='Confirm']");
public static By ADOPSprintVisible_icon = By.xpath("//span[contains(@data-fieldvalue,'Orphan Sprint Textual')]//following::div[text()='0 issues - '][1]");
public static By EditADOPSprintName_txtbox = By.xpath("//span[contains(@data-fieldvalue,'Orphan Sprint Textual')]//following::div[text()='0 issues - '][1]//preceding::span[1]");
}
