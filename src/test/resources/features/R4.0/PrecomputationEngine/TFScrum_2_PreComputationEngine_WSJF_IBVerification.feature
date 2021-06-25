Feature: TFSScrum PrecomputationEngine WSJF functionality IB Verification 

@testprecomp
Scenario: TFSScrum_PrecomputationEngine_WSJF_IBVerification_UserStory
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify the "inbound" details for "Story_wsjf_Multiply_0" for tool "TFS Scrum" using "flat" query whose client is "PreComputationEngine_ClientUId" and DC is "PreComputationEngine_DeliveryConstructUId_L2" for "WSJF" functionality 
	
	
	