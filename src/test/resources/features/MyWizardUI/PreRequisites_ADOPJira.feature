@Browser 
Feature: Pre-requisites for Inbound and outbound flow 

Scenario Outline: 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Configuration"
#	Then i select client and DC for "<applicationname>"  
	And i select the "ADOP JIRA" in Manage Product Configuration page 
#	And i navigate to "Product Instance Extension(s)" section 
#	And i add Product Instance Extension(s) details in the page for "<toolname>" 
	And i navigate to "Delivery Construct Association" section
	And i add Delivery construct association details in the page for "<toolname>"
	And i navigate to "Product Instance Entities" section
	And i add Product Instance Entities details in the page for "<toolname>"
	And i hit the save button in Product Config page
	
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |ADOP JIRA|
