@3API_IB_Verfification_TFSScrum_PrecomputationEngineFunctionality_RAGAndInference
Feature: TFSScrum PrecomputationEngine RAG functionality IB Verification 


Scenario: TFSScrum_PrecomputationEngine_RAG_IBVerification_UserStory
	Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify the "inbound" details for "Story_RAG_StatusDone_Rule1" for tool "TFS Scrum" using "flat" query whose client is "PreComputationEngine_ClientUId" and DC is "PreComputationEngine_DeliveryConstructUId_L2" for "RAG" functionality
	And i verify the "inbound" details for "Story_RAG_StatusInactivate_Rule2" for tool "TFS Scrum" using "flat" query whose client is "PreComputationEngine_ClientUId" and DC is "PreComputationEngine_DeliveryConstructUId_L2" for "RAG" functionality 
	And i verify the "inbound" details for "Story_RAG_NoAssociation_Rule3" for tool "TFS Scrum" using "flat" query whose client is "PreComputationEngine_ClientUId" and DC is "PreComputationEngine_DeliveryConstructUId_L2" for "RAG" functionality
	And i verify the "inbound" details for "Story_RAG_IterationTiming_Rule4" for tool "TFS Scrum" using "flat" query whose client is "PreComputationEngine_ClientUId" and DC is "PreComputationEngine_DeliveryConstructUId_L2" for "RAG" functionality
	And i verify the "inbound" details for "Story_RAG_IterationTiming_Rule5" for tool "TFS Scrum" using "flat" query whose client is "PreComputationEngine_ClientUId" and DC is "PreComputationEngine_DeliveryConstructUId_L2" for "RAG" functionality
	And i verify the "inbound" details for "Story_RAG_AssociatedToStory_Rule7" for tool "TFS Scrum" using "flat" query whose client is "PreComputationEngine_ClientUId" and DC is "PreComputationEngine_DeliveryConstructUId_L2" for "RAG" functionality
	
	And i verify the "inbound" details for "Story_RAG_PastIteration_Rule10" for tool "TFS Scrum" using "flat" query whose client is "PreComputationEngine_ClientUId" and DC is "PreComputationEngine_DeliveryConstructUId_L2" for "RAG" functionality
	And i verify the "inbound" details for "Story_RAG_IterationTiming_Rule11" for tool "TFS Scrum" using "flat" query whose client is "PreComputationEngine_ClientUId" and DC is "PreComputationEngine_DeliveryConstructUId_L2" for "RAG" functionality
		