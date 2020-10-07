@Browser 
Feature: Pre-requisites for Inbound and outbound flow 

Scenario Outline: 
	Given i login to application "<applicationname>" 
	#	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Instance Entity Rule Config" 
	Then i select client and DC for "<applicationname>" 
	And i verify and add the rules if missing for the "<toolname>" 
	
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Scrum|
