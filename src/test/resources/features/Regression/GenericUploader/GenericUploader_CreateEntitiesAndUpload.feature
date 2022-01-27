Feature: GenericUploader Regression(ADT)

@2GenericUploader_ADTJira
Scenario Outline: GenericUploader_ADTJira
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i prepare the excel data for tool "ADT Jira" in "Generic Uploader" DataLoader
	And i click on tile "Generic Uploader"
	Then i select client and DC for "<applicationname>"
	And i select the Product Instance as "ADT JIRA"
	And i select the Data Entity as "Epic" for "ADT Jira" and upload the excel file
	And i select the Data Entity as "Feature" for "ADT Jira" and upload the excel file
	And i select the Data Entity as "Task" for "ADT Jira" and upload the excel file
	And i select the Data Entity as "Bug" for "ADT Jira" and upload the excel file
	And i select the Data Entity as "Issue" for "ADT Jira" and upload the excel file
	And i select the Data Entity as "Impediment" for "ADT Jira" and upload the excel file
	And i select the Data Entity as "Risk" for "ADT Jira" and upload the excel file
	And i select the Data Entity as "Action" for "ADT Jira" and upload the excel file 
	And i select the Data Entity as "Iteration" for "ADT Jira" and upload the excel file 	
	
	Examples: 
		| applicationname | bug    | Epic    | Feature    | Issue    | Task    | TestCase    | Story    | Release    | Sprint    |Decision   |Action   |Deliverable   |Impediment|Risk|ProductBacklog|Milestone|Requirement|
		| MyWizard             | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01 | TestCase_01 | Story_WSJF | Release_01 | Sprint_01 |Decision_01|Action_01|Deliverable_01|Impediment_01|Risk_01|ProductBacklog_wsjf|Milestone_01|Requirement_01|
		
		
@4GenericUploader_MyWizardInstance
Scenario Outline: GenericUploader_ADTJira
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>" 
	And i prepare the excel data for tool "MyWizardInstance" in "Generic Uploader" DataLoader 
	And i click on tile "Generic Uploader"
	And i select the Product Instance as "myWizardInstance" 	
	And i select the Data Entity as "IterationForMyWizardInstance" for "ADT Jira" and upload the excel file
	Examples: 
		| applicationname | 
		| MyWizard             |
				
@6GenericUploader_NoToolInstance
Scenario Outline: GenericUploader_NoTool
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i prepare the excel data for tool "NoToolInstance" in "Generic Uploader" DataLoader
	And i click on tile "Generic Uploader"
	Then i select client and DC for No Tool Instance 
	And i select the Data Entity as "Epic" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Feature" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Task" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Bug" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Issue" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Impediment" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Risk" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Action" for "noToolInstance" and upload the excel file 
	And i select the Data Entity as "Decision" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Iteration" for "noToolInstance" and upload the excel file

	
	Examples: 
		| applicationname | 
		| MyWizard        |

@7GenericUploader_NewRelease
Scenario Outline: GenericUploader_ADTJira_NewRelease
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>" 
	And i click on tile "Generic Uploader"
	And i select the Product Instance as "ADT JIRA" 	
	And i select the Data Entity as "Epic_InvalidTemplate" for "ADT Jira" and upload the excel file
	And i select the Data Entity as "Epic_BlankTemplate" for "ADT Jira" and upload the excel file
	And i select the Data Entity as "Epic_PartialSuccess" for "ADT Jira" and upload the excel file
	And i select the Data Entity as "Epic_WrongData" for "ADT Jira" and upload the excel file

	
	Examples: 
		| applicationname | Epic  |
		| MyWizard        |	Epic_01 |
		
		
@8GenericUploader_mywizardinstanceGDL
Scenario Outline: GenericUploader_mywizardinstanceGDL
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i prepare the excel data for tool "NoToolInstance" with Associations in "Generic Uploader" DataLoader
	And i click on tile "Generic Uploader"
	Then i select client and DC for No Tool Instance 
	And i select the Product Instance as "myWizardInstance"
	And i select the Data Entity as "Epic" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Feature" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Task" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Bug" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Issue" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Impediment" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Risk" for "noToolInstance" and upload the excel file
	And i select the Data Entity as "Action" for "noToolInstance" and upload the excel file 
	And i select the Data Entity as "UserStory" for "noToolInstance" and upload the excel file 

	
	Examples: 
		| applicationname | Bug    | Epic    | Feature    | Issue    | Task     |  UserStory   |  Action    |  Impediment  |  Risk  |
		| MyWizard        | Bug_01 | Epic_01 | Feature_01 | Issue_01 | Task_01  | Story_01     | Action_01  | Impediment_01| Risk_01|	
	
	
	
@9GenericUploader_CustomTemplate
Scenario Outline: GenericUploader_CustomTemplate
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	Then i select client and DC for "<applicationname>" 
	And i click on tile "Generic Uploader"
	And i select the Product Instance as "ADT JIRA" 
	And i "Edit" the Custom Template for "Epic" for "ADT Jira"
	And i select the Data Entity as "Epic_Automation_CustomTemplate" for "ADT Jira" and upload the excel file
#	And i "Upload" the Custom Template for "Epic_Automation_CustomTemplate" for "ADT Jira"
	And i "Edit" the Custom Template for "Action" for "ADT Jira"
	And i select the Data Entity as "Action_Automation_CustomTemplate" for "ADT Jira" and upload the excel file
#	And i "Upload" the Custom Template for "Action_Automation_CustomTemplate" for "ADT Jira"
	
	
	Examples: 
		| applicationname | Epic    |  Action    |
		| MyWizard        |	Epic_01 | Action_01  |
	
	
	
	
	
	
		