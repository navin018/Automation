package repositories;

import java.util.List;
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

public class RQM_Requirement {
	
	public static void FunctionCreateRequirement(WebDriver driver,String RequirementName,String ArtifactType) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 15000);
         
        
        WebDriver frame = driver
                    .switchTo()
                    .frame(driver.findElement(By
                                .xpath("//iframe[@dojoattachpoint='iframe']")));
        wait.until(
                    ExpectedConditions.elementToBeClickable(By
                                .xpath("//label[contains(.,'Initial content:')]")))
                    .sendKeys(RequirementName);
        wait.until(
                    ExpectedConditions.elementToBeClickable(By
                          .xpath("//input[contains(@id,'com_ibm_rdm_web_project_NewArtifactForm_0_artifactTypeField')]"))).clear();
         frame.findElement(By.xpath("//input[contains(@id,'com_ibm_rdm_web_project_NewArtifactForm_0_artifactTypeField')]")).sendKeys("AP211");
         
         frame.findElement(By.xpath("//input[contains(@id,'com_ibm_rdm_web_project_NewArtifactForm_0_artifactTypeField')]")).click();
         
         frame.findElement(By.xpath("//input[contains(@id,'com_ibm_rdm_web_project_NewArtifactForm_0_artifactTypeField')]")).sendKeys(Keys.ENTER);
       
         wait.until(ExpectedConditions.visibilityOfElementLocated(By
                    .xpath(".//span[@title='1100 Plan']")));
        WebElement prevButtonnew3 = driver.findElement(By
                    .xpath(".//span[@title='1100 Plan']"));
        new Actions(frame).moveToElement(prevButtonnew3).perform();
        frame.findElement(By.xpath("//span[@title='1100 Plan']")).sendKeys(
                    Keys.ENTER);
        
        if(ArtifactType.equals("Collection")) {
            frame.findElement(By.xpath("//label[contains(@for,'com_ibm_rdm_web_project_NewArtifactForm_0_artifactFormatField')]")).sendKeys(ArtifactType);
        frame.findElement(By.xpath("//label[contains(@for,'com_ibm_rdm_web_project_NewArtifactForm_0_artifactFormatField')]")).click();
        }
        Thread.sleep(2000);
        Commonfunction.ClickonButton( frame, "OK");
         frame.switchTo().defaultContent();
  }
	
	
	
	
	
	public static void FunctionViewRequirement (WebDriver driver){
		
		WebDriverWait wait = new WebDriverWait(driver, 16000);
	
    wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath(".//span[contains(text(), 'Filter by Folder')]")));
    WebElement prevButtonnew4 = driver.findElement(By
                .xpath(".//span[contains(text(), 'Filter by Folder')]"));
    new Actions(driver).moveToElement(prevButtonnew4).click().perform();
    wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath(".//span[contains(text(), '1100 Plan')]")));
    driver.findElement(By.xpath(".//span[contains(text(), '1100 Plan')]"))
                .sendKeys(Keys.ENTER);
    try {
          Thread.sleep(5000);
    } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
    }
    driver.findElement(By.xpath("//label[contains(@for,'mainSelect_0')]")).click();
    driver.findElement(By.xpath("//a[contains(.,'Artifact 1')]")).click();
    driver.navigate().to("https://vw000490clm2.accenture.com/qm/web/console/NEW%20Lifecycle%20project16%20(Quality%20Management)#action=com.ibm.rqm.planning.home.actionDispatcher&subAction=viewUserHome");
	}
}
