@2IBValidation_AIDT
Feature: AIDT_IB_Validation


Scenario: AIDT_Task 
	Given i load the project properties file
	And i generate a token for "DevTest" environment 
	And i verify the "Inbound" "Task" details for "AIDT" 
	

Scenario: AIDT_Epic 
	And i verify the "Inbound" "Epic" details for "AIDT" 
	

Scenario: AIDT_Story 
	And i verify the "Inbound" "Story" details for "AIDT" 


Scenario: AIDT_Issue 
	And i verify the "Inbound" "Issue" details for "AIDT" 
	

#Scenario: AIDT_Bug
#	And i verify the "Inbound" "Bug" details for "AIDT" 
	

Scenario: AIDT_Feature 
	And i verify the "Inbound" "Feature" details for "AIDT" 
	


Scenario: AIDT_Risk
	 	And i verify the "Inbound" "Risk" details for "AIDT" 			


Scenario: AIDT_Deliverable
	 	And i verify the "Inbound" "Deliverable" details for "AIDT"
	
	
Scenario: TFSAgile_Action
		And i verify the "Inbound" "Action" details for "AIDT"
	

Scenario: AIDT_Decision
	And i verify the "Inbound" "Decision" details for "AIDT"
	
#		
#Scenario Outline: TFSAgile_DIY_IBVerification_Release_Sprint 
#	Given i login to application "<applicationname>" 
#	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
#	And i click on tile "my Queries"
#	Then i select client and DC for "<applicationname>"
#	And i capture the "IterationExternalID" for Entities created from "tool" for tool "AIDT" 
#	And i generate a token for "DevTest" environment 	
#	And i verify if "Release" has "flown" which was "NA" for "AIDT" for "Normal" functionality
#	And i verify if "Sprint" has "flown" which was "NA" for "AIDT" for "Normal" functionality
#
#		Examples: 
#		| applicationname |toolname|
#		| MyWizard        |AIDT|
		
