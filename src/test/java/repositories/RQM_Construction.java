package repositories;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utilities.reporting.LogUtil.logger;

public class RQM_Construction {
	//Browse Test Cases
	public static void FunctionBrowseTestCases(WebDriver driver){
	Class_ApplicationFunction.FunctionSelectSubMenu(driver, "Construction", "BrowseTest Cases");
    
     try {
                                    Thread.sleep(10000);
                    } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }
    
                    driver.findElement(By.xpath("//a[contains(.,'471')]")).click();
                    try {
                                    Thread.sleep(15000);
                    } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }}
//Browse Test Scripts
	public static void FunctionBrowseTestScripts(WebDriver driver){
	Class_ApplicationFunction.FunctionSelectSubMenu(driver, "Construction", "BrowseTest Scripts");

                    
driver.findElement(By.xpath("//a[@href='#action=com.ibm.rqm.planning.home.actionDispatcher&subAction=viewTestScript&id=10']")).click();
try {
                                    Thread.sleep(10000);
                    } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }}
//Browse Test Suites
	public static void FunctionBrowseTestSuites(WebDriver driver){
		Class_ApplicationFunction.FunctionSelectSubMenu(driver, "Construction", "BrowseTest Suites");}
//Browse Test Data
                                    
	public static void FunctionBrowseTestData(WebDriver driver){ 
	Class_ApplicationFunction.FunctionSelectSubMenu(driver, "Construction", "BrowseTest Data");
                    
                    
                    
                    driver.findElement(By.xpath("//input[contains(@aria-label,'TestData')]")).click();
                    driver.findElement(By.xpath("//div[contains(@title,'TestData')]")).click();
try {
                                    Thread.sleep(10000);
                    } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }
	}
//Browse Test Keyword
	public static void FunctionBrowseTestKeyword(WebDriver driver){              
	Class_ApplicationFunction. FunctionSelectSubMenu(driver, "Construction", "BrowseKeywords");
                    
                    
                    
                    driver.findElement(By.xpath("//input[@aria-label='Keyword_1']")).click();
                    try {
                                    Thread.sleep(5000);
                    } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }
                    
                    driver.findElement(By.xpath("//div[@title='2']")).click();
                    


}

}
