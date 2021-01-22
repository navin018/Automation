Feature: TFS Scrum_OB_Tool Validation 

@8TFSScrum_OB_ValidationInTool 
Scenario Outline: TFSScrum_OB_ValidationInTool 
	And i put a explicit wait of "600000" 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i validate the outbound flow for "<applicationname>" 
	
	Examples: 
		| applicationname | 
		| TFS Scrum            |