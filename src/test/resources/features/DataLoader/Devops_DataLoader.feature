@Browser
Feature: AD Data Loader

  Scenario Outline: 
    Given i login to application "<applicationname>"
    Then i select client and DC "<applicationname>"
    And i prepare the excel data for "Devops" DataLoader
    And i click on tile "Data Upload"
    And i upload file for "Devops" DataLoader
    
    And i verify the "inbound" details for "CodeCommit" for tool "TFS Scrum" using "flat" query whose client is "DevopsDataLoaderClientUId" and DC is "DevopsDataLoaderDCUId" for "DevOps_DataLoader" functionality

    Examples: 
      | applicationname |
      | MyWizard        |
