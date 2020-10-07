package repositories;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.List;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

import utilities.general.Property;

import static utilities.reporting.LogUtil.logger;

public class Class_ApplicationFunction {

	static Commonfunction ObjCommonfn = new Commonfunction();

	// static Test_code newTcode=new Test_code();

	public void FunctionSetValue(WebDriver driver, String Propertyname,
			String PropertyValue) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		switch (Propertyname) {

		case "Module":
			Commonfunction.FunctionSelectandClick(driver, "Work Items");
			String Xpathstring = "//tr[contains(@id,'jazz_ui_menu_MenuItem_15')]";
			WebDriverWait waitPrevButton = new WebDriverWait(driver, 185000);
			waitPrevButton.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(Xpathstring)));
			WebElement prevButton = driver.findElement(By.xpath(Xpathstring));
			new Actions(driver).moveToElement(prevButton).doubleClick()
					.perform();
			Commonfunction.SelectOptionValue(driver, PropertyValue);
			Commonfunction.ClickonButton(driver, "Create Work Item");
			break;
		case "Summary":
		case "Description":
		case "Resolution Description":
		case "Comments":
		case "Justification":
		case "SN URL":
		case "SN Base URL":
			ObjCommonfn.FunctionSetTextBoxValue(driver, Propertyname,
					PropertyValue);
			break;
		case "Estimated Resolution Date":
		case "Due Date":
		case "Impact Assessment Due By":
			ObjCommonfn.SetInputFieldvalue(driver, Propertyname, PropertyValue);
			break;
		case "Priority":
		case "Story Points":
		case "Owned By":
		case "Filed Against":
		case "Planned For":
		case "Found In":
		case "Work Request Type":
			ObjCommonfn.ClickandselectvaluefromList(driver, Propertyname,
					PropertyValue);
			break;
		case "Project Area":
			logger.info("Open Project Area");
			Commonfunction.FunctionSelectandClick(driver, "Manage All Projects");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//input[contains(@title,'Search Active Project Areas')]")));
			WebElement prevButtonnew = driver
					.findElement(By
							.xpath("//input[contains(@title,'Search Active Project Areas')]"));
			new Actions(driver).moveToElement(prevButtonnew).click()
					.sendKeys(PropertyValue).perform();
			prevButtonnew.sendKeys(Keys.ENTER);

			Commonfunction.FunctionSelectandClick(driver, PropertyValue);
			/*Commonfunction.ClickonLinks(driver, "Categories");

			prevButtonnew = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By
							.xpath("//span[contains(@title,'Action Menu')]")));
			List<WebElement> prevButtonnewlink = driver.findElements(By
					.xpath("//span[contains(@title,'Action Menu')]"));
			System.out.println(prevButtonnewlink.size());
			new Actions(driver).moveToElement(prevButtonnewlink.get(0)).click()
					.build().perform();
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By
							.xpath("//td[contains(text(),'Add Category...')]")))
					.click();
			ObjCommonfn.SetInputFieldvaluebyattachedpoint(driver,
					"fCategoryName", "Create_Cat11");

			Commonfunction.ClickonButton(driver, "OK");

			Commonfunction.ClickonButton(driver, "Save");*/
			/*
			 * new
			 * Actions(driver).moveToElement(prevButtonnewlink.get(4)).click(
			 * ).build() .perform();
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By
			 * .xpath("//td[contains(text(),'Associate...')]"))).click();
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By
			 * .xpath(
			 * "//span[contains(text(),'MasterPA_AgileTemplate1dot1 [Project Area]')]"
			 * ))).click(); ObjCommonfn.ClickonButton( driver, "Associate");
			 * ObjCommonfn.ClickonButton( driver, "Save");
			 */
			try {

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Commonfunction.FunctionSelectandClick(driver, "Explore Project");
		}

	}

	
	
	public static WebDriver FunctionLogin(String URL) {
		try {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe");
		logger.info("Opening Browser");
		driver = new FirefoxDriver();
		driver.get(URL);
		WebDriverWait wait = new WebDriverWait(driver, 1000);

		String Username = Property.getProperty("Username");
		String Password = Property.getProperty("Password");

		// Handle Window Security alert
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(Username + Keys.TAB + Password);
		alt.accept();
		
      	driver.manage().window().maximize();
		return driver;
		}catch(Exception E)
		{
			E.printStackTrace();
		}
		return null;
		
	}

