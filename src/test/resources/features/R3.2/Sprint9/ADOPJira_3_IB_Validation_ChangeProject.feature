@5IBValidation_ADOPJira_ChangeProjectOfWorkitem
Feature: ADOPJira_IB_Validation_ChangeProjectOfWorkitem


Scenario: ADOPJIRA_TaskFlow_ProjectChange 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "deleted" which was "NA" for "ADOP JIRA" for "ChangeProjectFromOne" functionality 
	And i verify if "Task" has "flown" which was "NA" for "ADOP JIRA" for "ChangeProjectToAnother" functionality 

Scenario: ADOPJIRA_StoryFlow_ProjectChange 
	And i verify if "Story" has "deleted" which was "NA" for "ADOP JIRA" for "ChangeProjectFromOne" functionality 
	And i verify if "Story" has "flown" which was "NA" for "ADOP JIRA" for "ChangeProjectToAnother" functionality 
