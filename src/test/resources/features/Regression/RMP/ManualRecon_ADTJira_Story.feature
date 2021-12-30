Feature: ADTJira_ManualRecon 

@1ADTJira_Manualrecon_createReleaseSprintAndStory_FromToolForManualmaticRecon
Scenario Outline: ADTJIRA_ManualRecon_ReleaseAndSprintCreationForManualReconFromTool 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create an "<Release>" in Jira 
	And i create an "<Sprint>" in Jira 
	And i create a "<story>" in Jira for "Manualrecon" 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	
	Examples: 
		| applicationname | task    | story    | risk    |Requirement| Test|issue    | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    | Sprint    |Team|milestone|TestExecution|Action|TestForTestExec|WorkRequest|
		| Jira            | Task_01 | Story_01 | Risk_01 | Requirement_01| Test_01|Issue_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 | Sprint_01 |Team_01|Milestone_01|Test Execution_01|Action_01|TestForTestExec_01|Work Request_01|
	
	
@2ADTJira_Manualrecon_IBVerificationofReleaseAndSprintCreatedFromTool
Scenario Outline: ADTJIRA_ManualRecon_ReleaseAndSprintIBVerification_CaptureIterationExternalId 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the "IterationExternalID" for Entities created from "tool" for tool "ADT Jira" 
	And i generate a token for "DevTest" environment 
	And i verify if "ReleaseFromTool" has "flown" which was "NA" for "ADT Jira" for "Recon" functionality
	And i verify if "SprintFromTool" has "flown" which was "NA" for "ADT Jira" for "Recon" functionality
		Examples: 
		| applicationname |toolname|
		| MyWizard        |ADT JIRA|

@3ADTJira_Manualrecon_IBVerificationofStoryVerifyiterationexternalid
Scenario: ADTJIRA_ManualRecon_Story_CheckifStoryFlown_Verifyiterationexternalid 
	And i generate a token for "DevTest" environment 
	And i verify if "Story" has "flown" which was "NA" for "ADT Jira" for "BeforeRecon" functionality

@4ADTJira_Manualrecon_DisableIterationToInBound
Scenario Outline: ManualRecon_CreateReleaseAndSprintFromRMP 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Configuration" 
	And i select client and DC for "MyWizard" 
	And i select the "ADT JIRA" in Manage Product Configuration page 
	And i navigate to "Product Instance Entities" section
	And i "Disable" outbound for entity Iteration for tool "ADT Jira"
	And i hit the save button in Product Config page 
		
	Examples: 
		| applicationname |
		| MyWizard        |
	
@5ADTJira_Manualrecon_CreateReleaseAndSprintFromRMP 
Scenario Outline: ManualRecon_CreateReleaseAndSprintFromRMP 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select client and DC for "<applicationname>" for RMP
	And i navigate to RMP page 
	And i and create Release and Sprint in RMP page for "ManualRecon" for the tool "ADT Jira" 
	And i put a explicit wait of "900000"
	
	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|
		
@6ADTJira_Manualrecon_IBVerificationofReleaseAndSprintCreatedFromRMP
Scenario Outline: ADTJIRA_ManualRecon_CheckifReleaseAndSprintFlown_CaptureIterationExternalId 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the "IterationExternalID" for Entities created from "RMP" for tool "ADT Jira" 
	And i generate a token for "DevTest" environment  
	And i verify if "ReleaseFromRMP" has "flown" which was "NA" for "ADT Jira" for "Recon" functionality
	And i verify if "SprintFromRMP" has "flown" which was "NA" for "ADT Jira" for "Recon" functionality
	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|
		
			
@7ADTJira_PerformManualrecon 
Scenario Outline: ManualRecon_PerformManualRecon 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Iteration Reconciliation"
	Then i select client and DC for "<applicationname>"
	And i perform Manual Recon for "Release" for tool "ADT Jira"
	And i perform Manual Recon for "Sprint" for tool "ADT Jira" 
	And i put a explicit wait of "60000"
	
	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|	


@8ADTJira_Manualrecon_IBVerificationofStoryVerifyIterationUIdAfterRecon
Scenario: ADTJIRA_ManualRecon_CheckifStoryFlown_VerifyIterationUIdAfterRecon 
	And i generate a token for "DevTest" environment 
	And i verify if "Story" has "flown" which was "NA" for "ADT Jira" for "AfterRecon" functionality
	
	
@9ADTJira_Manualrecon_EnableIterationToInBound
Scenario Outline: ManualRecon_CreateReleaseAndSprintFromRMP 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Configuration" 
	And i select client and DC for "MyWizard" 
	And i select the "ADT JIRA" in Manage Product Configuration page 
	And i navigate to "Product Instance Entities" section
	And i "enable" outbound for entity Iteration for tool "ADT Jira"
	And i hit the save button in Product Config page 
		
	Examples: 
		| applicationname |
		| MyWizard        |	