public static WebDriver FunctionLoginToRQM(String Url) {
		System.setProperty(
				"webdriver.gecko.driver",
				"C:\\Users\\sumedha.kulkarni\\Downloads\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		String baseUrl = Url;
		driver.get(baseUrl);

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Reading Values from property file
		Properties Loginproperties = ObjCommonfn
				.Getpropertiesvalue("Input_files/Login.properties");

		String Username = Loginproperties.getProperty("Username");
		String Password = Loginproperties.getProperty("Password");
		WebElement login = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//input[@name='j_username']")));
		login.sendKeys(Username);

		login = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//input[@name='j_password']")));
		login.sendKeys(Password);

		login = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Log In')]")));
		login.click();
		return driver;
	}

	public static String FunctionVerifyStatus(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);

		Select DropdwnStatus = new Select(driver.findElement(By.xpath("//select[@aria-label='Status']")));
		String Status = DropdwnStatus.getFirstSelectedOption().getText();

		return Status;
	}

	public static String FunctionUpdateStatus(WebDriver driver, String Status) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);

		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@aria-label='Status']")));

		WebElement combo1 = driver.findElement(By
				.xpath("//select[@aria-label='Status']"));

		new Actions(driver).moveToElement(combo1).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//select[@aria-label='Status']")));
		Select DropdwnStatus = new Select(driver.findElement(By
				.xpath("//select[@aria-label='Status']")));
		List<WebElement> WElist = DropdwnStatus.getOptions();
		for (int i = 0; i < WElist.size(); i++) {
			if (WElist.get(i).getText().equals(Status)) {
				WElist.get(i).click();
				break;
			}
		}

		return Status;
	}

	public static void FunctionCreateWorkItemReview(WebDriver driver,
			String Reviewer) {
		Commonfunction.ClickonPartialLinks(driver, "Reviews and Approvals");
		WebElement element = driver.findElement(By
				.xpath("//span[@aria-label='Add approvals']"));
		new Actions(driver).moveToElement(element).clickAndHold().perform();
		driver.findElement(By.xpath("//td[contains(.,'Add Review')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Add Approvers...')]"))
				.click();
		driver.findElement(By.xpath("//input[@class='searchText']")).sendKeys(
				Reviewer);
		driver.findElement(By.xpath("//option[contains(.,'" + Reviewer + "')]"))
				.click();
		driver.findElement(By.xpath("//button[contains(.,'Add and Close')]"))
				.click();
	}

	public static void FunctionSelectActiononArtifact(WebDriver driver,
			String Action) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//img[contains(@alt,'More Actions')]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(),'" + Action + "')]")));
		WebElement prevButtonnew6 = driver.findElement(By
				.xpath(".//span[contains(text(),'" + Action + "')]"));
		new Actions(driver).moveToElement(prevButtonnew6).sendKeys(Keys.ENTER)
				.perform();
	}

	public static void FunctionCreateRQMProjectArea(WebDriver driver,
			String RQMPAName) {

		
		Commonfunction.ClickonPartialLinks(driver, "Manage All Projects");
		Commonfunction.ClickonPartialLinks(driver, "Create Project Area");
		ObjCommonfn.SetInputFieldvalue(driver, "Project Area Name", RQMPAName);
		Commonfunction.WaitLow();
		Commonfunction.SelectOptionValue(driver,
				"Quality Management Default Process ");
		Commonfunction.ClickonButton(driver, "Save");

	}

	public static String FunctionCreateLifeCycleProjectArea(WebDriver driver,
			String ProjectAreaName) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);
		// driver.findElement(By.xpath("//img[contains(@src,'/qm/web/com/ibm/team/process/web/ui/internal/images/manage-all-projs_co.gif')]")).click();
		Commonfunction.ClickonPartialLinks(driver, "Manage All Projects");
		Commonfunction.ClickonPartialLinks(driver, "Create Lifecycle Project");

		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//input[@class='projectNameInput']")));
		element.sendKeys(ProjectAreaName);

		// List <WebElement> links = driver.findElements(By.tagName("a"));
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		List<WebElement> links = driver.findElements(By
				.linkText("Link to Existing..."));
		links.get(0).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		Commonfunction.SelectOptionValue(driver,
				"RRC_PA60_24022016 (project area)");
		Commonfunction.ClickonButton(driver, "Add Artifact Container");

		links.get(1).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		Commonfunction.SelectOptionValue(driver,
				"ChildPA_AgileTemplate1dot1 (project area)");
		Commonfunction.ClickonButton(driver, "Add Artifact Container");
		Commonfunction.ClickonButton(driver, "Save");
		Commonfunction.ClickonPartialLinks(driver, ProjectAreaName
				+ " (Quality Management)");
		String CurrentURL = driver.getCurrentUrl();
		String retval1 = null;
		for (String retval : CurrentURL.split("=")) {
			retval1 = retval;
		}
		System.out.println(retval1);

		return retval1;

	}

	public static void FunctionAddmemberandassignroles(WebDriver driver,
			String member) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				//.xpath("//div[contains(@class,'Project area created successfully')]")));
		
		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement ele : links) {

			driver.findElement(By.linkText("Add...")).click();
		}
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//input[@class='searchText']")));

		element.sendKeys(member);
		
		Commonfunction.SelectOptionValue( driver,  member);
		/*element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//option[contains(.,'" + member + "')]")));

		element.click();*/

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[@dojoattachpoint='_addButton']")));
		element.click();

		//element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
			//	.xpath("//button[contains(.,'Next >')]")));
		 Commonfunction.ClickonButton(driver, "Next >");
		//element.click();
		 Commonfunction.SelectOptionValue( driver,  "tester");
		/*element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//option[@value='tester']")));
		new Actions(driver).moveToElement(element).doubleClick().perform();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);*/

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//option[@value='contributor']")));

		element.click();
		// new Actions(driver).moveToElement(element).doubleClick().perform();
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		// driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//option[@value='data_migrator_admin']")));
		new Actions(driver).moveToElement(element).doubleClick().perform();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		// new Actions(driver).moveToElement(element).doubleClick().perform();

		/*element = wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//button[contains(.,'Finish')]")));
		element.click();
		 
		

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Save')]")));
		element.click();*/
		Commonfunction.ClickonButton(driver, "Finish");
		Commonfunction.ClickonButton(driver, "Save");
		
		boolean e;
		if (e = driver.findElement(By.xpath("//div[@class='content']"))
				.isDisplayed()) {
			Commonfunction.ClickonButton(driver, "Cancel");
		}

		Commonfunction.ClickonPartialLinks(driver, "Explore Project");
	}

	/*	public static String FunctionSelectPriority(WebDriver driver,
			String priority) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='com_ibm_rqm_planning_web_ui_internal_view_planning_TestPlanEditor_0priority-select']")));

		WebElement combo1 = driver
				.findElement(By
						.xpath("//select[@id='com_ibm_rqm_planning_web_ui_internal_view_planning_TestPlanEditor_0priority-select']"));

		new Actions(driver).moveToElement(combo1).doubleClick().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//select[@id='com_ibm_rqm_planning_web_ui_internal_view_planning_TestPlanEditor_0priority-select']")));
		Select DropdwnStatus = new Select(
				driver.findElement(By
						.xpath("//select[@id='com_ibm_rqm_planning_web_ui_internal_view_planning_TestPlanEditor_0priority-select']")));
		List<WebElement> WElist = DropdwnStatus.getOptions();
		for (int i = 0; i < WElist.size(); i++) {
			if (WElist.get(i).getText().equals(priority)) {
				WElist.get(i).click();
				break;
			}
		}
		return priority;
	}*/

	public static void FunctionIntegrateWorkRequest(WebDriver driver,String External_Workplan) {
		WebDriverWait waitPrevButton = new WebDriverWait(driver, 650000);
		waitPrevButton.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@aria-label='Status']")));
		Commonfunction.ClickonPartialLinks(driver, "Integration");
		Class_ApplicationFunction.FunctionUpdateStatus(driver, "Assess");
		if (External_Workplan.equals("Create New")){
		  ObjCommonfn.ClickandselectvaluefromList(driver, "External Workplan",
		  "Create New");
		 
		 ObjCommonfn.ClickandselectvaluefromList(driver,
		 "External Workplan Type","ACN Maintenance Request");
		}
		else if (External_Workplan.equals("No Workplan Required")){
		ObjCommonfn.ClickandselectvaluefromList(driver, "External Workplan",
				"No Workplan Required");
		Commonfunction.WaitLow();
		ObjCommonfn.FunctionSetTextBoxValue(driver, "Justification",
				"Justification");
		}
		else{
			ObjCommonfn.ClickandselectvaluefromList(driver, "External Workplan",
					"Select Existing");
			ObjCommonfn.ClickandselectvaluefromList(driver, "Available Workplans",
					"FluentBook_500");
			//driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
			ObjCommonfn.ClickandselectvaluefromList(driver, "Assign To",
					"Saksena, Akanksha A.");	
		}
		Commonfunction.WaitLow();
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
	
		Commonfunction.WaitHigh();
		Class_ApplicationFunction.FunctionUpdateStatus(driver, "Approve");
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class_ApplicationFunction.FunctionUpdateStatus(driver, "Plan");
		if (External_Workplan.equals("Create New")){
			  ObjCommonfn.ClickandselectvaluefromList(driver, "External Workplan",
			  "Create New");
			 
			 ObjCommonfn.ClickandselectvaluefromList(driver,
			 "External Workplan Type","ACN Maintenance Request");
			}
			else if (External_Workplan.equals("No Workplan Required")){
			ObjCommonfn.ClickandselectvaluefromList(driver, "External Workplan",
					"No Workplan Required");
			
			ObjCommonfn.FunctionSetTextBoxValue(driver, "Justification",
					"Justification");
			}
			else{
				ObjCommonfn.ClickandselectvaluefromList(driver, "External Workplan",
						"Select Existing");
				ObjCommonfn.ClickandselectvaluefromList(driver, "Available Workplans",
						"FluentBook_500");
				//driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
				ObjCommonfn.ClickandselectvaluefromList(driver, "Assign To",
						"Saksena, Akanksha A.");	
			}
		
		Commonfunction.WaitLow();
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();

	}

	public static void FunctionLink(WebDriver driver)
			throws InterruptedException {

		WebDriverWait waitPrevButton = new WebDriverWait(driver, 650000);
		Commonfunction.ClickonPartialLinks(driver, "Links");
		driver.findElement(

		By.xpath("//div[contains(@dojoattachpoint,'addAction')]")).click();

		Commonfunction
				.FunctionFileUpload("C:\\Users\\sumedha.kulkarni\\Desktop\\result.txt");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitPrevButton.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[@class='DropdownArrowElement']")))
				.click();
		driver.findElement(By.xpath("//td[contains(.,'Set Parent')]")).click();
		waitPrevButton.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//input[@class='QueryInput']"))).sendKeys("*");
		waitPrevButton.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//input[@class='QueryInput']"))).sendKeys(
				Keys.ENTER);
		waitPrevButton.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//option[@value='928']"))).click();
		driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();

		// Link RDNG Element
		waitPrevButton.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[@class='DropdownArrowElement']")))
				.click();
		driver.findElement(
				By.xpath("//td[contains(.,'Add Related Test Script')]"))
				.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitPrevButton
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//select[@aria-label='Select either the location of the existing artifact you want to link to or the location of the new artifact you want to create']")))
				.click();
		Select DropdwnStatus = new Select(
				driver.findElement(By
						.xpath("//select[@aria-label='Select either the location of the existing artifact you want to link to or the location of the new artifact you want to create']")));
		List<WebElement> WElist = DropdwnStatus.getOptions();
		System.out.println(WElist.size());
		for (int i = 0; i < WElist.size(); i++) {
			System.out.println(WElist.get(i).getText());
			if (WElist.get(i).getText().trim()
					.equals("RRC_New_Test (Quality Management)")) {
				System.out.println(WElist.get(i).getText());
				WElist.get(i).click();
				WElist.get(i).sendKeys(Keys.ENTER);
				break;
			}
		}

		waitPrevButton.until(
				ExpectedConditions.visibilityOfElementLocated((By
						.xpath("//button[contains(.,'OK')]")))).click();
		WebDriver Frame = driver.switchTo().frame(
				driver.findElement(By
						.xpath("//iframe[@dojoattachpoint='iframe']")));
		waitPrevButton
				.until(ExpectedConditions.visibilityOf(Frame.findElement(By
						.xpath("//input[@id='TableViewer_SimpleCheckBox_0-input']"))))
				.click();
		Frame.findElement(By.xpath("//button[contains(.,'OK')]")).click();
		Frame.switchTo().defaultContent();
		waitPrevButton.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[@class='DropdownArrowElement']")))
				.click();
		driver.findElement(
				By.xpath("//td[contains(.,'Add Related Artifacts')]")).click();
		Commonfunction
				.SetInputFieldvaluebyattachedpoint(
						driver,
						"urlField",
						"https://vw000490clm2.accenture.com/rm/resources/_niN1gb1lEeeDpPwB6_L5-Q?oslc_config.context=https%3A%2F%2Fvw000490clm2.accenture.com%2Frm%2Fcm%2Fstream%2F_T18jcLe4EeeendMN4hFOzw ");
		// waitPrevButton.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[contains(.,'OK')]")))).click();

	}

	// Function to select Submenu Item
	public static void FunctionSelectSubMenu(WebDriver driver,
			String dropdownName, String dropdownItem) {
		WebDriverWait wait = new WebDriverWait(driver, 15000);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@aria-label='"
						+ dropdownName + " Drop-Down Menu']")));
		element.click();
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//span[contains(.,'" + dropdownItem + "')]")));
		element.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Function to create Menu Items and set name and Description

	public static void FunctionCreatMenuItem(WebDriver driver,
			String dropdownItem) {

		WebDriverWait wait = new WebDriverWait(driver, 1800);

		Commonfunction.SelectOptionValue(driver, "Default test");

		List<WebElement> WElist = driver.findElements(By
				.xpath("//textarea[contains(@id,'TitleTextAreaEditor')]"));
		System.out.println("Total Title" + WElist.size());
		new Actions(driver).moveToElement(WElist.get(WElist.size() - 1))
				.click().sendKeys(dropdownItem).perform();

		Commonfunction.SelectOptionValue(driver, "Low");

		// //************************Changes Made by sumedha
		// Start**************************
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

		Commonfunction.ClickonButton(driver, "Save");
	}

	
}