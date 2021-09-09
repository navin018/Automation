Feature: TFS Team Architecture

Scenario Outline: TFS_Team Architecture_Creation
Given i load the project properties file
Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"   
    And i create a "Team01" in TFS with member "Resource1&Resource2"
    And i update the Entity ID for "Team01" into JSON file for "<applicationname>" for functionality "TeamArchitecture" 
    And i create a "Team02" in TFS with member "Resource1&Resource2" 
    And i update the Entity ID for "Team02" into JSON file for "<applicationname>" for functionality "TeamArchitecture"
    
    
    Examples:
      | applicationname |
      | TFS             | 


#after team has flown
Scenario Outline: TeamArch_captureteamDCUID_CreatedViaTool
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>"
	And i click on tile "Team Configuration"
	Then i want to capture team details for "Team01" for "<toolname>" for functionality "TeamArchitecture" 
	And i update the Entity ID for "TeamUId01" into JSON file for "<applicationname>" for functionality "TeamArchitecture"
	And i update the Entity ID for "TeamExternalId01" into JSON file for "<applicationname>" for functionality "TeamArchitecture"

 Examples:
      | applicationname |
      | MyWizard      | 
      
      
Scenario Outline: TFS_Team Architecture_Creation
Given i load the project properties file
Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"   
	
	And i "create" a "Bug_TeamArchitecture_Scenario1" in TFS for "TeamArchitecture"
	And i "create" a "Action_TeamArchitecture_Scenario1" in TFS for "TeamArchitecture"
	
#	add ur entities here 
	
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "TeamArchitecture"
  Examples:
      | applicationname |
      | TFS             |       
      
#IB verfication

Scenario Outline: TFSScrum_TeamArchi_WorkitemCcreation      
Given i load the project properties file
Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"    
   	And i "create" a "Story_TeamArchi" in TFS for "Team Architecture"
    
     And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
 Examples:
      | applicationname | Story  | 
      | TFS             | Story_TeamArchi | 
           