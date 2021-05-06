package testobjects;
import static org.testng.Assert.*;
import org.testng.Assert;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;

import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;
import utilities.general.Property;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import uiMap.DFTUIMap;
import uiMap.MyWizardMappingRuleUIMap;
import uiMap.MyWizardUIMap;
import uiMap.ProductConfigUIMap;
import uiMap.RMPUIMap;
import uiMap.SecurityTestsUIMap;
import utilities.selenium.DriverFactory;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
@SuppressWarnings("deprecation")
public class MyWizardHomePage {
	
	
	
	public	static void NavigateToHomePage() {
		
	try	{
		
		Thread.sleep(4000);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		Thread.sleep(1000);
		ExpWaitForElementToDisappear(MyWizardUIMap.DCMsg_StaticTxt);
		ExpWaitForCondition(MyWizardUIMap.SettingIcon_Image);
		click(MyWizardUIMap.SettingIcon_Image);
		click(MyWizardUIMap.AdminSetting_statictxt);
		//add windows switch code here
	
		ArrayList<String> tabs2 = new ArrayList<String> (driver().getWindowHandles());
		 driver().switchTo().window(tabs2.get(1));
		 Thread.sleep(6000);
		 waitPageToLoad();
		 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		 Thread.sleep(3000);
		 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		
		 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		 //mywizard works best on google chrome handled
		 if(CheckIfElementExists(MyWizardUIMap.MywizChromeNotification_btn1))
		 {
			 clickJS(MyWizardUIMap.MywizChromeNotification_btn1);
		 }
		//if creds are remebered but needs to be selected
//         String username = Property.getProperty("MyWizard_Username");
//         String[] username_sp = username.split("@");
		 if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccountnew_link, Property.getProperty("MyWizard_Username"), "username")))
		 {
			 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccountnew_link, Property.getProperty("MyWizard_Username"), "username"));
				Thread.sleep(5000);
		 }
//         if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccount1_link, username_sp[0], "username")))
//         {
//             clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccount1_link, username_sp[0], "username"));
//         }
         
         ExpWaitForCondition(MyWizardUIMap.scopeSelector_drpdown);
         Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue loading home page");
			Assert.fail("Issue loading home page");
		}
		}
	
	public static void SelectOnlyClient(){
		
		try{
//			DriverFactory.proxy.start();
			 
					 

			//code for AI fusion page	
			
//			ArrayList<String> tabs = new ArrayList<String> (driver().getWindowHandles());
//			 driver().switchTo().window(tabs.get(0));
//			 click(MyWizardUIMap.SettingIcon_Image);
//			 click(MyWizardUIMap.AdminSetting_statictxt);
//			 waitPageToLoad();
//			 Thread.sleep(10000);
//			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			 String parentWindowHandle = driver().getWindowHandle();
//			 driver().switchTo().window(parentWindowHandle);
//			 
//
//			 ArrayList<String> tabs1 = new ArrayList<String> (driver().getWindowHandles());
//			 
//			 driver().switchTo().window(tabs1.get(2));
			 
			//code for AI fusion page
			 
			 
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			highlight(MyWizardUIMap.scopeSelector_drpdown);
			 clickJS(MyWizardUIMap.scopeSelector_drpdown);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 enterText(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox,Property.getProperty("MyWizard_Client"));
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 Thread.sleep(2000);
			 if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt,Property.getProperty("MyWizard_Client"),"clientname")))
			 { 
				 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt,Property.getProperty("MyWizard_Client"),"clientname"));
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//				 clear(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox);
			 }
			 else
			 Assert.fail("Mentioned client "+Property.getProperty("MyWizard_Client")+"doesnt exists");
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			waitPageToLoad();
			click(MyWizardUIMap.apply_btn);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 
			 
			// Write HAR Data in a File
