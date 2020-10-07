package testobjects;

import static utilities.selenium.SeleniumDSL.DragAndDrop;
import static utilities.selenium.SeleniumDSL.ExpWaitForCondition;
import static utilities.selenium.SeleniumDSL.ExpWaitForElementToDisappear;
import static utilities.selenium.SeleniumDSL.*;


import java.util.ArrayList;
import java.util.Random;

import org.testng.Assert;

import uiMap.MyWizardUIMap;
import uiMap.RMPUIMap;

public class RMP extends Baseclass{
	private Baseclass base;
	
	public RMP()
	{
		
	}
	
	public RMP(Baseclass base) {
		this.base =base; 
	} 
	
	public static void NavigateToRMPPage()
	{
		try{
			click(RMPUIMap.MyWizardHome_Img);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   waitPageToLoad();
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   Thread.sleep(3000);
			   waitPageToLoad();
			   ExpWaitForCondition(RMPUIMap.BizDevops_Statictxt);
			   ExpWaitForCondition(RMPUIMap.ProgramPlanning_Img);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   singleClick(RMPUIMap.ProgramPlanning_Img);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   
			   singleClick(RMPUIMap.LivingRoadmap_Img);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   ExpWaitForCondition(RMPUIMap.LaunchRoadMapApp_Statictxt);
			   singleClick(RMPUIMap.LaunchRoadMapApp_Statictxt);
			   Thread.sleep(15000);
			  
			   ArrayList<String> tabs2 = new ArrayList<String> (driver().getWindowHandles());
				 driver().switchTo().window(tabs2.get(2));
				 ExpWaitForElementToDisappear(RMPUIMap.LoadingPleaseWait_msg);
				  ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   ExpWaitForCondition(RMPUIMap.RA_link);
			   waitPageToLoad();
			 	Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Could not load RMP page");
		}
		
	}

	public static void AddReleaseAndSprint(){
		try{
			
			  clickJS(RMPUIMap.New_link);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   clickJS(RMPUIMap.Blank_link);
			   Thread.sleep(2000);
			   DragAndDrop(RMPUIMap.AddInititave_link,RMPUIMap.DropInitiative_box);
			   Thread.sleep(3000);
			   ExpWaitForCondition(RMPUIMap.DropRelease_box);
			   DragAndDrop(RMPUIMap.AddRelease_link,RMPUIMap.DropRelease_box);
			   Thread.sleep(3000);
			   ExpWaitForCondition(RMPUIMap.DropSprint_box);
			   DragAndDrop(RMPUIMap.AddSprint_link,RMPUIMap.DropSprint_box);
			   Thread.sleep(2000);
			   click(RMPUIMap.closeRoadMapMenu_btn);
			   click(RMPUIMap.EditInitiave_btn);
			   click(RMPUIMap.EditInitiave_link);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   
			   Random rnd = new Random();
				int randomNumb = 1000 + rnd.nextInt(9000);	
				
				enterText(RMPUIMap.InitiaveName_txtbox, "Initiative"+randomNumb);
				click(RMPUIMap.Apply_btn);
				
				   click(RMPUIMap.EditRelease_btn);
				   Thread.sleep(2000);
				   click(RMPUIMap.EditRelease_link);
				   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				   enterText(RMPUIMap.ReleaseName_txtbox, "Release"+randomNumb);
				   String releasename = "Release"+randomNumb;
				   String releaseStartAndEndDate = getAttribute(RMPUIMap.ReleaseStartAndEndDate_txt,"title");
				   String[] rsd =  releaseStartAndEndDate.split("\\[");
				   String[] rsd1 = rsd[1].split("-");
				   System.out.println(rsd1[0].trim());
				   String[] red =  releaseStartAndEndDate.split("-");
				   String[] red1 = red[1].trim().split("\\]");
				   System.out.println(red1[0]);
				   String releasestartdate = rsd1[0].trim();
				   String releaseenddate =  red1[0];
				   click(RMPUIMap.Apply_btn);
					
				   clickJS(RMPUIMap.EditSprint_btn);
				   click(RMPUIMap.EditSprint_link);
				   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				   clear(RMPUIMap.SprintName_txtbox);
				   enterText(RMPUIMap.SprintName_txtbox, "Sprint"+randomNumb);
				   String Sprintname = "Sprint"+randomNumb;
				   String SprintStartAndEndDate = getAttribute(RMPUIMap.SprintStartAndEndDate,"title");
				   String[] ssd =  SprintStartAndEndDate.split("\\[");
				   String[] ssd1 = ssd[1].split("-");
				   System.out.println(ssd1[0].trim());
				   String[] sed =  SprintStartAndEndDate.split("-");
				   String[] sed1 = sed[1].trim().split("\\]");
				   System.out.println(sed1[0]);
				   String Sprintstartdate = ssd1[0].trim();
				   String Sprintenddate =  sed1[0];
				   click(RMPUIMap.SprintType_drpdown);
				   Thread.sleep(1000);
					clickJS(RMPUIMap.SprintTypeValue_drpdown);
					click(RMPUIMap.Apply_btn);
					Thread.sleep(2000);
					click(RMPUIMap.SaveBaseline_btn);
					enterText(RMPUIMap.RoadMapTitle_txtbox,"RoadMap"+randomNumb);
					click(RMPUIMap.Apply_btn);
					click(RMPUIMap.SaveBaseline_btn);
					click(RMPUIMap.Apply_btn);
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//						 ExpWaitForCondition(RMPUIMap.RoadMapUpdated_msg);
					Baseclass.getInstance().RMP_ReleaseName = releasename;
					Baseclass.getInstance().RMP_ReleaseStartDate=releasestartdate;
					Baseclass.getInstance().RMP_ReleaseEndDate=releaseenddate;
					Baseclass.getInstance().RMP_SprintName=Sprintname;
					Baseclass.getInstance().RMP_SprintStartDate=Sprintstartdate;
					Baseclass.getInstance().RMP_SprintEndDate=Sprintenddate;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Problem adding release and sprint");
			
		}
	}
	public static void BaselineRoadMap(){
		try{
			click(RMPUIMap.BaseLine_link);
			 click(RMPUIMap.Baseline_Alert);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 click(RMPUIMap.Apply_btn);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 ExpWaitForCondition(RMPUIMap.BaselineSaved_msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Problem baselining the roadmap created");
			
		}
	}
	
}
