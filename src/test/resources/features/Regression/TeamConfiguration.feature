@TeamConfiguration_regression
Feature: Team configuration regression 

Scenario Outline: Team configuration_createAndEditTeamInUI_createWorkitemsInToolAndAssignResources
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>"
	And i click on tile "Team Configuration"
	Then i want to "create" a team for "<toolname>"
	And i update the Entity ID for "Team" into JSON file for "<applicationname>"
	And i want to "edit" a team for "<toolname>"
	
	Examples: 
		| applicationname |toolname|Task   | Milestone  |
		| MyWizard        |TFS Agile|Task_TeamVerify | Milestone_TeamVerify|
	
	
Scenario Outline: Team configuration_createentitiesAndAddResourceForTeamCreatedinUI	
	Given i login to application "TFS"
    Then i select a Project for "TFS"   
    And i create a "<Task>" in TFS
     And i create a "<Milestone>" in TFS
     And i update the Entity ID for "Task" into JSON file for "<applicationname>"
     And i update the Entity ID for "Milestone" into JSON file for "<applicationname>"
     
		
	Examples: 
		| applicationname |toolname|Task   | Milestone  |
		| MyWizard        |TFS Agile|Task_TeamVerify | Milestone_TeamVerify|


Scenario: TeamConfig_TFSAgile_VerifyIB_WorkitemsAndTeam
Given i load the project properties file
And i generate a token for "DevTest" environment
And i verify if "Team" has "flown" which was "NA" for "TFS Agile" for "normal" functionality
And i verify the "inbound" details for "Task_TeamVerify" for tool "TFS Agile" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamsCheckAndWorkItemFlown" functionality
And i verify the "inbound" details for "Milestone_TeamVerify" for tool "TFS Agile" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamsCheckAndWorkItemFlown" functionality


Scenario Outline: Team configuration_RemoveResourceFromTeam
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>"
	And i click on tile "Team Configuration"
	And i want to "EditteamAndRemoveResource" a team for "<toolname>"
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile|


Scenario: TeamConfig_TFSAgile_VerifyIB_WorkitemsAndTeamAfterRemovingResource
And i generate a token for "DevTest" environment
And i verify the "inbound" details for "Task_TeamVerify" for tool "TFS Agile" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamsCheckAndWorkItemDeleted" functionality
And i verify the "inbound" details for "Milestone_TeamVerify" for tool "TFS Agile" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamsCheckAndWorkItemDeleted" functionality 


Scenario Outline: TeamConfig_CreateTeamFromTool
	Given i load the project properties file
	Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"   
    And i create a "Team" in TFS
    And i update the Entity ID for "Team" into JSON file for "<applicationname>"

Examples:
      | applicationname | Action   | Epic  |Release|Sprint|
      | TFS             | Action_TeamVerify | Epic_TeamVerify|Release_01|Sprint_01|   

Scenario Outline: TeamConfig_CreateReleaseAndSprintAndEntitiesAndAssociateWithTeamMemberForTeamCreatedinTool
	Given i load the project properties file
	Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"   
	 And i create "<Release>" and "<Sprint>" in TFS
    And i update the Entity ID for "Release" into JSON file for "<applicationname>" 
    And i update the Entity ID for "Sprint" into JSON file for "<applicationname>"
	And i create a "<Epic>" in TFS
    And i update the Entity ID for "Epic" into JSON file for "<applicationname>"
    And i create a "<Action>" in TFS
    And i update the Entity ID for "Action" into JSON file for "<applicationname>"
Examples:
      | applicationname | Action   | Epic  |Release|Sprint|
      | TFS             | Action_TeamVerify | Epic_TeamVerify|Release_01|Sprint_01|   
    
      

Scenario Outline: Team configuration_captureteamDCUID_CreatedViaTool
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>"
	And i click on tile "Team Configuration"
	Then i want to capture team details for a team for "<toolname>"
	
		
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile|
     
      

Scenario Outline: TeamConfig_VerifyIBForTeamAndWorkitemsAndIteration_CreatedViaTool
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the IterationExternalID for Iteration created from "tool" for tool "TFS Agile" 
	And i generate a token for "DevTest" environment
	And i verify if "Team" has "flown" which was "NA" for "TFS Agile" for "normal" functionality 
	And i verify if "ReleaseForteamVerification" has "flown" which was "NA" for "TFS Agile" for "normal" functionality
	And i verify if "SprintForteamVerification" has "flown" which was "NA" for "TFS Agile" for "normal" functionality
	And i verify the "inbound" details for "Epic_TeamVerify" for tool "TFS Agile" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamsCheckAndWorkItemFlown" functionality
	And i verify the "inbound" details for "Action_TeamVerify" for tool "TFS Agile" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamsCheckAndWorkItemFlown" functionality

	

Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile|
  