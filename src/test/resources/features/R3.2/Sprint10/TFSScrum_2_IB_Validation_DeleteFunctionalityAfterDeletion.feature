@3IBValidation_TFSScrum_DeleteFunctionality_checkFlowAfterDeleteion
Feature: TFSScrum_IB_Validation_DeleteFunctionality(after delete check IB)


Scenario: TFSScrum_Task_flow_afterDelete 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 


Scenario: TFSScrum_Epic_flow_afterDelete 

	And i verify if "Epic" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario: TFSScrum_Feature_flow_afterDelete 

	And i verify if "Feature" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 
	

Scenario: TFSScrum_ProductBacklog_flow_afterDelete 
	And i verify if "Story" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 


Scenario: TFSScrum_Risk_flow_afterDelete 
	And i verify if "Risk" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 
	 

Scenario: TFSScrum_Impediment_flow_afterDelete 
	And i verify if "Impediment" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 	

Scenario: TFSScrum_TestCase_flow_afterDelete 
	And i verify if "TestCase" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 
	 

Scenario: TFSScrum_Issue_flow_afterDelete 
And i verify if "Issue" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 
	 

Scenario: TFSScrum_Bug_flow_afterDelete
And i verify if "Bug" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario: TFSScrum_Action_flow_afterDelete
And i verify if "Action" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 


Scenario: TFSScrum_Decision_flow_afterDelete
And i verify if "Decision" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario: TFSScrum_Deliverable_flow_afterDelete
And i verify if "Deliverable" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario: TFSScrum_Milestone_flow_afterDelete
And i verify if "Milestone" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario: TFSScrum_Requirement_flow_afterDelete
And i verify if "Requirement" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario: TFSScrum_WorkRequest_flow_afterDelete 
And i verify if "Work Request" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality 

Scenario: TFSScrum_DeleteFunctionality_IBVerification_Release_Sprint
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the IterationExternalID for Iteration created from "tool" for tool "TFS Scrum" 
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality
	And i verify if "Sprint" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality

	 
	 

