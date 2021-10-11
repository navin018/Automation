@DevopsDataloader
Feature: AD Data Loader
#use TFS scrum in tool property
  Scenario Outline: 
  Given i load the project properties file
    Given i login to application "<applicationname>"
    And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
    Then i select client "Devops_Client" with DC_L1 as "Devops_DC_L1" and DC_L2 as "Devops_DC_L2"
    And i click on tile "Data Upload"
    And i prepare the excel data for tool "ADOP Jira" in "DevopsDataLoader" DataLoader
	And i upload file for "Devops" DataLoader
    
    Examples: 
      | applicationname |
      | MyWizard        |
      
      
Scenario: 
And i verify the "inbound" details for "CodeCommit" for tool "TFS Scrum" using "flat" query whose client is "DevopsDataLoaderClientUId" and DC is "DevopsDataLoaderDCUId" for "DevOps_DataLoader" functionality
And i verify the "inbound" details for "CodeBranch" for tool "TFS Scrum" using "flat" query whose client is "DevopsDataLoaderClientUId" and DC is "DevopsDataLoaderDCUId" for "DevOps_DataLoader" functionality
And i verify the "inbound" details for "Build" for tool "TFS Scrum" using "flat" query whose client is "DevopsDataLoaderClientUId" and DC is "DevopsDataLoaderDCUId" for "DevOps_DataLoader" functionality
And i verify the "inbound" details for "Deployment" for tool "TFS Scrum" using "flat" query whose client is "DevopsDataLoaderClientUId" and DC is "DevopsDataLoaderDCUId" for "DevOps_DataLoader" functionality
And i verify the "inbound" details for "Environment" for tool "TFS Scrum" using "flat" query whose client is "DevopsDataLoaderClientUId" and DC is "DevopsDataLoaderDCUId" for "DevOps_DataLoader" functionality