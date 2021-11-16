Feature: TFSScrum team Delete functionality 

@TeamDeletionFunctionality_TeamCreation
Scenario Outline: TFSScrum_Teamcreation
Given i load the project properties file
Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"   
    And i create a "Team" in TFS with member "gopala.veeramani@accenture.com" 
    And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
Examples:
      | applicationname | 
      | TFS             |

@TeamDeletionFunctionality_TeamIBflow
Scenario: TFSScrum_Team_IBflow_beforeDelete
Given i load the project properties file
And i generate a token for "DevTest" environment
And i verify if "Team" has "flown" which was "NA" for "TFS Agile" for "normal" functionality
 
@TeamDeletionFunctionality_WorkitemCreation
Scenario Outline: TFSScrum_WorkitemCreation
Given i load the project properties file
Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"  
    And i create a "<Epic>" in TFS   
    And i create a "<Action>" in TFS
     And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"

Examples:
      | applicationname | Action   | Epic  |
      | TFS             | Action_TeamVerify01 | Epic_TeamVerify01|   
      
@TeamDeletionFunctionality_WorkitemIBVerification    
Scenario: TFSScrum_Workitem_flow_beforeDelete
Given i load the project properties file
And i generate a token for "DevTest" environment
And i verify the "inbound" details for "Epic_TeamVerify01" for tool "TFS Scrum" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamsCheckAndWorkItemFlown" functionality
And i verify the "inbound" details for "Action_TeamVerify01" for tool "TFS Scrum" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamsCheckAndWorkItemFlown" functionality      
  
  
      	
@TeamDeletionFunctionality_TeamDeletion
Scenario Outline: TFSScrum_TeamDeletion
Given i load the project properties file
Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"   
    And i delete the "Team" in "TFS Scrum" for "delete" functionality 
#    wait for 2 hours
Examples:
      | applicationname | Action   | Epic  |
      | TFS             | Action_TeamVerify | Epic_TeamVerify| 	
      
@TeamDeletionFunctionality_IBVerifcation_Post_Deletion     
Scenario: TFSScrum_TeamandWorkitem_flow_AfterDelete
And i generate a token for "DevTest" environment
And i verify if "Team" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 
And i verify the "inbound" details for "Epic_TeamVerify01" for tool "TFS Scrum" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamsCheckAndWorkItemDeleted" functionality
And i verify the "inbound" details for "Action_TeamVerify01" for tool "TFS Scrum" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamsCheckAndWorkItemDeleted" functionality      
  							
