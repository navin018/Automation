Feature: TFSScrum PrecomputationEngine for WSJF functionality 

@2CreateTestProcess_TFSScrum_PreComputationFunctionality_WSJF_ProductBacklog_NegativeInt
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
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Task_wsjf_Multiply_0" and add the formula "( BusinessValue + Priority ) * CompletedWork" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Task_wsjf_Deno_0" and add the formula "AVG ( Priority + BusinessValue) / CompletedWork" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Task_wsjf_Nume_0" and add the formula "CompletedWork / ( Priority * Rank )" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Task_wsjf_Negative_Int" and add the formula "( Priority / BusinessValue ) - RemainingWork" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Task_wsjf_Decimal_Tool" and add the formula "OriginalEstimate * RemainingWork" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Task_wsjf_Zero_Tool" and add the formula "OriginalEstimate + CompletedWork" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Task_wsjf_Decimal_Output" and add the formula "Priority / BusinessValue" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Epic_wsjf_Multiply_0" and add the formula "( BusinessValue + Priority ) * StackRank" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Epic_wsjf_Deno_0" and add the formula "AVG ( BusinessValue , Priority ) / StackRank" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Epic_wsjf_Nume_0" and add the formula "BusinessValue / ( Priority * StackRank )" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Epic_wsjf_Negative_Int" and add the formula "( Priority / BusinessValue ) - TimeCriticality" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Epic_wsjf_Decimal_Tool" and add the formula "Effort * StackRank" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Epic_wsjf_Zero_Tool" and add the formula "StackRank + TimeCriticality" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Epic_wsjf_Decimal_Output" and add the formula "Priority / BusinessValue" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Bug_wsjf_Multiply_0" and add the formula "( BusinessValue + Priority ) * StackRank" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Bug_wsjf_Deno_0" and add the formula "AVG ( BusinessValue , Priority ) / StackRank" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Bug_wsjf_Nume_0" and add the formula "BusinessValue / ( Priority * StackRank )" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Bug_wsjf_Negative_Int" and add the formula "( Priority / BusinessValue ) - Effort" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Bug_wsjf_Decimal_Tool" and add the formula "Effort * StackRank" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Bug_wsjf_Zero_Tool" and add the formula "Effort + RemainingWork" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Bug_wsjf_Decimal_Output" and add the formula "Priority / BusinessValue" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Impediment_wsjf_Multiply_0" and add the formula "( BusinessValue + Priority ) * StackRank" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Impediment_wsjf_Deno_0" and add the formula "AVG ( BusinessValue , Priority ) / StackRank" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Impediment_wsjf_Nume_0" and add the formula "BusinessValue / ( Priority * StackRank )" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Impediment_wsjf_Negative_Int" and add the formula "( Priority / BusinessValue ) - StackRank" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Impediment_wsjf_Zero_Tool" and add the formula "BusinessValue + StackRank" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Impediment_wsjf_Decimal_Output" and add the formula "Priority / BusinessValue" for tool "TFS Scrum"
  	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Feature_wsjf_Multiply_0" and add the formula "( BusinessValue + Priority ) * StackRank" for tool "TFS Scrum"
    Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Feature_wsjf_Deno_0" and add the formula "AVG ( BusinessValue , Priority ) / StackRank" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Feature_wsjf_Nume_0" and add the formula "BusinessValue / ( Priority * StackRank)" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Feature_wsjf_Negative_Int" and add the formula "( Priority / BusinessValue ) - TimeCriticality" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Feature_wsjf_Decimal_Tool" and add the formula "Effort * StackRank" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Feature_wsjf_Zero_Tool" and add the formula "StackRank + TimeCriticality" for tool "TFS Scrum"
  	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Feature_wsjf_Decimal_Output" and add the formula "Priority / BusinessValue" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Multiply_0" and add the formula "( OriginalEstimate + CompletedWork ) * RemainingWork" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Deno_0" and add the formula "( OriginalEstimate + CompletedWork ) / RemainingWork" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Nume_0" and add the formula "RemainingWork / ( OriginalEstimate + CompletedWork )" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Negative_Int" and add the formula "( OriginalEstimate / CompletedWork ) - RemainingWork" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Decimal_Tool" and add the formula "OriginalEstimate * CompletedWork" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Zero_Tool" and add the formula "CompletedWork + RemainingWork" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Deliverable_wsjf_Decimal_Output" and add the formula "CompletedWork / RemainingWork" for tool "TFS Scrum"
	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Work Request_wsjf_Multiply_0" and add the formula "( CostApproved + Priority ) * CostEstimate" for tool "TFS Scrum"
  	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Work Request_wsjf_Deno_0" and add the formula "AVG ( CostApproved , Priority ) / CostEstimate" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Work Request_wsjf_Nume_0" and add the formula "CostEstimate / ( Priority * CostApproved )" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Work Request_wsjf_Negative_Int" and add the formula "( Priority / CostEstimate ) - CostApproved" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Work Request_wsjf_Zero_Tool" and add the formula "CostEstimate + CostApproved" for tool "TFS Scrum"
 	Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "Work Request_wsjf_Decimal_Output" and add the formula "Priority / CostEstimate" for tool "TFS Scrum"
   
   
	
			Examples: 
		| applicationname |UserStory|
		| MyWizard        |ProductBacklog_wsjf_Negative_Int|
		
		
@1WorkItemCreation_TFSScrum_PrecomputationEngineFunctionality_WSJF	
Scenario Outline: TFSScrum_WorkitemCreation_PreCompuation 
	Given i load the project properties file 
#	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create a "ProductBacklog_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
	And i create a "ProductBacklog_wsjf_Nume_0" in TFS for "PreComputation_WSJF"
	And i create a "ProductBacklog_wsjf_Negative_Int" in TFS for "PreComputation_WSJF"
	And i create a "ProductBacklog_wsjf_Decimal_Tool" in TFS for "PreComputation_WSJF"
	And i create a "ProductBacklog_wsjf_Multiply_0" in TFS for "PreComputation_WSJF"
	And i create a "ProductBacklog_wsjf_Zero_Tool" in TFS for "PreComputation_WSJF"
	And i create a "ProductBacklog_wsjf_Decimal_Output" in TFS for "PreComputation_WSJF"
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "PreComputation_WSJF"
#	And i put a explicit wait of "900000" 

	
	Examples: 
		| applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | ProductBacklog    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|WorkRequest|
		| TFS             | Bug_wsjf | Epic_wsjf | Feature_wsjf | Issue_wsjf | Task_wsjf | TestCase_wsjf |ProductBacklog_wsjf | Release_02 | Sprint_02 |Decision_wsjf|Action_wsjf|Deliverable_wsjf|Impediment_wsjf|Risk_wsjf|Milestone_wsjf|TestResult|Requirement_wsjf|Work Request_wsjf|
	
