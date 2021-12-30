Feature: TFSScrum_Manualrecon 

@1TFSScrum_Manualrecon_createReleaseAndSprintFromToolForManualRecon
Scenario Outline: TFSScrum_ManualRecon_ReleaseAndSprintCreationForManualReconFromTool 
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

	
	
@2TFSScrum_Manualrecon_IBVerificationofReleaseAndSprintCreatedFromTool
Scenario Outline: TFSScrum_Manualrecon_ReleaseAndSprintIBVerification_CaptureIterationExternalId 
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

@3TFSScrum_Manualrecon_IBVerificationofActionVerifyiterationexternalid
Scenario: TFSScrum_Manualrecon_Story_CheckifStoryFlown_Verifyiterationexternalid  
#	And i generate a token for "DevTest" environment 
	And i verify if "Story" has "flown" which was "NA" for "TFS Scrum" for "BeforeRecon" functionality
	And i verify if "Decision" has "flown" which was "NA" for "TFS Scrum" for "BeforeRecon" functionality
	
@4TFSScrum_Manualrecon_DisableIterationToInBound
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
			
@5TFSScrum_Manualrecon_CreateReleaseAndSprintFromRMP 
Scenario Outline: Manualrecon_CreateReleaseAndSprintFromRMP 
	
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select client and DC for "<applicationname>" for RMP
#	And i navigate to RMP page 
	And i and create Release and Sprint in RMP page for "Manualrecon" for the tool "TFS Scrum" 
#	And i put a explicit wait of "900000"
	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|
	
	
@6TFSScrum_Manualrecon_IBVerificationofReleaseAndSprintCreatedFromRMP
Scenario Outline: TFSScrum_Manualrecon_CheckifReleaseAndSprintFlown_CaptureIterationExternalId 
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
		
@7TFSScrum_PerformManualrecon 
Scenario Outline: ManualRecon_PerformManualRecon 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Iteration Reconciliation"
	Then i select client and DC for "<applicationname>"
	And i perform Manual Recon for "Release" for tool "TFS Scrum"
	And i perform Manual Recon for "Sprint" for tool "TFS Scrum" 
#	And i put a explicit wait of "60000"
	
	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|	
					
@8TFSScrum_Manualrecon_IBVerificationofStoryVerifyIterationUIdAfterRecon
Scenario: TFSScrum_Manualrecon_CheckifStoryFlown_VerifyIterationUIdAfterRecon 
		And i generate a token for "DevTest" environment 
	And i verify if "Decision" has "flown" which was "NA" for "TFS Scrum" for "AfterRecon" functionality
	And i verify if "Story" has "flown" which was "NA" for "TFS Scrum" for "AfterRecon" functionality
	
@9TFSScrum_Manualrecon_EnableIterationToInBound
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