//			 DriverFactory.proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//			 DriverFactory.proxy.newHar("test");
//			 Har har = DriverFactory.proxy.getHar();
//				File harFile = new File("C:\\Users\\sonal.harish.nagda\\SeleniumEasy2.har");
//				try {
//					har.writeTo(harFile);
//					DriverFactory.proxy.stop();
//				} catch (IOException ex) {
//					 System.out.println (ex.toString());
//				     System.out.println("Could not find file ");
//				}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Issue selecting client");
		}
	
	}
	public static void SelectClientAndDC(){
		try{
			
			
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 clickJS(MyWizardUIMap.scopeSelector_drpdown);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 enterText(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox,Property.getProperty("MyWizard_Client"));
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 Thread.sleep(2000);
			 if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt,Property.getProperty("MyWizard_Client"),"clientname")))
			 { 
				 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt,Property.getProperty("MyWizard_Client"),"clientname"));
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//				 clear(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox);
			 }
			 else
			 Assert.fail("Mentioned client "+Property.getProperty("MyWizard_Client")+"doesnt exists");
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			waitPageToLoad();
//			if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt,DC,"dcname")))
			if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt,Property.getProperty("MyWizard_DC_L1"),"dcname")))
			{
				clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt,Property.getProperty("MyWizard_DC_L1"),"dcname"));
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			}
			else
				 Assert.fail("Mentioned client "+Property.getProperty("MyWizard_DC_L1")+"doesnt exists");
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 if(!Property.getProperty("MyWizard_DC_L2").equalsIgnoreCase("NA"))
			 {
				 if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectProgram_statictxt,Property.getProperty("MyWizard_DC_L2"),"programname")))
				 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectProgram_statictxt,Property.getProperty("MyWizard_DC_L2"),"programname"));
//				clickJS(prepareWebElementWithDynamicXpath2(MyWizardUIMap.SelectProgram_statictxt,DC,Program,"dcname","programname"));
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 }
		
			waitPageToLoad();
			click(MyWizardUIMap.apply_btn);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue selecting client or DC");
			Assert.fail("Issue selecting client or DC");
		}
	}
	
	public static void SelectClientAndDCForRMP(){
		try{
			
			
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 clickJS(MyWizardUIMap.scopeSelector_RMP_drpdown);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 enterText(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox,Property.getProperty("MyWizard_Client"));
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 Thread.sleep(2000);
			 if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt_RMP,Property.getProperty("MyWizard_Client"),"clientname")))
			 { 
				 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt_RMP,Property.getProperty("MyWizard_Client"),"clientname"));
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//				 clear(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox);
			 }
			 else
			 Assert.fail("Mentioned client "+Property.getProperty("MyWizard_Client")+"doesnt exists");
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			waitPageToLoad();
//			if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt,DC,"dcname")))
			if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt_RMP,Property.getProperty("MyWizard_DC_L1"),"dcname")))
			{
				clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt_RMP,Property.getProperty("MyWizard_DC_L1"),"dcname"));
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			}
			else
				 Assert.fail("Mentioned client "+Property.getProperty("MyWizard_DC_L1")+"doesnt exists");
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 if(!Property.getProperty("MyWizard_DC_L2").equalsIgnoreCase("NA"))
			 {
				 if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectProgram_statictxt_RMP,Property.getProperty("MyWizard_DC_L2"),"programname")))
				 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectProgram_statictxt_RMP,Property.getProperty("MyWizard_DC_L2"),"programname"));
