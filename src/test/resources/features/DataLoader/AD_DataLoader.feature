@Browser
Feature: AD Data Loader

  Scenario Outline: 
    Given i login to application "<applicationname>"
    Then i select client and DC "<applicationname>"
    And i prepare the excel data for "AD" DataLoader
    And i click on tile "Data Upload"
    And i upload file for "AD" DataLoader

    Examples: 
      | applicationname |
      | MyWizard        |
