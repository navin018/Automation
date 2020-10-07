@Browser
Feature: Googletest

  Scenario Outline: 
   And i copy the existing workitem details for "<applicationname>" into WorkItemExternalIDsFile
    
    Examples: 
      | applicationname | 
      | TFS             | 
