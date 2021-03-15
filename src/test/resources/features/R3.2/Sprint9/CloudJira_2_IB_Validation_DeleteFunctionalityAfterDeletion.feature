@4IBValidation_CloudJira_DeleteFunctionality_checkFlowAfterDeleteion
Feature: CloudJira_IB_Validation_DeleteFunctionality(before delete check IB)


Scenario: CloudJIRA_Task 
	Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "deleted" which was "NA" for "Cloud JIRA" for "ChangeProjectFromOne" functionality
	

Scenario: CloudJIRA_Epic 
	And i verify if "Epic" has "deleted" which was "NA" for "Cloud JIRA" for "ChangeProjectFromOne" functionality
	
Scenario: CloudJIRA_Story 
	And i verify if "Story" has "deleted" which was "NA" for "Cloud JIRA" for "ChangeProjectFromOne" functionality
	

Scenario: CloudJIRA_Bug
	And i verify if "Bug" has "deleted" which was "NA" for "Cloud JIRA" for "ChangeProjectFromOne" functionality
	
	

Scenario: CloudJIRA_ReleaseAndSprint 
And i generate a token for "DevTest" environment
	And i verify if "ReleaseAndSprint" has "deleted" which was "NA" for "Cloud JIRA" for "ChangeProjectFromOne" functionality

	 
	 

