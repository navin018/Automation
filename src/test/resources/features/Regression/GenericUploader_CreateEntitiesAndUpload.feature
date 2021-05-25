Feature: GenericUploader


@1WorkItemCreation_ADTJira_GenericUploader		
Scenario Outline: ADTJIRA_WorkitemCreationInUI
	Given i load the project properties file 
#	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create a "<epic>" in Jira 
	And i create a "<feature>" in Jira 
	And i create a "<task>" in Jira 
	And i create a "<risk>" in Jira 
	And i create a "<bug>" in Jira 
	And i create a "<issue>" in Jira 
	And i create a "<impediment>" in Jira 
	And i create a "<Action>" in Jira 
	And i create an "<Release>" in Jira 
	And i create an "<Sprint>" in Jira 
 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	And i check the overall status of workitem creation for "<applicationname>"
#	And i put a explicit wait of "900000" 
#	And i generate a token for "DevTest" environment 
	
	
	Examples: 
		| applicationname | task    | story    | risk    |Requirement| Test|issue    | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    | Sprint    |Team|milestone|TestExecution|Action|TestForTestExec|WorkRequest|
		| Jira            | Task_01 | Story_01 | Risk_01 | Requirement_01| Test_01|Issue_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 | Sprint_01 |Team_01|Milestone_01|Test Execution_01|Action_01|TestForTestExec_01|Work Request_01|


@2GenericUploader_ADTJira
Scenario Outline: GenericUploader_ADTJira
	Given i load the project properties file 
#	Given i login to application "<applicationname>" 
#	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
#	Then i select client and DC for "<applicationname>" 
#	And i click on tile "my Queries"
#	Then i select client and DC for "<applicationname>"
#	And i capture the IterationExternalID for Iteration created from "tool" for tool "ADT Jira" 
#	And i click on "backtodashboard" button
#	And i prepare the excel data for tool "ADT Jira" in "Generic Uploader" DataLoader
	And i prepare the excel data for tool "myWizardInstance" in "Generic Uploader" DataLoader 
	And i click on tile "Generic Uploader"
	Then i select client and DC for "<applicationname>"
#	And i select the Product Instance as "ADT JIRA"
#	And i select the Data Entity as "Epic" for "ADT Jira" and upload the excel file
#	And i select the Data Entity as "Feature" and upload the excel file
#	And i select the Data Entity as "Task" and upload the excel file
#	And i select the Data Entity as "Bug" and upload the excel file
#	And i select the Data Entity as "Issue" and upload the excel file
#	And i select the Data Entity as "Impediment" and upload the excel file
#	And i select the Data Entity as "Risk" and upload the excel file
#	And i select the Data Entity as "Action" and upload the excel file 
#	And i select the Data Entity as "Iteration" and upload the excel file 	
	And i select the Product Instance as "myWizardInstance"
	And i select the Data Entity as "Decision" and upload the excel file
	And i select the Data Entity as "IterationForMyWizardInstance" and upload the excel file
	Examples: 
		| applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|ProductBacklog|Milestone|Requirement|
		| Jira             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 | Story_WSJF | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|ProductBacklog_wsjf|Milestone_01|Requirement_01|
		
@3GenericUploader_NoToolInstance
Scenario Outline: GenericUploader_NoTool
	Given i load the project properties file 
#	Given i login to application "<applicationname>" 
#	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i prepare the excel data for tool "NoToolInstance" in "Generic Uploader" DataLoader
	 
	And i click on tile "Generic Uploader"
	Then i select client and DC for No Tool Instance 
	And i select the Product Instance as "myWizardInstance"
	And i select the Data Entity as "Epic" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Feature" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Task" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Bug" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Issue" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Impediment" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Risk" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Action" for "noToolInstance" and upload the excel file 
#	And i select the Data Entity as "Iteration" and upload the excel file 	

	
	Examples: 
		| applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|ProductBacklog|Milestone|Requirement|
		| Jira             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 | Story_WSJF | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|ProductBacklog_wsjf|Milestone_01|Requirement_01|
		
		