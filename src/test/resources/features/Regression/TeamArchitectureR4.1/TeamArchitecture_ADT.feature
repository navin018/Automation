Feature: TFS Team Architecture

Scenario Outline: ADT_Team Architecture_Creation
Given i load the project properties file
Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"  
    And i create an "Team01" in Jira
    And i update the Entity ID for "Team01" into JSON file for "Jira" for functionality "TeamArchitecture"
    And i create an "Team02" in Jira
    And i update the Entity ID for "Team02" into JSON file for "Jira" for functionality "TeamArchitecture"
    And i create an "Team03" in Jira
     And i update the Entity ID for "Team03" into JSON file for "Jira" for functionality "TeamArchitecture"
    
    Examples:
      | applicationname |
      | Jira             | 


Scenario Outline: TeamArch_captureteamDCUID_CreatedViaTool
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>"
	And i click on tile "Team Configuration"
	Then i want to capture team details for "Team01" for "<toolname>" for functionality "TeamArchitecture" 
	And i update the Entity ID for "TeamUId01" into JSON file for "TFS" for functionality "TeamArchitecture"
	And i update the Entity ID for "TeamExternalId01" into JSON file for "TFS" for functionality "TeamArchitecture"
	Then i want to capture team details for "Team02" for "<toolname>" for functionality "TeamArchitecture" 
	And i update the Entity ID for "TeamUId02" into JSON file for "TFS" for functionality "TeamArchitecture"
	And i update the Entity ID for "TeamExternalId02" into JSON file for "TFS" for functionality "TeamArchitecture"
	Then i want to capture team details for "Team03" for "<toolname>" for functionality "TeamArchitecture" 
	And i update the Entity ID for "TeamUId03" into JSON file for "TFS" for functionality "TeamArchitecture"
	And i update the Entity ID for "TeamExternalId03" into JSON file for "TFS" for functionality "TeamArchitecture"
	
Examples:
      | applicationname |
      | MyWizard             |	
	
Scenario Outline: TeamArch_AddResourcesToTeamInUI	
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>"
	And i click on tile "Team Configuration"
    And i "add" the resources "abd@accenture.com" to the "team01"  
	

 Examples:
      | applicationname |
      | MyWizard      | 
      
Scenario Outline: TFS_Team Architecture_Creation
Given i load the project properties file
Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"   
	
	And i "create" a "Bug_TeamArchitecture_Scenario1" in Jira for "TeamArchitecture" 
    And i "update" a "Bug_TeamArchitecture_Scenario1" in Jira for "TeamArchitecture"
    And i "create" a "Action_TeamArchitecture_Scenario1" in Jira for "TeamArchitecture"
    And i "update" a "Action_TeamArchitecture_Scenario1" in Jira for "TeamArchitecture" 
    
    And i "create" a "Bug_TeamArchitecture_Scenario2" in Jira for "TeamArchitecture"
    And i "update" a "Bug_TeamArchitecture_Scenario2" in Jira for "TeamArchitecture"
    And i "create" a "Action_TeamArchitecture_Scenario2" in Jira for "TeamArchitecture"  
    And i "update" a "Action_TeamArchitecture_Scenario2" in Jira for "TeamArchitecture"
    
    And i "create" a "Bug_TeamArchitecture_Scenario3" in Jira for "TeamArchitecture"
    And i "update" a "Bug_TeamArchitecture_Scenario3" in Jira for "TeamArchitecture"
    And i "create" a "Action_TeamArchitecture_Scenario3" in Jira for "TeamArchitecture"    
    And i "update" a "Action_TeamArchitecture_Scenario3" in Jira for "TeamArchitecture"

    And i "create" a "Bug_TeamArchitecture_Scenario4" in Jira for "TeamArchitecture"
    And i "update" a "Bug_TeamArchitecture_Scenario4" in Jira for "TeamArchitecture"
    And i "create" a "Action_TeamArchitecture_Scenario4" in Jira for "TeamArchitecture"
    And i "update" a "Action_TeamArchitecture_Scenario4" in Jira for "TeamArchitecture" 
    
    
    And i "create" a "Bug_TeamArchitecture_Scenario5" in Jira for "TeamArchitecture"
    And i "update" a "Bug_TeamArchitecture_Scenario5" in Jira for "TeamArchitecture"
    And i "create" a "Action_TeamArchitecture_Scenario5" in Jira for "TeamArchitecture"
    And i "update" a "Action_TeamArchitecture_Scenario5" in Jira for "TeamArchitecture" 
    
    
    And i "create" a "Bug_TeamArchitecture_Scenario6" in Jira for "TeamArchitecture"
    And i "update" a "Bug_TeamArchitecture_Scenario6" in Jira for "TeamArchitecture"
    And i "create" a "Action_TeamArchitecture_Scenario6" in Jira for "TeamArchitecture"
    And i "update" a "Action_TeamArchitecture_Scenario6" in Jira for "TeamArchitecture" 
    
    
    And i "create" a "Bug_TeamArchitecture_Scenario7" in Jira for "TeamArchitecture"
    And i "update" a "Bug_TeamArchitecture_Scenario7" in Jira for "TeamArchitecture"
    And i "create" a "Action_TeamArchitecture_Scenario7" in Jira for "TeamArchitecture"
    And i "update" a "Action_TeamArchitecture_Scenario7" in Jira for "TeamArchitecture" 
    
    
    And i "create" a "Bug_TeamArchitecture_Scenario8" in Jira for "TeamArchitecture"
    And i "update" a "Bug_TeamArchitecture_Scenario8" in Jira for "TeamArchitecture"
    And i "create" a "Action_TeamArchitecture_Scenario8" in Jira for "TeamArchitecture"
    And i "update" a "Action_TeamArchitecture_Scenario8" in Jira for "TeamArchitecture"

	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "TeamArchitecture"
  Examples:
      | applicationname |
      | TFS             | 
 
 Scenario:
 And i verify the "inbound" details for "Action_TeamArchitecture_Scenario1" for tool "TFS Scrum" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality


