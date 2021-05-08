@3IBValidation_TFSAgile_DeleteFunctionality_checkFlowAfterDeleteion
Feature: TFSAgile_IB_Validation_DeleteFunctionality(after delete check IB)


Scenario: TFSAgile_Task_flow_afterDelete 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 


Scenario: TFSAgile_Epic_flow_afterDelete 

	And i verify if "Epic" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 

Scenario: TFSAgile_Feature_flow_afterDelete 

	And i verify if "Feature" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 
	

Scenario: TFSAgile_Story_flow_afterDelete 
	And i verify if "Story" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 


Scenario: TFSAgile_Risk_flow_afterDelete 
	And i verify if "Risk" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 
	 
	

Scenario: TFSAgile_TestCase_flow_afterDelete 
	And i verify if "TestCase" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 
	 

Scenario: TFSAgile_Issue_flow_afterDelete 
And i verify if "Issue" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 
	 

Scenario: TFSAgile_Bug_flow_afterDelete
And i verify if "Bug" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 

Scenario: TFSAgile_Action_flow_afterDelete
And i verify if "Action" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 


Scenario: TFSAgile_Decision_flow_afterDelete
And i verify if "Decision" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 

Scenario: TFSAgile_Deliverable_flow_afterDelete
And i verify if "Deliverable" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 

Scenario: TFSAgile_Milestone_flow_afterDelete
And i verify if "Milestone" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 

Scenario: TFSAgile_Requirement_flow_afterDelete
And i verify if "Requirement" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 

Scenario: TFSAgile_WorkRequest_flow_afterDelete 
And i verify if "Work Request" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality 

Scenario Outline: TFSAgile_DeleteFunctionality_IBVerification_Release_Sprint
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the IterationExternalID for deleted Iteration created from "tool" for tool "TFS Agile"
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality
	And i verify if "Sprint" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality

	Examples: 
		| applicationname |toolname|
		| MyWizard        |TFS Agile|	 
	 

