@7IBValidation_ADTJira_ChangeWorkitemItemType
Feature: ADTJira_IB_Validation_ChangeProjectOfWorkitem


Scenario: ADTJIRA_ChangeWorkItemType(StoryToWorkRequest)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Story" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality
	And i verify if "WorkRequest" has "flown" which was "Story" for "ADT JIRA" for "delete" functionality
	
Scenario: ADTJIRA_ChangeWorkItemType(ActionToTask)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Action" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality
	And i verify if "Task" has "flown" which was "Action" for "ADT JIRA" for "delete" functionality
	
Scenario: ADTJIRA_ChangeWorkItemType(BugToDeliverable)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Bug" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality
	And i verify if "Deliverable" has "flown" which was "Bug" for "ADT JIRA" for "delete" functionality
	
Scenario: ADTJIRA_ChangeWorkItemType(RequirementToFeature)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Requirement" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality
	And i verify if "Feature" has "flown" which was "Requirement" for "ADT JIRA" for "delete" functionality
	
	