package uiMap;

import org.openqa.selenium.By;

public class TeamConfigUIMap {

	public static By teamConfig_tile = By.xpath("//div[text()='Team Configuration']");
	public static By addTeam_button = By.xpath("//span[text()='Add Team']");
	public static By teamName_txtBox = By.name("name");
	public static By metricsreporting_chckBox = By.xpath("//input[contains(@name,'metrixreporting')]"); //Metric reporting checkbox
	public static By save_button = By.xpath("//button[text()='Save' and contains(@class,'btn-primary')]");
	public static By resourceSearch_txtBox = By.xpath("//input[@placeholder='Search...']");
	public static By selectResource_dropdown = By.xpath("//select[@id='selectedResourcesList']");
	public static By addResource_button = By.xpath("//div[@class='col-2 text-center']//button[text()='>>']");
	public static By RemoveResource_button = By.xpath("//div[@class='col-2 text-center']//button[text()='<<']");
	public static By searchBox_txtBox = By.xpath("//input[contains(@placeholder,'Enter text to search')]");
	public static By search_button = By.xpath("//button[@title='Search All']"); //Magnifying glass on the right of Search textbox
	public static By edit_link = By.xpath("//span[text()='View/Edit']");
	//public static String selectTeam_staticTxt = "//span[@title='{TeamName}']"; //To click on the first Team in the table
	public static String selectTeam_staticTxt = "//table[@class='ui-treetable-table']//tbody//tr[1]//td[@class='phx-col-prod-name text-left']//child::span[text()='{teamname}']";
	public static By deleteTeam_button = By.xpath("a[@title='Delete Team']");
	public static By description_txtBox = By.name("description");
	public static By saveSuccessful_staticTxt = By.xpath("//div[contains(text(),'Team saved successfully')]");
	public static By resourceAdded_staticTxt = By.xpath("//div[contains(text(),'Resource added successfully')]");
	public static By deleteTeamSuccess_staticTxt = By.xpath("//div[contains(text(),'Team deleted successfully')]");
	public static By delete_button = By.xpath("//table[@class='ui-treetable-table']//tbody//tr[1]//td[6]//a[@title='Delete Team']");
	public static By confirmDelete_button = By.xpath("//div[@class='modal-footer']//button[text()='Yes']");
	
	//DC association
	public static String TeamConfigPage_Section  = "//span[text()='Client/Delivery Construct Association(s)']";
	public static String DCClientToSelect_StaticTxt  = "//table[@class='ui-treetable-table']//tbody//following::td[@class='phx-col-ds text-left']//following::span[text()='{clientname}']";
	public static String PlusIconToExpandClientSelected_StaticTxt  = "//table[@class='ui-treetable-table']//tbody//following::td[@class='phx-col-ds text-left']//following::span[text()='{clientname}']/preceding::i[@class='pi pi-fw pi-chevron-right'][1]";
//	public static String checkL1DCcheckbox_checkbox = "//table[@class='ui-treetable-table']//tbody//following::td[@class='phx-col-ds text-left']//following::span[text()='{clientname}']//following::input[1]";
	public static String checkL1DCcheckbox_checkbox = "//span[text()='{DCname}']//preceding::input[@type='checkbox'][1]";
	public static String checkL2DCcheckbox_checkbox = "	//span[text()='{programname}']//preceding::input[@type='checkbox'][1]";
	public static String PlusIconToExpandDCL1_StaticTxt  = "//span[text()='{DCname}']//preceding::i[@class='pi pi-fw pi-chevron-right'][1]";

	public static By TeamUID_statictxt = By.xpath("//input[@name='teamUId']");
	public static String Teamname_statictxt  = "//span[text()='{teamname}']";
	public static String AssociatedResourceList_statictxt  = "//*[text()='Associated Resources']//following::*[text()='{resourceID}'][1]";
	public static String ResourceList_statictxt  = "//*[text()='Resource List']//following::*[text()='{resourceID}'][1]";
	
}
