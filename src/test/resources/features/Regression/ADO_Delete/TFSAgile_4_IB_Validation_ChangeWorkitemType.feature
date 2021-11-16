@6IBValidation_TFSAgile_ChangeWorkitemItemType
Feature: TFSAgile_IB_Validation_ChangeProjectOfWorkitem

 
Scenario: TFSAgile_ChangeWorkItemType(BugToMilestone)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Bug" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality
	And i verify if "Milestone" has "flown" which was "Bug" for "TFS Agile" for "delete" functionality
	
Scenario: TFSAgile_ChangeWorkItemType(TaskToAction)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality
	And i verify if "Action" has "flown" which was "Task" for "TFS Agile" for "delete" functionality
	

Scenario: TFSAgile_ChangeWorkItemType(DecisionToFeature)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Decision" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality
	And i verify if "Feature" has "flown" which was "Decision" for "TFS Agile" for "delete" functionality
	
Scenario: TFSAgile_ChangeWorkItemType(RiskToIssue)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Risk" has "deleted" which was "NA" for "TFS Agile" for "delete" functionality
	And i verify if "Issue" has "flown" which was "Risk" for "TFS Agile" for "delete" functionality