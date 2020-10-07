@Browser
Feature: Googletest

  Scenario Outline: 
    Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"
       And i validate the outbound flow for "<applicationname>"

    Examples: 
      | applicationname | 
      | TFS             | 
