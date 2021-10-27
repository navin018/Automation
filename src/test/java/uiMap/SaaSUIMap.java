package uiMap;
import org.openqa.selenium.By;

public class SaaSUIMap {


public static By Clear_btn=By.xpath("//span[@title='Client(s) and/or delivery construct(s) level access allows account to get access on selected client and/or delivery construct data.']/following::button[text()='Clear'][1]");
public static String DC_Checkbox="//span[text()='{SaaS_DC_L1}' and @class='node-name']//preceding::input[@type='checkbox'][1]";
public static By DC_Statictext=By.xpath("//span[text()='{SaaS_DC_L1}']//preceding::option[text()='Please select..'][1]");
public static By Page_size=By.xpath("//span[text()='Page Size']");
public static By Page_num=By.xpath("//a[text()='100']");
public static By Dc_drpdwn=By.xpath("//select[@class='ng-pristine ng-touched ng-valid']");

public static By Yes_btn=By.xpath("//input[@id='yes']");

public static By Quasar_txt=By.xpath("//div[text()='Quasar']");


public static By Search_icon=By.xpath("//nav[@class='nav myw-nav d-flex sticky']//div[@class='myw-header-nav d-flex justify-content-end mt-n2']//div[@class='mx-3 my-auto']//a[@href='javascript:;']//img[@class='myw-icon myw-24']");
public static By Search_txtbox=By.xpath("//nav[@class='nav myw-nav d-flex sticky']//div[@class='myw-header-nav d-flex justify-content-end mt-n2']//div[@class='mx-1 my-auto ng-star-inserted']//input[@id='searchcatalog']");
public static By AddCart_btn=By.xpath("//div[@class='service-box ng-star-inserted']//div[@class='ser-footer']//div[@class='ser-button-action']//a[@class='btn sassbtn-primary btn-atc ng-star-inserted'][contains(text(),'Add To Cart')]");
public static By Cart_icon =By.xpath("//img[@class='myw-icon myw-32 blob blue']");
public static By Note_checkbox=By.xpath("//span[contains(text(),'Note: \"Expected Spend/Month is a tentative calcula')]");
public static By Confirm_btn=By.xpath("//button[text()='Confirm']");
public static By Client_checkbox=By.xpath("//span[text()='3RD FRANKLIN FINANCIAL CORP.' and @class='node-name']//preceding::input[@type='checkbox'][1]");
public static By OrderConfiramtion_txt=By.xpath("//h3[text()='Order Confirmation']");
public static By OrderNum_txt=By.xpath("//p[@class='fs-18'][contains(text(),'order id')]");
public static By Ok_btn=By.xpath("//button[text()='Ok']");
public static By Username_txt=By.xpath("//a[@id='loginDetails']");
public static By MyOrder_drpdwm=By.xpath("//p[@class='mt-4']//following::span[text()='My Orders'][1]");
public static String Bundle_txt="//td[text()='{AppBundle}']";
public static By Order_id=By.xpath("//a[contains(text(),'ORDR')]");

public static By ConfirmConfig_btn=By.xpath("//button[contains(text(),'Confirm Configuration')]");

public static String Actual_Result="//div[text()='{tilename}']";
public static By RequirementsManagement_txt=By.xpath("//div[text()='Requirements Management']");


public static By DigitalDesignThinking_txt=By.xpath("//div[text()='Digital Design Thinking']");
public static By ChangeManagerAssistant_txt=By.xpath("//div[text()='Change Manager Assistant']");
public static By IngrAIn_txt=By.xpath("//div[text()='IngrAIn']");
public static By Cygnus_txt=By.xpath("//div[text()='Cygnus']");

public static By Iunderstand_txtbox=By.xpath("//button[@id='IUnderstandAction']");
public static By Welcome_text=By.xpath("//h1[text()='Welcome to myWizard® SaaS']");
public static By Console_text=By.xpath("//span[text()='Go to Console']");
public static By Importantnotice_text=By.xpath("//h3[text()='Important Notification']");
public static By Iagree_text=By.xpath("//span[text()='I agree.']");
public static By Submit_btn_popup=By.xpath("//button[text()='Submit'][@class='btn sassbtn-primary d-flex ml-auto']");
public static By Demographics_text=By.xpath("//h3[text()='Contract Demographics']");
public static By ChargeCode_txtbox=By.xpath("//input[@placeholder='Enter valid charge code']");
public static By NoofUsers_Dropdown=By.xpath("//select[@id='noOfUsers']");
public static By ContractDuration_Dropdown=By.xpath("//select[@id='contractDuration']");
public static By Verify_text=By.xpath("//a[text()='Verify']");
public static By Success_txt=By.xpath("//*[text()='Charge Code verified successfully']");
public static By DC_Submit_btn=By.xpath("//button[text()='Submit'][@class='btn sassbtn-primary mr-3']");
public static By SuccessToaster_Msg=By.xpath("//div[@id='toast-container'][text()='Demographic details updated successfully]");
public static By DIYSI_text=By.xpath("//h5[text()='DIY SI']");
public static By SetUp_btn=By.xpath("//button[text()='Setup Yourself']");
public static By Confidentiality_text=By.xpath("//strong[text()='Confidentiality Disclaimer']");
public static By Iunderstand_popup=By.xpath("//span[text()='I Understand']");
public static By Confirm_popup=By.xpath("//button[text()='Confirm']");
public static By GetStarted_btn=By.xpath("//button[text()=' Click here to order services']");
public static By selectedRRA_checkbox=By.xpath("//li[@aria-label='Requirements Readiness Analyzer'][@aria-selected='true']");
public static By selectedRC_checkbox=By.xpath("//li[@aria-label='Requirements Coverage'][@aria-selected='true']");
public static By selectedRM_checkbox=By.xpath("//li[@aria-label='Requirements Management'][@aria-selected='true']");
public static By selectedDDT_checkbox=By.xpath("//li[@aria-label='Digital Design Thinking'][@aria-selected='true']");
public static By selectedCMA_checkbox=By.xpath("//li[@aria-label='Change Manager Assistant'][@aria-selected='true']");
public static By selectedIAI_checkbox=By.xpath("//li[@aria-label='IngrAIn'][@aria-selected='true']");
public static By selectedRDB_checkbox=By.xpath("//li[@aria-label='Requirements Dependency Builder'][@aria-selected='true']");
public static By selectedRBP_checkbox=By.xpath("//li[@aria-label='Requirements Business Prioritization'][@aria-selected='true']");
public static By selectedCygnus_checkbox=By.xpath("//li[@aria-label='Cygnus'][@aria-selected='true']");
public static By selectedIA_checkbox=By.xpath("//li[@aria-label='Impact Analyzer'][@aria-selected='true']");
public static By saveandnxt_btn=By.xpath("//button[text()='Save & Next']");
public static By Userinenableuser_text=By.xpath("//a[@id='UserData-tab']");
public static By Greentick_img=By.xpath("//img[@class='mr-2 w-60px']");
public static By Arrow_img=By.xpath("//img[@alt='Click to Proceed']");
public static By TFS_checkbox=By.xpath("//input[contains(@id,'Azure DevOps (VSTS)-Agile')]");

public static By OrderService_btn=By.xpath("//button[text()=' Click here to order services']");

public static By SaaSLandingPage_txt=By.xpath("//span[text()='myWizard® SaaS']");

public static By StorySlicing_Tile=By.xpath("//div[text()='Story Slicing (SHEQC)']");
public static By StorySlicing_checkbox=By.xpath("//li[@aria-label='Story Slicing (SHEQC)'][@aria-selected='true']");
public static By Toaster_msg=By.xpath("//div[@aria-label='You are not able to access the application either you are not Authorized or the application is not Provisioned.']");
public static By ChangeManagerAssistant_Tile=By.xpath("//div[text()='Change Manager Assistant']");


}





