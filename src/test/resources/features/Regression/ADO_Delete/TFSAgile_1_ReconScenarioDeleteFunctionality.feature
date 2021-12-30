Feature: TFSAgile Recon Scenario_Delete functionality 

@1IterationAndWorkItemCreation_TFSAgile_DeleteFunctionality		
Scenario Outline: TFSAgile_DeleteFunctionality_IterationAndWorkItemCreation 
	Given i load the project properties file
	Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"
	 And i create "<Release>" and "<Sprint>" in TFS
	 And i create a "<Story>" in TFS
	 And i create a "<Action>" in TFS
    And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
	And i put a explicit wait of "900000" 
	And i generate a token for "DevTest" environment 
	
	    Examples: 
      | applicationname | Story    | Action| Release    | Sprint    |
      | TFS             | Story_DelFunctionality |Action_DelFunctionality| Release_02 | Sprint_02 |



@2VerifyToolIterationFlown_TFSAgile_DeleteFunctionality	
Scenario Outline: TFSAgile_DeleteFunctionalityReleaseAndSprintIBVerification_CaptureIterationExternalId 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the "IterationExternalID" for Entities created from "tool" for tool "TFS Agile" 
	And i generate a token for "DevTest" environment 
	And i verify if "ReleaseFromTool" has "flown" which was "NA" for "TFS Agile" for "Recon" functionality
	And i verify if "SprintFromTool" has "flown" which was "NA" for "TFS Agile" for "Recon" functionality
		Examples: 
		| applicationname |
		| MyWizard        |

@3TFSAgile_DeleteFunctionality_IBVerificationofActionVerifyiterationexternalid
Scenario: TFSAgile_DeleteFunctionality_Story_CheckifStoryFlown_Verifyiterationexternalid 
	
	Given i load the project properties file
	And i generate a token for "DevTest" environment 
	And i verify if "Action" has "flown" which was "NA" for "TFS Agile" for "BeforeRecon" functionality
	And i verify if "Story" has "flown" which was "NA" for "TFS Agile" for "BeforeRecon" functionality
	
	
@4TFSAgile_DeleteFunctionality_CreateReleaseAndSprintFromRMP 
Scenario Outline: TFSAgile_DeleteFunctionality_CreateReleaseAndSprintFromRMP 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select client and DC for "<applicationname>" for RMP
	And i navigate to RMP page 
	And i and create Release and Sprint in RMP page for "AutoRecon" for the tool "TFS Agile" 
	And i put a explicit wait of "900000"
	
	
	Examples: 
		| applicationname |
		| MyWizard        |

@5TFSAgile_DeleteFunctionality_IBVerificationofReleaseAndSprintCreatedFromRMP
Scenario Outline: ADTJIRA_AutoRecon_CheckifReleaseAndSprintFlown_CaptureIterationExternalId 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the "IterationExternalID" for Entities created from "RMP" for tool "TFS Agile" 
	And i generate a token for "DevTest" environment  
	And i verify if "ReleaseFromRMP" has "flown" which was "NA" for "TFS Agile" for "Recon" functionality
	And i verify if "SprintFromRMP" has "flown" which was "NA" for "TFS Agile" for "Recon" functionality

	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|
		
			
@7TFSAgile_DeleteFunctionality_IBVerificationofStoryVerifyIterationUIdAfterRecon
Scenario: ADTJIRA_AutoRecon_CheckifStoryFlown_VerifyIterationUIdAfterRecon 
	And i generate a token for "DevTest" environment 
	And i verify if "Action" has "flown" which was "NA" for "TFS Agile" for "AfterRecon" functionality
	And i verify if "Story" has "flown" which was "NA" for "TFS Agile" for "AfterRecon" functionality

@8TFSAgile_DeleteFunctionality_DeleteIterationfromTool
Scenario Outline: Delete_TestData_TFSAgile 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i delete "ReleaseAndSprint" in TFS	
#	wait for 2 hours 	

	Examples: 
		| applicationname | 
		| TFS             |
		
@9TFSAgile_DeleteFunctionality_VerifyIfIterationIsNotShownInIterationAPI
Scenario Outline: TFSAgile_DeleteFunctionality_IBVerification_Release_Sprint
	And i capture the IterationExternalID for deleted Iteration created from "tool" for tool "TFS Agile"
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality
	And i verify if "Sprint" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality

	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile|	 		
		
		
@10TFSAgile_DeleteFunctionality_VerifyIterationDeletedInWorkItem
Scenario: TFSAgile_DeleteFunctionality_VerifyIfReleaseAndSprintIsNullInWorkItems 
	Given i load the project properties file
	And i generate a token for "DevTest" environment
	And i verify if "Action" has "flown" which was "NA" for "TFS Agile" for "AfterRecon&Delete" functionality
	And i verify if "Story" has "flown" which was "NA" for "TFS Agile" for "AfterRecon&Delete" functionality




















