package uiMap;

import org.openqa.selenium.By;



public class GenericUploaderUIMap {
	

public static By ProductInstance_drpdown=By.xpath("//select[@name='ProductInstanceUId']");
public static By DataEntity_drpdown=By.xpath("//select[@name='entity']");
public static By DataMappingTemplate_drpdown=By.xpath("//*[@class='multiselect-dropdown']");
public static By DataMappingTemplateOption_drpdown=By.xpath("//*[@class='multiselect-item-checkbox ng-star-inserted']/child::div[contains(text(),'Standard Template')][1]");
public static By Upload_Img=By.xpath("//*[@title='Upload File']");
public static By Upload_btn=By.xpath("//button[text()='Upload']");
public static By Refresh_btn=By.xpath("//img[@title='Refresh']");
public static By StatusOfRecordUploaded_statictxt = By.xpath("//table[@class='ui-treetable-table']/tbody/tr[1]/td[3]/div/div/span/span[1]");
public static By SelectFile_btn=By.xpath("//span[text()=' Select File ']");
public static By Searchbox_txtbox=By.xpath("//input[@placeholder='Enter text to search the first 500 records']");
public static String SearchResultForGivenCorrelationUID_txt="//span[text()='{CorrelationUId}']";

}
