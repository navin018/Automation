@ADDataLoader
Feature: AD Data Loader
#use adop jira in tool properties
@ADDataloaderUpload
  Scenario Outline: 
  	Given i load the project properties file
    Given i login to application "<applicationname>"
    And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
    Then i select client "MyWizard_Client" with DC_L1 as "DCL1_ADDL" and DC_L2 as "DCL2_ADDL"
    And i click on tile "Data Upload"
#    And i prepare the excel data for tool "ADOP Jira" in "ADDataLoader" DataLoader
	And i upload file for "AD" DataLoader

	   Examples: 
      | applicationname |
      | MyWizard        |
  
 @ADDataLoaderAPIVerification 
Scenario: AD_Dataloader_IBVerification
Given i load the project properties file
And i generate a token for "DevTest" environment
And i verify the "inbound" details for "Release" for tool "ADOP jira" using "flat" query whose client is "ClientUId" and DC is "DCForADDataLoader" for "AD_DataLoader" functionality
And i verify the "inbound" details for "Sprint" for tool "ADOP jira" using "flat" query whose client is "ClientUId" and DC is "DCForADDataLoader" for "AD_DataLoader" functionality
And i verify the "inbound" details for "Bug" for tool "ADOP jira" using "flat" query whose client is "ClientUId" and DC is "DCForADDataLoader" for "AD_DataLoader" functionality
And i verify the "inbound" details for "Test" for tool "ADOP jira" using "flat" query whose client is "ClientUId" and DC is "DCForADDataLoader" for "AD_DataLoader" functionality
And i verify the "inbound" details for "TestResult" for tool "ADOP jira" using "flat" query whose client is "ClientUId" and DC is "DCForADDataLoader" for "AD_DataLoader" functionality
And i verify the "inbound" details for "Requirement" for tool "ADOP jira" using "NonFlat" query whose client is "ClientUId" and DC is "DCForADDataLoader" for "AD_DataLoader" functionality

