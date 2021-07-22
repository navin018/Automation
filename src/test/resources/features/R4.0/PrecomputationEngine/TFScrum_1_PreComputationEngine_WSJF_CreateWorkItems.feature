Feature: TFSScrum PrecomputationEngine Workitems creation for WSJF functionality 

		
@2WorkItemCreation_TFSScrum_PrecomputationEngineFunctionality_WSJF1	
Scenario Outline: TFSScrum_WorkitemCreation_PreCompuation 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i "create" a "Story_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
	And i "create" a "Story_wsjf_Nume_0" in TFS for "PreComputation_WSJF"
	And i "create" a "Story_wsjf_Negative_Int" in TFS for "PreComputation_WSJF"
	And i "create" a "Story_wsjf_Decimal_Tool" in TFS for "PreComputation_WSJF"
	And i "create" a "Story_wsjf_Multiply_0" in TFS for "PreComputation_WSJF"
	And i "create" a "Story_wsjf_Zero_Tool" in TFS for "PreComputation_WSJF"
	And i "create" a "Story_wsjf_Decimal_Output" in TFS for "PreComputation_WSJF"
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "PreComputation_WSJF"
#	
#	And i "create" a "Impediment_wsjf_Multiply_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Impediment_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Impediment_wsjf_Nume_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Impediment_wsjf_Negative_Int" in TFS for "PreComputation_WSJF"
#	And i "create" a "Impediment_wsjf_Zero_Tool" in TFS for "PreComputation_WSJF"
#	And i "create" a "Impediment_wsjf_Decimal_Output" in TFS for "PreComputation_WSJF"
#	
#	
#	And i "create" a "Task_wsjf_Multiply_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Task_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Task_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Task_wsjf_Negative_Int" in TFS for "PreComputation_WSJF"
#	And i "create" a "Task_wsjf_Decimal_Tool" in TFS for "PreComputation_WSJF"
#	And i "create" a "Task_wsjf_Zero_Tool" in TFS for "PreComputation_WSJF"
#	And i "create" a "Task_wsjf_Decimal_Output" in TFS for "PreComputation_WSJF"
#	
#	And i "create" a "Bug_wsjf_Multiply_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Bug_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Bug_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Bug_wsjf_Negative_Int" in TFS for "PreComputation_WSJF"
#	And i "create" a "Bug_wsjf_Decimal_Tool" in TFS for "PreComputation_WSJF"
#	And i "create" a "Bug_wsjf_Zero_Tool" in TFS for "PreComputation_WSJF"
#	And i "create" a "Bug_wsjf_Decimal_Output" in TFS for "PreComputation_WSJF"
#	
#	And i "create" a "Work Request_wsjf_Multiply_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Work Request_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Work Request_wsjf_Nume_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Work Request_wsjf_Negative_Int" in TFS for "PreComputation_WSJF"
#	And i "create" a "Work Request_wsjf_Zero_Tool" in TFS for "PreComputation_WSJF"
#	And i "create" a "Work Request_wsjf_Decimal_Output" in TFS for "PreComputation_WSJF"
#	
#	
#	And i "create" a "Decision_wsjf_Multiply_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Decision_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Decision_wsjf_Nume_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Decision_wsjf_Negative_Int" in TFS for "PreComputation_WSJF"
#	And i "create" a "Decision_wsjf_Decimal_Output" in TFS for "PreComputation_WSJF"
#	
#	And i "create" a "Issue_wsjf_Multiply_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Issue_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Issue_wsjf_Nume_0" in TFS for "PreComputation_WSJF"
#	And i "create" a "Issue_wsjf_Negative_Int" in TFS for "PreComputation_WSJF"
#	And i "create" a "Issue_wsjf_Decimal_Output" in TFS for "PreComputation_WSJF"
#	
#	And i "create" a "Epic_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
#    And i "create" a "Epic_wsjf_Nume_0" in TFS for "PreComputation_WSJF"
#    And i "create" a "Epic_wsjf_Negative_Int" in TFS for "PreComputation_WSJF"
#    And i "create" a "Epic_wsjf_Decimal_Tool" in TFS for "PreComputation_WSJF"
#    And i "create" a "Epic_wsjf_Multiply_0" in TFS for "PreComputation_WSJF"
#    And i "create" a "Epic_wsjf_Zero_Tool" in TFS for "PreComputation_WSJF"
#    And i "create" a "Epic_wsjf_Decimal_Output" in TFS for "PreComputation_WSJF"
#   
#   
#    And i "create" a "Feature_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
#    And i "create" a "Feature_wsjf_Nume_0" in TFS for "PreComputation_WSJF"
#    And i "create" a "Feature_wsjf_Negative_Int" in TFS for "PreComputation_WSJF"
#    And i "create" a "Featurec_wsjf_Decimal_Tool" in TFS for "PreComputation_WSJF"
#    And i "create" a "Feature_wsjf_Multiply_0" in TFS for "PreComputation_WSJF"
#    And i "create" a "Feature_wsjf_Zero_Tool" in TFS for "PreComputation_WSJF"
#    And i "create" a "Feature_wsjf_Decimal_Output" in TFS for "PreComputation_WSJF"
#   
#   
#    And i "create" a "Deliverable_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
#    And i "create" a "Deliverable_wsjf_Nume_0" in TFS for "PreComputation_WSJF"
#    And i "create" a "Deliverable_wsjf_Negative_Int" in TFS for "PreComputation_WSJF"
#    And i "create" a "Deliverable_wsjf_Decimal_Tool" in TFS for "PreComputation_WSJF"
#    And i "create" a "Deliverable_wsjf_Multiply_0" in TFS for "PreComputation_WSJF"
#    And i "create" a "Deliverable_wsjf_Zero_Tool" in TFS for "PreComputation_WSJF"
#    And i "create" a "Deliverable_wsjf_Decimal_Output" in TFS for "PreComputation_WSJF"
#   
#    And i "create" a "TestCase_wsjf_Deno_0" in TFS for "PreComputation_WSJF"
#    And i "create" a "TestCase_wsjf_Nume_0" in TFS for "PreComputation_WSJF"
#    And i "create" a "TestCase_wsjf_Negative_Int" in TFS for "PreComputation_WSJF"
#    And i "create" a "TestCase_wsjf_Decimal_Tool" in TFS for "PreComputation_WSJF"
#    And i "create" a "TestCase_wsjf_Multiply_0" in TFS for "PreComputation_WSJF"
#    And i "create" a "TestCase_wsjf_Decimal_Output" in TFS for "PreComputation_WSJF"
#    
#    
	And i "update" a "Story_wsjf_Deno_0_update" in TFS for "PreComputation_WSJF"
##	check this scenario. some entry is missing in baseclass
	And i "create" a "Story_wsjf_AssocationToTask" associated to "Task_wsjf_AssocationToStory" with linking as "Related" in TFS for "PreComputation_WSJF" 
	
	
	
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "PreComputation_WSJF"
#	And i put a explicit wait of "900000" 

	
	Examples: 
		| applicationname |
		| TFS             |
		

	
