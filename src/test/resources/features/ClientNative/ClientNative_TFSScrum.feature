@Browser 
Feature: Client native test for TFS Scrum

Scenario Outline: Client native test for TFS Scrum(excluding iteration)
	Given i login to application "<applicationname>" 
	#	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "mywizard-tfs" in Manage Product Configuration page 
	And i navigate to "Product Instance Entities" section 
	And i verify the ClientNative details for "<toolname>" 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Scrum|
		
Scenario Outline: Client native test for TFS Scrum(iteration)
	Given i login to application "<applicationname>" 
	#	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "mywizardinstance" in Manage Product Configuration page
	And i navigate to "Product Instance Entities" section 
	And i verify the ClientNative details for "<toolname>" 
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Scrum_Iteration|