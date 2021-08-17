@TFSAgile_DIY_ProjHier_DCCreation_WorkitemCreation_DeleteDC
Feature: DIY functionality to create/delete DC and create workitems 

@1TFSAgile_DIY_Proj_Hier_RemoveUserRoleInAccountManagement
Scenario Outline: TFSAgile_RemoveUserRole_DIY 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Account Management"
	And i remove the role "Client Admin" for user "sonal.harish.nagda@accenture.com"

Examples: 
		| applicationname |
		| MyWizard        |

@2TFSAgile_DIY_Proj_Hier_CreateDC
Scenario Outline: TFSAgile_DIY_CreateDC 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "DIY AD Automation" 
	Then i select client "Air New Zealand" for "<applicationname>" 
	And i "create" a DC for DIY for "TFS Agile"
	And i enter self enabled automation details for "TFS Agile" for "ProjectHierarchy" functionality 
	And i test the connectivity for "TFS Agile"  
	And i make a note of the DC created for "TFS Agile"
Examples: 
		| applicationname |
		| MyWizard        |
		

@3TFSAgile_DIY_Proj_Hier_CreateWorkitems		
Scenario Outline: TFSAgile_WorkitemCreation 
	Given i load the project properties file
	Given i login to application "<applicationname>"
    Then i select Project "ProductInstanceProjectForDIY" for "<applicationname>" 
    And i create "<Release>" and "<Sprint>" in TFS
	 And i create a "<Story>" in TFS
	 And i create a "<Action>" in TFS
    And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
	And i put a explicit wait of "900000" 
	And i generate a token for "DevTest" environment 
    
 	    Examples: 
		| applicationname |Story    | Action|Release|Sprint|
		| TFS             | Story_DelFunctionality|Action_DelFunctionality|Release_01|Sprint_01|
		
@7TFSAgile_DIY_Proj_Hier_InactivateRules
Scenario Outline: TFSAgile_DIY_InactiveRules
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Instance Entity Rule Config"
	Then i select client and DC for DIY for "TFS Agile"	
	And i deactivate the rules for "TFS Agile"
	
	
	Examples: 
		| applicationname |
		| MyWizard        |
		
		

@8TFSAgile_DIY_Proj_Hier_DeleteDC
Scenario Outline: TFSAgile_DI
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "DIY AD Automation" 
	Then i select only the client for "<applicationname>"
	And i "delete" a DC for DIY for "TFS Agile"
	
		Examples: 
		| applicationname |
		| MyWizard        |