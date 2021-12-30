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
#	And i put a explicit wait of "900000" 
#	And i generate a token for "DevTest" environment 
	
	    Examples: 
      | applicationname | Story    | Decision| Release    | Sprint    |
	| TFS             | Story_DelFunctionality |Decision_AutoRecon| Release_01 | Sprint_01 |

	
	
@2TFSAgile_Autorecon_IBVerificationofReleaseAndSprintCreatedFromTool
Scenario Outline: TFSAgile_AutoRecon_ReleaseAndSprintIBVerification_CaptureIterationExternalId 
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
#	And i put a explicit wait of "900000"
	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|
	
	
@5TFSAgile_Autorecon_IBVerificationofReleaseAndSprintCreatedFromRMP
Scenario Outline: TFSAgile_AutoRecon_CheckifReleaseAndSprintFlown_CaptureIterationExternalId 
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
		
			
@7TFSAgile_Autorecon_IBVerificationofStoryVerifyIterationUIdAfterRecon
Scenario: TFSAgile_AutoRecon_CheckifStoryFlown_VerifyIterationUIdAfterRecon 
	And i generate a token for "DevTest" environment 
	And i verify if "Decision" has "flown" which was "NA" for "TFS Agile" for "AfterRecon" functionality
	And i verify if "Story" has "flown" which was "NA" for "TFS Agile" for "AfterRecon" functionality