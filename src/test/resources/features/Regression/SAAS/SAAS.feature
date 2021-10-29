Feature: SAAS
Scenario Outline: _RemoveUserRole_DIY
 Given i load the project properties file
Given i login to application "<applicationname>"
And i navigate to the homepage of "<applicationname>" from "AIFusionPage"
 And i click on tile "Account Management"
 And i add the role "Delivery lead" for user "sonal.harish.nagda@ds.dev.accenture.com"



Examples:
| applicationname |
| MyWizard |


Scenario Outline: SaaS_loginandNavigation
Given i load the project properties file
And i login to application "<applicationname>" with username "UserName" 
Then i select client "SAAS_Client" with DC_L1 as "SAAS_DC_L1" and DC_L2 as "SAAS_DC_L2"
And i add Contract Demographics details with "BRBEQ001" and "25" and "<6 Mon"
And i add bundle "Requirements Analysis" to the cart in SAAS screen
And i go to final cart and enter all the mandatory details "Requirements Analysis"
#DIY screen enter details
And i enter data for "select tools" section for the bundle "Requirements Analysis" in DIY screen
And i enter data for "integrate tools" section for the bundle "Requirements Analysis" in DIY screen
And i enter data for "data mapping" section for the bundle "Requirements Analysis" in DIY screen
And i get started to order services for bundle "Requirements Analysis" in DIY screen



##back to SAAS UI
And i confirm order confirmation for bundle "Requirements Analysis" in SAAS screen



###back to DIY screen
And i enter data for "enable usecases" section for the bundle "Requirements Analysis" in DIY screen
And i enter data for "add users" section for the bundle "Requirements Analysis" in DIY screen
And i verify if i am able to view all the apps under the bundle "Requirements Analysis"
###phoenix UI - verify if i am able to see the stack tile, i.e all the apps(under that bundle) for the given login




Examples:
| applicationname |
| SaaS |




@ka
Scenario Outline: SaaS_loginandNavigation
Given i load the project properties file
And i login to application "<applicationname>" with username "UserName" 
Then i select client "SAAS_Client" with DC_L1 as "SAAS_DC_L1" and DC_L2 as "SAAS_DC_L2"
And i add Contract Demographics details with "BRBEQ001" and "25" and "<6 Mon"
And i add bundle "Knowledge Assistance" to the cart in SAAS screen
And i go to final cart and enter all the mandatory details "Knowledge Assistance"
#DIY screen enter details
And i enter data for "select tools" section for the bundle "Knowledge Assistance" in DIY screen
And i enter data for "integrate tools" section for the bundle "Knowledge Assistance" in DIY screen
And i enter data for "data mapping" section for the bundle "Knowledge Assistance" in DIY screen
And i get started to order services for bundle "Knowledge Assistance" in DIY screen
##back to SAAS UI
And i confirm order confirmation for bundle "Knowledge Assistance" in SAAS screen
###back to DIY screen
And i enter data for "enable usecases" section for the bundle "Knowledge Assistance" in DIY screen
And i enter data for "add users" section for the bundle "Knowledge Assistance" in DIY screen
And i verify if i am able to view all the apps under the bundle "Knowledge Assistance"
###phoenix UI - verify if i am able to see the stack tile, i.e all the apps(under that bundle) for the given login




Examples:
| applicationname |
| SaaS |



@agile
Scenario Outline: SaaS_loginandNavigation
Given i load the project properties file
And i login to application "<applicationname>" with username "UserName" 
Then i select client "SAAS_Client" with DC_L1 as "SAAS_DC_L1" and DC_L2 as "SAAS_DC_L2"
And i add Contract Demographics details with "BRBEQ001" and "25" and "<6 Mon"
And i add bundle "Agile" to the cart in SAAS screen
And i go to final cart and enter all the mandatory details "Agile"
##DIY screen enter details
And i enter data for "select tools" section for the bundle "Agile" in DIY screen
And i enter data for "integrate tools" section for the bundle "Agile" in DIY screen
And i enter data for "data mapping" section for the bundle "Agile" in DIY screen
And i get started to order services for bundle "Agile" in DIY screen
##back to SAAS UI
And i confirm order confirmation for bundle "Agile" in SAAS screen
###back to DIY screen
And i enter data for "enable usecases" section for the bundle "Agile" in DIY screen
And i enter data for "add users" section for the bundle "Agile" in DIY screen
And i verify if i am able to view all the apps under the bundle "Agile"
###phoenix UI - verify if i am able to see the stack tile, i.e all the apps(under that bundle) for the given login



Examples:
| applicationname |
| SaaS |



