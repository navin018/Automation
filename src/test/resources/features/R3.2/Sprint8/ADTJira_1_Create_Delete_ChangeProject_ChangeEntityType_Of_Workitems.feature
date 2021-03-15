Feature: ADTJira Delete functionality
@Delete_TestData_ADTJira_DeleteFunctionality      
Scenario Outline: Delete_TestData_ADTJira
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i delete the test automation data for "workitems" for "<applicationname>" 
	And i delete the test automation data for "release" for "<applicationname>" 
	And i delete the test automation data for "sprint" for "<applicationname>" 

    Examples: 
      | applicationname |
      |ADT Jira         | 
      
      

@1WorkItemCreation_ADTJira_DeleteFunctionality		
Scenario Outline: ADTJIRA_WorkitemCreationInUI
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
	And i create an "<Release>" in Jira 
	And i create an "<Sprint>" in Jira 
#	And i create an "<Team>" in Jira 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	And i check the overall status of workitem creation for "<applicationname>"
	And i put a explicit wait of "900000" 
	And i generate a token for "DevTest" environment 
	
	
	Examples: 
		| applicationname | task    | story    | risk    |Requirement| Test|issue    | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    | Sprint    |Team|milestone|TestExecution|Action|TestForTestExec|WorkRequest|
		| Jira            | Task_01 | Story_01 | Risk_01 | Requirement_01| Test_01|Issue_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 | Sprint_01 |Team_01|Milestone_01|Test Execution_01|Action_01|TestForTestExec_01|Work Request_01|

@2ChangeProjectOfWorkItems_ADTJira
Scenario Outline: ADTJIRA_ChangeProjectOfWorkitems
Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i change the "project" of "<task>" in "<applicationname>"
	And i change the "project" of "<bug>" in "<applicationname>"
	And i change the "project" of "<milestone>" in "<applicationname>"
	And i change the "project" of "<Action>" in "<applicationname>"
	And i change the "project" of "<deliverable>" in "<applicationname>"
	And i change the "project" of "<Requirement>" in "<applicationname>"
	And i change the "project" of "<Test>" in "<applicationname>"
	And i change the "project" of "<WorkRequest>" in "<applicationname>"

	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for "moveProjectOrIssue" functionality
	Examples: 
		| applicationname | task    | story    | risk    |Requirement| Test|issue    | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    | Sprint    |Team|milestone|TestExecution|Action|TestForTestExec|WorkRequest|
		| ADT Jira            | Task_01 | Story_01 | Risk_01 | Requirement_01| Test_01|Issue_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 | Sprint_01 |Team_01|Milestone_01|Test Execution_01|Action_01|TestForTestExec_01|Work Request_01|

@3ChangeEntityTypeOfWorkItems_ADTJira
Scenario Outline: ADTJIRA_ChangeProjectOfWorkitems
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i change the "entitytype" of "<story>" to "<WorkRequest>" in "<applicationname>" 
	And i change the "entitytype" of "<Action>" to "<task>" in "<applicationname>" 
	And i change the "entitytype" of "<bug>" to "<deliverable>" in "<applicationname>" 
	And i change the "entitytype" of "<Requirement>" to "<feature>" in "<applicationname>"
	
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for "moveProjectOrIssue" functionality
	Examples: 
		| applicationname | task    | story    | risk    |Requirement| Test|issue    | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    | Sprint    |Team|milestone|TestExecution|Action|TestForTestExec|WorkRequest|
		| ADT Jira            | Task_01 | Story_01 | Risk_01 | Requirement_01| Test_01|Issue_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 | Sprint_01 |Team_01|Milestone_01|Test Execution_01|Action_01|TestForTestExec_01|Work Request_01|



