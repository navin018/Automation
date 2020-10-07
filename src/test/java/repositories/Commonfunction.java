package repositories;

import java.awt.AWTException;
//import static utilities.reporting.LogUtil.logger;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Commonfunction {

	/*
	 * public void readExcel() throws BiffException, IOException { String
	 * FilePath = "D:\\sampledoc.xls"; FileInputStream fs = new
	 * FileInputStream(FilePath); Workbook wb = Workbook.getWorkbook(fs);
	 * 
	 * // TO get the access to the sheet Sheet sh = wb.getSheet("Sheet1");
	 * 
	 * // To get the number of rows present in sheet int totalNoOfRows =
	 * sh.getRows();
	 * 
	 * // To get the number of columns present in sheet int totalNoOfCols =
	 * sh.getColumns();
	 * 
	 * for (int row = 0; row < totalNoOfRows; row++) {
	 * 
	 * for (int col = 0; col < totalNoOfCols; col++) {
	 * System.out.print(sh.getCell(col, row).getContents() + "\t"); }
	 * System.out.println(); } }
	 */
	public static void ClickonLinks1(WebDriver driver, String Link) {
		WebDriverWait waitPrevButton = new WebDriverWait(driver, 1550000);
		waitPrevButton.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//span[contains(.,'" + Link + "')]")));
		driver.findElement(By.xpath("//span[contains(.,'" + Link + "')]"))
				.click();
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
		robot.setAutoDelay(100);
		;
	}

	public static void FunctionSelectandClick(WebDriver driver, String Linktext) {
		WebDriverWait waitPrevButton = new WebDriverWait(driver, 185000);
		String Xpathstring = "//span[contains(.,'" + Linktext + "')]";
		WebElement element = driver.findElement(By.linkText(Linktext));
		if (element != null) {

			waitPrevButton.until(ExpectedConditions
					.visibilityOfElementLocated(By.linkText(Linktext)));
			WebElement prevButton11 = driver.findElement(By.linkText(Linktext));
			if (prevButton11 != null) {
				new Actions(driver).moveToElement(prevButton11).click()
						.perform();
			} else {
				try {
//					Log.error("No such Element found: " + Linktext);
//					logger.info("No such Element found: " + Linktext);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {

			waitPrevButton.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(Xpathstring)));
			WebElement prevButton = driver.findElement(By.xpath(Xpathstring));
			new Actions(driver).moveToElement(prevButton).click().perform();
		}
	}// End of FunctionSelectandClick

	public void FunctionSelectDropDownValue(WebDriver driver, String Linktext,
			String Value) {
		WebDriverWait waitPrevButton = new WebDriverWait(driver, 250000);
		String Xpathstring = "//div[contains(@aria-label,'" + Linktext + "')]";
		waitPrevButton.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(Xpathstring)));
		WebElement prevButton11 = driver.findElement(By.xpath(Xpathstring));
		// prevButton11.click();
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		prevButton11.sendKeys(Value);
		waitPrevButton.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(Xpathstring)));
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		prevButton11.sendKeys(Keys.DOWN);
		new Actions(driver).moveToElement(prevButton11).sendKeys(Keys.ENTER)
				.perform();
	}// End of FunctionSelectandClick

	public void FunctionSetTextBoxValue(WebDriver driver, String Linktext,
			String Value) {
		WebDriverWait waitPrevButton = new WebDriverWait(driver, 250000);
		String Xpathstring = "//div[contains(@aria-label,'" + Linktext + "')]";
		waitPrevButton.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(Xpathstring)));
		WebElement prevButton11 = driver.findElement(By.xpath(Xpathstring));
		// prevButton11.click();
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		prevButton11.sendKeys(Value);
	}

	public void selectOptionWithText(WebDriver driver, String textToSelect) {
		// try {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement autoOptions = null;
		// WebElement autoOptions =
		// driver.findElement(By.xpath(("//div[contains(@aria-label,'"+textToSelect+"')]"));
		System.out.println("Class" + autoOptions.getClass());
		// wait.until(ExpectedConditions.visibilityOf(autoOptions));

		List<WebElement> optionsToSelect = autoOptions.findElements(By
				.tagName("li"));
		// System.out.println("Class"+optionsToSelect.size());
		for (WebElement option : optionsToSelect) {
			if (option.getText().equals(textToSelect)) {
				System.out.println("Trying to select: " + textToSelect);
				option.click();
				break;
			}
		}
		// }
		/*
		 * } catch (NoSuchElementException e) {
		 * System.out.println(e.getStackTrace()); } catch (Exception e) {
		 * System.out.println(e.getStackTrace()); }
		 */
	}

	public void ClickandselectvaluefromList(WebDriver driver,
			String Propertyname, String value) {
		System.out.println("Propertyname=" + Propertyname);
		WebDriverWait waitPrevButton = new WebDriverWait(driver, 1500);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String Xpathstring = "//div[contains(@aria-label,'" + Propertyname
				+ "')]";
		waitPrevButton.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(Xpathstring)));
		WebElement element = driver.findElement(By.xpath(Xpathstring));
		element.click();
		Xpathstring = ".//span[contains(text(),'" + value + "')]";
		waitPrevButton.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(Xpathstring)));
		element = driver.findElement(By.xpath(Xpathstring));
		element.click();

	}

	public void SetInputFieldvalue(WebDriver driver, String Propertyname,
			String PropertyValue) {
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//input[contains(@aria-label,'" + Propertyname + "')]")));
		WebElement prevButtonnew = driver
				.findElement(By.xpath("//input[contains(@aria-label,'"
						+ Propertyname + "')]"));
		prevButtonnew.clear();
		new Actions(driver).moveToElement(prevButtonnew).click()
				.sendKeys(PropertyValue).perform();

	}

	public static void SetInputFieldvaluebyattachedpoint(WebDriver driver,
			String Propertyname, String PropertyValue) {
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//input[contains(@dojoattachpoint,'" + Propertyname
						+ "')]")));
		WebElement prevButtonnew = driver.findElement(By
				.xpath("//input[contains(@dojoattachpoint,'" + Propertyname
						+ "')]"));
		prevButtonnew.clear();
		new Actions(driver).moveToElement(prevButtonnew).click()
				.sendKeys(PropertyValue).perform();
		new Actions(driver).moveToElement(prevButtonnew).click()
				.sendKeys(Keys.ENTER).perform();

	}

	
	public static void SelectCheckBox(WebDriver driver) {
		WaitLow();
		List<WebElement> Id = driver.findElements(By
				.xpath("//input[contains(@id,'SimpleCheckBox')]"));
		System.out.println("Enter test case no. " + Id.size());
		Id.get(Id.size() - 1).click();
		WaitLow();
	}
	
	/*public static void ClickonPartialLinks(WebDriver driver, String Link) {
		WaitLow();
		List<WebElement> listelement = driver.findElements(By
				.xpath("//a[contains(@title,'" + Link + "')]"));
		
		
		if (listelement.size() > 0) {
			if (listelement.get(listelement.size() - 1).isDisplayed()) {
		
		listelement.get(listelement.size() - 1).click();

		WaitMed();}}
	}*/
	public static void ClickonPartialLinks(WebDriver driver, String Link) {
		WaitLow();
		List<WebElement> listelement = driver.findElements(By
				.xpath("//a[contains(.,'" + Link + "')]"));
		
		
		if (listelement.size() > 0) {
			if (listelement.get(listelement.size() - 1).isDisplayed()) {
		
		listelement.get(listelement.size() - 1).click();

		WaitMed();}}
	}
	public static void ClickonLinks(WebDriver driver, String Link) {
		
		List<WebElement> listelement = driver.findElements(By
				.xpath("//a[@title='" + Link + "']"));
		
		
		if (listelement.size() > 0) {
			if (listelement.get(listelement.size() - 1).isDisplayed()) {
		
		listelement.get(listelement.size() - 1).click();

		}}
	}

	public static void SetName(WebDriver driver, String Value) {
		WaitLow();
		List<WebElement> listelement = driver.findElements(By
				.xpath("//input[contains(@name,'textField')]"));
		listelement.get(listelement.size() - 2).sendKeys(Value);

		WaitLow();

	}

	public static void SetDescription(WebDriver driver, String Value) {

		List<WebElement> listelement = driver.findElements(By
				.xpath("//textarea[contains(@name,'undefined')]"));
		listelement.get(listelement.size() - 1).sendKeys(Value);

		WaitLow();

	}

	public static void ClickonImage(WebDriver driver, String img) {
		List<WebElement> listelement = driver.findElements(By
				.xpath("//img[@alt='" + img + "']"));
		listelement.get(listelement.size() - 1).click();

		WaitLow();
	}
	
	public static void ClickonSpan(WebDriver driver, String Value){
		List<WebElement> listelement = driver.findElements(By
				.xpath(".//span[contains(text(), '"+ Value +"')]"));
		listelement.get(listelement.size() - 1).click();

		WaitLow();
	}

	public Properties Getpropertiesvalue(String filename) {
		Properties properties = null;
		try {
			File file = new File(filename);
			FileInputStream fileInput = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	/*
	 * public void ClickonButton(WebDriver driver, String Buttonname) {
	 * WebDriverWait wait = new WebDriverWait(driver, 1050000); try{ WebElement
	 * element = wait.until(ExpectedConditions
	 * .visibilityOfElementLocated(By.xpath("//button[contains(.,'" + Buttonname
	 * + "')]"))); element.click(); } catch( Exception e){ ;
	 * Log.error(FunctionGetErrormessage(driver));
	 * 
	 * }
	 * 
	 * }
	 */
	public static void ClickonButton(WebDriver driver, String Buttonname) {
		WaitLow();
		List<WebElement> listelement = driver.findElements(By
				.xpath("//button[contains(.,'" + Buttonname + "')]"));
		System.out.println("listelement"+listelement.size());
		if (listelement.size() > 0) {
			if (listelement.get(listelement.size() - 1).isDisplayed()) {
		
		listelement.get(listelement.size() - 1).click();

		WaitLow();}}
	}

	public String FunctionGetErrormessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		String Errormsg = null;
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//span[contains(dojoattachpoint,'fErrorMsg')]")));
		Errormsg = element.getText();

		return Errormsg;
	}

	public static void SelectOptionValue(WebDriver driver, String Value) {
		WaitLow();
		List<WebElement> listelement = null;
		listelement = driver.findElements(By.xpath("//option[contains(.,'"
				+ Value + "')]"));
		if (listelement.size() > 0) {
			if (listelement.get(listelement.size() - 1).isDisplayed()) {
				listelement.get(listelement.size() - 1).click();

				WaitLow();
			}
		}
	}

	public List<String> listFilesForFolder(final File folder,
			List<String> fileList) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry, fileList);
			} else {
				// System.out.println(fileEntry.getName());
				fileList.add(fileEntry.getName());
			}
		}

		return fileList;
	}

	public Map<String, String> readXML(String file) {
		Map<String, String> xmlMap = new LinkedHashMap<String, String>();

		try {

			File fXmlFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("Attribute");

			// System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				// System.out.println("\nCurrent Element :" +
				// nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					if (nNode.hasChildNodes()) {
						NodeList nnList = nNode.getChildNodes();

						Node nnNode = nnList.item(0);

						if (nnNode.getNodeType() == Node.ELEMENT_NODE) {

							xmlMap.put(nnNode.getNodeName(),
									nnNode.getTextContent());
						}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlMap;
	}

	public List<String> getKeys(Map<String, String> xmlMap) {
		return xmlMap.entrySet().stream().map(e -> e.getKey())
				.collect(Collectors.toList());
	}

	public static void WaitLow() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void WaitMed() {
		try {
			Thread.sleep(35000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void WaitHigh() {
		try {
			Thread.sleep(150000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void WaitVeryHigh() {
		try {
			Thread.sleep(200000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}