//				clickJS(prepareWebElementWithDynamicXpath2(MyWizardUIMap.SelectProgram_statictxt,DC,Program,"dcname","programname"));
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 }
		
			waitPageToLoad();
			click(MyWizardUIMap.apply_btn);
			Thread.sleep(60000);
			if(!CheckIfElementExists(RMPUIMap.CreateNewRodMap_link))
			{
				refresh();
				clickJS(MyWizardUIMap.scopeSelector_RMP_drpdown);
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				 enterText(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox,Property.getProperty("MyWizard_Client"));
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				 Thread.sleep(2000);
				 if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt_RMP,Property.getProperty("MyWizard_Client"),"clientname")))
				 { 
					 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt_RMP,Property.getProperty("MyWizard_Client"),"clientname"));
					 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//					 clear(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox);
				 }
				 else
				 Assert.fail("Mentioned client "+Property.getProperty("MyWizard_Client")+"doesnt exists");
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				waitPageToLoad();
//				if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt,DC,"dcname")))
				if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt_RMP,Property.getProperty("MyWizard_DC_L1"),"dcname")))
				{
					clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt_RMP,Property.getProperty("MyWizard_DC_L1"),"dcname"));
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				}
				else
					 Assert.fail("Mentioned client "+Property.getProperty("MyWizard_DC_L1")+"doesnt exists");
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				 if(!Property.getProperty("MyWizard_DC_L2").equalsIgnoreCase("NA"))
				 {
					 if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectProgram_statictxt_RMP,Property.getProperty("MyWizard_DC_L2"),"programname")))
					 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectProgram_statictxt_RMP,Property.getProperty("MyWizard_DC_L2"),"programname"));
//					clickJS(prepareWebElementWithDynamicXpath2(MyWizardUIMap.SelectProgram_statictxt,DC,Program,"dcname","programname"));
					 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				 }
			
				waitPageToLoad();
				click(MyWizardUIMap.apply_btn);
			}
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue selecting client or DC");
			Assert.fail("Issue selecting client or DC");
		}
	}
	
	public static void SelectClientAndDCForPipelines(){
		try{
			
			
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 clickJS(MyWizardUIMap.scopeSelector_drpdown);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 enterText(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox,Property.getProperty("MyWizard_Client"));
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 Thread.sleep(2000);
			 if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt,Property.getProperty("MyWizard_Client"),"clientname")))
			 { 
				 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectClient_statictxt,Property.getProperty("MyWizard_Client"),"clientname"));
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//				 clear(MyWizardUIMap.ScopeSelectorEnterTxt_txtbox);
			 }
			 else
			 Assert.fail("Mentioned client "+Property.getProperty("MyWizard_Client")+"doesnt exists");
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			waitPageToLoad();
//			if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt,DC,"dcname")))
			if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt,Property.getProperty("MyWizard_DC_L1_ForPipeline"),"dcname")))
			{
				clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectDC_statictxt,Property.getProperty("MyWizard_DC_L1_ForPipeline"),"dcname"));
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			}
			else
				 Assert.fail("Mentioned client "+Property.getProperty("MyWizard_DC_L1")+"doesnt exists");
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 if(!Property.getProperty("MyWizard_DC_L2").equalsIgnoreCase("NA"))
			 {
				 if(isVisible(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectProgram_statictxt,Property.getProperty("MyWizard_DC_L2_ForPipeline"),"programname")))
				 clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.SelectProgram_statictxt,Property.getProperty("MyWizard_DC_L2_ForPipeline"),"programname"));
