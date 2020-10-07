package repositories;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Class_Application_merge {

	static Commonfunction ObjCommonfn = new Commonfunction();

	/*public static WebDriver FunctionLogin(String URL) {
		System.setProperty(
				"webdriver.gecko.driver",
				"C:\\Users\\darshana.rathi\\Downloads\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		String baseUrl = URL;
		driver.get(baseUrl);

		WebDriverWait wait = new WebDriverWait(driver, 1000);

		// Reading Values from property file
		Properties Loginproperties = ObjCommonfn
				.Getpropertiesvalue("Input_files/Login.properties");

		String Username = Loginproperties.getProperty("Username");
		String Password = Loginproperties.getProperty("Password");

		// Handle Window Security alert
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(Username + Keys.TAB + Password);
		alt.accept();

		// Code to maximize browser
		driver.manage().window().maximize();
		return driver;

	}
*/
	// Create PA
	public static void FunctionCreatePA(WebDriver driver, String PAName) {
		WebDriverWait wait = new WebDriverWait(driver, 50000);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By
				.xpath("//span[contains(@class,'sprite-image admin-menu')]"))));
		WebElement prev = driver.findElement(By
				.xpath("//span[contains(@class,'sprite-image admin-menu')]"));
		System.out.println("Success");
		new Actions(driver).moveToElement(prev).clickAndHold()
				.sendKeys(Keys.ENTER).perform();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();

		}
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {

			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//input[@id='dijit_form_TextBox_0']")))
				.sendKeys(PAName);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//button[contains(.,'Next >')]"))).click();
		driver.findElement(
				By.xpath("//label[contains(.,'Use a template to initially populate the project')]"))
				.click();
		FunctionThread(driver);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
				.xpath("//input[@class='filterText helpMessage']")));
		List<WebElement> we = driver.findElements(By
				.xpath("//input[@class='filterText helpMessage']"));
		we.get(1).click();
		driver.findElement(By.xpath("//input[@class='filterText helpMessage']")).sendKeys(
				"ADT RRC Template 6.0");
		driver.findElement(By.xpath("//input[@class='filterText helpMessage']")).sendKeys(
				Keys.ENTER);
		driver.findElement(
				By.xpath("//label[contains(.,'ADT RRC Template 6.0')]"))
				.click();
		FunctionThread(driver);
		//wait.until(
			//	ExpectedConditions.elementToBeClickable(By
						//.xpath("//button[contains(.,'Finish')]"))).click();
		Commonfunction.ClickonButton(driver,"Finish");

		FunctionThread1(driver);

	}

	/*public static void ClickonLinks(WebDriver driver, String Link) {
		WebDriverWait waitPrevButton = new WebDriverWait(driver, 1500);

		driver.findElement(By.xpath("//a[contains(.,'" + Link + "')]")).click();
	}*/

	// Add Member
	public static void FunctionAddMember(WebDriver driver, String Member,
			String PAName) {
//		driver.get("https://vw000490clm2.accenture.com/rm/web");
		Commonfunction.ClickonLinks(driver, "Manage All Projects");
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//input[@title='Search Active Project Areas']")));
		WebElement prevButtonnew = driver.findElement(By
				.xpath("//input[@title='Search Active Project Areas']"));
		new Actions(driver).moveToElement(prevButtonnew).doubleClick()
				.sendKeys(PAName).perform();
		prevButtonnew.sendKeys(Keys.ENTER);

		FunctionThread(driver);
		Commonfunction.ClickonLinks(driver, PAName);
		// driver.findElement(By.xpath("//a[contains(.,'RDNGAutomationProject30112017')]")).click();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement ele : links) {
			driver.findElement(By.linkText("Add...")).click();
		}
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//input[@class='searchText']")));
		element.sendKeys(Member);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//option[contains(.,Member)] ")));
		element.click();
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[@dojoattachpoint='_addButton']")));
		element.click();
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Next >')]")));
		element.click();
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//option[@value='Administrator']")));
		new Actions(driver).moveToElement(element).doubleClick().perform();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//option[@value='Author']")));
		element.click();
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//option[@value='Commenter']")));
		new Actions(driver).moveToElement(element).doubleClick().perform();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//option[@value='ProjectSnapshotAdministrator']")));
		element.click();
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Finish')]")));
		element.click();
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Save')]")));
		element.click();
		driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();
	}

	// Create Artifact,Edit, link
	public static void FunctionCreateArtifact(WebDriver driver,
			String ProjectAreaName, String varArtifactname,
			String varDescriptionName, String varLink1Name,
			String varLinkingArtifactName, String varLink2Name,
			String varLinkingWorkItemName) {
		driver.get("https://vw000490clm2.accenture.com/rm/web");
		WebDriverWait wait = new WebDriverWait(driver, 12000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.linkText(ProjectAreaName))).click();
		ObjCommonfn.FunctionSelectandClick(driver, "Artifacts");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'More')]")));
		WebElement prevButtonnew1 = driver.findElement(By
				.xpath(".//span[contains(text(), 'More')]"));
		new Actions(driver).moveToElement(prevButtonnew1).click().perform();
		FunctionThread(driver);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//label[contains(.,'Initial content:')]")))
				.sendKeys(varArtifactname);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//input[contains(@id,'com_ibm_rdm_web_project_NewArtifactForm_0_artifactTypeField')]")))
				.clear();
		driver.findElement(
				By.xpath("//input[contains(@id,'com_ibm_rdm_web_project_NewArtifactForm_0_artifactTypeField')]"))
				.sendKeys("AP211");
		driver.findElement(
				By.xpath("//input[contains(@id,'com_ibm_rdm_web_project_NewArtifactForm_0_artifactTypeField')]"))
				.click();
		driver.findElement(
				By.xpath("//input[contains(@id,'com_ibm_rdm_web_project_NewArtifactForm_0_artifactTypeField')]"))
				.sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Browse')]")));
		WebElement prevButtonnew2 = driver.findElement(By
				.xpath("//button[contains(.,'Browse')]"));

		new Actions(driver).moveToElement(prevButtonnew2).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[@title='1100 Plan']")));
		WebElement prevButtonnew3 = driver.findElement(By
				.xpath(".//span[@title='1100 Plan']"));
		new Actions(driver).moveToElement(prevButtonnew3).perform();
		driver.findElement(By.xpath("//span[@title='1100 Plan']")).sendKeys(
				Keys.ENTER);
		FunctionThread(driver);
		driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Done')]")));
		WebElement prevButtonnew21 = driver.findElement(By
				.xpath("//button[contains(.,'Done')]"));
		new Actions(driver).moveToElement(prevButtonnew21).click().perform();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Edit')]")));
		WebElement prevButtonnew4 = driver.findElement(By
				.xpath("//button[contains(.,'Edit')]"));
		new Actions(driver).moveToElement(prevButtonnew4).click().perform();
		// AddComment
		//FunctionAddComment(driver);
		// Update Title
		FunctionUpdateTitle(driver);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//textarea[contains(@id,'description')]")));
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//textarea[contains(@id,'description')]")))
				.sendKeys(varDescriptionName);

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {

			e.printStackTrace();
		}

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.tagName("Body"))).click();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		FunctionThread(driver);

		driver.findElement(
				By.xpath("//input[contains(@class,'hyperLinkText-field')]"))
				.sendKeys(varLink1Name);

		driver.findElement(
				By.xpath("//input[contains(@class,'hyperLinkText-field')]"))
				.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath(".//span[contains(text(), '1100 Plan')]")));

		try {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath(".//span[contains(text(), '1100 Plan')]")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		prevButtonnew3 = driver.findElement(By
				.xpath(".//span[contains(text(), '1100 Plan')]"));
		new Actions(driver).moveToElement(prevButtonnew3).click().perform();

		List<WebElement> we = driver.findElements(By
				.xpath("//input[@class='filterText helpMessage']"));
		we.get(1).click();

		prevButtonnew21 = driver.findElement(By
				.xpath("//input[@class='filterText']"));
		prevButtonnew21.sendKeys(varLinkingArtifactName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[contains(@class,'entry-label')]"))
				.click();
		driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Save')]")));
		prevButtonnew21 = driver.findElement(By
				.xpath("//button[contains(.,'Save')]"));
		new Actions(driver).moveToElement(prevButtonnew21).click().perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.tagName("Body"))).click();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		FunctionThread(driver);
		List<WebElement> we1 = driver
				.findElements(By
						.xpath("//input[contains(@class,'dijitReset dijitInputField dijitArrowButtonInner')]"));
		System.out.println("test" + we1.size());
		new Actions(driver).moveToElement(we1.get(6)).clickAndHold().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prevButtonnew4 = driver.findElement(By
				.xpath("//td[contains(.,'More...')]"));
		new Actions(driver).moveToElement(prevButtonnew4).click().perform();
		new Actions(driver).moveToElement(prevButtonnew4)
				.sendKeys(Keys.ARROW_UP).perform();
		new Actions(driver).moveToElement(prevButtonnew4).sendKeys(Keys.ENTER)
				.perform();
		prevButtonnew4 = driver.findElement(By
				.xpath("//td[contains(.,'Implemented By')]"));
		new Actions(driver).moveToElement(prevButtonnew4).click().perform();
		driver.findElement(
				By.xpath("//input[contains(@class,'hyperLinkText-field')]"))
				.sendKeys(varLink2Name);
		WebDriver frame = driver.switchTo().frame(
				driver.findElement(By
						.xpath("//iframe[@dojoattachpoint='iframe']")));
		WebElement f = driver.findElement(By
				.xpath("//input[contains(@class,'QueryInput')]"));
		new Actions(driver).moveToElement(f).click().perform();
		f.sendKeys(varLinkingWorkItemName);

		frame.findElement(
				By.xpath("//option[contains(.,'" + varLinkingWorkItemName
						+ "')]")).click();
		frame.findElement(By.xpath("//button[contains(.,'OK')]")).click();

		frame.switchTo().defaultContent();

		FunctionThread(driver);

		List<WebElement> we11 = driver.findElements(By
				.xpath("//button[contains(.,'Save')]"));
		System.out.println(we11.size());
		we11.get(0).click();

		FunctionThread(driver);

		List<WebElement> we10 = driver.findElements(By
				.xpath("//button[contains(.,'Done')]"));
		System.out.println(we10.size());
		we10.get(0).click();

		// Download Artifact
		FunctionDownloadArtifact(driver);

	}

	// Create Review
	
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
		ObjCommonfn.FunctionSelectandClick(driver, "Collections");
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
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Browse')]")));
		WebElement prevButtonnew2 = driver.findElement(By
				.xpath("//button[contains(.,'Browse')]"));
		new Actions(driver).moveToElement(prevButtonnew2).click().perform();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), '1100 Plan')]")));
		WebElement prevButtonnew3 = driver.findElement(By
				.xpath(".//span[contains(text(), '1100 Plan')]"));
		new Actions(driver).moveToElement(prevButtonnew3).perform();
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

		prevButtonnew3 = driver.findElement(By
				.xpath(".//span[contains(text(), '1100 Plan')]"));
		new Actions(driver).moveToElement(prevButtonnew3).click().perform();
		List<WebElement> we = driver.findElements(By
				.xpath("//input[@class='filterText helpMessage']"));
		we.get(1).click();

		prevButtonnew2 = driver.findElement(By
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
		driver.findElement(By.xpath("//button[contains(.,'Add & Close')]"))
				.click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Done')]")));
		prevButtonnew2 = driver.findElement(By
				.xpath("//button[contains(.,'Done')]"));
		new Actions(driver).moveToElement(prevButtonnew2).click().perform();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Browse')]")));
		WebElement prevButtonnew20 = driver.findElement(By
				.xpath("//button[contains(.,'Browse')]"));
		new Actions(driver).moveToElement(prevButtonnew20).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[@title='1100 Plan']")));
		WebElement prevButtonnew30 = driver.findElement(By
				.xpath(".//span[@title='1100 Plan']"));
		new Actions(driver).moveToElement(prevButtonnew30).perform();
		driver.findElement(By.xpath("//span[@title='1100 Plan']")).sendKeys(
				Keys.ENTER);
		driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();

	}

	public static void FunctionCreateDuplicate(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		driver.findElement(By.xpath("//img[contains(@alt,'More Actions')]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'Duplicate Artifact')]")));
		WebElement prevButtonnew4 = driver.findElement(By
				.xpath(".//span[contains(text(), 'Duplicate Artifact')]"));
		new Actions(driver).moveToElement(prevButtonnew4).click().perform();
		driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Browse Collections
		Commonfunction.ClickonLinks(driver, "Collections");
		// ObjCommonfn.FunctionSelectandClick(driver, "Collections");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'Browse Collections')]")));
		WebElement prevButtonnew101 = driver.findElement(By
				.xpath(".//span[contains(text(), 'Browse Collections')]"));
		new Actions(driver).moveToElement(prevButtonnew101).click().perform();
		driver.close();
	}

	public static void FunctionFilterByFolder(WebDriver driver, String PAName) {
		// driver.get("https://vw000490clm2.accenture.com/rm/web");

		WebDriverWait wait = new WebDriverWait(driver, 15000);

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(PAName)))
				.click();

		ObjCommonfn.FunctionSelectandClick(driver, "Artifacts");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'Browse Artifacts')]")));
		WebElement prevButtonnew1 = driver.findElement(By
				.xpath(".//span[contains(text(), 'Browse Artifacts')]"));
		new Actions(driver).moveToElement(prevButtonnew1).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'Filter by Folder')]")));
		WebElement prevButtonnew4 = driver.findElement(By
				.xpath(".//span[contains(text(), 'Filter by Folder')]"));
		new Actions(driver).moveToElement(prevButtonnew4).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath(".//span[contains(text(), '1100 Plan')]")));
		driver.findElement(By.xpath(".//span[contains(text(), '1100 Plan')]"))
				.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'Filter by Attribute')]")));
		WebElement prevButtonnew5 = driver.findElement(By
				.xpath(".//span[contains(text(), 'Filter by Attribute')]"));
		new Actions(driver).moveToElement(prevButtonnew5).click().perform();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'Artifact type')]")));
		WebElement prevButtonnew6 = driver.findElement(By
				.xpath(".//span[contains(text(), 'Artifact type')]"));
		new Actions(driver).moveToElement(prevButtonnew6).click().perform();
		WebElement option1 = driver.findElement(By
				.xpath(".//span[contains(text(), 'AP211 Use Case')]"));
		option1.click();
		List<WebElement> we1 = driver.findElements(By
				.xpath("//span[contains(text(),'Apply')]"));
		System.out.println(we1.size());
		we1.get(1).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'Views')]")));
		WebElement prevButtonnew52 = driver.findElement(By
				.xpath(".//span[contains(text(), 'Views')]"));
		new Actions(driver).moveToElement(prevButtonnew52).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'Underived Use Cases')]")));
		WebElement prevButtonnew53 = driver.findElement(By
				.xpath(".//span[contains(text(), 'Underived Use Cases')]"));
		new Actions(driver).moveToElement(prevButtonnew53).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'Filter by Tag')]")));
		WebElement prevButtonnew54 = driver.findElement(By
				.xpath(".//span[contains(text(), 'Filter by Tag')]"));
		new Actions(driver).moveToElement(prevButtonnew54).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'Automation')]")));
		WebElement prevButtonnew55 = driver.findElement(By
				.xpath(".//span[contains(text(), 'Automation')]"));
		new Actions(driver).moveToElement(prevButtonnew55).click().perform();
		driver.close();

	}

	public static void FunctionImportADTTemplate(WebDriver driver,
			String RQMPAName) {

		WebDriverWait wait = new WebDriverWait(driver, 150000);

		Commonfunction.ClickonLinks(driver, "Manage All Projects");
		driver.findElement(
				By.xpath("//span[contains(.,'Create Project Area')]")).click();
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
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//button[contains(.,'Save')]")));
		element.click();
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
		WebElement element1 = driver.findElement(By
				.xpath("//span[contains(.,'Manage Project Properties')]"));
		new Actions(driver).moveToElement(element1).click().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();

		}
		driver.findElement(By.xpath("//span[contains(.,'Templates')]")).click();

		List<WebElement> we1 = driver.findElements(By
				.xpath("//span[contains(text(),'Upload Template...')]"));
		System.out.println(we1.size());
		we1.get(2).click();

		driver.findElement(By.xpath("//input[@name='upload']")).click();
		FunctionFileUpload(" C:\\Users\\darshana.rathi\\Downloads\\ADT RRC Template\\ADT FY13Q3.archive");
		FunctionThread(driver);
		List<WebElement> we2 = driver.findElements(By
				.xpath("//button[contains(.,'Upload')]"));
		System.out.println(we2.size());
		we2.get(0).click();
		// driver.findElement(By.xpath("//button[@dojoattachpoint='_okButtonNode']")).click();
		// driver.findElement(By.xpath("//button[contains(.,'Upload')]")).click();
	}

	public static void FunctionCreateTeamArea(WebDriver driver,
			String TeamAreaName, String member, String RQMPAName) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By
						.xpath("//img[@alt='Create Team...']")));
		element.click();

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
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
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//button[contains(.,'Add and Close')]")));
		element.click();
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
		driver.findElement(By.linkText(RQMPAName)).click();

	}

	
	public static void FunctionFileUpload(String FilePath) {
		StringSelection stringSelection = new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard()
				.setContents(stringSelection, null);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL); // paste the copied string into
												// the dialog box
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void FunctionThread(WebDriver driver) {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void FunctionThread1(WebDriver driver) {
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void FunctionUpdateTitle(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 150000);

		WebElement prevButtonnew4 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//span[@class='resource-title']")));

		Actions action = new Actions(driver);
		action.moveToElement(prevButtonnew4).sendKeys(Keys.ENTER).perform();
		int lenText = driver
				.findElement(By.xpath("//span[@class='resource-title']"))
				.getText().length();

		for (int i = 0; i < lenText; i++) {
			action.sendKeys(Keys.ARROW_LEFT);
		}
		action.build().perform();
		// action.sendKeys(Keys.DELETE);
		/*
		 * for (int i = 0; i < lenText; i++) { action.sendKeys(Keys.DELETE); }
		 */
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		action.build().perform();
		prevButtonnew4 = driver.findElement(By
				.xpath("//span[@title='<Artifact>']"));
		int length = prevButtonnew4.getText().length();

		prevButtonnew4.sendKeys("ArtifactName_Edited");
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_HOME);
		robot.keyRelease(KeyEvent.VK_HOME);

		for (int i = 0; i < length - 2; i++) {
			// System.out.println(i);
			robot.delay(110);
			robot.keyPress(KeyEvent.VK_DELETE);
			robot.keyRelease(KeyEvent.VK_DELETE);

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Save')]")));
		WebElement prevButtonnew201 = driver.findElement(By
				.xpath("//button[contains(.,'Save')]"));
		new Actions(driver).moveToElement(prevButtonnew201).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(.,'Done')]")));
		WebElement prevButtonnew202 = driver.findElement(By
				.xpath("//button[contains(.,'Done')]"));

		new Actions(driver).moveToElement(prevButtonnew202).click().perform();

	}

	static void FunctionSelectActiononArtifact(WebDriver driver, String Link) {
		driver.findElement(By.xpath("//img[contains(@alt,'More Actions')]"))
				.click();
		WebDriverWait wait = new WebDriverWait(driver, 1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(),'Create and Print PDF Document...')]")));
		WebElement prevButtonnew67 = driver
				.findElement(By
						.xpath(".//span[contains(text(),'Create and Print PDF Document...')]"));
		new Actions(driver).moveToElement(prevButtonnew67).sendKeys(Keys.ENTER)
				.perform();

	}

	static void FunctionDownloadArtifact(WebDriver driver) {
		FunctionSelectActiononArtifact(driver,
				"Create and Print PDF Document...");
		driver.findElement(
				By.xpath("//button[@dojoattachevent='onclick:_onOk']")).click();

		driver.switchTo().activeElement();

		try {
			Thread.sleep(12000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		WebElement element = driver.findElement(By
				.xpath("//button[contains(.,'Close')]"));
		new Actions(driver).moveToElement(element).click().perform();

	}
}
