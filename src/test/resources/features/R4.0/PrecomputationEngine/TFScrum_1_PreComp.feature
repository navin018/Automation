Feature: TFSScrum PrecomputationEngine functionality 

@1WorkItemCreation_TFSScrum_PreCompFunctionality		
Scenario Outline: TFSScrum_WorkitemCreation_PreCompuation 
	Given i load the project properties file 
#	Given i login to application "<applicationname>" 
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
	And i create a "<Impediment>" in TFS 
#	And i create a "<ProductBacklog>" in TFS 
	And i create a "<WorkRequest>" in TFS
	#     And i create a "<TestResult>" in TFS
	
#	And i create "<Release>" and "<Sprint>" in TFS 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
#	And i put a explicit wait of "900000" 

	
	Examples: 
		| applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | ProductBacklog    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|WorkRequest|
		| TFS             | Bug_wsjf | Epic_wsjf | Feature_wsjf | Issue_wsjf | Task_wsjf | TestCase_wsjf |ProductBacklog_wsjf | Release_02 | Sprint_02 |Decision_wsjf|Action_wsjf|Deliverable_wsjf|Impediment_wsjf|Risk_wsjf|Milestone_wsjf|TestResult|Requirement_wsjf|Work Request_wsjf|
	
	@1CreateTestProcess_TFSScrum_PreCompFunctionality		
Scenario Outline: TFSScrum_WorkitemCreation_PreCompuation 
	Given i load the project properties file 
#	Given i login to application "<applicationname>"  
#	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
#	And i select client "PreComputationEngine_Client" with DC_L1 as "PreComputationEngine_DC_L1" and DC_L2 as "PreComputationEngine_DC_L2" 
#	And i click on tile "Precomputation Engine"
    Then i "add" a process of type "Compute" for entity "WorkItem" and subentity "<UserStory>" and add the formula "StoryPoints / ( Priority * Rank )" 
   
	
			Examples: 
		| applicationname |UserStory|
		| MyWizard        |Story_wsjf|