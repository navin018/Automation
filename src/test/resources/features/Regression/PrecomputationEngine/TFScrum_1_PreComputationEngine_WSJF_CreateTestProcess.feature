Feature: TFSScrum PrecomputationEngine for WSJF functionality 

@1CreateTestProcess_TFSScrum_PreComputationFunctionality_WSJF_ProductBacklog_NegativeInt
Scenario Outline: TFSScrum_WorkitemCreation_PreCompuation 
	Given i load the project properties file 
	Given i login to application "MyWizard"  
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i select client "PreComputationEngine_Client" with DC_L1 as "PreComputationEngine_DC_L1" and DC_L2 as "PreComputationEngine_DC_L2" 
	And i click on tile "Precomputation Engine"
    Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Story_wsjf_Negative_Int" and add the formula "( Priority / BusinessValue ) - StoryPoints" for tool "TFS Scrum" 
    Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Story_wsjf_Multiply_0" and add the formula "( Priority / BusinessValue ) - StoryPoints" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Story_wsjf_Deno_0" and add the formula "AVG ( StoryPoints + BusinessValue ) / RiskReduction" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Story_wsjf_Nume_0" and add the formula " StoryPoints / ( Priority * Rank )" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Story_wsjf_Negative_Int" and add the formula "( Priority / BusinessValue ) - StoryPoints" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Story_wsjf_Decimal_Tool" and add the formula "StackRank * Effort" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Story_wsjf_Zero_Tool" and add the formula "Rank + StoryPoints" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Story_wsjf_Decimal_Output" and add the formula "Priority / BusinessValue" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Story_wsjf_Function" and add the formula "AVG ( StoryPoints , business value )" for tool "TFS Scrum"
	
	

# 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Multiply_0" and add the formula "( OriginalEstimate + CompletedWork ) * RemainingWork" for tool "TFS Scrum"
# 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Deno_0" and add the formula "( OriginalEstimate + CompletedWork ) / RemainingWork" for tool "TFS Scrum"
#	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Nume_0" and add the formula "RemainingWork / ( OriginalEstimate + CompletedWork )" for tool "TFS Scrum"
#	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Negative_Int" and add the formula "( OriginalEstimate / CompletedWork ) - RemainingWork" for tool "TFS Scrum"
#	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Decimal_Tool" and add the formula "OriginalEstimate * CompletedWork" for tool "TFS Scrum"
#	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Zero_Tool" and add the formula "CompletedWork + RemainingWork" for tool "TFS Scrum"
# 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Decimal_Output" and add the formula "CompletedWork / RemainingWork" for tool "TFS Scrum"
# 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Function" and add the formula "MIN ( OriginalEstimate , CompletedWork )" for tool "TFS Scrum"
# 	

#process for association scenario
   Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Story_wsjf_AssocationToTask" and add the formula "Priority + StoryPoints - BusinessValue_Task" for tool "TFS Scrum"
   																																	
   
	#process to test state pending, priority and sev pending
			Examples: 
		| applicationname |UserStory|
		| MyWizard        |ProductBacklog_wsjf_Negative_Int|
		
