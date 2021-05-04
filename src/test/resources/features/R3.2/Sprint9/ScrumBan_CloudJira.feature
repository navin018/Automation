Feature: ScrumBan Descriptive Mertrics_CloudJira

@1WorkItemCreation_CloudJira_ScrumBan
Scenario Outline: CloudJira_WorkitemCcreation 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create a "<story>" in CloudJira 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	
 Examples: 
      | applicationname | feature             | task    | story    | risk         | issue         | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    |Sprint    |
      | Cloud Jira            | New Feature_Cloud_01 | Task_01 | Story_01 | Risk_Cloud_01 | Issue_Cloud_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_02 |Sprint_01 |


@ScrumBan_CloudJira_IBVerification_NewWI_WithActivatedDate
Scenario: ScrumBanMertrics_CloudJira_IB_Validation_NewWI_WithActivatedDateAsModifiedAtSourceOn 
		And i generate a token for "DevTest" environment 
		And i verify if "Story" has "flown with activated date same as ModifiedAtSourceOn" which was "NA" for "Cloud Jira" for "ScrumBan" functionality

@ScrumBan_CloudJira_IBVerification_New_WithoutActivatedDate		
Scenario: ScrumBanMertrics_CloudJira_IB_Validation_OldWI_WithoutActivatedDate
		And i generate a token for "DevTest" environment 
		And i verify if "Story" has "flown without activated date" which was "NA" for "Cloud Jira" for "ScrumBan" functionality
			 