package uiMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class MSPSUIMap {
	

public static By Workingonit_text=By.xpath("//span[text()='Working on it...']");	
public static By Processing_toastermsg=By.xpath("//div[text()='Processing...']");
	
	
//creation of Project
public static By Search_Icon=By.xpath("//input[@value='Search this site']");
public static By Project_ribbon=By.xpath("//span[text()='Browse']//following::span[2]");
public static By NewProject_icon=By.xpath("//span[text()='New']");
public static By EnterpriseProject_option=By.xpath("//span[text()='Enterprise Project']");
public static By ProjectName_txtbox=By.xpath("//input[@title='Project Name']");
public static By Iframe=By.xpath("//iframe[@class='  pwa-animate-in']");
public static By Description_txtbox=By.xpath("//h3[text()='Description']//following::textarea[1]");
public static By Calender_Img=By.xpath("//img[@alt='Select a date from the calendar.']");
public static By Finish_btn=By.xpath("//a[text()='finish']");
public static By HoldOncreating_msg=By.xpath("//span[text()='Hold on, creating the project...']");
public static By Addtasks_text=By.xpath("//div[text()='Add tasks with dates to the timeline']");

//Enable ACNP
public static By ProjectDetails_option=By.xpath("//span[text()='Project Details']");
public static By BasicInfo_text=By.xpath("//span[text()='Basic Info']");
public static By ACNPSelect_dropdown=By.xpath("//select[@title='ACNP Is myWizard Project?']");

//schedule
public static By Schedule_option=By.xpath("//span[text()='Schedule']");

//Entity Creation

public static By DragandDrop_line=By.xpath("//div[contains(@id,'ProjectDrillDownJSGridControl_leftpane')]/following::div[1]");
public static String TaskName_textbox="//a[text()='Task Name']//following::tr[{row}]/td[5]";
public static By TaskNameinput_textbox=By.xpath("//input[contains(@id,'jsgrid_editboxct')]");
public static String WorkType_Selection="//a[text()='ACNT MyWizard Entity/Work Type']//following::tr[{row}]/td[6]";
public static String ACNTYes_dropdown="//a[text()='ACNT MyWizard Contractual']//following::tr[{row}]/td[7]";
public static By Worktypeselection_img=By.xpath("//input[contains(@id,'ProjectDrillDownJSGridControl_focusElement')]//following::img[1]");
public static By Srh_WorkType=By.xpath("//input[@aria-label='Type to search or tab again to choose an item']");
public static By SmallIndent_Img=By.xpath("//a[@id='Ribbon.ContextualTabs.ProjectDrilldown.Tasks.Editing.Indent-Small']");
public static By Criticalopt_formilestone=By.xpath("//span[text()='Critical']");
public static By dropdown_option=By.xpath("//div[contains(@id,'jsgrid_comboboxc')]//following::input[@title='Dropdown']");

public static String Search_result ="//div[@class='search-results']//span[text()='{MSPS_Entities}']";

//Save,Baseline,Publish and close
public static By Save_btn=By.xpath("//span[text()='Save']");
public static By Savecomplete_toastermsg=By.xpath("//div[text()='Save completed successfully.']");
public static By Publish_img=By.xpath("//span[text()='Publish']");
public static By Close_img=By.xpath("//span[text()='Close']");
public static By PublishCompleted_toastermsg=By.xpath("//div[text()='Publish completed successfully']");
public static By SetBaseline_img=By.xpath("//a[@id='Ribbon.ContextualTabs.ProjectDrilldown.Tasks.Editing.SetOrClearBaseline-Large']");
public static By setbaseline_option=By.xpath("//span[text()='Set Baseline']");
public static By Baseline_option=By.xpath("//span[text()='Set Baseline']//following::span[@class='ms-cui-glass-ff'][1]");
public static By SuccessBaseline_toastermsg=By.xpath("//div[text()='Baseline set successfully.']");
public static By Close_dialogbox=By.xpath("//h1[contains(@title,'Close')]");
public static By CheckIn_Radio=By.xpath("//input[@id='idCheckinRadio']");
public static By OKbtn_dialogbox=By.xpath("//input[@value='OK']");
public static By Checkin_toastermsg=By.xpath("//div[text()='Checking in...']");

//Rule
public static By DeliveryPlan_text=By.xpath("//div[text()='DeliveryPlan'][@col-id='Name']");
public static By Rule_area=By.xpath("//textarea[@name='xpathrule']");



public static By YesOrNo_txtbox=By.xpath("//input[@type='text'][@class='cb-textbox ']");



}
