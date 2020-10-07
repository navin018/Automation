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

import java.util.List;

public class RDNG_ImportADTTemplate {
	public static void FunctionImportADTTemplate(WebDriver driver,
			String RQMPAName) {

		WebDriverWait wait = new WebDriverWait(driver, 150000);

		Commonfunction.ClickonLinks(driver, "Manage All Projects");
		
		//driver.findElement(
				//By.xpath("//span[contains(.,'Create Project Area')]")).click();
		Commonfunction.ClickonLinks1(driver,"Create Project Area");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//input[@aria-label='Project Area Name']")));
		element.sendKeys(RQMPAName);
		//element = wait.until(ExpectedConditions.elementToBeClickable(By
			//	.xpath("//button[contains(.,'Save')]")));
		//element.click();
		Commonfunction.ClickonButton(driver,"Save");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		FunctionCreateTeamArea(driver, "TeamArea1", "anubha.a.jain", RQMPAName);

		try {
			Thread.sleep(10000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[contains(.,'Explore Project')]"))
				.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(
				By.xpath("//span[contains(@class,'sprite-image admin-menu')]"))
				.click();

		// new Actions(driver).moveToElement(element1).clickAndHold().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();

		}
		//WebElement element1 = driver.findElement(By
			//	.xpath("//span[contains(.,'Manage Project Properties')]"));
		//new Actions(driver).moveToElement(element1).click().perform();
		Commonfunction.ClickonLinks1(driver,"Manage Project Properties");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();

		}
		//driver.findElement(By.xpath("//span[contains(.,'Templates')]")).click();
		Commonfunction.ClickonLinks1(driver, "Templates");

		//List<WebElement> we1 = driver.findElements(By
			//	.xpath("//span[contains(text(),'Upload Template...')]"));
		//System.out.println(we1.size());
		//we1.get(2).click();
		Commonfunction.ClickonSpan(driver,"Upload Template...");

		driver.findElement(By.xpath("//input[@name='upload']")).click();
		Commonfunction.FunctionFileUpload(" C:\\Users\\darshana.rathi\\Downloads\\ADT RRC Template\\ADT FY13Q3.archive");
		
		//List<WebElement> we2 = driver.findElements(By
			//	.xpath("//button[contains(.,'Upload')]"));
		//System.out.println(we2.size());
		//we2.get(0).click();
		Commonfunction.ClickonButton(driver,"Upload");
		
		// driver.findElement(By.xpath("//button[@dojoattachpoint='_okButtonNode']")).click();
		// driver.findElement(By.xpath("//button[contains(.,'Upload')]")).click();
	}
	public static void FunctionCreateTeamArea(WebDriver driver,
			String TeamAreaName, String member, String RQMPAName) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);
		//WebElement element = wait
			//	.until(ExpectedConditions.elementToBeClickable(By
				//		.xpath("//img[@alt='Create Team...']")));
		//element.click();
		Commonfunction.ClickonImage(driver,"Create Team");

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//input[@dojoattachpoint='name']")));

		element.sendKeys(TeamAreaName);
		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement ele : links) {

			driver.findElement(By.linkText("Add...")).click();
		}
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//input[@class='searchText']")));
		element.sendKeys(member);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//option[contains(.,'" + member + "')]")));
		element.click();
		//element = wait.until(ExpectedConditions.elementToBeClickable(By
				//.xpath("//button[contains(.,'Add and Close')]")));
		//element.click();
		Commonfunction.ClickonButton(driver,"Add and Close");
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//button[@dojoattachpoint='saveButton']")));
		element.click();
		boolean e;
		if (e = driver.findElement(By.xpath("//div[@class='content']"))
				.isDisplayed()) {

			element = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath("//button[@dojoattachpoint='cancelButton']")));
			element.click();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.linkText(RQMPAName))
				.click();
		
	}

}
