Feature: TFSAgile team Delete functionality 

@AgileTeamcreation_Association_DeleteFunctionality
Scenario Outline: TFSAgile_WorkitemCcreation
Given i load the project properties file
Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"   
    And i create a "Team" in TFS with member "gopala.veeramani@accenture.com" 
    And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
    And i create a "<Epic>" in TFS
    And i create a "<Action>" in TFS
     And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"

Examples:
      | applicationname | Action   | Epic  |
      | TFS             | Action_TeamVerify01 | Epic_TeamVerify01|   
      
@AgileTeamIbVerification_PreDeletion_DeleteFunctionality     
Scenario: TFSAgile_Team_flow_beforeDelete
Given i load the project properties file
And i generate a token for "DevTest" environment
And i verify if "Team" has "flown" which was "NA" for "TFS Agile" for "normal" functionality
And i verify the "inbound" details for "Epic_TeamVerify01" for tool "TFS Agile" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamsCheckAndWorkItemFlown" functionality
And i verify the "inbound" details for "Action_TeamVerify01" for tool "TFS Agile" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamsCheckAndWorkItemFlown" functionality      
  
  
      	
@AgileTeamDeletion_DeleteFunctionality
Scenario Outline: TFSAgile_WorkitemCcreation
Given i load the project properties file
Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"   
    And i delete the "Team" in "TFS Agile" for "delete" functionality 
#    wait for 2 hours
Examples:
      | applicationname | Action   | Epic  |
      | TFS             | Action_TeamVerify | Epic_TeamVerify| 	
      
@AgileTeamIbVerification_PostDeletion+DeleteFunctionality     
Scenario: TFSAgile_Team_flow_beforeDelete
And i generate a token for "DevTest" environment
And i verify if "Team" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 							
