@IBvalidation
Feature: XIBvalidation_TFSScrum


  Scenario Outline: TFSScrum
    Given i load the "TFS Scrum" project properties file
#    And i generate a token for "DevTest" environment
    And i verify the "Inbound" "Task" details for "TFS Scrum"
    And i verify the "Inbound" "Epic" details for "TFS Scrum"
    And i verify the "Inbound" "Story" details for "TFS Scrum"
    And i verify the "Inbound" "Issue" details for "TFS Scrum"
    And i verify the "Inbound" "Bug" details for "TFS Scrum"
    And i verify the "Inbound" "Feature" details for "TFS Scrum"
    And i verify the "Inbound" "TestCase" details for "TFS Scrum"
    And i verify the "Inbound" "Risk" details for "TFS Scrum"
    And i verify the "Inbound" "Deliverable" details for "TFS Scrum"
    And i verify the "Inbound" "Action" details for "TFS Scrum"
    And i verify the "Inbound" "Impediment" details for "TFS Scrum"
    And i verify the "Inbound" "Decision" details for "TFS Scrum"
    And i verify the "Inbound" "Requirement" details for "TFS Scrum"
    And i verify the "Inbound" "Milestone" details for "TFS Scrum"
    And i verify the "Inbound" "Work Request" details for "TFS Scrum"
    
    Given i login to application "<applicationname>"
    And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
    And i click on tile "my Queries"
    Then i select client and DC for "<applicationname>"
    And i capture the "IterationExternalID" for Entities created from "tool" for tool "TFS Scrum"
    And i generate a token for "DevTest" environment
    And i verify if "Release" has "flown" which was "NA" for "TFS Scrum" for "Normal" functionality
    And i verify if "Sprint" has "flown" which was "NA" for "Scrum" for "Normal" functionality

    Examples:
      | applicationname |toolname|
      | MyWizard        |TFS Scrum|