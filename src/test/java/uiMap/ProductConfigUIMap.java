package uiMap;

import org.openqa.selenium.By;

public class ProductConfigUIMap {
	
	public static By searchBox_txtbox = By.xpath("//input[@placeholder='Search...']");
	
	public static By plusIcon_btn = By.xpath("//i[@class='pi pi-fw pi-chevron-right']");
	public static By ToasterMsg_HighlightedFeilds_Msg = By.xpath("//div[contains(text(),'Highlighted fields are mandatory to fill')]");
	public static String toolnameInstance_statixtxt = "//table//tbody//tr[3]//td[1]//span[@title='{toolname}']";
	public static By EditProductInstance_statictxt= By.xpath("//a[text()='Edit Product Instance']");
	public static String ToolSugestions_statictxt = "//span[text()='{toolname}']";
	public static By ProductInstanceExtension_link = By.xpath("//span[text()='Product Instance Extension(s)']");
	public static By AddExtension_link = By.xpath("//span[text()='Add Extension']");
	
	public static String ProductConfigPage_Section  = "//span[text()='{sectionname}']";
	
	public static By ProductInstanceExtension_Table =  By.xpath("//span[text()='Add Extension']//following::table[1]");
	public static String ProductInstanceExtensionRowToDelete_Img  = "//span[text()='Add Extension']//following::table[1]//tbody//tr[{rownumb}]//td[@class='phx-td-middle text-center w-5']";
	public static String ProductInstanceExtensionRowCol1AddData_txtbox = "//span[text()='Add Extension']//following::table[1]//tbody//tr[{rownumb}]//td[1]//input[@type='text']";
	public static String ProductInstanceExtensionRowCol2AddData_txtbox = "//span[text()='Add Extension']//following::table[1]//tbody//tr[{rownumb}]//td[2]//input[@type='text']";
	public static By Save_btn = By.xpath("//button[text()=' Save ']");
	
	//DC association
	public static String DCClientToSelect_StaticTxt  = "//table[@class='ui-treetable-table']//tbody//following::td[@class='phx-col-ds text-left']//following::span[text()='{clientname}']";
	public static String PlusIconToExpandClientSelected_StaticTxt  = "//table[@class='ui-treetable-table']//tbody//following::td[@class='phx-col-ds text-left']//following::span[text()='{clientname}']/preceding::i[@class='pi pi-fw pi-chevron-right'][1]";
//	public static String checkL1DCcheckbox_checkbox = "//table[@class='ui-treetable-table']//tbody//following::td[@class='phx-col-ds text-left']//following::span[text()='{clientname}']//following::input[1]";
	public static String checkL1DCcheckbox_checkbox = "//span[text()='{DCname}']//preceding::input[@type='checkbox'][1]";
	public static String checkL2DCcheckbox_checkbox = "	//span[text()='{programname}']//preceding::input[@type='checkbox'][1]";
	public static String PlusIconToExpandDCL1_StaticTxt  = "//span[text()='{DCname}']//preceding::i[@class='pi pi-fw pi-chevron-right'][1]";

	

	
	public static String getSelectedProjectValueFromDropDown_L1_DC_drpdown = "//span[text()='{DCname}']//following::select[1]";
	public static String getSelectedBoardValueFromDropDown_L1_DC_drpdown = "//span[text()='{DCname}']//following::select[2]";
	
	public static String getSelectedProjectValueFromDropDown_L2_DC_drpdown = "//span[text()='{programname}']//following::select[1]";
	public static String getSelectedBoardValueFromDropDown_L2_DC_drpdown = "//span[text()='{programname}']//following::select[2]";
	
	public static By AddEntity_link = By.xpath("//span[text()='Add Entity']");
	
	//product instance entities table
	public static By ProdInstanceEntityTable_table = By.xpath("//span[text()='Add Entity']//following::table[1]");
	//
	public static String Column1_WorkItem_Deliverable_drpdown = "//span[text()='Add Entity']//following::table[1]//tbody//tr[{int}]//td[1]//select[1]";
	public static String Column2_WorkItemType_drpdown = "//span[text()='Add Entity']//following::table[1]//tbody//tr[{int}]//td[2]//select[1]";
	public static String Column3_InboundOutbound_drpdown = "//span[text()='Add Entity']//following::table[1]//tbody//tr[{int}]//td[3]//select[1]";
	
	public static By SuccessfulSaveProdInstance = By.xpath("//div[contains(@aria-label,'Product Instance saved')]");
	
	public static By myWizard_TFS_statictxt = By.xpath("//span[@title='myWizard-TFS']");
	public static By mywizard_MSPS_statictxt = By.xpath("//span[@title='mywizardMSPS']");
	public static By mywizardInstance_statictxt = By.xpath("//span[@title='myWizardInstance']");

	
	//SEI
	public static By SEI_table = By.xpath("//table[@class='table phx-manage-prod-table ui-treetable-table-mod']");
	public static By Attributes_table = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']");
	public static String Column1_pipelineName_statictxt = "//table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//tr[{int}]/td[1]";
	public static String Column3_pipelineName_statictxt = "//table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//tr[{int}]/td[3]";
	public static String Column2_isEnabled_statictxt = "//table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//tr[{int}]/td[2]";
	public static String Column5_editPipeline_statictxt = "//table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//tr[{int}]//td[5]//a[@title='Edit Process Pipeline']";
	public static String Column5_ManageIntegrationParamters_statictxt = "//table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//tr[{int}]//td[5]//a[@title='Manage Integration Parameters']";
	
