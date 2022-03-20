@IBvalidation1
Feature: XIBvalidation_TFSScrum


  Scenario: TFSScrum_Task
    Given i load the "TFS Scrum" project properties file
#    And i generate a token for "DevTest" environment
    And i verify the "Inbound" "Task" details for "TFS Scrum"


  Scenario: TFSScrum_Epic

    And i verify the "Inbound" "Epic" details for "TFS Scrum"


  Scenario: TFSScrum_ProductBacklog

    And i verify the "Inbound" "Story" details for "TFS Scrum"


  Scenario: TFSScrum_Issue

    And i verify the "Inbound" "Issue" details for "TFS Scrum"


  Scenario: TFSScrum_Bug

    And i verify the "Inbound" "Bug" details for "TFS Scrum"


  Scenario: TFSScrum_Feature

    And i verify the "Inbound" "Feature" details for "TFS Scrum"





  Scenario: TFSScrum_TestCase

    And i verify the "Inbound" "TestCase" details for "TFS Scrum"

  Scenario: TFSScrum_Risk

    And i verify the "Inbound" "Risk" details for "TFS Scrum"


  Scenario: TFSScrum_Deliverable

    And i verify the "Inbound" "Deliverable" details for "TFS Scrum"


  Scenario: TFSScrum_Action

    And i verify the "Inbound" "Action" details for "TFS Scrum"

  Scenario: TFSScrum_Impediment

    And i verify the "Inbound" "Impediment" details for "TFS Scrum"

  Scenario: TFSScrum_Decision
    And i verify the "Inbound" "Decision" details for "TFS Scrum"

  Scenario: TFSScrum_Requirement
    And i verify the "Inbound" "Requirement" details for "TFS Scrum"

  Scenario: TFSScrum_Milestone
    And i verify the "Inbound" "Milestone" details for "TFS Scrum"

  Scenario: TFSAgile_WorkRequest

    And i verify the "Inbound" "Work Request" details for "TFS Scrum"


  Scenario Outline: TFSScrum_DIY_IBVerification_Release_Sprint
    Given i login to application "<applicationname>"
    And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
    And i click on tile "my Queries"
    Then i select client and DC for "<applicationname>"
    And i capture the "IterationExternalID" for Entities created from "tool" for tool "TFS Scrum"
    And i generate a token for "DevTest" environment
    And i verify if "Release" has "flown" which was "NA" for "TFS Agile" for "Normal" functionality
    And i verify if "Sprint" has "flown" which was "NA" for "TFS Agile" for "Normal" functionality

    Examples:
      | applicationname |toolname|
      | MyWizard        |TFS Scrum|