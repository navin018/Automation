package testobjects;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Practice.softassert;
import uiMap.DFTUIMap;
import uiMap.DIYUIMap;
import uiMap.DLMUIMap;
import uiMap.MyWizardUIMap;
import utilities.general.DataManager;
import utilities.general.Property;

import static org.testng.Assert.assertEquals;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dataobjects.DLMDO;

public class DFT extends Baseclass{
	private Baseclass base;
	
	public DFT()
	{
		
	}
	
	public DFT(Baseclass base) {
		this.base =base; 
	}
	 
	
	public static String testDataPath = System.getProperty("user.dir")
			+ File.separator + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator + "testdata" + File.separator + "DLM" + File.separator + "JSON" + File.separator ;

	public static void CheckIBOBDetails(String inboundOrOutbound, String toolname) {
		try{
			applyfilters();

		    Thread.sleep(2000);
		    ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		    if(inboundOrOutbound.equalsIgnoreCase("inbound")){
		    	clickJS(DFTUIMap.Searchbox_txtbox);
		    	enterText(DFTUIMap.Searchbox_txtbox,Baseclass.getInstance().CorrelationUID);
		    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		    	verifyDetailedDFTFlow(inboundOrOutbound,toolname,Baseclass.getInstance().CorrelationUID);
		    	
		
		    }
		    else if(inboundOrOutbound.equalsIgnoreCase("outbound"))
		    {
		    	clickJS(DFTUIMap.Searchbox_txtbox);
		    	enterText(DFTUIMap.Searchbox_txtbox, Baseclass.getInstance().CorrelationUID_OB);
		    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		    	verifyDetailedDFTFlow(inboundOrOutbound,toolname,Baseclass.getInstance().CorrelationUID_OB);
		    }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void applyfilters() {
		clickJS(DFTUIMap.Filter_Icon);
		clickJS(DFTUIMap.processed_checkbox);
		
		//start date
		clickJS(DFTUIMap.startDate_DatePicker);
		selectDropdownByText(DFTUIMap.SelectMonth_Drpdown, Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())); ;
		
		Date today = new Date();Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		clickJS(prepareWebElementWithDynamicXpath(DFTUIMap.StartDate_DayOfMonth, String.valueOf(dayOfMonth-1), "day"));

		//end date			
		clickJS(DFTUIMap.EndDate_DatePicker);
		selectDropdownByText(DFTUIMap.SelectMonth_Drpdown, Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())); ;
		clickJS(prepareWebElementWithDynamicXpath(DFTUIMap.EndDate_DayOfMonth, String.valueOf(dayOfMonth), "day"));
		
		
    
	    clickJS(DFTUIMap.Apply_btn);
	    ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		
	}

	public static void verifyDetailedDFTFlow(String inboundOrOutbound,String toolname,String CorrelationUID) {
    	try{
    		SoftAssert sa = new SoftAssert();
    		
//    	ExpWaitForCondition(prepareWebElementWithDynamicXpath(DFTUIMap.SearchResultForGivenCorrelationUID_txt, Baseclass.getInstance().CorrelationUID, "CorrelationUId"));
    		if(!CheckIfElementExists(prepareWebElementWithDynamicXpath(DFTUIMap.SearchResultForGivenCorrelationUID_txt, CorrelationUID, "CorrelationUId")))
    		{
    			Assert.fail("the workitem is not showing up in the DFT tile for toolname "+toolname);
    		}
    	singleClick(DFTUIMap.ActionWorkitem_icon);
    	Thread.sleep(3000);
    	List<WebElement> icons = driver().findElements(DFTUIMap.DFTIcons_icons);
    	System.out.println(icons.size());
    	for(WebElement icon:icons)
    	{
    		System.out.println(icon.getAttribute("style"));
    		sa.assertEquals(icon.getAttribute("style"), "fill: rgb(78, 175, 78);","one of the icons in the DFT tile is not green for "+inboundOrOutbound+" flow");
    	}
    	

    	if(inboundOrOutbound.equalsIgnoreCase("inbound"))
    	{
        	sa.assertEquals(icons.size(), 5, "one of the systems missing for the ibound flow in the DFT diagram");

			    	if(!CheckIfElementExists(DFTUIMap.Jira_icon))
					{
						sa.assertEquals(true, false, "tool name not shown in detailed flow diagram for "+toolname);
					}
					if(!CheckIfElementExists(DFTUIMap.myWizardGatewayManager_icon))
					{
						sa.assertEquals(true, false, "myWizardGatewayManager icon not shown in detailed flow diagram for "+toolname);
					}
					if(!CheckIfElementExists(DFTUIMap.myWizardENS1_icon))
					{
						sa.assertEquals(true, false, "myWizardENS icon not shown in detailed flow diagram for "+toolname);
					}
					if(!CheckIfElementExists(DFTUIMap.myWizard_icon))
					{
						sa.assertEquals(true, false, "myWizard icon not shown in detailed flow diagram for "+toolname);
					}
					if(!CheckIfElementExists(DFTUIMap.myWizardENS2_icon))
					{
						sa.assertEquals(true, false, "myWizardENS icon not shown in detailed flow diagram for "+toolname);
					}
					
			    			    	
					sa.assertAll();
			    	clickJS(DFTUIMap.closeDFTdetailedWindow_btn);
			    	clickJS(DFTUIMap.Searchbox_txtbox);
			    	clear(DFTUIMap.Searchbox_txtbox);
			    	clickJS(DFTUIMap.SearchAll_Icon);
			    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			    	Thread.sleep(2000);
			    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
	

    	}
    	else if(inboundOrOutbound.equalsIgnoreCase("outbound"))
    	{
        	sa.assertEquals(icons.size(), 4);
    		
    		if(!CheckIfElementExists(DFTUIMap.myWizardRequirementsManagement_icon))
			{
				sa.assertEquals(true, false, "myWizardRequirementsManagement icon not shown in detailed flow diagram for OB for "+toolname);
			}
    		if(!CheckIfElementExists(DFTUIMap.myWizard_icon))
			{
				sa.assertEquals(true, false, "myWizard icon not shown in detailed flow diagram for OB for "+toolname);
			}
    		if(!CheckIfElementExists(DFTUIMap.myWizardENS1_icon))
			{
				sa.assertEquals(true, false, "myWizardENS icon not shown in detailed flow diagram for OB for "+toolname);
			}
    		if(!CheckIfElementExists(DFTUIMap.myWizardGatewayManager_icon))
			{
				sa.assertEquals(true, false, "myWizardGatewayManager icon not shown in detailed flow diagram for "+toolname);
			}
    		if(!CheckIfElementExists(DFTUIMap.Jira_icon))
			{
				sa.assertEquals(true, false, "Jira icon not shown in detailed flow diagram for "+toolname);
			}
    		sa.assertAll();

    	}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		logger.info("either workitem not flown or the given workitem is not shown up in the DFT tile for the tool "+toolname);
    		Assert.fail("either workitem not flown or the given workitem is not shown up in the DFT tile for the tool "+toolname);
    	}
		
	}

		
}
