@2MSPS_API_IB_Verfification
Feature: MSPS functionality IB Verification 


Scenario: MSPS_IBVerification
	Given i load the project properties file 
	Given i login to application "mywizard" 
	And i navigate to the homepage of "mywizard" from "AIFusionPage"
	And i click on tile "my Queries"
	Then i select client and DC for "<applicationname>"
	And i capture the "ExternalID" for Entities created from "MSPS" for tool "MSPS"
	And i generate a token for "DevTest" environment
	And i verify the "inbound" details for "RelForMSPS" for tool "MSPS" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "MSPS" functionality
	And i verify the "inbound" details for "Initiative_MSPS" for tool "MSPS" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "MSPS" functionality
	And i verify the "inbound" details for "MSPS_FunctionalArea" for tool "MSPS" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "MSPS" functionality
	And i verify the "inbound" details for "Milestone_MSPS" for tool "MSPS" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "MSPS" functionality
	And i verify the "inbound" details for "MSPS_Deliverable" for tool "MSPS" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "MSPS" functionality
#deliveryplan or project code pending
#	And i verify the "inbound" details for "MSPS_DeliveryPlan" for tool "MSPS" using "flat" query whose client is "ClientUId" and DC is "DeliveryConstructUId_L2" for "MSPS" functionality