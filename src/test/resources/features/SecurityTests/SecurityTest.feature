Feature: Check for the security headers 

@SecurityTest_AccountManagementPage 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	Given the user check for the duplicate security headers and missing security headers for "MyWizardDashboardPage" 
	And i click on tile "Account Management" 
	And the user check for the duplicate security headers and missing security headers for "Account Management" 
	And i click on link "Add Account" under "Account Management" 
	And the user check for the duplicate security headers and missing security headers for "Account Management/Add Account page " 
	And i click on "back" button 
	And i click on link "View/Edit" under "Account Management" 
	And the user check for the duplicate security headers and missing security headers for "Account Management/View Edit page" 
	And i navigate to HomePage 
	And i "write" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
	
@SecurityTest_OrgDelStructureType 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Organization (Delivery) Structure Type" 
	And the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Type" 
	And i click on link "Add Organization Structure Type" under "Organization (Delivery) Structure Page" 
	Given the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Type/Add Organization Structure Type" 
	And i click on "back" button 
	And i click on link "Manage Delivery Construct Type" under "Organization (Delivery) Structure Page" 
	Given the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Type/Manage Delivery Construct" 
	And i click on link "View/Edit" under "Organization (Delivery) Structure Page,Manage Delivery Construct Type section" 
	Given the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Type/Manage Delivery Construct Type/View Edit Page" 
	And i click on link "Add Attribute" under "Organization (Delivery) Structure Page,Manage Delivery Construct Type section" 
	Given the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Type/Manage Delivery Construct Type/View Edit Page/Add Attribute Page" 
	And i click on "cancel" button 
	And i click on "back" button 
	And i click on link "Add Delivery Construct Type" under "Organization (Delivery) Structure/Manage Delivery Construct Type" 
	Given the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Type/Manage Delivery Construct Type/Add Delivery Construct Type" 
	And i click on "back" button 
	And i click on link "View/Edit" under "Organization (Delivery) Structure Page,Manage Delivery Construct Type section" 
	Given the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Type/Manage Delivery Construct Type/View Edit Page" 
	And i click on "back" button 
	And i click on "back" button 
	And i click on "backtodashboard" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
#	
@SecurityTest_OrgDelStructureConfig 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Organization (Delivery) Structure Config" 
	And the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Config" 
	And i click on link "Add Organization Structure" under "Organization (Delivery) Structure Config Page" 
	Given the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Config/Add Organization Structure" 
	And i click on "back" button 
	And i click on link "Manage Teams" under "Organization (Delivery) Structure Config" 
	Given the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Config/Manage Teams" 
	And i click on link "Add Team" under "View/Edit page of Organization (Delivery) Structure Config/Manage Teams" 
	Given the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Config/Manage Teams/Add Teams" 
	And i click on "back" button 
	And i click on link "View/Edit" under "Organization (Delivery) Structure Config Page,Manage Teams section" 
	And the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Config/Manage Teams/View Edit page" 
	And i click on "back" button 
	And i click on "backtodashboard" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
	
@SecurityTest_Event&Listner 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Event & Notification" 
	And the user check for the duplicate security headers and missing security headers for "Event & Notification" 
	And i click on link "Manage Account Listener" under "Event & Notification page" 
	And the user check for the duplicate security headers and missing security headers for "Event & Notification/Manage Account Listener" 
	And i click on "back" button 
	And i click on "backtodashboard" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
@SecurityTest_AppServicesConfig 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "AppServices Configuration" 
	And the user check for the duplicate security headers and missing security headers for "AppServices Configuration" 
	And i click on link "View/Edit" under "AppServices Configuration Page" 
	And the user check for the duplicate security headers and missing security headers for "AppServices Configuration/View Edit page" 
	And i click on link "Add Tile" under "View/Edit page of AppServices Configuration Tile" 
	And the user check for the duplicate security headers and missing security headers for "AppServices Configuration/View Edit Page/Add Tile Page" 
	And i click on "close" button 
	And i click on "back" button 
	And i click on link "Add App Service" under "AppServices Configuration Tile" 
	And the user check for the duplicate security headers and missing security headers for "AppServices Configuration/Add App Service page" 
	And i click on "back" button 
	And i click on "backtodashboard" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
@SecurityTest_TeamConfig 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Team Configuration" 
	And the user check for the duplicate security headers and missing security headers for "Team Configuration" 
	And i click on link "View/Edit" under "Team Configuration" 
	And the user check for the duplicate security headers and missing security headers for "Team Configuration/View Edit page" 
	And i click on "back" button 
	And i click on link "Add Team" under "Team Configuration" 
	And the user check for the duplicate security headers and missing security headers for "Team Configuration/Add Team page" 
	And i click on "back" button 
	And i click on "backtodashboard" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
@SecurityTest_ProductConfig 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Product Configuration" 
	And the user check for the duplicate security headers and missing security headers for "Product Configuration" 
	And i click on link "View/Edit" under "Product Configuration" 
	And the user check for the duplicate security headers and missing security headers for "Product Configuration/View Edit page" 
	And i click on "back" button 
	And i click on link "Add Product" under "Product Configuration" 
	And the user check for the duplicate security headers and missing security headers for "Product Configuration/Add Product page" 
	And i click on "back" button 
	And i click on "backtodashboard" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
	
@SecurityTest_ProductInstanceEntityRuleConfig 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Product Instance Entity Rule Config" 
		And i select client and DC for "MyWizard"
	And the user check for the duplicate security headers and missing security headers for "Product Instance Entity Rule Config" 
	And i click on link "Add Rule" under "Product Instance Entity Rule Config" 
	And the user check for the duplicate security headers and missing security headers for "Product Instance Entity Rule Config/Add Rule" 
	And i click on "back" button 
	And i click on "backtodashboard" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
