@Browser
Feature: Googletest

  Scenario Outline: 
    Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"
    And i create a "<bug>" in TFS 
    And i create a "<Epic>" in TFS
    And i create a "<Feature>" in TFS
    And i create a "<Impediment>" in TFS
    And i create a "<Task>" in TFS
    And i create a "<TestCase>" in TFS
    And i create a "<ProductBacklog>" in TFS
    And i create "<Release>" and "<Sprint>" in TFS
    And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"

  
    Examples: 
      | applicationname | Impediment    | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | ProductBacklog    |Release    | Sprint    |
      | TFS             | Impediment_01 | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 | Story_01 | ProductBacklog_01 |Release_01 | Sprint_01 |
