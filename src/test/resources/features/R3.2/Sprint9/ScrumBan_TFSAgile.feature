Feature: ScrumBan Descriptive Mertrics_TFSAgile

@1WorkItemCreation_TFSAgile_ScrumBan
Scenario Outline: ScrumBanMertrics_TFSAgile_WorkitemCreation 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
 	And i create a "<Story>" in TFS
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	
	
	    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

@ScrumBan_TFSAgile_IBVerification_New_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_New
			And i generate a token for "DevTest" environment 
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality


@ScrumBan_TFSAgile_WI_StatusMove_ClosedToActive
Scenario Outline: TFSScrum_changestatusofWorkitem_ClosedToActive
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Closed" in TFS
	And i update the status of "<Story>" to "Active" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_ClosedToActive_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_ClosedToActive
			And i generate a token for "DevTest" environment 
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality

@ScrumBan_TFSAgile_WI_StatusMove_ClosedToResolved
Scenario Outline: TFSScrum_changestatusofWorkitem_ClosedToResolved 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Closed" in TFS
	And i update the status of "<Story>" to "Resolved" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_ClosedToResolved_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_ClosedToResolved
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality

@ScrumBan_TFSAgile_WI_StatusMove_NewToResolved
Scenario Outline: TFSScrum_changestatusofWorkitem_NewToResolved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Resolved" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_NewToResolved_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_ClosedToResolved
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality

@ScrumBan_TFSAgile_WI_StatusMove_NewToActive
Scenario Outline: TFSScrum_changestatusofWorkitem_NewToActive
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Active" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_NewToActive_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_NewToActive
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality
			

@ScrumBan_TFSAgile_WI_StatusMove_ActiveToResolved
Scenario Outline: TFSScrum_changestatusofWorkitem_ActiveToResolved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Active" in TFS
	And i update the status of "<Story>" to "Resolved" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_ActiveToResolved_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_ActiveToResolved
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality	
			
			
@ScrumBan_TFSAgile_WI_StatusMove_ResolvedToClosedToActive
Scenario Outline: TFSScrum_changestatusofWorkitem_ResolvedToClosedToActive
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Closed" in TFS
	And i update the status of "<Story>" to "Active" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_ResolvedToClosedToActive_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_ResolvedToClosedToActive
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality		
			
@ScrumBan_TFSAgile_WI_StatusMove_ResolvedToClosedToResolved
Scenario Outline: TFSScrum_changestatusofWorkitem_ResolvedToClosedToResolved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Resolved" in TFS
	And i update the status of "<Story>" to "Closed" in TFS
	And i update the status of "<Story>" to "Resolved" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_ResolvedToClosedToResolved_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_ResolvedToClosedToResolved
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality
			
						
@ScrumBan_TFSAgile_WI_StatusMove_RemovedToNewToResolved
Scenario Outline: TFSScrum_changestatusofWorkitem_RemovedToNewToResolved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Removed" in TFS
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Resolved" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_RemovedToNewToResolved_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_RemovedToNewToResolved
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality						
			
			
@ScrumBan_TFSAgile_WI_StatusMove_RemovedToNewToActive
Scenario Outline: TFSScrum_changestatusofWorkitem_RemovedToNewToActive
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "Removed" in TFS
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Active" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_RemovedToNewToActive_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_RemovedToNewToActive
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality	
			
@ScrumBan_TFSAgile_WI_StatusMove_NewToClosed
Scenario Outline: TFSScrum_changestatusofWorkitem_NewToClosed
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Closed" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_NewToClosed_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_NewToClosed
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality	
			
@ScrumBan_TFSAgile_WI_StatusMove_RemovedToNewToClosed
Scenario Outline: TFSScrum_changestatusofWorkitem_RemovedToNewToClosed
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "Removed" in TFS 
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Closed" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_RemovedToNewToClosed_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_RemovedToNewToClosed
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality	
			
			
@ScrumBan_TFSAgile_WI_StatusMove_NewToResolvedToClosed
Scenario Outline: TFSScrum_changestatusofWorkitem_NewToResolvedToClosed
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "New" in TFS 
	And i update the status of "<Story>" to "Resolved" in TFS
	And i update the status of "<Story>" to "Closed" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_NewToResolvedToClosed_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_NewToResolvedToClosed
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality			
			
