package uiMap;

import org.openqa.selenium.By;



public class RMPUIMap {
	

public static By MyWizardHome_Img=By.xpath("//img[@title='Home']");
public static By BizDevops_Statictxt = By.xpath("//div[text()='BizDevOps - Business Aligned SI & Operations']");
public static By ProgramPlanning_Img=By.xpath("//img[@alt='Program Planning']");
public static By LivingRoadmap_Img=By.xpath("//span[text()='Living Roadmap &  Workplan, Milestones & Deliverables']");
public static By LaunchRoadMapApp_Statictxt=By.xpath("//div[text()='Roadmap Assistant']//following::a[@id='btnLaunch'][1]");
public static By LoadingPleaseWait_msg=By.xpath("//span[@id='loader']");
public static By New_link=By.xpath("//div[@title='New']");
public static By Blank_link=By.xpath("//span[@title='Blank']");
public static By RA_link=By.xpath("//h1[text()='Roadmap Assistant']");

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

public static By DropInitiative_box = By.xpath("//*[@id='rect1']/ngx-dnd-container/div");
public static By DropRelease_box = By.xpath("//div[text()='Add Initiative']/following::ngx-dnd-container[1]/div");
public static By DropSprint_box = By.xpath("//div[text()='Add Release']/following::ngx-dnd-container[1]/div");

public static By EditInitiave_btn = By.xpath("//button[contains(@title,'Add Initiative')]");
public static By EditRelease_btn = By.xpath("//button[contains(@title,'Add Release')]");
public static By EditSprint_btn = By.xpath("//button[contains(@title,'Sprint')]");


public static By EditInitiave_link = By.xpath("//button[contains(@title,'Add Initiative')]//following::button[@class='dropdown-item dropdownalignment dropdown-margin' and @value='Edit'][1]");

public static By InitiaveName_txtbox = By.xpath("//input[@id='InitiativeName']");
public static By Apply_btn = By.xpath("//button[@class='save-button']");

public static By EditRelease_link = By.xpath("//button[contains(@title,'Add Release')]//following::button[@class='dropdown-item dropdownalignment dropdown-margin' and @value='Edit'][1]");
public static By ReleaseName_txtbox = By.xpath("//input[@id='ReleaseName']");

public static By EditSprint_link = By.xpath("//button[contains(@title,'Sprint')]//following::button[@class='dropdown-item dropdownalignment dropdown-margin' and @value='Edit'][1]");
public static By SprintName_txtbox = By.xpath("//input[@id='SprintName']");
public static By SprintType_drpdown = By.xpath("//span[@class='dropdown-arrow']");
public static By SprintTypeValue_drpdown = By.xpath("//div[@title='Sprint-Developmentsprint']");
public static By SaveBaseline_btn = By.xpath("//div[@class='menuitem saveIcon' and @title='Save']");
public static By RoadMapTitle_txtbox = By.xpath("//input[@id='Title' and @name='Title']");
public static By RoadMapUpdated_msg = By.xpath("//span[text()='Roadmap Updated Successfully']");
public static By BaseLine_link = By.xpath("//div[@title='Baseline' and @class='menuitem baselineIcon']");
public static By Baseline_Alert = By.xpath("//button[text()='Ok']");
public static By BaselineSaved_msg = By.xpath("//span[text()='Baseline Saved Successfully']");
public static By closeRoadMapMenu_btn = By.xpath("//button[@aria-label='Close' and @class='close']");
public static By ReleaseStartAndEndDate_txt = By.xpath("//div[@class='pointer-auto'][contains(@title,'Release')]");
public static By SprintStartAndEndDate = By.xpath("//div[@class='pointer-auto'][contains(@title,'Sprint')]");



}
