@Browser
Feature: ADTJira inbound existing workitems creation

  Scenario Outline: 
   And i copy existing workitem details for "<applicationname>" into WorkItemExternalIDsFile
    

    Examples: 
      | applicationname | task    | story    | risk    | issue    | bug    | feature    | impediment    | deliverable    | epic    | subtask    | Release    | Sprint    |
      | Jira            | Task_01 | Story_01 | Risk_01 | Issue_01 | Bug_01 | Feature_01 | Impediment_01 | Deliverable_01 | Epic_01 | SubTask_01 | Release_01 | Sprint_01 |
