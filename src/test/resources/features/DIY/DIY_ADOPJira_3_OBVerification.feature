@5ADOPJira_DIY_OBVerfification
Feature: ADOPJira_DIY_OBVerification 


Scenario: ADOPJIRA_Task_flow_OB_DIY
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify the Outbound flow for "Task" details for "ADOP JIRA" for "DIY" functionality 


Scenario: ADOPJIRA_Epic_flow_OB_DIY 

	And i verify the Outbound flow for "Epic" details for "ADOP JIRA" for "DIY" functionality  
 
Scenario: ADOPJIRA_Story_flow_OB_DIY 
	And i verify the Outbound flow for "Story" details for "ADOP JIRA" for "DIY" functionality 


Scenario: ADOPJIRA_Risk_flow_DIY 
	And i verify the Outbound flow for "Risk" details for "ADOP JIRA" for "DIY" functionality 
	 
	

Scenario: ADOPJIRA_Impediment_flow_DIY 
	And i verify the Outbound flow for "Impediment" details for "ADOP JIRA" for "DIY" functionality 
	 

Scenario: ADOPJIRA_Issue_flow_DIY 
And i verify the Outbound flow for "Issue" details for "ADOP JIRA" for "DIY" functionality 
	 
	

Scenario: ADOPJIRA_Bug_flow_DIY
And i verify the Outbound flow for "Bug" details for "ADOP JIRA" for "DIY" functionality 
	

Scenario: ADOPJIRA_Feature_flow_DIY 
And i verify the Outbound flow for "Feature" details for "ADOP JIRA" for "DIY" functionality 
	 
	

 	

