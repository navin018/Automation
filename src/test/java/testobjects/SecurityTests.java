package testobjects;

import static org.testng.Assert.assertTrue;
import static utilities.reporting.LogUtil.logger;
import static utilities.reporting.Reporting.create_logs_and_report;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.base.BaseLocal;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import uiMap.MyWizardUIMap;
import uiMap.SecurityTestsUIMap;
import uiMap.TeamConfigUIMap;
import uiMap.myQueriesUIMap;
import utilities.general.Property;
import utilities.selenium.DriverFactory;
public class SecurityTests extends Baseclass{
	private Baseclass base;
	
	public SecurityTests()
	{
		
	}
	
	public SecurityTests(Baseclass base) {
		this.base =base; 
	}
	
	public static String  readNetworkData(){
		try{
		String netData="";	
//			String netData;
		String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
		netData = ((JavascriptExecutor) driver()).executeScript(scriptToExecute).toString();
		return netData;
		}
		catch(Exception e)
		{
			e.printStackTrace();
//			Assert.fail("Issue reading the network data");
		}
		return "null";
	}
	


		public static void the_user_check_for_the_security_headers(String TilePageName) {
		
		try {
			Baseclass.getInstance().SecurityTestsResults = true;
			String arr = null;
			String arr1 = null;
			String arr2 = null;
			int count = 0;
			waitPageToLoad();
			Thread.sleep(5000);
			String netData  = readNetworkData();
//			Assert.assertNotNull(netData,"Issue reading data from network");
			if(isNullOrEmpty(netData))
			{
				Baseclass.getInstance().SecurityTestsResults = false;
				create_logs_and_report("Could not read network data for tile/page "+TilePageName,"fail");
				Assert.fail("Could not read network data for tile/page "+TilePageName);
			}
			String[] arrstr = (netData.split("name="));
			ArrayList<String> ar = new ArrayList<String>();
		
			for (String string : arrstr) {
				if (string.contains("https:")) {
					System.out.println(string.split(",")[0]);
					if(!ar.contains(string.split(",")[0]))
						ar.add(string.split(",")[0]);
				}
				System.out.println(ar);
				
			}
			System.out.println(ar.size());
			for (String singleurl : ar) {
				try {
					//URL to hit
					URL obj = new URL(singleurl);
					System.out.println(singleurl);
					URLConnection conn = obj.openConnection();

					HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
					//Check for the response code
					if (connection.getResponseCode() == 200 || connection.getResponseCode() == 201) {
//						create_logs_and_report(singleurl + " is up and working with code " + connection.getResponseCode(),
//								"pass");
					} else {
						
						HttpURLConnection connection1 = (HttpURLConnection) obj.openConnection();
						Thread.sleep(1000);
						if(connection.getResponseCode()==200 || connection.getResponseCode()==201) {
					
//							create_logs_and_report(singleurl + " is up and working with code " + connection.getResponseCode(),
//									"pass");
						}
					}
					
					// Get all headers key values
					
					Map<String, List<String>> map = conn.getHeaderFields();
					
					HashMap<String, List<String>> getAllHeaders = new HashMap<String, List<String>>();
		
					ArrayList<String> checkkeys = new ArrayList<String>();
					for (Map.Entry<String, List<String>> entry : map.entrySet()) {

						checkkeys.add(entry.getKey());

						System.out.println("Headername : " + entry.getKey() + " ,HeaderValue : " + entry.getValue());
						getAllHeaders.put(entry.getKey(), entry.getValue());
						
						// checking for the null or empty header values
						
						if (entry.getValue().isEmpty() || (entry.getValue())==null) {
							Baseclass.getInstance().SecurityTestsResults = false;
							System.out.println("Headername : " + entry.getKey() + " ,HeaderValue : " + entry.getValue()
									+ "Contains null header value");
							create_logs_and_report("Headername : " + entry.getKey() + " ,HeaderValue : "
									+ entry.getValue() + "Contains null header value", "fail");
							  String[] url_sp = singleurl.split("/");
							  String baseurl = "https://"+url_sp[2]+"/"+url_sp[3];
							Baseclass.getInstance().SH.add(new SecurityHeaders(TilePageName,singleurl,baseurl,entry.getKey(),"Contains null header value"));
							
						}
					
					}
					
					validatesecuirtyHeaders(getAllHeaders,singleurl, TilePageName);
					
					
				
					//Checking for the duplicate 
					ArrayList<String> check = findduplicatestring(checkkeys);
					if (check.isEmpty()) {
//						System.out.println(singleurl + " url has no duplicates");
//						create_logs_and_report(singleurl + " url has no duplicates for the tile/page "+TilePageName, "pass");
					} else {
						System.out.println(singleurl + " url has no duplicates");
						Baseclass.getInstance().SecurityTestsResults = false;
						System.out.println(singleurl + " url has  duplicates " + check);
						create_logs_and_report(singleurl + " url has  duplicates for the tile/page "+TilePageName +"  "+ check, "fail");
						String[] url_sp = singleurl.split("/");
						  String baseurl = "https://"+url_sp[2]+"/"+url_sp[3];
						Baseclass.getInstance().SH.add(new SecurityHeaders(TilePageName,singleurl,baseurl,"","url has  duplicates headers"));
					}

					checkkeys.clear();
					check.clear();
					getAllHeaders.clear();
					arrstr=null;
					netData="";
//					create_logs_and_report(
//							"<-------------------------------------------Following are the list of Header for URL "
//									+ singleurl + " ------------------------------------------->" + map,
//							"pass");

				} catch (Exception e) {
					 String[] url_sp = singleurl.split("/");
					  String baseurl = "https://"+url_sp[2]+"/"+url_sp[3];
					Baseclass.getInstance().SecurityTestsResults = false;
					create_logs_and_report("unable to hit "+singleurl + " due to network issues", "fail");
					Baseclass.getInstance().SH.add(new SecurityHeaders(TilePageName,singleurl,baseurl,"NA","unable to hit this URL due to newtwork issue"));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Issue verifying the security headers for tile "+TilePageName);
		}

	}

	private static void validatesecuirtyHeaders(HashMap<String, List<String>> getAllHeaders,String url, String tilePageName) {
//		
		try{

				verifySingleHeader(getAllHeaders,"X-Content-Type-Options",Property.getProperty("X-Content-Type-Options"),url,tilePageName);
				verifySingleHeader(getAllHeaders,"Strict-Transport-Security",Property.getProperty("Strict-Transport-Security"),url,tilePageName);
				verifySingleHeader(getAllHeaders,"Cache-Control",Property.getProperty("Cache-Control"),url,tilePageName);
				verifySingleHeader(getAllHeaders,"X-XSS-Protection",Property.getProperty("X-XSS-Protection"),url,tilePageName);
				verifySingleHeader(getAllHeaders,"Server",Property.getProperty("Server"),url,tilePageName);
				verifySingleHeader(getAllHeaders,"Content-Security-Policy",Property.getProperty("Content-Security-Policy"),url,tilePageName);

		}catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Issue verifying the security headers for Tile "+tilePageName+ " for url "+url);
		}
		
			
	}

	
	public static void verifySingleHeader(HashMap<String, List<String>> getAllHeaders, String headername, String headervalue, String url,String TilePageName){
		
	try{
		  String[] url_sp = url.split("/");
		  String baseurl = "https://"+url_sp[2]+"/"+url_sp[3];
		if(getAllHeaders.containsKey(headername))
		{
			if(getAllHeaders.get(headername).size()!=1)
			{
				Baseclass.getInstance().SecurityTestsResults = false;
				create_logs_and_report("more than expected data in header "+headername+ " for "+ url + " under "+TilePageName,"fail");
				Baseclass.getInstance().SH.add(new SecurityHeaders(TilePageName,url,baseurl,headername,"more than expected data in header. Found "+getAllHeaders.get(headername)));

			}
			else if(getAllHeaders.get(headername).size()==1)
			{
			String[] headervalue_sp = headervalue.toString().split("&");
			if(headervalue_sp.length==1)
				{
					if(getAllHeaders.get(headername).toString().equals(headervalue))
					{
					System.out.println(headername + " present");
					}
					else
					{
						Baseclass.getInstance().SecurityTestsResults = false;
						System.out.println("header "+headername+" mismatch for url "+ url + " for the Tile/Page "+TilePageName);
						create_logs_and_report("header "+headername+" mismatch for url "+ url + " for the Tile/Page "+TilePageName,"fail");
						Baseclass.getInstance().SH.add(new SecurityHeaders(TilePageName,url,baseurl,headername,"Header Mismatch"));
					}
				}
			
			else if(headervalue_sp.length>1)
			{
				if(getAllHeaders.get(headername).toString().equals(headervalue_sp[0]) || getAllHeaders.get(headername).toString().equals(headervalue_sp[1]) )
				{
				System.out.println(headername + " present");
				}
				else
				{
					Baseclass.getInstance().SecurityTestsResults = false;
					System.out.println("header "+headername+" mismatch for url "+ url + " for the Tile/Page "+TilePageName);
					create_logs_and_report("header "+headername+" mismatch for url "+ url + " for the Tile/Page "+TilePageName,"fail");
					Baseclass.getInstance().SH.add(new SecurityHeaders(TilePageName,url,baseurl,headername,"Header Mismatch"));
				}
			}
			}
		}
		else 
		{
			  String[] url_sp1 = url.split("/");
			  String baseurl1 = "https://"+url_sp[2]+"/"+url_sp[3];
			Baseclass.getInstance().SecurityTestsResults = false;
			System.out.println("missing header "+headername);
			create_logs_and_report("header "+headername+" missing for url "+ url + " for the Tile/Page "+TilePageName,"fail");
			Baseclass.getInstance().SH.add(new SecurityHeaders(TilePageName,url,baseurl1,headername,"Header Missing"));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		Baseclass.getInstance().SH.add(new SecurityHeaders(TilePageName,url,"NA",headername,"Could not verify the security Header"));
	}
		
	}
	
	public static ArrayList<String> findduplicatestring(List<String> duplicates) {
		
		try{
		java.util.HashSet unique = new HashSet();
		ArrayList<String> foundduplicates = new ArrayList<String>();
		// System.out.println("Java Find duplicate objects in list using Set");
		for (String s : duplicates) {
			if (!unique.add(s)) { // // java.util.Set only unique object so if object will not bee add in Set it
									// will return false so can consider it as Duplicate
				foundduplicates.add(s);

			}
		}
		return foundduplicates;
	}
	
	catch(Exception e)
		{
		e.printStackTrace();
		
		}
		return null;

	}

	public static void clickSublink(String sublink, String tilename) throws Exception {
		try{
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clickJS(prepareWebElementWithDynamicXpath(SecurityTestsUIMap.subpage_link, sublink, "subpagelink"));
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			switch(sublink){
			case "Add Account":
			case "View/Edit":
			case "Add Organization Structure Type":
			case "Add Delivery Construct Type":
			case "Add App Service":	
				if(!tilename.equalsIgnoreCase("Access Role"))
				ExpWaitForCondition(SecurityTestsUIMap.BasicDetails_AddAccountPage_statictxt);
				else
					ExpWaitForCondition(SecurityTestsUIMap.BasicDetails_AccessRolePage_statictxt);
				break;
			case "Manage Delivery Construct Type":
				ExpWaitForCondition(SecurityTestsUIMap.Search_txtbox);
				break;
			case "Manage Teams":
				ExpWaitForCondition(SecurityTestsUIMap.Search500_txtbox);
				break;
			case "Add Attribute":
				ExpWaitForCondition(SecurityTestsUIMap.AddAttribute_statictxt);
				break;
			case "Add Stage Template":
				ExpWaitForCondition(SecurityTestsUIMap.AddStageTemplate_statictxt);
				break;
			case "Add Tile":
				ExpWaitForCondition(SecurityTestsUIMap.AddTile_statictxt);
				break;	
			case "Add Team":
				ExpWaitForCondition(SecurityTestsUIMap.AddTeam_statictxt);
				break;	
			case "Add Product":
				ExpWaitForCondition(SecurityTestsUIMap.AddProduct_statictxt);
				break;	
			case "Add Access Role":
				ExpWaitForCondition(SecurityTestsUIMap.AddAccessRole_statictxt);
				break;		
			case "Add Iteration Reconciliation":
				ExpWaitForCondition(SecurityTestsUIMap.AddEditIterationRecon_statictxt);
				break;
			case "New Query":
				ExpWaitForCondition(SecurityTestsUIMap.NewQueryEditor_statictxt);
				break;
			case "Add Delivery Structure":
				ExpWaitForCondition(SecurityTestsUIMap.AddDC_statictxt);
				break;
			case "Add Client":
				ExpWaitForCondition(SecurityTestsUIMap.AddClient_statictxt);
				break;
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Could not find subpage "+sublink+ " under tile "+tilename, e);
		}
	}

	public static void clickbutton(String btn) {
	try{
		
		switch(btn){
			case "back":
				back();
				break;
			case "cancel":
				clickJS(SecurityTestsUIMap.Cancel_AddAttributePage_btn);
				break;
			case "backtodashboard":
				clickJS(SecurityTestsUIMap.BackToDashboard_link);
				break;
			case "close":
				clickJS(SecurityTestsUIMap.Close_btn);
				break;
			case "Associate Clients":
				clickJS(SecurityTestsUIMap.AssociateClients_btn);
				break;
			case "Select DataEntity Dropdown":
				selectDropdownByIndex(SecurityTestsUIMap.GenericDataUploaderSelectEntity_drpdown, 1);
				break;
			case "Select Standard Template":
				clickJS(SecurityTestsUIMap.SelectdrpdownforTemplate_drpdown);
				clickJS(SecurityTestsUIMap.SelectdrpTemplate_drpdown);
				break;
			case "Close Associate Clients page":
				clickJS(SecurityTestsUIMap.CloseAssociateClients_btn);
				break;
			case "View/Edit mapping":
				clickJS(SecurityTestsUIMap.ViewEditMapping_btn);
				break;
			case "Go Back":
				clickJS(SecurityTestsUIMap.GoBack_btn);
				break;
			case "VASettings":
				clickJS(SecurityTestsUIMap.VASettings_btn);
				break;
			case "Query":
				clickJS(SecurityTestsUIMap.Query_btn);
				break;
			case "Recommendation":
				clickJS(SecurityTestsUIMap.Recommendation_btn);
				break;
				
			case "Entity":
				clickJS(SecurityTestsUIMap.Entity_btn);
				break;
			case "ruleBuilder":
				clickJS(SecurityTestsUIMap.ruleBuilder_btn);
				break;
			case "CloseAddDC":
				clickJS(SecurityTestsUIMap.CloseAddDC_btn);
				break;
			case "AttentionArea":
				clickJS(SecurityTestsUIMap.AttentionArea_btn);
				break;
			case "Back To Manage Reconciliation":
				clickJS(SecurityTestsUIMap.BackToManageRecon_btn);
				break;
			case "notifications":
				clickJS(SecurityTestsUIMap.Notifications_btn);
				break;
			case "VABack":
				singleClick(SecurityTestsUIMap.VABack_btn);
				Thread.sleep(5000);
				ExpWaitForElementToDisappear(SecurityTestsUIMap.waitSign_Img);
				break;
			case "Metrics Dashboard setting":
				clickJS(SecurityTestsUIMap.MetricsDashboardSetting_btn);
				ExpWaitForElementToDisappear(SecurityTestsUIMap.waitSign_Img);
				break;
			case "Process Builder":
				clickJS(SecurityTestsUIMap.ProcessBuilder_btn);
				Thread.sleep(5000);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				waitPageToLoad();
				break;
			case "ConfigContractExplore":
				clickJS(SecurityTestsUIMap.ConfigContractExplore_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				waitPageToLoad();
				break;
			case "SelfEnabledAutomationExplore":
				clickJS(SecurityTestsUIMap.SelfEnabledAutomationExplore_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				waitPageToLoad();
				break;
			case "OnbaordClientToolExplore":
				clickJS(SecurityTestsUIMap.OnbaordClientToolExplore_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				waitPageToLoad();
				break;
			case "Back to DIY AD Automation":
				clickJS(SecurityTestsUIMap.BacktoDIYADAutomation_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				waitPageToLoad();
				break;
			case "Select Functions":
				clickJS(SecurityTestsUIMap.SelectFunctions_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				waitPageToLoad();
				break;
			case "Integrate Tools":
				clickJS(SecurityTestsUIMap.IntegrateTools_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				waitPageToLoad();
				break;
			case "Data Mapping":
				clickJS(SecurityTestsUIMap.DataMapping_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				waitPageToLoad();
				break;
			case "Enable Usecases":
				clickJS(SecurityTestsUIMap.EnableUsecases_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				waitPageToLoad();
				break;
			case "Add Users":
				clickJS(SecurityTestsUIMap.AddUsers_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				waitPageToLoad();
				break;
			case "Get Started":
				clickJS(SecurityTestsUIMap.GetStarted_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				waitPageToLoad();
				break;
			case "Back to Overall Setup Progress":
				clickJS(SecurityTestsUIMap.BacktoOverallSetup_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				waitPageToLoad();
				break;
		}
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		
		waitPageToLoad();
		
	}catch(Exception e)
	{
		e.printStackTrace();
//		throw new Exception("Could you not subpage : "+sublink+ " under tile "+tilename, e);
	}
		
	}

	public static void gotohomepage() throws Exception {
		try{
		String homepageurl = Property.getProperty("MyWizard_URL");
		String[] sp = homepageurl.split("/home");
		goURL(sp[0]+"/core");
		waitPageToLoad();
		 ExpWaitForCondition(MyWizardUIMap.scopeSelector_drpdown);
		
	}catch(Exception e)
	{
		e.printStackTrace();
		throw new Exception("Could not go back to homepage", e);
//		
	}
		
	}

	public static void writetoexcel() throws IOException {
		try{
		  Workbook workbook = new XSSFWorkbook();
		  CreationHelper createHelper = workbook.getCreationHelper();
		  Sheet sheet = workbook.createSheet("Vulnerabilities");
		  String[] columns = {"Tile", "RequestURL", "BaseURL", "Header", "Findings"};
	        // Create a Font for styling header cells
	        Font headerFont = workbook.createFont();
//	        headerFont.setBold(true);
	        headerFont.setFontHeightInPoints((short) 14);
	        headerFont.setColor(IndexedColors.RED.getIndex());

	        // Create a CellStyle with the font
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFont(headerFont);

	        // Create a Row
	        Row headerRow = sheet.createRow(0);

	        // Create cells
	        for(int i = 0; i < columns.length; i++) {
	            Cell cell = headerRow.createCell(i);
	            cell.setCellValue(columns[i]);
	            cell.setCellStyle(headerCellStyle);
	        }

	        // Create Cell Style for formatting Date
	        CellStyle dateCellStyle = workbook.createCellStyle();
	        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

	        // Create Other rows and cells with employees data
	        int rowNum = 1;
	        for(SecurityHeaders sh: Baseclass.getInstance().SH) {
	            Row row = sheet.createRow(rowNum++);

	            row.createCell(0)
	                    .setCellValue(sh.getTile());

	            row.createCell(1)
	                    .setCellValue(sh.getRequestURL());

	           row.createCell(2)
	                    .setCellValue(sh.getBaseURL());
	           
	           row.createCell(3)
               .setCellValue(sh.getHeader());
	           
	           row.createCell(4)
               .setCellValue(sh.getFindings());
	        }

//			 Resize all columns to fit the content size
	        for(int i = 0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        // Write the output to a file
	        String testDataPath = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator ;
	        FileOutputStream fileOut = new FileOutputStream(testDataPath+"SecurityTestReport.xlsx");
	        workbook.write(fileOut);
	        fileOut.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Issue writing Vulnerabilites data into the excel file");
		}

		
	}
	
	public static void updateexcel() throws IOException, InvalidFormatException {
		try{
		 String testDataPath = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator ;
		  Workbook workbook = new XSSFWorkbook();
		  CreationHelper createHelper = workbook.getCreationHelper();
		  workbook = WorkbookFactory.create(new FileInputStream(new File(testDataPath+"SecurityTestReport.xlsx")));
		  Sheet sheet = workbook.getSheet("Vulnerabilities");

	        int rowNum = sheet.getPhysicalNumberOfRows();
	        for(SecurityHeaders sh: Baseclass.getInstance().SH) {
	            Row row = sheet.createRow(rowNum++);

	            row.createCell(0)
	                    .setCellValue(sh.getTile());

	            row.createCell(1)
	                    .setCellValue(sh.getRequestURL());

	           row.createCell(2)
	                    .setCellValue(sh.getBaseURL());
	           
	           row.createCell(3)
             .setCellValue(sh.getHeader());
	           
	           row.createCell(4)
             .setCellValue(sh.getFindings());
	        }

//			 Resize all columns to fit the content size
//	        for(int i = 0; i < columns.length; i++) {
//	            sheet.autoSizeColumn(i);
//	        }

	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream(testDataPath+"SecurityTestReport.xlsx");
	        workbook.write(fileOut);
	        fileOut.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Issue writing Vulnerabilites data into the excel file");
		}
	}

	public static void verify_securitytest_results() {
		Assert.assertTrue(Baseclass.getInstance().SecurityTestsResults,"Verify the Excel report for vulnerabilities");
		
	}

	public static void AddDC() {
		clickJS(SecurityTestsUIMap.PPM_RadioBtn);
		clickJS(SecurityTestsUIMap.AddDC_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		enterText(SecurityTestsUIMap.enterDCName_txtbox, "TestDCForSecurityTest");
	}


    public static void CreateQuery() {
        try {
            ExpWaitForCondition(SecurityTestsUIMap.NewQueryEditor_statictxt);
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
            selectDropdownByValue(myQueriesUIMap.Entity_dropdown,"00020040-0200-0000-0000-000000000000"); //Select the entity from entitytype dropdown
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
            selectDropdownByValue(myQueriesUIMap.workItemType_dropdown,"00020040-0200-0010-0040-000000000000"); //Select the workitem from workitem dropdown
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
            clickJS(myQueriesUIMap.Field_txtBox);
            selectDropdownByValue(myQueriesUIMap.Field_dropdown,"Title"); //Select the Title attribute
           
            clickJS(myQueriesUIMap.Operator_txtBox);
            selectDropdownByText(myQueriesUIMap.Operator_dropdown,"Contains"); // Select the operator
           
            enterText(myQueriesUIMap.value_txtbox1,"Automation");
            clickJS(myQueriesUIMap.RunQuery_button);
            //ExpWaitForCondition(myQueriesUIMap.recordsRetrieved_staticTxt); //Verify the toaster message
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
            clickJS(myQueriesUIMap.SaveQuery_txt); //Save the query
           
            int RandomNumber = RandomNumberGenerator();
            enterText(myQueriesUIMap.QueryName_txtbox,"Sample_" + RandomNumber);
            Baseclass.getInstance().QueryName= "Sample_" + RandomNumber;
            System.out.println(Baseclass.getInstance().QueryName);
            clickJS(myQueriesUIMap.saveQuery_button);
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
            clickJS(myQueriesUIMap.navigateToQueries_txt);
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            logger.info("Creation of query failed");
            Assert.fail("Creation of query failed");
        }   
       
    }
    

    public static void DeleteQuery() {
    	try {
           
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
            String queryname ="";
            queryname = Baseclass.getInstance().QueryName;       
            singleClick(prepareWebElementWithDynamicXpath(SecurityTestsUIMap.Delete_icon, queryname,"queryname"));
            singleClick(myQueriesUIMap.DeleteQueryYes_button);
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
            logger.info("Deletion of query failed");
            Assert.fail("Deletion of query failed");
        }   
    }
    
    public static void InActivateDeliveryStructureType() {
        try {
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
            enterText(SecurityTestsUIMap.Search_text,"Automation_DoNotEdit"); 
            doubleClick(SecurityTestsUIMap.title_text);
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
             if(CheckIfElementExists(SecurityTestsUIMap.Inactive_btn))
             {
                 clickJS(SecurityTestsUIMap.Inactive_btn);
             }
             Thread.sleep(4000);
            singleClick(SecurityTestsUIMap.Save_btn);
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
            singleClick(SecurityTestsUIMap.Back_option);
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
                    
        }
        catch(Exception e)
        {
            e.printStackTrace();
             Assert.fail("Issue deactivating the Delivery structure type");
        }    
    
        
    }
    
    public static void ActivateDeliveryStructureType() {
        try {
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
            enterText(SecurityTestsUIMap.Search_text,"Automation_DoNotEdit"); 
            doubleClick(SecurityTestsUIMap.title_text);
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
             if(CheckIfElementExists(SecurityTestsUIMap.Active_btn))
             {
                 clickJS(SecurityTestsUIMap.Active_btn);
             }
             
            singleClick(SecurityTestsUIMap.Save_btn);
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//            ExpWaitForCondition(SecurityTestsUIMap.querySaved_txt);
            singleClick(SecurityTestsUIMap.Back_option);
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
            }

        catch(Exception e)
        {
            e.printStackTrace();
             Assert.fail("Issue activating the Delivery structure type");
        }    
   
    
    }
    
    public static void CreateTeam() {
        try {
            ExpWaitForCondition(SecurityTestsUIMap.AddTeam_statictxt);
            clickJS(SecurityTestsUIMap.AddTeam_statictxt);    
            Baseclass.getInstance().teamName = "Team_" + RandomNumberGenerator();
            System.out.println(Baseclass.getInstance().teamName);
            ExpWaitForCondition(TeamConfigUIMap.teamName_txtBox);
            enterText(TeamConfigUIMap.teamName_txtBox,Baseclass.getInstance().teamName);     
            System.out.println(Baseclass.getInstance().teamName);
            click(SecurityTestsUIMap.TeamSave_button);
            System.out.println("Team Saved");

    }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail("Issue in Creating Team");
            
        }
    

}
public static void DeleteTeam() {
    try {
        ExpWaitForCondition(SecurityTestsUIMap.Team_Searchbox);
        enterText(SecurityTestsUIMap.Team_Searchbox, Baseclass.getInstance().teamName);            
        singleClick(SecurityTestsUIMap.delete_button);        
        ExpWaitForCondition(SecurityTestsUIMap.confirmDelete_button);
        singleClick(SecurityTestsUIMap.confirmDelete_button);        
        System.out.println("Team deletion successful");

}
    catch(Exception e){
        e.printStackTrace();
        Assert.fail("Issue in Deleting Team");
        
    }
}




public static void ActivateAccount() {

    try {
    	clickJS(SecurityTestsUIMap.FilterAccountManagementpage_icon);
    	clickJS(SecurityTestsUIMap.Inactive_icon);
    	clickJS(SecurityTestsUIMap.Apply_btn1);
    	 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
        ExpWaitForCondition(SecurityTestsUIMap.SearchAccount_txtbox);
        enterText(SecurityTestsUIMap.SearchAccount_txtbox,"AutomationAccount_DoNotEdit");
//        ExpWaitForCondition(SecurityTestsUIMap.SearchAccount_txtbox);
        try{
        doubleClick(SecurityTestsUIMap.Select_account);
        ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
        }
        catch(Exception e){
        	e.printStackTrace();
        	logger.info("account AutomationAccount_DoNotEdit does not exist or has been deleted");
        	Assert.fail("account AutomationAccount_DoNotEdit does not exist or has been deleted");
        }
        click(SecurityTestsUIMap.Activate_btn);
        clickJS(SecurityTestsUIMap.Saverule_btn);
        
    }
    catch(Exception e) {
        e.printStackTrace();
        Assert.fail("Issue In Activating Account");
    }
    
}



public static void InactivateAccount() {
	try {
		ExpWaitForCondition(SecurityTestsUIMap.SearchAccount_txtbox);		
		enterText(SecurityTestsUIMap.SearchAccount_txtbox,"AutomationAccount_DoNotEdit");
		ExpWaitForCondition(SecurityTestsUIMap.Select_account);
		doubleClick(SecurityTestsUIMap.Select_account);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		click(SecurityTestsUIMap.InActivate_btn);
		clickJS(SecurityTestsUIMap.Saverule_btn);
		
	}
	catch (Exception e) {
		e.printStackTrace();
		Assert.fail("Issue Inactivating Account");
	}
	
}

public static void InactivateRules() {
		try {
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		enterText(SecurityTestsUIMap.Search_text,"Epic");
		doubleClick(SecurityTestsUIMap.Epic_StaticTxt);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		if(CheckIfElementExists(SecurityTestsUIMap.Activerule_btn))
		{
		clickJS(SecurityTestsUIMap.Inactiverule_btn);
		}
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		singleClick(SecurityTestsUIMap.Saverule_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		}
		catch (Exception e) {
		e.printStackTrace();
		logger.info("Issue Inactivating Rules");
		Assert.fail("Issue Inactivating Rules");
		
		}
}

public static void ActivateRules() {
		try {
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		enterText(SecurityTestsUIMap.Search_text,"Epic");
		doubleClick(SecurityTestsUIMap.Epic_StaticTxt);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		if(CheckIfElementExists(SecurityTestsUIMap.Activerule_btn))
		{
		clickJS(SecurityTestsUIMap.Activerule_btn);
		}
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		clickJS(SecurityTestsUIMap.Saverule_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		
		 }
		catch (Exception e) {
		e.printStackTrace();
		Assert.fail("Issue Activating Rules");
		}
}

 

public static void UploadFile() {
    try{
          String ExcelFileLoc = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "DataLoader" + File.separator + "Excel"+  File.separator ;
         ExcelFileLoc = ExcelFileLoc+"AD.xlsx";
            ExpWaitForElementToDisappear(SecurityTestsUIMap.waitSign_Img1);
            singleClick(SecurityTestsUIMap.Browse_btn);
            Thread.sleep(5000);
            
            String AutoITFileloc = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator +"AutoIT" + File.separator ;
            String autoITExecutable = AutoITFileloc+"UploadFile_DataLoader.exe " +ExcelFileLoc;
            Process process = Runtime.getRuntime().exec(autoITExecutable);
            process.waitFor();
            Thread.sleep(6000);
            highlight(SecurityTestsUIMap.Upload_checkbox);
            clickJS(SecurityTestsUIMap.Upload_checkbox);
            click(SecurityTestsUIMap.UploadAll_link);
            Thread.sleep(3000);
            ExpWaitForElementToDisappear(SecurityTestsUIMap.waitSign_Img1);
            assertTrue(isEnabled(SecurityTestsUIMap.UploadComplete_statictxt));
            
    }
    catch(Exception e)
    {
    	e.printStackTrace();
        Assert.fail("Issue with file upload");
        
    }
}

public static void ActivateDC() {
    try {
        enterText(SecurityTestsUIMap.DC_Searchbox,"Automationdata_donotedit");
        ExpWaitForCondition(SecurityTestsUIMap.Dc_data);
        doubleClick(SecurityTestsUIMap.Dc_data);
        ExpWaitForCondition(SecurityTestsUIMap.DcActivate_button);
        clickJS(SecurityTestsUIMap.DcActivate_button);
        ExpWaitForElementToDisappear(SecurityTestsUIMap.waitSign_Img1);
        clickJS(SecurityTestsUIMap.DcSave_button);
        ExpWaitForElementToDisappear(SecurityTestsUIMap.waitSign_Img1);
        clickJS(SecurityTestsUIMap.BacktoManage_text);
        Thread.sleep(4000);
        if(CheckIfElementExists(SecurityTestsUIMap.Popup_Yes)){
//            ExpWaitForElementToDisappear(SecurityTestsUIMap.Popup_Yes);
            clickJS(SecurityTestsUIMap.Popup_Yes);
//            clickJS(SecurityTestsUIMap.BacktoManage_text);
            ExpWaitForElementToDisappear(SecurityTestsUIMap.waitSign_Img1);
   
}
    }
       
    catch(Exception e) {
        e.printStackTrace();
        Assert.fail("Issue In activating Account");
    }
   
    }
public static void InActivateDC() {
    try {
//        clear(SecurityTestsUIMap.DC_Searchbox);
//        enterText(SecurityTestsUIMap.DC_Searchbox,"Automationdata_donotedit");
        ExpWaitForCondition(SecurityTestsUIMap.Dc_data);
        doubleClick(SecurityTestsUIMap.Dc_data);
        ExpWaitForCondition(SecurityTestsUIMap.DcInactivate_button);
        clickJS(SecurityTestsUIMap.DcInactivate_button);
        ExpWaitForElementToDisappear(SecurityTestsUIMap.waitSign_Img1);
        singleClick(SecurityTestsUIMap.DcSave_button);       
       
        clickJS(SecurityTestsUIMap.BacktoManage_text);
        if(CheckIfElementExists(SecurityTestsUIMap.Popup_Yes)){
//            ExpWaitForElementToDisappear(SecurityTestsUIMap.Popup_Yes);
            clickJS(SecurityTestsUIMap.Popup_Yes);
//            clickJS(SecurityTestsUIMap.BacktoManage_text);
            ExpWaitForElementToDisappear(SecurityTestsUIMap.waitSign_Img1);
        }
       
       
       
        ExpWaitForElementToDisappear(SecurityTestsUIMap.waitSign_Img1);
       
   
}
    catch(Exception e) {
        e.printStackTrace();
        Assert.fail("Issue In Inactivating Account");
    }
   
    }

public static void ChangeDescriptionOfExistingClient() {
			try {
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			enterText(SecurityTestsUIMap.Search_Textbox1,"Bank of Mars");
			doubleClick(SecurityTestsUIMap.title_statictxt);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clear(SecurityTestsUIMap.Descprition_txtarea);
			enterText(SecurityTestsUIMap.Descprition_txtarea,"BankOfMarsDescription");
			singleClick(SecurityTestsUIMap.Savedescription_btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			}
		catch (Exception e) {
		e.printStackTrace();
		logger.info("Issue Changing the Description ");
		Assert.fail("Issue Changing the Description ");
}
}


public static void AddProductConfig() {
		try {
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		enterText(SecurityTestsUIMap.Productname_txtbox,"ProdConfigData_Automation_DonotEdit");
		selectDropdownByText(SecurityTestsUIMap.Vendor_drpdwn,"Accenture");
		enterText(SecurityTestsUIMap.Productcode_txtbox,"87654321");
		enterText(SecurityTestsUIMap.Shortdescription_txtbox,"Automation");
		enterText(SecurityTestsUIMap.description_txtbox,"Automation_Sample");
		selectDropdownByText(SecurityTestsUIMap.productCategory_drpdwn,"Tools");
		selectDropdownByText(SecurityTestsUIMap.productSubcategory_drpdwn,"Devops");
		selectDropdownByText(SecurityTestsUIMap.productSubmissioncategor_drpdwn,"ProductOnboarding");
		selectDropdownByText(SecurityTestsUIMap.productType_drpdwn,"myWizard Applications");
		selectDropdownByText(SecurityTestsUIMap.status_drpdwn,"General Availability (GA)");
		singleClick(SecurityTestsUIMap.saveproduct_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		}
		catch (Exception e) {
		e.printStackTrace();
		logger.info("Issue Adding the Product in Prod Config page");
		Assert.fail("Issue Adding the Productin Prod Config page");
}
}

public static void DeleteProductConfig() {
try{
    ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
    enterText(SecurityTestsUIMap.searchproductconfig_txt1,"ProdConfigData_Automation_DonotEdit");
        if(CheckIfElementExists(SecurityTestsUIMap.ProductConfigName_txt))
        {
        singleClick(SecurityTestsUIMap.deleteproduct_btn);
        }
    else if(CheckIfElementExists(SecurityTestsUIMap.application_btn))
        {
        singleClick(SecurityTestsUIMap.application_btn);
        ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
        singleClick(SecurityTestsUIMap.deleteproduct_btn);
        }
        singleClick(SecurityTestsUIMap.deletionconfirmation_btn);
        ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
        singleClick(SecurityTestsUIMap.backtodashboard_btn);
        ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
    }
    catch (Exception e) {
    e.printStackTrace();
    logger.info("Issue Deleting the Product in product Config page ");
    Assert.fail("Issue Deleting the Product in product Config page ");
    }

 

}

public static void SelectEntityType() {
    try{
        ExpWaitForCondition(SecurityTestsUIMap.SelectEntity_Drpdown);
        ExpWaitForElementToDisappear(SecurityTestsUIMap.waitSign_Img);

 

        selectDropdownByText(SecurityTestsUIMap.SelectEntity_Drpdown,"AD Entities");
        }
        catch(Exception e)
        {
            Assert.fail("Could not select dataupload type from the dropdown");
            e.printStackTrace();
        }

 


}

public static void Add_StageTemplate() {
    try {
        ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
        singleClick(SecurityTestsUIMap.AddStageTemplate_txt);
        ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
        ExpWaitForCondition(SecurityTestsUIMap.name_txtbox);
        enterText(SecurityTestsUIMap.name_txtbox,"Automation_template"); 
        selectDropdownByText(SecurityTestsUIMap.entityuid_drpdwn,"Deliverable");
        clickJS(SecurityTestsUIMap.type_drpdwn1);
        clickJS(SecurityTestsUIMap.type_checkbox);
        singleClick(SecurityTestsUIMap.description_txtbox1);
        enterText(SecurityTestsUIMap.stagename_txtbox,"Automation_Sample"); 
        clear(SecurityTestsUIMap.completion_txtbox);
        enterText(SecurityTestsUIMap.completion_txtbox,"100"); 
        singleClick(SecurityTestsUIMap.savetemplate_btn);
        ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
}
    catch (Exception e) {
        e.printStackTrace();
        logger.info("Issue Adding Stage Template ");
        Assert.fail("Issue Adding Stage Template ");
    }
}

    public static void Delete_StageTemplate() {
        try {
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
            enterText(SecurityTestsUIMap.name_textbox,"Automation_template");
            singleClick(SecurityTestsUIMap.delete_symbol);
            singleClick(SecurityTestsUIMap.yes_btn);
            ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
    }
        catch (Exception e) {
        e.printStackTrace();
        logger.info("Issue Adding Stage Template ");
        Assert.fail("Issue Adding Stage Template ");
    }

    
}
    	
    public static void Delete_MeasureAndMetric() {
    	try {
    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
    	clickJS(SecurityTestsUIMap.Search_img);
    	enterText(SecurityTestsUIMap.Search_img,"Automation_Testing");
    	HoverUsingAction(SecurityTestsUIMap.Metric_Name);
    	clickJS(SecurityTestsUIMap.Delete_symbol);
    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
    	clickJS(SecurityTestsUIMap.yes_btn1);
    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
    	clickJS(SecurityTestsUIMap.Save_icon);
    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);


    	}
    	catch (Exception e) {
    	e.printStackTrace();
    	logger.info("Issue Deleting Measure And metric");
    	Assert.fail("Issue Deleting Measure And metric");
    	}


    	}
    
    public static void Add_MeasureAndMetric() {
    	try {
    	// add measure
    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
    	singleClick(SecurityTestsUIMap.Filter_img);
    	Thread.sleep(2000);
    	selectDropdownByText(SecurityTestsUIMap.Metrictyp_drpdwn,"Custom");
    	selectDropdownByText(SecurityTestsUIMap.Category_drpdwn,"Quality");
    	singleClick(SecurityTestsUIMap.Apply_btn);
    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
    	clickJS(SecurityTestsUIMap.AddMeasure_img);
    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
    	enterText(SecurityTestsUIMap.Measurename_txt,"Automation_Sample");
    	enterText(SecurityTestsUIMap.Measuredefinition_txt,"Automation_DonotEdit");
    	selectDropdownByText(SecurityTestsUIMap.Entitycustom_drpdwn,"Deliverable");
    	selectDropdownByText(SecurityTestsUIMap.Functioncustom_drpdwn,"Min");
    	selectDropdownByText(SecurityTestsUIMap.Attribute_drpdwn,"ActualEndOn");
    	// need to add the xpath of field and operator
    	clickJS(SecurityTestsUIMap.Condition_checkbox);
    	selectDropdownByText(SecurityTestsUIMap.Field_drpdwn," ID ");
    	selectDropdownByText(SecurityTestsUIMap.Operator_drpdwn," = ");
    	enterText(SecurityTestsUIMap.value_txtarea,"2");
    	clickJS(SecurityTestsUIMap.Submit_btn);
    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
    	// add metrics
    	clickJS(SecurityTestsUIMap.AddMetric_img);
    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
    	enterText(SecurityTestsUIMap.Metricname_txt,"Automation_Testing");
    	int RandomNumber = RandomNumberGenerator();
    	enterText(SecurityTestsUIMap.Metriccode_txt,"Automation_" + RandomNumber);
//    	Baseclass.getInstance().MetricCode= "Automation_" + RandomNumber;
    	enterText(SecurityTestsUIMap.Metricdefinition_txt,"Automation_SecurityTest");
    	selectDropdownByText(SecurityTestsUIMap.Metricunit_drpdwn,"Number");
    	selectDropdownByText(SecurityTestsUIMap.Threshold_drpdwn,"Trend");
    	selectDropdownByText(SecurityTestsUIMap.deliveryfunction_drpdwn,"Analytics");
    	selectDropdownByText(SecurityTestsUIMap.Category_drpdwn,"Quality");
    	clickJS(SecurityTestsUIMap.next_btn);
    	Thread.sleep(1000);
    	enterText(SecurityTestsUIMap.Searchmeasure_txt,"11thjan0xxxxx");
    	clickJS(SecurityTestsUIMap.Measure_checkbox2);
    	clear(SecurityTestsUIMap.Searchmeasure_txt);
    	enterText(SecurityTestsUIMap.Searchmeasure_txt,"0202 test ");
    	clickJS(SecurityTestsUIMap.Measure_checkbox1);
    	WebElement source = find(SecurityTestsUIMap.Measure_checkbox1);
    	WebElement destination = find(SecurityTestsUIMap.Formula_txtarea);
    	DragAndDropUsingJS(source, destination);
    	singleClick(SecurityTestsUIMap.Formula_txtarea);
    	clickAddButton();


    	WebElement source1 = find(SecurityTestsUIMap.Measure_checkbox2);
    	WebElement destination1 = find(SecurityTestsUIMap.Formula_txtarea);
    	DragAndDropUsingJS(source1, destination1);
    	clickJS(SecurityTestsUIMap.SaveasDraft_btn);
    	clickJS(SecurityTestsUIMap.Submit_btn1);
    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
    	clickJS(SecurityTestsUIMap.Save_icon);
    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
    	}
    	catch (Exception e) {
    	e.printStackTrace();
    	logger.info("Issue Adding Measure And metric");
    	Assert.fail("Issue Adding Measure And metric");
    	}

    	}
    


}
