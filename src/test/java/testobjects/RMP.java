package testobjects;

import static utilities.selenium.SeleniumDSL.DragAndDrop;
import static utilities.selenium.SeleniumDSL.RandomNumberGenerator;
import static utilities.selenium.SeleniumDSL.ExpWaitForCondition;
import static utilities.selenium.SeleniumDSL.ExpWaitForElementToDisappear;
import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
			click(RMPUIMap.AssetsView_btn);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   waitPageToLoad();
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   waitPageToLoad();
			   ExpWaitForCondition(RMPUIMap.ProgramPlanning_Img);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   singleClick(RMPUIMap.ProgramPlanning_Img);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   
			   singleClick(RMPUIMap.LivingRoadmap_Img);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   ExpWaitForCondition(RMPUIMap.LaunchRoadMapApp_Statictxt);
			   singleClick(RMPUIMap.LaunchRoadMapApp_Statictxt);
			   Thread.sleep(30000);
			  
			   ArrayList<String> tabs2 = new ArrayList<String> (driver().getWindowHandles());
				 driver().switchTo().window(tabs2.get(1));
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

	public static void AddReleaseAndSprint(String typeofrecon,String toolname){
		try{
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			  clickJS(RMPUIMap.New_link);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   clickJS(RMPUIMap.Blank_link);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   DragAndDrop(RMPUIMap.AddInititave_link,RMPUIMap.DropInitiative_box);
			   Thread.sleep(5000);
			   ExpWaitForCondition(RMPUIMap.DropRelease_box);
			   DragAndDrop(RMPUIMap.AddRelease_link,RMPUIMap.DropRelease_box);
			   Thread.sleep(5000);
			   ExpWaitForCondition(RMPUIMap.DropSprint_box);
			   DragAndDrop(RMPUIMap.AddSprint_link,RMPUIMap.DropSprint_box);
			   Thread.sleep(5000);
			   click(RMPUIMap.closeRoadMapMenu_btn);
			   click(RMPUIMap.InitiativeEditOptions_btn);
//			   click(RMPUIMap.EditInitiave_btn);
			   click(RMPUIMap.EditInitiave_link);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   
			   
			   //initiave, release and sprint details here
			   String InitiaveName="";
			   String releasename="";
			   String releaseStartAndEndDate="";
			   String releasestartdate="";
			   String releaseenddate="";
			   String sprintname="";
			   String sprintstartdate = "";
			   String sprintenddate =  "";
			   
			   Random rnd = new Random();
				int randomNumb = 1000 + rnd.nextInt(9000);
				
				//get release and sprint details
				  String releasedetails = GetReleaseAndSprintDetails("Release", toolname);
				   releasename=releasedetails.split("&")[0];
				   releasestartdate=releasedetails.split("&")[1];
				   releaseenddate=releasedetails.split("&")[2];
				   String sprintdetails = GetReleaseAndSprintDetails("Sprint", toolname);
				   sprintname=sprintdetails.split("&")[0];
				   sprintstartdate=sprintdetails.split("&")[1].split(" ")[0];
				   sprintenddate=sprintdetails.split("&")[2].split(" ")[0];
				   
				   
				//if the type of recon is AutoRecon, then get the release and sprint details from workitemexternalIDs which has details of the release/sprint created in the tool
			   if(typeofrecon.equalsIgnoreCase("AutoRecon")){
				   InitiaveName= "Initiative"+randomNumb;
				 
			   }
			   else if(typeofrecon.equalsIgnoreCase("ManualRecon")){
				   InitiaveName= "Initiative"+randomNumb;
//				   releasename=releasename+"_"+randomNumb;
//				   sprintname=sprintname+"_"+randomNumb;
			   }
			
				//enter initiative name
				enterText(RMPUIMap.InitiaveName_txtbox, InitiaveName);
				enterText(RMPUIMap.InitiaveDescription_txtbox, InitiaveName);
				clear(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox);
				enterText(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox, "01/01/2019");
				clear(RMPUIMap.ReleaseOrSprintEndDate_txtbox);
				enterText(RMPUIMap.ReleaseOrSprintEndDate_txtbox, "31/03/2022");
				click(RMPUIMap.Apply_btn);
				ExpWaitForCondition(RMPUIMap.proceed_btn);
				clickJS(RMPUIMap.proceed_btn);
				 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				   
				//enter release details
			clickJS(RMPUIMap.ReleaseEditOptions_btn);
			Thread.sleep(2000);
			click(RMPUIMap.EditRelease_link);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
//				   String releasename = "Release"+randomNumb;
			//name of the release same as tool release name for auto and append with random number if manualrecon
			if(typeofrecon.equalsIgnoreCase("AutoRecon"))
			{
				enterText(RMPUIMap.ReleaseName_txtbox, releasename);
				enterText(RMPUIMap.ReleaseDescription_txtbox, releasename);
				
			}
			else if(typeofrecon.equalsIgnoreCase("ManualRecon")){
				enterText(RMPUIMap.ReleaseName_txtbox, releasename+"_"+randomNumb);
				enterText(RMPUIMap.ReleaseDescription_txtbox, releasename+"_"+randomNumb);
			}
			
			if(toolname.contains("Jira") || toolname.contains("JIRA")){
				releasestartdate = CommonFunctions.convertdatetogivenformat(releasestartdate,"d/MMM/yy","dd/MM/yyyy");
				releaseenddate = CommonFunctions.convertdatetogivenformat(releaseenddate,"d/MMM/yy","dd/MM/yyyy");
				}
				if(toolname.contains("TFS"))
				{
					releasestartdate = CommonFunctions.convertdatetogivenformat(releasestartdate,"MM/dd/yyyy","dd/MM/yyyy");
					releaseenddate = CommonFunctions.convertdatetogivenformat(releaseenddate,"MM/dd/yyyy","dd/MM/yyyy");
				}
				
			clear(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox);
			enterText(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox,releasestartdate);
			clear(RMPUIMap.ReleaseOrSprintEndDate_txtbox);
			enterText(RMPUIMap.ReleaseOrSprintEndDate_txtbox,releaseenddate);
			click(RMPUIMap.Apply_btn);
			ExpWaitForCondition(RMPUIMap.proceed_btn);
			clickJS(RMPUIMap.proceed_btn);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
			if (CheckIfElementExists(RMPUIMap.proceed_btn))
				clickJS(RMPUIMap.proceed_btn);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
			//sprint details
			clickJS(RMPUIMap.SprintEditOptions_btn);
			click(RMPUIMap.EditSprint_link);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clear(RMPUIMap.SprintName_txtbox);
			//name of the sprint same as tool release name for auto and append with random number if manualrecon
			if(typeofrecon.equalsIgnoreCase("AutoRecon"))
			{
				enterText(RMPUIMap.SprintName_txtbox, sprintname);
				enterText(RMPUIMap.SprintDescription_txtbox, sprintname);
				
			}
			else if(typeofrecon.equalsIgnoreCase("ManualRecon")){
				enterText(RMPUIMap.SprintName_txtbox, sprintname+"_"+randomNumb);
				enterText(RMPUIMap.SprintDescription_txtbox, sprintname+"_"+randomNumb);
			}
			
			if(toolname.contains("Jira") || toolname.contains("JIRA")){
				sprintstartdate = CommonFunctions.convertdatetogivenformat(sprintstartdate,"d/MMM/yy","dd/MM/yyyy");
				sprintenddate = CommonFunctions.convertdatetogivenformat(sprintenddate,"d/MMM/yy","dd/MM/yyyy");
				}
				if(toolname.contains("TFS"))
				{
					sprintstartdate = CommonFunctions.convertdatetogivenformat(sprintstartdate,"MM/dd/yyyy","dd/MM/yyyy");
					sprintenddate = CommonFunctions.convertdatetogivenformat(sprintenddate,"MM/dd/yyyy","dd/MM/yyyy");
				}
				
			 click(RMPUIMap.SprintType_drpdown);
			   Thread.sleep(1000);
				clickJS(RMPUIMap.SprintTypeValue_drpdown);
				clear(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox);
				enterText(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox,sprintstartdate);
				clear(RMPUIMap.ReleaseOrSprintEndDate_txtbox);
				enterText(RMPUIMap.ReleaseOrSprintEndDate_txtbox,sprintenddate);
				
				click(RMPUIMap.Apply_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				clickJS(RMPUIMap.SaveBaseline_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				
				enterText(RMPUIMap.RoadMapTitle_txtbox,"RoadMap"+randomNumb);
				click(RMPUIMap.Apply_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				click(RMPUIMap.SaveBaseline_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				click(RMPUIMap.Save_btn);
				ExpWaitForCondition(RMPUIMap.RoadmapSaved_successMsg);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//					 ExpWaitForCondition(RMPUIMap.RoadMapUpdated_msg);
				if(typeofrecon.equalsIgnoreCase("ManualRecon")){
				Baseclass.getInstance().RMP_ReleaseName = releasename;
				Baseclass.getInstance().RMP_SprintName=sprintname;
				}
//				Baseclass.getInstance().RMP_ReleaseStartDate=releasestartdate;
//				Baseclass.getInstance().RMP_ReleaseEndDate=releaseenddate;

//				Baseclass.getInstance().RMP_SprintStartDate=sprintstartdate;
//				Baseclass.getInstance().RMP_SprintEndDate=sprintenddate;
//				 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Problem adding release and sprint");
			
		}
	}

	public static void AddReleaseAndSprint1(String typeofrecon,String toolname){
		try{
			
			   //fetch release and sprint details
			   String InitiaveName="";
			   String releasename="";
			   String releaseStartAndEndDate="";
			   String releasestartdate="";
			   String releaseenddate="";
			   String sprintname="";
			   String sprintstartdate = "";
			   String sprintenddate =  "";
			   
			   Random rnd = new Random();
				int randomNumb = 1000 + rnd.nextInt(9000);
				
				//get release and sprint details
				  String releasedetails = GetReleaseAndSprintDetails("Release", toolname);
				   releasename=releasedetails.split("&")[0];
				   releasestartdate=releasedetails.split("&")[1];
				   releaseenddate=releasedetails.split("&")[2];
				   String sprintdetails = GetReleaseAndSprintDetails("Sprint", toolname);
				   sprintname=sprintdetails.split("&")[0];
				   sprintstartdate=sprintdetails.split("&")[1].split(" ")[0];
				   sprintenddate=sprintdetails.split("&")[2].split(" ")[0];
				   
			   
				   InitiaveName= "Initiative"+randomNumb;
					//name of the release same as tool release name for auto and append with random number if manualrecon
				   if(typeofrecon.equalsIgnoreCase("manualrecon")){
					   releasename=releasename+"_"+randomNumb;
					   sprintname=sprintname+"_"+randomNumb;
				   }
				   
				   
			   ExpWaitForCondition(RMPUIMap.CreateNewRodMap_link);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   clickJS(RMPUIMap.CreateNewRodMap_link);
			   ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			   clickJS(RMPUIMap.CreateNewRodMap_link);
			   Thread.sleep(3000);
			   
			   //set roadmap timeline
			   singleClick(RMPUIMap.Settings_Icon);
			   enterText(RMPUIMap.RoadMapTitle_txtbox,"RoadMap"+randomNumb);
			   clear(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox);
			   enterText(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox,"01/01/2019");
			   singleClick(RMPUIMap.Apply_btn);
			   ExpWaitForCondition(RMPUIMap.proceed_btn);
			   clickJS(RMPUIMap.proceed_btn);
			   
			   singleClick(RMPUIMap.plusIcon_Img);
			   Thread.sleep(3000);
			   singleClick(RMPUIMap.AddInititave_Link);
			   Thread.sleep(3000);
			   enterText(RMPUIMap.InitiaveOrReleaseNAME_txtbox,InitiaveName);
			   Thread.sleep(2000);
			   clickJS(RMPUIMap.timelinerange_range);
			   doubleClick(RMPUIMap.timelinerange_range);
			   Thread.sleep(2000);
			   clickJS(RMPUIMap.MoreOptions_Img);
			   Thread.sleep(2000);
			   singleClick(RMPUIMap.Edit_btn);
			   		   
			   //enter initiative name
				
				enterText(RMPUIMap.InitiaveDescription_txtbox, InitiaveName);
				clear(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox);
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			    Date date = new Date();
				enterText(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox, dateFormat.format(date));
				clear(RMPUIMap.ReleaseOrSprintEndDate_txtbox);
				enterText(RMPUIMap.ReleaseOrSprintEndDate_txtbox, "31/03/2022");
				click(RMPUIMap.Apply_btn);
				
				
				//add release in the roadmap
//				singleClick(RMPUIMap.plusIcon_Img);
//				Thread.sleep(2000);
//				singleClick(RMPUIMap.AddRelease_Link);
//				   Thread.sleep(3000);
				clickJS(RMPUIMap.MoreOptions_Img);
				Thread.sleep(2000);
				 HoverUsingAction(RMPUIMap.Add_Icon);
				 singleClick(RMPUIMap.SelectRelease_link);
				
//				   enterText(RMPUIMap.InitiaveOrReleaseNAME_txtbox,releasename);
//				   clickJS(RMPUIMap.timelinerange_range);
//				   doubleClick(RMPUIMap.timelinerange_range);
//				   Thread.sleep(2000);

				 clickJS(RMPUIMap.MoreOptionsForRelease_Img);
				   Thread.sleep(2000);
				   singleClick(RMPUIMap.EditRelease_btn);
				   Thread.sleep(2000);
				   ExpWaitForCondition(RMPUIMap.ReleaseNAME_txtbox);
				   enterText(RMPUIMap.ReleaseNAME_txtbox,releasename);
				   enterText(RMPUIMap.ReleaseDescription_txtbox, releasename);
				
			
			//convert the release dates to required format
			if(toolname.contains("Jira") || toolname.contains("JIRA")){
				releasestartdate = CommonFunctions.convertdatetogivenformat(releasestartdate,"d/MMM/yy","dd/MM/yyyy");
				releaseenddate = CommonFunctions.convertdatetogivenformat(releaseenddate,"d/MMM/yy","dd/MM/yyyy");
				}
				if(toolname.contains("TFS"))
				{
					releasestartdate = CommonFunctions.convertdatetogivenformat(releasestartdate,"MM/dd/yyyy","dd/MM/yyyy");
					releaseenddate = CommonFunctions.convertdatetogivenformat(releaseenddate,"MM/dd/yyyy","dd/MM/yyyy");
				}
				
			clear(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox);
			enterText(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox,releasestartdate);
			clear(RMPUIMap.ReleaseOrSprintEndDate_txtbox);
			enterText(RMPUIMap.ReleaseOrSprintEndDate_txtbox,releaseenddate);
			click(RMPUIMap.Apply_btn);
			ExpWaitForCondition(RMPUIMap.proceed_btn);
			clickJS(RMPUIMap.proceed_btn);
			
			
			
			//sprint details
			   clickJS(RMPUIMap.MoreOptionsForRelease_Img);
			   Thread.sleep(2000);
			   HoverUsingAction(RMPUIMap.AddIconForSprint_Icon);
			   Thread.sleep(2000);
			   singleClick(RMPUIMap.AddSprint_Link);
			   Thread.sleep(2000);
//			   moveAndClick(RMPUIMap.Sprint_Icon, RMPUIMap.Sprint_Icon);
			   WebElement webe = driver().findElement(By.xpath("//div[@class='rm-timeline-header childborder cursor-grab']"));
			   mouseHoverJScript(webe);
			   clickJS(RMPUIMap.SprintArrow_icon);
			   Thread.sleep(2000);
//			   singleClick(prepareWebElementWithDynamicXpath(RMPUIMap.Edisprint_btn, releasename, "releasename"));
			   singleClick(prepareWebElementWithDynamicXpath(RMPUIMap.Edisprint_btn, InitiaveName, "releasename"));
			   
//			   HoverUsingAction(RMPUIMap.Sprint_Icon);
//			   Thread.sleep(2000);
//			doubleClick(RMPUIMap.Sprint_Icon);
//			Thread.sleep(2000);
//			singleClick(RMPUIMap.Edisprint_btn);
			
			
			
			clear(RMPUIMap.SprintName_txtbox);

				enterText(RMPUIMap.SprintName_txtbox, sprintname);
				enterText(RMPUIMap.SprintDescription_txtbox, sprintname);

				//convert dates to respective format
			if(toolname.contains("Jira") || toolname.contains("JIRA")){
				sprintstartdate = CommonFunctions.convertdatetogivenformat(sprintstartdate,"d/MMM/yy","dd/MM/yyyy");
				sprintenddate = CommonFunctions.convertdatetogivenformat(sprintenddate,"d/MMM/yy","dd/MM/yyyy");
				}
				if(toolname.contains("TFS"))
				{
					sprintstartdate = CommonFunctions.convertdatetogivenformat(sprintstartdate,"MM/dd/yyyy","dd/MM/yyyy");
					sprintenddate = CommonFunctions.convertdatetogivenformat(sprintenddate,"MM/dd/yyyy","dd/MM/yyyy");
				}
				
			 click(RMPUIMap.SprintType_drpdown);
			   Thread.sleep(1000);
				clickJS(RMPUIMap.SprintTypeValue_drpdown);
				clear(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox);
				enterText(RMPUIMap.InititaveOrReleaseOrSprintStartDate_txtbox,sprintstartdate);
				clear(RMPUIMap.ReleaseOrSprintEndDate_txtbox);
				enterText(RMPUIMap.ReleaseOrSprintEndDate_txtbox,sprintenddate);
				
				click(RMPUIMap.Apply_btn);
				
				//review from here
				//save roadmap
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				ExpWaitForCondition(RMPUIMap.Save1_btn);
				clickJS(RMPUIMap.Save1_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				ExpWaitForCondition(RMPUIMap.Save_btn);
				click(RMPUIMap.Save_btn);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				
				//
//				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//				ExpWaitForCondition(RMPUIMap.SaveBaseline_btn);
//				clickJS(RMPUIMap.SaveBaseline_btn);
//				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//				clickJS(RMPUIMap.proceed_btn);
//				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//				clickJS(RMPUIMap.save_btn);
//				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//				enterText(RMPUIMap.RoadMapTitle_txtbox,"RoadMap"+randomNumb);
//				click(RMPUIMap.Apply_btn);
//				clickJS(RMPUIMap.Save_btn);
//				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//				click(RMPUIMap.SaveBaseline_btn);
//				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//				clickJS(RMPUIMap.proceed_btn);
//				ExpWaitForCondition(RMPUIMap.Save_btn);
//				click(RMPUIMap.Save_btn);

//				ExpWaitForCondition(RMPUIMap.RoadmapSaved_successMsg);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//					 ExpWaitForCondition(RMPUIMap.RoadMapUpdated_msg);
//				if(typeofrecon.equalsIgnoreCase("ManualRecon")){
				Baseclass.getInstance().RMP_ReleaseName = releasename;
				Baseclass.getInstance().RMP_SprintName=sprintname;
//				}
//				Baseclass.getInstance().RMP_ReleaseStartDate=releasestartdate;
//				Baseclass.getInstance().RMP_ReleaseEndDate=releaseenddate;

//				Baseclass.getInstance().RMP_SprintStartDate=sprintstartdate;
//				Baseclass.getInstance().RMP_SprintEndDate=sprintenddate;
//				 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Problem adding release and sprint");
			
		}
	}

	
	public static String GetReleaseAndSprintDetails(String releaseOrSprint, String toolname){
			try{
				String testDataPath = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator;
				String testDataPath_WorkItemExternalIDs="";
						if((toolname.equalsIgnoreCase("ADT Jira") || toolname.equalsIgnoreCase("ADOP Jira") || toolname.contains("Jira") || toolname.contains("JIRA")))
						{
							testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
						}
						if((toolname.equalsIgnoreCase("Rally")))
						{
							testDataPath_WorkItemExternalIDs = testDataPath + "Rally" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
						}
						else if((toolname.equalsIgnoreCase("TFS Agile") || toolname.equalsIgnoreCase("TFS Scrum") || toolname.contains("TFS")))
						{
							testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
						}
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader(testDataPath_WorkItemExternalIDs));
				JSONObject jsonObject = (JSONObject) obj;
				String ReleaseSprintName="";
				String ReleaseSprintStartDate="";
				String ReleaseSprintEndDate="";
			
					if(releaseOrSprint.equalsIgnoreCase("Release"))
					{
						ReleaseSprintName = (String) jsonObject.get("WorkItemExternalId_"+"ReleaseName");
						ReleaseSprintStartDate = (String) jsonObject.get("WorkItemExternalId_"+"ReleaseStartDate");
						ReleaseSprintEndDate = (String) jsonObject.get("WorkItemExternalId_"+"ReleaseEndDate");
						return ReleaseSprintName+"&"+ReleaseSprintStartDate+"&"+ReleaseSprintEndDate;
						}
					else if(releaseOrSprint.equalsIgnoreCase("Sprint"))
					{
						ReleaseSprintName = (String) jsonObject.get("WorkItemExternalId_"+"SprintName");
						ReleaseSprintStartDate = (String) jsonObject.get("WorkItemExternalId_"+"SprintStartDate");
						ReleaseSprintEndDate = (String) jsonObject.get("WorkItemExternalId_"+"SprintEndDate");
						return ReleaseSprintName+"&"+ReleaseSprintStartDate+"&"+ReleaseSprintEndDate;
					}
					 else{
							logger.info("Release or Sprint was not created for tool "+toolname);
						 Assert.fail("Release or Sprint was not created for tool "+toolname);
					 }
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Issue fetching Release or Sprint for tool "+toolname);
				 Assert.fail("Issue fetching Release or Sprint for tool "+toolname);
			}
			return "";		
	}
	public static void BaselineRoadMap(){
		try{
			click(RMPUIMap.BaseLine_link);
			 click(RMPUIMap.Baseline_Alert);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 click(RMPUIMap.Save_btn);
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 ExpWaitForCondition(RMPUIMap.BaselineSaved_msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Problem baselining the roadmap created");
			
		}
	}

	public static void PerformManualRecon(String ReleaseorSprint,String toolname) {
		try{
		ExpWaitForCondition(RMPUIMap.AddIterationRecon_link);
		clickJS(RMPUIMap.AddIterationRecon_link);
		 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		 HashMap<String,String> hm = Tools.getReleaseAndSprintDetails(toolname);
		 String ReleaseNameFromTool="";
		 String SprintNameFromTool="";
		 String ReleaseNameFromRMP="";
		 String SprintNameFromRMP="";
		 enterText(RMPUIMap.ManualReconName_txtbox,"ManualRecon_"+RandomNumberGenerator());
		 if(ReleaseorSprint.equalsIgnoreCase("Release")){
			 ReleaseNameFromTool = hm.get("ReleaseName");
			 ReleaseNameFromRMP = hm.get("ReleaseNameFromRMP");
			 selectDropdownByText(RMPUIMap.IterationType_drpdown, "Release");
		 }
		 if(ReleaseorSprint.equalsIgnoreCase("Sprint")){
			 SprintNameFromTool = hm.get("SprintName");
			 SprintNameFromRMP=hm.get("SprintNameFromRMP");
			 selectDropdownByText(RMPUIMap.IterationType_drpdown, "Sprint-DevelopmentSprint");
		 }
				
		 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		 clickJS(RMPUIMap.AddMapping_link);
		 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);

		 try{
//		 	CheckIfElementExists(prepareWebElementWithDynamicXpath(RMPUIMap.ReleaseOrSprintName_MyWizIntstance_txt, ReleaseNameFromTool, "releaseorsprintname"));
//		 	CheckIfElementExists(prepareWebElementWithDynamicXpath(RMPUIMap.ReleaseOrSprintName_tool_txt, ReleaseNameFromTool, "releaseorsprintname"));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 logger.info("the release or sprint doesnt exist in the mywizard or tool instance");
		 }
		 	Thread.sleep(5000);
		 	WebElement source_mywizardintance=null;
		 	WebElement source_tool = null;
		 	if(ReleaseorSprint.equalsIgnoreCase("Release")){
		 	source_mywizardintance =driver().findElement(prepareWebElementWithDynamicXpath(RMPUIMap.ReleaseOrSprintName_MyWizIntstance_txt,ReleaseNameFromRMP , "releaseorsprintname"));
		 	source_tool =driver().findElement(prepareWebElementWithDynamicXpath(RMPUIMap.ReleaseOrSprintName_tool_txt, ReleaseNameFromTool, "releaseorsprintname"));
		 	}
		 	else if(ReleaseorSprint.equalsIgnoreCase("Sprint")){
		 		source_mywizardintance =driver().findElement(prepareWebElementWithDynamicXpath(RMPUIMap.ReleaseOrSprintName_MyWizIntstance_txt,SprintNameFromRMP , "releaseorsprintname"));
			 	source_tool =driver().findElement(prepareWebElementWithDynamicXpath(RMPUIMap.ReleaseOrSprintName_tool_txt, SprintNameFromTool, "releaseorsprintname"));
		 	}
		
		 	WebElement destination =driver().findElement(RMPUIMap.DropReleaseAndSprint_box);
			DragAndDropUsingJS(source_mywizardintance, destination);
			DragAndDropUsingJS(source_tool, destination);
			Thread.sleep(3000);
			clickJS(RMPUIMap.Save_btn);
			ExpWaitForCondition(RMPUIMap.ReconSavedSuccess_Msg);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Issue merging "+ReleaseorSprint+ " for the tool "+toolname);
			Assert.fail("Issue merging "+ReleaseorSprint+ " for the tool "+toolname);
		}
	}
	
	
	public static HashMap<String, String> getReleaseAndSprintDetailsCreatedInRMP(String toolname) {
		try{
			String testDataPath_WorkItemExternalIDs="";
			String testDataPath = System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator;
			
			if(toolname.contains("Jira") || toolname.contains("JIRA")){
				testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
			}
			else if(toolname.contains("TFS") || toolname.contains("Tfs")){
				testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
			}
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(testDataPath_WorkItemExternalIDs));
			JSONObject jsonObject = (JSONObject) obj;
			
				String ReleaseName = (String) jsonObject.get("ReleaseName_FromRMP");
				String SprintName = (String) jsonObject.get("SprintName_FromRMP");
			
			HashMap<String,String> ReleaseAndSprintDetails = new HashMap<>();
			ReleaseAndSprintDetails.put("ReleaseName_FromRMP", ReleaseName);
			ReleaseAndSprintDetails.put("SprintName_FromRMP", SprintName);
			
			return ReleaseAndSprintDetails;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;

				
			}



	public static void CaptureReleaseAndSprintDetails(String toolname) {
		try{
	String testDataPath = System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "testdata" + File.separator;
	String testDataPath_WorkItemExternalIDs="";	
		if(toolname.contains("Jira") || toolname.contains("JIRA")){
			testDataPath_WorkItemExternalIDs = testDataPath + "Jira" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
		}
		else if(toolname.contains("TFS") || toolname.contains("Tfs")){
			testDataPath_WorkItemExternalIDs = testDataPath + "TFS" + File.separator + "JSON" +  File.separator + "WorkItemExternalIDs_ReleaseAndSprint.json" ;
		}
		FileReader reader = new FileReader(testDataPath_WorkItemExternalIDs);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        jsonObject.put("ReleaseName_FromRMP",Baseclass.getInstance().RMP_ReleaseName);
        jsonObject.put("SprintName_FromRMP",Baseclass.getInstance().RMP_SprintName);
        FileOutputStream outputStream = new FileOutputStream(testDataPath_WorkItemExternalIDs);
		 byte[] strToBytes = jsonObject.toString().getBytes(); outputStream.write(strToBytes);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
