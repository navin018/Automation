Feature: MSPS_Entity Creation


@MSPS_EntityCreation_InUI
Scenario Outline: MSPS_WorkitemCreation 
	Given i load the project properties file
	Given i login to application "<applicationname>"
	Then i "create" a "Project" in "<applicationname>"	
	And i enable the ACNP Project details 
	And i create "Entities" in "<applicationname>"
	And i save, publish,close and check-in the changes
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
	
 Examples: 
      | applicationname |
      | MSPS            |
      
      
      
@MSPS_AddingTitleinRule
Scenario Outline: Adding_DeliveryPlan_InRuleConfig
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Instance Entity Rule Config"
	Then i select client and DC for "<applicationname>" 
	And i click on the "Edit Rule" for "<toolname>" and "<entity>" and "<workitemtype>" under "Product Instance Entity Rule Config" 
	

Examples: 
		| applicationname |toolname|entity	    |
		| MyWizard        |MSPS    |DeliveryPlan|

     