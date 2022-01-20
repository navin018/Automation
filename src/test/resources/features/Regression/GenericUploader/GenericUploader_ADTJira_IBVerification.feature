@3GenericUploader_ADTJira_IBVerfification
Feature: GenericUploader_ADTJira_IBVerification 


Scenario: ADTJIRA_Task_flow_GenericUploader 
	Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "flown" which was "NA" for "ADTInstance" for "GenericUploader" functionality 


Scenario: ADTJIRA_Epic_flow_GenericUploader 

	And i verify if "Epic" has "flown" which was "NA" for "ADTInstance" for "GenericUploader" functionality 


Scenario: ADTJIRA_Risk_flow_GenericUploader 
	And i verify if "Risk" has "flown" which was "NA" for "ADTInstance" for "GenericUploader" functionality 
	 
	

Scenario: ADTJIRA_Impediment_flow_GenericUploader 
	And i verify if "Impediment" has "flown" which was "NA" for "ADTInstance" for "GenericUploader" functionality 
	 

Scenario: ADTJIRA_Issue_flow_GenericUploader 
And i verify if "Issue" has "flown" which was "NA" for "ADTInstance" for "GenericUploader" functionality 
	 
	

Scenario: ADTJIRA_Bug_flow_GenericUploader
And i verify if "Bug" has "flown" which was "NA" for "ADTInstance" for "GenericUploader" functionality 
	

Scenario: ADTJIRA_Feature_flow_GenericUploader 
And i verify if "Feature" has "flown" which was "NA" for "ADTInstance" for "GenericUploader" functionality 
	 
	
Scenario: ADTJIRA_Action_flow_GenericUploader

And i verify if "Action" has "flown" which was "NA" for "ADTInstance" for "GenericUploader" functionality

@finaloff
Scenario Outline: ADTJIRA_GenericUploader_IBVerification_Release_Sprint 

	And i generate a token for "DevTest" environment 
	And i set the IterationExternalID details into the baseclass for tool "ADTInstance"	
	And i verify if "Release" has "flown" which was "NA" for "ADTInstance" for "GenericUploader" functionality
	And i verify if "Sprint" has "flown" which was "NA" for "ADTInstance" for "GenericUploader" functionality
	
		Examples: 
		| applicationname |
		| MyWizard        |
		

