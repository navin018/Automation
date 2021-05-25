@TFSScrum_DIY_DCCreation_WorkitemCreation_DeleteDC
Feature: DIY functionality to create/delete DC and create workitems 

@1TFSScrum_DIY_RemoveUserRoleInAccountManagement
Scenario Outline: TFSScrum_RemoveUserRole_DIY 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Account Management"
	And i remove the role "Client Admin" for user "sonal.harish.nagda@accenture.com"

Examples: 
		| applicationname |
		| MyWizard        |

@2TFSScrum_DIY_CreateDC
Scenario Outline: TFSScrum_DIY_CreateDC 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "DIY AD Automation" 
	Then i select only the client for "<applicationname>"
	And i "create" a DC for DIY for "TFS Scrum"
	And i enter self enabled automation details for "TFS Scrum"
	And i test the connectivity for "TFS Scrum"  
	And i make a note of the DC created for "TFS Scrum"
Examples: 
		| applicationname |
		| MyWizard        |
		

@3TFSScrum_DIY_CreateWorkitems		
Scenario Outline: TFSScrum_WorkitemCreation 
	Given i load the project properties file
	Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"
    And i create a "<bug>" in TFS
    And i create a "<Epic>" in TFS
    And i create a "<Feature>" in TFS
    And i create a "<Issue>" in TFS
    And i create a "<Task>" in TFS
    And i create a "<Risk>" in TFS
    And i create a "<Impediment>" in TFS
    And i create a "<ProductBacklog>" in TFS
    
    And i create a "<TestCase>" in TFS
    And i create a "<Action>" in TFS
    And i create a "<Decision>" in TFS
    And i create a "<Deliverable>" in TFS
      And i create a "<Requirement>" in TFS
     And i create a "<Milestone>" in TFS
     
 And i create a "<WorkRequest>" in TFS
##     And i create a "<TestResult>" in TFSs
  
 And i create "<Release>" and "<Sprint>" in TFS
    And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
	And i put a explicit wait of "900000" 
	And i generate a token for "DevTest" environment 
	
	 	    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|WorkRequest|ProductBacklog|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|Work Request_01|ProductBacklog_01|

@7TFSScrum_DIY_InactivateRules
Scenario Outline: TFSScrum_DIY_InactiveRules
Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Instance Entity Rule Config"
	Then i select client and DC for DIY for "TFS Scrum"	
	And i deactivate the rules for "TFS Scrum"
	
	
	Examples: 
		| applicationname |
		| MyWizard        |

@8TFSScrum_DIY_DeleteDC
Scenario Outline: TFSScrum_DIY
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "DIY AD Automation" 
	Then i select only the client for "<applicationname>"
	And i "delete" a DC for DIY for "TFS Scrum"
	
		Examples: 
		| applicationname |
		| MyWizard        |