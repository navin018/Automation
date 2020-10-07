@Pre
Feature: Pre-Requisites_ADTJIRA_Validation

Scenario: ProdConfigCheck_ADTJIRA 

	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage"
	And i click on tile "Product Configuration" 
	Then i select client and DC for "MyWizard" 
	And i select the "ADT JIRA" in Manage Product Configuration page 
	And i navigate to "Product Instance Extension(s)" section 
	And i add Product Instance Extension(s) details in the page for "ADT JIRA" 
	And i hit the save button in Product Config page 
	And i select the "ADT JIRA" in Manage Product Configuration page 
	And i navigate to "Delivery Construct Association" section 
	And i add Delivery construct association details in the page for "ADT JIRA" 
	And i navigate to "Product Instance Entities" section 
	And i add Product Instance Entities details in the page for "ADT JIRA" 
	And i hit the save button in Product Config page 
	
#	Examples: 
#		| applicationname |toolname|
#		| MyWizard        |ADT JIRA|

