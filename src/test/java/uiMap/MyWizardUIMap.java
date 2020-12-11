package uiMap;

import org.openqa.selenium.By;



public class MyWizardUIMap {
	

public static By signIn_txtbox=By.xpath("//input[@type='email' and @name='loginfmt']");
public static By signInWithUserNameSaved_txtbox=By.xpath("//input[@type='email' and @name='UserName']");
public static By Next_btn=By.xpath("//input[@type='submit']");
public static String enteredUsername_txtbox = "//input[@placeholder='Enterprise ID' and @value='{username}']";
public static By Pwd_txtbox=By.xpath("//input[@type='password' and @name='passwd']");
public static By signIn_btn=By.xpath("//input[@type='submit']");

public static By Pwd_txtbox1=By.xpath("//input[@type='password' and @name='Password']");
public static By signIn_btn1=By.xpath("//span[@id='submitButton']");
public static By Yes_btn=By.xpath("//input[@type='submit'][@class='button ext-button primary ext-primary']");


public static By SettingIcon_Image = By.xpath("//span[@title='Settings']");
public static By AdminSetting_statictxt= By.xpath("//div[@title='Admin Settings']");

public static By PickAnAccount_staticTxt = By.xpath("//div[text()='Pick an account']");
public static By UserAnotherAccount_link = By.xpath("//div[text()='Use another account']");

public static By DC_Drpdwn= By.xpath("//span[@class='c-icons__text-sub']");
public static By ScopeSelectorEnterTxt_txtbox= By.xpath("//input[@placeholder='Enter minimum three characters to search...']");
public static By DCMsg_StaticTxt= By.xpath("//div[@aria-label='Please select a Delivery Construct to proceed']");
public static By ScopeSelectorArrow_Drpdown = By.xpath("//span[@class='-arrow-link js-dropdown'][@id='scopeSelector']");
public static String SelectClient_statictxt = "//span[@class='node-name'][text()='{clientname}']";
public static String SelectDC_statictxt = "//span[@class='node-name'][text()='{dcname}']";
public static String SelectProgram_statictxt = "//span[@class='node-name'][text()='{programname}']";

public static String PickAnAccount_link = "//div[text()='{username}']";
public static String PickAnAccountnew_link = "//div[@data-test-id='{username}']";
public static String PickAnAccount1_link = "//div[contains(text(),'{username}')]";
//public static String SelectDC_statictxt = "//*[text()='{dcname}']";
////public static String SelectProgram_statictxt = "//*[text()='{programname}']";
//public static String SelectProgram_statictxt = "//*[text()='{dcname}']//following::div[text()='{programname}']";



public static By scopeSelector_drpdown = By.xpath("//*[@id='scopeSelector']");
public static By apply_btn = By.xpath("//button[text()='Apply']");
//public static By apply_btn = By.xpath("//button[text()=' Apply ']");

public static String Tile_statictxt = "//div[@class='tile-title'][text()='{tilename}']";

public static By SelectEntity_Drpdown = By.xpath("//*[@name='AppServiceGroup']");

public static By Browse_btn = By.xpath("//input[@id='uploadFile']");
public static By waitSign_Img = By.xpath("//div[@class='sk-ball-spin-clockwise']");

public static By UploadAll_link = By.xpath("//span[text()='Upload All']");


public static By Upload_checkbox = By.xpath("//table//tbody//tr[1]//td[1]//input[@name='access-role']//following::span[1]");
public static By UploadComplete_statictxt = By.xpath("//td[text()=' Completed ']");

}
