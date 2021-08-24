@TeamConfiguration_regression
Feature: Team configuration regression 

Scenario Outline: Team configuration_createAndEditTeam_UI
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>"
	And i click on tile "Team Configuration"
	Then i want to "create" a team for "<toolname>"
	And i want to "edit" a team for "<toolname>"
		
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Scrum|

		
Scenario Outline: TeamConfig_CreateWorkItemsInToolAndAssignResource
	Given i load the project properties file
	Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"   
    And i create a "<Task>" in TFS
     And i create a "<Milestone>" in TFS
     And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"

Examples:
      | applicationname | Task   | Milestone  |
      | TFS             | Task_TeamVerify | Milestone_TeamVerify|   		
		
	
Scenario: TeamConfig_TFSScrum_VerifyIB_WorkitemsAndTeam
Given i load the project properties file
And i generate a token for "DevTest" environment
And i verify if "Team" has "flown" which was "NA" for "TFS Scrum" for "normal" functionality
And i verify if "Task" has "flown" which was "NA" for "TFS Scrum" for "normal" functionality
And i verify if "Milestone" has "flown" which was "NA" for "TFS Scrum" for "normal" functionality


Scenario Outline: Team configuration_RemoveResourceFromTeam
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>"
	And i click on tile "Team Configuration"
	And i want to "EditteamAndRemoveResource" a team for "<toolname>"
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Scrum|

Scenario: TeamConfig_TFSScrum_VerifyIB_WorkitemsAndTeam

And i verify if "Task" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality
And i verify if "Milestone" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality

		
Scenario Outline: TeamConfig_CreateTeam_WorkItems_Release_InTool
	Given i load the project properties file
	Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"   
    And i create a "Team" in TFS
    And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
    And i create "<Release>" and "<Sprint>" in TFS
    And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
    And i create a "<Epic>" in TFS
     And i create a "<Action>" in TFS
     And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"

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
		| MyWizard        |TFS Scrum|
     
      
  
Scenario Outline: TeamConfig_VerifyIBForTeamAndWorkitems_CreatedViaTool
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the IterationExternalID for Iteration created from "tool" for tool "TFS Scrum" 
	And i generate a token for "DevTest" environment 
	And i verify if "Epic" has "flown" which was "NA" for "TFS Scrum" for "normal" functionality
	And i verify if "Action" has "flown" which was "NA" for "TFS Scrum" for "normal" functionality
	And i verify if "Team" has "flown" which was "NA" for "TFS Scrum" for "normal" functionality
	And i verify if "ReleaseForTeamVerification" has "flown" which was "NA" for "TFS Scrum" for "normal" functionality
	And i verify if "SprintForTeamVerification" has "flown" which was "NA" for "TFS Scrum" for "normal" functionality

Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Scrum|
  