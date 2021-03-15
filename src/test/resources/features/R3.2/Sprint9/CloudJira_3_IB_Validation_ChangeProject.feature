@5IBValidation_CloudJira_ChangeProjectOfWorkitem 
Feature: CloudJira_IB_Validation_ChangeProjectOfWorkitem 


Scenario: CloudJIRA_Task_WorktitemProjectChangedFromOldToNew 
	And i generate a token for "DevTest" environment 
	And i verify if "Task" has "flown" which was "NA" for "Cloud JIRA" for "ChangeProjectToAnother" functionality 
	And i verify if "Task" has "deleted" which was "NA" for "Cloud JIRA" for "ChangeProjectFromOne" functionality 
	