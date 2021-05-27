@5GenericUploader_MyWIzardInstance_IBVerfification
Feature: GenericUploader_ADTJira_MyWizardInstance_IBVerification 


Scenario: ADTJIRA_MyWizard_Decision_flow_GenericUploader
And i verify if "Decision" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader" functionality

		

Scenario Outline: ADTJIRA_MyWizardInstance_GenericUploader_IBVerification_Release_Sprint 
	And i generate a token for "DevTest" environment 	
	And i set the IterationExternalID details into the baseclass for tool "ADT Jira"
	And i verify if "Release" has "flown" which was "NA" for "ADT Jira" for "GenericUploader_MyWizardInstance" functionality
	And i verify if "Sprint" has "flown" which was "NA" for "ADT Jira" for "GenericUploader_MyWizardInstance" functionality
	
		Examples: 
		| applicationname |
		| MyWizard        |		
		

 			
