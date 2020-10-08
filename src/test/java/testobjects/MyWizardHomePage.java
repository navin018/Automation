package testobjects;
import static org.testng.Assert.*;
import org.testng.Assert;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;

import static utilities.selenium.SeleniumDSL.*;
import utilities.general.Property;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import uiMap.MyWizardMappingRuleUIMap;
import uiMap.MyWizardUIMap;

import utilities.selenium.DriverFactory;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
@SuppressWarnings("deprecation")
public class MyWizardHomePage {
	
	
	
	public	static void NavigateToHomePage() {
		
	try	{
		
		Thread.sleep(4000);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ExpWaitForElementToDisappear(MyWizardUIMap.DCMsg_StaticTxt);
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
		 
		//if creds are remebered but needs to be selected
         String username = Property.getProperty("MyWizard_Username");
         String[] username_sp = username.split("@");
         if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccount1_link, username_sp[0], "username")))
         {
             clickJS(prepareWebElementWithDynamicXpath(MyWizardUIMap.PickAnAccount1_link, username_sp[0], "username"));
         }
         
         ExpWaitForCondition(MyWizardUIMap.scopeSelector_drpdown);
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
			
//			ExpWaitForCondition(MyWizardUIMap.scopeSelector_drpdown);
//			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//			 
//			 String DC = Property.getProperty("MyWizard_DC_L1");
//			 String Program =  Property.getProperty("MyWizard_DC_L2");
//			 if(!DC.equalsIgnoreCase("NA"))
//				 DC = " "+DC.trim()+" ";
//			 if(!Program.equalsIgnoreCase("NA"))
//				 Program = " "+Program.trim()+" ";
			
			
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
	    	Assert.fail("Either tile "+tile+" not found or issue loading the tile");
	  
	    	e.printStackTrace();
	    }
	}

	
	
	
	
	
	
	
}
