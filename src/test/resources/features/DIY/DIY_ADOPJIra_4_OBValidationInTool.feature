Feature: ADOPJira_OB_ToolValidation_DIY 

@6ADOPJira_OB_ValidationInTool_DIY 
Scenario Outline: ADOPJira_OB_ValidationInTool_DIY 
	And i put a explicit wait of "600000" 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i validate the outbound flow for "<applicationname>" 
	
	Examples: 
		| applicationname | 
		| ADOP Jira            | 