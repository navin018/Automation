@4IBValidation_ADTJira_DeleteFunctionality_checkFlowBeforeDeleteion
Feature: ADTJira_IB_Validation_DeleteFunctionality(before delete check IB)


Scenario: ADTJIRA_Task_flow_beforeDelete 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality 


Scenario: ADTJIRA_Epic_flow_beforeDelete 

	And i verify if "Epic" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality 

	

Scenario: ADTJIRA_Story_flow_beforeDelete 
	And i verify if "Story" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality 


Scenario: ADTJIRA_Risk_flow_beforeDelete 
	And i verify if "Risk" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality 
	 
	

Scenario: ADTJIRA_Impediment_flow_beforeDelete 
	And i verify if "Impediment" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality 
	 

Scenario: ADTJIRA_Issue_flow_beforeDelete 
And i verify if "Issue" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality 
	 
	

Scenario: ADTJIRA_Bug_flow_beforeDelete
And i verify if "Bug" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality 
	

Scenario: ADTJIRA_Feature_flow_beforeDelete 
And i verify if "Feature" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality 
	 
	
Scenario: ADTJIRA_Deliverable_flow_beforeDelete 
And i verify if "_Deliverable" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality 
	
Scenario: ADTJIRA_Test_flow_beforeDelete 
And i verify if "Test" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality 
	

Scenario: ADTJIRA_Requirement_flow_beforeDelete 
And i verify if "Requirement" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality 
	 
	

Scenario: ADTJIRA_Milestone_flow_beforeDelete 
And i verify if "Milestone" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality 
	
Scenario: ADTJIRA_Action_flow_beforeDelete
And i verify if "Action" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality 	
	
#confirm with swetha	
#Scenario: ADTJIRA_TestExecution_flow_beforeDelete 
#And i verify if "TestExecution" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality
	
Scenario: ADTJIRA_WorkRequest_flow_beforeDelete
And i verify if "Work Request" has "flown" which was "NA" for "ADT JIRA" for "delete" functionality
 


Scenario Outline: ADTJIRA_ReleaseAndSprint_flow_beforeDelete
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the IterationExternalID for Iteration created from "tool" for tool "ADT Jira" 
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "flown" which was "NA" for "ADT Jira" for "Normal" functionality
	And i verify if "Sprint" has "flown" which was "NA" for "ADT Jira" for "Normal" functionality
	
		Examples: 
		| applicationname |toolname|
		| MyWizard        |ADT JIRA|

	 
	 

