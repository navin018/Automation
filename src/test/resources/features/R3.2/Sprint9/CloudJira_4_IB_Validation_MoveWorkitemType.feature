@6IBValidation_CloudJira_ChangeProjectOfWorkitem 
Feature: CloudJira_IB_Validation_ChangeProjectOfWorkitem 


Scenario: CloudJIRA_Task 
	Given i load the project properties file 
	And i generate a token for "DevTest" environment 
	And i verify if "Story" has "deleted" which was "Epic" for "Cloud JIRA" for "ChangeProjectFromOne" functionality 
	And i verify if "Epic" has "flown" which was "Story" for "Cloud JIRA" for "ChangeProjectToAnother" functionality