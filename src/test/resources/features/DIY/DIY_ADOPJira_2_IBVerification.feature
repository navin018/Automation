@4ADOPJira_DIY_IBVerfification
Feature: ADOPJira_DIY_IBVerification 

Scenario: ADOPJIRA_Task_flow_DIY 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "flown" which was "NA" for "ADOP JIRA" for "DIY" functionality 


Scenario: ADOPJIRA_Epic_flow_DIY 

	And i verify if "Epic" has "flown" which was "NA" for "ADOP JIRA" for "DIY" functionality 


Scenario: ADOPJIRA_Story_flow_DIY 
	And i verify if "Story" has "flown" which was "NA" for "ADOP JIRA" for "DIY" functionality 


Scenario: ADOPJIRA_Risk_flow_DIY 
	And i verify if "Risk" has "flown" which was "NA" for "ADOP JIRA" for "DIY" functionality 
	 
	

Scenario: ADOPJIRA_Impediment_flow_DIY 
	And i verify if "Impediment" has "flown" which was "NA" for "ADOP JIRA" for "DIY" functionality 
	 

Scenario: ADOPJIRA_Issue_flow_DIY 
And i verify if "Issue" has "flown" which was "NA" for "ADOP JIRA" for "DIY" functionality 
	 
	
Scenario: ADOPJIRA_Bug_flow_DIY
And i verify if "Bug" has "flown" which was "NA" for "ADOP JIRA" for "DIY" functionality 
	

Scenario: ADOPJIRA_Test_flow_DIY
And i verify if "Test" has "flown" which was "NA" for "ADOP JIRA" for "DIY" functionality	

Scenario: ADOPJIRA_Feature_flow_DIY 
And i verify if "Feature" has "flown" which was "NA" for "ADOP JIRA" for "DIY" functionality 
	 
	
Scenario Outline: ADOPJIRA_DIY_IBVerification_Release_Sprint 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the "IterationExternalID" for Entities created from "tool" for tool "ADOP Jira" 
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "flown" which was "NA" for "ADOP Jira" for "DIY" functionality
	And i verify if "Sprint" has "flown" which was "NA" for "ADOP Jira" for "DIY" functionality
	
	Examples: 
		| applicationname |
		| MyWizard        |