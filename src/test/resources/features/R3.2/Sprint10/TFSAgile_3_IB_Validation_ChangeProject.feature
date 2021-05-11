@5IBValidation_TFSAgile_ChangeProjectOfWorkitem
Feature: TFSAgile_IB_Validation_ChangeProjectOfWorkitem


Scenario: TFSAgile_TaskFlow_ProjectChange 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "deleted" which was "NA" for "TFS Agile" for "ChangeProjectFromOne" functionality 
	And i verify if "Task" has "flown" which was "NA" for "TFS Agile" for "ChangeProjectToAnother" functionality 

Scenario: TFSAgile_TestCaseFlow_ProjectChange 
	And i verify if "TestCase" has "deleted" which was "NA" for "TFS Agile" for "ChangeProjectFromOne" functionality 
	And i verify if "TestCase" has "flown" which was "NA" for "TFS Agile" for "ChangeProjectToAnother" functionality 

Scenario: TFSAgile_BugFlow_ProjectChange 
	And i verify if "Bug" has "deleted" which was "NA" for "TFS Agile" for "ChangeProjectFromOne" functionality 
	And i verify if "Bug" has "flown" which was "NA" for "TFS Agile" for "ChangeProjectToAnother" functionality 
	
Scenario: TFSAgile_RiskFlow_ProjectChange 
	And i verify if "Risk" has "deleted" which was "NA" for "TFS Agile" for "ChangeProjectFromOne" functionality 
	And i verify if "Risk" has "flown" which was "NA" for "TFS Agile" for "ChangeProjectToAnother" functionality 
	
Scenario: TFSAgile_IssueFlow_ProjectChange 
	And i verify if "Issue" has "deleted" which was "NA" for "TFS Agile" for "ChangeProjectFromOne" functionality 
	And i verify if "Issue" has "flown" which was "NA" for "TFS Agile" for "ChangeProjectToAnother" functionality 
	
Scenario: TFSAgile_FeatureFlow_ProjectChange 
	And i verify if "Feature" has "deleted" which was "NA" for "TFS Agile" for "ChangeProjectFromOne" functionality 
	And i verify if "Feature" has "flown" which was "NA" for "TFS Agile" for "ChangeProjectToAnother" functionality 

Scenario: TFSAgile_DeliverableFlow_ProjectChange 
	And i verify if "Deliverable" has "deleted" which was "NA" for "TFS Agile" for "ChangeProjectFromOne" functionality 
	And i verify if "Deliverable" has "flown" which was "NA" for "TFS Agile" for "ChangeProjectToAnother" functionality 

Scenario: TFSAgile_ActionFlow_ProjectChange 
	And i verify if "Action" has "deleted" which was "NA" for "TFS Agile" for "ChangeProjectFromOne" functionality 
	And i verify if "Action" has "flown" which was "NA" for "TFS Agile" for "ChangeProjectToAnother" functionality 

Scenario: TFSAgile_DeliverableFlow_ProjectChange 
	And i verify if "Deliverable" has "deleted" which was "NA" for "TFS Agile" for "ChangeProjectFromOne" functionality 
	And i verify if "Deliverable" has "flown" which was "NA" for "TFS Agile" for "ChangeProjectToAnother" functionality 

Scenario: TFSAgile_RequirementFlow_ProjectChange 
	And i verify if "Requirement" has "deleted" which was "NA" for "TFS Agile" for "ChangeProjectFromOne" functionality 
	And i verify if "Requirement" has "flown" which was "NA" for "TFS Agile" for "ChangeProjectToAnother" functionality 

Scenario: TFSAgile_DecisionFlow_ProjectChange 
	And i verify if "Decision" has "deleted" which was "NA" for "TFS Agile" for "ChangeProjectFromOne" functionality 
	And i verify if "Decision" has "flown" which was "NA" for "TFS Agile" for "ChangeProjectToAnother" functionality 

Scenario: TFSAgile_MilestoneFlow_ProjectChange 
	And i verify if "Milestone" has "deleted" which was "NA" for "TFS Agile" for "ChangeProjectFromOne" functionality 
	And i verify if "Milestone" has "flown" which was "NA" for "TFS Agile" for "ChangeProjectToAnother" functionality 

Scenario: TFSAgile_ChangeRequestFlow_ProjectChange 
	And i verify if "Work Request" has "deleted" which was "NA" for "TFS Agile" for "ChangeProjectFromOne" functionality 
	And i verify if "Work Request" has "flown" which was "NA" for "TFS Agile" for "ChangeProjectToAnother" functionality 
		