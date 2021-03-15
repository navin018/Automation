@6IBValidation_ADOPJira_ChangeWorkitemItemType
Feature: ADOPJira_IB_Validation_ChangeProjectOfWorkitem

 
Scenario: ADOPJIRA_ChangeWorkItemType(StoryToWorkRequest)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Risk" has "deleted" which was "NA" for "ADOP JIRA" for "delete" functionality
	And i verify if "Impediment" has "flown" which was "Risk" for "ADOP JIRA" for "delete" functionality
	
Scenario: ADOPJIRA_ChangeWorkItemType(EpicToBug)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Epic" has "deleted" which was "NA" for "ADOP JIRA" for "delete" functionality
	And i verify if "Bug" has "flown" which was "Epic" for "ADOP JIRA" for "delete" functionality
	
