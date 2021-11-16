package uiMap;

import org.openqa.selenium.By;



public class MyWizardUIMap {
	

public static By signIn_txtbox=By.xpath("//input[@type='email' and @name='loginfmt']");
public static By signInWithUserNameSaved_txtbox=By.xpath("//input[@type='email' and @name='UserName']");
public static By Next_btn=By.xpath("//input[@type='submit']");
public static String enteredUsername_txtbox = "//input[@placeholder='Enterprise ID' and @value='{username}']";
public static By Pwd_txtbox=By.xpath("//input[@type='password' and @name='passwd']");
public static By signIn_btn=By.xpath("//input[@type='submit']");

//public static By Pwd_txtbox1=By.xpath("//input[@type='password' and @name='passwd']");
//public static By signIn_btn1=By.xpath("//input[@id='idSIButton9']");

//updated by sangeetha as there was change in adop/adt login
public static By Pwd_txtbox1=By.xpath("//input[@name='Password' or @type='password' and @name='passwd']");
public static By signIn_btn1=By.xpath("//*[@id='submitButton' or @id='idSIButton9']");

//public static By Yes_btn=By.xpath("//input[@type='submit'][@id='idSIButton9']");
public static By Yes_btn=By.xpath("//input[@id='idSIButton9']");

public static By BackToDashboard_link = By.xpath("//div[text()='Back to Dashboard' or @title='Go Back']");
public static By SettingIcon_Image = By.xpath("//span[@title='Settings']");
public static By AdminSetting_statictxt= By.xpath("//div[@title='Admin Settings']");

public static By PickAnAccount_staticTxt = By.xpath("//div[text()='Pick an account']");
public static By UserAnotherAccount_link = By.xpath("//div[text()='Use another account']");
public static By ComputationProcess_icon = By.xpath("//h6[text()=' Computation Process ']");
public static By DC_Drpdwn= By.xpath("//span[@class='c-icons__text-sub']");
public static By ScopeSelectorEnterTxt_txtbox= By.xpath("//input[@placeholder='Enter minimum three characters to search...']");
public static By DCMsg_StaticTxt= By.xpath("//div[@aria-label='Please select a Delivery Construct to proceed']");
public static By ScopeSelectorArrow_Drpdown = By.xpath("//span[@class='-arrow-link js-dropdown'][@id='scopeSelector']");
public static String SelectClient_statictxt = "//span[contains(@class,'node-name')][text()='{clientname}']";
public static String SelectClient_statictxt_RMP = "//span[contains(text(),'{clientname}')]";
public static String SelectDC_statictxt = "//span[@class='node-name'][text()='{dcname}']";
public static String SelectDC_statictxt_RMP = "//div[contains(text(),'{dcname}')]";
public static String SearchResultAccountManagement_statictxt = "//div[@col-id='EmailId'] [text()='{userID}']";
public static String SelectProgram_statictxt = "//span[contains(@class,'node-name')][text()='{programname}']";
public static String SelectProject_statictxt =  "//span[contains(@class,'node-name')][text()='{project}']";
public static String SelectProgram_statictxt_RMP = "//div[contains(text(),'{programname}')]";
public static String clientInAccountManagmentScreen = "//span[text()='Client/Delivery Construct Role(s)']//following::span[@class='node-name' and text()='{clientname}']//preceding::input[1]";

public static String PickAnAccount_link = "//div[text()='{username}']";
public static String PickAnAccountnew_link = "//div[@data-test-id='{username}']";
public static String PickAnAccount1_link = "//div[contains(text(),'{username}')]";
//public static String SelectDC_statictxt = "//*[text()='{dcname}']";
////public static String SelectProgram_statictxt = "//*[text()='{programname}']";
//public static String SelectProgram_statictxt = "//*[text()='{dcname}']//following::div[text()='{programname}']";



public static By scopeSelector_drpdown = By.xpath("//*[@id='scopeSelector' or @class='scope-selector']");
public static By scopeSelector_RMP_drpdown = By.xpath("//*[@class='scope-selector-toggle -arrow-link js-dropdown' or @id='scopeSelector']");
public static By apply_btn = By.xpath("//button[contains(text(),'Apply')]");
//public static By apply_btn = By.xpath("//button[text()=' Apply ']");

public static String Tile_statictxt = "//div[@class='tile-title'][text()='{tilename}']";

public static By SelectEntity_Drpdown = By.xpath("//*[@name='AppServiceGroup']");

public static By Browse_btn = By.xpath("//input[@id='uploadFile']");
public static By waitSign_Img = By.xpath("//div[@class='sk-ball-spin-clockwise']");

public static By UploadAll_link = By.xpath("//span[text()='Upload All']");


public static By Upload_checkbox = By.xpath("//table//tbody//tr[1]//td[1]//input[@name='access-role']//following::span[1]");
public static By UploadComplete_statictxt = By.xpath("//td[text()=' Completed ']");
public static By MywizChromeNotification_btn = By.xpath("//input[@class='btn btn-primary ' and @value='Ok']");
public static By MywizChromeNotification_btn1 = By.xpath("//button[@class='btn btn-primary ml-auto'][text()='Ok']");


public static By selectmyquery = By.xpath("//span[text()='QueryToFetchIterationDetails_Automation']");
public static By QueryValue_txtbox = By.xpath("//div[@comp-id='69']");
public static By runQuery_btn = By.xpath("//span[text()='Run Query']");

public static By QueryRunSuccess_Msg = By.xpath("//div[@aria-label='The complete records have been fetched from data base. You can view /export to CSV.']");
public static By GetIterationExternalID_statictxt = By.xpath("//div[@row-id='0']/child::div[@col-id='IterationExternalId' and @role='gridcell'][1]");
public static By GetIterationExternalID_MoreThanoneRow_statictxt = By.xpath("//div[@row-id='1']/child::div[@col-id='IterationExternalId' and @role='gridcell'][1]");
public static By QueryValueInput_txtbox = By.xpath("//input[@class='ag-cell-edit-input']");
public static By Search_txtbox = By.xpath("//input[@placeholder='Enter text to search the first 500 records']");

public static By Save_btn = By.xpath("//button[@class='btn btn-primary' and text()='Save']");
public static By BacktoOverallSetup_btn = By.xpath("//div[text()='Back to Overall Setup Progress']");
public static By BacktoDIYADAutomation_btn = By.xpath("//div[text()='Back to DIY AD Automation']");
//public static By IUnderstand_checkbox = By.xpath("//label[text()='I Understand']");
//public static By Confirm_btn = By.xpath("//label[text()='I Understand']");
//public static By IUnderstand_checkbox = By.xpath("//input[@id='understand']");
//public static By Confirm_btn = By.xpath("//button[text()=' Confirm ']");

public static By Dashboard_Checkbox = By.xpath("//span[text()='I Understand']");
public static By Dashboard_Confirm_btn = By.xpath("//button[text()='Confirm']");

public static By UserID_link = By.xpath("//span[@id='userDetail']");
public static By SignOut_btn= By.xpath("//button[text()='Sign out']");
public static String LogOutfromUser_txt = "//*[text()='{username}']";
public static By SignOutSuccessful_msg= By.xpath("//div[contains(text(),'You have successfully signed out')]");
}
