Feature: ScrumBan Descriptive Mertrics_ADTJira

@1WorkItemCreation_ADTJira_ScrumBan
Scenario Outline: TFSScrum_WorkitemCcreation 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	 And i create a "<story>" in Jira 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	
Examples: 
		| applicationname | task    | story    | risk    |Requirement| Test|issue    | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    | Sprint    |Team|milestone|TestExecution|Action|TestForTestExec|WorkRequest|
		| Jira            | Task_01 | Story_01 | Risk_01 | Requirement_01| Test_01|Issue_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 | Sprint_01 |Team_01|Milestone_01|Test Execution_01|Action_01|TestForTestExec_01|Work Request_01|


@ScrumBan_ADTJira_IBVerification_NewWI_WithActivatedDate
Scenario: ScrumBanMertrics_ADTJira_IB_Validation_NewWI_WithActivatedDateAsModifiedAtSourceOn 
		And i generate a token for "DevTest" environment 
		And i verify if "Story" has "flown with activated date same as ModifiedAtSourceOn" which was "NA" for "ADT Jira" for "ScrumBan" functionality

@ScrumBan_ADTJira_IBVerification_New_WithoutActivatedDate		
Scenario: ScrumBanMertrics_ADTJira_IB_Validation_OldWI_WithoutActivatedDate
		And i generate a token for "DevTest" environment 
		And i verify if "Story" has "flown without activated date" which was "NA" for "ADT Jira" for "ScrumBan" functionality
			 