@6IBValidation_TFSScrum_ChangeWorkitemItemType
Feature: TFSScrum_IB_Validation_ChangeProjectOfWorkitem

 
Scenario: TFSScrum_ChangeWorkItemType(BugToMilestone)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Bug" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality
	And i verify if "Milestone" has "flown" which was "Bug" for "TFS Scrum" for "delete" functionality
	
Scenario: TFSScrum_ChangeWorkItemType(TaskToAction)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality
	And i verify if "Action" has "flown" which was "Task" for "TFS Scrum" for "delete" functionality
	

Scenario: TFSScrum_ChangeWorkItemType(DecisionToFeature)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Decision" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality
	And i verify if "Feature" has "flown" which was "Decision" for "TFS Scrum" for "delete" functionality
	
Scenario: TFSScrum_ChangeWorkItemType(RiskToIssue)
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Risk" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality
	And i verify if "Issue" has "flown" which was "Risk" for "TFS Scrum" for "delete" functionality
	
Scenario: TFSScrum_ChangeWorkItemType(EpicToRequirement)
Given i load the project properties file
And i generate a token for "DevTest" environment
And i verify if "Epic" has "deleted" which was "NA" for "TFS Scrum" for "delete" functionality
And i verify if "Requirement" has "flown" which was "Risk" for "TFS Scrum" for "delete" functionality