@testopti
Scenario Outline: SaaS_loginandNavigation
Given i load the project properties file
And i login to application "<applicationname>" with username "UserName" 
Then i select client "SAAS_Client" with DC_L1 as "SAAS_DC_L1" and DC_L2 as "SAAS_DC_L2"
And i add Contract Demographics details with "BRBEQ001" and "25" and "<6 Mon"
And i add bundle "Test optimization" to the cart in SAAS screen
And i go to final cart and enter all the mandatory details "Test optimization"
##DIY screen enter details
And i enter data for "select tools" section for the bundle "Test optimization" in DIY screen
And i enter data for "integrate tools" section for the bundle "Test optimization" in DIY screen
And i enter data for "data mapping" section for the bundle "Test optimization" in DIY screen
And i get started to order services for bundle "Test optimization" in DIY screen
##back to SAAS UI
And i confirm order confirmation for bundle "Test optimization" in SAAS screen
###back to DIY screen
And i enter data for "enable usecases" section for the bundle "Test optimization" in DIY screen
And i enter data for "add users" section for the bundle "Test optimization" in DIY screen
And i verify if i am able to view all the apps under the bundle "Test optimization"
###phoenix UI - verify if i am able to see the stack tile, i.e all the apps(under that bundle) for the given login




Examples:
| applicationname |
| SaaS |



@program
Scenario Outline: SaaS_loginandNavigation
Given i load the project properties file
And i login to application "<applicationname>" with username "UserName" 
Then i select client "SAAS_Client" with DC_L1 as "SAAS_DC_L1" and DC_L2 as "SAAS_DC_L2"
And i add Contract Demographics details with "BRBEQ001" and "25" and "<6 Mon"
And i add bundle "Program & Project Management" to the cart in SAAS screen
And i go to final cart and enter all the mandatory details "Program & Project Management"
##DIY screen enter details
And i enter data for "select tools" section for the bundle "Program & Project Management" in DIY screen
And i enter data for "integrate tools" section for the bundle "Program & Project Management" in DIY screen
And i enter data for "data mapping" section for the bundle "Program & Project Management" in DIY screen
And i get started to order services for bundle "Program & Project Management" in DIY screen
##back to SAAS UI
And i confirm order confirmation for bundle "Program & Project Management" in SAAS screen
###back to DIY screen
And i enter data for "enable usecases" section for the bundle "Program & Project Management" in DIY screen
And i enter data for "add users" section for the bundle "Program & Project Management" in DIY screen
And i verify if i am able to view all the apps under the bundle "Program & Project Management"
###phoenix UI - verify if i am able to see the stack tile, i.e all the apps(under that bundle) for the given login


Examples:
| applicationname |
| SaaS |



@modern
Scenario Outline: SaaS_loginandNavigation
Given i load the project properties file
And i login to application "<applicationname>" with username "UserName" 
Then i select client "SAAS_Client" with DC_L1 as "SAAS_DC_L1" and DC_L2 as "SAAS_DC_L2"
And i add Contract Demographics details with "BRBEQ001" and "25" and "<6 Mon"
And i add bundle "Modern Engineering Analytics" to the cart in SAAS screen
And i go to final cart and enter all the mandatory details "Modern Engineering Analytics"
##DIY screen enter details
And i enter data for "select tools" section for the bundle "Modern Engineering Analytics" in DIY screen
And i enter data for "integrate tools" section for the bundle "Modern Engineering Analytics" in DIY screen
And i enter data for "data mapping" section for the bundle "Modern Engineering Analytics" in DIY screen
And i get started to order services for bundle "Modern Engineering Analytics" in DIY screen
##back to SAAS UI
And i confirm order confirmation for bundle "Modern Engineering Analytics" in SAAS screen
###back to DIY screen
And i enter data for "enable usecases" section for the bundle "Modern Engineering Analytics" in DIY screen
And i enter data for "add users" section for the bundle "Modern Engineering Analytics" in DIY screen
And i verify if i am able to view all the apps under the bundle "Modern Engineering Analytics"
###phoenix UI - verify if i am able to see the stack tile, i.e all the apps(under that bundle) for the given login


Examples:
| applicationname |
| SaaS |

@process
Scenario Outline: SaaS_loginandNavigation
Given i load the project properties file
And i login to application "<applicationname>" with username "UserName" 
Then i select client "SAAS_Client" with DC_L1 as "SAAS_DC_L1" and DC_L2 as "SAAS_DC_L2"
And i add Contract Demographics details with "BRBEQ001" and "25" and "<6 Mon"
And i add bundle "Process and Workflow Management" to the cart in SAAS screen
And i go to final cart and enter all the mandatory details "Process and Workflow Management"
###DIY screen enter details
And i enter data for "select tools" section for the bundle "Process and Workflow Management" in DIY screen
And i enter data for "integrate tools" section for the bundle "Process and Workflow Management" in DIY screen
And i enter data for "data mapping" section for the bundle "Process and Workflow Management" in DIY screen
And i get started to order services for bundle "Process and Workflow Management" in DIY screen
###back to SAAS UI
And i confirm order confirmation for bundle "Process and Workflow Management" in SAAS screen
####back to DIY screen
And i enter data for "enable usecases" section for the bundle "Process and Workflow Management" in DIY screen
And i enter data for "add users" section for the bundle "Process and Workflow Management" in DIY screen
And i verify if i am able to view all the apps under the bundle "Process and Workflow Management"
###phoenix UI - verify if i am able to see the stack tile, i.e all the apps(under that bundle) for the given login


Examples:
| applicationname |
| SaaS |