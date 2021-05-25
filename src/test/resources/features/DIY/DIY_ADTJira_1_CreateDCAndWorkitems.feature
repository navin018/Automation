@ADTJira_DIY_DCCreation_WorkitemCreation_DeleteDC
Feature: DIY functionality to create/delete DC and create workitems 

@1ADTJira_DIY_RemoveUserRoleInAccountManagement
Scenario Outline: ADTJIRA_RemoveUserRole_DIY 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Account Management"
	And i remove the role "Client Admin" for user "sonal.harish.nagda@accenture.com"

Examples: 
		| applicationname |
		| MyWizard        |

@2ADTJira_DIY_CreateDC
Scenario Outline: ADTJIRA_DIY_CreateDC 
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "DIY AD Automation" 
	Then i select only the client for "<applicationname>"
	And i "create" a DC for DIY for "ADT Jira"
	And i enter self enabled automation details for "ADT Jira"
	And i test the connectivity for "ADT Jira"  
	And i make a note of the DC created for "ADT Jira"
Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|
		

@3ADTJira_DIY_CreateWorkitems		
Scenario Outline: ADTJIRA_DIY_WorkitemCreationInUI
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create a "<epic>" in Jira 
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
	And i create a "<milestone>" in Jira 
	And i create a "<Action>" in Jira
	And i create a "<WorkRequest>" in Jira
	And i create a "<TestExecution>" in Jira
	And i create entity "<TestForTestExec>" in Jira 

	And i create an "<Release>" in Jira 
	And i create an "<Sprint>" in Jira 
#	And i create an "<Team>" in Jira 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	And i check the overall status of workitem creation for "<applicationname>"
	And i put a explicit wait of "900000" 

Examples: 
		| applicationname | task    | story    | risk    |Requirement| Test|issue    | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    | Sprint    |Team|milestone|TestExecution|Action|TestForTestExec|WorkRequest|
		| Jira            | Task_01 | Story_01 | Risk_01 | Requirement_01| Test_01|Issue_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 | Sprint_01 |Team_01|Milestone_01|Test Execution_01|Action_01|TestForTestExec_01|Work Request_01|


@7ADTJira_DIY_InactivateRules
Scenario Outline: ADTJIRA_DIY_InactiveRules

	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Instance Entity Rule Config"
	Then i select client and DC for DIY for "ADT Jira"	
	And i deactivate the rules for "ADT Jira"

	
	Examples: 
		| applicationname |
		| MyWizard        |

@8ADTJira_DIY_DeleteDC
Scenario Outline: ADTJIRA_DI
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "DIY AD Automation" 
	Then i select only the client for "<applicationname>"
	And i "delete" a DC for DIY for "ADT Jira"
	
		Examples: 
		| applicationname |
		| MyWizard        |