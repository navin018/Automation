package uiMap;

import org.openqa.selenium.By;



public class GenericUploaderUIMap {
	

public static By ProductInstance_drpdown=By.xpath("//select[@name='ProductInstanceUId']");
public static By DataEntity_drpdown=By.xpath("//select[@name='entity']");
public static By DataMappingTemplate_drpdown=By.xpath("//*[@class='multiselect-dropdown']");
public static By DataMappingCustomTemplateOption_drpdown=By.xpath("//*[@class='multiselect-item-checkbox ng-star-inserted']/child::div[contains(text(),'Custom Template')][1]");
public static By DataMappingTemplateOption_drpdown=By.xpath("//*[@class='multiselect-item-checkbox ng-star-inserted']/child::div[contains(text(),'Standard Template')][1]");
public static By Upload_Img=By.xpath("//*[@title='Upload File']");
public static By Upload_btn=By.xpath("//button[text()='Upload']");
public static By Refresh_btn=By.xpath("//img[@title='Refresh']");
//public static By StatusOfRecordUploaded_statictxt = By.xpath("//table[@class='ui-treetable-table']/tbody/tr[1]/td[3]/div/div/span/span[1]");
public static By SelectFile_btn=By.xpath("//span[text()=' Select File ']");
public static By Searchbox_txtbox=By.xpath("//input[@placeholder='Enter text to search the first 500 records']");
public static String SearchResultForGivenCorrelationUID_txt="//span[text()='{CorrelationUId}']";


public static By Failed_txt=By.xpath("//tr[@class='ng-star-inserted ui-state-highlight']//td[@class='w-40']//div//div[@class='gu-status-align']//span[@class='ng-star-inserted']//span[@class='text-danger'][contains(text(),'Failed')]");
public static By PartiallyComplete_txt=By.xpath("//span[text()=' Partially Complete']");
public static By FailedTemplate_download=By.xpath("//img[@src='/core/images/download.png']");

//edit and upload
public static By Edit_icon=By.xpath("//img[@id='EditimgID']");
public static By Clone_btn=By.xpath("//button[@id='SaveMappingClone']");
public static By TemplateName_txt=By.xpath("//input[@id='CustomDataMapName']");
public static By Search_txtbox=By.xpath("//body/app-root[@ng-version='8.2.11']/container/div[@class='site-wrap phx-theme-myWizard ng-star-inserted']/div[@class='c-container']/div[@class='phx-content']/app-show-mapping[@class='ng-star-inserted']/form[@class='ng-untouched ng-valid ng-dirty']/div[@class='phx-pane phx-account-management']/div[@class='phx-pane-container']/div[@class='phx-pane-content h-100']/div[@class='phx-manage-ds-list my-3 phx-ui-treetable']/p-treetable[@class='phx-primeTreeTable-mod2']/div[@class='table ui-treetable ui-widget ui-treetable-hoverable-rows ui-treetable-resizable ui-treetable-resizable-fit']/div[@class='ui-treetable-wrapper ng-star-inserted']/table[@class='ui-treetable-table']/thead[@class='ui-treetable-thead']/tr[@class='ng-star-inserted']/th[2]/input[1]");
public static By NewFeild_txtbox=By.xpath("//td[@class='w-40']//div//input[@type='text']");
public static By SaveAS_btn=By.xpath("//button[@id='SaveAsMapping']");
public static By SavedSuccessfully_msg=By.xpath("//div[@id='toast-container']");
public static By GoBack_btn=By.xpath("//div[@title='Go Back']");
public static By StatusOfRecordUploaded_statictxt = By.xpath("//table/tbody/tr[1]/td[3]/div/div/span/span[1]");





}
