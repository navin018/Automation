package repositories;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utilities.reporting.LogUtil.logger;

public class RQM_Planning {

	static Commonfunction ObjCommonfn = new Commonfunction();
	static WebElement element;

	// Creating New Test Case in a Test Plan
	public static void AddTestCase(WebDriver driver, String TestCaseName) {

		WebDriverWait wait = new WebDriverWait(driver, 1150000);

		Commonfunction.ClickonLinks(driver, "Test Cases");
		Commonfunction.ClickonImage(driver, "Create Test Case");
		Commonfunction.SetName(driver, "Testcase");
		Commonfunction.SetDescription(driver, "Testcase");
		Commonfunction.WaitLow();
		Commonfunction.ClickonButton(driver, "OK");

		Commonfunction.ClickonButton(driver, "Save");
		Commonfunction.WaitLow();
	}

	public static void AddTestScript(WebDriver driver, String TestCaseName) {

		WebDriverWait wait = new WebDriverWait(driver, 1150000);

		Commonfunction.ClickonLinks(driver, "Test Scripts");
		Commonfunction.ClickonImage(driver, "Create Test Script");
		Commonfunction.SetName(driver, "Testcase");
		Commonfunction.SetDescription(driver, "Testcase");
		Commonfunction.WaitLow();
		Commonfunction.ClickonButton(driver, "OK");

		Commonfunction.ClickonButton(driver, "Save");
		Commonfunction.WaitLow();
	}

	public static void AddTestSuite(WebDriver driver, String TestSuiteName) {

		WebDriverWait wait = new WebDriverWait(driver, 1150000);
		Commonfunction.ClickonLinks(driver, "Test Suites");
		Commonfunction.ClickonImage(driver, "Create Test Suite");
		Commonfunction.SetName(driver, "Testcase");
		Commonfunction.SetDescription(driver, "Testcase");
		Commonfunction.WaitLow();
		Commonfunction.ClickonButton(driver, "OK");

		Commonfunction.ClickonButton(driver, "Save");
	}

	public static void FunctionAddExistingTestItems(WebDriver driver,
			String TestCasesId, String ItemName) {
		WebDriverWait wait = new WebDriverWait(driver, 15000);
		Commonfunction.ClickonLinks(driver, "Test " + ItemName);
		Commonfunction.ClickonImage(driver, "Add Test " + ItemName);
		List<WebElement> Id = driver.findElements(By
				.xpath("//input[contains(@name,'id')]"));
		System.out.println("Enter test case no. " + Id.size());
		Id.get(Id.size() - 1).click();
		Id.get(Id.size() - 1).clear();
		Id.get(Id.size() - 1).sendKeys(TestCasesId);

		Commonfunction.ClickonButton(driver, "Run");
		Commonfunction.SelectCheckBox(driver);
		driver.findElement(By.xpath("//button[contains(.,'Add and Close')]"))
				.click();

		Commonfunction.ClickonButton(driver, "Save");

	}

