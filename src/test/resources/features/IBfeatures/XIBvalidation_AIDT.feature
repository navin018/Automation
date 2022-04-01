@IBvalidation
Feature: XIBvalidation_AIDT


  Scenario Outline: AIDT
    Given i load the "AIDT" project properties file
    And i generate a token for "DevTest" environment
    And i verify the "Inbound" "Task" details for "AIDT"
    And i verify the "Inbound" "Epic" details for "AIDT"
    And i verify the "Inbound" "Story" details for "AIDT"
    And i verify the "Inbound" "Issue" details for "AIDT"
    And i verify the "Inbound" "Bug" details for "AIDT"
    And i verify the "Inbound" "Impediment" details for "AIDT"
    And i verify the "Inbound" "Feature" details for "AIDT"
    And i verify the "Inbound" "Risk" details for "AIDT"
    And i verify the "Inbound" "Deliverable" details for "AIDT"
    And i verify the "Inbound" "Action" details for "AIDT"
    And i verify the "Inbound" "Decision" details for "AIDT"
    And i verify the "Inbound" "Requirement" details for "AIDT"
    And i verify the "Inbound" "Milestone" details for "AIDT"
    
    Given i login to application "<applicationname>"
    And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
    And i click on tile "my Queries"
    Then i select client and DC for "<applicationname>"
    And i capture the "IterationExternalID" for Entities created from "tool" for tool "AIDT"
    And i generate a token for "DevTest" environment
    And i verify if "Release" has "flown" which was "NA" for "AIDT" for "Normal" functionality
    And i verify if "Sprint" has "flown" which was "NA" for "AIDT" for "Normal" functionality

    Examples:
      | applicationname | toolname |
      | MyWizard        | AIDT     |

