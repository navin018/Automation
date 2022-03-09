@IBvalidation
Feature:Workitem_ADT

  Scenario Outline: ADTJIRA_WorkitemCreationInUI
    Given i load the "ADT Jira" project properties file
    Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"
    And i create a "<epic>" in Jira
    And i create a "<task>" in Jira
    And i create a "<story>" in Jira
    And i create a "<risk>" in Jira
    And i create a "<bug>" in Jira
    And i create a "<issue>" in Jira
    And i create a "<feature>" in Jira
    And i create a "<impediment>" in Jira
    And i create a "<deliverable>" in Jira
    And i create a "<Decision>" in Jira
    And i create a "<Requirement>" in Jira
    And i create a "<Test>" in Jira
    And i create a "<milestone>" in Jira
    And i create a "<Action>" in Jira
    And i create a "<WorkRequest>" in Jira
    And i create a "<TestExecution>" in Jira
    And i create entity "<TestForTestExec>" in Jira

    And i create an "<Release>" in Jira
    And i create an "<Sprint>" in Jira
#	And i create an "<Team>" in Jira
    And i update the WorkItemExternalIDs into a New JSON file for "<applicationname>"
    And i check the overall status of workitem creation for "<applicationname>"
#	And i put a explicit wait of "900000"
#	And i generate a token for "DevTest" environment


    Examples:
      | applicationname | task    | story    | risk    |Requirement| Test|issue    | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    | Sprint    |Team|milestone|TestExecution|Action|TestForTestExec|WorkRequest|Decision|
      | ADT Jira            | Task_01 | Story_01 | Risk_01 | Requirement_01| Test_01|Issue_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 | Sprint_01 |Team_01|Milestone_01|Test Execution_01|Action_01|TestForTestExec_01|Work Request_01|Decision_01|


