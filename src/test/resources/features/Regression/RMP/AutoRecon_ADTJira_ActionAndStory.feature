@ADTJiraCreateReleaseAndSprintFromRMP 
Feature: ADTJira_AutoRecon 

@1ADTJira_Autorecon_createReleaseAndSprintFromToolForAutomaticRecon
Scenario Outline: ADTJIRA_AutoRecon_ReleaseAndSprintCreationForAutoReconFromTool 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create an "<Release>" in Jira 
	And i create an "<Sprint>" in Jira 
	And i create a "<story>" in Jira for "autorecon"
	And i create a "<Action>" in Jira for "autorecon"
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	And i put a explicit wait of "900000"
	
	Examples: 
		| applicationname |  story    | Action    |Release    | Sprint    |
		| Jira            |  Story_01 | Action_01 | Release_01 | Sprint_01 |
	
	
@2ADTJira_Autorecon_IBVerificationofReleaseAndSprintCreatedFromTool
Scenario Outline: ADTJIRA_AutoRecon_ReleaseAndSprintIBVerification_CaptureIterationExternalId 
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

@3ADTJira_Autorecon_IBVerificationofStoryVerifyiterationexternalid
Scenario: ADTJIRA_AutoRecon_Story_CheckifStoryFlown_Verifyiterationexternalid 
	And i generate a token for "DevTest" environment 
	And i verify if "Story" has "flown" which was "NA" for "ADT Jira" for "BeforeRecon" functionality
	And i verify if "Action" has "flown" which was "NA" for "ADT Jira" for "BeforeRecon" functionality
	
	
@4ADTJira_Autorecon_CreateReleaseAndSprintFromRMP 
Scenario Outline: AutoRecon_CreateReleaseAndSprintFromRMP 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select client and DC for "<applicationname>" for RMP
	And i navigate to RMP page 
	And i and create Release and Sprint in RMP page for "AutoRecon" for the tool "ADT Jira" 
	And i put a explicit wait of "900000"
	
	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|
	
	
@5ADTJira_Autorecon_IBVerificationofReleaseAndSprintCreatedFromRMP
Scenario Outline: ADTJIRA_AutoRecon_CheckifReleaseAndSprintFlown_CaptureIterationExternalId 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the "IterationExternalID" for Entities created from "RMP" for tool "ADT Jira" 
	And i generate a token for "DevTest" environment  
	And i verify if "ReleaseFromRMP" has "flown" which was "NA" for "ADT Jira" for "Recon" functionality
	And i verify if "SprintFromRMP" has "flown" which was "NA" for "ADT Jira" for "Recon" functionality
	And i put a explicit wait of "60000"
	
	Examples: 
		| applicationname |applicationname1|
		| MyWizard        |RMP|
		
			
@6ADTJira_Autorecon_IBVerificationofStoryVerifyIterationUIdAfterRecon
Scenario: ADTJIRA_AutoRecon_CheckifStoryFlown_VerifyIterationUIdAfterRecon 
	And i generate a token for "DevTest" environment 
	And i verify if "Story" has "flown" which was "NA" for "ADT Jira" for "AfterRecon" functionality
	And i verify if "Action" has "flown" which was "NA" for "ADT Jira" for "AfterRecon" functionality
	
@7ADTJira_Autorecon_IBVerificationofReleaseandSprintinIterationMapsCollectionAfterRecon
Scenario: ADTJIRA_AutoRecon_CheckIfReconciled_ReleaseandSprint_InIterationMapsCollection
And i generate a token for "DevTest" environment 
	And i verify the "inbound" details for "ReleaseInIterationMaps" for tool "ADT Jira" using "non flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "PostRecon" functionality
	And i verify the "inbound" details for "SprintInIterationMaps" for tool "ADT Jira" using "non flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "PostRecon" functionality  	
	
	
@8ADTJira_Autorecon_DeletionOfReleaseSprint
Scenario Outline: ADTJIRA_ManualRecon_ReleaseAndSprintCreationForManualReconFromTool 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i delete "Release" in Jira	
	And i delete "Sprint" in Jira
	
Examples: 
		| applicationname |
		|ADT Jira    |

@9ADTJira_Autorecon_VerificationOfReleaseandSprintPostDeletion_InEntities	
Scenario: ADTJIRA_ManualRecon_CheckifStoryFlown_VerifyIterationUIdAfterRecon 
	And i generate a token for "DevTest" environment 
	And i verify if "Action" has "flown" which was "NA" for "ADT Jira" for "AfterRecon&Delete" functionality
	And i verify if "Story" has "flown" which was "NA" for "ADT Jira" for "AfterRecon&Delete" functionality