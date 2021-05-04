Feature: ScrumBan Descriptive Mertrics_TFSScrum

@1WorkItemCreation_TFSScrum_ScrumBan
Scenario Outline: TFSScrum_WorkitemCcreation 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create a "<ProductBacklog>" in TFS
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	
	
	Examples: 
		| applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|ProductBacklog|Milestone|Requirement|
		| TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 | Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|ProductBacklog_01|Milestone_01|Requirement_01|
		
@1WorkItemCreation_TFSScrum_ScrumBan
Scenario Outline: ScrumBanMertrics_TFSScrum_WorkitemCreation 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
 	And i create a "<Story>" in TFS
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	
	
	    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

@ScrumBan_TFSScrum_IBVerification_New_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_New
#			And i generate a token for "DevTest" environment 
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality

@ScrumBan_TFSScrum_WI_StatusMove_NewToApproved
Scenario Outline: TFSScrum_changestatusofWorkitem_NewToApproved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Approved" in TFS
	
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_NewToApproved_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_NewToApproved
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
		 
		 
@ScrumBan_TFSScrum_WI_StatusMove_DoneToCommitted
Scenario Outline: TFSScrum_changestatusofWorkitem_DoneToCommitted
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Done" in TFS
	And i update the status of "<Story>" to "Committed" in TFS	
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_DoneToCommitted_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_DoneToCommitted
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality

@ScrumBan_TFSScrum_WI_StatusMove_NewToCommitted
Scenario Outline: TFSScrum_changestatusofWorkitem_NewToCommitted
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Committed" in TFS	
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_NewToCommitted_WithActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_NewToCommitted
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
	
	
@ScrumBan_TFSScrum_WI_StatusMove_ApprovedToCommitted
Scenario Outline: TFSScrum_changestatusofWorkitem_ApprovedToCommitted
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Approved" in TFS
	And i update the status of "<Story>" to "Committed" in TFS	
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_ApprovedToCommitted_WithActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_ApprovedToCommitted
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality

@ScrumBan_TFSScrum_WI_StatusMove_CommittedToDoneToCommitted
Scenario Outline: TFSScrum_changestatusofWorkitem_CommittedToDoneToCommitted
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Committed" in TFS
	And i update the status of "<Story>" to "Done" in TFS	
	And i update the status of "<Story>" to "Committed" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_CommittedToDoneToCommitted_WithActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_CommittedToDoneToCommitted
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
		 		 			 		 

@ScrumBan_TFSScrum_WI_StatusMove_RemovedToNewToCommitted
Scenario Outline: TFSScrum_changestatusofWorkitem_RemovedToNewToCommitted
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Removed" in TFS
	And i update the status of "<Story>" to "New" in TFS	
	And i update the status of "<Story>" to "Committed" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_RemovedToNewToCommitted_WithActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_RemovedToNewToCommitted
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
		 		 			 		 
@ScrumBan_TFSScrum_WI_StatusMove_NewToDone
Scenario Outline: TFSScrum_changestatusofWorkitem_NewToDone
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "New" in TFS	
	And i update the status of "<Story>" to "Done" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_NewToDone_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_NewToDone
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
		 		 		 		 
		 		 		 		 
@ScrumBan_TFSScrum_WI_StatusMove_ApprovedToDone
Scenario Outline: TFSScrum_changestatusofWorkitem_ApprovedToDone
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Approved" in TFS	
	And i update the status of "<Story>" to "Done" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_ApprovedToDone_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_ApprovedToDone
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
		 		 		 		 		 		 		 		 
		 		 		 		 		 		 		 		 
@ScrumBan_TFSScrum_WI_StatusMove_RemovedToNewToDone
Scenario Outline: TFSScrum_changestatusofWorkitem_RemovedToNewToDone
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Removed" in TFS
	And i update the status of "<Story>" to "New" in TFS	
	And i update the status of "<Story>" to "Done" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_RemovedToNewToDone_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_RemovedToNewToDone
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
		 		 		 		 		 		 		 		 		 		 		 		 		 		 		 		 
		 		 		 		 		 		 		 		 		 		 		 		 		 		 		 		 
@ScrumBan_TFSScrum_WI_StatusMove_NewToCommittedToDone
Scenario Outline: TFSScrum_changestatusofWorkitem_NewToCommittedToDone
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Committed" in TFS	
	And i update the status of "<Story>" to "Done" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_NewToCommittedToDone_WithActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_NewToCommittedToDone
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
		
