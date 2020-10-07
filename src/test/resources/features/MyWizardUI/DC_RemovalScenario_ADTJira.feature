@PreRequisites_ADTJIRA
Feature: Pre-Requsites for ADTJIRA
Scenario Outline: 
	Given i login to application "<applicationname>" 
	#	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Configuration" 
	Then i select client and DC for "<applicationname>" 
	And i select the "ADT JIRA" in Manage Product Configuration page 
	And i navigate to "Delivery Construct Association" section 
	And i remove Delivery construct association details in the page for "<toolname>"
	And i hit the save button in Product Config page 
#	should i create a task here and then check the next step and new workitem?
	And i verify the "Inbound" "Task" details for "ADT JIRA" after removing DC
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |ADT JIRA|

