Feature: Check for the security headers 

@SecurityTest_AccountManagementPage
Scenario: Check for the security headers
Given i load the project properties file
    Given i login to application "MyWizard"
    And i navigate to the homepage of "MyWizard" from "AIFusionPage"
    Then i select client and DC for "<applicationname>"
    And i click on tile "Account Management"
    And i click on link "Add Account" under "Account Management"
    And i click on "back" button
    And i enter all the mandatory details for "Account Management"
    And the user check for the duplicate security headers and missing security headers for "Account Management/Add Account page "
    And i delete the data for "Account Management"
    And i click on "back" button
    And i click on link "View/Edit" under "Account Management"
    And the user check for the duplicate security headers and missing security headers for "Account Management/View Edit page"
    And i "write" the vulnerabilites details into excel
    And i verify the overall securitytest results
	
	
@SecurityTest_OrgDelStructureType
Scenario: Check for the security headers
    Given i login to application "MyWizard"
    And i navigate to the homepage of "MyWizard" from "AIFusionPage"
    And i click on tile "Organization (Delivery) Structure Type"
   Then i select client and DC for "<applicationname>"
    And i enter all the mandatory details for "Organization (Delivery) Structure Page"
    Given the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Type/Add Organization Structure Type"
    And i delete the data for "Organization (Delivery) Structure Page"
    And i click on link "Add Organization Structure Type" under "Organization (Delivery) Structure Page"
    And i click on "back" button
    And i click on link "View/Edit" under "Organization (Delivery) Structure Page,Manage Delivery Construct Type section"
    And i click on "back" button
    And i click on link "Manage Delivery Construct Type" under "Organization (Delivery) Structure Page"
    And i click on link "Add Delivery Construct Type" under "Organization (Delivery) Structure/Manage Delivery Construct Type"
    And i click on link "Add Attribute" under "Organization (Delivery) Structure Page,Manage Delivery Construct Type section"
    Given the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Type/Manage Delivery Construct Type/View Edit Page/Add Attribute Page"
    And i click on "cancel" button
    And i click on "back" button
    And i click on link "View/Edit" under "Organization (Delivery) Structure Page,Manage Delivery Construct Type section"
    Given the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Type/Manage Delivery Construct Type/View Edit Page"
    And i click on "back" button
    And i click on "back" button
    And i click on "backtodashboard" button
    And i "update" the vulnerabilites details into excel
    And i verify the overall securitytest results
    
@SecurityTest_OrgDelStructureConfig
Scenario: Check for the security headers
Given i load the project properties file
    Given i login to application "MyWizard"
    And i navigate to the homepage of "MyWizard" from "AIFusionPage"
    And i click on tile "Organization (Delivery) Structure Config"
    Then i select client and DC for "<applicationname>"
    And i click on link "Add Organization Structure" under "Organization (Delivery) Structure Config Page"
    And i click on "back" button
    And i enter all the mandatory details for "Organization (Delivery) Structure Config"
    Given the user check for the duplicate security headers and missing security headers for "Organization (Delivery) Structure Config/Add Organization Structure"
    And i delete the data for "Organization (Delivery) Structure Config"
    And i click on "back" button
    And i click on link "Manage Teams" under "Organization (Delivery) Structure Config"
    And i click on "back" button
    And i click on link "Add Team" under "View/Edit page of Organization (Delivery) Structure Config/Manage Teams"
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
    And i click on link "View/Edit" under "AppServices Configuration Page"
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
    And i click on link "View/Edit" under "Team Configuration"
    And i click on "back" button
    And i click on link "Add Team" under "Team Configuration"
    And i enter all the mandatory details for "Team Configuration"
    And the user check for the duplicate security headers and missing security headers for "Team Configuration/Add Team page"
    And i delete the data for "Team Configuration"
    And i click on "back" button
    And i click on "backtodashboard" button
    And i "update" the vulnerabilites details into excel
    And i verify the overall securitytest results

	
