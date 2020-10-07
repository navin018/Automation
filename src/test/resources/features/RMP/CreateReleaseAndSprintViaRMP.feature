@Browser
Feature: RMP

  Scenario Outline: 
    Given i login to application "<applicationname>"
    And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
    Then i select client and DC for "<applicationname>" 
   	And i navigate to RMP page
   	And i and create Release and Sprint in RMP page
   	And i update the WorkItemExternalIDs into a JSON file for "<applicationname1>"
   	
 

    Examples: 
      | applicationname |applicationname1|
      | MyWizard        |RMP|
