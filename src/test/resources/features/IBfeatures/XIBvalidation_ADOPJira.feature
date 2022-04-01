@IBvalidation
Feature: XIBvalidation_ADOPJira


Scenario Outline: ADOPJIRA
    Given i load the "ADOP Jira" project properties file
    And i generate a token for "DevTest" environment
    And i verify the "Inbound" "Task" details for "ADOP JIRA"
    And i verify the "Inbound" "Epic" details for "ADOP JIRA"
    And i verify the "Inbound" "Story" details for "ADOP JIRA"
    And i verify the "Inbound" "Risk" details for "ADOP JIRA"
    And i verify the "Inbound" "Impediment" details for "ADOP JIRA"
    And i verify the "Inbound" "Issue" details for "ADOP JIRA"
    And i verify the "Inbound" "Bug" details for "ADOP JIRA"
    And i verify the "Inbound" "Feature" details for "ADOP JIRA"
    And i verify the "Inbound" "Test" details for "ADOP JIRA"
    And i verify the "Inbound" "Test Execution" details for "ADOP JIRA"
    
    Given i load the "ADOP Jira" project properties file
    Given i login to application "<applicationname>"
    And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
    And i click on tile "my Queries"
    Then i select client and DC for "<applicationname>"
    And i capture the "IterationExternalID" for Entities created from "tool" for tool "ADOP Jira"
    And i generate a token for "DevTest" environment
    And i verify if "Release" has "flown" which was "NA" for "ADOP Jira" for "Normal" functionality
    And i verify if "Sprint" has "flown" which was "NA" for "ADOP Jira" for "Normal" functionality


    Examples:
      | applicationname | toolname  |
      | MyWizard        | ADOP JIRA |


