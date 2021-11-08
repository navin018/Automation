Feature: ADT Team Architecture
@ADT_TeamArch_TeamCreation
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

@ADT_TeamArch_CaptureTeamDetails
Scenario Outline: TeamArch_captureteamDCUID_CreatedViaTool
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>"
	And i click on tile "Team Configuration"
	Then i want to capture team details for "Team01" for "Jira" for functionality "TeamArchitecture" 
	And i update the Entity ID for "TeamUId01" into JSON file for "Jira" for functionality "TeamArchitecture"
	And i update the Entity ID for "TeamExternalId01" into JSON file for "Jira" for functionality "TeamArchitecture"
	Then i want to capture team details for "Team02" for "Jira" for functionality "TeamArchitecture" 
	And i update the Entity ID for "TeamUId02" into JSON file for "Jira" for functionality "TeamArchitecture"
	And i update the Entity ID for "TeamExternalId02" into JSON file for "Jira" for functionality "TeamArchitecture"
	Then i want to capture team details for "Team03" for "Jira" for functionality "TeamArchitecture" 
	And i update the Entity ID for "TeamUId03" into JSON file for "Jira" for functionality "TeamArchitecture"
	And i update the Entity ID for "TeamExternalId03" into JSON file for "Jira" for functionality "TeamArchitecture"
	
Examples:
      | applicationname |
      | MyWizard             |
      	
@ADT_TeamArch_AddResourcesToTeam      
Scenario Outline: TeamArch_AddResourcesInUI
    Given i load the project properties file
    Given i login to application "<applicationname>"
    And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
    Then i select client and DC for "<applicationname>"
    And i click on tile "Team Configuration"
    And i "add" the resources "abinesh.prakash@accenture.com&adeeb.khan@accenture.com" to the "Team01" for "<toolname>" for functionality "TeamArchitecture" 
    And i "add" the resources "adeeb.khan@accenture.com" to the "Team03" for "<toolname>" for functionality "TeamArchitecture"
   
   
      Examples:
      | applicationname |toolname|
      | MyWizard       | Jira|
   
@ADT_TeamArch_CreateEntitiesInTool     
Scenario Outline: ADT_Team Architecture_Creation
	Given i load the project properties file
	Given i login to application "<applicationname>"
	Then i select a Project for "<applicationname>"
	
	And i "create" a "Bug_TeamArchitecture_Scenario1" in Jira for "TeamArchitecture"
	And i "create" a "Action_TeamArchitecture_Scenario1" in Jira for "TeamArchitecture"
	And i update the Entity ID for "Bug_TeamArchitecture_Scenario1" into JSON file for "Jira" for functionality "TeamArchitecture"
	And i update the Entity ID for "Action_TeamArchitecture_Scenario1" into JSON file for "Jira" for functionality "TeamArchitecture"
	
	And i "create" a "Bug_TeamArchitecture_Scenario2" in Jira for "TeamArchitecture"
	And i "create" a "Action_TeamArchitecture_Scenario2" in Jira for "TeamArchitecture"
	And i update the Entity ID for "Bug_TeamArchitecture_Scenario2" into JSON file for "Jira" for functionality "TeamArchitecture"
	And i update the Entity ID for "Action_TeamArchitecture_Scenario2" into JSON file for "Jira" for functionality "TeamArchitecture"
	
	And i "create" a "Bug_TeamArchitecture_Scenario3" in Jira for "TeamArchitecture"
	And i "create" a "Action_TeamArchitecture_Scenario3" in Jira for "TeamArchitecture"
	And i update the Entity ID for "Bug_TeamArchitecture_Scenario3" into JSON file for "Jira" for functionality "TeamArchitecture"
	And i update the Entity ID for "Action_TeamArchitecture_Scenario3" into JSON file for "Jira" for functionality "TeamArchitecture"
	
	
	
	And i "create" a "Bug_TeamArchitecture_Scenario4" in Jira for "TeamArchitecture"
	And i "create" a "Action_TeamArchitecture_Scenario4" in Jira for "TeamArchitecture"
	And i update the Entity ID for "Bug_TeamArchitecture_Scenario4" into JSON file for "Jira" for functionality "TeamArchitecture"
	And i update the Entity ID for "Action_TeamArchitecture_Scenario4" into JSON file for "Jira" for functionality "TeamArchitecture"
	
	
	And i "create" a "Bug_TeamArchitecture_Scenario5" in Jira for "TeamArchitecture"
	And i "create" a "Action_TeamArchitecture_Scenario5" in Jira for "TeamArchitecture"
	And i update the Entity ID for "Bug_TeamArchitecture_Scenario5" into JSON file for "Jira" for functionality "TeamArchitecture"
	And i update the Entity ID for "Action_TeamArchitecture_Scenario5" into JSON file for "Jira" for functionality "TeamArchitecture"
	
	And i "create" a "Bug_TeamArchitecture_Scenario6" in Jira for "TeamArchitecture"
	And i "create" a "Action_TeamArchitecture_Scenario6" in Jira for "TeamArchitecture"
	And i update the Entity ID for "Bug_TeamArchitecture_Scenario6" into JSON file for "Jira" for functionality "TeamArchitecture"
	And i update the Entity ID for "Action_TeamArchitecture_Scenario6" into JSON file for "Jira" for functionality "TeamArchitecture"
	
	And i "create" a "Bug_TeamArchitecture_Scenario7" in Jira for "TeamArchitecture"
	And i "create" a "Action_TeamArchitecture_Scenario7" in Jira for "TeamArchitecture"
	And i update the Entity ID for "Bug_TeamArchitecture_Scenario7" into JSON file for "Jira" for functionality "TeamArchitecture"
	And i update the Entity ID for "Action_TeamArchitecture_Scenario7" into JSON file for "Jira" for functionality "TeamArchitecture"
	
	And i "create" a "Bug_TeamArchitecture_Scenario8" in Jira for "TeamArchitecture"
	And i "create" a "Action_TeamArchitecture_Scenario8" in Jira for "TeamArchitecture"
	And i update the Entity ID for "Bug_TeamArchitecture_Scenario8" into JSON file for "Jira" for functionality "TeamArchitecture"
	And i update the Entity ID for "Action_TeamArchitecture_Scenario8" into JSON file for "Jira" for functionality "TeamArchitecture"
	
