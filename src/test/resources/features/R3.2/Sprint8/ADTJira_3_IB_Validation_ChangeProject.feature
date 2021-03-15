@6IBValidation_ADTJira_ChangeProjectOfWorkitem
Feature: ADTJira_IB_Validation_ChangeProjectOfWorkitem

Scenario: ADTJIRA_TaskFlow_ProjectChange 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "deleted" which was "NA" for "ADT JIRA" for "ChangeProjectFromOne" functionality 
	And i verify if "Task" has "flown" which was "NA" for "ADT JIRA" for "ChangeProjectToAnother" functionality 

Scenario: ADTJIRA_BugFlow_ProjectChange 
	And i verify if "Bug" has "deleted" which was "NA" for "ADT JIRA" for "ChangeProjectFromOne" functionality 
	And i verify if "Bug" has "flown" which was "NA" for "ADT JIRA" for "ChangeProjectToAnother" functionality 

Scenario: ADTJIRA_MilestoneFlow_ProjectChange 
	And i verify if "Milestone" has "deleted" which was "NA" for "ADT JIRA" for "ChangeProjectFromOne" functionality 
	And i verify if "Milestone" has "flown" which was "NA" for "ADT JIRA" for "ChangeProjectToAnother" functionality 

Scenario: ADTJIRA_ActionFlow_ProjectChange 
	And i verify if "Action" has "deleted" which was "NA" for "ADT JIRA" for "ChangeProjectFromOne" functionality 
	And i verify if "Action" has "flown" which was "NA" for "ADT JIRA" for "ChangeProjectToAnother" functionality 

Scenario: ADTJIRA_RequirementFlow_ProjectChange 
	And i verify if "Requirement" has "deleted" which was "NA" for "ADT JIRA" for "ChangeProjectFromOne" functionality 
	And i verify if "Requirement" has "flown" which was "NA" for "ADT JIRA" for "ChangeProjectToAnother" functionality 

Scenario: ADTJIRA_BugFlow_ProjectChange 
	And i verify if "Bug" has "deleted" which was "NA" for "ADT JIRA" for "ChangeProjectFromOne" functionality 
	And i verify if "Bug" has "flown" which was "NA" for "ADT JIRA" for "ChangeProjectToAnother" functionality 

Scenario: ADTJIRA_TestFlow_ProjectChange 
	And i verify if "Test" has "deleted" which was "NA" for "ADT JIRA" for "ChangeProjectFromOne" functionality 
	And i verify if "Test" has "flown" which was "NA" for "ADT JIRA" for "ChangeProjectToAnother" functionality 

Scenario: ADTJIRA_WorkRequestFlow_ProjectChange 
	And i verify if "WorkRequest" has "deleted" which was "NA" for "ADT JIRA" for "ChangeProjectFromOne" functionality 
	And i verify if "WorkRequest" has "flown" which was "NA" for "ADT JIRA" for "ChangeProjectToAnother" functionality 

