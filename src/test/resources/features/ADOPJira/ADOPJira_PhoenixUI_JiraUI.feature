Feature: PhoenixUI_ADOPJiraUI

@0Delete_TestData_ADOPJira      
Scenario Outline: Delete_TestData_ADOPJira
    Given i login to application "<applicationname>"
   Then i select a Project for "<applicationname>"
   	And i delete the test automation data

    Examples: 
      | applicationname |
      | Jira            | 
      
      
@1PreRequisites_ADOPJira
Scenario Outline: ProdConfigCheck_ADOPJIRA 

	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage"
	And i click on tile "Product Configuration" 
	Then i select client and DC for "MyWizard" 
	And i select the "ADOP JIRA" in Manage Product Configuration page 
#	And i navigate to "Product Instance Extension(s)" section 
#	And i add Product Instance Extension(s) details in the page for "ADOP JIRA" 
#	And i hit the save button in Product Config page 
#	And i select the "ADOP JIRA" in Manage Product Configuration page 
	And i navigate to "Delivery Construct Association" section 
	And i add Delivery construct association details in the page for "ADOP JIRA" 
	And i navigate to "Product Instance Entities" section 
	And i add Product Instance Entities details in the page for "ADOP JIRA" 
	And i hit the save button in Product Config page 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |ADOP JIRA|
		
@2ClientNative_ADOPJira		
Scenario Outline: Client_Native_ADOPJIRA(!Iteraion) 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "ADOP JIRA" in Manage Product Configuration page 
	And i navigate to "Product Instance Entities" section 
	And i generate a token for "DevTest" environment 
	And i verify the ClientNative details for "<toolname_Sheet>" 
	And i hit the save button in Product Config page 
#	
	Examples: 
		| applicationname |toolname_Sheet|
		| MyWizard        |ADOP JIRA|

@2ClientNative_ADOPJira		
Scenario Outline: Client_Native_ADOPJIRA(iteration) 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "mywizardinstance" in Manage Product Configuration page 
	And i navigate to "Product Instance Entities" section 
	And i generate a token for "DevTest" environment 
	And i verify the ClientNative details for "<toolname_Sheet>" 
	And i hit the save button in Product Config page 
#	
	Examples: 
		| applicationname |toolname_Sheet|
		| MyWizard        |ADOP JIRA_Iteration|

@3SEI_ADOPJira
Scenario Outline: SEI_ADOPJira_IB_Pipelines 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "ADOP JIRA" in Manage Product Configuration page 
	And i check if the field "RealTimeConfigChanges" is "Enabled" 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i verify the existing "IB" pipelines if present and add them if missing for "<toolname>" 
#	And i hit the save button in Product Config page 
#	And i select the "ADOP JIRA" in Manage Product Configuration page 
#	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
#	And i deploy the pipelines and verify if successful for "<toolname>" 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |ADOP JIRA|

@3SEI_ADOPJira	
Scenario Outline: SEI_ADOPJira_OB_Pipelines 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select only the client for "<applicationname>" 
	And i select the "<toolname>" in Manage Product Configuration page 
	And i check if the field "RealTimeConfigChanges" is "Enabled" 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i verify the existing "OB" pipelines if present and add them if missing for "<toolname>" 
#	And i hit the save button in Product Config page 
#	And i select the "ADOP JIRA" in Manage Product Configuration page 
#	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
#	And i deploy the pipelines and verify if successful for "<toolname>" 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |ADOP JIRA|

@4Rules_ADOPJira
Scenario Outline: ADOPJira_RulesValidation
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Instance Entity Rule Config"
	Then i select client and DC for "<applicationname>"  
	And i verify and add the rules if missing for the "<toolname>" 
	
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |ADOP JIRA|
		
@5WorkItemCreation_ADOPJira		
Scenario Outline: ADOPJira_WorkitemCcreation 
Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"
	    And i create a "<feature>" in Jira
	    And i create a "<task>" in Jira
	    And i create a "<story>" in Jira
	    And i create a "<risk>" in Jira
	    And i create a "<bug>" in Jira
	    And i create a "<impediment>" in Jira
	    And i create a "<epic>" in Jira
	    And i create a "<issue>" in Jira
	    And i create an "<Release>" in Jira
    	And i create an "<Sprint>" in Jira
    And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
	And i put a explicit wait of "600000" 
	And i generate a token for "DevTest" environment 
	
	  Examples: 
      | applicationname | feature             | task    | story    | risk         | issue         | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    |Sprint    |
      | Jira            | New Feature_ADOP_01 | Task_01 | Story_01 | Risk_ADOP_01 | Issue_ADOP_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 |Sprint_01 |

@8ADOPJira_OB_ValidationInTool
Scenario Outline: ADOPJira_OB_ValidationInTool
    Given i login to application "<applicationname>"
   Then i select a Project for "<applicationname>"
    And i validate the outbound flow

    Examples: 
      | applicationname | 
      | Jira            | 
		
		