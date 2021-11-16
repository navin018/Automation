package testobjects;

import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.CheckIfElementExists;
import static utilities.selenium.SeleniumDSL.ExpWaitForCondition;
import static utilities.selenium.SeleniumDSL.ExpWaitForElementToDisappear;
import static utilities.selenium.SeleniumDSL.clear;
import static utilities.selenium.SeleniumDSL.clickJS;
import static utilities.selenium.SeleniumDSL.*;
import static utilities.selenium.SeleniumDSL.enterText;
import static utilities.selenium.SeleniumDSL.prepareWebElementWithDynamicXpath;
import static utilities.selenium.SeleniumDSL.selectDropdownByText;

import java.io.File;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import uiMap.MyWizardUIMap;
import uiMap.ProductInstanceEntityRuleConfigUIMAP;
import uiMap.SecurityTestsUIMap;
import uiMap.myQueriesUIMap;
import utilities.general.Property;
public class ProductInstanceEntityRuleConfig  extends Baseclass {
	private Baseclass base;
	static SoftAssert sa = new SoftAssert();
	public ProductInstanceEntityRuleConfig() {
		
	}

	public static void Deleterule() {
		try{
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			enterText(ProductInstanceEntityRuleConfigUIMAP.Search_txtbox,"Automation_Regression"); // searches the rule name
			doubleClick(ProductInstanceEntityRuleConfigUIMAP.SelectRule_Statictxt); // selects the rule
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.workitemtype_drpdwn,"Feature");//selects the workitem
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
				 if(CheckIfElementExists(ProductInstanceEntityRuleConfigUIMAP.Inactive_rule))
				 {
					 clickJS(ProductInstanceEntityRuleConfigUIMAP.Inactive_rule); // clicks on inactive btn
				 }
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 clickJS(ProductInstanceEntityRuleConfigUIMAP.Save_rule);    // saves the rule
			 ExpWaitForCondition(ProductInstanceEntityRuleConfigUIMAP.SavedRule_txt);
			 Assert.assertEquals(CheckIfElementExists(ProductInstanceEntityRuleConfigUIMAP.SavedRule_txt),true,"Rule is not saved"); //Assert if the rule is saved
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);	
				}
					catch(Exception e)
					{
						e.printStackTrace();
						logger.info("Deleting a rule failed");
						Assert.fail("Deleting a rule failed");
					}	
				
		
		
	}

	public static void Clonerule() {
		try {
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);	
			enterText(ProductInstanceEntityRuleConfigUIMAP.Search_txtbox,"Automation_Regression"); // searches for the advanced rule
			 clickJS(ProductInstanceEntityRuleConfigUIMAP.Clone_icon); // clicks on '+' btn
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);	
			 enterText(ProductInstanceEntityRuleConfigUIMAP.name_txt,"Automation_RegresProductInstanceEntityRuleConfigUIMAP.SavedRule_txtsion_Sample"); // enters the clone name
			 clickJS(ProductInstanceEntityRuleConfigUIMAP.Save_rule);
			 ExpWaitForCondition(ProductInstanceEntityRuleConfigUIMAP.SavedRule_txt);
			 Assert.assertEquals(CheckIfElementExists(myQueriesUIMap.savedQuery_txt),true,"Rule is not saved"); //Assert if the query is saved// saves the cloned rule
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Cloning a rule failed");
			Assert.fail("Cloning a rule failed");
		}
	}

	public static void Addrule(String toolName, String entityType, String workItemType) {
		try{
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);

			//Add Standard Rule
			clickJS(ProductInstanceEntityRuleConfigUIMAP.AddRule_btn); // clicks on add btn;
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			enterText(ProductInstanceEntityRuleConfigUIMAP.name_txt,"Automation_Regression_testing"); // enters the name of rule;
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.productinstance_drpdwn,"myWizard-TFS"); // selects the tool name
			Thread.sleep(2000);
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.dataentity_drpdwn,entityType); // selects the entity type
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.workitemtype_drpdwn,workItemType);//selects the workitem
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			singleClick(ProductInstanceEntityRuleConfigUIMAP.attribute_txtbox);
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.attribute_drpdwn,"State"); //selects the attribute
			Thread.sleep(2000);
			singleClick(ProductInstanceEntityRuleConfigUIMAP.Field_txtbox);
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.Field_drpdwn,"NA");//selects the field
			Thread.sleep(2000);
			singleClick(ProductInstanceEntityRuleConfigUIMAP.Value_txtbox);
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.Value_drpdwn,"New");//selects the value for attribute
			Thread.sleep(2000);

			// Add Advanced Rule

			clickJS(ProductInstanceEntityRuleConfigUIMAP.Advanced_btn);
			clickJS(ProductInstanceEntityRuleConfigUIMAP.Advance_checkbox);
			Thread.sleep(2000);
			String proj = Property.getProperty("ProductInstanceProjectForDIY");
			String AdvancedQuery = "(Project='"+proj+"' AND State = 'New' AND Priority = '4' )";
			System.out.println(AdvancedQuery);
			enterText(ProductInstanceEntityRuleConfigUIMAP.Text_area,AdvancedQuery); // enters advanced rule
			Thread.sleep(2000);
			clickJS(ProductInstanceEntityRuleConfigUIMAP.Save_rule); // saves the advanced rule
			ExpWaitForCondition(ProductInstanceEntityRuleConfigUIMAP.SavedRule_txt);
			Assert.assertEquals(CheckIfElementExists(ProductInstanceEntityRuleConfigUIMAP.SavedRule_txt),true,"Rule is not saved"); //Assert if the rule is saved
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			}
			catch(Exception e)
			{
			e.printStackTrace();
			logger.info("Adding a rule failed");
			Assert.fail("Adding a rule failed");
			}
		
		
		
	}

	public static void InactivateRule() {
		try {
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			enterText(SecurityTestsUIMap.Search_text,"Epic"); // searches the entity
//			doubleClick(SecurityTestsUIMap.text_epic);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 if(CheckIfElementExists(ProductInstanceEntityRuleConfigUIMAP.Inactive_rule))
			 {
				 clickJS(ProductInstanceEntityRuleConfigUIMAP.Inactive_rule); // clicks on inactive btn
			 }
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			 clickJS(ProductInstanceEntityRuleConfigUIMAP.Save_rule);       // saves the rule
			 try{
			 ExpWaitForCondition(ProductInstanceEntityRuleConfigUIMAP.SavedRule_txt);
			 }
			 catch (Exception e) {
				 e.printStackTrace();
			        logger.info("Issue Inactivating Rules");
			        Assert.fail("Rule saved msg not shown");
			 }
//			 Assert.assertEquals(CheckIfElementExists(ProductInstanceEntityRuleConfigUIMAP.SavedRule_txt),true,"Rule is not saved"); //Assert if the rule is saved
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);	
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
	}
		catch (Exception e) {
	        e.printStackTrace();
	        logger.info("Issue Inactivating Rules");
	        Assert.fail("Issue Inactivating Rules");
	    }

		
	}
		
	

}
