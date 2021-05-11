@5IBValidation_TFSScrum_ChangeProjectOfWorkitem
Feature: TFSScrum_IB_Validation_ChangeProjectOfWorkitem


Scenario: TFSScrum_TaskFlow_ProjectChange 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "deleted" which was "NA" for "TFS Scrum" for "ChangeProjectFromOne" functionality 
	And i verify if "Task" has "flown" which was "NA" for "TFS Scrum" for "ChangeProjectToAnother" functionality 

Scenario: TFSScrum_BugFlow_ProjectChange 
	And i verify if "Bug" has "deleted" which was "NA" for "TFS Scrum" for "ChangeProjectFromOne" functionality 
	And i verify if "Bug" has "flown" which was "NA" for "TFS Scrum" for "ChangeProjectToAnother" functionality 
	
Scenario: TFSScrum_ImpedimentFlow_ProjectChange 
	And i verify if "Impediment" has "deleted" which was "NA" for "TFS Scrum" for "ChangeProjectFromOne" functionality 
	And i verify if "Impediment" has "flown" which was "NA" for "TFS Scrum" for "ChangeProjectToAnother" functionality 
	
		
Scenario: TFSScrum_RiskFlow_ProjectChange 
	And i verify if "Risk" has "deleted" which was "NA" for "TFS Scrum" for "ChangeProjectFromOne" functionality 
	And i verify if "Risk" has "flown" which was "NA" for "TFS Scrum" for "ChangeProjectToAnother" functionality 
	
Scenario: TFSScrum_IssueFlow_ProjectChange 
	And i verify if "Issue" has "deleted" which was "NA" for "TFS Scrum" for "ChangeProjectFromOne" functionality 
	And i verify if "Issue" has "flown" which was "NA" for "TFS Scrum" for "ChangeProjectToAnother" functionality 
	
Scenario: TFSScrum_FeatureFlow_ProjectChange 
	And i verify if "Feature" has "deleted" which was "NA" for "TFS Scrum" for "ChangeProjectFromOne" functionality 
	And i verify if "Feature" has "flown" which was "NA" for "TFS Scrum" for "ChangeProjectToAnother" functionality 

Scenario: TFSScrum_DeliverableFlow_ProjectChange 
	And i verify if "Deliverable" has "deleted" which was "NA" for "TFS Scrum" for "ChangeProjectFromOne" functionality 
	And i verify if "Deliverable" has "flown" which was "NA" for "TFS Scrum" for "ChangeProjectToAnother" functionality 

Scenario: TFSScrum_ActionFlow_ProjectChange 
	And i verify if "Action" has "deleted" which was "NA" for "TFS Scrum" for "ChangeProjectFromOne" functionality 
	And i verify if "Action" has "flown" which was "NA" for "TFS Scrum" for "ChangeProjectToAnother" functionality 

Scenario: TFSScrum_DeliverableFlow_ProjectChange 
	And i verify if "Deliverable" has "deleted" which was "NA" for "TFS Scrum" for "ChangeProjectFromOne" functionality 
	And i verify if "Deliverable" has "flown" which was "NA" for "TFS Scrum" for "ChangeProjectToAnother" functionality 

Scenario: TFSScrum_RequirementFlow_ProjectChange 
	And i verify if "Requirement" has "deleted" which was "NA" for "TFS Scrum" for "ChangeProjectFromOne" functionality 
	And i verify if "Requirement" has "flown" which was "NA" for "TFS Scrum" for "ChangeProjectToAnother" functionality 

Scenario: TFSScrum_DecisionFlow_ProjectChange 
	And i verify if "Decision" has "deleted" which was "NA" for "TFS Scrum" for "ChangeProjectFromOne" functionality 
	And i verify if "Decision" has "flown" which was "NA" for "TFS Scrum" for "ChangeProjectToAnother" functionality 

Scenario: TFSScrum_MilestoneFlow_ProjectChange 
	And i verify if "Milestone" has "deleted" which was "NA" for "TFS Scrum" for "ChangeProjectFromOne" functionality 
	And i verify if "Milestone" has "flown" which was "NA" for "TFS Scrum" for "ChangeProjectToAnother" functionality 

Scenario: TFSScrum_ChangeRequestFlow_ProjectChange 
	And i verify if "Work Request" has "deleted" which was "NA" for "TFS Scrum" for "ChangeProjectFromOne" functionality 
	And i verify if "Work Request" has "flown" which was "NA" for "TFS Scrum" for "ChangeProjectToAnother" functionality 
		