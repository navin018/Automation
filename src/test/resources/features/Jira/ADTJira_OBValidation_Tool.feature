Feature: ADTJira_OB_ValidationInTool

  Scenario Outline: ADTJira_OB_ValidationInTool
    Given i login to application "<applicationname>"
   Then i select a Project for "<applicationname>"
    And i validate the outbound flow

    Examples: 
      | applicationname | 
      | Jira            | 
