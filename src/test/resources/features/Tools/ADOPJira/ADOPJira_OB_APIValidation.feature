@ADOPJiraOutBoundValidation 
Feature: ADOPJira outbound workitems validation 

Scenario Outline: Task validation 

	And i verify the "Outbound" "Task" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |
		
Scenario Outline: Epic validation 

	And i verify the "Outbound" "Epic" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |
	
Scenario Outline: Story validation 

	And i verify the "Outbound" "Story" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |		
		
Scenario Outline: Risk validation 

	And i verify the "Outbound" "Risk" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |	
		
		
		
		
Scenario Outline: Impediment validation 

	And i verify the "Outbound" "Impediment" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |	
		
		
		
		
Scenario Outline: Issue validation 

	And i verify the "Outbound" "Issue" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |	
		
Scenario Outline: ADOP Bug OB Issue validation 

	And i verify the "Outbound" "Bug" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |	
		
Scenario Outline: Feature validation 

	And i verify the "Outbound" "Feature" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |	
		

					

