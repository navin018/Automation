@3IBValidation_ADOPJira_DeleteFunctionality_checkFlowBeforeDeleteion
Feature: ADOPJira_IB_Validation_DeleteFunctionality(before delete check IB)


Scenario: ADOPJIRA_Task_flow_beforeDelete 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "flown" which was "NA" for "ADOP JIRA" for "delete" functionality 


Scenario: ADOPJIRA_Epic_flow_beforeDelete 

	And i verify if "Epic" has "flown" which was "NA" for "ADOP JIRA" for "delete" functionality 

	

Scenario: ADOPJIRA_Story_flow_beforeDelete 
	And i verify if "Story" has "flown" which was "NA" for "ADOP JIRA" for "delete" functionality 


Scenario: ADOPJIRA_Risk_flow_beforeDelete 
	And i verify if "Risk" has "flown" which was "NA" for "ADOP JIRA" for "delete" functionality 
	 
	

Scenario: ADOPJIRA_Impediment_flow_beforeDelete 
	And i verify if "Impediment" has "flown" which was "NA" for "ADOP JIRA" for "delete" functionality 
	 

Scenario: ADOPJIRA_Issue_flow_beforeDelete 
And i verify if "Issue" has "flown" which was "NA" for "ADOP JIRA" for "delete" functionality 
	 
	

Scenario: ADOPJIRA_Bug_flow_beforeDelete
And i verify if "Bug" has "flown" which was "NA" for "ADOP JIRA" for "delete" functionality 


Scenario: ADOPJIRA_ReleaseAndSprint_flow_beforeDelete 
And i verify if "ReleaseAndSprint" has "flown" which was "NA" for "ADOP JIRA" for "delete" functionality
	 
	 

