@3GenericUploader_ADTJira_IBVerfification
Feature: GenericUploader_ADTJira_IBVerification 


Scenario: ADTJIRA_Task_flow_GenericUploader 
#Given i load the project properties file 
#	And i generate a token for "DevTest" environment
	And i verify if "Task" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader" functionality 

@relspt
Scenario: ADTJIRA_Epic_flow_GenericUploader 

	And i verify if "Epic" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader" functionality 


Scenario: ADTJIRA_Risk_flow_GenericUploader 
	And i verify if "Risk" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader" functionality 
	 
	

Scenario: ADTJIRA_Impediment_flow_GenericUploader 
	And i verify if "Impediment" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader" functionality 
	 

Scenario: ADTJIRA_Issue_flow_GenericUploader 
And i verify if "Issue" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader" functionality 
	 
	

Scenario: ADTJIRA_Bug_flow_GenericUploader
And i verify if "Bug" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader" functionality 
	

Scenario: ADTJIRA_Feature_flow_GenericUploader 
And i verify if "Feature" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader" functionality 
	 
	
Scenario: ADTJIRA_Action_flow_GenericUploader
And i verify if "Action" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader" functionality

Scenario: ADTJIRA_Decision_flow_GenericUploader
And i verify if "Decision" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader" functionality


@verifyreleasegenericuploader
Scenario Outline: ADTJIRA_GenericUploader_IBVerification_Release_Sprint 
#	Given i login to application "<applicationname>" 
#	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
#	And i click on tile "my Queries"
#	Then i select client and DC for "<applicationname>"
	And i capture the IterationExternalID for Iteration created from "tool" for tool "ADT Jira" 
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "flown" which was "NA" for "ADT Jira" for "GenericUploader" functionality
	And i verify if "Sprint" has "flown" which was "NA" for "ADT Jira" for "GenericUploader" functionality
	
		Examples: 
		| applicationname |
		| MyWizard        |
		

Scenario Outline: ADTJIRA_MyWizardInstance_GenericUploader_IBVerification_Release_Sprint 
	And i generate a token for "DevTest" environment 	
	And i set the IterationExternalID details into the baseclass for tool "ADT Jira"
	And i verify if "Release" has "flown" which was "NA" for "ADT Jira" for "GenericUploader_MyWizardInstance" functionality
	And i verify if "Sprint" has "flown" which was "NA" for "ADT Jira" for "GenericUploader_MyWizardInstance" functionality
	
		Examples: 
		| applicationname |
		| MyWizard        |		
		

 			
