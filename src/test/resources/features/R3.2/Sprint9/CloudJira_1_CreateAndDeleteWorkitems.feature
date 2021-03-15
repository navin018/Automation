Feature: CloudJira Delete functionality
@Delete_TestData_CloudJira_DeleteFunctionality      
Scenario Outline: Delete_TestData_CloudJira
	Given i load the project properties file 
    Given i login to application "<applicationname>"
   Then i select a Project for "<applicationname>"
	And i delete the test automation data for "workitems" for "<applicationname>"
   	And i delete the test automation data for "release" for "<applicationname>"
   	And i delete the test automation data for "sprint" for "<applicationname>"

    Examples: 
      | applicationname |
      |Cloud Jira         | 
      
      

@1WorkItemCreation_CloudJira_DeleteFunctionality		
Scenario Outline: CloudJIRA_WorkitemCreationInUI
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i create a "<task>" in CloudJira 
	And i create a "<story>" in CloudJira 
	And i create a "<bug>" in CloudJira 
	And i create a "<epic>" in CloudJira 
	And i create an "<Release>" in Jira 
	And i create an "<Sprint>" in Jira 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" 
	And i put a explicit wait of "900000" 
	And i generate a token for "DevTest" environment 
	
	
 Examples: 
      | applicationname | feature             | task    | story    | risk         | issue         | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    |Sprint    |
      | Cloud Jira            | New Feature_Cloud_01 | Task_01 | Story_01 | Risk_Cloud_01 | Issue_Cloud_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_02 |Sprint_01 |

@2ChangeProjectOfWorkItemsAndEntityType_CloudJira
Scenario Outline: CloudJIRA_ChangeProjectOfWorkitems
Given i load the project properties file 
	Given i login to application "<applicationname>" 
	Then i select a Project for "<applicationname>" 
	And i change the "project" of "<task>" in "<applicationname>"
	And i change the "entitytype" of "<story>" to "<epic>" in "<applicationname>" 
	And i update the WorkItemExternalIDs into a JSON file for "<applicationname>" for "moveProjectOrIssue" functionality
	Examples: 
      | applicationname | feature             | task    | story    | risk         | issue         | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    |Sprint    |
      | Cloud Jira            | New Feature_Cloud_01 | Task_01 | Story_01 | Risk_Cloud_01 | Issue_Cloud_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_02 |Sprint_01 |


