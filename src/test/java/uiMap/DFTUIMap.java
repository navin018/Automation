package uiMap;

import org.openqa.selenium.By;



public class DFTUIMap {
	

public static By Filter_Icon=By.xpath("//a[@title='Filter']");
public static By processed_checkbox=By.xpath("//span[text()='Processed']");
public static By EndDate_txtbox=By.xpath("//*[text()='End Date']//following::input[@placeholder='DD/MM/YYYY']");
public static By StartDate_txtbox=By.xpath("//*[text()='Start Date']//following::input[@placeholder='DD/MM/YYYY']");
public static By Apply_btn=By.xpath("//a[text()='Apply']");
public static By Searchbox_txtbox=By.xpath("//input[@placeholder='Enter text to search the first 500 records']");
public static String SearchResultForGivenCorrelationUID_txt="//span[text()='{CorrelationUId}']";
public static By ActionWorkitem_icon=By.xpath("//a[@title='Action']");
public static By SearchAll_Icon=By.xpath("//button[@title='Search All']");

public static By DFTIcons_icons=By.xpath("//*[@r='7.5']");
public static By Jira_icon=By.xpath("//span[text()='JIRA']");
public static By myWizardGatewayManager_icon=By.xpath("//*[text()='myWizard-GatewayManager']");
public static By myWizardENS1_icon=By.xpath("//*[@class='node']//following::*[text()='myWizard-ENS'][1]");
public static By myWizardENS2_icon=By.xpath("//*[@class='node']//following::*[text()='myWizard-ENS'][2]");
public static By myWizard_icon=By.xpath("//*[@class='node']//following::*[text()='myWizard'][1]");
public static By myWizardRequirementsManagement_icon=By.xpath("//span[text()='myWizard.RequirementsManagement']");
public static By closeDFTdetailedWindow_btn=By.xpath("//h6//following::button[@aria-label='Close']");
}