//				clickJS(prepareWebElementWithDynamicXpath2(MyWizardUIMap.SelectProgram_statictxt,DC,Program,"dcname","programname"));
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 }
		
			waitPageToLoad();
			click(MyWizardUIMap.apply_btn);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue selecting client or DC");
			Assert.fail("Issue selecting client or DC");
		}
	}
	
	public	static void clickOnTile(String tile) {
		try{
			Thread.sleep(5000);
			waitPageToLoad();
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
	    	ExpWaitForCondition(prepareWebElementWithDynamicXpath(MyWizardUIMap.Tile_statictxt,tile,"tilename"));
	    	ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
	    	clickJS((prepareWebElementWithDynamicXpath(MyWizardUIMap.Tile_statictxt,tile,"tilename")));
	    	 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
	    	waitPageToLoad();
		}
		   catch(Exception e)
	    {
			   logger.info("Either tile "+tile+" not found or issue loading the tile");
	    	Assert.fail("Either tile "+tile+" not found or issue loading the tile");
	  
	    	e.printStackTrace();
	    }
	}

	public static void VerifyIfTileisLoaded(String TilePageName) throws Exception {
		switch(TilePageName){
		case "Product Configuration":
		
		case "Organization (Delivery) Structure Type":
		case "AppServices Configuration":
		case "Team Configuration":
		case "Access Role":
		
		case "Client Configuration":
		case "Iteration Reconciliation":
		case "Event & Notification":
			
		
				try{
				ExpWaitForCondition(ProductConfigUIMap.searchBox_txtbox);
					}
				catch(Exception e)
					{
					e.printStackTrace();
					throw new Exception("Could you not load page : "+TilePageName, e);
					}
		break;
		case "Lifecycle Template Configuration":
			
			try{
			ExpWaitForCondition(ProductConfigUIMap.LifecycletemplateConfig_statictxt);
				}
			catch(Exception e)
				{
				e.printStackTrace();
				throw new Exception("Could you not load page : "+TilePageName, e);
				}
	break;
	case "Account Management":
			
			try{
			ExpWaitForCondition(MyWizardUIMap.Search_txtbox);
				}
			catch(Exception e)
				{
				e.printStackTrace();
				throw new Exception("Could you not load page : "+TilePageName, e);
				}
	break;
		case "Dataflow Tracking":
			try{
				ExpWaitForCondition(DFTUIMap.Filter_Icon);
					}
				catch(Exception e)
					{
					e.printStackTrace();
					throw new Exception("Could you not load page : "+TilePageName, e);
					}
		break;
			
	case "DIY AD Automation":
			
			try{
			ExpWaitForCondition(ProductConfigUIMap.ContractOnBoarding_statictxt);
			Thread.sleep(2000);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				}
			catch(Exception e)
				{
				e.printStackTrace();
				throw new Exception("Could you not load page : "+TilePageName, e);
				}
	break;

		case "my Queries":

			try{
			ExpWaitForCondition(SecurityTestsUIMap.MyQueries_statictxt);
				}
			catch(Exception e)
				{
				e.printStackTrace();
				throw new Exception("Could you not load page : "+TilePageName, e);
				}
			break;
			
		case "Data Upload":

			try{
			ExpWaitForCondition(SecurityTestsUIMap.DataUpload_statictxt);
				}
			catch(Exception e)
				{
				e.printStackTrace();
				throw new Exception("Could you not load page : "+TilePageName, e);
				}
			break;
			
		case "Generic Uploader":

			try{
			ExpWaitForCondition(SecurityTestsUIMap.GenericUploader_statictxt);
				}
			catch(Exception e)
				{
				e.printStackTrace();
				throw new Exception("Could you not load page : "+TilePageName, e);
				}
			break;
			
		case "Metrics Engine":

			try{
			ExpWaitForCondition(SecurityTestsUIMap.MetricsEngine_statictxt);
				}
			catch(Exception e)
				{
				e.printStackTrace();
				throw new Exception("Could you not load page : "+TilePageName, e);
				}
			break;
			
		case "Virtual Assistant":

			try{
				Thread.sleep(5000);
			ExpWaitForCondition(SecurityTestsUIMap.VirtualAgents_statictxt);
				}
			catch(Exception e)
				{
				e.printStackTrace();
				throw new Exception("Could you not load page : "+TilePageName, e);
				}
			break;
		case "Product Instance Entity Rule Config":

			try{
				Thread.sleep(5000);
			ExpWaitForCondition(SecurityTestsUIMap.Search_txtbox);
				}
			catch(Exception e)
				{
				e.printStackTrace();
				throw new Exception("Could you not load page : "+TilePageName, e);
				}
			break;
	default:
		
		}
		
	}

	
	
	
	
	
	
	
}
