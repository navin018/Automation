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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import dataobjects.WorkItemDO;
import dataobjects.WorkItemExternalIDDO;
import testobjects.Baseclass;
import uiMap.JiraUIMap;
import uiMap.MyWizardMappingRuleUIMap;
import uiMap.MyWizardUIMap;
import utilities.general.DataManager;
import utilities.general.Property;

import org.apache.tools.ant.Project;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

	public class MappingRules extends Baseclass{
		private Baseclass base;
	
		public MappingRules()
		{
			
		}
		
		public MappingRules(Baseclass base) {
			this.base =base; 
		}
		
		public static void SetRandomNumberForRuleName(){
			
			try{
				
				Random r = new Random();
				Baseclass.getInstance().RandomNumbForMappingRule = r.nextInt(900)+100;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		public static void VerifyAndAddRulesIfMissing(String toolname,String[] workitems, String[] nonWorkitems){
			try{

				SetRandomNumberForRuleName();
				
				//verify workitem
				try{
					
						clickJS(MyWizardMappingRuleUIMap.PageSize_statictxt);
						clickJS(MyWizardMappingRuleUIMap.PageSize100_statictxt);
						
							for(String entity:workitems )
							{
								boolean workitemfound = false;
								if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.Entity_statictxt, entity, "workitem")))
										{													
												CheckWorkItemAndAddIfMissing(entity, toolname, workitemfound);
										}
								else
								{
									enterText(MyWizardMappingRuleUIMap.SearchWorkItemNonWorkItem_txtbox, entity);
									if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.Entity_statictxt, entity, "workitem")))
										CheckWorkItemAndAddIfMissing(entity, toolname, workitemfound);
									else
									addEntityWithRules(toolname,entity,"workitem");
								}
							}
					
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Issue verifying/adding workitems rules for tool "+toolname);
				Assert.fail("Issue verifying/adding workitems rules for tool "+toolname);
			}
				
				//verify non-workitems
				try{
					
//							System.out.println(getText(By.xpath("//div[@ref='eBodyContainer']//following::div[@row-id='1']//following::div[@col-id='EntityName'][1]")));
							
								for(String nonworkitem:nonWorkitems )
								{
									boolean nonworkitemboolean = false;
									if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.NonWorkitem_statictxt, nonworkitem, "nonworkitem")))
									{
												CheckNonWorkItemAndAddIfMissing(nonworkitem,toolname,nonworkitemboolean);
									}
									else
									{
										enterText(MyWizardMappingRuleUIMap.SearchWorkItemNonWorkItem_txtbox, nonworkitem);
										if(CheckIfElementExists(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.NonWorkitem_statictxt, nonworkitem, "nonworkitem")))
											CheckNonWorkItemAndAddIfMissing(nonworkitem,toolname,nonworkitemboolean);
										else
										addEntityWithRules(toolname,nonworkitem,"nonworkitem");
									}
								}
						
				}
				catch(Exception e)
				{
					e.printStackTrace();
					logger.info("Issue verifying/adding non-workitems rules for tool "+toolname);
					Assert.fail("Issue verifying/adding non-workitems rules for tool "+toolname);
				}
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue verfying/adding rules for tool "+toolname);
				Assert.fail("issue verfying/adding rules for tool "+toolname);
			}
		}
		
		public static void CheckWorkItemAndAddIfMissing(String workitem,String toolname, boolean workitemboolean){
			
			try{
				
				int noOfEntities = CheckElementsSize(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.Entity_statictxt, workitem, "workitem"));		
				
				if(noOfEntities>0)
				{
					//get parent of the elements
					ArrayList<Integer> parentnodes = getParentnodes(noOfEntities,workitem);
//					System.out.println(parentnodes);
						for(int i=1;i<=noOfEntities;i++)
						{
							//get parent
//								String rowindex = driver().findElement(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.NonWorkitem_statictxt, nonworkitem, "nonworkitem")).findElement(By.xpath("..")).getAttribute("row-index");
//							System.out.println(getText(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.EntityRowProductInstance_statictxt, String.valueOf(parentnodes.get(i-1)), "row")));
							
								if(getText(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.EntityRowProductInstance_statictxt, String.valueOf(parentnodes.get(i-1)), "row")).equalsIgnoreCase(toolname) && (CheckElementsSize(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.EntityRowStatusUId_statictxt, String.valueOf(parentnodes.get(i-1)), "row"))==1) )
								{
									VerifyRuleForSingleEntity(toolname,workitem,"workitem", Integer.valueOf(parentnodes.get(i-1)) );
									workitemboolean = true;
									break;
								}
						}	
				}
			
			if(!workitemboolean)
			{
				addEntityWithRules(toolname,workitem,"workitem");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		public static void CheckNonWorkItemAndAddIfMissing(String nonworkitem,String toolname,boolean nonworkitemboolean)
		{
			try{
			int noOfNonWorkItems = CheckElementsSize(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.NonWorkitem_statictxt, nonworkitem, "nonworkitem"));
			
			if(noOfNonWorkItems>0)
			{
				//get parent of the elements
				ArrayList<Integer> parentnodes = getParentnodes(noOfNonWorkItems,nonworkitem);
//				System.out.println(parentnodes);
					for(int i=1;i<=noOfNonWorkItems;i++)
					{
						//get parent
//							String rowindex = driver().findElement(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.NonWorkitem_statictxt, nonworkitem, "nonworkitem")).findElement(By.xpath("..")).getAttribute("row-index");
//						System.out.println(getText(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.NonWorkItemRowProductInstance_statictxt, String.valueOf(parentnodes.get(i-1)), "row")));
							
						if(getText(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.NonWorkItemRowProductInstance_statictxt, String.valueOf(parentnodes.get(i-1)), "row")).equalsIgnoreCase(toolname) && (CheckElementsSize(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.EntityRowStatusUId_statictxt, String.valueOf(parentnodes.get(i-1)), "row"))==1) )	
							{
								VerifyRuleForSingleEntity(toolname,nonworkitem,"nonworkitem", Integer.valueOf(parentnodes.get(i-1)) );
								nonworkitemboolean = true;
								clickJS(MyWizardMappingRuleUIMap.PageSize_statictxt);
								clickJS(MyWizardMappingRuleUIMap.PageSize100_statictxt);
								Thread.sleep(3000);
								break;
							}
					}	
			}
			
			if(!nonworkitemboolean)
			{
				addEntityWithRules(toolname,nonworkitem,"nonworkitem");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
			
		}
		
		public static ArrayList<Integer> getParentnodes(int noOfNonWorkItems,String WorkItem_Nonworkitem){
			
			try{
				ArrayList<Integer> parentnodesRowIndex = new ArrayList<>();
				for(int i=1;i<=noOfNonWorkItems;i++)
				{
					String rowindex = driver().findElement(prepareWebElementWithDynamicXpath2(MyWizardMappingRuleUIMap.findParentNode_dynamicTxt, WorkItem_Nonworkitem, String.valueOf(i), "workitems_nonworkitems", "int")).findElement(By.xpath("..")).getAttribute("row-index");
//					String attribute = getAttribute(prepareWebElementWithDynamicXpath2(MyWizardMappingRuleUIMap.findParentNode_dynamicTxt, WorkItem_Nonworkitem, String.valueOf(noOfNonWorkItems), "workitems_nonworkitems", "int"), "row-index");
					parentnodesRowIndex.add(Integer.valueOf(rowindex));
					
				}
				return parentnodesRowIndex;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue getting parent node for "+noOfNonWorkItems);
				Assert.fail("issue getting parent node for "+noOfNonWorkItems);
			}
			return null;
			
		}
		
		public static void addEntityWithRules(String toolname,String Entity,String workitem_nonworkitem)
		{
			try{
				
				clickJS(MyWizardMappingRuleUIMap.AddRule_link);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				String rulename = "Rule_"+Entity+"_"+Baseclass.getInstance().RandomNumbForMappingRule;
				enterText(MyWizardMappingRuleUIMap.RuleNameWileAddingNewRule_txtbox,rulename);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				
				selectByPartOfVisibleText(MyWizardMappingRuleUIMap.ProductInstance_Dropdwn, toolname);
//				selectByPartOfVisibleText(MyWizardMappingRuleUIMap.ProductInstance_Dropdwn, "myWizardInstance");
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				
				if(workitem_nonworkitem.equals("workitem"))
					selectByPartOfVisibleText(MyWizardMappingRuleUIMap.DataEntity_Dropdwn, "WorkItem");
					else
					selectByPartOfVisibleText(MyWizardMappingRuleUIMap.DataEntity_Dropdwn, Entity);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				if(workitem_nonworkitem.equals("workitem"))
					selectByPartOfVisibleText(MyWizardMappingRuleUIMap.WorkItemType_Dropdwn,Entity);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);				
				clickJS(MyWizardMappingRuleUIMap.RuleTypeAdvanced_Option);
				clickJS(MyWizardMappingRuleUIMap.UseAdvancedRule_statictxt);
		
				
				
				
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				String ruletoEnter = "(Project='"+Property.getProperty("RulesForProject")+"')";
//				System.out.println(ruletoEnter);
//				enterText(MyWizardMappingRuleUIMap.xpathrule_txtbox,"(Project=");
//				enterText(MyWizardMappingRuleUIMap.xpathrule_txtbox,"'");
//				enterText(MyWizardMappingRuleUIMap.xpathrule_txtbox,Property.getProperty("RulesForProject"));
//				enterText(MyWizardMappingRuleUIMap.xpathrule_txtbox,"')");
				enterText(MyWizardMappingRuleUIMap.xpathrule_txtbox,ruletoEnter);
				Thread.sleep(2000);
				clickJS(MyWizardMappingRuleUIMap.SaveRule_btn);
				Thread.sleep(1000);
				ExpWaitForCondition(MyWizardMappingRuleUIMap.RuleSavedSuccesfully_statictxt);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//												
				Thread.sleep(1000);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("issue adding  "+Entity+" rules for  "+toolname);
				Assert.fail("issue adding  "+Entity+" rules for  "+toolname);
			}
		}
			
		
		public static void VerifyRuleForSingleEntity(String toolname,String Entity_NonWorkItem,String WiOrNonWi, int rownumb)
		{
			try{
				//if toolname is- code pending
				if(WiOrNonWi.equalsIgnoreCase("workitem"))
				{
					clickJS(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.Entity_statictxt, Entity_NonWorkItem, "workitem"));
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					clickJS(MyWizardMappingRuleUIMap.viewEdit_link);
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				}
				if(WiOrNonWi.equalsIgnoreCase("NonWorkItem"))
				{
					clickJS(prepareWebElementWithDynamicXpath(MyWizardMappingRuleUIMap.NonWorkitemWithRow_statictxt, String.valueOf(rownumb), "row"));
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
					clickJS(MyWizardMappingRuleUIMap.viewEdit_link);
					ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				}
			
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				//verify the rule for the workitem
				clickJS(MyWizardMappingRuleUIMap.RuleTypeAdvanced_Option);
				if(!isSelected(MyWizardMappingRuleUIMap.IsUseAdvancedRuleSelected_statictxt))
					clickJS(MyWizardMappingRuleUIMap.UseAdvancedRule_statictxt);
				clear(MyWizardMappingRuleUIMap.xpathrule_txtbox);
				String rulename ="("+ "Project='"+Property.getProperty("RulesForProject")+"')";
				enterText(MyWizardMappingRuleUIMap.xpathrule_txtbox,rulename);
				Thread.sleep(2000);
				clickJS(MyWizardMappingRuleUIMap.SaveRule_btn);
				Thread.sleep(1000);
				ExpWaitForCondition(MyWizardMappingRuleUIMap.RuleSavedSuccesfully_statictxt);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
//												
				Thread.sleep(1000);
				ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				
				}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("Issue verfying rules for "+Entity_NonWorkItem+" for the given tool "+toolname);
				Assert.fail("Issue verfying rules for "+Entity_NonWorkItem+" for the given tool "+toolname);
			}
		}
	}