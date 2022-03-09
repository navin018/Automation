@IBvalidation
Feature:Workitem_AIDT

  Scenario Outline: ADIT_WorkitemCreation
    Given i load the "AIDT" project properties file
    Given i login to application "<applicationname>"
    And i create "<Release>" and "<Sprint>" in "AIDT"
    And i create a "<bug>" in "AIDT"
    And i create a "<Epic>" in "AIDT"
    And i create a "<Feature>" in "AIDT"
    And i create a "<Issue>" in "AIDT"
    And i create a "<Task>" in "AIDT"
    And i create a "<Risk>" in "AIDT"
    And i create a "<Action>" in "AIDT"
    And i create a "<Decision>" in "AIDT"
    And i create a "<Deliverable>" in "AIDT"
    And i create a "<Story>" in "AIDT"
    And i create a "<Impediment>" in "AIDT"
    And i create a "<Milestone>" in "AIDT"
    And i create a "<Requirement>" in "AIDT"
  #And i create "<Release>" and "<Sprint>" in "AIDT"
#    And i create a "Team" in "AIDT"
#
    And i update the WorkItemExternalIDs into a New JSON file for "<applicationname>"
#	And i put a explicit wait of "900000"
#	And i generate a token for "DevTest" environment

#	    Examples:
    #	    | applicationname | toolname | bug    | Epic    | Feature    | Issue    | Task    |  Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|
  #    | AIDT            | AIDT     |Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|



    Examples:
      | applicationname | toolname | bug | Epic | Feature | Issue | Task | Story | Release | Sprint |Decision |Action |Deliverable |Impediment | Risk |Milestone |Requirement|
      | AIDT | AIDT |Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | Story_01 | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|Milestone_01| Requirement_01|

