Feature: TFSScrum create team and 

@ScrumTeamcreation_Association_DeleteFunctionality
Scenario Outline: TFSScrum_WorkitemCcreation
Given i load the project properties file
Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"   
    And i create a "Team" in TFS 
    And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
    And i create a "<Epic>" in TFS
     And i create a "<Action>" in TFS
     And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"

Examples:
      | applicationname | Action   | Epic  |
      | TFS             | Action_TeamVerify | Epic_TeamVerify|   
      
@ScrumTeamIbVerification_PreDeletion_DeleteFunctionality     
Scenario: TFSScrum_Team_flow_beforeDelete
And i verify if "Team" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality      
  
      	
@ScrumTeamDeletion_DeleteFunctionality
Scenario Outline: TFSScrum_WorkitemCcreation
Given i load the project properties file
Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"   
    And i delete the "Team" in "TFS Scrum" for "delete" functionality 
#    wait for 2 hours
Examples:
      | applicationname | Action   | Epic  |
      | TFS             | Action_TeamVerify | Epic_TeamVerify| 	
      
@ScrumTeamIbVerification_PostDeletion+DeleteFunctionality     
Scenario: TFSScrum_Team_flow_beforeDelete
And i verify if "Team" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 							
