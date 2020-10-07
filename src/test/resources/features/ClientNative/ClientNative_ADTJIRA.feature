@ClientNative_ADTJira 
Feature: Client_Native_ADTJIRA 

Scenario Outline: Client_Native_ADTJIRA 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "ADT JIRA" in Manage Product Configuration page 
	And i navigate to "Product Instance Entities" section 
	And i verify the ClientNative details for "<toolname_Sheet>" 
	
	Examples: 
		| applicationname |toolname_Sheet|
		| MyWizard        |ADT JIRA|
		
Scenario Outline: Client_Native_ADTJIRA(iteration) 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "mywizardinstance" in Manage Product Configuration page 
	And i navigate to "Product Instance Entities" section 
	And i verify the ClientNative details for "<toolname_Sheet>" 
	
	Examples: 
		| applicationname |toolname_Sheet|
		| MyWizard        |ADT JIRA_Iteration|