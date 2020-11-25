package testobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Baseclass {
private static Baseclass base = new Baseclass();

Baseclass(){
	ClientNativeMatch = new HashMap<String,List<Object>>();
}

	
	public static Baseclass getInstance(){
		return base;
	}
	public String WorkItemExternalId_Task = "BOM-4578";
	public String WorkItemExternalId_Story;
	public String WorkItemExternalId_Risk;
	public String WorkItemExternalId_Epic;
	public String WorkItemExternalId_Bug;
	public String WorkItemExternalId_Feature;
	public String WorkItemExternalId_Impediment;
	public String WorkItemExternalId_Issue;
	public String WorkItemExternalId_Requirement;
	public String WorkItemExternalId_Deliverable;
	public String WorkItemExternalId_SubTask;
	public String WorkItemExternalId_TestCase;
	public String WorkItemExternalId_ProductBacklog;
	public String WorkItemExternalId_Test;
	public static List<SecurityHeaders> SH = new ArrayList<>();
	 
	
	public String TFS_ReleaseName;
	
	public String TFS_ReleaseStartDate;
	public String TFS_ReleaseEndDate;
	public String TFS_SprintName;
	public String TFS_SprintStartDate;
	public String TFS_SprintEndDate;
	
	public String Jira_ReleaseName;
	public String Jira_ReleaseStartDate;
	public String Jira_ReleaseEndDate;
	public String Jira_SprintName;
	public String Jira_SprintStartDate;
	public String Jira_SprintEndDate;
	public String Jira_ComponentName;

	
	public String RMP_ReleaseName;
	public String RMP_ReleaseStartDate;
	public String RMP_ReleaseEndDate;
	public String RMP_SprintName;
	public String RMP_SprintStartDate;
	public String RMP_SprintEndDate;
	
	public boolean SecurityTestsResults;
	
	
	
	
	
	
	public boolean isSecurityTestsResults() {
		return SecurityTestsResults;
	}


	public void setSecurityTestsResults(boolean securityTestsResults) {
		SecurityTestsResults = securityTestsResults;
	}
	public static HashMap<String,List<Object>> ClientNativeMatch;
	
	public int RandomNumbForMappingRule;
	
	public boolean DeployPipeline=false;
	
	public String getWorkItemExternalId_Requirement() {
		return WorkItemExternalId_Requirement;
	}


	public void setWorkItemExternalId_Requirement(String workItemExternalId_Requirement) {
		WorkItemExternalId_Requirement = workItemExternalId_Requirement;
	}
	
	public String getWorkItemExternalId_Test() {
		return WorkItemExternalId_Test;
	}


	public void setWorkItemExternalId_Test(String workItemExternalId_Test) {
		WorkItemExternalId_Test = workItemExternalId_Test;
	}
	
	public String getJira_ComponentName() {
		return Jira_ComponentName;
	}


	public void setJira_ComponentName(String jira_ComponentName) {
		Jira_ComponentName = jira_ComponentName;
	}
	
	public String getRMP_ReleaseName() {
		return RMP_ReleaseName;
	}
	public void setRMP_ReleaseName(String rMP_ReleaseName) {
		RMP_ReleaseName = rMP_ReleaseName;
	}
	public String getRMP_ReleaseStartDate() {
		return RMP_ReleaseStartDate;
	}
	public void setRMP_ReleaseStartDate(String rMP_ReleaseStartDate) {
		RMP_ReleaseStartDate = rMP_ReleaseStartDate;
	}
	public String getRMP_ReleaseEndDate() {
		return RMP_ReleaseEndDate;
	}
	public void setRMP_ReleaseEndDate(String rMP_ReleaseEndDate) {
		RMP_ReleaseEndDate = rMP_ReleaseEndDate;
	}
	public String getRMP_SprintName() {
		return RMP_SprintName;
	}
	public void setRMP_SprintName(String rMP_SprintName) {
		RMP_SprintName = rMP_SprintName;
	}
	public String getRMP_SprintStartDate() {
		return RMP_SprintStartDate;
	}
	public void setRMP_SprintStartDate(String rMP_SprintStartDate) {
		RMP_SprintStartDate = rMP_SprintStartDate;
	}
	public String getRMP_SprintEndDate() {
		return RMP_SprintEndDate;
	}
	public void setRMP_SprintEndDate(String rMP_SprintEndDate) {
		RMP_SprintEndDate = rMP_SprintEndDate;
	}

	
	
	
	public String getJira_ReleaseName() {
		return Jira_ReleaseName;
	}
	public void setJira_ReleaseName(String jira_ReleaseName) {
		Jira_ReleaseName = jira_ReleaseName;
	}
	public String getJira_ReleaseStartDate() {
		return Jira_ReleaseStartDate;
	}
	public void setJira_ReleaseStartDate(String jira_ReleaseStartDate) {
		Jira_ReleaseStartDate = jira_ReleaseStartDate;
	}
	public String getJira_ReleaseEndDate() {
		return Jira_ReleaseEndDate;
	}
	public void setJira_ReleaseEndDate(String jira_ReleaseEndDate) {
		Jira_ReleaseEndDate = jira_ReleaseEndDate;
	}
	public String getJira_SprintName() {
		return Jira_SprintName;
	}
	public void setJira_SprintName(String jira_SprintName) {
		Jira_SprintName = jira_SprintName;
	}
	public String getJira_SprintStartDate() {
		return Jira_SprintStartDate;
	}
	public void setJira_SprintStartDate(String jira_SprintStartDate) {
		Jira_SprintStartDate = jira_SprintStartDate;
	}
	public String getJira_SprintEndDate() {
		return Jira_SprintEndDate;
	}
	public void setJira_SprintEndDate(String jira_SprintEndDate) {
		Jira_SprintEndDate = jira_SprintEndDate;
	}

	
	public String DLM_TemplateName;
	
	public ArrayList<String> AccessLinkURL;
	public ArrayList<String> DocumentName;
}
