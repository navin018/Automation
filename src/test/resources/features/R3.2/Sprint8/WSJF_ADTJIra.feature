Feature: WSJF computation for ADTJira

@1WorkItemCreation_ADTJIra_WSJF 
Scenario Outline: ADTJIra_WorkitemCcreation 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create a "<Story>" in Jira for "WSJF functionality" 
	# And i create a "<Requirement>" in TFS for non-sanity
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	
	
	Examples: 
		| applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|ProductBacklog|Milestone|Requirement|
		| Jira             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 | Story_WSJF | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|ProductBacklog_wsjf|Milestone_01|Requirement_01|
		
@2ADTJira_WSJFCalculation 
Scenario: TFSScrum_WSJFCalculation 
			Given i load the project properties file 
			And i generate a token for "DevTest" environment 
			And i verify if "Story" has "flown" which was "NA" for "TFS Scrum" for "WSJF" functionality