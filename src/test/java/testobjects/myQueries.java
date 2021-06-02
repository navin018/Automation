package testobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import static utilities.selenium.SeleniumDSL.*;
import static utilities.general.Property.*;
import static utilities.reporting.LogUtil.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import dataobjects.WorkItemDO;
import dataobjects.WorkItemExternalIDDO;
//import javassist.bytecode.stackmap.BasicBlock.Catch;
import testobjects.Baseclass;
import uiMap.JiraUIMap;
import uiMap.MyWizardUIMap;
import uiMap.ProductConfigUIMap;
import uiMap.TeamConfigUIMap;
import utilities.general.DataManager;
import utilities.general.Property;
import utilities.selenium.SeleniumDSL;
import uiMap.myQueriesUIMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class myQueries extends Baseclass {
	private Baseclass base;
	static SoftAssert sa = new SoftAssert();
	public myQueries() {
		
	}

	public myQueries(Baseclass base) {
		this.base = base;
	}

	public static String testDataPath = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "test" + File.separator + "resources" + File.separator + "testdata" + File.separator + "Jira"
			+ File.separator + "JSON" + File.separator;

	public static void createQuery(String toolName,String entityType,String workItemType)
	{
		try{
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		clickJS(myQueriesUIMap.NewQuery_text);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		String classAttribute_value = getAttribute(myQueriesUIMap.Standard_button,"class");
		sa.assertEquals(classAttribute_value.contains("active"), 1,"Standard query is not selected"); //Verify that Standard Query is selected by default
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		selectDropdownByText(myQueriesUIMap.Entity_dropdown,entityType); //Select the entity from entitytype dropdown
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		selectDropdownByText(myQueriesUIMap.workItemType_dropdown,workItemType); //Select the workitem from workitem dropdown
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		Thread.sleep(3000);
		clickJS(myQueriesUIMap.Field_txtBox);
		selectDropdownByValue(myQueriesUIMap.Field_dropdown,"Title"); //Select the Title attribute 
		Thread.sleep(2000);
		clickJS(myQueriesUIMap.Operator_txtBox);
		selectDropdownByText(myQueriesUIMap.Operator_dropdown,"Contains"); // Select the operator
		Thread.sleep(2000);
		enterText(myQueriesUIMap.value_txtbox1,"Automation"); 
		clickJS(myQueriesUIMap.RunQuery_button);
		//ExpWaitForCondition(myQueriesUIMap.recordsRetrieved_staticTxt); //Verify the toaster message
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		clickJS(myQueriesUIMap.SaveQuery_txt); //Save the query
		enterText(myQueriesUIMap.QueryName_txtbox,"Auto_Regression");
		clickJS(myQueriesUIMap.saveQuery_button);
		//ExpWaitForCondition(myQueriesUIMap.querySaved_txt);
		clickJS(myQueriesUIMap.navigateToQueries_txt);
		Thread.sleep(3000);
		ExpWaitForCondition(myQueriesUIMap.savedQuery_txt);
//		Assert.assertEquals(CheckIfElementExists(myQueriesUIMap.savedQuery_txt),true,"Query is not saved"); //Assert if the query is saved
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Creation of query failed");
			Assert.fail("Creation of query failed");
		}		
	}
	public static void editQuery()
	{
		try{
		clickJS(myQueriesUIMap.savedQuery_txt);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		Thread.sleep(5000);
		singleClick(myQueriesUIMap.NewClause_txt); //Adding a new clause
		Thread.sleep(4000);
		clickJS(myQueriesUIMap.conditionColumn_txt);
		Thread.sleep(2000);
		selectDropdownByText(myQueriesUIMap.conditionColumn_dropdown,"OR");
		Thread.sleep(2000);
		clickJS(myQueriesUIMap.Field_txtBox);
		Thread.sleep(2000);
		selectDropdownByValue(myQueriesUIMap.Field_dropdown,"Priority");
		Thread.sleep(2000);
		clickJS(myQueriesUIMap.value_txtbox2);
		Thread.sleep(2000);
		selectDropdownByValue(myQueriesUIMap.Value_dropdown,"Medium");
		clickJS(myQueriesUIMap.RunQuery_button);
		clickJS(myQueriesUIMap.SaveQuery_txt); //Resave the query
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		//ExpWaitForCondition(myQueriesUIMap.recordsRetrieved_staticTxt);
		clickJS(myQueriesUIMap.navigateToQueries_txt);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Edit of query failed");
			Assert.fail("Edit of query failed");
		}
	}
	public static void deleteQuery()
	{
		try{
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			singleClick(myQueriesUIMap.DeleteQuery_icon);
			singleClick(myQueriesUIMap.DeleteQueryYes_button);
			sa.assertEquals(CheckIfElementExists(myQueriesUIMap.savedQuery_txt), 0,"Issues deleting query"); //Assert to check that query is not available
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Deletion of query failed");
			Assert.fail("Deletion of query failed");
		}
	}

}