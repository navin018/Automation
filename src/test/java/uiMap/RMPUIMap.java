package uiMap;

import org.openqa.selenium.By;



public class RMPUIMap {
	

public static By MyWizardHome_Img=By.xpath("//img[@title='Home']");
public static By BizDevops_Statictxt = By.xpath("//div[text()='BizDevOps - Business Aligned SI & Operations']");
public static By ProgramPlanning_Img=By.xpath("//img[@alt='Program Planning']");
public static By LivingRoadmap_Img=By.xpath("//span[text()='Living Roadmap &  Workplan, Milestones & Deliverables']");
public static By LaunchRoadMapApp_Statictxt=By.xpath("//div[text()='Roadmap Assistant']//following::a[@title='Launch App'][1]");
public static By LoadingPleaseWait_msg=By.xpath("//span[@id='loader']");
public static By New_link=By.xpath("//div[contains(@class,'newIcon')]");
public static By Blank_link=By.xpath("//a[text()='Create New Roadmap']");
public static By RA_link=By.xpath("//h1[text()='Roadmap Assistant']");
public static By Edit_btn = By.xpath("//li[@data-original-title='Edit']");
public static By typeDropDown_Drpdown=By.xpath("//span[@class='dropdown-down']");
public static By typeDropUp_Drpdown=By.xpath("//span[@class='dropdown-up']");

public static By searchProject_txtbox = By.xpath("//input[@aria-label='Filter projects']");
public static String stageType_statictxt= "//input[@aria-label='multiselect-item' and @type='checkbox']//following::div[text()='{type1}']";

public static By stageName_txtbox = By.xpath("//input[@id='S_1']");
public static By stageDescription_txtbox = By.xpath("//input[@id='D_1']");
public static By stageCompletion_txtbox = By.xpath("//input[@id='P_1']");

public static By save_btn = By.xpath("//button[@class='btn btn-primary ng-star-inserted']");
public static By SearchTemplateByName_txtbox = By.xpath("//table/thead/tr[2]/th[1]//input[@placeholder='Search...']");
public static By verifyAddedTemplate_btn = By.xpath("//table/tbody/tr[1]/td[1]/div[1]/span[1]");
public static By AddInititave_link = By.xpath("//span[text()='Add Initiative']");
public static By AddRelease_link = By.xpath("//span[text()='Add Release']");
public static By AddSprint_link = By.xpath("//span[text()='Add Sprint']");

//public static By DropInitiative_box = By.xpath("//*[@id='rect1']/ngx-dnd-container/div");
//public static By DropRelease_box = By.xpath("//div[text()='Add Initiative']/following::ngx-dnd-container[1]/div");
//public static By DropSprint_box = By.xpath("//div[text()='Add Release']/following::ngx-dnd-container[1]/div");

public static By DropInitiative_box = By.xpath("//*[@id='rect1']");
//public static By DropRelease_box = By.xpath("//span[text()='Add Initiative']/following::ngx-dnd-container[1]/div");
//public static By DropRelease_box = By.xpath("//div[@class='ng-star-inserted']//following::div[contains(@class,'ngx-dnd-container')][1]");
public static By DropRelease_box = By.xpath("//div[@class='timeline-container']//following::div[contains(@class,'ngx-dnd-container')][1]");
//
//public static By DropSprint_box = By.xpath("//span[text()='Add Release']/following::ngx-dnd-container[1]/div");
public static By DropSprint_box = By.xpath("//div[@class='timeline-container']//following::div[contains(@class,'ngx-dnd-container')][2]");

public static By InitiativeEditOptions_btn = By.xpath("//span[text()='Add Initiative']/following::button[@data-original-title='More Options'][1]");
public static By ReleaseEditOptions_btn = By.xpath("//span[text()='Add Release']/following::button[@data-original-title='More Options'][1]");
public static By SprintEditOptions_btn = By.xpath("//span[contains(text(),'Sprint')]/following::button[@data-original-title='More Options'][1]");


public static By EditInitiave_btn = By.xpath("//button[contains(@title,'Add Initiative')]");
public static By EditRelease_btn = By.xpath("//a[@id='addPopup']//preceding::li[@data-original-title='Edit'][1]");
public static By EditSprint_btn = By.xpath("//button[contains(@title,'Sprint')]");


//public static By EditInitiave_link = By.xpath("//button[contains(@title,'Add Initiative')]//following::button[@class='dropdown-item dropdownalignment dropdown-margin' and @value='Edit'][1]");
public static By EditInitiave_link = By.xpath("//button[text()='Edit']");
public static By EditRelease_link = By.xpath("//span[text()='Add Release']//following::button[text()='Edit']");
public static By InitiaveName_txtbox = By.xpath("//input[@id='InitiativeName']");
public static By InitiaveDescription_txtbox = By.xpath("//*[@id='DescriptionName']");

public static By Apply_btn = By.xpath("//button[@type='submit' or @type='Submit' or @class='btn btn-primary ml-3'][text()='Apply']");

//public static By EditRelease_link = By.xpath("//button[contains(@title,'Add Release')]//following::button[@class='dropdown-item dropdownalignment dropdown-margin' and @value='Edit'][1]");
public static By ReleaseName_txtbox = By.xpath("//input[@id='ReleaseName']");
public static By ReleaseDescription_txtbox = By.xpath("//*[@id='ReleaseDescription']");


//public static By EditSprint_link = By.xpath("//button[contains(@title,'Sprint')]//following::button[@class='dropdown-item dropdownalignment dropdown-margin' and @value='Edit'][1]");
public static By EditSprint_link = By.xpath("//span[contains(text(),'Sprint')]//following::button[text()='Edit']");
public static By SprintName_txtbox = By.xpath("//input[@id='SprintName']");
public static By SprintDescription_txtbox = By.xpath("//*[@id='SprintDescription']");

public static By SprintType_drpdown = By.xpath("//span[@class='dropdown-arrow']");
public static By SprintTypeValue_drpdown = By.xpath("//div[text()='Sprint-DevelopmentSprint']");
public static By SaveBaseline_btn = By.xpath("//a[@data-original-title='Save']");
public static By RoadMapTitle_txtbox = By.xpath("//input[@id='Title' and @name='Title']");
public static By RoadMapUpdated_msg = By.xpath("//span[text()='Roadmap Updated Successfully']");
public static By BaseLine_link = By.xpath("//a[@data-original-title='Baseline']");
public static By Baseline_Alert = By.xpath("//button[text()='Proceed']");
public static By BaselineSaved_msg = By.xpath("//span[text()='Baseline Saved Successfully']");
public static By closeRoadMapMenu_btn = By.xpath("//button[@aria-label='Close']");
//public static By ReleaseStartAndEndDate_txt = By.xpath("//div[@class='pointer-auto'][contains(@title,'Release')]");
public static By ReleaseStartAndEndDate_txt = By.xpath("//a[contains(@class,'expandCollapseIcon')][contains(@data-original-title,'Release')]");
//public static By SprintStartAndEndDate = By.xpath("//div[@class='pointer-auto'][contains(@title,'Sprint')]");
public static By SprintStartAndEndDate = By.xpath("//span[contains(@data-original-title,'Sprint')][contains(@class,'setName')][contains(text(),'Sprint')]");
public static By InititaveOrReleaseOrSprintStartDate_txtbox = By.xpath("//input[@id='PlannedStartDate']");
public static By ReleaseOrSprintEndDate_txtbox = By.xpath("//input[@id='PlannedEndDate']");
public static By proceed_btn = By.xpath("//button[text()='Proceed']");
public static By Save_btn = By.xpath("//button[text()='Save']");
public static By AssetsView_btn = By.xpath("//button[text()=' Assets View ']");
public static By RoadmapSaved_successMsg = By.xpath("//span[text()='Roadmap Saved Successfully']");
public static By AddIterationRecon_link = By.xpath("//span[text()='Add Iteration Reconciliation']");
public static By IterationType_drpdown = By.xpath("//select[@name='IterationTypeUId']");
public static By DropReleaseAndSprint_box = By.xpath("//div[@id='masterOptionDiv']");
public static By AddMapping_link = By.xpath("//span[text()='Add Mapping']");
public static By ManualReconName_txtbox = By.xpath("//input[@name='name']");


public static String ReleaseOrSprintName_MyWizIntstance_txt = "//form[@id='ListmyWizardInstance']//following::li[contains(text(),'{releaseorsprintname}')]";
public static String ReleaseOrSprintName_tool_txt = "//form[@id='ListmyWizard-TFS' or @id='ListADT JIRA' or @id='ListADOP JIRA']//following::li[contains(text(),'{releaseorsprintname}')]";
public static String EntityRowProductInstance_statictxt = "//div[@row-index='{row}']/child::div[@col-id='ProductInstance'][1] ";

public static By CreateNewRodMap_link = By.xpath("//*[text()='Create New Roadmap' or text()='Create new Roadmap']");
public static By plusIcon_Img = By.xpath("//a[@id='addPopup']");
public static By AddInititave_Link = By.xpath("//a[text()='Initiative']");
public static By AddRelease_Link = By.xpath("//div[@class='dropdown-body']/child::a[text()='Release'][1]");
public static By InitiaveOrReleaseNAME_txtbox = By.xpath("//input[contains(@class,'addFirstEntityInput')]");
public static By timelinerange_range = By.xpath("//div[@class='rm-timeline-range']");
public static By MoreOptions_Img = By.xpath("//img[@data-original-title='More Options']");


public static By MoreOptionsForRelease_Img = By.xpath("//div[@class='rm-timeline-group']//following::img[@data-original-title='More Options'][1]");
public static By Edisprint_btn = By.xpath("//div[contains(@data-original-title,'Sprint')]//following::a[@data-original-title='Edit'][1]");
public static By AddSprint_Link = By.xpath("//a[@id='addPopup']//preceding::a[text()='Sprint'][1]");
public static By Add_Icon = By.xpath("//a[@data-original-title='Add']");

public static By AddIconForSprint_Icon = By.xpath("//a[@id='addPopup']//preceding::a[@data-original-title='Add'][1]");
public static By Sprint_Icon = By.xpath("//div[contains(@data-original-title,'Sprint')]");
public static By ReconSavedSuccess_Msg = By.xpath("//div[contains(text(),'Saved successfully')]");
public static By SprintArrow_icon = By.xpath("//a[@id='addPopup']//preceding::a[@class='myw-action w-100'][1]");





}
