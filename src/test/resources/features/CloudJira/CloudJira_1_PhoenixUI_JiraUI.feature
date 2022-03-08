Feature: PhoenixUI_CloudJiraUI

#@0Delete_TestData_CloudJira      
#Scenario Outline: Delete_TestData_CloudJira
#    Given i login to application "<applicationname>"
#   Then i select a Project for "<applicationname>"
#   	And i delete the test automation data
#
#    Examples: 
#      | applicationname |
#      | Jira            | 
      
      
@1PreRequisites_CloudJira
Scenario Outline: ProdConfigCheck_CloudJIRA 
	Given i load the project properties file 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage"
	Then i select client and DC for "MyWizard" 
	And i click on tile "Product Configuration" 
	
	And i select the "Cloud JIRA" in Manage Product Configuration page 
	#do not run the below steps 
#	And i navigate to "Product Instance Extension(s)" section 
#	And i add Product Instance Extension(s) details in the page for "Cloud JIRA" 
#	And i hit the save button in Product Config page 
#	And i select the "Cloud JIRA" in Manage Product Configuration page 
	And i navigate to "Delivery Construct Association" section 
	And i add Delivery construct association details in the page for "Cloud JIRA" 
	And i navigate to "Product Instance Entities" section 
	And i add Product Instance Entities details in the page for "Cloud JIRA" 
	And i hit the save button in Product Config page 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |Cloud JIRA|
		
@2ClientNative_CloudJira		
Scenario Outline: Client_Native_CloudJIRA(!Iteraion) 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "Cloud JIRA" in Manage Product Configuration page 
	And i navigate to "Product Instance Entities" section 
	And i generate a token for "DevTest" environment 
	And i verify the ClientNative details for "<toolname_Sheet>" 
	And i hit the save button in Product Config page 
#	
	Examples: 
		| applicationname |toolname_Sheet|
		| MyWizard        |Cloud JIRA|

@2ClientNative_CloudJira		
Scenario Outline: Client_Native_CloudJIRA(iteration) 
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
		| MyWizard        |Cloud JIRA_Iteration|

@3SEI_CloudJira
Scenario Outline: SEI_CloudJira_IB_Pipelines 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "Cloud JIRA" in Manage Product Configuration page 
	And i check if the field "RealTimeConfigChanges" is "Enabled" 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i verify the existing "IB" pipelines if present and add them if missing for "<toolname>" 
#do not run the below steps 
#	And i hit the save button in Product Config page 
#	And i select the "Cloud JIRA" in Manage Product Configuration page 
#	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
#	And i deploy the pipelines and verify if successful for "<toolname>" 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |Cloud JIRA|

@3SEI_CloudJira	
Scenario Outline: SEI_CloudJira_OB_Pipelines 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select only the client for "<applicationname>" 
	And i select the "<toolname>" in Manage Product Configuration page 
	And i check if the field "RealTimeConfigChanges" is "Enabled" 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i verify the existing "OB" pipelines if present and add them if missing for "<toolname>" 
#do not run the below steps 
#	And i hit the save button in Product Config page 
#	And i select the "Cloud JIRA" in Manage Product Configuration page 
#	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
#	And i deploy the pipelines and verify if successful for "<toolname>" 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |Cloud JIRA|

@4Rules_CloudJira
Scenario Outline: CloudJira_RulesValidation
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Instance Entity Rule Config"
	Then i select client and DC for "<applicationname>"  
	And i verify and add the rules if missing for the "<toolname>" 
	
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |Cloud JIRA|
		
@5WorkItemCreation_CloudJira		
Scenario Outline: CloudJira_WorkitemCcreation 
	Given i load the "Cloud Jira" project properties file
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create a "<task>" in CloudJira 
	And i create a "<story>" in CloudJira 
	And i create a "<bug>" in CloudJira 
	And i create a "<epic>" in CloudJira 
	And i create an "<Release>" in Jira 
	And i create an "<Sprint>" in Jira 
	And i update the WorkItemExternalIDs into a New JSON file for "<applicationname>"
	And i check the overall status of workitem creation for "<applicationname>" 
	And i put a explicit wait of "900000" 
	And i generate a token for "DevTest" environment 
#	
	  Examples: 
      | applicationname | feature             | task    | story    | risk         | issue         | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    |Sprint    |
      | Cloud Jira            | New Feature_Cloud_01 | Task_01 | Story_01 | Risk_Cloud_01 | Issue_Cloud_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_02 |Sprint_CloudJira |

#@8CloudJira_OB_ValidationInTool
#this is pending
#Scenario Outline: CloudJira_OB_ValidationInTool
#And i put a explicit wait of "600000" 
#    Given i login to application "<applicationname>"
#   Then i select a Project for "<applicationname>"
##    And i validate the outbound flow

#    Examples: 
#      | applicationname | 
#      | Jira            | 
		
		