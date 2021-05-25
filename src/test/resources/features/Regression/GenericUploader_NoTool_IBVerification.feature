@3GenericUploader_NoTool_IBVerfification
Feature: GenericUploader_NoTool_IBVerification 


Scenario: NoTool_Task_flow_GenericUploader_NoTool 
#Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader_NoTool" functionality 


Scenario: NoTool_Epic_flow_GenericUploader 

	And i verify if "Epic" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader_NoTool" functionality 


Scenario: NoTool_Risk_flow_GenericUploader 
	And i verify if "Risk" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader_NoTool" functionality 
	 
	

Scenario: NoTool_Impediment_flow_GenericUploader 
	And i verify if "Impediment" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader_NoTool" functionality 
	 

Scenario: NoTool_Issue_flow_GenericUploader 
And i verify if "Issue" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader_NoTool" functionality 
	 
	

Scenario: NoTool_Bug_flow_GenericUploader
And i verify if "Bug" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader_NoTool" functionality 
	

Scenario: NoTool_Feature_flow_GenericUploader 
And i verify if "Feature" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader_NoTool" functionality 
	 
	
Scenario: NoTool_Action_flow_GenericUploader
And i verify if "Action" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader_NoTool" functionality

		
Scenario: NoTool_Decision_flow_GenericUploader
And i verify if "Decision" has "flown" which was "NA" for "ADT JIRA" for "GenericUploader_NoTool" functionality

Scenario Outline: NoTool_GenericUploader_IBVerification_Release_Sprint 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the IterationExternalID for Iteration created from "tool" for tool "ADT Jira" 
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "flown" which was "NA" for "ADT Jira" for "GenericUploader_NoTool" functionality
	And i verify if "Sprint" has "flown" which was "NA" for "ADT Jira" for "GenericUploader_NoTool" functionality
	
		Examples: 
		| applicationname |
		| MyWizard        |


 			
