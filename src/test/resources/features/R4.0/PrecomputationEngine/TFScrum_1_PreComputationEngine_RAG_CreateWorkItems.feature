Feature: TFSScrum PrecomputationEngine Workitems creation for WSJF functionality 

		
@2WorkItemCreation_TFSScrum_PrecomputationEngineFunctionality_RAG
Scenario Outline: TFSScrum_WorkitemCreation_PreCompuation 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>"
	#Rule1,2,3 
	And i "create" a "Story_RAG_StatusDone_Rule1" in TFS for "PreComputation_RAG"
	And i "create" a "Story_RAG_StatusInactivate_Rule2" in TFS for "PreComputation_RAG"
	And i "create" a "Story_RAG_NoAssociation_Rule3" in TFS for "PreComputation_RAG"
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "PreComputation_RAG"	
	#Rule4
	And i create a "Release" with start date as "-60" days from today and end date as "1" days from today in TFS 
	And i create a "Sprint" with start date as "-30" days from today and end date as "1" days from today in TFS 
	And i "create" a "Story_RAG_IterationTiming_Rule4" in TFS for "PreComputation_RAG"
	
	#Rule5
	And i create a "Release" with start date as "1" days from today and end date as "60" days from today in TFS 
	And i create a "Sprint" with start date as "2" days from today and end date as "7" days from today in TFS 
	And i "create" a "Story_RAG_IterationTiming_Rule5" in TFS for "PreComputation_RAG"
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "PreComputation_RAG"
	
	#Rule7
	And i create a "Release" with start date as "1" days from today and end date as "60" days from today in TFS 
	And i create a "Sprint" with start date as "2" days from today and end date as "7" days from today in TFS
	And i "create" a "Story_RAG_AssociatedIterationTiming_Rule7" in TFS for "PreComputation_RAG"
	
	And i create a "Release" with start date as "1" days from today and end date as "60" days from today in TFS 
	And i create a "Sprint" with start date as "2" days from today and end date as "14" days from today in TFS
	And i "create" a "Story_RAG_AssociatedToStory_Rule7" in TFS for "PreComputation_RAG"
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "PreComputation_RAG"	
	And i associate "Story_RAG_AssociatedIterationTiming_Rule7" to "Story_RAG_AssociatedToStory_Rule7" with relationship "Parent" for functionality "RAG" in TFS 
	
	#Rule10
	And i "create" a "Risk_RAG_ToBeAssociatedToStory_Rule10" in TFS for "PreComputation_RAG"
	And i create a "Release" with start date as "1" days from today and end date as "60" days from today in TFS
	And i create a "Sprint" with start date as "-7" days from today and end date as "-1" days from today in TFS
	And i "create" a "Story_RAG_PastIteration_Rule10" in TFS for "PreComputation_RAG"
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "PreComputation_RAG"	
	And i associate "Story_RAG_PastIteration_Rule10" to "Risk_RAG_ToBeAssociatedToStory_Rule10" with relationship "Related" for functionality "RAG" in TFS
	
	#Rule11
	And i "create" a "Risk_RAG_ToBeAssociatedToStory_Rule11" in TFS for "PreComputation_RAG"
	And i create a "Release" with start date as "1" days from today and end date as "60" days from today in TFS 
	And i create a "Sprint" with start date as "2" days from today and end date as "7" days from today in TFS 
	And i "create" a "Story_RAG_IterationTiming_Rule11" in TFS for "PreComputation_RAG"
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "PreComputation_RAG"	
	And i associate "Story_RAG_IterationTiming_Rule11" to "Risk_RAG_ToBeAssociatedToStory_Rule11" with relationship "Related" for functionality "RAG" in TFS
	
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for functionality "PreComputation_RAG"
	And i put a explicit wait of "900000" 

	
	Examples: 
		| applicationname |
		| TFS             |
		

	
