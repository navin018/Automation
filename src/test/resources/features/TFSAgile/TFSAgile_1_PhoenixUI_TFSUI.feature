Feature: PhoenixUI_TFSAgileUI

@0Delete_TestData_TFSAgile     
Scenario Outline: Delete_TestData_TFSAgile
    Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"
    Then i delete the test automation data for query "DeleteAutomationTestData"
    
    Examples: 
      | applicationname |
      | TFS             | 


@1PreRequisites_TFSAgile
Scenario Outline: ProdConfigCheck_TFSAgile 
	Given i load the project properties file
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Configuration"
	Then i select client and DC for "<applicationname>"  
	And i select the "Mywizard-TFS" in Manage Product Configuration page 
#	And i navigate to "Product Instance Extension(s)" section 
#	And i add Product Instance Extension(s) details in the page for "<toolname>" 
#	And i hit the save button in Product Config page 
#	And i select the "Mywizard-TFS" in Manage Product Configuration page 
	And i navigate to "Delivery Construct Association" section
	And i add Delivery construct association details in the page for "<toolname>"
	And i navigate to "Product Instance Entities" section
	And i add Product Instance Entities details in the page for "<toolname>"
	And i hit the save button in Product Config page
	
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |MyWizard-TFS|

		
@2ClientNative_TFSAgile	
Scenario Outline: Client_Native_TFSAgile(!Iteraion) 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "Mywizard-TFS" in Manage Product Configuration page 
	And i navigate to "Product Instance Entities" section 
	And i generate a token for "DevTest" environment 
	And i verify the ClientNative details for "<toolname_Sheet>" 
	And i hit the save button in Product Config page 

		Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile|	


@2ClientNative_TFSAgile		
Scenario Outline: Client_Native_TFSAgile(iteration) 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "mywizardinstance" in Manage Product Configuration page
	And i navigate to "Product Instance Entities" section 
	And i generate a token for "DevTest" environment 
	And i verify the ClientNative details for "<toolname_Sheet>" 
	And i hit the save button in Product Config page 
#	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile_Iteration|

@3SEI_TFSAgile
Scenario Outline: SEI_TFSAgile_IB_Pipelines 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "Mywizard-TFS" in Manage Product Configuration page 
	And i check if the field "RealTimeConfigChanges" is "Enabled" 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i verify the existing "IB" pipelines if present and add them if missing for "<toolname>" 
#	And i hit the save button in Product Config page 
#	And i select the "Mywizard-TFS" in Manage Product Configuration page 
#	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
#	And i deploy the pipelines and verify if successful for "<toolname>" 
#	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile|

@3SEI_TFSAgile		
Scenario Outline: SEI_TFSAgile_OB_Pipelines 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	Then i select only the client for "<applicationname>" 
	And i select the "Mywizard-TFS" in Manage Product Configuration page
	And i check if the field "RealTimeConfigChanges" is "Enabled" 
	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
	And i verify the existing "OB" pipelines if present and add them if missing for "<toolname>" 
#	And i hit the save button in Product Config page 
#	And i select the "Mywizard-TFS" in Manage Product Configuration page  
#	And i navigate to "GatewayManager/ToolGateway Integration Parameters" section 
#	And i deploy the pipelines and verify if successful for "<toolname>" 
	

	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile|

@4Rules_TFSAgile
Scenario Outline: TFSAgile_RulesValidation
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Instance Entity Rule Config"
	Then i select client and DC for "<applicationname>"  
	And i verify and add the rules if missing for the "<toolname>" 
	
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile|
		
@5WorkItemCreation_TFSAgile		
Scenario Outline: TFSAgile_WorkitemCreation 
	Given i load the project properties file
	Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"
    And i create a "<bug>" in TFS
    And i create a "<Epic>" in TFS
    And i create a "<Feature>" in TFS
    And i create a "<Issue>" in TFS
    And i create a "<Task>" in TFS
    And i create a "<TestCase>" in TFS
 	And i create a "<Risk>" in TFS
    And i create a "<Action>" in TFS
    And i create a "<Decision>" in TFS
    And i create a "<Deliverable>" in TFS
      And i create a "<Requirement>" in TFS
     And i create a "<Milestone>" in TFS
     And i create a "<Story>" in TFS
#     And i create a "<TestResult>" in TFS
#  
 And i create "<Release>" and "<Sprint>" in TFS
    And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"
	And i put a explicit wait of "900000" 
	And i generate a token for "DevTest" environment 
	
	    Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|


		
		