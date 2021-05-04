Feature: WSJF computation 

@1WorkItemCreation_TFSScrum_WSJF 
Scenario Outline: TFSScrum_WorkitemCcreation 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create a "<ProductBacklog>" in TFS for "WSJF functionality" 
	#      And i create a "<Requirement>" in TFS for non-sanity
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	
	
	Examples: 
		| applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|ProductBacklog|Milestone|Requirement|
		| TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 | Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|ProductBacklog_wsjf|Milestone_01|Requirement_01|
		
@2TFSScrum_WSJFCalculation 
Scenario: TFSScrum_WSJFCalculation 
			Given i load the project properties file 
			And i generate a token for "DevTest" environment 
			And i verify if "Story" has "flown" which was "NA" for "TFS Scrum" for "WSJF" functionality
			 