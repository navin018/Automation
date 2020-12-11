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
	And i click on "Associate Clients" button 
	And the user check for the duplicate security headers and missing security headers for "Metrics Engine/Associate Clients" 
	And i click on "Close Associate Clients page" button 
	And i click on "Go Back" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
	
@SecurityTest_GenericUploader 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
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
	
	
@SecurityTest_DIYADAutomation 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "DIY AD Automation" 
	Then i select only the client for "<applicationname>" 
	And the user check for the duplicate security headers and missing security headers for "DIY AD Automation" 
	And i click on "ConfigContractExplore" button 
	And the user check for the duplicate security headers and missing security headers for "DIY AD Automation/ConfigContractExplore" 
	And i click on link "Add Delivery Structure" under "DIY AD Automation/ConfigContractExplore page/Add Delivery Structure" 
	And the user check for the duplicate security headers and missing security headers for "DIY Automation/Add Delivery Structure/ConfigContractExplore" 
	And i click on "CloseAddDC" button 
	And i click on "Back to DIY AD Automation" button 
	And i click on "SelfEnabledAutomationExplore" button 
	And the user check for the duplicate security headers and missing security headers for "DIY AD Automation/SelfEnabledAutomationExplore" 
	And i click on "Select Functions" button 
	And the user check for the duplicate security headers and missing security headers for "DIY AD Automation/SelfEnabledAutomationExplore/Select Functions" 
	And i click on link "Add Tool" under "Select Functions sub-page under SelfEnabledAutomationExplore page/DIY AD Automation tile" 
	And the user check for the duplicate security headers and missing security headers for "DIY AD Automation/SelfEnabledAutomationExplore/Select Functions/Add tool" 
	And i click on "CloseAddDC" button 
	And i click on "Back to Overall Setup Progress" button 
	And i click on "Integrate Tools" button 
	And the user check for the duplicate security headers and missing security headers for "DIY AD Automation/Integrate Tools" 
	And i click on "Back to Overall Setup Progress" button 
	And i click on "Data Mapping" button 
	And the user check for the duplicate security headers and missing security headers for "DIY AD Automation/Data Mapping" 
	And i click on "Back to Overall Setup Progress" button 
	And i click on "Enable Usecases" button 
	And the user check for the duplicate security headers and missing security headers for "DIY AD Automation/Enable Usecases" 
	And i click on "Back to Overall Setup Progress" button 
	#Add users not clickable
#	And i click on "Add Users" button 
	#And the user check for the duplicate security headers and missing security headers for "DIY AD Automation/Add Users" 
#	And i click on "Back to Overall Setup Progress" button 
	And i click on "Back to DIY AD Automation" button 
	And i click on "OnbaordClientToolExplore" button 
	And the user check for the duplicate security headers and missing security headers for "DIY AD Automation/OnbaordClientToolExplore" 
	And i click on "Back to DIY AD Automation" button 
	And i click on "backtodashboard" button 
	And i "update" the vulnerabilites details into excel 
	And i verify the overall securitytest results 
	
	
@SecurityTest_VirtualAssistant 
Scenario: Check for the security headers 
	Given i login to application "MyWizard" 
	And i navigate to the homepage of "MyWizard" from "AIFusionPage" 
	And i click on tile "Virtual Assistant" 
	#	And the user check for the duplicate security headers and missing security headers for "Virtual Assistant Tile"
	
	And i click on "Metrics Dashboard setting" button 
	#	And the user check for the duplicate security headers and missing security headers for "Metrics Dashboard setting page under Virtual Assistant Tile"
	And i click on "Process Builder" button 
	#	And the user check for the duplicate security headers and missing security headers for "Process Builder page under Virtual Assistant Tile"
	And i click on "Metrics Dashboard setting" button 
	And i click on "VABack" button 
	And i click on "notifications" button 
	#	And the user check for the duplicate security headers and missing security headers for "Notifications page under Virtual Assistant Tile"
	And i click on "AttentionArea" button 
	#	And the user check for the duplicate security headers and missing security headers for "AttentionArea page under Virtual Assistant Tile"
	And i click on "VASettings" button 
	And i click on "Query" button 
	#	And the user check for the duplicate security headers and missing security headers for "Query page under Virtual Assistant Tile"
	And i click on "VABack" button 
	And i click on "VASettings" button 
	And i click on "Recommendation" button 
	#	And the user check for the duplicate security headers and missing security headers for "Recommendation page under Virtual Assistant Tile"
	And i click on "VABack" button 
	And i click on "VASettings" button 
	And i click on "Entity" button 
	#	And the user check for the duplicate security headers and missing security headers for "Entity page under Virtual Assistant Tile"
	And i click on "VABack" button 
	And i click on "VASettings" button 
	And i click on "ruleBuilder" button 
	#	And the user check for the duplicate security headers and missing security headers for "ruleBuilder page under Virtual Assistant Tile"
	And i click on "VABack" button 
	And i navigate to HomePage