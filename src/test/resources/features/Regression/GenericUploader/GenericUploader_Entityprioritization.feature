Feature: GenericUploader prioritization 


@ProdConfigRemoveEntiy_Entityprioritization
Scenario Outline: ADTJIRA_RemoveEntityEpicFromProdConfigPage
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Configuration" 
	And i select client and DC for "MyWizard"
	And i select the "ADT JIRA" in Manage Product Configuration page
	And i navigate to "Product Instance Entities" section
	And i "remove" entity "Epic" in the Product Instance Entities section 
	And i hit the save button in Product Config page
	And i click on "backtodashboard" button
	And i click on tile "Generic Uploader"
	And i verify the entity prioritization for entity "Epic" in generic uploader tile for tool "ADT JIRA" 
	And i click on "backtodashboard" button
	And i click on tile "Product Configuration"
	And i select the "ADT JIRA" in Manage Product Configuration page
	And i navigate to "Product Instance Entities" section
	And i "Add" entity "Epic" in the Product Instance Entities section 
	And i hit the save button in Product Config page
	
	Examples: 
		| applicationname | 
		| MyWizard           | 



