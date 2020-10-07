@Browser
Feature: AD Data Loader

  Scenario Outline: 
    Given i login to application "<applicationname>"
    Then i select client and DC for "<applicationname>"
    And i click on tile "Lifecycle Template Configuration"
    And i add a new template for DLM with data "<DLMTemplate1>"

    Examples: 
      | applicationname | DLMTemplate1    |
      | DevTest         | DLM_Template_01 |
