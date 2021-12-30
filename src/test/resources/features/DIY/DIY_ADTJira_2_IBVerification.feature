@4ADTJira_DIY_IBVerfification
Feature: ADTJira_DIY_IBVerification 

Scenario: ADTJIRA_Task_flow_DIY 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality 


Scenario: ADTJIRA_Epic_flow_DIY 

	And i verify if "Epic" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality 


Scenario: ADTJIRA_Story_flow_DIY 
	And i verify if "Story" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality 


Scenario: ADTJIRA_Risk_flow_DIY 
	And i verify if "Risk" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality 
	 
	

Scenario: ADTJIRA_Impediment_flow_DIY 
	And i verify if "Impediment" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality 
	 

Scenario: ADTJIRA_Issue_flow_DIY 
And i verify if "Issue" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality 
	 
	

Scenario: ADTJIRA_Bug_flow_DIY
And i verify if "Bug" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality 
	

Scenario: ADTJIRA_Feature_flow_DIY 
And i verify if "Feature" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality 
	 
	
Scenario: ADTJIRA_Deliverable_flow_DIY 
And i verify if "Deliverable" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality 
	
Scenario: ADTJIRA_Test_flow_DIY 
And i verify if "Test" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality 
	

Scenario: ADTJIRA_Requirement_flow_DIY 
And i verify if "Requirement" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality 

Scenario: ADTJIRA_Milestone_flow_DIY 
And i verify if "Milestone" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality 
	
Scenario: ADTJIRA_Action_flow_DIY
And i verify if "Action" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality

Scenario: ADTJIRA_WorkRequest_flow_DIY
And i verify if "Work Request" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality
 	
 Scenario: ADTJIRA_TestExecution_flow_DIY 
And i verify if "Test Execution" has "flown" which was "NA" for "ADT JIRA" for "DIY" functionality
	 
 	

Scenario Outline: ADTJIRA_DIY_IBVerification_Release_Sprint 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the "IterationExternalID" for Entities created from "tool" for tool "ADT Jira" 
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "flown" which was "NA" for "ADT Jira" for "DIY" functionality
	And i verify if "Sprint" has "flown" which was "NA" for "ADT Jira" for "DIY" functionality
	
		Examples: 
		| applicationname |
		| MyWizard        |
