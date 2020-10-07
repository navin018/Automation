@ADTJira_WorkitemCreation 
Feature: ADTJira_WorkitemCcreation 

Scenario Outline: ADTJira_WorkitemCcreation 
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
	And i create a "<subtask>" in Jira 
	And i create an "<Release>" in Jira 
	And i create an "<Sprint>" in Jira 
	And i create an "<Team>" in Jira 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	And i put a explicit wait of "600000" 
	
	Examples: 
		| applicationname | task    | story    | risk    |Requirement| Test|issue    | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    | Sprint    |Team|
		| Jira            | Task_01 | Story_01 | Risk_01 | Requirement_01| Test_01|Issue_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 | Sprint_01 |Team_01|
