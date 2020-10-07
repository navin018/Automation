package testobjects;

import uiMap.DLMUIMap;
import uiMap.MyWizardUIMap;
import utilities.general.DataManager;

import static org.testng.Assert.assertEquals;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;

import dataobjects.DLMDO;
public class DLM extends Baseclass{
	private Baseclass base;
	
	public DLM()
	{
		
	}
	
	public DLM(Baseclass base) {
		this.base =base; 
	}
	 
	
	public static String testDataPath = System.getProperty("user.dir")
			+ File.separator + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator + "testdata" + File.separator + "DLM" + File.separator + "JSON" + File.separator ;
	
	public static void addTemplate(String Template){
		try{
		 DLMDO di = DataManager.getData(testDataPath, "DLM",DLMDO.class).item.get(Template);	
		 Random rnd = new Random();
			int randomNumb = 100 + rnd.nextInt(900);
			String templatename = di.Name+randomNumb;
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		click(DLMUIMap.addStageTemplate_Btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		enterText(DLMUIMap.StageName_Txtbox,templatename);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		selectDropdownByText(DLMUIMap.Entity_Drpdown, di.EntityType);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		click(DLMUIMap.typeDropDown_Drpdown);
		Thread.sleep(2000);
		prepareWebElementWithDynamicXpathAndClickJS(DLMUIMap.stageType_statictxt, di.Type1, "type1");
		Thread.sleep(1000);
		click(DLMUIMap.typeDropUp_Drpdown);
		enterText(DLMUIMap.stageName_txtbox,di.StageName);
		enterText(DLMUIMap.stageDescription_txtbox,di.Description);
		enterText(DLMUIMap.stageCompletion_txtbox,di.Completion);
		Thread.sleep(5000);
//		ExpWaitForElementToDisappear(By.xpath("//button[@class='btn btn-primary ng-star-inserted phx-disabled']"));
		highlight(DLMUIMap.save_btn);
		moveAndClick(DLMUIMap.save_btn,DLMUIMap.save_btn);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		enterText(DLMUIMap.SearchTemplateByName_txtbox,templatename);
		Thread.sleep(2000);
		assertEquals(getText(DLMUIMap.verifyAddedTemplate_btn), templatename);
		driver().close();
		driver().quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
