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
	
	Examples: 
		| applicationname |toolname|entity |workitemtype |
		| MyWizard |ADT Jira|WorkItem|UserStory |
		
@verify_standardQuery		
Scenario Outline: Verify dropdown for non-workitems appears or not,Verify delete under select deletes the query,Verify column added using column option,Modify saved query location using SaveAS option
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	Then i select client and DC for "<applicationname>" 
	And i click on tile "my Queries" 
	And i "verify" the query for "<toolname>" and "<entity>" 

	
	Examples: 
		| applicationname |toolname|entity |
		| MyWizard |ADT Jira|WorkItem|


@verify_advanced_query	
Scenario Outline: Verify dropdown for non-workitems
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	Then i select client and DC for "<applicationname>" 
	And i click on tile "my Queries" 
	And i "verify_Advance_query" the query for "<toolname>" and "<entity>" 

	
	Examples: 
		| applicationname |toolname|entity |
		| MyWizard |ADT Jira|WorkItem|


Scenario Outline: Create edit query-Regression 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	Then i select client and DC for "<applicationname>" 
	And i click on tile "my Queries" 
	And i "create" the query for "<toolname>" and "<entity>" and "<workitemtype>" 
	Then i "edit" the query for "<toolname>" and "<entity>" and "<workitemtype>" 
	And i "edit" the column options for "<toolname>" and "<entity>" and "<workitemtype>" 
	
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
			
Scenario Outline: Validate the visibility of Product Instances
	Given i load the project properties file
	Given i login to application "<applicationname>"
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select only the client for "<applicationname>"
	And i click on tile "my Queries"
	Then i create the query and validate the product instance 
	
Examples: 
		| applicationname |
		| MyWizard        |