@1ProductInstanceEntityRuleConfig_Regression
Feature: ProductInstanceEntityRuleConfig regression 

Scenario Outline: ProductInstanceEntityRuleConfig_regression
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Product Instance Entity Rule Config" 
	Then i select client and DC for DIY for "TFS Agile"
#    And i select client and DC for "Product Instance Entity Rule Config"
	And i click on the "Inactivate Rule" for "<toolname>" and "<entity>" and "<workitemtype>" under "Product Instance Entity Rule Config" 
	And i click on the "Add Rule" for "<toolname>" and "<entity>" and "<workitemtype>" under "Product Instance Entity Rule Config" 
	And i click on the "Clone Rule" for "<toolname>" and "<entity>" and "<workitemtype>" under "Product Instance Entity Rule Config" 
	And i click on the "Delete Rule" for "<toolname>" and "<entity>" and "<workitemtype>" under "Product Instance Entity Rule Config"
	And i click on "back" button 
	And i navigate to HomePage 

Examples: 
		| applicationname |toolname|entity	|workitemtype	|
		| MyWizard        |TFS Agile|WorkItem|Epic			|
	
@2WorkItemCreation_TFSAgile_ProductInstanceEntityRuleConfig
Scenario Outline: TFSAgile_WorkitemCreation 
	Given i load the project properties file
	Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"
    And i create a "<Epic>" in TFS
      And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
	And i put a explicit wait of "900000" 
	And i generate a token for "DevTest" environment 
	
	    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|WorkRequest|
      | TFS             | Bug_01 | Epic_02 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|Work Request_01| | Issue_ADOP_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 |Sprint_01 |	
      
      
      


@3IBValidation_TFSAgile_ProductInstanceEntityRuleConfig
Scenario Outline: TFSAgile_Epic 
	And i generate a token for "DevTest" environment 
	And i load the project properties file
	And i verify the "Inbound" "Epic" details for "TFS Agile"
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile|