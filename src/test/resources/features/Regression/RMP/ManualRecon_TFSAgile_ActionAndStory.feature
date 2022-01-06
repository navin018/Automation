Feature: TFSAgile_Manualrecon 

@1TFSAgile_Manualrecon_createReleaseAndSprintFromToolForManualRecon
Scenario Outline: TFSAgile_ManualRecon_ReleaseAndSprintCreationForManualReconFromTool 
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

	
	
@2TFSAgile_Manualrecon_IBVerificationofReleaseAndSprintCreatedFromTool
Scenario Outline: TFSAgile_Manualrecon_ReleaseAndSprintIBVerification_CaptureIterationExternalId 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the "IterationExternalID" for Entities created from "tool" for tool "TFS Scrum" 
	And i generate a token for "DevTest" environment 
	And i verify if "ReleaseFromTool" has "flown" which was "NA" for "TFS Scrum" for "Recon" functionality
	And i verify if "SprintFromTool" has "flown" which was "NA" for "TFS Scrum" for "Recon" functionality
		Examples: 
		| applicationname |
		| MyWizard        |

@3TFSAgile_Manualrecon_IBVerificationofActionVerifyiterationexternalid
Scenario: TFSAgile_Manualrecon_Story_CheckifStoryFlown_Verifyiterationexternalid  
	And i generate a token for "DevTest" environment 
	And i verify if "Story" has "flown" which was "NA" for "TFS Scrum" for "BeforeRecon" functionality
	And i verify if "Action" has "flown" which was "NA" for "TFS Scrum" for "BeforeRecon" functionality
	
@4TFSAgile_Manualrecon_DisableIterationToInBound
Scenario Outline: ManualRecon_CreateReleaseAndSprintFromRMP 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Configuration" 
	And i select client and DC for "MyWizard" 
	And i select the "Mywizard-TFS" in Manage Product Configuration page  
	And i navigate to "Product Instance Entities" section
	And i "Disable" outbound for entity Iteration for tool "TFS Scrum"
	And i hit the save button in Product Config page 
		
	Examples: 
		| applicationname |
		| MyWizard        |
			
@5TFSAgile_Manualrecon_CreateReleaseAndSprintFromRMP 
Scenario Outline: Manualrecon_CreateReleaseAndSprintFromRMP 	
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select client and DC for "<applicationname>" for RMP
	And i navigate to RMP page 
	And i and create Release and Sprint in RMP page for "Manualrecon" for the tool "TFS Scrum" 
	And i put a explicit wait of "900000"
	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|
	
	
@6TFSAgile_Manualrecon_IBVerificationofReleaseAndSprintCreatedFromRMP
Scenario Outline: TFSAgile_Manualrecon_CheckifReleaseAndSprintFlown_CaptureIterationExternalId 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the "IterationExternalID" for Entities created from "RMP" for tool "TFS Scrum" 
	And i generate a token for "DevTest" environment  
	And i verify if "ReleaseFromRMP" has "flown" which was "NA" for "TFS Scrum" for "Recon" functionality
	And i verify if "SprintFromRMP" has "flown" which was "NA" for "TFS Scrum" for "Recon" functionality
	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|
		
@7TFSAgile_PerformManualrecon 
Scenario Outline: ManualRecon_PerformManualRecon 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Iteration Reconciliation"
	Then i select client and DC for "<applicationname>"
	And i perform Manual Recon for "Release" for tool "TFS Scrum"
	And i perform Manual Recon for "Sprint" for tool "TFS Scrum" 
	And i put a explicit wait of "60000"
	
	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|	
					
@8TFSAgile_Manualrecon_IBVerificationofStoryVerifyIterationUIdAfterRecon
Scenario: TFSAgile_Manualrecon_CheckifStoryFlown_VerifyIterationUIdAfterRecon 
		And i generate a token for "DevTest" environment 
	And i verify if "Action" has "flown" which was "NA" for "TFS Scrum" for "AfterRecon" functionality
	And i verify if "Story" has "flown" which was "NA" for "TFS Scrum" for "AfterRecon" functionality

@9TFSAgile_Manualrecon_IBVerificationofReleaseandSprintinIterationMapsCollectionAfterRecon
Scenario: TFSAgile_AutoRecon_CheckIfReconciled_ReleaseandSprint_InIterationMapsCollection
And i generate a token for "DevTest" environment 
	And i verify the "inbound" details for "ReleaseInIterationMaps" for tool "TFS Agile" using "non flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "PostRecon" functionality
	And i verify the "inbound" details for "SprintInIterationMaps" for tool "TFS Agile" using "non flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "PostRecon" functionality  	
	
	
@10TFSAgile_Manualrecon_DeletionofReleaseandSprint
Scenario Outline:  Deletion_Of_ManualReconciledReleaseAnsSprint_from_tool
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i delete "ReleaseAndSprint" in TFS	
	
	
	Examples: 
		| applicationname |
		| TFS          |

@11TFSAgile_Manualrecon_EnableIterationToInBound
Scenario Outline: ManualRecon_CreateReleaseAndSprintFromRMP 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Configuration" 
	And i select client and DC for "MyWizard" 
	And i select the "Mywizard-TFS" in Manage Product Configuration page 
	And i navigate to "Product Instance Entities" section
	And i "enable" outbound for entity Iteration for tool "TFS Scrum"
	And i hit the save button in Product Config page 
		
	Examples: 
		| applicationname |
		| MyWizard        |	
			
@12TFSAgile_Manualrecon_VerificationOfReleaseandSprintPostDeletion_InEntities
Scenario: TFSAgile_Manualrecon_CheckifStoryFlown_VerifyIterationUIdAfterRecon 
	Given i generate a token for "DevTest" environment 
	And i verify if "Action" has "flown" which was "NA" for "TFS Scrum" for "AfterRecon&Delete" functionality
	And i verify if "Story" has "flown" which was "NA" for "TFS Scrum" for "AfterRecon&Delete" functionality



