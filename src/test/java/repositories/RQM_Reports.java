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

public class RQM_Reports {
	
	public static void FunctionSelectAndRunReports(WebDriver driver,String ReportName) {
		
		Class_ApplicationFunction.FunctionSelectSubMenu( driver,"Reports", "BrowseShared Reports");
		WebDriverWait wait = new WebDriverWait(driver, 15000);
		Commonfunction.WaitLow();
		List<WebElement> links = driver.findElements(By.xpath("//img[contains(@id,'_')]"));
		links.get(1).click();
		WebElement chkbox = driver
				.findElement(By
						.xpath("//a[contains(.,' Execution Status by Owner using TCER Count (Live)')]"));
		chkbox.click();

		WebElement element11 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//label[contains(.,'"+ReportName+"')]")));
		element11.click();

		element11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Run')]")));
		element11.click();
	}
}