	// Adding formal review for a Test Plan
	public static void FunctionAddFormalReview(WebDriver driver, String approver) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);
		Commonfunction.ClickonLinks(driver, "Formal Review");

		List<WebElement> listelement = driver.findElements(By
				.xpath("//span[@title='Approval']"));
		listelement.get(listelement.size() - 1).click();

		listelement = driver.findElements(By
				.xpath("//input[@aria-disabled='false']"));
		listelement.get(listelement.size() - 1).sendKeys("Approval creation");

		listelement = driver.findElements(By
				.xpath("//span[contains(.,' Add approver')]"));
		listelement.get(listelement.size() - 1).click();

		listelement = driver.findElements(By
				.xpath("//input[@class='searchText']"));
		listelement.get(listelement.size() - 1).sendKeys(approver);

		ObjCommonfn.SelectOptionValue(driver, approver + " -");

		Commonfunction.ClickonButton(driver, "Add and Close");

		Commonfunction.ClickonButton(driver, "Save");

	}

	// Linking Requirement Collection to a Test Plan
	public static void FunctionLinkRequirementCollection(WebDriver driver,
			String LinkName, String LinkItem, String PlanName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 150000);
		Commonfunction.ClickonPartialLinks(driver, LinkName);
		Commonfunction.ClickonImage(driver, "Add new links");
		Thread.sleep(2000);
		WebDriver OldDriver = driver;
		WebDriver frame = driver.switchTo().frame(
				driver.findElement(By
						.xpath("//iframe[@dojoattachpoint='iframe']")));
		Commonfunction.WaitLow();

		new Actions(frame)
				.moveToElement(
						frame.findElement(By
								.xpath("//span[contains(@title,'1100 Plan')]")))
				.click().perform();

		element = frame.findElement(By
				.xpath("//input[@aria-label='Search text']"));
		element.sendKeys(LinkItem);
		Commonfunction.WaitLow();
		frame.findElement(By.xpath("//span[contains(@class,'entry-label')]"))
				.click();
		Commonfunction.ClickonButton(frame, "OK");

		frame.switchTo().defaultContent();
		Commonfunction.ClickonButton(driver, "Save");

	}

	// Linking Development Plan to a Test Plan
	public static void FunctionDevelopmentPlanLinks(WebDriver driver,
			String MainLink, String SubLink, String Value, String PlanName) {

		WebDriverWait wait = new WebDriverWait(driver, 150000);
		Commonfunction.ClickonLinks(driver, MainLink);
		Commonfunction.ClickonImage(driver, SubLink);

		WebDriver frame = driver
				.switchTo()
				.frame(driver.findElement(By
						.xpath("//iframe[contains(@dojoattachpoint,'iframe')]")));

		WebElement f = frame.findElement(By
				.xpath("//input[contains(@class,'QueryInput')]"));
		f.sendKeys(Value);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// driver.findElement(By.xpath("//span[contains(.,'"+Value+"')]"));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//span[contains(.,'" + Value + "')]")));
		element.click();

		// frame.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		Commonfunction.ClickonButton(frame, "OK");

		frame.switchTo().defaultContent();
		Commonfunction.ClickonButton(frame, "Save");
	}

	public static void FunctionDevelopmentItems(WebDriver driver,
			String MainLink, String SubLink, String Value, String PlanName) {

		WebDriverWait wait = new WebDriverWait(driver, 150000);
		Commonfunction.ClickonLinks(driver, MainLink);
		Commonfunction.ClickonImage(driver, SubLink);

		WebDriver frame = driver
				.switchTo()
				.frame(driver.findElement(By
						.xpath("//iframe[contains(@dojoattachpoint,'iframe')]")));

		WebElement f = frame.findElement(By
				.xpath("//input[contains(@class,'QueryInput')]"));
		f.sendKeys(Value);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// driver.findElement(By.xpath("//span[contains(.,'"+Value+"')]"));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//option[contains(.,'" + Value + "')]")));
		element.click();

		// frame.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		Commonfunction.ClickonButton(frame, "OK");

		frame.switchTo().defaultContent();
		Commonfunction.ClickonButton(frame, "Save");
	}

	// Selecting Iteration for a Test Plan
	public static void FunctionAddIteration(WebDriver driver,
			String IterationName) {
		Commonfunction.ClickonLinks(driver, "Test Schedules");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.linkText("Browse")).click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> we12 = driver.findElements(By
				.xpath("//span[contains(.,'" + IterationName + "')]"));
		System.out.println(we12.size());
		int count = we12.size();
		we12.get(count - 1).click();
		Commonfunction.ClickonButton(driver, "OK");
		Commonfunction.ClickonButton(driver, "Save");
	}

	// //Adding Entry/Exit Criteria to a Test Plan
	public static void FunctionEntryCriteria(WebDriver driver, String PlanName) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);
		Commonfunction.ClickonLinks(driver, "Entry Criteria");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//img[@alt='Add Quality Objectives']"))
				.click();
		driver.findElement(
				By.xpath("//td[contains(.,'Number of blocked test case execution records')]"))
				.click();
		Commonfunction.ClickonButton(driver, "OK");
		Commonfunction.ClickonButton(driver, "Save");

	}

	public static void FunctionExitCriteria(WebDriver driver, String PlanName) {

		WebDriverWait wait = new WebDriverWait(driver, 150000);
		Commonfunction.ClickonLinks(driver, "Exit Criteria");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Commonfunction.ClickonImage(driver, "Add Quality Objectives");
		driver.findElement(
				By.xpath("//td[contains(.,'Percentage of open severity 2 defects')]"))
				.click();
		Commonfunction.ClickonButton(driver, "OK");
		Commonfunction.ClickonButton(driver, "Save");
	}

	

	// Taking a snapshot of a Test Plan
	public static void CreateSnapshot(WebDriver driver, String SnapshotName) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);

		Commonfunction.ClickonLinks(driver, "Snapshots");
		Commonfunction.ClickonButton(driver, "Create New Snapshot");

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//input[@id='name']")));
		element.sendKeys(SnapshotName);

		Commonfunction.ClickonButton(driver, "OK");
		Commonfunction.ClickonLinks(driver, "Summary");
	}

	// Create Duplicate 
	public static void DuplicateTestItem(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 1500);
		Commonfunction.ClickonImage(driver, "Duplicate");
		Commonfunction.ClickonButton(driver, "Finish");

		// wait
		// .until(ExpectedConditions.elementToBeClickable(By
		// .xpath("//a[@class='com-ibm-asq-common-web-ui-view-action-link-button jazz-ui-ResourceLink']"))).click();

	}

	// Adding Attachment 
	public static void AddAttachmenttoTestPlan(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);
		Commonfunction.ClickonLinks(driver, "Attachments");
		driver.findElement(By.xpath("//input[@name='uploadFileInput']"))
				.click();
		Commonfunction
				.FunctionFileUpload("E:\\IDC\\sumedha\\Automation\\Selenium_Automation_Framework\\src\\ADTFeature.xml");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Commonfunction.ClickonButton(driver, "Save");
		Commonfunction.WaitLow();
	}

	public static void FunctionUpdatePlanStatus(WebDriver driver,
			String PlanName) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);

		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//div[@class='rich-hover-clip-cell clip-cell-nowrap-max-width']")))
				.click();

		boolean type = true;
		if (type = driver.findElement(By.xpath("//div[contains(.,'Draft')]"))
				.isDisplayed()) {
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By
							.xpath("//select[@name='action-select']")));
			element.click();

			element = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath("//option[contains(.,'Ready for review')]")));
			element.click();
		}

		else if (type = driver.findElement(
				By.xpath("//div[contains(.,'Under Review')]")).isDisplayed()) {
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By
							.xpath("//select[@name='action-select']")));
			element.click();

			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By
							.xpath("//option[contains(.,'Approve')]")));
			element.click();
		}
		Commonfunction.ClickonButton(driver, "Save");

	}

	public static void FunctionCreatTestData(WebDriver driver,
			String dropdownItem) {

		WebDriverWait wait = new WebDriverWait(driver, 1800);

		ObjCommonfn.SelectOptionValue(driver, "Default test");

		List<WebElement> WElist = driver.findElements(By
				.xpath("//textarea[contains(@id,'TitleTextAreaEditor')]"));
		System.out.println("Total Title" + WElist.size());
		new Actions(driver).moveToElement(WElist.get(WElist.size() - 1))
				.click().sendKeys(dropdownItem).perform();

		ObjCommonfn.SelectOptionValue(driver, "Low");

		// //************************Changes Made by sumedha
		// Start**************************
		wait = new WebDriverWait(driver, 150000);
		WElist = driver.findElements(By
				.xpath("//select[contains(@id,'owner-select')]"));
		if (WElist.size() > 0) {
			Select DropdwnStatus = new Select(WElist.get(WElist.size() - 1));
			WElist = DropdwnStatus.getOptions();
			for (int i = 0; i < WElist.size(); i++) {
				if (WElist.get(i).getText().equals("adtdevjazz1")) {
					WElist.get(i).click();
					break;
				}
			}
		}
		Commonfunction.WaitLow();

		WElist = driver.findElements(By
				.xpath("//textarea[contains(@id,'summary-text-area')]"));
		new Actions(driver).moveToElement(WElist.get(WElist.size() - 1))
				.click().sendKeys(dropdownItem + " description").perform();
		WebDriverWait wait2 = new WebDriverWait(driver, 2000);

		// -------------Upload & save---------------
		wait2.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//input[contains(@class,'UploadControl')]")))
				.click();
		driver.findElement(
				By.xpath("//input[contains(@class,'UploadControl')]")).click();
		Commonfunction
				.FunctionFileUpload(" C:\\Users\\anubha.a.jain\\Downloads\\Book1.csv");
		Commonfunction.WaitLow();

		Commonfunction.ClickonButton(driver, "Save");
	}

	public static void FunctionAddExistingScripttpKeyword(WebDriver driver,
			String TestCasesId, String ItemName) {
		WebDriverWait wait = new WebDriverWait(driver, 1800);
		Commonfunction.ClickonLinks(driver, "Test " + ItemName);
		Commonfunction.ClickonImage(driver, "Associate Existing Script");
		List<WebElement> Id = driver.findElements(By
				.xpath("//input[contains(@name,'id')]"));
		System.out.println("Enter test case no. " + Id.size());
		Id.get(Id.size() - 1).click();
		Id.get(Id.size() - 1).clear();
		Id.get(Id.size() - 1).sendKeys(TestCasesId);

		Commonfunction.ClickonButton(driver, "Run");
		Commonfunction.SelectCheckBox(driver);

		driver.findElement(By.xpath("//button[contains(.,'Add and Close')]"))
				.click();

		Commonfunction.ClickonButton(driver, "Save");
	}

	public static void FunctionExportPDF(WebDriver driver, String ExportType) {

		List<WebElement> links = driver.findElements(By
				.xpath("//label[contains(@class,'view-title')]"));

		String retval1 = null;
		for (String retval : links.get(links.size() - 1).getText().split(":")) {
			retval1 = retval;
		}
		Commonfunction.ClickonImage(driver, "Export PDF");
		/*
		 * System.out.println("retval1" + retval1); links =
		 * driver.findElements(By.xpath("//img[@alt='Export PDF']"));
		 * System.out.println("Size" + links.size()); links.get(links.size() -
		 * 1).click(); //Export Comprehensive
		 */
		links = driver.findElements(By.xpath("//td[contains(.,'" + ExportType
				+ "')]"));
		System.out.println("Size1" + links.size());
		links.get(links.size() - 1).click();

		Commonfunction.WaitMed();

		links = driver.findElements(By.xpath("//div[contains(@title,'"
				+ retval1 + "')]"));
		links.get(links.size() - 1).click();

		driver.switchTo().activeElement();

		Commonfunction.WaitMed();
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().activeElement();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void FunctionCreatTestScript(WebDriver driver,
			String dropdownItem) {

		WebDriverWait wait = new WebDriverWait(driver, 1800);

		ObjCommonfn.SelectOptionValue(driver, "Default test");

		List<WebElement> WElist = driver.findElements(By
				.xpath("//textarea[contains(@id,'TitleTextAreaEditor')]"));
		System.out.println("Total Title" + WElist.size());
		new Actions(driver).moveToElement(WElist.get(WElist.size() - 1))
				.click().sendKeys(dropdownItem).perform();

		Commonfunction.ClickonImage(driver, "Change Associated Test Data");
		Commonfunction.SelectCheckBox(driver);

		Commonfunction.ClickonButton(driver, "OK");

		wait = new WebDriverWait(driver, 150000);
		WElist = driver.findElements(By
				.xpath("//select[contains(@id,'owner-select')]"));
		Select DropdwnStatus = new Select(WElist.get(WElist.size() - 1));
		WElist = DropdwnStatus.getOptions();
		for (int i = 0; i < WElist.size(); i++) {
			if (WElist.get(i).getText().equals("adtdevjazz1")) {
				WElist.get(i).click();
				break;
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WElist = driver.findElements(By
				.xpath("//textarea[contains(@id,'summary-text-area')]"));
		new Actions(driver).moveToElement(WElist.get(WElist.size() - 1))
				.click().sendKeys(dropdownItem + " description").perform();
		Commonfunction.ClickonImage(driver, "Stack Left to Right");

		new Actions(driver)
				.moveToElement(
						driver.findElement(By
								.xpath("//div[@class='step-content']")))
				.click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]")));
		WebDriver frame = driver
				.switchTo()
				.frame(driver.findElement(By
						.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		WebElement f = driver
				.findElement(By
						.xpath("//body[@class='script-step-content cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']"));
		new Actions(driver).moveToElement(f).click().perform();

		for (int i = 0; i < 4; i++) {
			Commonfunction.WaitLow();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//body[@class='script-step-content cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")));
			WebElement itemdescription = frame
					.findElement(By
							.xpath("//body[@class='script-step-content cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']"));
			Commonfunction.WaitLow();
			itemdescription.sendKeys("first step");
			if (i < 3) {
				itemdescription
						.sendKeys(Keys.chord(Keys.ALT, Keys.ARROW_RIGHT));
			}

		}

		driver.switchTo().parentFrame();
		Commonfunction.ClickonButton(driver, "Save");
	}

	public static void FunctionAddPrePostCondition(WebDriver driver,
			String Condition, String Text) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);
		Commonfunction.ClickonLinks(driver, Condition);
		Commonfunction.ClickonImage(driver, "Edit");
		List<WebElement> Webelement = driver
				.findElements(By
						.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]"));
		WebDriver frame = driver.switchTo().frame(
				Webelement.get(Webelement.size() - 1));

		Commonfunction.WaitLow();

		Webelement = frame
				.findElements(By
						.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke_contents_ltr cke_show_borders')]"));
		Webelement.get(Webelement.size() - 1).sendKeys(Text);
		// f.sendKeys(Text);

		frame.switchTo().defaultContent();
		Commonfunction.ClickonButton(driver, "Save");
	}

	/*public static void FunctionGenerateTCERInTestCase(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 100000);

		// FunctionBrowseTestCases(driver);

		Commonfunction.WaitLow();

		Commonfunction.ClickonLinks(driver, "Test Case Execution Records");
		Commonfunction.ClickonImage(driver,
				"Generate New Test Case Execution Records");
		Commonfunction.ClickonButton(driver, "Next");
		// Commonfunction.WaitLow();
		Commonfunction.ClickonButton(driver, "Next");
		Commonfunction.ClickonButton(driver, "Finish");
		Commonfunction.ClickonButton(driver, "Save");
		Commonfunction.SelectCheckBox(driver);
		Commonfunction.ClickonImage(driver, "Run Test Case");
		List<WebElement> links = driver.findElements(By
				.xpath("//td[contains(.,'Run')]"));
		System.out.println("Size1" + links.size());
		links.get(links.size() - 2).click();
		Commonfunction.WaitMed();
		Commonfunction.ClickonButton(driver, "Finish");
		Commonfunction.WaitLow();
		List<WebElement> Webelement = driver
				.findElements(By
						.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]"));
		WebDriver frame = driver.switchTo().frame(
				Webelement.get(Webelement.size() - 1));

		Commonfunction.WaitLow();

		Webelement = frame
				.findElements(By
						.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke_contents_ltr cke_show_borders')]"));
		Webelement.get(Webelement.size() - 1).sendKeys("Working as expected");
		driver.switchTo().parentFrame();
		Commonfunction.ClickonImage(driver, "Pass (Ctrl+Shift+P)");
		Webelement = driver
				.findElements(By
						.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]"));
		
		driver.switchTo().frame(
				Webelement.get(Webelement.size() - 1));
		Webelement = frame
				.findElements(By
						.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke_contents_ltr cke_show_borders')]"));
		Webelement.get(Webelement.size() - 1).sendKeys("Working as expected");
		driver.switchTo().parentFrame();
		Commonfunction.ClickonImage(driver, "Fail (Ctrl+Shift+F)");
		Commonfunction.ClickonButton(driver, "Close");

	}*/
	
	// Changes made by harshad
	//Generate Test Execution Record in Test Case
	public static void FunctionGenerateTCERInTestCase(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 100000);

		// FunctionBrowseTestCases(driver);

		Commonfunction.WaitLow();
        Commonfunction.ClickonLinks(driver, "Test Case Execution Records");
		Commonfunction.ClickonImage(driver,
				"Generate New Test Case Execution Records");
		Commonfunction.ClickonButton(driver, "Next");
		// Commonfunction.WaitLow();
		Commonfunction.ClickonButton(driver, "Next");
		Commonfunction.ClickonButton(driver, "Finish");
		Commonfunction.ClickonButton(driver, "Save");
		
		}
		
	//Execute the TCER
		public static void FunctionExecuteTCER(WebDriver driver, String ActualResult){
			Integer Steps=null;
			WebDriverWait wait = new WebDriverWait(driver, 100000);
			Commonfunction.SelectCheckBox(driver);
			Commonfunction.ClickonImage(driver, "Run Test Case");
			List<WebElement> links = driver.findElements(By
					.xpath("//td[contains(.,'Run')]"));
			System.out.println("Size1" + links.size());
			 links.get(links.size() - 2).click();
			Commonfunction.WaitMed();
			Commonfunction.ClickonButton(driver, "Finish");
			Commonfunction.WaitLow();
			
			List<WebElement> Webelement = driver
					.findElements(By
							.xpath("//span[contains(@id,'step-num')]"));
			Steps=Webelement.size();
		
		if(ActualResult=="Pass")
		{	
			for(int i=0; i< Steps;i++)
			{
		 Webelement = driver
				.findElements(By
						.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]"));
		WebDriver frame = driver.switchTo().frame(
				Webelement.get(Webelement.size() - 1));

		Commonfunction.WaitLow();
		
		Webelement = frame
				.findElements(By
						.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke_contents_ltr cke_show_borders')]"));
		Webelement.get(Webelement.size() - 1).sendKeys(ActualResult);
		driver.switchTo().parentFrame();
		Commonfunction.ClickonImage(driver, "Pass (Ctrl+Shift+P)");
		}
		}
		
		else if(ActualResult=="Fail")
		{
		 Webelement = driver
				.findElements(By
						.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]"));
		
		WebDriver frame = driver.switchTo().frame(
				Webelement.get(Webelement.size() - 1));
		Webelement = frame
				.findElements(By
						.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke_contents_ltr cke_show_borders')]"));
		Webelement.get(Webelement.size() - 1).sendKeys("Failed");
		driver.switchTo().parentFrame();
		//driver.switchTo().defaultContent();
		
		LinkExistingDefectToTCER(driver);
		
		Commonfunction.ClickonImage(driver, "Fail (Ctrl+Shift+F)");
		LinkNewDefectToTCER(driver);
		Commonfunction.ClickonImage(driver, "Fail (Ctrl+Shift+F)");
		}
		
		driver.findElement(By
				.xpath("//button[@title='Press to close the view']")).click();
		
	}
		
		//Linking Existing Defect to a step in TCER
		public static void LinkExistingDefectToTCER(WebDriver driver){
			
		WebDriverWait wait = new WebDriverWait(driver, 100000);
		
		List<WebElement>links = driver.findElements(By.xpath("//img[@title='Link to Existing Defect']"));
		System.out.println("Size" + links.size());
		Commonfunction.WaitLow();
		links.get(links.size() - 2).click();
		
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//td[contains(.,'Link to Existing Defect')]")));
		element.click();
		Commonfunction.WaitLow();
		List<WebElement> Webelement1 = driver
				.findElements(By
						.xpath("//iframe[contains(@dojoattachpoint,'iframe')]"));
		WebDriver frame1 = driver.switchTo().frame(
				Webelement1.get(Webelement1.size() - 1));
		
		Commonfunction.SetInputFieldvaluebyattachedpoint(driver,
				"queryInput", "8") ;
		Commonfunction.SelectOptionValue(driver,"8");
		Commonfunction.ClickonButton(driver, "OK");
		driver.switchTo().defaultContent();
		
		}
		
		//Linking New Defect to a Step in TCER
		public static void LinkNewDefectToTCER(WebDriver driver){
			
			WebDriverWait wait = new WebDriverWait(driver, 100000);
			List<WebElement>links = driver.findElements(By.xpath("//img[@title='Create New Defect']"));
			System.out.println("Size" + links.size());
			links.get(links.size() - 1).click();
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//td[contains(.,'Create New Defect')]")));
			element.click();
			Commonfunction.WaitLow();
			List<WebElement> Webelement1 = driver
					.findElements(By
							.xpath("//iframe[contains(@dojoattachpoint,'iframe')]"));
			WebDriver frame1 = driver.switchTo().frame(
					Webelement1.get(Webelement1.size() - 1));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			 jse.executeScript("scroll(0, 250)");
			 Commonfunction.ClickonButton(driver, "OK");
			 driver.switchTo().defaultContent();
		}
		
}
