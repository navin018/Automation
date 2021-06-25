Feature: GenericUploader APT




@GenericUploader_APT
Scenario Outline: GenericUploader_ADTJira
	Given i load the project properties file 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Generic Uploader"
	
	#ATT-->	Port2-->Prog2-->Proj2	[CREATE EXCEL FILES FOR THE ENTITIES]	
	And i "create" records for entity "Task" in the excel file for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" 
	And i "create" records for entity "Bug" in the excel file for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" 
	And i "create" records for entity "Action" in the excel file for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" 
	And i "create" records for entity "Decision" in the excel file for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" 
	And i "create" records for entity "UserStory" in the excel file for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" 
	
	#ATT-->	Port2-->Prog2-->Proj2	[UPLOAD THE NEWLY EXCEL FILES IN GENERIC UPLOADER]
	Then i select the client as "ATT" and DC_L1 as "Port2" and DC_L2 as "Prog2" and DC_L3 as "Proj2" 
	And i select the Data Entity as "Task" for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" and upload the excel file 
	And i select the Data Entity as "Bug" for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" and upload the excel file 
	And i select the Data Entity as "Action" for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" and upload the excel file 
	And i select the Data Entity as "Decision" for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" and upload the excel file 
	And i select the Data Entity as "UserStory" for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" and upload the excel file 
	
	#ATT-->	Port2-->Prog2-->Proj2	[UPDATE THE FILE FOR THE ENTITIES]
	Then i select the client as "ATT" and DC_L1 as "Port2" and DC_L2 as "Prog2" and DC_L3 as "Proj2" 
	And i "update" records for entity "Task" in the excel file for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" 
	And i "update" records for entity "Bug" in the excel file for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" 
	And i "update" records for entity "Action" in the excel file for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" 
	And i "update" records for entity "Decision" in the excel file for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" 
	And i "update" records for entity "UserStory" in the excel file for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" 
	
	#ATT-->	Port2-->Prog2-->Proj2	[UPLOAD THE UPDATED EXCEL FILES IN GENERIC UPLOADER]
	And i select the Data Entity as "Task" for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" and upload the excel file 
	And i select the Data Entity as "Bug" for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" and upload the excel file 
	And i select the Data Entity as "Action" for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" and upload the excel file 
	And i select the Data Entity as "Decision" for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" and upload the excel file 
	And i select the Data Entity as "UserStory" for client "ATT" and DC_L1 "Port2" and DC_L2 "Prog2" and DC_L3 "Proj2" and upload the excel file 
#
#	#ATT-->	Port1-->Prog1-->Proj1	[CREATE FILE]
#	Then i select the client as "ATT" and DC_L1 as "Port1" and DC_L2 as "Prog1" and DC_L3 as "Proj1"
#	And i "create" records for entity "Task" in the excel file for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1"
#	And i "create" records for entity "Bug" in the excel file for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1"
#	And i "create" records for entity "Action" in the excel file for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1"
#	And i "create" records for entity "Decision" in the excel file for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1"
#	And i "create" records for entity "UserStory" in the excel file for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1"
#	
#	And i select the Data Entity as "Task" for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1" and upload the excel file 
#	And i select the Data Entity as "Bug" for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1" and upload the excel file
#	And i select the Data Entity as "Action" for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1" and upload the excel file
#	And i select the Data Entity as "Decision" for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1" and upload the excel file
#	And i select the Data Entity as "UserStory" for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1" and upload the excel file
#	
#	
#	
#	#ATT-->	Port1-->Prog1-->Proj1	[UPDATE FILE]
#	Then i select the client as "ATT" and DC_L1 as "Port1" and DC_L2 as "Prog1" and DC_L3 as "Proj1"
#	And i "update" records for entity "Task" in the excel file for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1"
#	And i "update" records for entity "Bug" in the excel file for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1"
#	And i "update" records for entity "Action" in the excel file for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1"
#	And i "update" records for entity "Decision" in the excel file for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1"
#	And i "update" records for entity "UserStory" in the excel file for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1"
#	
#	And i select the Data Entity as "Task" for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1" and upload the excel file 
#	And i select the Data Entity as "Bug" for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1" and upload the excel file
#	And i select the Data Entity as "Action" for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1" and upload the excel file
#	And i select the Data Entity as "Decision" for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1" and upload the excel file
#	And i select the Data Entity as "UserStory" for client "ATT" and DC_L1 "Port1" and DC_L2 "Prog1" and DC_L3 "Proj1" and upload the excel file

	
	

	Examples: 
		| applicationname | 
		| MyWizard             |
		
		

				

		