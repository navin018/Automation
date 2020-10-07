@Browser 
Feature: MSPS SEI 

Scenario Outline: 
	Given i login to application "<applicationname>" 
#	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	Then i select only the client for "<applicationname>" 
	And i click on tile "Product Configuration" 
	And i select the "mywizardMSPS" in Manage Product Configuration page 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i verify the existing "IB" pipelines if present and add them if missing for "<toolname>" 
	And i verify the existing "OB" pipelines if present and add them if missing for "<toolname>" 
	And i hit the save button in Product Config page 
	And i select the "mywizardMSPS" in Manage Product Configuration page 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i deploy the pipelines and verify if successful for "<toolname>"
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |mywizardMSPS|