@SecurityTest_ProductConfig
Scenario: Check for the security headers
    Given i login to application "MyWizard"
    And i navigate to the homepage of "MyWizard" from "AIFusionPage"
    And i click on tile "Product Configuration"
    And i click on link "View/Edit" under "Product Configuration"
    And the user check for the duplicate security headers and missing security headers for "Product Configuration/View Edit page"
    And i click on "back" button
    And i click on link "Add Product" under "Product Configuration"
    And i enter all the mandatory details for "Product Configuration"
    And the user check for the duplicate security headers and missing security headers for "Product Configuration/Add Product page"
    And i delete the data for "Product Configuration"
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
    And i click on link "Add Rule" under "Product Instance Entity Rule Config"
    And the user check for the duplicate security headers and missing security headers for "Product Instance Entity Rule Config"
    And i click on "Go Back" button
     And i enter all the mandatory details for "Product Instance Entity Rule Config"
    And the user check for the duplicate security headers and missing security headers for "Product Instance Entity Rule Config/Add Rule"
    And i delete the data for "Product Instance Entity Rule Config"
    And the user check for the duplicate security headers and missing security headers for "Product Instance Entity Rule Config/Add Rule"
    And i click on "backtodashboard" button
    And i "update" the vulnerabilites details into excel
    And i verify the overall securitytest results


	
@SecurityTest_AccessRole
Scenario: Check for the security headers
    Given i login to application "MyWizard"
    And i navigate to the homepage of "MyWizard" from "AIFusionPage"
    And i click on tile "Access Role"
    And i click on link "View/Edit" under "Access Role"
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
    And i click on link "New Query" under "my Queries page"
    And i enter all the mandatory details for "my Queries page"
    And the user check for the duplicate security headers and missing security headers for "my Queries/New Query page"
    And i delete the data for "my Queries page"
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
	And i enter all the mandatory details for "Data Upload"
	And the user check for the duplicate security headers and missing security headers for "DataUpload" 
	And i click on "Go Back" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
@SecurityTest_ClientConfig 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Client Configuration"  
	And i click on link "View/Edit" under "Client Configuration"
	And i enter all the mandatory details for "Client Configuration" 
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
	 And i enter all the mandatory details for "Metrics Engine"
	And the user check for the duplicate security headers and missing security headers for "Metrics Engine" 
   And i delete the data for "Metrics Engine"
	And i click on "Go Back" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
	
@SecurityTest_GenericUploader
Scenario: Check for the security headers
Given i load the project properties file
    Given i login to application "MyWizard"
    And i navigate to the homepage of "MyWizard" from "AIFusionPage"
    Then i select client and DC for "<applicationname>"
    And i click on tile "Generic Uploader"
    And i prepare the excel data for tool "ADT Jira" in "Generic Uploader" DataLoader
    And i select the Product Instance as "ADT JIRA"
    And i select the Data Entity as "Epic" for "ADT Jira" and upload the excel file
    And the user check for the duplicate security headers and missing security headers for "Generic Uploader"
    And i click on "View/Edit mapping" button
    And the user check for the duplicate security headers and missing security headers for "Generic Uploader/View Edit Page"
    And i click on "Go Back" button
    And i "update" the vulnerabilites details into excel
    And i verify the overall securitytest results
	
@SecurityTest_LifecycleTemplateConfig
Scenario: Check for the security headers
    Given i login to application "MyWizard"
    And i navigate to the homepage of "MyWizard" from "AIFusionPage"
    And i click on tile "Lifecycle Template Configuration"
    And i click on "Go Back" button
    And i click on link "Add Stage Template" under "Lifecycle Template Configuration"
    And i enter all the mandatory details for "Lifecycle Template Configuration/Add Stage Template"
    And the user check for the duplicate security headers and missing security headers for "Lifecycle Template Configuration/Add Stage Template"
     And i delete the data for "Lifecycle Template Configuration/Add Stage Template"
    And i click on "Go Back" button
    And i "update" the vulnerabilites details into excel
    And i verify the overall securitytest results

	
	
@SecurityTest_PrecomputationEngine
Scenario Outline: Check for the security headers
Given i load the project properties file
Given i login to application "MyWizard"
And i navigate to the homepage of "MyWizard" from "AIFusionPage"
And i click on tile "Precomputation Engine"
And i click on "Add Process" button
And the user check for the duplicate security headers and missing security headers for "Precomputation Engine"
And i click on "Cancel" button
And i click on "backtodashboard" button
And i "update" the vulnerabilites details into excel
And i verify the overall securitytest results



Examples:
| applicationname |
| MyWizard |	
	
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
	And i enter self enabled automation details for "ADT Jira" for "normal" functionality 
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

	 
