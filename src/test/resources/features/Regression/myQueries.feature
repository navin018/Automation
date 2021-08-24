@myQueries_regression
Feature: myQueries regression

Scenario Outline: Create edit query-Regression 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	Then i select client and DC for "<applicationname>" 
	And i click on tile "my Queries" 
	And i "create" the query for "<toolname>" and "<entity>" and "<workitemtype>" 
	Then i "edit" the query for "<toolname>" and "<entity>" and "<workitemtype>" 
	And i "edit" the column options for "<toolname>" and "<entity>" and "<workitemtype>" 
	And i "delete" the query for "<toolname>" and "<entity>" and "<workitemtype>" 
	Examples: 
		| applicationname |toolname|entity |workitemtype |
		| MyWizard |ADT Jira|WorkItem|UserStory |

Scenario Outline: Validate the visibility of Shared query 
	Given i load the project properties file 
	Given i login to application "<applicationname>" using "testuser02art@ds.dev.accenture.com" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	Then i select client and DC for "<applicationname>" 
	And i click on tile "my Queries" 
	And i verify the shared query 
	Examples: 
		| applicationname |toolname|
		| MyWizard |ADT Jira| 
		
	Scenario Outline: delete query 
		Given i login to application "<applicationname>" 
		And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
		Then i select client and DC for "<applicationname>" 
		And i click on tile "my Queries" 
		And i "delete" the query for "<toolname>" and "<entity>" and "<workitemtype>" 
		Examples: 
			| applicationname |toolname|entity |workitemtype |
			| MyWizard |ADT Jira|WorkItem|UserStory |