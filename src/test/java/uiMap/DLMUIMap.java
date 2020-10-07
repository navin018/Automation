package uiMap;

import org.openqa.selenium.By;



public class DLMUIMap {
	

public static By addStageTemplate_Btn=By.xpath("//span[text()='Add Stage Template']");

public static By StageName_Txtbox=By.xpath("//input[@name='name']");

public static By Entity_Drpdown=By.xpath("//*[@id='entityUId']");
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

//




}
