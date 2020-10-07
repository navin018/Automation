@Browser
Feature: Googletest

  Scenario Outline: 
    Given i login to application "<applicationname>"
    Then i select a Project for "<applicationname>"
    Then i delete the test automation data for query "DeleteAutomationTestData"
    
    Examples: 
      | applicationname |
      | TFS             | 