@ScrumBan_TFSAgile_WI_StatusMove_ActiveToClosed
Scenario Outline: TFSScrum_changestatusofWorkitem_ActiveToClosed
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "Active" in TFS
	And i update the status of "<Story>" to "Closed" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_ActiveToClosed_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_ActiveToClosed
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality	
			
@ScrumBan_TFSAgile_WI_StatusMove_ActiveToResolvedToClosed
Scenario Outline: TFSScrum_changestatusofWorkitem_ActiveToResolvedToClosed
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "Active" in TFS
	And i update the status of "<Story>" to "Resolved" in TFS
	And i update the status of "<Story>" to "Closed" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_ActiveToResolvedToClosed_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_ActiveToResolvedToClosed
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality						
			
			
@ScrumBan_TFSAgile_WI_StatusMove_ResolvedToClosed
Scenario Outline: TFSScrum_changestatusofWorkitem_ResolvedToClosed
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "Resolved" in TFS
	And i update the status of "<Story>" to "Closed" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_ResolvedToClosed_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_ResolvedToClosed
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality	
			
@ScrumBan_TFSAgile_WI_StatusMove_RemovedToNewToResolvedToClosed
Scenario Outline: TFSScrum_changestatusofWorkitem_RemovedToNewToResolvedToClosed
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "Removed" in TFS
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Resolved" in TFS
	And i update the status of "<Story>" to "Closed" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_RemovedToNewToResolvedToClosed_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_RemovedToNewToResolvedToClosed
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality		
			
@ScrumBan_TFSAgile_WI_StatusMove_RemovedToNewToActiveToClosed
Scenario Outline: TFSScrum_changestatusofWorkitem_RemovedToNewToActiveToClosed
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "Removed" in TFS
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Active" in TFS
	And i update the status of "<Story>" to "Closed" in TFS
	
    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_RemovedToNewToActiveToClosed_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_RemovedToNewToActiveToClosed
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality		
			
@ScrumBan_TFSAgile_WI_StatusMove_NewToRemoved
Scenario Outline: TFSScrum_changestatusofWorkitem_NewToRemoved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Removed" in TFS
	
	    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_NewToRemoved_WithoutActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_NewToRemoved
			And i verify if "Story" has "flown without activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality						
			
@ScrumBan_TFSAgile_WI_StatusMove_NewToActiveToRemoved
Scenario Outline: TFSScrum_changestatusofWorkitem_NewToActiveToRemoved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Active" in TFS
	And i update the status of "<Story>" to "Removed" in TFS
	
	    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_NewToActiveToRemoved_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_NewToActiveToRemoved
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality						
			
@ScrumBan_TFSAgile_WI_StatusMove_NewToResolvedToRemoved
Scenario Outline: TFSScrum_changestatusofWorkitem_NewToResolvedToRemoved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "New" in TFS
	And i update the status of "<Story>" to "Resolved" in TFS
	And i update the status of "<Story>" to "Removed" in TFS
	
	    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_NewToResolvedToRemoved_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_NewToResolvedToRemoved
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality						
			
@ScrumBan_TFSAgile_WI_StatusMove_ActiveToResolvedToRemoved
Scenario Outline: TFSScrum_changestatusofWorkitem_ActiveToResolvedToRemoved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "Active" in TFS
	And i update the status of "<Story>" to "Resolved" in TFS
	And i update the status of "<Story>" to "Removed" in TFS
	
	    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_ActiveToResolvedToRemoved_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_ActiveToResolvedToRemoved
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality						
			
@ScrumBan_TFSAgile_WI_StatusMove_ActiveToRemoved
Scenario Outline: TFSScrum_changestatusofWorkitem_ActiveToRemoved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "Active" in TFS
	And i update the status of "<Story>" to "Removed" in TFS
	
	    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_ActiveToRemoved_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_ActiveToRemoved
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality						
			
@ScrumBan_TFSAgile_WI_StatusMove_ResolvedToRemoved
Scenario Outline: TFSScrum_changestatusofWorkitem_ResolvedToRemoved
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	And i update the status of "<Story>" to "Resolved" in TFS
	And i update the status of "<Story>" to "Removed" in TFS
	
	    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|

			
@ScrumBan_TFSAgile_IBVerification_ResolvedToRemoved_WithActivatedDate
Scenario: ScrumBanMertrics_TFSAgile_IB_Validation_ChangeWIStatus_ResolvedToRemoved
			And i verify if "Story" has "flown with activated date" which was "NA" for "TFS Agile" for "ScrumBan" functionality						