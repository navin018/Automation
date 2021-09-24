@AD
Feature: AD Data Loader

  Scenario Outline: 
#    Given i login to application "<applicationname>"
#    Then i select client and DC "<applicationname>"
#    And i prepare the excel data for "AD" DataLoader
#    And i click on tile "Data Upload"
#    And i upload file for "AD" DataLoader
#    And i prepare the excel data for tool "ADOP Jira" in "ADDataLoader" DataLoader
    And i prepare the excel data for tool "ADOP Jira" in "DevopsDataLoader" DataLoader
    
	And i verify the "inbound" details for "Test_01" for tool "ADOP jira" using "flat" query whose client is "ClientUId" and DC is "DCForADDataLoader" for "AD_DataLoader" functionality

    Examples: 
      | applicationname |
      | MyWizard        |
