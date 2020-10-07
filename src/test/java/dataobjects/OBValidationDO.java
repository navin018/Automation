package dataobjects;

import java.util.Map;



public class OBValidationDO {
	
	public static OBValidationDO INSTANCE;
	
	public String WorkItemExternalId_Impediment;
	public String WorkItemExternalId_Risk;
	public String WorkItemExternalId_Task;
	public String WorkItemExternalId_Issue;
	public String WorkItemExternalId_Story;
	public String WorkItemExternalId_Feature;
	public String WorkItemExternalId_Deliverable;
	public String WorkItemExternalId_Bug;
	public String WorkItemExternalId_SubTask;
	public String WorkItemExternalId_Epic;
	
	public String getWorkItemExternalId_Impediment() {
		return WorkItemExternalId_Impediment;
	}

	public void setWorkItemExternalId_Impediment(String workItemExternalId_Impediment) {
		WorkItemExternalId_Impediment = workItemExternalId_Impediment;
	}

	public String getWorkItemExternalId_Risk() {
		return WorkItemExternalId_Risk;
	}

	public void setWorkItemExternalId_Risk(String workItemExternalId_Risk) {
		WorkItemExternalId_Risk = workItemExternalId_Risk;
	}

	public String getWorkItemExternalId_Task() {
		return WorkItemExternalId_Task;
	}

	public void setWorkItemExternalId_Task(String workItemExternalId_Task) {
		WorkItemExternalId_Task = workItemExternalId_Task;
	}

	public String getWorkItemExternalId_Issue() {
		return WorkItemExternalId_Issue;
	}

	public void setWorkItemExternalId_Issue(String workItemExternalId_Issue) {
		WorkItemExternalId_Issue = workItemExternalId_Issue;
	}

	public String getWorkItemExternalId_Story() {
		return WorkItemExternalId_Story;
	}

	public void setWorkItemExternalId_Story(String workItemExternalId_Story) {
		WorkItemExternalId_Story = workItemExternalId_Story;
	}

	public String getWorkItemExternalId_Feature() {
		return WorkItemExternalId_Feature;
	}

	public void setWorkItemExternalId_Feature(String workItemExternalId_Feature) {
		WorkItemExternalId_Feature = workItemExternalId_Feature;
	}

	public String getWorkItemExternalId_Deliverable() {
		return WorkItemExternalId_Deliverable;
	}

	public void setWorkItemExternalId_Deliverable(String workItemExternalId_Deliverable) {
		WorkItemExternalId_Deliverable = workItemExternalId_Deliverable;
	}

	public String getWorkItemExternalId_Bug() {
		return WorkItemExternalId_Bug;
	}

	public void setWorkItemExternalId_Bug(String workItemExternalId_Bug) {
		WorkItemExternalId_Bug = workItemExternalId_Bug;
	}

	public String getWorkItemExternalId_SubTask() {
		return WorkItemExternalId_SubTask;
	}

	public void setWorkItemExternalId_SubTask(String workItemExternalId_SubTask) {
		WorkItemExternalId_SubTask = workItemExternalId_SubTask;
	}

	public String getWorkItemExternalId_Epic() {
		return WorkItemExternalId_Epic;
	}

	public void setWorkItemExternalId_Epic(String workItemExternalId_Epic) {
		WorkItemExternalId_Epic = workItemExternalId_Epic;
	}

	
	
	public Map<String, OBValidationDO> item;
	
	public static void setInstance(OBValidationDO instance){
		INSTANCE = instance;
	}
	
	public static OBValidationDO getINSTANCE() {
		return INSTANCE;
	}

	
	
	
}