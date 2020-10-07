@Browser
Feature: ADTJira inbound workitems creation

  Scenario Outline: 
    Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"
    And i verify the Release and Sprint for "<applicationname>" 

    Examples: 
      | applicationname |
      | TFS            |
