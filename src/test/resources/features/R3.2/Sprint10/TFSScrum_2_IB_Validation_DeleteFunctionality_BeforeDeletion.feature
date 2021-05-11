@3IBValidation_TFSScrum_DeleteFunctionality_checkFlowBeforeDeleteion
Feature: TFSScrum_IB_Validation_DeleteFunctionality(before delete check IB)


Scenario: TFSScrum_Task_flow_beforeDelete 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 


Scenario: TFSScrum_Epic_flow_beforeDelete 

	And i verify if "Epic" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario: TFSScrum_Feature_flow_beforeDelete 

	And i verify if "Feature" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 
	
Scenario: TFSScrum_Impediment_flow_beforeDelete 

	And i verify if "Impediment" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 
	
Scenario: TFSScrum_ProductBacklog_flow_beforeDelete 
	And i verify if "Story" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 


Scenario: TFSScrum_Risk_flow_beforeDelete 
	And i verify if "Risk" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 


Scenario: TFSScrum_Issue_flow_beforeDelete 
And i verify if "Issue" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 
	 

Scenario: TFSScrum_Bug_flow_beforeDelete
And i verify if "Bug" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario: TFSScrum_Action_flow_beforeDelete
And i verify if "Action" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 


Scenario: TFSScrum_Decision_flow_beforeDelete
And i verify if "Decision" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario: TFSScrum_Deliverable_flow_beforeDelete
And i verify if "Deliverable" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario: TFSScrum_Milestone_flow_beforeDelete
And i verify if "Milestone" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario: TFSScrum_Requirement_flow_beforeDelete
And i verify if "Requirement" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario: TFSScrum_WorkRequest_flow_beforeDelete 
And i verify if "Work Request" has "flown" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario Outline: TFSScrum_Deletefunctionality_IBVerification_Release_Sprint
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the IterationExternalID for Iteration created from "tool" for tool "TFS Scrum" 
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "flown" which was "NA" for "TFS Scrum" for "normal" functionality
	And i verify if "Sprint" has "flown" which was "NA" for "TFS Scrum" for "normal" functionality
	
	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Scrum|	
