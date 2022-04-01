@IBvalidation
Feature: XIBvalidation_GenericUploader


  Scenario: NoTool_GenericUploader_NoTool
    Given i load the "ADT" project properties file
#    And i generate a token for "DevTest" environment
    And i verify if "Task" has "flown" which was "NA" for "NoToolInstance" for "GenericUploader_NoTool" functionality
    And i verify if "Epic" has "flown" which was "NA" for "NoToolInstance" for "GenericUploader_NoTool" functionality
    And i verify if "Risk" has "flown" which was "NA" for "NoToolInstance" for "GenericUploader_NoTool" functionality
    And i verify if "Impediment" has "flown" which was "NA" for "NoToolInstance" for "GenericUploader_NoTool" functionality
    And i verify if "Issue" has "flown" which was "NA" for "NoToolInstance" for "GenericUploader_NoTool" functionality
    And i verify if "Bug" has "flown" which was "NA" for "NoToolInstance" for "GenericUploader_NoTool" functionality
    And i verify if "Feature" has "flown" which was "NA" for "NoToolInstance" for "GenericUploader_NoTool" functionality
    And i verify if "Action" has "flown" which was "NA" for "NoToolInstance" for "GenericUploader_NoTool" functionality
    And i verify if "Decision" has "flown" which was "NA" for "NoToolInstance" for "GenericUploader_NoTool" functionality

    And i generate a token for "DevTest" environment
    And i set the IterationExternalID details into the baseclass for tool "NoToolInstance"
    And i verify if "Release" has "flown" which was "NA" for "NoToolInstance" for "GenericUploader_NoTool" functionality
    And i verify if "Sprint" has "flown" which was "NA" for "NoToolInstance" for "GenericUploader_NoTool" functionality




