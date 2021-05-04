Feature: ScrumBan Descriptive Mertrics_Rally

@1WorkItemCreation_Rally_ScrumBan
Scenario Outline: Rally_WorkitemCcreation 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create a "<story>" in Rally 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	
 Examples: 
      | applicationname | feature             | task    | story    | risk         | issue         | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    |Sprint    |
      | Rally            | New Feature_Cloud_01 | Task_01 | Story_01 | Risk_Cloud_01 | Issue_Cloud_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_02 |Sprint_01 |


@ScrumBan_Rally_IBVerification_Defined_WithoutActivatedDate
Scenario: ScrumBanMertrics_Rally_IB_Validation_ChangeWIStatus_Defined 
#			Given i load the project properties file 
#			And i generate a token for "DevTest" environment 
		And i verify if "Story" has "flown without activated date" which was "NA" for "Rally" for "ScrumBan" functionality


@ScrumBan_Rally_WI_StatusMove_InProgress
Scenario Outline: Rally_changestatusofWorkitem_InProgress
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "In Progress" in Rally

	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | Rally             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|
		
@ScrumBan_Rally_IBVerification_InProgress_WithActivatedDate
Scenario: ScrumBanMertrics_Rally_IB_Validation_ChangeWIStatus_InProgress 
#			Given i load the project properties file 
			And i generate a token for "DevTest" environment 
		And i verify if "Story" has "flown with activated date" which was "NA" for "Rally" for "ScrumBan" functionality
		
@ScrumBan_Rally_WI_StatusMove_Completed
Scenario Outline: Rally_changestatusofWorkitem_Completed
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Completed" in Rally

	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | Rally             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|		


@ScrumBan_Rally_IBVerification_Completed_WithActivatedDate
Scenario: ScrumBanMertrics_Rally_IB_Validation_ChangeWIStatus_Completed
#			Given i load the project properties file 
			And i generate a token for "DevTest" environment 
		And i verify if "Story" has "flown with activated date" which was "NA" for "Rally" for "ScrumBan" functionality
	
	
@ScrumBan_Rally_WI_StatusMove_Accepted
Scenario Outline: Rally_changestatusofWorkitem_Accepted
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Accepted" in Rally

	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | Rally             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|		


@ScrumBan_Rally_IBVerification_Accepted_WithActivatedDate
Scenario: ScrumBanMertrics_Rally_IB_Validation_ChangeWIStatus_Accepted
#			Given i load the project properties file 
			And i generate a token for "DevTest" environment 
		And i verify if "Story" has "flown with activated date" which was "NA" for "Rally" for "ScrumBan" functionality
						 