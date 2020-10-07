@SEI_ADTJira 
Feature: SEI_Validation_ADTJira 

Scenario Outline: SEI_ADTJira_IB_Pipelines 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "ADT JIRA" in Manage Product Configuration page 
	And i check if the field "RealTimeConfigChanges" is "Enabled" 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i verify the existing "IB" pipelines if present and add them if missing for "<toolname>" 
	And i hit the save button in Product Config page 
	And i select the "ADT JIRA" in Manage Product Configuration page 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i deploy the pipelines and verify if successful for "<toolname>" 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |ADT JIRA|
		
Scenario Outline: SEI_ADTJira_OB_Pipelines 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select only the client for "<applicationname>" 
	And i select the "<toolname>" in Manage Product Configuration page 
	And i check if the field "RealTimeConfigChanges" is "Enabled" 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i verify the existing "OB" pipelines if present and add them if missing for "<toolname>" 
	And i hit the save button in Product Config page 
	And i select the "ADT JIRA" in Manage Product Configuration page 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i deploy the pipelines and verify if successful for "<toolname>" 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |ADT JIRA|
