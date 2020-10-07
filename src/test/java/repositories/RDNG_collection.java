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

public class RDNG_collection {
	public static void FunctionCreateCollection(WebDriver driver,
			String ProjectAreaName, String varCollectionName,
			String varDescriptionName, String varLinkingArtifactName,
			String varArtifactname) {

		WebDriverWait wait = new WebDriverWait(driver, 12000);

		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.linkText(ProjectAreaName))).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Commonfunction.FunctionSelectandClick(driver, "Collections");
		WebDriverWait wait1 = new WebDriverWait(driver, 1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'Create Collection')]")));
		WebElement prevButtonnew1 = driver.findElement(By
				.xpath(".//span[contains(text(), 'Create Collection')]"));
		new Actions(driver).moveToElement(prevButtonnew1).click().perform();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//label[contains(.,'Name')]")));
		wait1.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//label[contains(.,'Name')]"))).sendKeys(
				varCollectionName);
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By
			//	.xpath("//button[contains(.,'Browse')]")));
		//WebElement prevButtonnew2 = driver.findElement(By
				//.xpath("//button[contains(.,'Browse')]"));
		//new Actions(driver).moveToElement(prevButtonnew2).click().perform();
		Commonfunction.ClickonButton(driver, "Browse");
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By
				//.xpath(".//span[contains(text(), '1100 Plan')]")));
		WebElement prevButtonnew3 = driver.findElement(By
				.xpath(".//span[contains(text(), '1100 Plan')]"));
		new Actions(driver).moveToElement(prevButtonnew3).perform();
		//Commonfunction.ClickonSpan(driver,"1100 Plan");
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), '1100 Plan')]")));
		driver.findElement(By.xpath(".//span[contains(text(), '1100 Plan')]"))
				.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[@dojoattachevent='click:_onOk']"))
				.click();
		wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//textarea[contains(@id,'description')]")))
				.sendKeys(varDescriptionName);
		wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//div[@title='Add artifact']"))).click();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath(".//span[contains(text(), '1100 Plan')]")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//prevButtonnew3 = driver.findElement(By
			//	.xpath(".//span[contains(text(), '1100 Plan')]"));
		//new Actions(driver).moveToElement(prevButtonnew3).click().perform();
		Commonfunction.ClickonSpan(driver,"1100 Plan");
		List<WebElement> we = driver.findElements(By
				.xpath("//input[@class='filterText helpMessage']"));
		we.get(1).click();

		WebElement prevButtonnew2 = driver.findElement(By
				.xpath("//input[@class='filterText']"));
		prevButtonnew2.sendKeys(varLinkingArtifactName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[contains(@class,'entry-label')]"))
				.click();
		//driver.findElement(By.xpath("//button[contains(.,'Add & Close')]"))
				//.click();
		Commonfunction.ClickonButton(driver, "Add & Close");
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By
			//	.xpath("//button[contains(.,'Done')]")));
		//prevButtonnew2 = driver.findElement(By
				//.xpath("//button[contains(.,'Done')]"));
		//new Actions(driver).moveToElement(prevButtonnew2).click().perform();
		Commonfunction.ClickonButton(driver, "Done");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(
				By.xpath("//div[@class='dijitReset dijitArrowButtonInner']"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//td[contains(text(), 'AP211 Use Case')]")));
		WebElement prevButtonnew10 = driver.findElement(By
				.xpath("//td[contains(text(), 'AP211 Use Case')]"));
		new Actions(driver).moveToElement(prevButtonnew10).click().perform();
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//label[contains(.,'Initial content:')]")))
				.sendKeys(varArtifactname);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By
			//	.xpath("//button[contains(.,'Browse')]")));
		//WebElement prevButtonnew20 = driver.findElement(By
				//.xpath("//button[contains(.,'Browse')]"));
		//new Actions(driver).moveToElement(prevButtonnew20).click().perform();
		Commonfunction.ClickonButton(driver, "Browse");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[@title='1100 Plan']")));
		WebElement prevButtonnew30 = driver.findElement(By
				.xpath(".//span[@title='1100 Plan']"));
		new Actions(driver).moveToElement(prevButtonnew30).perform();
		driver.findElement(By.xpath("//span[@title='1100 Plan']")).sendKeys(
				Keys.ENTER);
		//driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
		Commonfunction.ClickonButton(driver, "OK");

	}

}
