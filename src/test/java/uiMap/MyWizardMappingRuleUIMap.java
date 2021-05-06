package uiMap;

import org.openqa.selenium.By;



public class MyWizardMappingRuleUIMap {
	

public static By SaveRule_btn= By.xpath("//button[@class='btn btn-primary' and text()='Save']");
public static By xpathrule_txtbox= By.xpath("//textarea[@name='xpathrule']");
public static By RuleTypeStandard_Option= By.xpath("//span[text()='Standard']");
public static By RuleTypeAdvanced_Option= By.xpath("//span[text()='Advanced']");
public static By IsUseAdvancedRuleSelected_statictxt = By.xpath("//input[@name='useadvancedrule']");
public static By UseAdvancedRule_statictxt = By.xpath("//input[@name='useadvancedrule']//following::span[contains(text(),'Use Advanced')][1]");
public static By PageSize_statictxt = By.xpath("//span[text()='Page Size']");
public static By PageSize100_statictxt = By.xpath("//a[text()='100']");
public static String Entity_statictxt = "//div[text()='{workitem}' and @col-id='Client']";
public static String EntityForDIY_statictxt = "//div[text()='{nonworkitem}' and @col-id='EntityName']";
public static String NonWorkitem_statictxt = "//div[text()='{nonworkitem}' and @col-id='EntityName']";
public static String NonWorkitemWithRow_statictxt = "//div[@row-index='{row}']/child::div[@col-id='ProductInstance'][1]";
public static By InactiveRule_toggle = By.xpath("//input[@name='RuleStatusUId']//following::span[text()='InActive'][1]");
public static By viewEdit_link = By.xpath("//span[text()='View/Edit']");

public static By SearchWorkItemNonWorkItem_txtbox = By.xpath("//input[@placeholder='Search...']");

public static String EntityRowProductInstance_statictxt = "//div[@row-index='{row}']/child::div[@col-id='ProductInstance'][1] ";
public static String EntityRowStatusUId_statictxt = "//div[@row-index='{row}']//child::div[@col-id='RowStatusUId']//child::*[name()='svg' and @class='phx-msg-tblRow phx-icon-svg phx-green-tick']";
//div[text()='{row}' and @col-id='Client']//preceding::div[@col-id='ProductInstance'][1]
public static String NonWorkItemRowProductInstance_statictxt = "//div[@row-index='{row}']/child::div[@col-id='ProductInstance'][1] ";
//div[text()='{nonworkitem}' and @col-id='EntityName']//preceding::div[@col-id='ProductInstance']
public static String EntityRowEntityName_statictxt = "//div[text()='{row}' and @col-id='Client']//preceding::div[@col-id='EntityName'][1]";
public static By RuleSavedSuccesfully_statictxt = By.xpath("//div[contains(text(),'Saved successfully')]");


public static String findParentNode_dynamicTxt = "(//div[@ref='eBodyContainer']//following::div[text()='{workitems_nonworkitems}'])[{int}]";



public static By AddRule_link = By.xpath("//span[text()='Add Rule']");
public static By RuleNameWileAddingNewRule_txtbox = By.xpath("//input[@name='ruleNames']");
public static By ProductInstance_Dropdwn = By.xpath("//*[@name='ProductInstanceUId']");
public static By DataEntity_Dropdwn = By.xpath("//select[@name='entitylistcontrol']");
public static By WorkItemType_Dropdwn = By.xpath("//select[@name='workitemtype']");
//public static By SelectEntity_Drpdown = By.xpath("//*[@name='AppServiceGroup']");
//
//public static By Browse_btn = By.xpath("//input[@id='uploadFile']");
//public static By waitSign_Img = By.xpath("//div[@class='sk-ball-spin-clockwise']");
//
//public static By UploadAll_link = By.xpath("//span[text()='Upload All']");
//
//
//public static By Upload_checkbox = By.xpath("//table//tbody//tr[1]//td[1]//input[@name='access-role']//following::span[1]");
//public static By UploadComplete_statictxt = By.xpath("//td[text()=' Completed ']");

}
