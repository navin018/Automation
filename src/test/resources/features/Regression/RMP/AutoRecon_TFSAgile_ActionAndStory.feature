@TFSAgileCreateReleaseAndSprintFromRMP 
Feature: TFSAgile_AutoRecon 

@1TFSAgile_Autorecon_createReleaseAndSprintFromToolForAutomaticRecon
Scenario Outline: TFSAgile_AutoRecon_ReleaseAndSprintCreationForAutoReconFromTool 
	Given i load the project properties file
	Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"
	 And i create "<Release>" and "<Sprint>" in TFS
	 And i create a "<Story>" in TFS
	 And i create a "<Decision>" in TFS
    And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
	And i put a explicit wait of "900000" 
	And i generate a token for "DevTest" environment 
	
	    Examples: 
      | applicationname | Story    | Decision| Release    | Sprint    |
	| TFS             | Story_DelFunctionality |Decision_Del| Release_02 | Sprint_02 |

	
	
@2TFSAgile_Autorecon_IBVerificationofReleaseAndSprintCreatedFromTool
Scenario Outline: TFSAgile_AutoRecon_ReleaseAndSprintIBVerification_CaptureIterationExternalId 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the IterationExternalID for Iteration created from "tool" for tool "TFS Agile" 
	And i generate a token for "DevTest" environment 
	And i verify if "ReleaseFromTool" has "flown" which was "NA" for "TFS Agile" for "Recon" functionality
	And i verify if "SprintFromTool" has "flown" which was "NA" for "TFS Agile" for "Recon" functionality
		Examples: 
		| applicationname |
		| MyWizard        |

@3TFSAgile_Autorecon_IBVerificationofActionVerifyiterationexternalid
Scenario: TFSAgile_AutoRecon_Story_CheckifStoryFlown_Verifyiterationexternalid 
	And i generate a token for "DevTest" environment 
	And i verify if "Decision" has "flown" which was "NA" for "TFS Agile" for "BeforeRecon" functionality
	And i verify if "Story" has "flown" which was "NA" for "TFS Agile" for "BeforeRecon" functionality
	
	
@4TFSAgile_Autorecon_CreateReleaseAndSprintFromRMP 
Scenario Outline: AutoRecon_CreateReleaseAndSprintFromRMP 
	
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select client and DC for "<applicationname>" for RMP
	And i navigate to RMP page 
	And i and create Release and Sprint in RMP page for "AutoRecon" for the tool "TFS Agile" 
	And i put a explicit wait of "900000"
	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|
	
	
@5TFSAgile_Autorecon_IBVerificationofReleaseAndSprintCreatedFromRMP
Scenario Outline: TFSAgile_AutoRecon_CheckifReleaseAndSprintFlown_CaptureIterationExternalId
  Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the IterationExternalID for Iteration created from "RMP" for tool "TFS Agile" 
	And i generate a token for "DevTest" environment  
	And i verify if "ReleaseFromRMP" has "flown" which was "NA" for "TFS Agile" for "Recon" functionality
	And i verify if "SprintFromRMP" has "flown" which was "NA" for "TFS Agile" for "Recon" functionality
	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|
		
			
@6TFSAgile_Autorecon_IBVerificationofStoryVerifyIterationUIdAfterRecon
Scenario: TFSAgile_AutoRecon_CheckifStoryFlown_VerifyIterationUIdAfterRecon 
	And i generate a token for "DevTest" environment 
	And i verify if "Decision" has "flown" which was "NA" for "TFS Agile" for "AfterRecon" functionality
	And i verify if "Story" has "flown" which was "NA" for "TFS Agile" for "AfterRecon" functionality
	
@7TFSAgile_Autorecon_IBVerificationofReleaseandSprintinIterationMapsCollectionAfterRecon
Scenario: TFSAgile_AutoRecon_CheckIfReconciled_ReleaseandSprint_InIterationMapsCollection
And i generate a token for "DevTest" environment 
	And i verify the "inbound" details for "ReleaseInIterationMaps" for tool "ADT Jira" using "non flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "PostRecon" functionality
	And i verify the "inbound" details for "SprintInIterationMaps" for tool "ADT Jira" using "non flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "PostRecon" functionality  	
	

@8TFSAgile_Autorecon_DeletionofReleaseandSprint
Scenario Outline:  Deletion_Of_ManualReconciledReleaseAnsSprint_from_tool
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i delete "ReleaseAndSprint" in TFS	
	
		Examples: 
		| applicationname |
		| TFS          |
		
@9TFSAgile_Autorecon_VerificationOfReleaseandSprintPostDeletion_InEntities	
Scenario: TFSAgile_AutoRecon_CheckifStoryFlown_VerifyIterationUIdAfterRecon 
	And i generate a token for "DevTest" environment 
	And i verify if "Decision" has "flown" which was "NA" for "TFS Agile" for "AfterRecon&Delete" functionality
	And i verify if "Story" has "flown" which was "NA" for "TFS Agile" for "AfterRecon&Delete" functionality