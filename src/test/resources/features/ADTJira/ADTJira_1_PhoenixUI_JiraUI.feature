Feature: PhoenixUI_ADTJiraUI

@0Delete_TestData_ADTJira      
Scenario Outline: Delete_TestData_ADTJira
    Given i login to application "<applicationname>"
   Then i select a Project for "<applicationname>"
   	And i delete the test automation data

    Examples: 
      | applicationname |
      | Jira            | 
      
      
@1PreRequisites_ADTJira
Scenario Outline: ADTJIRA_ProdConfigCheckInUI 
	Given i load the project properties file 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage"
	And i click on tile "Product Configuration" 
	Then i select client and DC for "MyWizard" 
	And i select the "ADT JIRA" in Manage Product Configuration page 
#	And i navigate to "Product Instance Extension(s)" section 
#	And i add Product Instance Extension(s) details in the page for "ADT JIRA" 
#	And i hit the save button in Product Config page 
#	And i select the "ADT JIRA" in Manage Product Configuration page 
	And i navigate to "Delivery Construct Association" section 
	And i add Delivery construct association details in the page for "ADT JIRA" 
	And i navigate to "Product Instance Entities" section 
	And i add Product Instance Entities details in the page for "ADT JIRA" 
	And i hit the save button in Product Config page 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |ADT JIRA|
		
@2ClientNative_ADTJira		
Scenario Outline: Client_Native_ADTJIRA(!Iteraion) 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "ADT JIRA" in Manage Product Configuration page 
	And i navigate to "Product Instance Entities" section 
	And i generate a token for "DevTest" environment 
	And i verify the ClientNative details for "<toolname_Sheet>" 
	And i hit the save button in Product Config page 
#	
	Examples: 
		| applicationname |toolname_Sheet|
		| MyWizard        |ADT JIRA|

@2ClientNative_ADTJira		
Scenario Outline: Client_Native_ADTJIRA(iteration) 
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
		| MyWizard        |ADT JIRA_Iteration|

@3SEI_ADTJira
Scenario Outline: SEI_ADTJira_IB_Pipelines_UI
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "ADT JIRA" in Manage Product Configuration page 
	And i check if the field "RealTimeConfigChanges" is "Enabled" 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i verify the existing "IB" pipelines if present and add them if missing for "<toolname>" 
#	And i hit the save button in Product Config page 
#	And i select the "ADT JIRA" in Manage Product Configuration page 
#	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
#	And i deploy the pipelines and verify if successful for "<toolname>" 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |ADT JIRA|

@3SEI_ADTJira		
Scenario Outline: SEI_ADTJIRA_OB_Pipelines_UI 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select only the client for "<applicationname>" 
	And i select the "<toolname>" in Manage Product Configuration page 
	And i check if the field "RealTimeConfigChanges" is "Enabled" 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i verify the existing "OB" pipelines if present and add them if missing for "<toolname>" 
#	And i hit the save button in Product Config page 
#	And i select the "ADT JIRA" in Manage Product Configuration page 
#	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
#	And i deploy the pipelines and verify if successful for "<toolname>" 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |ADT JIRA|

@4Rules_ADTJira
Scenario Outline: ADTJIRA_RulesValidationInUI
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Instance Entity Rule Config"
	Then i select client and DC for "<applicationname>"  
	And i verify and add the rules if missing for the "<toolname>" 
	
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |ADT JIRA|
		
@5WorkItemCreation_ADTJira		
Scenario Outline: ADTJIRA_WorkitemCreationInUI
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create a "<task>" in Jira 
	And i create a "<story>" in Jira 
	And i create a "<risk>" in Jira 
	And i create a "<bug>" in Jira 
	And i create a "<issue>" in Jira 
	And i create a "<feature>" in Jira 
	And i create a "<impediment>" in Jira 
	And i create a "<deliverable>" in Jira 
	And i create a "<Requirement>" in Jira 
	And i create a "<Test>" in Jira
	And i create a "<epic>" in Jira 
##	And i create a "<subtask>" in Jira 
	And i create a "<milestone>" in Jira 
	And i create a "<Action>" in Jira
	And i create a "<TestExecution>" in Jira
	And i create entity "<TestForTestExec>" in Jira 
#
	And i create an "<Release>" in Jira 
	And i create an "<Sprint>" in Jira 
##	And i create an "<Team>" in Jira 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	And i check the overall status of workitem creation for "<applicationname>"
	And i put a explicit wait of "900000" 
	And i generate a token for "DevTest" environment 
	
	
	Examples: 
		| applicationname | task    | story    | risk    |Requirement| Test|issue    | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    | Sprint    |Team|milestone|TestExecution|Action|TestForTestExec|
		| Jira            | Task_01 | Story_01 | Risk_01 | Requirement_01| Test_01|Issue_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 | Sprint_01 |Team_01|Milestone_01|Test Execution_01|Action_01|TestForTestExec_01|