@ScrumBan_TFSScrum_WI_StatusMove_ApprovedToCommittedToDone
Scenario Outline: TFSScrum_changestatusofWorkitem_ApprovedToCommittedToDone
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Approved" in TFS
	And i update the status of "<Story>" to "Committed" in TFS	
	And i update the status of "<Story>" to "Done" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_ApprovedToCommittedToDone_WithActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_ApprovedToCommittedToDone
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
		 
		 
@ScrumBan_TFSScrum_WI_StatusMove_CommittedToDone
Scenario Outline: TFSScrum_changestatusofWorkitem_CommittedToDone
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "Committed" in TFS	
	And i update the status of "<Story>" to "Done" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_CommittedToDone_WithActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_CommittedToDone
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
		 				 			 		 		 		 		 		 		 		 		 		 		 		 		 		 		 		 
		 				 			 		 		 		 		 		 		 		 		 		 		 		 		 		 		 		 
@ScrumBan_TFSScrum_WI_StatusMove_RemovedToNewToCommittedToDone
Scenario Outline: TFSScrum_changestatusofWorkitem_RemovedToNewToCommittedToDone
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Removed" in TFS
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Committed" in TFS	
	And i update the status of "<Story>" to "Done" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_RemovedToNewToCommittedToDone_WithActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_RemovedToNewToCommittedToDone
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
		 			
		 			
@ScrumBan_TFSScrum_WI_StatusMove_NewToRemoved
Scenario Outline: TFSScrum_changestatusofWorkitem_NewToRemoved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Removed" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_NewToRemoved_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_NewToRemoved
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
		 				 			 		 		 		 		 		 				 				 			 		 		 		 		 		 		 		 		 		 		 		 		 		 		 		 

@ScrumBan_TFSScrum_WI_StatusMove_ApprovedToRemoved
Scenario Outline: TFSScrum_changestatusofWorkitem_ApprovedToRemoved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Approved" in TFS
	And i update the status of "<Story>" to "Removed" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_ApprovedToRemoved_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_ApprovedToRemoved
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality

@ScrumBan_TFSScrum_WI_StatusMove_NewToCommittedToRemoved
Scenario Outline: TFSScrum_changestatusofWorkitem_NewToCommittedToRemoved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Committed" in TFS
	And i update the status of "<Story>" to "Removed" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_NewToCommittedToRemoved_WithActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_NewToCommittedToRemoved
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality

@ScrumBan_TFSScrum_WI_StatusMove_ApprovedToCommittedToRemoved
Scenario Outline: TFSScrum_changestatusofWorkitem_ApprovedToCommittedToRemoved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Approved" in TFS
	And i update the status of "<Story>" to "Committed" in TFS
	And i update the status of "<Story>" to "Removed" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_ApprovedToCommittedToRemoved_WithActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_ApprovedToCommittedToRemoved
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
	
@ScrumBan_TFSScrum_WI_StatusMove_CommittedToRemoved
Scenario Outline: TFSScrum_changestatusofWorkitem_CommittedToRemoved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Committed" in TFS
	And i update the status of "<Story>" to "Removed" in TFS
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSScrum_IBVerification_CommittedToRemoved_WithActivatedDate
Scenario: ScrumBanMertrics_TFSScrum_IB_Validation_ChangeWIStatus_CommittedToRemoved
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Scrum" for "ScrumBan" functionality
				 				 			 		 		 		 		 		 				 				 			 		 		 		 		 		 		 		 		 		 		 		 		 		 		 		 