@4TFSScrum_DIY_IBVerfification
Feature: TFSScrum_DIY_IBVerification 

Scenario: TFSScrum_Task_flow_DIY 
Given i load the project properties file 
	And i generate a token for "DevTest" environment
	And i verify if "Task" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality 


Scenario: TFSScrum_Epic_flow_DIY 

	And i verify if "Epic" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality 


Scenario: TFSScrum_Story_flow_DIY 
	And i verify if "Story" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality 


Scenario: TFSScrum_Risk_flow_DIY 
	And i verify if "Risk" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality 
	 

Scenario: TFSScrum_Issue_flow_DIY 
And i verify if "Issue" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality 
	 
	
Scenario: TFSScrum_Bug_flow_DIY
And i verify if "Bug" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality 
	

Scenario: TFSScrum_Feature_flow_DIY 
And i verify if "Feature" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality


Scenario: TFSScrum_Impediment_flow_DIY 
And i verify if "Impediment" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality  

Scenario: TFSScrum_TestCase_flow_DIY
And i verify if "TestCase" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality	 

Scenario: TFSScrum_Deliverable_flow_DIY 
And i verify if "Deliverable" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality 
	
	

Scenario: TFSScrum_Action_flow_DIY 
And i verify if "Action" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality 
	

Scenario: TFSScrum_Decision_flow_DIY 
And i verify if "Decision" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality 
	
		
Scenario: TFSScrum_Milestone_flow_DIY 
And i verify if "Milestone" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality 

		
Scenario: TFSScrum_Requirement_flow_DIY 
And i verify if "Requirement" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality 
	
Scenario: TFSScrum_WorkRequest_flow_DIY 
And i verify if "Work Request" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality 
	
Scenario: TFSScrum_DIY_IBVerification_Release_Sprint 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the IterationExternalID for Iteration created from "tool" for tool "TFS Scrum" 
	And i generate a token for "DevTest" environment 	
	And i verify if "Release" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality
	And i verify if "Sprint" has "flown" which was "NA" for "TFS Scrum" for "DIY" functionality
	
