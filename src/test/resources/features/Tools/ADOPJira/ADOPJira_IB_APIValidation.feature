@ADOPJiraInBoundValidation 
Feature: ADOPJira inbound workitems validation 

Scenario Outline: ADOP JIRA IB Task validation 

	And i verify the "Inbound" "Task" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |
		
Scenario Outline: ADOP Jira IB Epic validation 

	And i verify the "Inbound" "Epic" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |
	
Scenario Outline: ADOP Jira IB Story validation 

	And i verify the "Inbound" "Story" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |		
		
Scenario Outline: ADOP Jira IB Risk validation 

	And i verify the "Inbound" "Risk" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |	
		
		
		
		
Scenario Outline: ADOP Jira IB Impediment validation 

	And i verify the "Inbound" "Impediment" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |	
			
Scenario Outline: ADOP Jira IB Issue validation 

	And i verify the "Inbound" "Issue" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |	
		
Scenario Outline: ADOP Bug IB Issue validation 

	And i verify the "Inbound" "Bug" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |	
		
Scenario Outline: ADOP Jira IB Feature validation 

	And i verify the "Inbound" "Feature" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |	
		
Scenario Outline: ADOP Jira IB Release and Sprint validation 

	And i verify the "Inbound" "ReleaseAndSprint" details for "<toolname>" 
	
	Examples: 
		| toolname | 
		| ADOP Jira  |																				
																					
			