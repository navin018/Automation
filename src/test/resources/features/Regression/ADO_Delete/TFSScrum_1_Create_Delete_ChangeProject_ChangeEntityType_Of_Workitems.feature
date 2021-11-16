Feature: TFSScrum Delete functionality 

@1WorkItemCreation_TFSScrum_DeleteFunctionality		
Scenario Outline: TFSScrum_WorkitemCreation 
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
	And i create a "<Impediment>" in TFS 
	And i create a "<ProductBacklog>" in TFS 
	And i create a "<WorkRequest>" in TFS
	#     And i create a "<TestResult>" in TFS
	
	And i create "<Release>" and "<Sprint>" in TFS 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	And i put a explicit wait of "900000" 
	And i generate a token for "DevTest" environment 
	
Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | ProductBacklog    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|WorkRequest|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |ProductBacklog_01 | Release_02 | Sprint_02 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|Work Request_01|

@2Delete_TestData_TFSScrum_DeleteFunctionality 
Scenario Outline: Delete_TestData_TFSScrum 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i delete "<bug>" in TFS 
	And i delete "<Epic>" in TFS 
	And i delete "<Feature>" in TFS 
	And i delete "<Issue>" in TFS 
	And i delete "<Task>" in TFS 
	And i delete "<TestCase>" in TFS 
	And i delete "<Risk>" in TFS 
	And i delete "<Action>" in TFS 
	And i delete "<Decision>" in TFS 
	And i delete "<Deliverable>" in TFS 
	And i delete "<Requirement>" in TFS 
	And i delete "<Milestone>" in TFS 
	And i delete "<Impediment>" in TFS 
	And i delete "<ProductBacklog>" in TFS 
	And i delete "<WorkRequest>" in TFS
	And i delete "ReleaseAndSprint" in TFS	 		


Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | ProductBacklog    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|WorkRequest|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |ProductBacklog_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|Work Request_01|

		

			
@3ChangeProjectOfWorkItems_TFSScrum 
Scenario Outline: TFSScrum_ChangeProjectOfWorkitems 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i change the "project" of "<bug>" in TFS
	And i change the "project" of "<Impediment>" in TFS
	And i change the "project" of "<Task>" in TFS
	And i change the "project" of "<Epic>" in TFS
	And i change the "project" of "<Feature>" in TFS
	And i change the "project" of "<Issue>" in TFS	
	And i change the "project" of "<Risk>" in TFS
	And i change the "project" of "<Milestone>" in TFS
	And i change the "project" of "<Action>" in TFS
	And i change the "project" of "<Decision>" in TFS
	And i change the "project" of "<Deliverable>" in TFS
	And i change the "project" of "<Requirement>" in TFS
	And i change the "project" of "<ProductBacklog>" in TFS		
	And i change the "project" of "<WorkRequest>" in TFS
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for "moveProjectOrIssue" functionality 

       Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|ProductBacklog|Milestone|Requirement|WorkRequest|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 | Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|ProductBacklog_01|Milestone_01|Requirement_01|Work Request_01|

						
@4ChangeEntityTypeOfWorkItems_TFSScrum_DeleteFunctionality
Scenario Outline: TFSScrum_ChangeProjectOfWorkitems 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i change the "entitytype" of "<bug>" to "<Milestone>" in TFS 
	And i change the "entitytype" of "<Task>" to "<Action>" in TFS 
	And i change the "entitytype" of "<Epic>" to "<Requirement>" in TFS 
	And i change the "entitytype" of "<Decision>" to "<Feature>" in TFS 
	And i change the "entitytype" of "<Risk>" to "<Issue>" in TFS 
	 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for "moveProjectOrIssue" functionality

 
	   Examples: 
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|ProductBacklog|Milestone|Requirement|
      | TFS             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 | Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|ProductBacklog_01|Milestone_01|Requirement_01|

	