#	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "TeamArchitecture"

	And i "update" a "Bug_TeamArchitecture_Scenario1" in Jira for "TeamArchitecture"
	And i "update" a "Action_TeamArchitecture_Scenario1" in Jira for "TeamArchitecture"
	And i "update" a "Bug_TeamArchitecture_Scenario2" in Jira for "TeamArchitecture"
	And i "update" a "Action_TeamArchitecture_Scenario2" in Jira for "TeamArchitecture"
	And i "update" a "Bug_TeamArchitecture_Scenario3" in Jira for "TeamArchitecture"
	And i "update" a "Action_TeamArchitecture_Scenario3" in Jira for "TeamArchitecture"
	And i "update" a "Bug_TeamArchitecture_Scenario4" in Jira for "TeamArchitecture"
	And i "update" a "Action_TeamArchitecture_Scenario4" in Jira for "TeamArchitecture"
	And i "update" a "Bug_TeamArchitecture_Scenario5" in Jira for "TeamArchitecture"
	And i "update" a "Action_TeamArchitecture_Scenario5" in Jira for "TeamArchitecture"	
	And i "update" a "Bug_TeamArchitecture_Scenario6" in Jira for "TeamArchitecture"
	And i "update" a "Action_TeamArchitecture_Scenario6" in Jira for "TeamArchitecture"
	And i "update" a "Bug_TeamArchitecture_Scenario7" in Jira for "TeamArchitecture"
	And i "update" a "Action_TeamArchitecture_Scenario7" in Jira for "TeamArchitecture"
	And i "update" a "Bug_TeamArchitecture_Scenario8" in Jira for "TeamArchitecture"
	And i "update" a "Action_TeamArchitecture_Scenario8" in Jira for "TeamArchitecture"
	
	Examples:
	| applicationname |
	| Jira |
 
@ADT_TeamArch_IB_ForEntities 
Scenario: Check IB for entities for team arch
Given i load the project properties file
And i generate a token for "DevTest" environment
And i verify the "inbound" details for "Action_TeamArchitecture_Scenario1" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality
And i verify the "inbound" details for "Bug_TeamArchitecture_Scenario1" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality

And i verify the "inbound" details for "Action_TeamArchitecture_Scenario2" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality
And i verify the "inbound" details for "Bug_TeamArchitecture_Scenario2" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality

And i verify the "inbound" details for "Action_TeamArchitecture_Scenario3" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality
And i verify the "inbound" details for "Bug_TeamArchitecture_Scenario3" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality

And i verify the "inbound" details for "Action_TeamArchitecture_Scenario4" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality
And i verify the "inbound" details for "Bug_TeamArchitecture_Scenario4" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality

And i verify the "inbound" details for "Action_TeamArchitecture_Scenario5" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality
And i verify the "inbound" details for "Bug_TeamArchitecture_Scenario5" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality

And i verify the "inbound" details for "Action_TeamArchitecture_Scenario6" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality
And i verify the "inbound" details for "Bug_TeamArchitecture_Scenario6" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality

And i verify the "inbound" details for "Action_TeamArchitecture_Scenario7" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality
And i verify the "inbound" details for "Bug_TeamArchitecture_Scenario7" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality

And i verify the "inbound" details for "Action_TeamArchitecture_Scenario8" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality
And i verify the "inbound" details for "Bug_TeamArchitecture_Scenario8" for tool "ADT Jira" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "TeamArchitecture" functionality
