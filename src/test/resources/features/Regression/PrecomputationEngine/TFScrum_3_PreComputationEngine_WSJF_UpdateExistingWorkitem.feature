@5API_UpdateWorkitemScenario_TFSScrum_PrecomputationEngineFunctionality_WSJF	
Feature: TFSScrum PrecomputationEngine WSJF functionality IB Verification 


@4UpdateWorkItem_TFSScrum_PrecomputationEngineFunctionality_WSJF	
Scenario Outline: TFSScrum_WorkitemCreation_PreCompuation 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i "update" a "Story_wsjf_Negative_Int_UpdateWorkitem" in TFS for "PreComputation_WSJF"
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "PreComputation_WSJF"
#	And i put a explicit wait of "900000" 
	Examples: 
		| applicationname |
		| TFS             |
@3API_IB_Verfification_TFSScrum_PrecomputationEngineFunctionality_WSJF	
Scenario: TFSScrum_PrecomputationEngine_WSJF_IBVerification_UserStoryUpdated
	Given i load the project properties file 
	And i generate a token for "DevTest" environment  
	And i verify the "inbound" details for "Story_wsjf_Negative_Int_UpdateWorkitem" for tool "TFS Scrum" using "flat" query whose client is "PreComputationEngine_ClientUId" and DC is "PreComputationEngine_DeliveryConstructUId_L2" for "WSJF" functionality  
	
