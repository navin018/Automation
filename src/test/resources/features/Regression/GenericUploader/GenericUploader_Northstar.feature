@7GenericUploader_NorthStar
Feature: GenericUploader_NorthStar 

Scenario: NoTool_NorthStar_flow_GenericUploader
Given i load the project properties file 
And i generate a token for "DevTest" environment
And i verify if "NorthStar" has "flown" which was "NA" for "ADT JIRA" for "NoTool_NorthStar" functionality


Scenario: NoTool_BusinessUnit_flow_GenericUploader
And i verify if "BusinessUnit" has "flown" which was "NA" for "ADT JIRA" for "NoTool_NorthStar" functionality

Scenario: NoTool_ServiceLine_flow_GenericUploader
And i verify if "ServiceLine" has "flown" which was "NA" for "ADT JIRA" for "NoTool_NorthStar" functionality

Scenario: NoTool_BusinessProcess_flow_GenericUploader
And i verify if "BusinessProcess" has "flown" which was "NA" for "ADT JIRA" for "NoTool_NorthStar" functionality
	
Scenario: NoTool_BusinessKPI_flow_GenericUploader
And i verify if "BusinessKPI" has "flown" which was "NA" for "ADT JIRA" for "NoTool_NorthStar" functionality
			
Scenario: NoTool_ITKPI_flow_GenericUploader
And i verify if "ITKPI" has "flown" which was "NA" for "ADT JIRA" for "NoTool_NorthStar" functionality