	public static By isEnabled_Yes_statictxt = By.xpath("//label[text()='Is Enabled']//following::span[text()='Yes']");
	public static By ServiceName_drpdown = By.xpath("//label[text()='Service Name']//following::select[1]");
	public static By ExecutionFrequency_txtbox = By.xpath("//label[text()='Execution Frequency (minutes)']//following::input[1]");
	public static By ContinueBtnInPipelineWindow_btn = By.xpath("//button[@title='Continue to Save Pipeline']");
	public static By EditProcessPipeline_window = By.xpath("//h5[text()='Edit Process Pipeline Details']");
	public static By AddProcessPipeline_link = By.xpath("//span[text()='Add Process Pipeline']");
	public static By ProductVersionProcessPipeline_link = By.xpath("//label[text()='Product Version Process Pipeline']//following::select[1]");
	public static By CloseAttributesWidow_btn = By.xpath("//button[@title='Close']");
	
	public static String ProjectName_AttributeName_statictxt = "//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='ProjectName']/following-sibling::td[@title='{projectname}']";
	public static String ProjectKey_AttributeName_statictxt = "//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='ProjectKey']/following-sibling::td[@title='{projectname}']";
	public static By ProjectNameAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='ProjectName']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	public static By ProjectKeyAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='ProjectKey']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	
	
	public static String Column2_AttributeName_statictxt = "//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//tr[{int}]/td[2]";
	public static String Column5_AttributeValue_statictxt = "//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//tr[{int}]/td[5]";
	public static String Column7_ManageIntegrationParams_Img = "//table[@class='table phx-manage-prod-table ui-treetable-table-mod']/tbody/tr[{int}]/td[7]/following::a[@class='mx-1 ng-star-inserted' and @title='Manage ProductInstance Integration Parameters'][1]";
	public static By ParameterValue_txtbox = By.xpath("//label[text()='Parameter Value ']//following::textarea[1]");
	public static By ContinueToSaveParamter_btn = By.xpath("//button[@title='Continue to Save Parameter']");
	public static By IsRealtimeConfigChangesEnabled_btn = By.xpath("//label[text()='Is Realtime Config Changes Enabled ?']//following::span[text()='Yes'][1]");
	public static By PasswordAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='Password']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	public static By ProjectExtensionAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='ProjectExtension']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	public static By BoardExtensionAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='BoardExtension']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	public static By TokenAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='Token']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	public static By AxureBlobContainerNameAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='AxureBlobContainerName']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	public static By SharedAccessKeyNameAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='AxureBlobContainerName']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	public static By SASKeyAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='SASKey']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	public static By myWizardGMBinFolderPathAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='myWizardGMBinFolderPath']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	public static By TokenGrantTypeAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='TokenGrantType']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	public static By TokenClientIdAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='TokenClientId']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	public static By TokenClientSecretAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='TokenClientSecret']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	public static By AzureStorageContainerNameAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='AzureStorageContainerName']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	public static By IntermediateAPIUrlAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='IntermediateAPIUrl']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");
	 
	
	
	public static By AuthUrlAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='AuthUrl']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");

	public static By SASUriAttribute_link = By.xpath("//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='SASUri']//following::a[@title='Manage ProductInstance Integration Parameters'][1]");

	public static String DynamicAttribute_link = "//span[text()='Add Parameter']//following::table[@class='table phx-manage-prod-table ui-treetable-table-mod']//tbody//td[text()='{attributename}']//following::a[@title='Manage ProductInstance Integration Parameters'][1]";
	public static By DeployPipeline_btn = By.xpath("//span[text()='Deploy Pipelines']");
	public static By DeployPipelineTable_table = By.xpath("//button[@title='Deploy']//preceding::table[1]");
	public static String SelectRows_DeployPipeline_Table = "//button[@title='Deploy']//preceding::table[1]/tbody/tr[{int}]/td[2]/input[1]";
	public static By Deploy_btn = By.xpath("//button[@title='Deploy']");
	public static String DeploymentStatus_txt = "//table[@class='table phx-manage-prod-table ui-treetable-table-mod']/tbody/tr[{int}]/td[3]";
	
	
	//client native related UI path
	public static String ManageEntity_link = "//span[text()='Add Entity']//following::table[1]//tbody//td//select/option[text()='{workitem}']//following::a[@title='Manage Product Instance Entity Properties'][1]";
	public static String MultiValuedField_checkbox = "//span[text()='Entity Properties']//following::table[1]//tbody//td[text()='{multivaluedField}']//preceding::input[1]";
	public static String EntityPropertyValues_checkbox = "//span[text()='Entity Properties']//following::table[1]//tbody//td[text()='{property}']//following::a[@title='ManageProductInstanceEntityPropertyValues'][1]";
	
	public static By EntityPropertyValue_table = By.xpath("//span[text()='Add Entity Property Value']//following::table[1]");
	public static String CDMValue_Dropdwn = "//span[text()='Add Entity Property Value']//following::table[1]//tr[{int}]//td[1]/select";
	public static String EntityPropertyGUId_HoverKey = "//span[text()='Add Entity Property Value']//following::table[1]//tr[{int}]/td[6]/a";
	public static String EntityPropertyToggle_btn = "//span[text()='Add Entity Property Value']//following::table[1]//tr[{int}]/td[6]/button";
	public static By ContinueToSaveAttribute_PropertyValuePage_btn = By.xpath("//span[text()='Add Entity Property Value']//following::button[@title='ContinueToSaveAttribute'][1]");
	public static By ContinueToSaveAttribute_EntityPropertyPage_btn = By.xpath("//span[text()='Entity Properties']//following::button[@title='ContinueToSaveAttribute'][1]");

	//realtimeconfig
	public static By RealtimeConfig_input = By.xpath("//span[text()='Yes']//preceding-sibling::input[@name='isRealtimeConfigChangesEnabled']");
}



