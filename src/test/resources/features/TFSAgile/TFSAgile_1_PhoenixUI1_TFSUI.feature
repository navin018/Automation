Feature: PhoenixUI_TFSAgileUI1

  @5WorkItemCreation_TFSAgile
  Scenario Outline: TFSAgile_WorkitemCreation
    Given i load the "TFS Agile" project properties file
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
    And i create a "<Story>" in TFS
    And i create a "<WorkRequest>" in TFS
##     And i create a "<TestResult>" in TFS
#
    And i create "<Release>" and "<Sprint>" in TFS
    And i update the WorkItemExternalIDs into a New JSON file for "<applicationname>"
#	And i put a explicit wait of "900000"
#	And i generate a token for "DevTest" environment

    Examples:
      | applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|Milestone|TestResult|Requirement|WorkRequest|
      | TFS Agile       | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 |Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01|TestResult|Requirement_01|Work Request_01|
