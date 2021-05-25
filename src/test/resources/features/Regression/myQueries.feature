@myQueries_regression
Feature: myQueries regression 

Scenario Outline: myQueries_regression
	Given i load the project properties file
	Given i login to application "<applicationname>" 
#	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>"
	And i click on tile "my Queries"
	And i "create" the query for "<toolname>" and "<entity>" and "<workitemtype>" 
	Then i "edit" the query for "<toolname>" and "<entity>" and "<workitemtype>"
	And i "delete" the query for "<toolname>" and "<entity>" and "<workitemtype>"
	
	
	
	
	Examples: 
		| applicationname |toolname|entity	|workitemtype	|
		| MyWizard        |ADT Jira|WorkItem|Bug			|