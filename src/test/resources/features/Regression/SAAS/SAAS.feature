Feature: SAAS
Scenario Outline: ADTJIRA_RemoveUserRole_DIY 
    Given i load the project properties file 
    Given i login to application "<applicationname>" 
    And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
    And i click on tile "Account Management"
    And i add the role "Delivery lead" for user "sonal.harish.nagda@accenture.com"
	
 
Examples: 
        | applicationname |
        | MyWizard        |
 
        
Scenario Outline: SaaS_loginandNavigation
Given i load the project properties file
And i login to application "<applicationname>"
Then i select client "SAAS_Client" with DC_L1 as "SAAS_DC_L1" and DC_L2 as "SAAS_DC_L2"
And i add Contract Demographics details with "Chargecode" and "NoofUsers" and "ContractDuration"
And i add bundle "Requirements Analysis" to the cart in SAAS screen			#likhita
And i go to final cart and enter all the mandatory details "Requirements Analysis"  #capture order ID	#likhita
#DIY screen enter details
And i enter data for "select tools" section for the bundle "Requirements Analysis" in DIY screen	#sangeetha
And i enter data for "integrate tools" section for the bundle "Requirements Analysis" in DIY screen	#sangeetha
And i enter data for "data mapping" section for the bundle "Requirements Analysis" in DIY screen	#sangeetha
And i get started to order services for bundle "Requirements Analysis" in DIY screen	#sangeetha

#back to SAAS UI
And i confirm order confirmation for bundle "Requirements Analysis" in SAAS screen	#likhita

#back to DIY screen
And i enter data for "enable usecases" section for the bundle "Requirements Analysis" in DIY screen	#sangeetha
And i enter data for "add users" section for the bundle "Requirements Analysis" in DIY screen	#sangeetha

#phoenix UI - verify if i am able to see the stack tile, i.e all the apps(under that bundle) for the given login
And i verify if i am able to view all the apps under the bundle "Requirements Analysis"	#likhita

Examples:
| applicationname |
| SaaS |