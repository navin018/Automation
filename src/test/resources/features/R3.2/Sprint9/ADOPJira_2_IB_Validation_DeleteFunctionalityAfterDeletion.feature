@4IBValidation_ADOPJira_DeleteFunctionality_checkFlowafterDeleteion
Feature: ADOPJira_IB_Validation_DeleteFunctionality(after delete check IB)


Scenario: ADOPJIRA_Task_flow_afterDelete 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "deleted" which was "NA" for "ADOP JIRA" for "delete" functionality 


Scenario: ADOPJIRA_Epic_flow_afterDelete 

	And i verify if "Epic" has "deleted" which was "NA" for "ADOP JIRA" for "delete" functionality 

	

Scenario: ADOPJIRA_Story_flow_afterDelete 
	And i verify if "Story" has "deleted" which was "NA" for "ADOP JIRA" for "delete" functionality 


Scenario: ADOPJIRA_Risk_flow_afterDelete 
	And i verify if "Risk" has "deleted" which was "NA" for "ADOP JIRA" for "delete" functionality 
	 
	

Scenario: ADOPJIRA_Impediment_flow_afterDelete 
	And i verify if "Impediment" has "deleted" which was "NA" for "ADOP JIRA" for "delete" functionality 
	 

Scenario: ADOPJIRA_Issue_flow_afterDelete 
And i verify if "Issue" has "deleted" which was "NA" for "ADOP JIRA" for "delete" functionality 
	 
	

Scenario: ADOPJIRA_Bug_flow_afterDelete
And i verify if "Bug" has "deleted" which was "NA" for "ADOP JIRA" for "delete" functionality 


	 
Scenario Outline:  ADOPJIRA_ReleaseAndSprint_flow_afterDelete  
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the IterationExternalID for deleted Iteration created from "tool" for tool "ADOP Jira" 
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "deleted" which was "NA" for "ADOP Jira" for "Normal" functionality
	And i verify if "Sprint" has "deleted" which was "NA" for "ADOP Jira" for "Normal" functionality
	
		Examples: 
		| applicationname |toolname|
		| MyWizard        |ADOP JIRA|
