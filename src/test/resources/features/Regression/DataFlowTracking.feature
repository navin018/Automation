Feature: DFT for ADTJira

@1WorkItemCreation_DFT_ADTJira 
Scenario Outline: ADTJIra_WorkitemCcreation 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create a "<Story>" in Jira 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	And i put a explicit wait of "600000"
	
	
	Examples: 
		| applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|ProductBacklog|Milestone|Requirement|
		| Jira             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 | Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|ProductBacklog_wsjf|Milestone_01|Requirement_01|
		
@2ADTJira_DFT1
Scenario Outline: something
			Given i load the project properties file 
			And i generate a token for "DevTest" environment 
			And i verify if "Story" has "flown" which was "NA" for "ADT Jira" for "DFT" functionality
			Given i login to application "<applicationname>" 
			And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
			And i click on tile "Dataflow Tracking"
			And i select only the client for "<applicationname>"
			And i check the DFT details for "Inbound" details for "ADT Jira"
			And i verify the Outbound flow for "Story" details for "ADT JIRA" for "DFT" functionality 
			And i put a explicit wait of "300000"
			And i check the DFT details for "Outbound" details for "ADT Jira"
Examples: 
		| applicationname |toolname|
		| MyWizard        |ADT JIRA|