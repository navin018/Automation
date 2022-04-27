@IBvalidation
Feature: XIBvalidation_ADT


Scenario Outline: ADTJIRA
    Given i load the "ADT Jira" project properties file
#    And i put a explicit wait of "300000"
    And i generate a token for "DevTest" environment
    And i verify the "Inbound" "Task" details for "ADT JIRA"
    And i verify the "Inbound" "Epic" details for "ADT JIRA"
    And i verify the "Inbound" "Story" details for "ADT JIRA"
    And i verify the "Inbound" "Risk" details for "ADT JIRA"
    And i verify the "Inbound" "Impediment" details for "ADT JIRA"
    And i verify the "Inbound" "Issue" details for "ADT JIRA"
    And i verify the "Inbound" "Bug" details for "ADT JIRA"
    And i verify the "Inbound" "Feature" details for "ADT JIRA"
    And i verify the "Inbound" "Deliverable" details for "ADT JIRA"
	And i verify the "Inbound" "Decision" details for "ADT JIRA"
    And i verify the "Inbound" "Test" details for "ADT JIRA"
    And i verify the "Inbound" "Requirement" details for "ADT JIRA"
    And i verify the "Inbound" "Milestone" details for "ADT JIRA"
    And i verify the "Inbound" "Action" details for "ADT JIRA"
    And i verify the "Inbound" "Work Request" details for "ADT JIRA"
    And i verify the "Inbound" "Test Execution" details for "ADT JIRA"
    
    Given i login to application "<applicationname>"
    And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
    And i click on tile "my Queries"
    Then i select client and DC for "<applicationname>"
    And i capture the "IterationExternalID" for Entities created from "tool" for tool "ADT Jira"
    And i generate a token for "DevTest" environment
    And i verify if "Release" has "flown" which was "NA" for "ADT Jira" for "Normal" functionality
    And i verify if "Sprint" has "flown" which was "NA" for "ADT Jira" for "Normal" functionality

    Examples:
      | applicationname | toolname |
      | MyWizard        | ADT JIRA |

