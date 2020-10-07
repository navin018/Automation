@Browser 
Feature: SEI TFS Agile

Scenario Outline: TFS Agile IB SEI 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "Mywizard-TFS" in Manage Product Configuration page 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i verify the existing "IB" pipelines if present and add them if missing for "<toolname>" 
	And i hit the save button in Product Config page 
	And i select the "Mywizard-TFS" in Manage Product Configuration page 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i deploy the pipelines and verify if successful for "<toolname>" 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile|
		
		
Scenario Outline: TFS Agile OB SEI 
	Given i login to application "<applicationname>" 
	And i click on tile "Product Configuration" 
	Then i select only the client for "<applicationname>" 
	And i select the "Mywizard-TFS" in Manage Product Configuration page 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i verify the existing "OB" pipelines if present and add them if missing for "<toolname>" 
	And i hit the save button in Product Config page 
	And i select the "Mywizard-TFS" in Manage Product Configuration page 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i deploy the pipelines and verify if successful for "<toolname>" 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile|
