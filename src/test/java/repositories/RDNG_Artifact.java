package repositories;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RDNG_Artifact {

	// Create Artifact,Edit, link
	public static void FunctionCreateArtifact(WebDriver driver,
			String ProjectAreaName, String varArtifactname,
			String varDescriptionName, String varLink1Name,
			String varLinkingArtifactName, String varLink2Name,
			String varLinkingWorkItemName) throws InterruptedException {
//		driver.get("https://vw000490clm2.accenture.com/rm/web");
		WebDriverWait wait = new WebDriverWait(driver, 12000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.linkText(ProjectAreaName))).click();
		Thread.sleep(3000);
		Commonfunction.FunctionSelectandClick(driver, "Artifacts");
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By
			///	.xpath(".//span[contains(text(), 'More')]")));
		//WebElement prevButtonnew1 = driver.findElement(By
			//	.xpath(".//span[contains(text(), 'More')]"));
		//new Actions(driver).moveToElement(prevButtonnew1).click().perform();
		Commonfunction.ClickonSpan(driver,"More");
		
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

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By
				//.xpath("//button[contains(.,'Browse')]")));
		
		//WebElement prevButtonnew2 = driver.findElement(By
				//.xpath("//button[contains(.,'Browse')]"));
		

		//new Actions(driver).moveToElement(prevButtonnew2).click().perform();
		Commonfunction.ClickonButton(driver, "Browse");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[@title='1100 Plan']")));
		WebElement prevButtonnew3 = driver.findElement(By
				.xpath(".//span[@title='1100 Plan']"));
		new Actions(driver).moveToElement(prevButtonnew3).perform();
		driver.findElement(By.xpath("//span[@title='1100 Plan']")).sendKeys(
				Keys.ENTER);
		
		
		Commonfunction.ClickonButton(driver, "OK");
		
		Commonfunction.ClickonButton(driver, "Done");
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Commonfunction.ClickonButton(driver, "Edit");
		
		// AddComment
		FunctionAddComment(driver);
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

		//prevButtonnew3 = driver.findElement(By
				//.xpath(".//span[contains(text(), '1100 Plan')]"));
		//new Actions(driver).moveToElement(prevButtonnew3).click().perform();
		Commonfunction.ClickonSpan(driver,"1100 Plan");

		List<WebElement> we = driver.findElements(By
				.xpath("//input[@class='filterText helpMessage']"));
		we.get(1).click();

		WebElement prevButtonnew21 = driver.findElement(By
				.xpath("//input[@class='filterText']"));
		prevButtonnew21.sendKeys(varLinkingArtifactName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[contains(@class,'entry-label')]"))
				.click();
		//driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
		Commonfunction.ClickonButton(driver, "OK");
		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By
			//	.xpath("//button[contains(.,'Save')]")));
		//prevButtonnew21 = driver.findElement(By
			//	.xpath("//button[contains(.,'Save')]"));
		//new Actions(driver).moveToElement(prevButtonnew21).click().perform();
		Commonfunction.ClickonButton(driver, "Save");
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
		WebElement prevButtonnew4 = driver.findElement(By
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
		//Commonfunction.ClickonButton(driver, "OK");

		frame.switchTo().defaultContent();

		

		//List<WebElement> we11 = driver.findElements(By
			//	.xpath("//button[contains(.,'Save')]"));
		//System.out.println(we11.size());
		//we11.get(0).click();
		Commonfunction.ClickonButton(driver, "Save");

		

		//List<WebElement> we10 = driver.findElements(By
		//		.xpath("//button[contains(.,'Done')]"));
		//System.out.println(we10.size());
		//we10.get(0).click();
		Commonfunction.ClickonButton(driver, "Done");

		// Download Artifact
		FunctionDownloadArtifact(driver);

	}
	
	public static void FunctionAddComment(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 1500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'Comments')]")));
		WebElement prevButtonnew60 = driver.findElement(By
				.xpath(".//span[contains(text(), 'Comments')]"));
		new Actions(driver).moveToElement(prevButtonnew60).click().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[@title='Comments']")));
		WebElement prevButtonnew61 = driver.findElement(By
				.xpath(".//span[@title='Comments']"));
		new Actions(driver).moveToElement(prevButtonnew61).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//td[contains(text(), 'Create comment for Artifact...')]")));
		WebElement prevButtonnew62 = driver
				.findElement(By
						.xpath(".//td[contains(text(), 'Create comment for Artifact...')]"));
		new Actions(driver).moveToElement(prevButtonnew62).click().perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//label[contains(.,'Subject:')]"))).sendKeys(
				"Comment For Artifact");

		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//label[contains(.,'Subject:')]"))).sendKeys(
				Keys.TAB);

		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//label[contains(@dojoattachpoint,'commentTextAreaLabel')]")))
				.sendKeys("Hello,Please add your comment");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[contains(@dojoattachevent,'click:_onOk')]")));
		WebElement prevButtonnew63 = driver.findElement(By
				.xpath("//button[contains(@dojoattachevent,'click:_onOk')]"));
		
		new Actions(driver).moveToElement(prevButtonnew63).click().perform();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.tagName("Body"))).click();
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
		
		Commonfunction.ClickonButton(driver, "Save");
		
		Commonfunction.ClickonButton(driver, "Done");

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
		
		Commonfunction.ClickonButton(driver, "Close");

	}
	static void FunctionSelectActiononArtifact(WebDriver driver, String Link) {
		
		Commonfunction.ClickonImage(driver, "More Actions");
		WebDriverWait wait = new WebDriverWait(driver, 1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(),'Create and Print PDF Document...')]")));
		WebElement prevButtonnew67 = driver
				.findElement(By
						.xpath(".//span[contains(text(),'Create and Print PDF Document...')]"));
		new Actions(driver).moveToElement(prevButtonnew67).sendKeys(Keys.ENTER)
				.perform();

	}
	public static void FunctionCreateReview(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 12000);
		//driver.findElement(By.xpath("//img[contains(@alt,'More Actions')]"))
			//	.click();
		Commonfunction.ClickonImage(driver, "More Actions");
		// WebDriverwait wait = new WebDriverWait(driver, 1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(),'Create Review')]")));
		WebElement prevButtonnew6 = driver.findElement(By
				.xpath(".//span[contains(text(),'Create Review')]"));
		new Actions(driver).moveToElement(prevButtonnew6).sendKeys(Keys.ENTER)
				.perform();
		
		List<WebElement> we1 = driver
				.findElements(By
						.xpath("//input[contains(@id,'com_ibm_rdm_web_review_CreateReviewForm_0_reviewNameId')]"));
		System.out.println("test" + we1.size());
		// we1.get(1).click();
		// driver.findElement(By.xpath("//input[contains(@id,'reviewNameId')]")).sendKeys("Test");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//label[contains(.,'Name')]")))
				.sendKeys("Test");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//textarea[contains(@id,'CreateReview')]")))
				.sendKeys("Review for Artifact");
		driver.findElement(
				By.xpath("//button[@dojoattachevent='onclick:_onOk']")).click();

		try {
			Thread.sleep(1000);

		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		WebDriver popup = null;
		Set<String> windowIterator = driver.getWindowHandles();
		System.err.println("No of windows :  " + windowIterator.size());
		for (String s : windowIterator) {
			String windowHandle = s;
			popup = driver.switchTo().window(windowHandle);
		}
		String Reviewer = "Kulkarni, Sumedha";
		popup.findElement(
				By.xpath("//span[contains(text(),'Add Participants')]"))
				.click();
		driver.findElement(By.xpath("//input[@class='searchText']")).sendKeys(
				Reviewer);
		driver.findElement(By.xpath("//option[contains(.,'" + Reviewer + "')]"))
				.click();
		//driver.findElement(By.xpath("//button[contains(.,'Add & Close')]"))
				//.click();
		Commonfunction.ClickonButton(driver, "Add & Close");
		driver.findElement(By.xpath("//span[contains(.,'Start Review')]"))
				.click();
		driver.findElement(By.xpath("//span[contains(.,'Pause Review')]"))
				.click();
		driver.findElement(By.xpath("//input[@id='dijit_form_CheckBox_1']"))
				.click();
		List<WebElement> we2 = driver.findElements(By
				.xpath("//span[contains(text(),'Change Status')]"));
		System.out.println(we1.size());
		we2.get(1).click();
		driver.findElement(
				By.xpath("//option[contains(.,'Approved/Reviewed')]")).click();
		//driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
		Commonfunction.ClickonButton(driver, "OK");
		driver.findElement(By.xpath("//span[contains(.,'Save Review')]"))
				.click();
		driver.findElement(By.xpath("//input[@id='dijit_form_CheckBox_0']"))
				.click();
		WebElement element = driver.findElement(By
				.xpath("//span[@id='dijit_form_DropDownButton_0']"));
		new Actions(driver).moveToElement(element).clickAndHold().perform();
		driver.findElement(By.xpath("//td[@id='dijit_MenuItem_1_text']"))
				.click();
		driver.findElement(
				By.xpath("//option[contains(.,'Approved/Reviewed')]")).click();
		driver.findElement(
				By.xpath("//option[contains(.,'Approved/Reviewed')]"))
				.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[contains(.,'Continue Review')]"))
				.click();
		driver.findElement(By.xpath("//span[contains(.,'Finalize Review')]"))
				.click();
		//driver.findElement(By.xpath("//button[contains(.,'Yes')]")).click();
		Commonfunction.ClickonButton(driver, "Yes");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();
		windowIterator = driver.getWindowHandles();
		System.err.println("No of windows :  " + windowIterator.size());
		for (String s : windowIterator) {
			String windowHandle = s;
			popup = driver.switchTo().window(windowHandle);
		}
		driver.close();
	}
	public static void FunctionCreateDuplicate(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		Commonfunction.ClickonImage(driver, "More Actions");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//span[contains(text(), 'Duplicate Artifact')]")));
		WebElement prevButtonnew4 = driver.findElement(By
				.xpath(".//span[contains(text(), 'Duplicate Artifact')]"));
		new Actions(driver).moveToElement(prevButtonnew4).click().perform();
		Commonfunction.ClickonButton(driver, "Yes");
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

		Commonfunction.FunctionSelectandClick(driver, "Artifacts");
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

}
