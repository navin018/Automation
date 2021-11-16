@5API_UpdateFormulaAndWorkitemScenario_TFSScrum_PrecomputationEngineFunctionality_WSJF	
Feature: TFSScrum PrecomputationEngine WSJF functionality IB Verification 


@UpdateFormula_TFSScrum_PrecomputationEngineFunctionality_WSJF	
Scenario Outline: TFSScrum_WorkitemCreation_PreCompuation 
	Given i load the project properties file 
	Given i login to application "MyWizard"  
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i select client "PreComputationEngine_Client" with DC_L1 as "PreComputationEngine_DC_L1" and DC_L2 as "PreComputationEngine_DC_L2" 
	And i click on tile "Precomputation Engine"
    Then i "edit" a process of type "Compute" for entity "WorkItem" and subentity "Story_wsjf_Multiply_0" and add the formula "( Priority + BusinessValue ) + StoryPoints" for tool "TFS Scrum"
    
	Examples: 
		| applicationname |
		| MyWizard        |
		
@4UpdateWorkItemAndFormula_TFSScrum_PrecomputationEngineFunctionality_WSJF	
Scenario Outline: TFSScrum_WorkitemCreation_PreCompuation 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i "update" a "Story_wsjf_Multiply_0_UpdateFormula" in TFS for "PreComputation_WSJF"
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "PreComputation_WSJF"
	And i put a explicit wait of "900000" 
	Examples: 
		| applicationname |
		| TFS             |
				    
@API_IB_Verfification_TFSScrum_PrecomputationEngineFunctionality_WSJF	
Scenario: TFSScrum_PrecomputationEngine_WSJF_IBVerification_UserStoryUpdated
	Given i load the project properties file 
	And i generate a token for "DevTest" environment  
	And i verify the "inbound" details for "Story_wsjf_Multiply_0_UpdateFormula" for tool "TFS Scrum" using "flat" query whose client is "PreComputationEngine_ClientUId" and DC is "PreComputationEngine_DeliveryConstructUId_L2" for "WSJF" functionality  
	
