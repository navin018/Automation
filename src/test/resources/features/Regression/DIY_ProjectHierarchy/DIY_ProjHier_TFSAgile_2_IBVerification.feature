@4TFSAgile_DIY_IBVerfification
Feature: TFSAgile_DIY_IBVerification 


Scenario: TFSAgile_Story_flow_DIY 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Story" has "flown" which was "NA" for "TFS Agile" for "DIY" functionality  


Scenario: TFSAgile_Action_flow_DIY 
And i verify if "Action" has "flown" which was "NA" for "TFS Agile" for "DIY" functionality 
	
Scenario Outline: TFSAgile_DIY_IBVerification_Release_Sprint
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the "IterationExternalID" for Entities created from "tool" for tool "TFS Agile" 
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "flown" which was "NA" for "TFS Agile" for "DIY" functionality
	And i verify if "Sprint" has "flown" which was "NA" for "TFS Agile" for "DIY" functionality
	
		Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile|
