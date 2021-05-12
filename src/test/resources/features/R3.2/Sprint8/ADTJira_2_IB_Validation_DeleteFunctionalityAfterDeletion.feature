@5IBValidation_ADTJira_DeleteFunctionality_checkFlowAfterDeleteion
Feature: ADTJira_IB_Validation_DeleteFunctionality(after delete check IB)



Scenario: ADTJIRA_Task_flow_afterDelete 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality 


Scenario: ADTJIRA_Epic_flow_afterDelete 

	And i verify if "Epic" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality 

Scenario: ADTJIRA_Story_flow_afterDelete 
	And i verify if "Story" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality 


Scenario: ADTJIRA_Risk_flow_afterDelete 
	And i verify if "Risk" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality 
	 
	
Scenario: ADTJIRA_Impediment_flow_afterDelete 
	And i verify if "Impediment" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality 
	 

Scenario: ADTJIRA_Issue_flow_afterDelete 
And i verify if "Issue" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality 
	 
	

Scenario: ADTJIRA_Bug_flow_afterDelete
And i verify if "Bug" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality 
	

Scenario: ADTJIRA_Feature_flow_afterDelete 
And i verify if "Feature" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality 
	 
	
Scenario: ADTJIRA_Deliverable_flow_afterDelete 
And i verify if "Deliverable" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality 
	
#Scenario: ADTJIRA_Test_flow_afterDelete 
#And i verify if "Test" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality 
	

Scenario: ADTJIRA_Requirement_flow_afterDelete 
And i verify if "Requirement" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality 
	 
	

Scenario: ADTJIRA_Milestone_flow_afterDelete 
And i verify if "Mielstone" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality 
	
Scenario: ADTJIRA_Action
And i verify if "Action" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality 	
	
Scenario: ADTJIRA_WorkRequest_flow_afterDelete
And i verify if "Work Request" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality
	
#confirmthis
#Scenario: ADTJIRA_TestExecution_flow_afterDelete 
#And i verify if "TestExecution" has "deleted" which was "NA" for "ADT JIRA" for "delete" functionality
	 
Scenario Outline: ADTJIRA_ReleaseAndSprint_flow_AfterDelete
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the IterationExternalID for deleted Iteration created from "tool" for tool "ADT Jira" 
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "deleted" which was "NA" for "ADT Jira" for "Normal" functionality
	And i verify if "Sprint" has "deleted" which was "NA" for "ADT Jira" for "Normal" functionality
	
		Examples: 
		| applicationname |toolname|
		| MyWizard        |ADT JIRA|