@SecurityTest_AccessRole 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Access Role" 
	And the user check for the duplicate security headers and missing security headers for "Access Role" 
	And i click on link "View/Edit" under "Access Role" 
	And the user check for the duplicate security headers and missing security headers for "Access Role/View Edit page" 
	And i click on "Go Back" button 
	And i click on link "Add Access Role" under "Access Role" 
	And the user check for the duplicate security headers and missing security headers for "Access Role/Add Access Role" 
	And i click on "Go Back" button 
	And i click on "Go Back" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
@SecurityTest_IterationRecon 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Iteration Reconciliation"
	And i select client and DC for "MyWizard" 
	And the user check for the duplicate security headers and missing security headers for "Iteration Reconciliation" 
	And i click on link "Add Iteration Reconciliation" under "Iteration Reconciliation" 
	And the user check for the duplicate security headers and missing security headers for "Iteration Reconciliation/Add Iteration Reconciliation" 
	And i click on "Back To Manage Reconciliation" button 
	And i click on "Go Back" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
@SecurityTest_MyQueries 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "my Queries" 
	And the user check for the duplicate security headers and missing security headers for "my Queries" 
	And i click on link "New Query" under "my Queries page" 
	And the user check for the duplicate security headers and missing security headers for "my Queries/New Query page" 
	And i click on "Go Back" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
@SecurityTest_DataFlowTracking 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Dataflow Tracking" 
	And the user check for the duplicate security headers and missing security headers for "Dataflow Tracking" 
	And i click on "Go Back" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
@SecurityTest_DataUpload 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Data Upload" 
	And the user check for the duplicate security headers and missing security headers for "DataUpload" 
	And i click on "Go Back" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
@SecurityTest_ClientConfig 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Client Configuration" 
	And the user check for the duplicate security headers and missing security headers for "Client Configuration" 
	And i click on link "View/Edit" under "Client Configuration" 
	And the user check for the duplicate security headers and missing security headers for "Client Configuration/View Edit page" 
	And i click on "Go Back" button 
	And i click on link "Add Client" under "Client Configuration" 
	And the user check for the duplicate security headers and missing security headers for "Client Configuration/Add Client" 
	And i click on "Go Back" button 
	And i click on "Go Back" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
@SecurityTest_MetricsEngine 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Metrics Engine" 
	And the user check for the duplicate security headers and missing security headers for "Metrics Engine" 
	#i commented this for some reASON
#	And i click on "Associate Clients" button 
#	And the user check for the duplicate security headers and missing security headers for "Metrics Engine/Associate Clients" 
#	And i click on "Close Associate Clients page" button 
	And i click on "Go Back" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
	
@SecurityTest_GenericUploader 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	Then i select client and DC for "<applicationname>" 
	And i click on tile "Generic Uploader" 
	And the user check for the duplicate security headers and missing security headers for "Generic Uploader" 
	#	And i click on "Select DataEntity Dropdown" button 
	#	And i click on "Select Standard Template" button 
	And i click on "View/Edit mapping" button 
	And the user check for the duplicate security headers and missing security headers for "Generic Uploader/View Edit Page" 
	And i click on "Go Back" button 
	And i click on "Go Back" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
@SecurityTest_LifecycleTemplateConfig 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Lifecycle Template Configuration" 
	And the user check for the duplicate security headers and missing security headers for "Lifecycle Template Configuration Tile" 
	And i click on link "Add Stage Template" under "Lifecycle Template Configuration" 
	And the user check for the duplicate security headers and missing security headers for "Lifecycle Template Configuration/Add Stage Template" 
	And i click on "Go Back" button 
	And i click on "Go Back" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
@1ADTJira_DIY_RemoveUserRoleInAccountManagement_SecurityTest
Scenario Outline: ADTJIRA_RemoveUserRole_DIY 
	Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Account Management"
	And i remove the role "Client Admin" for user "sonal.harish.nagda@accenture.com"

Examples: 
		| applicationname |
		| MyWizard        |

	
@SecurityTest_DIYADAutomation
Scenario: Check for the security headers 
	Given i load the project properties file
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "DIY AD Automation" 
	Then i select only the client for "<applicationname>" 
	And i "create" a DC for DIY for "ADT Jira"	
	And the user check for the duplicate security headers and missing security headers for "DIY AD Automation/HomePage"
	And i enter self enabled automation details for "ADT Jira"
	And the user check for the duplicate security headers and missing security headers for "DIY AD Automation/CreateDCPage"
	And i click on "Back to Overall Setup Progress" button
	And i click on "Back to DIY AD Automation" button
	And i click on "OnbaordClientToolExplore" button 
	And the user check for the duplicate security headers and missing security headers for "DIY AD Automation/OnbaordClientToolExplorePage"
	And i click on "Back to DIY AD Automation" button 
	And i click on "backtodashboard" button
	And i make a note of the DC created for "ADT Jira" 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results
	
	
@ADTJira_SecurityTest_InactivateRules
Scenario Outline: ADTJIRA_DIY_InactiveRules
Given i load the project properties file 
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "Product Instance Entity Rule Config"
	Then i select client and DC for DIY for "ADT Jira"	
	And i deactivate the rules for "ADT Jira"
	And i "delete" a DC for DIY for "ADT Jira"
	
	Examples: 
		| applicationname |
		| MyWizard        |

@8ADTJira_SecurityTest_DeleteDC
Scenario: ADTJIRA_DI
	Given i login to application "<applicationname>" 
	And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
	And i click on tile "DIY AD Automation" 
	Then i select only the client for "<applicationname>"
	And i "delete" a DC for DIY for "ADT Jira"	
	 
