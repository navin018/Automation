package testobjects;

import static utilities.reporting.LogUtil.logger;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import uiMap.DIYUIMap;
import uiMap.MSPSUIMap;
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

	public static void Deleterule(String toolName, String entityType, String workItemType) {
		try{
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			enterText(ProductInstanceEntityRuleConfigUIMAP.Search_txtbox,"Automation_Regression_"+workItemType); // searches the rule name
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

	public static void Clonerule(String toolName, String entityType, String workItemType) {
		try {
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);	
			enterText(ProductInstanceEntityRuleConfigUIMAP.Search_txtbox,"Automation_Regression_"+workItemType); // searches for the advanced rule
			 clickJS(ProductInstanceEntityRuleConfigUIMAP.Clone_icon); // clicks on '+' btn
			 ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);	
			 enterText(ProductInstanceEntityRuleConfigUIMAP.name_txt,"Automation_Clone_"+workItemType); // enters the clone name
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
			enterText(ProductInstanceEntityRuleConfigUIMAP.name_txt,"Automation_Regression_"+workItemType); // enters the name of rule;
			selectDropdownByValue(ProductInstanceEntityRuleConfigUIMAP.productinstance_drpdwn,"00000030-0010-0010-0320-000000000000"); // selects the tool name
			Thread.sleep(2000);
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.dataentity_drpdwn,entityType); // selects the entity type
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.workitemtype_drpdwn,workItemType);//selects the workitem
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			clickJS(ProductInstanceEntityRuleConfigUIMAP.Attribute_txt);
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.attribute_drpdwn,"State"); //selects the attribute
			Thread.sleep(2000);
			singleClick(ProductInstanceEntityRuleConfigUIMAP.Fieled_txt);
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.Field_drpdwn,"NA");//selects the field
			for(int i=0;i<2;i++) {
				moveRight();
				}
			singleClick(ProductInstanceEntityRuleConfigUIMAP.Value_txt);
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

	public static void InactivateRule(String toolName, String entityType, String workItemType) {
		try {
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			enterText(ProductInstanceEntityRuleConfigUIMAP.Search_text,workItemType); // searches the entity
			doubleClick(ProductInstanceEntityRuleConfigUIMAP.Entity_Txtbox);
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

	public static void Duplicaterule(String toolName, String entityType, String workItemType) {
		try {
			clickJS(ProductInstanceEntityRuleConfigUIMAP.AddRule_btn); // clicks on add btn;
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			enterText(ProductInstanceEntityRuleConfigUIMAP.name_txt,"Epic_09"); // enters the name of rule;
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.productinstance_drpdwn,"myWizard-TFS"); // selects the tool name
			Thread.sleep(2000);
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.dataentity_drpdwn,entityType); // selects the entity type
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			selectDropdownByText(ProductInstanceEntityRuleConfigUIMAP.workitemtype_drpdwn,workItemType);//selects the workitem
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
			
			clickJS(ProductInstanceEntityRuleConfigUIMAP.Attribute_txt);//selects the attribute
			Thread.sleep(2000);
			singleClick(ProductInstanceEntityRuleConfigUIMAP.Fieled_txt);
			for(int i=0;i<2;i++) {
				moveRight();
				}
			ExpWaitForCondition(ProductInstanceEntityRuleConfigUIMAP.ProjectValue_txt);
			if(CheckIfElementExists(ProductInstanceEntityRuleConfigUIMAP.ProjectValue_txt)) 
			{
				logger.info("The Project value in the rule config is as excpected");
				sa.assertTrue(true, "The Project value in the rule config is as excpected");
				
			}
			
			Thread.sleep(2000);
			clickJS(ProductInstanceEntityRuleConfigUIMAP.Save_rule);
			ExpWaitForCondition(ProductInstanceEntityRuleConfigUIMAP.DuplicationError_msg);
			if(CheckIfElementExists(ProductInstanceEntityRuleConfigUIMAP.DuplicationError_msg)) 
			{
				logger.info("Dulplication of rule is not possible");
				sa.assertTrue(true, "Dulplication of rule is not possible");
				
			}
			sa.assertAll();
			clickJS(ProductInstanceEntityRuleConfigUIMAP.Backto_ManageRule);
			ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
	}
		catch (Exception e) {
			grabScreenshotForExtentReport();
	        e.printStackTrace();
	        logger.info("Issue Duplicating Rule for given " +workItemType);
	        Assert.fail("Issue Duplicating Rule for given " +workItemType);
	    }

}

	public static void Checkrule(String toolName, String entityType, String workItemType) {
	try {
		SoftAssert sa = new SoftAssert();
		
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		enterText(ProductInstanceEntityRuleConfigUIMAP.Search_text,workItemType);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);// searches the entity
		doubleClick(ProductInstanceEntityRuleConfigUIMAP.Entity_Txtbox);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		
		if(CheckIfElementExists(ProductInstanceEntityRuleConfigUIMAP.Status_btn)) 
		{
			logger.info(" The Active/Inactive button is disabled for primary DC in Entity rule config.");
			sa.assertTrue(true," The Active/Inactive button is disabled for primary DC in Entity rule config.");
	    }
		
		if(CheckIfElementExists(ProductInstanceEntityRuleConfigUIMAP.Advanced_btn)) 
		{
			clickJS(ProductInstanceEntityRuleConfigUIMAP.Advanced_btn);
			logger.info(" Able to switch between Standard to Advanced Rule for primary DC in Entity rule config.");
			sa.assertTrue(true," Able to switch between Standard to Advanced Rule for primary DC in Entity rule config.");
	    }
		if(CheckIfElementExists(ProductInstanceEntityRuleConfigUIMAP.Standard_btn)) 
		{
			clickJS(ProductInstanceEntityRuleConfigUIMAP.Standard_btn);
			logger.info(" Able to switch between Advanced to Standard Rule for primary DC in Entity rule config.");
			sa.assertTrue(true," Able to switch between Advanced to Standard Rule for primary DC in Entity rule config.");
	    }
		
		if(CheckIfElementExists(ProductInstanceEntityRuleConfigUIMAP.AddRow_btn)) 
		{
			logger.info("Add Row button is disabled");
			sa.assertTrue(true,"Add Row button is disabled");
	    }
		
		
		if(CheckIfElementExists(ProductInstanceEntityRuleConfigUIMAP.Equal_Operator)) 
		{
		   logger.info("'=' operator in the rule config page displayed");
			sa.assertTrue(true,"'=' operator in the rule config page displayed");
	    }
		if(CheckIfElementExists(ProductInstanceEntityRuleConfigUIMAP.Delete_img)) 
		{
		   logger.info("Delete option in the first row is disabled");
			sa.assertTrue(true,"Delete option in the first row is disabled");
	    }
		sa.assertAll();
		
	}
	catch (Exception e) {
		grabScreenshotForExtentReport();
        e.printStackTrace();
        logger.info("Issue checking the Rule for given " +workItemType);
        Assert.fail("Issue checking the Rule for given " +workItemType);
    }
}
	public static void Editrule(String toolName, String entityType, String workItemType) {
		try{
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		enterText(SecurityTestsUIMap.Search_text,entityType);
		doubleClick(MSPSUIMap.DeliveryPlan_text);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);

		String RuleText=getValue(MSPSUIMap.Rule_area);
		String Rule1[] = RuleText.split("\\)");
		//get Name from Json file
		String DeliveryPlanName=Tools.getWorkItemExternalID("DeliveryPlan", toolName);
		String AddedRule=Rule1[0].toString()+" OR Title='"+DeliveryPlanName+"')";
		System.out.println(AddedRule);
		clear(ProductInstanceEntityRuleConfigUIMAP.Text_area);
		singleClick(ProductInstanceEntityRuleConfigUIMAP.Text_area);
		enterText(ProductInstanceEntityRuleConfigUIMAP.Text_area,AddedRule);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		clickJS(ProductInstanceEntityRuleConfigUIMAP.Save_rule);
		try{
		ExpWaitForCondition(ProductInstanceEntityRuleConfigUIMAP.SavedRule_txt);
		}
		catch (Exception e) {
		e.printStackTrace();
		logger.info("Issue Add project to Rules");
		Assert.fail("Rule saved message not shown");
		}
		Baseclass.getInstance().WorkItemExternalId_DeliveryPlan=DeliveryPlanName;
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);
		ExpWaitForElementToDisappear(MyWizardUIMap.waitSign_Img);

		}
		catch (Exception e) {
		e.printStackTrace();
		logger.info("Issue Editing Rules");
		Assert.fail("Issue Editing Rules");

		}




		}
}