@TeamConfiguration_regression
Feature: Team configuration regression 

Scenario Outline: Team configuration_regression
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>"
	And i click on tile "Team Configuration"
	Then i want to "create" a team for "<toolname>"
	And i want to "edit" a team for "<toolname>"
	And i want to "delete" a team for "<toolname>"
	
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |ADOP Jira|