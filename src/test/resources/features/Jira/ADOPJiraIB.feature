@Browser
Feature: ADOP Jira inbound workitem creation

  Scenario Outline: 
    Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"
	    And i create a "<feature>" in Jira
	    And i create a "<task>" in Jira
	    And i create a "<story>" in Jira
	    And i create a "<risk>" in Jira
	    And i create a "<bug>" in Jira
	    And i create a "<impediment>" in Jira
	    And i create a "<epic>" in Jira
	    And i create a "<issue>" in Jira
	    And i create an "<Release>" in Jira
    	And i create an "<Sprint>" in Jira
    And i update the WorkItemExternalIDs into a JSON file for "<applicationname>"

    Examples: 
      | applicationname | feature             | task    | story    | risk         | issue         | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    |Sprint    |
      | Jira            | New Feature_ADOP_01 | Task_01 | Story_01 | Risk_ADOP_01 | Issue_ADOP_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 |Sprint_01 |
