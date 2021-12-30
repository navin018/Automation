@3IBValidation_CloudJira_DeleteFunctionality_checkFlowBeforeDeleteion
Feature: CloudJira_IB_Validation_DeleteFunctionality(before delete check IB)

@Taa
Scenario: CloudJIRA_Task 
	Given i load the project properties file 
	And i generate a token for "DevTest" environment 
	And i verify if "Task" has "flown" which was "NA" for "Cloud JIRA" for "ChangeProjectFromOne" functionality
	

Scenario: CloudJIRA_Epic 
	And i verify if "Epic" has "flown" which was "NA" for "Cloud JIRA" for "ChangeProjectFromOne" functionality
	
Scenario: CloudJIRA_Story 
	And i verify if "Story" has "flown" which was "NA" for "Cloud JIRA" for "ChangeProjectFromOne" functionality
	

Scenario: CloudJIRA_Bug
	And i verify if "Bug" has "flown" which was "NA" for "Cloud JIRA" for "ChangeProjectFromOne" functionality
	
	
Scenario: CloudJIRA_ReleaseAndSprint 
And i generate a token for "DevTest" environment
	And i verify if "ReleaseAndSprint" has "flown" which was "NA" for "Cloud JIRA" for "ChangeProjectFromOne" functionality

	 
 Scenario Outline:  CloudJIRA_ReleaseAndSprint
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the "IterationExternalID" for Entities created from "tool" for tool "Cloud Jira" 
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "flown" which was "NA" for "Cloud Jira" for "Normal" functionality
	And i verify if "Sprint" has "flown" which was "NA" for "Cloud Jira" for "Normal" functionality
	
		Examples: 
		| applicationname |toolname|
		| MyWizard        |Cloud JIRA|

